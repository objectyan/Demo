package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class MapImageUpdateDataStruct extends DataStruct {
    public static final String KEY_IMAGE_HEIGHT = "height";
    public static final String KEY_IMAGE_PATH = "image";
    public static final String KEY_IMAGE_TYPE = "imagetype";
    public static final String KEY_IMAGE_WIDTH = "width";
    public static final String TYPE_BMP = "bmp";
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_PNG = "png";
    public int imageHeight;
    public String imagePath;
    public String imageType;
    public int imageWidth;

    public MapImageUpdateDataStruct() {
        this.imageWidth = 400;
        this.imageHeight = BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT;
        this.mCmd = BNaviProtocolDef.COMMAND_NOTIFY_MAP_UPDATE;
    }

    public String toString() {
        return "cmd=" + this.mCmd + " imagePath=" + this.imagePath + " imageType=" + this.imageType + " width=" + this.imageWidth + " height" + this.imageHeight;
    }
}
