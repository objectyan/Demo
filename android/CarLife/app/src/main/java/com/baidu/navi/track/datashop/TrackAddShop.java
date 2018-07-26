package com.baidu.navi.track.datashop;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.database.DataCache;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.track.database.DataService.Action;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackDBEvent;
import com.baidu.navi.track.sync.TrackDataSync;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class TrackAddShop {
    private static final String DefaultTrackName = "未知路";
    private static final int SEARCH_POI_TIMEOUT = 120000;
    private static final String TAG = "TrackAddShop";
    private int geoSearchCount = 0;
    private boolean isSync = false;
    private Object lockObject = new Object();
    protected HashMap<Handler, String> mEndGeoTrackId = new HashMap();
    private Handler mHandler = new MyHandler();
    protected HashMap<Handler, String> mStartGeoTrackId = new HashMap();
    private Object originalObject;

    private class MyHandler extends Handler {
        private MyHandler() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 2) {
                C1260i.b(TrackAddShop.TAG, "handleMessage msg = " + msg);
                TrackDBEvent dbEvent = null;
                if (msg.obj instanceof TrackDBEvent) {
                    dbEvent = msg.obj;
                }
                if (dbEvent != null) {
                    C1260i.b(TrackAddShop.TAG, "dbEvent.type = " + dbEvent.type);
                    if (dbEvent.type == 1) {
                        C1260i.b(TrackAddShop.TAG, "dbEvent.status = " + dbEvent.status);
                        int totalDistanse = TrackConfig.getInstance().getTotalDistanse();
                        int weekEndTime = TrackConfig.getInstance().getWeekEndTime();
                        int maxTime = TrackConfig.getInstance().getMaxTime();
                        if (TrackAddShop.this.originalObject != null && (TrackAddShop.this.originalObject instanceof CarNaviModel) && totalDistanse > 0 && weekEndTime > 0 && maxTime > 0) {
                            int weekDistanse = TrackConfig.getInstance().getWeekDistanse();
                            int weedStartTime = weekEndTime - 604800;
                            int distanse = ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getDistance();
                            int duration = ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getDuration();
                            int ctime = ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getCtime();
                            TrackConfig.getInstance().setTotalDistanse(distanse + totalDistanse);
                            if (maxTime < duration) {
                                TrackConfig.getInstance().setMaxTime(duration);
                            }
                            if (ctime >= weedStartTime && ctime < weekEndTime) {
                                TrackConfig.getInstance().setWeekDistanse(distanse + weekDistanse);
                            } else if (ctime > weekEndTime) {
                                Calendar cal = Calendar.getInstance();
                                cal.set(7, 2);
                                cal.set(11, 0);
                                cal.set(12, 0);
                                cal.set(13, 0);
                                long time = (cal.getTimeInMillis() / 1000) + 604800;
                                if (cal.getTimeInMillis() > System.currentTimeMillis()) {
                                    time -= 604800;
                                }
                                TrackConfig.getInstance().setWeekDistanse(distanse);
                                TrackConfig.getInstance().setWeekEndTime((int) time);
                            }
                        }
                        synchronized (TrackAddShop.this.lockObject) {
                            if (TrackAddShop.this.isSync && TrackAddShop.this.geoSearchCount == 0 && TrackAddShop.this.originalObject != null) {
                                C1260i.b(TrackAddShop.TAG, "originalObject : " + TrackAddShop.this.originalObject.toString());
                                TrackDataSync.getInstance().autoSync(TrackAddShop.this.originalObject);
                            }
                            if (TrackAddShop.this.geoSearchCount == 0) {
                                TrackAddShop.this.releaseShop();
                            }
                        }
                    }
                }
            }
        }
    }

    class SearchHandler extends Handler {
        public SearchHandler(Looper mainLooper) {
            super(mainLooper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        SearchPoi searchPoi = msg.obj.mData;
                        if (searchPoi != null) {
                            String trackId;
                            if (TrackAddShop.this.mStartGeoTrackId.containsKey(this)) {
                                trackId = (String) TrackAddShop.this.mStartGeoTrackId.get(this);
                                if (TextUtils.isEmpty(searchPoi.mName)) {
                                    searchPoi.mName = TrackAddShop.DefaultTrackName;
                                }
                                if (TrackAddShop.this.originalObject != null && (TrackAddShop.this.originalObject instanceof CarNaviModel) && ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getGuid().equals(trackId)) {
                                    ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getStartPoint().setAddr(searchPoi.mName);
                                }
                                C1260i.b(TrackAddShop.TAG, "trackStartName:" + searchPoi.mName);
                            } else if (TrackAddShop.this.mEndGeoTrackId.containsKey(this)) {
                                trackId = (String) TrackAddShop.this.mEndGeoTrackId.get(this);
                                if (TextUtils.isEmpty(searchPoi.mName)) {
                                    searchPoi.mName = TrackAddShop.DefaultTrackName;
                                }
                                if (TrackAddShop.this.originalObject != null && (TrackAddShop.this.originalObject instanceof CarNaviModel) && ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getGuid().equals(trackId)) {
                                    ((CarNaviModel) TrackAddShop.this.originalObject).getPBData().getEndPoint().setAddr(searchPoi.mName);
                                }
                                C1260i.b(TrackAddShop.TAG, "trackEndName:" + searchPoi.mName);
                            }
                        }
                        if (TrackAddShop.this.mStartGeoTrackId.remove(this) == null) {
                            TrackAddShop.this.mEndGeoTrackId.remove(this);
                        }
                    }
                    synchronized (TrackAddShop.this.lockObject) {
                        TrackAddShop.this.geoSearchCount = TrackAddShop.this.geoSearchCount - 1;
                        if (TrackAddShop.this.geoSearchCount == 0 && TrackAddShop.this.originalObject != null) {
                            TrackAddShop.this.updateRecord(TrackAddShop.this.originalObject);
                            TrackDataSync.getInstance().autoSync(TrackAddShop.this.originalObject);
                            TrackAddShop.this.releaseShop();
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void addRecord(Object trackItem, boolean isSync) {
        if (trackItem != null) {
            this.originalObject = trackItem;
            this.isSync = isSync;
            addRecord(trackItem);
            checkRecordStartName();
            checkRecordEndName();
        }
    }

    private void addRecord(Object trackItem) {
        if (trackItem != null) {
            try {
                List<Object> list = new ArrayList();
                list.add(trackItem);
                Context context = C1157a.a();
                Intent intent = new Intent(context, DataService.class);
                intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
                intent.setAction(Action.ACTION_WRITE_TRACK_TO_DB.toString());
                intent.putExtra(DataService.EXTRA_CACHE_KEY, DataCache.getInstance().addCache(list));
                context.startService(intent);
            } catch (Exception e) {
            }
        }
    }

    private void updateRecord(Object trackItem) {
        if (trackItem != null) {
            List<Object> list = new ArrayList();
            list.add(trackItem);
            Context context = C1157a.a();
            Intent intent = new Intent(context, DataService.class);
            intent.putExtra(DataService.EXTRA_HANDLER, DataCache.getInstance().addCache(this.mHandler));
            intent.setAction(Action.ACTION_UPDATE_TRACK_INFO_BY_LIST.toString());
            intent.putExtra(DataService.EXTRA_CACHE_KEY, DataCache.getInstance().addCache(list));
            context.startService(intent);
        }
    }

    private void releaseShop() {
        this.originalObject = null;
        this.mStartGeoTrackId.clear();
        this.mEndGeoTrackId.clear();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    private void checkRecordStartName() {
        if (this.originalObject != null && (this.originalObject instanceof CarNaviModel)) {
            NaviPoint startNaviPoint = ((CarNaviModel) this.originalObject).getPBData().getStartPoint();
            GeoPoint startPoint = CoordinateTransformUtil.transferBD09ToGCJ02(startNaviPoint.getLng(), startNaviPoint.getLat());
            String curStartName = startNaviPoint.getAddr();
            String trackId = ((CarNaviModel) this.originalObject).getPBData().getGuid();
            if (startPoint != null && !TextUtils.isEmpty(trackId)) {
                if (curStartName == null || curStartName.length() == 0 || curStartName.equals(RoutePlanParams.MY_LOCATION) || curStartName.equals("地图上的点")) {
                    SearchHandler searchHandler = new SearchHandler(Looper.getMainLooper());
                    this.mStartGeoTrackId.put(searchHandler, trackId);
                    startAntiGeo(startPoint, searchHandler);
                }
            }
        }
    }

    private void checkRecordEndName() {
        if (this.originalObject != null && (this.originalObject instanceof CarNaviModel)) {
            NaviPoint endNaviPoint = ((CarNaviModel) this.originalObject).getPBData().getEndPoint();
            GeoPoint geoPoint = CoordinateTransformUtil.transferBD09ToGCJ02(endNaviPoint.getLng(), endNaviPoint.getLat());
            String trackId = ((CarNaviModel) this.originalObject).getPBData().getGuid();
            if (geoPoint != null && !TextUtils.isEmpty(trackId)) {
                SearchHandler searchHandler = new SearchHandler(Looper.getMainLooper());
                this.mEndGeoTrackId.put(searchHandler, trackId);
                startAntiGeo(geoPoint, searchHandler);
            }
        }
    }

    private void startAntiGeo(GeoPoint geoPoint, SearchHandler handler) {
        if (NetworkUtils.isNetworkAvailable(C1157a.a()) || hasCurLocationCityOfflineData(geoPoint)) {
            this.geoSearchCount++;
            BNPoiSearcher.getInstance().asynGetPoiByPoint(geoPoint, SEARCH_POI_TIMEOUT, handler);
        }
    }

    public boolean hasCurLocationCityOfflineData(GeoPoint geoPoint) {
        if (!BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
        while (districtInfo != null && districtInfo.mType > 2) {
            districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
        }
        if (districtInfo != null) {
            return BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
        }
        return false;
    }
}
