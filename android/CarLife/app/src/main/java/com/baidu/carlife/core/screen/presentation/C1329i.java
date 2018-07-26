package com.baidu.carlife.core.screen.presentation;

import android.view.Surface;

/* compiled from: DisplaySpec */
/* renamed from: com.baidu.carlife.core.screen.presentation.i */
public class C1329i {
    /* renamed from: a */
    private int f3826a;
    /* renamed from: b */
    private int f3827b;
    /* renamed from: c */
    private int f3828c;
    /* renamed from: d */
    private Surface f3829d;
    /* renamed from: e */
    private int f3830e;

    /* renamed from: a */
    public int m4780a() {
        return this.f3826a;
    }

    /* renamed from: a */
    public void m4781a(int width) {
        this.f3826a = width;
    }

    /* renamed from: b */
    public int m4783b() {
        return this.f3827b;
    }

    /* renamed from: b */
    public void m4784b(int height) {
        this.f3827b = height;
    }

    /* renamed from: c */
    public int m4785c() {
        return this.f3828c;
    }

    /* renamed from: c */
    public void m4786c(int densityDpi) {
        this.f3828c = densityDpi;
    }

    /* renamed from: d */
    public Surface m4787d() {
        return this.f3829d;
    }

    /* renamed from: a */
    public void m4782a(Surface surface) {
        this.f3829d = surface;
    }

    /* renamed from: e */
    public int m4789e() {
        return this.f3830e;
    }

    /* renamed from: d */
    public void m4788d(int flag) {
        this.f3830e = flag;
    }

    public C1329i(int width, int height, int densityDpi, Surface surface, int flag) {
        this.f3826a = width;
        this.f3827b = height;
        this.f3828c = densityDpi;
        this.f3829d = surface;
        this.f3830e = flag;
    }

    public String toString() {
        return "DisplaySpec{width=" + this.f3826a + ", height=" + this.f3827b + ", densityDpi=" + this.f3828c + ", surface=" + this.f3829d + ", flag=" + this.f3830e + '}';
    }
}
