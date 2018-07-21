package com.baidu.che.codriver.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.baidu.carlife.R.p;

public class CircleProgressBar
  extends View
{
  private float a = 0.0F;
  private float b = getResources().getDimension(2131361898);
  private float c = getResources().getDimension(2131361898);
  private int d = -16777216;
  private int e = -7829368;
  private int f = -90;
  private RectF g;
  private Paint h;
  private Paint i;
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = new RectF();
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.p.CircleProgressBar, 0, 0);
    try
    {
      this.a = paramContext.getFloat(0, this.a);
      this.b = paramContext.getDimension(3, this.b);
      this.c = paramContext.getDimension(4, this.c);
      this.d = paramContext.getInt(1, this.d);
      this.e = paramContext.getInt(2, this.e);
      paramContext.recycle();
      this.h = new Paint(1);
      this.h.setColor(this.e);
      this.h.setStyle(Paint.Style.STROKE);
      this.h.setStrokeWidth(this.c);
      this.i = new Paint(1);
      this.i.setColor(this.d);
      this.i.setStyle(Paint.Style.STROKE);
      this.i.setStrokeWidth(this.b);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public int getBackgroundColor()
  {
    return this.e;
  }
  
  public float getBackgroundProgressBarWidth()
  {
    return this.c;
  }
  
  public int getColor()
  {
    return this.d;
  }
  
  public float getProgress()
  {
    return this.a;
  }
  
  public float getProgressBarWidth()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawOval(this.g, this.h);
    float f1 = 360.0F * this.a / 100.0F;
    paramCanvas.drawArc(this.g, this.f, f1, false, this.i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    paramInt1 = Math.min(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), paramInt2);
    setMeasuredDimension(paramInt1, paramInt1);
    if (this.b > this.c) {}
    for (float f1 = this.b;; f1 = this.c)
    {
      this.g.set(f1 / 2.0F + 0.0F, f1 / 2.0F + 0.0F, paramInt1 - f1 / 2.0F, paramInt1 - f1 / 2.0F);
      return;
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.e = paramInt;
    this.h.setColor(paramInt);
    invalidate();
    requestLayout();
  }
  
  public void setBackgroundProgressBarWidth(float paramFloat)
  {
    this.c = paramFloat;
    this.h.setStrokeWidth(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.d = paramInt;
    this.i.setColor(paramInt);
    invalidate();
    requestLayout();
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat <= 100.0F) {}
    for (;;)
    {
      this.a = paramFloat;
      invalidate();
      return;
      paramFloat = 100.0F;
    }
  }
  
  public void setProgressBarWidth(float paramFloat)
  {
    this.b = paramFloat;
    this.i.setStrokeWidth(paramFloat);
    requestLayout();
    invalidate();
  }
  
  public void setProgressWithAnimation(float paramFloat)
  {
    setProgressWithAnimation(paramFloat, 1500);
  }
  
  public void setProgressWithAnimation(float paramFloat, int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "progress", new float[] { paramFloat });
    localObjectAnimator.setDuration(paramInt);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.start();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CircleProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */