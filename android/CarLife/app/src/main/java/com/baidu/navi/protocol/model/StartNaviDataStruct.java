package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class StartNaviDataStruct extends DataStruct {
    public static final String KEY_USE_CAR_GPS = "useCarGPS";
    public boolean useCarGPS;

    public StartNaviDataStruct() {
        this.useCarGPS = false;
        this.mCmd = BNaviProtocolDef.COMMAND_START_NAVI;
    }
}
