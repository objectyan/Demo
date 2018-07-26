package com.baidu.navisdk.ui.voice;

import android.os.Bundle;

public interface BNVoice$OnVoicePageJumpListener {
    public static final int VOICE_PAGE_DETAIL = 4;
    public static final int VOICE_PAGE_INFO = 2;
    public static final int VOICE_PAGE_MAIN = 1;
    public static final int VOICE_PAGE_RECORD = 3;
    public static final int VOICE_PAGE_SQUARE = 5;

    void onBack(Bundle bundle);

    void onPageJump(int i, int i2, Bundle bundle);

    void onVoiceUserBehaviour(String str);
}
