package com.facebook.imagepipeline.p276e;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p141m.C5366b;
import java.util.Locale;

/* compiled from: ResizeOptions */
/* renamed from: com.facebook.imagepipeline.e.d */
public class C5495d {
    /* renamed from: a */
    public final int f22340a;
    /* renamed from: b */
    public final int f22341b;

    public C5495d(int width, int height) {
        boolean z;
        boolean z2 = true;
        if (width > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (height <= 0) {
            z2 = false;
        }
        C5350k.m18315a(z2);
        this.f22340a = width;
        this.f22341b = height;
    }

    public int hashCode() {
        return C5366b.m18365a(this.f22340a, this.f22341b);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof C5495d)) {
            return false;
        }
        C5495d that = (C5495d) other;
        if (this.f22340a == that.f22340a && this.f22341b == that.f22341b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format((Locale) null, "%dx%d", new Object[]{Integer.valueOf(this.f22340a), Integer.valueOf(this.f22341b)});
    }
}
