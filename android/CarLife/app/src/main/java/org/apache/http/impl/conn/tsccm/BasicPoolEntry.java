package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

@Deprecated
public class BasicPoolEntry
  extends AbstractPoolEntry
{
  public BasicPoolEntry(ClientConnectionOperator paramClientConnectionOperator, HttpRoute paramHttpRoute, ReferenceQueue<Object> paramReferenceQueue)
  {
    super((ClientConnectionOperator)null, (HttpRoute)null);
    throw new RuntimeException("Stub!");
  }
  
  protected final OperatedClientConnection getConnection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected final HttpRoute getPlannedRoute()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected final BasicPoolEntryRef getWeakRef()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/conn/tsccm/BasicPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */