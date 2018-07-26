package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.platform.comapi.util.C4820d;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: OrientedDrawable */
/* renamed from: com.facebook.drawee.d.j */
public class C5408j extends C5402h {
    @VisibleForTesting
    /* renamed from: a */
    final Matrix f22083a;
    /* renamed from: c */
    private int f22084c;
    /* renamed from: d */
    private final Matrix f22085d = new Matrix();
    /* renamed from: e */
    private final RectF f22086e = new RectF();

    public C5408j(Drawable drawable, int rotationAngle) {
        super(drawable);
        C5350k.m18315a(rotationAngle % 90 == 0);
        this.f22083a = new Matrix();
        this.f22084c = rotationAngle;
    }

    public void draw(Canvas canvas) {
        if (this.f22084c <= 0) {
            super.draw(canvas);
            return;
        }
        int saveCount = canvas.save();
        canvas.concat(this.f22083a);
        super.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public int getIntrinsicWidth() {
        return this.f22084c % C4820d.f19955a == 0 ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    public int getIntrinsicHeight() {
        return this.f22084c % C4820d.f19955a == 0 ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    protected void onBoundsChange(Rect bounds) {
        Drawable underlyingDrawable = getCurrent();
        if (this.f22084c > 0) {
            this.f22083a.setRotate((float) this.f22084c, (float) bounds.centerX(), (float) bounds.centerY());
            this.f22085d.reset();
            this.f22083a.invert(this.f22085d);
            this.f22086e.set(bounds);
            this.f22085d.mapRect(this.f22086e);
            underlyingDrawable.setBounds((int) this.f22086e.left, (int) this.f22086e.top, (int) this.f22086e.right, (int) this.f22086e.bottom);
            return;
        }
        underlyingDrawable.setBounds(bounds);
    }

    /* renamed from: a */
    public void mo4031a(Matrix transform) {
        m18500b(transform);
        if (!this.f22083a.isIdentity()) {
            transform.preConcat(this.f22083a);
        }
    }
}
