package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.platform.model.CLSong;
import com.google.gson.Gson;
import java.util.ArrayList;

public class CLGetSongListResp extends CLResponse {
    private static final String TAG = CLGetSongListResp.class.getSimpleName();
    public String playSongId;
    public int pn;
    public int rn;
    public ArrayList<CLSong> songList;
    public String songListId;
    public int total;
    public int version = 1;

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            LogUtil.m4432a(TAG, e);
            return null;
        }
    }

    public static CLGetSongListResp fromJson(String json) {
        try {
            return (CLGetSongListResp) new Gson().fromJson(json, CLGetSongListResp.class);
        } catch (Throwable e) {
            LogUtil.m4432a(TAG, e);
            return null;
        }
    }

    public int getResponseType() {
        return 2;
    }
}
