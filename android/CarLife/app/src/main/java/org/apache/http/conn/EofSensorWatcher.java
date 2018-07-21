package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

@Deprecated
public abstract interface EofSensorWatcher
{
  public abstract boolean eofDetected(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean streamAbort(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean streamClosed(InputStream paramInputStream)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/EofSensorWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */