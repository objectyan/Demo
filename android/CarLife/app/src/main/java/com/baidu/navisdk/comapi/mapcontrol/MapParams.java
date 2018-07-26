package com.baidu.navisdk.comapi.mapcontrol;

public class MapParams {

    public class Action {
    }

    public class Config {
    }

    public class Const {
        public static final int DEFAULT_LOCATED_SCALE_LEVEL = 14;
        public static final int DEFAULT_MAP_LOACTE_LATITUDE = 3945000;
        public static final int DEFAULT_MAP_LOACTE_LONGITUDE = 10856000;
        public static final int DEFAULT_NOT_LOCATED_SCALE_LEVEL = 3;
        public static final int DEFAULT_PICKPOINT_SCALE_LEVEL = 14;
        public static final int DEFAULT_POI_DETAIL_SCALE_LEVEL = 17;
        public static final String DISCOUNT = "discount";
        public static final String DISCOUNT_TITLE = "discount_title";
        public static final String D_DATA_TYPE = "d_data_type";
        public static final int MAPSTATUS_ANIMATION_TIME = 300;
        public static final int MAP_STATE_ENTER_NAV_PAGE_LEVEL = -2;
        public static final int MAP_STATE_INVALID_LEVEL = -1;
        public static final int MAX_MERCATOR_X = 20037508;
        public static final int MAX_MERCATOR_Y = 20037508;
        public static final int MAX_WAITING_LOCATION_TIMESPAN = 15000;
        public static final int MAX_ZOOM_LEVEL = 20;
        public static final int MIN_MERCATOR_X = -20037508;
        public static final int MIN_MERCATOR_Y = -20037508;
        public static final int MIN_ZOOM_LEVEL = 3;
        public static final int NAV_DEFAULT_AUTO_SCALE_LEVEL = 19;
        public static final int NAV_DEFAULT_SCALE_LEVEL_GUIDE = 18;
        public static final int NAV_MAX_SCALE_LEVEL_GUIDE = 19;
        public static final int NAV_MIN_SCALE_LEVEL_GUIDE = 15;
        public static final String SRC_NAME = "src_name";

        public class LayerMode {
            public static final int MAP_LAYER_MODE_BROWSE_MAP = 0;
            public static final int MAP_LAYER_MODE_CRUISE = 7;
            public static final int MAP_LAYER_MODE_INVALID = -1;
            public static final int MAP_LAYER_MODE_PICK_POINT = 4;
            public static final int MAP_LAYER_MODE_POIPKG = 2;
            public static final int MAP_LAYER_MODE_POI_DETAIL = 1;
            public static final int MAP_LAYER_MODE_RC_CALC_FAILED = 9;
            public static final int MAP_LAYER_MODE_ROUTE_DETAIL = 5;
            public static final int MAP_LAYER_MODE_ROUTE_DETAIL_FOR_NAVI = 6;
            public static final int MAP_LAYER_MODE_ROUTE_GUIDE = 3;
            public static final int MAP_LAYER_MODE_TRACK = 8;
            public static final int MAP_LAYER_MODE_UGC_ADD_SELECT_LINK = 12;
            public static final int MAP_LAYER_MODE_UGC_MAP_POP_UP = 10;
            public static final int MAP_LAYER_MODE_UGC_YAW_POP_UP = 11;
        }

        public class LayerTag {
            public static final String COMPASS_LAYER_TAG = "compass";
            public static final String DEFAULT_LAYER_TAG = "default";
            public static final String ITEM_LAYER_TAG = "item";
            public static final String ITSROUTE_LAYER_TAG = "itsroute";
            public static final String LOCATION_LAYER_TAG = "location";
            public static final String POPUP_LAYER_TAG = "popup";
            public static final String SHARELOCATION_BUBBLE = "smshare";
            public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
        }

        public class LocationMode {
            public static final int MAP_LOC_MODE_CLOSED = 3;
            public static final int MAP_LOC_MODE_DIR = 2;
            public static final int MAP_LOC_MODE_FIXED = 1;
            public static final int MAP_LOC_MODE_INVALID = 4;
            public static final int MAP_LOC_MODE_NEXT = -1;
            public static final int MAP_LOC_MODE_NORMAL = 0;
        }

        public class MapStyleMode {
            public static final int MAP_STYLE_TYPE_DEFAULT = 1;
            public static final int MAP_STYLE_TYPE_MAP_DAY = 2;
            public static final int MAP_STYLE_TYPE_MAP_NIGHT = 3;
            public static final int MAP_STYLE_TYPE_NAV_DAY = 4;
            public static final int MAP_STYLE_TYPE_NAV_IPO_DAY = 8;
            public static final int MAP_STYLE_TYPE_NAV_IPO_LOCK_DAY = 10;
            public static final int MAP_STYLE_TYPE_NAV_IPO_LOCK_NIGHT = 11;
            public static final int MAP_STYLE_TYPE_NAV_IPO_NIGHT = 9;
            public static final int MAP_STYLE_TYPE_NAV_NIGHT = 5;
            public static final int MAP_STYLE_TYPE_NAV_SMALL_SCREEN_DAY = 12;
            public static final int MAP_STYLE_TYPE_NAV_SMALL_SCREEN_NIGHT = 13;
            public static final int MAP_STYLE_TYPE_VIEWALL_DAY = 6;
            public static final int MAP_STYLE_TYPE_VIEWALL_NIGHT = 7;
        }

        public class NodeType {
            public static final int BACKGMARK = 17;
            public static final int BUSLINE = 11;
            public static final int BUSLINE_STOP = 23;
            public static final int BUSSTATION = 9;
            public static final int COMPASS = 19;
            public static final int END = 2;
            public static final int E_STREET_ARROW = 1235;
            public static final int E_STREET_INTER_POI = 1236;
            public static final int E_STREET_POI = 1234;
            public static final int FAVMARK = 7;
            public static final int FAVORITEPOI = 6;
            public static final int INDOORMAPPOI = 24;
            public static final int ITS_EVENT = 22;
            public static final int LOCATION = 18;
            public static final int NONE = 26;
            public static final int OPENAPI_DETAIL = 102;
            public static final int OPENAPI_MARK_POI = 103;
            public static final int POI = 3;
            public static final int POIADDR = 13;
            public static final int POIBKG = 4;
            public static final int POIRGC = 14;
            public static final int POIRGCSHARE = 15;
            public static final int POISHARE = 16;
            public static final int REGEO = 101;
            public static final int ROUTE_NODE = 8;
            public static final int ROUTE_TIP_NODE = 21;
            public static final int SEARCH_CENTER = 5;
            public static final int SHARELOCATION = 25;
            public static final int START = 1;
            public static final int STREETPOPUP = 20;
            public static final int TRAINLINE = 12;
            public static final int TRAINSTATION = 10;
        }

        public class UpdateType {
            public static final int ECOMPULSORY_UPDATE = 1;
            public static final int EUPDATE_MAPSTATUSCHANGE = 2;
            public static final int EUPDATE_MAPSTATUSCHANGELATER = 4;
            public static final int EUPDATE_NONE = 0;
            public static final int EUPDATE_TIMERESCAP = 8;
        }
    }

    public class Key {
    }

    public class LightNaviScreenType {
        public static final int ADDRESS_TYPE = 1;
        public static final int LOCK_TYPE = 2;
        public static final int UGC_TYPE = 4;
    }

    public class MapClickEventType {
        public static final int NE_Map_ClickEventType_Invalid = 0;
        public static final int NE_Map_ClickEventType_OverSpeed = 4;
        public static final int NE_Map_ClickEventType_UrgentAcc = 1;
        public static final int NE_Map_ClickEventType_UrgentDec = 2;
        public static final int NE_Map_ClickEventType_UrgentTurn = 3;
    }

    public class MapCommandType {
        public static final int NE_MAP_COMMAND_TYPE_INVALID = 0;
        public static final int NE_MAP_COMMAND_TYPE_NAVIEND = 1;
        public static final int NE_Map_Command_Type_EndCruise = 3;
        public static final int NE_Map_Command_Type_EndWaySearch = 6;
        public static final int NE_Map_Command_Type_RecoveryNavi = 4;
        public static final int NE_Map_Command_Type_StartCruise = 2;
        public static final int NE_Map_Command_Type_StartWaySearch = 5;
    }

    public class NaviMapMode {
        public static final int CRUISE = 3;
        public static final int FINISH = 4;
        public static final int NORMAL = 1;
        public static final int ROUTE = 5;
        public static final int SLIGHT = 2;
        public static final int TOTAL = 6;
        public static final int UNDEFINE = 0;
    }
}
