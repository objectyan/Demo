package com.baidu.tts.p236h.p237a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p233f.C5097n;
import java.util.Hashtable;

/* compiled from: TtsErrorPool */
/* renamed from: com.baidu.tts.h.a.c */
public class C5105c {
    /* renamed from: a */
    private static volatile C5105c f21205a = null;
    /* renamed from: b */
    private Hashtable<C5097n, C5104b> f21206b = new Hashtable();

    private C5105c() {
    }

    /* renamed from: a */
    public static C5105c m17295a() {
        if (f21205a == null) {
            synchronized (C5105c.class) {
                if (f21205a == null) {
                    f21205a = new C5105c();
                }
            }
        }
        return f21205a;
    }

    /* renamed from: a */
    public C5104b m17301a(C5097n c5097n) {
        C5104b c5104b = (C5104b) this.f21206b.get(c5097n);
        if (c5104b != null) {
            return c5104b;
        }
        c5104b = new C5104b(c5097n);
        this.f21206b.put(c5097n, c5104b);
        return c5104b;
    }

    /* renamed from: b */
    public TtsError m17302b(C5097n c5097n) {
        C5104b a = m17301a(c5097n);
        TtsError ttsError = new TtsError();
        ttsError.setTtsErrorFlyweight(a);
        return ttsError;
    }

    /* renamed from: a */
    public TtsError m17300a(C5097n c5097n, Throwable th) {
        TtsError b = m17302b(c5097n);
        b.setThrowable(th);
        return b;
    }

    /* renamed from: a */
    public TtsError m17296a(C5097n c5097n, int i) {
        return m17297a(c5097n, i, null);
    }

    /* renamed from: a */
    public TtsError m17299a(C5097n c5097n, String str) {
        return m17297a(c5097n, 0, str);
    }

    /* renamed from: a */
    public TtsError m17297a(C5097n c5097n, int i, String str) {
        return m17298a(c5097n, i, str, null);
    }

    /* renamed from: a */
    public TtsError m17298a(C5097n c5097n, int i, String str, Throwable th) {
        TtsError b = m17302b(c5097n);
        b.setCode(i);
        b.setMessage(str);
        b.setThrowable(th);
        return b;
    }
}
