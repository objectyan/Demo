package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class RouteGuideFinishDataStruct extends DataStruct {
    public RouteGuideFinishDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_ROUTE_GUIDE_FINIS_NOTIFY;
    }
}
