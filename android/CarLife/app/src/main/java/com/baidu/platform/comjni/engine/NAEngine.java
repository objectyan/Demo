package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comapi.p207a.C4754a;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.C2913c;
import com.baidu.platform.comjni.util.C4840a;

public class NAEngine extends C2913c {
    /* renamed from: a */
    private static final int f12745a = 0;
    /* renamed from: b */
    private static LongLinkClient f12746b;
    /* renamed from: c */
    private static boolean f12747c = false;

    private native long nativeCreate();

    private static native void nativeEnableMonitor(boolean z);

    private static native boolean nativeGetFlaxLength(Bundle bundle);

    private static native String nativeGetIP(String str);

    private static native void nativeInitCVLogFilePath(String str);

    private static native int nativeInitClass(Object obj, int i);

    private static native boolean nativeInitEngine(Object obj, String str);

    private static native void nativeMonitorSetLogPriority(int i);

    private native int nativeRelease(long j);

    private static native void nativeSetHttpsEnable(boolean z);

    private static native void nativeSetNewDomainEnable(boolean z);

    private static native void nativeSetProxyInfo(String str, int i);

    private static native boolean nativeStartSocketProc();

    private static native boolean nativeStartSocketProcByCache(String str);

    private static native void nativeUninitCVLogFilePath();

    private static native boolean nativeUninitEngine();

    public NAEngine() {
        create();
    }

    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public static void initVI() {
        nativeInitClass(new Bundle(), 0);
        f12747c = true;
    }

    public static boolean initEngine(Context context, String phoneInfo) {
        if (!f12747c) {
            initVI();
        }
        try {
            boolean ret = nativeInitEngine(context, phoneInfo);
            SysOSAPIv2.getInstance().init();
            return ret;
        } catch (Throwable e) {
            C4840a.a(e);
            return false;
        }
    }

    public static boolean initLongLinkClient() {
        if (f12746b == null) {
            try {
                f12746b = LongLinkClient.create();
            } catch (C4754a e) {
            }
        }
        return f12746b != null;
    }

    public static boolean unInitEngine() {
        try {
            if (f12746b != null) {
                f12746b.unRegister(null);
                f12746b.release();
                f12746b = null;
            }
            return nativeUninitEngine();
        } catch (Throwable e) {
            C4840a.a(e);
            return false;
        }
    }

    public static void setProxyInfo(String strHostName, int nPort) {
        nativeSetProxyInfo(strHostName, nPort);
    }

    public static boolean startSocketProc() {
        return nativeStartSocketProc();
    }

    public static boolean startSocketProcByCache(String cachePath) {
        return nativeStartSocketProcByCache(cachePath);
    }

    public static boolean getFlaxLength(Bundle b) {
        return nativeGetFlaxLength(b);
    }

    public static void stopLongLink() {
        if (f12746b != null) {
            try {
                f12746b.stop();
            } catch (Exception e) {
            }
        }
    }

    public static void restartLongLink() {
        if (f12746b != null) {
            try {
                f12746b.start();
            } catch (Exception e) {
            }
        }
    }

    public static void setMonitorEnable(boolean enable) {
        nativeEnableMonitor(enable);
        nativeMonitorSetLogPriority(1);
    }

    public static void initCVLogFilePath(String filePath) {
        nativeInitCVLogFilePath(filePath);
    }

    public static void unInitCVLogFilePath() {
        nativeUninitCVLogFilePath();
    }

    public static void setHttpsEnable(boolean enable) {
        nativeSetHttpsEnable(enable);
    }

    public static String getIP(String hostname) {
        return nativeGetIP(hostname);
    }

    public static void setNewDomainEnable(boolean enable) {
        nativeSetNewDomainEnable(enable);
    }
}
