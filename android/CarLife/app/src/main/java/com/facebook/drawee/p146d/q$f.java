package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$f */
class q$f extends q$a {
    /* renamed from: i */
    public static final q$c f22139i = new q$f();

    private q$f() {
    }

    /* renamed from: a */
    public void mo4051a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY, float scaleX, float scaleY) {
        float scale = Math.min(Math.min(scaleX, scaleY), 1.0f);
        float dx = ((float) parentRect.left) + ((((float) parentRect.width()) - (((float) childWidth) * scale)) * 0.5f);
        float dy = ((float) parentRect.top) + ((((float) parentRect.height()) - (((float) childHeight) * scale)) * 0.5f);
        outTransform.setScale(scale, scale);
        outTransform.postTranslate((float) ((int) (dx + 0.5f)), (float) ((int) (dy + 0.5f)));
    }
}
