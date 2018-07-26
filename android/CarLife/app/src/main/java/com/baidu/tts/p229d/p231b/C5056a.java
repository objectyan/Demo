package com.baidu.tts.p229d.p231b;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.database.C5068a;

/* compiled from: DownloadTrace */
/* renamed from: com.baidu.tts.d.b.a */
public class C5056a {
    /* renamed from: a */
    private static volatile C5056a f20911a = null;
    /* renamed from: b */
    private C5060e f20912b = C5060e.m17155a();
    /* renamed from: c */
    private C5068a f20913c;

    private C5056a() {
    }

    /* renamed from: a */
    public static C5056a m17101a() {
        if (f20911a == null) {
            synchronized (C5056a.class) {
                if (f20911a == null) {
                    f20911a = new C5056a();
                }
            }
        }
        return f20911a;
    }

    /* renamed from: b */
    public C5068a m17107b() {
        return this.f20913c;
    }

    /* renamed from: a */
    public void m17104a(C5068a c5068a) {
        this.f20913c = c5068a;
    }

    /* renamed from: a */
    public C5057b m17102a(String str) {
        return this.f20912b.m17161c(str);
    }

    /* renamed from: b */
    public C5059d m17106b(String str) {
        return this.f20912b.m17156a(str);
    }

    /* renamed from: c */
    public C5058c m17108c(String str) {
        return this.f20912b.m17159b(str);
    }

    /* renamed from: d */
    public long m17110d(String str) {
        return this.f20912b.m17163e(str);
    }

    /* renamed from: e */
    public int m17111e(String str) {
        return this.f20912b.m17164f(str);
    }

    /* renamed from: a */
    public void m17103a(DownloadHandler downloadHandler) {
        this.f20912b.m17157a(downloadHandler);
    }

    /* renamed from: a */
    public void m17105a(String str, String str2) {
        this.f20912b.m17158a(str, str2);
    }

    /* renamed from: c */
    public void m17109c() {
        this.f20912b.m17160b();
    }
}
