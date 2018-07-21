package com.facebook.h;

import java.io.IOException;
import java.io.InputStream;

class c
{
  public static int a(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (j < paramInt)
    {
      int k = paramInputStream.read();
      if (k == -1) {
        throw new IOException("no more bytes");
      }
      if (paramBoolean) {
        i |= (k & 0xFF) << j * 8;
      }
      for (;;)
      {
        j += 1;
        break;
        i = i << 8 | k & 0xFF;
      }
    }
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */