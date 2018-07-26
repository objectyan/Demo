package com.baidu.baidunavis;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class BaiduNaviParams {
    public static final int DRIVE_REF_DEFAULT_TIME_DURATION = 1440;
    public static final int DRIVE_REF_DEFAULT_TIME_INTERVAL = 30;
    public static final String KEY_FAILED_TYPE = "failed_type";
    public static final String KEY_HASOFFLINEDATA = "has_offline_data";
    public static final String KEY_NETMODE = "netmode";
    public static final String KEY_OPEN_API_SRC = "src_open_api";
    public static final String KEY_PB_Data = "pb_data";
    public static final String KEY_RESULT = "result";
    public static final String KEY_TIME = "time";
    public static final boolean NAV_THEME_SCENE_BYSELF = true;
    public static final String ROAD_CONDITION_COMMAND = "cctc";

    public interface AddThroughType {
        public static final String GEO_TYPE = "3";
        public static final String LONG_DIS_TYPE = "2";
        public static final String MAP_SELECT_TYPE = "5";
        public static final String NORMAL_TYPE = "1";
        public static final String POI_CLICK_TYPE = "4";
    }

    public interface BackBundle {
        public static final String back_from_nav = "back_from_nav";
        public static final String back_from_other = "back_from_other";
    }

    public interface MapCarPointKey {
        public static final String Map_CarPoint_Angle = "map_carpoint_angle";
        public static final String Map_CarPoint_X = "map_carpoint_x";
        public static final String Map_CarPoint_Y = "map_carpoint_y";
    }

    public interface MapRCRequestType {
        public static final int NE_MapRC_Request_Type_APP = 1;
        public static final int NE_MapRC_Request_Type_Invalid = 0;
        public static final int NE_MapRC_Request_Type_Push = 2;
    }

    public class MapThemeMode {
        public static final int CARMAPBASIC = 10;
        public static final int CARMAPNAVI = 11;
        public static final int CARMAPNIGHT = 12;
    }

    public class NERoutePlanMode {
        public static final int ROUTE_PLAN_MOD_AVOID_TAFFICJAM = 16;
        public static final int ROUTE_PLAN_MOD_MIN_DIST = 4;
        public static final int ROUTE_PLAN_MOD_MIN_TIME = 2;
        public static final int ROUTE_PLAN_MOD_MIN_TOLL = 8;
        public static final int ROUTE_PLAN_MOD_RECOMMEND = 1;
    }

    public interface NaviEvent {
        public static final int EVENT_AVOID_TRAFFIC_EJECT = 9013;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH = 9012;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH_FAILED = 9015;
        public static final int EVENT_AVOID_TRAFFIC_SWITCH_SUCCESS = 9014;
        public static final int EVENT_AVOID_TRAFFIC_TIPS = 9011;
        public static final int EVENT_GPS_DISMISS = 9006;
        public static final int EVENT_GPS_LOCATED = 9005;
        public static final int EVENT_NAVIGATING_STATE_BEGIN = 9003;
        public static final int EVENT_NAVIGATING_STATE_END = 9004;
        public static final int EVENT_ROUTEPLAN_BEGIN = 9007;
        public static final int EVENT_ROUTEPLAN_END = 9008;
        public static final int EVENT_ROUTEPLAN_FAILED = 9010;
        public static final int EVENT_ROUTEPLAN_SUCCESS = 9009;
        public static final int NAVI_EVENT_MSG_BASE = 9000;
        public static final int RASTERMAPTYPE_DERECTBOARD = 9001;
        public static final int RASTERMAPTYPE_GRID = 9002;

        void onOtherAction(int i, int i2, int i3, Object obj);

        void onRasterMapHide();

        void onRasterMapShow(int i, Bitmap bitmap, Bitmap bitmap2);

        void onRasterMapUpdate(String str, int i, String str2);

        void onRemainDistanceUpdate(CharSequence charSequence, Drawable drawable);

        void onRemainTimeUpdate(CharSequence charSequence, Drawable drawable);

        void onRoadNameUpdate(String str);

        void onRoadTurnInfoDistanceUpdate(CharSequence charSequence);

        void onRoadTurnInfoIconUpdate(Drawable drawable);

        void onSatelliteNumUpdate(int i, Drawable drawable);
    }

    public class NaviMapMode {
        public static final int BASE_LAYERS_CLOSED = 100;
        public static final int CRUISE = 3;
        public static final int FINISH = 4;
        public static final int NORMAL = 1;
        public static final int ROUTE = 5;
        public static final int SLIGHT = 2;
        public static final int TOTAL = 6;
        public static final int UNDEFINE = 0;
    }

    public class NaviMode {
        public static final int NE_NAVI_MODE_DRIVING_CAR = 3;
        public static final int NE_NAVI_MODE_INVALID = 0;
        public static final int NE_NAVI_MODE_NORMAL = 1;
        public static final int NE_NAVI_MODE_SLIGHT = 2;
    }

    public interface RPEntry {
        public static final int MAP_PAGE_PRE_CALC = 31;
        public static final int ROUTE_PLAN_ENTRY_CHANGE_PREFER = 24;
        public static final int ROUTE_PLAN_ENTRY_CHANGE_VIA_NODE = 25;
        public static final int ROUTE_PLAN_ENTRY_COMPANY = 21;
        public static final int ROUTE_PLAN_ENTRY_CRASH_RESTORE = 22;
        public static final int ROUTE_PLAN_ENTRY_DK_NAVI = 5;
        public static final int ROUTE_PLAN_ENTRY_DK_ROUTE = 6;
        public static final int ROUTE_PLAN_ENTRY_FROM_OPENAPI = 35;
        public static final int ROUTE_PLAN_ENTRY_FROM_VOICE = 34;
        public static final int ROUTE_PLAN_ENTRY_HOME = 20;
        public static final int ROUTE_PLAN_ENTRY_INNAVI = 2;
        public static final int ROUTE_PLAN_ENTRY_IPO_NO_LOADING = 16;
        public static final int ROUTE_PLAN_ENTRY_MSR_FAIL_FULL = 28;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_NAVI = 3;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_NAVI_COMPONENT = 13;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_NAVI_SELECT_ROUTE = 9;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_NAVI_TAB = 13;
        public static final int ROUTE_PLAN_ENTRY_OFFLINE2ONLINE = 27;
        public static final int ROUTE_PLAN_ENTRY_OPENAPI = 7;
        public static final int ROUTE_PLAN_ENTRY_OTHER = 29;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_OUTNAVI = 1;
        public static final int ROUTE_PLAN_ENTRY_PBDATA = 8;
        public static final int ROUTE_PLAN_ENTRY_PIECE_FAIL_RETRY = 26;
        public static final int ROUTE_PLAN_ENTRY_PROFESSION_SHORTCUT = 15;
        public static final int ROUTE_PLAN_ENTRY_REFRESH_ICON = 23;
        public static final int ROUTE_PLAN_ENTRY_ROUTE = 4;
        public static final int ROUTE_PLAN_ENTRY_ROUTE_CAR_HIS = 33;
        public static final int ROUTE_PLAN_ENTRY_ROUTE_SELECT_ROUTE = 10;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_ROUTE_TAB = 11;
        @Deprecated
        public static final int ROUTE_PLAN_ENTRY_SHORTCUT = 12;
        public static final int ROUTE_PLAN_TRAVLE_ASSIST = 30;
        public static final int USE_THE_CAR = 32;
    }

    public interface RouteDataMode {
        public static final int Inner = 0;
        public static final int RoutePB = 2;
        public static final int WholePB = 1;
    }

    public interface RouteInfoStatus {
        public static final int Route_All = 1;
        public static final int Route_Part = 2;
    }

    public interface RouteOutDataType {
        public static final int RoadCondition = 0;
        public static final int Route = 1;
    }

    public interface RoutePlanFailedSubType {
        public static final int ACTIVATE_NETWORK_UNCONNECTED = 2;
        public static final int CALC_ROUTE_FAILED = 8;
        public static final int LOC_INVALID = 9;
        public static final int NORMAL = 0;
        public static final int OFFLINE_AVOID_TAFFICJAM_ERROR = 11;
        public static final int ROUTEPLAN_AVOID_TRAFFICJAM_ERROR = 3;
        public static final int ROUTEPLAN_ON2OFF_NETWORK_ERROR = 4;
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_CANCEL = 1342177280;
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_FAIL = 37;
        public static final int ROUTEPLAN_RESULT_FAIL_DATA_LACK = -2147483632;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST1_DEVIATE = -2147483646;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST2_DEVIATE = -2147483645;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST3_DEVIATE = -2147483644;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST4_DEVIATE = -2147483643;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST5_DEVIATE = -2147483642;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_ERR = 805306368;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_TIME_OUT = -1879048192;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_NET_NO_DATA = -1879048191;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_START = 34;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_STOP = 35;
        public static final int ROUTEPLAN_RESULT_FAIL_PARSE_FAIL = 268435456;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_UNUSUAL = 16777216;
        public static final int ROUTEPLAN_RESULT_FAIL_START_DEVIATE = -2147483647;
        public static final int ROUTEPLAN_RESULT_FAIL_TOO_CLOSE = -2147483641;
        public static final int ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE = 536870912;
        public static final int ROUTEPLAN_RESULT_FAIL_WRONG_COORD = 36;
        public static final int ROUTEPLAN_RESULT_LOW_VERSION = 32;
        public static final int ROUTEPLAN_RESULT_WRONG_VERSION = 33;
        public static final int ROUTE_NODE_NOT_COMPLETE = 5;
        public static final int ROUTE_NODE_TOO_CLOSE = 10;
        public static final int SET_END_FAILED = 7;
        public static final int SET_START_FAILED = 6;
        public static final int SET_START_FAILED_FOR_APP_GUIDANCE_IS_NULL = 19;
        public static final int SET_START_FAILED_FOR_APP_START_IS_NULL = 20;
        public static final int SET_START_FAILED_FOR_ENGINE_HANDLE_IS_NULL = 16;
        public static final int SET_START_FAILED_FOR_ENGINE_RET_ERROR = 18;
        public static final int START_OR_DEST_INVALID = 1;
    }

    public interface RoutePlanKey {
        public static final String RoadCondition_PB_Data = "pb_data";
        public static final String Route_PB_Data = "pb_data";
        public static final String Route_Refresh_Reason = "route_refresh_reason";
    }

    public interface RoutePlanNetMode {
        public static final int NL_Net_Mode_Invalid = -1;
        public static final int NL_Net_Mode_OffLine = 0;
        public static final int NL_Net_Mode_OffLinePriority = 2;
        public static final int NL_Net_Mode_OnLine = 1;
        public static final int NL_Net_Mode_OnLinePriority = 3;
    }

    public interface RoutePlanStrategy {
        public static final int Force_Online_Priority = 1;
        public static final int User_Setting = 2;
    }

    public interface RoutePlanSuccessSubType {
        public static final int CityList = 0;
        public static final int PoiList = 1;
        public static final int Route = 2;
    }

    public interface RouteRefreshReason {
        public static final int Inner_refresh = 1;
        public static final int Outter_refresh = 0;
        public static final int Yaw_refresh = 2;
        public static final int other_refresh = 3;
    }

    public interface RouteSearchMode {
        public static final int By_Keyword = 1;
        public static final int By_Type = 0;
    }

    public interface SearchKey {
        public static final String Search_IS_LAST_PAGER = "IsLastPager";
        public static final String Search_PB_Data = "pb_data";
        public static final String Search_Route_Node_Type = "route_node_type";
        public static final String Search_Via_Route_Node_Index = "via_route_node_index";
    }

    public interface SearchRouteNodeType {
        public static final int End_Route_Node = 5;
        public static final int Start_Route_Node = 0;
        public static final int Via_1 = 1;
        public static final int Via_2 = 2;
        public static final int Via_3 = 3;
        public static final int Via_4 = 4;
    }

    public interface SearchSortType {
        public static final int Dist = 1;
        public static final int Heat = 3;
        public static final int TextMatch = 2;
    }

    public interface SearchSuccessSubType {
        public static final int CityList = 0;
        public static final int PoiList = 1;
    }

    public interface UgcEvent {
        public static final int EVENT_RESPORT_BTN_ClICK = 1;
        public static final int EVENT_UGC_MAPS_POINT_SELECTED = 3;
        public static final int EVENT_UGC_VIEW_FINISH = 2;
    }

    public interface VoiceEntry {
        public static final String MY = "mine";
        public static final String NAVI = "navi";
        public static final String OPENAPI = "openapi";
    }

    public interface VoiceKey {
        public static final String ACTION = "action";
        public static final String ENTRY = "entry";
        public static final String YPID = "ypid";
    }

    public interface VoiceMode {
        public static final int Novice = 0;
        public static final int Quite = 2;
        public static final int Veteran = 1;
    }
}
