package com.facebook.p135b.p137b;

import android.content.Context;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p254b.C5301b;
import com.facebook.common.p254b.C5302c;
import com.facebook.p135b.p136a.C5244a;
import com.facebook.p135b.p136a.C5246c;
import com.facebook.p135b.p136a.C5249g;
import com.facebook.p135b.p136a.C5250h;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: DiskCacheConfig */
/* renamed from: com.facebook.b.b.c */
public class C5274c {
    /* renamed from: a */
    private final int f21796a;
    /* renamed from: b */
    private final String f21797b;
    /* renamed from: c */
    private final C5273m<File> f21798c;
    /* renamed from: d */
    private final long f21799d;
    /* renamed from: e */
    private final long f21800e;
    /* renamed from: f */
    private final long f21801f;
    /* renamed from: g */
    private final C5270i f21802g;
    /* renamed from: h */
    private final C5244a f21803h;
    /* renamed from: i */
    private final C5246c f21804i;
    /* renamed from: j */
    private final C5301b f21805j;
    /* renamed from: k */
    private final Context f21806k;

    private C5274c(c$a builder) {
        C5244a a;
        C5246c a2;
        C5301b a3;
        this.f21796a = c$a.a(builder);
        this.f21797b = (String) C5350k.m18310a(c$a.b(builder));
        this.f21798c = (C5273m) C5350k.m18310a(c$a.c(builder));
        this.f21799d = c$a.d(builder);
        this.f21800e = c$a.e(builder);
        this.f21801f = c$a.f(builder);
        this.f21802g = (C5270i) C5350k.m18310a(c$a.g(builder));
        if (c$a.h(builder) == null) {
            a = C5249g.m17841a();
        } else {
            a = c$a.h(builder);
        }
        this.f21803h = a;
        if (c$a.i(builder) == null) {
            a2 = C5250h.m17843a();
        } else {
            a2 = c$a.i(builder);
        }
        this.f21804i = a2;
        if (c$a.j(builder) == null) {
            a3 = C5302c.m18084a();
        } else {
            a3 = c$a.j(builder);
        }
        this.f21805j = a3;
        this.f21806k = c$a.k(builder);
    }

    /* renamed from: a */
    public int m17935a() {
        return this.f21796a;
    }

    /* renamed from: b */
    public String m17936b() {
        return this.f21797b;
    }

    /* renamed from: c */
    public C5273m<File> m17937c() {
        return this.f21798c;
    }

    /* renamed from: d */
    public long m17938d() {
        return this.f21799d;
    }

    /* renamed from: e */
    public long m17939e() {
        return this.f21800e;
    }

    /* renamed from: f */
    public long m17940f() {
        return this.f21801f;
    }

    /* renamed from: g */
    public C5270i m17941g() {
        return this.f21802g;
    }

    /* renamed from: h */
    public C5244a m17942h() {
        return this.f21803h;
    }

    /* renamed from: i */
    public C5246c m17943i() {
        return this.f21804i;
    }

    /* renamed from: j */
    public C5301b m17944j() {
        return this.f21805j;
    }

    /* renamed from: k */
    public Context m17945k() {
        return this.f21806k;
    }

    /* renamed from: a */
    public static c$a m17934a(@Nullable Context context) {
        return new c$a(context, null);
    }
}
