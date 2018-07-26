package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import com.baidu.tts.p234g.p235a.C5102a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: LoggerChain */
/* renamed from: com.baidu.tts.chainofresponsibility.logger.d */
public class C5041d {
    /* renamed from: a */
    private static volatile C5041d f20825a = null;
    /* renamed from: b */
    private List<C5035b> f20826b = m17018g();
    /* renamed from: c */
    private ExecutorService f20827c;
    /* renamed from: d */
    private C5043f f20828d = new C5043f();
    /* renamed from: e */
    private C5042e f20829e = new C5042e();
    /* renamed from: f */
    private C5039a f20830f = C5039a.RELEASE;
    /* renamed from: g */
    private boolean f20831g = false;

    /* compiled from: LoggerChain */
    /* renamed from: com.baidu.tts.chainofresponsibility.logger.d$a */
    private enum C5039a {
        DEVELOP,
        RELEASE
    }

    /* compiled from: LoggerChain */
    /* renamed from: com.baidu.tts.chainofresponsibility.logger.d$b */
    private class C5040b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5041d f20823a;
        /* renamed from: b */
        private C5037c f20824b;

        public C5040b(C5041d c5041d, C5037c c5037c) {
            this.f20823a = c5041d;
            this.f20824b = c5037c;
        }

        public void run() {
            for (C5035b a : this.f20823a.f20826b) {
                a.mo3872a(this.f20824b, null, C5041d.f20825a);
            }
        }
    }

    private C5041d() {
        this.f20826b.add(this.f20828d);
        this.f20827c = Executors.newSingleThreadExecutor(new C5102a("LoggerChainPoolThread"));
    }

    /* renamed from: g */
    private List<C5035b> m17018g() {
        return this.f20826b == null ? new CopyOnWriteArrayList() : this.f20826b;
    }

    /* renamed from: a */
    public static C5041d m17013a() {
        if (f20825a == null) {
            synchronized (C5041d.class) {
                if (f20825a == null) {
                    f20825a = new C5041d();
                }
            }
        }
        return f20825a;
    }

    /* renamed from: b */
    public void m17024b() {
        if (this.f20826b != null) {
            this.f20826b.clear();
        }
    }

    /* renamed from: a */
    public void m17023a(boolean z) {
        this.f20831g = z;
    }

    /* renamed from: a */
    public void m17021a(String str) {
        if (this.f20829e != null) {
            this.f20829e.m17031a(str);
        }
    }

    /* renamed from: a */
    public void m17022a(List<String> list) {
        if (this.f20829e != null) {
            this.f20829e.m17032a((List) list);
        }
    }

    /* renamed from: b */
    public void m17025b(String str) {
        if (this.f20829e != null) {
            this.f20829e.m17033b(str);
        }
    }

    /* renamed from: c */
    public void m17026c() {
        if (this.f20829e != null) {
            this.f20829e.m17029a();
        }
    }

    /* renamed from: d */
    public void m17027d() {
        this.f20830f = C5039a.RELEASE;
    }

    /* renamed from: e */
    public boolean m17028e() {
        return this.f20830f == null || this.f20830f == C5039a.RELEASE;
    }

    /* renamed from: a */
    public void m17019a(int i, String str, String str2) {
        m17015a(new C5037c(), i, str, str2);
    }

    /* renamed from: a */
    private void m17015a(C5037c c5037c, int i, String str, String str2) {
        if (c5037c == null) {
            c5037c = new C5037c();
        }
        c5037c.m17007a(i);
        c5037c.m17008a(str);
        c5037c.m17010b(str2);
        m17020a(c5037c);
    }

    /* renamed from: a */
    public void m17020a(C5037c c5037c) {
        if (c5037c != null) {
            switch (this.f20830f) {
                case DEVELOP:
                    c5037c.m17007a(6);
                    this.f20829e.m17030a(c5037c, null, f20825a);
                    break;
                case RELEASE:
                    if (this.f20831g) {
                        this.f20829e.m17030a(c5037c, null, f20825a);
                        break;
                    }
                    break;
            }
            m17016b(c5037c);
        }
    }

    /* renamed from: b */
    private void m17016b(C5037c c5037c) {
        try {
            if (this.f20827c != null && !this.f20827c.isShutdown()) {
                this.f20827c.execute(new C5040b(this, c5037c));
            }
        } catch (Exception e) {
            Log.e("LoggerChain", "executeWork exception=" + e.toString());
        }
    }
}
