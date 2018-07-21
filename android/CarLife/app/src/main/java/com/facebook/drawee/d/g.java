package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.Arrays;

public class g
  extends a
{
  @VisibleForTesting
  public static final int a = 0;
  @VisibleForTesting
  public static final int b = 1;
  @VisibleForTesting
  public static final int c = 2;
  @VisibleForTesting
  int d;
  @VisibleForTesting
  int e;
  @VisibleForTesting
  long f;
  @VisibleForTesting
  int[] g;
  @VisibleForTesting
  int[] h;
  @VisibleForTesting
  int i;
  @VisibleForTesting
  boolean[] j;
  @VisibleForTesting
  int k;
  private final Drawable[] l;
  
  public g(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
    if (paramArrayOfDrawable.length >= 1) {}
    for (;;)
    {
      k.b(bool, "At least one layer required!");
      this.l = paramArrayOfDrawable;
      this.g = new int[paramArrayOfDrawable.length];
      this.h = new int[paramArrayOfDrawable.length];
      this.i = 255;
      this.j = new boolean[paramArrayOfDrawable.length];
      this.k = 0;
      k();
      return;
      bool = false;
    }
  }
  
  private void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (paramInt > 0))
    {
      this.k += 1;
      paramDrawable.mutate().setAlpha(paramInt);
      this.k -= 1;
      paramDrawable.draw(paramCanvas);
    }
  }
  
  private boolean a(float paramFloat)
  {
    boolean bool2 = true;
    int m = 0;
    if (m < this.l.length)
    {
      if (this.j[m] != 0) {}
      for (int n = 1;; n = -1)
      {
        this.h[m] = ((int)(this.g[m] + n * 255 * paramFloat));
        if (this.h[m] < 0) {
          this.h[m] = 0;
        }
        if (this.h[m] > 255) {
          this.h[m] = 255;
        }
        boolean bool1 = bool2;
        if (this.j[m] != 0)
        {
          bool1 = bool2;
          if (this.h[m] < 255) {
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (this.j[m] == 0)
        {
          bool2 = bool1;
          if (this.h[m] > 0) {
            bool2 = false;
          }
        }
        m += 1;
        break;
      }
    }
    return bool2;
  }
  
  private void k()
  {
    this.d = 2;
    Arrays.fill(this.g, 0);
    this.g[0] = 255;
    Arrays.fill(this.h, 0);
    this.h[0] = 255;
    Arrays.fill(this.j, false);
    this.j[0] = true;
  }
  
  public void b()
  {
    this.k += 1;
  }
  
  public void c()
  {
    this.k -= 1;
    invalidateSelf();
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
    if (this.d == 1) {
      this.d = 0;
    }
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.d = 0;
    this.j[paramInt] = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int m = 2;
    boolean bool1 = false;
    boolean bool2 = true;
    switch (this.d)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      m = 0;
      while (m < this.l.length)
      {
        a(paramCanvas, this.l[m], this.h[m] * this.i / 255);
        m += 1;
      }
      System.arraycopy(this.h, 0, this.g, 0, this.l.length);
      this.f = i();
      float f1;
      if (this.e == 0)
      {
        f1 = 1.0F;
        label123:
        bool1 = a(f1);
        if (!bool1) {
          break label148;
        }
      }
      for (;;)
      {
        this.d = m;
        break;
        f1 = 0.0F;
        break label123;
        label148:
        m = 1;
      }
      if (this.e > 0) {
        bool1 = true;
      }
      k.b(bool1);
      bool1 = a((float)(i() - this.f) / this.e);
      if (bool1) {}
      for (;;)
      {
        this.d = m;
        break;
        m = 1;
      }
      bool1 = true;
    }
    if (!bool1) {
      invalidateSelf();
    }
  }
  
  public void e()
  {
    k();
    invalidateSelf();
  }
  
  public void e(int paramInt)
  {
    this.d = 0;
    this.j[paramInt] = false;
    invalidateSelf();
  }
  
  public void f()
  {
    this.d = 0;
    Arrays.fill(this.j, true);
    invalidateSelf();
  }
  
  public void f(int paramInt)
  {
    this.d = 0;
    Arrays.fill(this.j, false);
    this.j[paramInt] = true;
    invalidateSelf();
  }
  
  public void g()
  {
    this.d = 0;
    Arrays.fill(this.j, false);
    invalidateSelf();
  }
  
  public void g(int paramInt)
  {
    this.d = 0;
    Arrays.fill(this.j, 0, paramInt + 1, true);
    Arrays.fill(this.j, paramInt + 1, this.l.length, false);
    invalidateSelf();
  }
  
  public int getAlpha()
  {
    return this.i;
  }
  
  public void h()
  {
    this.d = 2;
    int m = 0;
    if (m < this.l.length)
    {
      int[] arrayOfInt = this.h;
      if (this.j[m] != 0) {}
      for (int n = 255;; n = 0)
      {
        arrayOfInt[m] = n;
        m += 1;
        break;
      }
    }
    invalidateSelf();
  }
  
  public boolean h(int paramInt)
  {
    return this.j[paramInt];
  }
  
  protected long i()
  {
    return SystemClock.uptimeMillis();
  }
  
  public void invalidateSelf()
  {
    if (this.k == 0) {
      super.invalidateSelf();
    }
  }
  
  @VisibleForTesting
  public int j()
  {
    return this.d;
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      invalidateSelf();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */