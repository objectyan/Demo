package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.c;
import cz.msebera.android.httpclient.b.i;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.x;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

@Deprecated
@Immutable
class d
  implements c
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final cz.msebera.android.httpclient.b.b b;
  
  public d(cz.msebera.android.httpclient.b.b paramb)
  {
    this.b = paramb;
  }
  
  private boolean a(cz.msebera.android.httpclient.a.d paramd)
  {
    if ((paramd == null) || (!paramd.d())) {}
    do
    {
      return false;
      paramd = paramd.a();
    } while ((!paramd.equalsIgnoreCase("Basic")) && (!paramd.equalsIgnoreCase("Digest")));
    return true;
  }
  
  public cz.msebera.android.httpclient.b.b a()
  {
    return this.b;
  }
  
  public Queue<cz.msebera.android.httpclient.a.b> a(Map<String, f> paramMap, r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p
  {
    cz.msebera.android.httpclient.o.a.a(paramMap, "Map of auth challenges");
    cz.msebera.android.httpclient.o.a.a(paramr, "Host");
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    LinkedList localLinkedList = new LinkedList();
    i locali = (i)paramg.a("http.auth.credentials-provider");
    if (locali == null) {
      this.a.a("Credentials provider not set in the context");
    }
    do
    {
      for (;;)
      {
        return localLinkedList;
        try
        {
          paramx = this.b.a(paramMap, paramx, paramg);
          paramx.a((f)paramMap.get(paramx.a().toLowerCase(Locale.ENGLISH)));
          paramMap = locali.a(new h(paramr.a(), paramr.b(), paramx.b(), paramx.a()));
          if (paramMap != null)
          {
            localLinkedList.add(new cz.msebera.android.httpclient.a.b(paramx, paramMap));
            return localLinkedList;
          }
        }
        catch (j paramMap) {}
      }
    } while (!this.a.c());
    this.a.c(paramMap.getMessage(), paramMap);
    return localLinkedList;
  }
  
  public void a(r paramr, cz.msebera.android.httpclient.a.d paramd, cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.b.a locala = (cz.msebera.android.httpclient.b.a)paramg.a("http.auth.auth-cache");
    if (a(paramd))
    {
      Object localObject = locala;
      if (locala == null)
      {
        localObject = new g();
        paramg.a("http.auth.auth-cache", localObject);
      }
      if (this.a.a()) {
        this.a.a("Caching '" + paramd.a() + "' auth scheme for " + paramr);
      }
      ((cz.msebera.android.httpclient.b.a)localObject).a(paramr, paramd);
    }
  }
  
  public boolean a(r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
  {
    return this.b.a(paramx, paramg);
  }
  
  public Map<String, f> b(r paramr, x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p
  {
    return this.b.b(paramx, paramg);
  }
  
  public void b(r paramr, cz.msebera.android.httpclient.a.d paramd, cz.msebera.android.httpclient.n.g paramg)
  {
    paramg = (cz.msebera.android.httpclient.b.a)paramg.a("http.auth.auth-cache");
    if (paramg == null) {
      return;
    }
    if (this.a.a()) {
      this.a.a("Removing from cache '" + paramd.a() + "' auth scheme for " + paramr);
    }
    paramg.b(paramr);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */