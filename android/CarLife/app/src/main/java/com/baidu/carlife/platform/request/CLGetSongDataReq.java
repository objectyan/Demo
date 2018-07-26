package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.C1260i;
import com.google.gson.Gson;

public class CLGetSongDataReq extends CLRequest {
    private static final String TAG = CLGetSongDataReq.class.getSimpleName();
    public String songId;

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetSongDataReq fromJson(String json) {
        try {
            return (CLGetSongDataReq) new Gson().fromJson(json, CLGetSongDataReq.class);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public int getRequestType() {
        return 3;
    }
}
