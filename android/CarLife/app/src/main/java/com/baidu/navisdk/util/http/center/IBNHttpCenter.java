package com.baidu.navisdk.util.http.center;

import java.util.HashMap;

public interface IBNHttpCenter {
    void get(String str, HashMap<String, String> hashMap, IBNHttpResponseHandler iBNHttpResponseHandler, BNHttpParams bNHttpParams);

    void post(String str, HashMap<String, String> hashMap, IBNHttpResponseHandler iBNHttpResponseHandler, BNHttpParams bNHttpParams);
}
