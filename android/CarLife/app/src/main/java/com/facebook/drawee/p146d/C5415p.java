package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: ScaleTypeDrawable */
/* renamed from: com.facebook.drawee.d.p */
public class C5415p extends C5402h {
    @VisibleForTesting
    /* renamed from: a */
    q$c f22122a;
    @VisibleForTesting
    /* renamed from: c */
    Object f22123c;
    @VisibleForTesting
    /* renamed from: d */
    PointF f22124d = null;
    @VisibleForTesting
    /* renamed from: e */
    int f22125e = 0;
    @VisibleForTesting
    /* renamed from: f */
    int f22126f = 0;
    @VisibleForTesting
    /* renamed from: g */
    Matrix f22127g;
    /* renamed from: h */
    private Matrix f22128h = new Matrix();

    public C5415p(Drawable drawable, q$c scaleType) {
        super((Drawable) C5350k.m18310a((Object) drawable));
        this.f22122a = scaleType;
    }

    /* renamed from: b */
    public Drawable mo4036b(Drawable newDelegate) {
        Drawable previousDelegate = super.mo4036b(newDelegate);
        m18592d();
        return previousDelegate;
    }

    /* renamed from: b */
    public q$c m18590b() {
        return this.f22122a;
    }

    /* renamed from: a */
    public void m18588a(q$c scaleType) {
        this.f22122a = scaleType;
        this.f22123c = null;
        m18592d();
        invalidateSelf();
    }

    /* renamed from: c */
    public PointF m18591c() {
        return this.f22124d;
    }

    /* renamed from: a */
    public void m18587a(PointF focusPoint) {
        if (this.f22124d == null) {
            this.f22124d = new PointF();
        }
        this.f22124d.set(focusPoint);
        m18592d();
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        m18585e();
        if (this.f22127g != null) {
            int saveCount = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.f22127g);
            super.draw(canvas);
            canvas.restoreToCount(saveCount);
            return;
        }
        super.draw(canvas);
    }

    protected void onBoundsChange(Rect bounds) {
        m18592d();
    }

    /* renamed from: e */
    private void m18585e() {
        boolean underlyingChanged;
        boolean scaleTypeChanged = false;
        if (this.f22122a instanceof q$l) {
            Object state = ((q$l) this.f22122a).m18604f();
            if (state == null || !state.equals(this.f22123c)) {
                scaleTypeChanged = true;
            } else {
                scaleTypeChanged = false;
            }
            this.f22123c = state;
        }
        if (this.f22125e == getCurrent().getIntrinsicWidth() && this.f22126f == getCurrent().getIntrinsicHeight()) {
            underlyingChanged = false;
        } else {
            underlyingChanged = true;
        }
        if (underlyingChanged || scaleTypeChanged) {
            m18592d();
        }
    }

    @VisibleForTesting
    /* renamed from: d */
    void m18592d() {
        float f = 0.5f;
        Drawable underlyingDrawable = getCurrent();
        Rect bounds = getBounds();
        int viewWidth = bounds.width();
        int viewHeight = bounds.height();
        int underlyingWidth = underlyingDrawable.getIntrinsicWidth();
        this.f22125e = underlyingWidth;
        int underlyingHeight = underlyingDrawable.getIntrinsicHeight();
        this.f22126f = underlyingHeight;
        if (underlyingWidth <= 0 || underlyingHeight <= 0) {
            underlyingDrawable.setBounds(bounds);
            this.f22127g = null;
        } else if (underlyingWidth == viewWidth && underlyingHeight == viewHeight) {
            underlyingDrawable.setBounds(bounds);
            this.f22127g = null;
        } else if (this.f22122a == q$c.f22129a) {
            underlyingDrawable.setBounds(bounds);
            this.f22127g = null;
        } else {
            underlyingDrawable.setBounds(0, 0, underlyingWidth, underlyingHeight);
            q$c q_c = this.f22122a;
            Matrix matrix = this.f22128h;
            float f2 = this.f22124d != null ? this.f22124d.x : 0.5f;
            if (this.f22124d != null) {
                f = this.f22124d.y;
            }
            q_c.mo4050a(matrix, bounds, underlyingWidth, underlyingHeight, f2, f);
            this.f22127g = this.f22128h;
        }
    }

    /* renamed from: a */
    public void mo4031a(Matrix transform) {
        m18500b(transform);
        m18585e();
        if (this.f22127g != null) {
            transform.preConcat(this.f22127g);
        }
    }
}
