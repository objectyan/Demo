package com.baidu.navisdk.comapi.routeplan;

import android.annotation.SuppressLint;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.subview.BNavR;

@SuppressLint({"ValidFragment"})
public class RoutePlanParams {
    public static final int ADD_VIA_MODE = 4;
    public static final String CALC_PREFERENCE = "calc_preference";
    public static final String CALC_PREF_CARINFOSTR = "calc_pref_carinfostr";
    public static final String CALC_PREF_CARNO = "calc_pref_carno";
    public static final String CALC_PREF_CAROILENUM = "calc_pref_caroilenum";
    public static final String CALC_PREF_CARSETURL = "calc_pref_carseturl";
    public static final String CLEAR_ROUTE_INFO = "clear_route_info";
    public static final String COUNTRY_OFFLINE_DATA = "全国基础包";
    public static final int DEFAULT_MODE = 0;
    public static final int GPS_SET_COUNT_DOWN_TIME = 3;
    public static final String KEY_HOUR = "hour";
    public static final String KEY_MINUTE = "minute";
    public static final String KEY_NAV_NODE = "nav_node";
    public static final String KEY_SETTING_MODE = "setting_mode";
    public static final String Key_RouteData_HasMrsl = "key_routedata_pb_hasmrsl";
    public static final String Key_RouteData_Mode = "key_routedata_mode";
    public static final String Key_RouteData_PB = "key_routedata_pb";
    public static final String Key_RouteData_PB_Len = "key_routedata_pb_len";
    public static final String Key_RouteData_mrsl = "key_routedata_pb_mrsl";
    public static final int MAX_WAY_POINT = 5;
    public static final int MIN_ROUTE_PLAN_DISTANCE = 50;
    public static final int MIN_WAY_POINT = 2;
    public static final String MY_LOCATION = "我的位置";
    public static final int NE_ROUTEDATA_COMFROM_INVAILD = 0;
    public static final int NE_ROUTEDATA_COMFROM_NAVITAB = 2;
    public static final int NE_ROUTEDATA_COMFROM_ONNAVI = 4;
    public static final int NE_ROUTEDATA_COMFROM_ROUTEDETAIL = 3;
    public static final int NE_ROUTEDATA_COMFROM_TOUTETAB = 1;
    public static final int ROUTE_PLAN_DATA_DOWNLOADED = 3;
    public static final int ROUTE_PLAN_LACK_DATA = 2;
    public static final int ROUTE_PLAN_NODE_ERROR = 1;
    public static final int ROUTE_PLAN_TOAST_FAIL_TOO_CLOSE = 4;
    public static final int SET_DEST_MODE = 3;
    public static final int SET_START_MODE = 1;
    public static final int SET_VIA_MODE = 2;
    public static final String TURN_TYPE_ID_END = "目的地";
    public static final String TURN_TYPE_ID_START = "起始地";
    public static final String TURN_TYPE_ID_VIA = "途经点";
    public static final int YAWING_ROUTE_PLAN_RESULT = 2;
    public static final int[] gTurnIconIDSmall = BNavR.gTurnIconID;
    public static final int[] mProvince = new int[]{C4048R.string.nsdk_string_route_plan_lack_data_0, C4048R.string.nsdk_string_route_plan_lack_data_1, C4048R.string.nsdk_string_route_plan_lack_data_2, C4048R.string.nsdk_string_route_plan_lack_data_3, C4048R.string.nsdk_string_route_plan_lack_data_4, C4048R.string.nsdk_string_route_plan_lack_data_5, C4048R.string.nsdk_string_route_plan_lack_data_6, C4048R.string.nsdk_string_route_plan_lack_data_7, C4048R.string.nsdk_string_route_plan_lack_data_8, C4048R.string.nsdk_string_route_plan_lack_data_9, C4048R.string.nsdk_string_route_plan_lack_data_10, C4048R.string.nsdk_string_route_plan_lack_data_11, C4048R.string.nsdk_string_route_plan_lack_data_12, C4048R.string.nsdk_string_route_plan_lack_data_13, C4048R.string.nsdk_string_route_plan_lack_data_14, C4048R.string.nsdk_string_route_plan_lack_data_15, C4048R.string.nsdk_string_route_plan_lack_data_16, C4048R.string.nsdk_string_route_plan_lack_data_17, C4048R.string.nsdk_string_route_plan_lack_data_18, C4048R.string.nsdk_string_route_plan_lack_data_19, C4048R.string.nsdk_string_route_plan_lack_data_20, C4048R.string.nsdk_string_route_plan_lack_data_21, C4048R.string.nsdk_string_route_plan_lack_data_22, C4048R.string.nsdk_string_route_plan_lack_data_23, C4048R.string.nsdk_string_route_plan_lack_data_24, C4048R.string.nsdk_string_route_plan_lack_data_25, C4048R.string.nsdk_string_route_plan_lack_data_26, C4048R.string.nsdk_string_route_plan_lack_data_27, C4048R.string.nsdk_string_route_plan_lack_data_28, C4048R.string.nsdk_string_route_plan_lack_data_29, C4048R.string.nsdk_string_route_plan_lack_data_30, C4048R.string.nsdk_string_route_plan_lack_data_31, C4048R.string.nsdk_string_route_plan_lack_data_32, C4048R.string.nsdk_string_route_plan_lack_data_33};

    public class Action {
        public static final int COMP_ADDR_ACTION = 5;
        public static final int HOME_ADDR_ACTION = 4;
        public static final int MY_LOCATION_ACTION = 3;
        public static final int PICK_FROM_MAP_ACTION = 2;
        public static final int ROUTE_PLAN_NODE_ACTION = 1;
        public static final int SEARCH_CENTER_ACTION = 6;
        public static final int UGC_PICK_LINK_FROM_ADD_ACTION = 7;
        public static final int UGC_PICK_LINK_FROM_DETAIL_ACTION = 8;
    }

    public class BN_RoutePlan_MSG {
        public static final int NE_RoutePlan_Driving_Car_POINT = 40;
        public static final int NE_RoutePlan_Driving_Car_ROUTE_REFRESH = 41;
        public static final int RC_SUCCESS_NORMAL = 5;
        public static final int RP_BEFORE_START = 8;
        public static final int RP_FAIL_BUILD = 34;
        public static final int RP_FAIL_BUILD_AUTO = 49;
        public static final int RP_FAIL_NORMAL = 7;
        public static final int RP_FAIL_OVERTIME = 36;
        public static final int RP_FAIL_YAWING = 6;
        public static final int RP_IPO_SUCCESS_FAIL = 38;
        public static final int RP_IPO_SUCCESS_NORMAL = 37;
        public static final int RP_MAP_KEYWORD_RESULT = 35;
        public static final int RP_PROCCESS_CANCLE = 32;
        public static final int RP_START_BUILD = 48;
        public static final int RP_SUCCESS_BUILD = 33;
        public static final int RP_SUCCESS_NORMAL = 4;
        public static final int RP_SUCCESS_OFF2ON = 2;
        public static final int RP_SUCCESS_ON2OFF = 1;
        public static final int RP_SUCCESS_SELECT_ROUTE = 39;
        public static final int RP_SUCCESS_YAWING = 3;
    }

    public class BundleKey {
        public static final String FROM_FRAGMENT = "from_Fragment";
        public static final String SELECT_POINT_ACTION = "select_point_action";
        public static final String UGC_MAP_POINT_TYPE = "UGC_MAP_POINT_TYPE";
        public static final String UGC_MAP_POINT_X = "UGC_MAP_POINT_X";
        public static final String UGC_MAP_POINT_Y = "UGC_MAP_POINT_Y";
        public static final String UGC_MAP_ROAD_NAME = "UGC_MAP_ROAD_NAME";
        public static final String UGC_MAP_SYNC_STATUS = "UGC_MAP_SYNC_STATUS";
    }

    public static class GuideEndSceneType {
        public static final int TYPE_GUIDE_END_SCENE_ADD_VIA = 1;
        public static final int TYPE_GUIDE_END_SCENE_NORMAL = 0;
        public static final int TYPE_GUIDE_END_SCENE_SELECT_PARK = 2;
    }

    public static class GuideSceneType {
        public static final int TYPE_GUIDE_SCENE_GUIDE_END = 2;
        public static final int TYPE_GUIDE_SCENE_NAVING_RECOMMEND_PARK = 4;
        public static final int TYPE_GUIDE_SCENE_NORMAL = 1;
        public static final int TYPE_GUIDE_SCENE_OTHER_ROUTE = 5;
        public static final int TYPE_GUIDE_SCENE_YAWWING = 3;
    }

    public class NE_GPS_State_Enum {
        public static final int NE_GPS_State_Close = 0;
        public static final int NE_GPS_State_Fixed = 1;
        public static final int NE_GPS_State_NoFixed = 2;
    }

    public interface NE_Navi_Mode_Enum {
        public static final int NE_Navi_Mode_Invalid = 0;
        public static final int NE_Navi_Mode_Normal = 1;
        public static final int NE_Navi_Mode_Slight = 2;
    }

    public interface NE_Navi_Type_Enum {
        public static final int NE_Navi_Mode_InternationalNoNavi = 2;
        public static final int NE_Navi_Type_China = 0;
        public static final int NE_Navi_Type_InternationalHasNavi = 1;
    }

    public interface NE_RouteData_Comfrom_Enum {
        public static final int NE_RouteData_Comfrom_Invaild = 0;
        public static final int NE_RouteData_Comfrom_MapPagePreCalc = 21;
        public static final int NE_RouteData_Comfrom_PoiPageGoHereTab = 12;
        public static final int NE_RouteData_Comfrom_PreCalc2Cars = 22;
        public static final int NE_RouteData_Comfrom_PreCalc2Navi = 23;
        public static final int NE_RouteData_Comfrom_RefRouteByAtjVoice = 25;
        public static final int NE_RouteData_Comfrom_RefRouteByFastRouteVoice = 26;
        public static final int NE_RouteData_Comfrom_UpdateRouteOnButton = 28;
        public static final int NE_RouteData_Comfrom_UpdateRouteOnDetailPanel = 27;
    }

    public class NE_RouteData_Mode_Enum {
        public static final int NE_RouteData_Mode_Inner = 0;
        public static final int NE_RouteData_Mode_Outer_RoutePB = 2;
        public static final int NE_RouteData_Mode_Outer_WholePB = 1;
    }

    public interface NE_RoutePlan_Cars_Data_Type_Enum {
        public static final int NE_RoutePlan_Cars_Data_Type_All = 1;
        public static final int NE_RoutePlan_Cars_Data_Type_LongDistance = 2;
        public static final int NE_RoutePlan_Cars_Data_Type_RoadCondition = 4;
        public static final int NE_RoutePlan_Cars_Data_Type_UI = 0;
        public static final int NE_RoutePlan_Cars_Data_Type_YellowTipList = 3;
    }

    public class NE_RoutePlan_Preference {
        public static final int ROUTE_PLAN_PREFERENCE_AVOID_TRAFFIC_JAM = 16;
        public static final int ROUTE_PLAN_PREFERENCE_CAR_NUM = 32;
        public static final int ROUTE_PLAN_PREFERENCE_DEFAULT = 1;
        public static final int ROUTE_PLAN_PREFERENCE_DISTANCE_FIRST = 128;
        public static final int ROUTE_PLAN_PREFERENCE_INVALID = 0;
        public static final int ROUTE_PLAN_PREFERENCE_NOTOLL = 8;
        public static final int ROUTE_PLAN_PREFERENCE_ROAD_FIRST = 512;
        public static final int ROUTE_PLAN_PREFERENCE_TIME_FIRST = 256;
    }

    public class NE_RoutePlan_Result {
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_CANCEL = 406;
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_FAIL = 423;
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_GUIDE_INFO = 501;
        public static final int ROUTEPLAN_RESULT_FAIL_CALC_GUIDE_INFO_NET = 502;
        public static final int ROUTEPLAN_RESULT_FAIL_DATA_LACK = 420;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST1_DEVIATE = 414;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST1_IN_CLOUD_CONTROL = 408;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST2_DEVIATE = 415;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST2_IN_CLOUD_CONTROL = 409;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST3_DEVIATE = 416;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST3_IN_CLOUD_CONTROL = 410;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST4_DEVIATE = 417;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST4_IN_CLOUD_CONTROL = 411;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST5_DEVIATE = 418;
        public static final int ROUTEPLAN_RESULT_FAIL_DEST5_IN_CLOUD_CONTROL = 412;
        public static final int ROUTEPLAN_RESULT_FAIL_LOW_VERSION = 400;
        public static final int ROUTEPLAN_RESULT_FAIL_MAIN_SLAVE_VIADUCT_INFO = 21;
        public static final int ROUTEPLAN_RESULT_FAIL_NETWORK_ERROR = 450;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_CONNECT = 106;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_GET = 105;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_OTHER = 109;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_SEND = 107;
        public static final int ROUTEPLAN_RESULT_FAIL_NET_TIME_OUT = 108;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_NET_NO_DATA = 421;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_START = 402;
        public static final int ROUTEPLAN_RESULT_FAIL_NO_STOP = 403;
        public static final int ROUTEPLAN_RESULT_FAIL_OFFLINE_CALC_PARAM = 422;
        public static final int ROUTEPLAN_RESULT_FAIL_ONLYRC = 503;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_DATA_ERROR = 301;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_MAP_DATA_ERROR = 305;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_MAP_HANDLE_NULL = 304;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_PARSE_MEMORY = 303;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_PARSE_ROUTE = 302;
        public static final int ROUTEPLAN_RESULT_FAIL_PB_UNSERIALIZE = 300;
        public static final int ROUTEPLAN_RESULT_FAIL_REQUEST_TIMEOUT_INGUIDE = 500;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_NODATA = 206;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_PHP = 203;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_QT = 205;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_REQPARAM = 201;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_RET = 202;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_SIGN = 200;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_SILM = 204;
        public static final int ROUTEPLAN_RESULT_FAIL_SERVER_TYPE = 207;
        public static final int ROUTEPLAN_RESULT_FAIL_START_DEVIATE = 413;
        public static final int ROUTEPLAN_RESULT_FAIL_START_IN_CLOUD_CONTROL = 407;
        public static final int ROUTEPLAN_RESULT_FAIL_TOO_CLOSE = 419;
        public static final int ROUTEPLAN_RESULT_FAIL_URL_MEMORY = 100;
        public static final int ROUTEPLAN_RESULT_FAIL_URL_ROUTE = 101;
        public static final int ROUTEPLAN_RESULT_FAIL_URL_SIGN = 102;
        public static final int ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE = 405;
        public static final int ROUTEPLAN_RESULT_FAIL_WRONG_COORD = 404;
        public static final int ROUTEPLAN_RESULT_FAIL_WRONG_VERSION = 401;
        public static final int ROUTEPLAN_RESULT_FAIL_district_ERROR = 9000;
        public static final int ROUTEPLAN_RESULT_SUCCESS = 0;
        public static final int ROUTEPLAN_RESULT_SUCCESS_MAIN_SLAVE_VIADUCT_INFO = 20;
        public static final int ROUTEPLAN_RESULT_SUCCESS_ONLY_RC = 9;
    }

    public class NE_RoutePlan_Source_Enum {
        public static final int NE_RoutePlan_Source_InNavi = 0;
        public static final int NE_RoutePlan_Source_Invaild = -1;
        public static final int NE_RoutePlan_Source_OutNavi = 1;
    }

    public class NE_RoutePlan_Sub_Result {
        public static final int NE_ROUTEPLAN_SUBRESULT_INVALID = 0;
        public static final int NE_ROUTEPLAN_SUBRESULT_OFFTOONLINE = 2;
        public static final int NE_ROUTEPLAN_SUBRESULT_ONTOOFFLINE = 1;
    }

    public static class NE_UI_RoutePlan_SourceType_Enmu {
        public static final int GROUND_ROUTE_PLAN_RESULT = 6;
        public static final int MAIN_ROUTE_PLAN_RESULT = 4;
        public static final int SLAVE_ROUTE_PLAN_RESULT = 3;
        public static final int UNKNOWN_ROUTE_PLAN_RESULT = 7;
        public static final int VIADUCT_ROUTE_PLAN_RESULT = 5;
    }

    public class PickPointType {
        public static final int PICK_END_POINT = 2;
        public static final int PICK_POINT_INVALID = -1;
        public static final int PICK_START_POINT = 0;
        public static final int PICK_VIA_POINT = 1;
    }

    public interface RouteOutDataType {
        public static final int RoadCondition = 0;
        public static final int Route = 1;
    }
}
