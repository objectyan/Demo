package com.baidu.navisdk.ui.routedetails.proxy;

public class BNRouteDetailConfig {
    public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
    public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
    public static final int INVALID_INT_VALUE = -1;
    public static final String KEY_ROUTE_DETAIL_VIEW_MODE = "route_detail_view_mode";
    public static int pRGViewMode = 1;

    public static void clear() {
        pRGViewMode = -1;
    }
}
