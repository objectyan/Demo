package com.baidu.location.indoor.mapversion.a;

import com.baidu.location.indoor.mapversion.IndoorJni;
import com.baidu.location.indoor.mapversion.b.a.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a
{
  private static Lock a = new ReentrantLock();
  
  public static boolean a()
  {
    return IndoorJni.a;
  }
  
  /* Error */
  public static boolean a(com.baidu.location.BDLocation paramBDLocation)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 27	com/baidu/location/indoor/mapversion/a/a:a	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifne +13 -> 26
    //   16: iload 6
    //   18: istore 5
    //   20: ldc 2
    //   22: monitorexit
    //   23: iload 5
    //   25: ireturn
    //   26: invokestatic 32	com/baidu/location/indoor/mapversion/b/a:a	()Lcom/baidu/location/indoor/mapversion/b/a;
    //   29: aload_0
    //   30: invokevirtual 38	com/baidu/location/BDLocation:getFloor	()Ljava/lang/String;
    //   33: invokevirtual 42	com/baidu/location/indoor/mapversion/b/a:b	(Ljava/lang/String;)Lcom/baidu/location/indoor/mapversion/b/a$d;
    //   36: astore 9
    //   38: iload 6
    //   40: istore 5
    //   42: aload 9
    //   44: ifnull -24 -> 20
    //   47: aload 9
    //   49: aload_0
    //   50: invokevirtual 46	com/baidu/location/BDLocation:getLongitude	()D
    //   53: invokevirtual 51	com/baidu/location/indoor/mapversion/b/a$d:a	(D)D
    //   56: dstore_1
    //   57: aload 9
    //   59: aload_0
    //   60: invokevirtual 54	com/baidu/location/BDLocation:getLatitude	()D
    //   63: invokevirtual 56	com/baidu/location/indoor/mapversion/b/a$d:b	(D)D
    //   66: dstore_3
    //   67: iconst_2
    //   68: newarray <illegal type>
    //   70: astore 7
    //   72: aload 7
    //   74: dup
    //   75: iconst_0
    //   76: dconst_0
    //   77: dastore
    //   78: dup
    //   79: iconst_1
    //   80: dconst_0
    //   81: dastore
    //   82: pop
    //   83: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   86: invokeinterface 61 1 0
    //   91: dload_1
    //   92: dload_3
    //   93: invokestatic 65	com/baidu/location/indoor/mapversion/IndoorJni:setPfWf	(DD)[D
    //   96: astore 8
    //   98: aload 8
    //   100: astore 7
    //   102: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   105: invokeinterface 68 1 0
    //   110: iload 6
    //   112: istore 5
    //   114: aload 7
    //   116: iconst_0
    //   117: daload
    //   118: dconst_0
    //   119: dcmpl
    //   120: ifle -100 -> 20
    //   123: iload 6
    //   125: istore 5
    //   127: aload 7
    //   129: iconst_1
    //   130: daload
    //   131: dconst_0
    //   132: dcmpl
    //   133: ifle -113 -> 20
    //   136: aload 9
    //   138: aload 7
    //   140: iconst_0
    //   141: daload
    //   142: invokevirtual 71	com/baidu/location/indoor/mapversion/b/a$d:c	(D)D
    //   145: dstore_1
    //   146: aload 9
    //   148: aload 7
    //   150: iconst_1
    //   151: daload
    //   152: invokevirtual 74	com/baidu/location/indoor/mapversion/b/a$d:d	(D)D
    //   155: dstore_3
    //   156: aload_0
    //   157: dload_1
    //   158: invokevirtual 78	com/baidu/location/BDLocation:setLongitude	(D)V
    //   161: aload_0
    //   162: dload_3
    //   163: invokevirtual 81	com/baidu/location/BDLocation:setLatitude	(D)V
    //   166: iconst_1
    //   167: istore 5
    //   169: goto -149 -> 20
    //   172: astore 8
    //   174: aload 8
    //   176: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   179: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   182: invokeinterface 68 1 0
    //   187: goto -77 -> 110
    //   190: astore_0
    //   191: ldc 2
    //   193: monitorexit
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   200: invokeinterface 68 1 0
    //   205: aload_0
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramBDLocation	com.baidu.location.BDLocation
    //   56	102	1	d1	double
    //   66	97	3	d2	double
    //   9	159	5	bool1	boolean
    //   1	123	6	bool2	boolean
    //   70	79	7	localObject	Object
    //   96	3	8	arrayOfDouble	double[]
    //   172	3	8	localException	Exception
    //   36	111	9	locald	a.d
    // Exception table:
    //   from	to	target	type
    //   91	98	172	java/lang/Exception
    //   6	11	190	finally
    //   26	38	190	finally
    //   47	91	190	finally
    //   102	110	190	finally
    //   136	166	190	finally
    //   179	187	190	finally
    //   197	207	190	finally
    //   91	98	196	finally
    //   174	179	196	finally
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 27	com/baidu/location/indoor/mapversion/a/a:a	()Z
    //   9: istore 10
    //   11: iload 10
    //   13: ifne +12 -> 25
    //   16: iconst_0
    //   17: istore 9
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 9
    //   24: ireturn
    //   25: invokestatic 32	com/baidu/location/indoor/mapversion/b/a:a	()Lcom/baidu/location/indoor/mapversion/b/a;
    //   28: aload_0
    //   29: invokevirtual 42	com/baidu/location/indoor/mapversion/b/a:b	(Ljava/lang/String;)Lcom/baidu/location/indoor/mapversion/b/a$d;
    //   32: astore 11
    //   34: aload 11
    //   36: ifnonnull +9 -> 45
    //   39: iconst_0
    //   40: istore 9
    //   42: goto -23 -> 19
    //   45: aload 11
    //   47: ldc 87
    //   49: invokevirtual 90	com/baidu/location/indoor/mapversion/b/a$d:a	(Ljava/lang/String;)V
    //   52: aload 11
    //   54: getfield 94	com/baidu/location/indoor/mapversion/b/a$d:g	[[S
    //   57: astore 12
    //   59: aload 11
    //   61: invokevirtual 97	com/baidu/location/indoor/mapversion/b/a$d:a	()Lcom/baidu/location/indoor/mapversion/b/a$a;
    //   64: getfield 102	com/baidu/location/indoor/mapversion/b/a$a:a	D
    //   67: dstore_1
    //   68: aload 11
    //   70: invokevirtual 97	com/baidu/location/indoor/mapversion/b/a$d:a	()Lcom/baidu/location/indoor/mapversion/b/a$a;
    //   73: getfield 104	com/baidu/location/indoor/mapversion/b/a$a:b	D
    //   76: dstore_3
    //   77: new 106	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   84: astore 13
    //   86: iconst_0
    //   87: istore 6
    //   89: iload 6
    //   91: aload 12
    //   93: arraylength
    //   94: if_icmpge +125 -> 219
    //   97: aload 12
    //   99: iload 6
    //   101: aaload
    //   102: iconst_0
    //   103: iaload
    //   104: istore 8
    //   106: iconst_1
    //   107: istore 7
    //   109: iconst_1
    //   110: istore 5
    //   112: iload 7
    //   114: aload 12
    //   116: iload 6
    //   118: aaload
    //   119: arraylength
    //   120: if_icmpge +55 -> 175
    //   123: iload 8
    //   125: aload 12
    //   127: iload 6
    //   129: aaload
    //   130: iload 7
    //   132: iaload
    //   133: if_icmpeq +173 -> 306
    //   136: aload 13
    //   138: iload 5
    //   140: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc 113
    //   145: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 8
    //   150: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 118
    //   155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 12
    //   161: iload 6
    //   163: aaload
    //   164: iload 7
    //   166: iaload
    //   167: istore 8
    //   169: iconst_1
    //   170: istore 5
    //   172: goto +125 -> 297
    //   175: aload 13
    //   177: iload 5
    //   179: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc 113
    //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload 8
    //   189: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc 118
    //   194: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: iload 6
    //   200: aload 12
    //   202: arraylength
    //   203: iconst_1
    //   204: isub
    //   205: if_icmpeq +110 -> 315
    //   208: aload 13
    //   210: ldc 120
    //   212: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: goto +99 -> 315
    //   219: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   222: invokeinterface 61 1 0
    //   227: aload_0
    //   228: aload 12
    //   230: dload_1
    //   231: dload_3
    //   232: aload 11
    //   234: getfield 124	com/baidu/location/indoor/mapversion/b/a$d:f	Lcom/baidu/location/indoor/mapversion/b/a$a;
    //   237: getfield 126	com/baidu/location/indoor/mapversion/b/a$a:g	D
    //   240: d2i
    //   241: aload 11
    //   243: getfield 124	com/baidu/location/indoor/mapversion/b/a$d:f	Lcom/baidu/location/indoor/mapversion/b/a$a;
    //   246: getfield 129	com/baidu/location/indoor/mapversion/b/a$a:h	D
    //   249: d2i
    //   250: invokestatic 133	com/baidu/location/indoor/mapversion/IndoorJni:setRdnt	(Ljava/lang/String;[[SDDII)V
    //   253: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   256: invokeinterface 68 1 0
    //   261: goto -242 -> 19
    //   264: astore_0
    //   265: ldc 2
    //   267: monitorexit
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   275: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   278: invokeinterface 68 1 0
    //   283: goto -264 -> 19
    //   286: astore_0
    //   287: getstatic 15	com/baidu/location/indoor/mapversion/a/a:a	Ljava/util/concurrent/locks/Lock;
    //   290: invokeinterface 68 1 0
    //   295: aload_0
    //   296: athrow
    //   297: iload 7
    //   299: iconst_1
    //   300: iadd
    //   301: istore 7
    //   303: goto -191 -> 112
    //   306: iload 5
    //   308: iconst_1
    //   309: iadd
    //   310: istore 5
    //   312: goto -15 -> 297
    //   315: iload 6
    //   317: iconst_1
    //   318: iadd
    //   319: istore 6
    //   321: goto -232 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramString	String
    //   67	164	1	d1	double
    //   76	156	3	d2	double
    //   110	201	5	i	int
    //   87	233	6	j	int
    //   107	195	7	k	int
    //   104	84	8	m	int
    //   1	40	9	bool1	boolean
    //   9	3	10	bool2	boolean
    //   32	210	11	locald	a.d
    //   57	172	12	arrayOfShort	short[][]
    //   84	125	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	11	264	finally
    //   25	34	264	finally
    //   45	86	264	finally
    //   89	97	264	finally
    //   112	123	264	finally
    //   136	159	264	finally
    //   175	216	264	finally
    //   219	227	264	finally
    //   253	261	264	finally
    //   275	283	264	finally
    //   287	297	264	finally
    //   227	253	270	java/lang/Exception
    //   227	253	286	finally
    //   271	275	286	finally
  }
  
  public static double[] a(String paramString, double paramDouble1, double paramDouble2)
  {
    Object localObject2 = null;
    for (;;)
    {
      a.d locald;
      Object localObject1;
      try
      {
        boolean bool = a();
        if (!bool)
        {
          paramString = (String)localObject2;
          return paramString;
        }
        locald = com.baidu.location.indoor.mapversion.b.a.a().b(paramString);
        paramString = (String)localObject2;
        if (locald == null) {
          continue;
        }
        a.lock();
        localObject1 = new double[2];
        Object tmp56_54 = localObject1;
        tmp56_54[0] = 0.0D;
        Object tmp60_56 = tmp56_54;
        tmp60_56[1] = 0.0D;
        tmp60_56;
      }
      finally {}
      try
      {
        paramString = IndoorJni.getPfFr(paramDouble2, paramDouble1);
        localObject1 = paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        a.unlock();
        continue;
      }
      finally
      {
        a.unlock();
      }
      paramString = (String)tmp56_54;
      if (localObject1[0] > 0.0D)
      {
        paramString = (String)tmp56_54;
        if (localObject1[1] > 0.0D)
        {
          paramDouble1 = tmp60_56.c(localObject1[0]);
          paramDouble2 = tmp60_56.d(localObject1[1]);
          paramString = new double[2];
          paramString[0] = paramDouble2;
          paramString[1] = paramDouble1;
        }
      }
    }
  }
  
  public static void b()
  {
    if (!a()) {
      return;
    }
    try
    {
      IndoorJni.resetPf();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/mapversion/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */