package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.a.g;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.b.a.m;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class c
  implements ad
{
  private static final Set<String> b = new HashSet(Arrays.asList(new String[] { "HEAD", "GET", "OPTIONS", "TRACE" }));
  public b a = new b(getClass());
  private final j c;
  private final m d;
  private final long e;
  private final h f;
  private final n g;
  private final g h;
  private final cz.msebera.android.httpclient.b.a.h i;
  
  public c()
  {
    this(f.m);
  }
  
  public c(m paramm, cz.msebera.android.httpclient.b.a.h paramh, f paramf)
  {
    this(paramm, paramh, paramf, new j());
  }
  
  public c(m paramm, cz.msebera.android.httpclient.b.a.h paramh, f paramf, j paramj)
  {
    this(paramm, paramh, paramf, paramj, new i(paramj, paramh));
  }
  
  public c(m paramm, cz.msebera.android.httpclient.b.a.h paramh, f paramf, j paramj, g paramg)
  {
    this.d = paramm;
    this.c = paramj;
    this.f = new h(paramm);
    this.e = paramf.b();
    this.g = new n();
    this.i = paramh;
    this.h = paramg;
  }
  
  public c(f paramf)
  {
    this(new ac(), new d(paramf), paramf);
  }
  
  private void a(String paramString1, String paramString2, Map<String, as> paramMap)
    throws IOException
  {
    cz.msebera.android.httpclient.b.a.d locald = this.i.a(paramString2);
    if (locald == null) {}
    cz.msebera.android.httpclient.f localf;
    do
    {
      return;
      localf = locald.a("ETag");
    } while (localf == null);
    paramMap.put(localf.d(), new as(paramString1, paramString2, locald));
  }
  
  public cz.msebera.android.httpclient.b.a.d a(r paramr, u paramu, cz.msebera.android.httpclient.b.a.d paramd, x paramx, Date paramDate1, Date paramDate2)
    throws IOException
  {
    paramd = this.f.a(paramu.getRequestLine().c(), paramd, paramDate1, paramDate2, paramx);
    a(paramr, paramu, paramd);
    return paramd;
  }
  
  public cz.msebera.android.httpclient.b.a.d a(r paramr, u paramu, cz.msebera.android.httpclient.b.a.d paramd, x paramx, Date paramDate1, Date paramDate2, String paramString)
    throws IOException
  {
    paramr = this.f.a(paramu.getRequestLine().c(), paramd, paramDate1, paramDate2, paramx);
    this.i.a(paramString, paramr);
    return paramr;
  }
  
  cz.msebera.android.httpclient.b.a.d a(String paramString1, cz.msebera.android.httpclient.b.a.d paramd1, cz.msebera.android.httpclient.b.a.d paramd2, String paramString2, String paramString3)
    throws IOException
  {
    cz.msebera.android.httpclient.b.a.d locald = paramd1;
    paramd1 = locald;
    if (locald == null) {
      paramd1 = paramd2;
    }
    paramd2 = null;
    if (paramd1.i() != null) {
      paramd2 = this.d.a(paramString1, paramd1.i());
    }
    paramString1 = new HashMap(paramd1.k());
    paramString1.put(paramString2, paramString3);
    return new cz.msebera.android.httpclient.b.a.d(paramd1.e(), paramd1.f(), paramd1.a(), paramd1.g(), paramd2, paramString1);
  }
  
  public cz.msebera.android.httpclient.b.d.c a(r paramr, u paramu, cz.msebera.android.httpclient.b.d.c paramc, Date paramDate1, Date paramDate2)
    throws IOException
  {
    int k = 1;
    Object localObject = a(paramu, paramc);
    int j = k;
    try
    {
      ((ar)localObject).a();
      j = k;
      if (((ar)localObject).b())
      {
        j = 0;
        paramu = ((ar)localObject).d();
        paramr = paramu;
        if (0 != 0)
        {
          paramc.close();
          paramr = paramu;
        }
      }
      do
      {
        do
        {
          return paramr;
          j = k;
          localObject = ((ar)localObject).c();
          j = k;
          if (!a(paramc, (l)localObject)) {
            break;
          }
          j = k;
          paramu = b(paramc, (l)localObject);
          paramr = paramu;
        } while (1 == 0);
        paramc.close();
        return paramu;
        j = k;
        paramDate1 = new cz.msebera.android.httpclient.b.a.d(paramDate1, paramDate2, paramc.a(), paramc.getAllHeaders(), (l)localObject);
        j = k;
        a(paramr, paramu, paramDate1);
        j = k;
        paramu = this.g.a(paramDate1);
        paramr = paramu;
      } while (1 == 0);
      paramc.close();
      return paramu;
    }
    finally
    {
      if (j != 0) {
        paramc.close();
      }
    }
  }
  
  ar a(u paramu, cz.msebera.android.httpclient.b.d.c paramc)
  {
    return new ar(this.d, this.e, paramu, paramc);
  }
  
  public x a(r paramr, u paramu, x paramx, Date paramDate1, Date paramDate2)
    throws IOException
  {
    return a(paramr, paramu, aj.a(paramx), paramDate1, paramDate2);
  }
  
  public void a(r paramr, u paramu)
    throws IOException
  {
    if (!b.contains(paramu.getRequestLine().a()))
    {
      paramr = this.c.a(paramr, paramu);
      this.i.b(paramr);
    }
  }
  
  void a(r paramr, u paramu, cz.msebera.android.httpclient.b.a.d paramd)
    throws IOException
  {
    if (paramd.j())
    {
      c(paramr, paramu, paramd);
      return;
    }
    b(paramr, paramu, paramd);
  }
  
  public void a(r paramr, final u paramu, as paramas)
    throws IOException
  {
    paramr = this.c.a(paramr, paramu);
    final cz.msebera.android.httpclient.b.a.d locald = paramas.c();
    paramu = new cz.msebera.android.httpclient.b.a.i()
    {
      public cz.msebera.android.httpclient.b.a.d a(cz.msebera.android.httpclient.b.a.d paramAnonymousd)
        throws IOException
      {
        return c.this.a(paramu.getRequestLine().c(), paramAnonymousd, locald, this.c, this.d);
      }
    };
    try
    {
      this.i.a(paramr, paramu);
      return;
    }
    catch (cz.msebera.android.httpclient.b.a.j paramu)
    {
      this.a.c("Could not update key [" + paramr + "]", paramu);
    }
  }
  
  public void a(r paramr, u paramu, x paramx)
  {
    if (!b.contains(paramu.getRequestLine().a())) {
      this.h.a(paramr, paramu, paramx);
    }
  }
  
  boolean a(x paramx, l paraml)
  {
    int j = paramx.a().b();
    if ((j != 200) && (j != 206)) {}
    for (;;)
    {
      return false;
      paramx = paramx.getFirstHeader("Content-Length");
      if (paramx != null) {
        try
        {
          j = Integer.parseInt(paramx.d());
          if (paraml.b() < j) {
            return true;
          }
        }
        catch (NumberFormatException paramx) {}
      }
    }
    return false;
  }
  
  public cz.msebera.android.httpclient.b.a.d b(r paramr, u paramu)
    throws IOException
  {
    cz.msebera.android.httpclient.b.a.d locald = this.i.a(this.c.a(paramr, paramu));
    if (locald == null) {
      paramr = null;
    }
    do
    {
      return paramr;
      paramr = locald;
    } while (!locald.j());
    paramr = (String)locald.k().get(this.c.a(paramu, locald));
    if (paramr == null) {
      return null;
    }
    return this.i.a(paramr);
  }
  
  cz.msebera.android.httpclient.b.d.c b(x paramx, l paraml)
  {
    int j = Integer.parseInt(paramx.getFirstHeader("Content-Length").d());
    paramx = new cz.msebera.android.httpclient.k.j(cz.msebera.android.httpclient.ac.d, 502, "Bad Gateway");
    paramx.setHeader("Content-Type", "text/plain;charset=UTF-8");
    paraml = String.format("Received incomplete response with Content-Length %d but actual body length %d", new Object[] { Integer.valueOf(j), Long.valueOf(paraml.b()) }).getBytes();
    paramx.setHeader("Content-Length", Integer.toString(paraml.length));
    paramx.a(new cz.msebera.android.httpclient.g.d(paraml));
    return aj.a(paramx);
  }
  
  void b(r paramr, u paramu, cz.msebera.android.httpclient.b.a.d paramd)
    throws IOException
  {
    paramr = this.c.a(paramr, paramu);
    this.i.a(paramr, paramd);
  }
  
  public void c(r paramr, u paramu)
    throws IOException
  {
    this.h.a(paramr, paramu);
  }
  
  void c(final r paramr, final u paramu, final cz.msebera.android.httpclient.b.a.d paramd)
    throws IOException
  {
    String str = this.c.a(paramr, paramu);
    paramr = this.c.a(paramr, paramu, paramd);
    this.i.a(paramr, paramd);
    paramr = new cz.msebera.android.httpclient.b.a.i()
    {
      public cz.msebera.android.httpclient.b.a.d a(cz.msebera.android.httpclient.b.a.d paramAnonymousd)
        throws IOException
      {
        return c.this.a(paramu.getRequestLine().c(), paramAnonymousd, paramd, c.a(c.this).a(paramu, paramd), paramr);
      }
    };
    try
    {
      this.i.a(str, paramr);
      return;
    }
    catch (cz.msebera.android.httpclient.b.a.j paramr)
    {
      this.a.c("Could not update key [" + str + "]", paramr);
    }
  }
  
  public Map<String, as> d(r paramr, u paramu)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    paramr = this.i.a(this.c.a(paramr, paramu));
    if ((paramr == null) || (!paramr.j())) {}
    for (;;)
    {
      return localHashMap;
      paramr = paramr.k().entrySet().iterator();
      while (paramr.hasNext())
      {
        paramu = (Map.Entry)paramr.next();
        a((String)paramu.getKey(), (String)paramu.getValue(), localHashMap);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */