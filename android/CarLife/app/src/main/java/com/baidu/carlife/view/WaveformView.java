package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.util.C2188r;
import com.baidu.platform.comapi.util.C4820d;

public class WaveformView extends View {
    /* renamed from: a */
    private static final float f7305a = 0.0575f;
    /* renamed from: b */
    private float f7306b;
    /* renamed from: c */
    private float f7307c;
    /* renamed from: d */
    private float f7308d;
    /* renamed from: e */
    private int f7309e;
    /* renamed from: f */
    private int f7310f;
    /* renamed from: g */
    private int f7311g;
    /* renamed from: h */
    private float f7312h;
    /* renamed from: i */
    private float f7313i;
    /* renamed from: j */
    private float f7314j;
    /* renamed from: k */
    private Paint f7315k;
    /* renamed from: l */
    private Paint f7316l;
    /* renamed from: m */
    private Path f7317m;
    /* renamed from: n */
    private float f7318n;
    /* renamed from: o */
    private float f7319o;

    public WaveformView(Context context) {
        this(context, null);
    }

    public WaveformView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveformView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7306b = 7.5f;
        this.f7307c = 4.0f;
        this.f7308d = 0.8625f;
        this.f7309e = C2188r.m8328a((int) C0965R.color.cl_other_c);
        this.f7310f = 2;
        this.f7311g = 5;
        this.f7312h = 0.1875f;
        this.f7313i = -0.1875f;
        this.f7314j = this.f7313i;
        m8523a();
    }

    /* renamed from: a */
    private void m8523a() {
        this.f7315k = new Paint();
        this.f7315k.setStrokeWidth(this.f7306b);
        this.f7315k.setAntiAlias(true);
        this.f7315k.setStyle(Style.STROKE);
        this.f7315k.setColor(this.f7309e);
        this.f7316l = new Paint();
        this.f7316l.setStrokeWidth(this.f7307c);
        this.f7316l.setAntiAlias(true);
        this.f7316l.setStyle(Style.STROKE);
        this.f7316l.setColor(this.f7309e);
        this.f7317m = new Path();
    }

    /* renamed from: a */
    public void m8524a(float amplitude) {
        this.f7308d = Math.max(amplitude, f7305a);
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        for (int l = 0; l < this.f7311g; l++) {
            float midH = ((float) height) / 2.0f;
            float midW = ((float) width) / 2.0f;
            float maxAmplitude = (midH / 2.0f) - 4.0f;
            float progress = 1.0f - ((((float) l) * 1.0f) / ((float) this.f7311g));
            float normalAmplitude = ((1.5f * progress) - 0.5f) * this.f7308d;
            float multiplier = (float) Math.min(1.0d, (double) (((progress / 3.0f) * 2.0f) + 0.33333334f));
            if (l != 0) {
                this.f7316l.setAlpha((int) (255.0f * multiplier));
            }
            this.f7317m.reset();
            int x = 0;
            while (x < this.f7310f + width) {
                float y = ((((1.0f - ((float) Math.pow((double) ((1.0f / midW) * (((float) x) - midW)), 2.0d))) * maxAmplitude) * normalAmplitude) * ((float) Math.sin((((double) (((float) (x * C4820d.f19955a)) * this.f7312h)) / (((double) width) * 3.141592653589793d)) + ((double) this.f7314j)))) + midH;
                if (x == 0) {
                    this.f7317m.moveTo((float) x, y);
                } else {
                    this.f7317m.lineTo((float) x, y);
                }
                this.f7318n = (float) x;
                this.f7319o = y;
                x += this.f7310f;
            }
            if (l == 0) {
                canvas.drawPath(this.f7317m, this.f7315k);
            } else {
                canvas.drawPath(this.f7317m, this.f7316l);
            }
        }
        this.f7314j += this.f7313i;
        invalidate();
    }
}
