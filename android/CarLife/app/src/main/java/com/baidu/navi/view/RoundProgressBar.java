package com.baidu.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.R.p;

public class RoundProgressBar
  extends View
{
  public static final int FILL = 1;
  public static final int STROKE = 0;
  private int max = 100;
  private Paint paint = new Paint();
  private int progress = 0;
  private int roundColor;
  private int roundProgressColor;
  private float roundProgressWidth;
  private float roundWidth;
  private int style;
  private int textColor;
  private boolean textIsDisplayable;
  private float textSize;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.p.RoundProgressBar);
    this.roundColor = paramAttributeSet.getColor(0, paramContext.getResources().getColor(2131559158));
    this.roundProgressColor = paramAttributeSet.getColor(1, paramContext.getResources().getColor(2131559159));
    this.textColor = paramAttributeSet.getColor(4, -16711936);
    this.textSize = paramAttributeSet.getDimension(5, 15.0F);
    this.roundWidth = paramAttributeSet.getDimension(2, paramContext.getResources().getDimension(2131362092));
    this.roundProgressWidth = paramAttributeSet.getDimension(3, paramContext.getResources().getDimension(2131362091));
    this.max = paramAttributeSet.getInteger(6, 100);
    this.textIsDisplayable = paramAttributeSet.getBoolean(7, false);
    this.style = paramAttributeSet.getInt(8, 0);
    paramAttributeSet.recycle();
  }
  
  public int getMax()
  {
    try
    {
      int i = this.max;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getProgress()
  {
    try
    {
      int i = this.progress;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getRoundColor()
  {
    return this.roundColor;
  }
  
  public int getRoundProgressColor()
  {
    return this.roundProgressColor;
  }
  
  public float getRoundWidth()
  {
    return this.roundWidth;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(i - this.roundWidth / 2.0F - 2.0F);
    this.paint.setColor(this.roundColor);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.roundWidth);
    this.paint.setAntiAlias(true);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setColor(this.textColor);
    this.paint.setTextSize(this.textSize);
    this.paint.setTypeface(Typeface.DEFAULT_BOLD);
    int k = (int)(this.progress / this.max * 100.0F);
    float f = this.paint.measureText(k + "%");
    if ((this.textIsDisplayable) && (k != 0) && (this.style == 0)) {
      paramCanvas.drawText(k + "%", i - f / 2.0F, i + this.textSize / 2.0F, this.paint);
    }
    this.paint.setStrokeWidth(this.roundProgressWidth);
    this.paint.setColor(this.roundProgressColor);
    RectF localRectF = new RectF(i - j, i - j, i + j, i + j);
    switch (this.style)
    {
    }
    do
    {
      do
      {
        return;
        this.paint.setStyle(Paint.Style.STROKE);
      } while (this.progress == 0);
      paramCanvas.drawArc(localRectF, 270.0F, this.progress * 360 / this.max, false, this.paint);
      return;
      this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
    } while (this.progress == 0);
    paramCanvas.drawArc(localRectF, 270.0F, this.progress * 360 / this.max, false, this.paint);
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("max not less than 0");
      }
      finally {}
    }
    this.max = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("progress not less than 0");
      }
      finally {}
    }
    int i = paramInt;
    if (paramInt > this.max) {
      i = this.max;
    }
    if (i <= this.max)
    {
      this.progress = i;
      postInvalidate();
    }
  }
  
  public void setRoundColor(int paramInt)
  {
    this.roundColor = paramInt;
  }
  
  public void setRoundProgressColor(int paramInt)
  {
    this.roundProgressColor = paramInt;
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.roundWidth = paramFloat;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/RoundProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */