package com.baidu.mapframework.commonlib.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class IOUitls
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Object localObject = paramInputStream;
    if (!(paramInputStream instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream);
    }
    paramInputStream = paramOutputStream;
    if (!(paramOutputStream instanceof BufferedOutputStream)) {
      paramInputStream = new BufferedOutputStream(paramOutputStream);
    }
    paramOutputStream = new byte['Ȁ'];
    for (;;)
    {
      int i = ((InputStream)localObject).read(paramOutputStream);
      if (i == -1) {
        break;
      }
      paramInputStream.write(paramOutputStream, 0, i);
    }
    paramInputStream.flush();
  }
  
  public static void copyQuietly(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      copy(paramInputStream, paramOutputStream);
      closeQuietly(paramInputStream);
      closeQuietly(paramOutputStream);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      closeQuietly(paramInputStream);
      closeQuietly(paramOutputStream);
      return;
    }
    finally
    {
      localObject = finally;
      closeQuietly(paramInputStream);
      closeQuietly(paramOutputStream);
      throw ((Throwable)localObject);
    }
  }
  
  public static String readFile(File paramFile, String paramString)
  {
    if (!paramFile.isFile()) {
      throw new IllegalArgumentException(paramFile.getAbsolutePath() + " is not a File");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      copyQuietly(new FileInputStream(paramFile), localByteArrayOutputStream);
      paramFile = localByteArrayOutputStream.toString(paramString);
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new RuntimeException(paramFile);
    }
    catch (FileNotFoundException paramFile) {}
    return "";
  }
  
  public static String readFile(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("filePath is empty");
    }
    File localFile = new File(paramString1);
    if (!localFile.isFile()) {
      throw new IllegalArgumentException(paramString1 + " is not a File");
    }
    paramString1 = new ByteArrayOutputStream();
    try
    {
      copyQuietly(new FileInputStream(localFile), paramString1);
      paramString1 = paramString1.toString(paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (FileNotFoundException paramString1) {}
    return "";
  }
  
  public static byte[] readFile(File paramFile)
  {
    if (!paramFile.isFile()) {
      throw new IllegalArgumentException(paramFile.getAbsolutePath() + " is not a File");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      copyQuietly(new FileInputStream(paramFile), localByteArrayOutputStream);
      paramFile = localByteArrayOutputStream.toByteArray();
      return paramFile;
    }
    catch (FileNotFoundException paramFile) {}
    return new byte[0];
  }
  
  public static byte[] readFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("filePath is empty");
    }
    File localFile = new File(paramString);
    if (!localFile.isFile()) {
      throw new IllegalArgumentException(paramString + " is not a File");
    }
    paramString = new ByteArrayOutputStream();
    try
    {
      copyQuietly(new FileInputStream(localFile), paramString);
      paramString = paramString.toByteArray();
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return new byte[0];
  }
  
  public static void writeToFile(File paramFile, InputStream paramInputStream)
  {
    File localFile = paramFile.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!localFile.exists()) {
      throw new IllegalStateException("Can't create dir " + localFile.getAbsolutePath());
    }
    try
    {
      copyQuietly(paramInputStream, new FileOutputStream(paramFile));
      return;
    }
    catch (FileNotFoundException paramFile) {}
  }
  
  public static void writeToFile(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      writeToFile(paramFile, paramString1.getBytes(paramString2));
      return;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new IllegalArgumentException(paramFile);
    }
  }
  
  public static void writeToFile(File paramFile, byte[] paramArrayOfByte)
  {
    writeToFile(paramFile.getAbsolutePath(), paramArrayOfByte);
  }
  
  public static void writeToFile(String paramString, InputStream paramInputStream)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("filePath is empty");
    }
    paramString = new File(paramString);
    File localFile = paramString.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!localFile.exists()) {
      throw new IllegalStateException("Can't create dir " + localFile.getAbsolutePath());
    }
    try
    {
      copyQuietly(paramInputStream, new FileOutputStream(paramString));
      return;
    }
    catch (FileNotFoundException paramString) {}
  }
  
  public static void writeToFile(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      writeToFile(paramString1, paramString2.getBytes(paramString3));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public static void writeToFile(String paramString, byte[] paramArrayOfByte)
  {
    writeToFile(paramString, new ByteArrayInputStream(paramArrayOfByte));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/IOUitls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */