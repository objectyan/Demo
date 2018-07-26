package com.baidu.mapframework.commonlib.utils;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public class JSONUtils {
    public static int parseInt(JSONObject json, String key, int defaultValue) {
        return (json == null || TextUtils.isEmpty(key) || !json.has(key)) ? defaultValue : json.optInt(key);
    }

    public static int parseInt(JSONObject json, String key) {
        return parseInt(json, key, 0);
    }

    public static String parseString(JSONObject json, String key, String defaultValue) {
        return (json == null || TextUtils.isEmpty(key) || !json.has(key)) ? defaultValue : json.optString(key);
    }

    public static String parseString(JSONObject json, String key) {
        return parseString(json, key, "");
    }

    public static boolean isJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Bundle simpleJsonTransferToBundle(String simpleJson) {
        try {
            JSONObject jsonObject = new JSONObject(simpleJson);
            Iterator<String> iterate = jsonObject.keys();
            Bundle bundle = new Bundle();
            while (iterate.hasNext()) {
                String key = (String) iterate.next();
                bundle.putString(key, jsonObject.optString(key));
            }
            return bundle;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject bundleTransferToSimpleJson(Bundle bundle) {
        JSONObject jsonObject = new JSONObject();
        if (!(bundle == null || bundle.keySet() == null)) {
            try {
                for (String key : bundle.keySet()) {
                    jsonObject.put(key, bundle.get(key));
                }
            } catch (Exception e) {
            }
        }
        return jsonObject;
    }

    public static String bundleTransferToSimpleJsonString(Bundle bundle) {
        JSONObject jsonObject = bundleTransferToSimpleJson(bundle);
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.toString();
    }
}
