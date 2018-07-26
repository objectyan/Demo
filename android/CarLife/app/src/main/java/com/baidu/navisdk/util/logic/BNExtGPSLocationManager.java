package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class BNExtGPSLocationManager extends BNLocationManager {
    private static final String TAG = BNExtGPSLocationManager.class.getSimpleName();
    private static BNExtGPSLocationManager mInstance = null;
    private Context mContext;
    private int mDebugIndex = 1;
    private boolean mIsGpsEnabled = false;
    private LocationManager mSysLocManager;

    private BNExtGPSLocationManager() {
    }

    public static synchronized BNExtGPSLocationManager getInstance() {
        BNExtGPSLocationManager bNExtGPSLocationManager;
        synchronized (BNExtGPSLocationManager.class) {
            if (mInstance == null) {
                mInstance = new BNExtGPSLocationManager();
            }
            bNExtGPSLocationManager = mInstance;
        }
        return bNExtGPSLocationManager;
    }

    public static synchronized void destory() {
        synchronized (BNExtGPSLocationManager.class) {
            if (mInstance != null) {
                mInstance.unInit();
            }
            mInstance = null;
        }
    }

    public synchronized void init(Context context) {
        this.mContext = context;
        LogUtil.m15791e(TAG, "init");
    }

    public synchronized void unInit() {
        this.mContext = null;
        this.mSysLocManager = null;
        LogUtil.m15791e(TAG, " unInit");
    }

    public boolean isGpsEnabled() {
        if (RouteGuideParams.getRouteGuideMode() != 2) {
            return this.mIsGpsEnabled;
        }
        try {
            if (this.mSysLocManager == null && this.mContext != null && hasGPSPermission(BNaviModuleManager.getContext())) {
                this.mSysLocManager = (LocationManager) this.mContext.getSystemService("location");
            }
            return this.mSysLocManager.isProviderEnabled("gps");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isGpsAvailable() {
        return getCurLocation() != null;
    }

    public void updateGpsStatus(boolean enabled) {
        LogUtil.m15791e(TAG, "updateGpsStatus: enabled " + enabled);
        this.mIsGpsEnabled = enabled;
        notifyGpsStatusChanged(enabled, true);
    }

    public void updateLocation(LocData locData) {
        if (locData != null) {
            notifyLocationChanged(locData);
        }
    }

    public void updateWGS84Location(LocData locData, LocData gcjLocData) {
        if (locData != null) {
            notifyWGS84LocationChanged(locData, gcjLocData);
        }
    }

    public void triggerGPSDataChangeForDriving(LocData locData) {
        LogUtil.m15791e(TAG, "triggerGPSDataChangeForDriving   longitude:" + locData.longitude + ", latitude:" + locData.latitude + ", locType:" + locData.type + ", satellitesNum:" + locData.satellitesNum);
        if (locData.type == 61) {
            Bundle wgs84Bundle = CoordinateTransformUtil.transferGCJ02ToWGS84(locData.longitude, locData.latitude);
            locData.locType = 0;
            if (BNSettingManager.isShowJavaLog()) {
                SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("Driving sysloc=long:" + ((int) (wgs84Bundle.getDouble("LLx") * 100000.0d)) + ", lati:" + ((int) (wgs84Bundle.getDouble("LLy") * 100000.0d)) + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
            }
            BNRouteGuider.getInstance().triggerGPSDataChange((int) (wgs84Bundle.getDouble("LLx") * 100000.0d), (int) (wgs84Bundle.getDouble("LLy") * 100000.0d), locData.speed, locData.direction, locData.accuracy, (float) locData.altitude, locData.satellitesNum, locData.locType);
            return;
        }
        triggerGPSDataChangeForAllLocType(locData);
    }

    public void triggerGPSDataChangeForAllLocType(LocData locData) {
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e(TAG, "triggerGPSDataChangeForAllLocType   longitude:" + locData.longitude + ", latitude:" + locData.latitude + ", locType:" + locData.type + ", satellitesNum:" + locData.satellitesNum);
        }
        if (locData != null) {
            Bundle wgs84Bundle = CoordinateTransformUtil.transferGCJ02ToWGS84(locData.longitude, locData.latitude);
            BNRouteGuider.getInstance().triggerGPSDataChange((int) (wgs84Bundle.getDouble("LLx") * 100000.0d), (int) (wgs84Bundle.getDouble("LLy") * 100000.0d), locData.speed, locData.direction, locData.accuracy, (float) locData.altitude, locData.satellitesNum, locData.type == 61 ? 0 : 1);
        }
    }

    public void notifyLocationChangedForEngine(LocData locData) {
        if (!BNavigator.getInstance().isNaviBegin() && locData != null) {
            int indoorState;
            Bundle wgs84Bundle = CoordinateTransformUtil.transferGCJ02ToWGS84(locData.longitude, locData.latitude);
            double longtitude = wgs84Bundle.getDouble("LLx");
            double latitude = wgs84Bundle.getDouble("LLy");
            double altitude = locData.altitude;
            float speed = locData.speed;
            float bearing = locData.direction;
            float accuracy = locData.accuracy;
            int locType = locData.getStartPointUpStreamLocType();
            if (locData.indoorState == 1) {
                indoorState = 1;
            } else if (locData.indoorState == 0) {
                indoorState = 2;
            } else {
                indoorState = 0;
            }
            if (this.mDebugIndex >= 10) {
                this.mDebugIndex = 1;
                LogUtil.m15791e("triggerStartLocationData:", "call");
            }
            this.mDebugIndex++;
            BNRouteGuider.getInstance().triggerStartLocationData((int) (100000.0d * longtitude), (int) (100000.0d * latitude), (float) altitude, speed, bearing, accuracy, locType, indoorState);
        }
    }

    public boolean hasGPSPermission(Context context) {
        if (context == null) {
            return true;
        }
        try {
            PackageManager pm = context.getPackageManager();
            if (pm == null || -1 != pm.checkPermission("android.permission.ACCESS_FINE_LOCATION", PackageUtil.getPackageName())) {
                return true;
            }
            TipTool.onCreateToastDialog(context, BNStyleManager.getString(C4048R.string.nsdk_string_error_gps_permission_fail));
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
