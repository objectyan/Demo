package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.R;

public class TriangleStateView extends ImageView {
    /* renamed from: a */
    private int f7300a;
    /* renamed from: b */
    private Paint f7301b;
    /* renamed from: c */
    private int f7302c;

    public TriangleStateView(Context context) {
        this(context, null, 0);
    }

    public TriangleStateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriangleStateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7302c = context.getResources().getDimensionPixelSize(R.dimen.common_icon_small);
        this.f7300a = context.getResources().getColor(R.color.cl_btn_b_tab_select);
        this.f7301b = new Paint();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7301b.setStyle(Style.FILL);
        this.f7301b.setColor(this.f7300a);
        this.f7301b.setAntiAlias(true);
        Path path = new Path();
        path.moveTo((float) this.f7302c, 0.0f);
        path.lineTo((float) this.f7302c, (float) this.f7302c);
        path.lineTo(0.0f, (float) this.f7302c);
        path.close();
        canvas.drawPath(path, this.f7301b);
    }

    public void setBgColor(int color) {
        this.f7300a = color;
        invalidate();
    }
}
