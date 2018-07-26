package com.baidu.tts.tools;

import android.content.Context;
import android.text.TextUtils;

public class CommonParam {
    /* renamed from: a */
    private static final String f21301a = CommonParam.class.getSimpleName();

    public static String getCUID(Context paramContext) {
        String a = m17513a(paramContext);
        String imei = DeviceId.getIMEI(paramContext);
        if (TextUtils.isEmpty(imei)) {
            imei = "0";
        }
        return a + "|" + new StringBuffer(imei).reverse().toString();
    }

    /* renamed from: a */
    private static String m17513a(Context context) {
        return DeviceId.getDeviceID(context);
    }
}
