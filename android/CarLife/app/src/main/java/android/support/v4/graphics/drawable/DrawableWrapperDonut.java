package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class DrawableWrapperDonut
  extends Drawable
  implements Drawable.Callback, DrawableWrapper
{
  static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private boolean mColorFilterSet;
  private int mCurrentColor;
  private PorterDuff.Mode mCurrentMode;
  Drawable mDrawable;
  private ColorStateList mTintList;
  private PorterDuff.Mode mTintMode = DEFAULT_MODE;
  
  DrawableWrapperDonut(Drawable paramDrawable)
  {
    setWrappedDrawable(paramDrawable);
  }
  
  private boolean updateTint(int[] paramArrayOfInt)
  {
    if (!isCompatTintEnabled()) {}
    int i;
    do
    {
      return false;
      if ((this.mTintList == null) || (this.mTintMode == null)) {
        break;
      }
      i = this.mTintList.getColorForState(paramArrayOfInt, this.mTintList.getDefaultColor());
    } while ((this.mColorFilterSet) && (i == this.mCurrentColor) && (this.mTintMode == this.mCurrentMode));
    setColorFilter(i, this.mTintMode);
    this.mCurrentColor = i;
    this.mCurrentMode = this.mTintMode;
    this.mColorFilterSet = true;
    return true;
    this.mColorFilterSet = false;
    clearColorFilter();
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return this.mDrawable.getChangingConfigurations();
  }
  
  public Drawable getCurrent()
  {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mDrawable.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.mDrawable.getTransparentRegion();
  }
  
  public Drawable getWrappedDrawable()
  {
    return this.mDrawable;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  protected boolean isCompatTintEnabled()
  {
    return true;
  }
  
  public boolean isStateful()
  {
    if (isCompatTintEnabled()) {}
    for (ColorStateList localColorStateList = this.mTintList; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.mDrawable.isStateful()); localColorStateList = null) {
      return true;
    }
    return false;
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable1 = this.mDrawable;
    Drawable localDrawable2 = localDrawable1.mutate();
    if (localDrawable2 != localDrawable1) {
      setWrappedDrawable(localDrawable2);
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mDrawable.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setCompatTint(int paramInt)
  {
    setCompatTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setCompatTintList(ColorStateList paramColorStateList)
  {
    if (this.mTintList != paramColorStateList)
    {
      this.mTintList = paramColorStateList;
      updateTint(getState());
    }
  }
  
  public void setCompatTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mTintMode != paramMode)
    {
      this.mTintMode = paramMode;
      updateTint(getState());
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.mDrawable.setState(paramArrayOfInt);
    return (updateTint(paramArrayOfInt)) || (bool);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.mDrawable.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void setWrappedDrawable(Drawable paramDrawable)
  {
    if (this.mDrawable != null) {
      this.mDrawable.setCallback(null);
    }
    this.mDrawable = null;
    if (paramDrawable != null)
    {
      setBounds(paramDrawable.getBounds());
      paramDrawable.setCallback(this);
    }
    for (;;)
    {
      this.mDrawable = paramDrawable;
      invalidateSelf();
      return;
      setBounds(0, 0, 0, 0);
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/graphics/drawable/DrawableWrapperDonut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */