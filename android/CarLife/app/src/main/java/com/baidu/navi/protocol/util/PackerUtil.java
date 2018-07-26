package com.baidu.navi.protocol.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PackerUtil {
    public static final String KEY_COMMAND = "command";
    public static final String KEY_EXT_DATA = "extData";
    public static final String KEY_METHOD = "method";
    public static final String KEY_MODULE_NAME = "moduleName";
    public static final String KEY_RESULT = "result";
    public static final String KEY_VERSION = "version";

    public static String getCommand(JSONObject obj) {
        String cmd = null;
        if (obj != null) {
            try {
                cmd = obj.getJSONObject(KEY_COMMAND).getString("method");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return cmd;
    }

    public static JSONObject createProtocolJSON(String cmd, JSONObject extDataObj) {
        if (TextUtils.isEmpty(cmd)) {
            return null;
        }
        try {
            JSONObject obj = new JSONObject();
            JSONObject commandObj = new JSONObject();
            if (extDataObj != null) {
                commandObj.put(KEY_EXT_DATA, extDataObj);
            }
            commandObj.put("method", cmd);
            obj.put(KEY_MODULE_NAME, BNaviProtocolDef.moduleName);
            obj.put("version", 2);
            obj.put(KEY_COMMAND, commandObj);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getExtDataObj(JSONObject obj) {
        JSONObject extDataObj = null;
        if (obj != null) {
            try {
                JSONObject commandObj = obj.getJSONObject(KEY_COMMAND);
                if (commandObj != null) {
                    extDataObj = commandObj.getJSONObject(KEY_EXT_DATA);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return extDataObj;
    }

    public static int getVersion(JSONObject obj) {
        if (obj != null) {
            return obj.optInt("version", 0);
        }
        return 0;
    }

    public static JSONObject createResultJSON(JSONObject extDataObj) {
        if (extDataObj == null) {
            return null;
        }
        try {
            JSONObject temp = new JSONObject();
            JSONObject commandObj = new JSONObject();
            if (extDataObj != null) {
                commandObj.put(KEY_EXT_DATA, extDataObj);
            }
            commandObj.put("method", "result");
            temp.put(KEY_MODULE_NAME, BNaviProtocolDef.moduleName);
            temp.put("version", 2);
            temp.put(KEY_COMMAND, commandObj);
            return temp;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject createJSONWithoutParam(String cmd) {
        return createProtocolJSON(cmd, new JSONObject());
    }
}
