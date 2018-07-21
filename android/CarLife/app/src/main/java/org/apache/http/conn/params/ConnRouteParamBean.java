package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnRouteParamBean
  extends HttpAbstractParamBean
{
  public ConnRouteParamBean(HttpParams paramHttpParams)
  {
    super((HttpParams)null);
    throw new RuntimeException("Stub!");
  }
  
  public void setDefaultProxy(HttpHost paramHttpHost)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setForcedRoute(HttpRoute paramHttpRoute)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLocalAddress(InetAddress paramInetAddress)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/params/ConnRouteParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */