package cz.msebera.android.httpclient.g.a;

import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class k
  implements n
{
  private final a a;
  private final f b;
  private final long c;
  
  k(a parama, String paramString, long paramLong)
  {
    this.a = parama;
    this.b = new b("Content-Type", paramString);
    this.c = paramLong;
  }
  
  a a()
  {
    return this.a;
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public InputStream getContent()
    throws IOException
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }
  
  public f getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return this.c;
  }
  
  public f getContentType()
  {
    return this.b;
  }
  
  public boolean isChunked()
  {
    return !isRepeatable();
  }
  
  public boolean isRepeatable()
  {
    return this.c != -1L;
  }
  
  public boolean isStreaming()
  {
    return !isRepeatable();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.a.a(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */