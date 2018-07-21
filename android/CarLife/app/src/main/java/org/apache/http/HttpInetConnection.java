package org.apache.http;

import java.net.InetAddress;

@Deprecated
public abstract interface HttpInetConnection
  extends HttpConnection
{
  public abstract InetAddress getLocalAddress();
  
  public abstract int getLocalPort();
  
  public abstract InetAddress getRemoteAddress();
  
  public abstract int getRemotePort();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/HttpInetConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */