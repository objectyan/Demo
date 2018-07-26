package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetAddressDataStruct extends DataStruct {
    public static final String KEY_COMPANY = "company";
    public static final String KEY_HOME = "home";

    public GetAddressDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_HOME_AND_COMPANY;
    }
}
