package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class KeywordSuggestDataStruct extends DataStruct {
    public static final String KEY_DISTRICT_ID = "districtId";
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_KEYWORD_LIST = "keywordList";
    public int districtId;
    public String keyword;

    public KeywordSuggestDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_KEYWORD_SUGGEST;
    }
}
