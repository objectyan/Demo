package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CircleWaveView extends View {
    private Paint paint;
    private int radius;

    public CircleWaveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleWaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.radius = 0;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(BNStyleManager.getColor(C4048R.color.nsdk_cl_asr_voice_wave));
        this.paint.setStyle(Style.FILL);
    }

    public CircleWaveView(Context context) {
        super(context);
        this.radius = 0;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(BNStyleManager.getColor(C4048R.color.nsdk_cl_asr_voice_wave));
        this.paint.setStyle(Style.FILL);
    }

    public void setCircleRadius(int percent) {
        if (percent + 10 > 80) {
            this.radius = (int) (80.0f * ScreenUtil.getInstance().getDensity());
        } else {
            this.radius = (int) (((float) (percent + 10)) * ScreenUtil.getInstance().getDensity());
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), (float) this.radius, this.paint);
    }
}
