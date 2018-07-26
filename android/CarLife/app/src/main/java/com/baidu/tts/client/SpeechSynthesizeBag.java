package com.baidu.tts.client;

import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.tools.ResourceTools;

public class SpeechSynthesizeBag {
    /* renamed from: a */
    private String f20834a;
    /* renamed from: b */
    private String f20835b;

    public String getText() {
        return this.f20834a;
    }

    public int setText(String text) {
        C5097n isTextValid = ResourceTools.isTextValid(text);
        if (isTextValid != null) {
            return isTextValid.m17284b();
        }
        this.f20834a = text;
        return 0;
    }

    public String getUtteranceId() {
        return this.f20835b;
    }

    public void setUtteranceId(String utteranceId) {
        this.f20835b = utteranceId;
    }
}
