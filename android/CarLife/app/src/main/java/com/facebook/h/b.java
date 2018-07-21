package com.facebook.h;

import com.facebook.common.internal.k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
{
  public static final int a = 255;
  public static final int b = 0;
  public static final int c = 216;
  public static final int d = 1;
  public static final int e = 217;
  public static final int f = 218;
  public static final int g = 225;
  public static final int h = 192;
  public static final int i = 208;
  public static final int j = 215;
  public static final int k = 1165519206;
  
  public static int a(int paramInt)
  {
    return d.a(paramInt);
  }
  
  public static int a(InputStream paramInputStream)
  {
    try
    {
      int m = b(paramInputStream);
      if (m == 0) {
        return 0;
      }
      m = d.a(paramInputStream, m);
      return m;
    }
    catch (IOException paramInputStream) {}
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static boolean a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    k.a(paramInputStream);
    while (c.a(paramInputStream, 1, false) == 255)
    {
      for (int m = 255; m == 255; m = c.a(paramInputStream, 1, false)) {}
      if ((paramInt == 192) && (b(m))) {}
      while (m == paramInt) {
        return true;
      }
      if ((m != 216) && (m != 1))
      {
        if ((m == 217) || (m == 218)) {
          return false;
        }
        paramInputStream.skip(c.a(paramInputStream, 2, false) - 2);
      }
    }
    return false;
  }
  
  private static int b(InputStream paramInputStream)
    throws IOException
  {
    if (a(paramInputStream, 225))
    {
      int m = c.a(paramInputStream, 2, false) - 2;
      if (m > 6)
      {
        int n = c.a(paramInputStream, 4, false);
        int i1 = c.a(paramInputStream, 2, false);
        if ((n == 1165519206) && (i1 == 0)) {
          return m - 4 - 2;
        }
      }
    }
    return 0;
  }
  
  private static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 196: 
    case 200: 
    case 204: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */