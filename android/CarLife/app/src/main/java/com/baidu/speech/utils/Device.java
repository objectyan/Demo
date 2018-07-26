package com.baidu.speech.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public final class Device {
    private static final String TAG = "Device";

    private Device() {
    }

    public static String getDevID(Context context) {
        String string = PreferenceSetting.getString(context, "device_id", "");
        if (TextUtils.isEmpty(string)) {
            string = CommonParam.getCUID(context);
            PreferenceSetting.setString(context, "device_id", string);
            return string;
        }
        Log.d(TAG, "read deviceID:" + string);
        return string;
    }
}
