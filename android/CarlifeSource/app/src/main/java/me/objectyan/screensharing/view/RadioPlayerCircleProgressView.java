package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.util.C2188r;

public class RadioPlayerCircleProgressView extends View {
    /* renamed from: a */
    private int f7210a;
    /* renamed from: b */
    private Paint f7211b = new Paint();
    /* renamed from: c */
    private final int f7212c = CarlifeScreenUtil.m4331a().m4343c(2);
    /* renamed from: d */
    private RectF f7213d;
    /* renamed from: e */
    private int f7214e = 100;

    public void setProgress(int progress) {
        this.f7210a = progress;
        invalidate();
    }

    public void setMax(int value) {
        this.f7214e = value;
    }

    public RadioPlayerCircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7211b.setAntiAlias(true);
        this.f7211b.setFlags(1);
        this.f7211b.setStyle(Style.STROKE);
        this.f7211b.setColor(C2188r.m8328a((int) R.color.cl_progress_radio_player));
        this.f7211b.setStrokeWidth((float) this.f7212c);
        this.f7211b.setStrokeCap(Cap.SQUARE);
        this.f7213d = new RectF();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;
        if (center != 0) {
            this.f7213d.set((float) (this.f7212c / 2), (float) (this.f7212c / 2), (float) ((center * 2) - (this.f7212c / 2)), (float) ((center * 2) - (this.f7212c / 2)));
            canvas.drawArc(this.f7213d, -90.0f, 360.0f * (((float) this.f7210a) / ((float) this.f7214e)), false, this.f7211b);
        }
    }
}
