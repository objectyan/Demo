package com.facebook.drawee.p146d;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: ForwardingDrawable */
/* renamed from: com.facebook.drawee.d.h */
public class C5402h extends Drawable implements Callback, C5399d, C5400r, C5401s {
    /* renamed from: d */
    private static final Matrix f22051d = new Matrix();
    /* renamed from: a */
    private Drawable f22052a;
    /* renamed from: b */
    protected C5401s f22053b;
    /* renamed from: c */
    private final C5405e f22054c = new C5405e();

    public C5402h(Drawable drawable) {
        this.f22052a = drawable;
        C2930f.a(this.f22052a, this, this);
    }

    /* renamed from: b */
    public Drawable mo4036b(Drawable newDelegate) {
        Drawable previousDelegate = m18502c(newDelegate);
        invalidateSelf();
        return previousDelegate;
    }

    /* renamed from: c */
    protected Drawable m18502c(Drawable newDelegate) {
        Drawable previousDelegate = this.f22052a;
        C2930f.a(previousDelegate, null, null);
        C2930f.a(newDelegate, null, null);
        C2930f.a(newDelegate, this.f22054c);
        C2930f.a(newDelegate, this);
        C2930f.a(newDelegate, this, this);
        this.f22052a = newDelegate;
        return previousDelegate;
    }

    public int getOpacity() {
        return this.f22052a.getOpacity();
    }

    public void setAlpha(int alpha) {
        this.f22054c.m18510a(alpha);
        this.f22052a.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f22054c.m18511a(colorFilter);
        this.f22052a.setColorFilter(colorFilter);
    }

    public void setDither(boolean dither) {
        this.f22054c.m18513a(dither);
        this.f22052a.setDither(dither);
    }

    public void setFilterBitmap(boolean filterBitmap) {
        this.f22054c.m18514b(filterBitmap);
        this.f22052a.setFilterBitmap(filterBitmap);
    }

    public boolean setVisible(boolean visible, boolean restart) {
        super.setVisible(visible, restart);
        return this.f22052a.setVisible(visible, restart);
    }

    protected void onBoundsChange(Rect bounds) {
        this.f22052a.setBounds(bounds);
    }

    public boolean isStateful() {
        return this.f22052a.isStateful();
    }

    protected boolean onStateChange(int[] state) {
        return this.f22052a.setState(state);
    }

    protected boolean onLevelChange(int level) {
        return this.f22052a.setLevel(level);
    }

    public void draw(Canvas canvas) {
        this.f22052a.draw(canvas);
    }

    public int getIntrinsicWidth() {
        return this.f22052a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f22052a.getIntrinsicHeight();
    }

    public boolean getPadding(Rect padding) {
        return this.f22052a.getPadding(padding);
    }

    public Drawable mutate() {
        this.f22052a.mutate();
        return this;
    }

    public Drawable getCurrent() {
        return this.f22052a;
    }

    /* renamed from: a */
    public Drawable mo4030a(Drawable newDrawable) {
        return mo4036b(newDrawable);
    }

    /* renamed from: a */
    public Drawable mo4029a() {
        return getCurrent();
    }

    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    /* renamed from: a */
    public void mo4033a(C5401s transformCallback) {
        this.f22053b = transformCallback;
    }

    /* renamed from: b */
    protected void m18500b(Matrix transform) {
        if (this.f22053b != null) {
            this.f22053b.mo4031a(transform);
        } else {
            transform.reset();
        }
    }

    /* renamed from: a */
    public void mo4031a(Matrix transform) {
        m18500b(transform);
    }

    /* renamed from: a */
    public void mo4032a(RectF bounds) {
        if (this.f22053b != null) {
            this.f22053b.mo4032a(bounds);
        } else {
            bounds.set(getBounds());
        }
    }

    /* renamed from: b */
    public void m18501b(RectF outBounds) {
        m18500b(f22051d);
        outBounds.set(getBounds());
        f22051d.mapRect(outBounds);
    }

    @TargetApi(21)
    public void setHotspot(float x, float y) {
        this.f22052a.setHotspot(x, y);
    }
}
