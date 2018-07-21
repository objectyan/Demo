package com.baidu.che.codriver.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class f
{
  public static String a(String paramString)
  {
    return b(c.a().getFilesDir() + File.separator + paramString);
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(c.a().getFilesDir() + File.separator + paramString1, paramString2);
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, java.io.FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 72	java/util/zip/GZIPOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 75	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: iconst_0
    //   16: aload_0
    //   17: arraylength
    //   18: invokevirtual 79	java/util/zip/GZIPOutputStream:write	([BII)V
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: invokevirtual 82	java/util/zip/GZIPOutputStream:close	()V
    //   29: return
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   35: return
    //   36: astore_1
    //   37: aload_3
    //   38: astore_0
    //   39: aload_0
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   45: aload_0
    //   46: ifnull -17 -> 29
    //   49: aload_0
    //   50: invokevirtual 82	java/util/zip/GZIPOutputStream:close	()V
    //   53: return
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   59: return
    //   60: astore_0
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 82	java/util/zip/GZIPOutputStream:close	()V
    //   69: aload_0
    //   70: athrow
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   76: goto -7 -> 69
    //   79: astore_0
    //   80: aload_1
    //   81: astore_2
    //   82: goto -21 -> 61
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: goto -51 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramArrayOfByte	byte[]
    //   0	93	1	paramFileOutputStream	java.io.FileOutputStream
    //   1	81	2	localObject1	Object
    //   85	4	2	localException	Exception
    //   3	35	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	29	30	java/io/IOException
    //   4	13	36	java/lang/Exception
    //   49	53	54	java/io/IOException
    //   4	13	60	finally
    //   41	45	60	finally
    //   65	69	71	java/io/IOException
    //   13	21	79	finally
    //   13	21	85	java/lang/Exception
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: new 13	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   27: astore 10
    //   29: aload 8
    //   31: astore_1
    //   32: aload 9
    //   34: astore_2
    //   35: new 31	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload 8
    //   46: astore_1
    //   47: aload 9
    //   49: astore_2
    //   50: aload_0
    //   51: invokevirtual 107	java/io/File:exists	()Z
    //   54: ifne +46 -> 100
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 109	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 109	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 110	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: ldc 112
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   89: goto -20 -> 69
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   97: ldc 112
    //   99: areturn
    //   100: aload 8
    //   102: astore_1
    //   103: aload 9
    //   105: astore_2
    //   106: new 114	java/io/FileInputStream
    //   109: dup
    //   110: aload_0
    //   111: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_0
    //   115: new 118	java/io/BufferedReader
    //   118: dup
    //   119: new 120	java/io/InputStreamReader
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   127: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +51 -> 188
    //   140: aload 10
    //   142: aload_2
    //   143: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: goto -16 -> 131
    //   150: astore 4
    //   152: aload_1
    //   153: astore_3
    //   154: aload_3
    //   155: astore_1
    //   156: aload_0
    //   157: astore_2
    //   158: aload 4
    //   160: invokevirtual 130	java/io/FileNotFoundException:printStackTrace	()V
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 131	java/io/BufferedReader:close	()V
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 134	java/io/InputStream:close	()V
    //   179: aload 10
    //   181: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 137	com/baidu/che/codriver/util/f:c	(Ljava/lang/String;)Ljava/lang/String;
    //   187: areturn
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 131	java/io/BufferedReader:close	()V
    //   196: aload_0
    //   197: ifnull +180 -> 377
    //   200: aload_0
    //   201: invokevirtual 134	java/io/InputStream:close	()V
    //   204: goto -25 -> 179
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   212: goto -16 -> 196
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   220: goto -41 -> 179
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   228: goto -57 -> 171
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   236: goto -57 -> 179
    //   239: astore 4
    //   241: aload 7
    //   243: astore_0
    //   244: aload_3
    //   245: astore_1
    //   246: aload_0
    //   247: astore_2
    //   248: aload 4
    //   250: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 131	java/io/BufferedReader:close	()V
    //   261: aload_0
    //   262: ifnull -83 -> 179
    //   265: aload_0
    //   266: invokevirtual 134	java/io/InputStream:close	()V
    //   269: goto -90 -> 179
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   277: goto -98 -> 179
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   285: goto -24 -> 261
    //   288: astore_0
    //   289: aload_1
    //   290: ifnull +7 -> 297
    //   293: aload_1
    //   294: invokevirtual 131	java/io/BufferedReader:close	()V
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 134	java/io/InputStream:close	()V
    //   305: aload_0
    //   306: athrow
    //   307: astore_1
    //   308: aload_1
    //   309: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   312: goto -15 -> 297
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   320: goto -15 -> 305
    //   323: astore_3
    //   324: aload 5
    //   326: astore_1
    //   327: aload_0
    //   328: astore_2
    //   329: aload_3
    //   330: astore_0
    //   331: goto -42 -> 289
    //   334: astore_3
    //   335: aload_0
    //   336: astore_2
    //   337: aload_3
    //   338: astore_0
    //   339: goto -50 -> 289
    //   342: astore 4
    //   344: goto -100 -> 244
    //   347: astore 4
    //   349: aload_1
    //   350: astore_3
    //   351: goto -107 -> 244
    //   354: astore_0
    //   355: aload 4
    //   357: astore_3
    //   358: aload_0
    //   359: astore 4
    //   361: aload 6
    //   363: astore_0
    //   364: goto -210 -> 154
    //   367: astore_1
    //   368: aload 4
    //   370: astore_3
    //   371: aload_1
    //   372: astore 4
    //   374: goto -220 -> 154
    //   377: goto -198 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   31	162	1	localObject1	Object
    //   207	2	1	localIOException1	java.io.IOException
    //   223	2	1	localIOException2	java.io.IOException
    //   245	1	1	localObject2	Object
    //   280	14	1	localIOException3	java.io.IOException
    //   307	2	1	localIOException4	java.io.IOException
    //   315	2	1	localIOException5	java.io.IOException
    //   326	24	1	localObject3	Object
    //   367	5	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   34	303	2	localObject4	Object
    //   10	248	3	localObject5	Object
    //   323	7	3	localObject6	Object
    //   334	4	3	localObject7	Object
    //   350	21	3	localObject8	Object
    //   18	1	4	localObject9	Object
    //   150	9	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   239	10	4	localIOException6	java.io.IOException
    //   342	1	4	localIOException7	java.io.IOException
    //   347	9	4	localIOException8	java.io.IOException
    //   359	14	4	localObject10	Object
    //   15	310	5	localObject11	Object
    //   7	355	6	localObject12	Object
    //   1	241	7	localObject13	Object
    //   12	89	8	localObject14	Object
    //   4	100	9	localObject15	Object
    //   27	153	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   61	69	84	java/io/IOException
    //   73	81	92	java/io/IOException
    //   131	136	150	java/io/FileNotFoundException
    //   140	147	150	java/io/FileNotFoundException
    //   192	196	207	java/io/IOException
    //   200	204	215	java/io/IOException
    //   167	171	223	java/io/IOException
    //   175	179	231	java/io/IOException
    //   35	44	239	java/io/IOException
    //   50	57	239	java/io/IOException
    //   106	115	239	java/io/IOException
    //   265	269	272	java/io/IOException
    //   257	261	280	java/io/IOException
    //   35	44	288	finally
    //   50	57	288	finally
    //   106	115	288	finally
    //   158	163	288	finally
    //   248	253	288	finally
    //   293	297	307	java/io/IOException
    //   301	305	315	java/io/IOException
    //   115	131	323	finally
    //   131	136	334	finally
    //   140	147	334	finally
    //   115	131	342	java/io/IOException
    //   131	136	347	java/io/IOException
    //   140	147	347	java/io/IOException
    //   35	44	354	java/io/FileNotFoundException
    //   50	57	354	java/io/FileNotFoundException
    //   106	115	354	java/io/FileNotFoundException
    //   115	131	367	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: new 31	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload 4
    //   27: astore_2
    //   28: aload_0
    //   29: invokevirtual 107	java/io/File:exists	()Z
    //   32: ifne +11 -> 43
    //   35: aload 4
    //   37: astore_2
    //   38: aload_0
    //   39: invokevirtual 146	java/io/File:createNewFile	()Z
    //   42: pop
    //   43: aload 4
    //   45: astore_2
    //   46: new 148	java/io/BufferedWriter
    //   49: dup
    //   50: new 150	java/io/FileWriter
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 151	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   58: invokespecial 154	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   61: astore_0
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 156	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokevirtual 159	java/io/BufferedWriter:flush	()V
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 160	java/io/BufferedWriter:close	()V
    //   79: return
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   85: return
    //   86: astore_1
    //   87: aload_3
    //   88: astore_0
    //   89: aload_0
    //   90: astore_2
    //   91: aload_1
    //   92: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   95: aload_0
    //   96: ifnull -89 -> 7
    //   99: aload_0
    //   100: invokevirtual 160	java/io/BufferedWriter:close	()V
    //   103: return
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   109: return
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 160	java/io/BufferedWriter:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_1
    //   130: aload_0
    //   131: astore_2
    //   132: aload_1
    //   133: astore_0
    //   134: goto -23 -> 111
    //   137: astore_1
    //   138: goto -49 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString1	String
    //   0	141	1	paramString2	String
    //   15	117	2	localObject1	Object
    //   12	76	3	localObject2	Object
    //   9	35	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   75	79	80	java/io/IOException
    //   16	25	86	java/lang/Exception
    //   28	35	86	java/lang/Exception
    //   38	43	86	java/lang/Exception
    //   46	62	86	java/lang/Exception
    //   99	103	104	java/io/IOException
    //   16	25	110	finally
    //   28	35	110	finally
    //   38	43	110	finally
    //   46	62	110	finally
    //   91	95	110	finally
    //   115	119	121	java/io/IOException
    //   62	71	129	finally
    //   62	71	137	java/lang/Exception
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("﻿")) {
        str = paramString.substring(1);
      }
    }
    return str;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */