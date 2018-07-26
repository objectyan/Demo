package com.baidu.speech.core;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class BDSSDKLoader {

    public interface BDSCoreEventListener {
        void receiveCoreEvent(BDSMessage bDSMessage, BDSSDKInterface bDSSDKInterface);
    }

    public interface BDSSDKInterface {
        void EchoMessage(BDSMessage bDSMessage);

        boolean instanceInitialized();

        int postMessage(BDSMessage bDSMessage);

        void release();

        void setListener(BDSCoreEventListener bDSCoreEventListener);
    }

    public static native void SetLogLevel(int i);

    public static native int getEngineVersion();

    public static BDSSDKInterface getSDKObjectForSDKType(String str, Context context) {
        String str2 = context.getApplicationInfo().nativeLibraryDir;
        if (!str2.endsWith("/") && str2.length() > 0) {
            str2 = str2 + "/";
        }
        setLibrarySearchPath(str2);
        setJavaContext(context);
        str2 = context.getCacheDir().getAbsolutePath() + "/";
        String str3 = context.getFilesDir().getAbsolutePath() + "/";
        makeDir(str3);
        setWriteableTempPath(str2);
        setWriteableLibraryDataPath(str3);
        setWriteableUserDataPath(str3);
        return BDSCoreJniInterface.getNewSDK(str);
    }

    public static void loadLibraries() throws Exception {
        try {
            System.loadLibrary("bdEASRAndroid");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            System.loadLibrary("bdSpilWakeup");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            System.loadLibrary("BaiduSpeechSDK");
        } catch (Throwable th22) {
            th22.printStackTrace();
            IOException iOException = new IOException("Can not load BaiduSpeechSDK library");
        }
    }

    public static boolean makeDir(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && file.canWrite()) {
                    return true;
                }
            } else if (file.mkdirs()) {
                return true;
            }
        }
        return false;
    }

    public static native void setJavaContext(Context context);

    private static native void setLibrarySearchPath(String str);

    public static native void setWriteableLibraryDataPath(String str);

    public static native void setWriteableTempPath(String str);

    public static native void setWriteableUserDataPath(String str);
}
