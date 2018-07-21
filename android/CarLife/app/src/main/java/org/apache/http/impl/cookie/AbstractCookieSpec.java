package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

@Deprecated
public abstract class AbstractCookieSpec
  implements CookieSpec
{
  public AbstractCookieSpec()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected CookieAttributeHandler findAttribHandler(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected CookieAttributeHandler getAttribHandler(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected Collection<CookieAttributeHandler> getAttribHandlers()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void registerAttribHandler(String paramString, CookieAttributeHandler paramCookieAttributeHandler)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/cookie/AbstractCookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */