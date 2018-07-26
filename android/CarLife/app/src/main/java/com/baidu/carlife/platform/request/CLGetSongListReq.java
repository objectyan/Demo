package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.C1260i;
import com.google.gson.Gson;

public class CLGetSongListReq extends CLRequest {
    private static final String TAG = CLGetSongListReq.class.getSimpleName();
    public int pn;
    public int rn;
    public String songListId;
    public int version = 1;

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetSongListReq fromJson(String json) {
        try {
            return (CLGetSongListReq) new Gson().fromJson(json, CLGetSongListReq.class);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public int getRequestType() {
        return 2;
    }
}
