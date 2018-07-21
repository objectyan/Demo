package com.facebook.drawee.c;

import android.content.Context;
import com.facebook.c.e;
import com.facebook.c.g;
import com.facebook.c.h;
import com.facebook.common.internal.k;
import com.facebook.common.internal.m;
import com.facebook.drawee.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class b<BUILDER extends b<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO>
  implements com.facebook.drawee.g.d
{
  private static final d<Object> a = new b.1();
  private static final NullPointerException b = new NullPointerException("No image request was specified!");
  private static final AtomicLong q = new AtomicLong();
  private final Context c;
  private final Set<d> d;
  @Nullable
  private Object e;
  @Nullable
  private REQUEST f;
  @Nullable
  private REQUEST g;
  @Nullable
  private REQUEST[] h;
  private boolean i;
  @Nullable
  private m<com.facebook.c.d<IMAGE>> j;
  @Nullable
  private d<? super INFO> k;
  private boolean l;
  private boolean m;
  private boolean n;
  private String o;
  @Nullable
  private com.facebook.drawee.g.a p;
  
  protected b(Context paramContext, Set<d> paramSet)
  {
    this.c = paramContext;
    this.d = paramSet;
    a();
  }
  
  private void a()
  {
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = true;
    this.k = null;
    this.l = false;
    this.m = false;
    this.p = null;
    this.o = null;
  }
  
  protected static String t()
  {
    return String.valueOf(q.getAndIncrement());
  }
  
  protected abstract com.facebook.c.d<IMAGE> a(REQUEST paramREQUEST, Object paramObject, boolean paramBoolean);
  
  protected m<com.facebook.c.d<IMAGE>> a(REQUEST paramREQUEST, boolean paramBoolean)
  {
    return new b.2(this, paramREQUEST, f(), paramBoolean);
  }
  
  public BUILDER a(d<? super INFO> paramd)
  {
    this.k = paramd;
    return c();
  }
  
  public BUILDER a(@Nullable com.facebook.drawee.g.a parama)
  {
    this.p = parama;
    return c();
  }
  
  public BUILDER a(Object paramObject)
  {
    this.e = paramObject;
    return c();
  }
  
  public BUILDER a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return c();
  }
  
  public BUILDER a(REQUEST[] paramArrayOfREQUEST)
  {
    return a(paramArrayOfREQUEST, true);
  }
  
  public BUILDER a(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    this.h = paramArrayOfREQUEST;
    this.i = paramBoolean;
    return c();
  }
  
  public void a(@Nullable m<com.facebook.c.d<IMAGE>> paramm)
  {
    this.j = paramm;
  }
  
  protected void a(a parama)
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        parama.a((d)localIterator.next());
      }
    }
    if (this.k != null) {
      parama.a(this.k);
    }
    if (this.m) {
      parama.a(a);
    }
  }
  
  protected m<com.facebook.c.d<IMAGE>> b(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfREQUEST.length * 2);
    if (paramBoolean)
    {
      i1 = 0;
      while (i1 < paramArrayOfREQUEST.length)
      {
        localArrayList.add(a(paramArrayOfREQUEST[i1], true));
        i1 += 1;
      }
    }
    int i1 = 0;
    while (i1 < paramArrayOfREQUEST.length)
    {
      localArrayList.add(d(paramArrayOfREQUEST[i1]));
      i1 += 1;
    }
    return g.a(localArrayList);
  }
  
  public BUILDER b(REQUEST paramREQUEST)
  {
    this.f = paramREQUEST;
    return c();
  }
  
  public BUILDER b(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return c();
  }
  
  protected void b(a parama)
  {
    if (!this.l) {
      return;
    }
    c localc2 = parama.i();
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      parama.a(localc1);
    }
    localc1.a(this.l);
    c(parama);
  }
  
  protected abstract BUILDER c();
  
  public BUILDER c(REQUEST paramREQUEST)
  {
    this.g = paramREQUEST;
    return c();
  }
  
  public BUILDER c(String paramString)
  {
    this.o = paramString;
    return c();
  }
  
  public BUILDER c(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return c();
  }
  
  protected void c(a parama)
  {
    if (parama.j() == null) {
      parama.a(com.facebook.drawee.f.a.a(this.c));
    }
  }
  
  protected m<com.facebook.c.d<IMAGE>> d(REQUEST paramREQUEST)
  {
    return a(paramREQUEST, false);
  }
  
  protected abstract a d();
  
  public BUILDER e()
  {
    a();
    return c();
  }
  
  @Nullable
  public Object f()
  {
    return this.e;
  }
  
  @Nullable
  public REQUEST g()
  {
    return (REQUEST)this.f;
  }
  
  @Nullable
  public REQUEST h()
  {
    return (REQUEST)this.g;
  }
  
  @Nullable
  public REQUEST[] i()
  {
    return this.h;
  }
  
  @Nullable
  public m<com.facebook.c.d<IMAGE>> j()
  {
    return this.j;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  public boolean l()
  {
    return this.n;
  }
  
  public boolean m()
  {
    return this.m;
  }
  
  @Nullable
  public d<? super INFO> n()
  {
    return this.k;
  }
  
  @Nullable
  public String o()
  {
    return this.o;
  }
  
  @Nullable
  public com.facebook.drawee.g.a p()
  {
    return this.p;
  }
  
  public a q()
  {
    r();
    if ((this.f == null) && (this.h == null) && (this.g != null))
    {
      this.f = this.g;
      this.g = null;
    }
    return s();
  }
  
  protected void r()
  {
    boolean bool2 = false;
    if ((this.h == null) || (this.f == null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      k.b(bool1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
      if (this.j != null)
      {
        bool1 = bool2;
        if (this.h == null)
        {
          bool1 = bool2;
          if (this.f == null)
          {
            bool1 = bool2;
            if (this.g != null) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      k.b(bool1, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
      return;
    }
  }
  
  protected a s()
  {
    a locala = d();
    locala.a(l());
    locala.a(o());
    b(locala);
    a(locala);
    return locala;
  }
  
  protected m<com.facebook.c.d<IMAGE>> u()
  {
    if (this.j != null)
    {
      localObject1 = this.j;
      return (m<com.facebook.c.d<IMAGE>>)localObject1;
    }
    Object localObject1 = null;
    if (this.f != null) {
      localObject1 = d(this.f);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.g != null)
        {
          localObject2 = new ArrayList(2);
          ((List)localObject2).add(localObject1);
          ((List)localObject2).add(d(this.g));
          localObject2 = h.a((List)localObject2);
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return e.b(b);
      if (this.h != null) {
        localObject1 = b(this.h, this.i);
      }
    }
  }
  
  protected Context v()
  {
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/drawee/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */