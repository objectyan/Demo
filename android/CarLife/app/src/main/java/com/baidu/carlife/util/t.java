package com.baidu.carlife.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.p.a;
import com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto.CarlifeStatisticsInfo;
import com.baidu.navi.util.StatisticManager;
import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class t
{
  public static final String a = "StatisticVehicleUtil";
  public static final String b = f.jm + File.separator + "vehicle/log/";
  public static final String c = "CarlifeVechicleCrash.log";
  public static int d = 120000;
  private static Timer e = null;
  private static TimerTask f = null;
  private static Handler g = null;
  
  public static void a()
  {
    i.e("StatisticVehicleUtil", "Carlife Statstic Connect Timer Stop");
    if (e != null)
    {
      e.cancel();
      e = null;
    }
    if (g != null) {
      g = null;
    }
    if (f != null)
    {
      f.cancel();
      f = null;
    }
  }
  
  public static void a(Context paramContext, final com.baidu.carlife.core.screen.e parame)
  {
    
    try
    {
      i.e("StatisticVehicleUtil", "Carlife Statstic Connect Timer Start");
      e = new Timer();
      g = new Handler();
      f = new TimerTask()
      {
        public void run()
        {
          i.e("StatisticVehicleUtil", "Carlife Statstic Connect Timeout 1");
          if (t.b() != null)
          {
            i.e("StatisticVehicleUtil", "Carlife Statstic Connect Timeout 2");
            if (t.c() != null) {
              t.c().post(new Runnable()
              {
                public void run()
                {
                  x.a(t.2.this.a, t.2.this.b);
                }
              });
            }
            t.a();
          }
        }
      };
      e.schedule(f, d);
      return;
    }
    catch (Exception paramContext)
    {
      i.b("StatisticVehicleUtil", "startTimer get exception");
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    int j = paramCarlifeStatisticsInfo.getConnectCount();
    int i = 0;
    while (i < j)
    {
      StatisticManager.onEvent("1031");
      i += 1;
    }
    StatisticManager.onEvent("1032");
    StatisticManager.onEventDuration(paramContext, "1033", "1033", paramCarlifeStatisticsInfo.getConnectTime());
  }
  
  public static void a(final CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    BaiduNaviApplication localBaiduNaviApplication = BaiduNaviApplication.getInstance();
    if ((localBaiduNaviApplication == null) || (paramCarlifeStatisticsInfo == null)) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        t.a(this.a, paramCarlifeStatisticsInfo);
        t.b(this.a, paramCarlifeStatisticsInfo);
        t.c(this.a, paramCarlifeStatisticsInfo);
      }
    }).start();
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 44	java/io/File
    //   3: dup
    //   4: getstatic 55	com/baidu/carlife/util/t:b	Ljava/lang/String;
    //   7: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 157	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 160	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 30	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   30: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   33: invokestatic 172	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc -82
    //   41: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_1
    //   48: new 44	java/io/File
    //   51: dup
    //   52: new 30	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   59: getstatic 55	com/baidu/carlife/util/t:b	Ljava/lang/String;
    //   62: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: aconst_null
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_3
    //   81: aload 4
    //   83: invokevirtual 157	java/io/File:exists	()Z
    //   86: ifne +41 -> 127
    //   89: aload_2
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 177	java/io/File:createNewFile	()Z
    //   96: pop
    //   97: aload_2
    //   98: astore_1
    //   99: new 179	java/io/FileWriter
    //   102: dup
    //   103: aload 4
    //   105: iconst_0
    //   106: invokespecial 182	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   109: astore_2
    //   110: aload_2
    //   111: aload_0
    //   112: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 188	java/io/FileWriter:flush	()V
    //   119: aload_2
    //   120: ifnull +59 -> 179
    //   123: aload_2
    //   124: invokevirtual 191	java/io/FileWriter:close	()V
    //   127: return
    //   128: astore_0
    //   129: return
    //   130: astore_2
    //   131: aload_3
    //   132: astore_0
    //   133: aload_0
    //   134: astore_1
    //   135: aload_2
    //   136: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   139: aload_0
    //   140: ifnull -13 -> 127
    //   143: aload_0
    //   144: invokevirtual 191	java/io/FileWriter:close	()V
    //   147: return
    //   148: astore_0
    //   149: return
    //   150: astore_0
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 191	java/io/FileWriter:close	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_1
    //   162: goto -3 -> 159
    //   165: astore_0
    //   166: aload_2
    //   167: astore_1
    //   168: goto -17 -> 151
    //   171: astore_1
    //   172: aload_2
    //   173: astore_0
    //   174: aload_1
    //   175: astore_2
    //   176: goto -43 -> 133
    //   179: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString	String
    //   10	146	1	localObject1	Object
    //   161	1	1	localIOException1	java.io.IOException
    //   167	1	1	localObject2	Object
    //   171	4	1	localIOException2	java.io.IOException
    //   78	46	2	localFileWriter	java.io.FileWriter
    //   130	43	2	localIOException3	java.io.IOException
    //   175	1	2	localIOException4	java.io.IOException
    //   80	52	3	localObject3	Object
    //   75	29	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	127	128	java/io/IOException
    //   91	97	130	java/io/IOException
    //   99	110	130	java/io/IOException
    //   143	147	148	java/io/IOException
    //   91	97	150	finally
    //   99	110	150	finally
    //   135	139	150	finally
    //   155	159	161	java/io/IOException
    //   110	119	165	finally
    //   110	119	171	java/io/IOException
  }
  
  public static void b(Context paramContext, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    Object localObject = p.a().a("connectedTime", "");
    paramContext = (Context)localObject;
    if (((String)localObject).split(",").length > 1000)
    {
      paramContext = null;
      p.a().c("connectedTime");
    }
    if (TextUtils.isEmpty(paramContext)) {}
    for (paramContext = String.valueOf(new Date().getTime() / 1000L);; paramContext = paramContext + "," + String.valueOf(new Date().getTime() / 1000L))
    {
      p.a().b("connectedTime", paramContext);
      if (com.baidu.carlife.core.e.a().r())
      {
        localObject = new com.baidu.carlife.k.p();
        localObject.getClass();
        p.a locala = new p.a((com.baidu.carlife.k.p)localObject);
        locala.b = paramCarlifeStatisticsInfo.getCuid();
        locala.a = paramCarlifeStatisticsInfo.getChannel();
        locala.c = paramCarlifeStatisticsInfo.getVersionName();
        locala.d = locala.a(paramContext);
        ((com.baidu.carlife.k.p)localObject).a(locala);
        ((com.baidu.carlife.k.p)localObject).toPostRequest();
      }
      return;
    }
  }
  
  /* Error */
  public static void c(Context paramContext, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 282	com/baidu/carlife/protobuf/CarlifeStatisticsInfoProto$CarlifeStatisticsInfo:getCrashLog	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +66 -> 75
    //   12: new 30	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 284
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 5
    //   34: aconst_null
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_0
    //   39: ldc 18
    //   41: ldc_w 285
    //   44: invokevirtual 291	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_2
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: aload 5
    //   59: invokevirtual 295	java/lang/String:getBytes	()[B
    //   62: invokevirtual 300	java/io/FileOutputStream:write	([B)V
    //   65: aload 4
    //   67: ifnull +8 -> 75
    //   70: aload 4
    //   72: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   75: aconst_null
    //   76: astore 5
    //   78: aconst_null
    //   79: astore_3
    //   80: aconst_null
    //   81: astore 8
    //   83: aconst_null
    //   84: astore 7
    //   86: aload 7
    //   88: astore_2
    //   89: aload 8
    //   91: astore 4
    //   93: aload_0
    //   94: ldc 18
    //   96: invokevirtual 305	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   99: astore 6
    //   101: aload 7
    //   103: astore_2
    //   104: aload 6
    //   106: astore_3
    //   107: aload 8
    //   109: astore 4
    //   111: aload 6
    //   113: astore 5
    //   115: sipush 1024
    //   118: newarray <illegal type>
    //   120: astore 10
    //   122: aload 7
    //   124: astore_2
    //   125: aload 6
    //   127: astore_3
    //   128: aload 8
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: new 307	java/io/ByteArrayOutputStream
    //   139: dup
    //   140: invokespecial 308	java/io/ByteArrayOutputStream:<init>	()V
    //   143: astore 9
    //   145: aload 7
    //   147: astore_2
    //   148: aload 6
    //   150: astore_3
    //   151: aload 8
    //   153: astore 4
    //   155: aload 6
    //   157: astore 5
    //   159: aload 6
    //   161: aload 10
    //   163: invokevirtual 314	java/io/FileInputStream:read	([B)I
    //   166: iconst_m1
    //   167: if_icmpeq +104 -> 271
    //   170: aload 7
    //   172: astore_2
    //   173: aload 6
    //   175: astore_3
    //   176: aload 8
    //   178: astore 4
    //   180: aload 6
    //   182: astore 5
    //   184: aload 9
    //   186: aload 10
    //   188: iconst_0
    //   189: aload 10
    //   191: arraylength
    //   192: invokevirtual 317	java/io/ByteArrayOutputStream:write	([BII)V
    //   195: goto -50 -> 145
    //   198: astore 4
    //   200: aload 4
    //   202: invokevirtual 318	java/io/FileNotFoundException:printStackTrace	()V
    //   205: aload_2
    //   206: ifnull +9 -> 215
    //   209: aload_2
    //   210: arraylength
    //   211: iconst_1
    //   212: if_icmpge +141 -> 353
    //   215: return
    //   216: astore_2
    //   217: aload_2
    //   218: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   221: goto -146 -> 75
    //   224: astore 4
    //   226: aload_2
    //   227: astore_3
    //   228: aload 4
    //   230: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   233: aload_2
    //   234: ifnull -159 -> 75
    //   237: aload_2
    //   238: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   241: goto -166 -> 75
    //   244: astore_2
    //   245: aload_2
    //   246: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   249: goto -174 -> 75
    //   252: astore_0
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   261: aload_0
    //   262: athrow
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   268: goto -7 -> 261
    //   271: aload 7
    //   273: astore_2
    //   274: aload 6
    //   276: astore_3
    //   277: aload 8
    //   279: astore 4
    //   281: aload 6
    //   283: astore 5
    //   285: aload 9
    //   287: invokevirtual 319	java/io/ByteArrayOutputStream:flush	()V
    //   290: aload 7
    //   292: astore_2
    //   293: aload 6
    //   295: astore_3
    //   296: aload 8
    //   298: astore 4
    //   300: aload 6
    //   302: astore 5
    //   304: aload 9
    //   306: invokevirtual 322	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   309: astore 7
    //   311: aload 7
    //   313: astore_2
    //   314: aload 6
    //   316: astore_3
    //   317: aload 7
    //   319: astore 4
    //   321: aload 6
    //   323: astore 5
    //   325: aload 9
    //   327: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   330: aload 7
    //   332: astore_2
    //   333: aload 6
    //   335: astore_3
    //   336: goto -131 -> 205
    //   339: astore_2
    //   340: aload_2
    //   341: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   344: aload 4
    //   346: astore_2
    //   347: aload 5
    //   349: astore_3
    //   350: goto -145 -> 205
    //   353: aconst_null
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 4
    //   359: aload_0
    //   360: ldc_w 325
    //   363: iconst_0
    //   364: invokevirtual 291	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   367: astore 6
    //   369: aload 6
    //   371: astore 4
    //   373: aload 6
    //   375: astore 5
    //   377: aload_2
    //   378: aload 6
    //   380: invokestatic 330	com/baidu/carlife/util/h:a	([BLjava/io/FileOutputStream;)V
    //   383: aload_3
    //   384: ifnull +7 -> 391
    //   387: aload_3
    //   388: invokevirtual 331	java/io/FileInputStream:close	()V
    //   391: aload 6
    //   393: ifnull +8 -> 401
    //   396: aload 6
    //   398: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   401: aconst_null
    //   402: astore_2
    //   403: aload_0
    //   404: ldc_w 325
    //   407: invokevirtual 305	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   410: astore_0
    //   411: aload_0
    //   412: astore_3
    //   413: aload_0
    //   414: astore_2
    //   415: invokestatic 236	com/baidu/carlife/core/e:a	()Lcom/baidu/carlife/core/e;
    //   418: invokevirtual 239	com/baidu/carlife/core/e:r	()Z
    //   421: ifeq +31 -> 452
    //   424: aload_0
    //   425: astore_3
    //   426: aload_0
    //   427: ifnull +25 -> 452
    //   430: aload_0
    //   431: astore_2
    //   432: new 333	com/baidu/carlife/k/o
    //   435: dup
    //   436: aload_1
    //   437: invokevirtual 263	com/baidu/carlife/protobuf/CarlifeStatisticsInfoProto$CarlifeStatisticsInfo:getVersionName	()Ljava/lang/String;
    //   440: ldc_w 325
    //   443: aload_0
    //   444: invokespecial 336	com/baidu/carlife/k/o:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   447: invokevirtual 337	com/baidu/carlife/k/o:toPostRequest	()V
    //   450: aload_0
    //   451: astore_3
    //   452: aload_3
    //   453: ifnull -238 -> 215
    //   456: aload_3
    //   457: invokevirtual 340	java/io/InputStream:close	()V
    //   460: return
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   466: return
    //   467: astore_2
    //   468: aload_2
    //   469: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   472: goto -71 -> 401
    //   475: astore_2
    //   476: aload 4
    //   478: astore 5
    //   480: aload_2
    //   481: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   484: aload_3
    //   485: ifnull +7 -> 492
    //   488: aload_3
    //   489: invokevirtual 331	java/io/FileInputStream:close	()V
    //   492: aload 4
    //   494: ifnull -93 -> 401
    //   497: aload 4
    //   499: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   502: goto -101 -> 401
    //   505: astore_2
    //   506: aload_2
    //   507: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   510: goto -109 -> 401
    //   513: astore_0
    //   514: aload_3
    //   515: ifnull +7 -> 522
    //   518: aload_3
    //   519: invokevirtual 331	java/io/FileInputStream:close	()V
    //   522: aload 5
    //   524: ifnull +8 -> 532
    //   527: aload 5
    //   529: invokevirtual 301	java/io/FileOutputStream:close	()V
    //   532: aload_0
    //   533: athrow
    //   534: astore_1
    //   535: aload_1
    //   536: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   539: goto -7 -> 532
    //   542: astore_0
    //   543: aload_0
    //   544: invokevirtual 318	java/io/FileNotFoundException:printStackTrace	()V
    //   547: aload_2
    //   548: astore_3
    //   549: goto -97 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	paramContext	Context
    //   0	552	1	paramCarlifeStatisticsInfo	CarlifeStatisticsInfoProto.CarlifeStatisticsInfo
    //   4	206	2	localObject1	Object
    //   216	22	2	localIOException1	java.io.IOException
    //   244	2	2	localIOException2	java.io.IOException
    //   273	60	2	localObject2	Object
    //   339	2	2	localIOException3	java.io.IOException
    //   346	86	2	localObject3	Object
    //   467	2	2	localIOException4	java.io.IOException
    //   475	6	2	localException1	Exception
    //   505	43	2	localIOException5	java.io.IOException
    //   35	514	3	localObject4	Object
    //   47	132	4	localObject5	Object
    //   198	3	4	localFileNotFoundException	java.io.FileNotFoundException
    //   224	5	4	localException2	Exception
    //   279	219	4	localObject6	Object
    //   32	496	5	localObject7	Object
    //   99	298	6	localObject8	Object
    //   84	247	7	arrayOfByte1	byte[]
    //   81	216	8	localObject9	Object
    //   143	183	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   120	70	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	101	198	java/io/FileNotFoundException
    //   115	122	198	java/io/FileNotFoundException
    //   136	145	198	java/io/FileNotFoundException
    //   159	170	198	java/io/FileNotFoundException
    //   184	195	198	java/io/FileNotFoundException
    //   285	290	198	java/io/FileNotFoundException
    //   304	311	198	java/io/FileNotFoundException
    //   325	330	198	java/io/FileNotFoundException
    //   70	75	216	java/io/IOException
    //   38	49	224	java/lang/Exception
    //   55	65	224	java/lang/Exception
    //   237	241	244	java/io/IOException
    //   38	49	252	finally
    //   55	65	252	finally
    //   228	233	252	finally
    //   257	261	263	java/io/IOException
    //   93	101	339	java/io/IOException
    //   115	122	339	java/io/IOException
    //   136	145	339	java/io/IOException
    //   159	170	339	java/io/IOException
    //   184	195	339	java/io/IOException
    //   285	290	339	java/io/IOException
    //   304	311	339	java/io/IOException
    //   325	330	339	java/io/IOException
    //   456	460	461	java/io/IOException
    //   387	391	467	java/io/IOException
    //   396	401	467	java/io/IOException
    //   359	369	475	java/lang/Exception
    //   377	383	475	java/lang/Exception
    //   488	492	505	java/io/IOException
    //   497	502	505	java/io/IOException
    //   359	369	513	finally
    //   377	383	513	finally
    //   480	484	513	finally
    //   518	522	534	java/io/IOException
    //   527	532	534	java/io/IOException
    //   403	411	542	java/io/FileNotFoundException
    //   415	424	542	java/io/FileNotFoundException
    //   432	450	542	java/io/FileNotFoundException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */