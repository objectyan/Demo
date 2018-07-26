package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: AspectRatioMeasure */
/* renamed from: com.facebook.drawee.view.a */
public class C5426a {

    /* compiled from: AspectRatioMeasure */
    /* renamed from: com.facebook.drawee.view.a$a */
    public static class C5425a {
        /* renamed from: a */
        public int f22164a;
        /* renamed from: b */
        public int f22165b;
    }

    /* renamed from: a */
    public static void m18653a(C5425a spec, float aspectRatio, @Nullable LayoutParams layoutParams, int widthPadding, int heightPadding) {
        if (aspectRatio > 0.0f && layoutParams != null) {
            if (C5426a.m18654a(layoutParams.height)) {
                spec.f22165b = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.f22164a) - widthPadding)) / aspectRatio) + ((float) heightPadding)), spec.f22165b), 1073741824);
            } else if (C5426a.m18654a(layoutParams.width)) {
                spec.f22164a = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.f22165b) - heightPadding)) * aspectRatio) + ((float) widthPadding)), spec.f22164a), 1073741824);
            }
        }
    }

    /* renamed from: a */
    private static boolean m18654a(int layoutDimension) {
        return layoutDimension == 0 || layoutDimension == -2;
    }
}
