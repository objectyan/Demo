package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

@Deprecated
public class ThreadSafeClientConnManager
  implements ClientConnectionManager
{
  protected ClientConnectionOperator connOperator;
  protected final AbstractConnPool connectionPool;
  protected SchemeRegistry schemeRegistry;
  
  public ThreadSafeClientConnManager(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void closeExpiredConnections()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected AbstractConnPool createConnectionPool(HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void finalize()
    throws Throwable
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getConnectionsInPool()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getConnectionsInPool(HttpRoute paramHttpRoute)
  {
    throw new RuntimeException("Stub!");
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */