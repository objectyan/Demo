package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.Arrays;

public class o
  extends h
  implements l
{
  @VisibleForTesting
  a a = a.a;
  @VisibleForTesting
  final float[] c = new float[8];
  @VisibleForTesting
  final Paint d = new Paint(1);
  private final float[] e = new float[8];
  private boolean f = false;
  private float g = 0.0F;
  private int h = 0;
  private int i = 0;
  private float j = 0.0F;
  private final Path k = new Path();
  private final Path l = new Path();
  private final RectF m = new RectF();
  
  public o(Drawable paramDrawable)
  {
    super((Drawable)k.a(paramDrawable));
  }
  
  private void g()
  {
    this.k.reset();
    this.l.reset();
    this.m.set(getBounds());
    this.m.inset(this.j, this.j);
    if (this.f)
    {
      this.k.addCircle(this.m.centerX(), this.m.centerY(), Math.min(this.m.width(), this.m.height()) / 2.0F, Path.Direction.CW);
      this.m.inset(-this.j, -this.j);
      this.m.inset(this.g / 2.0F, this.g / 2.0F);
      if (!this.f) {
        break label221;
      }
      float f1 = Math.min(this.m.width(), this.m.height()) / 2.0F;
      this.l.addCircle(this.m.centerX(), this.m.centerY(), f1, Path.Direction.CW);
    }
    for (;;)
    {
      this.m.inset(-this.g / 2.0F, -this.g / 2.0F);
      return;
      this.k.addRoundRect(this.m, this.e, Path.Direction.CW);
      break;
      label221:
      int n = 0;
      while (n < this.c.length)
      {
        this.c[n] = (this.e[n] + this.j - this.g / 2.0F);
        n += 1;
      }
      this.l.addRoundRect(this.m, this.c, Path.Direction.CW);
    }
  }
  
  public void a(float paramFloat)
  {
    Arrays.fill(this.e, paramFloat);
    g();
    invalidateSelf();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
    invalidateSelf();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.h = paramInt;
    this.g = paramFloat;
    g();
    invalidateSelf();
  }
  
  public void a(a parama)
  {
    this.a = parama;
    invalidateSelf();
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
    this.j = paramFloat;
    g();
    invalidateSelf();
  }
  
  public float[] b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public float d()
  {
    return this.g;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    switch (1.a[this.a.ordinal()])
    {
    }
    for (;;)
    {
      if (this.h != 0)
      {
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(this.h);
        this.d.setStrokeWidth(this.g);
        this.k.setFillType(Path.FillType.EVEN_ODD);
        paramCanvas.drawPath(this.l, this.d);
      }
      return;
      int n = paramCanvas.save();
      this.k.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.k);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(n);
      continue;
      super.draw(paramCanvas);
      this.d.setColor(this.i);
      this.d.setStyle(Paint.Style.FILL);
      this.k.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      paramCanvas.drawPath(this.k, this.d);
      if (this.f)
      {
        float f1 = (localRect.width() - localRect.height() + this.g) / 2.0F;
        float f2 = (localRect.height() - localRect.width() + this.g) / 2.0F;
        if (f1 > 0.0F)
        {
          paramCanvas.drawRect(localRect.left, localRect.top, localRect.left + f1, localRect.bottom, this.d);
          paramCanvas.drawRect(localRect.right - f1, localRect.top, localRect.right, localRect.bottom, this.d);
        }
        if (f2 > 0.0F)
        {
          paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.top + f2, this.d);
          paramCanvas.drawRect(localRect.left, localRect.bottom - f2, localRect.right, localRect.bottom, this.d);
        }
      }
    }
  }
  
  public float e()
  {
    return this.j;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public boolean g_()
  {
    return this.f;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    g();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */