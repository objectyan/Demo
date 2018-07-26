package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class SetImageSizeDataStruct extends DataStruct {
    public static final String KEY_IMAGE_HEIGHT = "height";
    public static final String KEY_IMAGE_WIDTH = "width";
    public int imageHeight;
    public int imageWidth;

    public SetImageSizeDataStruct() {
        this.imageWidth = 400;
        this.imageHeight = BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT;
        this.mCmd = BNaviProtocolDef.COMMAND_SET_IMAGE_SIZE;
    }
}
