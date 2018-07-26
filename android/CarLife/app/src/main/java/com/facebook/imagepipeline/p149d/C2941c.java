package com.facebook.imagepipeline.p149d;

import android.net.Uri;
import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p141m.C5366b;
import com.facebook.common.p262l.C5363e;
import com.facebook.imagepipeline.p276e.C5492a;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p135b.p136a.C5247d;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: BitmapMemoryCacheKey */
/* renamed from: com.facebook.imagepipeline.d.c */
public class C2941c implements C5247d {
    /* renamed from: a */
    private final String f13036a;
    @Nullable
    /* renamed from: b */
    private final C5495d f13037b;
    /* renamed from: c */
    private final boolean f13038c;
    /* renamed from: d */
    private final C5492a f13039d;
    @Nullable
    /* renamed from: e */
    private final C5247d f13040e;
    @Nullable
    /* renamed from: f */
    private final String f13041f;
    /* renamed from: g */
    private final int f13042g;
    /* renamed from: h */
    private final Object f13043h;
    /* renamed from: i */
    private final long f13044i;

    public C2941c(String sourceString, @Nullable C5495d resizeOptions, boolean autoRotated, C5492a imageDecodeOptions, @Nullable C5247d postprocessorCacheKey, @Nullable String postprocessorName, Object callerContext) {
        this.f13036a = (String) C5350k.a(sourceString);
        this.f13037b = resizeOptions;
        this.f13038c = autoRotated;
        this.f13039d = imageDecodeOptions;
        this.f13040e = postprocessorCacheKey;
        this.f13041f = postprocessorName;
        this.f13042g = C5366b.a(Integer.valueOf(sourceString.hashCode()), Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), Integer.valueOf(autoRotated ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode()), this.f13039d, this.f13040e, postprocessorName);
        this.f13043h = callerContext;
        this.f13044i = C5363e.a().b();
    }

    public boolean equals(Object o) {
        if (!(o instanceof C2941c)) {
            return false;
        }
        C2941c otherKey = (C2941c) o;
        if (this.f13042g == otherKey.f13042g && this.f13036a.equals(otherKey.f13036a) && C2923j.m11273a(this.f13037b, otherKey.f13037b) && this.f13038c == otherKey.f13038c && C2923j.m11273a(this.f13039d, otherKey.f13039d) && C2923j.m11273a(this.f13040e, otherKey.f13040e) && C2923j.m11273a(this.f13041f, otherKey.f13041f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f13042g;
    }

    /* renamed from: a */
    public boolean m11596a(Uri uri) {
        return m11595a().contains(uri.toString());
    }

    /* renamed from: a */
    public String m11595a() {
        return this.f13036a;
    }

    @Nullable
    /* renamed from: b */
    public String m11597b() {
        return this.f13041f;
    }

    public String toString() {
        return String.format((Locale) null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.f13036a, this.f13037b, Boolean.toString(this.f13038c), this.f13039d, this.f13040e, this.f13041f, Integer.valueOf(this.f13042g)});
    }

    /* renamed from: c */
    public Object m11598c() {
        return this.f13043h;
    }

    /* renamed from: d */
    public long m11599d() {
        return this.f13044i;
    }
}
