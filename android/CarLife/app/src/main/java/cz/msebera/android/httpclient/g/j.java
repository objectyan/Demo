package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class j
  implements n
{
  protected n wrappedEntity;
  
  public j(n paramn)
  {
    this.wrappedEntity = ((n)a.a(paramn, "Wrapped entity"));
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {
    this.wrappedEntity.consumeContent();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return this.wrappedEntity.getContent();
  }
  
  public f getContentEncoding()
  {
    return this.wrappedEntity.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.wrappedEntity.getContentLength();
  }
  
  public f getContentType()
  {
    return this.wrappedEntity.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.wrappedEntity.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.wrappedEntity.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.wrappedEntity.isStreaming();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.wrappedEntity.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */