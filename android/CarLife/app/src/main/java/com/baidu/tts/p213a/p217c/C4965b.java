package com.baidu.tts.p213a.p217c;

import android.util.Log;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p219a.C4960b;
import com.baidu.tts.p218b.p219a.p222a.C4984d;
import com.baidu.tts.p218b.p220b.C4962a;
import com.baidu.tts.p218b.p220b.p226a.C5016c;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5091i;

/* compiled from: TtsAdapter */
/* renamed from: com.baidu.tts.a.c.b */
public class C4965b implements C4959a {
    /* renamed from: a */
    private C4984d f20640a;
    /* renamed from: b */
    private C5016c f20641b;
    /* renamed from: c */
    private TtsListener f20642c;
    /* renamed from: d */
    private C4960b f20643d;
    /* renamed from: e */
    private C4962a f20644e;
    /* renamed from: f */
    private C4960b f20645f;

    /* compiled from: TtsAdapter */
    /* renamed from: com.baidu.tts.a.c.b$1 */
    class C49611 implements C4960b {
        /* renamed from: a */
        final /* synthetic */ C4965b f20637a;

        C49611(C4965b c4965b) {
            this.f20637a = c4965b;
        }

        /* renamed from: a */
        public void mo3766a(C5145h c5145h) {
            if (this.f20637a.f20642c != null) {
                this.f20637a.f20642c.onSynthesizeStart(c5145h);
            }
        }

        /* renamed from: b */
        public void mo3767b(C5145h c5145h) {
            if (this.f20637a.f20642c != null) {
                this.f20637a.f20642c.onSynthesizeFinished(c5145h);
            }
        }

        /* renamed from: c */
        public void mo3768c(C5145h c5145h) {
            if (this.f20637a.f20642c != null) {
                this.f20637a.f20642c.onSynthesizeDataArrived(c5145h);
            }
        }

        /* renamed from: d */
        public void mo3769d(C5145h c5145h) {
            if (this.f20637a.f20642c != null) {
                this.f20637a.f20642c.onError(c5145h);
            }
        }

        /* renamed from: e */
        public void mo3770e(C5145h c5145h) {
            LoggerProxy.m17001d("TtsAdapter", "onSynthesizeStop");
        }
    }

    /* compiled from: TtsAdapter */
    /* renamed from: com.baidu.tts.a.c.b$2 */
    class C49632 implements C4962a {
        /* renamed from: a */
        final /* synthetic */ C4965b f20638a;

        C49632(C4965b c4965b) {
            this.f20638a = c4965b;
        }

        /* renamed from: a */
        public void mo3771a(C5145h c5145h) {
            if (this.f20638a.f20642c != null) {
                this.f20638a.f20642c.onPlayStart(c5145h);
            }
        }

        /* renamed from: b */
        public void mo3772b(C5145h c5145h) {
            if (this.f20638a.f20642c != null) {
                this.f20638a.f20642c.onPlayProgressUpdate(c5145h);
            }
        }

        /* renamed from: c */
        public void mo3773c(C5145h c5145h) {
            if (this.f20638a.f20642c != null) {
                try {
                    this.f20638a.f20642c.onPlayFinished(c5145h);
                } catch (Exception e) {
                    Log.e("TtsAdapter", "onPlayFinished exception e=" + e.toString());
                }
            }
        }
    }

    /* compiled from: TtsAdapter */
    /* renamed from: com.baidu.tts.a.c.b$3 */
    class C49643 implements C4960b {
        /* renamed from: a */
        final /* synthetic */ C4965b f20639a;

        C49643(C4965b c4965b) {
            this.f20639a = c4965b;
        }

        /* renamed from: a */
        public void mo3766a(C5145h c5145h) {
            if (this.f20639a.m16509a(c5145h)) {
                this.f20639a.f20641b.mo3857a(c5145h);
            }
        }

        /* renamed from: b */
        public void mo3767b(C5145h c5145h) {
            if (this.f20639a.m16509a(c5145h)) {
                this.f20639a.f20641b.mo3857a(c5145h);
            }
        }

        /* renamed from: c */
        public void mo3768c(C5145h c5145h) {
            if (this.f20639a.m16509a(c5145h)) {
                this.f20639a.f20641b.mo3857a(c5145h);
            }
        }

        /* renamed from: d */
        public void mo3769d(C5145h c5145h) {
        }

        /* renamed from: e */
        public void mo3770e(C5145h c5145h) {
        }
    }

    public C4965b(C4984d c4984d, C5016c c5016c, C5148j c5148j) {
        this.f20640a = c4984d;
        this.f20641b = c5016c;
    }

    /* renamed from: b */
    public TtsError mo3782b() {
        TtsError b = this.f20640a.mo3782b();
        this.f20641b.mo3782b();
        m16527g();
        return b;
    }

    /* renamed from: c */
    public void mo3784c() {
        this.f20640a.mo3784c();
        this.f20641b.mo3784c();
    }

    /* renamed from: d */
    public void mo3785d() {
        this.f20640a.mo3785d();
        this.f20641b.mo3785d();
    }

    /* renamed from: e */
    public void mo3786e() {
        LoggerProxy.m17001d("TtsAdapter", "before engine stop");
        this.f20640a.mo3786e();
        LoggerProxy.m17001d("TtsAdapter", "after engine stop");
        this.f20641b.mo3786e();
        LoggerProxy.m17001d("TtsAdapter", "after play stop");
    }

    /* renamed from: f */
    public void mo3787f() {
        LoggerProxy.m17001d("TtsAdapter", "before engine destroy");
        this.f20640a.mo3787f();
        LoggerProxy.m17001d("TtsAdapter", "after engine destroy");
        this.f20641b.mo3787f();
        LoggerProxy.m17001d("TtsAdapter", "after player destroy");
    }

    /* renamed from: a */
    public void mo3779a(TtsListener ttsListener) {
        this.f20642c = ttsListener;
        m16517a(this.f20640a);
        m16518a(this.f20641b);
    }

    /* renamed from: a */
    public void mo3780a(C5146i c5146i) {
        this.f20640a.mo3829a(c5146i);
    }

    /* renamed from: b */
    public void mo3783b(C5146i c5146i) {
        this.f20641b.mo3859o();
        this.f20640a.mo3829a(c5146i);
    }

    /* renamed from: a */
    protected void m16517a(C4984d c4984d) {
        if (this.f20643d == null) {
            this.f20643d = new C49611(this);
        }
        c4984d.mo3828a(this.f20643d);
    }

    /* renamed from: a */
    protected void m16518a(C5016c c5016c) {
        if (this.f20644e == null) {
            this.f20644e = new C49632(this);
        }
        c5016c.mo3856a(this.f20644e);
    }

    /* renamed from: g */
    protected void m16527g() {
        this.f20645f = new C49643(this);
        this.f20640a.mo3828a(this.f20645f);
    }

    /* renamed from: a */
    private boolean m16509a(C5145h c5145h) {
        C5146i e = c5145h.m17431e();
        if (e == null) {
            return false;
        }
        return C5091i.m17277a(e.m17446g());
    }

    /* renamed from: a */
    public int mo3775a(C5142e c5142e) {
        return this.f20640a.mo3824a(c5142e);
    }

    /* renamed from: b */
    public int mo3781b(C5142e c5142e) {
        return this.f20640a.mo3831b(c5142e);
    }

    /* renamed from: a */
    public int mo3777a(C5144g c5144g) {
        return this.f20640a.mo3826a(c5144g);
    }

    /* renamed from: a */
    public int mo3776a(C5143f c5143f) {
        return this.f20640a.mo3825a(c5143f);
    }

    /* renamed from: a */
    public int mo3774a(float f, float f2) {
        return this.f20641b.mo3854a(f, f2);
    }

    /* renamed from: a */
    public C5016c mo3778a() {
        return this.f20641b;
    }
}
