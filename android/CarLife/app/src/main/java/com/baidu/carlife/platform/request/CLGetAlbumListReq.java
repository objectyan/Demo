package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.C1260i;
import com.google.gson.Gson;

public class CLGetAlbumListReq extends CLRequest {
    private static final String TAG = CLGetAlbumListReq.class.getSimpleName();

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetAlbumListReq fromJson(String json) {
        try {
            return (CLGetAlbumListReq) new Gson().fromJson(json, CLGetAlbumListReq.class);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public int getRequestType() {
        return 1;
    }
}
