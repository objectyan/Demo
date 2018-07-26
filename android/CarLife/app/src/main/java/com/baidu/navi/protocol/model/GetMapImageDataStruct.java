package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetMapImageDataStruct extends DataStruct {
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_IMAGE_DATA = "imageData";
    public static final String KEY_IMAGE_PATH = "image";
    public static final String KEY_IMAGE_TYPE = "imagetype";
    public static final String KEY_WIDTH = "width";
    public static final String TYPE_BMP = "bmp";
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_PNG = "png";
    public int height;
    public int width;

    public GetMapImageDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_MAP_IMAGE;
    }
}
