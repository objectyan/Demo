package com.baidu.tts.p243o.p244a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.auth.C4974a;
import com.baidu.tts.p213a.p217c.C4965b;
import com.baidu.tts.p213a.p217c.C4966c;
import com.baidu.tts.p218b.p219a.C4994a;
import com.baidu.tts.p218b.p219a.p222a.C4984d;
import com.baidu.tts.p218b.p220b.p226a.C5016c;
import com.baidu.tts.p218b.p220b.p226a.C5023f;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5088f;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5095m;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p236h.p238b.C5107b;

/* compiled from: Tts */
/* renamed from: com.baidu.tts.o.a.c */
public class C5152c implements ITts {
    /* renamed from: a */
    static final /* synthetic */ boolean f21277a = (!C5152c.class.desiredAssertionStatus());
    /* renamed from: b */
    private C5148j f21278b = new C5148j();
    /* renamed from: c */
    private TtsListener f21279c;
    /* renamed from: d */
    private C5095m f21280d;
    /* renamed from: e */
    private C4966c f21281e;
    /* renamed from: f */
    private volatile C5149a f21282f = this.f21283g;
    /* renamed from: g */
    private C5153d f21283g = new C5153d(this);
    /* renamed from: h */
    private C5150b f21284h = new C5150b(this);

    /* renamed from: b */
    public TtsError mo3782b() {
        return this.f21282f.mo3782b();
    }

    /* renamed from: c */
    public void mo3784c() {
        this.f21282f.mo3784c();
    }

    /* renamed from: d */
    public void mo3785d() {
        this.f21282f.mo3785d();
    }

    /* renamed from: e */
    public void mo3786e() {
        this.f21282f.mo3786e();
    }

    /* renamed from: f */
    public void mo3787f() {
        this.f21282f.mo3787f();
    }

    public void setTtsListener(TtsListener ttsListener) {
        this.f21282f.setTtsListener(ttsListener);
    }

    public TtsListener getTtsListener() {
        return this.f21282f.getTtsListener();
    }

    public void setContext(Context context) {
        this.f21282f.setContext(context);
    }

    public void setMode(C5095m mode) {
        this.f21282f.setMode(mode);
    }

    public C5095m getMode() {
        return this.f21282f.getMode();
    }

    public AuthInfo auth(C5095m ttsEnum) {
        return this.f21282f.auth(ttsEnum);
    }

    public int setParam(C5089g key, String value) {
        return this.f21282f.setParam(key, value);
    }

    public void speak(C5146i textParams) {
        this.f21282f.speak(textParams);
    }

    public void synthesize(C5146i textParams) {
        this.f21282f.synthesize(textParams);
    }

    public int loadCustomResource(C5142e params) {
        return this.f21282f.loadCustomResource(params);
    }

    public int freeCustomResource(C5142e params) {
        return this.f21282f.freeCustomResource(params);
    }

    public int loadModel(C5144g params) {
        return this.f21282f.loadModel(params);
    }

    public int loadEnglishModel(C5143f params) {
        return this.f21282f.loadEnglishModel(params);
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        return this.f21282f.setStereoVolume(leftVolume, rightVolume);
    }

    public int setAudioStreamType(int streamType) {
        return this.f21282f.setAudioStreamType(streamType);
    }

    public C5148j getTtsParams() {
        return this.f21282f.getTtsParams();
    }

    /* renamed from: a */
    void m17473a(C5149a c5149a) {
        this.f21282f = c5149a;
    }

    /* renamed from: a */
    public C5153d m17466a() {
        return this.f21283g;
    }

    /* renamed from: g */
    public C5150b m17482g() {
        return this.f21284h;
    }

    /* renamed from: h */
    TtsError m17483h() {
        Object obj = null;
        if (this.f21280d == null) {
            this.f21280d = C5095m.ONLINE;
        }
        if (this.f21278b == null) {
            this.f21278b = new C5148j();
        }
        TtsError b = C5107b.m17306a().mo3782b();
        if (f21277a || b == null) {
            C4984d a;
            switch (this.f21280d) {
                case ONLINE:
                    a = C4994a.m16719a().m16723a(C5088f.ONLINE);
                    obj = this.f21278b.m17451c();
                    break;
                case OFFLINE:
                    a = C4994a.m16719a().m16723a(C5088f.OFFLINE);
                    obj = this.f21278b.m17452d();
                    break;
                case MIX:
                    a = C4994a.m16719a().m16723a(C5088f.MIX);
                    obj = this.f21278b.m17449a();
                    break;
                default:
                    a = null;
                    break;
            }
            if (a == null || obj == null) {
                return C5105c.m17295a().m17302b(C5097n.TTS_UNINITIAL);
            }
            a.mo3830a(obj);
            C5016c c5023f = new C5023f();
            c5023f.mo3858a(this.f21278b.m17450b());
            this.f21281e = new C4966c();
            this.f21281e.m16533a(new C4965b(a, c5023f, this.f21278b));
            if (this.f21279c != null) {
                this.f21281e.m16534a(this.f21279c);
            }
            return this.f21281e.m16532a();
        }
        throw new AssertionError();
    }

    /* renamed from: i */
    void m17484i() {
        this.f21281e.m16537b();
    }

    /* renamed from: j */
    void m17485j() {
        this.f21281e.m16539c();
    }

    /* renamed from: k */
    void m17486k() {
        this.f21281e.m16540d();
    }

    /* renamed from: l */
    void m17487l() {
        this.f21281e.m16541e();
        C4974a.m16566a().m16575b();
        C5107b.m17306a().mo3787f();
        this.f21278b = new C5148j();
    }

    /* renamed from: a */
    void m17469a(TtsListener ttsListener) {
        if (ttsListener != null && ttsListener != this.f21279c) {
            this.f21279c = ttsListener;
            if (this.f21281e != null) {
                this.f21281e.m16534a(this.f21279c);
            }
        }
    }

    /* renamed from: m */
    TtsListener m17488m() {
        return this.f21279c;
    }

    /* renamed from: a */
    void m17467a(Context context) {
        C5107b.m17306a().m17309a(context);
    }

    /* renamed from: a */
    void m17470a(C5095m c5095m) {
        this.f21280d = c5095m;
    }

    /* renamed from: n */
    C5095m m17489n() {
        return this.f21280d;
    }

    /* renamed from: b */
    AuthInfo m17476b(C5095m c5095m) {
        return C4974a.m16566a().m16571a(c5095m, this.f21278b);
    }

    /* renamed from: a */
    int m17462a(C5089g c5089g, String str) {
        if (this.f21278b != null) {
            return this.f21278b.m17448a(c5089g, str);
        }
        return 0;
    }

    /* renamed from: a */
    void m17472a(C5146i c5146i) {
        this.f21281e.m16535a(c5146i);
    }

    /* renamed from: b */
    void m17477b(C5146i c5146i) {
        this.f21281e.m16538b(c5146i);
    }

    /* renamed from: a */
    int m17463a(C5142e c5142e) {
        return this.f21281e.m16529a(c5142e);
    }

    /* renamed from: b */
    int m17474b(C5142e c5142e) {
        return this.f21281e.m16536b(c5142e);
    }

    /* renamed from: a */
    int m17465a(C5144g c5144g) {
        return this.f21281e.m16531a(c5144g);
    }

    /* renamed from: a */
    int m17464a(C5143f c5143f) {
        return this.f21281e.m16530a(c5143f);
    }

    /* renamed from: o */
    C5148j m17490o() {
        return this.f21278b;
    }

    /* renamed from: a */
    int m17460a(float f, float f2) {
        return this.f21281e.m16528a(f, f2);
    }

    /* renamed from: a */
    int m17461a(int i) {
        try {
            return this.f21281e.m16542f().mo3778a().mo3855a(i);
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: p */
    public int m17491p() {
        if (this.f21279c == null) {
            throw new IllegalStateException(C5097n.TTS_UNINITIAL.m17285c());
        }
        m17468a(C5105c.m17295a().m17302b(C5097n.TTS_UNINITIAL));
        return -1;
    }

    /* renamed from: a */
    public void m17468a(TtsError ttsError) {
        m17471a(C5145h.m17415b(ttsError));
    }

    /* renamed from: a */
    public void m17471a(C5145h c5145h) {
        if (this.f21279c != null) {
            this.f21279c.onError(c5145h);
        }
    }

    /* renamed from: q */
    public boolean m17492q() {
        return this.f21284h == this.f21282f;
    }
}
