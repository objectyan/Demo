package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

@Deprecated
public final class RouteTracker
  implements RouteInfo
{
  public RouteTracker(HttpHost paramHttpHost, InetAddress paramInetAddress)
  {
    throw new RuntimeException("Stub!");
  }
  
  public RouteTracker(HttpRoute paramHttpRoute)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void connectProxy(HttpHost paramHttpHost, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void connectTarget(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean equals(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int getHopCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpHost getHopTarget(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final RouteInfo.LayerType getLayerType()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final InetAddress getLocalAddress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpHost getProxyHost()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpHost getTargetHost()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final RouteInfo.TunnelType getTunnelType()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final int hashCode()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isConnected()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isLayered()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isSecure()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isTunnelled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void layerProtocol(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final HttpRoute toRoute()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String toString()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void tunnelTarget(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/routing/RouteTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */