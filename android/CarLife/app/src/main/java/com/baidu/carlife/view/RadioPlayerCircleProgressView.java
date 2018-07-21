package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.core.d;
import com.baidu.carlife.util.r;

public class RadioPlayerCircleProgressView
  extends View
{
  private int a;
  private Paint b = new Paint();
  private final int c = d.a().c(2);
  private RectF d;
  private int e = 100;
  
  public RadioPlayerCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.b.setFlags(1);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(r.a(2131558680));
    this.b.setStrokeWidth(this.c);
    this.b.setStrokeCap(Paint.Cap.SQUARE);
    this.d = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (i == 0) {
      return;
    }
    this.d.set(this.c / 2, this.c / 2, i * 2 - this.c / 2, i * 2 - this.c / 2);
    paramCanvas.drawArc(this.d, -90.0F, 360.0F * (this.a / this.e), false, this.b);
  }
  
  public void setMax(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/RadioPlayerCircleProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */