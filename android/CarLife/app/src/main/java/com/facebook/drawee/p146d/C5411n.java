package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

/* compiled from: RoundedColorDrawable */
/* renamed from: com.facebook.drawee.d.n */
public class C5411n extends Drawable implements C5410l {
    @VisibleForTesting
    /* renamed from: a */
    final float[] f22094a;
    @VisibleForTesting
    /* renamed from: b */
    final Paint f22095b;
    @VisibleForTesting
    /* renamed from: c */
    final Path f22096c;
    @VisibleForTesting
    /* renamed from: d */
    final Path f22097d;
    /* renamed from: e */
    private final float[] f22098e;
    /* renamed from: f */
    private boolean f22099f;
    /* renamed from: g */
    private float f22100g;
    /* renamed from: h */
    private float f22101h;
    /* renamed from: i */
    private int f22102i;
    /* renamed from: j */
    private int f22103j;
    /* renamed from: k */
    private final RectF f22104k;
    /* renamed from: l */
    private int f22105l;

    public C5411n(int color) {
        this.f22098e = new float[8];
        this.f22094a = new float[8];
        this.f22095b = new Paint(1);
        this.f22099f = false;
        this.f22100g = 0.0f;
        this.f22101h = 0.0f;
        this.f22102i = 0;
        this.f22096c = new Path();
        this.f22097d = new Path();
        this.f22103j = 0;
        this.f22104k = new RectF();
        this.f22105l = 255;
        m18562a(color);
    }

    /* renamed from: a */
    public static C5411n m18559a(ColorDrawable colorDrawable) {
        return new C5411n(colorDrawable.getColor());
    }

    public C5411n(float[] radii, int color) {
        this(color);
        mo4043a(radii);
    }

    public C5411n(float radius, int color) {
        this(color);
        mo4040a(radius);
    }

    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        m18560g();
    }

    public void draw(Canvas canvas) {
        this.f22095b.setColor(C2930f.a(this.f22103j, this.f22105l));
        this.f22095b.setStyle(Style.FILL);
        canvas.drawPath(this.f22096c, this.f22095b);
        if (this.f22100g != 0.0f) {
            this.f22095b.setColor(C2930f.a(this.f22102i, this.f22105l));
            this.f22095b.setStyle(Style.STROKE);
            this.f22095b.setStrokeWidth(this.f22100g);
            canvas.drawPath(this.f22097d, this.f22095b);
        }
    }

    /* renamed from: a */
    public void mo4042a(boolean isCircle) {
        this.f22099f = isCircle;
        m18560g();
        invalidateSelf();
    }

    public boolean g_() {
        return this.f22099f;
    }

    /* renamed from: a */
    public void mo4043a(float[] radii) {
        if (radii == null) {
            Arrays.fill(this.f22098e, 0.0f);
        } else {
            boolean z;
            if (radii.length == 8) {
                z = true;
            } else {
                z = false;
            }
            C5350k.m18316a(z, (Object) "radii should have exactly 8 values");
            System.arraycopy(radii, 0, this.f22098e, 0, 8);
        }
        m18560g();
        invalidateSelf();
    }

    /* renamed from: b */
    public float[] mo4045b() {
        return this.f22098e;
    }

    /* renamed from: a */
    public void mo4040a(float radius) {
        C5350k.m18316a(radius >= 0.0f, (Object) "radius should be non negative");
        Arrays.fill(this.f22098e, radius);
        m18560g();
        invalidateSelf();
    }

    /* renamed from: a */
    public void m18562a(int color) {
        if (this.f22103j != color) {
            this.f22103j = color;
            invalidateSelf();
        }
    }

    /* renamed from: f */
    public int m18571f() {
        return this.f22103j;
    }

    /* renamed from: a */
    public void mo4041a(int color, float width) {
        if (this.f22102i != color) {
            this.f22102i = color;
            invalidateSelf();
        }
        if (this.f22100g != width) {
            this.f22100g = width;
            m18560g();
            invalidateSelf();
        }
    }

    /* renamed from: c */
    public int mo4046c() {
        return this.f22102i;
    }

    /* renamed from: d */
    public float mo4047d() {
        return this.f22100g;
    }

    /* renamed from: b */
    public void mo4044b(float padding) {
        if (this.f22101h != padding) {
            this.f22101h = padding;
            m18560g();
            invalidateSelf();
        }
    }

    /* renamed from: e */
    public float mo4048e() {
        return this.f22101h;
    }

    public void setAlpha(int alpha) {
        if (alpha != this.f22105l) {
            this.f22105l = alpha;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f22105l;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return C2930f.a(C2930f.a(this.f22103j, this.f22105l));
    }

    /* renamed from: g */
    private void m18560g() {
        this.f22096c.reset();
        this.f22097d.reset();
        this.f22104k.set(getBounds());
        this.f22104k.inset(this.f22100g / 2.0f, this.f22100g / 2.0f);
        if (this.f22099f) {
            this.f22097d.addCircle(this.f22104k.centerX(), this.f22104k.centerY(), Math.min(this.f22104k.width(), this.f22104k.height()) / 2.0f, Direction.CW);
        } else {
            for (int i = 0; i < this.f22094a.length; i++) {
                this.f22094a[i] = (this.f22098e[i] + this.f22101h) - (this.f22100g / 2.0f);
            }
            this.f22097d.addRoundRect(this.f22104k, this.f22094a, Direction.CW);
        }
        this.f22104k.inset((-this.f22100g) / 2.0f, (-this.f22100g) / 2.0f);
        this.f22104k.inset(this.f22101h, this.f22101h);
        if (this.f22099f) {
            this.f22096c.addCircle(this.f22104k.centerX(), this.f22104k.centerY(), Math.min(this.f22104k.width(), this.f22104k.height()) / 2.0f, Direction.CW);
        } else {
            this.f22096c.addRoundRect(this.f22104k, this.f22098e, Direction.CW);
        }
        this.f22104k.inset(-this.f22101h, -this.f22101h);
    }
}
