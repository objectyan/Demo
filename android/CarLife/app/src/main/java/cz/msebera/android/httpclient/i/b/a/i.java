package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.g;
import cz.msebera.android.httpclient.b.a.h;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@Immutable
class i
  implements g
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final h b;
  private final j c;
  
  public i(j paramj, h paramh)
  {
    this.c = paramj;
    this.b = paramh;
  }
  
  private URL a(URL paramURL, x paramx)
  {
    paramx = paramx.getFirstHeader("Content-Location");
    if (paramx == null) {
      paramx = null;
    }
    String str;
    URL localURL;
    do
    {
      return paramx;
      str = paramx.d();
      localURL = c(str);
      paramx = localURL;
    } while (localURL != null);
    return c(paramURL, str);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.b.b(paramString);
      return;
    }
    catch (IOException paramString)
    {
      this.a.c("unable to flush cache entry", paramString);
    }
  }
  
  private void a(URL paramURL1, x paramx, URL paramURL2)
  {
    d locald = b(this.c.a(paramURL2.toString()));
    if (locald == null) {}
    while ((b(paramx, locald)) || (!a(paramx, locald))) {
      return;
    }
    a(paramURL1, paramURL2);
  }
  
  private boolean a(x paramx, d paramd)
  {
    paramd = paramd.a("ETag");
    paramx = paramx.getFirstHeader("ETag");
    if ((paramd == null) || (paramx == null)) {}
    while (paramd.d().equals(paramx.d())) {
      return false;
    }
    return true;
  }
  
  private d b(String paramString)
  {
    try
    {
      paramString = this.b.a(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      this.a.c("could not retrieve entry from storage", paramString);
    }
    return null;
  }
  
  private URL b(URL paramURL, x paramx)
  {
    paramx = paramx.getFirstHeader("Location");
    if (paramx == null) {
      paramx = null;
    }
    String str;
    URL localURL;
    do
    {
      return paramx;
      str = paramx.d();
      localURL = c(str);
      paramx = localURL;
    } while (localURL != null);
    return c(paramURL, str);
  }
  
  private boolean b(x paramx, d paramd)
  {
    paramd = paramd.a("Date");
    paramx = paramx.getFirstHeader("Date");
    if ((paramd == null) || (paramx == null)) {}
    do
    {
      return false;
      paramd = cz.msebera.android.httpclient.b.g.b.a(paramd.d());
      paramx = cz.msebera.android.httpclient.b.g.b.a(paramx.d());
    } while ((paramd == null) || (paramx == null));
    return paramx.before(paramd);
  }
  
  private URL c(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  private URL c(URL paramURL, String paramString)
  {
    try
    {
      paramURL = new URL(paramURL, paramString);
      return paramURL;
    }
    catch (MalformedURLException paramURL) {}
    return null;
  }
  
  private boolean d(String paramString)
  {
    return (!"GET".equals(paramString)) && (!"HEAD".equals(paramString));
  }
  
  public void a(r paramr, u paramu)
  {
    Object localObject;
    if (a(paramu))
    {
      this.a.a("Request should not be cached");
      paramr = this.c.a(paramr, paramu);
      localObject = b(paramr);
      this.a.a("parent entry: " + localObject);
      if (localObject != null)
      {
        localObject = ((d)localObject).k().values().iterator();
        while (((Iterator)localObject).hasNext()) {
          a((String)((Iterator)localObject).next());
        }
        a(paramr);
      }
      paramr = c(paramr);
      if (paramr != null) {
        break label128;
      }
      this.a.b("Couldn't transform request into valid URL");
    }
    label128:
    do
    {
      return;
      localObject = paramu.getFirstHeader("Content-Location");
      if (localObject != null)
      {
        localObject = ((f)localObject).d();
        if (!b(paramr, (String)localObject)) {
          a(paramr, (String)localObject);
        }
      }
      paramu = paramu.getFirstHeader("Location");
    } while (paramu == null);
    b(paramr, paramu.d());
  }
  
  public void a(r paramr, u paramu, x paramx)
  {
    int i = paramx.a().b();
    if ((i < 200) || (i > 299)) {}
    do
    {
      do
      {
        return;
        paramr = c(this.c.a(paramr, paramu));
      } while (paramr == null);
      paramu = a(paramr, paramx);
      if (paramu != null) {
        a(paramr, paramx, paramu);
      }
      paramu = b(paramr, paramx);
    } while (paramu == null);
    a(paramr, paramx, paramu);
  }
  
  protected void a(URL paramURL, String paramString)
  {
    paramString = c(paramURL, paramString);
    if (paramString == null) {
      return;
    }
    a(paramURL, paramString);
  }
  
  protected void a(URL paramURL1, URL paramURL2)
  {
    paramURL2 = c(this.c.a(paramURL2.toString()));
    if (paramURL2 == null) {}
    while (!paramURL2.getAuthority().equalsIgnoreCase(paramURL1.getAuthority())) {
      return;
    }
    a(paramURL2.toString());
  }
  
  protected boolean a(u paramu)
  {
    return d(paramu.getRequestLine().a());
  }
  
  protected boolean b(URL paramURL, String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return false;
    }
    a(paramURL, paramString);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */