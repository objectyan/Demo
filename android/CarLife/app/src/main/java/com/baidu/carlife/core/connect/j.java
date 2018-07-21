package com.baidu.carlife.core.connect;

public class j
{
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt2 = Integer.parseInt(paramString, paramInt2);
      return paramInt2;
    }
    catch (NumberFormatException paramString) {}
    return paramInt1;
  }
  
  public static String a(int paramInt)
  {
    String str2 = Integer.toHexString(paramInt);
    String str1 = str2;
    if (str2.length() % 2 == 1) {
      str1 = "0" + str2;
    }
    return str1.toUpperCase();
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str2 = Integer.toHexString(paramInt1);
    String str1 = str2;
    if (str2.length() % 2 == 1) {
      str1 = "0" + str2;
    }
    return b(str1.toUpperCase(), paramInt2);
  }
  
  public static String a(String paramString)
  {
    String str1 = "";
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      String str2 = Integer.toHexString(paramString.charAt(i));
      str1 = str1 + str2;
      i += 1;
    }
    return str1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = "";
    int j = paramString.length() / paramInt;
    int i = 0;
    while (i < j)
    {
      char c = (char)b(paramString.substring(i * paramInt, (i + 1) * paramInt));
      str = str + c;
      i += 1;
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      char c = (char)paramArrayOfByte[i];
      str = str + c;
      i += 1;
    }
    return str;
  }
  
  public static int b(String paramString)
  {
    paramString = paramString.toUpperCase();
    int m = paramString.length();
    int j = 0;
    int i = m;
    if (i > 0)
    {
      int k = paramString.charAt(i - 1);
      if ((k >= 48) && (k <= 57)) {
        k -= 48;
      }
      for (;;)
      {
        j = (int)(j + Math.pow(16.0D, m - i) * k);
        i -= 1;
        break;
        k -= 55;
      }
    }
    return j;
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str = "";
    int i = 0;
    while (i < paramInt - paramString.length())
    {
      str = "0" + str;
      i += 1;
    }
    return (str + paramString).substring(0, paramInt);
  }
  
  public static final String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toUpperCase();
  }
  
  public static int c(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static String c(String paramString)
  {
    String str2 = paramString.toUpperCase();
    String str1 = "";
    int j = str2.length();
    int i = 0;
    if (i < j)
    {
      paramString = str1;
      switch (str2.charAt(i))
      {
      default: 
        paramString = str1;
      }
      for (;;)
      {
        i += 1;
        str1 = paramString;
        break;
        paramString = str1 + "0000";
        continue;
        paramString = str1 + "0001";
        continue;
        paramString = str1 + "0010";
        continue;
        paramString = str1 + "0011";
        continue;
        paramString = str1 + "0100";
        continue;
        paramString = str1 + "0101";
        continue;
        paramString = str1 + "0110";
        continue;
        paramString = str1 + "0111";
        continue;
        paramString = str1 + "1000";
        continue;
        paramString = str1 + "1001";
        continue;
        paramString = str1 + "1010";
        continue;
        paramString = str1 + "1011";
        continue;
        paramString = str1 + "1100";
        continue;
        paramString = str1 + "1101";
        continue;
        paramString = str1 + "1110";
        continue;
        paramString = str1 + "1111";
      }
    }
    return str1;
  }
  
  public static String d(String paramString)
  {
    String str = "";
    int j = paramString.length() / 2;
    int i = 0;
    while (i < j)
    {
      char c = (char)b(paramString.substring(i * 2, i * 2 + 2));
      str = str + String.valueOf(c);
      i += 1;
    }
    return str;
  }
  
  public static int e(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    int i = k;
    while (i > 0)
    {
      int m = paramString.charAt(i - 1);
      j = (int)(j + Math.pow(2.0D, k - i) * (m - 48));
      i -= 1;
    }
    return j;
  }
  
  public static byte[] f(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    paramString = c(paramString);
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = ((byte)e(paramString.substring(i * 8 + 1, (i + 1) * 8)));
      if (paramString.charAt(i * 8) == '1') {
        arrayOfByte[i] = ((byte)(0 - arrayOfByte[i]));
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static final byte[] g(String paramString)
    throws IllegalArgumentException
  {
    if (paramString.length() % 2 != 0) {
      throw new IllegalArgumentException();
    }
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int j = 0;
    int k = paramString.length();
    int m;
    for (int i = 0; i < k; i = m + 1)
    {
      paramString = new StringBuilder().append("");
      m = i + 1;
      arrayOfByte[j] = new Integer(Integer.parseInt(arrayOfChar[i] + arrayOfChar[m], 16) & 0xFF).byteValue();
      j += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */