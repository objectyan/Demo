package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e;
import cz.msebera.android.httpclient.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Deprecated
@Immutable
public abstract class b
  implements cz.msebera.android.httpclient.b.b
{
  private static final List<String> b = Collections.unmodifiableList(Arrays.asList(new String[] { "negotiate", "NTLM", "Digest", "Basic" }));
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  
  public cz.msebera.android.httpclient.a.d a(Map<String, cz.msebera.android.httpclient.f> paramMap, x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws j
  {
    cz.msebera.android.httpclient.a.g localg = (cz.msebera.android.httpclient.a.g)paramg.a("http.authscheme-registry");
    cz.msebera.android.httpclient.o.b.a(localg, "AuthScheme registry");
    List localList = c(paramx, paramg);
    paramg = localList;
    if (localList == null) {
      paramg = b;
    }
    if (this.a.a()) {
      this.a.a("Authentication schemes in the order of preference: " + paramg);
    }
    localList = null;
    Iterator localIterator = paramg.iterator();
    for (;;)
    {
      paramg = localList;
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((cz.msebera.android.httpclient.f)paramMap.get(str.toLowerCase(Locale.ENGLISH)) == null) {
          break label260;
        }
        if (this.a.a()) {
          this.a.a(str + " authentication scheme selected");
        }
      }
      try
      {
        paramg = localg.a(str, paramx.getParams());
        if (paramg != null) {
          break;
        }
        throw new j("Unable to respond to any of these challenges: " + paramMap);
      }
      catch (IllegalStateException paramg) {}
      if (this.a.c())
      {
        this.a.c("Authentication scheme " + str + " not supported");
        continue;
        label260:
        if (this.a.a()) {
          this.a.a("Challenge for " + str + " authentication scheme not available");
        }
      }
    }
    return paramg;
  }
  
  protected List<String> a()
  {
    return b;
  }
  
  protected Map<String, cz.msebera.android.httpclient.f> a(cz.msebera.android.httpclient.f[] paramArrayOff)
    throws p
  {
    HashMap localHashMap = new HashMap(paramArrayOff.length);
    int m = paramArrayOff.length;
    int k = 0;
    while (k < m)
    {
      cz.msebera.android.httpclient.f localf = paramArrayOff[k];
      cz.msebera.android.httpclient.o.d locald;
      int i;
      if ((localf instanceof e))
      {
        locald = ((e)localf).a();
        i = ((e)localf).b();
      }
      while ((i < locald.e()) && (cz.msebera.android.httpclient.n.f.a(locald.a(i))))
      {
        i += 1;
        continue;
        String str = localf.d();
        if (str == null) {
          throw new p("Header value is null");
        }
        locald = new cz.msebera.android.httpclient.o.d(str.length());
        locald.a(str);
        i = 0;
      }
      int j = i;
      while ((j < locald.e()) && (!cz.msebera.android.httpclient.n.f.a(locald.a(j)))) {
        j += 1;
      }
      localHashMap.put(locald.a(i, j).toLowerCase(Locale.ENGLISH), localf);
      k += 1;
    }
    return localHashMap;
  }
  
  protected List<String> c(x paramx, cz.msebera.android.httpclient.n.g paramg)
  {
    return a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */