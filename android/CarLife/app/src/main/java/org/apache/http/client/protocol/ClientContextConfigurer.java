package org.apache.http.client.protocol;

import java.util.List;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class ClientContextConfigurer
  implements ClientContext
{
  public ClientContextConfigurer(HttpContext paramHttpContext)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAuthSchemePref(List<String> paramList)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAuthSchemeRegistry(AuthSchemeRegistry paramAuthSchemeRegistry)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCookieSpecRegistry(CookieSpecRegistry paramCookieSpecRegistry)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCookieStore(CookieStore paramCookieStore)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCredentialsProvider(CredentialsProvider paramCredentialsProvider)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/client/protocol/ClientContextConfigurer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */