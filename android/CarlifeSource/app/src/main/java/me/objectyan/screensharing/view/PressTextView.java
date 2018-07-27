package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import com.baidu.navisdk.util.common.ScreenUtil;

public class PressTextView extends TextView {
    /* renamed from: a */
    public static final int f7206a = 1;
    /* renamed from: b */
    public static final int f7207b = 2;
    /* renamed from: c */
    private boolean f7208c;
    /* renamed from: d */
    private int f7209d;

    public PressTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PressTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f7208c = false;
        this.f7209d = 0;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.f7209d != 1) {
            return super.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case 0:
                setAlpha(0.4f);
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                break;
        }
        return super.onTouchEvent(event);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7208c) {
            return;
        }
        if (this.f7209d == 1 || this.f7209d == 2) {
            int width = this.f7209d == 1 ? 94 : 90;
            int height = this.f7209d == 1 ? MessageType.BNMessageTypeTunnelUpdate : 66;
            int widthPx = ScreenUtil.getInstance().dip2px(width);
            int heightPx = ScreenUtil.getInstance().dip2px(height);
            int padding = ScreenUtil.getInstance().dip2px(5);
            Paint paint = new Paint();
            paint.setColor(-59580);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setStyle(Style.FILL_AND_STROKE);
            canvas.drawCircle((float) widthPx, (float) heightPx, (float) padding, paint);
        }
    }

    public void setNeedRedPoint(boolean isNeed) {
        this.f7208c = isNeed;
    }

    public void setPageType(int type) {
        this.f7209d = type;
    }
}
