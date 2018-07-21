package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.e;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.b.o;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
@Immutable
public class v
  implements o
{
  private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  public cz.msebera.android.httpclient.h.b log = new cz.msebera.android.httpclient.h.b(getClass());
  
  public URI getLocationURI(x paramx, g paramg)
    throws aj
  {
    a.a(paramx, "HTTP response");
    Object localObject1 = paramx.getFirstHeader("location");
    if (localObject1 == null) {
      throw new aj("Received redirect response " + paramx.a() + " but no location header");
    }
    Object localObject2 = ((f)localObject1).d();
    if (this.log.a()) {
      this.log.a("Redirect requested to location '" + (String)localObject2 + "'");
    }
    try
    {
      localObject1 = new URI((String)localObject2);
      localObject2 = paramx.getParams();
      paramx = (x)localObject1;
      if (((URI)localObject1).isAbsolute()) {
        break label268;
      }
      if (((j)localObject2).c("http.protocol.reject-relative-redirect")) {
        throw new aj("Relative redirect location '" + localObject1 + "' not allowed");
      }
    }
    catch (URISyntaxException paramx)
    {
      throw new aj("Invalid redirect URI: " + (String)localObject2, paramx);
    }
    paramx = (r)paramg.a("http.target_host");
    cz.msebera.android.httpclient.o.b.a(paramx, "Target host");
    u localu = (u)paramg.a("http.request");
    for (;;)
    {
      try
      {
        paramx = i.a(i.a(new URI(localu.getRequestLine().c()), paramx, true), (URI)localObject1);
        label268:
        if (!((j)localObject2).d("http.protocol.allow-circular-redirects")) {
          return paramx;
        }
        localObject2 = (ar)paramg.a("http.protocol.redirect-locations");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ar();
          paramg.a("http.protocol.redirect-locations", localObject1);
        }
        if (paramx.getFragment() != null) {}
        paramg = paramx;
      }
      catch (URISyntaxException paramx)
      {
        try
        {
          paramg = i.a(paramx, new r(paramx.getHost(), paramx.getPort(), paramx.getScheme()), true);
          if (!((ar)localObject1).a(paramg)) {
            break;
          }
          throw new e("Circular redirect to '" + paramg + "'");
        }
        catch (URISyntaxException paramx)
        {
          throw new aj(paramx.getMessage(), paramx);
        }
        paramx = paramx;
        throw new aj(paramx.getMessage(), paramx);
      }
    }
    ((ar)localObject1).b(paramg);
    return paramx;
  }
  
  public boolean isRedirectRequested(x paramx, g paramg)
  {
    a.a(paramx, "HTTP response");
    switch (paramx.a().b())
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
    case 301: 
    case 302: 
    case 307: 
      do
      {
        return false;
        paramx = ((u)paramg.a("http.request")).getRequestLine().a();
      } while ((!paramx.equalsIgnoreCase("GET")) && (!paramx.equalsIgnoreCase("HEAD")));
      return true;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */