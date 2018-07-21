package org.apache.http.conn.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnManagerParamBean
  extends HttpAbstractParamBean
{
  public ConnManagerParamBean(HttpParams paramHttpParams)
  {
    super((HttpParams)null);
    throw new RuntimeException("Stub!");
  }
  
  public void setConnectionsPerRoute(ConnPerRouteBean paramConnPerRouteBean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMaxTotalConnections(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setTimeout(long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/params/ConnManagerParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */