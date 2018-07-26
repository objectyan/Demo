package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: ProgressBarDrawable */
/* renamed from: com.facebook.drawee.d.k */
public class C5409k extends Drawable {
    /* renamed from: a */
    private final Paint f22087a = new Paint(1);
    /* renamed from: b */
    private int f22088b = Integer.MIN_VALUE;
    /* renamed from: c */
    private int f22089c = -2147450625;
    /* renamed from: d */
    private int f22090d = 10;
    /* renamed from: e */
    private int f22091e = 20;
    /* renamed from: f */
    private int f22092f = 0;
    /* renamed from: g */
    private boolean f22093g = false;

    /* renamed from: a */
    public void m18542a(int color) {
        if (this.f22089c != color) {
            this.f22089c = color;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public int m18541a() {
        return this.f22089c;
    }

    /* renamed from: b */
    public void m18545b(int backgroundColor) {
        if (this.f22088b != backgroundColor) {
            this.f22088b = backgroundColor;
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public int m18544b() {
        return this.f22088b;
    }

    /* renamed from: c */
    public void m18547c(int padding) {
        if (this.f22090d != padding) {
            this.f22090d = padding;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect padding) {
        padding.set(this.f22090d, this.f22090d, this.f22090d, this.f22090d);
        return this.f22090d != 0;
    }

    /* renamed from: d */
    public void m18548d(int barWidth) {
        if (this.f22091e != barWidth) {
            this.f22091e = barWidth;
            invalidateSelf();
        }
    }

    /* renamed from: c */
    public int m18546c() {
        return this.f22091e;
    }

    /* renamed from: a */
    public void m18543a(boolean hideWhenZero) {
        this.f22093g = hideWhenZero;
    }

    /* renamed from: d */
    public boolean m18549d() {
        return this.f22093g;
    }

    protected boolean onLevelChange(int level) {
        this.f22092f = level;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int alpha) {
        this.f22087a.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.f22087a.setColorFilter(cf);
    }

    public int getOpacity() {
        return C2930f.a(this.f22087a.getColor());
    }

    public void draw(Canvas canvas) {
        if (!this.f22093g || this.f22092f != 0) {
            m18540a(canvas, 10000, this.f22088b);
            m18540a(canvas, this.f22092f, this.f22089c);
        }
    }

    /* renamed from: a */
    private void m18540a(Canvas canvas, int level, int color) {
        Rect bounds = getBounds();
        int length = ((bounds.width() - (this.f22090d * 2)) * level) / 10000;
        int xpos = bounds.left + this.f22090d;
        int ypos = (bounds.bottom - this.f22090d) - this.f22091e;
        this.f22087a.setColor(color);
        canvas.drawRect((float) xpos, (float) ypos, (float) (xpos + length), (float) (this.f22091e + ypos), this.f22087a);
    }
}
