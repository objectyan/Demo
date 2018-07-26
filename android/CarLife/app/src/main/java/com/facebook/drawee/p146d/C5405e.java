package com.facebook.drawee.p146d;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableProperties */
/* renamed from: com.facebook.drawee.d.e */
public class C5405e {
    /* renamed from: a */
    private static final int f22061a = -1;
    /* renamed from: b */
    private int f22062b = -1;
    /* renamed from: c */
    private boolean f22063c = false;
    /* renamed from: d */
    private ColorFilter f22064d = null;
    /* renamed from: e */
    private int f22065e = -1;
    /* renamed from: f */
    private int f22066f = -1;

    /* renamed from: a */
    public void m18510a(int alpha) {
        this.f22062b = alpha;
    }

    /* renamed from: a */
    public void m18511a(ColorFilter colorFilter) {
        this.f22064d = colorFilter;
        this.f22063c = true;
    }

    /* renamed from: a */
    public void m18513a(boolean dither) {
        this.f22065e = dither ? 1 : 0;
    }

    /* renamed from: b */
    public void m18514b(boolean filterBitmap) {
        this.f22066f = filterBitmap ? 1 : 0;
    }

    /* renamed from: a */
    public void m18512a(Drawable drawable) {
        boolean z = true;
        if (drawable != null) {
            if (this.f22062b != -1) {
                drawable.setAlpha(this.f22062b);
            }
            if (this.f22063c) {
                drawable.setColorFilter(this.f22064d);
            }
            if (this.f22065e != -1) {
                boolean z2;
                if (this.f22065e != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable.setDither(z2);
            }
            if (this.f22066f != -1) {
                if (this.f22066f == 0) {
                    z = false;
                }
                drawable.setFilterBitmap(z);
            }
        }
    }
}
