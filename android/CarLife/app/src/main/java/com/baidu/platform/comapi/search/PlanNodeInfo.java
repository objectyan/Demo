package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;

public class PlanNodeInfo {
    public int bWanda;
    public String buildingId = null;
    public String cityID;
    public String extra = null;
    public String floorId = null;
    public String keyword = null;
    public Point pt = null;
    public String rgcName = null;
    public int subNodeType = -1;
    public SuggestionHistoryInfo sugInfo = null;
    public String treasureIconUrl;
    public int type = 2;
    public String uid = null;

    public static class PlanNodeType {
        public static final int NODE_TYPE_COMPANY = 5;
        public static final int NODE_TYPE_HOME = 4;
        public static final int NODE_TYPE_MY_LOCATION = 3;
        public static final int NodeTypeKeyword = 2;
        public static final int NodeTypeLocation = 1;
        public static final int NodeTypeUid = 0;
    }
}
