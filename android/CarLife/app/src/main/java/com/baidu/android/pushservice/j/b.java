package com.baidu.android.pushservice.j;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;
import org.json.JSONObject;

public class b
{
  private static final Object a = new Object();
  
  public static String a(Context paramContext, String paramString)
  {
    Object localObject2;
    if (paramContext == null) {
      localObject2 = "";
    }
    for (;;)
    {
      return (String)localObject2;
      Object localObject1 = null;
      try
      {
        localObject2 = Settings.System.getString(paramContext.getContentResolver(), paramString);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      try
      {
        paramContext = b(paramContext, paramString);
        localObject2 = localObject1;
        if (paramContext == null) {
          continue;
        }
        localObject2 = localObject1;
        if (!(paramContext instanceof String)) {
          continue;
        }
        paramContext = String.valueOf(paramContext);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        return (String)localObject1;
      }
    }
  }
  
  /* Error */
  private static JSONObject a(Context paramContext)
  {
    // Byte code:
    //   0: new 52	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 53	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: new 55	java/io/File
    //   16: dup
    //   17: invokestatic 61	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   20: ldc 63
    //   22: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 70	java/io/File:exists	()Z
    //   30: ifne +8 -> 38
    //   33: aload_1
    //   34: invokevirtual 73	java/io/File:mkdirs	()Z
    //   37: pop
    //   38: new 55	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: ldc 75
    //   45: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_1
    //   49: aload_1
    //   50: invokevirtual 70	java/io/File:exists	()Z
    //   53: ifeq +114 -> 167
    //   56: new 77	java/io/FileInputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 84	java/io/FileInputStream:available	()I
    //   69: newarray <illegal type>
    //   71: astore_3
    //   72: aload_1
    //   73: aload_3
    //   74: invokevirtual 88	java/io/FileInputStream:read	([B)I
    //   77: pop
    //   78: new 52	org/json/JSONObject
    //   81: dup
    //   82: aload_0
    //   83: ldc 19
    //   85: new 43	java/lang/String
    //   88: dup
    //   89: aload_3
    //   90: ldc 90
    //   92: invokespecial 93	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokestatic 99	com/baidu/android/pushservice/jni/BaiduAppSSOJni:getDecrypted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: invokespecial 102	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   101: astore_0
    //   102: aload_1
    //   103: astore_2
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokevirtual 105	java/io/FileInputStream:close	()V
    //   114: aload_0
    //   115: astore_1
    //   116: aload_1
    //   117: areturn
    //   118: astore_0
    //   119: aload_3
    //   120: astore_0
    //   121: aload_2
    //   122: astore_1
    //   123: aload_0
    //   124: ifnull -8 -> 116
    //   127: aload_0
    //   128: invokevirtual 105	java/io/FileInputStream:close	()V
    //   131: aload_2
    //   132: areturn
    //   133: astore_0
    //   134: aload_2
    //   135: areturn
    //   136: astore_0
    //   137: aload 4
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 105	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_1
    //   151: aload_0
    //   152: areturn
    //   153: astore_1
    //   154: goto -6 -> 148
    //   157: astore_0
    //   158: goto -18 -> 140
    //   161: astore_0
    //   162: aload_1
    //   163: astore_0
    //   164: goto -43 -> 121
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_2
    //   170: astore_0
    //   171: aload_1
    //   172: astore_2
    //   173: goto -69 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContext	Context
    //   25	120	1	localObject1	Object
    //   150	1	1	localIOException1	java.io.IOException
    //   153	10	1	localIOException2	java.io.IOException
    //   168	4	1	localObject2	Object
    //   7	166	2	localObject3	Object
    //   12	108	3	arrayOfByte	byte[]
    //   9	129	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   13	38	118	java/lang/Exception
    //   38	65	118	java/lang/Exception
    //   127	131	133	java/io/IOException
    //   13	38	136	finally
    //   38	65	136	finally
    //   110	114	150	java/io/IOException
    //   144	148	153	java/io/IOException
    //   65	102	157	finally
    //   65	102	161	java/lang/Exception
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      boolean bool2 = false;
      boolean bool1 = bool2;
      try
      {
        if (p.u(paramContext, "android.permission.WRITE_SETTINGS")) {
          bool1 = Settings.System.putInt(paramContext.getContentResolver(), paramString, paramInt);
        }
        if (bool1) {
          continue;
        }
        a(paramContext, paramString, Integer.valueOf(paramInt));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    do
    {
      return;
      int i = 0;
      try
      {
        boolean bool = Settings.System.putString(paramContext.getContentResolver(), paramString1, paramString2);
        i = bool;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    } while (i != 0);
    a(paramContext, paramString1, paramString2);
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -123
    //   3: invokestatic 114	com/baidu/android/pushservice/j/p:u	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: ifeq +119 -> 125
    //   9: getstatic 13	com/baidu/android/pushservice/j/b:a	Ljava/lang/Object;
    //   12: astore 5
    //   14: aload 5
    //   16: monitorenter
    //   17: aload_0
    //   18: invokestatic 135	com/baidu/android/pushservice/j/b:a	(Landroid/content/Context;)Lorg/json/JSONObject;
    //   21: astore 6
    //   23: aload 6
    //   25: aload_1
    //   26: invokevirtual 139	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 4
    //   34: aload 7
    //   36: ifnull +10 -> 46
    //   39: aload 6
    //   41: aload_1
    //   42: invokevirtual 142	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   45: pop
    //   46: aload 6
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: new 55	java/io/File
    //   57: dup
    //   58: invokestatic 61	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   61: ldc 63
    //   63: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 70	java/io/File:exists	()Z
    //   71: ifne +8 -> 79
    //   74: aload_1
    //   75: invokevirtual 73	java/io/File:mkdirs	()Z
    //   78: pop
    //   79: new 55	java/io/File
    //   82: dup
    //   83: aload_1
    //   84: ldc 75
    //   86: invokespecial 66	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_0
    //   91: ldc 19
    //   93: aload 6
    //   95: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   98: invokestatic 153	com/baidu/android/pushservice/jni/BaiduAppSSOJni:getEncrypted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: istore_3
    //   107: iload_3
    //   108: ifeq +19 -> 127
    //   111: iconst_1
    //   112: anewarray 155	java/io/Closeable
    //   115: dup
    //   116: iconst_0
    //   117: aconst_null
    //   118: aastore
    //   119: invokestatic 160	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   122: aload 5
    //   124: monitorexit
    //   125: iconst_0
    //   126: ireturn
    //   127: aload_1
    //   128: invokevirtual 70	java/io/File:exists	()Z
    //   131: ifeq +8 -> 139
    //   134: aload_1
    //   135: invokevirtual 163	java/io/File:delete	()Z
    //   138: pop
    //   139: aload_1
    //   140: invokevirtual 166	java/io/File:createNewFile	()Z
    //   143: pop
    //   144: new 168	java/io/FileOutputStream
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   152: astore_0
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual 173	java/lang/String:getBytes	()[B
    //   158: invokevirtual 177	java/io/FileOutputStream:write	([B)V
    //   161: iconst_1
    //   162: anewarray 155	java/io/Closeable
    //   165: dup
    //   166: iconst_0
    //   167: aload_0
    //   168: aastore
    //   169: invokestatic 160	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   172: aload 5
    //   174: monitorexit
    //   175: iconst_1
    //   176: ireturn
    //   177: iconst_1
    //   178: anewarray 155	java/io/Closeable
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: aastore
    //   185: invokestatic 160	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   188: aload 5
    //   190: monitorexit
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_0
    //   194: aload 5
    //   196: monitorexit
    //   197: aload_0
    //   198: athrow
    //   199: astore_0
    //   200: aload 4
    //   202: astore_1
    //   203: iconst_1
    //   204: anewarray 155	java/io/Closeable
    //   207: dup
    //   208: iconst_0
    //   209: aload_1
    //   210: aastore
    //   211: invokestatic 160	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   214: aload_0
    //   215: athrow
    //   216: astore_2
    //   217: aload_0
    //   218: astore_1
    //   219: aload_2
    //   220: astore_0
    //   221: goto -18 -> 203
    //   224: astore_1
    //   225: goto -48 -> 177
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_0
    //   231: goto -54 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	paramString	String
    //   0	234	2	paramObject	Object
    //   106	2	3	bool	boolean
    //   32	169	4	localObject1	Object
    //   12	183	5	localObject2	Object
    //   21	73	6	localJSONObject	JSONObject
    //   29	6	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	31	193	finally
    //   39	46	193	finally
    //   111	125	193	finally
    //   161	175	193	finally
    //   177	191	193	finally
    //   194	197	193	finally
    //   203	216	193	finally
    //   46	79	199	finally
    //   79	107	199	finally
    //   127	139	199	finally
    //   139	153	199	finally
    //   153	161	216	finally
    //   153	161	224	java/lang/Exception
    //   46	79	228	java/lang/Exception
    //   79	107	228	java/lang/Exception
    //   127	139	228	java/lang/Exception
    //   139	153	228	java/lang/Exception
  }
  
  private static Object b(Context paramContext, String paramString)
  {
    if (p.u(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
      synchronized (a)
      {
        paramContext = a(paramContext).opt(paramString);
        return paramContext;
      }
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */