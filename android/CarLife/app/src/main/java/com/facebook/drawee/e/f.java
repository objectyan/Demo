package com.facebook.drawee.e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.k;
import com.facebook.drawee.d.d;
import com.facebook.drawee.d.h;
import com.facebook.drawee.d.i;
import com.facebook.drawee.d.l;
import com.facebook.drawee.d.m;
import com.facebook.drawee.d.n;
import com.facebook.drawee.d.o;
import com.facebook.drawee.d.p;
import com.facebook.drawee.d.q.c;
import javax.annotation.Nullable;

public class f
{
  private static final Drawable a = new ColorDrawable(0);
  
  @Nullable
  static Drawable a(@Nullable Drawable paramDrawable, @Nullable Matrix paramMatrix)
  {
    if ((paramDrawable == null) || (paramMatrix == null)) {
      return paramDrawable;
    }
    return new i(paramDrawable, paramMatrix);
  }
  
  @Nullable
  static Drawable a(@Nullable Drawable paramDrawable, @Nullable q.c paramc)
  {
    return a(paramDrawable, paramc, null);
  }
  
  @Nullable
  static Drawable a(@Nullable Drawable paramDrawable, @Nullable q.c paramc, @Nullable PointF paramPointF)
  {
    if ((paramDrawable == null) || (paramc == null)) {}
    do
    {
      return paramDrawable;
      paramc = new p(paramDrawable, paramc);
      paramDrawable = paramc;
    } while (paramPointF == null);
    paramc.a(paramPointF);
    return paramc;
  }
  
  static Drawable a(@Nullable Drawable paramDrawable, @Nullable e parame)
  {
    if ((paramDrawable == null) || (parame == null) || (parame.c() != e.a.a)) {
      return paramDrawable;
    }
    paramDrawable = new o(paramDrawable);
    a(paramDrawable, parame);
    paramDrawable.a(parame.d());
    return paramDrawable;
  }
  
  static Drawable a(@Nullable Drawable paramDrawable, @Nullable e parame, Resources paramResources)
  {
    if ((paramDrawable == null) || (parame == null) || (parame.c() != e.a.b)) {
      return paramDrawable;
    }
    if ((paramDrawable instanceof h))
    {
      d locald = a((h)paramDrawable);
      locald.a(b(locald.a(a), parame, paramResources));
      return paramDrawable;
    }
    return b(paramDrawable, parame, paramResources);
  }
  
  static d a(d paramd)
  {
    for (;;)
    {
      Drawable localDrawable = paramd.a();
      if ((localDrawable == paramd) || (!(localDrawable instanceof d))) {
        return paramd;
      }
      paramd = (d)localDrawable;
    }
  }
  
  static p a(d paramd, q.c paramc)
  {
    paramc = a(paramd.a(a), paramc);
    paramd.a(paramc);
    k.a(paramc, "Parent has no child drawable!");
    return (p)paramc;
  }
  
  static void a(d paramd, @Nullable e parame)
  {
    Drawable localDrawable = paramd.a();
    if ((parame != null) && (parame.c() == e.a.a)) {
      if ((localDrawable instanceof o))
      {
        paramd = (o)localDrawable;
        a(paramd, parame);
        paramd.a(parame.d());
      }
    }
    while (!(localDrawable instanceof o))
    {
      return;
      paramd.a(a(paramd.a(a), parame));
      return;
    }
    paramd.a(((o)localDrawable).b(a));
    a.setCallback(null);
  }
  
  static void a(d paramd, @Nullable e parame, Resources paramResources)
  {
    paramd = a(paramd);
    Drawable localDrawable = paramd.a();
    if ((parame != null) && (parame.c() == e.a.b)) {
      if ((localDrawable instanceof l)) {
        a((l)localDrawable, parame);
      }
    }
    while (!(localDrawable instanceof l))
    {
      do
      {
        return;
      } while (localDrawable == null);
      paramd.a(a);
      paramd.a(b(localDrawable, parame, paramResources));
      return;
    }
    a((l)localDrawable);
  }
  
  static void a(l paraml)
  {
    paraml.a(false);
    paraml.a(0.0F);
    paraml.a(0, 0.0F);
    paraml.b(0.0F);
  }
  
  static void a(l paraml, e parame)
  {
    paraml.a(parame.a());
    paraml.a(parame.b());
    paraml.a(parame.g(), parame.f());
    paraml.b(parame.h());
  }
  
  private static Drawable b(Drawable paramDrawable, e parame, Resources paramResources)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = (BitmapDrawable)paramDrawable;
      paramDrawable = new m(paramResources, paramDrawable.getBitmap(), paramDrawable.getPaint());
      a(paramDrawable, parame);
      return paramDrawable;
    }
    if (((paramDrawable instanceof ColorDrawable)) && (Build.VERSION.SDK_INT >= 11))
    {
      paramDrawable = n.a((ColorDrawable)paramDrawable);
      a(paramDrawable, parame);
      return paramDrawable;
    }
    return paramDrawable;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */