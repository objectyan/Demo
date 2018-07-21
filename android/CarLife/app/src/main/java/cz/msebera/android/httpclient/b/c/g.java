package cz.msebera.android.httpclient.b.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
class g
  extends InputStream
{
  private final InputStream a;
  private final a b;
  private InputStream c;
  
  public g(InputStream paramInputStream, a parama)
  {
    this.a = paramInputStream;
    this.b = parama;
  }
  
  private void a()
    throws IOException
  {
    if (this.c == null) {
      this.c = this.b.a(this.a);
    }
  }
  
  public int available()
    throws IOException
  {
    a();
    return this.c.available();
  }
  
  public void close()
    throws IOException
  {
    try
    {
      if (this.c != null) {
        this.c.close();
      }
      return;
    }
    finally
    {
      this.a.close();
    }
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    a();
    return this.c.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    a();
    return this.c.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    a();
    return this.c.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    a();
    return this.c.skip(paramLong);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */