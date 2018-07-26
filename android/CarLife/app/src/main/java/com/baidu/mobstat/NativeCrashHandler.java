package com.baidu.mobstat;

import android.content.Context;
import android.util.Log;
import java.io.File;

public final class NativeCrashHandler {
    /* renamed from: a */
    private static boolean f19372a;
    /* renamed from: b */
    private static Context f19373b;

    private static native void nativeException();

    private static native void nativeInit(String str);

    private static native void nativeProcess(String str);

    private static native void nativeUnint();

    static {
        f19372a = false;
        try {
            System.loadLibrary("crash_analysis");
            f19372a = true;
        } catch (Throwable th) {
            Log.w("NativeCrashHandler", "Load library failed.");
        }
    }

    private NativeCrashHandler() {
    }

    public static void doNativeCrash() {
        if (f19372a) {
            try {
                nativeException();
            } catch (Throwable th) {
                Log.w("NativeCrashHandler", "Invoke method nativeException failed.");
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            f19373b = context.getApplicationContext();
            if (f19372a) {
                File cacheDir = context.getCacheDir();
                if (cacheDir.exists() && cacheDir.isDirectory()) {
                    try {
                        nativeInit(cacheDir.getAbsolutePath());
                    } catch (Throwable th) {
                        Log.w("NativeCrashHandler", "Invoke method nativeInit failed.");
                    }
                }
            }
        }
    }

    public static void uninit() {
        if (f19372a) {
            try {
                nativeUnint();
            } catch (Throwable th) {
                Log.w("NativeCrashHandler", "Invoke method nativeUnint failed.");
            }
        }
    }

    public static void process(String str) {
        if (str != null && str.length() != 0 && f19372a) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    nativeProcess(str);
                } catch (Throwable th) {
                    Log.w("NativeCrashHandler", "Invoke method nativeProcess failed.");
                }
            }
        }
    }

    public static void onCrashCallbackFromNative(String str) {
        Log.w("NativeCrashHandler", "crash: " + str);
        bl.m15490a().m15493a(System.currentTimeMillis(), str, "NativeException", 1);
    }
}
