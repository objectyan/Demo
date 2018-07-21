package com.facebook.drawee.d;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;

public class p
  extends h
{
  @VisibleForTesting
  q.c a;
  @VisibleForTesting
  Object c;
  @VisibleForTesting
  PointF d = null;
  @VisibleForTesting
  int e = 0;
  @VisibleForTesting
  int f = 0;
  @VisibleForTesting
  Matrix g;
  private Matrix h = new Matrix();
  
  public p(Drawable paramDrawable, q.c paramc)
  {
    super((Drawable)k.a(paramDrawable));
    this.a = paramc;
  }
  
  private void e()
  {
    int i = 0;
    if ((this.a instanceof q.l))
    {
      Object localObject = ((q.l)this.a).f();
      if ((localObject == null) || (!localObject.equals(this.c)))
      {
        i = 1;
        this.c = localObject;
      }
    }
    else
    {
      if ((this.e == getCurrent().getIntrinsicWidth()) && (this.f == getCurrent().getIntrinsicHeight())) {
        break label95;
      }
    }
    label95:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) || (i != 0)) {
        d();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void a(Matrix paramMatrix)
  {
    b(paramMatrix);
    e();
    if (this.g != null) {
      paramMatrix.preConcat(this.g);
    }
  }
  
  public void a(PointF paramPointF)
  {
    if (this.d == null) {
      this.d = new PointF();
    }
    this.d.set(paramPointF);
    d();
    invalidateSelf();
  }
  
  public void a(q.c paramc)
  {
    this.a = paramc;
    this.c = null;
    d();
    invalidateSelf();
  }
  
  public Drawable b(Drawable paramDrawable)
  {
    paramDrawable = super.b(paramDrawable);
    d();
    return paramDrawable;
  }
  
  public q.c b()
  {
    return this.a;
  }
  
  public PointF c()
  {
    return this.d;
  }
  
  @VisibleForTesting
  void d()
  {
    float f2 = 0.5F;
    Object localObject = getCurrent();
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    int k = ((Drawable)localObject).getIntrinsicWidth();
    this.e = k;
    int m = ((Drawable)localObject).getIntrinsicHeight();
    this.f = m;
    if ((k <= 0) || (m <= 0))
    {
      ((Drawable)localObject).setBounds(localRect);
      this.g = null;
      return;
    }
    if ((k == i) && (m == j))
    {
      ((Drawable)localObject).setBounds(localRect);
      this.g = null;
      return;
    }
    if (this.a == q.c.a)
    {
      ((Drawable)localObject).setBounds(localRect);
      this.g = null;
      return;
    }
    ((Drawable)localObject).setBounds(0, 0, k, m);
    localObject = this.a;
    Matrix localMatrix = this.h;
    if (this.d != null) {}
    for (float f1 = this.d.x;; f1 = 0.5F)
    {
      if (this.d != null) {
        f2 = this.d.y;
      }
      ((q.c)localObject).a(localMatrix, localRect, k, m, f1, f2);
      this.g = this.h;
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    e();
    if (this.g != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.g);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */