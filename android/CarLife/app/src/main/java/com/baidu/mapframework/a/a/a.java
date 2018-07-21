package com.baidu.mapframework.a.a;

import android.text.TextUtils;
import com.baidu.mapframework.commonlib.utils.IO;
import com.baidu.platform.comapi.util.f;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class a
{
  private static final String a = a.class.getName();
  
  /* Error */
  public static void a(File paramFile1, File paramFile2, String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 25	java/util/zip/ZipOutputStream
    //   9: dup
    //   10: new 27	java/io/BufferedOutputStream
    //   13: dup
    //   14: new 29	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 32	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokespecial 35	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: invokespecial 36	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_1
    //   29: aload_1
    //   30: iload_3
    //   31: invokevirtual 40	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   34: aload_1
    //   35: iload 4
    //   37: invokevirtual 43	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   40: new 45	java/io/BufferedInputStream
    //   43: dup
    //   44: new 47	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 51	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_0
    //   56: aload_1
    //   57: new 53	java/util/zip/ZipEntry
    //   60: dup
    //   61: aload_2
    //   62: invokespecial 56	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 60	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   68: aload_0
    //   69: aload_1
    //   70: invokestatic 66	com/baidu/mapframework/commonlib/utils/IO:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   73: aload_1
    //   74: invokestatic 70	com/baidu/mapframework/commonlib/utils/IO:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload_0
    //   78: invokestatic 70	com/baidu/mapframework/commonlib/utils/IO:closeQuietly	(Ljava/io/Closeable;)V
    //   81: return
    //   82: astore_1
    //   83: aload 6
    //   85: astore_0
    //   86: aload 5
    //   88: astore_2
    //   89: aload_0
    //   90: invokestatic 70	com/baidu/mapframework/commonlib/utils/IO:closeQuietly	(Ljava/io/Closeable;)V
    //   93: aload_2
    //   94: invokestatic 70	com/baidu/mapframework/commonlib/utils/IO:closeQuietly	(Ljava/io/Closeable;)V
    //   97: aload_1
    //   98: athrow
    //   99: astore 6
    //   101: aload_1
    //   102: astore_0
    //   103: aload 5
    //   105: astore_2
    //   106: aload 6
    //   108: astore_1
    //   109: goto -20 -> 89
    //   112: astore 5
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload 5
    //   120: astore_1
    //   121: goto -32 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramFile1	File
    //   0	124	1	paramFile2	File
    //   0	124	2	paramString	String
    //   0	124	3	paramInt1	int
    //   0	124	4	paramInt2	int
    //   4	100	5	localObject1	Object
    //   112	7	5	localObject2	Object
    //   1	83	6	localObject3	Object
    //   99	8	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	29	82	finally
    //   29	56	99	finally
    //   56	73	112	finally
  }
  
  public static void a(@Nullable File paramFile, @Nullable String paramString)
    throws IOException
  {
    f.b(a, "unzip " + paramFile + " " + paramString);
    if ((paramFile == null) || (TextUtils.isEmpty(paramString)))
    {
      f.e(a, "unzipPart : path or partName is null");
      throw new IOException("unzipPart : path or partName is null");
    }
    paramFile = new ZipFile(paramFile);
    Enumeration localEnumeration = paramFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      if ((!localZipEntry.isDirectory()) && (!localZipEntry.getName().contains("../"))) {
        IO.writeToFile(new File(paramString, localZipEntry.getName()), paramFile.getInputStream(localZipEntry));
      }
    }
    paramFile.close();
  }
  
  @NotNull
  public static byte[] b(@Nullable File paramFile, @Nullable String paramString)
    throws IOException
  {
    f.b(a, "unzipPart " + paramFile + " " + paramString);
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      throw new IOException("unzipPart : path or partName is null");
    }
    ZipFile localZipFile = new ZipFile(paramFile);
    paramFile = null;
    try
    {
      paramString = localZipFile.getInputStream(localZipFile.getEntry(paramString));
      paramFile = paramString;
      byte[] arrayOfByte = IO.inputStreamToBytes(paramString);
      return arrayOfByte;
    }
    finally
    {
      IO.closeQuietly(paramFile);
      localZipFile.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */