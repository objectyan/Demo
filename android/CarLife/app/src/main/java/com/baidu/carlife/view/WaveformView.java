package com.baidu.carlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.carlife.util.r;

public class WaveformView
  extends View
{
  private static final float a = 0.0575F;
  private float b = 7.5F;
  private float c = 4.0F;
  private float d = 0.8625F;
  private int e = r.a(2131558646);
  private int f = 2;
  private int g = 5;
  private float h = 0.1875F;
  private float i = -0.1875F;
  private float j = this.i;
  private Paint k;
  private Paint l;
  private Path m;
  private float n;
  private float o;
  
  public WaveformView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WaveformView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WaveformView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.k = new Paint();
    this.k.setStrokeWidth(this.b);
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.STROKE);
    this.k.setColor(this.e);
    this.l = new Paint();
    this.l.setStrokeWidth(this.c);
    this.l.setAntiAlias(true);
    this.l.setStyle(Paint.Style.STROKE);
    this.l.setColor(this.e);
    this.m = new Path();
  }
  
  public void a(float paramFloat)
  {
    this.d = Math.max(paramFloat, 0.0575F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i3 = getWidth();
    int i4 = getHeight();
    int i1 = 0;
    if (i1 < this.g)
    {
      float f1 = i4 / 2.0F;
      float f2 = i3 / 2.0F;
      float f3 = f1 / 2.0F;
      float f4 = 1.0F - i1 * 1.0F / this.g;
      float f5 = this.d;
      float f6 = (float)Math.min(1.0D, f4 / 3.0F * 2.0F + 0.33333334F);
      if (i1 != 0) {
        this.l.setAlpha((int)(255.0F * f6));
      }
      this.m.reset();
      int i2 = 0;
      if (i2 < this.f + i3)
      {
        f6 = (1.0F - (float)Math.pow(1.0F / f2 * (i2 - f2), 2.0D)) * (f3 - 4.0F) * ((1.5F * f4 - 0.5F) * f5) * (float)Math.sin(i2 * 180 * this.h / (i3 * 3.141592653589793D) + this.j) + f1;
        if (i2 == 0) {
          this.m.moveTo(i2, f6);
        }
        for (;;)
        {
          this.n = i2;
          this.o = f6;
          i2 += this.f;
          break;
          this.m.lineTo(i2, f6);
        }
      }
      if (i1 == 0) {
        paramCanvas.drawPath(this.m, this.k);
      }
      for (;;)
      {
        i1 += 1;
        break;
        paramCanvas.drawPath(this.m, this.l);
      }
    }
    this.j += this.i;
    invalidate();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/WaveformView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */