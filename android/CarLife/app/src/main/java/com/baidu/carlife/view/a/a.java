package com.baidu.carlife.view.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class a
  extends Drawable
{
  public static final int a = 1;
  private Paint b;
  private float c;
  private float d;
  private int e;
  private float f;
  private float g;
  private float h;
  
  public a(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramInt;
    this.f = (this.c / 2.0F);
    this.g = (this.d / 2.0F);
    this.h = this.f;
    this.b = new Paint();
  }
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramInt1;
    this.f = (this.c / 2.0F);
    this.g = (this.d / 2.0F);
    if (paramInt2 == 1) {}
    for (this.h = this.g;; this.h = this.f)
    {
      this.b = new Paint();
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, this.c, this.d, null, 31);
    this.b.setColor(this.e);
    this.b.setAntiAlias(true);
    paramCanvas.drawCircle(this.f, this.g, this.h, this.b);
    paramCanvas.restoreToCount(i);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */