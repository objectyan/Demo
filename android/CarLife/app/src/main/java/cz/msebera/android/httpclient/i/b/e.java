package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.i;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Immutable
abstract class e
  implements cz.msebera.android.httpclient.b.c
{
  private static final List<String> b = Collections.unmodifiableList(Arrays.asList(new String[] { "negotiate", "Kerberos", "NTLM", "Digest", "Basic" }));
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final int c;
  private final String d;
  
  e(int paramInt, String paramString)
  {
    this.c = paramInt;
    this.d = paramString;
  }
  
  abstract Collection<String> a(cz.msebera.android.httpclient.b.b.c paramc);
  
  public Queue<cz.msebera.android.httpclient.a.b> a(Map<String, cz.msebera.android.httpclient.f> paramMap, r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p
  {
    cz.msebera.android.httpclient.o.a.a(paramMap, "Map of auth challenges");
    cz.msebera.android.httpclient.o.a.a(paramr, "Host");
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    paramx = cz.msebera.android.httpclient.b.f.c.b(paramg);
    LinkedList localLinkedList = new LinkedList();
    cz.msebera.android.httpclient.d.b localb = paramx.j();
    if (localb == null) {
      this.a.a("Auth scheme registry not set in the context");
    }
    for (;;)
    {
      return localLinkedList;
      i locali = paramx.k();
      if (locali == null)
      {
        this.a.a("Credentials provider not set in the context");
        return localLinkedList;
      }
      Object localObject1 = a(paramx.p());
      paramx = (x)localObject1;
      if (localObject1 == null) {
        paramx = b;
      }
      if (this.a.a()) {
        this.a.a("Authentication schemes in the order of preference: " + paramx);
      }
      paramx = paramx.iterator();
      while (paramx.hasNext())
      {
        Object localObject2 = (String)paramx.next();
        localObject1 = (cz.msebera.android.httpclient.f)paramMap.get(((String)localObject2).toLowerCase(Locale.ENGLISH));
        if (localObject1 != null)
        {
          cz.msebera.android.httpclient.a.f localf = (cz.msebera.android.httpclient.a.f)localb.c((String)localObject2);
          if (localf == null)
          {
            if (this.a.c()) {
              this.a.c("Authentication scheme " + (String)localObject2 + " not supported");
            }
          }
          else
          {
            localObject2 = localf.a(paramg);
            ((cz.msebera.android.httpclient.a.d)localObject2).a((cz.msebera.android.httpclient.f)localObject1);
            localObject1 = locali.a(new h(paramr.a(), paramr.b(), ((cz.msebera.android.httpclient.a.d)localObject2).b(), ((cz.msebera.android.httpclient.a.d)localObject2).a()));
            if (localObject1 != null) {
              localLinkedList.add(new cz.msebera.android.httpclient.a.b((cz.msebera.android.httpclient.a.d)localObject2, (n)localObject1));
            }
          }
        }
        else if (this.a.a())
        {
          this.a.a("Challenge for " + (String)localObject2 + " authentication scheme not available");
        }
      }
    }
  }
  
  public void a(r paramr, cz.msebera.android.httpclient.a.d paramd, cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "Host");
    cz.msebera.android.httpclient.o.a.a(paramd, "Auth scheme");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    cz.msebera.android.httpclient.b.f.c localc = cz.msebera.android.httpclient.b.f.c.b(paramg);
    if (a(paramd))
    {
      cz.msebera.android.httpclient.b.a locala = localc.l();
      paramg = locala;
      if (locala == null)
      {
        paramg = new g();
        localc.a(paramg);
      }
      if (this.a.a()) {
        this.a.a("Caching '" + paramd.a() + "' auth scheme for " + paramr);
      }
      paramg.a(paramr, paramd);
    }
  }
  
  protected boolean a(cz.msebera.android.httpclient.a.d paramd)
  {
    if ((paramd == null) || (!paramd.d())) {}
    do
    {
      return false;
      paramd = paramd.a();
    } while ((!paramd.equalsIgnoreCase("Basic")) && (!paramd.equalsIgnoreCase("Digest")));
    return true;
  }
  
  public boolean a(r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    return paramx.a().b() == this.c;
  }
  
  public Map<String, cz.msebera.android.httpclient.f> b(r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p
  {
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    paramx = paramx.getHeaders(this.d);
    paramg = new HashMap(paramx.length);
    int m = paramx.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = paramx[k];
      int i;
      if ((localObject instanceof cz.msebera.android.httpclient.e))
      {
        paramr = ((cz.msebera.android.httpclient.e)localObject).a();
        i = ((cz.msebera.android.httpclient.e)localObject).b();
      }
      while ((i < paramr.e()) && (cz.msebera.android.httpclient.n.f.a(paramr.a(i))))
      {
        i += 1;
        continue;
        String str = ((cz.msebera.android.httpclient.f)localObject).d();
        if (str == null) {
          throw new p("Header value is null");
        }
        paramr = new cz.msebera.android.httpclient.o.d(str.length());
        paramr.a(str);
        i = 0;
      }
      int j = i;
      while ((j < paramr.e()) && (!cz.msebera.android.httpclient.n.f.a(paramr.a(j)))) {
        j += 1;
      }
      paramg.put(paramr.a(i, j).toLowerCase(Locale.ENGLISH), localObject);
      k += 1;
    }
    return paramg;
  }
  
  public void b(r paramr, cz.msebera.android.httpclient.a.d paramd, cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "Host");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    paramd = cz.msebera.android.httpclient.b.f.c.b(paramg).l();
    if (paramd != null)
    {
      if (this.a.a()) {
        this.a.a("Clearing cached auth scheme for " + paramr);
      }
      paramd.b(paramr);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */