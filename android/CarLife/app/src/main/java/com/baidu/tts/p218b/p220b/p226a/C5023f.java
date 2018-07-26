package com.baidu.tts.p218b.p220b.p226a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p220b.C4962a;
import com.baidu.tts.p218b.p220b.C5031b;
import com.baidu.tts.p218b.p220b.p227b.C5026c;
import com.baidu.tts.p225m.C5140a;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p228c.C5033a;
import com.baidu.tts.p233f.C5094l;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PlayExecutor */
/* renamed from: com.baidu.tts.b.b.a.f */
public class C5023f extends C5017a {
    /* renamed from: c */
    private ThreadPoolExecutor f20791c;
    /* renamed from: f */
    private C5026c f20792f;
    /* renamed from: g */
    private C5025h f20793g;
    /* renamed from: h */
    private C5019d f20794h;
    /* renamed from: i */
    private C5024g f20795i;
    /* renamed from: j */
    private C5020e f20796j;

    /* compiled from: PlayExecutor */
    /* renamed from: com.baidu.tts.b.b.a.f$1 */
    class C50211 implements C4962a {
        /* renamed from: a */
        final /* synthetic */ C5023f f20788a;

        C50211(C5023f c5023f) {
            this.f20788a = c5023f;
        }

        /* renamed from: a */
        public void mo3771a(C5145h c5145h) {
            this.f20788a.m16883b(c5145h);
        }

        /* renamed from: b */
        public void mo3772b(C5145h c5145h) {
            this.f20788a.m16884c(c5145h);
        }

        /* renamed from: c */
        public void mo3773c(C5145h c5145h) {
            this.f20788a.m16885d(c5145h);
        }
    }

    /* compiled from: PlayExecutor */
    /* renamed from: com.baidu.tts.b.b.a.f$a */
    private class C5022a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5023f f20789a;
        /* renamed from: b */
        private C5145h f20790b;

        public C5022a(C5023f c5023f, C5145h c5145h) {
            this.f20789a = c5023f;
            this.f20790b = c5145h;
        }

        public void run() {
            LoggerProxy.m17001d("PlayQueueMachine", "enter run");
            this.f20789a.f20792f.mo3862a(this.f20790b);
            LoggerProxy.m17001d("PlayQueueMachine", "end run");
        }
    }

    public C5023f() {
        this.f20793g = new C5025h(this);
        this.f20794h = new C5019d(this);
        this.f20795i = new C5024g(this);
        this.f20796j = new C5020e(this);
        this.b = this.f20793g;
        this.f20792f = C5031b.m16996a().m16998b();
    }

    /* renamed from: m */
    public boolean mo3838m() {
        return this.b == this.f20796j;
    }

    /* renamed from: n */
    public boolean mo3839n() {
        return Thread.currentThread().isInterrupted() || this.b == this.f20794h;
    }

    /* renamed from: p */
    public C5025h m16926p() {
        return this.f20793g;
    }

    /* renamed from: q */
    public C5019d m16927q() {
        return this.f20794h;
    }

    /* renamed from: r */
    public C5024g m16928r() {
        return this.f20795i;
    }

    /* renamed from: s */
    public C5020e m16929s() {
        return this.f20796j;
    }

    /* renamed from: t */
    TtsError m16930t() {
        this.f20792f.mo3863a(new C50211(this));
        return this.f20792f.mo3861a();
    }

    /* renamed from: u */
    void m16931u() {
        this.f20791c = new C5033a(200, "PlayExecutorPoolThread");
    }

    /* renamed from: v */
    void m16932v() {
        this.f20792f.mo3867d();
    }

    /* renamed from: w */
    void m16933w() {
        this.f20792f.mo3866c();
    }

    /* renamed from: x */
    void m16934x() {
        this.f20792f.mo3868e();
        if (this.f20791c != null) {
            if (!this.f20791c.isShutdown()) {
                this.f20791c.shutdownNow();
            }
            try {
                LoggerProxy.m17001d("PlayQueueMachine", "before await");
                LoggerProxy.m17001d("PlayQueueMachine", "after await isTer=" + this.f20791c.awaitTermination(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                LoggerProxy.m17001d("PlayQueueMachine", "InterruptedException");
            }
            this.f20791c = null;
        }
    }

    /* renamed from: y */
    void m16935y() {
        this.f20792f.mo3869f();
    }

    /* renamed from: e */
    void m16923e(C5145h c5145h) {
        this.f20791c.execute(new C5022a(this, c5145h));
    }

    /* renamed from: z */
    void m16936z() {
        this.f20792f.mo3865b();
    }

    /* renamed from: b */
    <T> void m16922b(T t) {
        this.f20792f.mo3864a(((C5140a) t).m17394a());
    }

    /* renamed from: b */
    void m16921b(C4962a c4962a) {
        this.a = c4962a;
    }

    /* renamed from: b */
    int m16919b(float f, float f2) {
        return this.f20792f.mo3870a(f, f2);
    }

    /* renamed from: b */
    int m16920b(int i) {
        return this.f20792f.mo3871a(i);
    }
}
