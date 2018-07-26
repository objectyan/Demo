package com.baidu.speech.utils;

import android.content.Context;
import android.text.TextUtils;

public class CommonParam {
    public static String AGENT_URL = "";
    private static final boolean DEBUG = false;
    public static String REQUEST_URL = "";
    private static final String TAG = CommonParam.class.getSimpleName();

    public static String getCUID(Context context) {
        String devId = getDevId(context);
        String intlMobEqId = DeviceId.getIntlMobEqId(context);
        if (TextUtils.isEmpty(intlMobEqId)) {
            intlMobEqId = "0";
        }
        return devId + "|" + new StringBuffer(intlMobEqId).reverse().toString();
    }

    private static String getDevId(Context context) {
        return DeviceId.getDevID(context);
    }
}
