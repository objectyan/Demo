package cz.msebera.android.httpclient.g.a.a;

import cz.msebera.android.httpclient.g.g;
import java.io.IOException;
import java.io.OutputStream;

public class b
  extends a
{
  private final byte[] a;
  private final String b;
  
  public b(byte[] paramArrayOfByte, g paramg, String paramString)
  {
    super(paramg);
    cz.msebera.android.httpclient.o.a.a(paramArrayOfByte, "byte[]");
    this.a = paramArrayOfByte;
    this.b = paramString;
  }
  
  public b(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, "application/octet-stream", paramString);
  }
  
  @Deprecated
  public b(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this(paramArrayOfByte, g.b(paramString1), paramString2);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.a);
  }
  
  public String e()
  {
    return null;
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
    return this.a.length;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */