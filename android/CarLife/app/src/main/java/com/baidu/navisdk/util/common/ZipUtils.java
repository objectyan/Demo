package com.baidu.navisdk.util.common;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  private static final String TAG = "ZipUtils";
  
  public static void closeStrem(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (Exception paramCloseable)
      {
        paramCloseable.printStackTrace();
        LogUtil.e("ZipUtils", "closeQuietly closeable failed");
        return;
      }
    }
    LogUtil.e("ZipUtils", "closeQuietly closeable is null");
  }
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramInputStream != null) && (paramOutputStream != null))
    {
      Object localObject = paramInputStream;
      if (!(paramInputStream instanceof BufferedInputStream)) {
        localObject = new BufferedInputStream(paramInputStream);
      }
      paramInputStream = paramOutputStream;
      if (!(paramOutputStream instanceof BufferedOutputStream)) {
        paramInputStream = new BufferedOutputStream(paramOutputStream);
      }
      paramOutputStream = new byte[' '];
      for (;;)
      {
        int i = ((InputStream)localObject).read(paramOutputStream);
        if (i == -1) {
          break;
        }
        paramInputStream.write(paramOutputStream, 0, i);
      }
      paramInputStream.flush();
      return;
    }
    LogUtil.e("ZipUtils", "copyStream : outputStream or inputStream is null");
  }
  
  public static ZipOutputStream getZipOutputStream(File paramFile)
    throws FileNotFoundException
  {
    return new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile)));
  }
  
  public static void unzip(File paramFile, String paramString)
    throws IOException
  {
    LogUtil.e("ZipUtils", "unzip " + paramFile + " " + paramString);
    if ((paramFile == null) || (TextUtils.isEmpty(paramString)))
    {
      LogUtil.e("ZipUtils", "unzipPart : path or partName is null");
      throw new IOException("unzipPart : path or partName is null");
    }
    paramFile = new ZipFile(paramFile);
    Enumeration localEnumeration = paramFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      if ((!localZipEntry.isDirectory()) && (!localZipEntry.getName().contains("../"))) {
        writeToFile(new File(paramString, localZipEntry.getName()), paramFile.getInputStream(localZipEntry));
      }
    }
    paramFile.close();
  }
  
  public static void writeToFile(File paramFile, InputStream paramInputStream)
    throws IOException
  {
    if ((paramFile != null) && (paramInputStream != null))
    {
      LogUtil.e("ZipUtils", "writeToFile " + paramFile.getAbsolutePath());
      File localFile = paramFile.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      if (!localFile.exists()) {
        throw new IOException("Can't create dir " + localFile.getAbsolutePath());
      }
      copyStream(paramInputStream, new FileOutputStream(paramFile));
      return;
    }
    LogUtil.e("ZipUtils", "writeToFile : file or inputStream is null");
  }
  
  /* Error */
  public static void zip(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: bipush 6
    //   5: invokevirtual 182	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   8: new 41	java/io/BufferedInputStream
    //   11: dup
    //   12: new 184	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_0
    //   24: aload_1
    //   25: new 129	java/util/zip/ZipEntry
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 186	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 190	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 174	com/baidu/navisdk/util/common/ZipUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   41: aload_0
    //   42: invokestatic 192	com/baidu/navisdk/util/common/ZipUtils:closeStrem	(Ljava/io/Closeable;)V
    //   45: return
    //   46: astore_1
    //   47: aload_3
    //   48: astore_0
    //   49: aload_0
    //   50: invokestatic 192	com/baidu/navisdk/util/common/ZipUtils:closeStrem	(Ljava/io/Closeable;)V
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: goto -7 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramFile	File
    //   0	59	1	paramZipOutputStream	ZipOutputStream
    //   0	59	2	paramString	String
    //   1	47	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	46	finally
    //   24	41	55	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */