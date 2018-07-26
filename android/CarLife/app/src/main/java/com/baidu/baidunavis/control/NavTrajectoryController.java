package com.baidu.baidunavis.control;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.model.TrajectoryGPSData;
import com.baidu.baidunavis.model.TrajectorySummaryInfo;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;

public class NavTrajectoryController {
    private static final int CAR_DISTANCE_MIN_LIMIT = 200;
    public static final int CRUISE = 2;
    public static final int CRUISE_FOLLOW = 3;
    private static final String DefaultTrackName = "未知路";
    public static final int END_RECORD_FAIL = 1;
    public static final int END_RECORD_INVALID = -1;
    public static final int END_RECORD_SUC = 0;
    public static final int ROUTE_GUIDE = 1;
    private static final int SEARCH_POI_TIMEOUT = 120000;
    private static final String TAG = NavTrajectoryController.class.getSimpleName();
    public static boolean hasConnected = false;
    private static NavTrajectoryController mInstance = null;
    private boolean isEndNaviByOpenAPI = false;
    private LocationChangeListener mCarNaviLocChangeListener = null;
    protected HashMap<Handler, String> mEndGeoTrackId = new HashMap();
    private GeoPoint mFinalGeoPoint = null;
    private GeoPoint mFirstGeoPoint = null;
    private boolean mIsNeedRecordTrack = true;
    private boolean mIsStartRecord = false;
    public int mLastestRequestID = 0;
    private ILocationChangeListener mLocChangeListener = null;
    private boolean mNotInputStartEndGeo = false;
    protected HashMap<Handler, String> mStartGeoTrackId = new HashMap();
    private boolean shouldShowNaviResult = false;
    private String trackKeyUrl = null;

    /* renamed from: com.baidu.baidunavis.control.NavTrajectoryController$2 */
    class C08472 extends ILocationChangeListener {
        C08472() {
        }

        public void onLocationChange(LocData locData) {
            NavTrajectoryController.this.recording(locData.longitude, locData.latitude, locData.speed, locData.direction, locData.accuracy, locData.time);
            if (!NavTrajectoryController.this.mNotInputStartEndGeo) {
                NavTrajectoryController.this.mFinalGeoPoint = locData.toGeoPoint();
            } else if (NavTrajectoryController.this.mFirstGeoPoint == null) {
                NavTrajectoryController.this.mFirstGeoPoint = locData.toGeoPoint();
                NavTrajectoryController.this.checkRecordStartName(NavTrajectoryController.this.mFirstGeoPoint, null, NavTrajectoryController.this.getCurrentUUID());
            } else {
                NavTrajectoryController.this.mFinalGeoPoint = locData.toGeoPoint();
            }
        }

        public void onWGS84LocationChange(LocData locData, LocData gcj02LocData) {
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
                            final String tmpName;
                            if (NavTrajectoryController.this.mStartGeoTrackId.containsKey(this)) {
                                trackId = (String) NavTrajectoryController.this.mStartGeoTrackId.get(this);
                                if (TextUtils.isEmpty(searchPoi.mName)) {
                                    searchPoi.mName = NavTrajectoryController.DefaultTrackName;
                                }
                                JNITrajectoryControl.sInstance.updateStartName(trackId, searchPoi.mName);
                                tmpName = searchPoi.mName;
                                if (NavLogUtils.LOGGABLE && NavCommonFuncModel.getInstance().getActivity() != null) {
                                    NavCommonFuncModel.getInstance().getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), "trackStartName:" + tmpName);
                                        }
                                    });
                                }
                            } else if (NavTrajectoryController.this.mEndGeoTrackId.containsKey(this)) {
                                trackId = (String) NavTrajectoryController.this.mEndGeoTrackId.get(this);
                                if (TextUtils.isEmpty(searchPoi.mName)) {
                                    searchPoi.mName = NavTrajectoryController.DefaultTrackName;
                                }
                                try {
                                    JNITrajectoryControl.sInstance.updateEndName(trackId, searchPoi.mName);
                                } catch (Throwable th) {
                                }
                                tmpName = searchPoi.mName;
                                if (NavLogUtils.LOGGABLE && NavCommonFuncModel.getInstance().getActivity() != null) {
                                    NavCommonFuncModel.getInstance().getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), "trackEndName:" + tmpName);
                                        }
                                    });
                                }
                            }
                        }
                    }
                    if (NavTrajectoryController.this.mStartGeoTrackId.remove(this) == null) {
                        NavTrajectoryController.this.mEndGeoTrackId.remove(this);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private NavTrajectoryController() {
    }

    public static NavTrajectoryController getInstance() {
        if (mInstance == null) {
            mInstance = new NavTrajectoryController();
        }
        return mInstance;
    }

    public boolean isNeedRecordTrack() {
        return this.mIsNeedRecordTrack;
    }

    public void setNeedRecordTrack(boolean record) {
        this.mIsNeedRecordTrack = record;
    }

    public String getCurrentUUID() {
        if (isNeedRecordTrack()) {
            return JNITrajectoryControl.sInstance.getCurrentUUID();
        }
        return null;
    }

    public TrajectorySummaryInfo getCurrentTrajectorySummaryInfo() {
        if (!isNeedRecordTrack()) {
            return null;
        }
        String curUUID = getCurrentUUID();
        if (curUUID == null || curUUID.length() == 0) {
            return null;
        }
        return getTrajectoryById(getCurrentUUID());
    }

    public ArrayList<TrajectoryGPSData> getCurrentUUIDTrajectoryGPSData() {
        if (!isNeedRecordTrack()) {
            return null;
        }
        String curUUID = getCurrentUUID();
        if (curUUID == null || curUUID.length() == 0) {
            return null;
        }
        return getTrajectoryGPSList(curUUID);
    }

    public int startRecord(String userId, String startPointName, int fromType, boolean selfRegisterLocation, boolean notInputStartEndGeo) {
        if (!isNeedRecordTrack() || NavMapAdapter.sMonkey) {
            return 0;
        }
        Bundle data = new Bundle();
        if (userId != null) {
            data.putString("userId", userId);
        }
        if (startPointName != null) {
            data.putString("startPointName", startPointName);
        }
        data.putInt("fromType", fromType);
        data.putBoolean("selfRegisterLocation", selfRegisterLocation);
        data.putBoolean("notInputStartEndGeo", notInputStartEndGeo);
        final String str = userId;
        final String str2 = startPointName;
        final int i = fromType;
        final boolean z = selfRegisterLocation;
        final boolean z2 = notInputStartEndGeo;
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-StartRecordTraj", null) {
            protected String execute() {
                try {
                    NavTrajectoryController.getInstance().startRecordInner(str == null ? "" : str, str2 == null ? "" : str2, i, z, z2);
                } catch (Throwable th) {
                }
                return null;
            }
        }, new BNWorkerConfig(100, 0));
        return 1;
    }

    int startRecordInner(String userId, String startPointName, int fromType, boolean selfRegisterLocation, boolean notInputStartEndGeo) {
        if (!isNeedRecordTrack() || NavMapAdapter.sMonkey) {
            return 0;
        }
        this.mIsStartRecord = true;
        NavLogUtils.m3003e("NavTrajectoryController", "startRecord---- " + startPointName + "," + fromType);
        this.mNotInputStartEndGeo = notInputStartEndGeo;
        int ret = JNITrajectoryControl.sInstance.startRecord(userId, startPointName, fromType, NavMapAdapter.getInstance().isCloudSwitchOn(NavMapAdapter.getInstance().getNavEnergyPromoteEvent()));
        if (selfRegisterLocation) {
            if (this.mLocChangeListener == null) {
                this.mLocChangeListener = new C08472();
            }
            reInitLocationService();
        }
        NavLogUtils.m3003e(TAG, "startRecord: ret --> " + ret);
        return ret;
    }

    public void reInitLocationService() {
        if (this.mLocChangeListener != null) {
            if (C1609a.m5871a().m5880b() && BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
                BNSysLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
                BNExtGPSLocationManager.getInstance().addLocationListener(this.mLocChangeListener);
                return;
            }
            BNExtGPSLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
            BNSysLocationManager.getInstance().addLocationListener(this.mLocChangeListener);
        }
    }

    public void startRecordForNaviResult(int naviMode) {
        NavLogUtils.m3003e(TAG, "startRecordForNaviResult: --> naviMode: " + naviMode);
        BNNaviResultController.getInstance().reset();
        BNNaviResultController.getInstance().registerVMsgHandler();
    }

    public int endRecord(String endPointName, boolean trackRecordOK, int recordType) {
        if (recordType == 1) {
            StatisticManager.onEvent(StatisticConstants.NAVI_0015, StatisticConstants.NAVI_0015);
        }
        this.shouldShowNaviResult = false;
        if (!isNeedRecordTrack() || NavMapAdapter.sMonkey || !this.mIsStartRecord) {
            return 0;
        }
        this.mIsStartRecord = false;
        NavLogUtils.m3003e("NavTrajectoryController", "endRecord----" + endPointName + " trackRecordOK:" + trackRecordOK);
        if (this.mLocChangeListener != null) {
            BNSysLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
            BNExtGPSLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
            this.mLocChangeListener = null;
        }
        RouteNode endNode = NavRoutePlanModel.getInstance().getEndRouteNode();
        String uid = "";
        if (BNRoutePlaner.getInstance().getEntry() == 20) {
            uid = "1";
        } else if (BNRoutePlaner.getInstance().getEntry() == 21) {
            uid = "2";
        } else if (!(endNode == null || endNode.mUID == null || endNode.mUID.length() <= 0)) {
            uid = endNode.mUID;
        }
        int ret = -100;
        Bundle outBundle = new Bundle();
        try {
            ret = JNITrajectoryControl.sInstance.endRecord(endPointName, uid, RGCacheStatus.sMockGpsGuide, outBundle);
        } catch (Throwable th) {
            NavLogUtils.m3003e(TAG, "endRecord: Exception --> ");
        }
        if (outBundle == null || !outBundle.containsKey("trajectory_requestid")) {
            this.mLastestRequestID = 0;
        } else {
            this.mLastestRequestID = outBundle.getInt("trajectory_requestid");
        }
        try {
            JNITrajectoryControl.sInstance.updateEndName(getCurrentUUID(), endPointName);
        } catch (Throwable th2) {
        }
        TrackCarDataSolveModel.mFirstGeoPoint = this.mFirstGeoPoint;
        TrackCarDataSolveModel.mFinalGeoPoint = this.mFinalGeoPoint;
        this.mFirstGeoPoint = null;
        this.mFinalGeoPoint = null;
        if (trackRecordOK && !NavCommonFuncModel.sIsAnologNavi) {
            NavLogUtils.m3003e(TAG, "endRecord: NaviResultModel --> " + BNNaviResultModel.getInstance().toString());
            checkShouldDisplayNaviResultPage(ret);
            NavLogUtils.m3003e(TAG, "endRecord: --> ret: " + ret + ", shouldShowNaviResult: " + this.shouldShowNaviResult);
        }
        this.shouldShowNaviResult = false;
        onEndRecord(ret, recordType);
        return ret;
    }

    private void onEndRecord(int endRecordState, int recordType) {
        if (endRecordState == 0) {
            try {
                int iDistance = (int) getCurrentTrajectorySummaryInfo().mDistance;
                if (iDistance > 0) {
                    if (recordType == 1) {
                        StatisticManager.onEvent(StatisticConstants.NAVI_0016, StatisticConstants.NAVI_0016);
                        StatisticManager.onEventMileage(C1157a.m3876a(), StatisticConstants.NAVI_0013, StatisticConstants.HOME_MAP_NAVI_STATUS_DISTANSE, iDistance);
                        if (!hasConnected) {
                            StatisticManager.onEventMileage(C1157a.m3876a(), StatisticConstants.NAVI_0030, StatisticConstants.HOME_MAP_NAVI_STATUS_DISTANSE, iDistance);
                        }
                        if (iDistance >= 1800000) {
                            StatisticManager.onEvent(StatisticConstants.NAVI_0014, StatisticConstants.NAVI_0014);
                        }
                    } else if (recordType == 3) {
                        StatisticManager.onEventMileage(C1157a.m3876a(), StatisticConstants.NAVI_0009, StatisticConstants.HOME_MAP_CRUISE_FOLLOW_STATUS_DISTANSE, iDistance);
                        if (iDistance >= 1800000) {
                            StatisticManager.onEvent(StatisticConstants.NAVI_0010, StatisticConstants.NAVI_0010);
                        }
                    }
                    if (iDistance > 200) {
                        NavMapAdapter.getInstance().createCarNaviData();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void checkShouldDisplayNaviResultPage(int endRecordState) {
        if (endRecordState != 0) {
            this.shouldShowNaviResult = false;
        } else if (BNNaviResultModel.getInstance().isDestArrived()) {
            this.shouldShowNaviResult = true;
            BNNaviResultModel.getInstance().setNaviCompletePercentage(1.0f);
        } else {
            double percentage;
            long curMilea = JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID());
            int planedDist = BNNaviResultModel.getInstance().getEstimatedRemainDist();
            if (planedDist == 0) {
                percentage = 0.0d;
            } else {
                percentage = ((double) curMilea) / ((double) planedDist);
            }
            NavLogUtils.m3003e(TAG, "checkShouldDisplayNaviResultPage: --> curMilea: " + curMilea + ", planedDist: " + planedDist + ", percentage: " + percentage);
            BNNaviResultModel.getInstance().setNaviCompletePercentage((float) percentage);
            if (curMilea <= BNOffScreenParams.MIN_ENTER_INTERVAL) {
            }
        }
    }

    public int recording(double longitude, double latitude, float speed, float bearing, float accuracy, long time) {
        if (isNeedRecordTrack()) {
            return JNITrajectoryControl.sInstance.recording(longitude, latitude, speed, bearing, accuracy, time);
        }
        return 0;
    }

    public int rename(String uuid, String newname) {
        if (isNeedRecordTrack()) {
            return JNITrajectoryControl.sInstance.rename(uuid, newname);
        }
        return 0;
    }

    public int delete(String uuid) {
        return 0;
    }

    public int patchDelete(ArrayList<String> arrayList) {
        return 0;
    }

    public TrajectorySummaryInfo getTrajectoryById(String uuid) {
        if (!BaiduNaviManager.isNaviSoLoadSuccess() || !BaiduNaviManager.sIsBaseEngineInitialized || !isNeedRecordTrack()) {
            return null;
        }
        NaviTrajectory nt = new NaviTrajectory();
        JNITrajectoryControl.sInstance.getTrajectoryById(uuid, nt);
        setTrackKeyUrl(nt);
        return convertTo(nt);
    }

    public ArrayList<TrajectorySummaryInfo> getAllDisplayTrajectory(String bduss, String userId) {
        if (!isNeedRecordTrack()) {
            return null;
        }
        ArrayList<NaviTrajectory> outList = new ArrayList();
        JNITrajectoryControl.sInstance.getTrajectoryList(bduss, userId, outList);
        ArrayList<TrajectorySummaryInfo> ret = new ArrayList();
        int i = 0;
        while (outList != null && i < outList.size()) {
            ret.add(convertTo((NaviTrajectory) outList.get(i)));
            i++;
        }
        return ret;
    }

    public ArrayList<TrajectoryGPSData> getTrajectoryGPSList(String uuid) {
        if (!isNeedRecordTrack()) {
            return null;
        }
        ArrayList<NaviTrajectoryGPSData> outList = new ArrayList();
        JNITrajectoryControl.sInstance.GetTrajectoryGPSListDirect(uuid, outList);
        ArrayList<TrajectoryGPSData> ret = new ArrayList();
        int i = 0;
        while (outList != null) {
            try {
                if (i >= outList.size()) {
                    return ret;
                }
                ret.add(convertTo((NaviTrajectoryGPSData) outList.get(i)));
                i++;
            } catch (Throwable th) {
                return null;
            }
        }
        return ret;
    }

    public int logoutCleanUp() {
        if (isNeedRecordTrack()) {
            return JNITrajectoryControl.sInstance.logoutCleanUp();
        }
        return 0;
    }

    public int updateStartName(String uuid, String startName) {
        if (isNeedRecordTrack()) {
            return JNITrajectoryControl.sInstance.updateStartName(uuid, startName);
        }
        return 0;
    }

    public int updateEndName(String uuid, String endName) {
        int i = 0;
        if (isNeedRecordTrack()) {
            try {
                i = JNITrajectoryControl.sInstance.updateEndName(uuid, endName);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    private void setTrackKeyUrl(NaviTrajectory nt) {
        LogUtil.m3004e("onShowMenu", " NaviTrajectory44 trackKeyUrl " + this.trackKeyUrl);
        if (nt != null) {
            LogUtil.m3004e("onShowMenu", " NaviTrajectory55 nt.clPoiID " + nt.clPoiID);
            if (nt.clPoiID != null) {
                this.trackKeyUrl = nt.clUrl;
            }
            LogUtil.m3004e("onShowMenu", " NaviTrajectory33 trackKeyUrl " + this.trackKeyUrl);
        }
    }

    public String getTrackKeyUrl() {
        return this.trackKeyUrl;
    }

    private TrajectorySummaryInfo convertTo(NaviTrajectory nt) {
        if (nt == null) {
            return null;
        }
        TrajectorySummaryInfo ret = new TrajectorySummaryInfo();
        ret.mUUID = nt.mUUID;
        ret.mName = nt.mName;
        ret.mHasSync = nt.mHasSync;
        ret.mDistance = nt.mDistance;
        ret.mDate = nt.mDate;
        ret.mDuration = nt.mDuration;
        ret.mAverageSpeed = nt.mAverageSpeed;
        ret.mMaxSpeed = nt.mMaxSpeed;
        ret.mFromType = nt.mFromType;
        ret.mHasGpsMock = RGCacheStatus.sMockGpsGuide;
        ret.unMileageDist = nt.unMileageDist;
        ret.ulCreateTime = nt.ulCreateTime;
        ret.bIsChangedKey = nt.bIsChangedKey;
        ret.nKeyVersion = nt.nKeyVersion;
        ret.clTrackID = nt.clTrackID;
        ret.clCUID = nt.clCUID;
        ret.clSessionID = nt.clSessionID;
        ret.clBduss = nt.clBduss;
        ret.clPoiID = nt.clPoiID;
        ret.clDataSign = nt.clDataSign;
        ret.clSessionSign = nt.clSessionSign;
        ret.clUrl = nt.clUrl;
        ret.mLastestRequestID = getInstance().mLastestRequestID;
        RouteNode endNode = NavRoutePlanModel.getInstance().getEndRouteNode();
        if (endNode != null) {
            ret.mBusinessPoi = endNode.mBusinessPoi;
        }
        RoutePlanNode node = NavCommonFuncModel.getInstance().mEndNode;
        if (node != null) {
            if (!node.isNodeSettedData()) {
                node = BNSettingManager.getEndNode();
            }
            ret.clEndLatitude = String.valueOf(node.getLatitudeE6());
            ret.clEndLongtitude = String.valueOf(node.getLongitudeE6());
            ret.clEndName = node.mName;
            NavLogUtils.m3003e("tag", "walk lat ,long " + ret.clEndLatitude + "," + ret.clEndLongtitude);
        }
        LogUtil.m3004e("onShowMenu", " NaviTrajectory11 ntd.unMileageDist " + nt.unMileageDist + " ntd.ulCreateTime " + nt.ulCreateTime + " ntd.bIsChangedKey " + nt.bIsChangedKey + " ntd.nKeyVersion " + nt.nKeyVersion + " ntd.clTrackID " + nt.clTrackID + " ntd.clCUID " + nt.clCUID + " ntd.clSessionID " + nt.clSessionID + " ntd.clBduss " + nt.clBduss + " ntd.clPoiID " + nt.clPoiID + " ntd.clDataSign " + nt.clDataSign + " ntd.clSessionSign " + nt.clSessionSign + " ntd.clUrl " + nt.clUrl + " ret.mBusinessPoi " + ret.mBusinessPoi);
        return ret;
    }

    private TrajectoryGPSData convertTo(NaviTrajectoryGPSData ntd) {
        if (ntd == null) {
            return null;
        }
        TrajectoryGPSData ret = new TrajectoryGPSData();
        ret.mLongitude = ntd.mLongitude;
        ret.mLatitude = ntd.mLatitude;
        ret.mSpeed = ntd.mSpeed;
        ret.mBearing = ntd.mBearing;
        ret.mAccuracy = ntd.mAccuracy;
        ret.mGpsTime = ntd.mGpsTime;
        ret.unLimitSpeed = ntd.unLimitSpeed;
        ret.fMaxSpeed = ntd.fMaxSpeed;
        ret.bMaxSpeed = ntd.bMaxSpeed;
        ret.bOverSpeed = ntd.bOverSpeed;
        ret.bRapidAcc = ntd.bRapidAcc;
        ret.bBrake = ntd.bBrake;
        ret.bCurve = ntd.bCurve;
        ret.bYaw = ntd.bYaw;
        LogUtil.m3004e("onShowMenu", " NaviTrajectory22 ntd.mGpsTime " + ntd.mGpsTime + " ntd.unLimitSpeed " + ntd.unLimitSpeed + " ntd.fMaxSpeed " + ntd.fMaxSpeed + " ntd.bMaxSpeed " + ntd.bMaxSpeed + " ntd.bOverSpeed " + ntd.bOverSpeed + " ntd.bRapidAcc " + ntd.bRapidAcc + " ntd.bBrake " + ntd.bBrake + " ntd.bCurve " + ntd.bCurve + " ntd.mLongitude " + ntd.mLongitude + " ntd.mLatitude " + ntd.mLatitude + " ntd.mSpeed " + ntd.mSpeed + " ntd.mBearing " + ntd.mBearing + " ntd.mAccuracy " + ntd.mAccuracy);
        return ret;
    }

    public void checkRecordStartName(GeoPoint startPoint, String curStartName, String trackId) {
        if (startPoint != null && trackId != null && trackId.length() != 0) {
            if (curStartName == null || curStartName.length() == 0 || curStartName.equals(RoutePlanParams.MY_LOCATION) || curStartName.equals("地图上的点")) {
                SearchHandler searchHandler = new SearchHandler(Looper.getMainLooper());
                this.mStartGeoTrackId.put(searchHandler, trackId);
                startAntiGeo(startPoint, searchHandler);
            }
        }
    }

    public void checkRecordEndName(GeoPoint geoPoint, String trackId) {
        if (geoPoint != null && trackId != null && trackId.length() != 0) {
            SearchHandler searchHandler = new SearchHandler(Looper.getMainLooper());
            this.mEndGeoTrackId.put(searchHandler, trackId);
            startAntiGeo(geoPoint, searchHandler);
        }
    }

    private void startAntiGeo(GeoPoint geoPoint, SearchHandler handler) {
        BNPoiSearcher.getInstance().asynGetPoiByPoint(geoPoint, SEARCH_POI_TIMEOUT, handler);
    }

    public Bitmap getCarNaviBusinessImage() {
        NavLogUtils.m3003e(ModuleName.TRAJECTORY, "getCarNaviBusinessImage() ");
        if (BusinessActivityManager.getInstance().getModel() != null) {
            return BusinessActivityManager.getInstance().getModel().naviendPicBitmap;
        }
        return null;
    }

    public void setEndNaviByOpenApi(boolean endNavByOpenApi) {
        this.isEndNaviByOpenAPI = endNavByOpenApi;
    }
}
