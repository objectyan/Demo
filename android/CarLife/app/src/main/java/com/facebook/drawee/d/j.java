package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;

public class j
  extends h
{
  @VisibleForTesting
  final Matrix a;
  private int c;
  private final Matrix d = new Matrix();
  private final RectF e = new RectF();
  
  public j(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable);
    if (paramInt % 90 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      this.a = new Matrix();
      this.c = paramInt;
      return;
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    b(paramMatrix);
    if (!this.a.isIdentity()) {
      paramMatrix.preConcat(this.a);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c <= 0)
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    paramCanvas.concat(this.a);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.c % 180 == 0) {
      return super.getIntrinsicHeight();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.c % 180 == 0) {
      return super.getIntrinsicWidth();
    }
    return super.getIntrinsicHeight();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = getCurrent();
    if (this.c > 0)
    {
      this.a.setRotate(this.c, paramRect.centerX(), paramRect.centerY());
      this.d.reset();
      this.a.invert(this.d);
      this.e.set(paramRect);
      this.d.mapRect(this.e);
      localDrawable.setBounds((int)this.e.left, (int)this.e.top, (int)this.e.right, (int)this.e.bottom);
      return;
    }
    localDrawable.setBounds(paramRect);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */