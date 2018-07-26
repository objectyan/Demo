package com.baidu.navisdk;

public class CommonParams {
    public static final double BJ_LATITUDE = 39.92d;
    public static final double BJ_LONGITUDE = 116.46d;
    public static final int INVALID_LOCATION = -1;
    public static final String KEY_CLOSE_TIPS = "close_tips";
    public static final int NAVI_ANIMATION_TIME = 300;
    public static final int NET_MOD_OFFLINE = 0;
    public static final String PREFERENCES = "navi";
    public static final String PRODUCT_NAME = "baidu-navi";
    public static final String PRODUCT_NAME_SDK_FOR_MAP = "baiduNavi_SDK_FOR_Map";
    public static final int SUB_SYS_TOTAL = 9;
    public static final int SUB_SYS_TYPE_DATA_MANAGER = 3;
    public static final int SUB_SYS_TYPE_FAVORITE = 4;
    public static final int SUB_SYS_TYPE_GUIDANCE = 1;
    public static final int SUB_SYS_TYPE_MAP = 0;
    public static final int SUB_SYS_TYPE_SEARCH = 2;
    public static final int SUB_SYS_TYPE_STATISTICS = 6;
    public static final int SUB_SYS_TYPE_TRAJECTORY = 5;
    public static final int SUB_SYS_TYPE_VOICE_COMMAND = 7;
    public static final int SUB_SYS_TYPE_VOICE_TTS = 8;

    public class Action {
    }

    public class Config {
    }

    public class Const {
        public static final String WEBVIEW_HOME_PAGE = "WEBVIEW_HOME_PAGE";
        public static final String WEBVIEW_TITLE = "WEBVIEW_TITLE";

        public class ModelName {
            public static final String COMMON_TOOL = "CommonToolModel";
            public static final String OFFLINE_DATA = "OfflineDataModel";
            public static final String POI_SEARCH = "PoiSearchModel";
            public static final String ROUTE_GUIDE = "RouteGuideModel";
            public static final String ROUTE_PLAN = "RoutePlanModel";
        }

        public class ModuleName {
            public static final String ASR = "ASR";
            public static final String COMMON = "Common";
            public static final String CRUISE = "Cruise";
            public static final String FAVORITE = "Favorite";
            public static final String FRAMEWORK = "Framework";
            public static final String GUIDE_INFO = "guide_info";
            public static final String HIGHTWAY = "Highway";
            public static final String LOCATION = "Location";
            public static final String MAP = "Map";
            public static final String OFFLINEDATA = "OffineData";
            public static final String POISEARCH = "PoiSearch";
            public static final String ROUTEGUIDE = "RouteGuide";
            public static final String ROUTEPLAN = "RoutePlan";
            public static final String RouteGuideAR = "AR";
            public static final String RouteGuideHUD = "HUD";
            public static final String STREETSCAPE = "Streetscape";
            public static final String TRAFFIC = "Traffic";
            public static final String TRAJECTORY = "Trajectory";
            public static final String TTS = "TTS";
            public static final String XDVoice = "XDVoice";
        }
    }

    public class DEVICE_TYPE {
        public static final int DEVICE_TYPE_BLUETOOTH = 0;
        public static final int DEVICE_TYPE_USB = 1;
    }

    public class Key {
        public static final String BUNDLE_ROOT_PAGE_TYPE = "root_page_type";
        public static final String IS_FIRST_ENTER_IPO_HOME = "is_first_enter_ipo_home";
        public static final String NAVI_UPDATE_APK_NOT_ALERT = "NAVI_UPDATE_APK_NOT_ALERT";
        public static final String NAVI_UPDATE_APK_VERSION = "NAVI_UPDATE_APK_VERSION";
        public static final String SP_COMMON_CHOOSED_SDCARD_PATH = "SP_COMMON_CHOOSED_SDCARD_PATH";
        public static final String SP_KEY_CARNET_CONNECTED = "carnet.connected";
        public static final String SP_KEY_FIRST_BOOT = "SP_KEY_FIRST_BOOT";
        public static final String SP_KEY_FIRST_INIT_FOR_LINKID = "SP_KEY_FIRST_INIT_FOR_LINKID";
        public static final String SP_KEY_HOME_CARD_ORDER = "SP_KEY_HOME_CARD_ORDER";
        public static final String SP_KEY_SCREEN_KEEP_ON = "SP_KEY_SCREEN_KEEP_ON";
        public static final String SP_KEY_SHOW_DISCLAIMER = "SP_KEY_SHOW_DISCLAIMER";
        public static final String SP_KEY_SHOW_TOAST_FOR_LINKID = "SP_KEY_SHOW_TOAST_FOR_LINKID";
        public static final String SP_KEY_XIAODU_HELP = "SP_KEY_XIAODU_HELP";
    }

    public class NE_COORDSYS_CHANGE_TYPE {
        public static final int NE_BDLL2GCJLL_TYPE = 8;
        public static final int NE_BDLL2WGSLL_TYPE = 6;
        public static final int NE_BDMC2GCJLL_TYPE = 2;
        public static final int NE_BDMC2WGSLL_TYPE = 0;
        public static final int NE_GCJLL2BDLL_TYPE = 9;
        public static final int NE_GCJLL2BDMC_TYPE = 3;
        public static final int NE_GCJLL2WGSLL_TYPE = 5;
        public static final int NE_WGSLL2BDLL_TYPE = 7;
        public static final int NE_WGSLL2BDMC_TYPE = 1;
        public static final int NE_WGSLL2GCJLL_TYPE = 4;
    }

    public class NE_NetStatus {
        public static final int NET_STATUS_INVALID = 0;
        public static final int NET_STATUS_NO_NET = 1;
        public static final int NET_STATUS_WIFI_NET = 2;
        public static final int NET_STATUS_WWAN_NET = 3;
    }

    public class NL_Guidance_Net_Mode_Enum {
        public static final int NL_Guidance_Net_Mode_Invalid = 0;
        public static final int NL_Guidance_Net_Mode_OffLine = 1;
        public static final int NL_Guidance_Net_Mode_OffLinePriority = 3;
        public static final int NL_Guidance_Net_Mode_OnLine = 2;
        public static final int NL_Guidance_Net_Mode_OnLinePriority = 4;
    }

    public class NL_Net_Mode {
        public static final int NL_Net_Mode_Invalid = -1;
        public static final int NL_Net_Mode_OffLine = 0;
        public static final int NL_Net_Mode_OffLinePriority = 2;
        public static final int NL_Net_Mode_OnLine = 1;
        public static final int NL_Net_Mode_OnLinePriority = 3;
    }

    public class NL_Ret_Enum {
        public static final int NL_Ret_Activate_Fail = 2;
        public static final int NL_Ret_Data_Format_Error = 3;
        public static final int NL_Ret_Fail = 1;
        public static final int NL_Ret_Invalid = -1;
        public static final int NL_Ret_None = -100;
        public static final int NL_Ret_Success = 0;
    }

    public enum NaviStatus {
        NAVI_MAP_BROWSE_MODE,
        NAVI_ROUTE_PLAN_COMPLETE,
        NAVI_ROUTE_DETAIL_MODE,
        NAVI_GPS_GUIDANCE,
        NAVI_ANALOG_GUIDANCE,
        NAVI_GPS_GUIDE_BROWSE_MODE,
        NAVI_ANALOG_GUIDE_BROWSE_MODE,
        NAVI_PICK_POINT,
        SEARCH_BY_CYCLE_OVERVIEW,
        NAVI_MAP_POI_MODE,
        NAVI_MAP_TRACK_MODE
    }

    public class NetConnectStatus {
        public static final int NetStatusInvalid = 0;
        public static final int NetStatusNoNet = 1;
        public static final int NetStatusWIFINet = 2;
        public static final int NetStatusWWANNet = 3;
    }

    public class PAGE_TYPE {
        public static final int BN_RG_DETAIL_PAGE = 1;
        public static final int BN_RG_NAVING_PAGE = 2;
        public static final int BN_SEARCH_RESULT_PAGE = 0;
    }
}
