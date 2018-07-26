package com.baidu.tts.p239i.p240a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.Iterator;

/* compiled from: UtteranceSubpackager */
/* renamed from: com.baidu.tts.i.a.b */
public class C5109b implements Iterator<C5108a> {
    /* renamed from: a */
    private int f21218a;
    /* renamed from: b */
    private int f21219b;
    /* renamed from: c */
    private int f21220c;
    /* renamed from: d */
    private int f21221d;
    /* renamed from: e */
    private int f21222e;
    /* renamed from: f */
    private int f21223f;
    /* renamed from: g */
    private int f21224g;

    public /* synthetic */ Object next() {
        return m17333c();
    }

    /* renamed from: a */
    public void m17330a(int i) {
        this.f21220c = i;
    }

    /* renamed from: a */
    public void m17329a() {
        this.f21218a = 0;
        this.f21219b = 0;
        this.f21221d = 0;
        this.f21222e = 0;
        this.f21223f = 0;
        this.f21224g = 0;
    }

    /* renamed from: b */
    public void m17331b() {
    }

    /* renamed from: b */
    public void m17332b(int i) {
        this.f21219b += i;
        this.f21223f = 0;
    }

    /* renamed from: e */
    private int m17327e() {
        return (this.f21218a + this.f21219b) - 1;
    }

    /* renamed from: f */
    private int m17328f() {
        return (this.f21221d + this.f21220c) - 1;
    }

    public boolean hasNext() {
        return this.f21222e < m17327e();
    }

    /* renamed from: c */
    public C5108a m17333c() {
        C5108a c5108a = new C5108a();
        int f = m17328f();
        if (f <= m17327e()) {
            int i = (f - this.f21222e) + 1;
            c5108a.m17321a(this.f21223f);
            c5108a.m17324b(i);
            this.f21222e = f + 1;
            this.f21221d = this.f21222e;
            this.f21223f += i;
            float f2 = ((float) this.f21221d) / ((float) this.f21219b);
            LoggerProxy.m17001d("UtteranceSubpackager", "mCurrentProgressStartIndex=" + this.f21221d + "--mCurrentAllUtteranceLenght=" + this.f21219b + "--percent=" + f2);
            c5108a.m17320a(f2);
            c5108a.m17322a(true);
        } else {
            f = this.f21219b - this.f21222e;
            c5108a.m17321a(this.f21223f);
            c5108a.m17324b(f);
            this.f21222e += f;
            this.f21223f = f + this.f21223f;
        }
        return c5108a;
    }

    public void remove() {
    }

    /* renamed from: d */
    public int m17335d() {
        return this.f21224g;
    }

    /* renamed from: c */
    public void m17334c(int i) {
        this.f21224g = i;
    }
}
