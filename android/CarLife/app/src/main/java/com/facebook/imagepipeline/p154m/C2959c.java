package com.facebook.imagepipeline.p154m;

import android.net.Uri;
import com.facebook.common.internal.C2923j;
import com.facebook.imagepipeline.p276e.C5492a;
import com.facebook.imagepipeline.p276e.C5494c;
import com.facebook.imagepipeline.p276e.C5495d;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ImageRequest */
/* renamed from: com.facebook.imagepipeline.m.c */
public class C2959c {
    @Nullable
    /* renamed from: a */
    C5495d f13187a = null;
    /* renamed from: b */
    private final c$a f13188b;
    /* renamed from: c */
    private final Uri f13189c;
    /* renamed from: d */
    private File f13190d;
    /* renamed from: e */
    private final boolean f13191e;
    /* renamed from: f */
    private final boolean f13192f;
    /* renamed from: g */
    private final C5492a f13193g;
    /* renamed from: h */
    private final boolean f13194h;
    /* renamed from: i */
    private final C5494c f13195i;
    /* renamed from: j */
    private final c$b f13196j;
    /* renamed from: k */
    private final boolean f13197k;
    /* renamed from: l */
    private final C2957e f13198l;

    /* renamed from: a */
    public static C2959c m11916a(@Nullable Uri uri) {
        return uri == null ? null : C2960d.m11933a(uri).m11957m();
    }

    /* renamed from: a */
    public static C2959c m11917a(@Nullable String uriString) {
        return (uriString == null || uriString.length() == 0) ? null : C2959c.m11916a(Uri.parse(uriString));
    }

    protected C2959c(C2960d builder) {
        this.f13188b = builder.m11950f();
        this.f13189c = builder.m11935a();
        this.f13191e = builder.m11951g();
        this.f13192f = builder.m11952h();
        this.f13193g = builder.m11949e();
        this.f13187a = builder.m11948d();
        this.f13194h = builder.m11947c();
        this.f13195i = builder.m11955k();
        this.f13196j = builder.m11943b();
        this.f13197k = builder.m11954j();
        this.f13198l = builder.m11956l();
    }

    /* renamed from: a */
    public c$a m11918a() {
        return this.f13188b;
    }

    /* renamed from: b */
    public Uri m11919b() {
        return this.f13189c;
    }

    /* renamed from: c */
    public int m11920c() {
        return this.f13187a != null ? this.f13187a.f22340a : 2048;
    }

    /* renamed from: d */
    public int m11921d() {
        return this.f13187a != null ? this.f13187a.f22341b : 2048;
    }

    @Nullable
    /* renamed from: e */
    public C5495d m11922e() {
        return this.f13187a;
    }

    /* renamed from: f */
    public C5492a m11923f() {
        return this.f13193g;
    }

    /* renamed from: g */
    public boolean m11924g() {
        return this.f13194h;
    }

    /* renamed from: h */
    public boolean m11925h() {
        return this.f13191e;
    }

    /* renamed from: i */
    public boolean m11926i() {
        return this.f13192f;
    }

    /* renamed from: j */
    public C5494c m11927j() {
        return this.f13195i;
    }

    /* renamed from: k */
    public c$b m11928k() {
        return this.f13196j;
    }

    /* renamed from: l */
    public boolean m11929l() {
        return this.f13197k;
    }

    /* renamed from: m */
    public synchronized File m11930m() {
        if (this.f13190d == null) {
            this.f13190d = new File(this.f13189c.getPath());
        }
        return this.f13190d;
    }

    @Nullable
    /* renamed from: n */
    public C2957e m11931n() {
        return this.f13198l;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C2959c)) {
            return false;
        }
        C2959c request = (C2959c) o;
        if (C2923j.m11273a(this.f13189c, request.f13189c) && C2923j.m11273a(this.f13188b, request.f13188b) && C2923j.m11273a(this.f13190d, request.f13190d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C2923j.m11269a(this.f13188b, this.f13189c, this.f13190d);
    }
}
