package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class c
  extends j
{
  private final byte[] a;
  
  public c(n paramn)
    throws IOException
  {
    super(paramn);
    if ((!paramn.isRepeatable()) || (paramn.getContentLength() < 0L))
    {
      this.a = g.c(paramn);
      return;
    }
    this.a = null;
  }
  
  public InputStream getContent()
    throws IOException
  {
    if (this.a != null) {
      return new ByteArrayInputStream(this.a);
    }
    return super.getContent();
  }
  
  public long getContentLength()
  {
    if (this.a != null) {
      return this.a.length;
    }
    return super.getContentLength();
  }
  
  public boolean isChunked()
  {
    return (this.a == null) && (super.isChunked());
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return (this.a == null) && (super.isStreaming());
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    a.a(paramOutputStream, "Output stream");
    if (this.a != null)
    {
      paramOutputStream.write(this.a);
      return;
    }
    super.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */