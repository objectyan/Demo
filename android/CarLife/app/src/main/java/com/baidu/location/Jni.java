package com.baidu.location;

public class Jni
{
  private static int a = 0;
  private static int b = 1;
  private static int c = 2;
  private static int d = 11;
  private static int e = 12;
  private static int f = 13;
  private static int g = 14;
  private static int h = 15;
  private static int i = 1024;
  private static boolean j = false;
  
  static
  {
    try
    {
      System.loadLibrary("locSDK7a");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      j = true;
    }
  }
  
  private static native String a(byte[] paramArrayOfByte, int paramInt);
  
  private static native String b(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  
  private static native String c(byte[] paramArrayOfByte, int paramInt);
  
  public static double[] coorEncrypt(double paramDouble1, double paramDouble2, String paramString)
  {
    double[] arrayOfDouble = new double[2];
    double[] tmp7_5 = arrayOfDouble;
    tmp7_5[0] = 0.0D;
    double[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0.0D;
    tmp11_7;
    if (j) {
      return tmp11_7;
    }
    int k = -1;
    if (paramString.equals("bd09"))
    {
      k = a;
      if (!paramString.equals("gcj2wgs")) {
        break label211;
      }
      k = 16;
    }
    label211:
    for (;;)
    {
      try
      {
        paramString = b(paramDouble1, paramDouble2, k, 132456).split(":");
        tmp11_7[0] = Double.parseDouble(paramString[0]);
        tmp11_7[1] = Double.parseDouble(paramString[1]);
        return tmp11_7;
        if (paramString.equals("bd09ll"))
        {
          k = b;
          break;
        }
        if (paramString.equals("gcj02"))
        {
          k = c;
          break;
        }
        if (paramString.equals("gps2gcj"))
        {
          k = d;
          break;
        }
        if (paramString.equals("bd092gcj"))
        {
          k = e;
          break;
        }
        if (paramString.equals("bd09ll2gcj"))
        {
          k = f;
          break;
        }
        if (!paramString.equals("wgs842mc")) {
          break;
        }
        k = h;
      }
      catch (UnsatisfiedLinkError paramString) {}
    }
  }
  
  public static String decodeIBeacon(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (j) {
      return null;
    }
    return ib(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private static native String ee(String paramString, int paramInt);
  
  public static String en1(String paramString)
  {
    int k = 740;
    int m = 0;
    if (j) {
      return "err!";
    }
    if (paramString == null) {
      return "null";
    }
    paramString = paramString.getBytes();
    byte[] arrayOfByte = new byte[i];
    int n = paramString.length;
    if (n > 740) {}
    for (;;)
    {
      int i1;
      for (n = 0; m < k; n = i1)
      {
        i1 = n;
        if (paramString[m] != 0)
        {
          arrayOfByte[n] = paramString[m];
          i1 = n + 1;
        }
        m += 1;
      }
      try
      {
        paramString = a(arrayOfByte, 132456);
        return paramString;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
        return "err!";
      }
      k = n;
    }
  }
  
  public static String encode(String paramString)
  {
    if (j) {
      return "err!";
    }
    return en1(paramString) + "|tp=3";
  }
  
  public static String encode2(String paramString)
  {
    if (j) {
      return "err!";
    }
    if (paramString == null) {
      return "null";
    }
    paramString = paramString.getBytes();
    try
    {
      paramString = c(paramString, 132456);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "err!";
  }
  
  public static Long encode3(String paramString)
  {
    if (j) {
      return null;
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          long l = murmur(paramString);
          return Long.valueOf(l);
        }
        catch (UnsatisfiedLinkError paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString = "";
      }
    }
    return null;
  }
  
  private static native String encodeNotLimit(String paramString, int paramInt);
  
  public static String encodeOfflineLocationUpdateRequest(String paramString)
  {
    if (j) {
      return "err!";
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      try
      {
        for (;;)
        {
          paramString = encodeNotLimit(paramString, 132456);
          return paramString + "|tp=3";
          paramString = paramString;
          paramString = "";
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = "err!";
        }
      }
    }
  }
  
  public static String encodeTp4(String paramString)
  {
    if (j) {
      return "err!";
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      try
      {
        for (;;)
        {
          paramString = ee(paramString, 132456);
          return paramString + "|tp=4";
          paramString = paramString;
          paramString = "";
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = "err!";
        }
      }
    }
  }
  
  private static native void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native String g(byte[] paramArrayOfByte);
  
  public static double getGpsSwiftRadius(float paramFloat, double paramDouble1, double paramDouble2)
  {
    if (j) {
      return 0.0D;
    }
    try
    {
      paramDouble1 = gsr(paramFloat, paramDouble1, paramDouble2);
      return paramDouble1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0.0D;
  }
  
  public static String getSkyKey()
  {
    if (j) {
      return "err!";
    }
    try
    {
      String str = sky();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return "err!";
  }
  
  private static native double gsr(float paramFloat, double paramDouble1, double paramDouble2);
  
  public static String gtr2(String paramString)
  {
    if (j) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = g(paramString.getBytes());
        if ((paramString != null) && (paramString.length() >= 2) && (!"no".equals(paramString))) {
          return paramString;
        }
      }
      catch (UnsatisfiedLinkError paramString) {}
    }
    return null;
  }
  
  private static native String ib(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native long murmur(String paramString);
  
  public static void removeSoList(int paramInt, String paramString) {}
  
  private static native String sky();
  
  public static void tr2(String paramString1, String paramString2)
  {
    if (j) {
      return;
    }
    try
    {
      f(paramString1.getBytes(), paramString2.getBytes());
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static native void uninstall(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/Jni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */