package com.baidu.tts.p243o.p244a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p218b.p220b.p227b.C5030b.C5029a;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p233f.C5097n.C5096a;

/* compiled from: UninitialState */
/* renamed from: com.baidu.tts.o.a.d */
public class C5153d extends C5149a {
    public C5153d(C5152c c5152c) {
        super(c5152c);
    }

    /* renamed from: b */
    public TtsError mo3782b() {
        TtsError h = this.a.m17483h();
        if (h != null) {
            C5097n errorEnum = h.getErrorEnum();
            if (errorEnum != null) {
                if (C5096a.f21135a.equals(errorEnum.m17283a())) {
                    m17454a(this.a.m17482g());
                }
            }
        } else {
            m17454a(this.a.m17482g());
        }
        return h;
    }

    /* renamed from: c */
    public void mo3784c() {
        this.a.m17491p();
    }

    /* renamed from: d */
    public void mo3785d() {
        this.a.m17491p();
    }

    /* renamed from: e */
    public void mo3786e() {
        this.a.m17491p();
    }

    /* renamed from: f */
    public void mo3787f() {
    }

    public void speak(C5146i textParams) {
        this.a.m17491p();
    }

    public void synthesize(C5146i textParams) {
        this.a.m17491p();
    }

    public int loadCustomResource(C5142e params) {
        return this.a.m17491p();
    }

    public int freeCustomResource(C5142e params) {
        return this.a.m17491p();
    }

    public int loadModel(C5144g params) {
        return this.a.m17491p();
    }

    public int loadEnglishModel(C5143f params) {
        return this.a.m17491p();
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        C5029a e = this.a.getTtsParams().m17453e();
        e.m16969a(leftVolume);
        e.m16971b(rightVolume);
        return 0;
    }

    public int setAudioStreamType(int streamType) {
        this.a.getTtsParams().m17453e().m16964a(streamType);
        return 0;
    }
}
