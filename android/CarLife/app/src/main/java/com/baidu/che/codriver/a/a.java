package com.baidu.che.codriver.a;

import android.text.TextUtils;

public class a
{
  private static final String a = "CoDriver";
  private static final String b = "cl";
  private static final String c = "D%k2tJ";
  private static final String d = "GmDW#U";
  private String e;
  private String f;
  private String g;
  private String h;
  
  private a()
  {
    f();
  }
  
  public static String a()
  {
    String str2 = e().e;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "CoDriver";
    }
    return str1;
  }
  
  public static String b()
  {
    return "cl";
  }
  
  public static String c()
  {
    return "D%k2tJ";
  }
  
  public static String d()
  {
    return "GmDW#U";
  }
  
  private static a e()
  {
    return a.a();
  }
  
  private void f()
  {
    g();
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: new 56	java/io/InputStreamReader
    //   16: dup
    //   17: invokestatic 61	com/baidu/che/codriver/util/c:a	()Landroid/content/Context;
    //   20: invokevirtual 67	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc 69
    //   25: invokevirtual 75	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: invokespecial 78	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: new 80	java/io/BufferedReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 83	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_2
    //   41: ldc 85
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +26 -> 78
    //   55: new 90	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   62: aload_3
    //   63: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_3
    //   75: goto -31 -> 44
    //   78: aload_3
    //   79: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +156 -> 238
    //   85: aload_3
    //   86: ldc 100
    //   88: invokevirtual 106	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +145 -> 238
    //   96: aload_3
    //   97: arraylength
    //   98: iconst_4
    //   99: if_icmpne +139 -> 238
    //   102: aload_0
    //   103: aload_3
    //   104: iconst_0
    //   105: aaload
    //   106: putfield 40	com/baidu/che/codriver/a/a:e	Ljava/lang/String;
    //   109: aload_0
    //   110: aload_3
    //   111: iconst_1
    //   112: aaload
    //   113: putfield 108	com/baidu/che/codriver/a/a:f	Ljava/lang/String;
    //   116: aload_0
    //   117: aload_3
    //   118: iconst_2
    //   119: aaload
    //   120: putfield 110	com/baidu/che/codriver/a/a:g	Ljava/lang/String;
    //   123: aload_0
    //   124: aload_3
    //   125: iconst_3
    //   126: aaload
    //   127: putfield 112	com/baidu/che/codriver/a/a:h	Ljava/lang/String;
    //   130: ldc 114
    //   132: new 90	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   139: ldc 116
    //   141: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 40	com/baidu/che/codriver/a/a:e	Ljava/lang/String;
    //   148: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 121	com/baidu/che/codriver/util/h:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: ldc 114
    //   159: new 90	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   166: ldc 123
    //   168: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 108	com/baidu/che/codriver/a/a:f	Ljava/lang/String;
    //   175: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 121	com/baidu/che/codriver/util/h:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: ldc 114
    //   186: new 90	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   193: ldc 125
    //   195: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 110	com/baidu/che/codriver/a/a:g	Ljava/lang/String;
    //   202: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 121	com/baidu/che/codriver/util/h:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: ldc 114
    //   213: new 90	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   220: ldc 127
    //   222: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 112	com/baidu/che/codriver/a/a:h	Ljava/lang/String;
    //   229: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 121	com/baidu/che/codriver/util/h:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 130	java/io/BufferedReader:close	()V
    //   246: aload_1
    //   247: ifnull +141 -> 388
    //   250: aload_1
    //   251: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   254: return
    //   255: astore_2
    //   256: aload_2
    //   257: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   260: goto -14 -> 246
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   268: return
    //   269: astore 5
    //   271: aload 6
    //   273: astore_1
    //   274: aload 4
    //   276: astore_2
    //   277: aload_1
    //   278: astore_3
    //   279: aload 5
    //   281: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 130	java/io/BufferedReader:close	()V
    //   294: aload_1
    //   295: ifnull -41 -> 254
    //   298: aload_1
    //   299: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   302: return
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   308: return
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   314: goto -20 -> 294
    //   317: astore_1
    //   318: aload_2
    //   319: ifnull +7 -> 326
    //   322: aload_2
    //   323: invokevirtual 130	java/io/BufferedReader:close	()V
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   334: aload_1
    //   335: athrow
    //   336: astore_2
    //   337: aload_2
    //   338: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   341: goto -15 -> 326
    //   344: astore_2
    //   345: aload_2
    //   346: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   349: goto -15 -> 334
    //   352: astore 4
    //   354: aload 5
    //   356: astore_2
    //   357: aload_1
    //   358: astore_3
    //   359: aload 4
    //   361: astore_1
    //   362: goto -44 -> 318
    //   365: astore 4
    //   367: aload_1
    //   368: astore_3
    //   369: aload 4
    //   371: astore_1
    //   372: goto -54 -> 318
    //   375: astore 5
    //   377: goto -103 -> 274
    //   380: astore 5
    //   382: aload_2
    //   383: astore 4
    //   385: goto -111 -> 274
    //   388: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	a
    //   31	220	1	localInputStreamReader	java.io.InputStreamReader
    //   263	2	1	localIOException1	java.io.IOException
    //   273	26	1	localObject1	Object
    //   303	2	1	localIOException2	java.io.IOException
    //   317	41	1	localObject2	Object
    //   361	11	1	localObject3	Object
    //   6	237	2	localBufferedReader	java.io.BufferedReader
    //   255	2	2	localIOException3	java.io.IOException
    //   276	1	2	localObject4	Object
    //   309	14	2	localIOException4	java.io.IOException
    //   336	2	2	localIOException5	java.io.IOException
    //   344	2	2	localIOException6	java.io.IOException
    //   356	27	2	localObject5	Object
    //   1	368	3	localObject6	Object
    //   11	279	4	str	String
    //   352	8	4	localObject7	Object
    //   365	5	4	localObject8	Object
    //   383	1	4	localObject9	Object
    //   8	1	5	localObject10	Object
    //   269	86	5	localException1	Exception
    //   375	1	5	localException2	Exception
    //   380	1	5	localException3	Exception
    //   3	269	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   242	246	255	java/io/IOException
    //   250	254	263	java/io/IOException
    //   13	32	269	java/lang/Exception
    //   298	302	303	java/io/IOException
    //   289	294	309	java/io/IOException
    //   13	32	317	finally
    //   279	284	317	finally
    //   322	326	336	java/io/IOException
    //   330	334	344	java/io/IOException
    //   32	41	352	finally
    //   44	50	365	finally
    //   55	75	365	finally
    //   78	92	365	finally
    //   96	238	365	finally
    //   32	41	375	java/lang/Exception
    //   44	50	380	java/lang/Exception
    //   55	75	380	java/lang/Exception
    //   78	92	380	java/lang/Exception
    //   96	238	380	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  private static class a
  {
    private static final a a = new a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */