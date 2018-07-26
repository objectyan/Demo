package com.baidu.tts.p225m;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p224n.C5004a;
import com.baidu.tts.p233f.C5080a;
import com.baidu.tts.p233f.C5087e;

/* compiled from: ResponseBag */
/* renamed from: com.baidu.tts.m.h */
public class C5145h extends C5004a<C5145h> {
    /* renamed from: a */
    public int f21256a;
    /* renamed from: b */
    private C5087e f21257b;
    /* renamed from: c */
    private int f21258c;
    /* renamed from: d */
    private int f21259d;
    /* renamed from: e */
    private String f21260e;
    /* renamed from: f */
    private int f21261f;
    /* renamed from: g */
    private int f21262g;
    /* renamed from: h */
    private byte[] f21263h;
    /* renamed from: i */
    private C5080a f21264i;
    /* renamed from: j */
    private C5146i f21265j;
    /* renamed from: k */
    private TtsError f21266k;

    /* renamed from: a */
    public int m17417a() {
        return this.f21259d;
    }

    /* renamed from: a */
    public void m17418a(int i) {
        this.f21259d = i;
    }

    /* renamed from: a */
    public void m17423a(String str) {
        this.f21260e = str;
    }

    /* renamed from: b */
    public int m17425b() {
        return this.f21261f;
    }

    /* renamed from: b */
    public void m17426b(int i) {
        this.f21261f = i;
    }

    /* renamed from: c */
    public void m17428c(int i) {
        this.f21256a = i;
    }

    /* renamed from: c */
    public int m17427c() {
        return this.f21262g;
    }

    /* renamed from: d */
    public void m17429d(int i) {
        this.f21262g = i;
    }

    /* renamed from: d */
    public byte[] m17430d() {
        return this.f21263h;
    }

    /* renamed from: a */
    public void m17424a(byte[] bArr) {
        this.f21263h = bArr;
    }

    /* renamed from: e */
    public void m17432e(int i) {
        this.f21258c = i;
    }

    /* renamed from: a */
    public void m17420a(C5080a c5080a) {
        this.f21264i = c5080a;
    }

    /* renamed from: e */
    public C5146i m17431e() {
        return this.f21265j;
    }

    /* renamed from: a */
    public void m17422a(C5146i c5146i) {
        this.f21265j = c5146i;
    }

    /* renamed from: f */
    public TtsError m17433f() {
        return this.f21266k;
    }

    /* renamed from: a */
    public void m17419a(TtsError ttsError) {
        this.f21266k = ttsError;
    }

    /* renamed from: g */
    public C5087e m17434g() {
        return this.f21257b;
    }

    /* renamed from: a */
    public void m17421a(C5087e c5087e) {
        this.f21257b = c5087e;
    }

    /* renamed from: b */
    public static C5145h m17416b(C5146i c5146i) {
        C5145h c5145h = new C5145h();
        c5145h.m17422a(c5146i);
        return c5145h;
    }

    /* renamed from: b */
    public static C5145h m17415b(TtsError ttsError) {
        C5145h c5145h = new C5145h();
        c5145h.m17419a(ttsError);
        return c5145h;
    }

    /* renamed from: a */
    public static C5145h m17414a(C5146i c5146i, TtsError ttsError) {
        C5145h b = C5145h.m17416b(c5146i);
        b.m17419a(ttsError);
        return b;
    }
}
