package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetFavoriteAsFileDataStruct extends DataStruct {
    public static String KEY_FAVFILEPATH = "favFilePath";
    public static String KEY_FAVNUM = "favNum";
    public String mFavFile;
    public int mFavNum;

    public GetFavoriteAsFileDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_FAVORITE_AS_FILE;
    }
}
