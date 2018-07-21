package com.facebook.drawee.e;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.d.h;
import com.facebook.drawee.d.t;
import com.facebook.drawee.d.u;
import javax.annotation.Nullable;

public class d
  extends h
  implements t
{
  @Nullable
  @VisibleForTesting
  Drawable a = null;
  @Nullable
  private u c;
  
  public d(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void a(@Nullable u paramu)
  {
    this.c = paramu;
  }
  
  public void d(@Nullable Drawable paramDrawable)
  {
    this.a = paramDrawable;
    invalidateSelf();
  }
  
  @SuppressLint({"WrongCall"})
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {}
    do
    {
      return;
      if (this.c != null) {
        this.c.c();
      }
      super.draw(paramCanvas);
    } while (this.a == null);
    this.a.setBounds(getBounds());
    this.a.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null) {
      this.c.a(paramBoolean1);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */