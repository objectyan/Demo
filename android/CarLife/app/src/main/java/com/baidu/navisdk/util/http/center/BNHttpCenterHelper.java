package com.baidu.navisdk.util.http.center;

import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;

public class BNHttpCenterHelper {
    public static HashMap<String, String> formatParams(List<NameValuePair> params) {
        HashMap<String, String> newParams = new HashMap();
        if (params != null) {
            for (NameValuePair nvp : params) {
                newParams.put(nvp.getName(), nvp.getValue());
            }
        }
        return newParams;
    }
}
