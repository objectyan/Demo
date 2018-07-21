package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.k;

public class i
  extends h
{
  private Matrix a;
  private Matrix c;
  private int d = 0;
  private int e = 0;
  
  public i(Drawable paramDrawable, Matrix paramMatrix)
  {
    super((Drawable)k.a(paramDrawable));
    this.a = paramMatrix;
  }
  
  private void c()
  {
    if ((this.d != getCurrent().getIntrinsicWidth()) || (this.e != getCurrent().getIntrinsicHeight())) {
      d();
    }
  }
  
  private void d()
  {
    Drawable localDrawable = getCurrent();
    Rect localRect = getBounds();
    int i = localDrawable.getIntrinsicWidth();
    this.d = i;
    int j = localDrawable.getIntrinsicHeight();
    this.e = j;
    if ((i <= 0) || (j <= 0))
    {
      localDrawable.setBounds(localRect);
      this.c = null;
      return;
    }
    localDrawable.setBounds(0, 0, i, j);
    this.c = this.a;
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    if (this.c != null) {
      paramMatrix.preConcat(this.c);
    }
  }
  
  public Matrix b()
  {
    return this.a;
  }
  
  public Drawable b(Drawable paramDrawable)
  {
    paramDrawable = super.b(paramDrawable);
    d();
    return paramDrawable;
  }
  
  public void c(Matrix paramMatrix)
  {
    this.a = paramMatrix;
    d();
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    c();
    if (this.c != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.c);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */