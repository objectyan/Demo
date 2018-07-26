package com.baidu.baidunavis.tts;

public interface IBNTTSPlayerPCMListener {
    void handlePCMStream(byte[] bArr, boolean z);

    void notifyTTSEnd();

    void notifyTTSStart();
}
