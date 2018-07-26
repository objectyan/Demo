package com.facebook.imagepipeline.p275c;

import android.graphics.Bitmap;
import com.facebook.common.p140h.C5329c;

/* compiled from: SimpleBitmapReleaser */
/* renamed from: com.facebook.imagepipeline.c.f */
public class C5461f implements C5329c<Bitmap> {
    /* renamed from: a */
    private static C5461f f22271a;

    /* renamed from: a */
    public static C5461f m18739a() {
        if (f22271a == null) {
            f22271a = new C5461f();
        }
        return f22271a;
    }

    private C5461f() {
    }

    /* renamed from: a */
    public void m18740a(Bitmap value) {
        value.recycle();
    }
}
