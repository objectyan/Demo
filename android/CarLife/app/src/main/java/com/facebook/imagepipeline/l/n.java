package com.facebook.imagepipeline.l;

import a.h;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.d.f;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.m.c.a;
import com.facebook.imagepipeline.m.c.b;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
  implements ai<com.facebook.imagepipeline.i.d>
{
  @VisibleForTesting
  static final String a = "DiskCacheProducer";
  @VisibleForTesting
  static final String b = "cached_value_found";
  private final com.facebook.imagepipeline.d.e c;
  private final com.facebook.imagepipeline.d.e d;
  private final f e;
  private final ai<com.facebook.imagepipeline.i.d> f;
  private final boolean g;
  private final int h;
  
  public n(com.facebook.imagepipeline.d.e parame1, com.facebook.imagepipeline.d.e parame2, f paramf, ai<com.facebook.imagepipeline.i.d> paramai, int paramInt)
  {
    this.c = parame1;
    this.d = parame2;
    this.e = paramf;
    this.f = paramai;
    this.h = paramInt;
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      return;
    }
  }
  
  private h<com.facebook.imagepipeline.i.d, Void> a(final j<com.facebook.imagepipeline.i.d> paramj, final com.facebook.imagepipeline.d.e parame, final com.facebook.b.a.d paramd, final aj paramaj)
  {
    final String str = paramaj.b();
    new h()
    {
      public Void b(a.j<com.facebook.imagepipeline.i.d> paramAnonymousj)
        throws Exception
      {
        if (n.a(paramAnonymousj))
        {
          this.a.b(str, "DiskCacheProducer", null);
          paramj.b();
          return null;
        }
        if (paramAnonymousj.e())
        {
          this.a.a(str, "DiskCacheProducer", paramAnonymousj.g(), null);
          n.a(n.this, paramj, new n.a(n.this, paramj, parame, paramd, null), paramaj);
          return null;
        }
        paramAnonymousj = (com.facebook.imagepipeline.i.d)paramAnonymousj.f();
        if (paramAnonymousj != null)
        {
          this.a.a(str, "DiskCacheProducer", n.a(this.a, str, true));
          paramj.b(1.0F);
          paramj.b(paramAnonymousj, true);
          paramAnonymousj.close();
          return null;
        }
        this.a.a(str, "DiskCacheProducer", n.a(this.a, str, false));
        n.a(n.this, paramj, new n.a(n.this, paramj, parame, paramd, null), paramaj);
        return null;
      }
    };
  }
  
  @VisibleForTesting
  static Map<String, String> a(al paramal, String paramString, boolean paramBoolean)
  {
    if (!paramal.b(paramString)) {
      return null;
    }
    return g.a("cached_value_found", String.valueOf(paramBoolean));
  }
  
  private void a(j<com.facebook.imagepipeline.i.d> paramj1, j<com.facebook.imagepipeline.i.d> paramj2, aj paramaj)
  {
    if (paramaj.e().a() >= c.b.b.a())
    {
      paramj1.b(null, true);
      return;
    }
    this.f.a(paramj2, paramaj);
  }
  
  private void a(final AtomicBoolean paramAtomicBoolean, aj paramaj)
  {
    paramaj.a(new e()
    {
      public void a()
      {
        paramAtomicBoolean.set(true);
      }
    });
  }
  
  private static boolean b(a.j<?> paramj)
  {
    return (paramj.d()) || ((paramj.e()) && ((paramj.g() instanceof CancellationException)));
  }
  
  public void a(j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    Object localObject1 = paramaj.a();
    if (!((c)localObject1).l())
    {
      a(paramj, paramj, paramaj);
      return;
    }
    paramaj.c().a(paramaj.b(), "DiskCacheProducer");
    final com.facebook.b.a.d locald = this.e.c((c)localObject1, paramaj.d());
    int i;
    label85:
    final AtomicBoolean localAtomicBoolean;
    final com.facebook.imagepipeline.d.e locale;
    if (((c)localObject1).a() == c.a.a)
    {
      i = 1;
      if (i == 0) {
        break label203;
      }
      localObject1 = this.d;
      localAtomicBoolean = new AtomicBoolean(false);
      if (!this.g) {
        break label227;
      }
      boolean bool1 = this.d.a(locald);
      boolean bool2 = this.c.a(locald);
      if ((!bool1) && (bool2)) {
        break label212;
      }
      localObject2 = this.d;
      locale = this.c;
    }
    label146:
    label203:
    label212:
    label227:
    for (Object localObject2 = ((com.facebook.imagepipeline.d.e)localObject2).a(locald, localAtomicBoolean).b(new h()
        {
          public a.j<com.facebook.imagepipeline.i.d> b(a.j<com.facebook.imagepipeline.i.d> paramAnonymousj)
            throws Exception
          {
            if ((n.a(paramAnonymousj)) || ((!paramAnonymousj.e()) && (paramAnonymousj.f() != null))) {
              return paramAnonymousj;
            }
            return locale.a(locald, localAtomicBoolean);
          }
        });; localObject2 = ((com.facebook.imagepipeline.d.e)localObject1).a(locald, localAtomicBoolean))
    {
      ((a.j)localObject2).a(a(paramj, (com.facebook.imagepipeline.d.e)localObject1, locald, paramaj));
      a(localAtomicBoolean, paramaj);
      return;
      i = 0;
      break;
      localObject1 = this.c;
      break label85;
      localObject2 = this.c;
      locale = this.d;
      break label146;
    }
  }
  
  private class a
    extends m<com.facebook.imagepipeline.i.d, com.facebook.imagepipeline.i.d>
  {
    private final com.facebook.imagepipeline.d.e b;
    private final com.facebook.b.a.d c;
    
    private a(com.facebook.imagepipeline.d.e parame, com.facebook.b.a.d paramd)
    {
      super();
      this.b = paramd;
      com.facebook.b.a.d locald;
      this.c = locald;
    }
    
    public void a(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      if ((paramd != null) && (paramBoolean))
      {
        if (!n.a(n.this)) {
          break label83;
        }
        int i = paramd.j();
        if ((i <= 0) || (i >= n.b(n.this))) {
          break label65;
        }
        n.c(n.this).a(this.c, paramd);
      }
      for (;;)
      {
        d().b(paramd, paramBoolean);
        return;
        label65:
        n.d(n.this).a(this.c, paramd);
        continue;
        label83:
        this.b.a(this.c, paramd);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */