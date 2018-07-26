package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

/* compiled from: FadeDrawable */
/* renamed from: com.facebook.drawee.d.g */
public class C5406g extends C2929a {
    @VisibleForTesting
    /* renamed from: a */
    public static final int f22067a = 0;
    @VisibleForTesting
    /* renamed from: b */
    public static final int f22068b = 1;
    @VisibleForTesting
    /* renamed from: c */
    public static final int f22069c = 2;
    @VisibleForTesting
    /* renamed from: d */
    int f22070d;
    @VisibleForTesting
    /* renamed from: e */
    int f22071e;
    @VisibleForTesting
    /* renamed from: f */
    long f22072f;
    @VisibleForTesting
    /* renamed from: g */
    int[] f22073g;
    @VisibleForTesting
    /* renamed from: h */
    int[] f22074h;
    @VisibleForTesting
    /* renamed from: i */
    int f22075i;
    @VisibleForTesting
    /* renamed from: j */
    boolean[] f22076j;
    @VisibleForTesting
    /* renamed from: k */
    int f22077k;
    /* renamed from: l */
    private final Drawable[] f22078l;

    public C5406g(Drawable[] layers) {
        boolean z = true;
        super(layers);
        if (layers.length < 1) {
            z = false;
        }
        C5350k.m18322b(z, (Object) "At least one layer required!");
        this.f22078l = layers;
        this.f22073g = new int[layers.length];
        this.f22074h = new int[layers.length];
        this.f22075i = 255;
        this.f22076j = new boolean[layers.length];
        this.f22077k = 0;
        m18517k();
    }

    public void invalidateSelf() {
        if (this.f22077k == 0) {
            super.invalidateSelf();
        }
    }

    /* renamed from: b */
    public void m18518b() {
        this.f22077k++;
    }

    /* renamed from: c */
    public void m18519c() {
        this.f22077k--;
        invalidateSelf();
    }

    /* renamed from: c */
    public void m18520c(int durationMs) {
        this.f22071e = durationMs;
        if (this.f22070d == 1) {
            this.f22070d = 0;
        }
    }

    /* renamed from: d */
    public int m18521d() {
        return this.f22071e;
    }

    /* renamed from: k */
    private void m18517k() {
        this.f22070d = 2;
        Arrays.fill(this.f22073g, 0);
        this.f22073g[0] = 255;
        Arrays.fill(this.f22074h, 0);
        this.f22074h[0] = 255;
        Arrays.fill(this.f22076j, false);
        this.f22076j[0] = true;
    }

    /* renamed from: e */
    public void m18523e() {
        m18517k();
        invalidateSelf();
    }

    /* renamed from: d */
    public void m18522d(int index) {
        this.f22070d = 0;
        this.f22076j[index] = true;
        invalidateSelf();
    }

    /* renamed from: e */
    public void m18524e(int index) {
        this.f22070d = 0;
        this.f22076j[index] = false;
        invalidateSelf();
    }

    /* renamed from: f */
    public void m18525f() {
        this.f22070d = 0;
        Arrays.fill(this.f22076j, true);
        invalidateSelf();
    }

    /* renamed from: g */
    public void m18527g() {
        this.f22070d = 0;
        Arrays.fill(this.f22076j, false);
        invalidateSelf();
    }

    /* renamed from: f */
    public void m18526f(int index) {
        this.f22070d = 0;
        Arrays.fill(this.f22076j, false);
        this.f22076j[index] = true;
        invalidateSelf();
    }

    /* renamed from: g */
    public void m18528g(int index) {
        this.f22070d = 0;
        Arrays.fill(this.f22076j, 0, index + 1, true);
        Arrays.fill(this.f22076j, index + 1, this.f22078l.length, false);
        invalidateSelf();
    }

    /* renamed from: h */
    public void m18529h() {
        this.f22070d = 2;
        for (int i = 0; i < this.f22078l.length; i++) {
            this.f22074h[i] = this.f22076j[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    /* renamed from: a */
    private boolean m18516a(float ratio) {
        boolean done = true;
        int i = 0;
        while (i < this.f22078l.length) {
            this.f22074h[i] = (int) (((float) this.f22073g[i]) + (((float) ((this.f22076j[i] ? 1 : -1) * 255)) * ratio));
            if (this.f22074h[i] < 0) {
                this.f22074h[i] = 0;
            }
            if (this.f22074h[i] > 255) {
                this.f22074h[i] = 255;
            }
            if (this.f22076j[i] && this.f22074h[i] < 255) {
                done = false;
            }
            if (!this.f22076j[i] && this.f22074h[i] > 0) {
                done = false;
            }
            i++;
        }
        return done;
    }

    public void draw(Canvas canvas) {
        int i = 2;
        boolean z = false;
        boolean done = true;
        switch (this.f22070d) {
            case 0:
                System.arraycopy(this.f22074h, 0, this.f22073g, 0, this.f22078l.length);
                this.f22072f = m18531i();
                done = m18516a(this.f22071e == 0 ? 1.0f : 0.0f);
                if (!done) {
                    i = 1;
                }
                this.f22070d = i;
                break;
            case 1:
                if (this.f22071e > 0) {
                    z = true;
                }
                C5350k.m18321b(z);
                done = m18516a(((float) (m18531i() - this.f22072f)) / ((float) this.f22071e));
                if (!done) {
                    i = 1;
                }
                this.f22070d = i;
                break;
            case 2:
                done = true;
                break;
        }
        for (int i2 = 0; i2 < this.f22078l.length; i2++) {
            m18515a(canvas, this.f22078l[i2], (this.f22074h[i2] * this.f22075i) / 255);
        }
        if (!done) {
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private void m18515a(Canvas canvas, Drawable drawable, int alpha) {
        if (drawable != null && alpha > 0) {
            this.f22077k++;
            drawable.mutate().setAlpha(alpha);
            this.f22077k--;
            drawable.draw(canvas);
        }
    }

    public void setAlpha(int alpha) {
        if (this.f22075i != alpha) {
            this.f22075i = alpha;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f22075i;
    }

    /* renamed from: i */
    protected long m18531i() {
        return SystemClock.uptimeMillis();
    }

    @VisibleForTesting
    /* renamed from: j */
    public int m18532j() {
        return this.f22070d;
    }

    /* renamed from: h */
    public boolean m18530h(int index) {
        return this.f22076j[index];
    }
}
