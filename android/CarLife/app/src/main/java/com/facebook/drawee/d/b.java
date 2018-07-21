package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;

public class b
  extends h
  implements c, Runnable
{
  private static final int c = 360;
  private static final int d = 20;
  @VisibleForTesting
  float a = 0.0F;
  private int e;
  private boolean f;
  private boolean g = false;
  
  public b(Drawable paramDrawable, int paramInt)
  {
    this(paramDrawable, paramInt, true);
  }
  
  public b(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    super((Drawable)k.a(paramDrawable));
    this.e = paramInt;
    this.f = paramBoolean;
  }
  
  private void e()
  {
    if (!this.g)
    {
      this.g = true;
      scheduleSelf(this, SystemClock.uptimeMillis() + 20L);
    }
  }
  
  private int f()
  {
    return (int)(20.0F / this.e * 360.0F);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b()
  {
    this.a = 0.0F;
    this.g = false;
    unscheduleSelf(this);
    invalidateSelf();
  }
  
  public b c()
  {
    return new b(f.a(a()), this.e, this.f);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    Rect localRect = getBounds();
    int j = localRect.right;
    int k = localRect.left;
    int m = localRect.bottom;
    int n = localRect.top;
    float f1 = this.a;
    if (!this.f) {
      f1 = 360.0F - this.a;
    }
    paramCanvas.rotate(f1, localRect.left + (j - k) / 2, localRect.top + (m - n) / 2);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    e();
  }
  
  public void run()
  {
    this.g = false;
    this.a += f();
    invalidateSelf();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */