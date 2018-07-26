package com.facebook.imagepipeline.p149d;

import android.net.Uri;
import com.facebook.imagepipeline.p154m.C2957e;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p135b.p136a.C5251i;
import javax.annotation.Nullable;

/* compiled from: DefaultCacheKeyFactory */
/* renamed from: com.facebook.imagepipeline.d.j */
public class C5479j implements C5477f {
    /* renamed from: a */
    private static C5479j f22305a = null;

    protected C5479j() {
    }

    /* renamed from: a */
    public static synchronized C5479j m18791a() {
        C5479j c5479j;
        synchronized (C5479j.class) {
            if (f22305a == null) {
                f22305a = new C5479j();
            }
            c5479j = f22305a;
        }
        return c5479j;
    }

    /* renamed from: a */
    public C5247d mo4062a(C2959c request, Object callerContext) {
        return new C2941c(m18792a(request.b()).toString(), request.e(), request.g(), request.f(), null, null, callerContext);
    }

    /* renamed from: b */
    public C5247d mo4063b(C2959c request, Object callerContext) {
        C5247d postprocessorCacheKey;
        String postprocessorName;
        C2957e postprocessor = request.n();
        if (postprocessor != null) {
            postprocessorCacheKey = postprocessor.b();
            postprocessorName = postprocessor.getClass().getName();
        } else {
            postprocessorCacheKey = null;
            postprocessorName = null;
        }
        return new C2941c(m18792a(request.b()).toString(), request.e(), request.g(), request.f(), postprocessorCacheKey, postprocessorName, callerContext);
    }

    /* renamed from: c */
    public C5247d mo4064c(C2959c request, @Nullable Object callerContext) {
        return new C5251i(m18792a(request.b()).toString());
    }

    /* renamed from: a */
    protected Uri m18792a(Uri sourceUri) {
        return sourceUri;
    }
}
