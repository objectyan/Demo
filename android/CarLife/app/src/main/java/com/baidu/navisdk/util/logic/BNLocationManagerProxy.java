package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class BNLocationManagerProxy {
    private static BNLocationManagerProxy sProxy;

    private BNLocationManagerProxy() {
    }

    public static BNLocationManagerProxy getInstance() {
        if (sProxy == null) {
            synchronized (BNLocationManagerProxy.class) {
                if (sProxy == null) {
                    sProxy = new BNLocationManagerProxy();
                }
            }
        }
        return sProxy;
    }

    public int getGpsState() {
        int gpsState = BNExtGPSLocationManager.getInstance().isGpsEnabled() ? BNExtGPSLocationManager.getInstance().isGpsAvailable() ? 1 : 2 : 0;
        if (gpsState == 1) {
            return gpsState;
        }
        if (!BNSysLocationManager.getInstance().isGpsEnabled()) {
            gpsState = 0;
        } else if (BNSysLocationManager.getInstance().isGpsAvailable()) {
            gpsState = 1;
        } else {
            gpsState = 2;
        }
        if (gpsState == 1) {
            return gpsState;
        }
        return gpsState;
    }

    public GeoPoint getLastValidLocation() {
        GeoPoint point = BNExtGPSLocationManager.getInstance().getLastValidLocation();
        if (point != null && point.isValid()) {
            return point;
        }
        point = BNSysLocationManager.getInstance().getLastValidLocation();
        if (point == null || !point.isValid()) {
            return point;
        }
        return point;
    }

    public boolean isLocationValid() {
        boolean isLocatoinValid = BNExtGPSLocationManager.getInstance().isGpsAvailable();
        if (isLocatoinValid) {
            return isLocatoinValid;
        }
        isLocatoinValid = BNSysLocationManager.getInstance().isSysLocationValid();
        if (isLocatoinValid) {
            return isLocatoinValid;
        }
        return isLocatoinValid;
    }

    public LocData getCurLocation() {
        LocData locData = BNExtGPSLocationManager.getInstance().getCurLocation();
        if (locData != null && locData.isValid()) {
            return locData;
        }
        locData = BNSysLocationManager.getInstance().getCurLocation();
        if (locData == null || !locData.isValid()) {
            return locData;
        }
        return locData;
    }

    public RoutePlanNode getCurLocationNode() {
        GeoPoint point = getLastValidLocation();
        if (point != null) {
            return new RoutePlanNode(point, 3, null, null);
        }
        return null;
    }

    public void startNaviLocate(Context context) {
    }

    public void stopNaviLocate() {
    }
}
