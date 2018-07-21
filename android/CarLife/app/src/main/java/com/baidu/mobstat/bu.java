package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class bu
{
  static String a = "Android";
  boolean b = false;
  String c;
  String d;
  String e = "0";
  String f = null;
  String g = null;
  int h = -1;
  String i;
  String j;
  int k;
  int l;
  String m = null;
  String n;
  String o;
  String p;
  String q;
  String r;
  String s;
  String t;
  String u;
  String v;
  String w;
  String x;
  String y;
  JSONObject z;
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/baidu/mobstat/bu:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_1
    //   15: ldc 63
    //   17: invokestatic 68	com/baidu/mobstat/cu:e	(Landroid/content/Context;Ljava/lang/String;)Z
    //   20: pop
    //   21: aload_1
    //   22: ldc 70
    //   24: invokestatic 68	com/baidu/mobstat/cu:e	(Landroid/content/Context;Ljava/lang/String;)Z
    //   27: pop
    //   28: aload_1
    //   29: ldc 72
    //   31: invokestatic 68	com/baidu/mobstat/cu:e	(Landroid/content/Context;Ljava/lang/String;)Z
    //   34: pop
    //   35: aload_1
    //   36: ldc 74
    //   38: invokestatic 68	com/baidu/mobstat/cu:e	(Landroid/content/Context;Ljava/lang/String;)Z
    //   41: pop
    //   42: aload_1
    //   43: ldc 76
    //   45: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 84	android/telephony/TelephonyManager
    //   51: astore 4
    //   53: aload_0
    //   54: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   57: invokevirtual 93	com/baidu/mobstat/CooperService:getOSVersion	()Ljava/lang/String;
    //   60: putfield 95	com/baidu/mobstat/bu:c	Ljava/lang/String;
    //   63: aload_0
    //   64: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   67: invokevirtual 98	com/baidu/mobstat/CooperService:getOSSysVersion	()Ljava/lang/String;
    //   70: putfield 100	com/baidu/mobstat/bu:d	Ljava/lang/String;
    //   73: aload_0
    //   74: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   77: invokevirtual 103	com/baidu/mobstat/CooperService:getPhoneModel	()Ljava/lang/String;
    //   80: putfield 105	com/baidu/mobstat/bu:o	Ljava/lang/String;
    //   83: aload_0
    //   84: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   87: invokevirtual 108	com/baidu/mobstat/CooperService:getManufacturer	()Ljava/lang/String;
    //   90: putfield 110	com/baidu/mobstat/bu:p	Ljava/lang/String;
    //   93: aload_0
    //   94: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   97: invokevirtual 113	com/baidu/mobstat/CooperService:getUUID	()Ljava/lang/String;
    //   100: putfield 115	com/baidu/mobstat/bu:y	Ljava/lang/String;
    //   103: aload_0
    //   104: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   107: aload_1
    //   108: invokevirtual 119	com/baidu/mobstat/CooperService:getHeaderExt	(Landroid/content/Context;)Lorg/json/JSONObject;
    //   111: putfield 121	com/baidu/mobstat/bu:z	Lorg/json/JSONObject;
    //   114: aload_0
    //   115: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   118: aload 4
    //   120: aload_1
    //   121: invokevirtual 125	com/baidu/mobstat/CooperService:getDeviceId	(Landroid/telephony/TelephonyManager;Landroid/content/Context;)Ljava/lang/String;
    //   124: putfield 127	com/baidu/mobstat/bu:j	Ljava/lang/String;
    //   127: invokestatic 132	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   130: aload_1
    //   131: invokevirtual 135	com/baidu/mobstat/bj:j	(Landroid/content/Context;)Z
    //   134: ifeq +292 -> 426
    //   137: ldc -119
    //   139: astore_3
    //   140: aload_0
    //   141: aload_3
    //   142: putfield 50	com/baidu/mobstat/bu:e	Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 141	com/baidu/mobstat/de:s	(Landroid/content/Context;)Z
    //   149: ifeq +9 -> 158
    //   152: aload_0
    //   153: ldc -113
    //   155: putfield 50	com/baidu/mobstat/bu:e	Ljava/lang/String;
    //   158: aload_0
    //   159: new 145	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   166: aload_0
    //   167: getfield 50	com/baidu/mobstat/bu:e	Ljava/lang/String;
    //   170: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc -104
    //   175: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: putfield 50	com/baidu/mobstat/bu:e	Ljava/lang/String;
    //   184: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   187: aload_1
    //   188: invokevirtual 158	com/baidu/mobstat/CooperService:isDeviceMacEnabled	(Landroid/content/Context;)Z
    //   191: istore_2
    //   192: aload_0
    //   193: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   196: aload_1
    //   197: iload_2
    //   198: invokevirtual 162	com/baidu/mobstat/CooperService:getMacAddress	(Landroid/content/Context;Z)Ljava/lang/String;
    //   201: putfield 164	com/baidu/mobstat/bu:t	Ljava/lang/String;
    //   204: aload_0
    //   205: iconst_1
    //   206: aload_1
    //   207: invokestatic 167	com/baidu/mobstat/de:f	(ILandroid/content/Context;)Ljava/lang/String;
    //   210: putfield 169	com/baidu/mobstat/bu:v	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_1
    //   215: iconst_1
    //   216: invokestatic 172	com/baidu/mobstat/de:a	(Landroid/content/Context;I)Ljava/lang/String;
    //   219: putfield 174	com/baidu/mobstat/bu:w	Ljava/lang/String;
    //   222: aload_0
    //   223: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   226: aload_1
    //   227: iconst_1
    //   228: invokevirtual 177	com/baidu/mobstat/CooperService:getCUID	(Landroid/content/Context;Z)Ljava/lang/String;
    //   231: putfield 54	com/baidu/mobstat/bu:g	Ljava/lang/String;
    //   234: aload_0
    //   235: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   238: aload 4
    //   240: invokevirtual 181	com/baidu/mobstat/CooperService:getOperator	(Landroid/telephony/TelephonyManager;)Ljava/lang/String;
    //   243: putfield 183	com/baidu/mobstat/bu:n	Ljava/lang/String;
    //   246: aload_0
    //   247: aload_1
    //   248: invokestatic 186	com/baidu/mobstat/de:b	(Landroid/content/Context;)I
    //   251: putfield 188	com/baidu/mobstat/bu:k	I
    //   254: aload_0
    //   255: aload_1
    //   256: invokestatic 190	com/baidu/mobstat/de:c	(Landroid/content/Context;)I
    //   259: putfield 192	com/baidu/mobstat/bu:l	I
    //   262: aload_1
    //   263: invokevirtual 196	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   266: invokevirtual 202	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   269: getfield 207	android/content/res/Configuration:orientation	I
    //   272: iconst_2
    //   273: if_icmpne +42 -> 315
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 188	com/baidu/mobstat/bu:k	I
    //   281: aload_0
    //   282: getfield 192	com/baidu/mobstat/bu:l	I
    //   285: ixor
    //   286: putfield 188	com/baidu/mobstat/bu:k	I
    //   289: aload_0
    //   290: aload_0
    //   291: getfield 188	com/baidu/mobstat/bu:k	I
    //   294: aload_0
    //   295: getfield 192	com/baidu/mobstat/bu:l	I
    //   298: ixor
    //   299: putfield 192	com/baidu/mobstat/bu:l	I
    //   302: aload_0
    //   303: aload_0
    //   304: getfield 188	com/baidu/mobstat/bu:k	I
    //   307: aload_0
    //   308: getfield 192	com/baidu/mobstat/bu:l	I
    //   311: ixor
    //   312: putfield 188	com/baidu/mobstat/bu:k	I
    //   315: aload_0
    //   316: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   319: aload_1
    //   320: invokevirtual 211	com/baidu/mobstat/CooperService:getAppChannel	(Landroid/content/Context;)Ljava/lang/String;
    //   323: putfield 58	com/baidu/mobstat/bu:m	Ljava/lang/String;
    //   326: aload_0
    //   327: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   330: aload_1
    //   331: invokevirtual 214	com/baidu/mobstat/CooperService:getAppKey	(Landroid/content/Context;)Ljava/lang/String;
    //   334: putfield 52	com/baidu/mobstat/bu:f	Ljava/lang/String;
    //   337: aload_0
    //   338: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   341: aload_1
    //   342: invokevirtual 217	com/baidu/mobstat/CooperService:getAppVersionCode	(Landroid/content/Context;)I
    //   345: putfield 56	com/baidu/mobstat/bu:h	I
    //   348: aload_0
    //   349: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   352: aload_1
    //   353: invokevirtual 220	com/baidu/mobstat/CooperService:getAppVersionName	(Landroid/content/Context;)Ljava/lang/String;
    //   356: putfield 222	com/baidu/mobstat/bu:i	Ljava/lang/String;
    //   359: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   362: aload_1
    //   363: invokevirtual 225	com/baidu/mobstat/CooperService:checkCellLocationSetting	(Landroid/content/Context;)Z
    //   366: ifeq +114 -> 480
    //   369: aload_0
    //   370: aload_1
    //   371: invokestatic 227	com/baidu/mobstat/de:g	(Landroid/content/Context;)Ljava/lang/String;
    //   374: putfield 229	com/baidu/mobstat/bu:q	Ljava/lang/String;
    //   377: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   380: aload_1
    //   381: invokevirtual 232	com/baidu/mobstat/CooperService:checkGPSLocationSetting	(Landroid/content/Context;)Z
    //   384: ifeq +113 -> 497
    //   387: aload_0
    //   388: aload_1
    //   389: invokestatic 234	com/baidu/mobstat/de:h	(Landroid/content/Context;)Ljava/lang/String;
    //   392: putfield 236	com/baidu/mobstat/bu:r	Ljava/lang/String;
    //   395: aload_0
    //   396: invokestatic 89	com/baidu/mobstat/CooperService:a	()Lcom/baidu/mobstat/CooperService;
    //   399: aload_1
    //   400: invokevirtual 239	com/baidu/mobstat/CooperService:getLinkedWay	(Landroid/content/Context;)Ljava/lang/String;
    //   403: putfield 241	com/baidu/mobstat/bu:s	Ljava/lang/String;
    //   406: aload_0
    //   407: invokestatic 243	com/baidu/mobstat/de:b	()Ljava/lang/String;
    //   410: putfield 245	com/baidu/mobstat/bu:x	Ljava/lang/String;
    //   413: aload_0
    //   414: iconst_1
    //   415: putfield 46	com/baidu/mobstat/bu:b	Z
    //   418: goto -407 -> 11
    //   421: astore_1
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: ldc 48
    //   428: astore_3
    //   429: goto -289 -> 140
    //   432: astore_3
    //   433: aload_3
    //   434: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   437: goto -233 -> 204
    //   440: astore_3
    //   441: aload_3
    //   442: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   445: goto -232 -> 213
    //   448: astore_3
    //   449: aload_3
    //   450: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   453: goto -231 -> 222
    //   456: astore_3
    //   457: aload_3
    //   458: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   461: goto -215 -> 246
    //   464: astore_3
    //   465: aload_3
    //   466: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   469: goto -154 -> 315
    //   472: astore_3
    //   473: aload_3
    //   474: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   477: goto -118 -> 359
    //   480: aload_0
    //   481: ldc -4
    //   483: putfield 229	com/baidu/mobstat/bu:q	Ljava/lang/String;
    //   486: goto -109 -> 377
    //   489: astore_3
    //   490: aload_3
    //   491: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   494: goto -117 -> 377
    //   497: aload_0
    //   498: ldc -2
    //   500: putfield 236	com/baidu/mobstat/bu:r	Ljava/lang/String;
    //   503: goto -108 -> 395
    //   506: astore_3
    //   507: aload_3
    //   508: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   511: goto -116 -> 395
    //   514: astore_1
    //   515: aload_1
    //   516: invokestatic 250	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   519: goto -113 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	bu
    //   0	522	1	paramContext	Context
    //   6	192	2	bool	boolean
    //   139	290	3	str	String
    //   432	2	3	localException1	Exception
    //   440	2	3	localException2	Exception
    //   448	2	3	localException3	Exception
    //   456	2	3	localException4	Exception
    //   464	2	3	localException5	Exception
    //   472	2	3	localException6	Exception
    //   489	2	3	localException7	Exception
    //   506	2	3	localException8	Exception
    //   51	188	4	localTelephonyManager	android.telephony.TelephonyManager
    // Exception table:
    //   from	to	target	type
    //   2	7	421	finally
    //   14	137	421	finally
    //   140	158	421	finally
    //   158	184	421	finally
    //   184	204	421	finally
    //   204	213	421	finally
    //   213	222	421	finally
    //   222	234	421	finally
    //   234	246	421	finally
    //   246	315	421	finally
    //   315	337	421	finally
    //   337	359	421	finally
    //   359	377	421	finally
    //   377	395	421	finally
    //   395	406	421	finally
    //   406	418	421	finally
    //   433	437	421	finally
    //   441	445	421	finally
    //   449	453	421	finally
    //   457	461	421	finally
    //   465	469	421	finally
    //   473	477	421	finally
    //   480	486	421	finally
    //   490	494	421	finally
    //   497	503	421	finally
    //   507	511	421	finally
    //   515	519	421	finally
    //   184	204	432	java/lang/Exception
    //   204	213	440	java/lang/Exception
    //   213	222	448	java/lang/Exception
    //   234	246	456	java/lang/Exception
    //   246	315	464	java/lang/Exception
    //   337	359	472	java/lang/Exception
    //   359	377	489	java/lang/Exception
    //   480	486	489	java/lang/Exception
    //   377	395	506	java/lang/Exception
    //   497	503	506	java/lang/Exception
    //   395	406	514	java/lang/Exception
  }
  
  /* Error */
  public void a(Context paramContext, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 257	com/baidu/mobstat/bu:a	(Landroid/content/Context;)V
    //   7: aload_2
    //   8: invokevirtual 263	org/json/JSONObject:length	()I
    //   11: bipush 10
    //   13: if_icmple +29 -> 42
    //   16: new 145	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 265
    //   26: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 271	com/baidu/mobstat/db:a	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 273	com/baidu/mobstat/bu:b	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   48: goto -9 -> 39
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	bu
    //   0	56	1	paramContext	Context
    //   0	56	2	paramJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	39	51	finally
    //   42	48	51	finally
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.z = paramJSONObject;
  }
  
  public void b(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      String str1;
      try
      {
        if (a != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("o", str1);
        paramJSONObject.put("st", 0);
        if (this.c != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("s", str1);
        if (this.d != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("sv", str1);
        if (this.f != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("k", str1);
        if (this.e != null) {
          continue;
        }
        str1 = "0";
        paramJSONObject.put("pt", str1);
        paramJSONObject.put("i", "");
        paramJSONObject.put("v", "3.7.6.1");
        paramJSONObject.put("sc", 0);
        paramJSONObject.put("a", this.h);
        if (this.i != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("n", str1);
        paramJSONObject.put("d", "");
        if (this.t != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("mc", str1);
        if (this.v != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("bm", str1);
        if (this.j != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("dd", str1);
        if (this.g != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("ii", str1);
        paramJSONObject.put("tg", 1);
        paramJSONObject.put("w", this.k);
        paramJSONObject.put("h", this.l);
        if (this.w != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("dn", str1);
        if (this.m != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("c", str1);
        if (this.n != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("op", str1);
        if (this.o != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("m", str1);
        if (this.p != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("ma", str1);
        paramJSONObject.put("cl", this.q);
        if (this.r != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("gl", str1);
        if (this.s != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("l", str1);
        paramJSONObject.put("t", System.currentTimeMillis());
        paramJSONObject.put("pn", de.h(1, paramContext));
        if (this.x != null) {
          continue;
        }
        str1 = "";
        paramJSONObject.put("rom", str1);
        String str2 = de.q(paramContext);
        paramJSONObject.put("pl", str2);
        str1 = null;
        if (TextUtils.isEmpty(str2)) {
          break label772;
        }
        str1 = de.r(paramContext);
      }
      catch (JSONException paramContext)
      {
        db.a("header ini error");
        continue;
      }
      finally {}
      paramJSONObject.put("scl", paramContext);
      if (this.y == null)
      {
        paramContext = "";
        paramJSONObject.put("sign", paramContext);
        if ((this.z != null) && (this.z.length() != 0)) {
          paramJSONObject.put("ext", this.z);
        }
        db.a("header is: " + paramJSONObject.toString() + "; len: " + paramJSONObject.length());
        return;
        str1 = a;
        continue;
        str1 = this.c;
        continue;
        str1 = this.d;
        continue;
        str1 = this.f;
        continue;
        str1 = this.e;
        continue;
        str1 = this.i;
        continue;
        str1 = this.t;
        continue;
        str1 = this.v;
        continue;
        str1 = this.j;
        continue;
        str1 = this.g;
        continue;
        str1 = this.w;
        continue;
        str1 = this.m;
        continue;
        str1 = this.n;
        continue;
        str1 = this.o;
        continue;
        str1 = this.p;
        continue;
        str1 = this.r;
        continue;
        str1 = this.s;
        continue;
        str1 = this.x;
      }
      else
      {
        paramContext = this.y;
        continue;
        label772:
        paramContext = str1;
        if (str1 == null) {
          paramContext = "";
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */