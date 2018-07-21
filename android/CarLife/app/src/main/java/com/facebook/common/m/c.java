package com.facebook.common.m;

public class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] b = new char['Ā'];
  private static final char[] c = new char['Ā'];
  private static final byte[] d;
  
  static
  {
    int j = 0;
    while (j < 256)
    {
      b[j] = a[(j >> 4 & 0xF)];
      c[j] = a[(j & 0xF)];
      j += 1;
    }
    d = new byte[103];
    j = 0;
    while (j <= 70)
    {
      d[j] = -1;
      j += 1;
    }
    for (int i = 0; i < 10; i = (byte)(i + 1)) {
      d[(i + 48)] = i;
    }
    for (j = 0; j < 6; j = (byte)(j + 1))
    {
      d[(j + 65)] = ((byte)(j + 10));
      d[(j + 97)] = ((byte)(j + 10));
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt > 255) || (paramInt < 0)) {
      throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }
    return String.valueOf(b[paramInt]) + String.valueOf(c[paramInt]);
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < paramArrayOfByte.length)
      {
        k = paramArrayOfByte[i] & 0xFF;
        if ((k != 0) || (!paramBoolean)) {}
      }
      else
      {
        return new String(arrayOfChar, 0, j);
      }
      int m = j + 1;
      arrayOfChar[j] = b[k];
      j = m + 1;
      arrayOfChar[m] = c[k];
      i += 1;
    }
  }
  
  public static byte[] a(String paramString)
  {
    int m = paramString.length();
    if ((m & 0x1) != 0) {
      throw new IllegalArgumentException("Odd number of characters.");
    }
    int k = 0;
    byte[] arrayOfByte = new byte[m >> 1];
    int i = 0;
    int j = 0;
    int n;
    if (j < m)
    {
      n = j + 1;
      j = paramString.charAt(j);
      if (j > 102) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + paramString);
        int i1 = d[j];
        if (i1 == -1)
        {
          i = 1;
          continue;
        }
        j = n + 1;
        n = paramString.charAt(n);
        if (n > 102)
        {
          i = 1;
          continue;
        }
        n = d[n];
        if (n == -1)
        {
          i = 1;
          continue;
        }
        arrayOfByte[i] = ((byte)(i1 << 4 | n));
        i += 1;
        break;
      }
      return arrayOfByte;
      i = k;
    }
  }
  
  public static byte[] b(String paramString)
  {
    return a(paramString.replaceAll(" ", ""));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */