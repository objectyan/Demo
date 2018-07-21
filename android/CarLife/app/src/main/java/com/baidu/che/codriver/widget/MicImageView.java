package com.baidu.che.codriver.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class MicImageView
  extends ImageView
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final int e = 144;
  private LayerDrawable f;
  private ClipDrawable g;
  private ObjectAnimator h;
  private ValueAnimator i;
  private ValueAnimator j;
  private Paint k;
  private float l;
  private float m;
  private RectF n;
  private RectF o;
  private float p;
  private float q;
  private int r;
  private int s;
  private float t;
  private int u = 0;
  
  public MicImageView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public MicImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private float a(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = getWidth() / 2;
    float f2 = getHeight() / 2;
    float f3 = this.l + this.t * (this.m - this.l);
    float f4 = 20.0F + this.t * 10.0F;
    int i1 = (int)((1.0D - 0.8D * this.t) * 255.0D);
    this.k.setAlpha(i1);
    RectF localRectF = new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    paramCanvas.drawArc(localRectF, 360.0F - f4 / 2.0F, f4, false, this.k);
    paramCanvas.drawArc(localRectF, 180.0F - f4 / 2.0F, f4, false, this.k);
    this.k.setAlpha((int)((0.2D + 0.8D * this.t) * 255.0D));
    paramCanvas.drawArc(this.n, 350.0F, 20.0F, false, this.k);
    paramCanvas.drawArc(this.n, 170.0F, 20.0F, false, this.k);
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.n, this.r + 0, 60.0F, false, this.k);
    paramCanvas.drawArc(this.n, this.r + 180, 60.0F, false, this.k);
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawArc(this.n, 270.0F, this.s * 360 / 100, false, this.k);
  }
  
  private void d()
  {
    this.f = ((LayerDrawable)getDrawable());
    this.g = ((ClipDrawable)this.f.getDrawable(1));
    this.g.setLevel(10000);
    this.k = new Paint(1);
    this.k.setColor(-16741121);
    this.k.setStyle(Paint.Style.STROKE);
    this.k.setStrokeWidth(a(3.0F));
    this.l = a(55.0F);
    this.m = a(69.0F);
    this.h = ObjectAnimator.ofInt(this.g, "level", new int[] { 3000, 7000, 4000, 9000, 3000 });
    this.h.setDuration(1000L);
    this.h.setRepeatCount(-1);
    this.h.setRepeatMode(1);
    this.h.setInterpolator(new AccelerateDecelerateInterpolator());
    this.i = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        MicImageView.a(MicImageView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    this.i.setDuration(1000L);
    this.i.setRepeatCount(-1);
    this.i.setRepeatMode(1);
    this.i.setInterpolator(new DecelerateInterpolator());
    this.j = ValueAnimator.ofInt(new int[] { 0, 360 });
    this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        MicImageView.a(MicImageView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        MicImageView.this.invalidate();
      }
    });
    this.j.setDuration(1000L);
    this.j.setRepeatCount(-1);
    this.j.setRepeatMode(-1);
    this.j.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  private void e()
  {
    this.h.start();
    this.i.start();
  }
  
  private void f()
  {
    this.h.cancel();
    this.i.cancel();
    this.g.setLevel(10000);
    this.k.setAlpha(255);
    this.s = 0;
    this.t = 0.0F;
  }
  
  private void g()
  {
    this.j.start();
  }
  
  private void h()
  {
    this.j.cancel();
    this.r = 0;
    invalidate();
  }
  
  private void setState(int paramInt)
  {
    if (this.u == paramInt) {
      return;
    }
    this.u = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      f();
      h();
      return;
    case 1: 
    case 3: 
      e();
      h();
      return;
    }
    g();
    f();
  }
  
  public void a()
  {
    setState(0);
  }
  
  public void a(int paramInt)
  {
    int i1;
    if (paramInt >= 0)
    {
      i1 = paramInt;
      if (paramInt <= 100) {}
    }
    else
    {
      i1 = 0;
    }
    this.s = i1;
    setState(3);
  }
  
  public void b()
  {
    setState(1);
  }
  
  public void c()
  {
    setState(2);
  }
  
  public int getCurrentState()
  {
    return this.u;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.u)
    {
    case 0: 
    default: 
      return;
    case 1: 
      a(paramCanvas);
      return;
    case 2: 
      b(paramCanvas);
      return;
    }
    c(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)a(144.0F);
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = (paramInt1 / 2);
    this.q = (paramInt2 / 2);
    this.n = new RectF(this.p - this.l, this.q - this.l, this.p + this.l, this.q + this.l);
    this.o = new RectF(this.p - this.m, this.q - this.m, this.p + this.m, this.q + this.m);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/MicImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */