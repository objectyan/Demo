package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class StopNaviDataStruct extends DataStruct {
    public StopNaviDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_STOP_NAVI;
    }
}
