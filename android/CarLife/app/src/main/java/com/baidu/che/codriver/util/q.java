package com.baidu.che.codriver.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class q
{
  public static String a(File paramFile)
    throws Exception
  {
    Object localObject3 = null;
    try
    {
      DataInputStream localDataInputStream = new DataInputStream(new FileInputStream(paramFile));
      if (paramFile == null) {
        break label57;
      }
    }
    finally
    {
      try
      {
        paramFile = new byte[(int)paramFile.length()];
        localDataInputStream.readFully(paramFile);
        paramFile = b(paramFile);
        if (localDataInputStream != null) {
          localDataInputStream.close();
        }
        return paramFile;
      }
      finally
      {
        paramFile = (File)localObject1;
        Object localObject2 = localObject4;
      }
      localObject1 = finally;
      paramFile = (File)localObject3;
    }
    paramFile.close();
    label57:
    throw ((Throwable)localObject1);
  }
  
  /* Error */
  static void a(String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 45	com/baidu/che/codriver/util/q:a	(Ljava/lang/String;)[B
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_0
    //   7: new 47	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 51	java/io/FileOutputStream:write	([B)V
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: invokevirtual 52	java/io/FileOutputStream:close	()V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: ifnull +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 52	java/io/FileOutputStream:close	()V
    //   39: aload_1
    //   40: athrow
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: aload_2
    //   45: astore_1
    //   46: goto -15 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramString	String
    //   0	49	1	paramFile	File
    //   4	14	2	arrayOfByte	byte[]
    //   41	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	30	finally
    //   16	21	41	finally
  }
  
  public static void a(String[] paramArrayOfString)
    throws Exception
  {
    paramArrayOfString = new File("test.bin");
    a("百度一下, 度秘你好", paramArrayOfString);
    paramArrayOfString = a(paramArrayOfString);
    System.out.println(String.format("in: %s, out: %s, equal ? %s", new Object[] { "百度一下, 度秘你好", paramArrayOfString, Boolean.valueOf("百度一下, 度秘你好".equals(paramArrayOfString)) }));
  }
  
  public static byte[] a(String paramString)
    throws Exception
  {
    if ((paramString == null) && (paramString.length() == 0)) {
      throw new Exception("bad input!");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (localStringBuilder.length() < 512) {
      localStringBuilder.append(paramString + "\r\n");
    }
    return a(localStringBuilder.toString().toString().getBytes("UTF-8"));
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0xFFFFFFFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  static String b(byte[] paramArrayOfByte)
    throws Exception
  {
    return new Scanner(new String(a(paramArrayOfByte), "UTF-8")).nextLine();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */