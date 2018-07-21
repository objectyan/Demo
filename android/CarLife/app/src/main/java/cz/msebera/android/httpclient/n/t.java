package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.aa;
import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.af;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.aq;
import cz.msebera.android.httpclient.b;
import cz.msebera.android.httpclient.g.d;
import cz.msebera.android.httpclient.i.i;
import cz.msebera.android.httpclient.i.l;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.f;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.y;
import java.io.IOException;

@Immutable
public class t
{
  private volatile cz.msebera.android.httpclient.l.j a = null;
  private volatile k b = null;
  private volatile o c = null;
  private volatile b d = null;
  private volatile y e = null;
  private volatile j f = null;
  
  @Deprecated
  public t(k paramk, b paramb, y paramy)
  {
    a(paramk);
    a(paramb);
    a(paramy);
  }
  
  public t(k paramk, b paramb, y paramy, o paramo)
  {
    this(paramk, paramb, paramy, paramo, null);
  }
  
  public t(k paramk, b paramb, y paramy, o paramo, j paramj)
  {
    this.b = ((k)a.a(paramk, "HTTP processor"));
    if (paramb != null)
    {
      this.d = paramb;
      if (paramy == null) {
        break label85;
      }
    }
    for (;;)
    {
      this.e = paramy;
      this.c = paramo;
      this.f = paramj;
      return;
      paramb = i.a;
      break;
      label85:
      paramy = l.a;
    }
  }
  
  @Deprecated
  public t(k paramk, b paramb, y paramy, q paramq, cz.msebera.android.httpclient.l.j paramj)
  {
    this(paramk, paramb, paramy, new a(paramq), null);
  }
  
  @Deprecated
  public t(k paramk, b paramb, y paramy, q paramq, j paramj, cz.msebera.android.httpclient.l.j paramj1)
  {
    this(paramk, paramb, paramy, new a(paramq), paramj);
  }
  
  public t(k paramk, o paramo)
  {
    this(paramk, null, null, paramo, null);
  }
  
  @Deprecated
  public cz.msebera.android.httpclient.l.j a()
  {
    return this.a;
  }
  
  public void a(aa paramaa, g paramg)
    throws IOException, p
  {
    paramg.a("http.connection", paramaa);
    localObject3 = null;
    for (;;)
    {
      try
      {
        localu = paramaa.a();
        localObject1 = localObject3;
        if ((localu instanceof cz.msebera.android.httpclient.o))
        {
          if (!((cz.msebera.android.httpclient.o)localu).expectContinue()) {
            continue;
          }
          localObject1 = this.e.a(ac.d, 100, paramg);
          j localj = this.f;
          localObject3 = localObject1;
          if (localj == null) {}
        }
      }
      catch (p localp2)
      {
        u localu;
        Object localObject1;
        Object localObject2 = this.e.a(ac.c, 500, paramg);
        a(localp2, (x)localObject2);
        continue;
        paramaa.a((cz.msebera.android.httpclient.o)localu);
        localObject2 = localp2;
        continue;
      }
      try
      {
        this.f.a(localu, (x)localObject1, paramg);
        localObject3 = localObject1;
      }
      catch (p localp1)
      {
        localObject3 = this.e.a(ac.c, 500, paramg);
        a(localp1, (x)localObject3);
      }
    }
    localObject1 = localObject3;
    if (((x)localObject3).a().b() < 200)
    {
      paramaa.a((x)localObject3);
      paramaa.b();
      localObject1 = null;
      paramaa.a((cz.msebera.android.httpclient.o)localu);
    }
    paramg.a("http.request", localu);
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = this.e.a(ac.d, 200, paramg);
      this.b.process(localu, paramg);
      a(localu, (x)localObject3, paramg);
    }
    localObject1 = localObject3;
    if ((localu instanceof cz.msebera.android.httpclient.o))
    {
      cz.msebera.android.httpclient.o.g.b(((cz.msebera.android.httpclient.o)localu).getEntity());
      localObject1 = localObject3;
    }
    paramg.a("http.response", localObject1);
    this.b.process((x)localObject1, paramg);
    paramaa.a((x)localObject1);
    paramaa.b((x)localObject1);
    paramaa.b();
    if (!this.d.a((x)localObject1, paramg)) {
      paramaa.close();
    }
  }
  
  @Deprecated
  public void a(b paramb)
  {
    a.a(paramb, "Connection reuse strategy");
    this.d = paramb;
  }
  
  @Deprecated
  public void a(cz.msebera.android.httpclient.l.j paramj)
  {
    this.a = paramj;
  }
  
  @Deprecated
  public void a(j paramj)
  {
    this.f = paramj;
  }
  
  @Deprecated
  public void a(k paramk)
  {
    a.a(paramk, "HTTP processor");
    this.b = paramk;
  }
  
  @Deprecated
  public void a(q paramq)
  {
    this.c = new a(paramq);
  }
  
  protected void a(p paramp, x paramx)
  {
    if ((paramp instanceof af)) {
      paramx.a(501);
    }
    for (;;)
    {
      String str2 = paramp.getMessage();
      String str1 = str2;
      if (str2 == null) {
        str1 = paramp.toString();
      }
      paramp = new d(f.a(str1));
      paramp.a("text/plain; charset=US-ASCII");
      paramx.a(paramp);
      return;
      if ((paramp instanceof aq)) {
        paramx.a(505);
      } else if ((paramp instanceof aj)) {
        paramx.a(400);
      } else {
        paramx.a(500);
      }
    }
  }
  
  protected void a(u paramu, x paramx, g paramg)
    throws p, IOException
  {
    n localn = null;
    if (this.c != null) {
      localn = this.c.a(paramu);
    }
    if (localn != null)
    {
      localn.a(paramu, paramx, paramg);
      return;
    }
    paramx.a(501);
  }
  
  @Deprecated
  public void a(y paramy)
  {
    a.a(paramy, "Response factory");
    this.e = paramy;
  }
  
  @Deprecated
  private static class a
    implements o
  {
    private final q a;
    
    public a(q paramq)
    {
      this.a = paramq;
    }
    
    public n a(u paramu)
    {
      return this.a.b(paramu.getRequestLine().c());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */