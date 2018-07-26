package com.baidu.navisdk.ui.routedetails;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class TextViewWithSpecifyBackground extends TextView {
    private static final String TAG = TextViewWithSpecifyBackground.class.getName();
    private int mColor;
    private ShapeDrawable mShapeDrawable;

    private class MyShape extends Shape {
        TextViewWithSpecifyBackground pn;

        public MyShape(TextViewWithSpecifyBackground pn) {
            this.pn = pn;
        }

        public void draw(Canvas canvas, Paint paint) {
            paint.setColor(TextViewWithSpecifyBackground.this.mColor);
            int starty = ScreenUtil.getInstance().dip2px(1);
            int num = (this.pn.getHeight() - starty) / 2;
            canvas.drawRect((float) num, (float) starty, (float) (this.pn.getWidth() - num), (float) this.pn.getHeight(), paint);
            canvas.drawCircle((float) num, (float) (num + starty), (float) num, paint);
            canvas.drawCircle((float) (this.pn.getWidth() - num), (float) (num + starty), (float) num, paint);
            LogUtil.m15791e(TextViewWithSpecifyBackground.TAG, "pain Rect And Circle");
        }
    }

    public TextViewWithSpecifyBackground(Context context) {
        super(context);
        setWillNotDraw(false);
        drawDefaultBGColor();
        setSingleLine(true);
    }

    public TextViewWithSpecifyBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        drawDefaultBGColor();
        setSingleLine(true);
    }

    public void drawDefaultBGColor() {
        if (this.mShapeDrawable == null) {
            this.mShapeDrawable = new ShapeDrawable();
        }
        this.mShapeDrawable.setShape(new MyShape(this));
        setBackgroundDrawable(this.mShapeDrawable);
    }

    public void setViewBGColor(int color) {
        this.mColor = color;
    }
}
