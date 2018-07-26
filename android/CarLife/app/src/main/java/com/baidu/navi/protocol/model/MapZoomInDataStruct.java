package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class MapZoomInDataStruct extends DataStruct {
    public MapZoomInDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_MAP_ZOOM_IN;
    }
}
