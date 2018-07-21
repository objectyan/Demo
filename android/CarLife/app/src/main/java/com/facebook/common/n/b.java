package com.facebook.common.n;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

public class b
{
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static a d;
  public static boolean e = false;
  private static final String f = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
  private static final int g = 20;
  private static final int h = 21;
  private static final byte[] i;
  private static final byte[] j;
  private static final byte[] k;
  private static final byte[] l;
  private static final byte[] m;
  
  static
  {
    boolean bool2 = true;
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 17) {
      bool1 = true;
    }
    for (;;)
    {
      a = bool1;
      if (Build.VERSION.SDK_INT >= 14)
      {
        bool1 = bool2;
        b = bool1;
        c = a();
        d = null;
        e = false;
      }
      try
      {
        d = (a)Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        e = true;
        i = a("RIFF");
        j = a("WEBP");
        k = a("VP8 ");
        l = a("VP8L");
        m = a("VP8X");
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          e = false;
        }
      }
    }
  }
  
  private static boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {}
    BitmapFactory.Options localOptions;
    do
    {
      return false;
      if (Build.VERSION.SDK_INT != 17) {
        break;
      }
      byte[] arrayOfByte = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    } while ((localOptions.outHeight != 1) || (localOptions.outWidth != 1));
    return true;
  }
  
  public static boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = a(paramArrayOfByte, paramInt + 12, m);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x2) == 2) {}
    for (paramInt = 1; (bool) && (paramInt != 0); paramInt = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (b(paramArrayOfByte, paramInt1)) {
      bool1 = b;
    }
    do
    {
      do
      {
        return bool1;
        if (c(paramArrayOfByte, paramInt1)) {
          return c;
        }
        bool1 = bool2;
      } while (!b(paramArrayOfByte, paramInt1, paramInt2));
      bool1 = bool2;
    } while (a(paramArrayOfByte, paramInt1));
    return c;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null)) {}
    while (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) {
      return false;
    }
    int n = 0;
    for (;;)
    {
      if (n >= paramArrayOfByte2.length) {
        break label45;
      }
      if (paramArrayOfByte1[(n + paramInt)] != paramArrayOfByte2[n]) {
        break;
      }
      n += 1;
    }
    label45:
    return true;
  }
  
  private static byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  public static boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, paramInt + 12, k);
  }
  
  public static boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 21) && (a(paramArrayOfByte, paramInt1 + 12, m));
  }
  
  public static boolean c(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, paramInt + 12, l);
  }
  
  public static boolean c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 20) && (a(paramArrayOfByte, paramInt1, i)) && (a(paramArrayOfByte, paramInt1 + 8, j));
  }
  
  public static boolean d(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = a(paramArrayOfByte, paramInt + 12, m);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x10) == 16) {}
    for (paramInt = 1; (bool) && (paramInt != 0); paramInt = 0) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */