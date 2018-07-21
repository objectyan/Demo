package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.h;
import cz.msebera.android.httpclient.k.j;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class p
  implements cz.msebera.android.httpclient.i.f.b
{
  private static final boolean b = false;
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final AtomicLong c = new AtomicLong();
  private final AtomicLong d = new AtomicLong();
  private final AtomicLong e = new AtomicLong();
  private final Map<cz.msebera.android.httpclient.ak, String> f = new HashMap(4);
  private final f g;
  private final cz.msebera.android.httpclient.i.f.b h;
  private final ad i;
  private final l j;
  private final n k;
  private final m l;
  private final o m;
  private final t n;
  private final ao o;
  private final ak p;
  private final an q;
  private final b r;
  
  public p(cz.msebera.android.httpclient.i.f.b paramb)
  {
    this(paramb, new c(), f.m);
  }
  
  public p(cz.msebera.android.httpclient.i.f.b paramb, cz.msebera.android.httpclient.b.a.m paramm, h paramh, f paramf)
  {
    this(paramb, new c(paramm, paramh, paramf), paramf);
  }
  
  public p(cz.msebera.android.httpclient.i.f.b paramb, ad paramad, f paramf)
  {
    this(paramb, paramad, paramf, null);
  }
  
  public p(cz.msebera.android.httpclient.i.f.b paramb, ad paramad, f paramf, b paramb1)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP backend");
    cz.msebera.android.httpclient.o.a.a(paramad, "HttpCache");
    if (paramf != null) {}
    for (;;)
    {
      this.g = paramf;
      this.h = paramb;
      this.i = paramad;
      this.j = new l();
      this.k = new n(this.j);
      this.l = new m();
      this.m = new o(this.j, this.g);
      this.n = new t();
      this.o = new ao();
      this.p = new ak(this.g.g());
      this.q = new an(this.g.b(), this.g.k(), this.g.c(), this.g.f());
      this.r = paramb1;
      return;
      paramf = f.m;
    }
  }
  
  p(cz.msebera.android.httpclient.i.f.b paramb, ad paramad, l paraml, an paraman, n paramn, m paramm, o paramo, t paramt, ao paramao, ak paramak, f paramf, b paramb1)
  {
    if (paramf != null) {}
    for (;;)
    {
      this.g = paramf;
      this.h = paramb;
      this.i = paramad;
      this.j = paraml;
      this.q = paraman;
      this.k = paramn;
      this.l = paramm;
      this.m = paramo;
      this.n = paramt;
      this.o = paramao;
      this.p = paramak;
      this.r = paramb1;
      return;
      paramf = f.m;
    }
  }
  
  private d a(r paramr, cz.msebera.android.httpclient.b.d.o paramo)
  {
    try
    {
      paramr = this.i.b(paramr, paramo);
      return paramr;
    }
    catch (IOException paramr)
    {
      this.a.c("Unable to retrieve entries from cache", paramr);
    }
    return null;
  }
  
  private d a(r paramr, cz.msebera.android.httpclient.b.d.o paramo, Date paramDate1, Date paramDate2, cz.msebera.android.httpclient.b.d.c paramc, as paramas, d paramd)
    throws IOException
  {
    try
    {
      paramr = this.i.a(paramr, paramo, paramd, paramc, paramDate1, paramDate2, paramas.b());
      return paramr;
    }
    catch (IOException paramr)
    {
      this.a.c("Could not update cache entry", paramr);
      return paramd;
    }
    finally
    {
      paramc.close();
    }
  }
  
  private cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.n.g paramg, d paramd, Date paramDate)
  {
    if ((paramo.containsHeader("If-None-Match")) || (paramo.containsHeader("If-Modified-Since"))) {}
    for (paramo = this.k.b(paramd);; paramo = this.k.a(paramd))
    {
      a(paramg, cz.msebera.android.httpclient.b.a.a.b);
      if (this.j.e(paramd, paramDate) > 0L) {
        paramo.addHeader("Warning", "110 localhost \"Response is stale\"");
      }
      return paramo;
    }
  }
  
  private cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, d paramd, Date paramDate)
    throws cz.msebera.android.httpclient.p
  {
    try
    {
      if ((this.r != null) && (!a(paramo, paramd, paramDate)) && (this.j.c(paramd, paramDate)))
      {
        this.a.e("Serving stale with asynchronous revalidation");
        cz.msebera.android.httpclient.b.d.c localc = a(paramo, paramc, paramd, paramDate);
        this.r.a(this, paramb, paramo, paramc, paramg, paramd);
        return localc;
      }
      paramb = a(paramb, paramo, paramc, paramg, paramd);
      return paramb;
    }
    catch (IOException paramb) {}
    return b(paramo, paramc, paramd, paramDate);
  }
  
  private cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.n.g paramg, d paramd)
  {
    paramd = this.k.a(paramd);
    a(paramg, cz.msebera.android.httpclient.b.a.a.b);
    paramd.addHeader("Warning", "111 localhost \"Revalidation failed\"");
    return paramd;
  }
  
  private x a(cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.n.g paramg)
  {
    Object localObject = null;
    Iterator localIterator = this.p.a(paramo).iterator();
    for (paramo = (cz.msebera.android.httpclient.b.d.o)localObject; localIterator.hasNext(); paramo = this.p.a(paramo))
    {
      paramo = (al)localIterator.next();
      a(paramg, cz.msebera.android.httpclient.b.a.a.a);
    }
    return paramo;
  }
  
  private String a(cz.msebera.android.httpclient.t paramt)
  {
    cz.msebera.android.httpclient.ak localak = paramt.getProtocolVersion();
    paramt = (String)this.f.get(localak);
    if (paramt != null) {
      return paramt;
    }
    paramt = cz.msebera.android.httpclient.o.l.a("cz.msebera.android.httpclient.client", getClass().getClassLoader());
    if (paramt != null)
    {
      paramt = paramt.c();
      if (!"http".equalsIgnoreCase(localak.a())) {
        break label119;
      }
    }
    label119:
    for (paramt = String.format("%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[] { Integer.valueOf(localak.b()), Integer.valueOf(localak.c()), paramt });; paramt = String.format("%s/%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[] { localak.a(), Integer.valueOf(localak.b()), Integer.valueOf(localak.c()), paramt }))
    {
      this.f.put(localak, paramt);
      return paramt;
      paramt = "UNAVAILABLE";
      break;
    }
  }
  
  private void a(cz.msebera.android.httpclient.n.g paramg)
  {
    this.e.getAndIncrement();
    a(paramg, cz.msebera.android.httpclient.b.a.a.d);
  }
  
  private void a(cz.msebera.android.httpclient.n.g paramg, cz.msebera.android.httpclient.b.a.a parama)
  {
    if (paramg != null) {
      paramg.a("http.cache.response.status", parama);
    }
  }
  
  private void a(r paramr, cz.msebera.android.httpclient.b.d.o paramo, as paramas)
  {
    try
    {
      this.i.a(paramr, paramo, paramas);
      return;
    }
    catch (IOException paramr)
    {
      this.a.c("Could not update cache entry to reuse variant", paramr);
    }
  }
  
  private void a(u paramu, x paramx)
  {
    if (paramx.a().b() == 304)
    {
      paramu = paramu.getFirstHeader("If-Modified-Since");
      if (paramu != null) {
        paramx.addHeader("Last-Modified", paramu.d());
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 500) || (paramInt == 502) || (paramInt == 503) || (paramInt == 504);
  }
  
  private boolean a(cz.msebera.android.httpclient.b.d.o paramo)
  {
    paramo = paramo.getHeaders("Cache-Control");
    int i3 = paramo.length;
    int i1 = 0;
    while (i1 < i3)
    {
      cz.msebera.android.httpclient.g[] arrayOfg = paramo[i1].e();
      int i4 = arrayOfg.length;
      int i2 = 0;
      while (i2 < i4)
      {
        if ("only-if-cached".equals(arrayOfg[i2].a()))
        {
          this.a.e("Request marked only-if-cached");
          return false;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean a(cz.msebera.android.httpclient.b.d.o paramo, d paramd)
  {
    return (this.m.a(paramo)) && (this.m.a(paramo, paramd, new Date()));
  }
  
  private boolean a(cz.msebera.android.httpclient.b.d.o paramo, d paramd, Date paramDate)
  {
    return (this.j.c(paramd)) || ((this.g.k()) && (this.j.d(paramd))) || (b(paramo, paramd, paramDate));
  }
  
  private boolean a(r paramr, cz.msebera.android.httpclient.b.d.o paramo, x paramx)
  {
    Object localObject = null;
    try
    {
      paramr = this.i.b(paramr, paramo);
      if (paramr == null) {}
      do
      {
        do
        {
          do
          {
            return false;
            paramr = paramr.a("Date");
          } while (paramr == null);
          paramo = paramx.getFirstHeader("Date");
        } while (paramo == null);
        paramr = cz.msebera.android.httpclient.b.g.b.a(paramr.d());
        paramo = cz.msebera.android.httpclient.b.g.b.a(paramo.d());
      } while ((paramr == null) || (paramo == null));
      return paramo.before(paramr);
    }
    catch (IOException paramr)
    {
      for (;;)
      {
        paramr = (r)localObject;
      }
    }
  }
  
  private boolean a(x paramx, d paramd)
  {
    paramd = paramd.a("Date");
    paramx = paramx.getFirstHeader("Date");
    if ((paramd != null) && (paramx != null))
    {
      paramd = cz.msebera.android.httpclient.b.g.b.a(paramd.d());
      paramx = cz.msebera.android.httpclient.b.g.b.a(paramx.d());
      if ((paramd != null) && (paramx != null)) {
        break label56;
      }
    }
    label56:
    while (!paramx.before(paramd)) {
      return false;
    }
    return true;
  }
  
  private cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.n.g paramg, d paramd, Date paramDate)
  {
    if (a(paramo, paramd, paramDate)) {
      return b(paramg);
    }
    return a(paramg, paramd);
  }
  
  private cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, d paramd)
    throws IOException, cz.msebera.android.httpclient.p
  {
    r localr = paramc.v();
    d(localr, paramo);
    Date localDate = e();
    if (this.m.a(localr, paramo, paramd, localDate)) {
      this.a.a("Cache hit");
    }
    for (paramg = a(paramo, paramc, paramd, localDate);; paramg = b(paramc))
    {
      paramc.a("http.route", paramb);
      paramc.a("http.target_host", localr);
      paramc.a("http.request", paramo);
      paramc.a("http.response", paramg);
      paramc.a("http.request_sent", Boolean.TRUE);
      return paramg;
      if (a(paramo)) {
        break;
      }
      this.a.a("Cache entry not suitable but only-if-cached requested");
    }
    if ((paramd.d() != 304) || (this.m.a(paramo)))
    {
      this.a.a("Revalidating cache entry");
      return a(paramb, paramo, paramc, paramg, paramd, localDate);
    }
    this.a.a("Cache entry not usable; calling backend");
    return b(paramb, paramo, paramc, paramg);
  }
  
  private cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.n.g paramg)
  {
    a(paramg, cz.msebera.android.httpclient.b.a.a.a);
    return aj.a(new j(ac.d, 504, "Gateway Timeout"));
  }
  
  private Map<String, as> b(r paramr, cz.msebera.android.httpclient.b.d.o paramo)
  {
    try
    {
      paramr = this.i.d(paramr, paramo);
      return paramr;
    }
    catch (IOException paramr)
    {
      this.a.c("Unable to retrieve variant entries from cache", paramr);
    }
    return null;
  }
  
  private boolean b(cz.msebera.android.httpclient.b.d.o paramo, d paramd, Date paramDate)
  {
    paramo = paramo.getHeaders("Cache-Control");
    int i3 = paramo.length;
    int i1 = 0;
    while (i1 < i3)
    {
      cz.msebera.android.httpclient.g[] arrayOfg = paramo[i1].e();
      int i4 = arrayOfg.length;
      int i2 = 0;
      while (i2 < i4)
      {
        cz.msebera.android.httpclient.g localg = arrayOfg[i2];
        if ("max-stale".equals(localg.a())) {
          try
          {
            int i5 = Integer.parseInt(localg.b());
            long l1 = this.j.a(paramd, paramDate);
            long l2 = this.j.a(paramd);
            if (l1 - l2 <= i5) {
              break label155;
            }
            return true;
          }
          catch (NumberFormatException paramo)
          {
            return true;
          }
        } else if (("min-fresh".equals(localg.a())) || ("max-age".equals(localg.a()))) {
          return true;
        }
        label155:
        i2 += 1;
      }
      i1 += 1;
    }
    return false;
  }
  
  private cz.msebera.android.httpclient.b.d.c c(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, cz.msebera.android.httpclient.p
  {
    Object localObject = paramc.v();
    c((r)localObject, paramo);
    if (!a(paramo)) {
      return aj.a(new j(ac.d, 504, "Gateway Timeout"));
    }
    localObject = b((r)localObject, paramo);
    if ((localObject != null) && (((Map)localObject).size() > 0)) {
      return a(paramb, paramo, paramc, paramg, (Map)localObject);
    }
    return b(paramb, paramo, paramc, paramg);
  }
  
  private cz.msebera.android.httpclient.b.d.c c(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, d paramd)
    throws IOException, cz.msebera.android.httpclient.p
  {
    return b(paramb, this.n.b(paramo, paramd), paramc, paramg);
  }
  
  private void c(r paramr, cz.msebera.android.httpclient.b.d.o paramo)
  {
    this.d.getAndIncrement();
    if (this.a.e())
    {
      paramo = paramo.getRequestLine();
      this.a.e("Cache miss [host: " + paramr + "; uri: " + paramo.c() + "]");
    }
  }
  
  private void d(r paramr, cz.msebera.android.httpclient.b.d.o paramo)
  {
    this.c.getAndIncrement();
    if (this.a.e())
    {
      paramo = paramo.getRequestLine();
      this.a.e("Cache hit [host: " + paramr + "; uri: " + paramo.c() + "]");
    }
  }
  
  private void e(r paramr, cz.msebera.android.httpclient.b.d.o paramo)
  {
    try
    {
      this.i.c(paramr, paramo);
      return;
    }
    catch (IOException paramr)
    {
      this.a.c("Unable to flush invalidated entries from cache", paramr);
    }
  }
  
  public long a()
  {
    return this.c.get();
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo)
    throws IOException, cz.msebera.android.httpclient.p
  {
    return a(paramb, paramo, cz.msebera.android.httpclient.b.f.c.c(), null);
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc)
    throws IOException, cz.msebera.android.httpclient.p
  {
    return a(paramb, paramo, paramc, null);
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, cz.msebera.android.httpclient.p
  {
    Object localObject = paramc.v();
    String str = a(paramo.a());
    a(paramc, cz.msebera.android.httpclient.b.a.a.c);
    if (a(paramo))
    {
      a(paramc, cz.msebera.android.httpclient.b.a.a.a);
      return aj.a(new ai());
    }
    x localx = a(paramo, paramc);
    if (localx != null) {
      return aj.a(localx);
    }
    this.p.a(paramo);
    paramo.addHeader("Via", str);
    e(paramc.v(), paramo);
    if (!this.l.a(paramo))
    {
      this.a.a("Request is not servable from cache");
      return b(paramb, paramo, paramc, paramg);
    }
    localObject = a((r)localObject, paramo);
    if (localObject == null)
    {
      this.a.a("Cache miss");
      return c(paramb, paramo, paramc, paramg);
    }
    return b(paramb, paramo, paramc, paramg, (d)localObject);
  }
  
  cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, d paramd)
    throws IOException, cz.msebera.android.httpclient.p
  {
    cz.msebera.android.httpclient.b.d.o localo = this.n.a(paramo, paramd);
    Object localObject = localo.getURI();
    if (localObject != null) {}
    Date localDate1;
    Date localDate2;
    int i1;
    try
    {
      localo.a(ag.a((URI)localObject, paramb));
      localDate1 = e();
      cz.msebera.android.httpclient.b.d.c localc = this.h.a(paramb, localo, paramc, paramg);
      localDate2 = e();
      localObject = localc;
      if (a(localc, paramd))
      {
        localc.close();
        localObject = this.n.b(paramo, paramd);
        localDate1 = e();
        localObject = this.h.a(paramb, (cz.msebera.android.httpclient.b.d.o)localObject, paramc, paramg);
        localDate2 = e();
      }
      ((cz.msebera.android.httpclient.b.d.c)localObject).addHeader("Via", a((cz.msebera.android.httpclient.t)localObject));
      i1 = ((cz.msebera.android.httpclient.b.d.c)localObject).a().b();
      if ((i1 == 304) || (i1 == 200)) {
        a(paramc);
      }
      if (i1 != 304) {
        break label288;
      }
      paramb = this.i.a(paramc.v(), paramo, paramd, (x)localObject, localDate1, localDate2);
      if ((this.m.a(paramo)) && (this.m.a(paramo, paramb, new Date()))) {
        return this.k.b(paramb);
      }
    }
    catch (URISyntaxException paramb)
    {
      throw new cz.msebera.android.httpclient.aj("Invalid URI: " + localObject, paramb);
    }
    return this.k.a(paramb);
    label288:
    if ((a(i1)) && (!a(paramo, paramd, e())) && (this.j.a(paramo, paramd, localDate2))) {
      try
      {
        paramb = this.k.a(paramd);
        paramb.addHeader("Warning", "110 localhost \"Response is stale\"");
        return paramb;
      }
      finally
      {
        ((cz.msebera.android.httpclient.b.d.c)localObject).close();
      }
    }
    return a(paramb, localo, paramc, paramg, localDate1, localDate2, (cz.msebera.android.httpclient.b.d.c)localObject);
  }
  
  cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, Date paramDate1, Date paramDate2, cz.msebera.android.httpclient.b.d.c paramc1)
    throws IOException
  {
    this.a.e("Handling Backend response");
    this.o.a(paramo, paramc1);
    paramc = paramc.v();
    boolean bool = this.q.a(paramo, paramc1);
    this.i.a(paramc, paramo, paramc1);
    if ((bool) && (!a(paramc, paramo, paramc1)))
    {
      a(paramo, paramc1);
      paramb = this.i.a(paramc, paramo, paramc1, paramDate1, paramDate2);
    }
    do
    {
      return paramb;
      paramb = paramc1;
    } while (bool);
    try
    {
      this.i.a(paramc, paramo);
      return paramc1;
    }
    catch (IOException paramb)
    {
      this.a.c("Unable to flush invalid cache entries", paramb);
    }
    return paramc1;
  }
  
  cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, Map<String, as> paramMap)
    throws IOException, cz.msebera.android.httpclient.p
  {
    cz.msebera.android.httpclient.b.d.o localo = this.n.a(paramo, paramMap);
    Date localDate1 = e();
    cz.msebera.android.httpclient.b.d.c localc = this.h.a(paramb, localo, paramc, paramg);
    try
    {
      Date localDate2 = e();
      localc.addHeader("Via", a(localc));
      if (localc.a().b() != 304) {
        return a(paramb, paramo, paramc, paramg, localDate1, localDate2, localc);
      }
      Object localObject = localc.getFirstHeader("ETag");
      if (localObject == null)
      {
        this.a.c("304 response did not contain ETag");
        ae.a(localc.b());
        localc.close();
        return b(paramb, paramo, paramc, paramg);
      }
      paramMap = (as)paramMap.get(((cz.msebera.android.httpclient.f)localObject).d());
      if (paramMap == null)
      {
        this.a.a("304 response did not contain ETag matching one sent in If-None-Match");
        ae.a(localc.b());
        localc.close();
        return b(paramb, paramo, paramc, paramg);
      }
      localObject = paramMap.c();
      if (a(localc, (d)localObject))
      {
        ae.a(localc.b());
        localc.close();
        return c(paramb, paramo, paramc, paramg, (d)localObject);
      }
      a(paramc);
      paramb = a(paramc.v(), localo, localDate1, localDate2, localc, paramMap, (d)localObject);
      localc.close();
      paramg = this.k.a(paramb);
      a(paramc.v(), paramo, paramMap);
      if (a(paramo, paramb))
      {
        paramb = this.k.b(paramb);
        return paramb;
      }
    }
    catch (IOException paramb)
    {
      localc.close();
      throw paramb;
    }
    catch (RuntimeException paramb)
    {
      localc.close();
      throw paramb;
    }
    return paramg;
  }
  
  boolean a(u paramu)
  {
    am localam = paramu.getRequestLine();
    if (!"OPTIONS".equals(localam.a())) {}
    while ((!"*".equals(localam.c())) || (!"0".equals(paramu.getFirstHeader("Max-Forwards").d()))) {
      return false;
    }
    return true;
  }
  
  public long b()
  {
    return this.d.get();
  }
  
  cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, cz.msebera.android.httpclient.p
  {
    Date localDate = e();
    this.a.e("Calling the backend");
    cz.msebera.android.httpclient.b.d.c localc = this.h.a(paramb, paramo, paramc, paramg);
    try
    {
      localc.addHeader("Via", a(localc));
      paramb = a(paramb, paramo, paramc, paramg, localDate, e(), localc);
      return paramb;
    }
    catch (IOException paramb)
    {
      localc.close();
      throw paramb;
    }
    catch (RuntimeException paramb)
    {
      localc.close();
      throw paramb;
    }
  }
  
  public long c()
  {
    return this.e.get();
  }
  
  public boolean d()
  {
    return false;
  }
  
  Date e()
  {
    return new Date();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */