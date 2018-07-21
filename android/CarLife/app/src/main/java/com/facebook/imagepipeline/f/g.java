package com.facebook.imagepipeline.f;

import a.h;
import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.c.i;
import com.facebook.common.h.a;
import com.facebook.common.internal.j.a;
import com.facebook.common.internal.k;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.ao;
import com.facebook.imagepipeline.l.as;
import com.facebook.imagepipeline.m.c.b;
import com.facebook.imagepipeline.memory.y;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class g
{
  private static final CancellationException a = new CancellationException("Prefetching is not enabled");
  private final m b;
  private final com.facebook.imagepipeline.j.c c;
  private final com.facebook.common.internal.m<Boolean> d;
  private final p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> e;
  private final p<com.facebook.b.a.d, y> f;
  private final com.facebook.imagepipeline.d.e g;
  private final com.facebook.imagepipeline.d.e h;
  private final com.facebook.imagepipeline.d.f i;
  private final as j;
  private AtomicLong k = new AtomicLong();
  
  public g(m paramm, Set<com.facebook.imagepipeline.j.c> paramSet, com.facebook.common.internal.m<Boolean> paramm1, p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> paramp, p<com.facebook.b.a.d, y> paramp1, com.facebook.imagepipeline.d.e parame1, com.facebook.imagepipeline.d.e parame2, com.facebook.imagepipeline.d.f paramf, as paramas)
  {
    this.b = paramm;
    this.c = new com.facebook.imagepipeline.j.b(paramSet);
    this.d = paramm1;
    this.e = paramp;
    this.f = paramp1;
    this.g = parame1;
    this.h = parame2;
    this.i = paramf;
    this.j = paramas;
  }
  
  private <T> com.facebook.c.d<a<T>> a(ai<a<T>> paramai, com.facebook.imagepipeline.m.c paramc, c.b paramb, Object paramObject)
  {
    for (boolean bool = false;; bool = true) {
      try
      {
        paramb = c.b.a(paramc.k(), paramb);
        String str = i();
        com.facebook.imagepipeline.j.c localc = this.c;
        if ((!paramc.h()) && (com.facebook.common.m.g.a(paramc.b())))
        {
          paramai = com.facebook.imagepipeline.g.d.a(paramai, new ao(paramc, str, localc, paramObject, paramb, false, bool, paramc.j()), this.c);
          return paramai;
        }
      }
      catch (Exception paramai)
      {
        return com.facebook.c.e.a(paramai);
      }
    }
  }
  
  private com.facebook.c.d<Void> a(ai<Void> paramai, com.facebook.imagepipeline.m.c paramc, c.b paramb, Object paramObject, com.facebook.imagepipeline.e.c paramc1)
  {
    try
    {
      paramb = c.b.a(paramc.k(), paramb);
      paramai = com.facebook.imagepipeline.g.f.a(paramai, new ao(paramc, i(), this.c, paramObject, paramb, true, false, paramc1), this.c);
      return paramai;
    }
    catch (Exception paramai) {}
    return com.facebook.c.e.a(paramai);
  }
  
  private Predicate<com.facebook.b.a.d> g(final Uri paramUri)
  {
    new Predicate()
    {
      public boolean a(com.facebook.b.a.d paramAnonymousd)
      {
        return paramAnonymousd.a(paramUri);
      }
    };
  }
  
  private String i()
  {
    return String.valueOf(this.k.getAndIncrement());
  }
  
  public com.facebook.c.d<Void> a(com.facebook.imagepipeline.m.c paramc, Object paramObject, com.facebook.imagepipeline.e.c paramc1)
  {
    if (!((Boolean)this.d.b()).booleanValue()) {
      return com.facebook.c.e.a(a);
    }
    try
    {
      paramc = a(this.b.b(paramc), paramc, c.b.a, paramObject, paramc1);
      return paramc;
    }
    catch (Exception paramc) {}
    return com.facebook.c.e.a(paramc);
  }
  
  public com.facebook.common.internal.m<com.facebook.c.d<a<y>>> a(final com.facebook.imagepipeline.m.c paramc, final Object paramObject)
  {
    new com.facebook.common.internal.m()
    {
      public com.facebook.c.d<a<y>> a()
      {
        return g.this.d(paramc, paramObject);
      }
      
      public String toString()
      {
        return com.facebook.common.internal.j.a(this).a("uri", paramc.b()).toString();
      }
    };
  }
  
  public com.facebook.common.internal.m<com.facebook.c.d<a<com.facebook.imagepipeline.i.b>>> a(final com.facebook.imagepipeline.m.c paramc, final Object paramObject, final boolean paramBoolean)
  {
    new com.facebook.common.internal.m()
    {
      public com.facebook.c.d<a<com.facebook.imagepipeline.i.b>> a()
      {
        if (paramBoolean) {
          return g.this.b(paramc, paramObject);
        }
        return g.this.c(paramc, paramObject);
      }
      
      public String toString()
      {
        return com.facebook.common.internal.j.a(this).a("uri", paramc.b()).toString();
      }
    };
  }
  
  public void a()
  {
    Predicate local3 = new Predicate()
    {
      public boolean a(com.facebook.b.a.d paramAnonymousd)
      {
        return true;
      }
    };
    this.e.a(local3);
    this.f.a(local3);
  }
  
  public void a(Uri paramUri)
  {
    paramUri = g(paramUri);
    this.e.a(paramUri);
    this.f.a(paramUri);
  }
  
  public void a(com.facebook.imagepipeline.m.c paramc)
  {
    paramc = this.i.c(paramc, null);
    this.g.d(paramc);
    this.h.d(paramc);
  }
  
  public com.facebook.c.d<a<com.facebook.imagepipeline.i.b>> b(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    try
    {
      paramc = a(this.b.c(paramc), paramc, c.b.d, paramObject);
      return paramc;
    }
    catch (Exception paramc) {}
    return com.facebook.c.e.a(paramc);
  }
  
  public void b()
  {
    this.g.a();
    this.h.a();
  }
  
  public void b(Uri paramUri)
  {
    a(com.facebook.imagepipeline.m.c.a(paramUri));
  }
  
  public boolean b(com.facebook.imagepipeline.m.c paramc)
  {
    if (paramc == null) {
      return false;
    }
    paramc = this.i.a(paramc, null);
    paramc = this.e.a(paramc);
    try
    {
      boolean bool = a.a(paramc);
      return bool;
    }
    finally
    {
      a.c(paramc);
    }
  }
  
  public com.facebook.c.d<a<com.facebook.imagepipeline.i.b>> c(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    try
    {
      paramc = a(this.b.c(paramc), paramc, c.b.a, paramObject);
      return paramc;
    }
    catch (Exception paramc) {}
    return com.facebook.c.e.a(paramc);
  }
  
  public void c()
  {
    a();
    b();
  }
  
  public void c(Uri paramUri)
  {
    a(paramUri);
    b(paramUri);
  }
  
  public boolean c(com.facebook.imagepipeline.m.c paramc)
  {
    paramc = this.i.c(paramc, null);
    return this.g.c(paramc);
  }
  
  public com.facebook.c.d<Boolean> d(final com.facebook.imagepipeline.m.c paramc)
  {
    paramc = this.i.c(paramc, null);
    final i locali = i.j();
    this.g.b(paramc).b(new h()
    {
      public a.j<Boolean> b(a.j<Boolean> paramAnonymousj)
        throws Exception
      {
        if ((!paramAnonymousj.d()) && (!paramAnonymousj.e()) && (((Boolean)paramAnonymousj.f()).booleanValue())) {
          return a.j.a(Boolean.valueOf(true));
        }
        return g.a(g.this).b(paramc);
      }
    }).a(new h()
    {
      public Void b(a.j<Boolean> paramAnonymousj)
        throws Exception
      {
        i locali = locali;
        if ((!paramAnonymousj.d()) && (!paramAnonymousj.e()) && (((Boolean)paramAnonymousj.f()).booleanValue())) {}
        for (boolean bool = true;; bool = false)
        {
          locali.b(Boolean.valueOf(bool));
          return null;
        }
      }
    });
    return locali;
  }
  
  public com.facebook.c.d<a<y>> d(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    k.a(paramc.b());
    try
    {
      ai localai = this.b.a(paramc);
      com.facebook.imagepipeline.m.c localc = paramc;
      if (paramc.e() != null) {
        localc = com.facebook.imagepipeline.m.d.a(paramc).a(null).m();
      }
      paramc = a(localai, localc, c.b.a, paramObject);
      return paramc;
    }
    catch (Exception paramc) {}
    return com.facebook.c.e.a(paramc);
  }
  
  public p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> d()
  {
    return this.e;
  }
  
  public boolean d(Uri paramUri)
  {
    if (paramUri == null) {
      return false;
    }
    paramUri = g(paramUri);
    return this.e.b(paramUri);
  }
  
  public com.facebook.c.d<Void> e(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    if (!((Boolean)this.d.b()).booleanValue()) {
      return com.facebook.c.e.a(a);
    }
    try
    {
      paramc = a(this.b.d(paramc), paramc, c.b.a, paramObject, com.facebook.imagepipeline.e.c.b);
      return paramc;
    }
    catch (Exception paramc) {}
    return com.facebook.c.e.a(paramc);
  }
  
  public void e()
  {
    this.j.a();
  }
  
  public boolean e(Uri paramUri)
  {
    return c(com.facebook.imagepipeline.m.c.a(paramUri));
  }
  
  public com.facebook.c.d<Boolean> f(Uri paramUri)
  {
    return d(com.facebook.imagepipeline.m.c.a(paramUri));
  }
  
  public com.facebook.c.d<Void> f(com.facebook.imagepipeline.m.c paramc, Object paramObject)
  {
    return a(paramc, paramObject, com.facebook.imagepipeline.e.c.b);
  }
  
  public void f()
  {
    this.j.b();
  }
  
  public boolean g()
  {
    return this.j.c();
  }
  
  public com.facebook.imagepipeline.d.f h()
  {
    return this.i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */