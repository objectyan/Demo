package com.baidu.mapframework.commonlib.asynchttp;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class MyRedirectHandler
  extends DefaultRedirectHandler
{
  private static final String a = "http.protocol.redirect-locations";
  private final boolean b;
  
  public MyRedirectHandler(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws ProtocolException
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    Object localObject1 = paramHttpResponse.getFirstHeader("location");
    if (localObject1 == null) {
      throw new ProtocolException("Received redirect response " + paramHttpResponse.getStatusLine() + " but no location header");
    }
    Object localObject2 = ((Header)localObject1).getValue().replaceAll(" ", "%20");
    try
    {
      localObject1 = new URI((String)localObject2);
      localObject2 = paramHttpResponse.getParams();
      paramHttpResponse = (HttpResponse)localObject1;
      if (((URI)localObject1).isAbsolute()) {
        break label248;
      }
      if (((HttpParams)localObject2).isParameterTrue("http.protocol.reject-relative-redirect")) {
        throw new ProtocolException("Relative redirect location '" + localObject1 + "' not allowed");
      }
    }
    catch (URISyntaxException paramHttpResponse)
    {
      throw new ProtocolException("Invalid redirect URI: " + (String)localObject2, paramHttpResponse);
    }
    paramHttpResponse = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    if (paramHttpResponse == null) {
      throw new IllegalStateException("Target host not available in the HTTP context");
    }
    HttpRequest localHttpRequest = (HttpRequest)paramHttpContext.getAttribute("http.request");
    for (;;)
    {
      try
      {
        paramHttpResponse = URIUtils.resolve(URIUtils.rewriteURI(new URI(localHttpRequest.getRequestLine().getUri()), paramHttpResponse, true), (URI)localObject1);
        label248:
        if (!((HttpParams)localObject2).isParameterFalse("http.protocol.allow-circular-redirects")) {
          return paramHttpResponse;
        }
        localObject2 = (RedirectLocations)paramHttpContext.getAttribute("http.protocol.redirect-locations");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new RedirectLocations();
          paramHttpContext.setAttribute("http.protocol.redirect-locations", localObject1);
        }
        if (paramHttpResponse.getFragment() != null) {}
        paramHttpContext = paramHttpResponse;
      }
      catch (URISyntaxException paramHttpResponse)
      {
        try
        {
          paramHttpContext = URIUtils.rewriteURI(paramHttpResponse, new HttpHost(paramHttpResponse.getHost(), paramHttpResponse.getPort(), paramHttpResponse.getScheme()), true);
          if (!((RedirectLocations)localObject1).contains(paramHttpContext)) {
            break;
          }
          throw new CircularRedirectException("Circular redirect to '" + paramHttpContext + "'");
        }
        catch (URISyntaxException paramHttpResponse)
        {
          throw new ProtocolException(paramHttpResponse.getMessage(), paramHttpResponse);
        }
        paramHttpResponse = paramHttpResponse;
        throw new ProtocolException(paramHttpResponse.getMessage(), paramHttpResponse);
      }
    }
    ((RedirectLocations)localObject1).add(paramHttpContext);
    return paramHttpResponse;
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (!this.b) {
      return false;
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    switch (paramHttpResponse.getStatusLine().getStatusCode())
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/MyRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */