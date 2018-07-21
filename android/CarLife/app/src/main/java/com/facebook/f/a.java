package com.facebook.f;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final int a = 10;
  private static final byte[] b = { 0, 33, -7, 4 };
  private static final byte[] c = { 0, 44 };
  private static final byte[] d = { 0, 33 };
  
  public static boolean a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[10];
    int k;
    label107:
    do
    {
      try
      {
        paramInputStream.read(arrayOfByte, 0, 10);
        int i = 0;
        for (k = 0; paramInputStream.read(arrayOfByte, i, 1) > 0; k = j)
        {
          j = k;
          if (a(arrayOfByte, i + 1, b))
          {
            if (a(arrayOfByte, i + 9, c)) {
              break label107;
            }
            j = k;
            if (a(arrayOfByte, i + 9, d)) {
              break label107;
            }
          }
          i = (i + 1) % arrayOfByte.length;
        }
        return false;
      }
      catch (IOException paramInputStream)
      {
        throw new RuntimeException(paramInputStream);
      }
      k += 1;
      int j = k;
    } while (k <= 1);
    return true;
  }
  
  @VisibleForTesting
  static boolean a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    k.a(paramArrayOfByte1);
    k.a(paramArrayOfByte2);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.a(bool);
      if (paramArrayOfByte2.length <= paramArrayOfByte1.length) {
        break;
      }
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label66;
      }
      if (paramArrayOfByte1[((i + paramInt) % paramArrayOfByte1.length)] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label66:
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */