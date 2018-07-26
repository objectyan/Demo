package com.baidu.baidunavis.tts;

public interface ITTSPlayer {
    void changeTTSPlayerVolume(boolean z);

    int getState();

    int init();

    int playText(String str, boolean z);

    void release();

    void setPlayModeAsync();

    void setPlayModeSync();

    void stop();
}
