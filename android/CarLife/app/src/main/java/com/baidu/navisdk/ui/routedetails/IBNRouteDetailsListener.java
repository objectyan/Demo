package com.baidu.navisdk.ui.routedetails;

public interface IBNRouteDetailsListener {
    public static final int MAP_ROUTE_FOCUS = 4;
    public static final int PAGE_JUMP_TO_BACK = 1;
    public static final int PAGE_JUMP_TO_HOME = 2;
    public static final int ROUTE_PLAN_SUCCESS = 2;
    public static final int SWITCH_OTHER_ROUTE_RESULT_FAILED = 1;
    public static final int SWITCH_OTHER_ROUTE_RESULT_SUCCESS = 0;
    public static final int UI_UPDATE_GET_CAR_NO = 5;
    public static final int UI_UPDATE_GET_CAR_TYPE = 6;
    public static final int UI_UPDATE_OPEN_WEBVIEW = 7;
    public static final int UI_UPDATE_REFRESH = 3;

    void onHideSidePanel();

    void onNotifySwitchResult(int i);

    void onPageJump(int i, Object obj);

    void onResetMapCtrlPanel();

    void onShowSidePanel();

    void onStartNavi(boolean z);

    void onStartRealNavi();

    void onSwitchOtherRoute(int i);

    void onUpdate(int i, int i2, int i3, Object obj);

    void onYawingBackGuiding();
}
