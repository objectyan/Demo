package com.facebook.drawee.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

public class m
  extends BitmapDrawable
  implements l, r
{
  @VisibleForTesting
  final float[] a = new float[8];
  @VisibleForTesting
  final RectF b = new RectF();
  @VisibleForTesting
  final RectF c = new RectF();
  @VisibleForTesting
  final RectF d = new RectF();
  @VisibleForTesting
  final RectF e = new RectF();
  @VisibleForTesting
  final Matrix f = new Matrix();
  @VisibleForTesting
  final Matrix g = new Matrix();
  @VisibleForTesting
  final Matrix h = new Matrix();
  @VisibleForTesting
  final Matrix i = new Matrix();
  @VisibleForTesting
  final Matrix j = new Matrix();
  @VisibleForTesting
  final Matrix k = new Matrix();
  private boolean l = false;
  private boolean m = false;
  private final float[] n = new float[8];
  private float o = 0.0F;
  private int p = 0;
  private float q = 0.0F;
  private final Path r = new Path();
  private final Path s = new Path();
  private boolean t = true;
  private final Paint u = new Paint();
  private final Paint v = new Paint(1);
  private boolean w = true;
  private WeakReference<Bitmap> x;
  @Nullable
  private s y;
  
  public m(Resources paramResources, Bitmap paramBitmap)
  {
    this(paramResources, paramBitmap, null);
  }
  
  public m(Resources paramResources, Bitmap paramBitmap, @Nullable Paint paramPaint)
  {
    super(paramResources, paramBitmap);
    if (paramPaint != null) {
      this.u.set(paramPaint);
    }
    this.u.setFlags(1);
    this.v.setStyle(Paint.Style.STROKE);
  }
  
  public static m a(Resources paramResources, BitmapDrawable paramBitmapDrawable)
  {
    return new m(paramResources, paramBitmapDrawable.getBitmap(), paramBitmapDrawable.getPaint());
  }
  
  private void g()
  {
    if (this.y != null)
    {
      this.y.a(this.h);
      this.y.a(this.b);
    }
    for (;;)
    {
      this.d.set(0.0F, 0.0F, getBitmap().getWidth(), getBitmap().getHeight());
      this.e.set(getBounds());
      this.f.setRectToRect(this.d, this.e, Matrix.ScaleToFit.FILL);
      if ((!this.h.equals(this.i)) || (!this.f.equals(this.g)))
      {
        this.w = true;
        this.h.invert(this.j);
        this.k.set(this.h);
        this.k.preConcat(this.f);
        this.i.set(this.h);
        this.g.set(this.f);
      }
      if (!this.b.equals(this.c))
      {
        this.t = true;
        this.c.set(this.b);
      }
      return;
      this.h.reset();
      this.b.set(getBounds());
    }
  }
  
  private void h()
  {
    if (this.t)
    {
      this.s.reset();
      this.b.inset(this.o / 2.0F, this.o / 2.0F);
      if (!this.l) {
        break label211;
      }
      float f1 = Math.min(this.b.width(), this.b.height()) / 2.0F;
      this.s.addCircle(this.b.centerX(), this.b.centerY(), f1, Path.Direction.CW);
      this.b.inset(-this.o / 2.0F, -this.o / 2.0F);
      this.r.reset();
      this.b.inset(this.q, this.q);
      if (!this.l) {
        break label274;
      }
      this.r.addCircle(this.b.centerX(), this.b.centerY(), Math.min(this.b.width(), this.b.height()) / 2.0F, Path.Direction.CW);
    }
    for (;;)
    {
      this.b.inset(-this.q, -this.q);
      this.r.setFillType(Path.FillType.WINDING);
      this.t = false;
      return;
      label211:
      int i1 = 0;
      while (i1 < this.a.length)
      {
        this.a[i1] = (this.n[i1] + this.q - this.o / 2.0F);
        i1 += 1;
      }
      this.s.addRoundRect(this.b, this.a, Path.Direction.CW);
      break;
      label274:
      this.r.addRoundRect(this.b, this.n, Path.Direction.CW);
    }
  }
  
  private void i()
  {
    Bitmap localBitmap = getBitmap();
    if ((this.x == null) || (this.x.get() != localBitmap))
    {
      this.x = new WeakReference(localBitmap);
      this.u.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.w = true;
    }
    if (this.w)
    {
      this.u.getShader().setLocalMatrix(this.k);
      this.w = false;
    }
  }
  
  public void a(float paramFloat)
  {
    boolean bool2 = false;
    if (paramFloat >= 0.0F) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      k.b(bool1);
      Arrays.fill(this.n, paramFloat);
      bool1 = bool2;
      if (paramFloat != 0.0F) {
        bool1 = true;
      }
      this.m = bool1;
      this.t = true;
      invalidateSelf();
      return;
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((this.p != paramInt) || (this.o != paramFloat))
    {
      this.p = paramInt;
      this.o = paramFloat;
      this.t = true;
      invalidateSelf();
    }
  }
  
  public void a(@Nullable s params)
  {
    this.y = params;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    this.t = true;
    invalidateSelf();
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.n, 0.0F);
      this.m = false;
      this.t = true;
      invalidateSelf();
      return;
    }
    boolean bool2;
    label37:
    int i1;
    if (paramArrayOfFloat.length == 8)
    {
      bool2 = true;
      k.a(bool2, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.n, 0, 8);
      this.m = false;
      i1 = 0;
      label64:
      if (i1 < 8)
      {
        bool2 = this.m;
        if (paramArrayOfFloat[i1] <= 0.0F) {
          break label107;
        }
      }
    }
    label107:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.m = (bool1 | bool2);
      i1 += 1;
      break label64;
      break;
      bool2 = false;
      break label37;
    }
  }
  
  public void b(float paramFloat)
  {
    if (this.q != paramFloat)
    {
      this.q = paramFloat;
      this.t = true;
      invalidateSelf();
    }
  }
  
  public float[] b()
  {
    return this.n;
  }
  
  public int c()
  {
    return this.p;
  }
  
  public float d()
  {
    return this.o;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!f())
    {
      super.draw(paramCanvas);
      return;
    }
    g();
    h();
    i();
    int i1 = paramCanvas.save();
    paramCanvas.concat(this.j);
    paramCanvas.drawPath(this.r, this.u);
    if (this.o > 0.0F)
    {
      this.v.setStrokeWidth(this.o);
      this.v.setColor(f.a(this.p, this.u.getAlpha()));
      paramCanvas.drawPath(this.s, this.v);
    }
    paramCanvas.restoreToCount(i1);
  }
  
  public float e()
  {
    return this.q;
  }
  
  @VisibleForTesting
  boolean f()
  {
    return (this.l) || (this.m) || (this.o > 0.0F);
  }
  
  public boolean g_()
  {
    return this.l;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.u.getAlpha())
    {
      this.u.setAlpha(paramInt);
      super.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.u.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */