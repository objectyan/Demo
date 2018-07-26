package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.debug.commonui.DebugCommonUIController;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BNSysLocationManager extends BNLocationManager {
    private static final long GPS_AVAIL_MAX_INTERVAL = 1500;
    private static final int GPS_AVAIL_MIN_NUM_DATA = 3;
    private static final float GPS_UPDATE_MIN_DIST = 0.0f;
    private static final int GPS_UPDATE_MIN_TIME = 0;
    private static final int MOCK_JUDGE_TIME_INTERVAL = 10000;
    private static final String TAG = "Location";
    private static BNSysLocationManager mInstance = null;
    public boolean isLocateInitSuccessful = true;
    private int mEventOfGPSStatusChanged = 2;
    private int mFixedSatellitesNum = 0;
    private boolean mGpsAvailable = false;
    private boolean mGpsAvailableDebug = false;
    private GpsStatus mGpsStatus;
    private int mGpsStatusDebug = 0;
    private Listener mGpsStatusListener = new BNSysLocationManager$3(this);
    private Listener mGpsStatusRoutePlanListener = new BNSysLocationManager$2(this);
    private boolean mIsStarted = false;
    private long mLastTimeOfSatelliteStatusChanged = 0;
    private List<Long> mLocDataTimeCache = new ArrayList(3);
    private LocationListener mLocationListener = new BNSysLocationManager$4(this);
    private int mMockJudgeGPSCount = 0;
    private int mMockJudgeGPSStatusAvailableCount = 0;
    private int mMockJudgeGPSStatusTmpAvailableCount = 0;
    private int mMockJudgeGPSStatusUnavailableCount = 0;
    private long mMockJudgeLastTime = 0;
    private int mMockJudgeTotalCount = 0;
    private int mSearchedSatellitesNum = 0;
    public boolean mSensorFingerEnable = false;
    private LocationManager mSysLocManager = null;

    private BNSysLocationManager() {
    }

    public static synchronized BNSysLocationManager getInstance() {
        BNSysLocationManager bNSysLocationManager;
        synchronized (BNSysLocationManager.class) {
            if (mInstance == null) {
                mInstance = new BNSysLocationManager();
            }
            bNSysLocationManager = mInstance;
        }
        return bNSysLocationManager;
    }

    public static synchronized void destory() {
        synchronized (BNSysLocationManager.class) {
            if (mInstance != null) {
                mInstance.unInit();
            }
            mInstance = null;
        }
    }

    public void restartLocateModule() {
        if (VERSION.SDK_INT >= 23 && this.mSysLocManager == null) {
            LogUtil.e("Location", "restartLocateModule");
            init(BNaviModuleManager.getContext());
        }
    }

    public void init(Context context) {
        LogUtil.e("Location", "init");
        if (this.mSysLocManager == null && context != null && hasGPSPermission(BNaviModuleManager.getContext())) {
            this.mSysLocManager = (LocationManager) context.getSystemService("location");
        }
        if (this.mSysLocManager == null) {
            this.isLocateInitSuccessful = false;
            LogUtil.e("Location", "init locateinit failed");
        }
    }

    public boolean hasGPSPermission(Context context) {
        if (context != null) {
            try {
                PackageManager pm = context.getPackageManager();
                if (pm != null && -1 == pm.checkPermission("android.permission.ACCESS_FINE_LOCATION", PackageUtil.getPackageName())) {
                    TipTool.onCreateToastDialog(context, BNStyleManager.getString(C4048R.string.nsdk_string_error_gps_permission_fail));
                    LogUtil.e("Location", "hasGPSPermission=false");
                    return false;
                }
            } catch (Exception e) {
                LogUtil.e("Location", "hasGPSPermission=true but exception=" + e.getMessage());
                return true;
            }
        }
        LogUtil.e("Location", "hasGPSPermission=true");
        return true;
    }

    public void unInit() {
        LogUtil.e("Location", "unInit");
        stopLocate();
        this.mSysLocManager = null;
    }

    public boolean isGpsEnabled() {
        boolean enable = false;
        try {
            if (this.mSysLocManager != null) {
                enable = this.mSysLocManager.isProviderEnabled("gps");
            }
        } catch (IllegalArgumentException e) {
            LogUtil.e("Location", e.toString());
        } catch (SecurityException e2) {
            LogUtil.e("Location", e2.toString());
        }
        return enable;
    }

    public boolean isSysLocationValid() {
        return this.mGpsAvailable && getCurLocation() != null;
    }

    public synchronized boolean startNaviLocate(Context context) {
        super.startNaviLocate(context);
        return startLocate();
    }

    public void showDebugUI() {
        if (BNSettingManager.isGPSDebug()) {
            DebugCommonUIController.getInstance().showUI(DebugCommonUIController.DEBUG_MODULE_LOCATION, new BNSysLocationManager$1(this));
        }
    }

    private String getLocationStatusDebugString() {
        String string = "out";
        switch (this.mGpsStatusDebug) {
            case 1:
                return "tmp";
            case 2:
                return BNRemoteConstants.ERROR_DEFAULT_STR;
            default:
                return "out";
        }
    }

    public String getGPSStatusDebugString() {
        String string = "停止定位";
        switch (this.mEventOfGPSStatusChanged) {
            case 1:
                return "开始定位";
            case 2:
                return "停止定位";
            case 3:
                return "首次定位";
            case 4:
                return "卫星变化";
            default:
                return string;
        }
    }

    public synchronized void startNaviLocateForRoutePlan(Context context) {
        if (!(this.mSysLocManager == null || this.mGpsStatusListener == null || !hasGPSPermission(context))) {
            try {
                this.mSysLocManager.addGpsStatusListener(this.mGpsStatusRoutePlanListener);
            } catch (Exception e) {
            }
        }
    }

    public synchronized void stopNaviLocateForRoutePlan() {
        if (!(this.mSysLocManager == null || this.mGpsStatusListener == null)) {
            this.mSysLocManager.removeGpsStatusListener(this.mGpsStatusRoutePlanListener);
        }
    }

    public synchronized void stopNaviLocate() {
        super.stopNaviLocate();
        LogUtil.e("Location", "stopNaviLocate");
        stopLocate();
        if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.end(SDKDebugFileUtil.SYSLOC_FILENAME);
            SDKDebugFileUtil.end(SDKDebugFileUtil.NAVING_SYSLOC_FILENAME);
        }
    }

    private synchronized boolean startLocate() {
        boolean z;
        LogUtil.e("Location", "startLocate");
        if (this.mSysLocManager == null || this.mIsStarted) {
            UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, C2578b.f8568g, null, null);
            LogUtil.e("Location", "startLocate() error for null. mIsStarted=" + this.mIsStarted);
            z = false;
        } else if (hasGPSPermission(BNaviModuleManager.getContext())) {
            try {
                this.mSysLocManager.requestLocationUpdates("gps", 0, 0.0f, this.mLocationListener);
                this.mSysLocManager.addGpsStatusListener(this.mGpsStatusListener);
                if (NavSDKDebug.sShowDebugToast) {
                    TipTool.onCreateDebugToast(BNaviModuleManager.getContext(), "SysLoc: startLocate");
                }
                resetMockJudge();
                this.mIsStarted = true;
                LogUtil.e("Location", "startLocate() ok");
                z = true;
            } catch (Exception e) {
                UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, "5", null, null);
                if (PerformStatItem.sUserTest) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, " BNSysLocationManager startLocate catch Exception = " + e.getMessage());
                    SDKDebugFileUtil.getInstance().uploadLogFile(1, true, true, 2000);
                }
                LogUtil.e("Location", "startLocate() ex=" + e.getMessage());
                z = false;
            }
        } else {
            UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, "4", null, null);
            LogUtil.e("Location", "startLocate() error for permission denied");
            z = false;
        }
        return z;
    }

    private synchronized boolean stopLocate() {
        boolean z = false;
        synchronized (this) {
            LogUtil.e("Location", "stopLocate");
            try {
                if (this.mSysLocManager == null || !this.mIsStarted) {
                    LogUtil.e("Location", "stopLocate() error for null. mIsStarted=" + this.mIsStarted);
                } else {
                    if (this.mLocationListener != null) {
                        this.mSysLocManager.removeUpdates(this.mLocationListener);
                    }
                    if (this.mGpsStatusListener != null) {
                        this.mSysLocManager.removeGpsStatusListener(this.mGpsStatusListener);
                    }
                    this.mIsStarted = false;
                    LogUtil.e("Location", "stopLocate() ok");
                    z = true;
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.e("Location", "stopLocate() error for ex=" + e.getMessage());
            }
        }
        return z;
    }

    public synchronized void addNmeaListener(NmeaListener listener) {
        try {
            if (!(this.mSysLocManager == null || listener == null)) {
                this.mSysLocManager.addNmeaListener(listener);
                LogUtil.e("Location", "addNmeaListener() ok");
            }
        } catch (Exception e) {
            LogUtil.e("Location", "addNmeaListener() error. e=" + e.getMessage());
        }
    }

    public synchronized void removeNmeaListener(NmeaListener listener) {
        LogUtil.e("Location", "removeNmeaListener() ");
        if (!(this.mSysLocManager == null || listener == null)) {
            this.mSysLocManager.removeNmeaListener(listener);
        }
    }

    private void notifyGpsStatusWithSatellitesChanged(int satellites) {
        if (this.mGpsAvailable && satellites == 0) {
            this.mGpsAvailable = false;
            LogUtil.e("Location", "notifyGpsStatusWithSatellitesChanged: mGpsAvailable --> " + this.mGpsAvailable);
            notifyGpsStatusChanged(true, false);
        } else if (!this.mGpsAvailable && satellites > 0) {
            this.mGpsAvailable = true;
            LogUtil.e("Location", "notifyGpsStatusWithSatellitesChanged: mGpsAvailable --> " + this.mGpsAvailable);
            notifyGpsStatusChanged(true, true);
            this.mLocDataTimeCache.clear();
        }
    }

    private HashMap<String, Integer> getSatellitesMap() {
        HashMap<String, Integer> satellitesMap = new HashMap();
        try {
            if (this.mSysLocManager != null) {
                if (this.mGpsStatus == null) {
                    this.mGpsStatus = this.mSysLocManager.getGpsStatus(null);
                } else {
                    this.mSysLocManager.getGpsStatus(this.mGpsStatus);
                }
                int fixedSatellitesNum = 0;
                int searchedSatellitesNum = 0;
                for (GpsSatellite satellite : this.mGpsStatus.getSatellites()) {
                    if (satellite.usedInFix()) {
                        fixedSatellitesNum++;
                    }
                    searchedSatellitesNum++;
                }
                satellitesMap.put("fixedSatellitesNum", Integer.valueOf(fixedSatellitesNum));
                satellitesMap.put("searchedSatellitesNum", Integer.valueOf(searchedSatellitesNum));
                return satellitesMap;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void startRecordStarInfos() {
        recordViaductStartNodeStarInfos();
    }

    private void recordViaductStartNodeStarInfos() {
        try {
            if (BNaviModuleManager.getContext() != null && this.mSysLocManager != null) {
                ArrayList<Bundle> starInfos = new ArrayList();
                int fixedSatellitesNum = 0;
                int searchedSatellitesNum = 0;
                for (GpsSatellite satellite : this.mSysLocManager.getGpsStatus(null).getSatellites()) {
                    if (satellite.usedInFix()) {
                        fixedSatellitesNum++;
                    }
                    searchedSatellitesNum++;
                    Bundle star = new Bundle();
                    star.putInt("nStarId", satellite.getPrn());
                    star.putFloat("fUpAngle", satellite.getElevation());
                    star.putFloat("fAngle", satellite.getAzimuth());
                    star.putFloat("fSNR", satellite.getSnr());
                    star.putBoolean("bIsUsed", satellite.usedInFix());
                    star.putBoolean("bIsHaveAlmanac", satellite.hasAlmanac());
                    star.putBoolean("bIsHaveEphemeris", satellite.hasEphemeris());
                    starInfos.add(star);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("recordViaductStartNodeStarInfos:", "nStarId=" + satellite.getPrn());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "fUpAngle=" + satellite.getElevation());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "fAngle=" + satellite.getAzimuth());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "fSNR=" + satellite.getSnr());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "bIsUsed=" + satellite.usedInFix());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "bIsHaveAlmanac=" + satellite.hasAlmanac());
                        LogUtil.e("recordViaductStartNodeStarInfos:", "bIsHaveEphemeris=" + satellite.hasEphemeris());
                    }
                    if (searchedSatellitesNum == 60) {
                        break;
                    }
                }
                LogUtil.e("recordViaductStartNodeStarInfos:", "searchedSatellitesNum=" + searchedSatellitesNum);
                LogUtil.e("recordViaductStartNodeStarInfos:", "fixedSatellitesNum=" + fixedSatellitesNum);
                BNRouteGuider.getInstance().triggerGPSStarInfoChange(searchedSatellitesNum, fixedSatellitesNum, starInfos);
            }
        } catch (Exception e) {
        }
    }

    public GeoPoint getSysLastKnownLocation() {
        if (this.mSysLocManager != null) {
            Location location = this.mSysLocManager.getLastKnownLocation("gps");
            if (location == null) {
                location = this.mSysLocManager.getLastKnownLocation(C1981b.f6367g);
            }
            if (location != null) {
                return CoordinateTransformUtil.transferWGS84ToGCJ02(location.getLongitude(), location.getLatitude());
            }
        }
        return null;
    }

    public boolean isGpsAvailable() {
        return this.mGpsAvailable;
    }

    public int getFixedSatelliteNum() {
        return this.mFixedSatellitesNum;
    }

    public int getSearchedSatelliteNum() {
        return this.mSearchedSatellitesNum;
    }

    private boolean handleLocationWhenGpsLost(Location location) {
        if (location == null) {
            return true;
        }
        LogUtil.e("Location", "handleLocationWhenGpsLost");
        long now = System.currentTimeMillis();
        long lastTime = now;
        if (!this.mLocDataTimeCache.isEmpty()) {
            lastTime = ((Long) this.mLocDataTimeCache.get(this.mLocDataTimeCache.size() - 1)).longValue();
        }
        if (now - lastTime <= GPS_AVAIL_MAX_INTERVAL) {
            this.mLocDataTimeCache.add(Long.valueOf(now));
            LogUtil.e("Location", "GpsLost: add new location, size " + this.mLocDataTimeCache.size());
            if (this.mLocDataTimeCache.size() >= 3) {
                this.mGpsAvailable = true;
                notifyGpsStatusChanged(true, true);
                LogUtil.e("Location", "GpsLost: unavailable ----> available");
                this.mLocDataTimeCache.clear();
                return false;
            }
        }
        this.mLocDataTimeCache.clear();
        LogUtil.e("Location", "GpsLost: > interval, clear all");
        return true;
    }

    private void recordSensorFingerStarInfos() {
        try {
            Context ctx = BNaviModuleManager.getContext();
            if (ctx != null) {
                LocationManager mSysLocManager = (LocationManager) ctx.getSystemService("location");
                if (mSysLocManager != null) {
                    ArrayList<Bundle> starInfos = new ArrayList();
                    int fixedSatellitesNum = 0;
                    int searchedSatellitesNum = 0;
                    for (GpsSatellite satellite : mSysLocManager.getGpsStatus(null).getSatellites()) {
                        if (satellite.usedInFix()) {
                            fixedSatellitesNum++;
                        }
                        searchedSatellitesNum++;
                        Bundle star = new Bundle();
                        star.putInt("nStarId", satellite.getPrn());
                        star.putFloat("fUpAngle", satellite.getElevation());
                        star.putFloat("fAngle", satellite.getAzimuth());
                        star.putFloat("fSNR", satellite.getSnr());
                        star.putBoolean("bIsUsed", satellite.usedInFix());
                        star.putBoolean("bIsHaveAlmanac", satellite.hasAlmanac());
                        star.putBoolean("bIsHaveEphemeris", satellite.hasEphemeris());
                        starInfos.add(star);
                        LogUtil.e("SensorFinger", "starID=" + satellite.getPrn());
                        if (LogUtil.LOGGABLE) {
                            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "SensorFinger.starID=" + satellite.getPrn());
                        }
                        if (searchedSatellitesNum == 60) {
                            break;
                        }
                    }
                    BNRouteGuider.getInstance().triggerGPSStarInfoChange(searchedSatellitesNum, fixedSatellitesNum, starInfos);
                }
            }
        } catch (Exception e) {
        }
    }

    private void resetMockJudge() {
        LogUtil.e("Location", "resetcja() mReAddGpsLocation " + BNavigator.getInstance().mReAddGpsLocation);
        if (BNavigator.getInstance().mReAddGpsLocation) {
            BNavigator.getInstance().mReAddGpsLocation = false;
            return;
        }
        this.mMockJudgeLastTime = 0;
        this.mMockJudgeGPSCount = 0;
        this.mMockJudgeTotalCount = 0;
        this.mLastTimeOfSatelliteStatusChanged = 0;
        this.mEventOfGPSStatusChanged = 2;
        this.mMockJudgeGPSStatusAvailableCount = 0;
        this.mMockJudgeGPSStatusTmpAvailableCount = 0;
        this.mMockJudgeGPSStatusUnavailableCount = 0;
        this.mGpsStatusDebug = 0;
    }

    public boolean isMock() {
        return isMockByLocationAndSatellieteStatus();
    }

    private boolean isMockByLocationAndSatellieteStatus() {
        LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() gpsC=" + this.mMockJudgeGPSCount + ", totalC=" + this.mMockJudgeTotalCount);
        if (this.mMockJudgeTotalCount <= 0) {
            LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() true for 0");
            return true;
        } else if (((double) this.mMockJudgeGPSCount) / ((double) this.mMockJudgeTotalCount) >= 0.9d) {
            LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() false");
            return false;
        } else {
            LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() true other");
            return true;
        }
    }

    private boolean isMockByGPSStatus() {
        LogUtil.e("Location", "iscjaByGPSStatus() ac=" + this.mMockJudgeGPSStatusAvailableCount + ", tc=" + this.mMockJudgeGPSStatusTmpAvailableCount + ", uc=" + this.mMockJudgeGPSStatusUnavailableCount);
        int total = (this.mMockJudgeGPSStatusAvailableCount + this.mMockJudgeGPSStatusTmpAvailableCount) + this.mMockJudgeGPSStatusUnavailableCount;
        if (total == 0) {
            LogUtil.e("Location", "iscjaByGPSStatus() true for 0");
            return true;
        } else if (((double) (this.mMockJudgeGPSStatusAvailableCount + this.mMockJudgeGPSStatusTmpAvailableCount)) / ((double) total) >= 0.8d) {
            LogUtil.e("Location", "iscjaByGPSStatus() false");
            return false;
        } else {
            LogUtil.e("Location", "iscjaByGPSStatus() true for other");
            return true;
        }
    }

    private void mockJudge() {
        if (VERSION.SDK_INT >= 23 && SystemClock.elapsedRealtime() - this.mMockJudgeLastTime > BNOffScreenParams.MIN_ENTER_INTERVAL) {
            if (SystemClock.elapsedRealtime() - this.mLastTimeOfSatelliteStatusChanged < 3000) {
                this.mMockJudgeGPSCount++;
            }
            this.mMockJudgeTotalCount++;
            this.mMockJudgeLastTime = SystemClock.elapsedRealtime();
            LogUtil.e("Location", "cja() gpsC=" + this.mMockJudgeGPSCount + ", totalC=" + this.mMockJudgeTotalCount);
            switch (this.mGpsStatusDebug) {
                case 0:
                    this.mMockJudgeGPSStatusUnavailableCount++;
                    break;
                case 1:
                    this.mMockJudgeGPSStatusTmpAvailableCount++;
                    break;
                case 2:
                    this.mMockJudgeGPSStatusAvailableCount++;
                    break;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Location", "cja() ac=" + this.mMockJudgeGPSStatusAvailableCount + ", tc=" + this.mMockJudgeGPSStatusTmpAvailableCount + ", uc=" + this.mMockJudgeGPSStatusUnavailableCount);
            }
        }
    }
}
