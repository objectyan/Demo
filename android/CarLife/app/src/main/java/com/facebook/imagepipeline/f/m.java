package com.facebook.imagepipeline.f;

import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.common.m.g;
import com.facebook.imagepipeline.i.b;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.l.ae;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.am;
import com.facebook.imagepipeline.l.as;
import com.facebook.imagepipeline.l.av;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.m.c.b;
import com.facebook.imagepipeline.memory.y;
import java.util.HashMap;
import java.util.Map;

public class m
{
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> a;
  @VisibleForTesting
  ai<d> b;
  @VisibleForTesting
  ai<com.facebook.common.h.a<y>> c;
  @VisibleForTesting
  ai<Void> d;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> e;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> f;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> g;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> h;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> i;
  @VisibleForTesting
  ai<com.facebook.common.h.a<b>> j;
  @VisibleForTesting
  Map<ai<com.facebook.common.h.a<b>>, ai<com.facebook.common.h.a<b>>> k;
  @VisibleForTesting
  Map<ai<com.facebook.common.h.a<b>>, ai<Void>> l;
  private final l m;
  private final ae n;
  private final boolean o;
  private final boolean p;
  private final boolean q;
  private final as r;
  private final int s;
  private ai<d> t;
  
  public m(l paraml, ae paramae, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, as paramas, int paramInt)
  {
    this.m = paraml;
    this.n = paramae;
    this.o = paramBoolean1;
    this.q = paramBoolean2;
    this.p = paramBoolean3;
    this.k = new HashMap();
    this.l = new HashMap();
    this.r = paramas;
    this.s = paramInt;
  }
  
  private ai<com.facebook.common.h.a<b>> a()
  {
    try
    {
      if (this.a == null) {
        this.a = b(d());
      }
      ai localai = this.a;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> a(ai<d> paramai)
  {
    return a(paramai, new av[] { this.m.e() });
  }
  
  private ai<com.facebook.common.h.a<b>> a(ai<d> paramai, av<d>[] paramArrayOfav)
  {
    return b(b(c(paramai), paramArrayOfav));
  }
  
  private ai<d> a(av<d>[] paramArrayOfav)
  {
    paramArrayOfav = this.m.a(paramArrayOfav);
    if (this.q) {
      return paramArrayOfav;
    }
    return this.m.k(paramArrayOfav);
  }
  
  private ai<d> b()
  {
    try
    {
      if (this.b == null) {
        this.b = this.m.a(d(), this.r);
      }
      ai localai = this.b;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> b(ai<d> paramai)
  {
    return d(this.m.e(paramai));
  }
  
  private ai<d> b(ai<d> paramai, av<d>[] paramArrayOfav)
  {
    Object localObject = l.a(paramai);
    paramai = (ai<d>)localObject;
    if (!this.q) {
      paramai = this.m.k((ai)localObject);
    }
    paramai = this.m.a(this.s, paramai);
    localObject = this.m;
    return l.a(a(paramArrayOfav), paramai);
  }
  
  private ai<Void> c()
  {
    try
    {
      if (this.d == null)
      {
        localObject1 = this.m;
        this.d = l.l(b());
      }
      Object localObject1 = this.d;
      return (ai<Void>)localObject1;
    }
    finally {}
  }
  
  private ai<d> c(ai<d> paramai)
  {
    Object localObject = paramai;
    if (Build.VERSION.SDK_INT < 18)
    {
      localObject = paramai;
      if (!this.p) {
        localObject = this.m.m(paramai);
      }
    }
    paramai = this.m.f((ai)localObject);
    paramai = this.m.h(paramai);
    return this.m.g(paramai);
  }
  
  private ai<d> d()
  {
    try
    {
      if (this.t == null)
      {
        this.t = l.a(c(this.m.a(this.n)));
        if ((this.o) && (!this.q)) {
          this.t = this.m.k(this.t);
        }
      }
      ai localai = this.t;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> d(ai<com.facebook.common.h.a<b>> paramai)
  {
    paramai = this.m.d(paramai);
    paramai = this.m.c(paramai);
    paramai = this.m.a(paramai, this.r);
    return this.m.b(paramai);
  }
  
  private ai<com.facebook.common.h.a<b>> e()
  {
    try
    {
      if (this.e == null) {
        this.e = a(this.m.f());
      }
      ai localai = this.e;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> e(ai<com.facebook.common.h.a<b>> paramai)
  {
    try
    {
      if (!this.k.containsKey(paramai))
      {
        Object localObject = this.m.j(paramai);
        localObject = this.m.i((ai)localObject);
        this.k.put(paramai, localObject);
      }
      paramai = (ai)this.k.get(paramai);
      return paramai;
    }
    finally {}
  }
  
  private static void e(c paramc)
  {
    k.a(paramc);
    k.a(g.a(paramc.b()));
    if (paramc.k().a() <= c.b.c.a()) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      return;
    }
  }
  
  private ai<com.facebook.common.h.a<b>> f()
  {
    try
    {
      if (this.f == null) {
        this.f = d(this.m.h());
      }
      ai localai = this.f;
      return localai;
    }
    finally {}
  }
  
  private ai<Void> f(ai<com.facebook.common.h.a<b>> paramai)
  {
    try
    {
      if (!this.l.containsKey(paramai))
      {
        Object localObject = this.m;
        localObject = l.l(paramai);
        this.l.put(paramai, localObject);
      }
      paramai = (ai)this.l.get(paramai);
      return paramai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> f(c paramc)
  {
    k.a(paramc);
    paramc = paramc.b();
    k.a(paramc, "Uri is null.");
    if (g.a(paramc)) {
      return a();
    }
    if (g.b(paramc))
    {
      if (com.facebook.common.f.a.b(com.facebook.common.f.a.c(paramc.getPath()))) {
        return f();
      }
      return e();
    }
    if (g.c(paramc)) {
      return g();
    }
    if (g.f(paramc)) {
      return i();
    }
    if (g.g(paramc)) {
      return h();
    }
    if (g.h(paramc)) {
      return j();
    }
    String str = paramc.toString();
    paramc = str;
    if (str.length() > 30) {
      paramc = str.substring(0, 30) + "...";
    }
    throw new RuntimeException("Unsupported uri scheme! Uri is: " + paramc);
  }
  
  private ai<com.facebook.common.h.a<b>> g()
  {
    try
    {
      if (this.g == null) {
        this.g = a(this.m.c(), new av[] { this.m.d(), this.m.e() });
      }
      ai localai = this.g;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> h()
  {
    try
    {
      if (this.h == null) {
        this.h = a(this.m.g());
      }
      ai localai = this.h;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> i()
  {
    try
    {
      if (this.i == null) {
        this.i = a(this.m.b());
      }
      ai localai = this.i;
      return localai;
    }
    finally {}
  }
  
  private ai<com.facebook.common.h.a<b>> j()
  {
    try
    {
      if (this.j == null)
      {
        Object localObject3 = this.m.a();
        localObject1 = localObject3;
        if (Build.VERSION.SDK_INT < 18)
        {
          localObject1 = localObject3;
          if (!this.p) {
            localObject1 = this.m.m((ai)localObject3);
          }
        }
        localObject3 = this.m;
        localObject3 = l.a((ai)localObject1);
        localObject1 = localObject3;
        if (!this.q) {
          localObject1 = this.m.k((ai)localObject3);
        }
        this.j = b((ai)localObject1);
      }
      Object localObject1 = this.j;
      return (ai<com.facebook.common.h.a<b>>)localObject1;
    }
    finally {}
  }
  
  public ai<com.facebook.common.h.a<y>> a(c paramc)
  {
    e(paramc);
    try
    {
      if (this.c == null) {
        this.c = new am(b());
      }
      return this.c;
    }
    finally {}
  }
  
  public ai<Void> b(c paramc)
  {
    e(paramc);
    return c();
  }
  
  public ai<com.facebook.common.h.a<b>> c(c paramc)
  {
    ai localai2 = f(paramc);
    ai localai1 = localai2;
    if (paramc.n() != null) {
      localai1 = e(localai2);
    }
    return localai1;
  }
  
  public ai<Void> d(c paramc)
  {
    return f(f(paramc));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */