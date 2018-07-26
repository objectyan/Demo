package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class SearchByTypeDataStruct extends DataStruct {
    public static final String KEY_FIRST_TIME_ONLINE_SEARCH = "firstTimeOnlineSearch";
    public static final String KEY_ONLINE_SEARCH = "onlineSearch";
    public static final String KEY_POI_LIST = "poiList";
    public static final String KEY_TYPE = "type";
    public static final int TYPE_AUTO_SERVICE = 8192;
    public static final int TYPE_BANK = 16448;
    public static final int TYPE_CATERING = 2048;
    public static final int TYPE_GAS = 31552;
    public static final int TYPE_HOTEL = 4096;
    public static final int TYPE_PARK = 31488;
    public static final int TYPE_SCENIC = 24576;
    public static final int TYPE_WC = 11392;
    public int type;

    public SearchByTypeDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_SEARCH_BY_TYPE;
    }
}
