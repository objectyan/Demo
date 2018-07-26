package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C5350k;

/* compiled from: MatrixDrawable */
/* renamed from: com.facebook.drawee.d.i */
public class C5407i extends C5402h {
    /* renamed from: a */
    private Matrix f22079a;
    /* renamed from: c */
    private Matrix f22080c;
    /* renamed from: d */
    private int f22081d = 0;
    /* renamed from: e */
    private int f22082e = 0;

    public C5407i(Drawable drawable, Matrix matrix) {
        super((Drawable) C5350k.m18310a((Object) drawable));
        this.f22079a = matrix;
    }

    /* renamed from: b */
    public Drawable mo4036b(Drawable newDelegate) {
        Drawable previousDelegate = super.mo4036b(newDelegate);
        m18534d();
        return previousDelegate;
    }

    /* renamed from: b */
    public Matrix m18536b() {
        return this.f22079a;
    }

    /* renamed from: c */
    public void m18538c(Matrix matrix) {
        this.f22079a = matrix;
        m18534d();
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        m18533c();
        if (this.f22080c != null) {
            int saveCount = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f22080c);
            super.draw(canvas);
            canvas.restoreToCount(saveCount);
            return;
        }
        super.draw(canvas);
    }

    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        m18534d();
    }

    /* renamed from: c */
    private void m18533c() {
        if (this.f22081d != getCurrent().getIntrinsicWidth() || this.f22082e != getCurrent().getIntrinsicHeight()) {
            m18534d();
        }
    }

    /* renamed from: d */
    private void m18534d() {
        Drawable underlyingDrawable = getCurrent();
        Rect bounds = getBounds();
        int underlyingWidth = underlyingDrawable.getIntrinsicWidth();
        this.f22081d = underlyingWidth;
        int underlyingHeight = underlyingDrawable.getIntrinsicHeight();
        this.f22082e = underlyingHeight;
        if (underlyingWidth <= 0 || underlyingHeight <= 0) {
            underlyingDrawable.setBounds(bounds);
            this.f22080c = null;
            return;
        }
        underlyingDrawable.setBounds(0, 0, underlyingWidth, underlyingHeight);
        this.f22080c = this.f22079a;
    }

    /* renamed from: a */
    public void mo4031a(Matrix transform) {
        super.mo4031a(transform);
        if (this.f22080c != null) {
            transform.preConcat(this.f22080c);
        }
    }
}
