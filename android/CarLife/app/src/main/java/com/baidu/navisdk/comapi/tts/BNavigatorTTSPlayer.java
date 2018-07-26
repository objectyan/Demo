package com.baidu.navisdk.comapi.tts;

import com.baidu.navisdk.jni.nativeif.JNITTSPlayer;

public class BNavigatorTTSPlayer {
    private static int mHandle = 0;
    private static BNavigatorTTSPlayer mInstance;
    private static JNITTSPlayer mJNIPlayer;

    private BNavigatorTTSPlayer() {
    }

    public static BNavigatorTTSPlayer getInstance() {
        if (mInstance == null) {
            mInstance = new BNavigatorTTSPlayer();
        }
        return mInstance;
    }

    public void init() {
    }

    public void init(IBNTTSPlayerListener listener) {
    }

    public void unInit() {
        TTSPlayerControl.unInit();
    }

    public void setTTSPlayerListener(IBNTTSPlayerListener listener) {
        init(listener);
    }

    public int playTTSText(String text, boolean bPreempt) {
        return 0;
    }

    public void pauseVoiceTTSOutput() {
    }

    public void resumeVoiceTTSOutput() {
    }

    public void stopVoiceTTSOutput() {
    }

    public void setPhoneIn(boolean bCalling) {
    }

    public int getTTSState() {
        return TTSPlayerControl.getTTSState();
    }

    public int playOver() {
        return -1;
    }
}
