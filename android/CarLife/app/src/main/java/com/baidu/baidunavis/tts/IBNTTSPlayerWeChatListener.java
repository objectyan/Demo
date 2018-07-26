package com.baidu.baidunavis.tts;

public interface IBNTTSPlayerWeChatListener {
    void notifyTTSEnd();

    void notifyTTSInterrupt();

    void notifyTTSStart();
}
