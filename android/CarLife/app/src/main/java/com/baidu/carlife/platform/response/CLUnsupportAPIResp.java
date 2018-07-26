package com.baidu.carlife.platform.response;

import com.baidu.carlife.core.C1260i;
import com.google.gson.Gson;

public class CLUnsupportAPIResp extends CLResponse {
    private static final String TAG = CLUnsupportAPIResp.class.getSimpleName();

    public CLUnsupportAPIResp(long requestId) {
        this.errorNo = 1;
        this.errorMsg = "unsupport api";
        this.requestId = requestId;
    }

    public String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public static CLUnsupportAPIResp fromJson(String json) {
        try {
            return (CLUnsupportAPIResp) new Gson().fromJson(json, CLUnsupportAPIResp.class);
        } catch (Throwable e) {
            C1260i.m4432a(TAG, e);
            return null;
        }
    }

    public int getResponseType() {
        return 0;
    }
}
