package org.apache.http.protocol;

import java.util.Map;

@Deprecated
public class HttpRequestHandlerRegistry
  implements HttpRequestHandlerResolver
{
  public HttpRequestHandlerRegistry()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpRequestHandler lookup(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected boolean matchUriRequestPattern(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void register(String paramString, HttpRequestHandler paramHttpRequestHandler)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setHandlers(Map paramMap)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void unregister(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/protocol/HttpRequestHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */