package com.baidu.carlife.view.p104a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: RecCirclePressStateDrawable */
/* renamed from: com.baidu.carlife.view.a.a */
public class C2250a extends Drawable {
    /* renamed from: a */
    public static final int f7328a = 1;
    /* renamed from: b */
    private Paint f7329b;
    /* renamed from: c */
    private float f7330c;
    /* renamed from: d */
    private float f7331d;
    /* renamed from: e */
    private int f7332e;
    /* renamed from: f */
    private float f7333f;
    /* renamed from: g */
    private float f7334g;
    /* renamed from: h */
    private float f7335h;

    public C2250a(float width, float height, int color) {
        this.f7330c = width;
        this.f7331d = height;
        this.f7332e = color;
        this.f7333f = this.f7330c / 2.0f;
        this.f7334g = this.f7331d / 2.0f;
        this.f7335h = this.f7333f;
        this.f7329b = new Paint();
    }

    public C2250a(float width, float height, int color, int style) {
        this.f7330c = width;
        this.f7331d = height;
        this.f7332e = color;
        this.f7333f = this.f7330c / 2.0f;
        this.f7334g = this.f7331d / 2.0f;
        if (style == 1) {
            this.f7335h = this.f7334g;
        } else {
            this.f7335h = this.f7333f;
        }
        this.f7329b = new Paint();
    }

    public void draw(Canvas canvas) {
        int sc = canvas.saveLayer(0.0f, 0.0f, this.f7330c, this.f7331d, null, 31);
        this.f7329b.setColor(this.f7332e);
        this.f7329b.setAntiAlias(true);
        canvas.drawCircle(this.f7333f, this.f7334g, this.f7335h, this.f7329b);
        canvas.restoreToCount(sc);
    }

    public void setAlpha(int alpha) {
        this.f7329b.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7329b.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return 0;
    }
}
