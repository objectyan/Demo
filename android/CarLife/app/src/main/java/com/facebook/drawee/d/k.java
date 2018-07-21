package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class k
  extends Drawable
{
  private final Paint a = new Paint(1);
  private int b = Integer.MIN_VALUE;
  private int c = -2147450625;
  private int d = 10;
  private int e = 20;
  private int f = 0;
  private boolean g = false;
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Rect localRect = getBounds();
    paramInt1 = (localRect.width() - this.d * 2) * paramInt1 / 10000;
    int i = localRect.left + this.d;
    int j = localRect.bottom - this.d - this.e;
    this.a.setColor(paramInt2);
    paramCanvas.drawRect(i, j, i + paramInt1, this.e + j, this.a);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      invalidateSelf();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      invalidateSelf();
    }
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      invalidateSelf();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      invalidateSelf();
    }
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.g) && (this.f == 0)) {
      return;
    }
    a(paramCanvas, 10000, this.b);
    a(paramCanvas, this.f, this.c);
  }
  
  public int getOpacity()
  {
    return f.a(this.a.getColor());
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(this.d, this.d, this.d, this.d);
    return this.d != 0;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.f = paramInt;
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */