package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

@Deprecated
public class HttpHostConnectException
  extends ConnectException
{
  public HttpHostConnectException(HttpHost paramHttpHost, ConnectException paramConnectException)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpHost getHost()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/HttpHostConnectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */