package cz.msebera.android.httpclient.g.a.a;

import cz.msebera.android.httpclient.g.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f
  extends a
{
  private final InputStream a;
  private final String b;
  
  public f(InputStream paramInputStream, g paramg)
  {
    this(paramInputStream, paramg, null);
  }
  
  public f(InputStream paramInputStream, g paramg, String paramString)
  {
    super(paramg);
    cz.msebera.android.httpclient.o.a.a(paramInputStream, "Input stream");
    this.a = paramInputStream;
    this.b = paramString;
  }
  
  public f(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, g.n, paramString);
  }
  
  @Deprecated
  public f(InputStream paramInputStream, String paramString1, String paramString2)
  {
    this(paramInputStream, g.b(paramString1), paramString2);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = this.a.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      paramOutputStream.flush();
    }
    finally
    {
      this.a.close();
    }
    this.a.close();
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return "binary";
  }
  
  public long h()
  {
    return -1L;
  }
  
  public InputStream i()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */