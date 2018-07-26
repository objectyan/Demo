package com.baidu.nplatform.comjni.engine;

import android.os.Bundle;
import com.baidu.navisdk.vi.VMsg;

public class AppEngine {
    private static final int eBundle = 0;

    public static void despatchMessage(int what, int arg1, int arg2) {
        VMsg.dispatchMessage(what, arg1, arg2);
    }

    public static boolean InitEngine(Bundle phoneInfo) {
        boolean z = false;
        try {
            JNIEngine.initClass(new Bundle(), 0);
            z = JNIEngine.InitEngine(phoneInfo);
        } catch (Throwable th) {
        }
        return z;
    }

    public static boolean UnInitEngine() {
        try {
            return JNIEngine.UnInitEngine();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean StartSocketProc() {
        return JNIEngine.StartSocketProc();
    }

    public static boolean GetFlaxLength(Bundle b) {
        return JNIEngine.GetFlaxLength(b);
    }
}
