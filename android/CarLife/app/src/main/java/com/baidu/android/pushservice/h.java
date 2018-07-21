package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.p;
import java.net.InetAddress;
import java.util.ArrayList;

public final class h
{
  public static int a;
  public static int b;
  public static String[] c;
  public static String d;
  public static final String e = m;
  public static final String f = e + "/searchbox?action=publicsrv&type=issuedcode";
  private static String g = "api.tuisong.baidu.com";
  private static String[] h = { "api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com" };
  private static String i = "sa.tuisong.baidu.com";
  private static String[] j = { "sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com" };
  private static final String[] k;
  private static boolean l;
  private static String m;
  private static ArrayList<String> n;
  private static ArrayList<String> o;
  private static boolean p = false;
  
  static
  {
    a = 5287;
    b = 5288;
    k = new String[] { "202.108.23.109", "180.149.132.103", "111.13.12.174", "111.13.12.61" };
    c = new String[] { "202.108.23.105", "180.149.132.107", "111.13.12.162", "180.149.131.209", "111.13.12.110", "111.13.100.86", " 111.13.100.85", " 61.135.185.18", "220.181.163.183", "220.181.163.182", " 115.239.210.219", "115.239.210.246" };
    l = true;
    m = "http://m.baidu.com";
    d = "http://m.baidu.com";
    n = null;
    o = null;
  }
  
  public static int a(Context paramContext)
  {
    if (p.F(paramContext)) {
      return b;
    }
    return a;
  }
  
  public static String a()
  {
    return "http://" + g;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    if ((o == null) || (o.isEmpty()) || (l)) {
      o = a(paramContext, ".baidu.push.sa");
    }
    if ((o != null) && (o.size() > 0))
    {
      if (!paramBoolean) {
        o.remove(0);
      }
      if (o.size() > 0) {
        return (String)o.get(0);
      }
    }
    return null;
  }
  
  private static ArrayList<String> a(Context paramContext, String paramString)
  {
    int i2 = 0;
    int i1 = 0;
    ArrayList localArrayList = b(paramContext, paramString);
    if (localArrayList.size() <= 0)
    {
      if (paramString.equals(".baidu.push.http"))
      {
        paramString = k;
        i2 = paramString.length;
        while (i1 < i2)
        {
          localArrayList.add(paramString[i1]);
          i1 += 1;
        }
      }
      paramString = c;
      int i3 = paramString.length;
      i1 = i2;
      while (i1 < i3)
      {
        localArrayList.add(paramString[i1]);
        i1 += 1;
      }
      l = true;
      c(paramContext);
      return localArrayList;
    }
    l = false;
    return localArrayList;
  }
  
  public static String b()
  {
    return "https://" + g;
  }
  
  public static String b(Context paramContext, boolean paramBoolean)
  {
    if ((n == null) || (n.isEmpty())) {
      n = a(paramContext, ".baidu.push.http");
    }
    if ((n != null) && (n.size() > 0))
    {
      if (!paramBoolean) {
        n.remove(0);
      }
      if (n.size() > 0) {
        return (String)n.get(0);
      }
    }
    return null;
  }
  
  private static ArrayList<String> b(Context paramContext, String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("pst", 0).getString(paramString, null);
    if (!TextUtils.isEmpty(paramContext))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length > 0)) {
        while (i1 < paramContext.length)
        {
          localArrayList.add(paramContext[i1]);
          i1 += 1;
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static void b(Context paramContext)
  {
    // Byte code:
    //   0: new 241	java/io/File
    //   3: dup
    //   4: invokestatic 247	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc -7
    //   9: invokespecial 252	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 255	java/io/File:exists	()Z
    //   17: ifeq +511 -> 528
    //   20: new 257	java/util/Properties
    //   23: dup
    //   24: invokespecial 258	java/util/Properties:<init>	()V
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: ldc_w 260
    //   36: invokestatic 264	com/baidu/android/pushservice/j/p:u	(Landroid/content/Context;Ljava/lang/String;)Z
    //   39: ifeq +348 -> 387
    //   42: new 266	java/io/FileInputStream
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: astore 4
    //   56: aload 7
    //   58: aload_2
    //   59: invokevirtual 273	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_2
    //   63: astore_3
    //   64: aload_2
    //   65: astore 4
    //   67: aload 7
    //   69: ldc_w 275
    //   72: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 6
    //   77: aload_2
    //   78: astore_3
    //   79: aload_2
    //   80: astore 4
    //   82: aload 6
    //   84: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +49 -> 136
    //   90: aload 6
    //   92: astore 5
    //   94: aload_2
    //   95: astore_3
    //   96: aload_2
    //   97: astore 4
    //   99: aload 6
    //   101: ldc -89
    //   103: invokevirtual 283	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   106: ifeq +20 -> 126
    //   109: aload_2
    //   110: astore_3
    //   111: aload_2
    //   112: astore 4
    //   114: aload 6
    //   116: ldc -89
    //   118: ldc_w 285
    //   121: invokevirtual 289	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   124: astore 5
    //   126: aload_2
    //   127: astore_3
    //   128: aload_2
    //   129: astore 4
    //   131: aload 5
    //   133: putstatic 34	com/baidu/android/pushservice/h:g	Ljava/lang/String;
    //   136: aload_2
    //   137: astore_3
    //   138: aload_2
    //   139: astore 4
    //   141: aload 7
    //   143: ldc_w 291
    //   146: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 5
    //   151: aload_2
    //   152: astore_3
    //   153: aload_2
    //   154: astore 4
    //   156: aload 5
    //   158: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne +13 -> 174
    //   164: aload_2
    //   165: astore_3
    //   166: aload_2
    //   167: astore 4
    //   169: aload 5
    //   171: putstatic 62	com/baidu/android/pushservice/h:i	Ljava/lang/String;
    //   174: aload_2
    //   175: astore_3
    //   176: aload_2
    //   177: astore 4
    //   179: aload_0
    //   180: invokestatic 165	com/baidu/android/pushservice/j/p:F	(Landroid/content/Context;)Z
    //   183: ifne +282 -> 465
    //   186: aload_2
    //   187: astore_3
    //   188: aload_2
    //   189: astore 4
    //   191: aload 7
    //   193: ldc_w 293
    //   196: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 5
    //   201: aload_2
    //   202: astore_3
    //   203: aload_2
    //   204: astore 4
    //   206: aload 5
    //   208: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +16 -> 227
    //   214: aload_2
    //   215: astore_3
    //   216: aload_2
    //   217: astore 4
    //   219: aload 5
    //   221: invokestatic 299	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   224: putstatic 86	com/baidu/android/pushservice/h:a	I
    //   227: aload_2
    //   228: astore_3
    //   229: aload_2
    //   230: astore 4
    //   232: aload 7
    //   234: ldc_w 301
    //   237: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 5
    //   242: aload_2
    //   243: astore_3
    //   244: aload_2
    //   245: astore 4
    //   247: aload 5
    //   249: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne +13 -> 265
    //   255: aload_2
    //   256: astore_3
    //   257: aload_2
    //   258: astore 4
    //   260: aload 5
    //   262: putstatic 130	com/baidu/android/pushservice/h:m	Ljava/lang/String;
    //   265: aload_2
    //   266: astore_3
    //   267: aload_2
    //   268: astore 4
    //   270: aload 7
    //   272: ldc_w 303
    //   275: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifne +13 -> 294
    //   284: aload_2
    //   285: astore_3
    //   286: aload_2
    //   287: astore 4
    //   289: aload 5
    //   291: putstatic 132	com/baidu/android/pushservice/h:d	Ljava/lang/String;
    //   294: aload_2
    //   295: astore_3
    //   296: aload_2
    //   297: astore 4
    //   299: getstatic 306	com/baidu/android/pushservice/f:a	I
    //   302: ifne +64 -> 366
    //   305: aload_2
    //   306: astore_3
    //   307: aload_2
    //   308: astore 4
    //   310: aload 7
    //   312: ldc_w 308
    //   315: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 5
    //   320: aload_2
    //   321: astore_3
    //   322: aload_2
    //   323: astore 4
    //   325: aload 7
    //   327: ldc_w 310
    //   330: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   333: aload_0
    //   334: invokevirtual 313	android/content/Context:getPackageName	()Ljava/lang/String;
    //   337: invokestatic 316	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   340: ifeq +26 -> 366
    //   343: aload_2
    //   344: astore_3
    //   345: aload_2
    //   346: astore 4
    //   348: aload 5
    //   350: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   353: ifne +13 -> 366
    //   356: aload_2
    //   357: astore_3
    //   358: aload_2
    //   359: astore 4
    //   361: aload 5
    //   363: putstatic 318	com/baidu/android/pushservice/f:b	Ljava/lang/String;
    //   366: aload_2
    //   367: astore_3
    //   368: aload_2
    //   369: astore 4
    //   371: iconst_1
    //   372: putstatic 157	com/baidu/android/pushservice/h:p	Z
    //   375: iconst_1
    //   376: anewarray 320	java/io/Closeable
    //   379: dup
    //   380: iconst_0
    //   381: aload_2
    //   382: aastore
    //   383: invokestatic 325	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   386: return
    //   387: aload 7
    //   389: ldc_w 275
    //   392: ldc_w 327
    //   395: invokevirtual 331	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: pop
    //   399: aload_0
    //   400: invokestatic 165	com/baidu/android/pushservice/j/p:F	(Landroid/content/Context;)Z
    //   403: ifeq +32 -> 435
    //   406: aload 7
    //   408: ldc_w 333
    //   411: ldc_w 335
    //   414: invokevirtual 331	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   417: pop
    //   418: aload 7
    //   420: ldc_w 291
    //   423: ldc_w 337
    //   426: invokevirtual 331	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   429: pop
    //   430: aconst_null
    //   431: astore_2
    //   432: goto -370 -> 62
    //   435: aload 7
    //   437: ldc_w 293
    //   440: ldc_w 339
    //   443: invokevirtual 331	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   446: pop
    //   447: goto -29 -> 418
    //   450: astore_0
    //   451: aconst_null
    //   452: astore_3
    //   453: iconst_1
    //   454: anewarray 320	java/io/Closeable
    //   457: dup
    //   458: iconst_0
    //   459: aload_3
    //   460: aastore
    //   461: invokestatic 325	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   464: return
    //   465: aload_2
    //   466: astore_3
    //   467: aload_2
    //   468: astore 4
    //   470: aload 7
    //   472: ldc_w 333
    //   475: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 5
    //   480: aload_2
    //   481: astore_3
    //   482: aload_2
    //   483: astore 4
    //   485: aload 5
    //   487: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   490: ifne -263 -> 227
    //   493: aload_2
    //   494: astore_3
    //   495: aload_2
    //   496: astore 4
    //   498: aload 5
    //   500: invokestatic 299	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   503: putstatic 88	com/baidu/android/pushservice/h:b	I
    //   506: goto -279 -> 227
    //   509: astore_0
    //   510: goto -57 -> 453
    //   513: astore_0
    //   514: iconst_1
    //   515: anewarray 320	java/io/Closeable
    //   518: dup
    //   519: iconst_0
    //   520: aload 4
    //   522: aastore
    //   523: invokestatic 325	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   526: aload_0
    //   527: athrow
    //   528: aload_0
    //   529: invokestatic 344	com/baidu/android/pushservice/PushSettings:a	(Landroid/content/Context;)Ljava/lang/String;
    //   532: astore_0
    //   533: aload_0
    //   534: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   537: ifne -151 -> 386
    //   540: aload_0
    //   541: invokevirtual 347	java/lang/String:length	()I
    //   544: ifle -158 -> 386
    //   547: aload_0
    //   548: aload_0
    //   549: invokevirtual 347	java/lang/String:length	()I
    //   552: iconst_1
    //   553: isub
    //   554: invokevirtual 351	java/lang/String:substring	(I)Ljava/lang/String;
    //   557: invokestatic 299	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   560: istore_1
    //   561: getstatic 58	com/baidu/android/pushservice/h:h	[Ljava/lang/String;
    //   564: iload_1
    //   565: bipush 10
    //   567: irem
    //   568: aaload
    //   569: putstatic 34	com/baidu/android/pushservice/h:g	Ljava/lang/String;
    //   572: getstatic 84	com/baidu/android/pushservice/h:j	[Ljava/lang/String;
    //   575: iload_1
    //   576: bipush 10
    //   578: irem
    //   579: aaload
    //   580: putstatic 62	com/baidu/android/pushservice/h:i	Ljava/lang/String;
    //   583: return
    //   584: astore_0
    //   585: return
    //   586: astore_0
    //   587: goto -73 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	paramContext	Context
    //   560	19	1	i1	int
    //   12	484	2	localObject1	Object
    //   52	443	3	localObject2	Object
    //   30	491	4	localObject3	Object
    //   92	407	5	str1	String
    //   75	40	6	str2	String
    //   27	444	7	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   32	51	450	java/lang/Exception
    //   387	418	450	java/lang/Exception
    //   418	430	450	java/lang/Exception
    //   435	447	450	java/lang/Exception
    //   56	62	509	java/lang/Exception
    //   67	77	509	java/lang/Exception
    //   82	90	509	java/lang/Exception
    //   99	109	509	java/lang/Exception
    //   114	126	509	java/lang/Exception
    //   131	136	509	java/lang/Exception
    //   141	151	509	java/lang/Exception
    //   156	164	509	java/lang/Exception
    //   169	174	509	java/lang/Exception
    //   179	186	509	java/lang/Exception
    //   191	201	509	java/lang/Exception
    //   206	214	509	java/lang/Exception
    //   219	227	509	java/lang/Exception
    //   232	242	509	java/lang/Exception
    //   247	255	509	java/lang/Exception
    //   260	265	509	java/lang/Exception
    //   270	284	509	java/lang/Exception
    //   289	294	509	java/lang/Exception
    //   299	305	509	java/lang/Exception
    //   310	320	509	java/lang/Exception
    //   325	343	509	java/lang/Exception
    //   348	356	509	java/lang/Exception
    //   361	366	509	java/lang/Exception
    //   371	375	509	java/lang/Exception
    //   470	480	509	java/lang/Exception
    //   485	493	509	java/lang/Exception
    //   498	506	509	java/lang/Exception
    //   32	51	513	finally
    //   387	418	513	finally
    //   418	430	513	finally
    //   435	447	513	finally
    //   547	583	584	java/lang/Exception
    //   56	62	586	finally
    //   67	77	586	finally
    //   82	90	586	finally
    //   99	109	586	finally
    //   114	126	586	finally
    //   131	136	586	finally
    //   141	151	586	finally
    //   156	164	586	finally
    //   169	174	586	finally
    //   179	186	586	finally
    //   191	201	586	finally
    //   206	214	586	finally
    //   219	227	586	finally
    //   232	242	586	finally
    //   247	255	586	finally
    //   260	265	586	finally
    //   270	284	586	finally
    //   289	294	586	finally
    //   299	305	586	finally
    //   310	320	586	finally
    //   325	343	586	finally
    //   348	356	586	finally
    //   361	366	586	finally
    //   371	375	586	finally
    //   470	480	586	finally
    //   485	493	586	finally
    //   498	506	586	finally
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    try
    {
      if (paramString1.startsWith("http://")) {
        localObject = paramString1.replace("http://", "");
      }
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName((String)localObject);
      if ((paramContext != null) && (arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        localObject = paramContext.getSharedPreferences("pst", 0);
        int i2 = arrayOfInetAddress.length;
        paramString1 = "";
        int i1 = 0;
        while (i1 < i2)
        {
          InetAddress localInetAddress = arrayOfInetAddress[i1];
          paramString1 = paramString1 + ":" + localInetAddress.getHostAddress();
          i1 += 1;
        }
        if (paramString1.length() > 1)
        {
          paramString1 = paramString1.substring(1);
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putString(paramString2, paramString1);
          ((SharedPreferences.Editor)localObject).commit();
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      q.a(paramContext, paramString1);
    }
    return false;
  }
  
  public static String c()
  {
    return i;
  }
  
  public static void c(final Context paramContext)
  {
    final SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("pst", 0);
    long l1 = localSharedPreferences.getLong(".baidu.push.dns.refresh", 0L);
    if (System.currentTimeMillis() - l1 > 86400000L) {
      d.a().a(new c("updateBackupIp", (short)95)
      {
        public void a()
        {
          boolean bool1 = h.a(paramContext.getApplicationContext(), h.g(), ".baidu.push.sa");
          boolean bool2 = h.a(paramContext.getApplicationContext(), h.h(), ".baidu.push.http");
          if ((bool1) && (bool2))
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putLong(".baidu.push.dns.refresh", System.currentTimeMillis());
            localEditor.commit();
          }
        }
      });
    }
  }
  
  public static String d()
  {
    if (p) {
      return a() + "/rest/2.0/channel/channel";
    }
    return b() + "/rest/2.0/channel/channel";
  }
  
  public static String e()
  {
    if (p) {
      return a() + "/rest/2.0/channel/";
    }
    return b() + "/rest/2.0/channel/";
  }
  
  public static boolean f()
  {
    return p;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */