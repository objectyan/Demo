package com.facebook.p135b.p136a;

import android.net.Uri;
import com.facebook.common.internal.C5350k;

/* compiled from: SimpleCacheKey */
/* renamed from: com.facebook.b.a.i */
public class C5251i implements C5247d {
    /* renamed from: a */
    final String f21764a;

    public C5251i(String key) {
        this.f21764a = (String) C5350k.m18310a((Object) key);
    }

    public String toString() {
        return this.f21764a;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C5251i)) {
            return false;
        }
        return this.f21764a.equals(((C5251i) o).f21764a);
    }

    public int hashCode() {
        return this.f21764a.hashCode();
    }

    /* renamed from: a */
    public boolean mo3933a(Uri uri) {
        return this.f21764a.contains(uri.toString());
    }
}
