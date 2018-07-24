package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.platform.model.CLAlbum;
import com.google.gson.Gson;
import java.util.ArrayList;

public class CLGetAlbumListResp extends CLResponse {
    private static final String TAG = CLGetAlbumListResp.class.getSimpleName();
    public ArrayList<CLAlbum> albumList;

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            LogUtil.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetAlbumListResp fromJson(String json) {
        try {
            return (CLGetAlbumListResp) new Gson().fromJson(json, CLGetAlbumListResp.class);
        } catch (Throwable e) {
            LogUtil.m4432a(TAG, e);
            return null;
        }
    }

    public int getResponseType() {
        return 1;
    }
}
