package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.core.d;
import com.baidu.carlife.util.r;

public class CircleProgressBarView
  extends View
{
  private int a;
  private Paint b = new Paint();
  private Paint c;
  private Paint d;
  private int e = r.a(2131558625);
  private int f = r.a(2131558610);
  private int g = r.a(2131558698);
  private int h = d.a().c(2);
  private int i = d.a().c(14);
  private RectF j;
  
  public CircleProgressBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.b.setFlags(1);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.h);
    this.c = new Paint(this.b);
    this.c.setStrokeWidth(this.h * 2);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setFlags(1);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.d.setTextSize(this.i);
    this.j = new RectF();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getWidth() / 2;
    if (k == 0) {
      return;
    }
    this.b.setColor(this.e);
    this.c.setColor(this.f);
    this.d.setColor(this.g);
    paramCanvas.drawCircle(k, k, k - this.h, this.b);
    this.j.set(this.h, this.h, k * 2 - this.h, k * 2 - this.h);
    paramCanvas.drawArc(this.j, -90.0F, 360.0F * (this.a / 100.0F), false, this.c);
    paramCanvas.drawText(this.a + "%", k, this.i / 2 + k, this.d);
  }
  
  public void setProgress(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/CircleProgressBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */