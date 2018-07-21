package com.facebook.a;

import com.facebook.common.internal.k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
  implements a
{
  private final byte[] a;
  
  public b(byte[] paramArrayOfByte)
  {
    this.a = ((byte[])k.a(paramArrayOfByte));
  }
  
  public InputStream a()
    throws IOException
  {
    return new ByteArrayInputStream(this.a);
  }
  
  public byte[] b()
  {
    return this.a;
  }
  
  public long c()
  {
    return this.a.length;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */