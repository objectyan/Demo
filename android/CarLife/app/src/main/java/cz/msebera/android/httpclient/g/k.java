package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class k
  extends a
{
  private final InputStream e;
  private final long f;
  
  public k(InputStream paramInputStream)
  {
    this(paramInputStream, -1L);
  }
  
  public k(InputStream paramInputStream, long paramLong)
  {
    this(paramInputStream, paramLong, null);
  }
  
  public k(InputStream paramInputStream, long paramLong, g paramg)
  {
    this.e = ((InputStream)cz.msebera.android.httpclient.o.a.a(paramInputStream, "Source input stream"));
    this.f = paramLong;
    if (paramg != null) {
      a(paramg.toString());
    }
  }
  
  public k(InputStream paramInputStream, g paramg)
  {
    this(paramInputStream, -1L, paramg);
  }
  
  public InputStream getContent()
    throws IOException
  {
    return this.e;
  }
  
  public long getContentLength()
  {
    return this.f;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = this.e;
    byte[] arrayOfByte;
    int i;
    try
    {
      arrayOfByte = new byte['က'];
      if (this.f < 0L) {
        for (;;)
        {
          i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
      }
      l = this.f;
    }
    finally
    {
      localInputStream.close();
    }
    for (;;)
    {
      long l;
      if (l > 0L)
      {
        i = localInputStream.read(arrayOfByte, 0, (int)Math.min(4096L, l));
        if (i != -1) {}
      }
      else
      {
        localInputStream.close();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l -= i;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */