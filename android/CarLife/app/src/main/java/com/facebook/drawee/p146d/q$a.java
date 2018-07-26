package com.facebook.drawee.p146d;

import android.graphics.Matrix;
import android.graphics.Rect;

/* compiled from: ScalingUtils */
/* renamed from: com.facebook.drawee.d.q$a */
public abstract class q$a implements q$c {
    /* renamed from: a */
    public abstract void mo4051a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

    /* renamed from: a */
    public Matrix mo4050a(Matrix outTransform, Rect parentRect, int childWidth, int childHeight, float focusX, float focusY) {
        mo4051a(outTransform, parentRect, childWidth, childHeight, focusX, focusY, ((float) parentRect.width()) / ((float) childWidth), ((float) parentRect.height()) / ((float) childHeight));
        return outTransform;
    }
}
