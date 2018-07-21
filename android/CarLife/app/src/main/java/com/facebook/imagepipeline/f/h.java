package com.facebook.imagepipeline.f;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.b.b.c.a;
import com.facebook.common.internal.m;
import com.facebook.imagepipeline.d.j;
import com.facebook.imagepipeline.d.n;
import com.facebook.imagepipeline.d.q;
import com.facebook.imagepipeline.l.ae;
import com.facebook.imagepipeline.l.s;
import com.facebook.imagepipeline.memory.t.a;
import com.facebook.imagepipeline.memory.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class h
{
  @Nullable
  private final com.facebook.imagepipeline.a.a.d a;
  private final Bitmap.Config b;
  private final m<q> c;
  private final com.facebook.imagepipeline.d.f d;
  private final Context e;
  private final boolean f;
  private final boolean g;
  private final f h;
  private final m<q> i;
  private final e j;
  private final n k;
  @Nullable
  private final com.facebook.imagepipeline.h.b l;
  private final m<Boolean> m;
  private final com.facebook.b.b.c n;
  private final com.facebook.common.g.c o;
  private final ae p;
  @Nullable
  private final com.facebook.imagepipeline.c.e q;
  private final u r;
  private final com.facebook.imagepipeline.h.c s;
  private final Set<com.facebook.imagepipeline.j.c> t;
  private final boolean u;
  private final com.facebook.b.b.c v;
  private final i w;
  
  private h(a parama)
  {
    this.a = a.a(parama);
    label55:
    label71:
    label120:
    label148:
    label164:
    label193:
    label213:
    label229:
    label249:
    label283:
    label303:
    label323:
    label348:
    int i1;
    if (a.b(parama) == null)
    {
      localObject = new com.facebook.imagepipeline.d.i((ActivityManager)a.c(parama).getSystemService("activity"));
      this.c = ((m)localObject);
      if (a.d(parama) != null) {
        break label402;
      }
      localObject = Bitmap.Config.ARGB_8888;
      this.b = ((Bitmap.Config)localObject);
      if (a.e(parama) != null) {
        break label410;
      }
      localObject = j.a();
      this.d = ((com.facebook.imagepipeline.d.f)localObject);
      this.e = ((Context)com.facebook.common.internal.k.a(a.c(parama)));
      this.g = a.f(parama);
      if (a.g(parama) != null) {
        break label418;
      }
      localObject = new b(new d());
      this.h = ((f)localObject);
      this.f = a.h(parama);
      if (a.i(parama) != null) {
        break label426;
      }
      localObject = new com.facebook.imagepipeline.d.k();
      this.i = ((m)localObject);
      if (a.j(parama) != null) {
        break label434;
      }
      localObject = com.facebook.imagepipeline.d.t.l();
      this.k = ((n)localObject);
      this.l = a.k(parama);
      if (a.l(parama) != null) {
        break label442;
      }
      localObject = new h.1(this);
      this.m = ((m)localObject);
      if (a.m(parama) != null) {
        break label450;
      }
      localObject = b(a.c(parama));
      this.n = ((com.facebook.b.b.c)localObject);
      if (a.n(parama) != null) {
        break label458;
      }
      localObject = com.facebook.common.g.f.a();
      this.o = ((com.facebook.common.g.c)localObject);
      if (a.o(parama) != null) {
        break label466;
      }
      localObject = new s();
      this.p = ((ae)localObject);
      this.q = a.p(parama);
      if (a.q(parama) != null) {
        break label474;
      }
      localObject = new u(com.facebook.imagepipeline.memory.t.i().a());
      this.r = ((u)localObject);
      if (a.r(parama) != null) {
        break label482;
      }
      localObject = new com.facebook.imagepipeline.h.e();
      this.s = ((com.facebook.imagepipeline.h.c)localObject);
      if (a.s(parama) != null) {
        break label490;
      }
      localObject = new HashSet();
      this.t = ((Set)localObject);
      this.u = a.t(parama);
      if (a.u(parama) != null) {
        break label498;
      }
      localObject = this.n;
      this.v = ((com.facebook.b.b.c)localObject);
      i1 = this.r.c();
      if (a.v(parama) != null) {
        break label506;
      }
    }
    label402:
    label410:
    label418:
    label426:
    label434:
    label442:
    label450:
    label458:
    label466:
    label474:
    label482:
    label490:
    label498:
    label506:
    for (Object localObject = new a(i1);; localObject = a.v(parama))
    {
      this.j = ((e)localObject);
      this.w = a.w(parama).a();
      return;
      localObject = a.b(parama);
      break;
      localObject = a.d(parama);
      break label55;
      localObject = a.e(parama);
      break label71;
      localObject = a.g(parama);
      break label120;
      localObject = a.i(parama);
      break label148;
      localObject = a.j(parama);
      break label164;
      localObject = a.l(parama);
      break label193;
      localObject = a.m(parama);
      break label213;
      localObject = a.n(parama);
      break label229;
      localObject = a.o(parama);
      break label249;
      localObject = a.q(parama);
      break label283;
      localObject = a.r(parama);
      break label303;
      localObject = a.s(parama);
      break label323;
      localObject = a.u(parama);
      break label348;
    }
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  private static com.facebook.b.b.c b(Context paramContext)
  {
    return com.facebook.b.b.c.a(paramContext).a();
  }
  
  @Nullable
  public com.facebook.imagepipeline.a.a.d a()
  {
    return this.a;
  }
  
  public Bitmap.Config b()
  {
    return this.b;
  }
  
  public m<q> c()
  {
    return this.c;
  }
  
  public com.facebook.imagepipeline.d.f d()
  {
    return this.d;
  }
  
  public Context e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.w.a();
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public f h()
  {
    return this.h;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public boolean j()
  {
    return this.w.c();
  }
  
  public m<q> k()
  {
    return this.i;
  }
  
  public e l()
  {
    return this.j;
  }
  
  @Deprecated
  public int m()
  {
    return this.w.b();
  }
  
  public n n()
  {
    return this.k;
  }
  
  @Nullable
  public com.facebook.imagepipeline.h.b o()
  {
    return this.l;
  }
  
  public m<Boolean> p()
  {
    return this.m;
  }
  
  public com.facebook.b.b.c q()
  {
    return this.n;
  }
  
  public com.facebook.common.g.c r()
  {
    return this.o;
  }
  
  public ae s()
  {
    return this.p;
  }
  
  @Nullable
  public com.facebook.imagepipeline.c.e t()
  {
    return this.q;
  }
  
  public u u()
  {
    return this.r;
  }
  
  public com.facebook.imagepipeline.h.c v()
  {
    return this.s;
  }
  
  public Set<com.facebook.imagepipeline.j.c> w()
  {
    return Collections.unmodifiableSet(this.t);
  }
  
  public boolean x()
  {
    return this.u;
  }
  
  public com.facebook.b.b.c y()
  {
    return this.v;
  }
  
  public i z()
  {
    return this.w;
  }
  
  public static class a
  {
    private com.facebook.imagepipeline.a.a.d a;
    private Bitmap.Config b;
    private m<q> c;
    private com.facebook.imagepipeline.d.f d;
    private final Context e;
    private boolean f = false;
    private boolean g;
    private m<q> h;
    private e i;
    private n j;
    private com.facebook.imagepipeline.h.b k;
    private m<Boolean> l;
    private com.facebook.b.b.c m;
    private com.facebook.common.g.c n;
    private ae o;
    private com.facebook.imagepipeline.c.e p;
    private u q;
    private com.facebook.imagepipeline.h.c r;
    private Set<com.facebook.imagepipeline.j.c> s;
    private boolean t = true;
    private com.facebook.b.b.c u;
    private f v;
    private final i.a w = new i.a(this);
    
    private a(Context paramContext)
    {
      this.e = ((Context)com.facebook.common.internal.k.a(paramContext));
    }
    
    public a a(Bitmap.Config paramConfig)
    {
      this.b = paramConfig;
      return this;
    }
    
    public a a(com.facebook.b.b.c paramc)
    {
      this.m = paramc;
      return this;
    }
    
    public a a(com.facebook.common.g.c paramc)
    {
      this.n = paramc;
      return this;
    }
    
    public a a(m<q> paramm)
    {
      this.c = ((m)com.facebook.common.internal.k.a(paramm));
      return this;
    }
    
    public a a(com.facebook.imagepipeline.a.a.d paramd)
    {
      this.a = paramd;
      return this;
    }
    
    public a a(com.facebook.imagepipeline.c.e parame)
    {
      this.p = parame;
      return this;
    }
    
    public a a(com.facebook.imagepipeline.d.f paramf)
    {
      this.d = paramf;
      return this;
    }
    
    public a a(n paramn)
    {
      this.j = paramn;
      return this;
    }
    
    @Deprecated
    public a a(c paramc)
    {
      a(new b(paramc));
      return this;
    }
    
    public a a(e parame)
    {
      this.i = parame;
      return this;
    }
    
    public a a(f paramf)
    {
      this.v = paramf;
      return this;
    }
    
    public a a(com.facebook.imagepipeline.h.b paramb)
    {
      this.k = paramb;
      return this;
    }
    
    public a a(com.facebook.imagepipeline.h.c paramc)
    {
      this.r = paramc;
      return this;
    }
    
    public a a(ae paramae)
    {
      this.o = paramae;
      return this;
    }
    
    public a a(u paramu)
    {
      this.q = paramu;
      return this;
    }
    
    public a a(Set<com.facebook.imagepipeline.j.c> paramSet)
    {
      this.s = paramSet;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public boolean a()
    {
      return this.f;
    }
    
    public a b(com.facebook.b.b.c paramc)
    {
      this.u = paramc;
      return this;
    }
    
    public a b(m<q> paramm)
    {
      this.h = ((m)com.facebook.common.internal.k.a(paramm));
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public i.a b()
    {
      return this.w;
    }
    
    public a c(m<Boolean> paramm)
    {
      this.l = paramm;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.t = paramBoolean;
      return this;
    }
    
    public h c()
    {
      return new h(this, null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */