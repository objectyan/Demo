package com.baidu.che.codriver.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.baidu.carlife.C0965R;

public class CircleProgressBar extends View {
    /* renamed from: a */
    private float f9403a = 0.0f;
    /* renamed from: b */
    private float f9404b = getResources().getDimension(C0965R.dimen.default_2);
    /* renamed from: c */
    private float f9405c = getResources().getDimension(C0965R.dimen.default_2);
    /* renamed from: d */
    private int f9406d = -16777216;
    /* renamed from: e */
    private int f9407e = -7829368;
    /* renamed from: f */
    private int f9408f = -90;
    /* renamed from: g */
    private RectF f9409g;
    /* renamed from: h */
    private Paint f9410h;
    /* renamed from: i */
    private Paint f9411i;

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        m10852a(context, attrs);
    }

    /* renamed from: a */
    private void m10852a(Context context, AttributeSet attrs) {
        this.f9409g = new RectF();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, C0965R.C0963p.CircleProgressBar, 0, 0);
        try {
            this.f9403a = typedArray.getFloat(0, this.f9403a);
            this.f9404b = typedArray.getDimension(3, this.f9404b);
            this.f9405c = typedArray.getDimension(4, this.f9405c);
            this.f9406d = typedArray.getInt(1, this.f9406d);
            this.f9407e = typedArray.getInt(2, this.f9407e);
            this.f9410h = new Paint(1);
            this.f9410h.setColor(this.f9407e);
            this.f9410h.setStyle(Style.STROKE);
            this.f9410h.setStrokeWidth(this.f9405c);
            this.f9411i = new Paint(1);
            this.f9411i.setColor(this.f9406d);
            this.f9411i.setStyle(Style.STROKE);
            this.f9411i.setStrokeWidth(this.f9404b);
        } finally {
            typedArray.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.f9409g, this.f9410h);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f9409g, (float) this.f9408f, (360.0f * this.f9403a) / 100.0f, false, this.f9411i);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        setMeasuredDimension(min, min);
        float highStroke = this.f9404b > this.f9405c ? this.f9404b : this.f9405c;
        this.f9409g.set((highStroke / 2.0f) + 0.0f, (highStroke / 2.0f) + 0.0f, ((float) min) - (highStroke / 2.0f), ((float) min) - (highStroke / 2.0f));
    }

    public float getProgress() {
        return this.f9403a;
    }

    public void setProgress(float progress) {
        if (progress > 100.0f) {
            progress = 100.0f;
        }
        this.f9403a = progress;
        invalidate();
    }

    public float getProgressBarWidth() {
        return this.f9404b;
    }

    public void setProgressBarWidth(float strokeWidth) {
        this.f9404b = strokeWidth;
        this.f9411i.setStrokeWidth(strokeWidth);
        requestLayout();
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return this.f9405c;
    }

    public void setBackgroundProgressBarWidth(float backgroundStrokeWidth) {
        this.f9405c = backgroundStrokeWidth;
        this.f9410h.setStrokeWidth(backgroundStrokeWidth);
        requestLayout();
        invalidate();
    }

    public int getColor() {
        return this.f9406d;
    }

    public void setColor(int color) {
        this.f9406d = color;
        this.f9411i.setColor(color);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return this.f9407e;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.f9407e = backgroundColor;
        this.f9410h.setColor(backgroundColor);
        invalidate();
        requestLayout();
    }

    public void setProgressWithAnimation(float progress) {
        setProgressWithAnimation(progress, 1500);
    }

    public void setProgressWithAnimation(float progress, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", new float[]{progress});
        objectAnimator.setDuration((long) duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }
}
