package com.baidu.carlife.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.n;
import com.baidu.carlife.k.n.a;
import com.baidu.carlife.l.a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s
{
  public static final String a = "StatisticMobileUtil";
  public static String b = null;
  public static final String c = "statistic.json";
  public static final String d = "StatisticErrorCode.txt";
  public static final String e = "10003";
  public static final String f = "10004";
  public static final String g = "10005";
  public static String h = "";
  public static String i = "";
  public static String j = "";
  public static boolean k = false;
  public static long l = 0L;
  public static long m = 0L;
  public static boolean n = false;
  private static final int o = 10;
  
  public static n.a a()
  {
    n.a locala = new n.a();
    String str;
    if (TextUtils.isEmpty(h))
    {
      str = "unknow";
      locala.a = str;
      if (!TextUtils.isEmpty(i)) {
        break label133;
      }
      str = "unknow";
      label37:
      locala.b = str;
      if (!TextUtils.isEmpty(j)) {
        break label140;
      }
      str = "unknow";
      label54:
      locala.c = str;
      locala.d = "android";
      locala.g = e.g();
      locala.f = c.b();
      locala.e = e.j();
      if (GeoLocateModel.getInstance().getCurrentDistrict() == null) {
        break label147;
      }
      locala.h = GeoLocateModel.getInstance().getCurrentDistrict().mId;
      label108:
      if (!a.a().N()) {
        break label155;
      }
    }
    label133:
    label140:
    label147:
    label155:
    for (int i1 = 1;; i1 = 0)
    {
      locala.i = i1;
      return locala;
      str = h;
      break;
      str = i;
      break label37;
      str = j;
      break label54;
      locala.h = 0;
      break label108;
    }
  }
  
  public static n.a a(n paramn, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramn == null)) {
      paramn = null;
    }
    n.a locala;
    do
    {
      return paramn;
      i.d("resJson", paramJSONObject.toString());
      locala = new n.a();
      locala.d = paramJSONObject.optString("os");
      locala.g = paramJSONObject.optString("appVer");
      locala.f = paramJSONObject.optString("mCuid");
      locala.h = paramJSONObject.optInt("loc");
      locala.a = paramJSONObject.optString("cuid");
      locala.b = paramJSONObject.optString("channel");
      locala.c = paramJSONObject.optString("version");
      locala.i = paramJSONObject.optInt("isConn");
      locala.e = paramJSONObject.optString("mb");
      paramn = locala;
    } while (paramJSONObject.optJSONObject("item0") == null);
    locala.a(paramJSONObject.optJSONObject("item0").toString());
    return locala;
  }
  
  public static JSONObject a(n.a parama, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", parama.d);
      localJSONObject.put("appVer", parama.g);
      localJSONObject.put("mCuid", parama.f);
      localJSONObject.put("mb", parama.e);
      localJSONObject.put("loc", parama.h);
      localJSONObject.put("cuid", parama.a);
      localJSONObject.put("channel", parama.b);
      localJSONObject.put("version", parama.c);
      localJSONObject.put("isConn", parama.i);
      localJSONObject.put("item0", paramJSONObject);
      return localJSONObject;
    }
    catch (JSONException parama)
    {
      i.e("StatisticMobileUtil", parama.toString());
    }
    return null;
  }
  
  /* Error */
  public static JSONObject a(String paramString)
  {
    // Byte code:
    //   0: getstatic 47	com/baidu/carlife/util/s:b	Ljava/lang/String;
    //   3: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 196	java/io/File
    //   21: dup
    //   22: new 198	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   29: getstatic 47	com/baidu/carlife/util/s:b	Ljava/lang/String;
    //   32: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 210	java/io/File:exists	()Z
    //   50: ifeq -34 -> 16
    //   53: ldc 49
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 9
    //   60: aconst_null
    //   61: astore 10
    //   63: aconst_null
    //   64: astore_2
    //   65: aconst_null
    //   66: astore 8
    //   68: aconst_null
    //   69: astore 5
    //   71: aconst_null
    //   72: astore 6
    //   74: aconst_null
    //   75: astore_1
    //   76: aconst_null
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_3
    //   81: new 212	java/io/FileReader
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 215	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   89: astore_0
    //   90: new 217	java/io/BufferedReader
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 220	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore_1
    //   99: aload 7
    //   101: astore_2
    //   102: aload_1
    //   103: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +25 -> 133
    //   111: new 198	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   118: aload_2
    //   119: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore_2
    //   130: goto -28 -> 102
    //   133: new 134	org/json/JSONObject
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 224	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_2
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 227	java/io/BufferedReader:close	()V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 228	java/io/FileReader:close	()V
    //   158: aload_2
    //   159: areturn
    //   160: astore_0
    //   161: ldc 12
    //   163: aload_0
    //   164: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   167: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_2
    //   171: areturn
    //   172: astore 4
    //   174: aload 8
    //   176: astore_0
    //   177: aload_3
    //   178: astore_1
    //   179: aload_0
    //   180: astore_2
    //   181: ldc 12
    //   183: aload 4
    //   185: invokevirtual 230	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   188: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 227	java/io/BufferedReader:close	()V
    //   199: aload_0
    //   200: ifnull -184 -> 16
    //   203: aload_0
    //   204: invokevirtual 228	java/io/FileReader:close	()V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_0
    //   210: ldc 12
    //   212: aload_0
    //   213: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   216: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore 4
    //   223: aload 9
    //   225: astore_0
    //   226: aload 5
    //   228: astore_3
    //   229: aload_3
    //   230: astore_1
    //   231: aload_0
    //   232: astore_2
    //   233: ldc 12
    //   235: aload 4
    //   237: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   240: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 227	java/io/BufferedReader:close	()V
    //   251: aload_0
    //   252: ifnull -236 -> 16
    //   255: aload_0
    //   256: invokevirtual 228	java/io/FileReader:close	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: ldc 12
    //   264: aload_0
    //   265: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   268: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aconst_null
    //   272: areturn
    //   273: astore 4
    //   275: aload 10
    //   277: astore_0
    //   278: aload 6
    //   280: astore_3
    //   281: aload_3
    //   282: astore_1
    //   283: aload_0
    //   284: astore_2
    //   285: ldc 12
    //   287: aload 4
    //   289: invokevirtual 188	org/json/JSONException:toString	()Ljava/lang/String;
    //   292: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_3
    //   296: ifnull +7 -> 303
    //   299: aload_3
    //   300: invokevirtual 227	java/io/BufferedReader:close	()V
    //   303: aload_0
    //   304: ifnull -288 -> 16
    //   307: aload_0
    //   308: invokevirtual 228	java/io/FileReader:close	()V
    //   311: aconst_null
    //   312: areturn
    //   313: astore_0
    //   314: ldc 12
    //   316: aload_0
    //   317: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   320: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_0
    //   326: aload_1
    //   327: ifnull +7 -> 334
    //   330: aload_1
    //   331: invokevirtual 227	java/io/BufferedReader:close	()V
    //   334: aload_2
    //   335: ifnull +7 -> 342
    //   338: aload_2
    //   339: invokevirtual 228	java/io/FileReader:close	()V
    //   342: aload_0
    //   343: athrow
    //   344: astore_1
    //   345: ldc 12
    //   347: aload_1
    //   348: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   351: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: goto -12 -> 342
    //   357: astore_3
    //   358: aload 4
    //   360: astore_1
    //   361: aload_0
    //   362: astore_2
    //   363: aload_3
    //   364: astore_0
    //   365: goto -39 -> 326
    //   368: astore_3
    //   369: aload_0
    //   370: astore_2
    //   371: aload_3
    //   372: astore_0
    //   373: goto -47 -> 326
    //   376: astore 4
    //   378: aload 6
    //   380: astore_3
    //   381: goto -100 -> 281
    //   384: astore 4
    //   386: aload_1
    //   387: astore_3
    //   388: goto -107 -> 281
    //   391: astore 4
    //   393: aload 5
    //   395: astore_3
    //   396: goto -167 -> 229
    //   399: astore 4
    //   401: aload_1
    //   402: astore_3
    //   403: goto -174 -> 229
    //   406: astore 4
    //   408: goto -231 -> 177
    //   411: astore 4
    //   413: aload_1
    //   414: astore_3
    //   415: goto -238 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString	String
    //   75	256	1	localObject1	Object
    //   344	4	1	localIOException1	java.io.IOException
    //   360	54	1	localObject2	Object
    //   64	307	2	localObject3	Object
    //   80	220	3	localObject4	Object
    //   357	7	3	localObject5	Object
    //   368	4	3	localObject6	Object
    //   380	35	3	localObject7	Object
    //   77	1	4	localObject8	Object
    //   172	12	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   221	15	4	localIOException2	java.io.IOException
    //   273	86	4	localJSONException1	JSONException
    //   376	1	4	localJSONException2	JSONException
    //   384	1	4	localJSONException3	JSONException
    //   391	1	4	localIOException3	java.io.IOException
    //   399	1	4	localIOException4	java.io.IOException
    //   406	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   411	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   69	325	5	localObject9	Object
    //   72	307	6	localObject10	Object
    //   55	45	7	str	String
    //   66	109	8	localObject11	Object
    //   58	166	9	localObject12	Object
    //   61	215	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   146	150	160	java/io/IOException
    //   154	158	160	java/io/IOException
    //   81	90	172	java/io/FileNotFoundException
    //   195	199	209	java/io/IOException
    //   203	207	209	java/io/IOException
    //   81	90	221	java/io/IOException
    //   247	251	261	java/io/IOException
    //   255	259	261	java/io/IOException
    //   81	90	273	org/json/JSONException
    //   299	303	313	java/io/IOException
    //   307	311	313	java/io/IOException
    //   81	90	325	finally
    //   181	191	325	finally
    //   233	243	325	finally
    //   285	295	325	finally
    //   330	334	344	java/io/IOException
    //   338	342	344	java/io/IOException
    //   90	99	357	finally
    //   102	107	368	finally
    //   111	130	368	finally
    //   133	142	368	finally
    //   90	99	376	org/json/JSONException
    //   102	107	384	org/json/JSONException
    //   111	130	384	org/json/JSONException
    //   133	142	384	org/json/JSONException
    //   90	99	391	java/io/IOException
    //   102	107	399	java/io/IOException
    //   111	130	399	java/io/IOException
    //   133	142	399	java/io/IOException
    //   90	99	406	java/io/FileNotFoundException
    //   102	107	411	java/io/FileNotFoundException
    //   111	130	411	java/io/FileNotFoundException
    //   133	142	411	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    n.a locala;
    if ((!paramBoolean2) || ((paramBoolean2) && (e.a().r())))
    {
      paramContext = new n();
      paramContext.a("statistic.json");
      locala = new n.a();
      if ((!paramBoolean2) || (!paramBoolean4)) {
        break label79;
      }
      locala = a(paramContext, a("statistic.json"));
      if (locala != null)
      {
        paramContext.a(locala);
        paramContext.toPostRequest();
      }
    }
    label79:
    Object localObject;
    label160:
    label230:
    label323:
    label334:
    label394:
    label434:
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      int i1;
      if (paramBoolean1)
      {
        paramLong1 = (l1 - paramLong1) / 1000L;
        localObject = new HashMap();
        locala.d = "android";
        locala.g = e.g();
        locala.f = c.b();
        locala.e = e.j();
        if (GeoLocateModel.getInstance().getCurrentDistrict() == null) {
          break label323;
        }
        locala.h = GeoLocateModel.getInstance().getCurrentDistrict().mId;
        if ((!paramBoolean1) || (!k)) {
          break label334;
        }
        locala.a = h;
        locala.b = i;
        locala.c = j;
        locala.i = 1;
        ((Map)localObject).put("connTime", "" + paramLong1);
        i1 = e.s();
        if (i1 != 1) {
          break label394;
        }
        ((Map)localObject).put("net", "Mobile");
      }
      for (;;)
      {
        ((Map)localObject).put("carr", e.k());
        ((Map)localObject).put("dpi", e.c());
        localObject = locala.a("10003", (Map)localObject, System.currentTimeMillis() / 1000L);
        if (!paramBoolean2) {
          break label434;
        }
        paramContext.a(locala);
        paramContext.toPostRequest();
        return;
        paramLong1 = paramLong2;
        break;
        locala.h = 131;
        break label160;
        locala.a = "";
        locala.b = "";
        locala.c = "";
        locala.i = 0;
        ((Map)localObject).put("useTime", "" + paramLong1);
        break label230;
        if (i1 == 2) {
          ((Map)localObject).put("net", "WIFI");
        } else {
          ((Map)localObject).put("net", "invalid");
        }
      }
    } while (!paramBoolean3);
    a(a(locala, (JSONObject)localObject), "statistic.json");
  }
  
  public static void a(CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    b = f.jm + File.separator + "mobile/log/";
    if (paramCarlifeStatisticsInfo == null) {
      return;
    }
    h = paramCarlifeStatisticsInfo.getCuid();
    i = paramCarlifeStatisticsInfo.getChannel();
    j = paramCarlifeStatisticsInfo.getVersionName();
    k = true;
  }
  
  public static void a(String paramString, final boolean paramBoolean)
  {
    try
    {
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 17	com/baidu/carlife/util/s$1:a	Ljava/lang/String;
          //   4: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   7: ifeq +4 -> 11
          //   10: return
          //   11: getstatic 38	com/baidu/carlife/util/s:b	Ljava/lang/String;
          //   14: ifnonnull +11 -> 25
          //   17: ldc 40
          //   19: ldc 42
          //   21: invokestatic 48	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   24: return
          //   25: new 50	java/io/File
          //   28: dup
          //   29: getstatic 38	com/baidu/carlife/util/s:b	Ljava/lang/String;
          //   32: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
          //   35: astore 5
          //   37: aload 5
          //   39: invokevirtual 57	java/io/File:exists	()Z
          //   42: ifne +9 -> 51
          //   45: aload 5
          //   47: invokevirtual 60	java/io/File:mkdirs	()Z
          //   50: pop
          //   51: new 50	java/io/File
          //   54: dup
          //   55: new 62	java/lang/StringBuilder
          //   58: dup
          //   59: invokespecial 63	java/lang/StringBuilder:<init>	()V
          //   62: getstatic 38	com/baidu/carlife/util/s:b	Ljava/lang/String;
          //   65: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   68: ldc 69
          //   70: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   73: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   76: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
          //   79: astore 13
          //   81: aload 13
          //   83: invokevirtual 57	java/io/File:exists	()Z
          //   86: ifne +9 -> 95
          //   89: aload 13
          //   91: invokevirtual 76	java/io/File:createNewFile	()Z
          //   94: pop
          //   95: aconst_null
          //   96: astore 6
          //   98: aconst_null
          //   99: astore 7
          //   101: new 78	java/io/FileWriter
          //   104: dup
          //   105: aload 13
          //   107: iconst_1
          //   108: invokespecial 81	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
          //   111: astore 5
          //   113: aload 5
          //   115: new 62	java/lang/StringBuilder
          //   118: dup
          //   119: invokespecial 63	java/lang/StringBuilder:<init>	()V
          //   122: ldc 83
          //   124: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   127: aload_0
          //   128: getfield 17	com/baidu/carlife/util/s$1:a	Ljava/lang/String;
          //   131: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   134: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   137: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
          //   140: aload 5
          //   142: ifnull +8 -> 150
          //   145: aload 5
          //   147: invokevirtual 89	java/io/FileWriter:close	()V
          //   150: new 91	java/lang/StringBuffer
          //   153: dup
          //   154: invokespecial 92	java/lang/StringBuffer:<init>	()V
          //   157: astore 12
          //   159: aconst_null
          //   160: astore 6
          //   162: aconst_null
          //   163: astore 11
          //   165: aconst_null
          //   166: astore 10
          //   168: aconst_null
          //   169: astore 8
          //   171: aconst_null
          //   172: astore 7
          //   174: aconst_null
          //   175: astore 9
          //   177: new 94	java/io/FileReader
          //   180: dup
          //   181: aload 13
          //   183: invokespecial 97	java/io/FileReader:<init>	(Ljava/io/File;)V
          //   186: astore 5
          //   188: new 99	java/io/BufferedReader
          //   191: dup
          //   192: aload 5
          //   194: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
          //   197: astore 6
          //   199: aload 6
          //   201: invokevirtual 105	java/io/BufferedReader:readLine	()Ljava/lang/String;
          //   204: astore 7
          //   206: aload 7
          //   208: ifnull +204 -> 412
          //   211: aload 12
          //   213: aload 7
          //   215: invokevirtual 108	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
          //   218: pop
          //   219: goto -20 -> 199
          //   222: astore 7
          //   224: aload 6
          //   226: ifnull +8 -> 234
          //   229: aload 6
          //   231: invokevirtual 109	java/io/BufferedReader:close	()V
          //   234: aload 5
          //   236: ifnull +8 -> 244
          //   239: aload 5
          //   241: invokevirtual 110	java/io/FileReader:close	()V
          //   244: aload 12
          //   246: invokevirtual 111	java/lang/StringBuffer:toString	()Ljava/lang/String;
          //   249: astore 5
          //   251: aload 5
          //   253: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   256: ifne -246 -> 10
          //   259: new 113	java/util/HashMap
          //   262: dup
          //   263: invokespecial 114	java/util/HashMap:<init>	()V
          //   266: astore 6
          //   268: aload 5
          //   270: ldc 83
          //   272: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   275: astore 7
          //   277: aload 7
          //   279: arraylength
          //   280: istore_2
          //   281: iconst_0
          //   282: istore_1
          //   283: iload_1
          //   284: iload_2
          //   285: if_icmpge +222 -> 507
          //   288: aload 7
          //   290: iload_1
          //   291: aaload
          //   292: ldc 122
          //   294: invokevirtual 120	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
          //   297: astore 9
          //   299: aload 9
          //   301: arraylength
          //   302: iconst_1
          //   303: if_icmple +58 -> 361
          //   306: new 113	java/util/HashMap
          //   309: dup
          //   310: invokespecial 114	java/util/HashMap:<init>	()V
          //   313: astore 8
          //   315: aload 8
          //   317: ldc 124
          //   319: aload 9
          //   321: iconst_0
          //   322: aaload
          //   323: invokeinterface 130 3 0
          //   328: pop
          //   329: lconst_0
          //   330: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   333: astore 5
          //   335: aload 9
          //   337: iconst_1
          //   338: aaload
          //   339: invokestatic 140	java/lang/Long:parseLong	(Ljava/lang/String;)J
          //   342: lstore_3
          //   343: lload_3
          //   344: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   347: astore 5
          //   349: aload 6
          //   351: aload 5
          //   353: aload 8
          //   355: invokeinterface 130 3 0
          //   360: pop
          //   361: iload_1
          //   362: iconst_1
          //   363: iadd
          //   364: istore_1
          //   365: goto -82 -> 283
          //   368: astore 5
          //   370: goto -220 -> 150
          //   373: astore 5
          //   375: aload 7
          //   377: astore 5
          //   379: aload 5
          //   381: ifnull -231 -> 150
          //   384: aload 5
          //   386: invokevirtual 89	java/io/FileWriter:close	()V
          //   389: goto -239 -> 150
          //   392: astore 5
          //   394: goto -244 -> 150
          //   397: astore 5
          //   399: aload 6
          //   401: ifnull +8 -> 409
          //   404: aload 6
          //   406: invokevirtual 89	java/io/FileWriter:close	()V
          //   409: aload 5
          //   411: athrow
          //   412: aload 6
          //   414: ifnull +8 -> 422
          //   417: aload 6
          //   419: invokevirtual 109	java/io/BufferedReader:close	()V
          //   422: aload 5
          //   424: ifnull +8 -> 432
          //   427: aload 5
          //   429: invokevirtual 110	java/io/FileReader:close	()V
          //   432: goto -188 -> 244
          //   435: astore 5
          //   437: goto -193 -> 244
          //   440: astore 5
          //   442: aload 6
          //   444: astore 5
          //   446: aload 8
          //   448: astore 6
          //   450: aload 6
          //   452: ifnull +8 -> 460
          //   455: aload 6
          //   457: invokevirtual 109	java/io/BufferedReader:close	()V
          //   460: aload 5
          //   462: ifnull -218 -> 244
          //   465: aload 5
          //   467: invokevirtual 110	java/io/FileReader:close	()V
          //   470: goto -226 -> 244
          //   473: astore 5
          //   475: goto -231 -> 244
          //   478: astore 6
          //   480: aload 11
          //   482: astore 5
          //   484: aload 7
          //   486: ifnull +8 -> 494
          //   489: aload 7
          //   491: invokevirtual 109	java/io/BufferedReader:close	()V
          //   494: aload 5
          //   496: ifnull +8 -> 504
          //   499: aload 5
          //   501: invokevirtual 110	java/io/FileReader:close	()V
          //   504: aload 6
          //   506: athrow
          //   507: aload 6
          //   509: invokeinterface 144 1 0
          //   514: bipush 10
          //   516: if_icmpge +10 -> 526
          //   519: aload_0
          //   520: getfield 19	com/baidu/carlife/util/s$1:b	Z
          //   523: ifne -513 -> 10
          //   526: new 146	com/baidu/carlife/k/n
          //   529: dup
          //   530: invokespecial 147	com/baidu/carlife/k/n:<init>	()V
          //   533: astore 5
          //   535: aload 5
          //   537: ldc 69
          //   539: invokevirtual 149	com/baidu/carlife/k/n:a	(Ljava/lang/String;)V
          //   542: invokestatic 152	com/baidu/carlife/util/s:a	()Lcom/baidu/carlife/k/n$a;
          //   545: astore 7
          //   547: aload 6
          //   549: invokeinterface 156 1 0
          //   554: invokeinterface 162 1 0
          //   559: astore 6
          //   561: aload 6
          //   563: invokeinterface 167 1 0
          //   568: ifeq +49 -> 617
          //   571: aload 6
          //   573: invokeinterface 171 1 0
          //   578: checkcast 173	java/util/Map$Entry
          //   581: astore 8
          //   583: aload 7
          //   585: ldc -81
          //   587: aload 8
          //   589: invokeinterface 178 1 0
          //   594: checkcast 126	java/util/Map
          //   597: aload 8
          //   599: invokeinterface 181 1 0
          //   604: checkcast 132	java/lang/Long
          //   607: invokevirtual 185	java/lang/Long:longValue	()J
          //   610: invokevirtual 190	com/baidu/carlife/k/n$a:a	(Ljava/lang/String;Ljava/util/Map;J)Lorg/json/JSONObject;
          //   613: pop
          //   614: goto -53 -> 561
          //   617: aload 5
          //   619: aload 7
          //   621: invokevirtual 193	com/baidu/carlife/k/n:a	(Lcom/baidu/carlife/k/n$a;)V
          //   624: aload 5
          //   626: invokevirtual 196	com/baidu/carlife/k/n:toPostRequest	()V
          //   629: return
          //   630: astore 5
          //   632: goto -537 -> 95
          //   635: astore 6
          //   637: goto -228 -> 409
          //   640: astore 9
          //   642: goto -293 -> 349
          //   645: astore 5
          //   647: goto -143 -> 504
          //   650: astore 6
          //   652: goto -168 -> 484
          //   655: astore 8
          //   657: aload 6
          //   659: astore 7
          //   661: aload 8
          //   663: astore 6
          //   665: goto -181 -> 484
          //   668: astore 6
          //   670: aload 8
          //   672: astore 6
          //   674: goto -224 -> 450
          //   677: astore 7
          //   679: goto -229 -> 450
          //   682: astore 5
          //   684: goto -440 -> 244
          //   687: astore 5
          //   689: aload 9
          //   691: astore 6
          //   693: aload 10
          //   695: astore 5
          //   697: goto -473 -> 224
          //   700: astore 6
          //   702: aload 9
          //   704: astore 6
          //   706: goto -482 -> 224
          //   709: astore 7
          //   711: aload 5
          //   713: astore 6
          //   715: aload 7
          //   717: astore 5
          //   719: goto -320 -> 399
          //   722: astore 6
          //   724: goto -345 -> 379
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	727	0	this	1
          //   282	83	1	i	int
          //   280	6	2	j	int
          //   342	2	3	l	long
          //   35	317	5	localObject1	Object
          //   368	1	5	localIOException1	java.io.IOException
          //   373	1	5	localIOException2	java.io.IOException
          //   377	8	5	localObject2	Object
          //   392	1	5	localIOException3	java.io.IOException
          //   397	31	5	localObject3	Object
          //   435	1	5	localIOException4	java.io.IOException
          //   440	1	5	localIOException5	java.io.IOException
          //   444	22	5	localObject4	Object
          //   473	1	5	localIOException6	java.io.IOException
          //   482	143	5	localObject5	Object
          //   630	1	5	localIOException7	java.io.IOException
          //   645	1	5	localIOException8	java.io.IOException
          //   682	1	5	localIOException9	java.io.IOException
          //   687	1	5	localFileNotFoundException1	java.io.FileNotFoundException
          //   695	23	5	localObject6	Object
          //   96	360	6	localObject7	Object
          //   478	70	6	localObject8	Object
          //   559	13	6	localIterator	java.util.Iterator
          //   635	1	6	localIOException10	java.io.IOException
          //   650	8	6	localObject9	Object
          //   663	1	6	localObject10	Object
          //   668	1	6	localIOException11	java.io.IOException
          //   672	20	6	localObject11	Object
          //   700	1	6	localFileNotFoundException2	java.io.FileNotFoundException
          //   704	10	6	localObject12	Object
          //   722	1	6	localIOException12	java.io.IOException
          //   99	115	7	str	String
          //   222	1	7	localFileNotFoundException3	java.io.FileNotFoundException
          //   275	385	7	localObject13	Object
          //   677	1	7	localIOException13	java.io.IOException
          //   709	7	7	localObject14	Object
          //   169	429	8	localObject15	Object
          //   655	16	8	localObject16	Object
          //   175	161	9	arrayOfString	String[]
          //   640	63	9	localException	Exception
          //   166	528	10	localObject17	Object
          //   163	318	11	localObject18	Object
          //   157	88	12	localStringBuffer	StringBuffer
          //   79	103	13	localFile	File
          // Exception table:
          //   from	to	target	type
          //   199	206	222	java/io/FileNotFoundException
          //   211	219	222	java/io/FileNotFoundException
          //   145	150	368	java/io/IOException
          //   101	113	373	java/io/IOException
          //   384	389	392	java/io/IOException
          //   101	113	397	finally
          //   417	422	435	java/io/IOException
          //   427	432	435	java/io/IOException
          //   177	188	440	java/io/IOException
          //   455	460	473	java/io/IOException
          //   465	470	473	java/io/IOException
          //   177	188	478	finally
          //   89	95	630	java/io/IOException
          //   404	409	635	java/io/IOException
          //   335	343	640	java/lang/Exception
          //   489	494	645	java/io/IOException
          //   499	504	645	java/io/IOException
          //   188	199	650	finally
          //   199	206	655	finally
          //   211	219	655	finally
          //   188	199	668	java/io/IOException
          //   199	206	677	java/io/IOException
          //   211	219	677	java/io/IOException
          //   229	234	682	java/io/IOException
          //   239	244	682	java/io/IOException
          //   177	188	687	java/io/FileNotFoundException
          //   188	199	700	java/io/FileNotFoundException
          //   113	140	709	finally
          //   113	140	722	java/io/IOException
        }
      }).start();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +12 -> 20
    //   11: getstatic 47	com/baidu/carlife/util/s:b	Ljava/lang/String;
    //   14: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 137	org/json/JSONObject:toString	()Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne -10 -> 20
    //   33: new 196	java/io/File
    //   36: dup
    //   37: getstatic 47	com/baidu/carlife/util/s:b	Ljava/lang/String;
    //   40: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_0
    //   45: invokevirtual 210	java/io/File:exists	()Z
    //   48: ifne +8 -> 56
    //   51: aload_0
    //   52: invokevirtual 339	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 196	java/io/File
    //   59: dup
    //   60: new 198	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   67: getstatic 47	com/baidu/carlife/util/s:b	Ljava/lang/String;
    //   70: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: aload 4
    //   93: invokevirtual 342	java/io/File:createNewFile	()Z
    //   96: pop
    //   97: aload_1
    //   98: astore_0
    //   99: new 344	java/io/FileWriter
    //   102: dup
    //   103: aload 4
    //   105: iconst_0
    //   106: invokespecial 347	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   109: astore_1
    //   110: aload_1
    //   111: aload_3
    //   112: invokevirtual 350	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: invokevirtual 353	java/io/FileWriter:flush	()V
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 354	java/io/FileWriter:close	()V
    //   127: return
    //   128: astore_0
    //   129: ldc 12
    //   131: aload_0
    //   132: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   135: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: return
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: aload_0
    //   143: astore_2
    //   144: aload_1
    //   145: astore_0
    //   146: ldc 12
    //   148: aload_2
    //   149: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   152: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_1
    //   156: ifnull -136 -> 20
    //   159: aload_1
    //   160: invokevirtual 354	java/io/FileWriter:close	()V
    //   163: return
    //   164: astore_0
    //   165: ldc 12
    //   167: aload_0
    //   168: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   171: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: return
    //   175: astore_1
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 354	java/io/FileWriter:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: astore_0
    //   187: ldc 12
    //   189: aload_0
    //   190: invokevirtual 229	java/io/IOException:toString	()Ljava/lang/String;
    //   193: invokestatic 190	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -12 -> 184
    //   199: astore_2
    //   200: aload_1
    //   201: astore_0
    //   202: aload_2
    //   203: astore_1
    //   204: goto -28 -> 176
    //   207: astore_2
    //   208: goto -64 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramJSONObject	JSONObject
    //   0	211	1	paramString	String
    //   88	61	2	localJSONObject	JSONObject
    //   199	4	2	localObject	Object
    //   207	1	2	localIOException	java.io.IOException
    //   25	87	3	str	String
    //   83	21	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	127	128	java/io/IOException
    //   91	97	139	java/io/IOException
    //   99	110	139	java/io/IOException
    //   159	163	164	java/io/IOException
    //   91	97	175	finally
    //   99	110	175	finally
    //   146	155	175	finally
    //   180	184	186	java/io/IOException
    //   110	119	199	finally
    //   110	119	207	java/io/IOException
  }
  
  public static void a(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    b = f.jm + File.separator + "mobile/log/";
    BaiduNaviApplication localBaiduNaviApplication = BaiduNaviApplication.getInstance();
    if ((localBaiduNaviApplication == null) || ((paramBoolean1) && (!k))) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        s.a(this.a, paramBoolean1, s.m, s.l, paramBoolean2, paramBoolean3, paramBoolean4);
      }
    }).start();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */