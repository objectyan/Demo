package com.baidu.navisdk.comapi.voicecommand;

public interface OnVoiceStatusListener {
    public static final int Status_Listening = 1;
    public static final int Status_NotUnderstand = 3;
    public static final int Status_Speaking = 2;
    public static final int Status_Waiting = 0;

    void onVoiceStatusChanged(int i);
}
