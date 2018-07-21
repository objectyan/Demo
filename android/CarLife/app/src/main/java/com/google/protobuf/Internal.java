package com.google.protobuf;

import java.io.UnsupportedEncodingException;

public class Internal
{
  public static ByteString bytesDefaultValue(String paramString)
  {
    try
    {
      paramString = ByteString.copyFrom(paramString.getBytes("ISO-8859-1"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static String stringDefaultValue(String paramString)
  {
    try
    {
      paramString = new String(paramString.getBytes("ISO-8859-1"), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", paramString);
    }
  }
  
  public static abstract interface EnumLite
  {
    public abstract int getNumber();
  }
  
  public static abstract interface EnumLiteMap<T extends Internal.EnumLite>
  {
    public abstract T findValueByNumber(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */