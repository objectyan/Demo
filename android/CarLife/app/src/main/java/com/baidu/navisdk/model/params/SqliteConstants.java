package com.baidu.navisdk.model.params;

import android.provider.BaseColumns;

public class SqliteConstants {
    public static final String DATABASE_NAME = "navi.db";
    public static final int DATABASE_VERSION = 3;

    public static final class ContinueNaviNodes implements BaseColumns {
        public static final String DESCRIPTION = "description";
        public static final String FROM = "is_from";
        public static final String NAME = "name";
        public static final String POINT_LATITUDE = "latitude";
        public static final String POINT_LONGITUDE = "longitude";
        public static final String POI_ORIGIN_UID = "poi_origin_uid";
        public static final String TABLE_NAME = "continue_navi_nodes";
    }

    public static final class NaviNode implements BaseColumns {
        public static final String COLUMNS_NODE_NAME = "node_name";
        public static final String TABLE_NAME = "navi_node";
    }

    public static final class RoutePlanHistory implements BaseColumns {
        public static final String DESCRIPTION = "description";
        public static final String FROM = "is_from";
        public static final String NAME = "name";
        public static final String POINT_LATITUDE = "latitude";
        public static final String POINT_LONGITUDE = "longitude";
        public static final String POI_ORIGIN_UID = "poi_origin_uid";
        public static final String TABLE_NAME = "route_plan_history";
    }

    public static final class SearchHistory implements BaseColumns {
        public static final String CALLED_COUNT = "called_count";
        public static final String INPUT_STRING = "input_string";
        public static final String TABLE_NAME = "search_history";
    }
}
