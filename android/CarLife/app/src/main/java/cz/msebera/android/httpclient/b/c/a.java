package cz.msebera.android.httpclient.b.c;

import cz.msebera.android.httpclient.g.j;
import cz.msebera.android.httpclient.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class a
  extends j
{
  private static final int a = 2048;
  private InputStream b;
  
  public a(n paramn)
  {
    super(paramn);
  }
  
  private InputStream a()
    throws IOException
  {
    return new g(this.wrappedEntity.getContent(), this);
  }
  
  abstract InputStream a(InputStream paramInputStream)
    throws IOException;
  
  public InputStream getContent()
    throws IOException
  {
    if (this.wrappedEntity.isStreaming())
    {
      if (this.b == null) {
        this.b = a();
      }
      return this.b;
    }
    return a();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    InputStream localInputStream = getContent();
    try
    {
      byte[] arrayOfByte = new byte['ࠀ'];
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */