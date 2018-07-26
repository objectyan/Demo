package com.baidu.speech.core;

import android.util.Log;

public class LogUtil {
    public static boolean DEBUG = false;
    public static final String TAG = "Android_Audio";

    public static void log_d(String str) {
        if (DEBUG) {
            Log.d(TAG, str);
        }
    }

    public static void log_e(String str) {
        if (DEBUG) {
            Log.e(TAG, str);
        }
    }
}
