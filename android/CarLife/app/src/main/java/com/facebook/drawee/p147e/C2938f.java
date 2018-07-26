package com.facebook.drawee.p147e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.C5350k;
import com.facebook.drawee.p146d.C2931m;
import com.facebook.drawee.p146d.C5399d;
import com.facebook.drawee.p146d.C5402h;
import com.facebook.drawee.p146d.C5407i;
import com.facebook.drawee.p146d.C5410l;
import com.facebook.drawee.p146d.C5411n;
import com.facebook.drawee.p146d.C5414o;
import com.facebook.drawee.p146d.C5415p;
import com.facebook.drawee.p146d.q$c;
import com.facebook.drawee.p147e.C5419e.C5418a;
import javax.annotation.Nullable;

/* compiled from: WrappingUtils */
/* renamed from: com.facebook.drawee.e.f */
public class C2938f {
    /* renamed from: a */
    private static final Drawable f13016a = new ColorDrawable(0);

    @Nullable
    /* renamed from: a */
    static Drawable m11551a(@Nullable Drawable drawable, @Nullable q$c scaleType) {
        return C2938f.m11552a(drawable, scaleType, null);
    }

    @Nullable
    /* renamed from: a */
    static Drawable m11552a(@Nullable Drawable drawable, @Nullable q$c scaleType, @Nullable PointF focusPoint) {
        if (drawable == null || scaleType == null) {
            return drawable;
        }
        Drawable scaleTypeDrawable = new C5415p(drawable, scaleType);
        if (focusPoint == null) {
            return scaleTypeDrawable;
        }
        scaleTypeDrawable.a(focusPoint);
        return scaleTypeDrawable;
    }

    @Nullable
    /* renamed from: a */
    static Drawable m11550a(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new C5407i(drawable, matrix);
    }

    /* renamed from: a */
    static C5415p m11556a(C5399d parent, q$c scaleType) {
        Drawable child = C2938f.m11551a(parent.a(f13016a), scaleType);
        parent.a(child);
        C5350k.a(child, "Parent has no child drawable!");
        return (C5415p) child;
    }

    /* renamed from: a */
    static void m11557a(C5399d parent, @Nullable C5419e roundingParams) {
        Drawable child = parent.a();
        if (roundingParams == null || roundingParams.c() != C5418a.f22145a) {
            if (child instanceof C5414o) {
                parent.a(((C5414o) child).b(f13016a));
                f13016a.setCallback(null);
            }
        } else if (child instanceof C5414o) {
            C5410l roundedCornersDrawable = (C5414o) child;
            C2938f.m11560a(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.a(roundingParams.d());
        } else {
            parent.a(C2938f.m11553a(parent.a(f13016a), roundingParams));
        }
    }

    /* renamed from: a */
    static void m11558a(C5399d parent, @Nullable C5419e roundingParams, Resources resources) {
        parent = C2938f.m11555a(parent);
        Drawable child = parent.a();
        if (roundingParams == null || roundingParams.c() != C5418a.f22146b) {
            if (child instanceof C5410l) {
                C2938f.m11559a((C5410l) child);
            }
        } else if (child instanceof C5410l) {
            C2938f.m11560a((C5410l) child, roundingParams);
        } else if (child != null) {
            parent.a(f13016a);
            parent.a(C2938f.m11561b(child, roundingParams, resources));
        }
    }

    /* renamed from: a */
    static Drawable m11553a(@Nullable Drawable drawable, @Nullable C5419e roundingParams) {
        if (drawable == null || roundingParams == null || roundingParams.c() != C5418a.f22145a) {
            return drawable;
        }
        C5410l roundedCornersDrawable = new C5414o(drawable);
        C2938f.m11560a(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.a(roundingParams.d());
        return roundedCornersDrawable;
    }

    /* renamed from: a */
    static Drawable m11554a(@Nullable Drawable drawable, @Nullable C5419e roundingParams, Resources resources) {
        if (drawable == null || roundingParams == null || roundingParams.c() != C5418a.f22146b) {
            return drawable;
        }
        if (!(drawable instanceof C5402h)) {
            return C2938f.m11561b(drawable, roundingParams, resources);
        }
        C5399d parent = C2938f.m11555a((C5402h) drawable);
        parent.a(C2938f.m11561b(parent.a(f13016a), roundingParams, resources));
        return drawable;
    }

    /* renamed from: b */
    private static Drawable m11561b(Drawable drawable, C5419e roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            C5410l roundedBitmapDrawable = new C2931m(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            C2938f.m11560a(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        } else if (!(drawable instanceof ColorDrawable) || VERSION.SDK_INT < 11) {
            return drawable;
        } else {
            C5410l roundedColorDrawable = C5411n.a((ColorDrawable) drawable);
            C2938f.m11560a(roundedColorDrawable, roundingParams);
            return roundedColorDrawable;
        }
    }

    /* renamed from: a */
    static void m11560a(C5410l rounded, C5419e roundingParams) {
        rounded.a(roundingParams.a());
        rounded.a(roundingParams.b());
        rounded.a(roundingParams.g(), roundingParams.f());
        rounded.b(roundingParams.h());
    }

    /* renamed from: a */
    static void m11559a(C5410l rounded) {
        rounded.a(false);
        rounded.a(0.0f);
        rounded.a(0, 0.0f);
        rounded.b(0.0f);
    }

    /* renamed from: a */
    static C5399d m11555a(C5399d parent) {
        while (true) {
            Drawable child = parent.a();
            if (child == parent || !(child instanceof C5399d)) {
                return parent;
            }
            parent = (C5399d) child;
        }
        return parent;
    }
}
