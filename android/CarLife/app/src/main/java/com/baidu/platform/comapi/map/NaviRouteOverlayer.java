package com.baidu.platform.comapi.map;

import android.os.Bundle;

public class NaviRouteOverlayer extends InnerOverlay {
    static NaviRouteOverlayer naviRouteOverlayer = null;

    public NaviRouteOverlayer(int emapNaviRoute) {
        super(emapNaviRoute);
    }

    public static InnerOverlay getInstance() {
        if (naviRouteOverlayer == null) {
            naviRouteOverlayer = new NaviRouteOverlayer(26);
        }
        return naviRouteOverlayer;
    }

    public void setData(String strJson) {
    }

    public String getData() {
        return null;
    }

    public Bundle getParam() {
        return null;
    }

    public void clear() {
    }
}
