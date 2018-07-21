package org.apache.http.conn.params;

import java.util.Map;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public final class ConnPerRouteBean
  implements ConnPerRoute
{
  public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
  
  public ConnPerRouteBean()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ConnPerRouteBean(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getDefaultMax()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getMaxForRoute(HttpRoute paramHttpRoute)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMaxForRoute(HttpRoute paramHttpRoute, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMaxForRoutes(Map<HttpRoute, Integer> paramMap)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/params/ConnPerRouteBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */