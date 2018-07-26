package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.platform.model.CLSongData;
import com.google.gson.Gson;

public class CLGetSongDataResp extends CLResponse {
    private static final String TAG = CLGetSongDataResp.class.getSimpleName();
    public CLSongData songData;

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetSongDataResp fromJson(String json) {
        try {
            return (CLGetSongDataResp) new Gson().fromJson(json, CLGetSongDataResp.class);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public int getResponseType() {
        return 3;
    }
}
