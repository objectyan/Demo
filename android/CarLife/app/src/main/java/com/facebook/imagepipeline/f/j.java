package com.facebook.imagepipeline.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.k;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.l.as;
import com.facebook.imagepipeline.memory.u;
import com.facebook.imagepipeline.memory.y;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class j
{
  private static j a = null;
  private final as b;
  private final h c;
  private com.facebook.imagepipeline.d.h<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> d;
  private p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> e;
  private com.facebook.imagepipeline.d.h<com.facebook.b.a.d, y> f;
  private p<com.facebook.b.a.d, y> g;
  private com.facebook.imagepipeline.d.e h;
  private com.facebook.b.b.j i;
  private com.facebook.imagepipeline.h.b j;
  private g k;
  private l l;
  private m m;
  private com.facebook.imagepipeline.d.e n;
  private com.facebook.b.b.j o;
  private com.facebook.imagepipeline.c.e p;
  private com.facebook.imagepipeline.k.e q;
  private com.facebook.imagepipeline.a.a.b r;
  
  public j(h paramh)
  {
    this.c = ((h)k.a(paramh));
    this.b = new as(paramh.l().e());
  }
  
  @Deprecated
  public static com.facebook.b.b.e a(com.facebook.b.b.c paramc, com.facebook.b.b.d paramd)
  {
    return b.a(paramc, paramd);
  }
  
  public static com.facebook.imagepipeline.c.e a(u paramu, com.facebook.imagepipeline.k.e parame)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new com.facebook.imagepipeline.c.a(paramu.a());
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new com.facebook.imagepipeline.c.d(new com.facebook.imagepipeline.c.b(paramu.e()), parame);
    }
    return new com.facebook.imagepipeline.c.c();
  }
  
  public static j a()
  {
    return (j)k.a(a, "ImagePipelineFactory was not initialized!");
  }
  
  public static com.facebook.imagepipeline.k.e a(u paramu, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i1 = paramu.c();
      return new com.facebook.imagepipeline.k.a(paramu.a(), i1, new Pools.SynchronizedPool(i1));
    }
    if ((paramBoolean1) && (Build.VERSION.SDK_INT < 19)) {
      return new com.facebook.imagepipeline.k.c(paramBoolean2);
    }
    return new com.facebook.imagepipeline.k.d(paramu.b());
  }
  
  public static void a(Context paramContext)
  {
    a(h.a(paramContext).c());
  }
  
  public static void a(h paramh)
  {
    a = new j(paramh);
  }
  
  public static void b()
  {
    if (a != null)
    {
      a.e().a(com.facebook.common.internal.a.a());
      a.g().a(com.facebook.common.internal.a.a());
      a = null;
    }
  }
  
  private com.facebook.imagepipeline.h.b o()
  {
    if (this.j == null)
    {
      if (this.c.o() != null) {
        this.j = this.c.o();
      }
    }
    else {
      return this.j;
    }
    if (c() != null) {}
    for (com.facebook.imagepipeline.a.a.d locald = c().a();; locald = null)
    {
      this.j = new com.facebook.imagepipeline.h.b(locald, l(), this.c.b());
      break;
    }
  }
  
  private com.facebook.imagepipeline.d.e p()
  {
    if (this.h == null) {
      this.h = new com.facebook.imagepipeline.d.e(i(), this.c.u().e(), this.c.u().f(), this.c.l().a(), this.c.l().b(), this.c.n());
    }
    return this.h;
  }
  
  private l q()
  {
    if (this.l == null) {
      this.l = new l(this.c.e(), this.c.u().h(), o(), this.c.v(), this.c.i(), this.c.x(), this.c.l(), this.c.u().e(), e(), g(), p(), s(), this.c.d(), k(), this.c.z().a(), this.c.z().b());
    }
    return this.l;
  }
  
  private m r()
  {
    if (this.m == null) {
      this.m = new m(q(), this.c.s(), this.c.x(), this.c.i(), this.c.z().c(), this.b, this.c.z().d());
    }
    return this.m;
  }
  
  private com.facebook.imagepipeline.d.e s()
  {
    if (this.n == null) {
      this.n = new com.facebook.imagepipeline.d.e(n(), this.c.u().e(), this.c.u().f(), this.c.l().a(), this.c.l().b(), this.c.n());
    }
    return this.n;
  }
  
  public com.facebook.imagepipeline.a.a.b c()
  {
    if (this.r == null) {
      this.r = com.facebook.imagepipeline.a.a.c.a(k(), this.c.l());
    }
    return this.r;
  }
  
  public com.facebook.imagepipeline.d.h<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> d()
  {
    if (this.d == null) {
      this.d = com.facebook.imagepipeline.d.a.a(this.c.c(), this.c.r());
    }
    return this.d;
  }
  
  public p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> e()
  {
    if (this.e == null) {
      this.e = com.facebook.imagepipeline.d.b.a(d(), this.c.n());
    }
    return this.e;
  }
  
  public com.facebook.imagepipeline.d.h<com.facebook.b.a.d, y> f()
  {
    if (this.f == null) {
      this.f = com.facebook.imagepipeline.d.l.a(this.c.k(), this.c.r());
    }
    return this.f;
  }
  
  public p<com.facebook.b.a.d, y> g()
  {
    if (this.g == null) {
      this.g = com.facebook.imagepipeline.d.m.a(f(), this.c.n());
    }
    return this.g;
  }
  
  @Deprecated
  public com.facebook.b.b.j h()
  {
    return i();
  }
  
  public com.facebook.b.b.j i()
  {
    if (this.i == null)
    {
      com.facebook.b.b.c localc = this.c.q();
      this.i = this.c.h().a(localc);
    }
    return this.i;
  }
  
  public g j()
  {
    if (this.k == null) {
      this.k = new g(r(), this.c.w(), this.c.p(), e(), g(), p(), s(), this.c.d(), this.b);
    }
    return this.k;
  }
  
  public com.facebook.imagepipeline.c.e k()
  {
    if (this.p == null) {
      this.p = a(this.c.u(), l());
    }
    return this.p;
  }
  
  public com.facebook.imagepipeline.k.e l()
  {
    if (this.q == null) {
      this.q = a(this.c.u(), this.c.g(), this.c.z().c());
    }
    return this.q;
  }
  
  @Deprecated
  public com.facebook.b.b.j m()
  {
    return n();
  }
  
  public com.facebook.b.b.j n()
  {
    if (this.o == null)
    {
      com.facebook.b.b.c localc = this.c.y();
      this.o = this.c.h().a(localc);
    }
    return this.o;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */