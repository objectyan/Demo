package com.facebook.h;

import com.facebook.common.e.a;
import java.io.IOException;
import java.io.InputStream;

class d
{
  public static final int a = 1296891946;
  public static final int b = 1229531648;
  public static final int c = 274;
  public static final int d = 3;
  private static final Class<?> e = d.class;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      a.c(e, "Unsupported orientation");
    case 1: 
      return 0;
    case 3: 
      return 180;
    case 6: 
      return 90;
    }
    return 270;
  }
  
  public static int a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    a locala = new a(null);
    paramInt = a(paramInputStream, paramInt, locala);
    int i = locala.c - 8;
    if ((paramInt == 0) || (i > paramInt)) {
      return 0;
    }
    paramInputStream.skip(i);
    return a(paramInputStream, a(paramInputStream, paramInt - i, locala.a, 274), locala.a);
  }
  
  private static int a(InputStream paramInputStream, int paramInt, a parama)
    throws IOException
  {
    if (paramInt <= 8) {
      return 0;
    }
    parama.b = c.a(paramInputStream, 4, false);
    if ((parama.b != 1229531648) && (parama.b != 1296891946))
    {
      a.e(e, "Invalid TIFF header");
      return 0;
    }
    if (parama.b == 1229531648) {}
    for (boolean bool = true;; bool = false)
    {
      parama.a = bool;
      parama.c = c.a(paramInputStream, 4, parama.a);
      paramInt = paramInt - 4 - 4;
      if ((parama.c >= 8) && (parama.c - 8 <= paramInt)) {
        break;
      }
      a.e(e, "Invalid offset");
      return 0;
    }
    return paramInt;
  }
  
  private static int a(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramInt < 10) {}
    while ((c.a(paramInputStream, 2, paramBoolean) != 3) || (c.a(paramInputStream, 4, paramBoolean) != 1)) {
      return 0;
    }
    paramInt = c.a(paramInputStream, 2, paramBoolean);
    c.a(paramInputStream, 2, paramBoolean);
    return paramInt;
  }
  
  private static int a(InputStream paramInputStream, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 14) {}
    for (;;)
    {
      return 0;
      int i = c.a(paramInputStream, 2, paramBoolean);
      int j = paramInt1 - 2;
      paramInt1 = i;
      i = j;
      while ((paramInt1 > 0) && (i >= 12))
      {
        j = c.a(paramInputStream, 2, paramBoolean);
        i -= 2;
        if (j == paramInt2) {
          return i;
        }
        paramInputStream.skip(10L);
        i -= 10;
        paramInt1 -= 1;
      }
    }
  }
  
  private static class a
  {
    boolean a;
    int b;
    int c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */