package com.baidu.navisdk.comapi.userdata;

public class FavoriteParams {

    public class Action {
        public static final int FAVORITE_ACTION_DELETE_ADD = 2;
        public static final int FAVORITE_ACTION_MODIFIED_HOME_CORP = 3;
        public static final int FAVORITE_ACTION_RENAME = 1;
    }

    public class Const {
        public static final int FAVORITE_POI_MAX_SUM = 500;
        public static final int FAV_ADD_DUPLICATE_OR_NULL = -1;
        public static final int FAV_ADD_FAILED = 0;
        public static final int FAV_ADD_FULL = -2;
        public static final int FAV_ADD_SUCCESS = 1;
        public static final int FAV_DELETE_FAILED = -1;
        public static final int FAV_DELETE_SUCCESS = 0;
        public static final int FAV_RENAME_DUPLICATE = -1;
        public static final int FAV_RENAME_FAILED = 0;
        public static final int FAV_RENAME_SUCCESS = 1;
        public static final int FAV_SYNC_FAILED = -1;
        public static final int FAV_SYNC_FULL = -2;
        public static final int FAV_SYNC_SUCCESS = 0;
    }

    public class FavPOISyncSubMsgType {
        public static final int FAV_SYNC_BDUSS = 203;
        public static final int FAV_SYNC_FAILED = 204;
        public static final int FAV_SYNC_FULL = 201;
        public static final int FAV_SYNC_RELOGIN = 202;
        public static final int FAV_SYNC_SUCCESS = 200;
    }

    public class FavPOSortType {
        public static final int FAV_POI_SORT_TYPE_NAME = 1;
        public static final int FAV_POI_SORT_TYPE_NONE = 0;
        public static final int FAV_POI_SORT_TYPE_TIME = 2;
    }

    public class FavoritePoiType {
        public static final int TYPE_FAVORITE_POI_ALL = 3;
        public static final int TYPE_FAVORITE_POI_CAMERA = 2;
        public static final int TYPE_FAVORITE_POI_INVALID = 0;
        public static final int TYPE_FAVORITE_POI_OTHER = 1;
    }

    public class Key {
        public static final String FAVORITE_ACTION_KEY = "fav_action_key";
        public static final String PREF_CURRENT_USERNAME = "PREF_CURRENT_USERNAME";
        public static final String PREF_HAS_FAVORITE_OLD_DATA_FROM_2_1_SYNC = "PREF_HAS_FAVORITE_OLD_DATA_FROM_2_1_SYNC";
        public static final String PREF_HAS_FAVORITE_OLD_DATA_SYNC = "PREF_HAS_FAVORITE_OLD_DATA_SYNC";
        public static final String SP_SORT_TYPE_PRE_KEY = "sp_sort_type_prefer_key";
    }
}
