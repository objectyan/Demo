package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.util.C2188r;

public class CircleProgressBarView extends View {
    /* renamed from: a */
    private int f7073a;
    /* renamed from: b */
    private Paint f7074b = new Paint();
    /* renamed from: c */
    private Paint f7075c;
    /* renamed from: d */
    private Paint f7076d;
    /* renamed from: e */
    private int f7077e = C2188r.m8328a((int) C0965R.color.cl_line_a2_progress);
    /* renamed from: f */
    private int f7078f = C2188r.m8328a((int) C0965R.color.cl_btn_b_tab_select);
    /* renamed from: g */
    private int f7079g = C2188r.m8328a((int) C0965R.color.cl_text_a4_content);
    /* renamed from: h */
    private int f7080h = C1249d.m4331a().m4343c(2);
    /* renamed from: i */
    private int f7081i = C1249d.m4331a().m4343c(14);
    /* renamed from: j */
    private RectF f7082j;

    public void setProgress(int progress) {
        this.f7073a = progress;
        invalidate();
    }

    public void setProgressColor(int bgColor, int progressColor, int textColor) {
        this.f7077e = bgColor;
        this.f7078f = progressColor;
        this.f7079g = textColor;
    }

    public CircleProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7074b.setAntiAlias(true);
        this.f7074b.setFlags(1);
        this.f7074b.setStyle(Style.STROKE);
        this.f7074b.setStrokeWidth((float) this.f7080h);
        this.f7075c = new Paint(this.f7074b);
        this.f7075c.setStrokeWidth((float) (this.f7080h * 2));
        this.f7076d = new Paint();
        this.f7076d.setAntiAlias(true);
        this.f7076d.setFlags(1);
        this.f7076d.setTextAlign(Align.CENTER);
        this.f7076d.setTextSize((float) this.f7081i);
        this.f7082j = new RectF();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;
        if (center != 0) {
            this.f7074b.setColor(this.f7077e);
            this.f7075c.setColor(this.f7078f);
            this.f7076d.setColor(this.f7079g);
            canvas.drawCircle((float) center, (float) center, (float) (center - this.f7080h), this.f7074b);
            this.f7082j.set((float) this.f7080h, (float) this.f7080h, (float) ((center * 2) - this.f7080h), (float) ((center * 2) - this.f7080h));
            canvas.drawArc(this.f7082j, -90.0f, 360.0f * (((float) this.f7073a) / 100.0f), false, this.f7075c);
            canvas.drawText(this.f7073a + "%", (float) center, (float) ((this.f7081i / 2) + center), this.f7076d);
        }
    }
}
