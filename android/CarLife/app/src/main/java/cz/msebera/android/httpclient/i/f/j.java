package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
class j
  implements n
{
  private final n a;
  private boolean b = false;
  
  j(n paramn)
  {
    this.a = paramn;
  }
  
  static void a(o paramo)
  {
    n localn = paramo.getEntity();
    if ((localn != null) && (!localn.isRepeatable()) && (!a(localn))) {
      paramo.setEntity(new j(localn));
    }
  }
  
  static boolean a(n paramn)
  {
    return paramn instanceof j;
  }
  
  static boolean a(u paramu)
  {
    if ((paramu instanceof o))
    {
      paramu = ((o)paramu).getEntity();
      if ((paramu != null) && ((!a(paramu)) || (((j)paramu).b()))) {}
    }
    else
    {
      return true;
    }
    return paramu.isRepeatable();
  }
  
  public n a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {
    this.b = true;
    this.a.consumeContent();
  }
  
  public InputStream getContent()
    throws IOException, IllegalStateException
  {
    return this.a.getContent();
  }
  
  public f getContentEncoding()
  {
    return this.a.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.a.getContentLength();
  }
  
  public f getContentType()
  {
    return this.a.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.a.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.a.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.a.isStreaming();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RequestEntityProxy{");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.b = true;
    this.a.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */