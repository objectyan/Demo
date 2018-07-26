package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class BackgroundNotifyDataStruct extends DataStruct {
    public BackgroundNotifyDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_ROUTE_GUIDE_BACKGROUND_NOTIFY;
    }
}
