package com.facebook.drawee.d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import javax.annotation.Nullable;

public class f
{
  public static int a(int paramInt)
  {
    paramInt >>>= 24;
    if (paramInt == 255) {
      return -1;
    }
    if (paramInt == 0) {
      return -2;
    }
    return -3;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255) {
      return paramInt1;
    }
    if (paramInt2 == 0) {
      return paramInt1 & 0xFFFFFF;
    }
    return (paramInt1 >>> 24) * (paramInt2 + (paramInt2 >> 7)) >> 8 << 24 | 0xFFFFFF & paramInt1;
  }
  
  @Nullable
  public static Drawable a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof c)) {
      return ((c)paramDrawable).d();
    }
    paramDrawable = paramDrawable.getConstantState();
    if (paramDrawable != null) {
      return paramDrawable.newDrawable();
    }
    return null;
  }
  
  public static void a(Drawable paramDrawable, @Nullable Drawable.Callback paramCallback, @Nullable s params)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(paramCallback);
      if ((paramDrawable instanceof r)) {
        ((r)paramDrawable).a(params);
      }
    }
  }
  
  public static void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable2 == null) || (paramDrawable1 == null) || (paramDrawable1 == paramDrawable2)) {
      return;
    }
    paramDrawable1.setBounds(paramDrawable2.getBounds());
    paramDrawable1.setChangingConfigurations(paramDrawable2.getChangingConfigurations());
    paramDrawable1.setLevel(paramDrawable2.getLevel());
    paramDrawable1.setVisible(paramDrawable2.isVisible(), false);
    paramDrawable1.setState(paramDrawable2.getState());
  }
  
  public static void a(Drawable paramDrawable, e parame)
  {
    if ((paramDrawable == null) || (parame == null)) {
      return;
    }
    parame.a(paramDrawable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */