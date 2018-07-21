package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class b
  extends a
{
  private InputStream e;
  private long f = -1L;
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(InputStream paramInputStream)
  {
    this.e = paramInputStream;
  }
  
  public InputStream getContent()
    throws IllegalStateException
  {
    if (this.e != null) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Content has not been provided");
      return this.e;
    }
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
    return this.e != null;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = getContent();
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localInputStream.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */