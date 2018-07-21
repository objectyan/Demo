package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.Arrays;

public class n
  extends Drawable
  implements l
{
  @VisibleForTesting
  final float[] a = new float[8];
  @VisibleForTesting
  final Paint b = new Paint(1);
  @VisibleForTesting
  final Path c = new Path();
  @VisibleForTesting
  final Path d = new Path();
  private final float[] e = new float[8];
  private boolean f = false;
  private float g = 0.0F;
  private float h = 0.0F;
  private int i = 0;
  private int j = 0;
  private final RectF k = new RectF();
  private int l = 255;
  
  public n(float paramFloat, int paramInt)
  {
    this(paramInt);
    a(paramFloat);
  }
  
  public n(int paramInt)
  {
    a(paramInt);
  }
  
  public n(float[] paramArrayOfFloat, int paramInt)
  {
    this(paramInt);
    a(paramArrayOfFloat);
  }
  
  public static n a(ColorDrawable paramColorDrawable)
  {
    return new n(paramColorDrawable.getColor());
  }
  
  private void g()
  {
    this.c.reset();
    this.d.reset();
    this.k.set(getBounds());
    this.k.inset(this.g / 2.0F, this.g / 2.0F);
    if (this.f)
    {
      float f1 = Math.min(this.k.width(), this.k.height()) / 2.0F;
      this.d.addCircle(this.k.centerX(), this.k.centerY(), f1, Path.Direction.CW);
      this.k.inset(-this.g / 2.0F, -this.g / 2.0F);
      this.k.inset(this.h, this.h);
      if (!this.f) {
        break label265;
      }
      f1 = Math.min(this.k.width(), this.k.height()) / 2.0F;
      this.c.addCircle(this.k.centerX(), this.k.centerY(), f1, Path.Direction.CW);
    }
    for (;;)
    {
      this.k.inset(-this.h, -this.h);
      return;
      int m = 0;
      while (m < this.a.length)
      {
        this.a[m] = (this.e[m] + this.h - this.g / 2.0F);
        m += 1;
      }
      this.d.addRoundRect(this.k, this.a, Path.Direction.CW);
      break;
      label265:
      this.c.addRoundRect(this.k, this.e, Path.Direction.CW);
    }
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "radius should be non negative");
      Arrays.fill(this.e, paramFloat);
      g();
      invalidateSelf();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      invalidateSelf();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      invalidateSelf();
    }
    if (this.g != paramFloat)
    {
      this.g = paramFloat;
      g();
      invalidateSelf();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    g();
    invalidateSelf();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.e, 0.0F);
      g();
      invalidateSelf();
      return;
    }
    if (paramArrayOfFloat.length == 8) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.e, 0, 8);
      break;
    }
  }
  
  public void b(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      g();
      invalidateSelf();
    }
  }
  
  public float[] b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public float d()
  {
    return this.g;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.b.setColor(f.a(this.j, this.l));
    this.b.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.c, this.b);
    if (this.g != 0.0F)
    {
      this.b.setColor(f.a(this.i, this.l));
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setStrokeWidth(this.g);
      paramCanvas.drawPath(this.d, this.b);
    }
  }
  
  public float e()
  {
    return this.h;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public boolean g_()
  {
    return this.f;
  }
  
  public int getAlpha()
  {
    return this.l;
  }
  
  public int getOpacity()
  {
    return f.a(f.a(this.j, this.l));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    g();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.l)
    {
      this.l = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */