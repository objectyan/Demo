package com.baidu.mapframework.tts;

public interface OnTTSStateChangedListener {
    void onPlayEnd();

    void onPlayError(int i, String str);

    void onPlayStart();
}
