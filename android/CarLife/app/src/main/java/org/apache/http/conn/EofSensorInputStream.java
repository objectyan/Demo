package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class EofSensorInputStream
  extends InputStream
  implements ConnectionReleaseTrigger
{
  protected InputStream wrappedStream;
  
  public EofSensorInputStream(InputStream paramInputStream, EofSensorWatcher paramEofSensorWatcher)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void abortConnection()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public int available()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void checkAbort()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void checkClose()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void checkEOF(int paramInt)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void close()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean isReadAllowed()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public int read()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void releaseConnection()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/conn/EofSensorInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */