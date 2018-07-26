package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$j */
class q$j extends q$a {
    /* renamed from: i */
    public static final q$c f22143i = new q$j();

    private q$j() {
    }

    /* renamed from: a */
    public void mo4051a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY, float scaleX, float scaleY) {
        float dx = (float) parentRect.left;
        float dy = (float) parentRect.top;
        outTransform.setScale(scaleX, scaleY);
        outTransform.postTranslate((float) ((int) (dx + 0.5f)), (float) ((int) (0.5f + dy)));
    }
}
