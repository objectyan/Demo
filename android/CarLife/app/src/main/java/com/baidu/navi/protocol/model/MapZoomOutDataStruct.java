package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class MapZoomOutDataStruct extends DataStruct {
    public MapZoomOutDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_MAP_ZOOM_OUT;
    }
}
