package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

@Immutable
class g
  implements n, Serializable
{
  private static final long a = -3467082284120936233L;
  private final d b;
  
  public g(d paramd)
  {
    this.b = paramd;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public void consumeContent()
    throws IOException
  {}
  
  public InputStream getContent()
    throws IOException
  {
    return this.b.i().a();
  }
  
  public f getContentEncoding()
  {
    return this.b.a("Content-Encoding");
  }
  
  public long getContentLength()
  {
    return this.b.i().b();
  }
  
  public f getContentType()
  {
    return this.b.a("Content-Type");
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = this.b.i().a();
    try
    {
      ae.a(localInputStream, paramOutputStream);
      return;
    }
    finally
    {
      localInputStream.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */