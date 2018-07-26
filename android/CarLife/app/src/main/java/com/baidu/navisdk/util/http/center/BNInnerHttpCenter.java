package com.baidu.navisdk.util.http.center;

import java.util.HashMap;

public class BNInnerHttpCenter implements IBNHttpCenter {
    private static IBNHttpCenter sInstance = null;
    private static final Object sInstanceLock = new Object();

    private BNInnerHttpCenter() {
    }

    public static IBNHttpCenter getInstance() {
        if (sInstance == null) {
            synchronized (sInstanceLock) {
                if (sInstance == null) {
                    sInstance = new BNInnerHttpCenter();
                }
            }
        }
        return sInstance;
    }

    public void get(String url, HashMap<String, String> hashMap, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        if (moreParams == null) {
            BNHttpParams tmpParams = new BNHttpParams();
        }
    }

    public void post(String url, HashMap<String, String> hashMap, IBNHttpResponseHandler handler, BNHttpParams moreParams) {
        if (moreParams == null) {
            BNHttpParams tmpParams = new BNHttpParams();
        }
    }
}
