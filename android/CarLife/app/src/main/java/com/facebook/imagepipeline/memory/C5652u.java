package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: PoolFactory */
/* renamed from: com.facebook.imagepipeline.memory.u */
public class C5652u {
    /* renamed from: a */
    private final C5651t f22808a;
    /* renamed from: b */
    private C5629d f22809b;
    /* renamed from: c */
    private C5638k f22810c;
    /* renamed from: d */
    private C5639m f22811d;
    /* renamed from: e */
    private C5642z f22812e;
    /* renamed from: f */
    private ac f22813f;
    /* renamed from: g */
    private ad f22814g;
    /* renamed from: h */
    private C5630f f22815h;

    public C5652u(C5651t config) {
        this.f22808a = (C5651t) C5350k.m18310a((Object) config);
    }

    /* renamed from: a */
    public C5629d m19624a() {
        if (this.f22809b == null) {
            this.f22809b = new C5629d(this.f22808a.m19618c(), this.f22808a.m19616a(), this.f22808a.m19617b());
        }
        return this.f22809b;
    }

    /* renamed from: b */
    public C5638k m19625b() {
        if (this.f22810c == null) {
            this.f22810c = new C5638k(this.f22808a.m19618c(), this.f22808a.m19621f());
        }
        return this.f22810c;
    }

    /* renamed from: c */
    public int m19626c() {
        return this.f22808a.m19621f().f22822g;
    }

    /* renamed from: d */
    public C5639m m19627d() {
        if (this.f22811d == null) {
            this.f22811d = new C5639m(this.f22808a.m19618c(), this.f22808a.m19619d(), this.f22808a.m19620e());
        }
        return this.f22811d;
    }

    /* renamed from: e */
    public C5642z m19628e() {
        if (this.f22812e == null) {
            this.f22812e = new C5643o(m19627d(), m19629f());
        }
        return this.f22812e;
    }

    /* renamed from: f */
    public ac m19629f() {
        if (this.f22813f == null) {
            this.f22813f = new ac(m19631h());
        }
        return this.f22813f;
    }

    /* renamed from: g */
    public ad m19630g() {
        if (this.f22814g == null) {
            this.f22814g = new ad(this.f22808a.m19618c(), this.f22808a.m19621f());
        }
        return this.f22814g;
    }

    /* renamed from: h */
    public C5630f m19631h() {
        if (this.f22815h == null) {
            this.f22815h = new C5636l(this.f22808a.m19618c(), this.f22808a.m19622g(), this.f22808a.m19623h());
        }
        return this.f22815h;
    }
}
