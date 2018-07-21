package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class DrawableWrapperLollipop
  extends DrawableWrapperKitKat
{
  private final boolean mUseCompatTinting;
  
  DrawableWrapperLollipop(Drawable paramDrawable)
  {
    this(paramDrawable, false);
  }
  
  DrawableWrapperLollipop(Drawable paramDrawable, boolean paramBoolean)
  {
    super(paramDrawable);
    this.mUseCompatTinting = paramBoolean;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    this.mDrawable.applyTheme(paramTheme);
  }
  
  public boolean canApplyTheme()
  {
    return this.mDrawable.canApplyTheme();
  }
  
  public Rect getDirtyBounds()
  {
    return this.mDrawable.getDirtyBounds();
  }
  
  public void getOutline(Outline paramOutline)
  {
    this.mDrawable.getOutline(paramOutline);
  }
  
  protected boolean isCompatTintEnabled()
  {
    return this.mUseCompatTinting;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.mDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void setTint(int paramInt)
  {
    if (this.mUseCompatTinting)
    {
      setCompatTint(paramInt);
      return;
    }
    this.mDrawable.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mUseCompatTinting)
    {
      setCompatTintList(paramColorStateList);
      return;
    }
    this.mDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mUseCompatTinting)
    {
      setCompatTintMode(paramMode);
      return;
    }
    this.mDrawable.setTintMode(paramMode);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/graphics/drawable/DrawableWrapperLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */