package com.baidu.navisdk.ui.routeguide;

public class BNavConfig {
    public static final int INVALID_INT_VALUE = -1;
    public static final String INVALID_STRING_VALUE = "none";
    public static final String KEY_ROUTEGUIDE_CALCROUTE_DONE = "calroute_done";
    public static final String KEY_ROUTEGUIDE_CAR_RESULT_HAS_SHOW_ANIM = "car_result_has_show_anim";
    public static final String KEY_ROUTEGUIDE_END_NAME = "end_name";
    public static final String KEY_ROUTEGUIDE_END_UGCRESULTPAGE = "navi.end.ugcpage";
    public static final String KEY_ROUTEGUIDE_END_X = "end_x";
    public static final String KEY_ROUTEGUIDE_END_Y = "end_y";
    public static final String KEY_ROUTEGUIDE_IPO_SWITCH = "is_ipo_switch";
    public static final String KEY_ROUTEGUIDE_LOCATE_MODE = "locate_mode";
    public static final String KEY_ROUTEGUIDE_MENU_TYPE = "menu_type";
    public static final String KEY_ROUTEGUIDE_NET_FRESH_ENABLE = "net_refresh";
    public static final String KEY_ROUTEGUIDE_ROAD_CONDITION_ENABLE = "road_condition";
    public static final String KEY_ROUTEGUIDE_SELECTED_ROUTE_MRSL = "selected_route_mrsl";
    public static final String KEY_ROUTEGUIDE_SHOW_FULLVIEW = "show_fullview";
    public static final String KEY_ROUTEGUIDE_START_NAME = "start_name";
    public static final String KEY_ROUTEGUIDE_START_X = "start_x";
    public static final String KEY_ROUTEGUIDE_START_Y = "start_y";
    public static final String KEY_ROUTEGUIDE_VIEW_MODE = "routeguide_view_mode";
    public static final String KEY_ROUTEGUIDE_WALKNAVI = "walknavi";
    public static final String KEY_ROUTEGUIDE_WANDA = "is_wanda";
    public static int pRGCalcDone = -1;
    public static String pRGEndName = INVALID_STRING_VALUE;
    public static int pRGEndX = -1;
    public static int pRGEndY = -1;
    public static int pRGLocateMode = 0;
    public static int pRGMenuType = 1;
    public static String pRGMrsl = null;
    public static boolean pRGNetRefreshEnable = false;
    public static boolean pRGRoadConditionEnable = false;
    public static boolean pRGShowFullview = true;
    public static String pRGStartName = INVALID_STRING_VALUE;
    public static int pRGStartX = -1;
    public static int pRGStartY = -1;
    public static int pRGViewMode = -1;

    public static void clear() {
        pRGViewMode = -1;
        pRGCalcDone = -1;
        pRGStartX = -1;
        pRGStartY = -1;
        pRGEndX = -1;
        pRGEndY = -1;
        pRGStartName = INVALID_STRING_VALUE;
        pRGEndName = INVALID_STRING_VALUE;
        pRGLocateMode = 0;
        pRGShowFullview = true;
    }
}
