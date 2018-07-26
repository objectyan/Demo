package com.baidu.mapframework.tts;

import android.os.Handler;

public interface ITTSPlayer {
    void addOnTTSStateChangeListener(OnTTSStateChangedListener onTTSStateChangedListener);

    void changeTTSPlayerVolume(boolean z);

    int getCurrentProgress();

    int getInitState();

    int getState();

    String getVoicePath(String str);

    int init();

    int pause();

    boolean pauseAllDownload();

    boolean pauseDownload(String str);

    int playText(String str, boolean z);

    boolean recoveryToNavVoice();

    void registCallbackHandler(Handler handler);

    void release();

    void removeOnTTSStateChangeListener(OnTTSStateChangedListener onTTSStateChangedListener);

    int resume();

    void setOnTTSPlayCompleteListener(OnTTSPlayCompleteListener onTTSPlayCompleteListener);

    void setOnTTSPlayErrorListener(OnTTSPlayErrorListener onTTSPlayErrorListener);

    void setOnTTSPlayStartListener(OnTTSPlayStartListener onTTSPlayStartListener);

    void setPlayModeAsync();

    void setPlayModeSync();

    int setTTSPlaySpeed(int i);

    boolean startDownload(String str);

    void stop();

    boolean switchVoice(String str, String str2);

    void unregistCallbackHandler(Handler handler);

    int xdPlayText(String str, boolean z);
}
