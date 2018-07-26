package com.baidu.navisdk.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class GeoLocateModel {
    private static final int DIS_INTERVAL_TO_REFRESH_DISTRICT = 10000;
    private static final long TIME_INTERVAL_TO_ANTI_DISTRICT_IN_FIRST = 300000;
    private boolean hasUpdateDistrictInfo = false;
    private Handler mAntiGeoHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    synchronized (GeoLocateModel.this.mIsAntiGeoing) {
                        GeoLocateModel.this.mIsAntiGeoing = Boolean.valueOf(false);
                    }
                    if (msg.arg1 == 0) {
                        RspData rsp = msg.obj;
                        ReqData req = rsp.mReq;
                        Bundle bundle = rsp.mData;
                        int cityId = bundle.getInt(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                        int provinceId = bundle.getInt("provice");
                        DistrictInfo cityDistrict = BNPoiSearcher.getInstance().getDistrictById(cityId);
                        DistrictInfo provinceDistrict = BNPoiSearcher.getInstance().getDistrictById(provinceId);
                        if (cityDistrict != null) {
                            GeoLocateModel.this.hasUpdateDistrictInfo = true;
                            GeoLocateModel.this.mCurrentDistrict = cityDistrict;
                            GeoLocateModel.this.mCurrentDistrict.mName = GeoLocateModel.this.specialDealWith(GeoLocateModel.this.mCurrentDistrict.mName);
                            BNSettingManager.setDistrictId(GeoLocateModel.this.mCurrentDistrict.mId);
                            BNSettingManager.setDistrictName(GeoLocateModel.this.mCurrentDistrict.mName);
                            GeoLocateModel.this.mCurrentParentDistrict = provinceDistrict;
                            GeoLocateModel.this.notifyDistrictInfoListener(cityDistrict, provinceDistrict);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private DistrictInfo mCurLocationProvinceDistrict = null;
    private DistrictInfo mCurrentDistrict = null;
    private DistrictInfo mCurrentParentDistrict = null;
    public SearchPoi mCurrentPoi = null;
    private List<IDistrictInfoListener> mDistrictInfoListeners = new ArrayList();
    private DistrictInfo mDistrictSetByManMade;
    private Boolean mIsAntiGeoing = Boolean.FALSE;
    private long mLastAntiDistrictTime = -1;
    public LocData mLastLocation = null;
    public long mLocationUpdatedTime = 0;
    private LocData mUpdateLacation;

    public interface IDistrictInfoListener {
        void onDistrictUpdated(DistrictInfo districtInfo, DistrictInfo districtInfo2);
    }

    private static class LazyHolder {
        private static GeoLocateModel sInstance = new GeoLocateModel();

        private LazyHolder() {
        }
    }

    public static GeoLocateModel getInstance() {
        return LazyHolder.sInstance;
    }

    public LocData getLastLocation() {
        return this.mLastLocation;
    }

    public GeoPoint getLastGeoPoint() {
        if (this.mLastLocation == null || !this.mLastLocation.isValid()) {
            return null;
        }
        GeoPoint gp = new GeoPoint();
        gp.setLatitudeE6((int) (this.mLastLocation.latitude * 100000.0d));
        gp.setLongitudeE6((int) (this.mLastLocation.longitude * 100000.0d));
        return gp;
    }

    public DistrictInfo getCurrentDistrict() {
        if (this.mCurrentDistrict != null) {
            return this.mCurrentDistrict;
        }
        int districtID = BNSettingManager.getDistrictId();
        String name = BNSettingManager.getDistrictName();
        DistrictInfo district = new DistrictInfo();
        district.mId = districtID;
        district.mName = name;
        district.mType = 3;
        return district;
    }

    public int getCurrentCityId() {
        if (this.mCurrentDistrict != null) {
            return this.mCurrentDistrict.mId;
        }
        return Integer.MIN_VALUE;
    }

    public void addDistrictInfoListener(IDistrictInfoListener listener) {
        if (listener != null && !this.mDistrictInfoListeners.contains(listener)) {
            this.mDistrictInfoListeners.add(listener);
        }
    }

    public void removeDistrictInfoListener(IDistrictInfoListener listener) {
        if (listener != null) {
            this.mDistrictInfoListeners.remove(listener);
        }
    }

    private void notifyDistrictInfoListener(DistrictInfo cityDistrict, DistrictInfo provinceDistrict) {
        for (int i = 0; i < this.mDistrictInfoListeners.size(); i++) {
            IDistrictInfoListener listener = (IDistrictInfoListener) this.mDistrictInfoListeners.get(i);
            if (listener != null) {
                listener.onDistrictUpdated(cityDistrict, provinceDistrict);
            }
        }
        this.mDistrictInfoListeners.clear();
    }

    public DistrictInfo getProvinceDistrict() {
        if (this.mCurrentDistrict != null) {
            return this.mCurrentParentDistrict;
        }
        DistrictInfo district = new DistrictInfo();
        district.mId = 19;
        district.mType = 2;
        return district;
    }

    public void updateLocation(LocData locData) {
        if (locData != null) {
            synchronized (this) {
                this.mLastLocation = locData;
                this.mLocationUpdatedTime = System.currentTimeMillis();
            }
            if (!BNavigator.getInstance().isNaviBegin()) {
                if (this.mCurrentDistrict == null) {
                    if (this.mLastAntiDistrictTime < 0 || SystemClock.elapsedRealtime() - this.mLastAntiDistrictTime > TIME_INTERVAL_TO_ANTI_DISTRICT_IN_FIRST) {
                        this.mLastAntiDistrictTime = SystemClock.elapsedRealtime();
                        asyncGetCurrentDistricts();
                    }
                } else if (this.mUpdateLacation != null && this.mUpdateLacation.isValid() && this.mLastLocation != null && this.mLastLocation.isValid() && !isNeareast(this.mUpdateLacation, this.mLastLocation)) {
                    asyncGetCurrentDistricts();
                }
            }
        }
    }

    public boolean isNeareast(LocData p1, LocData p2) {
        double dx = (p1.longitude * 100000.0d) - (p2.longitude * 100000.0d);
        double dy = (p1.latitude * 100000.0d) - (p2.latitude * 100000.0d);
        if (Math.sqrt((dx * dx) + (dy * dy)) > 10000.0d) {
            return false;
        }
        return true;
    }

    public boolean isNeareast(GeoPoint p1, GeoPoint p2) {
        int dx = p1.getLongitudeE6() - p2.getLongitudeE6();
        int dy = p1.getLatitudeE6() - p2.getLatitudeE6();
        if (Math.sqrt((double) ((dx * dx) + (dy * dy))) > 10000.0d) {
            return false;
        }
        return true;
    }

    public boolean hasUpdateDistrictInfo() {
        return this.hasUpdateDistrictInfo;
    }

    public void updateDistrict(GeoPoint pos, DistrictInfo city, DistrictInfo parent) {
        if (isNeareast(pos, getLastGeoPoint())) {
            this.mCurrentDistrict = city;
            this.mCurrentParentDistrict = parent;
        }
    }

    public boolean asyncGetCurrentDistricts() {
        boolean z = true;
        if (this.mLastLocation != null && this.mLastLocation.isValid()) {
            synchronized (this.mIsAntiGeoing) {
                if (this.mIsAntiGeoing.booleanValue()) {
                    z = false;
                } else {
                    if (BNPoiSearcher.getInstance().asynGetDistrictByPoint(this.mLastLocation.toGeoPoint(), 10000, this.mAntiGeoHandler)) {
                        this.mIsAntiGeoing = Boolean.valueOf(true);
                    }
                    this.mUpdateLacation = this.mLastLocation;
                }
            }
        }
        return z;
    }

    public void setDistrictByIdByManMade(int districtId) {
        this.mDistrictSetByManMade = BNPoiSearcher.getInstance().getDistrictById(districtId);
        if (this.mDistrictSetByManMade != null) {
            if (this.mDistrictSetByManMade.mType == 4) {
                this.mDistrictSetByManMade = BNPoiSearcher.getInstance().getParentDistrict(this.mDistrictSetByManMade.mId);
            }
            if (this.mDistrictSetByManMade != null) {
                this.mDistrictSetByManMade.mName = specialDealWith(this.mDistrictSetByManMade.mName);
            }
        }
    }

    public DistrictInfo getDistrictByManMade() {
        return this.mDistrictSetByManMade;
    }

    public void clearDistrictByManMade() {
        this.mDistrictSetByManMade = null;
    }

    private String specialDealWith(String name) {
        if (name == null) {
            return name;
        }
        String dealedStr;
        if (name.equals("澳门特别行政区")) {
            dealedStr = "澳门";
        } else if (name.equals("香港特别行政区")) {
            dealedStr = "香港";
        } else if (name.equals("北京市")) {
            dealedStr = "北京";
        } else if (name.equals("重庆市")) {
            dealedStr = "重庆";
        } else if (name.equals("上海市")) {
            dealedStr = "上海";
        } else if (name.equals("天津市")) {
            dealedStr = "天津";
        } else if (name.equals("深圳市")) {
            dealedStr = "深圳";
        } else if (name.equals("广西壮族自治区")) {
            dealedStr = "广西";
        } else if (name.equals("内蒙古自治区")) {
            dealedStr = "内蒙古";
        } else if (name.equals("宁夏回族自治区")) {
            dealedStr = "宁夏";
        } else if (name.equals("青海省")) {
            dealedStr = "青海";
        } else if (name.equals("西藏自治区")) {
            dealedStr = "西藏";
        } else if (name.equals("新疆维吾尔自治区")) {
            dealedStr = "新疆";
        } else {
            dealedStr = name;
        }
        return dealedStr;
    }

    public String getCurCityName() {
        DistrictInfo district;
        if (this.mDistrictSetByManMade != null) {
            district = this.mDistrictSetByManMade;
        } else {
            district = getCurrentDistrict();
        }
        if (district != null) {
            return specialDealWith(district.mName);
        }
        return null;
    }

    public DistrictInfo getProvinceDistrictByPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
        int i = 0;
        while (districtInfo != null && districtInfo.mType > 2 && i < 10) {
            districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
            i++;
        }
        if (districtInfo == null || districtInfo.mType != 2) {
            return null;
        }
        return districtInfo;
    }

    public boolean hasCurLocationCityOfflineData() {
        if (!BNLocationManagerProxy.getInstance().isLocationValid() || !BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        LocData locData = BNLocationManagerProxy.getInstance().getCurLocation();
        if (locData == null) {
            return false;
        }
        if (locData.longitude == -1.0d && locData.latitude == -1.0d) {
            return false;
        }
        DistrictInfo districtInfo = getProvinceDistrict();
        if (districtInfo == null || districtInfo.mType != 2) {
            return false;
        }
        return BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
    }
}
