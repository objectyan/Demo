package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$h */
class q$h extends q$a {
    /* renamed from: i */
    public static final q$c f22141i = new q$h();

    private q$h() {
    }

    /* renamed from: a */
    public void mo4051a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY, float scaleX, float scaleY) {
        float scale = Math.min(scaleX, scaleY);
        float dx = ((float) parentRect.left) + (((float) parentRect.width()) - (((float) childWidth) * scale));
        float dy = ((float) parentRect.top) + (((float) parentRect.height()) - (((float) childHeight) * scale));
        outTransform.setScale(scale, scale);
        outTransform.postTranslate((float) ((int) (dx + 0.5f)), (float) ((int) (dy + 0.5f)));
    }
}
