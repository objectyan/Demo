package com.baidu.speech.utils;

import android.content.Context;
import java.io.File;

public class Policy {
    public static String app(Context context) {
        return "com.baidu.speech.demo".equals(context.getPackageName()) ? "" : context.getPackageName();
    }

    public static String modelVadDefaultResFile(Context context) {
        return String.format("%s/%s", new Object[]{context.getApplicationInfo().nativeLibraryDir, "libbd_easr_s1_merge_normal_20151216.dat.so"});
    }

    public static String pfm(Context context) {
        return Util.pfm(context);
    }

    public static int sample(Context context) {
        return Utility.is2G(context) ? 8000 : 16000;
    }

    public static int taskTimeout() {
        return 30000;
    }

    public static String uiRetryFile(Context context) {
        return new File(context.getCacheDir(), "bd_asr_ui_repeat.pcm").toString();
    }

    public static String uid(Context context) {
        return Device.getDevID(context);
    }

    public static String ver(Context context) {
        return "";
    }
}
