package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class AddFavoriteByFileDataStruct extends DataStruct {
    public static String KEY_FAVFILEPATH = "favFilePath";
    public static String KEY_FAVNUM = "favNum";
    public String mFavFile;
    public int mFavNum;

    public AddFavoriteByFileDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_ADD_FAVORITE_BY_FILE;
    }
}
