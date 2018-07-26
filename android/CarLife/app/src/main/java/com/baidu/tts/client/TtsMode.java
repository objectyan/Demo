package com.baidu.tts.client;

import com.baidu.tts.p233f.C5095m;

public enum TtsMode {
    ONLINE(C5095m.ONLINE),
    OFFLINE(C5095m.OFFLINE),
    MIX(C5095m.MIX);
    
    /* renamed from: a */
    private final C5095m f20839a;

    private TtsMode(C5095m ttsEnum) {
        this.f20839a = ttsEnum;
    }

    public C5095m getTtsEnum() {
        return this.f20839a;
    }

    public int getMode() {
        return this.f20839a.m17281a();
    }

    public String getDescription() {
        return this.f20839a.m17282b();
    }
}
