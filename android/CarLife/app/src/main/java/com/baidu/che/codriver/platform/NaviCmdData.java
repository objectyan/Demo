package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.platform.NaviCmdOriginalData.ExtInfo;
import com.baidu.che.codriver.platform.navi.NaviAddressData;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.INoProguard;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviCmdData implements INoProguard {
    private static final String TAG = "NaviCmdData";
    private String mFunc;
    private String mParams;

    public NaviCmdData(String func, String params) {
        this.mFunc = func;
        this.mParams = params;
    }

    public void setFunc(String func) {
        this.mFunc = func;
    }

    public void setParams(String params) {
        this.mParams = params;
    }

    public String getFunc() {
        return this.mFunc;
    }

    public String getParams() {
        return this.mParams;
    }

    public String toString() {
        return "CmdNaviData { func = " + this.mFunc + ", params = " + this.mParams + " }";
    }

    public static String createParams(String key, String order) {
        JSONObject result = new JSONObject();
        try {
            result.put(key, order);
            C2725h.m10207b(TAG, "params: " + result.toString());
            return result.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createParams(String key, int order) {
        JSONObject result = new JSONObject();
        try {
            result.put(key, order);
            C2725h.m10207b(TAG, "params: " + result.toString());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createParamsPoi(ExtInfo object) {
        JSONObject result = new JSONObject();
        try {
            if (object.lat == null || object.lng == null) {
                C2725h.m10207b(TAG, "lng or lat is null");
                return null;
            }
            JSONObject pos = new JSONObject();
            pos.put("lat", object.lat);
            pos.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, object.lng);
            result.put(NaviCmdConstants.KEY_NAVI_CMD_DEST, pos);
            if (object.poiName != null) {
                result.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_NAME, object.poiName);
                C2725h.m10207b(TAG, "params: " + result.toString());
                return result.toString();
            }
            C2725h.m10207b(TAG, "poiName is null");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createParamsPoi(NaviAddressData address) {
        JSONObject result = new JSONObject();
        try {
            if (address.getLat() == null || address.getLng() == null) {
                C2725h.m10207b(TAG, "lng or lat is null");
                return null;
            }
            JSONObject pos = new JSONObject();
            pos.put("lat", address.getLat());
            pos.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, address.getLng());
            result.put(NaviCmdConstants.KEY_NAVI_CMD_DEST, pos);
            if (address.getName() != null) {
                result.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_NAME, address.getName());
                C2725h.m10207b(TAG, "params: " + result.toString());
                return result.toString();
            }
            C2725h.m10207b(TAG, "poiName is null");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createParamsAddress(NaviAddressData address) {
        JSONObject result = new JSONObject();
        JSONObject dataObject = new JSONObject();
        try {
            if (address.getType().equals(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY)) {
                result.put(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_COMPANY_ADDRESS);
            } else if (address.getType().equals("home")) {
                result.put(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_HOME_ADDRESS);
            } else {
                C2725h.m10207b(TAG, "set address type error");
                return null;
            }
            dataObject.put("name", address.getName());
            dataObject.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, address.getAddress());
            dataObject.put("lat", address.getLat());
            dataObject.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, address.getLng());
            dataObject.put("type", address.getType());
            result.put("data", dataObject);
            C2725h.m10207b(TAG, "params: " + result.toString());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createParamsResetNaviByPreference(String type) {
        return "{\"order\":\"type_reset_navi_bypreference\",\"data\":{\"navi_preference\":\"" + type + "\"}}";
    }
}
