package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

public interface XDVoiceCallback {
    void cancelAsr();

    void closePanel();

    void showPanel();

    void startAsr();

    void voiceEnable(int i, int i2);

    void voiceRestore();

    boolean xdIsWakeEnable();

    boolean xdIsWakeUpOn();

    void xdWakeEnable(boolean z);
}
