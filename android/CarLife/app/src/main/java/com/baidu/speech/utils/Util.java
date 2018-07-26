package com.baidu.speech.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class Util {
    public static String getDevId(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return "";
        }
        try {
            Object invoke = telephonyManager.getClass().getMethod("get" + getDevName() + "Id", new Class[0]).invoke(telephonyManager, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getDevName() {
        return "Device";
    }

    public static String pfm(Context context) throws SecurityException {
        boolean isUsingWifi = Utility.isUsingWifi(context);
        String generatePlatformString = Utility.generatePlatformString();
        generatePlatformString = isUsingWifi ? generatePlatformString + "&1" : generatePlatformString + "&3";
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                Object devId = getDevId(telephonyManager);
                if (!TextUtils.isEmpty(devId)) {
                    generatePlatformString = (generatePlatformString + "&") + devId;
                }
            }
        } catch (Exception e) {
        }
        return generatePlatformString;
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return MD5Util.toMd5(bArr, z);
    }
}
