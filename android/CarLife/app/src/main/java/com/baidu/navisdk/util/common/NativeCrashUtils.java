package com.baidu.navisdk.util.common;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeCrashUtils
{
  private static final String BACKUP_DMP_FILENAME = "backupdmp.backupdmp";
  public static final String BP_FOLDER = "/log/bp";
  public static final boolean DEBUG = false;
  public static final int HEAD_INFO_LENGTH = 1024;
  public static final String TAG = "NativeCrashUtils";
  public static final String UPLOAD_LOG_NAVI_URL = HttpURLManager.getInstance().getScheme() + "navimon.baidu.com/hunter/log/post";
  public static final String UPLOAD_LOG_URL;
  public static final boolean UPLOAD_ONLY_WIFI = false;
  public static final String UPLOAD_PROTOCOL_URL = HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/imap/ulog/open";
  private static Handler mHandler = null;
  
  static
  {
    UPLOAD_LOG_URL = HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/imap/ulog/upc";
  }
  
  /* Error */
  private static void checkNativeCrash()
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   5: invokestatic 102	com/baidu/navisdk/util/common/NativeCrashUtils:getBPDirPath	()Ljava/lang/String;
    //   8: astore 12
    //   10: aload 12
    //   12: ifnull +11 -> 23
    //   15: aload 12
    //   17: invokevirtual 108	java/lang/String:length	()I
    //   20: ifne +4 -> 24
    //   23: return
    //   24: new 110	java/io/File
    //   27: dup
    //   28: aload 12
    //   30: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 116	java/io/File:exists	()Z
    //   38: ifeq -15 -> 23
    //   41: aload_3
    //   42: invokevirtual 119	java/io/File:isDirectory	()Z
    //   45: ifeq -22 -> 23
    //   48: aload_3
    //   49: new 12	com/baidu/navisdk/util/common/NativeCrashUtils$3
    //   52: dup
    //   53: invokespecial 120	com/baidu/navisdk/util/common/NativeCrashUtils$3:<init>	()V
    //   56: invokevirtual 124	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   59: astore 13
    //   61: aload 13
    //   63: ifnull -40 -> 23
    //   66: aload 13
    //   68: arraylength
    //   69: ifeq -46 -> 23
    //   72: aload 13
    //   74: arraylength
    //   75: istore_2
    //   76: iconst_0
    //   77: istore_0
    //   78: iload_0
    //   79: iload_2
    //   80: if_icmpge -57 -> 23
    //   83: aload 13
    //   85: iload_0
    //   86: aaload
    //   87: astore 14
    //   89: new 41	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   96: ldc 126
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 14
    //   103: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   115: aconst_null
    //   116: astore 11
    //   118: aconst_null
    //   119: astore 4
    //   121: aconst_null
    //   122: astore 5
    //   124: aconst_null
    //   125: astore 10
    //   127: aconst_null
    //   128: astore 7
    //   130: aconst_null
    //   131: astore 8
    //   133: aconst_null
    //   134: astore 9
    //   136: aconst_null
    //   137: astore 6
    //   139: new 131	java/io/ByteArrayOutputStream
    //   142: dup
    //   143: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   146: astore_3
    //   147: new 134	java/util/zip/GZIPOutputStream
    //   150: dup
    //   151: aload_3
    //   152: invokespecial 137	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   155: astore 4
    //   157: sipush 1024
    //   160: newarray <illegal type>
    //   162: astore 10
    //   164: new 104	java/lang/String
    //   167: dup
    //   168: invokestatic 140	com/baidu/navisdk/util/common/NativeCrashUtils:generateCrashLogHead	()Ljava/lang/String;
    //   171: invokevirtual 144	java/lang/String:getBytes	()[B
    //   174: ldc -110
    //   176: invokespecial 149	java/lang/String:<init>	([BLjava/lang/String;)V
    //   179: ldc -110
    //   181: invokevirtual 152	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   184: astore 5
    //   186: aload 5
    //   188: arraylength
    //   189: sipush 1024
    //   192: if_icmple +52 -> 244
    //   195: ldc -102
    //   197: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   200: iconst_0
    //   201: ifeq +11 -> 212
    //   204: new 156	java/lang/NullPointerException
    //   207: dup
    //   208: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   211: athrow
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   222: aload_3
    //   223: ifnull +7 -> 230
    //   226: aload_3
    //   227: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   230: iconst_0
    //   231: ifeq -208 -> 23
    //   234: new 156	java/lang/NullPointerException
    //   237: dup
    //   238: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   241: athrow
    //   242: astore_3
    //   243: return
    //   244: new 41	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   251: ldc -93
    //   253: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: arraylength
    //   259: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc -88
    //   264: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: new 104	java/lang/String
    //   270: dup
    //   271: aload 5
    //   273: ldc -110
    //   275: invokespecial 149	java/lang/String:<init>	([BLjava/lang/String;)V
    //   278: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   287: aload 4
    //   289: aload 5
    //   291: iconst_0
    //   292: aload 5
    //   294: arraylength
    //   295: invokevirtual 172	java/util/zip/GZIPOutputStream:write	([BII)V
    //   298: iconst_0
    //   299: istore_1
    //   300: iload_1
    //   301: sipush 1024
    //   304: aload 5
    //   306: arraylength
    //   307: isub
    //   308: if_icmpge +23 -> 331
    //   311: aload 4
    //   313: iconst_1
    //   314: newarray <illegal type>
    //   316: dup
    //   317: iconst_0
    //   318: bipush 32
    //   320: bastore
    //   321: invokevirtual 175	java/util/zip/GZIPOutputStream:write	([B)V
    //   324: iload_1
    //   325: iconst_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -28 -> 300
    //   331: new 110	java/io/File
    //   334: dup
    //   335: new 41	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   342: aload 12
    //   344: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: getstatic 178	java/io/File:separator	Ljava/lang/String;
    //   350: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc 19
    //   355: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   364: astore 5
    //   366: aload 5
    //   368: invokevirtual 116	java/io/File:exists	()Z
    //   371: ifeq +9 -> 380
    //   374: aload 5
    //   376: invokevirtual 181	java/io/File:delete	()Z
    //   379: pop
    //   380: new 183	java/io/FileOutputStream
    //   383: dup
    //   384: aload 5
    //   386: invokespecial 186	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   389: astore 5
    //   391: new 188	java/io/FileInputStream
    //   394: dup
    //   395: aload 14
    //   397: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   400: astore 6
    //   402: aload 6
    //   404: aload 10
    //   406: iconst_0
    //   407: aload 10
    //   409: arraylength
    //   410: invokevirtual 193	java/io/FileInputStream:read	([BII)I
    //   413: istore_1
    //   414: iload_1
    //   415: iconst_m1
    //   416: if_icmpeq +81 -> 497
    //   419: aload 4
    //   421: aload 10
    //   423: iconst_0
    //   424: iload_1
    //   425: invokevirtual 172	java/util/zip/GZIPOutputStream:write	([BII)V
    //   428: aload 4
    //   430: invokevirtual 196	java/util/zip/GZIPOutputStream:flush	()V
    //   433: aload 5
    //   435: aload 10
    //   437: iconst_0
    //   438: iload_1
    //   439: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
    //   442: aload 5
    //   444: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   447: goto -45 -> 402
    //   450: astore 7
    //   452: aload 6
    //   454: ifnull +8 -> 462
    //   457: aload 6
    //   459: invokevirtual 199	java/io/FileInputStream:close	()V
    //   462: aload 4
    //   464: ifnull +8 -> 472
    //   467: aload 4
    //   469: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   472: aload_3
    //   473: ifnull +7 -> 480
    //   476: aload_3
    //   477: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   480: aload 5
    //   482: ifnull +8 -> 490
    //   485: aload 5
    //   487: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   490: iload_0
    //   491: iconst_1
    //   492: iadd
    //   493: istore_0
    //   494: goto -416 -> 78
    //   497: aload 4
    //   499: invokevirtual 203	java/util/zip/GZIPOutputStream:finish	()V
    //   502: aload_3
    //   503: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   506: astore 7
    //   508: new 41	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   515: ldc -48
    //   517: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 7
    //   522: arraylength
    //   523: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   532: aload 14
    //   534: invokevirtual 211	java/io/File:getName	()Ljava/lang/String;
    //   537: aload 7
    //   539: invokestatic 215	com/baidu/navisdk/util/common/NativeCrashUtils:uploadCrashLog	(Ljava/lang/String;[B)Z
    //   542: ifeq +214 -> 756
    //   545: ldc -39
    //   547: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   550: invokestatic 221	com/baidu/navisdk/util/common/NativeCrashUtils:getBackProtocolJSON	()Lorg/json/JSONObject;
    //   553: astore 7
    //   555: aload 7
    //   557: ifnull +191 -> 748
    //   560: aload 7
    //   562: invokevirtual 224	org/json/JSONObject:toString	()Ljava/lang/String;
    //   565: invokevirtual 144	java/lang/String:getBytes	()[B
    //   568: invokestatic 228	com/baidu/navisdk/util/common/NativeCrashUtils:gzipBytes	([B)[B
    //   571: astore 7
    //   573: new 41	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   580: ldc -26
    //   582: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 7
    //   587: arraylength
    //   588: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   597: aload 7
    //   599: ifnull +141 -> 740
    //   602: aload 7
    //   604: arraylength
    //   605: ifle +135 -> 740
    //   608: ldc -24
    //   610: aload 7
    //   612: invokestatic 235	com/baidu/navisdk/util/common/NativeCrashUtils:uploadBackProtocolToServer	(Ljava/lang/String;[B)Z
    //   615: ifeq +54 -> 669
    //   618: ldc -19
    //   620: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   623: aload 13
    //   625: invokestatic 241	com/baidu/navisdk/util/common/NativeCrashUtils:deleteFiles	([Ljava/io/File;)V
    //   628: aload 6
    //   630: ifnull +8 -> 638
    //   633: aload 6
    //   635: invokevirtual 199	java/io/FileInputStream:close	()V
    //   638: aload 4
    //   640: ifnull +8 -> 648
    //   643: aload 4
    //   645: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   648: aload_3
    //   649: ifnull +7 -> 656
    //   652: aload_3
    //   653: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   656: aload 5
    //   658: ifnull +8 -> 666
    //   661: aload 5
    //   663: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   666: goto -176 -> 490
    //   669: ldc -13
    //   671: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   674: goto -46 -> 628
    //   677: astore 7
    //   679: aload 5
    //   681: astore 8
    //   683: aload 4
    //   685: astore 5
    //   687: aload 7
    //   689: astore 4
    //   691: aload 6
    //   693: astore 7
    //   695: aload 8
    //   697: astore 6
    //   699: aload 7
    //   701: ifnull +8 -> 709
    //   704: aload 7
    //   706: invokevirtual 199	java/io/FileInputStream:close	()V
    //   709: aload 5
    //   711: ifnull +8 -> 719
    //   714: aload 5
    //   716: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   719: aload_3
    //   720: ifnull +7 -> 727
    //   723: aload_3
    //   724: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   727: aload 6
    //   729: ifnull +8 -> 737
    //   732: aload 6
    //   734: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   737: aload 4
    //   739: athrow
    //   740: ldc -11
    //   742: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   745: goto -117 -> 628
    //   748: ldc -9
    //   750: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   753: goto -125 -> 628
    //   756: ldc -7
    //   758: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   761: goto -133 -> 628
    //   764: astore_3
    //   765: goto -28 -> 737
    //   768: astore 4
    //   770: aload 9
    //   772: astore 6
    //   774: aload 11
    //   776: astore_3
    //   777: goto -78 -> 699
    //   780: astore 4
    //   782: aload 9
    //   784: astore 6
    //   786: goto -87 -> 699
    //   789: astore 8
    //   791: aload 9
    //   793: astore 6
    //   795: aload 4
    //   797: astore 5
    //   799: aload 8
    //   801: astore 4
    //   803: goto -104 -> 699
    //   806: astore 8
    //   808: aload 5
    //   810: astore 6
    //   812: aload 4
    //   814: astore 5
    //   816: aload 8
    //   818: astore 4
    //   820: goto -121 -> 699
    //   823: astore_3
    //   824: goto -334 -> 490
    //   827: astore_3
    //   828: aload 6
    //   830: astore 5
    //   832: aload 4
    //   834: astore_3
    //   835: aload 8
    //   837: astore 6
    //   839: aload 10
    //   841: astore 4
    //   843: goto -391 -> 452
    //   846: astore 4
    //   848: aload 6
    //   850: astore 5
    //   852: aload 8
    //   854: astore 6
    //   856: aload 10
    //   858: astore 4
    //   860: goto -408 -> 452
    //   863: astore 5
    //   865: aload 6
    //   867: astore 5
    //   869: aload 8
    //   871: astore 6
    //   873: goto -421 -> 452
    //   876: astore 6
    //   878: aload 8
    //   880: astore 6
    //   882: goto -430 -> 452
    //   885: astore_3
    //   886: goto -220 -> 666
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	417	0	i	int
    //   299	140	1	j	int
    //   75	6	2	k	int
    //   33	194	3	localObject1	Object
    //   242	482	3	localIOException1	java.io.IOException
    //   764	1	3	localIOException2	java.io.IOException
    //   776	1	3	localObject2	Object
    //   823	1	3	localIOException3	java.io.IOException
    //   827	1	3	localException1	Exception
    //   834	1	3	localObject3	Object
    //   885	1	3	localIOException4	java.io.IOException
    //   119	619	4	localObject4	Object
    //   768	1	4	localObject5	Object
    //   780	16	4	localObject6	Object
    //   801	41	4	localObject7	Object
    //   846	1	4	localException2	Exception
    //   858	1	4	localObject8	Object
    //   122	729	5	localObject9	Object
    //   863	1	5	localException3	Exception
    //   867	1	5	localObject10	Object
    //   137	735	6	localObject11	Object
    //   876	1	6	localException4	Exception
    //   880	1	6	localObject12	Object
    //   128	1	7	localObject13	Object
    //   450	1	7	localException5	Exception
    //   506	105	7	localObject14	Object
    //   677	11	7	localObject15	Object
    //   693	12	7	localObject16	Object
    //   131	565	8	localObject17	Object
    //   789	11	8	localObject18	Object
    //   806	73	8	localObject19	Object
    //   134	658	9	localObject20	Object
    //   125	732	10	arrayOfByte	byte[]
    //   116	659	11	localObject21	Object
    //   8	335	12	str	String
    //   59	565	13	arrayOfFile	File[]
    //   87	446	14	localFile	File
    // Exception table:
    //   from	to	target	type
    //   204	212	242	java/io/IOException
    //   217	222	242	java/io/IOException
    //   226	230	242	java/io/IOException
    //   234	242	242	java/io/IOException
    //   402	414	450	java/lang/Exception
    //   419	447	450	java/lang/Exception
    //   497	555	450	java/lang/Exception
    //   560	597	450	java/lang/Exception
    //   602	628	450	java/lang/Exception
    //   669	674	450	java/lang/Exception
    //   740	745	450	java/lang/Exception
    //   748	753	450	java/lang/Exception
    //   756	761	450	java/lang/Exception
    //   402	414	677	finally
    //   419	447	677	finally
    //   497	555	677	finally
    //   560	597	677	finally
    //   602	628	677	finally
    //   669	674	677	finally
    //   740	745	677	finally
    //   748	753	677	finally
    //   756	761	677	finally
    //   704	709	764	java/io/IOException
    //   714	719	764	java/io/IOException
    //   723	727	764	java/io/IOException
    //   732	737	764	java/io/IOException
    //   139	147	768	finally
    //   147	157	780	finally
    //   157	200	789	finally
    //   244	298	789	finally
    //   300	324	789	finally
    //   331	380	789	finally
    //   380	391	789	finally
    //   391	402	806	finally
    //   457	462	823	java/io/IOException
    //   467	472	823	java/io/IOException
    //   476	480	823	java/io/IOException
    //   485	490	823	java/io/IOException
    //   139	147	827	java/lang/Exception
    //   147	157	846	java/lang/Exception
    //   157	200	863	java/lang/Exception
    //   244	298	863	java/lang/Exception
    //   300	324	863	java/lang/Exception
    //   331	380	863	java/lang/Exception
    //   380	391	863	java/lang/Exception
    //   391	402	876	java/lang/Exception
    //   633	638	885	java/io/IOException
    //   643	648	885	java/io/IOException
    //   652	656	885	java/io/IOException
    //   661	666	885	java/io/IOException
  }
  
  private static void deleteFiles(File[] paramArrayOfFile)
  {
    int i = paramArrayOfFile.length - 1;
    while (i >= 0)
    {
      File localFile = paramArrayOfFile[i];
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      i -= 1;
    }
  }
  
  private static JSONObject generateAllAndHeadJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("sv", PackageUtil.strSoftWareVer);
      localJSONObject2.put("os", "android");
      localJSONObject2.put("sw", ScreenUtil.getInstance().getWidthPixels());
      localJSONObject2.put("cuid", PackageUtil.getCuid());
      localJSONObject2.put("pd", "carlife");
      localJSONObject2.put("ch", PackageUtil.getChannel());
      localJSONObject2.put("mb", PackageUtil.strPhoneType);
      localJSONObject2.put("sh", ScreenUtil.getInstance().getHeightPixels());
      localJSONObject2.put("ov", "Android" + Build.VERSION.SDK_INT);
      localJSONObject2.put("ver", "2");
      if (BNaviModuleManager.getContext() != null) {
        localJSONObject2.put("deviceid", PackageUtil.getImeiNum());
      }
      for (;;)
      {
        localJSONObject1.put("head", localJSONObject2);
        return localJSONObject1;
        localJSONObject2.put("deviceid", "");
      }
      return null;
    }
    catch (JSONException localJSONException) {}
  }
  
  private static String generateCrashLogHead()
  {
    String str = "sv:" + PackageUtil.strSoftWareVer + ";os:android;sw:" + ScreenUtil.getInstance().getWidthPixels() + ";cuid:" + PackageUtil.getCuid() + ";pd:carlife;ch:" + PackageUtil.getChannel() + ";mb:" + PackageUtil.strPhoneType + ";sh:" + ScreenUtil.getInstance().getHeightPixels() + ";ov:Android" + Build.VERSION.SDK_INT + ";";
    loge("crashHeadInfo=" + str);
    return str;
  }
  
  private static JSONObject generateLogItem()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (BNaviModuleManager.getContext() == null) {}
      for (Object localObject = "0";; localObject = NetworkUtils.getCurrentNetMode(BNaviModuleManager.getContext()))
      {
        localJSONObject.put("net", localObject);
        localJSONObject.put("lt", "3000");
        localJSONObject.put("tm", "" + new Date().getTime());
        localJSONObject.put("act", "crashlog");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("detail", "unknown");
        ((JSONObject)localObject).put("reason", "unknown");
        localJSONObject.put("ActParam", localObject);
        return localJSONObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  private static String getBPDirPath()
  {
    return SysOSAPI.getInstance().GetSDCardPath() + "/log/bp";
  }
  
  private static JSONObject getBackProtocolJSON()
  {
    JSONObject localJSONObject1 = generateAllAndHeadJSON();
    JSONArray localJSONArray = new JSONArray();
    if (localJSONObject1 == null) {
      return null;
    }
    JSONObject localJSONObject2 = generateLogItem();
    if (localJSONObject2 != null)
    {
      localJSONArray.put(localJSONObject2);
      try
      {
        localJSONObject1.put("log", localJSONArray);
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  private static byte[] gzipBytes(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 41	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 412
    //   21: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: arraylength
    //   26: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   35: aconst_null
    //   36: astore 5
    //   38: aconst_null
    //   39: astore 6
    //   41: aconst_null
    //   42: astore_3
    //   43: aconst_null
    //   44: astore 4
    //   46: new 131	java/io/ByteArrayOutputStream
    //   49: dup
    //   50: invokespecial 132	java/io/ByteArrayOutputStream:<init>	()V
    //   53: astore_1
    //   54: new 134	java/util/zip/GZIPOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 137	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: iconst_0
    //   66: aload_0
    //   67: arraylength
    //   68: invokevirtual 172	java/util/zip/GZIPOutputStream:write	([BII)V
    //   71: aload_2
    //   72: invokevirtual 196	java/util/zip/GZIPOutputStream:flush	()V
    //   75: aload_2
    //   76: invokevirtual 203	java/util/zip/GZIPOutputStream:finish	()V
    //   79: aload_1
    //   80: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   83: astore_0
    //   84: new 41	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 414
    //   94: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: arraylength
    //   99: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 93	com/baidu/navisdk/util/common/NativeCrashUtils:loge	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore_1
    //   127: aload_0
    //   128: areturn
    //   129: astore_0
    //   130: aload 4
    //   132: astore_2
    //   133: aload 6
    //   135: astore_0
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   144: aload_0
    //   145: ifnull -136 -> 9
    //   148: aload_0
    //   149: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: aload_3
    //   159: astore_2
    //   160: aload 5
    //   162: astore_0
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 160	java/util/zip/GZIPOutputStream:close	()V
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore_0
    //   182: goto -3 -> 179
    //   185: astore 4
    //   187: aload_1
    //   188: astore_0
    //   189: aload_3
    //   190: astore_2
    //   191: aload 4
    //   193: astore_1
    //   194: goto -31 -> 163
    //   197: astore_3
    //   198: aload_1
    //   199: astore_0
    //   200: aload_3
    //   201: astore_1
    //   202: goto -39 -> 163
    //   205: astore_0
    //   206: aload_1
    //   207: astore_0
    //   208: aload 4
    //   210: astore_2
    //   211: goto -75 -> 136
    //   214: astore_0
    //   215: aload_1
    //   216: astore_0
    //   217: goto -81 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramArrayOfByte	byte[]
    //   53	68	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   126	1	1	localException	Exception
    //   157	31	1	localObject1	Object
    //   193	23	1	localObject2	Object
    //   62	149	2	localObject3	Object
    //   42	148	3	localObject4	Object
    //   197	4	3	localObject5	Object
    //   44	87	4	localObject6	Object
    //   185	24	4	localObject7	Object
    //   36	125	5	localObject8	Object
    //   39	95	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   112	116	126	java/lang/Exception
    //   120	124	126	java/lang/Exception
    //   46	54	129	java/lang/Exception
    //   140	144	154	java/lang/Exception
    //   148	152	154	java/lang/Exception
    //   46	54	157	finally
    //   167	171	181	java/lang/Exception
    //   175	179	181	java/lang/Exception
    //   54	63	185	finally
    //   63	108	197	finally
    //   54	63	205	java/lang/Exception
    //   63	108	214	java/lang/Exception
  }
  
  private static void initDirs()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/log/bp");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static boolean isNetworkStateOK(int paramInt1, int paramInt2)
  {
    return paramInt1 == 1;
  }
  
  private static void loge(String paramString) {}
  
  /* Error */
  private static void parseDmpWithHead(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 108	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 110	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 116	java/io/File:exists	()Z
    //   23: ifeq -12 -> 11
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 7
    //   37: aconst_null
    //   38: astore 4
    //   40: aconst_null
    //   41: astore 5
    //   43: new 188	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: new 183	java/io/FileOutputStream
    //   55: dup
    //   56: new 41	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 423
    //   70: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: astore_3
    //   80: new 183	java/io/FileOutputStream
    //   83: dup
    //   84: new 41	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 426
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   107: astore_1
    //   108: sipush 1024
    //   111: newarray <illegal type>
    //   113: astore 4
    //   115: aload_0
    //   116: aload 4
    //   118: invokevirtual 429	java/io/FileInputStream:read	([B)I
    //   121: sipush 1024
    //   124: if_icmpne +80 -> 204
    //   127: aload_3
    //   128: aload 4
    //   130: iconst_0
    //   131: sipush 1024
    //   134: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
    //   137: aload_3
    //   138: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   141: aload_0
    //   142: aload 4
    //   144: invokevirtual 429	java/io/FileInputStream:read	([B)I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_m1
    //   150: if_icmpeq +54 -> 204
    //   153: aload_1
    //   154: aload 4
    //   156: iconst_0
    //   157: iload_2
    //   158: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
    //   161: aload_1
    //   162: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   165: goto -24 -> 141
    //   168: astore 4
    //   170: aload_1
    //   171: astore 4
    //   173: aload_3
    //   174: astore_1
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 199	java/io/FileInputStream:close	()V
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   191: aload 4
    //   193: ifnull -182 -> 11
    //   196: aload 4
    //   198: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: astore_0
    //   203: return
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 199	java/io/FileInputStream:close	()V
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: return
    //   231: astore_1
    //   232: aload 6
    //   234: astore_3
    //   235: aload 8
    //   237: astore_0
    //   238: aload_0
    //   239: ifnull +7 -> 246
    //   242: aload_0
    //   243: invokevirtual 199	java/io/FileInputStream:close	()V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   254: aload 4
    //   256: ifnull +8 -> 264
    //   259: aload 4
    //   261: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: astore_0
    //   267: goto -3 -> 264
    //   270: astore_1
    //   271: aload 6
    //   273: astore_3
    //   274: goto -36 -> 238
    //   277: astore_1
    //   278: goto -40 -> 238
    //   281: astore 5
    //   283: aload_1
    //   284: astore 4
    //   286: aload 5
    //   288: astore_1
    //   289: goto -51 -> 238
    //   292: astore_0
    //   293: aload_3
    //   294: astore_0
    //   295: aload 5
    //   297: astore 4
    //   299: aload 7
    //   301: astore_1
    //   302: goto -127 -> 175
    //   305: astore_1
    //   306: aload 5
    //   308: astore 4
    //   310: aload 7
    //   312: astore_1
    //   313: goto -138 -> 175
    //   316: astore_1
    //   317: aload_3
    //   318: astore_1
    //   319: aload 5
    //   321: astore 4
    //   323: goto -148 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString1	String
    //   0	326	1	paramString2	String
    //   147	11	2	i	int
    //   30	288	3	localObject1	Object
    //   38	117	4	arrayOfByte	byte[]
    //   168	1	4	localException	Exception
    //   171	151	4	localObject2	Object
    //   41	1	5	localObject3	Object
    //   281	39	5	localObject4	Object
    //   32	240	6	localObject5	Object
    //   35	276	7	localObject6	Object
    //   27	209	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   108	141	168	java/lang/Exception
    //   141	148	168	java/lang/Exception
    //   153	165	168	java/lang/Exception
    //   179	183	202	java/lang/Exception
    //   187	191	202	java/lang/Exception
    //   196	201	202	java/lang/Exception
    //   208	212	229	java/lang/Exception
    //   216	220	229	java/lang/Exception
    //   224	228	229	java/lang/Exception
    //   43	52	231	finally
    //   242	246	266	java/lang/Exception
    //   250	254	266	java/lang/Exception
    //   259	264	266	java/lang/Exception
    //   52	80	270	finally
    //   80	108	277	finally
    //   108	141	281	finally
    //   141	148	281	finally
    //   153	165	281	finally
    //   43	52	292	java/lang/Exception
    //   52	80	305	java/lang/Exception
    //   80	108	316	java/lang/Exception
  }
  
  /* Error */
  private static void printBytesToGZIPFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: new 183	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokevirtual 431	java/io/FileOutputStream:write	([B)V
    //   27: aload_1
    //   28: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   31: aload_1
    //   32: ifnull +7 -> 39
    //   35: aload_1
    //   36: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   39: return
    //   40: astore_0
    //   41: return
    //   42: astore_0
    //   43: aload_3
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull -38 -> 8
    //   49: aload_0
    //   50: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   53: return
    //   54: astore_0
    //   55: return
    //   56: astore_0
    //   57: aload_2
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: astore_1
    //   70: goto -3 -> 67
    //   73: astore_0
    //   74: goto -15 -> 59
    //   77: astore_0
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramArrayOfByte	byte[]
    //   0	83	1	paramString	String
    //   10	48	2	localObject1	Object
    //   12	32	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	40	java/lang/Exception
    //   13	22	42	java/lang/Exception
    //   49	53	54	java/lang/Exception
    //   13	22	56	finally
    //   63	67	69	java/lang/Exception
    //   22	31	73	finally
    //   22	31	77	java/lang/Exception
  }
  
  /* Error */
  private static void printJSONObjectToFile(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: ifnull +10 -> 15
    //   8: aload_1
    //   9: invokevirtual 108	java/lang/String:length	()I
    //   12: ifne +4 -> 16
    //   15: return
    //   16: new 110	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 116	java/io/File:exists	()Z
    //   29: ifeq +8 -> 37
    //   32: aload_2
    //   33: invokevirtual 181	java/io/File:delete	()Z
    //   36: pop
    //   37: aconst_null
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_3
    //   41: new 183	java/io/FileOutputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_0
    //   52: invokevirtual 224	org/json/JSONObject:toString	()Ljava/lang/String;
    //   55: invokevirtual 144	java/lang/String:getBytes	()[B
    //   58: invokevirtual 431	java/io/FileOutputStream:write	([B)V
    //   61: aload_1
    //   62: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   65: aload_1
    //   66: ifnull +51 -> 117
    //   69: aload_1
    //   70: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   73: return
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: aload_3
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull -65 -> 15
    //   83: aload_0
    //   84: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: astore_0
    //   89: return
    //   90: astore_0
    //   91: aload_2
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_1
    //   104: goto -3 -> 101
    //   107: astore_0
    //   108: goto -15 -> 93
    //   111: astore_0
    //   112: aload_1
    //   113: astore_0
    //   114: goto -35 -> 79
    //   117: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramJSONObject	JSONObject
    //   0	118	1	paramString	String
    //   24	68	2	localFile	File
    //   40	38	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   41	50	76	java/lang/Exception
    //   83	87	88	java/io/IOException
    //   41	50	90	finally
    //   97	101	103	java/io/IOException
    //   50	65	107	finally
    //   50	65	111	java/lang/Exception
  }
  
  /* Error */
  private static void printStringToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: aload_1
    //   5: ifnull +10 -> 15
    //   8: aload_1
    //   9: invokevirtual 108	java/lang/String:length	()I
    //   12: ifne +4 -> 16
    //   15: return
    //   16: new 110	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 116	java/io/File:exists	()Z
    //   29: ifeq +8 -> 37
    //   32: aload_2
    //   33: invokevirtual 181	java/io/File:delete	()Z
    //   36: pop
    //   37: aconst_null
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_3
    //   41: new 183	java/io/FileOutputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_0
    //   52: invokevirtual 144	java/lang/String:getBytes	()[B
    //   55: invokevirtual 431	java/io/FileOutputStream:write	([B)V
    //   58: aload_1
    //   59: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   62: aload_1
    //   63: ifnull +51 -> 114
    //   66: aload_1
    //   67: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   70: return
    //   71: astore_0
    //   72: return
    //   73: astore_0
    //   74: aload_3
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull -62 -> 15
    //   80: aload_0
    //   81: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: return
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: athrow
    //   100: astore_1
    //   101: goto -3 -> 98
    //   104: astore_0
    //   105: goto -15 -> 90
    //   108: astore_0
    //   109: aload_1
    //   110: astore_0
    //   111: goto -35 -> 76
    //   114: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramString1	String
    //   0	115	1	paramString2	String
    //   24	65	2	localFile	File
    //   40	35	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	71	java/io/IOException
    //   41	50	73	java/lang/Exception
    //   80	84	85	java/io/IOException
    //   41	50	87	finally
    //   94	98	100	java/io/IOException
    //   50	62	104	finally
    //   50	62	108	java/lang/Exception
  }
  
  public static void startCheckNativeCrash()
  {
    
    if (isNetworkStateOK(NetworkUtils.mConnectState, NetworkUtils.mWifiState))
    {
      BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("NativeCrashUtils1", null)new BNWorkerConfig
      {
        protected String execute()
        {
          NativeCrashUtils.access$000();
          return null;
        }
      }, new BNWorkerConfig(102, 0));
      return;
    }
    if (mHandler == null) {
      mHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if ((paramAnonymousMessage.what == 5555) && (NativeCrashUtils.isNetworkStateOK(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2)))
          {
            NetworkListener.unRegisterMessageHandler(NativeCrashUtils.mHandler);
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("NativeCrashUtils2", null)new BNWorkerConfig
            {
              protected String execute()
              {
                NativeCrashUtils.access$000();
                return null;
              }
            }, new BNWorkerConfig(102, 0));
          }
        }
      };
    }
    NetworkListener.registerMessageHandler(mHandler);
  }
  
  /* Error */
  private static void ungzipFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: new 188	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore_0
    //   35: new 473	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 476	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: new 183	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: sipush 1024
    //   56: newarray <illegal type>
    //   58: astore 4
    //   60: aload_3
    //   61: aload 4
    //   63: iconst_0
    //   64: aload 4
    //   66: arraylength
    //   67: invokevirtual 477	java/util/zip/GZIPInputStream:read	([BII)I
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpeq +54 -> 127
    //   76: aload_1
    //   77: aload 4
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
    //   84: aload_1
    //   85: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   88: goto -28 -> 60
    //   91: astore 4
    //   93: aload_1
    //   94: astore 4
    //   96: aload_3
    //   97: astore_1
    //   98: aload 4
    //   100: ifnull +8 -> 108
    //   103: aload 4
    //   105: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   116: aload_0
    //   117: ifnull -109 -> 8
    //   120: aload_0
    //   121: invokevirtual 199	java/io/FileInputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: return
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 199	java/io/FileInputStream:close	()V
    //   151: return
    //   152: astore_0
    //   153: return
    //   154: astore_1
    //   155: aload 6
    //   157: astore_3
    //   158: aload 8
    //   160: astore_0
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 199	java/io/FileInputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_0
    //   190: goto -3 -> 187
    //   193: astore_1
    //   194: aload 6
    //   196: astore_3
    //   197: goto -36 -> 161
    //   200: astore_1
    //   201: goto -40 -> 161
    //   204: astore 5
    //   206: aload_1
    //   207: astore 4
    //   209: aload 5
    //   211: astore_1
    //   212: goto -51 -> 161
    //   215: astore_0
    //   216: aload_3
    //   217: astore_0
    //   218: aload 5
    //   220: astore 4
    //   222: aload 7
    //   224: astore_1
    //   225: goto -127 -> 98
    //   228: astore_1
    //   229: aload 5
    //   231: astore 4
    //   233: aload 7
    //   235: astore_1
    //   236: goto -138 -> 98
    //   239: astore_1
    //   240: aload_3
    //   241: astore_1
    //   242: aload 5
    //   244: astore 4
    //   246: goto -148 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString1	String
    //   0	249	1	paramString2	String
    //   70	11	2	i	int
    //   13	228	3	localObject1	Object
    //   21	57	4	arrayOfByte	byte[]
    //   91	1	4	localException	Exception
    //   94	151	4	localObject2	Object
    //   24	1	5	localObject3	Object
    //   204	39	5	localObject4	Object
    //   15	180	6	localObject5	Object
    //   18	216	7	localObject6	Object
    //   10	149	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	91	java/lang/Exception
    //   60	71	91	java/lang/Exception
    //   76	88	91	java/lang/Exception
    //   103	108	125	java/lang/Exception
    //   112	116	125	java/lang/Exception
    //   120	124	125	java/lang/Exception
    //   131	135	152	java/lang/Exception
    //   139	143	152	java/lang/Exception
    //   147	151	152	java/lang/Exception
    //   26	35	154	finally
    //   166	171	189	java/lang/Exception
    //   175	179	189	java/lang/Exception
    //   183	187	189	java/lang/Exception
    //   35	44	193	finally
    //   44	53	200	finally
    //   53	60	204	finally
    //   60	71	204	finally
    //   76	88	204	finally
    //   26	35	215	java/lang/Exception
    //   35	44	228	java/lang/Exception
    //   44	53	239	java/lang/Exception
  }
  
  /* Error */
  private static void ungzipFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 5
    //   26: new 480	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 482	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_0
    //   35: new 473	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 476	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: new 183	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 424	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: sipush 1024
    //   56: newarray <illegal type>
    //   58: astore 4
    //   60: aload_3
    //   61: aload 4
    //   63: iconst_0
    //   64: aload 4
    //   66: arraylength
    //   67: invokevirtual 477	java/util/zip/GZIPInputStream:read	([BII)I
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpeq +54 -> 127
    //   76: aload_1
    //   77: aload 4
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
    //   84: aload_1
    //   85: invokevirtual 198	java/io/FileOutputStream:flush	()V
    //   88: goto -28 -> 60
    //   91: astore 4
    //   93: aload_1
    //   94: astore 4
    //   96: aload_3
    //   97: astore_1
    //   98: aload 4
    //   100: ifnull +8 -> 108
    //   103: aload 4
    //   105: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   116: aload_0
    //   117: ifnull -109 -> 8
    //   120: aload_0
    //   121: invokevirtual 483	java/io/ByteArrayInputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: return
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 483	java/io/ByteArrayInputStream:close	()V
    //   151: return
    //   152: astore_0
    //   153: return
    //   154: astore_1
    //   155: aload 6
    //   157: astore_3
    //   158: aload 8
    //   160: astore_0
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 478	java/util/zip/GZIPInputStream:close	()V
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 483	java/io/ByteArrayInputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_0
    //   190: goto -3 -> 187
    //   193: astore_1
    //   194: aload 6
    //   196: astore_3
    //   197: goto -36 -> 161
    //   200: astore_1
    //   201: goto -40 -> 161
    //   204: astore 5
    //   206: aload_1
    //   207: astore 4
    //   209: aload 5
    //   211: astore_1
    //   212: goto -51 -> 161
    //   215: astore_0
    //   216: aload_3
    //   217: astore_0
    //   218: aload 5
    //   220: astore 4
    //   222: aload 7
    //   224: astore_1
    //   225: goto -127 -> 98
    //   228: astore_1
    //   229: aload 5
    //   231: astore 4
    //   233: aload 7
    //   235: astore_1
    //   236: goto -138 -> 98
    //   239: astore_1
    //   240: aload_3
    //   241: astore_1
    //   242: aload 5
    //   244: astore 4
    //   246: goto -148 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramArrayOfByte	byte[]
    //   0	249	1	paramString	String
    //   70	11	2	i	int
    //   13	228	3	localObject1	Object
    //   21	57	4	arrayOfByte	byte[]
    //   91	1	4	localException	Exception
    //   94	151	4	localObject2	Object
    //   24	1	5	localObject3	Object
    //   204	39	5	localObject4	Object
    //   15	180	6	localObject5	Object
    //   18	216	7	localObject6	Object
    //   10	149	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	91	java/lang/Exception
    //   60	71	91	java/lang/Exception
    //   76	88	91	java/lang/Exception
    //   103	108	125	java/lang/Exception
    //   112	116	125	java/lang/Exception
    //   120	124	125	java/lang/Exception
    //   131	135	152	java/lang/Exception
    //   139	143	152	java/lang/Exception
    //   147	151	152	java/lang/Exception
    //   26	35	154	finally
    //   166	171	189	java/lang/Exception
    //   175	179	189	java/lang/Exception
    //   183	187	189	java/lang/Exception
    //   35	44	193	finally
    //   44	53	200	finally
    //   53	60	204	finally
    //   60	71	204	finally
    //   76	88	204	finally
    //   26	35	215	java/lang/Exception
    //   35	44	228	java/lang/Exception
    //   44	53	239	java/lang/Exception
  }
  
  private static boolean uploadBackProtocolToServer(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      HttpPostUtil localHttpPostUtil = new HttpPostUtil(UPLOAD_PROTOCOL_URL, "datafile");
      localHttpPostUtil.addTextParameter("ver", "2");
      localHttpPostUtil.addTextParameter("pd", "navi");
      localHttpPostUtil.addTextParameter("cuid", PackageUtil.getCuid());
      localHttpPostUtil.addTextParameter("os", "android");
      localHttpPostUtil.addFileParameter(paramString, paramArrayOfByte);
      new String(localHttpPostUtil.send());
      int i = localHttpPostUtil.getResCode();
      return i == 200;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static boolean uploadCrashLog(String paramString, byte[] paramArrayOfByte)
  {
    return uploadCrashLogToNaviServer(paramString, paramArrayOfByte);
  }
  
  private static boolean uploadCrashLogToMapServer(String paramString, byte[] paramArrayOfByte)
  {
    loge("uploadCrashLogToMapServer() begin");
    for (;;)
    {
      try
      {
        HttpPostUtil localHttpPostUtil = new HttpPostUtil(UPLOAD_LOG_URL, "datafile");
        localHttpPostUtil.addTextParameter("ver", "2");
        localHttpPostUtil.addTextParameter("pd", "navi");
        localHttpPostUtil.addTextParameter("cuid", PackageUtil.getCuid());
        localHttpPostUtil.addTextParameter("os", "android");
        localHttpPostUtil.addFileParameter(paramString, paramArrayOfByte);
        new String(localHttpPostUtil.send());
        int i = localHttpPostUtil.getResCode();
        if (i != 200) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        boolean bool = false;
        continue;
      }
      loge("uploadCrashLogToMapServer() ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private static boolean uploadCrashLogToNaviServer(String paramString, byte[] paramArrayOfByte)
  {
    loge("uploadCrashLogToNaviServer() begin");
    for (;;)
    {
      try
      {
        HttpPostUtil localHttpPostUtil = new HttpPostUtil(UPLOAD_LOG_NAVI_URL, "datafile");
        localHttpPostUtil.addTextParameter("appid", "1");
        localHttpPostUtil.addTextParameter("app_ver", PackageUtil.getVersionName());
        localHttpPostUtil.addTextParameter("os", "0");
        Object localObject = new ArrayList();
        ((List)localObject).add(new BasicNameValuePair("app_ver", PackageUtil.getVersionName()));
        ((List)localObject).add(new BasicNameValuePair("appid", "1"));
        ((List)localObject).add(new BasicNameValuePair("os", "0"));
        localObject = HttpUtils.calcUrlSign((List)localObject);
        loge("uploadCrashLogToNaviServer() sign=" + (String)localObject);
        localHttpPostUtil.addTextParameter("sign", (String)localObject);
        localHttpPostUtil.addFileParameter(paramString, paramArrayOfByte);
        new String(localHttpPostUtil.send());
        int i = localHttpPostUtil.getResCode();
        if (i != 200) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        boolean bool = false;
        continue;
      }
      loge("uploadCrashLogToNaviServer() ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  public static class HttpPostUtil
  {
    String boundary = UUID.randomUUID().toString();
    HttpURLConnection conn;
    DataOutputStream ds;
    String fileKey = null;
    Map<String, byte[]> fileparams = new TreeMap();
    int resCode = -1;
    Map<String, String> textParams = new TreeMap();
    URL url;
    
    public HttpPostUtil(String paramString1, String paramString2)
      throws Exception
    {
      this.url = new URL(paramString1);
      this.fileKey = paramString2;
    }
    
    private String encode(String paramString)
      throws Exception
    {
      return URLEncoder.encode(paramString, "UTF-8");
    }
    
    private byte[] getBytes(File paramFile)
      throws Exception
    {
      Object localObject = new FileInputStream(paramFile);
      paramFile = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = ((FileInputStream)localObject).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramFile.write(arrayOfByte, 0, i);
      }
      ((FileInputStream)localObject).close();
      localObject = paramFile.toByteArray();
      paramFile.close();
      return (byte[])localObject;
    }
    
    private String getContentType(File paramFile)
      throws Exception
    {
      return "application/octet-stream";
    }
    
    private void initConnection()
      throws Exception
    {
      this.conn = ((HttpURLConnection)this.url.openConnection());
      this.conn.setDoOutput(true);
      this.conn.setDoInput(true);
      this.conn.setUseCaches(false);
      this.conn.setConnectTimeout(10000);
      this.conn.setRequestMethod("POST");
      this.conn.setRequestProperty("connection", "keep-alive");
      this.conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
    }
    
    private void paramsEnd()
      throws Exception
    {
      this.ds.writeBytes("--" + this.boundary + "--\r\n");
      this.ds.writeBytes("\r\n");
    }
    
    private void writeFileParams()
      throws Exception
    {
      if (this.ds == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.fileparams.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          byte[] arrayOfByte = (byte[])this.fileparams.get(str);
          if ((arrayOfByte != null) && (arrayOfByte.length != 0))
          {
            this.ds.writeBytes("--" + this.boundary + "\r\n");
            this.ds.writeBytes("Content-Disposition: form-data; name=\"" + this.fileKey + "\"; filename=\"" + str + "\"\r\n");
            this.ds.writeBytes("Content-Type: " + getContentType(null) + "\r\n");
            this.ds.writeBytes("\r\n");
            this.ds.write(arrayOfByte);
            this.ds.writeBytes("\r\n");
          }
        }
      }
    }
    
    private void writeStringParams()
      throws Exception
    {
      if (this.ds == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.textParams.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)this.textParams.get(str1);
          this.ds.writeBytes("--" + this.boundary + "\r\n");
          this.ds.writeBytes("Content-Disposition: form-data; name=\"" + str1 + "\"\r\n");
          this.ds.writeBytes("\r\n");
          this.ds.writeBytes(str2 + "\r\n");
        }
      }
    }
    
    public void addFileParameter(String paramString, byte[] paramArrayOfByte)
    {
      this.fileparams.put(paramString, paramArrayOfByte);
    }
    
    public void addTextParameter(String paramString1, String paramString2)
    {
      this.textParams.put(paramString1, paramString2);
    }
    
    public void clearAllParameters()
    {
      this.textParams.clear();
      this.fileparams.clear();
    }
    
    public int getResCode()
    {
      return this.resCode;
    }
    
    public byte[] send()
      throws Exception
    {
      initConnection();
      try
      {
        this.conn.connect();
        this.ds = new DataOutputStream(this.conn.getOutputStream());
        writeFileParams();
        writeStringParams();
        paramsEnd();
        this.resCode = this.conn.getResponseCode();
        Object localObject1 = this.conn.getResponseMessage();
        NativeCrashUtils.loge("resCode=" + this.resCode);
        NativeCrashUtils.loge("resMsg=" + (String)localObject1);
        localObject2 = this.conn.getInputStream();
        localObject1 = new ByteArrayOutputStream();
        for (;;)
        {
          int i = ((InputStream)localObject2).read();
          if (i == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write(i);
        }
        localSocketTimeoutException.flush();
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        throw new RuntimeException();
      }
      this.conn.disconnect();
      ((InputStream)localObject2).close();
      Object localObject2 = localSocketTimeoutException.toByteArray();
      localSocketTimeoutException.close();
      return (byte[])localObject2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/NativeCrashUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */