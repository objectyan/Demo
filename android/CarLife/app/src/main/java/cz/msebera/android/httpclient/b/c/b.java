package cz.msebera.android.httpclient.b.c;

import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import java.io.IOException;
import java.io.InputStream;

public class b
  extends a
{
  public b(n paramn)
  {
    super(paramn);
  }
  
  InputStream a(InputStream paramInputStream)
    throws IOException
  {
    return new c(paramInputStream);
  }
  
  public f getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */