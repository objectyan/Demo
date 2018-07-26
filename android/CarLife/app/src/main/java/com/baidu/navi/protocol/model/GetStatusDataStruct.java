package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetStatusDataStruct extends DataStruct {
    public static final String KEY_END_ADDR = "end";
    public static final String KEY_IS_NAVI_BEGIN = "isNaviBegin";
    public static final String KEY_START_ADDR = "start";

    public GetStatusDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_STATUS;
    }
}
