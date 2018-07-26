package com.baidu.navisdk.jni.nativeif;

public class JNITTSPlayer {
    public static JNITTSPlayer sInstance = new JNITTSPlayer();

    public native int PlayOver();

    private JNITTSPlayer() {
    }
}
