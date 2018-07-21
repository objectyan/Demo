package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;

class ax
{
  private static volatile DexClassLoader a;
  private static volatile boolean b = false;
  
  private static DexClassLoader a(Context paramContext)
  {
    Object localObject2 = null;
    for (;;)
    {
      File localFile;
      try
      {
        if (a != null)
        {
          localObject1 = a;
          return (DexClassLoader)localObject1;
        }
        localFile = paramContext.getFileStreamPath(".remote.jar");
        if (localFile != null)
        {
          localObject1 = localObject2;
          if (!localFile.isFile()) {
            continue;
          }
        }
        if (!b(paramContext, localFile.getAbsolutePath()))
        {
          bd.a("remote jar version lower than min limit, need delete");
          localObject1 = localObject2;
          if (!localFile.isFile()) {
            continue;
          }
          localFile.delete();
          localObject1 = localObject2;
          continue;
        }
        if (c(paramContext, localFile.getAbsolutePath())) {
          break label116;
        }
      }
      finally {}
      bd.a("remote jar md5 is not right, need delete");
      Object localObject1 = localObject2;
      if (!localFile.isFile()) {
        continue;
      }
      localFile.delete();
      localObject1 = localObject2;
      continue;
      label116:
      localObject1 = paramContext.getDir("outdex", 0);
      try
      {
        a = new DexClassLoader(localFile.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), null, paramContext.getClassLoader());
        localObject1 = a;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          bd.a(paramContext);
        }
      }
    }
  }
  
  public static Class<?> a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    return paramContext.loadClass(paramString);
  }
  
  public static void a(Context paramContext, l paraml)
  {
    for (;;)
    {
      try
      {
        boolean bool = b;
        if (bool) {
          return;
        }
        if (!de.n(paramContext))
        {
          bd.a("isWifiAvailable = false, will not to update");
          continue;
        }
        if (paraml.a(paramContext)) {
          break label54;
        }
      }
      finally {}
      bd.a("check time, will not to update");
      continue;
      label54:
      bd.a("can start update config");
      new ay(paramContext, paraml).start();
      b = true;
    }
  }
  
  /* Error */
  private static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: new 28	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload_2
    //   17: astore_1
    //   18: aload 4
    //   20: invokevirtual 116	java/io/File:exists	()Z
    //   23: ifeq +31 -> 54
    //   26: aload_2
    //   27: astore_1
    //   28: new 118	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   35: ldc 122
    //   37: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 4
    //   42: invokevirtual 130	java/io/File:length	()J
    //   45: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 138	com/baidu/mobstat/bd:b	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: astore_1
    //   56: new 140	java/util/jar/JarFile
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 141	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   64: astore_2
    //   65: aload_2
    //   66: invokevirtual 145	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   69: invokevirtual 151	java/util/jar/Manifest:getMainAttributes	()Ljava/util/jar/Attributes;
    //   72: ldc -103
    //   74: invokevirtual 158	java/util/jar/Attributes:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_1
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 161	java/util/jar/JarFile:close	()V
    //   86: aload_1
    //   87: areturn
    //   88: astore_1
    //   89: aload_3
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: aload_2
    //   94: astore_1
    //   95: aload_3
    //   96: invokestatic 73	com/baidu/mobstat/bd:a	(Ljava/lang/Throwable;)V
    //   99: aload_2
    //   100: astore_1
    //   101: new 118	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   108: ldc -93
    //   110: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 46	com/baidu/mobstat/bd:a	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 161	java/util/jar/JarFile:close	()V
    //   131: ldc -91
    //   133: areturn
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 161	java/util/jar/JarFile:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: aload_1
    //   147: areturn
    //   148: astore_0
    //   149: goto -18 -> 131
    //   152: astore_1
    //   153: goto -10 -> 143
    //   156: astore_0
    //   157: aload_2
    //   158: astore_1
    //   159: goto -24 -> 135
    //   162: astore_3
    //   163: goto -70 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   5	82	1	localObject1	Object
    //   88	4	1	localException1	Exception
    //   94	53	1	localObject2	Object
    //   152	1	1	localException2	Exception
    //   158	1	1	localObject3	Object
    //   1	157	2	localObject4	Object
    //   3	93	3	localObject5	Object
    //   162	1	3	localException3	Exception
    //   14	27	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	16	88	java/lang/Exception
    //   18	26	88	java/lang/Exception
    //   28	54	88	java/lang/Exception
    //   56	65	88	java/lang/Exception
    //   6	16	134	finally
    //   18	26	134	finally
    //   28	54	134	finally
    //   56	65	134	finally
    //   95	99	134	finally
    //   101	123	134	finally
    //   82	86	145	java/lang/Exception
    //   127	131	148	java/lang/Exception
    //   139	143	152	java/lang/Exception
    //   65	78	156	finally
    //   65	78	162	java/lang/Exception
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    paramContext = b(paramString);
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return false;
      try
      {
        i = Integer.valueOf(paramContext).intValue();
        if (i < 4) {
          continue;
        }
        return true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          bd.b(paramContext);
          int i = 0;
        }
      }
    }
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    String str = cz.a(new File(paramString));
    bd.a("remote.jar local file digest value digest = " + str);
    if (TextUtils.isEmpty(str)) {
      bd.a("remote.jar local file digest value fail");
    }
    do
    {
      return false;
      paramString = b(paramString);
      bd.a("remote.jar local file digest value version = " + paramString);
    } while (TextUtils.isEmpty(paramString));
    paramContext = d(paramContext, paramString);
    bd.a("remote.jar config digest value remoteJarMd5 = " + paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      bd.a("remote.jar config digest value lost");
      return false;
    }
    return str.equals(paramContext);
  }
  
  private static String d(Context paramContext, String paramString)
  {
    return az.a(paramContext).c(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */