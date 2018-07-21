package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.l;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Immutable
public class ab
  implements l
{
  private static final long a = -2078599905620463394L;
  private final byte[] b;
  
  public ab(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public InputStream a()
  {
    return new ByteArrayInputStream(this.b);
  }
  
  public long b()
  {
    return this.b.length;
  }
  
  public void c() {}
  
  byte[] d()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */