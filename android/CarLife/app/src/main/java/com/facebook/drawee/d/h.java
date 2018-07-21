package com.facebook.drawee.d;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class h
  extends Drawable
  implements Drawable.Callback, d, r, s
{
  private static final Matrix d = new Matrix();
  private Drawable a;
  protected s b;
  private final e c = new e();
  
  public h(Drawable paramDrawable)
  {
    this.a = paramDrawable;
    f.a(this.a, this, this);
  }
  
  public Drawable a()
  {
    return getCurrent();
  }
  
  public Drawable a(Drawable paramDrawable)
  {
    return b(paramDrawable);
  }
  
  public void a(Matrix paramMatrix)
  {
    b(paramMatrix);
  }
  
  public void a(RectF paramRectF)
  {
    if (this.b != null)
    {
      this.b.a(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }
  
  public void a(s params)
  {
    this.b = params;
  }
  
  public Drawable b(Drawable paramDrawable)
  {
    paramDrawable = c(paramDrawable);
    invalidateSelf();
    return paramDrawable;
  }
  
  protected void b(Matrix paramMatrix)
  {
    if (this.b != null)
    {
      this.b.a(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }
  
  public void b(RectF paramRectF)
  {
    b(d);
    paramRectF.set(getBounds());
    d.mapRect(paramRectF);
  }
  
  protected Drawable c(Drawable paramDrawable)
  {
    Drawable localDrawable = this.a;
    f.a(localDrawable, null, null);
    f.a(paramDrawable, null, null);
    f.a(paramDrawable, this.c);
    f.a(paramDrawable, this);
    f.a(paramDrawable, this, this);
    this.a = paramDrawable;
    return localDrawable;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
  }
  
  public Drawable getCurrent()
  {
    return this.a;
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return this.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.a.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.a.isStateful();
  }
  
  public Drawable mutate()
  {
    this.a.mutate();
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.a.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.a.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    return this.a.setState(paramArrayOfInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.c.a(paramInt);
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.a(paramColorFilter);
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    this.a.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.c.b(paramBoolean);
    this.a.setFilterBitmap(paramBoolean);
  }
  
  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.a.setHotspot(paramFloat1, paramFloat2);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setVisible(paramBoolean1, paramBoolean2);
    return this.a.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */