package com.baidu.tts.p218b.p219a.p223b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p219a.C4960b;
import com.baidu.tts.p218b.p219a.p223b.C5008e.C5006b;
import com.baidu.tts.p225m.C5141b;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;

/* compiled from: MixSynthesizer */
/* renamed from: com.baidu.tts.b.a.b.d */
public class C5001d extends C4996a {
    /* renamed from: b */
    private C5141b f20715b;
    /* renamed from: c */
    private C5013f f20716c = new C5013f();
    /* renamed from: d */
    private C5008e f20717d = new C5008e();
    /* renamed from: e */
    private C4998c f20718e = new C4998c();
    /* renamed from: f */
    private TtsError f20719f;
    /* renamed from: g */
    private int f20720g = 0;
    /* renamed from: h */
    private int f20721h = 0;

    /* compiled from: MixSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.d$1 */
    class C49991 implements C4960b {
        /* renamed from: a */
        final /* synthetic */ C5001d f20713a;

        C49991(C5001d c5001d) {
            this.f20713a = c5001d;
        }

        /* renamed from: a */
        public void mo3766a(C5145h c5145h) {
        }

        /* renamed from: c */
        public void mo3768c(C5145h c5145h) {
            this.f20713a.f20721h = c5145h.m17425b();
            this.f20713a.f20720g = c5145h.m17427c();
            this.f20713a.m16738a(c5145h);
        }

        /* renamed from: b */
        public void mo3767b(C5145h c5145h) {
        }

        /* renamed from: e */
        public void mo3770e(C5145h c5145h) {
        }

        /* renamed from: d */
        public void mo3769d(C5145h c5145h) {
        }
    }

    /* compiled from: MixSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.d$2 */
    class C50002 implements C4960b {
        /* renamed from: a */
        final /* synthetic */ C5001d f20714a;

        C50002(C5001d c5001d) {
            this.f20714a = c5001d;
        }

        /* renamed from: a */
        public void mo3766a(C5145h c5145h) {
        }

        /* renamed from: c */
        public void mo3768c(C5145h c5145h) {
            this.f20714a.m16738a(this.f20714a.m16761b(c5145h));
        }

        /* renamed from: b */
        public void mo3767b(C5145h c5145h) {
        }

        /* renamed from: e */
        public void mo3770e(C5145h c5145h) {
        }

        /* renamed from: d */
        public void mo3769d(C5145h c5145h) {
        }
    }

    /* renamed from: a */
    public TtsError mo3843a() {
        this.f20716c.mo3845a(new C49991(this));
        this.f20717d.mo3845a(new C50002(this));
        this.f20716c.mo3843a();
        this.f20719f = this.f20717d.mo3843a();
        if (this.f20719f != null) {
            return C5105c.m17295a().m17302b(C5097n.MIX_ENGINE_OFFLINE_INIT_FAILURE);
        }
        return null;
    }

    /* renamed from: b */
    public TtsError mo3848b() {
        this.f20716c.mo3848b();
        this.f20717d.mo3848b();
        this.f20718e.m16746a(null);
        return null;
    }

    /* renamed from: a */
    public <AllSynthesizerParams> void mo3846a(AllSynthesizerParams allSynthesizerParams) {
        this.f20715b = (C5141b) allSynthesizerParams;
        Object a = this.f20715b.m17396a();
        a.m16818a(3);
        a.m16822b(500);
        this.f20716c.mo3846a(a);
        this.f20717d.mo3846a(this.f20715b.m17399b());
        this.f20718e.m16746a(this.f20715b);
    }

    /* renamed from: a */
    public TtsError mo3844a(C5146i c5146i) throws InterruptedException {
        this.f20721h = 0;
        this.f20720g = 0;
        if (!this.f20718e.m16747a()) {
            return this.f20717d.mo3844a(c5146i);
        }
        TtsError a = this.f20716c.mo3844a(c5146i);
        if (a == null) {
            return a;
        }
        LoggerProxy.m17001d("MixSynthesizer", "online synthesize ttserror=" + a.getDetailMessage());
        c5146i.m17439b(c5146i.m17440c().substring(this.f20720g));
        return this.f20717d.mo3844a(c5146i);
    }

    /* renamed from: b */
    private C5145h m16761b(C5145h c5145h) {
        int b = c5145h.m17425b();
        if (b >= 0) {
            b += this.f20721h;
        } else {
            b -= this.f20721h;
        }
        c5145h.m17426b(b);
        c5145h.m17429d(c5145h.m17427c() + this.f20720g);
        return c5145h;
    }

    /* renamed from: a */
    public int mo3841a(C5142e c5142e) {
        return this.f20717d.mo3841a(c5142e);
    }

    /* renamed from: b */
    public int mo3847b(C5142e c5142e) {
        return this.f20717d.mo3847b(c5142e);
    }

    /* renamed from: a */
    public int mo3842a(C5144g c5144g) {
        if (this.f20719f == null) {
            return this.f20717d.mo3842a(c5144g);
        }
        String a = c5144g.m17410a();
        String b = c5144g.m17412b();
        C5006b b2 = this.f20715b.m17399b();
        b2.m16795d(a);
        b2.m16797e(b);
        this.f20719f = this.f20717d.mo3843a();
        if (this.f20719f == null) {
            return 0;
        }
        return this.f20719f.getDetailCode();
    }

    /* renamed from: a */
    public int mo3849a(C5143f c5143f) {
        return this.f20717d.mo3849a(c5143f);
    }
}
