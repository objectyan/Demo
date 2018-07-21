package com.facebook.drawee.d;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.k;
import javax.annotation.Nullable;

public class a
  extends Drawable
  implements Drawable.Callback, r, s
{
  private s a;
  private final e b = new e();
  private final Drawable[] c;
  private final d[] d;
  private final Rect e = new Rect();
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public a(Drawable[] paramArrayOfDrawable)
  {
    k.a(paramArrayOfDrawable);
    this.c = paramArrayOfDrawable;
    int i = 0;
    while (i < this.c.length)
    {
      f.a(this.c[i], this, this);
      i += 1;
    }
    this.d = new d[this.c.length];
  }
  
  private d c(int paramInt)
  {
    return new a.1(this, paramInt);
  }
  
  public int a()
  {
    return this.c.length;
  }
  
  @Nullable
  public Drawable a(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt >= this.c.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      return this.c[paramInt];
      bool1 = false;
      break;
    }
  }
  
  @Nullable
  public Drawable a(int paramInt, @Nullable Drawable paramDrawable)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt >= this.c.length) {
        break label119;
      }
    }
    label119:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      Drawable localDrawable = this.c[paramInt];
      if (paramDrawable != localDrawable)
      {
        if ((paramDrawable != null) && (this.h)) {
          paramDrawable.mutate();
        }
        f.a(this.c[paramInt], null, null);
        f.a(paramDrawable, null, null);
        f.a(paramDrawable, this.b);
        f.a(paramDrawable, this);
        f.a(paramDrawable, this, this);
        this.g = false;
        this.c[paramInt] = paramDrawable;
        invalidateSelf();
      }
      return localDrawable;
      bool1 = false;
      break;
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    if (this.a != null)
    {
      this.a.a(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void a(RectF paramRectF)
  {
    if (this.a != null)
    {
      this.a.a(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }
  
  public void a(s params)
  {
    this.a = params;
  }
  
  public d b(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      k.a(bool1);
      if (paramInt >= this.d.length) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.a(bool1);
      if (this.d[paramInt] == null) {
        this.d[paramInt] = c(paramInt);
      }
      return this.d[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.draw(paramCanvas);
      }
      i += 1;
    }
  }
  
  public int getIntrinsicHeight()
  {
    int j = -1;
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      int k = j;
      if (localDrawable != null) {
        k = Math.max(j, localDrawable.getIntrinsicHeight());
      }
      i += 1;
      j = k;
    }
    if (j > 0) {
      return j;
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    int j = -1;
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      int k = j;
      if (localDrawable != null) {
        k = Math.max(j, localDrawable.getIntrinsicWidth());
      }
      i += 1;
      j = k;
    }
    if (j > 0) {
      return j;
    }
    return -1;
  }
  
  public int getOpacity()
  {
    int k;
    if (this.c.length == 0)
    {
      k = -2;
      return k;
    }
    int i = -1;
    int j = 1;
    for (;;)
    {
      k = i;
      if (j >= this.c.length) {
        break;
      }
      Drawable localDrawable = this.c[j];
      k = i;
      if (localDrawable != null) {
        k = Drawable.resolveOpacity(i, localDrawable.getOpacity());
      }
      j += 1;
      i = k;
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    Rect localRect = this.e;
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null)
      {
        localDrawable.getPadding(localRect);
        paramRect.left = Math.max(paramRect.left, localRect.left);
        paramRect.top = Math.max(paramRect.top, localRect.top);
        paramRect.right = Math.max(paramRect.right, localRect.right);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.bottom);
      }
      i += 1;
    }
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if (!this.g)
    {
      this.f = false;
      int i = 0;
      if (i < this.c.length)
      {
        Drawable localDrawable = this.c[i];
        boolean bool2 = this.f;
        if ((localDrawable != null) && (localDrawable.isStateful())) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.f = (bool1 | bool2);
          i += 1;
          break;
        }
      }
      this.g = true;
    }
    return this.f;
  }
  
  public Drawable mutate()
  {
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.mutate();
      }
      i += 1;
    }
    this.h = true;
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setBounds(paramRect);
      }
      i += 1;
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    boolean bool1 = false;
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      boolean bool2 = bool1;
      if (localDrawable != null)
      {
        bool2 = bool1;
        if (localDrawable.setLevel(paramInt)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      boolean bool2 = bool1;
      if (localDrawable != null)
      {
        bool2 = bool1;
        if (localDrawable.setState(paramArrayOfInt)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    return bool1;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.a(paramInt);
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setAlpha(paramInt);
      }
      i += 1;
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.a(paramColorFilter);
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setColorFilter(paramColorFilter);
      }
      i += 1;
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setDither(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setFilterBitmap(paramBoolean);
      }
      i += 1;
    }
  }
  
  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setHotspot(paramFloat1, paramFloat2);
      }
      i += 1;
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    int i = 0;
    while (i < this.c.length)
    {
      Drawable localDrawable = this.c[i];
      if (localDrawable != null) {
        localDrawable.setVisible(paramBoolean1, paramBoolean2);
      }
      i += 1;
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */