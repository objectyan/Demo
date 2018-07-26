package com.baidu.baidunavis.tts;

public interface OnTTSStateChangedListener {
    void onPlayEnd();

    void onPlayError(int i, String str);

    void onPlayStart();
}
