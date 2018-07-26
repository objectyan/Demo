package com.baidu.tts.p218b.p219a.p222a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p219a.C4960b;
import com.baidu.tts.p218b.p219a.p223b.C4995b;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p234g.p235a.C5102a;
import com.baidu.tts.p236h.p237a.C5105c;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: EngineExecutor */
/* renamed from: com.baidu.tts.b.a.a.c */
public class C4989c extends C4985a {
    /* renamed from: f */
    private ExecutorService f20703f;
    /* renamed from: g */
    private C4993h f20704g;
    /* renamed from: h */
    private C4990e f20705h;
    /* renamed from: i */
    private C4992g f20706i;
    /* renamed from: j */
    private C4991f f20707j;

    /* compiled from: EngineExecutor */
    /* renamed from: com.baidu.tts.b.a.a.c$1 */
    class C49871 implements C4960b {
        /* renamed from: a */
        final /* synthetic */ C4989c f20700a;

        C49871(C4989c c4989c) {
            this.f20700a = c4989c;
        }

        /* renamed from: e */
        public void mo3770e(C5145h c5145h) {
        }

        /* renamed from: a */
        public void mo3766a(C5145h c5145h) {
        }

        /* renamed from: b */
        public void mo3767b(C5145h c5145h) {
        }

        /* renamed from: c */
        public void mo3768c(C5145h c5145h) {
            this.f20700a.m16648b(c5145h);
        }

        /* renamed from: d */
        public void mo3769d(C5145h c5145h) {
        }
    }

    /* compiled from: EngineExecutor */
    /* renamed from: com.baidu.tts.b.a.a.c$a */
    private class C4988a implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C4989c f20701a;
        /* renamed from: b */
        private C5146i f20702b;

        public /* synthetic */ Object call() throws Exception {
            return m16678a();
        }

        public C4988a(C4989c c4989c, C5146i c5146i) {
            this.f20701a = c4989c;
            this.f20702b = c5146i;
        }

        /* renamed from: a */
        public Void m16678a() throws Exception {
            try {
                this.f20701a.m16644a(C5145h.m17416b(this.f20702b));
                TtsError a = this.f20701a.a.mo3844a(this.f20702b);
                if (a == null) {
                    this.f20701a.m16649c(C5145h.m17416b(this.f20702b));
                } else {
                    this.f20701a.m16651e(C5145h.m17414a(this.f20702b, a));
                }
            } catch (InterruptedException e) {
            }
            return null;
        }
    }

    public C4989c() {
        this.f20704g = new C4993h(this);
        this.f20705h = new C4990e(this);
        this.f20706i = new C4992g(this);
        this.f20707j = new C4991f(this);
        this.c = this.f20704g;
    }

    /* renamed from: m */
    public boolean mo3838m() {
        return this.c == this.f20707j;
    }

    /* renamed from: n */
    public boolean mo3839n() {
        return Thread.currentThread().isInterrupted() || this.c == this.f20705h;
    }

    /* renamed from: o */
    public C4993h m16690o() {
        return this.f20704g;
    }

    /* renamed from: p */
    public C4990e m16691p() {
        return this.f20705h;
    }

    /* renamed from: q */
    public C4992g m16692q() {
        return this.f20706i;
    }

    /* renamed from: r */
    public C4991f m16693r() {
        return this.f20707j;
    }

    /* renamed from: s */
    TtsError m16694s() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.a.mo3845a(new C49871(this));
        return this.a.mo3843a();
    }

    /* renamed from: t */
    void m16695t() {
        this.f20703f = Executors.newSingleThreadExecutor(new C5102a("EngineExecutorPoolThread"));
    }

    /* renamed from: u */
    void m16696u() {
    }

    /* renamed from: v */
    void m16697v() {
    }

    /* renamed from: w */
    void m16698w() {
        if (this.f20703f != null) {
            if (!this.f20703f.isShutdown()) {
                this.f20703f.shutdownNow();
            }
            try {
                LoggerProxy.m17001d("EngineExecutor", "before awaitTermination");
                boolean awaitTermination = this.f20703f.awaitTermination(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS);
                LoggerProxy.m17001d("EngineExecutor", "after awaitTermination isTermination=" + awaitTermination);
                m16679a(awaitTermination);
            } catch (InterruptedException e) {
                m16679a(false);
            }
            this.f20703f = null;
        }
    }

    /* renamed from: x */
    void m16699x() {
        this.a.mo3848b();
        this.b = null;
    }

    /* renamed from: b */
    int m16681b(C5144g c5144g) {
        return this.a.mo3842a(c5144g);
    }

    /* renamed from: b */
    int m16680b(C5143f c5143f) {
        return this.a.mo3849a(c5143f);
    }

    /* renamed from: c */
    int m16686c(C5142e c5142e) {
        return this.a.mo3841a(c5142e);
    }

    /* renamed from: d */
    int m16687d(C5142e c5142e) {
        return this.a.mo3847b(c5142e);
    }

    /* renamed from: b */
    void m16682b(C4995b c4995b) {
        this.a = c4995b;
    }

    /* renamed from: b */
    void m16683b(C4960b c4960b) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (!this.b.contains(c4960b)) {
            this.b.add(c4960b);
        }
    }

    /* renamed from: b */
    <T> void m16685b(T t) {
        this.a.mo3846a((Object) t);
    }

    /* renamed from: b */
    void m16684b(C5146i c5146i) {
        this.f20703f.submit(new C4988a(this, c5146i));
    }

    /* renamed from: a */
    private void m16679a(boolean z) {
        if (z) {
            m16650d(null);
            return;
        }
        C5145h c5145h = new C5145h();
        c5145h.m17419a(C5105c.m17295a().m17302b(C5097n.TTS_ENGINE_STOP_FAILURE));
        m16650d(c5145h);
    }
}
