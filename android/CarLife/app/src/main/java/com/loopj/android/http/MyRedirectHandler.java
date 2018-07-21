package com.loopj.android.http;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.e;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i.b.ar;
import cz.msebera.android.httpclient.i.b.v;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.net.URI;
import java.net.URISyntaxException;

class MyRedirectHandler
  extends v
{
  private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  private final boolean enableRedirects;
  
  public MyRedirectHandler(boolean paramBoolean)
  {
    this.enableRedirects = paramBoolean;
  }
  
  public URI getLocationURI(x paramx, g paramg)
    throws aj
  {
    if (paramx == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    Object localObject1 = paramx.getFirstHeader("location");
    if (localObject1 == null) {
      throw new aj("Received redirect response " + paramx.a() + " but no location header");
    }
    Object localObject2 = ((f)localObject1).d().replaceAll(" ", "%20");
    try
    {
      localObject1 = new URI((String)localObject2);
      localObject2 = paramx.getParams();
      paramx = (x)localObject1;
      if (((URI)localObject1).isAbsolute()) {
        break label248;
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
    if (paramx == null) {
      throw new IllegalStateException("Target host not available in the HTTP context");
    }
    u localu = (u)paramg.a("http.request");
    for (;;)
    {
      try
      {
        paramx = i.a(i.a(new URI(localu.getRequestLine().c()), paramx, true), (URI)localObject1);
        label248:
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
    if (!this.enableRedirects) {
      return false;
    }
    if (paramx == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    switch (paramx.a().b())
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/MyRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */