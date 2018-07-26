package com.baidu.tts.p229d.p231b;

import com.baidu.tts.client.model.DownloadHandler;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TracePool */
/* renamed from: com.baidu.tts.d.b.e */
public class C5060e {
    /* renamed from: a */
    private static volatile C5060e f20930a = null;
    /* renamed from: b */
    private ConcurrentHashMap<String, C5059d> f20931b = new ConcurrentHashMap();
    /* renamed from: c */
    private ConcurrentHashMap<String, C5058c> f20932c = new ConcurrentHashMap();
    /* renamed from: d */
    private ConcurrentHashMap<String, C5057b> f20933d = new ConcurrentHashMap();

    private C5060e() {
    }

    /* renamed from: a */
    public static C5060e m17155a() {
        if (f20930a == null) {
            synchronized (C5060e.class) {
                if (f20930a == null) {
                    f20930a = new C5060e();
                }
            }
        }
        return f20930a;
    }

    /* renamed from: a */
    public C5059d m17156a(String str) {
        try {
            C5059d c5059d = new C5059d(str);
            C5059d c5059d2 = (C5059d) this.f20931b.putIfAbsent(str, c5059d);
            if (c5059d2 == null) {
                return c5059d;
            }
            return c5059d2;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public C5058c m17159b(String str) {
        try {
            C5058c c5058c = new C5058c(str);
            C5058c c5058c2 = (C5058c) this.f20932c.putIfAbsent(str, c5058c);
            if (c5058c2 == null) {
                return c5058c;
            }
            return c5058c2;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    public C5057b m17161c(String str) {
        try {
            C5057b c5057b = new C5057b(str);
            C5057b c5057b2 = (C5057b) this.f20933d.putIfAbsent(str, c5057b);
            if (c5057b2 == null) {
                return c5057b;
            }
            return c5057b2;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public C5057b m17162d(String str) {
        C5058c b = m17159b(str);
        if (b != null) {
            return m17161c(b.m17131a());
        }
        return null;
    }

    /* renamed from: e */
    public long m17163e(String str) {
        return m17162d(str).m17114a();
    }

    /* renamed from: f */
    public int m17164f(String str) {
        return m17162d(str).m17125d();
    }

    /* renamed from: a */
    public void m17157a(DownloadHandler downloadHandler) {
        m17156a(downloadHandler.getModelId()).m17145b(downloadHandler);
    }

    /* renamed from: a */
    public void m17158a(String str, String str2) {
        C5057b d = m17162d(str);
        if (d != null) {
            d.m17122b(str2);
        }
    }

    /* renamed from: b */
    public void m17160b() {
        for (C5059d a : this.f20931b.values()) {
            a.m17137a();
        }
    }
}
