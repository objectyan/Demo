package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class gn
  implements Closeable
{
  private byte[] e()
    throws IOException
  {
    long l = b();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    ip localip = c();
    try
    {
      byte[] arrayOfByte1 = localip.n();
      gy.a(localip);
      if ((l != -1L) && (l != arrayOfByte1.length)) {
        throw new IOException("Content-Length and stream length disagree");
      }
    }
    finally
    {
      gy.a(localip);
    }
    return arrayOfByte2;
  }
  
  public abstract gg a();
  
  public abstract long b();
  
  public abstract ip c();
  
  public void close()
  {
    gy.a(c());
  }
  
  public final String d()
    throws IOException
  {
    byte[] arrayOfByte = e();
    gg localgg = a();
    if (localgg != null)
    {
      localCharset = gy.c;
      if (localgg.a == null) {}
    }
    for (Charset localCharset = Charset.forName(localgg.a);; localCharset = gy.c) {
      return new String(arrayOfByte, localCharset.name());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */