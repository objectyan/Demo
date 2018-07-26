package com.baidu.tts.tools;

import java.util.Set;
import org.json.JSONArray;

public class JsonTool {
    public static JSONArray fromSetToJson(Set<String> set) {
        if (set != null) {
            return new JSONArray(set);
        }
        return null;
    }

    public static String[] getStringarray(JSONArray ja) {
        if (ja == null) {
            return null;
        }
        int length = ja.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = ja.optString(i);
        }
        return strArr;
    }
}
