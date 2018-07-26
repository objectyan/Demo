package com.facebook.drawee.p146d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;

/* compiled from: RoundedCornersDrawable */
/* renamed from: com.facebook.drawee.d.o */
public class C5414o extends C5402h implements C5410l {
    @VisibleForTesting
    /* renamed from: a */
    C5413a f22110a = C5413a.OVERLAY_COLOR;
    @VisibleForTesting
    /* renamed from: c */
    final float[] f22111c = new float[8];
    @VisibleForTesting
    /* renamed from: d */
    final Paint f22112d = new Paint(1);
    /* renamed from: e */
    private final float[] f22113e = new float[8];
    /* renamed from: f */
    private boolean f22114f = false;
    /* renamed from: g */
    private float f22115g = 0.0f;
    /* renamed from: h */
    private int f22116h = 0;
    /* renamed from: i */
    private int f22117i = 0;
    /* renamed from: j */
    private float f22118j = 0.0f;
    /* renamed from: k */
    private final Path f22119k = new Path();
    /* renamed from: l */
    private final Path f22120l = new Path();
    /* renamed from: m */
    private final RectF f22121m = new RectF();

    /* compiled from: RoundedCornersDrawable */
    /* renamed from: com.facebook.drawee.d.o$a */
    public enum C5413a {
        OVERLAY_COLOR,
        CLIPPING
    }

    public C5414o(Drawable drawable) {
        super((Drawable) C5350k.m18310a((Object) drawable));
    }

    /* renamed from: a */
    public void m18576a(C5413a type) {
        this.f22110a = type;
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo4042a(boolean isCircle) {
        this.f22114f = isCircle;
        m18572g();
        invalidateSelf();
    }

    public boolean g_() {
        return this.f22114f;
    }

    /* renamed from: a */
    public void mo4040a(float radius) {
        Arrays.fill(this.f22113e, radius);
        m18572g();
        invalidateSelf();
    }

    /* renamed from: a */
    public void mo4043a(float[] radii) {
        if (radii == null) {
            Arrays.fill(this.f22113e, 0.0f);
        } else {
            boolean z;
            if (radii.length == 8) {
                z = true;
            } else {
                z = false;
            }
            C5350k.m18316a(z, (Object) "radii should have exactly 8 values");
            System.arraycopy(radii, 0, this.f22113e, 0, 8);
        }
        m18572g();
        invalidateSelf();
    }

    /* renamed from: b */
    public float[] mo4045b() {
        return this.f22113e;
    }

    /* renamed from: a */
    public void m18574a(int overlayColor) {
        this.f22117i = overlayColor;
        invalidateSelf();
    }

    /* renamed from: f */
    public int m18584f() {
        return this.f22117i;
    }

    /* renamed from: a */
    public void mo4041a(int color, float width) {
        this.f22116h = color;
        this.f22115g = width;
        m18572g();
        invalidateSelf();
    }

    /* renamed from: c */
    public int mo4046c() {
        return this.f22116h;
    }

    /* renamed from: d */
    public float mo4047d() {
        return this.f22115g;
    }

    /* renamed from: b */
    public void mo4044b(float padding) {
        this.f22118j = padding;
        m18572g();
        invalidateSelf();
    }

    /* renamed from: e */
    public float mo4048e() {
        return this.f22118j;
    }

    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        m18572g();
    }

    /* renamed from: g */
    private void m18572g() {
        this.f22119k.reset();
        this.f22120l.reset();
        this.f22121m.set(getBounds());
        this.f22121m.inset(this.f22118j, this.f22118j);
        if (this.f22114f) {
            this.f22119k.addCircle(this.f22121m.centerX(), this.f22121m.centerY(), Math.min(this.f22121m.width(), this.f22121m.height()) / 2.0f, Direction.CW);
        } else {
            this.f22119k.addRoundRect(this.f22121m, this.f22113e, Direction.CW);
        }
        this.f22121m.inset(-this.f22118j, -this.f22118j);
        this.f22121m.inset(this.f22115g / 2.0f, this.f22115g / 2.0f);
        if (this.f22114f) {
            this.f22120l.addCircle(this.f22121m.centerX(), this.f22121m.centerY(), Math.min(this.f22121m.width(), this.f22121m.height()) / 2.0f, Direction.CW);
        } else {
            for (int i = 0; i < this.f22111c.length; i++) {
                this.f22111c[i] = (this.f22113e[i] + this.f22118j) - (this.f22115g / 2.0f);
            }
            this.f22120l.addRoundRect(this.f22121m, this.f22111c, Direction.CW);
        }
        this.f22121m.inset((-this.f22115g) / 2.0f, (-this.f22115g) / 2.0f);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.f22110a) {
            case CLIPPING:
                int saveCount = canvas.save();
                this.f22119k.setFillType(FillType.EVEN_ODD);
                canvas.clipPath(this.f22119k);
                super.draw(canvas);
                canvas.restoreToCount(saveCount);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.f22112d.setColor(this.f22117i);
                this.f22112d.setStyle(Style.FILL);
                this.f22119k.setFillType(FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.f22119k, this.f22112d);
                if (this.f22114f) {
                    float paddingH = (((float) (bounds.width() - bounds.height())) + this.f22115g) / 2.0f;
                    float paddingV = (((float) (bounds.height() - bounds.width())) + this.f22115g) / 2.0f;
                    if (paddingH > 0.0f) {
                        canvas.drawRect((float) bounds.left, (float) bounds.top, ((float) bounds.left) + paddingH, (float) bounds.bottom, this.f22112d);
                        canvas.drawRect(((float) bounds.right) - paddingH, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f22112d);
                    }
                    if (paddingV > 0.0f) {
                        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, ((float) bounds.top) + paddingV, this.f22112d);
                        canvas.drawRect((float) bounds.left, ((float) bounds.bottom) - paddingV, (float) bounds.right, (float) bounds.bottom, this.f22112d);
                        break;
                    }
                }
                break;
        }
        if (this.f22116h != 0) {
            this.f22112d.setStyle(Style.STROKE);
            this.f22112d.setColor(this.f22116h);
            this.f22112d.setStrokeWidth(this.f22115g);
            this.f22119k.setFillType(FillType.EVEN_ODD);
            canvas.drawPath(this.f22120l, this.f22112d);
        }
    }
}
