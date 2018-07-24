package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.R;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.util.C2188r;

public class MusicCircleView extends View {
    /* renamed from: a */
    private final int f7205a = CarlifeScreenUtil.m4331a().m4343c(2);

    public MusicCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setColor(C2188r.m8328a((int) R.color.cl_line_a2_progress));
        paint.setAntiAlias(true);
        paint.setStrokeWidth((float) this.f7205a);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - (this.f7205a / 2)), paint);
    }
}
