package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class SearchByKeywordDataStruct extends DataStruct {
    public static final String KEY_DISTRICT_ID = "districtId";
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_POI_LIST = "poiList";
    public int districtId;
    public String keyword;

    public SearchByKeywordDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_SEARCH_BY_KEYWORD;
    }
}
