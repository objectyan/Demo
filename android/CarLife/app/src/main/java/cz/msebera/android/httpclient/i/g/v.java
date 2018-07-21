package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.h;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public class v
  extends InputStream
{
  private final h a;
  private boolean b = false;
  
  public v(h paramh)
  {
    this.a = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer"));
  }
  
  public int available()
    throws IOException
  {
    if ((this.a instanceof cz.msebera.android.httpclient.j.a)) {
      return ((cz.msebera.android.httpclient.j.a)this.a).g();
    }
    return 0;
  }
  
  public void close()
    throws IOException
  {
    this.b = true;
  }
  
  public int read()
    throws IOException
  {
    if (this.b) {
      return -1;
    }
    return this.a.a();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b) {
      return -1;
    }
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */