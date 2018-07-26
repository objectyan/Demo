package com.facebook.drawee.p266b;

/* compiled from: RetryManager */
/* renamed from: com.facebook.drawee.b.c */
public class C5394c {
    /* renamed from: a */
    private static final int f22035a = 4;
    /* renamed from: b */
    private boolean f22036b;
    /* renamed from: c */
    private int f22037c;
    /* renamed from: d */
    private int f22038d;

    public C5394c() {
        m18449b();
    }

    /* renamed from: a */
    public static C5394c m18446a() {
        return new C5394c();
    }

    /* renamed from: b */
    public void m18449b() {
        this.f22036b = false;
        this.f22037c = 4;
        m18450c();
    }

    /* renamed from: c */
    public void m18450c() {
        this.f22038d = 0;
    }

    /* renamed from: d */
    public boolean m18451d() {
        return this.f22036b;
    }

    /* renamed from: a */
    public void m18448a(boolean tapToRetryEnabled) {
        this.f22036b = tapToRetryEnabled;
    }

    /* renamed from: a */
    public void m18447a(int maxTapToRetryAttemps) {
        this.f22037c = maxTapToRetryAttemps;
    }

    /* renamed from: e */
    public boolean m18452e() {
        return this.f22036b && this.f22038d < this.f22037c;
    }

    /* renamed from: f */
    public void m18453f() {
        this.f22038d++;
    }
}
