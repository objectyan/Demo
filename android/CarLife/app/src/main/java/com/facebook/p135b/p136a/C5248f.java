package com.facebook.p135b.p136a;

import android.net.Uri;
import com.facebook.common.internal.C5350k;
import java.util.List;

/* compiled from: MultiCacheKey */
/* renamed from: com.facebook.b.a.f */
public class C5248f implements C5247d {
    /* renamed from: a */
    final List<C5247d> f21761a;

    public C5248f(List<C5247d> cacheKeys) {
        this.f21761a = (List) C5350k.m18310a((Object) cacheKeys);
    }

    /* renamed from: a */
    public List<C5247d> m17839a() {
        return this.f21761a;
    }

    public String toString() {
        return "MultiCacheKey:" + this.f21761a.toString();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C5248f)) {
            return false;
        }
        return this.f21761a.equals(((C5248f) o).f21761a);
    }

    public int hashCode() {
        return this.f21761a.hashCode();
    }

    /* renamed from: a */
    public boolean mo3933a(Uri uri) {
        for (int i = 0; i < this.f21761a.size(); i++) {
            if (((C5247d) this.f21761a.get(i)).mo3933a(uri)) {
                return true;
            }
        }
        return false;
    }
}
