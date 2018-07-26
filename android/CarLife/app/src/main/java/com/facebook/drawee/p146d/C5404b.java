package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: AutoRotateDrawable */
/* renamed from: com.facebook.drawee.d.b */
public class C5404b extends C5402h implements C5403c, Runnable {
    /* renamed from: c */
    private static final int f22055c = 360;
    /* renamed from: d */
    private static final int f22056d = 20;
    @VisibleForTesting
    /* renamed from: a */
    float f22057a;
    /* renamed from: e */
    private int f22058e;
    /* renamed from: f */
    private boolean f22059f;
    /* renamed from: g */
    private boolean f22060g;

    /* renamed from: d */
    public /* synthetic */ Drawable mo4034d() {
        return m18508c();
    }

    public C5404b(Drawable drawable, int interval) {
        this(drawable, interval, true);
    }

    public C5404b(Drawable drawable, int interval, boolean clockwise) {
        super((Drawable) C5350k.m18310a((Object) drawable));
        this.f22057a = 0.0f;
        this.f22060g = false;
        this.f22058e = interval;
        this.f22059f = clockwise;
    }

    /* renamed from: b */
    public void m18507b() {
        this.f22057a = 0.0f;
        this.f22060g = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m18506a(boolean clockwise) {
        this.f22059f = clockwise;
    }

    public void draw(Canvas canvas) {
        int saveCount = canvas.save();
        Rect bounds = getBounds();
        int width = bounds.right - bounds.left;
        int height = bounds.bottom - bounds.top;
        float angle = this.f22057a;
        if (!this.f22059f) {
            angle = 360.0f - this.f22057a;
        }
        canvas.rotate(angle, (float) (bounds.left + (width / 2)), (float) (bounds.top + (height / 2)));
        super.draw(canvas);
        canvas.restoreToCount(saveCount);
        m18504e();
    }

    public void run() {
        this.f22060g = false;
        this.f22057a += (float) m18505f();
        invalidateSelf();
    }

    /* renamed from: c */
    public C5404b m18508c() {
        return new C5404b(C2930f.a(mo4029a()), this.f22058e, this.f22059f);
    }

    /* renamed from: e */
    private void m18504e() {
        if (!this.f22060g) {
            this.f22060g = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    /* renamed from: f */
    private int m18505f() {
        return (int) ((20.0f / ((float) this.f22058e)) * 360.0f);
    }
}
