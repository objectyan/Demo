package com.baidu.navisdk.util.logic;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.UpdateLocationDataStruct;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.NavSDKDebug;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.commonui.DebugCommonUIController;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

class BNSysLocationManager$4 implements LocationListener {
    final /* synthetic */ BNSysLocationManager this$0;

    BNSysLocationManager$4(BNSysLocationManager this$0) {
        this.this$0 = this$0;
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            if (BNSysLocationManager.access$1100(this.this$0) || !BNSysLocationManager.access$1200(this.this$0, location)) {
                try {
                    LocData locData = new LocData();
                    GeoPoint geopt = CoordinateTransformUtil.transferWGS84ToGCJ02(location.getLongitude(), location.getLatitude());
                    locData.latitude = ((double) geopt.getLatitudeE6()) / 100000.0d;
                    locData.longitude = ((double) geopt.getLongitudeE6()) / 100000.0d;
                    locData.speed = location.getSpeed();
                    locData.accuracy = Math.min(2000.0f, location.getAccuracy());
                    locData.direction = location.getBearing();
                    locData.satellitesNum = BNSysLocationManager.access$300(this.this$0);
                    locData.altitude = location.getAltitude();
                    locData.time = location.getTime();
                    locData.locType = 0;
                    LocData wgs84Data = locData.clone();
                    wgs84Data.latitude = location.getLatitude();
                    wgs84Data.longitude = location.getLongitude();
                    this.this$0.notifyWGS84LocationChanged(wgs84Data, locData);
                    this.this$0.notifyLocationChanged(locData);
                    BNSysLocationManager.access$1300(this.this$0);
                    if (NavSDKDebug.sShowDebugToast) {
                        TipTool.onCreateDebugToast(BNaviModuleManager.getContext(), "Sys " + locData.toString());
                    }
                    if (LogUtil.LOGGABLE) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("sysloc=long:" + location.getLongitude() + ", lati:" + location.getLatitude() + ", transloc=long:" + locData.longitude + ", lati:" + locData.latitude + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
                    }
                    if (BNSettingManager.isGPSDebug()) {
                        DebugCommonUIController.getInstance().updateUIInfo(DebugCommonUIController.DEBUG_MODULE_LOCATION, "long:" + locData.longitude + ", lati:" + locData.latitude + ", speed:" + locData.speed + ", direction:" + locData.direction + ", accuracy:" + locData.accuracy + ", locType:" + locData.locType + ", satellitesNum:" + locData.satellitesNum);
                    }
                } catch (Throwable t) {
                    if (BNSettingManager.isShowJavaLog()) {
                        StringBuffer sb = new StringBuffer();
                        StackTraceElement[] stackElements = t.getStackTrace();
                        if (stackElements != null) {
                            int len = Math.min(5, stackElements.length);
                            for (int i = 0; i < len; i++) {
                                sb.append("at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
                            }
                        }
                        SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("message: " + t.getLocalizedMessage() + ", stack:" + sb.toString());
                    }
                }
            }
        }
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        boolean available;
        int satellites = 0;
        if (extras != null) {
            satellites = extras.getInt(UpdateLocationDataStruct.KEY_SATELLITES);
        }
        BNSysLocationManager.access$1402(this.this$0, status);
        LogUtil.m15791e("Location", "onStatusChanged: " + provider + ", status " + status + ", satellites " + satellites);
        if (status == 1 || status == 2) {
            available = true;
        } else {
            available = false;
        }
        if (NavSDKDebug.sShowDebugToast) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "Sys GPSStatusChanged, avail " + available + ", sat " + satellites);
        }
    }

    public void onProviderEnabled(String provider) {
        LogUtil.m15791e("Location", "onProviderEnabled: " + provider);
        BNSysLocationManager.access$002(this.this$0, true);
        BNSysLocationManager.access$1102(this.this$0, false);
        this.this$0.notifyGpsStatusChanged(true, false);
    }

    public void onProviderDisabled(String provider) {
        LogUtil.m15791e("Location", "onProviderDisabled: " + provider);
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_4, "1", null, null);
        BNSysLocationManager.access$002(this.this$0, false);
        BNSysLocationManager.access$1102(this.this$0, false);
        this.this$0.notifyGpsStatusChanged(false, false);
    }
}
