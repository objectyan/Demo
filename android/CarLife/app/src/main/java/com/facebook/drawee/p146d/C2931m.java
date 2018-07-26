package com.facebook.drawee.p146d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: RoundedBitmapDrawable */
/* renamed from: com.facebook.drawee.d.m */
public class C2931m extends BitmapDrawable implements C5410l, C5400r {
    @VisibleForTesting
    /* renamed from: a */
    final float[] f12946a;
    @VisibleForTesting
    /* renamed from: b */
    final RectF f12947b;
    @VisibleForTesting
    /* renamed from: c */
    final RectF f12948c;
    @VisibleForTesting
    /* renamed from: d */
    final RectF f12949d;
    @VisibleForTesting
    /* renamed from: e */
    final RectF f12950e;
    @VisibleForTesting
    /* renamed from: f */
    final Matrix f12951f;
    @VisibleForTesting
    /* renamed from: g */
    final Matrix f12952g;
    @VisibleForTesting
    /* renamed from: h */
    final Matrix f12953h;
    @VisibleForTesting
    /* renamed from: i */
    final Matrix f12954i;
    @VisibleForTesting
    /* renamed from: j */
    final Matrix f12955j;
    @VisibleForTesting
    /* renamed from: k */
    final Matrix f12956k;
    /* renamed from: l */
    private boolean f12957l;
    /* renamed from: m */
    private boolean f12958m;
    /* renamed from: n */
    private final float[] f12959n;
    /* renamed from: o */
    private float f12960o;
    /* renamed from: p */
    private int f12961p;
    /* renamed from: q */
    private float f12962q;
    /* renamed from: r */
    private final Path f12963r;
    /* renamed from: s */
    private final Path f12964s;
    /* renamed from: t */
    private boolean f12965t;
    /* renamed from: u */
    private final Paint f12966u;
    /* renamed from: v */
    private final Paint f12967v;
    /* renamed from: w */
    private boolean f12968w;
    /* renamed from: x */
    private WeakReference<Bitmap> f12969x;
    @Nullable
    /* renamed from: y */
    private C5401s f12970y;

    public C2931m(Resources res, Bitmap bitmap) {
        this(res, bitmap, null);
    }

    public C2931m(Resources res, Bitmap bitmap, @Nullable Paint paint) {
        super(res, bitmap);
        this.f12957l = false;
        this.f12958m = false;
        this.f12959n = new float[8];
        this.f12946a = new float[8];
        this.f12947b = new RectF();
        this.f12948c = new RectF();
        this.f12949d = new RectF();
        this.f12950e = new RectF();
        this.f12951f = new Matrix();
        this.f12952g = new Matrix();
        this.f12953h = new Matrix();
        this.f12954i = new Matrix();
        this.f12955j = new Matrix();
        this.f12956k = new Matrix();
        this.f12960o = 0.0f;
        this.f12961p = 0;
        this.f12962q = 0.0f;
        this.f12963r = new Path();
        this.f12964s = new Path();
        this.f12965t = true;
        this.f12966u = new Paint();
        this.f12967v = new Paint(1);
        this.f12968w = true;
        if (paint != null) {
            this.f12966u.set(paint);
        }
        this.f12966u.setFlags(1);
        this.f12967v.setStyle(Style.STROKE);
    }

    /* renamed from: a */
    public static C2931m m11413a(Resources res, BitmapDrawable bitmapDrawable) {
        return new C2931m(res, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    /* renamed from: a */
    public void m11420a(boolean isCircle) {
        this.f12957l = isCircle;
        this.f12965t = true;
        invalidateSelf();
    }

    public boolean g_() {
        return this.f12957l;
    }

    /* renamed from: a */
    public void m11417a(float radius) {
        boolean z = false;
        C5350k.b(radius >= 0.0f);
        Arrays.fill(this.f12959n, radius);
        if (radius != 0.0f) {
            z = true;
        }
        this.f12958m = z;
        this.f12965t = true;
        invalidateSelf();
    }

    /* renamed from: a */
    public void m11421a(float[] radii) {
        if (radii == null) {
            Arrays.fill(this.f12959n, 0.0f);
            this.f12958m = false;
        } else {
            boolean z;
            if (radii.length == 8) {
                z = true;
            } else {
                z = false;
            }
            C5350k.a(z, "radii should have exactly 8 values");
            System.arraycopy(radii, 0, this.f12959n, 0, 8);
            this.f12958m = false;
            for (int i = 0; i < 8; i++) {
                int i2;
                boolean z2 = this.f12958m;
                if (radii[i] > 0.0f) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.f12958m = i2 | z2;
            }
        }
        this.f12965t = true;
        invalidateSelf();
    }

    /* renamed from: b */
    public float[] m11423b() {
        return this.f12959n;
    }

    /* renamed from: a */
    public void m11418a(int color, float width) {
        if (this.f12961p != color || this.f12960o != width) {
            this.f12961p = color;
            this.f12960o = width;
            this.f12965t = true;
            invalidateSelf();
        }
    }

    /* renamed from: c */
    public int m11424c() {
        return this.f12961p;
    }

    /* renamed from: d */
    public float m11425d() {
        return this.f12960o;
    }

    /* renamed from: b */
    public void m11422b(float padding) {
        if (this.f12962q != padding) {
            this.f12962q = padding;
            this.f12965t = true;
            invalidateSelf();
        }
    }

    /* renamed from: e */
    public float m11426e() {
        return this.f12962q;
    }

    /* renamed from: a */
    public void m11419a(@Nullable C5401s transformCallback) {
        this.f12970y = transformCallback;
    }

    public void setAlpha(int alpha) {
        if (alpha != this.f12966u.getAlpha()) {
            this.f12966u.setAlpha(alpha);
            super.setAlpha(alpha);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12966u.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        if (m11427f()) {
            m11414g();
            m11415h();
            m11416i();
            int saveCount = canvas.save();
            canvas.concat(this.f12955j);
            canvas.drawPath(this.f12963r, this.f12966u);
            if (this.f12960o > 0.0f) {
                this.f12967v.setStrokeWidth(this.f12960o);
                this.f12967v.setColor(C2930f.m11408a(this.f12961p, this.f12966u.getAlpha()));
                canvas.drawPath(this.f12964s, this.f12967v);
            }
            canvas.restoreToCount(saveCount);
            return;
        }
        super.draw(canvas);
    }

    @VisibleForTesting
    /* renamed from: f */
    boolean m11427f() {
        return this.f12957l || this.f12958m || this.f12960o > 0.0f;
    }

    /* renamed from: g */
    private void m11414g() {
        if (this.f12970y != null) {
            this.f12970y.a(this.f12953h);
            this.f12970y.a(this.f12947b);
        } else {
            this.f12953h.reset();
            this.f12947b.set(getBounds());
        }
        this.f12949d.set(0.0f, 0.0f, (float) getBitmap().getWidth(), (float) getBitmap().getHeight());
        this.f12950e.set(getBounds());
        this.f12951f.setRectToRect(this.f12949d, this.f12950e, ScaleToFit.FILL);
        if (!(this.f12953h.equals(this.f12954i) && this.f12951f.equals(this.f12952g))) {
            this.f12968w = true;
            this.f12953h.invert(this.f12955j);
            this.f12956k.set(this.f12953h);
            this.f12956k.preConcat(this.f12951f);
            this.f12954i.set(this.f12953h);
            this.f12952g.set(this.f12951f);
        }
        if (!this.f12947b.equals(this.f12948c)) {
            this.f12965t = true;
            this.f12948c.set(this.f12947b);
        }
    }

    /* renamed from: h */
    private void m11415h() {
        if (this.f12965t) {
            this.f12964s.reset();
            this.f12947b.inset(this.f12960o / 2.0f, this.f12960o / 2.0f);
            if (this.f12957l) {
                this.f12964s.addCircle(this.f12947b.centerX(), this.f12947b.centerY(), Math.min(this.f12947b.width(), this.f12947b.height()) / 2.0f, Direction.CW);
            } else {
                for (int i = 0; i < this.f12946a.length; i++) {
                    this.f12946a[i] = (this.f12959n[i] + this.f12962q) - (this.f12960o / 2.0f);
                }
                this.f12964s.addRoundRect(this.f12947b, this.f12946a, Direction.CW);
            }
            this.f12947b.inset((-this.f12960o) / 2.0f, (-this.f12960o) / 2.0f);
            this.f12963r.reset();
            this.f12947b.inset(this.f12962q, this.f12962q);
            if (this.f12957l) {
                this.f12963r.addCircle(this.f12947b.centerX(), this.f12947b.centerY(), Math.min(this.f12947b.width(), this.f12947b.height()) / 2.0f, Direction.CW);
            } else {
                this.f12963r.addRoundRect(this.f12947b, this.f12959n, Direction.CW);
            }
            this.f12947b.inset(-this.f12962q, -this.f12962q);
            this.f12963r.setFillType(FillType.WINDING);
            this.f12965t = false;
        }
    }

    /* renamed from: i */
    private void m11416i() {
        Bitmap bitmap = getBitmap();
        if (this.f12969x == null || this.f12969x.get() != bitmap) {
            this.f12969x = new WeakReference(bitmap);
            this.f12966u.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
            this.f12968w = true;
        }
        if (this.f12968w) {
            this.f12966u.getShader().setLocalMatrix(this.f12956k);
            this.f12968w = false;
        }
    }
}
