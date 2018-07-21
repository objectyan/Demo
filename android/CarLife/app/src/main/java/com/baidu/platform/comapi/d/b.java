package com.baidu.platform.comapi.d;

import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;

public class b
{
  public static final b a = new b();
  public static final int b = 65536;
  public static final String c = ".dir";
  private c d = new c(com.baidu.platform.comapi.c.f(), "res.json");
  
  private void a(String paramString)
  {
    File localFile = new File(paramString.concat("/cfg/a/ResPack.png"));
    paramString = new File(paramString.concat("/cfg/a/ResPack.rs"));
    if (localFile.exists())
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      localFile.renameTo(paramString);
    }
  }
  
  /* Error */
  private boolean a(android.content.res.AssetManager paramAssetManager, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 9
    //   9: aload 10
    //   11: astore 8
    //   13: aload 11
    //   15: astore 7
    //   17: aload_3
    //   18: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +268 -> 289
    //   24: aload 10
    //   26: astore 8
    //   28: aload 11
    //   30: astore 7
    //   32: aload_3
    //   33: ldc 13
    //   35: invokevirtual 78	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   38: ifeq +251 -> 289
    //   41: aload 10
    //   43: astore 8
    //   45: aload 11
    //   47: astore 7
    //   49: aload_3
    //   50: iconst_0
    //   51: aload_3
    //   52: ldc 13
    //   54: invokevirtual 82	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   57: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   60: astore 12
    //   62: aload 10
    //   64: astore 8
    //   66: aload 11
    //   68: astore 7
    //   70: aload 4
    //   72: iconst_0
    //   73: aload 4
    //   75: ldc 13
    //   77: invokevirtual 82	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore 4
    //   85: aload 10
    //   87: astore 8
    //   89: aload 11
    //   91: astore 7
    //   93: aload_1
    //   94: aload 12
    //   96: invokevirtual 92	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   99: astore 13
    //   101: aload 9
    //   103: astore_3
    //   104: aload 13
    //   106: ifnull +314 -> 420
    //   109: aload 9
    //   111: astore_3
    //   112: aload 10
    //   114: astore 8
    //   116: aload 11
    //   118: astore 7
    //   120: aload 13
    //   122: arraylength
    //   123: ifle +297 -> 420
    //   126: aload 10
    //   128: astore 8
    //   130: aload 11
    //   132: astore 7
    //   134: new 42	java/io/File
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload 10
    //   146: astore 8
    //   148: aload 11
    //   150: astore 7
    //   152: aload_3
    //   153: invokevirtual 58	java/io/File:exists	()Z
    //   156: ifeq +16 -> 172
    //   159: aload 10
    //   161: astore 8
    //   163: aload 11
    //   165: astore 7
    //   167: aload_3
    //   168: invokevirtual 61	java/io/File:delete	()Z
    //   171: pop
    //   172: aload 10
    //   174: astore 8
    //   176: aload 11
    //   178: astore 7
    //   180: aload_3
    //   181: invokevirtual 95	java/io/File:mkdirs	()Z
    //   184: pop
    //   185: aload 10
    //   187: astore 8
    //   189: aload 11
    //   191: astore 7
    //   193: aload 13
    //   195: arraylength
    //   196: istore 6
    //   198: iconst_0
    //   199: istore 5
    //   201: aload 9
    //   203: astore_3
    //   204: iload 5
    //   206: iload 6
    //   208: if_icmpge +212 -> 420
    //   211: aload 13
    //   213: iload 5
    //   215: aaload
    //   216: astore_3
    //   217: aload 10
    //   219: astore 8
    //   221: aload 11
    //   223: astore 7
    //   225: aload_0
    //   226: aload_1
    //   227: aload_2
    //   228: new 97	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   235: aload 12
    //   237: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 104
    //   242: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_3
    //   246: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: new 97	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   259: aload 4
    //   261: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 104
    //   266: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokespecial 110	com/baidu/platform/comapi/d/b:a	(Landroid/content/res/AssetManager;[BLjava/lang/String;Ljava/lang/String;)Z
    //   279: pop
    //   280: iload 5
    //   282: iconst_1
    //   283: iadd
    //   284: istore 5
    //   286: goto -85 -> 201
    //   289: aload 10
    //   291: astore 8
    //   293: aload 11
    //   295: astore 7
    //   297: aload_1
    //   298: aload_3
    //   299: invokevirtual 114	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   302: astore_1
    //   303: aload_1
    //   304: astore 8
    //   306: aload_1
    //   307: astore 7
    //   309: new 42	java/io/File
    //   312: dup
    //   313: aload 4
    //   315: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   318: astore_3
    //   319: aload_1
    //   320: astore 8
    //   322: aload_1
    //   323: astore 7
    //   325: aload_3
    //   326: invokevirtual 118	java/io/File:getParentFile	()Ljava/io/File;
    //   329: astore 4
    //   331: aload 4
    //   333: ifnull +29 -> 362
    //   336: aload_1
    //   337: astore 8
    //   339: aload_1
    //   340: astore 7
    //   342: aload 4
    //   344: invokevirtual 121	java/io/File:isDirectory	()Z
    //   347: ifne +15 -> 362
    //   350: aload_1
    //   351: astore 8
    //   353: aload_1
    //   354: astore 7
    //   356: aload 4
    //   358: invokevirtual 95	java/io/File:mkdirs	()Z
    //   361: pop
    //   362: aload_1
    //   363: astore 8
    //   365: aload_1
    //   366: astore 7
    //   368: aload_3
    //   369: invokevirtual 58	java/io/File:exists	()Z
    //   372: ifeq +14 -> 386
    //   375: aload_1
    //   376: astore 8
    //   378: aload_1
    //   379: astore 7
    //   381: aload_3
    //   382: invokevirtual 61	java/io/File:delete	()Z
    //   385: pop
    //   386: aload_1
    //   387: astore 8
    //   389: aload_1
    //   390: astore 7
    //   392: aload_3
    //   393: invokevirtual 124	java/io/File:createNewFile	()Z
    //   396: pop
    //   397: aload_1
    //   398: astore 8
    //   400: aload_1
    //   401: astore 7
    //   403: new 126	java/io/FileOutputStream
    //   406: dup
    //   407: aload_3
    //   408: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   411: astore_3
    //   412: aload_1
    //   413: aload_3
    //   414: aload_2
    //   415: invokestatic 134	com/baidu/platform/comapi/d/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   418: aload_1
    //   419: astore_3
    //   420: aload_3
    //   421: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   424: iconst_1
    //   425: ireturn
    //   426: astore_1
    //   427: aload 8
    //   429: astore_1
    //   430: aload_1
    //   431: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   434: iconst_0
    //   435: ireturn
    //   436: astore_2
    //   437: aload 7
    //   439: astore_1
    //   440: aload_1
    //   441: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   444: aload_2
    //   445: athrow
    //   446: astore_2
    //   447: goto -7 -> 440
    //   450: astore_2
    //   451: goto -21 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	b
    //   0	454	1	paramAssetManager	android.content.res.AssetManager
    //   0	454	2	paramArrayOfByte	byte[]
    //   0	454	3	paramString1	String
    //   0	454	4	paramString2	String
    //   199	86	5	i	int
    //   196	13	6	j	int
    //   15	423	7	localObject1	Object
    //   11	417	8	localObject2	Object
    //   7	195	9	localObject3	Object
    //   1	289	10	localObject4	Object
    //   4	290	11	localObject5	Object
    //   60	176	12	str	String
    //   99	113	13	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   17	24	426	java/lang/Exception
    //   32	41	426	java/lang/Exception
    //   49	62	426	java/lang/Exception
    //   70	85	426	java/lang/Exception
    //   93	101	426	java/lang/Exception
    //   120	126	426	java/lang/Exception
    //   134	144	426	java/lang/Exception
    //   152	159	426	java/lang/Exception
    //   167	172	426	java/lang/Exception
    //   180	185	426	java/lang/Exception
    //   193	198	426	java/lang/Exception
    //   225	280	426	java/lang/Exception
    //   297	303	426	java/lang/Exception
    //   309	319	426	java/lang/Exception
    //   325	331	426	java/lang/Exception
    //   342	350	426	java/lang/Exception
    //   356	362	426	java/lang/Exception
    //   368	375	426	java/lang/Exception
    //   381	386	426	java/lang/Exception
    //   392	397	426	java/lang/Exception
    //   403	412	426	java/lang/Exception
    //   17	24	436	finally
    //   32	41	436	finally
    //   49	62	436	finally
    //   70	85	436	finally
    //   93	101	436	finally
    //   120	126	436	finally
    //   134	144	436	finally
    //   152	159	436	finally
    //   167	172	436	finally
    //   180	185	436	finally
    //   193	198	436	finally
    //   225	280	436	finally
    //   297	303	436	finally
    //   309	319	436	finally
    //   325	331	436	finally
    //   342	350	436	finally
    //   356	362	436	finally
    //   368	375	436	finally
    //   381	386	436	finally
    //   392	397	436	finally
    //   403	412	436	finally
    //   412	418	446	finally
    //   412	418	450	java/lang/Exception
  }
  
  /* Error */
  private boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: invokevirtual 58	java/io/File:exists	()Z
    //   8: ifeq +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: new 142	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 147	java/io/FileInputStream:available	()I
    //   36: newarray <illegal type>
    //   38: astore 4
    //   40: aload_1
    //   41: aload 4
    //   43: invokevirtual 151	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload 4
    //   49: aload_2
    //   50: invokestatic 157	java/util/Arrays:equals	([B[B)Z
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +9 -> 64
    //   58: aload_1
    //   59: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_1
    //   65: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_1
    //   71: aload 5
    //   73: astore_1
    //   74: aload_1
    //   75: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_2
    //   81: aload 4
    //   83: astore_1
    //   84: aload_1
    //   85: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: goto -7 -> 84
    //   94: astore_2
    //   95: goto -21 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	b
    //   0	98	1	paramFile	File
    //   0	98	2	paramArrayOfByte	byte[]
    //   53	2	3	bool	boolean
    //   18	64	4	arrayOfByte	byte[]
    //   21	51	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	32	70	java/io/IOException
    //   23	32	80	finally
    //   32	54	90	finally
    //   32	54	94	java/io/IOException
  }
  
  private String b()
  {
    String str = SysOSAPIv2.getInstance().getOutputDirPath();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private void b(String paramString)
  {
    File localFile = new File(paramString.concat("/cfg/a/ResPackPoi.png"));
    paramString = new File(paramString.concat("/cfg/a/ResPackPoi.rs"));
    if (localFile.exists())
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      localFile.renameTo(paramString);
    }
  }
  
  /* Error */
  private boolean b(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +9 -> 14
    //   8: iconst_0
    //   9: istore 4
    //   11: iload 4
    //   13: ireturn
    //   14: iconst_0
    //   15: istore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: aload_1
    //   23: invokevirtual 58	java/io/File:exists	()Z
    //   26: ifeq +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 61	java/io/File:delete	()Z
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 124	java/io/File:createNewFile	()Z
    //   38: pop
    //   39: new 126	java/io/FileOutputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore_1
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 174	java/io/FileOutputStream:write	([B)V
    //   53: iconst_1
    //   54: istore_3
    //   55: aload_1
    //   56: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   59: iload_3
    //   60: istore 4
    //   62: aload_1
    //   63: ifnull -52 -> 11
    //   66: aload_1
    //   67: invokevirtual 177	java/io/FileOutputStream:close	()V
    //   70: iload_3
    //   71: ireturn
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   77: iload_3
    //   78: ireturn
    //   79: astore_1
    //   80: aload 6
    //   82: astore_1
    //   83: aload_1
    //   84: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   87: goto -28 -> 59
    //   90: astore_2
    //   91: aload 5
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 137	com/baidu/platform/comapi/d/a:a	(Ljava/io/Closeable;)V
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: goto -7 -> 94
    //   104: astore_2
    //   105: goto -22 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	b
    //   0	108	1	paramFile	File
    //   0	108	2	paramArrayOfByte	byte[]
    //   15	63	3	bool1	boolean
    //   9	52	4	bool2	boolean
    //   17	75	5	localObject1	Object
    //   20	61	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	72	java/io/IOException
    //   22	34	79	java/lang/Exception
    //   34	48	79	java/lang/Exception
    //   22	34	90	finally
    //   34	48	90	finally
    //   48	53	100	finally
    //   48	53	104	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    File localFile = new File(paramString.concat("/cfg/a/ResPackRoute.png"));
    paramString = new File(paramString.concat("/cfg/a/ResPackRoute.rs"));
    if (localFile.exists())
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      localFile.renameTo(paramString);
    }
  }
  
  private void d(String paramString)
  {
    File localFile = new File(paramString.concat("/cfg/a/ResPackTravel.png"));
    paramString = new File(paramString.concat("/cfg/a/ResPackTravel.rs"));
    if (localFile.exists())
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      localFile.renameTo(paramString);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 32	com/baidu/platform/comapi/c:f	()Landroid/content/Context;
    //   3: astore 17
    //   5: iconst_1
    //   6: istore 5
    //   8: iconst_1
    //   9: istore_3
    //   10: iconst_1
    //   11: istore 8
    //   13: iconst_1
    //   14: istore 4
    //   16: iconst_1
    //   17: istore 7
    //   19: iconst_1
    //   20: istore 6
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 15
    //   28: aconst_null
    //   29: astore 13
    //   31: aconst_null
    //   32: astore 11
    //   34: aconst_null
    //   35: astore 14
    //   37: aconst_null
    //   38: astore 12
    //   40: aload_0
    //   41: invokespecial 192	com/baidu/platform/comapi/d/b:b	()Ljava/lang/String;
    //   44: astore 16
    //   46: new 42	java/io/File
    //   49: dup
    //   50: aload 16
    //   52: ldc -62
    //   54: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: astore 9
    //   59: iload_3
    //   60: istore 4
    //   62: aload 15
    //   64: astore 10
    //   66: iload 8
    //   68: istore 5
    //   70: aload 13
    //   72: astore 12
    //   74: aload_0
    //   75: getfield 39	com/baidu/platform/comapi/d/b:d	Lcom/baidu/platform/comapi/d/c;
    //   78: invokevirtual 200	com/baidu/platform/comapi/d/c:a	()[B
    //   81: astore 11
    //   83: iload_3
    //   84: istore 4
    //   86: aload 11
    //   88: astore 10
    //   90: iload 8
    //   92: istore 5
    //   94: aload 11
    //   96: astore 12
    //   98: aload_0
    //   99: aload 9
    //   101: aload 11
    //   103: invokespecial 202	com/baidu/platform/comapi/d/b:a	(Ljava/io/File;[B)Z
    //   106: istore_3
    //   107: iload 7
    //   109: istore 4
    //   111: iload_3
    //   112: ifeq +164 -> 276
    //   115: iload_3
    //   116: istore 4
    //   118: aload 11
    //   120: astore 10
    //   122: iload_3
    //   123: istore 5
    //   125: aload 11
    //   127: astore 12
    //   129: aload 17
    //   131: invokevirtual 208	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   134: astore 13
    //   136: iload_3
    //   137: istore 4
    //   139: aload 11
    //   141: astore 10
    //   143: iload_3
    //   144: istore 5
    //   146: aload 11
    //   148: astore 12
    //   150: aload_0
    //   151: getfield 39	com/baidu/platform/comapi/d/b:d	Lcom/baidu/platform/comapi/d/c;
    //   154: invokevirtual 211	com/baidu/platform/comapi/d/c:b	()[Ljava/lang/String;
    //   157: astore 14
    //   159: iload_3
    //   160: istore 4
    //   162: aload 11
    //   164: astore 10
    //   166: iload_3
    //   167: istore 5
    //   169: aload 11
    //   171: astore 12
    //   173: ldc 9
    //   175: newarray <illegal type>
    //   177: astore 15
    //   179: iload_3
    //   180: istore 4
    //   182: aload 11
    //   184: astore 10
    //   186: iload_3
    //   187: istore 5
    //   189: aload 11
    //   191: astore 12
    //   193: aload 14
    //   195: arraylength
    //   196: istore_2
    //   197: iconst_0
    //   198: istore_1
    //   199: iload 6
    //   201: istore 4
    //   203: iload_1
    //   204: iload_2
    //   205: if_icmpge +71 -> 276
    //   208: aload 14
    //   210: iload_1
    //   211: aaload
    //   212: astore 17
    //   214: iload_3
    //   215: istore 4
    //   217: aload 11
    //   219: astore 10
    //   221: iload_3
    //   222: istore 5
    //   224: aload 11
    //   226: astore 12
    //   228: aload_0
    //   229: aload 13
    //   231: aload 15
    //   233: aload 17
    //   235: new 97	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   242: aload 16
    //   244: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 104
    //   249: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 17
    //   254: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokespecial 110	com/baidu/platform/comapi/d/b:a	(Landroid/content/res/AssetManager;[BLjava/lang/String;Ljava/lang/String;)Z
    //   263: istore 6
    //   265: iload 6
    //   267: istore 4
    //   269: iload_1
    //   270: iconst_1
    //   271: iadd
    //   272: istore_1
    //   273: goto -70 -> 203
    //   276: iload_3
    //   277: ifeq +17 -> 294
    //   280: iload 4
    //   282: ifeq +12 -> 294
    //   285: aload_0
    //   286: aload 9
    //   288: aload 11
    //   290: invokespecial 213	com/baidu/platform/comapi/d/b:b	(Ljava/io/File;[B)Z
    //   293: pop
    //   294: return
    //   295: astore 9
    //   297: aload 12
    //   299: astore 9
    //   301: iload 4
    //   303: istore_3
    //   304: iconst_0
    //   305: istore 4
    //   307: goto -31 -> 276
    //   310: astore 9
    //   312: aload 14
    //   314: astore 9
    //   316: iload 5
    //   318: istore_3
    //   319: iconst_0
    //   320: istore 4
    //   322: aload 10
    //   324: astore 11
    //   326: goto -50 -> 276
    //   329: astore 11
    //   331: iload 4
    //   333: istore_3
    //   334: goto -15 -> 319
    //   337: astore 10
    //   339: iload 5
    //   341: istore_3
    //   342: aload 12
    //   344: astore 11
    //   346: goto -42 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	b
    //   198	75	1	i	int
    //   196	10	2	j	int
    //   9	333	3	bool1	boolean
    //   14	318	4	bool2	boolean
    //   6	334	5	bool3	boolean
    //   20	246	6	bool4	boolean
    //   17	91	7	bool5	boolean
    //   11	80	8	bool6	boolean
    //   57	230	9	localFile	File
    //   295	1	9	localRuntimeException1	RuntimeException
    //   299	1	9	localObject1	Object
    //   310	1	9	localException1	Exception
    //   314	1	9	arrayOfString1	String[]
    //   23	300	10	localObject2	Object
    //   337	1	10	localRuntimeException2	RuntimeException
    //   32	293	11	localObject3	Object
    //   329	1	11	localException2	Exception
    //   344	1	11	localObject4	Object
    //   38	305	12	localObject5	Object
    //   29	201	13	localAssetManager	android.content.res.AssetManager
    //   35	278	14	arrayOfString2	String[]
    //   26	206	15	arrayOfByte	byte[]
    //   44	199	16	str	String
    //   3	250	17	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   40	59	295	java/lang/RuntimeException
    //   40	59	310	java/lang/Exception
    //   74	83	329	java/lang/Exception
    //   98	107	329	java/lang/Exception
    //   129	136	329	java/lang/Exception
    //   150	159	329	java/lang/Exception
    //   173	179	329	java/lang/Exception
    //   193	197	329	java/lang/Exception
    //   228	265	329	java/lang/Exception
    //   74	83	337	java/lang/RuntimeException
    //   98	107	337	java/lang/RuntimeException
    //   129	136	337	java/lang/RuntimeException
    //   150	159	337	java/lang/RuntimeException
    //   173	179	337	java/lang/RuntimeException
    //   193	197	337	java/lang/RuntimeException
    //   228	265	337	java/lang/RuntimeException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */