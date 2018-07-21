package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Immutable
class t
{
  public o a(o paramo, d paramd)
    throws aj
  {
    o localo = o.a(paramo.a());
    localo.setHeaders(paramo.getAllHeaders());
    paramo = paramd.a("ETag");
    if (paramo != null) {
      localo.setHeader("If-None-Match", paramo.d());
    }
    paramo = paramd.a("Last-Modified");
    if (paramo != null) {
      localo.setHeader("If-Modified-Since", paramo.d());
    }
    int j = 0;
    paramo = paramd.b("Cache-Control");
    int n = paramo.length;
    int i = 0;
    if (i < n)
    {
      paramd = paramo[i].e();
      int i1 = paramd.length;
      int m = 0;
      for (;;)
      {
        int k = j;
        if (m < i1)
        {
          Object localObject = paramd[m];
          if (("must-revalidate".equalsIgnoreCase(((g)localObject).a())) || ("proxy-revalidate".equalsIgnoreCase(((g)localObject).a()))) {
            k = 1;
          }
        }
        else
        {
          i += 1;
          j = k;
          break;
        }
        m += 1;
      }
    }
    if (j != 0) {
      localo.addHeader("Cache-Control", "max-age=0");
    }
    return localo;
  }
  
  public o a(o paramo, Map<String, as> paramMap)
  {
    o localo = o.a(paramo.a());
    localo.setHeaders(paramo.getAllHeaders());
    paramo = new StringBuilder();
    int i = 1;
    paramMap = paramMap.keySet().iterator();
    while (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      if (i == 0) {
        paramo.append(",");
      }
      i = 0;
      paramo.append(str);
    }
    localo.setHeader("If-None-Match", paramo.toString());
    return localo;
  }
  
  public o b(o paramo, d paramd)
  {
    paramd = o.a(paramo.a());
    paramd.setHeaders(paramo.getAllHeaders());
    paramd.addHeader("Cache-Control", "no-cache");
    paramd.addHeader("Pragma", "no-cache");
    paramd.removeHeaders("If-Range");
    paramd.removeHeaders("If-Match");
    paramd.removeHeaders("If-None-Match");
    paramd.removeHeaders("If-Unmodified-Since");
    paramd.removeHeaders("If-Modified-Since");
    return paramd;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */