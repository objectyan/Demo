package com.facebook.drawee.d;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class e
{
  private static final int a = -1;
  private int b = -1;
  private boolean c = false;
  private ColorFilter d = null;
  private int e = -1;
  private int f = -1;
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(ColorFilter paramColorFilter)
  {
    this.d = paramColorFilter;
    this.c = true;
  }
  
  public void a(Drawable paramDrawable)
  {
    boolean bool2 = true;
    if (paramDrawable == null) {}
    do
    {
      return;
      if (this.b != -1) {
        paramDrawable.setAlpha(this.b);
      }
      if (this.c) {
        paramDrawable.setColorFilter(this.d);
      }
      if (this.e != -1)
      {
        if (this.e == 0) {
          break;
        }
        bool1 = true;
        paramDrawable.setDither(bool1);
      }
    } while (this.f == -1);
    if (this.f != 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramDrawable.setFilterBitmap(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.e = i;
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.f = i;
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */