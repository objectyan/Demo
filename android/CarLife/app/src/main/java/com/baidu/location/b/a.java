package com.baidu.location.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class a
{
  private static Object b = new Object();
  private static a c = null;
  private static final String d = g.l() + "/gal.db";
  a a = null;
  private SQLiteDatabase e = null;
  private boolean f = false;
  private String g = null;
  private double h = Double.MAX_VALUE;
  private double i = Double.MAX_VALUE;
  
  public static a a()
  {
    synchronized (b)
    {
      if (c == null) {
        c = new a();
      }
      a locala = c;
      return locala;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (this.a == null) {
      this.a = new a();
    }
    this.a.a(paramDouble1, paramDouble2, paramDouble3);
  }
  
  public int a(BDLocation paramBDLocation)
  {
    float f1;
    double d1;
    if (paramBDLocation != null)
    {
      f1 = paramBDLocation.getRadius();
      d1 = paramBDLocation.getAltitude();
    }
    for (;;)
    {
      if ((this.e != null) && (f1 > 0.0F) && (d1 > 0.0D))
      {
        double d2 = b(paramBDLocation.getLongitude(), paramBDLocation.getLatitude());
        if (d2 != Double.MAX_VALUE)
        {
          d1 = Jni.getGpsSwiftRadius(f1, d1, d2);
          if (d1 > 50.0D) {
            return 3;
          }
          if (d1 > 20.0D) {
            return 2;
          }
          return 1;
        }
      }
      return 0;
      d1 = 0.0D;
      f1 = 0.0F;
    }
  }
  
  /* Error */
  public double[] a(double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: ldc2_w 61
    //   3: dstore 5
    //   5: ldc2_w 61
    //   8: dstore 7
    //   10: iconst_2
    //   11: newarray <illegal type>
    //   13: astore 20
    //   15: aload_0
    //   16: getfield 54	com/baidu/location/b/a:e	Landroid/database/sqlite/SQLiteDatabase;
    //   19: ifnull +622 -> 641
    //   22: aconst_null
    //   23: astore 19
    //   25: getstatic 115	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   28: ldc 117
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc2_w 118
    //   39: dload_1
    //   40: dmul
    //   41: invokestatic 125	java/lang/Math:floor	(D)D
    //   44: d2i
    //   45: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc2_w 118
    //   54: dload_3
    //   55: dmul
    //   56: invokestatic 125	java/lang/Math:floor	(D)D
    //   59: d2i
    //   60: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: invokestatic 137	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   67: astore 21
    //   69: aload_0
    //   70: getfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   73: ifnull +58 -> 131
    //   76: aload_0
    //   77: getfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   80: aload 21
    //   82: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +46 -> 131
    //   88: aload_0
    //   89: getfield 64	com/baidu/location/b/a:h	D
    //   92: dstore_3
    //   93: aload_0
    //   94: getfield 66	com/baidu/location/b/a:i	D
    //   97: dstore_1
    //   98: dload_3
    //   99: ldc2_w 142
    //   102: dcmpl
    //   103: ifle +471 -> 574
    //   106: aload 20
    //   108: iconst_0
    //   109: ldc2_w 142
    //   112: dastore
    //   113: dload_1
    //   114: ldc2_w 142
    //   117: dcmpl
    //   118: ifle +464 -> 582
    //   121: aload 20
    //   123: iconst_1
    //   124: ldc2_w 142
    //   127: dastore
    //   128: aload 20
    //   130: areturn
    //   131: dload 7
    //   133: dstore 11
    //   135: dload 5
    //   137: dstore 9
    //   139: aload_0
    //   140: getfield 54	com/baidu/location/b/a:e	Landroid/database/sqlite/SQLiteDatabase;
    //   143: new 33	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   150: ldc -111
    //   152: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 21
    //   157: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc -109
    //   162: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aconst_null
    //   169: invokevirtual 153	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   172: astore 18
    //   174: aload 18
    //   176: ifnull +273 -> 449
    //   179: aload 18
    //   181: astore 19
    //   183: dload 7
    //   185: dstore 11
    //   187: dload 5
    //   189: dstore 9
    //   191: aload 18
    //   193: invokeinterface 159 1 0
    //   198: ifeq +251 -> 449
    //   201: aload 18
    //   203: astore 19
    //   205: dload 7
    //   207: dstore 11
    //   209: dload 5
    //   211: dstore 9
    //   213: aload 18
    //   215: iconst_1
    //   216: invokeinterface 163 2 0
    //   221: dstore 7
    //   223: aload 18
    //   225: iconst_2
    //   226: invokeinterface 163 2 0
    //   231: dstore 9
    //   233: aload 18
    //   235: iconst_3
    //   236: invokeinterface 167 2 0
    //   241: istore 13
    //   243: dload 7
    //   245: ldc2_w 142
    //   248: dcmpl
    //   249: ifne +385 -> 634
    //   252: ldc2_w 61
    //   255: dstore 5
    //   257: dload 9
    //   259: dconst_0
    //   260: dcmpg
    //   261: ifgt +366 -> 627
    //   264: ldc2_w 61
    //   267: dstore 7
    //   269: aload 18
    //   271: astore 19
    //   273: dload 7
    //   275: dstore 11
    //   277: dload 5
    //   279: dstore 9
    //   281: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   284: ldc2_w 174
    //   287: ldiv
    //   288: lstore 14
    //   290: iload 13
    //   292: i2l
    //   293: lstore 16
    //   295: aload 18
    //   297: astore 19
    //   299: dload 7
    //   301: dstore 11
    //   303: dload 5
    //   305: dstore 9
    //   307: aload_0
    //   308: getfield 56	com/baidu/location/b/a:f	Z
    //   311: ifne +36 -> 347
    //   314: lload 14
    //   316: lload 16
    //   318: lsub
    //   319: ldc2_w 176
    //   322: lcmp
    //   323: ifle +24 -> 347
    //   326: aload 18
    //   328: astore 19
    //   330: dload 7
    //   332: dstore 11
    //   334: dload 5
    //   336: dstore 9
    //   338: aload_0
    //   339: dload_1
    //   340: dload_3
    //   341: ldc2_w 178
    //   344: invokespecial 180	com/baidu/location/b/a:a	(DDD)V
    //   347: aload 18
    //   349: astore 19
    //   351: dload 7
    //   353: dstore 11
    //   355: dload 5
    //   357: dstore 9
    //   359: aload_0
    //   360: aload 21
    //   362: putfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   365: aload 18
    //   367: astore 19
    //   369: dload 7
    //   371: dstore 11
    //   373: dload 5
    //   375: dstore 9
    //   377: aload_0
    //   378: dload 5
    //   380: putfield 64	com/baidu/location/b/a:h	D
    //   383: aload 18
    //   385: astore 19
    //   387: dload 7
    //   389: dstore 11
    //   391: dload 5
    //   393: dstore 9
    //   395: aload_0
    //   396: dload 7
    //   398: putfield 66	com/baidu/location/b/a:i	D
    //   401: dload 7
    //   403: dstore_1
    //   404: dload 5
    //   406: dstore 7
    //   408: dload_1
    //   409: dstore 5
    //   411: dload 5
    //   413: dstore_1
    //   414: dload 7
    //   416: dstore_3
    //   417: aload 18
    //   419: ifnull -321 -> 98
    //   422: aload 18
    //   424: invokeinterface 183 1 0
    //   429: dload 5
    //   431: dstore_1
    //   432: dload 7
    //   434: dstore_3
    //   435: goto -337 -> 98
    //   438: astore 18
    //   440: dload 5
    //   442: dstore_1
    //   443: dload 7
    //   445: dstore_3
    //   446: goto -348 -> 98
    //   449: aload 18
    //   451: astore 19
    //   453: dload 7
    //   455: dstore 11
    //   457: dload 5
    //   459: dstore 9
    //   461: aload_0
    //   462: getfield 56	com/baidu/location/b/a:f	Z
    //   465: ifne +24 -> 489
    //   468: aload 18
    //   470: astore 19
    //   472: dload 7
    //   474: dstore 11
    //   476: dload 5
    //   478: dstore 9
    //   480: aload_0
    //   481: dload_1
    //   482: dload_3
    //   483: ldc2_w 178
    //   486: invokespecial 180	com/baidu/location/b/a:a	(DDD)V
    //   489: ldc2_w 61
    //   492: dstore 5
    //   494: ldc2_w 61
    //   497: dstore 7
    //   499: goto -88 -> 411
    //   502: astore 18
    //   504: dload 11
    //   506: dstore 5
    //   508: dload 9
    //   510: dstore 7
    //   512: aload 19
    //   514: astore 18
    //   516: dload 5
    //   518: dstore_1
    //   519: dload 7
    //   521: dstore_3
    //   522: aload 18
    //   524: ifnull -426 -> 98
    //   527: aload 18
    //   529: invokeinterface 183 1 0
    //   534: dload 5
    //   536: dstore_1
    //   537: dload 7
    //   539: dstore_3
    //   540: goto -442 -> 98
    //   543: astore 18
    //   545: dload 5
    //   547: dstore_1
    //   548: dload 7
    //   550: dstore_3
    //   551: goto -453 -> 98
    //   554: astore 18
    //   556: aconst_null
    //   557: astore 19
    //   559: aload 19
    //   561: ifnull +10 -> 571
    //   564: aload 19
    //   566: invokeinterface 183 1 0
    //   571: aload 18
    //   573: athrow
    //   574: aload 20
    //   576: iconst_0
    //   577: dload_3
    //   578: dastore
    //   579: goto -466 -> 113
    //   582: aload 20
    //   584: iconst_1
    //   585: dload_1
    //   586: dastore
    //   587: aload 20
    //   589: areturn
    //   590: astore 19
    //   592: goto -21 -> 571
    //   595: astore 20
    //   597: aload 18
    //   599: astore 19
    //   601: aload 20
    //   603: astore 18
    //   605: goto -46 -> 559
    //   608: astore 19
    //   610: ldc2_w 61
    //   613: dstore 5
    //   615: goto -99 -> 516
    //   618: astore 19
    //   620: dload 9
    //   622: dstore 5
    //   624: goto -108 -> 516
    //   627: dload 9
    //   629: dstore 7
    //   631: goto -362 -> 269
    //   634: dload 7
    //   636: dstore 5
    //   638: goto -381 -> 257
    //   641: ldc2_w 61
    //   644: dstore_1
    //   645: ldc2_w 61
    //   648: dstore_3
    //   649: goto -551 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	a
    //   0	652	1	paramDouble1	double
    //   0	652	3	paramDouble2	double
    //   3	634	5	d1	double
    //   8	627	7	d2	double
    //   137	491	9	d3	double
    //   133	372	11	d4	double
    //   241	50	13	j	int
    //   288	27	14	l1	long
    //   293	24	16	l2	long
    //   172	251	18	localCursor	Cursor
    //   438	31	18	localException1	Exception
    //   502	1	18	localException2	Exception
    //   514	14	18	localObject1	Object
    //   543	1	18	localException3	Exception
    //   554	44	18	localObject2	Object
    //   603	1	18	localObject3	Object
    //   23	542	19	localObject4	Object
    //   590	1	19	localException4	Exception
    //   599	1	19	localObject5	Object
    //   608	1	19	localException5	Exception
    //   618	1	19	localException6	Exception
    //   13	575	20	arrayOfDouble	double[]
    //   595	7	20	localObject6	Object
    //   67	294	21	str	String
    // Exception table:
    //   from	to	target	type
    //   422	429	438	java/lang/Exception
    //   139	174	502	java/lang/Exception
    //   191	201	502	java/lang/Exception
    //   213	223	502	java/lang/Exception
    //   281	290	502	java/lang/Exception
    //   307	314	502	java/lang/Exception
    //   338	347	502	java/lang/Exception
    //   359	365	502	java/lang/Exception
    //   377	383	502	java/lang/Exception
    //   395	401	502	java/lang/Exception
    //   461	468	502	java/lang/Exception
    //   480	489	502	java/lang/Exception
    //   527	534	543	java/lang/Exception
    //   139	174	554	finally
    //   564	571	590	java/lang/Exception
    //   191	201	595	finally
    //   213	223	595	finally
    //   223	233	595	finally
    //   233	243	595	finally
    //   281	290	595	finally
    //   307	314	595	finally
    //   338	347	595	finally
    //   359	365	595	finally
    //   377	383	595	finally
    //   395	401	595	finally
    //   461	468	595	finally
    //   480	489	595	finally
    //   223	233	608	java/lang/Exception
    //   233	243	618	java/lang/Exception
  }
  
  /* Error */
  public double b(double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: ldc2_w 61
    //   3: dstore 7
    //   5: aload_0
    //   6: getfield 54	com/baidu/location/b/a:e	Landroid/database/sqlite/SQLiteDatabase;
    //   9: ifnull +368 -> 377
    //   12: getstatic 115	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   15: ldc 117
    //   17: iconst_2
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: ldc2_w 118
    //   26: dload_1
    //   27: dmul
    //   28: invokestatic 125	java/lang/Math:floor	(D)D
    //   31: d2i
    //   32: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc2_w 118
    //   41: dload_3
    //   42: dmul
    //   43: invokestatic 125	java/lang/Math:floor	(D)D
    //   46: d2i
    //   47: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 137	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: astore 17
    //   56: aload_0
    //   57: getfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   60: ifnull +22 -> 82
    //   63: aload_0
    //   64: getfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   67: aload 17
    //   69: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +10 -> 82
    //   75: aload_0
    //   76: getfield 64	com/baidu/location/b/a:h	D
    //   79: dstore_1
    //   80: dload_1
    //   81: dreturn
    //   82: aload_0
    //   83: getfield 54	com/baidu/location/b/a:e	Landroid/database/sqlite/SQLiteDatabase;
    //   86: new 33	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   93: ldc -111
    //   95: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 17
    //   100: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc -109
    //   105: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aconst_null
    //   112: invokevirtual 153	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore 16
    //   117: aload 16
    //   119: ifnull +160 -> 279
    //   122: dload 7
    //   124: dstore 5
    //   126: aload 16
    //   128: invokeinterface 159 1 0
    //   133: ifeq +146 -> 279
    //   136: dload 7
    //   138: dstore 5
    //   140: aload 16
    //   142: iconst_1
    //   143: invokeinterface 163 2 0
    //   148: dstore 9
    //   150: dload 9
    //   152: dstore 5
    //   154: aload 16
    //   156: iconst_3
    //   157: invokeinterface 167 2 0
    //   162: istore 11
    //   164: dload 9
    //   166: dstore 7
    //   168: dload 9
    //   170: ldc2_w 142
    //   173: dcmpl
    //   174: ifne +8 -> 182
    //   177: ldc2_w 61
    //   180: dstore 7
    //   182: dload 7
    //   184: dstore 5
    //   186: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   189: ldc2_w 174
    //   192: ldiv
    //   193: lstore 12
    //   195: iload 11
    //   197: i2l
    //   198: lstore 14
    //   200: dload 7
    //   202: dstore 5
    //   204: aload_0
    //   205: getfield 56	com/baidu/location/b/a:f	Z
    //   208: ifne +28 -> 236
    //   211: lload 12
    //   213: lload 14
    //   215: lsub
    //   216: ldc2_w 176
    //   219: lcmp
    //   220: ifle +16 -> 236
    //   223: dload 7
    //   225: dstore 5
    //   227: aload_0
    //   228: dload_1
    //   229: dload_3
    //   230: ldc2_w 178
    //   233: invokespecial 180	com/baidu/location/b/a:a	(DDD)V
    //   236: dload 7
    //   238: dstore 5
    //   240: aload_0
    //   241: aload 17
    //   243: putfield 60	com/baidu/location/b/a:g	Ljava/lang/String;
    //   246: dload 7
    //   248: dstore 5
    //   250: aload_0
    //   251: dload 7
    //   253: putfield 64	com/baidu/location/b/a:h	D
    //   256: dload 7
    //   258: dstore_3
    //   259: dload_3
    //   260: dstore_1
    //   261: aload 16
    //   263: ifnull -183 -> 80
    //   266: aload 16
    //   268: invokeinterface 183 1 0
    //   273: dload_3
    //   274: dreturn
    //   275: astore 16
    //   277: dload_3
    //   278: dreturn
    //   279: dload 7
    //   281: dstore 5
    //   283: aload_0
    //   284: getfield 56	com/baidu/location/b/a:f	Z
    //   287: ifne +16 -> 303
    //   290: dload 7
    //   292: dstore 5
    //   294: aload_0
    //   295: dload_1
    //   296: dload_3
    //   297: ldc2_w 178
    //   300: invokespecial 180	com/baidu/location/b/a:a	(DDD)V
    //   303: ldc2_w 61
    //   306: dstore_3
    //   307: goto -48 -> 259
    //   310: astore 16
    //   312: aconst_null
    //   313: astore 16
    //   315: ldc2_w 61
    //   318: dstore_3
    //   319: dload_3
    //   320: dstore_1
    //   321: aload 16
    //   323: ifnull -243 -> 80
    //   326: aload 16
    //   328: invokeinterface 183 1 0
    //   333: dload_3
    //   334: dreturn
    //   335: astore 16
    //   337: dload_3
    //   338: dreturn
    //   339: astore 17
    //   341: aconst_null
    //   342: astore 16
    //   344: aload 16
    //   346: ifnull +10 -> 356
    //   349: aload 16
    //   351: invokeinterface 183 1 0
    //   356: aload 17
    //   358: athrow
    //   359: astore 16
    //   361: goto -5 -> 356
    //   364: astore 17
    //   366: goto -22 -> 344
    //   369: astore 17
    //   371: dload 5
    //   373: dstore_3
    //   374: goto -55 -> 319
    //   377: ldc2_w 61
    //   380: dreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	a
    //   0	381	1	paramDouble1	double
    //   0	381	3	paramDouble2	double
    //   124	248	5	d1	double
    //   3	288	7	d2	double
    //   148	21	9	d3	double
    //   162	34	11	j	int
    //   193	19	12	l1	long
    //   198	16	14	l2	long
    //   115	152	16	localCursor	Cursor
    //   275	1	16	localException1	Exception
    //   310	1	16	localException2	Exception
    //   313	14	16	localObject1	Object
    //   335	1	16	localException3	Exception
    //   342	8	16	localObject2	Object
    //   359	1	16	localException4	Exception
    //   54	188	17	str	String
    //   339	18	17	localObject3	Object
    //   364	1	17	localObject4	Object
    //   369	1	17	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   266	273	275	java/lang/Exception
    //   82	117	310	java/lang/Exception
    //   326	333	335	java/lang/Exception
    //   82	117	339	finally
    //   349	356	359	java/lang/Exception
    //   126	136	364	finally
    //   140	150	364	finally
    //   154	164	364	finally
    //   186	195	364	finally
    //   204	211	364	finally
    //   227	236	364	finally
    //   240	246	364	finally
    //   250	256	364	finally
    //   283	290	364	finally
    //   294	303	364	finally
    //   126	136	369	java/lang/Exception
    //   140	150	369	java/lang/Exception
    //   154	164	369	java/lang/Exception
    //   186	195	369	java/lang/Exception
    //   204	211	369	java/lang/Exception
    //   227	236	369	java/lang/Exception
    //   240	246	369	java/lang/Exception
    //   250	256	369	java/lang/Exception
    //   283	290	369	java/lang/Exception
    //   294	303	369	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      Object localObject = new File(d);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        this.e = SQLiteDatabase.openOrCreateDatabase((File)localObject, null);
        localObject = this.e.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
        if (((Cursor)localObject).moveToFirst())
        {
          if (((Cursor)localObject).getInt(0) != 0) {
            break label93;
          }
          this.e.execSQL("CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
        }
        for (;;)
        {
          this.e.setVersion(1);
          ((Cursor)localObject).close();
          return;
          label93:
          this.e.execSQL("DROP TABLE galdata");
          this.e.execSQL("CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      this.e = null;
    }
  }
  
  public void c()
  {
    if (this.e != null) {}
    try
    {
      this.e.close();
      this.e = null;
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.e = null;
      return;
    }
    finally
    {
      localObject = finally;
      this.e = null;
      throw ((Throwable)localObject);
    }
  }
  
  class a
    extends e
  {
    int a;
    int b;
    int c;
    int d;
    double e;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = "http://loc.map.baidu.com/gpsz";
      String str = String.format(Locale.CHINESE, "&x=%d&y=%d&sdk=%f", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Double.valueOf(this.e) });
      this.k.put("gpsz", Jni.encode(str));
    }
    
    public void a(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      double[] arrayOfDouble = Jni.coorEncrypt(paramDouble1, paramDouble2, "gcj2wgs");
      this.a = ((int)Math.floor(arrayOfDouble[0] * 100.0D));
      this.b = ((int)Math.floor(arrayOfDouble[1] * 100.0D));
      this.c = ((int)Math.floor(paramDouble1 * 100.0D));
      this.d = ((int)Math.floor(paramDouble2 * 100.0D));
      this.e = paramDouble3;
      a.a(a.this, true);
      i();
    }
    
    /* Error */
    public void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_1
      //   1: ifeq +368 -> 369
      //   4: aload_0
      //   5: getfield 114	com/baidu/location/b/a$a:j	Ljava/lang/String;
      //   8: ifnull +361 -> 369
      //   11: new 116	org/json/JSONObject
      //   14: dup
      //   15: aload_0
      //   16: getfield 114	com/baidu/location/b/a$a:j	Ljava/lang/String;
      //   19: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   22: astore 9
      //   24: aload 9
      //   26: ifnull +343 -> 369
      //   29: aload 9
      //   31: ldc 121
      //   33: invokevirtual 125	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   36: ifeq +333 -> 369
      //   39: aload 9
      //   41: ldc 121
      //   43: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   46: astore 9
      //   48: aload 9
      //   50: ldc -126
      //   52: invokevirtual 134	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   55: ifeq +314 -> 369
      //   58: aload 9
      //   60: invokevirtual 138	java/lang/String:trim	()Ljava/lang/String;
      //   63: ldc -126
      //   65: invokevirtual 142	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   68: astore 9
      //   70: aload 9
      //   72: arraylength
      //   73: istore_2
      //   74: iload_2
      //   75: i2d
      //   76: invokestatic 145	java/lang/Math:sqrt	(D)D
      //   79: d2i
      //   80: istore 4
      //   82: iload 4
      //   84: iload 4
      //   86: imul
      //   87: iload_2
      //   88: if_icmpne +281 -> 369
      //   91: aload_0
      //   92: getfield 100	com/baidu/location/b/a$a:c	I
      //   95: istore 5
      //   97: iload 4
      //   99: iconst_1
      //   100: isub
      //   101: iconst_2
      //   102: idiv
      //   103: istore 6
      //   105: aload_0
      //   106: getfield 102	com/baidu/location/b/a$a:d	I
      //   109: istore 7
      //   111: iload 4
      //   113: iconst_1
      //   114: isub
      //   115: iconst_2
      //   116: idiv
      //   117: istore 8
      //   119: iconst_0
      //   120: istore_2
      //   121: goto +366 -> 487
      //   124: iload_3
      //   125: iload 4
      //   127: if_icmpge +348 -> 475
      //   130: new 147	android/content/ContentValues
      //   133: dup
      //   134: invokespecial 148	android/content/ContentValues:<init>	()V
      //   137: astore 10
      //   139: aload 9
      //   141: iload_2
      //   142: iload 4
      //   144: imul
      //   145: iload_3
      //   146: iadd
      //   147: aaload
      //   148: ldc -106
      //   150: invokevirtual 134	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   153: ifeq +162 -> 315
      //   156: aload 10
      //   158: ldc -104
      //   160: ldc2_w 153
      //   163: invokestatic 63	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   166: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   169: aload 10
      //   171: ldc -97
      //   173: ldc2_w 153
      //   176: invokestatic 63	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   179: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   182: aload 10
      //   184: ldc -95
      //   186: invokestatic 167	java/lang/System:currentTimeMillis	()J
      //   189: ldc2_w 168
      //   192: ldiv
      //   193: l2i
      //   194: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   197: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   200: getstatic 42	java/util/Locale:CHINESE	Ljava/util/Locale;
      //   203: ldc -82
      //   205: iconst_2
      //   206: anewarray 46	java/lang/Object
      //   209: dup
      //   210: iconst_0
      //   211: iload 5
      //   213: iload 6
      //   215: isub
      //   216: iload_3
      //   217: iadd
      //   218: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   221: aastore
      //   222: dup
      //   223: iconst_1
      //   224: iload 7
      //   226: iload 8
      //   228: isub
      //   229: iload_2
      //   230: iadd
      //   231: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   234: aastore
      //   235: invokestatic 69	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   238: astore 11
      //   240: aload_0
      //   241: getfield 19	com/baidu/location/b/a$a:f	Lcom/baidu/location/b/a;
      //   244: invokestatic 177	com/baidu/location/b/a:a	(Lcom/baidu/location/b/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   247: ldc -77
      //   249: aload 10
      //   251: new 181	java/lang/StringBuilder
      //   254: dup
      //   255: invokespecial 182	java/lang/StringBuilder:<init>	()V
      //   258: ldc -72
      //   260: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: aload 11
      //   265: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: ldc -66
      //   270: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   273: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   276: aconst_null
      //   277: invokevirtual 199	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   280: ifgt +28 -> 308
      //   283: aload 10
      //   285: ldc -55
      //   287: aload 11
      //   289: invokevirtual 204	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   292: aload_0
      //   293: getfield 19	com/baidu/location/b/a$a:f	Lcom/baidu/location/b/a;
      //   296: invokestatic 177	com/baidu/location/b/a:a	(Lcom/baidu/location/b/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   299: ldc -77
      //   301: aconst_null
      //   302: aload 10
      //   304: invokevirtual 208	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   307: pop2
      //   308: iload_3
      //   309: iconst_1
      //   310: iadd
      //   311: istore_3
      //   312: goto -188 -> 124
      //   315: aload 9
      //   317: iload_2
      //   318: iload 4
      //   320: imul
      //   321: iload_3
      //   322: iadd
      //   323: aaload
      //   324: ldc -46
      //   326: invokevirtual 134	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   329: ifne +66 -> 395
      //   332: aload 10
      //   334: ldc -104
      //   336: aload 9
      //   338: iload_2
      //   339: iload 4
      //   341: imul
      //   342: iload_3
      //   343: iadd
      //   344: aaload
      //   345: invokestatic 213	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
      //   348: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   351: aload 10
      //   353: ldc -97
      //   355: ldc2_w 153
      //   358: invokestatic 63	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   361: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   364: goto -182 -> 182
      //   367: astore 9
      //   369: aload_0
      //   370: getfield 29	com/baidu/location/b/a$a:k	Ljava/util/Map;
      //   373: ifnull +12 -> 385
      //   376: aload_0
      //   377: getfield 29	com/baidu/location/b/a$a:k	Ljava/util/Map;
      //   380: invokeinterface 216 1 0
      //   385: aload_0
      //   386: getfield 19	com/baidu/location/b/a$a:f	Lcom/baidu/location/b/a;
      //   389: iconst_0
      //   390: invokestatic 105	com/baidu/location/b/a:a	(Lcom/baidu/location/b/a;Z)Z
      //   393: pop
      //   394: return
      //   395: aload 9
      //   397: iload_2
      //   398: iload 4
      //   400: imul
      //   401: iload_3
      //   402: iadd
      //   403: aaload
      //   404: ldc -46
      //   406: invokevirtual 142	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   409: astore 11
      //   411: aload 11
      //   413: arraylength
      //   414: iconst_2
      //   415: if_icmpne +31 -> 446
      //   418: aload 10
      //   420: ldc -104
      //   422: aload 11
      //   424: iconst_0
      //   425: aaload
      //   426: invokestatic 213	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
      //   429: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   432: aload 10
      //   434: ldc -97
      //   436: aload 11
      //   438: iconst_1
      //   439: aaload
      //   440: invokevirtual 204	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   443: goto -261 -> 182
      //   446: aload 10
      //   448: ldc -104
      //   450: ldc2_w 153
      //   453: invokestatic 63	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   456: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   459: aload 10
      //   461: ldc -97
      //   463: ldc2_w 153
      //   466: invokestatic 63	java/lang/Double:valueOf	(D)Ljava/lang/Double;
      //   469: invokevirtual 157	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
      //   472: goto -290 -> 182
      //   475: iload_2
      //   476: iconst_1
      //   477: iadd
      //   478: istore_2
      //   479: goto +8 -> 487
      //   482: astore 10
      //   484: goto -176 -> 308
      //   487: iload_2
      //   488: iload 4
      //   490: if_icmpge -121 -> 369
      //   493: iconst_0
      //   494: istore_3
      //   495: goto -371 -> 124
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	498	0	this	a
      //   0	498	1	paramBoolean	boolean
      //   73	418	2	i	int
      //   124	371	3	j	int
      //   80	411	4	k	int
      //   95	121	5	m	int
      //   103	113	6	n	int
      //   109	120	7	i1	int
      //   117	112	8	i2	int
      //   22	315	9	localObject1	Object
      //   367	29	9	localException1	Exception
      //   137	323	10	localContentValues	android.content.ContentValues
      //   482	1	10	localException2	Exception
      //   238	199	11	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   11	24	367	java/lang/Exception
      //   29	82	367	java/lang/Exception
      //   91	119	367	java/lang/Exception
      //   130	182	367	java/lang/Exception
      //   182	240	367	java/lang/Exception
      //   315	364	367	java/lang/Exception
      //   395	443	367	java/lang/Exception
      //   446	472	367	java/lang/Exception
      //   240	308	482	java/lang/Exception
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */