package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class ForegroundNotifyDataStruct extends DataStruct {
    public ForegroundNotifyDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FOREGROUND_NOTIFY;
    }
}
