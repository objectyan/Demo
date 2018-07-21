package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.d.g;
import com.baidu.location.e.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static Object i = new Object();
  private static b j = null;
  ConcurrentHashMap<String, c> a;
  ConcurrentHashMap<String, c> b;
  ConcurrentHashMap<String, c> c;
  ConcurrentHashMap<String, c> d;
  d e;
  f f;
  e g;
  private String h;
  private final SQLiteDatabase k;
  private String l;
  private int m;
  private Handler n;
  private boolean o;
  private b p;
  private BDLocation q;
  
  /* Error */
  public b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: invokespecial 60	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: ldc 69
    //   10: putfield 71	com/baidu/location/c/b:h	Ljava/lang/String;
    //   13: aload_0
    //   14: new 73	java/util/concurrent/ConcurrentHashMap
    //   17: dup
    //   18: invokespecial 74	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   21: putfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_0
    //   25: new 73	java/util/concurrent/ConcurrentHashMap
    //   28: dup
    //   29: invokespecial 74	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   32: putfield 78	com/baidu/location/c/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_0
    //   36: new 73	java/util/concurrent/ConcurrentHashMap
    //   39: dup
    //   40: invokespecial 74	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   43: putfield 80	com/baidu/location/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: aload_0
    //   47: new 73	java/util/concurrent/ConcurrentHashMap
    //   50: dup
    //   51: invokespecial 74	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   54: putfield 82	com/baidu/location/c/b:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   57: aload_0
    //   58: new 23	com/baidu/location/c/b$d
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 85	com/baidu/location/c/b$d:<init>	(Lcom/baidu/location/c/b;)V
    //   66: putfield 87	com/baidu/location/c/b:e	Lcom/baidu/location/c/b$d;
    //   69: aload_0
    //   70: new 29	com/baidu/location/c/b$f
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 88	com/baidu/location/c/b$f:<init>	(Lcom/baidu/location/c/b;)V
    //   78: putfield 90	com/baidu/location/c/b:f	Lcom/baidu/location/c/b$f;
    //   81: aload_0
    //   82: new 26	com/baidu/location/c/b$e
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 91	com/baidu/location/c/b$e:<init>	(Lcom/baidu/location/c/b;)V
    //   90: putfield 93	com/baidu/location/c/b:g	Lcom/baidu/location/c/b$e;
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 95	com/baidu/location/c/b:l	Ljava/lang/String;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 97	com/baidu/location/c/b:m	I
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 99	com/baidu/location/c/b:n	Landroid/os/Handler;
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 101	com/baidu/location/c/b:o	Z
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 103	com/baidu/location/c/b:p	Lcom/baidu/location/c/b$b;
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 105	com/baidu/location/c/b:q	Lcom/baidu/location/BDLocation;
    //   123: new 107	java/io/File
    //   126: dup
    //   127: invokestatic 113	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   130: invokevirtual 119	android/content/Context:getFilesDir	()Ljava/io/File;
    //   133: ldc 121
    //   135: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   138: astore 10
    //   140: aload 10
    //   142: astore 8
    //   144: aload 10
    //   146: invokevirtual 128	java/io/File:exists	()Z
    //   149: ifne +13 -> 162
    //   152: aload 10
    //   154: invokevirtual 131	java/io/File:mkdir	()Z
    //   157: pop
    //   158: aload 10
    //   160: astore 8
    //   162: new 107	java/io/File
    //   165: dup
    //   166: aload 8
    //   168: ldc -123
    //   170: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   173: astore 8
    //   175: aload 8
    //   177: invokevirtual 128	java/io/File:exists	()Z
    //   180: ifne +9 -> 189
    //   183: aload 8
    //   185: invokevirtual 136	java/io/File:createNewFile	()Z
    //   188: pop
    //   189: aload 8
    //   191: aconst_null
    //   192: invokestatic 142	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   195: astore 8
    //   197: aload_0
    //   198: aload 8
    //   200: putfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   203: aload_0
    //   204: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   207: ifnull +39 -> 246
    //   210: aload_0
    //   211: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   214: ldc -110
    //   216: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   223: ldc -104
    //   225: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   228: aload_0
    //   229: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   232: ldc -102
    //   234: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   237: aload_0
    //   238: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   241: ldc -100
    //   243: invokevirtual 150	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   246: iconst_4
    //   247: anewarray 158	java/lang/String
    //   250: astore 10
    //   252: aload 10
    //   254: iconst_0
    //   255: ldc -96
    //   257: aastore
    //   258: aload 10
    //   260: iconst_1
    //   261: ldc -94
    //   263: aastore
    //   264: aload 10
    //   266: iconst_2
    //   267: ldc -92
    //   269: aastore
    //   270: aload 10
    //   272: iconst_3
    //   273: ldc -90
    //   275: aastore
    //   276: aload 10
    //   278: arraylength
    //   279: istore_2
    //   280: iconst_0
    //   281: istore_1
    //   282: aload 9
    //   284: astore 8
    //   286: iload_1
    //   287: iload_2
    //   288: if_icmpge +444 -> 732
    //   291: aload 10
    //   293: iload_1
    //   294: aaload
    //   295: astore 11
    //   297: aload_0
    //   298: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   301: ifnull +485 -> 786
    //   304: aload_0
    //   305: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   308: aload 11
    //   310: aconst_null
    //   311: invokevirtual 170	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   314: astore 9
    //   316: aload 9
    //   318: astore 8
    //   320: aload 8
    //   322: ifnull +349 -> 671
    //   325: aload 8
    //   327: invokeinterface 175 1 0
    //   332: ifeq +339 -> 671
    //   335: aload 8
    //   337: invokeinterface 178 1 0
    //   342: ifne +329 -> 671
    //   345: aload 8
    //   347: aload 8
    //   349: ldc -76
    //   351: invokeinterface 184 2 0
    //   356: invokeinterface 188 2 0
    //   361: astore 9
    //   363: aload 8
    //   365: aload 8
    //   367: ldc -66
    //   369: invokeinterface 184 2 0
    //   374: invokeinterface 194 2 0
    //   379: istore_3
    //   380: aload 8
    //   382: aload 8
    //   384: ldc -60
    //   386: invokeinterface 184 2 0
    //   391: invokeinterface 194 2 0
    //   396: istore 4
    //   398: aload 8
    //   400: aload 8
    //   402: ldc -58
    //   404: invokeinterface 184 2 0
    //   409: invokeinterface 194 2 0
    //   414: istore 5
    //   416: aload 8
    //   418: aload 8
    //   420: ldc -57
    //   422: invokeinterface 184 2 0
    //   427: invokeinterface 194 2 0
    //   432: istore 6
    //   434: aload 8
    //   436: aload 8
    //   438: ldc -55
    //   440: invokeinterface 184 2 0
    //   445: invokeinterface 194 2 0
    //   450: istore 7
    //   452: new 20	com/baidu/location/c/b$c
    //   455: dup
    //   456: aload_0
    //   457: aload 9
    //   459: iload_3
    //   460: iload 4
    //   462: iload 5
    //   464: iload 6
    //   466: iload 7
    //   468: aload 8
    //   470: aload 8
    //   472: ldc -54
    //   474: invokeinterface 184 2 0
    //   479: invokeinterface 194 2 0
    //   484: invokespecial 205	com/baidu/location/c/b$c:<init>	(Lcom/baidu/location/c/b;Ljava/lang/String;IIIIII)V
    //   487: astore 12
    //   489: aload 11
    //   491: ldc -96
    //   493: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +72 -> 568
    //   499: aload_0
    //   500: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   503: aload 9
    //   505: aload 12
    //   507: invokevirtual 213	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: aload 8
    //   513: invokeinterface 216 1 0
    //   518: pop
    //   519: goto -184 -> 335
    //   522: astore 9
    //   524: aload 9
    //   526: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   529: aload 8
    //   531: astore 9
    //   533: aload 8
    //   535: ifnull +14 -> 549
    //   538: aload 8
    //   540: invokeinterface 222 1 0
    //   545: aload 8
    //   547: astore 9
    //   549: iload_1
    //   550: iconst_1
    //   551: iadd
    //   552: istore_1
    //   553: aload 9
    //   555: astore 8
    //   557: goto -271 -> 286
    //   560: astore 8
    //   562: aconst_null
    //   563: astore 8
    //   565: goto -368 -> 197
    //   568: aload 11
    //   570: ldc -94
    //   572: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   575: ifeq +43 -> 618
    //   578: aload_0
    //   579: getfield 78	com/baidu/location/c/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   582: aload 9
    //   584: aload 12
    //   586: invokevirtual 213	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   589: pop
    //   590: goto -79 -> 511
    //   593: astore 10
    //   595: aload 8
    //   597: astore 9
    //   599: aload 10
    //   601: astore 8
    //   603: aload 9
    //   605: ifnull +10 -> 615
    //   608: aload 9
    //   610: invokeinterface 222 1 0
    //   615: aload 8
    //   617: athrow
    //   618: aload 11
    //   620: ldc -92
    //   622: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifeq +18 -> 643
    //   628: aload_0
    //   629: getfield 80	com/baidu/location/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   632: aload 9
    //   634: aload 12
    //   636: invokevirtual 213	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: pop
    //   640: goto -129 -> 511
    //   643: aload_0
    //   644: getfield 82	com/baidu/location/c/b:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   647: aload 9
    //   649: aload 12
    //   651: invokevirtual 213	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: aload_0
    //   656: getfield 97	com/baidu/location/c/b:m	I
    //   659: ifne -148 -> 511
    //   662: aload_0
    //   663: iload 7
    //   665: putfield 97	com/baidu/location/c/b:m	I
    //   668: goto -157 -> 511
    //   671: aload 8
    //   673: astore 9
    //   675: aload 8
    //   677: ifnull -128 -> 549
    //   680: aload 8
    //   682: invokeinterface 222 1 0
    //   687: aload 8
    //   689: astore 9
    //   691: goto -142 -> 549
    //   694: astore 9
    //   696: aload 9
    //   698: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   701: aload 8
    //   703: astore 9
    //   705: goto -156 -> 549
    //   708: astore 9
    //   710: aload 9
    //   712: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   715: aload 8
    //   717: astore 9
    //   719: goto -170 -> 549
    //   722: astore 9
    //   724: aload 9
    //   726: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   729: goto -114 -> 615
    //   732: return
    //   733: astore 10
    //   735: aload 8
    //   737: astore 9
    //   739: aload 10
    //   741: astore 8
    //   743: goto -140 -> 603
    //   746: astore 10
    //   748: aload 8
    //   750: astore 9
    //   752: aload 10
    //   754: astore 8
    //   756: goto -153 -> 603
    //   759: astore 9
    //   761: goto -237 -> 524
    //   764: astore 8
    //   766: goto -520 -> 246
    //   769: astore 8
    //   771: aconst_null
    //   772: astore 8
    //   774: goto -612 -> 162
    //   777: astore 8
    //   779: aload 10
    //   781: astore 8
    //   783: goto -621 -> 162
    //   786: goto -115 -> 671
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	b
    //   281	272	1	i1	int
    //   279	10	2	i2	int
    //   379	81	3	i3	int
    //   396	65	4	i4	int
    //   414	49	5	i5	int
    //   432	33	6	i6	int
    //   450	214	7	i7	int
    //   142	414	8	localObject1	Object
    //   560	1	8	localException1	Exception
    //   563	192	8	localObject2	Object
    //   764	1	8	localException2	Exception
    //   769	1	8	localException3	Exception
    //   772	1	8	localObject3	Object
    //   777	1	8	localException4	Exception
    //   781	1	8	localObject4	Object
    //   1	503	9	localObject5	Object
    //   522	3	9	localException5	Exception
    //   531	159	9	localObject6	Object
    //   694	3	9	localException6	Exception
    //   703	1	9	localObject7	Object
    //   708	3	9	localException7	Exception
    //   717	1	9	localObject8	Object
    //   722	3	9	localException8	Exception
    //   737	14	9	localObject9	Object
    //   759	1	9	localException9	Exception
    //   138	154	10	localObject10	Object
    //   593	7	10	localObject11	Object
    //   733	7	10	localObject12	Object
    //   746	34	10	localObject13	Object
    //   295	324	11	str	String
    //   487	163	12	localc	c
    // Exception table:
    //   from	to	target	type
    //   325	335	522	java/lang/Exception
    //   335	511	522	java/lang/Exception
    //   511	519	522	java/lang/Exception
    //   568	590	522	java/lang/Exception
    //   618	640	522	java/lang/Exception
    //   643	668	522	java/lang/Exception
    //   162	189	560	java/lang/Exception
    //   189	197	560	java/lang/Exception
    //   325	335	593	finally
    //   335	511	593	finally
    //   511	519	593	finally
    //   568	590	593	finally
    //   618	640	593	finally
    //   643	668	593	finally
    //   680	687	694	java/lang/Exception
    //   538	545	708	java/lang/Exception
    //   608	615	722	java/lang/Exception
    //   524	529	733	finally
    //   297	316	746	finally
    //   297	316	759	java/lang/Exception
    //   210	246	764	java/lang/Exception
    //   123	140	769	java/lang/Exception
    //   144	158	777	java/lang/Exception
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d2 = Math.toRadians(paramDouble1);
    Math.toRadians(paramDouble2);
    double d1 = Math.toRadians(paramDouble3);
    Math.toRadians(paramDouble4);
    paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
    paramDouble3 = Math.toRadians(paramDouble3 - paramDouble1);
    paramDouble1 = Math.sin(paramDouble3 / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    paramDouble4 = Math.cos(d2);
    d1 = Math.cos(d1);
    d2 = Math.sin(paramDouble2 / 2.0D);
    paramDouble1 = Math.sin(paramDouble2 / 2.0D) * (paramDouble4 * d1 * d2) + paramDouble3 * paramDouble1;
    return Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * 6378137.0D;
  }
  
  private int a(ArrayList<a> paramArrayList, double paramDouble)
  {
    int i3;
    if (paramArrayList.size() == 0)
    {
      i3 = 0;
      return i3;
    }
    int i1 = 0;
    label16:
    double d1;
    int i2;
    if (paramArrayList.size() >= 3)
    {
      double d2 = 0.0D;
      d1 = 0.0D;
      i2 = 0;
      while (i2 < paramArrayList.size())
      {
        d2 += ((a)paramArrayList.get(i2)).a;
        d1 += ((a)paramArrayList.get(i2)).b;
        i2 += 1;
      }
      double d3 = d2 / paramArrayList.size();
      double d4 = d1 / paramArrayList.size();
      i2 = 0;
      i3 = -1;
      d1 = -1.0D;
      label116:
      if (i2 < paramArrayList.size())
      {
        d2 = a(d4, d3, ((a)paramArrayList.get(i2)).b, ((a)paramArrayList.get(i2)).a);
        if (d2 <= d1) {
          break label240;
        }
        i3 = i2;
        d1 = d2;
      }
    }
    label240:
    for (;;)
    {
      i2 += 1;
      break label116;
      if ((d1 > paramDouble) && (i3 >= 0) && (i3 < paramArrayList.size()))
      {
        paramArrayList.remove(i3);
        i2 = 1;
        i1 += 1;
      }
      for (;;)
      {
        i3 = i1;
        if (i2 != 1) {
          break;
        }
        break label16;
        i2 = 0;
      }
    }
  }
  
  private BDLocation a(Long paramLong, BDLocation paramBDLocation, Location paramLocation)
  {
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.b.values());
    int i1 = ((c)((List)localObject2).get(0)).e;
    Object localObject1 = paramBDLocation;
    int i3;
    if (paramLocation != null)
    {
      i2 = (int)(paramLocation.getLongitude() * 100000.0D) / i1;
      i3 = (int)(paramLocation.getLatitude() * 100000.0D) / i1;
      localObject1 = "CL_" + i2 + "_" + i3;
      if (!this.b.containsKey(localObject1)) {
        return null;
      }
      localObject1 = paramBDLocation;
      if (paramBDLocation == null) {
        localObject1 = new BDLocation();
      }
      ((BDLocation)localObject1).setLatitude(paramLocation.getLatitude());
      ((BDLocation)localObject1).setLongitude(paramLocation.getLongitude());
    }
    if (localObject1 != null) {
      Collections.sort((List)localObject2, new Comparator()
      {
        public int a(b.c paramAnonymousc1, b.c paramAnonymousc2)
        {
          int i = Math.abs(this.a - paramAnonymousc1.a) + Math.abs(this.b - paramAnonymousc1.b);
          int j = Math.abs(this.a - paramAnonymousc2.a) + Math.abs(this.b - paramAnonymousc2.b);
          if (i > j) {
            return 1;
          }
          if (i < j) {
            return -1;
          }
          return paramAnonymousc1.c.compareTo(paramAnonymousc2.c);
        }
      });
    }
    localObject2 = ((List)localObject2).iterator();
    paramLocation = null;
    int i2 = 0;
    i1 = 0;
    double d5 = 0.0D;
    double d1 = 0.0D;
    Object localObject3;
    String str;
    double d3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      str = String.format(Locale.US, "SELECT * FROM %s WHERE id = %d;", new Object[] { ((c)localObject3).c, paramLong });
      paramBDLocation = paramLocation;
      d3 = d5;
      localObject1 = paramLocation;
    }
    for (;;)
    {
      int i6;
      int i5;
      double d6;
      try
      {
        paramLocation = this.k.rawQuery(str, null);
        i4 = i2;
        i3 = i1;
        d2 = d1;
        d4 = d5;
        if (paramLocation != null)
        {
          i4 = i2;
          i3 = i1;
          d2 = d1;
          d4 = d5;
          paramBDLocation = paramLocation;
          d3 = d5;
          localObject1 = paramLocation;
          if (paramLocation.moveToFirst())
          {
            paramBDLocation = paramLocation;
            d3 = d5;
            localObject1 = paramLocation;
            localObject3 = ((c)localObject3).a(paramLocation.getInt(paramLocation.getColumnIndex("x")));
            paramBDLocation = paramLocation;
            d3 = d5;
            localObject1 = paramLocation;
            d4 = ((Location)localObject3).getLongitude();
            paramBDLocation = paramLocation;
            d3 = d4;
            localObject1 = paramLocation;
            d2 = ((Location)localObject3).getLatitude();
            i3 = 500;
            i4 = 1;
          }
        }
        localObject1 = paramLocation;
        i6 = i4;
        i5 = i3;
        d5 = d2;
        d6 = d4;
        if (paramLocation == null) {
          break label680;
        }
      }
      catch (Exception paramLocation)
      {
        int i4;
        double d4;
        localObject1 = paramBDLocation;
        i6 = i2;
        i5 = i1;
        d5 = d1;
        d6 = d3;
        if (paramBDLocation == null) {
          break label680;
        }
        try
        {
          paramBDLocation.close();
          d2 = d3;
          i3 = i1;
          i1 = i2;
          i2 = i3;
        }
        catch (Exception paramLocation)
        {
          paramLocation.printStackTrace();
          d2 = d3;
          i3 = i1;
          i1 = i2;
          i2 = i3;
        }
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((Cursor)localObject1).close();
          throw paramLong;
        }
        catch (Exception paramBDLocation)
        {
          paramBDLocation.printStackTrace();
          continue;
        }
        i3 = i2;
        paramLocation = paramBDLocation;
        i2 = i1;
        i1 = i3;
        d5 = d2;
      }
      try
      {
        paramLocation.close();
        paramBDLocation = paramLocation;
        i1 = i4;
        i2 = i3;
        d1 = d2;
        d2 = d4;
      }
      catch (Exception paramBDLocation)
      {
        paramBDLocation.printStackTrace();
        paramBDLocation = paramLocation;
        i1 = i4;
        i2 = i3;
        d1 = d2;
        d2 = d4;
        continue;
      }
      if (i1 != 0)
      {
        if (i1 != 0)
        {
          paramLong = new BDLocation();
          paramLong.setRadius(i2);
          paramLong.setLatitude(d1);
          paramLong.setLongitude(d2);
          paramLong.setNetworkLocationType("cl");
          paramLong.setLocType(66);
          return paramLong;
        }
      }
      else {
        break;
      }
      return null;
      i3 = i1;
      i1 = i2;
      double d2 = d5;
      i2 = i3;
      continue;
      label680:
      paramBDLocation = (BDLocation)localObject1;
      i1 = i6;
      d2 = d6;
      i2 = i5;
      d1 = d5;
    }
  }
  
  /* Error */
  private BDLocation a(java.util.LinkedHashMap<String, Integer> paramLinkedHashMap, BDLocation paramBDLocation1, BDLocation paramBDLocation2, int paramInt, Location paramLocation)
  {
    // Byte code:
    //   0: new 249	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 273	java/util/ArrayList:<init>	()V
    //   7: astore 39
    //   9: aload 39
    //   11: aload_0
    //   12: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: invokevirtual 277	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   18: invokeinterface 283 2 0
    //   23: pop
    //   24: aload 39
    //   26: iconst_0
    //   27: invokeinterface 284 2 0
    //   32: checkcast 20	com/baidu/location/c/b$c
    //   35: getfield 286	com/baidu/location/c/b$c:e	I
    //   38: istore 31
    //   40: aload_3
    //   41: astore 38
    //   43: aload 5
    //   45: ifnull +117 -> 162
    //   48: aload 5
    //   50: invokevirtual 292	android/location/Location:getLongitude	()D
    //   53: ldc2_w 293
    //   56: dmul
    //   57: d2i
    //   58: iload 31
    //   60: idiv
    //   61: istore 32
    //   63: aload 5
    //   65: invokevirtual 297	android/location/Location:getLatitude	()D
    //   68: ldc2_w 293
    //   71: dmul
    //   72: d2i
    //   73: iload 31
    //   75: idiv
    //   76: istore 33
    //   78: new 299	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 385
    //   88: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload 32
    //   93: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc_w 311
    //   99: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 33
    //   104: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 38
    //   112: aload_0
    //   113: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   116: aload 38
    //   118: invokevirtual 318	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   121: ifne +5 -> 126
    //   124: aconst_null
    //   125: areturn
    //   126: aload_3
    //   127: astore 38
    //   129: aload_3
    //   130: ifnonnull +12 -> 142
    //   133: new 320	com/baidu/location/BDLocation
    //   136: dup
    //   137: invokespecial 321	com/baidu/location/BDLocation:<init>	()V
    //   140: astore 38
    //   142: aload 38
    //   144: aload 5
    //   146: invokevirtual 297	android/location/Location:getLatitude	()D
    //   149: invokevirtual 325	com/baidu/location/BDLocation:setLatitude	(D)V
    //   152: aload 38
    //   154: aload 5
    //   156: invokevirtual 292	android/location/Location:getLongitude	()D
    //   159: invokevirtual 328	com/baidu/location/BDLocation:setLongitude	(D)V
    //   162: aconst_null
    //   163: astore_3
    //   164: new 387	java/util/HashMap
    //   167: dup
    //   168: invokespecial 388	java/util/HashMap:<init>	()V
    //   171: astore 40
    //   173: dconst_0
    //   174: dstore 16
    //   176: dconst_0
    //   177: dstore 14
    //   179: aload_2
    //   180: ifnull +337 -> 517
    //   183: aload_2
    //   184: invokevirtual 330	com/baidu/location/BDLocation:getLatitude	()D
    //   187: dstore 14
    //   189: aload_2
    //   190: invokevirtual 329	com/baidu/location/BDLocation:getLongitude	()D
    //   193: dstore 16
    //   195: ldc2_w 293
    //   198: dload 16
    //   200: dmul
    //   201: d2i
    //   202: iload 31
    //   204: idiv
    //   205: istore 33
    //   207: ldc2_w 293
    //   210: dload 14
    //   212: dmul
    //   213: d2i
    //   214: iload 31
    //   216: idiv
    //   217: istore 34
    //   219: new 299	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 385
    //   229: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 33
    //   234: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc_w 311
    //   240: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload 34
    //   245: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore 5
    //   253: aload_3
    //   254: astore_2
    //   255: aload_0
    //   256: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   259: aload 5
    //   261: invokevirtual 318	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   264: ifeq +140 -> 404
    //   267: new 249	java/util/ArrayList
    //   270: dup
    //   271: invokespecial 273	java/util/ArrayList:<init>	()V
    //   274: astore_3
    //   275: aload_3
    //   276: aload_0
    //   277: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: aload 5
    //   282: invokevirtual 391	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: invokeinterface 394 2 0
    //   290: pop
    //   291: iconst_m1
    //   292: istore 31
    //   294: aload_3
    //   295: astore_2
    //   296: iload 31
    //   298: iconst_1
    //   299: if_icmpgt +105 -> 404
    //   302: iconst_m1
    //   303: istore 32
    //   305: iload 32
    //   307: iconst_1
    //   308: if_icmpgt +87 -> 395
    //   311: iload 31
    //   313: ifne +8 -> 321
    //   316: iload 32
    //   318: ifeq +68 -> 386
    //   321: new 299	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 385
    //   331: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: iload 33
    //   336: iload 31
    //   338: iadd
    //   339: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 311
    //   345: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 34
    //   350: iload 32
    //   352: iadd
    //   353: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: astore_2
    //   360: aload_0
    //   361: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   364: aload_2
    //   365: invokevirtual 318	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   368: ifeq +18 -> 386
    //   371: aload_3
    //   372: aload_0
    //   373: getfield 76	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   376: aload_2
    //   377: invokevirtual 391	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   380: invokeinterface 394 2 0
    //   385: pop
    //   386: iload 32
    //   388: iconst_1
    //   389: iadd
    //   390: istore 32
    //   392: goto -87 -> 305
    //   395: iload 31
    //   397: iconst_1
    //   398: iadd
    //   399: istore 31
    //   401: goto -107 -> 294
    //   404: iconst_1
    //   405: istore 35
    //   407: new 396	java/lang/StringBuffer
    //   410: dup
    //   411: invokespecial 397	java/lang/StringBuffer:<init>	()V
    //   414: astore 38
    //   416: aload_1
    //   417: invokevirtual 403	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   420: invokeinterface 406 1 0
    //   425: astore 39
    //   427: iconst_0
    //   428: istore 32
    //   430: iconst_1
    //   431: istore 31
    //   433: iload 32
    //   435: aload_1
    //   436: invokevirtual 407	java/util/LinkedHashMap:size	()I
    //   439: if_icmpge +181 -> 620
    //   442: aload 39
    //   444: invokeinterface 352 1 0
    //   449: checkcast 409	java/util/Map$Entry
    //   452: astore_3
    //   453: aload_3
    //   454: invokeinterface 412 1 0
    //   459: checkcast 158	java/lang/String
    //   462: astore 41
    //   464: aload_3
    //   465: invokeinterface 415 1 0
    //   470: checkcast 417	java/lang/Integer
    //   473: astore 5
    //   475: aload 5
    //   477: astore_3
    //   478: aload 5
    //   480: invokevirtual 420	java/lang/Integer:intValue	()I
    //   483: ifge +13 -> 496
    //   486: aload 5
    //   488: invokevirtual 420	java/lang/Integer:intValue	()I
    //   491: ineg
    //   492: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: astore_3
    //   496: aload 41
    //   498: invokestatic 430	com/baidu/location/Jni:encode3	(Ljava/lang/String;)Ljava/lang/Long;
    //   501: astore 5
    //   503: aload 5
    //   505: ifnonnull +74 -> 579
    //   508: iload 32
    //   510: iconst_1
    //   511: iadd
    //   512: istore 32
    //   514: goto -81 -> 433
    //   517: aload 38
    //   519: ifnull +51 -> 570
    //   522: aload 39
    //   524: new 12	com/baidu/location/c/b$4
    //   527: dup
    //   528: aload_0
    //   529: aload 38
    //   531: invokevirtual 329	com/baidu/location/BDLocation:getLongitude	()D
    //   534: ldc2_w 293
    //   537: dmul
    //   538: d2i
    //   539: iload 31
    //   541: idiv
    //   542: aload 38
    //   544: invokevirtual 330	com/baidu/location/BDLocation:getLatitude	()D
    //   547: ldc2_w 293
    //   550: dmul
    //   551: d2i
    //   552: iload 31
    //   554: idiv
    //   555: invokespecial 431	com/baidu/location/c/b$4:<init>	(Lcom/baidu/location/c/b;II)V
    //   558: invokestatic 339	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   561: iconst_0
    //   562: istore 35
    //   564: aload 39
    //   566: astore_2
    //   567: goto -160 -> 407
    //   570: iconst_0
    //   571: istore 35
    //   573: aload 39
    //   575: astore_2
    //   576: goto -169 -> 407
    //   579: iload 31
    //   581: ifeq +28 -> 609
    //   584: iconst_0
    //   585: istore 31
    //   587: aload 40
    //   589: aload 5
    //   591: aload_3
    //   592: invokeinterface 434 3 0
    //   597: pop
    //   598: aload 38
    //   600: aload 5
    //   602: invokevirtual 437	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   605: pop
    //   606: goto -98 -> 508
    //   609: aload 38
    //   611: bipush 44
    //   613: invokevirtual 440	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   616: pop
    //   617: goto -30 -> 587
    //   620: aload_2
    //   621: ifnull +1203 -> 1824
    //   624: aload_2
    //   625: invokeinterface 343 1 0
    //   630: astore_3
    //   631: dconst_0
    //   632: dstore 8
    //   634: dconst_0
    //   635: dstore 6
    //   637: iconst_0
    //   638: istore 31
    //   640: iconst_0
    //   641: istore 32
    //   643: aload_3
    //   644: invokeinterface 348 1 0
    //   649: ifeq +1160 -> 1809
    //   652: aload_3
    //   653: invokeinterface 352 1 0
    //   658: checkcast 20	com/baidu/location/c/b$c
    //   661: astore 5
    //   663: getstatic 358	java/util/Locale:US	Ljava/util/Locale;
    //   666: ldc_w 442
    //   669: iconst_2
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: aload 5
    //   677: getfield 362	com/baidu/location/c/b$c:c	Ljava/lang/String;
    //   680: aastore
    //   681: dup
    //   682: iconst_1
    //   683: aload 38
    //   685: aastore
    //   686: invokestatic 366	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   689: astore_2
    //   690: aload_0
    //   691: getfield 144	com/baidu/location/c/b:k	Landroid/database/sqlite/SQLiteDatabase;
    //   694: aload_2
    //   695: aconst_null
    //   696: invokevirtual 170	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   699: astore_2
    //   700: aload_2
    //   701: ifnull +888 -> 1589
    //   704: aload_2
    //   705: invokeinterface 175 1 0
    //   710: ifeq +879 -> 1589
    //   713: new 249	java/util/ArrayList
    //   716: dup
    //   717: invokespecial 273	java/util/ArrayList:<init>	()V
    //   720: astore 39
    //   722: aload_2
    //   723: invokeinterface 178 1 0
    //   728: ifne +319 -> 1047
    //   731: aload_2
    //   732: iconst_0
    //   733: invokeinterface 446 2 0
    //   738: lstore 36
    //   740: aload 5
    //   742: aload_2
    //   743: aload_2
    //   744: ldc -66
    //   746: invokeinterface 184 2 0
    //   751: invokeinterface 194 2 0
    //   756: invokevirtual 369	com/baidu/location/c/b$c:a	(I)Landroid/location/Location;
    //   759: astore 41
    //   761: aload 41
    //   763: invokevirtual 292	android/location/Location:getLongitude	()D
    //   766: dstore 12
    //   768: aload 41
    //   770: invokevirtual 297	android/location/Location:getLatitude	()D
    //   773: dstore 18
    //   775: dload 12
    //   777: dconst_0
    //   778: dcmpg
    //   779: ifle +10 -> 789
    //   782: dload 18
    //   784: dconst_0
    //   785: dcmpg
    //   786: ifgt +92 -> 878
    //   789: aload_2
    //   790: invokeinterface 216 1 0
    //   795: pop
    //   796: goto -74 -> 722
    //   799: astore 5
    //   801: iload 32
    //   803: istore 34
    //   805: dload 8
    //   807: dstore 12
    //   809: dload 6
    //   811: dstore 10
    //   813: iload 31
    //   815: istore 33
    //   817: aload_2
    //   818: ifnull +951 -> 1769
    //   821: aload_2
    //   822: invokeinterface 222 1 0
    //   827: iload 32
    //   829: istore 33
    //   831: dload 8
    //   833: dstore 10
    //   835: dload 6
    //   837: dstore 8
    //   839: dload 10
    //   841: dstore 6
    //   843: iload 31
    //   845: istore 32
    //   847: iload 33
    //   849: istore 31
    //   851: dload 8
    //   853: dstore 10
    //   855: iload 32
    //   857: istore 33
    //   859: iload 31
    //   861: istore 32
    //   863: dload 6
    //   865: dstore 8
    //   867: dload 10
    //   869: dstore 6
    //   871: iload 33
    //   873: istore 31
    //   875: goto -232 -> 643
    //   878: iload 35
    //   880: iconst_1
    //   881: if_icmpne +45 -> 926
    //   884: aload_0
    //   885: dload 14
    //   887: dload 16
    //   889: dload 18
    //   891: dload 12
    //   893: invokespecial 266	com/baidu/location/c/b:a	(DDDD)D
    //   896: ldc2_w 447
    //   899: dcmpl
    //   900: ifle +26 -> 926
    //   903: aload_2
    //   904: invokeinterface 216 1 0
    //   909: pop
    //   910: goto -188 -> 722
    //   913: astore_1
    //   914: aload_2
    //   915: ifnull +9 -> 924
    //   918: aload_2
    //   919: invokeinterface 222 1 0
    //   924: aload_1
    //   925: athrow
    //   926: bipush 100
    //   928: bipush 30
    //   930: aload 40
    //   932: lload 36
    //   934: invokestatic 453	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   937: invokeinterface 454 2 0
    //   942: checkcast 417	java/lang/Integer
    //   945: invokevirtual 420	java/lang/Integer:intValue	()I
    //   948: invokestatic 458	java/lang/Math:max	(II)I
    //   951: invokestatic 461	java/lang/Math:min	(II)I
    //   954: istore 33
    //   956: iload 33
    //   958: bipush 70
    //   960: if_icmple +70 -> 1030
    //   963: dconst_1
    //   964: iload 33
    //   966: bipush 70
    //   968: isub
    //   969: i2d
    //   970: ldc2_w 462
    //   973: ddiv
    //   974: dadd
    //   975: dstore 10
    //   977: aload 39
    //   979: new 14	com/baidu/location/c/b$a
    //   982: dup
    //   983: dload 12
    //   985: dload 18
    //   987: dload 10
    //   989: ldc2_w 464
    //   992: ldc2_w 466
    //   995: invokestatic 469	java/lang/Math:max	(DD)D
    //   998: ldc2_w 470
    //   1001: invokestatic 474	java/lang/Math:pow	(DD)D
    //   1004: ldc2_w 475
    //   1007: dmul
    //   1008: dmul
    //   1009: invokestatic 479	java/lang/Math:exp	(D)D
    //   1012: aconst_null
    //   1013: invokespecial 482	com/baidu/location/c/b$a:<init>	(DDDLcom/baidu/location/c/b$1;)V
    //   1016: invokevirtual 483	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1019: pop
    //   1020: aload_2
    //   1021: invokeinterface 216 1 0
    //   1026: pop
    //   1027: goto -305 -> 722
    //   1030: dconst_1
    //   1031: iload 33
    //   1033: bipush 70
    //   1035: isub
    //   1036: i2d
    //   1037: ldc2_w 464
    //   1040: ddiv
    //   1041: dadd
    //   1042: dstore 10
    //   1044: goto -67 -> 977
    //   1047: aload_0
    //   1048: aload 39
    //   1050: ldc2_w 484
    //   1053: invokespecial 487	com/baidu/location/c/b:a	(Ljava/util/ArrayList;D)I
    //   1056: pop
    //   1057: dconst_0
    //   1058: dstore 18
    //   1060: dconst_0
    //   1061: dstore 10
    //   1063: dconst_0
    //   1064: dstore 12
    //   1066: iconst_0
    //   1067: istore 33
    //   1069: iload 33
    //   1071: aload 39
    //   1073: invokevirtual 253	java/util/ArrayList:size	()I
    //   1076: if_icmpge +113 -> 1189
    //   1079: aload 39
    //   1081: iload 33
    //   1083: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1086: checkcast 14	com/baidu/location/c/b$a
    //   1089: astore 5
    //   1091: aload 5
    //   1093: getfield 489	com/baidu/location/c/b$a:c	D
    //   1096: dconst_0
    //   1097: dcmpg
    //   1098: ifgt +18 -> 1116
    //   1101: dload 10
    //   1103: dstore 20
    //   1105: dload 12
    //   1107: dstore 10
    //   1109: dload 20
    //   1111: dstore 12
    //   1113: goto +726 -> 1839
    //   1116: aload 5
    //   1118: getfield 260	com/baidu/location/c/b$a:a	D
    //   1121: dstore 22
    //   1123: aload 5
    //   1125: getfield 489	com/baidu/location/c/b$a:c	D
    //   1128: dstore 24
    //   1130: aload 5
    //   1132: getfield 262	com/baidu/location/c/b$a:b	D
    //   1135: dstore 20
    //   1137: aload 5
    //   1139: getfield 489	com/baidu/location/c/b$a:c	D
    //   1142: dstore 26
    //   1144: aload 5
    //   1146: getfield 489	com/baidu/location/c/b$a:c	D
    //   1149: dstore 28
    //   1151: dload 28
    //   1153: dload 12
    //   1155: dadd
    //   1156: dstore 12
    //   1158: dload 20
    //   1160: dload 26
    //   1162: dmul
    //   1163: dload 10
    //   1165: dadd
    //   1166: dstore 20
    //   1168: dload 22
    //   1170: dload 24
    //   1172: dmul
    //   1173: dload 18
    //   1175: dadd
    //   1176: dstore 18
    //   1178: dload 12
    //   1180: dstore 10
    //   1182: dload 20
    //   1184: dstore 12
    //   1186: goto +653 -> 1839
    //   1189: dload 12
    //   1191: dconst_0
    //   1192: dcmpl
    //   1193: ifle +601 -> 1794
    //   1196: dload 18
    //   1198: dconst_0
    //   1199: dcmpl
    //   1200: ifle +594 -> 1794
    //   1203: dload 10
    //   1205: dconst_0
    //   1206: dcmpl
    //   1207: ifle +587 -> 1794
    //   1210: dload 18
    //   1212: dload 12
    //   1214: ddiv
    //   1215: dstore 8
    //   1217: dload 10
    //   1219: dload 12
    //   1221: ddiv
    //   1222: dstore 6
    //   1224: fconst_0
    //   1225: fstore 30
    //   1227: iconst_0
    //   1228: istore 32
    //   1230: iload 32
    //   1232: aload 39
    //   1234: invokevirtual 253	java/util/ArrayList:size	()I
    //   1237: if_icmpge +57 -> 1294
    //   1240: fload 30
    //   1242: f2d
    //   1243: dstore 10
    //   1245: aload_0
    //   1246: dload 8
    //   1248: dload 6
    //   1250: aload 39
    //   1252: iload 32
    //   1254: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1257: checkcast 14	com/baidu/location/c/b$a
    //   1260: getfield 260	com/baidu/location/c/b$a:a	D
    //   1263: aload 39
    //   1265: iload 32
    //   1267: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1270: checkcast 14	com/baidu/location/c/b$a
    //   1273: getfield 262	com/baidu/location/c/b$a:b	D
    //   1276: invokespecial 266	com/baidu/location/c/b:a	(DDDD)D
    //   1279: dload 10
    //   1281: dadd
    //   1282: d2f
    //   1283: fstore 30
    //   1285: iload 32
    //   1287: iconst_1
    //   1288: iadd
    //   1289: istore 32
    //   1291: goto -61 -> 1230
    //   1294: fload 30
    //   1296: aload 39
    //   1298: invokevirtual 253	java/util/ArrayList:size	()I
    //   1301: i2f
    //   1302: fdiv
    //   1303: invokestatic 493	java/lang/Math:round	(F)I
    //   1306: istore 32
    //   1308: iload 32
    //   1310: istore 31
    //   1312: iload 31
    //   1314: bipush 30
    //   1316: if_icmpge +232 -> 1548
    //   1319: bipush 30
    //   1321: istore 31
    //   1323: iconst_1
    //   1324: istore 32
    //   1326: iload 32
    //   1328: istore 33
    //   1330: iload 35
    //   1332: ifne +23 -> 1355
    //   1335: iload 32
    //   1337: istore 33
    //   1339: iload 32
    //   1341: istore 34
    //   1343: aload 39
    //   1345: invokevirtual 253	java/util/ArrayList:size	()I
    //   1348: iconst_1
    //   1349: if_icmpgt +6 -> 1355
    //   1352: iconst_0
    //   1353: istore 33
    //   1355: iload 33
    //   1357: istore 32
    //   1359: iload 33
    //   1361: istore 34
    //   1363: aload 39
    //   1365: invokevirtual 253	java/util/ArrayList:size	()I
    //   1368: iload 4
    //   1370: if_icmpge +35 -> 1405
    //   1373: iload 33
    //   1375: istore 32
    //   1377: iload 33
    //   1379: istore 34
    //   1381: dconst_1
    //   1382: aload 39
    //   1384: invokevirtual 253	java/util/ArrayList:size	()I
    //   1387: i2d
    //   1388: dmul
    //   1389: aload_1
    //   1390: invokevirtual 407	java/util/LinkedHashMap:size	()I
    //   1393: i2d
    //   1394: ddiv
    //   1395: ldc2_w 494
    //   1398: dcmpg
    //   1399: ifge +6 -> 1405
    //   1402: iconst_0
    //   1403: istore 32
    //   1405: iload 32
    //   1407: istore 33
    //   1409: iload 35
    //   1411: iconst_1
    //   1412: if_icmpne +47 -> 1459
    //   1415: iload 32
    //   1417: istore 33
    //   1419: iload 32
    //   1421: iconst_1
    //   1422: if_icmpne +37 -> 1459
    //   1425: iload 32
    //   1427: istore 34
    //   1429: aload_0
    //   1430: dload 14
    //   1432: dload 16
    //   1434: dload 6
    //   1436: dload 8
    //   1438: invokespecial 266	com/baidu/location/c/b:a	(DDDD)D
    //   1441: dstore 10
    //   1443: iload 32
    //   1445: istore 33
    //   1447: dload 10
    //   1449: ldc2_w 447
    //   1452: dcmpl
    //   1453: ifle +6 -> 1459
    //   1456: iconst_0
    //   1457: istore 33
    //   1459: dload 6
    //   1461: dstore 10
    //   1463: dload 8
    //   1465: dstore 12
    //   1467: iload 33
    //   1469: istore 32
    //   1471: iload 31
    //   1473: istore 4
    //   1475: aload_2
    //   1476: ifnull +25 -> 1501
    //   1479: aload_2
    //   1480: invokeinterface 222 1 0
    //   1485: iload 31
    //   1487: istore 4
    //   1489: iload 33
    //   1491: istore 32
    //   1493: dload 8
    //   1495: dstore 12
    //   1497: dload 6
    //   1499: dstore 10
    //   1501: iload 32
    //   1503: ifeq +211 -> 1714
    //   1506: new 320	com/baidu/location/BDLocation
    //   1509: dup
    //   1510: invokespecial 321	com/baidu/location/BDLocation:<init>	()V
    //   1513: astore_1
    //   1514: aload_1
    //   1515: iload 4
    //   1517: i2f
    //   1518: invokevirtual 373	com/baidu/location/BDLocation:setRadius	(F)V
    //   1521: aload_1
    //   1522: dload 10
    //   1524: invokevirtual 325	com/baidu/location/BDLocation:setLatitude	(D)V
    //   1527: aload_1
    //   1528: dload 12
    //   1530: invokevirtual 328	com/baidu/location/BDLocation:setLongitude	(D)V
    //   1533: aload_1
    //   1534: ldc_w 497
    //   1537: invokevirtual 378	com/baidu/location/BDLocation:setNetworkLocationType	(Ljava/lang/String;)V
    //   1540: aload_1
    //   1541: bipush 66
    //   1543: invokevirtual 382	com/baidu/location/BDLocation:setLocType	(I)V
    //   1546: aload_1
    //   1547: areturn
    //   1548: bipush 100
    //   1550: iload 31
    //   1552: if_icmpge +236 -> 1788
    //   1555: bipush 100
    //   1557: istore 31
    //   1559: iconst_1
    //   1560: istore 32
    //   1562: goto -236 -> 1326
    //   1565: astore_1
    //   1566: aload_1
    //   1567: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   1570: dload 6
    //   1572: dstore 10
    //   1574: dload 8
    //   1576: dstore 12
    //   1578: iload 33
    //   1580: istore 32
    //   1582: iload 31
    //   1584: istore 4
    //   1586: goto -85 -> 1501
    //   1589: iload 32
    //   1591: istore 34
    //   1593: dload 8
    //   1595: dstore 12
    //   1597: dload 6
    //   1599: dstore 10
    //   1601: iload 31
    //   1603: istore 33
    //   1605: aload_2
    //   1606: ifnull +163 -> 1769
    //   1609: aload_2
    //   1610: invokeinterface 222 1 0
    //   1615: dload 6
    //   1617: dstore 10
    //   1619: iload 31
    //   1621: istore 33
    //   1623: iload 32
    //   1625: istore 31
    //   1627: iload 33
    //   1629: istore 32
    //   1631: dload 8
    //   1633: dstore 6
    //   1635: dload 10
    //   1637: dstore 8
    //   1639: goto -788 -> 851
    //   1642: astore_2
    //   1643: aload_2
    //   1644: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   1647: dload 6
    //   1649: dstore 10
    //   1651: iload 31
    //   1653: istore 33
    //   1655: iload 32
    //   1657: istore 31
    //   1659: iload 33
    //   1661: istore 32
    //   1663: dload 8
    //   1665: dstore 6
    //   1667: dload 10
    //   1669: dstore 8
    //   1671: goto -820 -> 851
    //   1674: astore_2
    //   1675: aload_2
    //   1676: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   1679: dload 6
    //   1681: dstore 10
    //   1683: iload 31
    //   1685: istore 33
    //   1687: iload 32
    //   1689: istore 31
    //   1691: iload 33
    //   1693: istore 32
    //   1695: dload 8
    //   1697: dstore 6
    //   1699: dload 10
    //   1701: dstore 8
    //   1703: goto -852 -> 851
    //   1706: astore_2
    //   1707: aload_2
    //   1708: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   1711: goto -787 -> 924
    //   1714: aconst_null
    //   1715: areturn
    //   1716: astore_1
    //   1717: aconst_null
    //   1718: astore_2
    //   1719: goto -805 -> 914
    //   1722: astore_2
    //   1723: aconst_null
    //   1724: astore_2
    //   1725: goto -924 -> 801
    //   1728: astore 5
    //   1730: dload 8
    //   1732: dstore 10
    //   1734: iconst_1
    //   1735: istore 32
    //   1737: dload 6
    //   1739: dstore 8
    //   1741: dload 10
    //   1743: dstore 6
    //   1745: goto -944 -> 801
    //   1748: astore 5
    //   1750: dload 8
    //   1752: dstore 10
    //   1754: iload 34
    //   1756: istore 32
    //   1758: dload 6
    //   1760: dstore 8
    //   1762: dload 10
    //   1764: dstore 6
    //   1766: goto -965 -> 801
    //   1769: iload 34
    //   1771: istore 31
    //   1773: dload 12
    //   1775: dstore 6
    //   1777: dload 10
    //   1779: dstore 8
    //   1781: iload 33
    //   1783: istore 32
    //   1785: goto -934 -> 851
    //   1788: iconst_1
    //   1789: istore 32
    //   1791: goto -465 -> 1326
    //   1794: dload 6
    //   1796: dstore 10
    //   1798: dload 8
    //   1800: dstore 6
    //   1802: dload 10
    //   1804: dstore 8
    //   1806: goto -480 -> 1326
    //   1809: dload 8
    //   1811: dstore 10
    //   1813: dload 6
    //   1815: dstore 12
    //   1817: iload 31
    //   1819: istore 4
    //   1821: goto -320 -> 1501
    //   1824: dconst_0
    //   1825: dstore 10
    //   1827: iconst_0
    //   1828: istore 4
    //   1830: iconst_0
    //   1831: istore 32
    //   1833: dconst_0
    //   1834: dstore 12
    //   1836: goto -335 -> 1501
    //   1839: iload 33
    //   1841: iconst_1
    //   1842: iadd
    //   1843: istore 33
    //   1845: dload 12
    //   1847: dstore 20
    //   1849: dload 10
    //   1851: dstore 12
    //   1853: dload 20
    //   1855: dstore 10
    //   1857: goto -788 -> 1069
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1860	0	this	b
    //   0	1860	1	paramLinkedHashMap	java.util.LinkedHashMap<String, Integer>
    //   0	1860	2	paramBDLocation1	BDLocation
    //   0	1860	3	paramBDLocation2	BDLocation
    //   0	1860	4	paramInt	int
    //   0	1860	5	paramLocation	Location
    //   635	1179	6	d1	double
    //   632	1178	8	d2	double
    //   811	1045	10	d3	double
    //   766	1086	12	d4	double
    //   177	1254	14	d5	double
    //   174	1259	16	d6	double
    //   773	438	18	d7	double
    //   1103	751	20	d8	double
    //   1121	48	22	d9	double
    //   1128	43	24	d10	double
    //   1142	19	26	d11	double
    //   1149	3	28	d12	double
    //   1225	70	30	f1	float
    //   38	1780	31	i1	int
    //   61	1771	32	i2	int
    //   76	1768	33	i3	int
    //   217	1553	34	i4	int
    //   405	1008	35	i5	int
    //   738	195	36	l1	long
    //   41	643	38	localObject1	Object
    //   7	1376	39	localObject2	Object
    //   171	760	40	localHashMap	HashMap
    //   462	307	41	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   704	722	799	java/lang/Exception
    //   722	775	799	java/lang/Exception
    //   789	796	799	java/lang/Exception
    //   884	910	799	java/lang/Exception
    //   926	956	799	java/lang/Exception
    //   963	977	799	java/lang/Exception
    //   977	1027	799	java/lang/Exception
    //   1030	1044	799	java/lang/Exception
    //   1047	1057	799	java/lang/Exception
    //   1069	1101	799	java/lang/Exception
    //   1116	1151	799	java/lang/Exception
    //   704	722	913	finally
    //   722	775	913	finally
    //   789	796	913	finally
    //   884	910	913	finally
    //   926	956	913	finally
    //   963	977	913	finally
    //   977	1027	913	finally
    //   1030	1044	913	finally
    //   1047	1057	913	finally
    //   1069	1101	913	finally
    //   1116	1151	913	finally
    //   1230	1240	913	finally
    //   1245	1285	913	finally
    //   1294	1308	913	finally
    //   1343	1352	913	finally
    //   1363	1373	913	finally
    //   1381	1402	913	finally
    //   1429	1443	913	finally
    //   1479	1485	1565	java/lang/Exception
    //   1609	1615	1642	java/lang/Exception
    //   821	827	1674	java/lang/Exception
    //   918	924	1706	java/lang/Exception
    //   690	700	1716	finally
    //   690	700	1722	java/lang/Exception
    //   1230	1240	1728	java/lang/Exception
    //   1245	1285	1728	java/lang/Exception
    //   1294	1308	1728	java/lang/Exception
    //   1343	1352	1748	java/lang/Exception
    //   1363	1373	1748	java/lang/Exception
    //   1381	1402	1748	java/lang/Exception
    //   1429	1443	1748	java/lang/Exception
  }
  
  public static b a()
  {
    synchronized (i)
    {
      if (j == null) {
        j = new b();
      }
      b localb = j;
      return localb;
    }
  }
  
  private String a(com.baidu.location.f.a parama, com.baidu.location.f.e parame, BDLocation paramBDLocation1, BDLocation paramBDLocation2, BDLocation paramBDLocation3)
  {
    int i1;
    StringBuffer localStringBuffer;
    if ((paramBDLocation1 == null) && (paramBDLocation2 == null))
    {
      i1 = 0;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("&uptype=oflv2");
      if ((parama != null) && (parama.e())) {
        localStringBuffer.append(parama.i());
      }
      if ((parame != null) && (parame.a() > 0)) {
        localStringBuffer.append(parame.c());
      }
      if ((paramBDLocation1 != null) && (paramBDLocation1.getLocType() == 66)) {
        break label239;
      }
      localStringBuffer.append("&ofcl=0");
      label94:
      if ((paramBDLocation2 != null) && (paramBDLocation2.getLocType() == 66)) {
        break label292;
      }
      localStringBuffer.append("&ofwf=0");
      label118:
      if ((paramBDLocation3 != null) && (paramBDLocation3.getLocType() == 66)) {
        break label348;
      }
      localStringBuffer.append(String.format(Locale.CHINA, "&ofl=%s|%d", new Object[] { "1", Integer.valueOf(i1) }));
    }
    for (;;)
    {
      localStringBuffer.append(com.baidu.location.h.b.a().g());
      parama = localStringBuffer.toString();
      com.baidu.location.d.f.a().a(parama);
      g.a(g.a, Jni.encode(parama));
      return parama;
      if ((paramBDLocation1 == null) && (paramBDLocation2 != null))
      {
        i1 = 2;
        break;
      }
      if ((paramBDLocation1 != null) && (paramBDLocation2 == null))
      {
        i1 = 1;
        break;
      }
      i1 = 4;
      break;
      label239:
      localStringBuffer.append(String.format(Locale.US, "&ofcl=1|%f|%f|%d", new Object[] { Double.valueOf(paramBDLocation1.getLongitude()), Double.valueOf(paramBDLocation1.getLatitude()), Integer.valueOf((int)paramBDLocation1.getRadius()) }));
      break label94;
      label292:
      localStringBuffer.append(String.format(Locale.US, "&ofwf=1|%f|%f|%d", new Object[] { Double.valueOf(paramBDLocation2.getLongitude()), Double.valueOf(paramBDLocation2.getLatitude()), Integer.valueOf((int)paramBDLocation2.getRadius()) }));
      break label118;
      label348:
      localStringBuffer.append(String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[] { "1", Integer.valueOf(i1), Double.valueOf(paramBDLocation3.getLongitude()), Double.valueOf(paramBDLocation3.getLatitude()), Integer.valueOf((int)paramBDLocation3.getRadius()) }));
    }
  }
  
  private void c()
  {
    if (!d.a().e())
    {
      break label9;
      break label9;
      break label9;
    }
    label9:
    while ((this.g.a) || (this.e.a) || (this.f.a)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    label84:
    Object localObject6;
    Object localObject5;
    int i3;
    if ((!this.c.isEmpty()) || (!this.d.isEmpty()))
    {
      localObject1 = null;
      localObject2 = null;
      i1 = 0;
      i2 = 0;
      Iterator localIterator = this.b.keySet().iterator();
      if (localIterator.hasNext())
      {
        localObject6 = (String)localIterator.next();
        if ((((c)this.b.get(localObject6)).g == 1) && (!this.d.containsKey(localObject6)))
        {
          localObject5 = localObject1;
          if (localObject1 == null) {
            localObject5 = new ArrayList();
          }
          ((List)localObject5).add(localObject6);
          i3 = i2;
          localObject1 = localObject2;
          localObject2 = localObject5;
          i2 = i1;
          i1 = i3;
        }
      }
    }
    for (;;)
    {
      label179:
      i3 = i2;
      localObject5 = localObject1;
      localObject1 = localObject2;
      i2 = i1;
      i1 = i3;
      localObject2 = localObject5;
      break label84;
      int i4 = i2;
      i3 = i1;
      localObject5 = localObject2;
      if (((c)this.b.get(localObject6)).g == 0)
      {
        int i6 = (int)(System.currentTimeMillis() / 1000L) - ((c)this.b.get(localObject6)).f;
        int i5 = i2 + 1;
        i2 = i1;
        if (i6 > i1)
        {
          i2 = i6;
          localObject2 = localObject6;
        }
        i4 = i5;
        i3 = i2;
        localObject5 = localObject2;
        if (i6 > 2592000)
        {
          if (localObject1 == null) {
            localObject1 = new ArrayList();
          }
          for (;;)
          {
            ((List)localObject1).add(localObject6);
            i1 = i5;
            localObject5 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject5;
            break label179;
            localObject5 = localObject1;
            if (i2 > 9)
            {
              localObject5 = localObject1;
              if (localObject2 != null)
              {
                localObject6 = localObject1;
                if (localObject1 == null) {
                  localObject6 = new ArrayList();
                }
                localObject5 = localObject6;
                if (!((List)localObject6).contains(localObject2))
                {
                  ((List)localObject6).add(localObject2);
                  localObject5 = localObject6;
                }
              }
            }
            if (localObject5 != null)
            {
              localObject1 = ((List)localObject5).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                try
                {
                  localObject5 = "DROP TABLE " + (String)localObject2 + ";";
                  localObject6 = "DELETE FROM CL WHERE id = \"" + (String)localObject2 + "\";";
                  if (this.k != null)
                  {
                    this.k.execSQL((String)localObject5);
                    this.k.execSQL((String)localObject6);
                    this.b.remove(localObject2);
                  }
                }
                catch (Exception localException1)
                {
                  Log.w(com.baidu.location.h.a.a, "OfflineLocationV2Manager delete table error!", localException1);
                }
              }
              if (this.n == null) {
                break;
              }
              this.n.sendEmptyMessage(1);
              return;
            }
            localObject6 = this.a.keySet().iterator();
            Object localObject3;
            for (localObject1 = localObject5; ((Iterator)localObject6).hasNext(); localObject1 = localObject3)
            {
              localObject5 = (String)((Iterator)localObject6).next();
              localObject3 = localObject1;
              if (!this.c.containsKey(localObject5))
              {
                localObject3 = localObject1;
                if (localObject1 == null) {
                  localObject3 = new ArrayList();
                }
                ((List)localObject3).add(localObject5);
              }
            }
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (String)((Iterator)localObject1).next();
                try
                {
                  localObject5 = "DROP TABLE " + (String)localObject3 + ";";
                  localObject6 = "DELETE FROM AP WHERE id = \"" + (String)localObject3 + "\";";
                  if (this.k != null)
                  {
                    this.k.execSQL((String)localObject5);
                    this.k.execSQL((String)localObject6);
                    this.a.remove(localObject3);
                  }
                }
                catch (Exception localException2)
                {
                  Log.w(com.baidu.location.h.a.a, "OfflineLocationV2Manager delete table error!", localException2);
                }
              }
              if (this.n == null) {
                break;
              }
              this.n.sendEmptyMessage(1);
              return;
            }
            localObject4 = null;
            localObject1 = localObject4;
            if (!this.d.isEmpty())
            {
              localObject5 = this.d.keySet().iterator();
              localObject1 = localObject4;
              if (((Iterator)localObject5).hasNext())
              {
                localObject1 = (String)((Iterator)localObject5).next();
                if (this.b.containsKey(localObject1)) {
                  break label951;
                }
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label1005;
              }
              this.e.a(((c)this.d.get(localObject1)).a, ((c)this.d.get(localObject1)).b, 1, ((c)this.d.get(localObject1)).e);
              return;
              label951:
              if ((((c)this.b.get(localObject1)).d == 0) || (((c)this.b.get(localObject1)).d >= ((c)this.d.get(localObject1)).d)) {
                break;
              }
            }
            label1005:
            if (!this.c.isEmpty())
            {
              localObject5 = this.c.keySet().iterator();
              label1029:
              if (((Iterator)localObject5).hasNext())
              {
                localObject4 = (String)((Iterator)localObject5).next();
                if (!this.a.containsKey(localObject4)) {
                  localObject1 = localObject4;
                }
              }
            }
            for (;;)
            {
              if (localObject1 != null)
              {
                this.f.a(((c)this.c.get(localObject1)).a, ((c)this.c.get(localObject1)).b, 1, ((c)this.c.get(localObject1)).e);
                return;
                if ((((c)this.a.get(localObject4)).d == 0) || (((c)this.a.get(localObject4)).d >= ((c)this.c.get(localObject4)).d)) {
                  break label1029;
                }
                localObject1 = localObject4;
                continue;
              }
              if ((this.d == null) || (this.d.isEmpty())) {
                break;
              }
              localObject1 = new ArrayList();
              ((List)localObject1).addAll(this.d.values());
              i3 = ((c)((List)localObject1).get(0)).e;
              localObject1 = null;
              localObject4 = new double[2];
              Object tmp1250_1248 = localObject4;
              tmp1250_1248[0] = 0.0D;
              Object tmp1254_1250 = tmp1250_1248;
              tmp1254_1250[1] = 0.0D;
              tmp1254_1250;
              i2 = 0;
              i1 = 0;
              if (this.q != null)
              {
                localObject1 = new BDLocation(this.q);
                localObject4 = Jni.coorEncrypt(((BDLocation)localObject1).getLongitude(), ((BDLocation)localObject1).getLatitude(), "gcj2wgs");
                i2 = (int)(localObject4[0] * 100000.0D) / i3;
                i1 = (int)(localObject4[1] * 100000.0D) / i3;
                localObject1 = new c("CL_" + i2 + "_" + i1, i2, i1, 0, 0, 0, 0);
              }
              if ((localObject1 == null) || (this.b.containsKey(((c)localObject1).c)) || (this.d.containsKey(((c)localObject1).c))) {
                break;
              }
              this.e.a(localObject4[1], localObject4[0], 0, i2, i1, i3);
              return;
              if (this.m > 0)
              {
                a(86400);
                return;
              }
              a(604800);
              return;
            }
          }
        }
      }
      i1 = i4;
      i2 = i3;
      Object localObject4 = localObject1;
      localObject1 = localObject5;
    }
  }
  
  public BDLocation a(com.baidu.location.f.a parama, com.baidu.location.f.e parame, boolean paramBoolean, Location paramLocation)
  {
    Object localObject2 = null;
    BDLocation localBDLocation1 = null;
    for (;;)
    {
      Object localObject1;
      BDLocation localBDLocation2;
      try
      {
        boolean bool = d.a().e();
        if (!bool)
        {
          localObject1 = localBDLocation1;
          return (BDLocation)localObject1;
        }
        if ((parama == null) || (!parama.e()))
        {
          localObject1 = localBDLocation1;
          if (parame == null) {
            continue;
          }
          localObject1 = localBDLocation1;
          if (parame.a() == 0) {
            continue;
          }
        }
        if (this.b.isEmpty())
        {
          localObject1 = localBDLocation1;
          if (this.a.isEmpty()) {
            continue;
          }
        }
        localObject1 = localBDLocation1;
        if (this.g.a) {
          continue;
        }
        localObject1 = localBDLocation1;
        if (this.e.a) {
          continue;
        }
        localObject1 = localBDLocation1;
        if (this.f.a) {
          continue;
        }
        localObject1 = localBDLocation1;
        if (this.o) {
          continue;
        }
        this.o = true;
        if (this.q == null) {
          break label610;
        }
        localBDLocation2 = new BDLocation(this.q);
        localObject1 = Jni.coorEncrypt(localBDLocation2.getLongitude(), localBDLocation2.getLatitude(), "gcj2wgs");
        localBDLocation2.setLatitude(localObject1[1]);
        localBDLocation2.setLongitude(localObject1[0]);
        if ((this.b.isEmpty()) || (parama == null) || (!parama.e())) {
          break label604;
        }
        String str = parama.h();
        if ((this.p == null) || (!this.p.b.equals(str)) || ((int)(System.currentTimeMillis() / 1000L) - this.p.c >= 600)) {
          break label598;
        }
        localBDLocation1 = this.p.a;
        if (localBDLocation1 != null)
        {
          localObject1 = localBDLocation1;
          if (localBDLocation1.getLocType() == 66) {}
        }
        else
        {
          localBDLocation1 = a(Jni.encode3(parama.h()), localBDLocation2, paramLocation);
          localObject1 = localBDLocation1;
          if (localBDLocation1 != null)
          {
            localObject1 = localBDLocation1;
            if (localBDLocation1.getLocType() == 66)
            {
              this.p = null;
              this.p = new b(localBDLocation1, str, (int)(System.currentTimeMillis() / 1000L));
              localObject1 = localBDLocation1;
            }
          }
        }
        if ((this.a.isEmpty()) || (parame == null) || (parame.a() <= 0)) {
          break label592;
        }
        localBDLocation1 = a(parame.i(), (BDLocation)localObject1, localBDLocation2, 2, paramLocation);
        if ((localBDLocation1 != null) && (localBDLocation1.getLocType() == 66))
        {
          paramLocation = new BDLocation(localBDLocation1);
          if (paramBoolean) {
            a(parama, parame, (BDLocation)localObject1, localBDLocation1, paramLocation);
          }
          if ((paramLocation != null) && (paramLocation.getLocType() == 66))
          {
            parama = Jni.coorEncrypt(paramLocation.getLongitude(), paramLocation.getLatitude(), "gps2gcj");
            paramLocation.setLongitude(parama[0]);
            paramLocation.setLatitude(parama[1]);
            paramLocation.setCoorType("gcj02");
            paramLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
          }
          this.o = false;
          localObject1 = paramLocation;
          continue;
        }
        paramLocation = (Location)localObject2;
      }
      finally {}
      if (localObject1 != null)
      {
        paramLocation = (Location)localObject2;
        if (((BDLocation)localObject1).getLocType() == 66)
        {
          paramLocation = new BDLocation((BDLocation)localObject1);
          continue;
          label592:
          localBDLocation1 = null;
          continue;
          label598:
          localBDLocation1 = null;
          continue;
          label604:
          localObject1 = null;
          continue;
          label610:
          localBDLocation2 = null;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.n == null) {
      this.n = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          }
          do
          {
            return;
          } while ((com.baidu.location.a.e.a().d() != 0) || (b.a(b.this) == null));
          b.b(b.this);
        }
      };
    }
    if (!d.a().e()) {}
    do
    {
      do
      {
        return;
      } while ((int)(System.currentTimeMillis() / 1000L) - this.m <= paramInt);
      this.m = ((int)(System.currentTimeMillis() / 1000L));
    } while (!com.baidu.location.f.f.j());
    this.n.postDelayed(new Runnable()
    {
      public void run()
      {
        if ((com.baidu.location.a.e.a().d() == 0) && (b.a(b.this) != null) && (b.this.g != null)) {
          b.this.g.b();
        }
      }
    }, '丠');
  }
  
  public void a(BDLocation paramBDLocation)
  {
    if ((paramBDLocation != null) && ((paramBDLocation.getLocType() == 61) || (paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66))) {
      this.q = new BDLocation(paramBDLocation);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.l = paramString;
    }
  }
  
  public void b()
  {
    if (this.n != null) {
      this.n.sendEmptyMessage(1);
    }
  }
  
  private static final class a
  {
    double a;
    double b;
    double c;
    
    private a(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = paramDouble3;
    }
  }
  
  private class b
  {
    public BDLocation a;
    public String b;
    public int c;
    
    b(BDLocation paramBDLocation, String paramString, int paramInt)
    {
      this.a = paramBDLocation;
      this.b = paramString;
      this.c = paramInt;
    }
  }
  
  private class c
  {
    public int a = 0;
    public int b = 0;
    public String c = null;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    
    c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.c = paramString;
      this.a = paramInt1;
      this.b = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
    }
    
    public Location a(int paramInt)
    {
      Location localLocation = new Location("temp");
      int i = this.b;
      int j = this.e;
      double d1 = ((paramInt >> 16 & 0xFFFF) * this.e / 65535 + i * j) / 100000.0D;
      i = this.a;
      j = this.e;
      double d2 = ((paramInt & 0xFFFF) * this.e / 65535 + i * j) / 100000.0D;
      localLocation.setLatitude(d1);
      localLocation.setLongitude(d2);
      return localLocation;
    }
  }
  
  private final class d
    extends com.baidu.location.h.e
  {
    public boolean a = false;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private double p = 0.0D;
    private double q = 0.0D;
    private int r = 0;
    private boolean s = false;
    
    public d()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = b.c(b.this);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&qt=grid");
      if (this.e == 1)
      {
        ((StringBuffer)localObject).append("&tp=gdg");
        ((StringBuffer)localObject).append("&clg=");
        ((StringBuffer)localObject).append(String.format(Locale.US, "%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
      }
      for (;;)
      {
        ((StringBuffer)localObject).append("&ct=");
        ((StringBuffer)localObject).append(b.a(b.this));
        ((StringBuffer)localObject).append(com.baidu.location.h.b.a().g());
        ((StringBuffer)localObject).append("&vkey=0");
        localObject = ((StringBuffer)localObject).toString();
        this.k.put("qt", "grid");
        this.k.put("req", Jni.encode((String)localObject));
        return;
        ((StringBuffer)localObject).append("&tp=gdl");
        ((StringBuffer)localObject).append("&datp=c");
        ((StringBuffer)localObject).append("&loc=");
        ((StringBuffer)localObject).append(String.format(Locale.US, "%.6f|%.6f", new Object[] { Double.valueOf(this.q), Double.valueOf(this.p) }));
      }
    }
    
    public void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (b.a(b.this) == null) {}
      while ((this.a) || (this.s)) {
        return;
      }
      this.a = true;
      this.p = paramDouble1;
      this.q = paramDouble2;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt1;
      this.r = paramInt4;
      a(false, "ofloc.map.baidu.com");
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (b.a(b.this) == null) {}
      while ((this.a) || (this.s)) {
        return;
      }
      this.a = true;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.r = paramInt4;
      a(false, "ofloc.map.baidu.com");
    }
    
    /* Error */
    public void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 11
      //   3: iconst_0
      //   4: istore_2
      //   5: iload_1
      //   6: ifeq +1180 -> 1186
      //   9: aload_0
      //   10: getfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   13: ifnull +1173 -> 1186
      //   16: aload_0
      //   17: getfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   20: astore 10
      //   22: new 161	org/json/JSONObject
      //   25: dup
      //   26: aload 10
      //   28: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   31: astore 10
      //   33: aload 10
      //   35: ifnull +545 -> 580
      //   38: aload 10
      //   40: ldc -90
      //   42: invokevirtual 170	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   45: ifeq +535 -> 580
      //   48: aload 10
      //   50: ldc -90
      //   52: invokevirtual 174	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   55: astore 10
      //   57: iconst_0
      //   58: ifne +37 -> 95
      //   61: getstatic 79	java/util/Locale:US	Ljava/util/Locale;
      //   64: ldc -80
      //   66: iconst_2
      //   67: anewarray 83	java/lang/Object
      //   70: dup
      //   71: iconst_0
      //   72: aload_0
      //   73: getfield 31	com/baidu/location/c/b$d:c	I
      //   76: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   79: aastore
      //   80: dup
      //   81: iconst_1
      //   82: aload_0
      //   83: getfield 33	com/baidu/location/c/b$d:d	I
      //   86: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: aastore
      //   90: invokestatic 95	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   93: astore 11
      //   95: aload_0
      //   96: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   99: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   102: invokevirtual 184	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   105: iload_2
      //   106: istore 5
      //   108: aload 10
      //   110: ifnull +27 -> 137
      //   113: aload 10
      //   115: ldc -70
      //   117: invokevirtual 170	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   120: istore_1
      //   121: iload_2
      //   122: istore 5
      //   124: iload_1
      //   125: ifeq +12 -> 137
      //   128: aload 10
      //   130: ldc -70
      //   132: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   135: istore 5
      //   137: iconst_0
      //   138: istore_2
      //   139: iload_2
      //   140: istore 6
      //   142: aload 10
      //   144: ifnull +25 -> 169
      //   147: iload_2
      //   148: istore 6
      //   150: aload 10
      //   152: ldc -64
      //   154: invokevirtual 170	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   157: ifeq +12 -> 169
      //   160: aload 10
      //   162: ldc -64
      //   164: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   167: istore 6
      //   169: iload 6
      //   171: ifeq +17 -> 188
      //   174: iload 6
      //   176: aload_0
      //   177: getfield 43	com/baidu/location/c/b$d:r	I
      //   180: if_icmpeq +8 -> 188
      //   183: aload_0
      //   184: iconst_1
      //   185: putfield 45	com/baidu/location/c/b$d:s	Z
      //   188: iload 6
      //   190: ifle +788 -> 978
      //   193: aload_0
      //   194: getfield 45	com/baidu/location/c/b$d:s	Z
      //   197: ifne +781 -> 978
      //   200: aload 10
      //   202: ifnull +776 -> 978
      //   205: aload 10
      //   207: ldc -62
      //   209: invokevirtual 170	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   212: ifeq +766 -> 978
      //   215: new 196	java/lang/StringBuilder
      //   218: dup
      //   219: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   222: ldc -57
      //   224: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   227: aload 11
      //   229: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: ldc -52
      //   234: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: astore 12
      //   242: new 196	java/lang/StringBuilder
      //   245: dup
      //   246: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   249: ldc -49
      //   251: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: aload 11
      //   256: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: ldc -47
      //   261: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   267: astore 13
      //   269: aload_0
      //   270: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   273: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   276: astore 14
      //   278: aload 14
      //   280: ifnull +27 -> 307
      //   283: aload_0
      //   284: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   287: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   290: aload 12
      //   292: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   295: aload_0
      //   296: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   299: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   302: aload 13
      //   304: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   307: aload 10
      //   309: ldc -62
      //   311: invokevirtual 215	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   314: ldc -47
      //   316: invokevirtual 219	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   319: astore 12
      //   321: new 62	java/lang/StringBuffer
      //   324: dup
      //   325: invokespecial 63	java/lang/StringBuffer:<init>	()V
      //   328: astore 13
      //   330: new 196	java/lang/StringBuilder
      //   333: dup
      //   334: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   337: ldc -35
      //   339: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   342: aload 11
      //   344: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   347: ldc -33
      //   349: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   355: astore 14
      //   357: aload 12
      //   359: arraylength
      //   360: istore 9
      //   362: iconst_0
      //   363: istore 8
      //   365: iconst_1
      //   366: istore 4
      //   368: iconst_0
      //   369: istore 7
      //   371: iload 7
      //   373: iload 9
      //   375: if_icmpge +345 -> 720
      //   378: aload 12
      //   380: iload 7
      //   382: aaload
      //   383: astore 15
      //   385: iload 8
      //   387: istore_2
      //   388: iload 4
      //   390: istore_3
      //   391: aload 15
      //   393: ldc -31
      //   395: invokevirtual 229	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   398: ifeq +147 -> 545
      //   401: aload 15
      //   403: ldc -25
      //   405: invokevirtual 219	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   408: astore 16
      //   410: iload 8
      //   412: istore_2
      //   413: iload 4
      //   415: istore_3
      //   416: aload 16
      //   418: arraylength
      //   419: iconst_2
      //   420: if_icmpne +125 -> 545
      //   423: aload 16
      //   425: iconst_0
      //   426: aaload
      //   427: astore 15
      //   429: aload 16
      //   431: iconst_1
      //   432: aaload
      //   433: astore 16
      //   435: iload 4
      //   437: ifeq +149 -> 586
      //   440: iconst_0
      //   441: istore_3
      //   442: aload 13
      //   444: bipush 40
      //   446: invokevirtual 234	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   449: aload 15
      //   451: invokevirtual 69	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   454: bipush 44
      //   456: invokevirtual 234	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   459: new 196	java/lang/StringBuilder
      //   462: dup
      //   463: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   466: ldc -20
      //   468: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   471: aload 16
      //   473: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   476: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   479: invokevirtual 69	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   482: bipush 41
      //   484: invokevirtual 234	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   487: pop
      //   488: iload 8
      //   490: iconst_1
      //   491: iadd
      //   492: istore 4
      //   494: iload 4
      //   496: istore_2
      //   497: iload 4
      //   499: bipush 100
      //   501: if_icmplt +44 -> 545
      //   504: aload_0
      //   505: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   508: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   511: aload 14
      //   513: iconst_1
      //   514: anewarray 83	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: aload 13
      //   521: invokevirtual 113	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   524: aastore
      //   525: invokestatic 239	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   528: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   531: iconst_1
      //   532: istore_3
      //   533: aload 13
      //   535: iconst_0
      //   536: invokevirtual 243	java/lang/StringBuffer:setLength	(I)V
      //   539: iload 4
      //   541: bipush 100
      //   543: isub
      //   544: istore_2
      //   545: iload 7
      //   547: iconst_1
      //   548: iadd
      //   549: istore 7
      //   551: iload_2
      //   552: istore 8
      //   554: iload_3
      //   555: istore 4
      //   557: goto -186 -> 371
      //   560: astore 10
      //   562: aload 10
      //   564: invokevirtual 246	org/json/JSONException:printStackTrace	()V
      //   567: aconst_null
      //   568: astore 10
      //   570: goto -537 -> 33
      //   573: astore 10
      //   575: aload 10
      //   577: invokevirtual 246	org/json/JSONException:printStackTrace	()V
      //   580: aconst_null
      //   581: astore 10
      //   583: goto -526 -> 57
      //   586: aload 13
      //   588: bipush 44
      //   590: invokevirtual 234	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   593: pop
      //   594: iload 4
      //   596: istore_3
      //   597: goto -155 -> 442
      //   600: astore 10
      //   602: iconst_0
      //   603: istore_2
      //   604: aload_0
      //   605: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   608: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   611: ifnull +26 -> 637
      //   614: aload_0
      //   615: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   618: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   621: invokevirtual 250	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   624: ifeq +13 -> 637
      //   627: aload_0
      //   628: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   631: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   634: invokevirtual 253	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   637: aload_0
      //   638: aconst_null
      //   639: putfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   642: aload_0
      //   643: aload_0
      //   644: getfield 37	com/baidu/location/c/b$d:f	I
      //   647: iconst_1
      //   648: iadd
      //   649: putfield 37	com/baidu/location/c/b$d:f	I
      //   652: aload_0
      //   653: aconst_null
      //   654: putfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   657: aload_0
      //   658: getfield 52	com/baidu/location/c/b$d:k	Ljava/util/Map;
      //   661: invokeinterface 256 1 0
      //   666: aload_0
      //   667: getfield 37	com/baidu/location/c/b$d:f	I
      //   670: iconst_3
      //   671: irem
      //   672: iconst_1
      //   673: if_icmpne +6 -> 679
      //   676: invokestatic 261	java/lang/System:gc	()V
      //   679: aload_0
      //   680: iconst_0
      //   681: putfield 29	com/baidu/location/c/b$d:a	Z
      //   684: iload_2
      //   685: ifeq +34 -> 719
      //   688: aload_0
      //   689: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   692: invokestatic 264	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   695: ifnull +24 -> 719
      //   698: invokestatic 269	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
      //   701: invokevirtual 271	com/baidu/location/a/a:c	()Z
      //   704: ifeq +15 -> 719
      //   707: aload_0
      //   708: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   711: invokestatic 264	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   714: iconst_1
      //   715: invokevirtual 277	android/os/Handler:sendEmptyMessage	(I)Z
      //   718: pop
      //   719: return
      //   720: iload 8
      //   722: ifle +30 -> 752
      //   725: aload_0
      //   726: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   729: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   732: aload 14
      //   734: iconst_1
      //   735: anewarray 83	java/lang/Object
      //   738: dup
      //   739: iconst_0
      //   740: aload 13
      //   742: invokevirtual 113	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   745: aastore
      //   746: invokestatic 239	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   749: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   752: aload_0
      //   753: getfield 45	com/baidu/location/c/b$d:s	Z
      //   756: ifne +425 -> 1181
      //   759: aload 10
      //   761: ifnull +420 -> 1181
      //   764: getstatic 79	java/util/Locale:US	Ljava/util/Locale;
      //   767: ldc_w 279
      //   770: bipush 7
      //   772: anewarray 83	java/lang/Object
      //   775: dup
      //   776: iconst_0
      //   777: aload 11
      //   779: aastore
      //   780: dup
      //   781: iconst_1
      //   782: aload_0
      //   783: getfield 31	com/baidu/location/c/b$d:c	I
      //   786: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   789: aastore
      //   790: dup
      //   791: iconst_2
      //   792: aload_0
      //   793: getfield 33	com/baidu/location/c/b$d:d	I
      //   796: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   799: aastore
      //   800: dup
      //   801: iconst_3
      //   802: iload 5
      //   804: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   807: aastore
      //   808: dup
      //   809: iconst_4
      //   810: iload 6
      //   812: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   815: aastore
      //   816: dup
      //   817: iconst_5
      //   818: invokestatic 283	java/lang/System:currentTimeMillis	()J
      //   821: ldc2_w 284
      //   824: ldiv
      //   825: l2i
      //   826: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   829: aastore
      //   830: dup
      //   831: bipush 6
      //   833: aload_0
      //   834: getfield 35	com/baidu/location/c/b$d:e	I
      //   837: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   840: aastore
      //   841: invokestatic 95	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   844: astore 10
      //   846: new 287	com/baidu/location/c/b$c
      //   849: dup
      //   850: aload_0
      //   851: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   854: aload 11
      //   856: aload_0
      //   857: getfield 31	com/baidu/location/c/b$d:c	I
      //   860: aload_0
      //   861: getfield 33	com/baidu/location/c/b$d:d	I
      //   864: iload 5
      //   866: iload 6
      //   868: invokestatic 283	java/lang/System:currentTimeMillis	()J
      //   871: ldc2_w 284
      //   874: ldiv
      //   875: l2i
      //   876: aload_0
      //   877: getfield 35	com/baidu/location/c/b$d:e	I
      //   880: invokespecial 290	com/baidu/location/c/b$c:<init>	(Lcom/baidu/location/c/b;Ljava/lang/String;IIIIII)V
      //   883: astore 11
      //   885: aload_0
      //   886: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   889: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   892: aload 10
      //   894: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   897: aload_0
      //   898: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   901: getfield 293	com/baidu/location/c/b:b	Ljava/util/concurrent/ConcurrentHashMap;
      //   904: aload 11
      //   906: getfield 295	com/baidu/location/c/b$c:c	Ljava/lang/String;
      //   909: aload 11
      //   911: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   914: pop
      //   915: iconst_1
      //   916: istore_2
      //   917: aload_0
      //   918: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   921: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   924: ifnull +13 -> 937
      //   927: aload_0
      //   928: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   931: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   934: invokevirtual 301	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   937: aload_0
      //   938: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   941: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   944: ifnull +26 -> 970
      //   947: aload_0
      //   948: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   951: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   954: invokevirtual 250	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   957: ifeq +13 -> 970
      //   960: aload_0
      //   961: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   964: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   967: invokevirtual 253	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   970: aload_0
      //   971: aconst_null
      //   972: putfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   975: goto -333 -> 642
      //   978: aload 10
      //   980: ifnull -228 -> 752
      //   983: aload 10
      //   985: ldc -62
      //   987: invokevirtual 170	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   990: ifne -238 -> 752
      //   993: new 196	java/lang/StringBuilder
      //   996: dup
      //   997: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   1000: ldc -57
      //   1002: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1005: aload 11
      //   1007: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1010: ldc -52
      //   1012: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1015: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1018: astore 12
      //   1020: new 196	java/lang/StringBuilder
      //   1023: dup
      //   1024: invokespecial 197	java/lang/StringBuilder:<init>	()V
      //   1027: ldc -49
      //   1029: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1032: aload 11
      //   1034: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1037: ldc -47
      //   1039: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1042: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1045: astore 13
      //   1047: aload_0
      //   1048: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1051: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1054: astore 14
      //   1056: aload 14
      //   1058: ifnull -306 -> 752
      //   1061: aload_0
      //   1062: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1065: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1068: aload 12
      //   1070: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1073: aload_0
      //   1074: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1077: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1080: aload 13
      //   1082: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1085: goto -333 -> 752
      //   1088: astore 12
      //   1090: goto -338 -> 752
      //   1093: astore 10
      //   1095: iconst_0
      //   1096: istore_2
      //   1097: goto -180 -> 917
      //   1100: astore 10
      //   1102: aload_0
      //   1103: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1106: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1109: ifnull +26 -> 1135
      //   1112: aload_0
      //   1113: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1116: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1119: invokevirtual 250	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   1122: ifeq +13 -> 1135
      //   1125: aload_0
      //   1126: getfield 24	com/baidu/location/c/b$d:b	Lcom/baidu/location/c/b;
      //   1129: invokestatic 179	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1132: invokevirtual 253	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   1135: aload_0
      //   1136: aconst_null
      //   1137: putfield 159	com/baidu/location/c/b$d:j	Ljava/lang/String;
      //   1140: aload 10
      //   1142: athrow
      //   1143: astore 11
      //   1145: goto -10 -> 1135
      //   1148: astore 10
      //   1150: goto -513 -> 637
      //   1153: astore 10
      //   1155: goto -551 -> 604
      //   1158: astore 10
      //   1160: goto -190 -> 970
      //   1163: astore 12
      //   1165: goto -858 -> 307
      //   1168: astore 12
      //   1170: iload_2
      //   1171: istore 5
      //   1173: goto -1036 -> 137
      //   1176: astore 12
      //   1178: goto -1073 -> 105
      //   1181: iconst_0
      //   1182: istore_2
      //   1183: goto -266 -> 917
      //   1186: iconst_0
      //   1187: istore_2
      //   1188: goto -546 -> 642
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1191	0	this	d
      //   0	1191	1	paramBoolean	boolean
      //   4	1184	2	i	int
      //   390	207	3	j	int
      //   366	229	4	k	int
      //   106	1066	5	m	int
      //   140	727	6	n	int
      //   369	181	7	i1	int
      //   363	358	8	i2	int
      //   360	16	9	i3	int
      //   20	288	10	localObject1	Object
      //   560	3	10	localJSONException1	org.json.JSONException
      //   568	1	10	localObject2	Object
      //   573	3	10	localJSONException2	org.json.JSONException
      //   581	1	10	localObject3	Object
      //   600	160	10	localException1	Exception
      //   844	140	10	str1	String
      //   1093	1	10	localException2	Exception
      //   1100	41	10	localObject4	Object
      //   1148	1	10	localException3	Exception
      //   1153	1	10	localException4	Exception
      //   1158	1	10	localException5	Exception
      //   1	1032	11	localObject5	Object
      //   1143	1	11	localException6	Exception
      //   240	829	12	localObject6	Object
      //   1088	1	12	localException7	Exception
      //   1163	1	12	localException8	Exception
      //   1168	1	12	localException9	Exception
      //   1176	1	12	localException10	Exception
      //   267	814	13	localObject7	Object
      //   276	781	14	localObject8	Object
      //   383	67	15	str2	String
      //   408	64	16	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   22	33	560	org/json/JSONException
      //   48	57	573	org/json/JSONException
      //   113	121	600	java/lang/Exception
      //   150	169	600	java/lang/Exception
      //   174	188	600	java/lang/Exception
      //   193	200	600	java/lang/Exception
      //   205	278	600	java/lang/Exception
      //   307	362	600	java/lang/Exception
      //   391	410	600	java/lang/Exception
      //   416	423	600	java/lang/Exception
      //   442	488	600	java/lang/Exception
      //   504	531	600	java/lang/Exception
      //   533	539	600	java/lang/Exception
      //   586	594	600	java/lang/Exception
      //   725	752	600	java/lang/Exception
      //   752	759	600	java/lang/Exception
      //   764	885	600	java/lang/Exception
      //   983	1056	600	java/lang/Exception
      //   1061	1085	1088	java/lang/Exception
      //   885	915	1093	java/lang/Exception
      //   95	105	1100	finally
      //   113	121	1100	finally
      //   128	137	1100	finally
      //   150	169	1100	finally
      //   174	188	1100	finally
      //   193	200	1100	finally
      //   205	278	1100	finally
      //   283	307	1100	finally
      //   307	362	1100	finally
      //   391	410	1100	finally
      //   416	423	1100	finally
      //   442	488	1100	finally
      //   504	531	1100	finally
      //   533	539	1100	finally
      //   586	594	1100	finally
      //   725	752	1100	finally
      //   752	759	1100	finally
      //   764	885	1100	finally
      //   885	915	1100	finally
      //   917	937	1100	finally
      //   983	1056	1100	finally
      //   1061	1085	1100	finally
      //   1102	1135	1143	java/lang/Exception
      //   604	637	1148	java/lang/Exception
      //   917	937	1153	java/lang/Exception
      //   937	970	1158	java/lang/Exception
      //   283	307	1163	java/lang/Exception
      //   128	137	1168	java/lang/Exception
      //   95	105	1176	java/lang/Exception
    }
  }
  
  private final class e
    extends com.baidu.location.h.e
  {
    public boolean a = false;
    private int c = 0;
    
    public e()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = b.c(b.this);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&qt=grid");
      ((StringBuffer)localObject).append("&tp=gi");
      ((StringBuffer)localObject).append("&ct=");
      ((StringBuffer)localObject).append(b.a(b.this));
      ((StringBuffer)localObject).append(com.baidu.location.h.b.a().g());
      ((StringBuffer)localObject).append("&vkey=0");
      localObject = ((StringBuffer)localObject).toString();
      this.k.put("qt", "grid");
      this.k.put("req", Jni.encode((String)localObject));
    }
    
    /* Error */
    public void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_1
      //   1: ifeq +1930 -> 1931
      //   4: aload_0
      //   5: getfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   8: ifnull +1923 -> 1931
      //   11: aload_0
      //   12: getfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   15: astore 11
      //   17: new 96	org/json/JSONObject
      //   20: dup
      //   21: aload 11
      //   23: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   26: astore 11
      //   28: aload 11
      //   30: ifnull +550 -> 580
      //   33: aload 11
      //   35: ldc 101
      //   37: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   40: ifeq +540 -> 580
      //   43: aload 11
      //   45: ldc 101
      //   47: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   50: astore 11
      //   52: aload_0
      //   53: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   56: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   59: invokevirtual 118	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   62: aload 11
      //   64: ifnull +1862 -> 1926
      //   67: aload 11
      //   69: ldc 120
      //   71: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   74: istore_1
      //   75: iload_1
      //   76: ifeq +1850 -> 1926
      //   79: aload 11
      //   81: ldc 120
      //   83: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   86: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   89: invokevirtual 133	java/lang/Integer:intValue	()I
      //   92: istore_2
      //   93: aload 11
      //   95: ifnull +1825 -> 1920
      //   98: aload 11
      //   100: ldc -121
      //   102: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   105: ifeq +1815 -> 1920
      //   108: aload 11
      //   110: ldc -121
      //   112: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   115: ldc -119
      //   117: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   120: ifeq +1800 -> 1920
      //   123: aload 11
      //   125: ldc -121
      //   127: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   130: ldc -119
      //   132: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   135: istore 5
      //   137: iload 5
      //   139: ifle +617 -> 756
      //   142: aload 11
      //   144: ifnull +612 -> 756
      //   147: aload 11
      //   149: ldc -121
      //   151: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   154: ifeq +602 -> 756
      //   157: aload 11
      //   159: ldc -121
      //   161: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   164: ldc -114
      //   166: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   169: ifeq +587 -> 756
      //   172: aload_0
      //   173: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   176: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   179: astore 12
      //   181: aload 12
      //   183: ifnull +15 -> 198
      //   186: aload_0
      //   187: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   190: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   193: ldc -112
      //   195: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   198: aload 11
      //   200: ldc -121
      //   202: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   205: ldc -114
      //   207: invokevirtual 151	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   210: astore 12
      //   212: aload 12
      //   214: invokevirtual 156	org/json/JSONArray:length	()I
      //   217: istore 8
      //   219: new 41	java/lang/StringBuffer
      //   222: dup
      //   223: invokespecial 42	java/lang/StringBuffer:<init>	()V
      //   226: astore 13
      //   228: iconst_0
      //   229: istore 4
      //   231: iconst_1
      //   232: istore_3
      //   233: iconst_0
      //   234: istore 6
      //   236: iload 6
      //   238: iload 8
      //   240: if_icmpge +484 -> 724
      //   243: aload 12
      //   245: iload 6
      //   247: invokevirtual 159	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   250: ldc -95
      //   252: invokevirtual 167	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   255: astore 14
      //   257: aload 14
      //   259: iconst_0
      //   260: aaload
      //   261: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   264: invokevirtual 133	java/lang/Integer:intValue	()I
      //   267: istore 7
      //   269: aload 14
      //   271: iconst_1
      //   272: aaload
      //   273: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   276: invokevirtual 133	java/lang/Integer:intValue	()I
      //   279: istore 9
      //   281: iload_3
      //   282: ifeq +311 -> 593
      //   285: iconst_0
      //   286: istore_3
      //   287: aload 13
      //   289: bipush 40
      //   291: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   294: new 172	java/lang/StringBuilder
      //   297: dup
      //   298: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   301: ldc -81
      //   303: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   306: iload 7
      //   308: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   311: ldc -73
      //   313: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: iload 9
      //   318: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   321: ldc -71
      //   323: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   329: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   332: bipush 44
      //   334: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   337: new 172	java/lang/StringBuilder
      //   340: dup
      //   341: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   344: ldc -68
      //   346: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   349: iload 7
      //   351: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   354: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   357: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   360: bipush 44
      //   362: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   365: new 172	java/lang/StringBuilder
      //   368: dup
      //   369: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   372: ldc -68
      //   374: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   377: iload 9
      //   379: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   382: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   385: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   388: bipush 44
      //   390: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   393: new 172	java/lang/StringBuilder
      //   396: dup
      //   397: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   400: ldc -68
      //   402: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   405: iload_2
      //   406: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   409: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   412: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   415: bipush 44
      //   417: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   420: new 172	java/lang/StringBuilder
      //   423: dup
      //   424: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   427: ldc -68
      //   429: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   432: iload 5
      //   434: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   437: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   440: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   443: bipush 44
      //   445: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   448: new 172	java/lang/StringBuilder
      //   451: dup
      //   452: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   455: ldc -68
      //   457: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   460: invokestatic 194	java/lang/System:currentTimeMillis	()J
      //   463: ldc2_w 195
      //   466: ldiv
      //   467: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   470: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   473: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   476: bipush 44
      //   478: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   481: ldc -55
      //   483: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   486: bipush 41
      //   488: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   491: pop
      //   492: iload 4
      //   494: iconst_1
      //   495: iadd
      //   496: istore 7
      //   498: iload 7
      //   500: istore 4
      //   502: iload 7
      //   504: bipush 10
      //   506: if_icmplt +45 -> 551
      //   509: aload_0
      //   510: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   513: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   516: ldc -53
      //   518: iconst_1
      //   519: anewarray 205	java/lang/Object
      //   522: dup
      //   523: iconst_0
      //   524: aload 13
      //   526: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   529: aastore
      //   530: invokestatic 209	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   533: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   536: iconst_1
      //   537: istore_3
      //   538: aload 13
      //   540: iconst_0
      //   541: invokevirtual 213	java/lang/StringBuffer:setLength	(I)V
      //   544: iload 7
      //   546: bipush 10
      //   548: isub
      //   549: istore 4
      //   551: iload 6
      //   553: iconst_1
      //   554: iadd
      //   555: istore 6
      //   557: goto -321 -> 236
      //   560: astore 11
      //   562: aload 11
      //   564: invokevirtual 216	org/json/JSONException:printStackTrace	()V
      //   567: aconst_null
      //   568: astore 11
      //   570: goto -542 -> 28
      //   573: astore 11
      //   575: aload 11
      //   577: invokevirtual 216	org/json/JSONException:printStackTrace	()V
      //   580: aconst_null
      //   581: astore 11
      //   583: goto -531 -> 52
      //   586: astore 12
      //   588: iconst_0
      //   589: istore_2
      //   590: goto -497 -> 93
      //   593: aload 13
      //   595: bipush 44
      //   597: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   600: pop
      //   601: goto -314 -> 287
      //   604: astore 11
      //   606: iconst_0
      //   607: istore_2
      //   608: aload_0
      //   609: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   612: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   615: ifnull +26 -> 641
      //   618: aload_0
      //   619: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   622: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   625: invokevirtual 220	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   628: ifeq +13 -> 641
      //   631: aload_0
      //   632: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   635: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   638: invokevirtual 223	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   641: aload_0
      //   642: aconst_null
      //   643: putfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   646: aload_0
      //   647: aload_0
      //   648: getfield 24	com/baidu/location/c/b$e:c	I
      //   651: iconst_1
      //   652: iadd
      //   653: putfield 24	com/baidu/location/c/b$e:c	I
      //   656: aload_0
      //   657: aconst_null
      //   658: putfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   661: aload_0
      //   662: getfield 31	com/baidu/location/c/b$e:k	Ljava/util/Map;
      //   665: invokeinterface 226 1 0
      //   670: aload_0
      //   671: getfield 24	com/baidu/location/c/b$e:c	I
      //   674: iconst_3
      //   675: irem
      //   676: iconst_1
      //   677: if_icmpne +6 -> 683
      //   680: invokestatic 229	java/lang/System:gc	()V
      //   683: aload_0
      //   684: iconst_0
      //   685: putfield 22	com/baidu/location/c/b$e:a	Z
      //   688: iload_2
      //   689: ifeq +34 -> 723
      //   692: aload_0
      //   693: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   696: invokestatic 232	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   699: ifnull +24 -> 723
      //   702: invokestatic 237	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
      //   705: invokevirtual 239	com/baidu/location/a/a:c	()Z
      //   708: ifeq +15 -> 723
      //   711: aload_0
      //   712: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   715: invokestatic 232	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   718: iconst_1
      //   719: invokevirtual 245	android/os/Handler:sendEmptyMessage	(I)Z
      //   722: pop
      //   723: return
      //   724: iload 4
      //   726: ifle +30 -> 756
      //   729: aload_0
      //   730: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   733: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   736: ldc -53
      //   738: iconst_1
      //   739: anewarray 205	java/lang/Object
      //   742: dup
      //   743: iconst_0
      //   744: aload 13
      //   746: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   749: aastore
      //   750: invokestatic 209	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   753: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   756: aload 11
      //   758: ifnull +1156 -> 1914
      //   761: aload 11
      //   763: ldc -9
      //   765: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   768: ifeq +1146 -> 1914
      //   771: aload 11
      //   773: ldc -9
      //   775: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   778: ldc -119
      //   780: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   783: ifeq +1131 -> 1914
      //   786: aload 11
      //   788: ldc -9
      //   790: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   793: ldc -119
      //   795: invokevirtual 141	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   798: istore 5
      //   800: iload 5
      //   802: ifle +501 -> 1303
      //   805: aload 11
      //   807: ifnull +496 -> 1303
      //   810: aload 11
      //   812: ldc -9
      //   814: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   817: ifeq +486 -> 1303
      //   820: aload 11
      //   822: ldc -9
      //   824: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   827: ldc -114
      //   829: invokevirtual 105	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   832: ifeq +471 -> 1303
      //   835: aload_0
      //   836: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   839: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   842: astore 12
      //   844: aload 12
      //   846: ifnull +15 -> 861
      //   849: aload_0
      //   850: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   853: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   856: ldc -7
      //   858: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   861: aload 11
      //   863: ldc -9
      //   865: invokevirtual 109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   868: ldc -114
      //   870: invokevirtual 151	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   873: astore 11
      //   875: aload 11
      //   877: invokevirtual 156	org/json/JSONArray:length	()I
      //   880: istore 8
      //   882: new 41	java/lang/StringBuffer
      //   885: dup
      //   886: invokespecial 42	java/lang/StringBuffer:<init>	()V
      //   889: astore 12
      //   891: iconst_0
      //   892: istore 4
      //   894: iconst_1
      //   895: istore_3
      //   896: iconst_0
      //   897: istore 6
      //   899: iload 6
      //   901: iload 8
      //   903: if_icmpge +368 -> 1271
      //   906: aload 11
      //   908: iload 6
      //   910: invokevirtual 159	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   913: ldc -95
      //   915: invokevirtual 167	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   918: astore 13
      //   920: aload 13
      //   922: iconst_0
      //   923: aaload
      //   924: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   927: invokevirtual 133	java/lang/Integer:intValue	()I
      //   930: istore 7
      //   932: aload 13
      //   934: iconst_1
      //   935: aaload
      //   936: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   939: invokevirtual 133	java/lang/Integer:intValue	()I
      //   942: istore 9
      //   944: iload_3
      //   945: ifeq +272 -> 1217
      //   948: iconst_0
      //   949: istore_3
      //   950: aload 12
      //   952: bipush 40
      //   954: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   957: new 172	java/lang/StringBuilder
      //   960: dup
      //   961: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   964: ldc -5
      //   966: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   969: iload 7
      //   971: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   974: ldc -73
      //   976: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   979: iload 9
      //   981: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   984: ldc -71
      //   986: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   989: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   992: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   995: bipush 44
      //   997: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1000: new 172	java/lang/StringBuilder
      //   1003: dup
      //   1004: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   1007: ldc -68
      //   1009: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1012: iload 7
      //   1014: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1017: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1020: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1023: bipush 44
      //   1025: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1028: new 172	java/lang/StringBuilder
      //   1031: dup
      //   1032: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   1035: ldc -68
      //   1037: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1040: iload 9
      //   1042: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1045: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1048: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1051: bipush 44
      //   1053: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1056: new 172	java/lang/StringBuilder
      //   1059: dup
      //   1060: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   1063: ldc -68
      //   1065: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1068: iload_2
      //   1069: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1072: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1075: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1078: bipush 44
      //   1080: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1083: new 172	java/lang/StringBuilder
      //   1086: dup
      //   1087: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   1090: ldc -68
      //   1092: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1095: iload 5
      //   1097: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1100: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1103: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1106: bipush 44
      //   1108: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1111: new 172	java/lang/StringBuilder
      //   1114: dup
      //   1115: invokespecial 173	java/lang/StringBuilder:<init>	()V
      //   1118: ldc -68
      //   1120: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1123: invokestatic 194	java/lang/System:currentTimeMillis	()J
      //   1126: ldc2_w 195
      //   1129: ldiv
      //   1130: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1133: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1136: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1139: bipush 44
      //   1141: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1144: ldc -55
      //   1146: invokevirtual 48	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   1149: bipush 41
      //   1151: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1154: pop
      //   1155: iload 4
      //   1157: iconst_1
      //   1158: iadd
      //   1159: istore 7
      //   1161: iload 7
      //   1163: istore 4
      //   1165: iload 7
      //   1167: bipush 10
      //   1169: if_icmplt +767 -> 1936
      //   1172: aload_0
      //   1173: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1176: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1179: ldc -3
      //   1181: iconst_1
      //   1182: anewarray 205	java/lang/Object
      //   1185: dup
      //   1186: iconst_0
      //   1187: aload 12
      //   1189: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   1192: aastore
      //   1193: invokestatic 209	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1196: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1199: iconst_1
      //   1200: istore_3
      //   1201: aload 12
      //   1203: iconst_0
      //   1204: invokevirtual 213	java/lang/StringBuffer:setLength	(I)V
      //   1207: iload 7
      //   1209: bipush 10
      //   1211: isub
      //   1212: istore 4
      //   1214: goto +722 -> 1936
      //   1217: aload 12
      //   1219: bipush 44
      //   1221: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   1224: pop
      //   1225: goto -275 -> 950
      //   1228: astore 11
      //   1230: aload_0
      //   1231: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1234: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1237: ifnull +26 -> 1263
      //   1240: aload_0
      //   1241: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1244: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1247: invokevirtual 220	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   1250: ifeq +13 -> 1263
      //   1253: aload_0
      //   1254: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1257: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1260: invokevirtual 223	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   1263: aload_0
      //   1264: aconst_null
      //   1265: putfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   1268: aload 11
      //   1270: athrow
      //   1271: iload 4
      //   1273: ifle +30 -> 1303
      //   1276: aload_0
      //   1277: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1280: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1283: ldc -3
      //   1285: iconst_1
      //   1286: anewarray 205	java/lang/Object
      //   1289: dup
      //   1290: iconst_0
      //   1291: aload 12
      //   1293: invokevirtual 68	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   1296: aastore
      //   1297: invokestatic 209	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1300: invokevirtual 147	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1303: aload_0
      //   1304: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1307: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1310: ifnull +13 -> 1323
      //   1313: aload_0
      //   1314: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1317: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1320: invokevirtual 256	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   1323: aload_0
      //   1324: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1327: getfield 259	com/baidu/location/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
      //   1330: invokevirtual 262	java/util/concurrent/ConcurrentHashMap:clear	()V
      //   1333: aload_0
      //   1334: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1337: getfield 264	com/baidu/location/c/b:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   1340: invokevirtual 262	java/util/concurrent/ConcurrentHashMap:clear	()V
      //   1343: iconst_2
      //   1344: anewarray 163	java/lang/String
      //   1347: astore 13
      //   1349: aload 13
      //   1351: iconst_0
      //   1352: ldc_w 266
      //   1355: aastore
      //   1356: aload 13
      //   1358: iconst_1
      //   1359: ldc_w 268
      //   1362: aastore
      //   1363: aload 13
      //   1365: arraylength
      //   1366: istore 5
      //   1368: iconst_0
      //   1369: istore 4
      //   1371: iconst_0
      //   1372: istore_2
      //   1373: aconst_null
      //   1374: astore 11
      //   1376: iload 4
      //   1378: iload 5
      //   1380: if_icmpge +430 -> 1810
      //   1383: aload 13
      //   1385: iload 4
      //   1387: aaload
      //   1388: astore 14
      //   1390: aload_0
      //   1391: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1394: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1397: ifnull +509 -> 1906
      //   1400: aload_0
      //   1401: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1404: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1407: aload 14
      //   1409: aconst_null
      //   1410: invokevirtual 272	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   1413: astore 12
      //   1415: aload 12
      //   1417: astore 11
      //   1419: aload 11
      //   1421: ifnull +316 -> 1737
      //   1424: aload 11
      //   1426: invokeinterface 277 1 0
      //   1431: istore_1
      //   1432: iload_1
      //   1433: ifeq +304 -> 1737
      //   1436: iconst_1
      //   1437: istore_2
      //   1438: aload 11
      //   1440: invokeinterface 280 1 0
      //   1445: ifne +464 -> 1909
      //   1448: aload 11
      //   1450: aload 11
      //   1452: ldc_w 282
      //   1455: invokeinterface 285 2 0
      //   1460: invokeinterface 286 2 0
      //   1465: astore 12
      //   1467: aload 11
      //   1469: aload 11
      //   1471: ldc_w 288
      //   1474: invokeinterface 285 2 0
      //   1479: invokeinterface 291 2 0
      //   1484: istore_3
      //   1485: aload 11
      //   1487: aload 11
      //   1489: ldc_w 293
      //   1492: invokeinterface 285 2 0
      //   1497: invokeinterface 291 2 0
      //   1502: istore 6
      //   1504: aload 11
      //   1506: aload 11
      //   1508: ldc_w 295
      //   1511: invokeinterface 285 2 0
      //   1516: invokeinterface 291 2 0
      //   1521: istore 7
      //   1523: aload 11
      //   1525: aload 11
      //   1527: ldc_w 296
      //   1530: invokeinterface 285 2 0
      //   1535: invokeinterface 291 2 0
      //   1540: istore 8
      //   1542: aload 11
      //   1544: aload 11
      //   1546: ldc_w 298
      //   1549: invokeinterface 285 2 0
      //   1554: invokeinterface 291 2 0
      //   1559: istore 9
      //   1561: aload 11
      //   1563: aload 11
      //   1565: ldc_w 299
      //   1568: invokeinterface 285 2 0
      //   1573: invokeinterface 291 2 0
      //   1578: istore 10
      //   1580: new 301	com/baidu/location/c/b$c
      //   1583: dup
      //   1584: aload_0
      //   1585: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1588: aload 12
      //   1590: iload_3
      //   1591: iload 6
      //   1593: iload 7
      //   1595: iload 8
      //   1597: iload 9
      //   1599: iload 10
      //   1601: invokespecial 304	com/baidu/location/c/b$c:<init>	(Lcom/baidu/location/c/b;Ljava/lang/String;IIIIII)V
      //   1604: astore 12
      //   1606: aload 14
      //   1608: ldc_w 266
      //   1611: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1614: ifeq +80 -> 1694
      //   1617: aload_0
      //   1618: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1621: getfield 259	com/baidu/location/c/b:c	Ljava/util/concurrent/ConcurrentHashMap;
      //   1624: aload 12
      //   1626: getfield 310	com/baidu/location/c/b$c:c	Ljava/lang/String;
      //   1629: aload 12
      //   1631: invokevirtual 311	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1634: pop
      //   1635: aload 11
      //   1637: invokeinterface 314 1 0
      //   1642: pop
      //   1643: goto -205 -> 1438
      //   1646: astore 12
      //   1648: iconst_1
      //   1649: istore_2
      //   1650: aload 12
      //   1652: invokevirtual 315	java/lang/Exception:printStackTrace	()V
      //   1655: aload 11
      //   1657: astore 12
      //   1659: iload_2
      //   1660: istore_3
      //   1661: aload 11
      //   1663: ifnull +16 -> 1679
      //   1666: aload 11
      //   1668: invokeinterface 318 1 0
      //   1673: iload_2
      //   1674: istore_3
      //   1675: aload 11
      //   1677: astore 12
      //   1679: iload 4
      //   1681: iconst_1
      //   1682: iadd
      //   1683: istore 4
      //   1685: aload 12
      //   1687: astore 11
      //   1689: iload_3
      //   1690: istore_2
      //   1691: goto -315 -> 1376
      //   1694: aload_0
      //   1695: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1698: getfield 264	com/baidu/location/c/b:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   1701: aload 12
      //   1703: getfield 310	com/baidu/location/c/b$c:c	Ljava/lang/String;
      //   1706: aload 12
      //   1708: invokevirtual 311	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1711: pop
      //   1712: goto -77 -> 1635
      //   1715: astore 12
      //   1717: aload 11
      //   1719: ifnull +10 -> 1729
      //   1722: aload 11
      //   1724: invokeinterface 318 1 0
      //   1729: aload 12
      //   1731: athrow
      //   1732: astore 11
      //   1734: goto -1126 -> 608
      //   1737: aload 11
      //   1739: astore 12
      //   1741: iload_2
      //   1742: istore_3
      //   1743: aload 11
      //   1745: ifnull -66 -> 1679
      //   1748: aload 11
      //   1750: invokeinterface 318 1 0
      //   1755: aload 11
      //   1757: astore 12
      //   1759: iload_2
      //   1760: istore_3
      //   1761: goto -82 -> 1679
      //   1764: astore 12
      //   1766: iload_2
      //   1767: istore_3
      //   1768: aload 12
      //   1770: invokevirtual 315	java/lang/Exception:printStackTrace	()V
      //   1773: aload 11
      //   1775: astore 12
      //   1777: iload_2
      //   1778: istore_3
      //   1779: goto -100 -> 1679
      //   1782: astore 12
      //   1784: iload_2
      //   1785: istore_3
      //   1786: aload 12
      //   1788: invokevirtual 315	java/lang/Exception:printStackTrace	()V
      //   1791: aload 11
      //   1793: astore 12
      //   1795: iload_2
      //   1796: istore_3
      //   1797: goto -118 -> 1679
      //   1800: astore 11
      //   1802: aload 11
      //   1804: invokevirtual 315	java/lang/Exception:printStackTrace	()V
      //   1807: goto -78 -> 1729
      //   1810: aload_0
      //   1811: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1814: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1817: ifnull +26 -> 1843
      //   1820: aload_0
      //   1821: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1824: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1827: invokevirtual 220	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   1830: ifeq +13 -> 1843
      //   1833: aload_0
      //   1834: getfield 17	com/baidu/location/c/b$e:b	Lcom/baidu/location/c/b;
      //   1837: invokestatic 113	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1840: invokevirtual 223	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   1843: aload_0
      //   1844: aconst_null
      //   1845: putfield 94	com/baidu/location/c/b$e:j	Ljava/lang/String;
      //   1848: goto -1202 -> 646
      //   1851: astore 12
      //   1853: goto -590 -> 1263
      //   1856: astore 11
      //   1858: goto -1217 -> 641
      //   1861: astore 11
      //   1863: goto -20 -> 1843
      //   1866: astore 12
      //   1868: goto -151 -> 1717
      //   1871: astore 12
      //   1873: goto -156 -> 1717
      //   1876: astore 12
      //   1878: goto -161 -> 1717
      //   1881: astore 12
      //   1883: goto -233 -> 1650
      //   1886: astore 12
      //   1888: goto -238 -> 1650
      //   1891: astore 12
      //   1893: goto -1032 -> 861
      //   1896: astore 12
      //   1898: goto -1700 -> 198
      //   1901: astore 12
      //   1903: goto -1841 -> 62
      //   1906: goto -169 -> 1737
      //   1909: iconst_1
      //   1910: istore_2
      //   1911: goto -174 -> 1737
      //   1914: iconst_0
      //   1915: istore 5
      //   1917: goto -1117 -> 800
      //   1920: iconst_0
      //   1921: istore 5
      //   1923: goto -1786 -> 137
      //   1926: iconst_0
      //   1927: istore_2
      //   1928: goto -1835 -> 93
      //   1931: iconst_0
      //   1932: istore_2
      //   1933: goto -1287 -> 646
      //   1936: iload 6
      //   1938: iconst_1
      //   1939: iadd
      //   1940: istore 6
      //   1942: goto -1043 -> 899
      //   1945: astore 11
      //   1947: iload_3
      //   1948: istore_2
      //   1949: goto -1341 -> 608
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1952	0	this	e
      //   0	1952	1	paramBoolean	boolean
      //   92	1857	2	i	int
      //   232	1716	3	j	int
      //   229	1455	4	k	int
      //   135	1787	5	m	int
      //   234	1707	6	n	int
      //   267	1327	7	i1	int
      //   217	1379	8	i2	int
      //   279	1319	9	i3	int
      //   1578	22	10	i4	int
      //   15	184	11	localObject1	Object
      //   560	3	11	localJSONException1	org.json.JSONException
      //   568	1	11	localObject2	Object
      //   573	3	11	localJSONException2	org.json.JSONException
      //   581	1	11	localObject3	Object
      //   604	258	11	localException1	Exception
      //   873	34	11	localJSONArray	org.json.JSONArray
      //   1228	41	11	localObject4	Object
      //   1374	349	11	localObject5	Object
      //   1732	60	11	localException2	Exception
      //   1800	3	11	localException3	Exception
      //   1856	1	11	localException4	Exception
      //   1861	1	11	localException5	Exception
      //   1945	1	11	localException6	Exception
      //   179	65	12	localObject6	Object
      //   586	1	12	localException7	Exception
      //   842	788	12	localObject7	Object
      //   1646	5	12	localException8	Exception
      //   1657	50	12	localObject8	Object
      //   1715	15	12	localObject9	Object
      //   1739	19	12	localException9	Exception
      //   1764	5	12	localException10	Exception
      //   1775	1	12	localException11	Exception
      //   1782	5	12	localException12	Exception
      //   1793	1	12	localException13	Exception
      //   1851	1	12	localException14	Exception
      //   1866	1	12	localObject10	Object
      //   1871	1	12	localObject11	Object
      //   1876	1	12	localObject12	Object
      //   1881	1	12	localException15	Exception
      //   1886	1	12	localException16	Exception
      //   1891	1	12	localException17	Exception
      //   1896	1	12	localException18	Exception
      //   1901	1	12	localException19	Exception
      //   226	1158	13	localObject13	Object
      //   255	1352	14	arrayOfString	String[]
      // Exception table:
      //   from	to	target	type
      //   17	28	560	org/json/JSONException
      //   43	52	573	org/json/JSONException
      //   79	93	586	java/lang/Exception
      //   67	75	604	java/lang/Exception
      //   98	137	604	java/lang/Exception
      //   147	181	604	java/lang/Exception
      //   198	228	604	java/lang/Exception
      //   243	281	604	java/lang/Exception
      //   287	492	604	java/lang/Exception
      //   509	536	604	java/lang/Exception
      //   538	544	604	java/lang/Exception
      //   593	601	604	java/lang/Exception
      //   729	756	604	java/lang/Exception
      //   761	800	604	java/lang/Exception
      //   810	844	604	java/lang/Exception
      //   861	891	604	java/lang/Exception
      //   906	944	604	java/lang/Exception
      //   950	1155	604	java/lang/Exception
      //   1172	1199	604	java/lang/Exception
      //   1201	1207	604	java/lang/Exception
      //   1217	1225	604	java/lang/Exception
      //   1276	1303	604	java/lang/Exception
      //   1303	1323	604	java/lang/Exception
      //   1323	1349	604	java/lang/Exception
      //   1363	1368	604	java/lang/Exception
      //   52	62	1228	finally
      //   67	75	1228	finally
      //   79	93	1228	finally
      //   98	137	1228	finally
      //   147	181	1228	finally
      //   186	198	1228	finally
      //   198	228	1228	finally
      //   243	281	1228	finally
      //   287	492	1228	finally
      //   509	536	1228	finally
      //   538	544	1228	finally
      //   593	601	1228	finally
      //   729	756	1228	finally
      //   761	800	1228	finally
      //   810	844	1228	finally
      //   849	861	1228	finally
      //   861	891	1228	finally
      //   906	944	1228	finally
      //   950	1155	1228	finally
      //   1172	1199	1228	finally
      //   1201	1207	1228	finally
      //   1217	1225	1228	finally
      //   1276	1303	1228	finally
      //   1303	1323	1228	finally
      //   1323	1349	1228	finally
      //   1363	1368	1228	finally
      //   1666	1673	1228	finally
      //   1722	1729	1228	finally
      //   1729	1732	1228	finally
      //   1748	1755	1228	finally
      //   1768	1773	1228	finally
      //   1786	1791	1228	finally
      //   1802	1807	1228	finally
      //   1438	1635	1646	java/lang/Exception
      //   1635	1643	1646	java/lang/Exception
      //   1694	1712	1646	java/lang/Exception
      //   1438	1635	1715	finally
      //   1635	1643	1715	finally
      //   1694	1712	1715	finally
      //   1729	1732	1732	java/lang/Exception
      //   1802	1807	1732	java/lang/Exception
      //   1748	1755	1764	java/lang/Exception
      //   1666	1673	1782	java/lang/Exception
      //   1722	1729	1800	java/lang/Exception
      //   1230	1263	1851	java/lang/Exception
      //   608	641	1856	java/lang/Exception
      //   1810	1843	1861	java/lang/Exception
      //   1424	1432	1866	finally
      //   1650	1655	1871	finally
      //   1390	1415	1876	finally
      //   1424	1432	1881	java/lang/Exception
      //   1390	1415	1886	java/lang/Exception
      //   849	861	1891	java/lang/Exception
      //   186	198	1896	java/lang/Exception
      //   52	62	1901	java/lang/Exception
      //   1768	1773	1945	java/lang/Exception
      //   1786	1791	1945	java/lang/Exception
    }
    
    public void b()
    {
      if (b.a(b.this) == null) {}
      while (this.a) {
        return;
      }
      this.a = true;
      a(false, "ofloc.map.baidu.com");
    }
  }
  
  private final class f
    extends com.baidu.location.h.e
  {
    public boolean a = false;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int p = 0;
    private boolean q = false;
    
    public f()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = b.c(b.this);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&qt=grid");
      ((StringBuffer)localObject).append("&tp=gdg");
      ((StringBuffer)localObject).append("&ct=");
      ((StringBuffer)localObject).append(b.a(b.this));
      ((StringBuffer)localObject).append(com.baidu.location.h.b.a().g());
      ((StringBuffer)localObject).append("&apg=");
      ((StringBuffer)localObject).append(String.format(Locale.US, "%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
      ((StringBuffer)localObject).append("&vkey=0");
      localObject = ((StringBuffer)localObject).toString();
      this.k.put("qt", "grid");
      this.k.put("req", Jni.encode((String)localObject));
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (b.a(b.this) == null) {}
      while ((this.a) || (this.q)) {
        return;
      }
      this.a = true;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.p = paramInt4;
      a(false, "ofloc.map.baidu.com");
    }
    
    /* Error */
    public void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 11
      //   3: iconst_0
      //   4: istore_2
      //   5: iload_1
      //   6: ifeq +1180 -> 1186
      //   9: aload_0
      //   10: getfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   13: ifnull +1173 -> 1186
      //   16: aload_0
      //   17: getfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   20: astore 10
      //   22: new 140	org/json/JSONObject
      //   25: dup
      //   26: aload 10
      //   28: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   31: astore 10
      //   33: aload 10
      //   35: ifnull +545 -> 580
      //   38: aload 10
      //   40: ldc -111
      //   42: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   45: ifeq +535 -> 580
      //   48: aload 10
      //   50: ldc -111
      //   52: invokevirtual 153	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   55: astore 10
      //   57: iconst_0
      //   58: ifne +37 -> 95
      //   61: getstatic 85	java/util/Locale:US	Ljava/util/Locale;
      //   64: ldc -101
      //   66: iconst_2
      //   67: anewarray 89	java/lang/Object
      //   70: dup
      //   71: iconst_0
      //   72: aload_0
      //   73: getfield 28	com/baidu/location/c/b$f:c	I
      //   76: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   79: aastore
      //   80: dup
      //   81: iconst_1
      //   82: aload_0
      //   83: getfield 30	com/baidu/location/c/b$f:d	I
      //   86: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: aastore
      //   90: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   93: astore 11
      //   95: aload_0
      //   96: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   99: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   102: invokevirtual 163	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   105: iload_2
      //   106: istore 5
      //   108: aload 10
      //   110: ifnull +27 -> 137
      //   113: aload 10
      //   115: ldc -91
      //   117: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   120: istore_1
      //   121: iload_2
      //   122: istore 5
      //   124: iload_1
      //   125: ifeq +12 -> 137
      //   128: aload 10
      //   130: ldc -91
      //   132: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   135: istore 5
      //   137: iconst_0
      //   138: istore_2
      //   139: iload_2
      //   140: istore 6
      //   142: aload 10
      //   144: ifnull +25 -> 169
      //   147: iload_2
      //   148: istore 6
      //   150: aload 10
      //   152: ldc -85
      //   154: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   157: ifeq +12 -> 169
      //   160: aload 10
      //   162: ldc -85
      //   164: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   167: istore 6
      //   169: iload 6
      //   171: ifeq +17 -> 188
      //   174: iload 6
      //   176: aload_0
      //   177: getfield 36	com/baidu/location/c/b$f:p	I
      //   180: if_icmpeq +8 -> 188
      //   183: aload_0
      //   184: iconst_1
      //   185: putfield 38	com/baidu/location/c/b$f:q	Z
      //   188: iload 6
      //   190: ifle +788 -> 978
      //   193: aload_0
      //   194: getfield 38	com/baidu/location/c/b$f:q	Z
      //   197: ifne +781 -> 978
      //   200: aload 10
      //   202: ifnull +776 -> 978
      //   205: aload 10
      //   207: ldc -83
      //   209: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   212: ifeq +766 -> 978
      //   215: new 175	java/lang/StringBuilder
      //   218: dup
      //   219: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   222: ldc -78
      //   224: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   227: aload 11
      //   229: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: ldc -73
      //   234: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: astore 12
      //   242: new 175	java/lang/StringBuilder
      //   245: dup
      //   246: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   249: ldc -70
      //   251: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: aload 11
      //   256: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: ldc -68
      //   261: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   267: astore 13
      //   269: aload_0
      //   270: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   273: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   276: astore 14
      //   278: aload 14
      //   280: ifnull +27 -> 307
      //   283: aload_0
      //   284: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   287: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   290: aload 12
      //   292: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   295: aload_0
      //   296: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   299: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   302: aload 13
      //   304: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   307: aload 10
      //   309: ldc -83
      //   311: invokevirtual 194	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   314: ldc -68
      //   316: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   319: astore 12
      //   321: new 55	java/lang/StringBuffer
      //   324: dup
      //   325: invokespecial 56	java/lang/StringBuffer:<init>	()V
      //   328: astore 13
      //   330: new 175	java/lang/StringBuilder
      //   333: dup
      //   334: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   337: ldc -56
      //   339: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   342: aload 11
      //   344: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   347: ldc -54
      //   349: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   355: astore 14
      //   357: aload 12
      //   359: arraylength
      //   360: istore 9
      //   362: iconst_0
      //   363: istore 8
      //   365: iconst_1
      //   366: istore 4
      //   368: iconst_0
      //   369: istore 7
      //   371: iload 7
      //   373: iload 9
      //   375: if_icmpge +345 -> 720
      //   378: aload 12
      //   380: iload 7
      //   382: aaload
      //   383: astore 15
      //   385: iload 8
      //   387: istore_2
      //   388: iload 4
      //   390: istore_3
      //   391: aload 15
      //   393: ldc -52
      //   395: invokevirtual 208	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   398: ifeq +147 -> 545
      //   401: aload 15
      //   403: ldc -46
      //   405: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   408: astore 16
      //   410: iload 8
      //   412: istore_2
      //   413: iload 4
      //   415: istore_3
      //   416: aload 16
      //   418: arraylength
      //   419: iconst_2
      //   420: if_icmpne +125 -> 545
      //   423: aload 16
      //   425: iconst_0
      //   426: aaload
      //   427: astore 15
      //   429: aload 16
      //   431: iconst_1
      //   432: aaload
      //   433: astore 16
      //   435: iload 4
      //   437: ifeq +149 -> 586
      //   440: iconst_0
      //   441: istore_3
      //   442: aload 13
      //   444: bipush 40
      //   446: invokevirtual 213	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   449: aload 15
      //   451: invokevirtual 62	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   454: bipush 44
      //   456: invokevirtual 213	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   459: new 175	java/lang/StringBuilder
      //   462: dup
      //   463: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   466: ldc -41
      //   468: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   471: aload 16
      //   473: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   476: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   479: invokevirtual 62	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   482: bipush 41
      //   484: invokevirtual 213	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   487: pop
      //   488: iload 8
      //   490: iconst_1
      //   491: iadd
      //   492: istore 4
      //   494: iload 4
      //   496: istore_2
      //   497: iload 4
      //   499: bipush 100
      //   501: if_icmplt +44 -> 545
      //   504: aload_0
      //   505: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   508: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   511: aload 14
      //   513: iconst_1
      //   514: anewarray 89	java/lang/Object
      //   517: dup
      //   518: iconst_0
      //   519: aload 13
      //   521: invokevirtual 106	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   524: aastore
      //   525: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   528: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   531: iconst_1
      //   532: istore_3
      //   533: aload 13
      //   535: iconst_0
      //   536: invokevirtual 222	java/lang/StringBuffer:setLength	(I)V
      //   539: iload 4
      //   541: bipush 100
      //   543: isub
      //   544: istore_2
      //   545: iload 7
      //   547: iconst_1
      //   548: iadd
      //   549: istore 7
      //   551: iload_2
      //   552: istore 8
      //   554: iload_3
      //   555: istore 4
      //   557: goto -186 -> 371
      //   560: astore 10
      //   562: aload 10
      //   564: invokevirtual 225	org/json/JSONException:printStackTrace	()V
      //   567: aconst_null
      //   568: astore 10
      //   570: goto -537 -> 33
      //   573: astore 10
      //   575: aload 10
      //   577: invokevirtual 225	org/json/JSONException:printStackTrace	()V
      //   580: aconst_null
      //   581: astore 10
      //   583: goto -526 -> 57
      //   586: aload 13
      //   588: bipush 44
      //   590: invokevirtual 213	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   593: pop
      //   594: iload 4
      //   596: istore_3
      //   597: goto -155 -> 442
      //   600: astore 10
      //   602: iconst_0
      //   603: istore_2
      //   604: aload_0
      //   605: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   608: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   611: ifnull +26 -> 637
      //   614: aload_0
      //   615: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   618: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   621: invokevirtual 229	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   624: ifeq +13 -> 637
      //   627: aload_0
      //   628: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   631: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   634: invokevirtual 232	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   637: aload_0
      //   638: aconst_null
      //   639: putfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   642: aload_0
      //   643: aload_0
      //   644: getfield 34	com/baidu/location/c/b$f:f	I
      //   647: iconst_1
      //   648: iadd
      //   649: putfield 34	com/baidu/location/c/b$f:f	I
      //   652: aload_0
      //   653: aconst_null
      //   654: putfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   657: aload_0
      //   658: getfield 45	com/baidu/location/c/b$f:k	Ljava/util/Map;
      //   661: invokeinterface 235 1 0
      //   666: aload_0
      //   667: getfield 34	com/baidu/location/c/b$f:f	I
      //   670: iconst_3
      //   671: irem
      //   672: iconst_1
      //   673: if_icmpne +6 -> 679
      //   676: invokestatic 240	java/lang/System:gc	()V
      //   679: aload_0
      //   680: iconst_0
      //   681: putfield 26	com/baidu/location/c/b$f:a	Z
      //   684: iload_2
      //   685: ifeq +34 -> 719
      //   688: aload_0
      //   689: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   692: invokestatic 243	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   695: ifnull +24 -> 719
      //   698: invokestatic 248	com/baidu/location/a/a:a	()Lcom/baidu/location/a/a;
      //   701: invokevirtual 250	com/baidu/location/a/a:c	()Z
      //   704: ifeq +15 -> 719
      //   707: aload_0
      //   708: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   711: invokestatic 243	com/baidu/location/c/b:e	(Lcom/baidu/location/c/b;)Landroid/os/Handler;
      //   714: iconst_1
      //   715: invokevirtual 256	android/os/Handler:sendEmptyMessage	(I)Z
      //   718: pop
      //   719: return
      //   720: iload 8
      //   722: ifle +30 -> 752
      //   725: aload_0
      //   726: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   729: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   732: aload 14
      //   734: iconst_1
      //   735: anewarray 89	java/lang/Object
      //   738: dup
      //   739: iconst_0
      //   740: aload 13
      //   742: invokevirtual 106	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   745: aastore
      //   746: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   749: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   752: aload_0
      //   753: getfield 38	com/baidu/location/c/b$f:q	Z
      //   756: ifne +425 -> 1181
      //   759: aload 10
      //   761: ifnull +420 -> 1181
      //   764: getstatic 85	java/util/Locale:US	Ljava/util/Locale;
      //   767: ldc_w 258
      //   770: bipush 7
      //   772: anewarray 89	java/lang/Object
      //   775: dup
      //   776: iconst_0
      //   777: aload 11
      //   779: aastore
      //   780: dup
      //   781: iconst_1
      //   782: aload_0
      //   783: getfield 28	com/baidu/location/c/b$f:c	I
      //   786: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   789: aastore
      //   790: dup
      //   791: iconst_2
      //   792: aload_0
      //   793: getfield 30	com/baidu/location/c/b$f:d	I
      //   796: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   799: aastore
      //   800: dup
      //   801: iconst_3
      //   802: iload 5
      //   804: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   807: aastore
      //   808: dup
      //   809: iconst_4
      //   810: iload 6
      //   812: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   815: aastore
      //   816: dup
      //   817: iconst_5
      //   818: invokestatic 262	java/lang/System:currentTimeMillis	()J
      //   821: ldc2_w 263
      //   824: ldiv
      //   825: l2i
      //   826: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   829: aastore
      //   830: dup
      //   831: bipush 6
      //   833: aload_0
      //   834: getfield 32	com/baidu/location/c/b$f:e	I
      //   837: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   840: aastore
      //   841: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   844: astore 10
      //   846: new 266	com/baidu/location/c/b$c
      //   849: dup
      //   850: aload_0
      //   851: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   854: aload 11
      //   856: aload_0
      //   857: getfield 28	com/baidu/location/c/b$f:c	I
      //   860: aload_0
      //   861: getfield 30	com/baidu/location/c/b$f:d	I
      //   864: iload 5
      //   866: iload 6
      //   868: invokestatic 262	java/lang/System:currentTimeMillis	()J
      //   871: ldc2_w 263
      //   874: ldiv
      //   875: l2i
      //   876: aload_0
      //   877: getfield 32	com/baidu/location/c/b$f:e	I
      //   880: invokespecial 269	com/baidu/location/c/b$c:<init>	(Lcom/baidu/location/c/b;Ljava/lang/String;IIIIII)V
      //   883: astore 11
      //   885: aload_0
      //   886: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   889: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   892: aload 10
      //   894: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   897: aload_0
      //   898: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   901: getfield 272	com/baidu/location/c/b:a	Ljava/util/concurrent/ConcurrentHashMap;
      //   904: aload 11
      //   906: getfield 274	com/baidu/location/c/b$c:c	Ljava/lang/String;
      //   909: aload 11
      //   911: invokevirtual 277	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   914: pop
      //   915: iconst_1
      //   916: istore_2
      //   917: aload_0
      //   918: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   921: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   924: ifnull +13 -> 937
      //   927: aload_0
      //   928: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   931: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   934: invokevirtual 280	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   937: aload_0
      //   938: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   941: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   944: ifnull +26 -> 970
      //   947: aload_0
      //   948: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   951: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   954: invokevirtual 229	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   957: ifeq +13 -> 970
      //   960: aload_0
      //   961: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   964: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   967: invokevirtual 232	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   970: aload_0
      //   971: aconst_null
      //   972: putfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   975: goto -333 -> 642
      //   978: aload 10
      //   980: ifnull -228 -> 752
      //   983: aload 10
      //   985: ldc -83
      //   987: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   990: ifne -238 -> 752
      //   993: new 175	java/lang/StringBuilder
      //   996: dup
      //   997: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   1000: ldc -78
      //   1002: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1005: aload 11
      //   1007: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1010: ldc -73
      //   1012: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1015: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1018: astore 12
      //   1020: new 175	java/lang/StringBuilder
      //   1023: dup
      //   1024: invokespecial 176	java/lang/StringBuilder:<init>	()V
      //   1027: ldc -70
      //   1029: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1032: aload 11
      //   1034: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1037: ldc -68
      //   1039: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1042: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1045: astore 13
      //   1047: aload_0
      //   1048: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1051: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1054: astore 14
      //   1056: aload 14
      //   1058: ifnull -306 -> 752
      //   1061: aload_0
      //   1062: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1065: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1068: aload 12
      //   1070: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1073: aload_0
      //   1074: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1077: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1080: aload 13
      //   1082: invokevirtual 191	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   1085: goto -333 -> 752
      //   1088: astore 12
      //   1090: goto -338 -> 752
      //   1093: astore 10
      //   1095: iconst_0
      //   1096: istore_2
      //   1097: goto -180 -> 917
      //   1100: astore 10
      //   1102: aload_0
      //   1103: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1106: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1109: ifnull +26 -> 1135
      //   1112: aload_0
      //   1113: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1116: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1119: invokevirtual 229	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   1122: ifeq +13 -> 1135
      //   1125: aload_0
      //   1126: getfield 21	com/baidu/location/c/b$f:b	Lcom/baidu/location/c/b;
      //   1129: invokestatic 158	com/baidu/location/c/b:d	(Lcom/baidu/location/c/b;)Landroid/database/sqlite/SQLiteDatabase;
      //   1132: invokevirtual 232	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   1135: aload_0
      //   1136: aconst_null
      //   1137: putfield 138	com/baidu/location/c/b$f:j	Ljava/lang/String;
      //   1140: aload 10
      //   1142: athrow
      //   1143: astore 11
      //   1145: goto -10 -> 1135
      //   1148: astore 10
      //   1150: goto -513 -> 637
      //   1153: astore 10
      //   1155: goto -551 -> 604
      //   1158: astore 10
      //   1160: goto -190 -> 970
      //   1163: astore 12
      //   1165: goto -858 -> 307
      //   1168: astore 12
      //   1170: iload_2
      //   1171: istore 5
      //   1173: goto -1036 -> 137
      //   1176: astore 12
      //   1178: goto -1073 -> 105
      //   1181: iconst_0
      //   1182: istore_2
      //   1183: goto -266 -> 917
      //   1186: iconst_0
      //   1187: istore_2
      //   1188: goto -546 -> 642
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1191	0	this	f
      //   0	1191	1	paramBoolean	boolean
      //   4	1184	2	i	int
      //   390	207	3	j	int
      //   366	229	4	k	int
      //   106	1066	5	m	int
      //   140	727	6	n	int
      //   369	181	7	i1	int
      //   363	358	8	i2	int
      //   360	16	9	i3	int
      //   20	288	10	localObject1	Object
      //   560	3	10	localJSONException1	org.json.JSONException
      //   568	1	10	localObject2	Object
      //   573	3	10	localJSONException2	org.json.JSONException
      //   581	1	10	localObject3	Object
      //   600	160	10	localException1	Exception
      //   844	140	10	str1	String
      //   1093	1	10	localException2	Exception
      //   1100	41	10	localObject4	Object
      //   1148	1	10	localException3	Exception
      //   1153	1	10	localException4	Exception
      //   1158	1	10	localException5	Exception
      //   1	1032	11	localObject5	Object
      //   1143	1	11	localException6	Exception
      //   240	829	12	localObject6	Object
      //   1088	1	12	localException7	Exception
      //   1163	1	12	localException8	Exception
      //   1168	1	12	localException9	Exception
      //   1176	1	12	localException10	Exception
      //   267	814	13	localObject7	Object
      //   276	781	14	localObject8	Object
      //   383	67	15	str2	String
      //   408	64	16	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   22	33	560	org/json/JSONException
      //   48	57	573	org/json/JSONException
      //   113	121	600	java/lang/Exception
      //   150	169	600	java/lang/Exception
      //   174	188	600	java/lang/Exception
      //   193	200	600	java/lang/Exception
      //   205	278	600	java/lang/Exception
      //   307	362	600	java/lang/Exception
      //   391	410	600	java/lang/Exception
      //   416	423	600	java/lang/Exception
      //   442	488	600	java/lang/Exception
      //   504	531	600	java/lang/Exception
      //   533	539	600	java/lang/Exception
      //   586	594	600	java/lang/Exception
      //   725	752	600	java/lang/Exception
      //   752	759	600	java/lang/Exception
      //   764	885	600	java/lang/Exception
      //   983	1056	600	java/lang/Exception
      //   1061	1085	1088	java/lang/Exception
      //   885	915	1093	java/lang/Exception
      //   95	105	1100	finally
      //   113	121	1100	finally
      //   128	137	1100	finally
      //   150	169	1100	finally
      //   174	188	1100	finally
      //   193	200	1100	finally
      //   205	278	1100	finally
      //   283	307	1100	finally
      //   307	362	1100	finally
      //   391	410	1100	finally
      //   416	423	1100	finally
      //   442	488	1100	finally
      //   504	531	1100	finally
      //   533	539	1100	finally
      //   586	594	1100	finally
      //   725	752	1100	finally
      //   752	759	1100	finally
      //   764	885	1100	finally
      //   885	915	1100	finally
      //   917	937	1100	finally
      //   983	1056	1100	finally
      //   1061	1085	1100	finally
      //   1102	1135	1143	java/lang/Exception
      //   604	637	1148	java/lang/Exception
      //   917	937	1153	java/lang/Exception
      //   937	970	1158	java/lang/Exception
      //   283	307	1163	java/lang/Exception
      //   128	137	1168	java/lang/Exception
      //   95	105	1176	java/lang/Exception
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */