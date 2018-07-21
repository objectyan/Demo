package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public abstract interface DrawableWrapper
{
  public abstract Drawable getWrappedDrawable();
  
  public abstract void setCompatTint(int paramInt);
  
  public abstract void setCompatTintList(ColorStateList paramColorStateList);
  
  public abstract void setCompatTintMode(PorterDuff.Mode paramMode);
  
  public abstract void setWrappedDrawable(Drawable paramDrawable);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/v4/graphics/drawable/DrawableWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */