package com.baidu.tts.tools;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

public class GetCUID {
    private GetCUID() {
    }

    public static String getCUID(Context context) {
        String string = SharedPreferencesUtils.getString(context, "CUID", "");
        if (TextUtils.isEmpty(string)) {
            string = CommonParam.getCUID(context);
            SharedPreferencesUtils.putString(context, "CUID", string);
            return string;
        }
        LoggerProxy.m17001d("Device", "read deviceID:" + string);
        return string;
    }
}
