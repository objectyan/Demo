package com.baidu.tts.p243o.p244a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5095m;

/* compiled from: ATtsState */
/* renamed from: com.baidu.tts.o.a.a */
public abstract class C5149a implements ITts {
    /* renamed from: a */
    protected C5152c f21275a;

    public C5149a(C5152c c5152c) {
        this.f21275a = c5152c;
    }

    public void setTtsListener(TtsListener ttsListener) {
        this.f21275a.m17469a(ttsListener);
    }

    public TtsListener getTtsListener() {
        return this.f21275a.m17488m();
    }

    public void setContext(Context context) {
        this.f21275a.m17467a(context);
    }

    public void setMode(C5095m mode) {
        this.f21275a.m17470a(mode);
    }

    public C5095m getMode() {
        return this.f21275a.m17489n();
    }

    public AuthInfo auth(C5095m ttsEnum) {
        return this.f21275a.m17476b(ttsEnum);
    }

    public int setParam(C5089g key, String value) {
        return this.f21275a.m17462a(key, value);
    }

    public C5148j getTtsParams() {
        return this.f21275a.m17490o();
    }

    /* renamed from: a */
    public void m17454a(C5149a c5149a) {
        this.f21275a.m17473a(c5149a);
    }
}
