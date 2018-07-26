package com.facebook.imagepipeline.p276e;

import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ImageDecodeOptions */
/* renamed from: com.facebook.imagepipeline.e.a */
public class C5492a {
    /* renamed from: h */
    private static final C5492a f22321h = C5492a.m18847b().m18863h();
    /* renamed from: a */
    public final int f22322a;
    /* renamed from: b */
    public final int f22323b;
    /* renamed from: c */
    public final boolean f22324c;
    /* renamed from: d */
    public final boolean f22325d;
    /* renamed from: e */
    public final boolean f22326e;
    /* renamed from: f */
    public final boolean f22327f;
    /* renamed from: g */
    public final boolean f22328g;

    public C5492a(C5493b b) {
        this.f22322a = b.m18848a();
        this.f22323b = b.m18852b();
        this.f22324c = b.m18856c();
        this.f22325d = b.m18858d();
        this.f22326e = b.m18860e();
        this.f22327f = b.m18861f();
        this.f22328g = b.m18862g();
    }

    /* renamed from: a */
    public static C5492a m18846a() {
        return f22321h;
    }

    /* renamed from: b */
    public static C5493b m18847b() {
        return new C5493b();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C5492a that = (C5492a) o;
        if (this.f22323b != that.f22323b) {
            return false;
        }
        if (this.f22324c != that.f22324c) {
            return false;
        }
        if (this.f22325d != that.f22325d) {
            return false;
        }
        if (this.f22326e != that.f22326e) {
            return false;
        }
        if (this.f22327f != that.f22327f) {
            return false;
        }
        if (this.f22328g != that.f22328g) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f22323b * 31) + (this.f22324c ? 1 : 0);
    }

    public String toString() {
        return String.format((Locale) null, "%d-%d-%b-%b-%b-%b-%b", new Object[]{Integer.valueOf(this.f22322a), Integer.valueOf(this.f22323b), Boolean.valueOf(this.f22324c), Boolean.valueOf(this.f22325d), Boolean.valueOf(this.f22326e), Boolean.valueOf(this.f22327f), Boolean.valueOf(this.f22328g)});
    }
}
