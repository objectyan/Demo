package com.facebook.b.a;

import com.facebook.common.internal.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class k
{
  public static j a(InputStream paramInputStream)
  {
    new j()
    {
      public void a(OutputStream paramAnonymousOutputStream)
        throws IOException
      {
        b.a(this.a, paramAnonymousOutputStream);
      }
    };
  }
  
  public static j a(byte[] paramArrayOfByte)
  {
    new j()
    {
      public void a(OutputStream paramAnonymousOutputStream)
        throws IOException
      {
        paramAnonymousOutputStream.write(this.a);
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */