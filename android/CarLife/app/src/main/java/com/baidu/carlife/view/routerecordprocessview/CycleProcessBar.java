package com.baidu.carlife.view.routerecordprocessview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.C0965R;

public class CycleProcessBar extends View {
    /* renamed from: a */
    private final int f7788a = 3;
    /* renamed from: b */
    private final int f7789b = ContextCompat.getColor(getContext(), C0965R.color.cl_line_a2_progress);
    /* renamed from: c */
    private final int f7790c = ContextCompat.getColor(getContext(), C0965R.color.cl_other_c);
    /* renamed from: d */
    private final float f7791d = 135.0f;
    /* renamed from: e */
    private final float f7792e = 270.0f;
    /* renamed from: f */
    private Context f7793f;
    /* renamed from: g */
    private Paint f7794g;
    /* renamed from: h */
    private Paint f7795h;
    /* renamed from: i */
    private float f7796i;
    /* renamed from: j */
    private RectF f7797j;
    /* renamed from: k */
    private float f7798k = 0.5f;

    public CycleProcessBar(Context context) {
        super(context, null);
    }

    public CycleProcessBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7793f = context;
        m8954a();
    }

    public void setmPercent(float percent) {
        this.f7798k = percent;
        invalidate();
    }

    /* renamed from: a */
    private void m8954a() {
        this.f7796i = (float) m8953a(3.0f);
        this.f7794g = new Paint();
        this.f7794g.setColor(this.f7789b);
        this.f7794g.setStrokeWidth(this.f7796i);
        this.f7794g.setAntiAlias(true);
        this.f7794g.setFlags(1);
        this.f7794g.setStyle(Style.STROKE);
        this.f7794g.setStrokeCap(Cap.ROUND);
        this.f7795h = new Paint();
        this.f7795h.setColor(this.f7790c);
        this.f7795h.setStrokeWidth(this.f7796i);
        this.f7795h.setAntiAlias(true);
        this.f7795h.setFlags(1);
        this.f7795h.setStyle(Style.STROKE);
        this.f7795h.setStrokeCap(Cap.ROUND);
        this.f7797j = new RectF();
    }

    protected void onDraw(Canvas canvas) {
        int center = getWidth() / 2;
        if (center != 0) {
            this.f7797j.set(this.f7796i / 2.0f, this.f7796i / 2.0f, ((float) (center * 2)) - (this.f7796i / 2.0f), ((float) (center * 2)) - (this.f7796i / 2.0f));
            m8955a(canvas);
            m8956b(canvas);
        }
    }

    /* renamed from: a */
    private void m8955a(Canvas canvas) {
        canvas.drawArc(this.f7797j, 135.0f, 270.0f, false, this.f7794g);
    }

    /* renamed from: b */
    private void m8956b(Canvas canvas) {
        canvas.drawArc(this.f7797j, 135.0f, this.f7798k * 270.0f, false, this.f7795h);
    }

    /* renamed from: a */
    private int m8953a(float dip) {
        return (int) (0.5f + (this.f7793f.getResources().getDisplayMetrics().density * dip));
    }
}
