package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g.a;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.k.j;
import cz.msebera.android.httpclient.k.p;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Immutable
class ak
{
  private static final List<String> b = Arrays.asList(new String[] { "min-fresh", "max-stale", "max-age" });
  private final boolean a;
  
  public ak()
  {
    this.a = false;
  }
  
  public ak(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private String a(List<cz.msebera.android.httpclient.g> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 1;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      cz.msebera.android.httpclient.g localg = (cz.msebera.android.httpclient.g)paramList.next();
      if (i == 0) {
        localStringBuilder.append(",");
      }
      for (;;)
      {
        localStringBuilder.append(localg.toString());
        break;
        i = 0;
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a(cz.msebera.android.httpclient.o paramo)
  {
    if (paramo.getEntity().getContentType() == null) {
      ((a)paramo.getEntity()).a(cz.msebera.android.httpclient.g.g.d.a());
    }
  }
  
  private void d(u paramu)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    cz.msebera.android.httpclient.f[] arrayOff = paramu.getHeaders("Cache-Control");
    int m = arrayOff.length;
    int i = 0;
    while (i < m)
    {
      cz.msebera.android.httpclient.g[] arrayOfg = arrayOff[i].e();
      int n = arrayOfg.length;
      int j = 0;
      while (j < n)
      {
        cz.msebera.android.httpclient.g localg = arrayOfg[j];
        if (!b.contains(localg.a())) {
          localArrayList.add(localg);
        }
        if ("no-cache".equals(localg.a())) {
          k = 1;
        }
        j += 1;
      }
      i += 1;
    }
    if (k == 0) {
      return;
    }
    paramu.removeHeaders("Cache-Control");
    paramu.setHeader("Cache-Control", a(localArrayList));
  }
  
  private boolean e(u paramu)
  {
    return ("TRACE".equals(paramu.getRequestLine().a())) && ((paramu instanceof cz.msebera.android.httpclient.o));
  }
  
  private void f(u paramu)
  {
    if (!"OPTIONS".equals(paramu.getRequestLine().a())) {}
    cz.msebera.android.httpclient.f localf;
    do
    {
      return;
      localf = paramu.getFirstHeader("Max-Forwards");
    } while (localf == null);
    paramu.removeHeaders("Max-Forwards");
    paramu.setHeader("Max-Forwards", Integer.toString(Integer.parseInt(localf.d()) - 1));
  }
  
  private void g(u paramu)
  {
    if (!"OPTIONS".equals(paramu.getRequestLine().a())) {}
    while (!(paramu instanceof cz.msebera.android.httpclient.o)) {
      return;
    }
    a((cz.msebera.android.httpclient.o)paramu);
  }
  
  private void h(u paramu)
  {
    if ((paramu instanceof cz.msebera.android.httpclient.o))
    {
      if ((((cz.msebera.android.httpclient.o)paramu).expectContinue()) && (((cz.msebera.android.httpclient.o)paramu).getEntity() != null))
      {
        j(paramu);
        return;
      }
      i(paramu);
      return;
    }
    i(paramu);
  }
  
  private void i(u paramu)
  {
    int k = 0;
    cz.msebera.android.httpclient.f[] arrayOff = paramu.getHeaders("Expect");
    Object localObject = new ArrayList();
    int m = arrayOff.length;
    int i = 0;
    while (i < m)
    {
      cz.msebera.android.httpclient.f localf = arrayOff[i];
      cz.msebera.android.httpclient.g[] arrayOfg = localf.e();
      int n = arrayOfg.length;
      int j = 0;
      if (j < n)
      {
        cz.msebera.android.httpclient.g localg = arrayOfg[j];
        if (!"100-continue".equalsIgnoreCase(localg.a())) {
          ((List)localObject).add(localg);
        }
        for (;;)
        {
          j += 1;
          break;
          k = 1;
        }
      }
      if (k != 0)
      {
        paramu.removeHeader(localf);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramu.addHeader(new b("Expect", ((cz.msebera.android.httpclient.g)((Iterator)localObject).next()).a()));
        }
      }
      localObject = new ArrayList();
      i += 1;
    }
  }
  
  private void j(u paramu)
  {
    int k = 0;
    cz.msebera.android.httpclient.f[] arrayOff = paramu.getHeaders("Expect");
    int m = arrayOff.length;
    int i = 0;
    while (i < m)
    {
      cz.msebera.android.httpclient.g[] arrayOfg = arrayOff[i].e();
      int n = arrayOfg.length;
      int j = 0;
      while (j < n)
      {
        if ("100-continue".equalsIgnoreCase(arrayOfg[j].a())) {
          k = 1;
        }
        j += 1;
      }
      i += 1;
    }
    if (k == 0) {
      paramu.addHeader("Expect", "100-continue");
    }
  }
  
  private al k(u paramu)
  {
    if (!"GET".equals(paramu.getRequestLine().a())) {}
    do
    {
      do
      {
        return null;
      } while (paramu.getFirstHeader("Range") == null);
      paramu = paramu.getFirstHeader("If-Range");
    } while ((paramu == null) || (!paramu.d().startsWith("W/")));
    return al.d;
  }
  
  private al l(u paramu)
  {
    Object localObject = paramu.getRequestLine().a();
    if ((!"PUT".equals(localObject)) && (!"DELETE".equals(localObject))) {}
    do
    {
      do
      {
        return null;
        localObject = paramu.getFirstHeader("If-Match");
        if (localObject == null) {
          break;
        }
      } while (!((cz.msebera.android.httpclient.f)localObject).d().startsWith("W/"));
      return al.c;
      paramu = paramu.getFirstHeader("If-None-Match");
    } while ((paramu == null) || (!paramu.d().startsWith("W/")));
    return al.c;
  }
  
  private al m(u paramu)
  {
    paramu = paramu.getHeaders("Cache-Control");
    int k = paramu.length;
    int i = 0;
    while (i < k)
    {
      cz.msebera.android.httpclient.g[] arrayOfg = paramu[i].e();
      int m = arrayOfg.length;
      int j = 0;
      while (j < m)
      {
        cz.msebera.android.httpclient.g localg = arrayOfg[j];
        if (("no-cache".equalsIgnoreCase(localg.a())) && (localg.b() != null)) {
          return al.e;
        }
        j += 1;
      }
      i += 1;
    }
    return null;
  }
  
  public x a(al paramal)
  {
    switch (1.a[paramal.ordinal()])
    {
    default: 
      throw new IllegalStateException("The request was compliant, therefore no error can be generated for it.");
    case 1: 
      return new j(new p(ac.d, 411, ""));
    case 2: 
      return new j(new p(ac.d, 400, "Weak eTag not compatible with byte range"));
    case 3: 
      return new j(new p(ac.d, 400, "Weak eTag not compatible with PUT or DELETE requests"));
    }
    return new j(new p(ac.d, 400, "No-Cache directive MUST NOT include a field name"));
  }
  
  public List<al> a(u paramu)
  {
    ArrayList localArrayList = new ArrayList();
    al localal = k(paramu);
    if (localal != null) {
      localArrayList.add(localal);
    }
    if (!this.a)
    {
      localal = l(paramu);
      if (localal != null) {
        localArrayList.add(localal);
      }
    }
    paramu = m(paramu);
    if (paramu != null) {
      localArrayList.add(paramu);
    }
    return localArrayList;
  }
  
  public void a(cz.msebera.android.httpclient.b.d.o paramo)
    throws cz.msebera.android.httpclient.b.f
  {
    if (e(paramo)) {
      ((cz.msebera.android.httpclient.o)paramo).setEntity(null);
    }
    h(paramo);
    g(paramo);
    f(paramo);
    d(paramo);
    if ((c(paramo)) || (b(paramo))) {
      paramo.a(ac.d);
    }
  }
  
  protected boolean b(u paramu)
  {
    paramu = paramu.getProtocolVersion();
    if (paramu.b() != ac.d.b()) {}
    while (paramu.c() <= ac.d.c()) {
      return false;
    }
    return true;
  }
  
  protected boolean c(u paramu)
  {
    return paramu.getProtocolVersion().b(ac.d) < 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */