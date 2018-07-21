package com.baidu.platform.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class b
{
  public static final boolean a = false;
  private static final String c = "lib/armeabi/";
  private static final Set<String> d = new HashSet();
  private static final Set<String> e = new HashSet();
  private static final boolean f = false;
  private static final String g = "/debuginfo/update/";
  private static final String h = "/debuginfo/update/config.txt";
  private static final HashMap<String, String> i = new HashMap();
  private Context b;
  
  protected b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static b a()
  {
    return new b(a.a().b());
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (i.size() == 0)) {
      i.putAll(paramHashMap);
    }
  }
  
  protected final void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    try
    {
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if (j == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, j);
      }
      try
      {
        paramInputStream.close();
      }
      catch (IOException paramInputStream)
      {
        try
        {
          for (;;)
          {
            paramOutputStream.close();
            throw ((Throwable)localObject);
            paramOutputStream.flush();
            try
            {
              paramInputStream.close();
            }
            catch (IOException paramInputStream)
            {
              for (;;)
              {
                try
                {
                  paramOutputStream.close();
                  return;
                }
                catch (IOException paramInputStream)
                {
                  return;
                }
                paramInputStream = paramInputStream;
              }
            }
            paramInputStream = paramInputStream;
          }
        }
        catch (IOException paramInputStream)
        {
          for (;;) {}
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 36	com/baidu/platform/a/b:d	Ljava/util/Set;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: getstatic 36	com/baidu/platform/a/b:d	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 104 2 0
    //   17: ifeq +11 -> 28
    //   20: aload_3
    //   21: monitorexit
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_3
    //   29: monitorexit
    //   30: new 106	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   37: ldc 109
    //   39: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 115
    //   48: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_3
    //   55: getstatic 43	com/baidu/platform/a/b:i	Ljava/util/HashMap;
    //   58: aload_3
    //   59: invokevirtual 122	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +69 -> 133
    //   67: getstatic 43	com/baidu/platform/a/b:i	Ljava/util/HashMap;
    //   70: aload_3
    //   71: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 128	java/lang/String
    //   77: invokestatic 134	java/lang/System:load	(Ljava/lang/String;)V
    //   80: getstatic 36	com/baidu/platform/a/b:d	Ljava/util/Set;
    //   83: astore_3
    //   84: aload_3
    //   85: monitorenter
    //   86: getstatic 36	com/baidu/platform/a/b:d	Ljava/util/Set;
    //   89: aload_1
    //   90: invokeinterface 137 2 0
    //   95: pop
    //   96: aload_3
    //   97: monitorexit
    //   98: iconst_1
    //   99: istore_2
    //   100: goto -76 -> 24
    //   103: astore 4
    //   105: aload_3
    //   106: monitorexit
    //   107: aload 4
    //   109: athrow
    //   110: astore_3
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 139	com/baidu/platform/a/b:b	(Ljava/lang/String;)Z
    //   116: istore_2
    //   117: goto -93 -> 24
    //   120: astore_3
    //   121: aload_1
    //   122: invokestatic 142	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   125: goto -45 -> 80
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: aload_1
    //   134: invokestatic 142	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   137: goto -57 -> 80
    //   140: astore 4
    //   142: aload_3
    //   143: monitorexit
    //   144: aload 4
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	b
    //   0	147	1	paramString	String
    //   23	94	2	bool	boolean
    //   110	1	3	localThrowable	Throwable
    //   120	23	3	localException	Exception
    //   103	5	4	localObject2	Object
    //   140	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	22	103	finally
    //   28	30	103	finally
    //   105	107	103	finally
    //   2	8	110	java/lang/Throwable
    //   30	63	110	java/lang/Throwable
    //   67	80	110	java/lang/Throwable
    //   80	86	110	java/lang/Throwable
    //   107	110	110	java/lang/Throwable
    //   121	125	110	java/lang/Throwable
    //   133	137	110	java/lang/Throwable
    //   144	147	110	java/lang/Throwable
    //   67	80	120	java/lang/Exception
    //   2	8	128	finally
    //   30	63	128	finally
    //   67	80	128	finally
    //   80	86	128	finally
    //   107	110	128	finally
    //   111	117	128	finally
    //   121	125	128	finally
    //   133	137	128	finally
    //   144	147	128	finally
    //   86	98	140	finally
    //   142	144	140	finally
  }
  
  public Set<String> b()
  {
    synchronized (d)
    {
      HashSet localHashSet = new HashSet(d);
      return localHashSet;
    }
  }
  
  protected boolean b(String paramString)
  {
    ??? = System.mapLibraryName(paramString);
    if (c((String)???)) {
      try
      {
        System.load(new File(e(), (String)???).getAbsolutePath());
        synchronized (d)
        {
          d.add(paramString);
          return true;
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        synchronized (e)
        {
          e.add(paramString);
        }
      }
    }
  }
  
  public Set<String> c()
  {
    synchronized (e)
    {
      HashSet localHashSet = new HashSet(e);
      return localHashSet;
    }
  }
  
  /* Error */
  protected boolean c(String paramString)
  {
    // Byte code:
    //   0: new 106	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   7: ldc 11
    //   9: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_1
    //   13: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 5
    //   21: aconst_null
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 4
    //   26: new 165	java/util/zip/ZipFile
    //   29: dup
    //   30: aload_0
    //   31: invokevirtual 167	com/baidu/platform/a/b:d	()Ljava/lang/String;
    //   34: invokespecial 169	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: new 155	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 157	com/baidu/platform/a/b:e	()Ljava/lang/String;
    //   46: aload_1
    //   47: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_2
    //   52: aload 5
    //   54: invokevirtual 173	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnonnull +13 -> 72
    //   62: aload_2
    //   63: ifnull +7 -> 70
    //   66: aload_2
    //   67: invokevirtual 174	java/util/zip/ZipFile:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 178	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   78: new 180	java/io/FileOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: invokevirtual 185	com/baidu/platform/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 174	java/util/zip/ZipFile:close	()V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_1
    //   100: aload 4
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull -34 -> 70
    //   107: aload_1
    //   108: invokevirtual 174	java/util/zip/ZipFile:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_1
    //   117: aload_3
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 174	java/util/zip/ZipFile:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -60 -> 70
    //   133: astore_1
    //   134: goto -37 -> 97
    //   137: astore_2
    //   138: goto -11 -> 127
    //   141: astore_1
    //   142: goto -23 -> 119
    //   145: astore_1
    //   146: aload_2
    //   147: astore_1
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	b
    //   0	151	1	paramString	String
    //   37	87	2	localObject1	Object
    //   137	10	2	localIOException	IOException
    //   22	96	3	localZipEntry	java.util.zip.ZipEntry
    //   24	77	4	localObject2	Object
    //   19	34	5	str	String
    // Exception table:
    //   from	to	target	type
    //   26	38	99	java/lang/Exception
    //   107	111	113	java/io/IOException
    //   26	38	116	finally
    //   66	70	129	java/io/IOException
    //   93	97	133	java/io/IOException
    //   123	127	137	java/io/IOException
    //   38	58	141	finally
    //   72	89	141	finally
    //   38	58	145	java/lang/Exception
    //   72	89	145	java/lang/Exception
  }
  
  @TargetApi(8)
  protected String d()
  {
    if (8 <= Build.VERSION.SDK_INT) {
      return this.b.getPackageCodePath();
    }
    return "";
  }
  
  protected String e()
  {
    File localFile = new File(this.b.getFilesDir(), "libs");
    localFile.mkdirs();
    return localFile.getAbsolutePath();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */