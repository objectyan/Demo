package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.d.r;
import cz.msebera.android.httpclient.b.e;
import cz.msebera.android.httpclient.b.p;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.k;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

@Immutable
public class w
  implements p
{
  @Deprecated
  public static final String b = "http.protocol.redirect-locations";
  public static final w c = new w();
  private static final String[] d = { "GET", "HEAD" };
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  
  protected URI a(String paramString)
    throws aj
  {
    try
    {
      Object localObject = new cz.msebera.android.httpclient.b.g.h(new URI(paramString).normalize());
      String str = ((cz.msebera.android.httpclient.b.g.h)localObject).h();
      if (str != null) {
        ((cz.msebera.android.httpclient.b.g.h)localObject).c(str.toLowerCase(Locale.ENGLISH));
      }
      if (k.a(((cz.msebera.android.httpclient.b.g.h)localObject).j())) {
        ((cz.msebera.android.httpclient.b.g.h)localObject).d("/");
      }
      localObject = ((cz.msebera.android.httpclient.b.g.h)localObject).a();
      return (URI)localObject;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new aj("Invalid redirect URI: " + paramString, localURISyntaxException);
    }
  }
  
  public boolean a(u paramu, x paramx, g paramg)
    throws aj
  {
    boolean bool2 = true;
    a.a(paramu, "HTTP request");
    a.a(paramx, "HTTP response");
    int i = paramx.a().b();
    paramu = paramu.getRequestLine().a();
    paramx = paramx.getFirstHeader("location");
    boolean bool1 = bool2;
    switch (i)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      bool1 = false;
    case 303: 
    case 302: 
      do
      {
        return bool1;
        if (!b(paramu)) {
          break;
        }
        bool1 = bool2;
      } while (paramx != null);
      return false;
    }
    return b(paramu);
  }
  
  public q b(u paramu, x paramx, g paramg)
    throws aj
  {
    paramg = c(paramu, paramx, paramg);
    String str = paramu.getRequestLine().a();
    if (str.equalsIgnoreCase("HEAD")) {
      return new cz.msebera.android.httpclient.b.d.i(paramg);
    }
    if (str.equalsIgnoreCase("GET")) {
      return new cz.msebera.android.httpclient.b.d.h(paramg);
    }
    if (paramx.a().b() == 307) {
      return r.a(paramu).a(paramg).n();
    }
    return new cz.msebera.android.httpclient.b.d.h(paramg);
  }
  
  protected boolean b(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = d;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public URI c(u paramu, x paramx, g paramg)
    throws aj
  {
    a.a(paramu, "HTTP request");
    a.a(paramx, "HTTP response");
    a.a(paramg, "HTTP context");
    cz.msebera.android.httpclient.b.f.c localc1 = cz.msebera.android.httpclient.b.f.c.b(paramg);
    Object localObject = paramx.getFirstHeader("location");
    if (localObject == null) {
      throw new aj("Received redirect response " + paramx.a() + " but no location header");
    }
    paramx = ((f)localObject).d();
    if (this.a.a()) {
      this.a.a("Redirect requested to location '" + paramx + "'");
    }
    cz.msebera.android.httpclient.b.b.c localc = localc1.p();
    localObject = a(paramx);
    paramx = (x)localObject;
    try
    {
      if (((URI)localObject).isAbsolute()) {
        break label249;
      }
      if (!localc.g()) {
        throw new aj("Relative redirect location '" + localObject + "' not allowed");
      }
    }
    catch (URISyntaxException paramu)
    {
      throw new aj(paramu.getMessage(), paramu);
    }
    paramx = localc1.v();
    cz.msebera.android.httpclient.o.b.a(paramx, "Target host");
    paramx = cz.msebera.android.httpclient.b.g.i.a(cz.msebera.android.httpclient.b.g.i.a(new URI(paramu.getRequestLine().c()), paramx, false), (URI)localObject);
    label249:
    localObject = (ar)localc1.a("http.protocol.redirect-locations");
    paramu = (u)localObject;
    if (localObject == null)
    {
      paramu = new ar();
      paramg.a("http.protocol.redirect-locations", paramu);
    }
    if ((!localc.h()) && (paramu.a(paramx))) {
      throw new e("Circular redirect to '" + paramx + "'");
    }
    paramu.b(paramx);
    return paramx;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */