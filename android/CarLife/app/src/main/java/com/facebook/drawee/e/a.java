package com.facebook.drawee.e;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.k;
import com.facebook.drawee.d.g;
import com.facebook.drawee.d.h;
import com.facebook.drawee.d.i;
import com.facebook.drawee.d.p;
import com.facebook.drawee.d.q.c;
import com.facebook.drawee.g.c;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class a
  implements c
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private final Drawable h = new ColorDrawable(0);
  private final Resources i;
  @Nullable
  private e j;
  private final d k;
  private final g l;
  private final h m;
  
  a(b paramb)
  {
    this.i = paramb.b();
    this.j = paramb.t();
    this.m = new h(this.h);
    int n;
    if (paramb.r() != null)
    {
      n = paramb.r().size();
      if (paramb.s() == null) {
        break label261;
      }
    }
    Drawable[] arrayOfDrawable;
    label261:
    for (int i1 = 1;; i1 = 0)
    {
      n += i1;
      arrayOfDrawable = new Drawable[n + 6];
      arrayOfDrawable[0] = e(paramb.q(), null);
      arrayOfDrawable[1] = e(paramb.e(), paramb.f());
      arrayOfDrawable[2] = a(this.m, paramb.m(), paramb.o(), paramb.n(), paramb.p());
      arrayOfDrawable[3] = e(paramb.k(), paramb.l());
      arrayOfDrawable[4] = e(paramb.g(), paramb.h());
      arrayOfDrawable[5] = e(paramb.i(), paramb.j());
      if (n <= 0) {
        break label291;
      }
      n = 0;
      if (paramb.r() == null) {
        break label266;
      }
      Iterator localIterator = paramb.r().iterator();
      for (;;)
      {
        i1 = n;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfDrawable[(n + 6)] = e((Drawable)localIterator.next(), null);
        n += 1;
      }
      n = 1;
      break;
    }
    label266:
    i1 = 1;
    if (paramb.s() != null) {
      arrayOfDrawable[(i1 + 6)] = e(paramb.s(), null);
    }
    label291:
    this.l = new g(arrayOfDrawable);
    this.l.c(paramb.c());
    this.k = new d(f.a(this.l, this.j));
    this.k.mutate();
    h();
  }
  
  @Nullable
  private Drawable a(Drawable paramDrawable, @Nullable q.c paramc, @Nullable PointF paramPointF, @Nullable Matrix paramMatrix, @Nullable ColorFilter paramColorFilter)
  {
    paramDrawable.setColorFilter(paramColorFilter);
    return f.a(f.a(paramDrawable, paramc, paramPointF), paramMatrix);
  }
  
  private void a(float paramFloat)
  {
    Drawable localDrawable = h(3).a();
    if (localDrawable == null) {
      return;
    }
    if (paramFloat >= 0.999F)
    {
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      g(3);
    }
    for (;;)
    {
      localDrawable.setLevel(Math.round(10000.0F * paramFloat));
      return;
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).start();
      }
      f(3);
    }
  }
  
  private void b(int paramInt, @Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.l.a(paramInt, null);
      return;
    }
    paramDrawable = f.a(paramDrawable, this.j, this.i);
    h(paramInt).a(paramDrawable);
  }
  
  @Nullable
  private Drawable e(@Nullable Drawable paramDrawable, @Nullable q.c paramc)
  {
    return f.a(f.a(paramDrawable, this.j, this.i), paramc);
  }
  
  private void f(int paramInt)
  {
    if (paramInt >= 0) {
      this.l.d(paramInt);
    }
  }
  
  private void g()
  {
    this.m.a(this.h);
  }
  
  private void g(int paramInt)
  {
    if (paramInt >= 0) {
      this.l.e(paramInt);
    }
  }
  
  private com.facebook.drawee.d.d h(int paramInt)
  {
    Object localObject2 = this.l.b(paramInt);
    Object localObject1 = localObject2;
    if ((((com.facebook.drawee.d.d)localObject2).a() instanceof i)) {
      localObject1 = (i)((com.facebook.drawee.d.d)localObject2).a();
    }
    localObject2 = localObject1;
    if ((((com.facebook.drawee.d.d)localObject1).a() instanceof p)) {
      localObject2 = (p)((com.facebook.drawee.d.d)localObject1).a();
    }
    return (com.facebook.drawee.d.d)localObject2;
  }
  
  private void h()
  {
    if (this.l != null)
    {
      this.l.b();
      this.l.f();
      i();
      f(1);
      this.l.h();
      this.l.c();
    }
  }
  
  private p i(int paramInt)
  {
    com.facebook.drawee.d.d locald = h(paramInt);
    if ((locald instanceof p)) {
      return (p)locald;
    }
    return f.a(locald, q.c.a);
  }
  
  private void i()
  {
    g(1);
    g(2);
    g(3);
    g(4);
    g(5);
  }
  
  private boolean j(int paramInt)
  {
    return h(paramInt) instanceof p;
  }
  
  public Drawable a()
  {
    return this.k;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.l.b();
    a(paramFloat);
    if (paramBoolean) {
      this.l.h();
    }
    this.l.c();
  }
  
  public void a(int paramInt)
  {
    this.l.c(paramInt);
  }
  
  public void a(int paramInt, @Nullable Drawable paramDrawable)
  {
    if ((paramInt >= 0) && (paramInt + 6 < this.l.a())) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool, "The given index does not correspond to an overlay image.");
      b(paramInt + 6, paramDrawable);
      return;
    }
  }
  
  public void a(int paramInt, q.c paramc)
  {
    a(this.i.getDrawable(paramInt), paramc);
  }
  
  public void a(ColorFilter paramColorFilter)
  {
    this.m.setColorFilter(paramColorFilter);
  }
  
  public void a(PointF paramPointF)
  {
    k.a(paramPointF);
    i(2).a(paramPointF);
  }
  
  public void a(RectF paramRectF)
  {
    this.m.b(paramRectF);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.k.d(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, float paramFloat, boolean paramBoolean)
  {
    paramDrawable = f.a(paramDrawable, this.j, this.i);
    paramDrawable.mutate();
    this.m.a(paramDrawable);
    this.l.b();
    i();
    f(2);
    a(paramFloat);
    if (paramBoolean) {
      this.l.h();
    }
    this.l.c();
  }
  
  public void a(Drawable paramDrawable, q.c paramc)
  {
    b(1, paramDrawable);
    i(1).a(paramc);
  }
  
  public void a(q.c paramc)
  {
    k.a(paramc);
    i(2).a(paramc);
  }
  
  public void a(@Nullable e parame)
  {
    this.j = parame;
    f.a(this.k, this.j);
    int n = 0;
    while (n < this.l.a())
    {
      f.a(h(n), this.j, this.i);
      n += 1;
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    this.l.b();
    i();
    if (this.l.a(5) != null) {
      f(5);
    }
    for (;;)
    {
      this.l.c();
      return;
      f(1);
    }
  }
  
  public void b()
  {
    g();
    h();
  }
  
  public void b(int paramInt)
  {
    b(this.i.getDrawable(paramInt));
  }
  
  public void b(int paramInt, q.c paramc)
  {
    b(this.i.getDrawable(paramInt), paramc);
  }
  
  public void b(PointF paramPointF)
  {
    k.a(paramPointF);
    i(1).a(paramPointF);
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    b(1, paramDrawable);
  }
  
  public void b(Drawable paramDrawable, q.c paramc)
  {
    b(5, paramDrawable);
    i(5).a(paramc);
  }
  
  public void b(Throwable paramThrowable)
  {
    this.l.b();
    i();
    if (this.l.a(4) != null) {
      f(4);
    }
    for (;;)
    {
      this.l.c();
      return;
      f(1);
    }
  }
  
  public int c()
  {
    return this.l.d();
  }
  
  public void c(int paramInt)
  {
    c(this.i.getDrawable(paramInt));
  }
  
  public void c(int paramInt, q.c paramc)
  {
    c(this.i.getDrawable(paramInt), paramc);
  }
  
  public void c(@Nullable Drawable paramDrawable)
  {
    b(5, paramDrawable);
  }
  
  public void c(Drawable paramDrawable, q.c paramc)
  {
    b(4, paramDrawable);
    i(4).a(paramc);
  }
  
  @Nullable
  public q.c d()
  {
    if (!j(2)) {
      return null;
    }
    return i(2).b();
  }
  
  public void d(int paramInt)
  {
    d(this.i.getDrawable(paramInt));
  }
  
  public void d(int paramInt, q.c paramc)
  {
    d(this.i.getDrawable(paramInt), paramc);
  }
  
  public void d(@Nullable Drawable paramDrawable)
  {
    b(4, paramDrawable);
  }
  
  public void d(Drawable paramDrawable, q.c paramc)
  {
    b(3, paramDrawable);
    i(3).a(paramc);
  }
  
  public void e(int paramInt)
  {
    e(this.i.getDrawable(paramInt));
  }
  
  public void e(@Nullable Drawable paramDrawable)
  {
    b(3, paramDrawable);
  }
  
  public boolean e()
  {
    return h(1) != null;
  }
  
  @Nullable
  public e f()
  {
    return this.j;
  }
  
  public void f(@Nullable Drawable paramDrawable)
  {
    b(0, paramDrawable);
  }
  
  public void g(@Nullable Drawable paramDrawable)
  {
    a(0, paramDrawable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */