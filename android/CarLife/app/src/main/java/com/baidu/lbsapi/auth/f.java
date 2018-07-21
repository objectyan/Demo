package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public class f
{
  private Context a;
  private String b = null;
  private HashMap<String, String> c = null;
  private String d = null;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private String a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable())) {
        break label141;
      }
      paramContext = paramContext.getExtraInfo();
      if ((paramContext != null) && ((paramContext.trim().toLowerCase().equals("cmwap")) || (paramContext.trim().toLowerCase().equals("uniwap")) || (paramContext.trim().toLowerCase().equals("3gwap")) || (paramContext.trim().toLowerCase().equals("ctwap"))))
      {
        if (paramContext.trim().toLowerCase().equals("ctwap")) {
          return "ctwap";
        }
        return "cmwap";
      }
    }
    catch (Exception paramContext)
    {
      if (a.a) {
        paramContext.printStackTrace();
      }
      return null;
    }
    return "wifi";
    label141:
    return null;
  }
  
  /* Error */
  private void a(HttpsURLConnection paramHttpsURLConnection)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: new 90	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   16: ldc 93
    //   18: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 19	com/baidu/lbsapi/auth/f:b	Ljava/lang/String;
    //   25: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 21	com/baidu/lbsapi/auth/f:c	Ljava/util/HashMap;
    //   38: ifnonnull +13 -> 51
    //   41: aload_0
    //   42: ldc 105
    //   44: invokestatic 110	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   50: return
    //   51: iconst_1
    //   52: istore 4
    //   54: aload_1
    //   55: invokevirtual 116	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   58: astore 6
    //   60: aload 6
    //   62: astore 8
    //   64: new 118	java/io/BufferedWriter
    //   67: dup
    //   68: new 120	java/io/OutputStreamWriter
    //   71: dup
    //   72: aload 6
    //   74: ldc 122
    //   76: invokespecial 125	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   79: invokespecial 128	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   82: astore 7
    //   84: aload 6
    //   86: astore 8
    //   88: aload 7
    //   90: aload_0
    //   91: getfield 21	com/baidu/lbsapi/auth/f:c	Ljava/util/HashMap;
    //   94: invokestatic 131	com/baidu/lbsapi/auth/f:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   97: invokevirtual 134	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: getfield 21	com/baidu/lbsapi/auth/f:c	Ljava/util/HashMap;
    //   108: invokestatic 131	com/baidu/lbsapi/auth/f:b	(Ljava/util/HashMap;)Ljava/lang/String;
    //   111: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   114: aload 6
    //   116: astore 8
    //   118: aload 7
    //   120: invokevirtual 137	java/io/BufferedWriter:flush	()V
    //   123: aload 6
    //   125: astore 8
    //   127: aload 7
    //   129: invokevirtual 140	java/io/BufferedWriter:close	()V
    //   132: aload 6
    //   134: astore 8
    //   136: aload_1
    //   137: invokevirtual 143	javax/net/ssl/HttpsURLConnection:connect	()V
    //   140: aload_1
    //   141: invokevirtual 147	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   144: astore 9
    //   146: aload_1
    //   147: invokevirtual 151	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   150: istore_2
    //   151: sipush 200
    //   154: iload_2
    //   155: if_icmpne +983 -> 1138
    //   158: new 153	java/io/BufferedReader
    //   161: dup
    //   162: new 155	java/io/InputStreamReader
    //   165: dup
    //   166: aload 9
    //   168: ldc 122
    //   170: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   173: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   176: astore 7
    //   178: new 163	java/lang/StringBuffer
    //   181: dup
    //   182: invokespecial 164	java/lang/StringBuffer:<init>	()V
    //   185: astore 8
    //   187: aload 7
    //   189: invokevirtual 167	java/io/BufferedReader:read	()I
    //   192: istore_3
    //   193: iload_3
    //   194: iconst_m1
    //   195: if_icmpeq +247 -> 442
    //   198: aload 8
    //   200: iload_3
    //   201: i2c
    //   202: invokevirtual 170	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   205: pop
    //   206: goto -19 -> 187
    //   209: astore 8
    //   211: aload 7
    //   213: astore 10
    //   215: aload 8
    //   217: astore 7
    //   219: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   222: ifeq +34 -> 256
    //   225: aload 7
    //   227: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   230: new 90	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   237: ldc -83
    //   239: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 7
    //   244: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   256: aload_0
    //   257: bipush -11
    //   259: new 90	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   266: ldc -78
    //   268: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 7
    //   273: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   276: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   285: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   288: aload 9
    //   290: ifnull +42 -> 332
    //   293: aload 10
    //   295: ifnull +37 -> 332
    //   298: iload_2
    //   299: istore_3
    //   300: aload 6
    //   302: astore 8
    //   304: iload_2
    //   305: istore 4
    //   307: iload_2
    //   308: istore 5
    //   310: aload 10
    //   312: invokevirtual 182	java/io/BufferedReader:close	()V
    //   315: iload_2
    //   316: istore_3
    //   317: aload 6
    //   319: astore 8
    //   321: iload_2
    //   322: istore 4
    //   324: iload_2
    //   325: istore 5
    //   327: aload 9
    //   329: invokevirtual 185	java/io/InputStream:close	()V
    //   332: aload_1
    //   333: ifnull +790 -> 1123
    //   336: iload_2
    //   337: istore_3
    //   338: aload 6
    //   340: astore 8
    //   342: iload_2
    //   343: istore 4
    //   345: iload_2
    //   346: istore 5
    //   348: aload_1
    //   349: invokevirtual 188	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   352: iconst_0
    //   353: istore 4
    //   355: iload_2
    //   356: istore 5
    //   358: iload 4
    //   360: istore_2
    //   361: iload 5
    //   363: istore_3
    //   364: aload 6
    //   366: ifnull +14 -> 380
    //   369: aload 6
    //   371: invokevirtual 191	java/io/OutputStream:close	()V
    //   374: iload 5
    //   376: istore_3
    //   377: iload 4
    //   379: istore_2
    //   380: iload_2
    //   381: ifeq +534 -> 915
    //   384: sipush 200
    //   387: iload_3
    //   388: if_icmpeq +527 -> 915
    //   391: new 90	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   398: ldc -63
    //   400: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: iload_3
    //   404: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   413: aload_0
    //   414: bipush -11
    //   416: new 90	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   423: ldc -63
    //   425: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: iload_3
    //   429: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   438: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   441: return
    //   442: aload_0
    //   443: aload 8
    //   445: invokevirtual 197	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   448: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   451: aload 9
    //   453: ifnull +26 -> 479
    //   456: aload 7
    //   458: ifnull +21 -> 479
    //   461: aload 6
    //   463: astore 8
    //   465: aload 7
    //   467: invokevirtual 182	java/io/BufferedReader:close	()V
    //   470: aload 6
    //   472: astore 8
    //   474: aload 9
    //   476: invokevirtual 185	java/io/InputStream:close	()V
    //   479: aload_1
    //   480: ifnull +652 -> 1132
    //   483: aload 6
    //   485: astore 8
    //   487: aload_1
    //   488: invokevirtual 188	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   491: iload_2
    //   492: istore 5
    //   494: goto -136 -> 358
    //   497: astore 7
    //   499: aconst_null
    //   500: astore 9
    //   502: iconst_m1
    //   503: istore_2
    //   504: aload 11
    //   506: astore 10
    //   508: aload 9
    //   510: ifnull +42 -> 552
    //   513: aload 10
    //   515: ifnull +37 -> 552
    //   518: iload_2
    //   519: istore_3
    //   520: aload 6
    //   522: astore 8
    //   524: iload_2
    //   525: istore 4
    //   527: iload_2
    //   528: istore 5
    //   530: aload 10
    //   532: invokevirtual 182	java/io/BufferedReader:close	()V
    //   535: iload_2
    //   536: istore_3
    //   537: aload 6
    //   539: astore 8
    //   541: iload_2
    //   542: istore 4
    //   544: iload_2
    //   545: istore 5
    //   547: aload 9
    //   549: invokevirtual 185	java/io/InputStream:close	()V
    //   552: aload_1
    //   553: ifnull +19 -> 572
    //   556: iload_2
    //   557: istore_3
    //   558: aload 6
    //   560: astore 8
    //   562: iload_2
    //   563: istore 4
    //   565: iload_2
    //   566: istore 5
    //   568: aload_1
    //   569: invokevirtual 188	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   572: iload_2
    //   573: istore_3
    //   574: aload 6
    //   576: astore 8
    //   578: iload_2
    //   579: istore 4
    //   581: iload_2
    //   582: istore 5
    //   584: aload 7
    //   586: athrow
    //   587: astore 7
    //   589: aload 6
    //   591: astore_1
    //   592: aload 7
    //   594: astore 6
    //   596: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   599: ifeq +8 -> 607
    //   602: aload 6
    //   604: invokevirtual 198	java/net/MalformedURLException:printStackTrace	()V
    //   607: aload_0
    //   608: bipush -11
    //   610: new 90	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   617: ldc -56
    //   619: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload 6
    //   624: invokevirtual 201	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   627: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   636: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   639: iload_3
    //   640: istore 4
    //   642: aload_1
    //   643: ifnull +472 -> 1115
    //   646: aload_1
    //   647: invokevirtual 191	java/io/OutputStream:close	()V
    //   650: iconst_0
    //   651: istore_2
    //   652: goto -272 -> 380
    //   655: astore_1
    //   656: iload 4
    //   658: istore_2
    //   659: iload 5
    //   661: istore_3
    //   662: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   665: ifeq -285 -> 380
    //   668: aload_1
    //   669: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   672: iload 4
    //   674: istore_2
    //   675: iload 5
    //   677: istore_3
    //   678: goto -298 -> 380
    //   681: astore_1
    //   682: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   685: ifeq +7 -> 692
    //   688: aload_1
    //   689: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   692: iconst_0
    //   693: istore_2
    //   694: goto -314 -> 380
    //   697: astore_1
    //   698: iconst_m1
    //   699: istore_3
    //   700: aconst_null
    //   701: astore 6
    //   703: aload 6
    //   705: astore 8
    //   707: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   710: ifeq +11 -> 721
    //   713: aload 6
    //   715: astore 8
    //   717: aload_1
    //   718: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   721: aload 6
    //   723: astore 8
    //   725: aload_0
    //   726: bipush -11
    //   728: new 90	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   735: ldc -78
    //   737: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload_1
    //   741: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   744: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   753: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   756: iload_3
    //   757: istore 4
    //   759: aload 6
    //   761: ifnull +354 -> 1115
    //   764: aload 6
    //   766: invokevirtual 191	java/io/OutputStream:close	()V
    //   769: iconst_0
    //   770: istore_2
    //   771: goto -391 -> 380
    //   774: astore_1
    //   775: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   778: ifeq +7 -> 785
    //   781: aload_1
    //   782: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   785: iconst_0
    //   786: istore_2
    //   787: goto -407 -> 380
    //   790: astore_1
    //   791: iconst_m1
    //   792: istore_3
    //   793: aconst_null
    //   794: astore 6
    //   796: aload 6
    //   798: astore 8
    //   800: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   803: ifeq +11 -> 814
    //   806: aload 6
    //   808: astore 8
    //   810: aload_1
    //   811: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   814: aload 6
    //   816: astore 8
    //   818: aload_0
    //   819: bipush -11
    //   821: new 90	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   828: ldc -53
    //   830: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_1
    //   834: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   837: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   846: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   849: iload_3
    //   850: istore 4
    //   852: aload 6
    //   854: ifnull +261 -> 1115
    //   857: aload 6
    //   859: invokevirtual 191	java/io/OutputStream:close	()V
    //   862: iconst_0
    //   863: istore_2
    //   864: goto -484 -> 380
    //   867: astore_1
    //   868: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   871: ifeq +7 -> 878
    //   874: aload_1
    //   875: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   878: iconst_0
    //   879: istore_2
    //   880: goto -500 -> 380
    //   883: astore_1
    //   884: aconst_null
    //   885: astore 8
    //   887: aload 8
    //   889: ifnull +8 -> 897
    //   892: aload 8
    //   894: invokevirtual 191	java/io/OutputStream:close	()V
    //   897: aload_1
    //   898: athrow
    //   899: astore 6
    //   901: getstatic 78	com/baidu/lbsapi/auth/a:a	Z
    //   904: ifeq -7 -> 897
    //   907: aload 6
    //   909: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   912: goto -15 -> 897
    //   915: aload_0
    //   916: getfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   919: ifnonnull +19 -> 938
    //   922: ldc -50
    //   924: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   927: aload_0
    //   928: iconst_m1
    //   929: ldc -48
    //   931: invokestatic 181	com/baidu/lbsapi/auth/c:a	(ILjava/lang/String;)Ljava/lang/String;
    //   934: putfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   937: return
    //   938: new 90	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   945: ldc -46
    //   947: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: aload_0
    //   951: getfield 23	com/baidu/lbsapi/auth/f:d	Ljava/lang/String;
    //   954: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokestatic 103	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   963: return
    //   964: astore_1
    //   965: goto -78 -> 887
    //   968: astore 6
    //   970: aload_1
    //   971: astore 8
    //   973: aload 6
    //   975: astore_1
    //   976: goto -89 -> 887
    //   979: astore_1
    //   980: iconst_m1
    //   981: istore_3
    //   982: goto -186 -> 796
    //   985: astore_1
    //   986: iload_2
    //   987: istore_3
    //   988: goto -192 -> 796
    //   991: astore_1
    //   992: iload 4
    //   994: istore_3
    //   995: goto -199 -> 796
    //   998: astore_1
    //   999: iconst_m1
    //   1000: istore_3
    //   1001: goto -298 -> 703
    //   1004: astore_1
    //   1005: iload_2
    //   1006: istore_3
    //   1007: goto -304 -> 703
    //   1010: astore_1
    //   1011: iload 5
    //   1013: istore_3
    //   1014: goto -311 -> 703
    //   1017: astore 6
    //   1019: iconst_m1
    //   1020: istore_3
    //   1021: aload 7
    //   1023: astore_1
    //   1024: goto -428 -> 596
    //   1027: astore 7
    //   1029: iconst_m1
    //   1030: istore_3
    //   1031: aload 6
    //   1033: astore_1
    //   1034: aload 7
    //   1036: astore 6
    //   1038: goto -442 -> 596
    //   1041: astore 7
    //   1043: aload 6
    //   1045: astore_1
    //   1046: aload 7
    //   1048: astore 6
    //   1050: iload_2
    //   1051: istore_3
    //   1052: goto -456 -> 596
    //   1055: astore 7
    //   1057: iconst_m1
    //   1058: istore_2
    //   1059: aload 11
    //   1061: astore 10
    //   1063: goto -555 -> 508
    //   1066: astore 7
    //   1068: aload 11
    //   1070: astore 10
    //   1072: goto -564 -> 508
    //   1075: astore 8
    //   1077: aload 7
    //   1079: astore 10
    //   1081: aload 8
    //   1083: astore 7
    //   1085: goto -577 -> 508
    //   1088: astore 7
    //   1090: goto -582 -> 508
    //   1093: astore 7
    //   1095: aconst_null
    //   1096: astore 9
    //   1098: iconst_m1
    //   1099: istore_2
    //   1100: goto -881 -> 219
    //   1103: astore 7
    //   1105: iconst_m1
    //   1106: istore_2
    //   1107: goto -888 -> 219
    //   1110: astore 7
    //   1112: goto -893 -> 219
    //   1115: iconst_0
    //   1116: istore_2
    //   1117: iload 4
    //   1119: istore_3
    //   1120: goto -740 -> 380
    //   1123: iconst_0
    //   1124: istore 4
    //   1126: iload_2
    //   1127: istore 5
    //   1129: goto -771 -> 358
    //   1132: iload_2
    //   1133: istore 5
    //   1135: goto -777 -> 358
    //   1138: aconst_null
    //   1139: astore 7
    //   1141: goto -690 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1144	0	this	f
    //   0	1144	1	paramHttpsURLConnection	HttpsURLConnection
    //   150	983	2	i	int
    //   192	928	3	j	int
    //   52	1073	4	k	int
    //   308	826	5	m	int
    //   58	800	6	localObject1	Object
    //   899	9	6	localIOException1	java.io.IOException
    //   968	6	6	localObject2	Object
    //   1017	15	6	localMalformedURLException1	MalformedURLException
    //   1036	13	6	localMalformedURLException2	MalformedURLException
    //   4	462	7	localObject3	Object
    //   497	88	7	localObject4	Object
    //   587	435	7	localMalformedURLException3	MalformedURLException
    //   1027	8	7	localMalformedURLException4	MalformedURLException
    //   1041	6	7	localMalformedURLException5	MalformedURLException
    //   1055	1	7	localObject5	Object
    //   1066	12	7	localObject6	Object
    //   1083	1	7	localObject7	Object
    //   1088	1	7	localObject8	Object
    //   1093	1	7	localIOException2	java.io.IOException
    //   1103	1	7	localIOException3	java.io.IOException
    //   1110	1	7	localIOException4	java.io.IOException
    //   1139	1	7	localObject9	Object
    //   62	137	8	localObject10	Object
    //   209	7	8	localIOException5	java.io.IOException
    //   302	670	8	localObject11	Object
    //   1075	7	8	localObject12	Object
    //   144	953	9	localInputStream	java.io.InputStream
    //   7	1073	10	localObject13	Object
    //   1	1068	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   178	187	209	java/io/IOException
    //   187	193	209	java/io/IOException
    //   198	206	209	java/io/IOException
    //   442	451	209	java/io/IOException
    //   140	146	497	finally
    //   310	315	587	java/net/MalformedURLException
    //   327	332	587	java/net/MalformedURLException
    //   348	352	587	java/net/MalformedURLException
    //   530	535	587	java/net/MalformedURLException
    //   547	552	587	java/net/MalformedURLException
    //   568	572	587	java/net/MalformedURLException
    //   584	587	587	java/net/MalformedURLException
    //   369	374	655	java/io/IOException
    //   646	650	681	java/io/IOException
    //   54	60	697	java/io/IOException
    //   764	769	774	java/io/IOException
    //   54	60	790	java/lang/Exception
    //   857	862	867	java/io/IOException
    //   54	60	883	finally
    //   892	897	899	java/io/IOException
    //   64	84	964	finally
    //   88	100	964	finally
    //   104	114	964	finally
    //   118	123	964	finally
    //   127	132	964	finally
    //   136	140	964	finally
    //   310	315	964	finally
    //   327	332	964	finally
    //   348	352	964	finally
    //   465	470	964	finally
    //   474	479	964	finally
    //   487	491	964	finally
    //   530	535	964	finally
    //   547	552	964	finally
    //   568	572	964	finally
    //   584	587	964	finally
    //   707	713	964	finally
    //   717	721	964	finally
    //   725	756	964	finally
    //   800	806	964	finally
    //   810	814	964	finally
    //   818	849	964	finally
    //   596	607	968	finally
    //   607	639	968	finally
    //   64	84	979	java/lang/Exception
    //   88	100	979	java/lang/Exception
    //   104	114	979	java/lang/Exception
    //   118	123	979	java/lang/Exception
    //   127	132	979	java/lang/Exception
    //   136	140	979	java/lang/Exception
    //   465	470	985	java/lang/Exception
    //   474	479	985	java/lang/Exception
    //   487	491	985	java/lang/Exception
    //   310	315	991	java/lang/Exception
    //   327	332	991	java/lang/Exception
    //   348	352	991	java/lang/Exception
    //   530	535	991	java/lang/Exception
    //   547	552	991	java/lang/Exception
    //   568	572	991	java/lang/Exception
    //   584	587	991	java/lang/Exception
    //   64	84	998	java/io/IOException
    //   88	100	998	java/io/IOException
    //   104	114	998	java/io/IOException
    //   118	123	998	java/io/IOException
    //   127	132	998	java/io/IOException
    //   136	140	998	java/io/IOException
    //   465	470	1004	java/io/IOException
    //   474	479	1004	java/io/IOException
    //   487	491	1004	java/io/IOException
    //   310	315	1010	java/io/IOException
    //   327	332	1010	java/io/IOException
    //   348	352	1010	java/io/IOException
    //   530	535	1010	java/io/IOException
    //   547	552	1010	java/io/IOException
    //   568	572	1010	java/io/IOException
    //   584	587	1010	java/io/IOException
    //   54	60	1017	java/net/MalformedURLException
    //   64	84	1027	java/net/MalformedURLException
    //   88	100	1027	java/net/MalformedURLException
    //   104	114	1027	java/net/MalformedURLException
    //   118	123	1027	java/net/MalformedURLException
    //   127	132	1027	java/net/MalformedURLException
    //   136	140	1027	java/net/MalformedURLException
    //   465	470	1041	java/net/MalformedURLException
    //   474	479	1041	java/net/MalformedURLException
    //   487	491	1041	java/net/MalformedURLException
    //   146	151	1055	finally
    //   158	178	1066	finally
    //   178	187	1075	finally
    //   187	193	1075	finally
    //   198	206	1075	finally
    //   442	451	1075	finally
    //   219	256	1088	finally
    //   256	288	1088	finally
    //   140	146	1093	java/io/IOException
    //   146	151	1103	java/io/IOException
    //   158	178	1110	java/io/IOException
  }
  
  private static String b(HashMap<String, String> paramHashMap)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 1;
    if (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  private HttpsURLConnection b()
  {
    try
    {
      localObject = new URL(this.b);
      a.a("https URL: " + this.b);
      str = a(this.a);
      if ((str == null) || (str.equals("")))
      {
        a.c("Current network is not available.");
        this.d = c.a(-10, "Current network is not available.");
        return null;
      }
      a.a("checkNetwork = " + str);
      if (!str.equals("cmwap")) {
        break label208;
      }
      localObject = (HttpsURLConnection)((URL)localObject).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject;
        String str;
        if (a.a)
        {
          localMalformedURLException.printStackTrace();
          a.a(localMalformedURLException.getMessage());
        }
        this.d = c.a(-11, "Auth server could not be parsed as a URL.");
        return null;
        HttpsURLConnection localHttpsURLConnection;
        if (str.equals("ctwap")) {
          localHttpsURLConnection = (HttpsURLConnection)localMalformedURLException.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        } else {
          localHttpsURLConnection = (HttpsURLConnection)localHttpsURLConnection.openConnection();
        }
      }
    }
    catch (Exception localException)
    {
      label208:
      if (!a.a) {
        break label279;
      }
      localException.printStackTrace();
      a.a(localException.getMessage());
      label279:
      this.d = c.a(-11, "Init httpsurlconnection failed.");
    }
    ((HttpsURLConnection)localObject).setDoInput(true);
    ((HttpsURLConnection)localObject).setDoOutput(true);
    ((HttpsURLConnection)localObject).setRequestMethod("POST");
    ((HttpsURLConnection)localObject).setConnectTimeout(50000);
    ((HttpsURLConnection)localObject).setReadTimeout(50000);
    return (HttpsURLConnection)localObject;
    return null;
  }
  
  private HashMap<String, String> c(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }
  
  protected String a(HashMap<String, String> paramHashMap)
  {
    this.c = c(paramHashMap);
    this.b = ((String)this.c.get("url"));
    paramHashMap = b();
    if (paramHashMap == null)
    {
      a.c("syncConnect failed,httpsURLConnection is null");
      return this.d;
    }
    a(paramHashMap);
    return this.d;
  }
  
  protected boolean a()
  {
    a.a("checkNetwork start");
    try
    {
      Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isAvailable();
        if (bool) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      if (a.a) {
        localException.printStackTrace();
      }
      return false;
    }
    a.a("checkNetwork end");
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/lbsapi/auth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */