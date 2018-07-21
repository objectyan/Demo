package cz.msebera.android.httpclient.o;

import cz.msebera.android.httpclient.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class f
{
  public static String a(byte[] paramArrayOfByte)
  {
    a.a(paramArrayOfByte, "Input");
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.a(paramArrayOfByte, "Input");
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, c.f.name());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new Error("ASCII not supported");
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    a.a(paramArrayOfByte, "Input");
    a.a(paramString, "Charset");
    try
    {
      paramString = new String(paramArrayOfByte, paramInt1, paramInt2, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    a.a(paramArrayOfByte, "Input");
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramString);
  }
  
  public static byte[] a(String paramString)
  {
    a.a(paramString, "Input");
    try
    {
      paramString = paramString.getBytes(c.f.name());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new Error("ASCII not supported");
    }
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    a.a(paramString1, "Input");
    a.a(paramString2, "Charset");
    try
    {
      paramString2 = paramString1.getBytes(paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2) {}
    return paramString1.getBytes();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */