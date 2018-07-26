package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class RerouteDataStruct extends RoutePlanDataStruct {
    public RerouteDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_REROUTE;
    }
}
