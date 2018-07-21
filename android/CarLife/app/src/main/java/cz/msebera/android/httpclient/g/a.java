package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.n;
import java.io.IOException;

@NotThreadSafe
public abstract class a
  implements n
{
  protected static final int a = 4096;
  protected f b;
  protected f c;
  protected boolean d;
  
  public void a(f paramf)
  {
    this.b = paramf;
  }
  
  public void a(String paramString)
  {
    b localb = null;
    if (paramString != null) {
      localb = new b("Content-Type", paramString);
    }
    a(localb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(f paramf)
  {
    this.c = paramf;
  }
  
  public void b(String paramString)
  {
    b localb = null;
    if (paramString != null) {
      localb = new b("Content-Encoding", paramString);
    }
    b(localb);
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {}
  
  public f getContentEncoding()
  {
    return this.c;
  }
  
  public f getContentType()
  {
    return this.b;
  }
  
  public boolean isChunked()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (this.b != null)
    {
      localStringBuilder.append("Content-Type: ");
      localStringBuilder.append(this.b.d());
      localStringBuilder.append(',');
    }
    if (this.c != null)
    {
      localStringBuilder.append("Content-Encoding: ");
      localStringBuilder.append(this.c.d());
      localStringBuilder.append(',');
    }
    long l = getContentLength();
    if (l >= 0L)
    {
      localStringBuilder.append("Content-Length: ");
      localStringBuilder.append(l);
      localStringBuilder.append(',');
    }
    localStringBuilder.append("Chunked: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */