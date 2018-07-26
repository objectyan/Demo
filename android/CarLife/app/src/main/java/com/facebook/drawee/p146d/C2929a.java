package com.facebook.drawee.p146d;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.C5350k;
import javax.annotation.Nullable;

/* compiled from: ArrayDrawable */
/* renamed from: com.facebook.drawee.d.a */
public class C2929a extends Drawable implements Callback, C5400r, C5401s {
    /* renamed from: a */
    private C5401s f12938a;
    /* renamed from: b */
    private final C5405e f12939b = new C5405e();
    /* renamed from: c */
    private final Drawable[] f12940c;
    /* renamed from: d */
    private final C5399d[] f12941d;
    /* renamed from: e */
    private final Rect f12942e = new Rect();
    /* renamed from: f */
    private boolean f12943f = false;
    /* renamed from: g */
    private boolean f12944g = false;
    /* renamed from: h */
    private boolean f12945h = false;

    public C2929a(Drawable[] layers) {
        C5350k.a(layers);
        this.f12940c = layers;
        for (Drawable a : this.f12940c) {
            C2930f.m11410a(a, this, this);
        }
        this.f12941d = new C5399d[this.f12940c.length];
    }

    /* renamed from: a */
    public int m11400a() {
        return this.f12940c.length;
    }

    @Nullable
    /* renamed from: a */
    public Drawable m11401a(int index) {
        boolean z;
        boolean z2 = true;
        if (index >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.a(z);
        if (index >= this.f12940c.length) {
            z2 = false;
        }
        C5350k.a(z2);
        return this.f12940c[index];
    }

    @Nullable
    /* renamed from: a */
    public Drawable m11402a(int index, @Nullable Drawable drawable) {
        boolean z;
        boolean z2 = true;
        if (index >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.a(z);
        if (index >= this.f12940c.length) {
            z2 = false;
        }
        C5350k.a(z2);
        Drawable oldDrawable = this.f12940c[index];
        if (drawable != oldDrawable) {
            if (drawable != null && this.f12945h) {
                drawable.mutate();
            }
            C2930f.m11410a(this.f12940c[index], null, null);
            C2930f.m11410a(drawable, null, null);
            C2930f.m11412a(drawable, this.f12939b);
            C2930f.m11411a(drawable, (Drawable) this);
            C2930f.m11410a(drawable, this, this);
            this.f12944g = false;
            this.f12940c[index] = drawable;
            invalidateSelf();
        }
        return oldDrawable;
    }

    public int getIntrinsicWidth() {
        int width = -1;
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                width = Math.max(width, drawable.getIntrinsicWidth());
            }
        }
        return width > 0 ? width : -1;
    }

    public int getIntrinsicHeight() {
        int height = -1;
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                height = Math.max(height, drawable.getIntrinsicHeight());
            }
        }
        return height > 0 ? height : -1;
    }

    protected void onBoundsChange(Rect bounds) {
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setBounds(bounds);
            }
        }
    }

    public boolean isStateful() {
        if (!this.f12944g) {
            this.f12943f = false;
            for (Drawable drawable : this.f12940c) {
                int i;
                boolean z = this.f12943f;
                if (drawable == null || !drawable.isStateful()) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.f12943f = i | z;
            }
            this.f12944g = true;
        }
        return this.f12943f;
    }

    protected boolean onStateChange(int[] state) {
        boolean stateChanged = false;
        for (Drawable drawable : this.f12940c) {
            if (drawable != null && drawable.setState(state)) {
                stateChanged = true;
            }
        }
        return stateChanged;
    }

    protected boolean onLevelChange(int level) {
        boolean levelChanged = false;
        for (Drawable drawable : this.f12940c) {
            if (drawable != null && drawable.setLevel(level)) {
                levelChanged = true;
            }
        }
        return levelChanged;
    }

    public void draw(Canvas canvas) {
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    public boolean getPadding(Rect padding) {
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        Rect rect = this.f12942e;
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.getPadding(rect);
                padding.left = Math.max(padding.left, rect.left);
                padding.top = Math.max(padding.top, rect.top);
                padding.right = Math.max(padding.right, rect.right);
                padding.bottom = Math.max(padding.bottom, rect.bottom);
            }
        }
        return true;
    }

    public Drawable mutate() {
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.f12945h = true;
        return this;
    }

    public int getOpacity() {
        if (this.f12940c.length == 0) {
            return -2;
        }
        int opacity = -1;
        for (int i = 1; i < this.f12940c.length; i++) {
            Drawable drawable = this.f12940c[i];
            if (drawable != null) {
                opacity = Drawable.resolveOpacity(opacity, drawable.getOpacity());
            }
        }
        return opacity;
    }

    public void setAlpha(int alpha) {
        this.f12939b.a(alpha);
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setAlpha(alpha);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12939b.a(colorFilter);
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean dither) {
        this.f12939b.a(dither);
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setDither(dither);
            }
        }
    }

    public void setFilterBitmap(boolean filterBitmap) {
        this.f12939b.b(filterBitmap);
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setFilterBitmap(filterBitmap);
            }
        }
    }

    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setVisible(visible, restart);
            }
        }
        return changed;
    }

    /* renamed from: b */
    public C5399d m11406b(int index) {
        boolean z = true;
        C5350k.a(index >= 0);
        if (index >= this.f12941d.length) {
            z = false;
        }
        C5350k.a(z);
        if (this.f12941d[index] == null) {
            this.f12941d[index] = m11399c(index);
        }
        return this.f12941d[index];
    }

    /* renamed from: c */
    private C5399d m11399c(int index) {
        return new a$1(this, index);
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
    public void m11405a(C5401s transformCallback) {
        this.f12938a = transformCallback;
    }

    /* renamed from: a */
    public void m11403a(Matrix transform) {
        if (this.f12938a != null) {
            this.f12938a.a(transform);
        } else {
            transform.reset();
        }
    }

    /* renamed from: a */
    public void m11404a(RectF bounds) {
        if (this.f12938a != null) {
            this.f12938a.a(bounds);
        } else {
            bounds.set(getBounds());
        }
    }

    @TargetApi(21)
    public void setHotspot(float x, float y) {
        for (Drawable drawable : this.f12940c) {
            if (drawable != null) {
                drawable.setHotspot(x, y);
            }
        }
    }
}
