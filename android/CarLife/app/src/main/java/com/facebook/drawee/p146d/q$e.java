package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$e */
class q$e extends q$a {
    /* renamed from: i */
    public static final q$c f22138i = new q$e();

    private q$e() {
    }

    /* renamed from: a */
    public void mo4051a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY, float scaleX, float scaleY) {
        float scale;
        float dx;
        float dy;
        if (scaleY > scaleX) {
            scale = scaleY;
            dx = ((float) parentRect.left) + ((((float) parentRect.width()) - (((float) childWidth) * scale)) * 0.5f);
            dy = (float) parentRect.top;
        } else {
            scale = scaleX;
            dx = (float) parentRect.left;
            dy = ((float) parentRect.top) + ((((float) parentRect.height()) - (((float) childHeight) * scale)) * 0.5f);
        }
        outTransform.setScale(scale, scale);
        outTransform.postTranslate((float) ((int) (dx + 0.5f)), (float) ((int) (dy + 0.5f)));
    }
}
