package com.facebook.imagepipeline.p154m;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.p276e.C5492a;
import com.facebook.imagepipeline.p276e.C5494c;
import com.facebook.imagepipeline.p276e.C5495d;
import javax.annotation.Nullable;

/* compiled from: ImageRequestBuilder */
/* renamed from: com.facebook.imagepipeline.m.d */
public class C2960d {
    /* renamed from: a */
    private Uri f13199a = null;
    /* renamed from: b */
    private c$b f13200b = c$b.f22715a;
    /* renamed from: c */
    private boolean f13201c = false;
    @Nullable
    /* renamed from: d */
    private C5495d f13202d = null;
    /* renamed from: e */
    private C5492a f13203e = C5492a.a();
    /* renamed from: f */
    private c$a f13204f = c$a.f22713b;
    /* renamed from: g */
    private boolean f13205g = false;
    /* renamed from: h */
    private boolean f13206h = false;
    /* renamed from: i */
    private C5494c f13207i = C5494c.f22338c;
    @Nullable
    /* renamed from: j */
    private C2957e f13208j = null;
    /* renamed from: k */
    private boolean f13209k = true;

    /* renamed from: a */
    public static C2960d m11933a(Uri uri) {
        return new C2960d().m11944b(uri);
    }

    /* renamed from: a */
    public static C2960d m11932a(int resId) {
        return C2960d.m11933a(new Builder().scheme(C2924g.f12892f).path(String.valueOf(resId)).build());
    }

    /* renamed from: a */
    public static C2960d m11934a(C2959c imageRequest) {
        return C2960d.m11933a(imageRequest.m11919b()).m11942a(imageRequest.m11924g()).m11936a(imageRequest.m11923f()).m11939a(imageRequest.m11918a()).m11946c(imageRequest.m11926i()).m11940a(imageRequest.m11928k()).m11941a(imageRequest.m11931n()).m11945b(imageRequest.m11925h()).m11937a(imageRequest.m11927j()).m11938a(imageRequest.m11922e());
    }

    private C2960d() {
    }

    /* renamed from: b */
    public C2960d m11944b(Uri uri) {
        C5350k.a(uri);
        this.f13199a = uri;
        return this;
    }

    /* renamed from: a */
    public Uri m11935a() {
        return this.f13199a;
    }

    /* renamed from: a */
    public C2960d m11940a(c$b requestLevel) {
        this.f13200b = requestLevel;
        return this;
    }

    /* renamed from: b */
    public c$b m11943b() {
        return this.f13200b;
    }

    /* renamed from: a */
    public C2960d m11942a(boolean enabled) {
        this.f13201c = enabled;
        return this;
    }

    /* renamed from: c */
    public boolean m11947c() {
        return this.f13201c;
    }

    /* renamed from: a */
    public C2960d m11938a(C5495d resizeOptions) {
        this.f13202d = resizeOptions;
        return this;
    }

    @Nullable
    /* renamed from: d */
    public C5495d m11948d() {
        return this.f13202d;
    }

    /* renamed from: a */
    public C2960d m11936a(C5492a imageDecodeOptions) {
        this.f13203e = imageDecodeOptions;
        return this;
    }

    /* renamed from: e */
    public C5492a m11949e() {
        return this.f13203e;
    }

    /* renamed from: a */
    public C2960d m11939a(c$a cacheChoice) {
        this.f13204f = cacheChoice;
        return this;
    }

    /* renamed from: f */
    public c$a m11950f() {
        return this.f13204f;
    }

    /* renamed from: b */
    public C2960d m11945b(boolean enabled) {
        this.f13205g = enabled;
        return this;
    }

    /* renamed from: g */
    public boolean m11951g() {
        return this.f13205g;
    }

    /* renamed from: c */
    public C2960d m11946c(boolean enabled) {
        this.f13206h = enabled;
        return this;
    }

    /* renamed from: h */
    public boolean m11952h() {
        return this.f13206h;
    }

    /* renamed from: i */
    public C2960d m11953i() {
        this.f13209k = false;
        return this;
    }

    /* renamed from: j */
    public boolean m11954j() {
        return this.f13209k && C2924g.m11278a(this.f13199a);
    }

    /* renamed from: a */
    public C2960d m11937a(C5494c requestPriority) {
        this.f13207i = requestPriority;
        return this;
    }

    /* renamed from: k */
    public C5494c m11955k() {
        return this.f13207i;
    }

    /* renamed from: a */
    public C2960d m11941a(C2957e postprocessor) {
        this.f13208j = postprocessor;
        return this;
    }

    @Nullable
    /* renamed from: l */
    public C2957e m11956l() {
        return this.f13208j;
    }

    /* renamed from: m */
    public C2959c m11957m() {
        m11958n();
        return new C2959c(this);
    }

    /* renamed from: n */
    protected void m11958n() {
        if (this.f13199a == null) {
            throw new d$a("Source must be set!");
        }
        if (C2924g.m11284g(this.f13199a)) {
            if (!this.f13199a.isAbsolute()) {
                throw new d$a("Resource URI path must be absolute.");
            } else if (this.f13199a.getPath().isEmpty()) {
                throw new d$a("Resource URI must not be empty");
            } else {
                try {
                    Integer.parseInt(this.f13199a.getPath().substring(1));
                } catch (NumberFormatException e) {
                    throw new d$a("Resource URI path must be a resource id.");
                }
            }
        }
        if (C2924g.m11283f(this.f13199a) && !this.f13199a.isAbsolute()) {
            throw new d$a("Asset URI path must be absolute.");
        }
    }
}
