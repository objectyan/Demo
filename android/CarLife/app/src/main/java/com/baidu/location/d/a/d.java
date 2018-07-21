package com.baidu.location.d.a;

import com.baidu.location.Jni;
import com.baidu.location.h.b;
import com.baidu.location.h.g;
import java.io.File;

public class d
{
  static String[] a = { "lbaca.dat", "lbacb.dat", "lbacc.dat", "lbacd.dat" };
  private static d b;
  
  public static d a()
  {
    if (b == null) {
      b = new d();
    }
    return b;
  }
  
  /* Error */
  static void a(StringBuffer paramStringBuffer, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 39	java/io/File:exists	()Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: new 41	java/io/FileOutputStream
    //   13: dup
    //   14: aload_1
    //   15: iconst_1
    //   16: invokespecial 44	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_1
    //   20: new 46	java/util/zip/GZIPOutputStream
    //   23: dup
    //   24: new 48	java/io/BufferedOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 51	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 52	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_3
    //   41: if_icmpge +19 -> 60
    //   44: aload 4
    //   46: aload_0
    //   47: invokevirtual 58	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   50: invokevirtual 62	java/lang/String:getBytes	()[B
    //   53: invokevirtual 66	java/util/zip/GZIPOutputStream:write	([B)V
    //   56: iload_3
    //   57: ifeq +22 -> 79
    //   60: aload 4
    //   62: invokevirtual 69	java/util/zip/GZIPOutputStream:close	()V
    //   65: aload_1
    //   66: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   69: return
    //   70: astore_0
    //   71: return
    //   72: astore 5
    //   74: iconst_0
    //   75: istore_3
    //   76: goto -20 -> 56
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: istore_2
    //   83: goto -44 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramStringBuffer	StringBuffer
    //   0	86	1	paramFile	File
    //   38	45	2	i	int
    //   1	75	3	j	int
    //   35	26	4	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   72	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	37	70	java/lang/Exception
    //   60	69	70	java/lang/Exception
    //   44	56	72	java/lang/Exception
  }
  
  static void a(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, String paramString)
  {
    if (paramStringBuffer1.length() + paramStringBuffer2.length() < 8190) {
      paramStringBuffer1.append(paramStringBuffer2);
    }
    while (paramString == null) {
      return;
    }
    try
    {
      a(paramStringBuffer1, new File(paramString));
      paramStringBuffer1.delete(0, paramStringBuffer1.length());
      paramStringBuffer1.append(paramStringBuffer2);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = c(paramInt);
    if (localObject == null) {}
    do
    {
      File localFile;
      do
      {
        do
        {
          return false;
        } while (paramInt != 2);
        localFile = new File((String)localObject);
        if (!localFile.exists()) {
          break;
        }
        if (localFile.length() <= 92160L) {
          break label74;
        }
      } while (!a(localFile, paramInt));
      localObject = new File((String)localObject);
    } while (((File)localObject).exists());
    label74:
    try
    {
      boolean bool = a((File)localObject);
      return bool;
    }
    catch (Exception localException) {}
    return true;
    return false;
  }
  
  private static boolean a(File paramFile)
  {
    try
    {
      paramFile.createNewFile();
      StringBuffer localStringBuffer = new StringBuffer(256);
      localStringBuffer.append("C");
      localStringBuffer.append("\t");
      localStringBuffer.append(Jni.encode(b.a().e()));
      localStringBuffer.append("\n");
      a(localStringBuffer, paramFile);
      return true;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  private static boolean a(File paramFile, int paramInt)
  {
    String str = null;
    if (paramInt == 2) {
      str = c();
    }
    if (str == null) {
      return false;
    }
    return paramFile.renameTo(new File(str));
  }
  
  static String b(int paramInt)
  {
    String str1 = g.k();
    String str2;
    if (str1 == null)
    {
      str2 = null;
      return str2;
    }
    if (paramInt == 1) {}
    for (str1 = str1 + File.separator + "llmis1";; str1 = str1 + File.separator + "llmis2")
    {
      File localFile = new File(str1);
      str2 = str1;
      if (localFile.exists()) {
        break;
      }
      try
      {
        boolean bool = localFile.mkdirs();
        str2 = str1;
        if (bool) {
          break;
        }
        return null;
      }
      catch (Exception localException) {}
      if (paramInt != 2) {
        break label111;
      }
    }
    label111:
    return null;
    return null;
  }
  
  private static String c()
  {
    String str1 = b(2);
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (!new File(str1 + File.separator + str2).exists()) {
        return str1 + File.separator + str2;
      }
      i += 1;
    }
    return null;
  }
  
  public static String c(int paramInt)
  {
    String str = b(paramInt);
    if (str == null) {}
    do
    {
      return null;
      if (paramInt == 2) {
        return str + File.separator + "lbacz.dat";
      }
    } while (paramInt != 1);
    return str + File.separator + "lmibacz.dat";
  }
  
  public String b()
  {
    String str1 = b(2);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = a;
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          String str2 = localObject[i];
          File localFile = new File(str1 + File.separator + str2);
          if (!localFile.exists()) {
            break label222;
          }
          if (localFile.length() > 524288L)
          {
            localFile.delete();
            break label222;
          }
          if (localFile.length() < 4096L) {
            break label222;
          }
          return str1 + File.separator + str2;
        }
        if (!e.a().a)
        {
          localObject = new File(str1 + File.separator + "lbacz.dat");
          if ((((File)localObject).exists()) && (((File)localObject).length() > 4096L))
          {
            str1 = str1 + File.separator + "lbacz.dat";
            return str1;
          }
        }
      }
      catch (Exception localException) {}
      return null;
      label222:
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */