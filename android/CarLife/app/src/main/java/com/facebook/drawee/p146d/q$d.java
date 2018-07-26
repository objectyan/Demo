package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$d */
class q$d extends q$a {
    /* renamed from: i */
    public static final q$c f22137i = new q$d();

    private q$d() {
    }

    /* renamed from: a */
    public void mo4051a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY, float scaleX, float scaleY) {
        outTransform.setTranslate((float) ((int) ((((float) parentRect.left) + (((float) (parentRect.width() - childWidth)) * 0.5f)) + 0.5f)), (float) ((int) ((((float) parentRect.top) + (((float) (parentRect.height() - childHeight)) * 0.5f)) + 0.5f)));
    }
}
