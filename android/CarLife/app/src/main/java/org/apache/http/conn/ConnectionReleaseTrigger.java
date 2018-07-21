package org.apache.http.conn;

import java.io.IOException;

@Deprecated
public abstract interface ConnectionReleaseTrigger
{
  public abstract void abortConnection()
    throws IOException;
  
  public abstract void releaseConnection()
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/ConnectionReleaseTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */