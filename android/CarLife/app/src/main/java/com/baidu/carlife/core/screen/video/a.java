package com.baidu.carlife.core.screen.video;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

public abstract class a
  extends Thread
{
  protected static byte[] d;
  protected static ByteBuffer e;
  protected static Bitmap f;
  private static final String h = "BaseReceiverAndConverterThread";
  protected boolean a = true;
  protected DataInputStream b;
  protected DataOutputStream c;
  protected ByteArrayOutputStream g = new ByteArrayOutputStream();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: new 55	java/io/File
    //   3: dup
    //   4: ldc 57
    //   6: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore 17
    //   11: aload 17
    //   13: invokevirtual 64	java/io/File:exists	()Z
    //   16: ifeq +31 -> 47
    //   19: aload 17
    //   21: invokevirtual 68	java/io/File:lastModified	()J
    //   24: lstore_3
    //   25: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   28: lstore 5
    //   30: lload_3
    //   31: lconst_0
    //   32: lcmp
    //   33: ifle +15 -> 48
    //   36: lload 5
    //   38: lload_3
    //   39: lsub
    //   40: ldc2_w 74
    //   43: lcmp
    //   44: ifle +4 -> 48
    //   47: return
    //   48: aconst_null
    //   49: astore 15
    //   51: aconst_null
    //   52: astore 16
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 14
    //   60: aconst_null
    //   61: astore 12
    //   63: aconst_null
    //   64: astore 13
    //   66: aconst_null
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore 11
    //   75: bipush 10
    //   77: newarray <illegal type>
    //   79: astore 18
    //   81: new 77	java/io/FileInputStream
    //   84: dup
    //   85: aload 17
    //   87: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore 7
    //   92: new 82	java/lang/StringBuffer
    //   95: dup
    //   96: invokespecial 83	java/lang/StringBuffer:<init>	()V
    //   99: astore 8
    //   101: aload 7
    //   103: aload 18
    //   105: invokevirtual 87	java/io/FileInputStream:read	([B)I
    //   108: istore_1
    //   109: iload_1
    //   110: iconst_m1
    //   111: if_icmpeq +67 -> 178
    //   114: aload 8
    //   116: new 89	java/lang/String
    //   119: dup
    //   120: aload 18
    //   122: iconst_0
    //   123: iload_1
    //   124: invokespecial 92	java/lang/String:<init>	([BII)V
    //   127: invokevirtual 96	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   130: pop
    //   131: goto -30 -> 101
    //   134: astore 10
    //   136: aload 7
    //   138: astore 8
    //   140: aload 11
    //   142: astore 9
    //   144: aload 10
    //   146: invokevirtual 99	java/io/FileNotFoundException:printStackTrace	()V
    //   149: aload 7
    //   151: ifnull +8 -> 159
    //   154: aload 7
    //   156: invokevirtual 102	java/io/FileInputStream:close	()V
    //   159: aload 11
    //   161: ifnull -114 -> 47
    //   164: aload 11
    //   166: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   169: return
    //   170: astore 7
    //   172: aload 7
    //   174: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   177: return
    //   178: aload 8
    //   180: invokevirtual 110	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   183: ldc 112
    //   185: invokevirtual 116	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   188: astore 8
    //   190: aload 8
    //   192: ifnull +122 -> 314
    //   195: iconst_1
    //   196: istore_1
    //   197: aload 8
    //   199: arraylength
    //   200: iconst_2
    //   201: if_icmple +118 -> 319
    //   204: iconst_1
    //   205: istore_2
    //   206: iload_2
    //   207: iload_1
    //   208: iand
    //   209: ifeq +55 -> 264
    //   212: aload 8
    //   214: iconst_0
    //   215: aaload
    //   216: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: aload 8
    //   221: iconst_1
    //   222: aaload
    //   223: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: iadd
    //   227: iconst_2
    //   228: if_icmplt +36 -> 264
    //   231: getstatic 127	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   234: getstatic 133	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   237: invokevirtual 137	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   240: ldc -117
    //   242: invokevirtual 143	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   245: ifeq +79 -> 324
    //   248: aload_0
    //   249: getfield 145	com/baidu/carlife/core/screen/video/a:c	Ljava/io/DataOutputStream;
    //   252: sipush 206
    //   255: invokevirtual 150	java/io/DataOutputStream:write	(I)V
    //   258: sipush 4251
    //   261: invokestatic 154	com/baidu/carlife/core/k:b	(I)V
    //   264: new 104	java/io/FileOutputStream
    //   267: dup
    //   268: aload 17
    //   270: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: astore 8
    //   275: aload 8
    //   277: ldc -99
    //   279: invokevirtual 161	java/lang/String:getBytes	()[B
    //   282: invokevirtual 164	java/io/FileOutputStream:write	([B)V
    //   285: aload 7
    //   287: ifnull +8 -> 295
    //   290: aload 7
    //   292: invokevirtual 102	java/io/FileInputStream:close	()V
    //   295: aload 8
    //   297: ifnull -250 -> 47
    //   300: aload 8
    //   302: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   305: return
    //   306: astore 7
    //   308: aload 7
    //   310: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   313: return
    //   314: iconst_0
    //   315: istore_1
    //   316: goto -119 -> 197
    //   319: iconst_0
    //   320: istore_2
    //   321: goto -115 -> 206
    //   324: bipush 18
    //   326: istore_1
    //   327: ldc -90
    //   329: invokestatic 172	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   332: astore 8
    //   334: aload 8
    //   336: iconst_0
    //   337: anewarray 168	java/lang/Class
    //   340: invokevirtual 176	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   343: astore 9
    //   345: aload 9
    //   347: iconst_1
    //   348: invokevirtual 182	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   351: aload 9
    //   353: iconst_0
    //   354: anewarray 184	java/lang/Object
    //   357: invokevirtual 188	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   360: astore 9
    //   362: aload 8
    //   364: ldc -66
    //   366: iconst_1
    //   367: anewarray 168	java/lang/Class
    //   370: dup
    //   371: iconst_0
    //   372: getstatic 194	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   375: aastore
    //   376: invokevirtual 198	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   379: aload 9
    //   381: iconst_1
    //   382: anewarray 184	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: sipush 2006
    //   390: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: aastore
    //   394: invokevirtual 208	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast 118	java/lang/Integer
    //   400: invokevirtual 212	java/lang/Integer:intValue	()I
    //   403: istore_2
    //   404: iload_2
    //   405: istore_1
    //   406: aload_0
    //   407: getfield 145	com/baidu/carlife/core/screen/video/a:c	Ljava/io/DataOutputStream;
    //   410: iload_1
    //   411: sipush 200
    //   414: iadd
    //   415: invokevirtual 150	java/io/DataOutputStream:write	(I)V
    //   418: goto -160 -> 258
    //   421: astore 10
    //   423: aload 12
    //   425: astore 11
    //   427: aload 7
    //   429: astore 8
    //   431: aload 11
    //   433: astore 9
    //   435: aload 10
    //   437: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 102	java/io/FileInputStream:close	()V
    //   450: aload 11
    //   452: ifnull -405 -> 47
    //   455: aload 11
    //   457: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   460: return
    //   461: astore 7
    //   463: aload 7
    //   465: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   468: return
    //   469: astore 8
    //   471: aload 8
    //   473: invokevirtual 213	java/lang/ClassNotFoundException:printStackTrace	()V
    //   476: goto -70 -> 406
    //   479: astore 10
    //   481: aload 13
    //   483: astore 11
    //   485: aload 7
    //   487: astore 8
    //   489: aload 11
    //   491: astore 9
    //   493: ldc 14
    //   495: aload 10
    //   497: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   500: invokestatic 219	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 7
    //   505: ifnull +8 -> 513
    //   508: aload 7
    //   510: invokevirtual 102	java/io/FileInputStream:close	()V
    //   513: aload 11
    //   515: ifnull -468 -> 47
    //   518: aload 11
    //   520: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   523: return
    //   524: astore 7
    //   526: aload 7
    //   528: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   531: return
    //   532: astore 8
    //   534: aload 8
    //   536: invokevirtual 220	java/lang/NoSuchMethodException:printStackTrace	()V
    //   539: goto -133 -> 406
    //   542: astore 9
    //   544: aload 7
    //   546: astore 8
    //   548: aload 9
    //   550: astore 7
    //   552: aload 10
    //   554: astore 9
    //   556: aload 8
    //   558: ifnull +8 -> 566
    //   561: aload 8
    //   563: invokevirtual 102	java/io/FileInputStream:close	()V
    //   566: aload 9
    //   568: ifnull +8 -> 576
    //   571: aload 9
    //   573: invokevirtual 105	java/io/FileOutputStream:close	()V
    //   576: aload 7
    //   578: athrow
    //   579: astore 8
    //   581: aload 8
    //   583: invokevirtual 221	java/lang/InstantiationException:printStackTrace	()V
    //   586: goto -180 -> 406
    //   589: astore 8
    //   591: aload 8
    //   593: invokevirtual 222	java/lang/IllegalAccessException:printStackTrace	()V
    //   596: goto -190 -> 406
    //   599: astore 8
    //   601: aload 8
    //   603: invokevirtual 223	java/lang/IllegalArgumentException:printStackTrace	()V
    //   606: goto -200 -> 406
    //   609: astore 8
    //   611: aload 8
    //   613: invokevirtual 224	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   616: goto -210 -> 406
    //   619: astore 7
    //   621: aload 7
    //   623: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   626: goto -331 -> 295
    //   629: astore 7
    //   631: aload 7
    //   633: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   636: goto -477 -> 159
    //   639: astore 7
    //   641: aload 7
    //   643: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   646: goto -196 -> 450
    //   649: astore 7
    //   651: aload 7
    //   653: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   656: goto -143 -> 513
    //   659: astore 8
    //   661: aload 8
    //   663: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   666: goto -100 -> 566
    //   669: astore 8
    //   671: aload 8
    //   673: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   676: goto -100 -> 576
    //   679: astore 7
    //   681: goto -125 -> 556
    //   684: astore 10
    //   686: aload 8
    //   688: astore 9
    //   690: aload 7
    //   692: astore 8
    //   694: aload 10
    //   696: astore 7
    //   698: goto -142 -> 556
    //   701: astore 10
    //   703: aload 16
    //   705: astore 7
    //   707: aload 13
    //   709: astore 11
    //   711: goto -226 -> 485
    //   714: astore 10
    //   716: aload 8
    //   718: astore 11
    //   720: goto -235 -> 485
    //   723: astore 10
    //   725: aload 15
    //   727: astore 7
    //   729: aload 12
    //   731: astore 11
    //   733: goto -306 -> 427
    //   736: astore 10
    //   738: aload 8
    //   740: astore 11
    //   742: goto -315 -> 427
    //   745: astore 10
    //   747: aload 14
    //   749: astore 7
    //   751: goto -615 -> 136
    //   754: astore 10
    //   756: aload 8
    //   758: astore 11
    //   760: goto -624 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	a
    //   108	307	1	i	int
    //   205	200	2	j	int
    //   24	15	3	l1	long
    //   28	9	5	l2	long
    //   90	65	7	localFileInputStream	java.io.FileInputStream
    //   170	121	7	localIOException1	java.io.IOException
    //   306	140	7	localIOException2	java.io.IOException
    //   461	48	7	localIOException3	java.io.IOException
    //   524	21	7	localIOException4	java.io.IOException
    //   550	27	7	localObject1	Object
    //   619	3	7	localIOException5	java.io.IOException
    //   629	3	7	localIOException6	java.io.IOException
    //   639	3	7	localIOException7	java.io.IOException
    //   649	3	7	localIOException8	java.io.IOException
    //   679	12	7	localObject2	Object
    //   696	54	7	localObject3	Object
    //   55	375	8	localObject4	Object
    //   469	3	8	localClassNotFoundException	ClassNotFoundException
    //   487	1	8	localObject5	Object
    //   532	3	8	localNoSuchMethodException	NoSuchMethodException
    //   546	16	8	localObject6	Object
    //   579	3	8	localInstantiationException	InstantiationException
    //   589	3	8	localIllegalAccessException	IllegalAccessException
    //   599	3	8	localIllegalArgumentException	IllegalArgumentException
    //   609	3	8	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   659	3	8	localIOException9	java.io.IOException
    //   669	18	8	localIOException10	java.io.IOException
    //   692	65	8	localObject7	Object
    //   70	422	9	localObject8	Object
    //   542	7	9	localObject9	Object
    //   554	135	9	localObject10	Object
    //   67	1	10	localObject11	Object
    //   134	11	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   421	15	10	localIOException11	java.io.IOException
    //   479	74	10	localException1	Exception
    //   684	11	10	localObject12	Object
    //   701	1	10	localException2	Exception
    //   714	1	10	localException3	Exception
    //   723	1	10	localIOException12	java.io.IOException
    //   736	1	10	localIOException13	java.io.IOException
    //   745	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   754	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   73	686	11	localObject13	Object
    //   61	669	12	localObject14	Object
    //   64	644	13	localObject15	Object
    //   58	690	14	localObject16	Object
    //   49	677	15	localObject17	Object
    //   52	652	16	localObject18	Object
    //   9	260	17	localFile	java.io.File
    //   79	42	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   92	101	134	java/io/FileNotFoundException
    //   101	109	134	java/io/FileNotFoundException
    //   114	131	134	java/io/FileNotFoundException
    //   178	190	134	java/io/FileNotFoundException
    //   197	204	134	java/io/FileNotFoundException
    //   212	258	134	java/io/FileNotFoundException
    //   258	264	134	java/io/FileNotFoundException
    //   264	275	134	java/io/FileNotFoundException
    //   327	404	134	java/io/FileNotFoundException
    //   406	418	134	java/io/FileNotFoundException
    //   471	476	134	java/io/FileNotFoundException
    //   534	539	134	java/io/FileNotFoundException
    //   581	586	134	java/io/FileNotFoundException
    //   591	596	134	java/io/FileNotFoundException
    //   601	606	134	java/io/FileNotFoundException
    //   611	616	134	java/io/FileNotFoundException
    //   164	169	170	java/io/IOException
    //   300	305	306	java/io/IOException
    //   92	101	421	java/io/IOException
    //   101	109	421	java/io/IOException
    //   114	131	421	java/io/IOException
    //   178	190	421	java/io/IOException
    //   197	204	421	java/io/IOException
    //   212	258	421	java/io/IOException
    //   258	264	421	java/io/IOException
    //   264	275	421	java/io/IOException
    //   327	404	421	java/io/IOException
    //   406	418	421	java/io/IOException
    //   471	476	421	java/io/IOException
    //   534	539	421	java/io/IOException
    //   581	586	421	java/io/IOException
    //   591	596	421	java/io/IOException
    //   601	606	421	java/io/IOException
    //   611	616	421	java/io/IOException
    //   455	460	461	java/io/IOException
    //   327	404	469	java/lang/ClassNotFoundException
    //   92	101	479	java/lang/Exception
    //   101	109	479	java/lang/Exception
    //   114	131	479	java/lang/Exception
    //   178	190	479	java/lang/Exception
    //   197	204	479	java/lang/Exception
    //   212	258	479	java/lang/Exception
    //   258	264	479	java/lang/Exception
    //   264	275	479	java/lang/Exception
    //   327	404	479	java/lang/Exception
    //   406	418	479	java/lang/Exception
    //   471	476	479	java/lang/Exception
    //   534	539	479	java/lang/Exception
    //   581	586	479	java/lang/Exception
    //   591	596	479	java/lang/Exception
    //   601	606	479	java/lang/Exception
    //   611	616	479	java/lang/Exception
    //   518	523	524	java/io/IOException
    //   327	404	532	java/lang/NoSuchMethodException
    //   92	101	542	finally
    //   101	109	542	finally
    //   114	131	542	finally
    //   178	190	542	finally
    //   197	204	542	finally
    //   212	258	542	finally
    //   258	264	542	finally
    //   264	275	542	finally
    //   327	404	542	finally
    //   406	418	542	finally
    //   471	476	542	finally
    //   534	539	542	finally
    //   581	586	542	finally
    //   591	596	542	finally
    //   601	606	542	finally
    //   611	616	542	finally
    //   327	404	579	java/lang/InstantiationException
    //   327	404	589	java/lang/IllegalAccessException
    //   327	404	599	java/lang/IllegalArgumentException
    //   327	404	609	java/lang/reflect/InvocationTargetException
    //   290	295	619	java/io/IOException
    //   154	159	629	java/io/IOException
    //   445	450	639	java/io/IOException
    //   508	513	649	java/io/IOException
    //   561	566	659	java/io/IOException
    //   571	576	669	java/io/IOException
    //   81	92	679	finally
    //   144	149	679	finally
    //   435	440	679	finally
    //   493	503	679	finally
    //   275	285	684	finally
    //   81	92	701	java/lang/Exception
    //   275	285	714	java/lang/Exception
    //   81	92	723	java/io/IOException
    //   275	285	736	java/io/IOException
    //   81	92	745	java/io/FileNotFoundException
    //   275	285	754	java/io/FileNotFoundException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */