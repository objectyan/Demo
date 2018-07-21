package cz.msebera.android.httpclient.b.c;

import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g.j;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class e
  extends j
{
  private static final String a = "gzip";
  
  public e(n paramn)
  {
    super(paramn);
  }
  
  public InputStream getContent()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public f getContentEncoding()
  {
    return new b("Content-Encoding", "gzip");
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public boolean isChunked()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    a.a(paramOutputStream, "Output stream");
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    this.wrappedEntity.writeTo(paramOutputStream);
    paramOutputStream.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */