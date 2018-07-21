package com.facebook.common.m;

import com.facebook.common.internal.b;
import com.facebook.common.internal.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class e
{
  public static long a(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    k.a(paramInputStream);
    boolean bool;
    long l1;
    if (paramLong >= 0L)
    {
      bool = true;
      k.a(bool);
      l1 = paramLong;
    }
    for (;;)
    {
      l2 = paramLong;
      if (l1 <= 0L) {
        break label78;
      }
      l2 = paramInputStream.skip(l1);
      if (l2 > 0L)
      {
        l1 -= l2;
        continue;
        bool = false;
        break;
      }
      if (paramInputStream.read() == -1) {
        break label73;
      }
      l1 -= 1L;
    }
    label73:
    long l2 = paramLong - l1;
    label78:
    return l2;
  }
  
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    return a(paramInputStream, paramInputStream.available());
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    ByteArrayOutputStream local1 = new ByteArrayOutputStream(paramInt)
    {
      public byte[] toByteArray()
      {
        if (this.count == this.buf.length) {
          return this.buf;
        }
        return super.toByteArray();
      }
    };
    b.a(paramInputStream, local1);
    return local1.toByteArray();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/m/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */