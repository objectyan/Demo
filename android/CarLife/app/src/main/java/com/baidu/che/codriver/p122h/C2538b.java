package com.baidu.che.codriver.p122h;

import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizerListener;

/* compiled from: CustomSpeechListener */
/* renamed from: com.baidu.che.codriver.h.b */
public abstract class C2538b implements SpeechSynthesizerListener {
    /* renamed from: b */
    public C2549b f8332b;

    public void onSpeechStart(String s) {
    }

    public void onSpeechFinish(String s) {
    }

    public void onError(String s, SpeechError speechError) {
    }

    public void onSynthesizeStart(String s) {
    }

    public void onSynthesizeDataArrived(String s, byte[] bytes, int i) {
    }

    public void onSynthesizeFinish(String s) {
    }

    public void onSpeechProgressChanged(String s, int i) {
    }

    /* renamed from: a */
    public final void m9629a(C2549b model) {
        this.f8332b = model;
    }
}
