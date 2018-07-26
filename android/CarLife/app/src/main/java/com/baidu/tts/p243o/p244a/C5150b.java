package com.baidu.tts.p243o.p244a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5146i;

/* compiled from: InitializedState */
/* renamed from: com.baidu.tts.o.a.b */
public class C5150b extends C5149a {
    public C5150b(C5152c c5152c) {
        super(c5152c);
    }

    /* renamed from: b */
    public TtsError mo3782b() {
        return null;
    }

    /* renamed from: c */
    public void mo3784c() {
        this.a.m17484i();
    }

    /* renamed from: d */
    public void mo3785d() {
        this.a.m17485j();
    }

    /* renamed from: e */
    public void mo3786e() {
        this.a.m17486k();
    }

    /* renamed from: f */
    public void mo3787f() {
        this.a.m17487l();
        m17454a(this.a.m17466a());
    }

    public void speak(C5146i textParams) {
        this.a.m17472a(textParams);
    }

    public void synthesize(C5146i textParams) {
        this.a.m17477b(textParams);
    }

    public int loadCustomResource(C5142e params) {
        return this.a.m17463a(params);
    }

    public int freeCustomResource(C5142e params) {
        return this.a.m17474b(params);
    }

    public int loadModel(C5144g params) {
        return this.a.m17465a(params);
    }

    public int loadEnglishModel(C5143f params) {
        return this.a.m17464a(params);
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        return this.a.m17460a(leftVolume, rightVolume);
    }

    public int setAudioStreamType(int streamType) {
        return this.a.m17461a(streamType);
    }
}
