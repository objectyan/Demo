package com.baidu.speech.utils;

import android.content.Context;

final class PreferenceSetting {
    private static final String FILE_NAME = "bdvrsetting";
    private static final String FILE_NAME_MD5 = Util.toMd5(FILE_NAME.getBytes(), false);
    private static final String VTLN_KEY = "vtln";
    private static final int VTLN_LIMIT = 255;
    private static final String VTLN_SECRET_KEY = "BDVRVtln*!Secret";

    private PreferenceSetting() {
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences(FILE_NAME_MD5, 0).getBoolean(str, z);
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(FILE_NAME_MD5, 0).getString(str, str2);
    }

    public static int getVtlnWithCheckSum(Context context) {
        String string = getString(context, VTLN_KEY, "");
        if (string.indexOf("||") == -1) {
            return -1;
        }
        String[] split = string.split("\\|\\|");
        if (split.length < 2) {
            return -1;
        }
        Object obj = split[1];
        string = split[0];
        return Util.toMd5(new StringBuilder().append(string).append(VTLN_SECRET_KEY).toString().getBytes(), false).equals(obj) ? Integer.parseInt(string) : -1;
    }

    public static void removeString(Context context, String str) {
        context.getSharedPreferences(FILE_NAME_MD5, 0).edit().remove(str).commit();
    }

    public static void setBoolean(Context context, String str, boolean z) {
        context.getSharedPreferences(FILE_NAME_MD5, 0).edit().putBoolean(str, z).commit();
    }

    public static void setString(Context context, String str, String str2) {
        context.getSharedPreferences(FILE_NAME_MD5, 0).edit().putString(str, str2).commit();
    }

    public static boolean setVtlnWithCheckSum(Context context, int i) {
        if (i < 0 || i > 255) {
            return false;
        }
        setString(context, VTLN_KEY, i + "||" + Util.toMd5((i + VTLN_SECRET_KEY).getBytes(), false));
        return true;
    }
}
