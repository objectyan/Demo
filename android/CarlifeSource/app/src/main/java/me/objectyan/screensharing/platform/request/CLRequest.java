package com.baidu.carlife.platform.request;

import com.baidu.carlife.core.LogUtil;
import com.google.gson.Gson;

public abstract class CLRequest {
    public static final int REQUEST_GET_ALBUM_LIST = 1;
    public static final int REQUEST_GET_SONG_DATA = 3;
    public static final int REQUEST_GET_SONG_LIST = 2;
    private static final String TAG = CLRequest.class.getSimpleName();
    public long requestId = System.currentTimeMillis();

    public abstract int getRequestType();

    public static CLRequest fromJson(String json) {
        try {
            return (CLRequest) new Gson().fromJson(json, CLRequest.class);
        } catch (Throwable e) {
            LogUtil.m4432a(TAG, e);
            return null;
        }
    }
}
