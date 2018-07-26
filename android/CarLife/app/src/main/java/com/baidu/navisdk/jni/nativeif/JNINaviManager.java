package com.baidu.navisdk.jni.nativeif;

public class JNINaviManager {
    public static JNINaviManager sInstance = new JNINaviManager();

    public interface LogPathType {
        public static final int INIT_LOG = 0;
        public static final int RP_LOG = 1;
    }

    public native String getIPByHost(String str);

    public native String getInitLogPath(int i);

    public native int initNaviManager(Object obj);

    public native void initNaviStatistics(int i);

    public native int initSubSystem(int i);

    public native int reInitSearchEngine(int i, Object obj);

    public native int reloadNaviManager(int i, String str);

    public native int uninitNaviManager();

    public native void uninitNaviStatistics();

    public native void uninitSubSystem(int i);

    public native int updateAppSource(int i);

    private JNINaviManager() {
    }
}
