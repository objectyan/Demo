package com.baidu.carlife.view.routerecordprocessview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CycleProcessBar
  extends View
{
  private final int a = 3;
  private final int b = ContextCompat.getColor(getContext(), 2131558625);
  private final int c = ContextCompat.getColor(getContext(), 2131558646);
  private final float d = 135.0F;
  private final float e = 270.0F;
  private Context f;
  private Paint g;
  private Paint h;
  private float i;
  private RectF j;
  private float k = 0.5F;
  
  public CycleProcessBar(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public CycleProcessBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(0.5F + this.f.getResources().getDisplayMetrics().density * paramFloat);
  }
  
  private void a()
  {
    this.i = a(3.0F);
    this.g = new Paint();
    this.g.setColor(this.b);
    this.g.setStrokeWidth(this.i);
    this.g.setAntiAlias(true);
    this.g.setFlags(1);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeCap(Paint.Cap.ROUND);
    this.h = new Paint();
    this.h.setColor(this.c);
    this.h.setStrokeWidth(this.i);
    this.h.setAntiAlias(true);
    this.h.setFlags(1);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeCap(Paint.Cap.ROUND);
    this.j = new RectF();
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.j, 135.0F, 270.0F, false, this.g);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.j, 135.0F, this.k * 270.0F, false, this.h);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getWidth() / 2;
    if (m == 0) {
      return;
    }
    this.j.set(this.i / 2.0F, this.i / 2.0F, m * 2 - this.i / 2.0F, m * 2 - this.i / 2.0F);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  public void setmPercent(float paramFloat)
  {
    this.k = paramFloat;
    invalidate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/routerecordprocessview/CycleProcessBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */