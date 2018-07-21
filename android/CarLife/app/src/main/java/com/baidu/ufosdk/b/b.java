package com.baidu.ufosdk.b;

import java.io.IOException;
import java.io.InputStream;

final class b
  implements Runnable
{
  b(Process paramProcess) {}
  
  public final void run()
  {
    try
    {
      InputStream localInputStream = this.a.getErrorStream();
      byte[] arrayOfByte = new byte[' '];
      int i;
      do
      {
        i = localInputStream.read(arrayOfByte);
      } while (i >= 0);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */