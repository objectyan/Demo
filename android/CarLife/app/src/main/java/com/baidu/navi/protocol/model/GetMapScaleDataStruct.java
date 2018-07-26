package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetMapScaleDataStruct extends DataStruct {
    public static final String KEY_MAP_SCALE_DIS = "scaleDis";
    public static final String KEY_MAP_SCALE_LEVEL = "scaleLevel";

    public GetMapScaleDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_MAP_SCALE;
    }
}
