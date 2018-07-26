package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1249d;
import com.baidu.carlife.util.C2188r;

public class MusicCircleProgressView extends View {
    /* renamed from: a */
    private int f7200a;
    /* renamed from: b */
    private Paint f7201b = new Paint();
    /* renamed from: c */
    private final int f7202c = C1249d.m4331a().m4343c(8);
    /* renamed from: d */
    private RectF f7203d;
    /* renamed from: e */
    private int f7204e = 100;

    public void setProgress(int progress) {
        this.f7200a = progress;
        invalidate();
    }

    public void setMax(int value) {
        this.f7204e = value;
    }

    public MusicCircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f7201b.setAntiAlias(true);
        this.f7201b.setFlags(1);
        this.f7201b.setStyle(Style.STROKE);
        this.f7201b.setColor(C2188r.m8328a((int) C0965R.color.cl_other_c_highlight));
        this.f7201b.setStrokeWidth((float) this.f7202c);
        this.f7201b.setStrokeCap(Cap.SQUARE);
        this.f7203d = new RectF();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;
        if (center != 0) {
            this.f7203d.set((float) (this.f7202c / 2), (float) (this.f7202c / 2), (float) ((center * 2) - (this.f7202c / 2)), (float) ((center * 2) - (this.f7202c / 2)));
            canvas.drawArc(this.f7203d, -90.0f, 360.0f * (((float) this.f7200a) / ((float) this.f7204e)), false, this.f7201b);
        }
    }
}
