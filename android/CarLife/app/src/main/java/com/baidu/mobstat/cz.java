package com.baidu.mobstat;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cz
{
  public static String a(File paramFile)
  {
    try
    {
      paramFile = cy.a(MessageDigest.getInstance("SHA-256"), paramFile);
      return paramFile;
    }
    catch (NoSuchAlgorithmException paramFile)
    {
      db.b(paramFile);
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = cy.a(MessageDigest.getInstance("SHA-256"), paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      db.b(paramArrayOfByte);
    }
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */