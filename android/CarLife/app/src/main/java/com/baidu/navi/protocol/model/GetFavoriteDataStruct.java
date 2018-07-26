package com.baidu.navi.protocol.model;

import com.baidu.navi.protocol.util.BNaviProtocolDef;

public class GetFavoriteDataStruct extends DataStruct {
    public static final String KEY_FAVORITE_LIST = "favoriteList";

    public GetFavoriteDataStruct() {
        this.mCmd = BNaviProtocolDef.COMMAND_GET_FAVORITE;
    }
}
