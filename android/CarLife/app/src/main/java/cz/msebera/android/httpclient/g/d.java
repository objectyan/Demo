package cz.msebera.android.httpclient.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
public class d
  extends a
  implements Cloneable
{
  @Deprecated
  protected final byte[] e;
  private final byte[] f;
  private final int g;
  private final int h;
  
  public d(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, null);
  }
  
  public d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(paramArrayOfByte, paramInt1, paramInt2, null);
  }
  
  public d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramArrayOfByte, "Source byte array");
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfByte.length);
    }
    this.e = paramArrayOfByte;
    this.f = paramArrayOfByte;
    this.g = paramInt1;
    this.h = paramInt2;
    if (paramg != null) {
      a(paramg.toString());
    }
  }
  
  public d(byte[] paramArrayOfByte, g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramArrayOfByte, "Source byte array");
    this.e = paramArrayOfByte;
    this.f = paramArrayOfByte;
    this.g = 0;
    this.h = this.f.length;
    if (paramg != null) {
      a(paramg.toString());
    }
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(this.f, this.g, this.h);
  }
  
  public long getContentLength()
  {
    return this.h;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Output stream");
    paramOutputStream.write(this.f, this.g, this.h);
    paramOutputStream.flush();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */