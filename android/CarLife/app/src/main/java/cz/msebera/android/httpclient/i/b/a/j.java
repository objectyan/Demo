package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.c;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Immutable
class j
{
  private static final URI a = URI.create("http://example.com/");
  
  private int a(int paramInt, String paramString)
  {
    int i;
    if ((paramInt == -1) && ("http".equalsIgnoreCase(paramString))) {
      i = 80;
    }
    do
    {
      do
      {
        return i;
        i = paramInt;
      } while (paramInt != -1);
      i = paramInt;
    } while (!"https".equalsIgnoreCase(paramString));
    return 443;
  }
  
  private boolean a(u paramu)
  {
    paramu = paramu.getRequestLine().c();
    return ("*".equals(paramu)) || (paramu.startsWith("/"));
  }
  
  public String a(r paramr, u paramu)
  {
    if (a(paramu)) {
      return a(String.format("%s%s", new Object[] { paramr.toString(), paramu.getRequestLine().c() }));
    }
    return a(paramu.getRequestLine().c());
  }
  
  public String a(r paramr, u paramu, d paramd)
  {
    if (!paramd.j()) {
      return a(paramr, paramu);
    }
    return a(paramu, paramd) + a(paramr, paramu);
  }
  
  public String a(u paramu, d paramd)
  {
    Object localObject1 = new ArrayList();
    paramd = paramd.b("Vary");
    int k = paramd.length;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = paramd[i].e();
      int m = localObject2.length;
      int j = 0;
      while (j < m)
      {
        ((List)localObject1).add(localObject2[j].a());
        j += 1;
      }
      i += 1;
    }
    Collections.sort((List)localObject1);
    try
    {
      paramd = new StringBuilder("{");
      i = 1;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (i == 0) {
          paramd.append("&");
        }
        paramd.append(URLEncoder.encode((String)localObject2, c.e.name()));
        paramd.append("=");
        paramd.append(URLEncoder.encode(a(paramu.getHeaders((String)localObject2)), c.e.name()));
        i = 0;
      }
      paramd.append("}");
      return paramd.toString();
    }
    catch (UnsupportedEncodingException paramu)
    {
      throw new RuntimeException("couldn't encode to UTF-8", paramu);
    }
  }
  
  public String a(String paramString)
  {
    try
    {
      Object localObject = new URL(i.a(a, paramString).toASCIIString());
      String str2 = ((URL)localObject).getProtocol();
      String str3 = ((URL)localObject).getHost();
      int i = a(((URL)localObject).getPort(), str2);
      String str1 = ((URL)localObject).getPath();
      localObject = ((URL)localObject).getQuery();
      if (localObject != null) {
        str1 = str1 + "?" + (String)localObject;
      }
      for (;;)
      {
        str1 = new URL(str2, str3, i, str1).toString();
        return str1;
      }
      return paramString;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return paramString;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
  
  protected String a(f[] paramArrayOff)
  {
    if (paramArrayOff == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = 1;
    int k = paramArrayOff.length;
    int i = 0;
    while (i < k)
    {
      f localf = paramArrayOff[i];
      if (j == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(localf.d().trim());
      j = 0;
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */