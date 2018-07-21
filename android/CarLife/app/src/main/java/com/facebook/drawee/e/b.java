package com.facebook.drawee.e;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.k;
import com.facebook.drawee.d.q.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class b
{
  public static final int a = 300;
  public static final q.c b = q.c.f;
  public static final q.c c = q.c.g;
  private Resources d;
  private int e;
  private float f;
  private Drawable g;
  @Nullable
  private q.c h;
  private Drawable i;
  private q.c j;
  private Drawable k;
  private q.c l;
  private Drawable m;
  private q.c n;
  private q.c o;
  private Matrix p;
  private PointF q;
  private ColorFilter r;
  private Drawable s;
  private List<Drawable> t;
  private Drawable u;
  private e v;
  
  public b(Resources paramResources)
  {
    this.d = paramResources;
    v();
  }
  
  public static b a(Resources paramResources)
  {
    return new b(paramResources);
  }
  
  private void v()
  {
    this.e = 300;
    this.f = 0.0F;
    this.g = null;
    this.h = b;
    this.i = null;
    this.j = b;
    this.k = null;
    this.l = b;
    this.m = null;
    this.n = b;
    this.o = c;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = null;
    this.v = null;
  }
  
  private void w()
  {
    if (this.t != null)
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext()) {
        k.a((Drawable)localIterator.next());
      }
    }
  }
  
  public b a()
  {
    v();
    return this;
  }
  
  public b a(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }
  
  public b a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public b a(int paramInt, @Nullable q.c paramc)
  {
    this.g = this.d.getDrawable(paramInt);
    this.h = paramc;
    return this;
  }
  
  public b a(@Nullable ColorFilter paramColorFilter)
  {
    this.r = paramColorFilter;
    return this;
  }
  
  @Deprecated
  public b a(@Nullable Matrix paramMatrix)
  {
    this.p = paramMatrix;
    this.o = null;
    return this;
  }
  
  public b a(@Nullable PointF paramPointF)
  {
    this.q = paramPointF;
    return this;
  }
  
  public b a(@Nullable Drawable paramDrawable)
  {
    this.g = paramDrawable;
    return this;
  }
  
  public b a(Drawable paramDrawable, @Nullable q.c paramc)
  {
    this.g = paramDrawable;
    this.h = paramc;
    return this;
  }
  
  public b a(@Nullable q.c paramc)
  {
    this.h = paramc;
    return this;
  }
  
  public b a(@Nullable e parame)
  {
    this.v = parame;
    return this;
  }
  
  @Deprecated
  public b a(@Nullable List<Drawable> paramList)
  {
    if (paramList == null)
    {
      this.s = null;
      return this;
    }
    this.s = new com.facebook.drawee.d.a((Drawable[])paramList.toArray(new Drawable[paramList.size()]));
    return this;
  }
  
  public Resources b()
  {
    return this.d;
  }
  
  public b b(int paramInt)
  {
    this.g = this.d.getDrawable(paramInt);
    return this;
  }
  
  public b b(int paramInt, @Nullable q.c paramc)
  {
    this.i = this.d.getDrawable(paramInt);
    this.j = paramc;
    return this;
  }
  
  public b b(@Nullable Drawable paramDrawable)
  {
    this.i = paramDrawable;
    return this;
  }
  
  public b b(Drawable paramDrawable, @Nullable q.c paramc)
  {
    this.i = paramDrawable;
    this.j = paramc;
    return this;
  }
  
  public b b(@Nullable q.c paramc)
  {
    this.j = paramc;
    return this;
  }
  
  public b b(@Nullable List<Drawable> paramList)
  {
    this.t = paramList;
    return this;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public b c(int paramInt)
  {
    this.i = this.d.getDrawable(paramInt);
    return this;
  }
  
  public b c(int paramInt, @Nullable q.c paramc)
  {
    this.k = this.d.getDrawable(paramInt);
    this.l = paramc;
    return this;
  }
  
  public b c(@Nullable Drawable paramDrawable)
  {
    this.k = paramDrawable;
    return this;
  }
  
  public b c(Drawable paramDrawable, @Nullable q.c paramc)
  {
    this.k = paramDrawable;
    this.l = paramc;
    return this;
  }
  
  public b c(@Nullable q.c paramc)
  {
    this.l = paramc;
    return this;
  }
  
  public float d()
  {
    return this.f;
  }
  
  public b d(int paramInt)
  {
    this.k = this.d.getDrawable(paramInt);
    return this;
  }
  
  public b d(int paramInt, @Nullable q.c paramc)
  {
    this.m = this.d.getDrawable(paramInt);
    this.n = paramc;
    return this;
  }
  
  public b d(@Nullable Drawable paramDrawable)
  {
    this.m = paramDrawable;
    return this;
  }
  
  public b d(Drawable paramDrawable, @Nullable q.c paramc)
  {
    this.m = paramDrawable;
    this.n = paramc;
    return this;
  }
  
  public b d(@Nullable q.c paramc)
  {
    this.n = paramc;
    return this;
  }
  
  @Nullable
  public Drawable e()
  {
    return this.g;
  }
  
  public b e(int paramInt)
  {
    this.m = this.d.getDrawable(paramInt);
    return this;
  }
  
  public b e(@Nullable Drawable paramDrawable)
  {
    this.s = paramDrawable;
    return this;
  }
  
  public b e(@Nullable q.c paramc)
  {
    this.o = paramc;
    this.p = null;
    return this;
  }
  
  @Nullable
  public q.c f()
  {
    return this.h;
  }
  
  public b f(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.t = null;
      return this;
    }
    this.t = Arrays.asList(new Drawable[] { paramDrawable });
    return this;
  }
  
  @Nullable
  public Drawable g()
  {
    return this.i;
  }
  
  public b g(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.u = null;
      return this;
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable);
    this.u = localStateListDrawable;
    return this;
  }
  
  @Nullable
  public q.c h()
  {
    return this.j;
  }
  
  @Nullable
  public Drawable i()
  {
    return this.k;
  }
  
  @Nullable
  public q.c j()
  {
    return this.l;
  }
  
  @Nullable
  public Drawable k()
  {
    return this.m;
  }
  
  @Nullable
  public q.c l()
  {
    return this.n;
  }
  
  @Nullable
  public q.c m()
  {
    return this.o;
  }
  
  @Nullable
  public Matrix n()
  {
    return this.p;
  }
  
  @Nullable
  public PointF o()
  {
    return this.q;
  }
  
  @Nullable
  public ColorFilter p()
  {
    return this.r;
  }
  
  @Nullable
  public Drawable q()
  {
    return this.s;
  }
  
  @Nullable
  public List<Drawable> r()
  {
    return this.t;
  }
  
  @Nullable
  public Drawable s()
  {
    return this.u;
  }
  
  @Nullable
  public e t()
  {
    return this.v;
  }
  
  public a u()
  {
    w();
    return new a(this);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */