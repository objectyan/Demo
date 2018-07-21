package com.baidu.platform.comapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  protected static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int MD5_16_LENGTH = 16;
  private static final int MD5_16_START = 8;
  private static final int MD5_LENGTH = 32;
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = HEX_DIGITS[((paramByte & 0xF0) >> 4)];
    char c2 = HEX_DIGITS[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean checkPassword(String paramString1, String paramString2)
  {
    return getMD5String(paramString1).equals(paramString2);
  }
  
  public static String getFileMD5String(File paramFile)
    throws IOException
  {
    return getFileMD5String(paramFile, 131072);
  }
  
  public static String getFileMD5String(File paramFile, int paramInt)
    throws IOException
  {
    Object localObject1 = null;
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      localObject1 = localObject2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (localObject1 == null) {
      return "";
    }
    paramFile = new FileInputStream(paramFile);
    localObject2 = new byte[paramInt];
    for (;;)
    {
      paramInt = paramFile.read((byte[])localObject2);
      if (paramInt <= 0) {
        break;
      }
      ((MessageDigest)localObject1).update((byte[])localObject2, 0, paramInt);
    }
    paramFile.close();
    try
    {
      paramFile = bufferToHex(((MessageDigest)localObject1).digest());
      return paramFile;
    }
    catch (Exception paramFile)
    {
      throw new IOException(paramFile.toString());
    }
  }
  
  public static String getFileMD5StringNIO(File paramFile)
    throws IOException
  {
    return getFileMD5StringNIO(paramFile, 131072);
  }
  
  public static String getFileMD5StringNIO(File paramFile, int paramInt)
    throws IOException
  {
    Object localObject1 = null;
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      localObject1 = localObject2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Object localObject2;
      ByteBuffer localByteBuffer;
      for (;;) {}
    }
    if (localObject1 == null) {
      return "";
    }
    paramFile = new FileInputStream(paramFile);
    localObject2 = paramFile.getChannel();
    localByteBuffer = ByteBuffer.allocate(paramInt);
    for (paramInt = ((FileChannel)localObject2).read(localByteBuffer); paramInt != -1; paramInt = ((FileChannel)localObject2).read(localByteBuffer))
    {
      localByteBuffer.flip();
      ((MessageDigest)localObject1).update(localByteBuffer);
      if (!localByteBuffer.hasRemaining()) {
        localByteBuffer.clear();
      }
    }
    paramFile.close();
    try
    {
      paramFile = bufferToHex(((MessageDigest)localObject1).digest());
      return paramFile;
    }
    catch (Exception paramFile)
    {
      throw new IOException(paramFile.toString());
    }
  }
  
  public static String getMD5String(String paramString)
  {
    return getMD5String(paramString.getBytes());
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;) {}
    }
    if (localObject == null) {
      return "";
    }
    ((MessageDigest)localObject).update(paramArrayOfByte);
    try
    {
      paramArrayOfByte = bufferToHex(((MessageDigest)localObject).digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      return "";
    }
  }
  
  public static String getMD5String16(String paramString)
  {
    paramString = getMD5String(paramString.getBytes());
    if (paramString.length() == 32) {
      return paramString.substring(8, 24);
    }
    return null;
  }
  
  public static String getSignMD5String(String paramString)
  {
    return URLEncodeUtils.generateSign(1, paramString);
  }
  
  public static String getWebSignMD5String(String paramString)
  {
    return URLEncodeUtils.generateSign(2, paramString);
  }
  
  public static String signOpra(String paramString)
  {
    return URLEncodeUtils.generateSign(3, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */