package com.baidu.carlife.k.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.e;
import com.baidu.carlife.util.w;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class i
  extends Thread
  implements Comparable<i>
{
  public static final String a = "NetWorkDownload";
  private static final String b = i.class.getSimpleName();
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 15000;
  private h.c f;
  private g g;
  private File h;
  private HttpURLConnection i;
  private Context j;
  private String k;
  private boolean l;
  private boolean m;
  private Handler n = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        Object localObject;
        do
        {
          return;
          localObject = paramAnonymousMessage.getData();
          paramAnonymousMessage = (h.b)((Bundle)localObject).getSerializable("state");
          localObject = (h.a)((Bundle)localObject).getSerializable("errorCode");
          i.a(i.this, (h.a)localObject);
        } while (i.b(i.this) == null);
        i.b(i.this).a(paramAnonymousMessage, (h.a)localObject);
        com.baidu.carlife.core.i.b(i.i(), i.c(i.this).d + ":state=" + paramAnonymousMessage.name() + ",errorCode=" + ((h.a)localObject).name());
        return;
      } while (i.b(i.this) == null);
      i.b(i.this).a(i.c(i.this).f, paramAnonymousMessage.arg1);
    }
  };
  
  i(Context paramContext, g paramg, h.c paramc, String paramString)
  {
    this.g = paramg;
    this.g.a = System.currentTimeMillis();
    this.j = paramContext;
    this.k = paramString;
    this.f = paramc;
    a(h.b.a, h.a.a);
  }
  
  private void a(int paramInt)
  {
    if (this.m) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.n.sendMessage(localMessage);
  }
  
  private void a(h.a parama)
  {
    switch (2.a[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      w.a(2131296454, 0);
      return;
    case 2: 
      w.a(2131296459, 0);
      return;
    }
    w.a(2131296385, 0);
  }
  
  private void a(h.b paramb, h.a parama)
  {
    if (this.m) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("state", paramb);
    localBundle.putSerializable("errorCode", parama);
    localMessage.setData(localBundle);
    this.n.sendMessage(localMessage);
    switch (2.b[paramb.ordinal()])
    {
    default: 
      return;
    }
    this.l = true;
    j.a().b(this);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(this.g.d))
    {
      a(h.b.f, h.a.d);
      return false;
    }
    if (TextUtils.isEmpty(paramString)) {
      if (!Environment.getExternalStorageState().equals("mounted")) {}
    }
    for (this.g.e = (Environment.getExternalStorageDirectory().toString() + File.separator + "BaiduCarlife" + File.separator + "NetWorkDownload"); !b(this.g.e); this.g.e = paramString)
    {
      a(h.b.f, h.a.d);
      return false;
      a(h.b.f, h.a.c);
      return false;
    }
    paramString = new File(this.g.e + File.separator + this.g.d);
    if ((paramString.exists()) && (this.g.g)) {
      paramString.delete();
    }
    do
    {
      do
      {
        this.h = paramString;
        return true;
      } while ((!this.g.g) && (paramString.exists()));
      int i1 = 0;
      try
      {
        boolean bool = paramString.createNewFile();
        i1 = bool;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    } while (i1 != 0);
    a(h.b.f, h.a.d);
    return false;
  }
  
  private boolean b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  public int a(i parami)
  {
    int i2 = parami.c().b - this.g.b;
    int i1 = i2;
    if (i2 == 0) {
      i1 = (int)(this.g.a - parami.c().a);
    }
    return i1;
  }
  
  public void a()
  {
    this.f = null;
  }
  
  public void a(h.c paramc)
  {
    this.f = paramc;
  }
  
  public File b()
  {
    return this.h;
  }
  
  public g c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return (this.m) || (this.l);
  }
  
  public void e()
  {
    a(h.b.d, h.a.a);
    if ((this.g.g) && (this.h != null)) {
      this.h.delete();
    }
    this.m = true;
  }
  
  protected void f()
  {
    if (!e.a().r()) {
      a(h.b.f, h.a.b);
    }
    while (!a(this.k)) {
      return;
    }
    a(h.b.b, h.a.a);
  }
  
  /* Error */
  protected void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 269	com/baidu/carlife/k/a/i:d	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 20
    //   11: aconst_null
    //   12: astore 21
    //   14: aconst_null
    //   15: astore 22
    //   17: aconst_null
    //   18: astore 23
    //   20: aconst_null
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 16
    //   26: aconst_null
    //   27: astore 17
    //   29: aconst_null
    //   30: astore 18
    //   32: aconst_null
    //   33: astore 19
    //   35: aconst_null
    //   36: astore 12
    //   38: lconst_0
    //   39: lstore 5
    //   41: aload 20
    //   43: astore 13
    //   45: aload 21
    //   47: astore 14
    //   49: aload 22
    //   51: astore 15
    //   53: aload 23
    //   55: astore 10
    //   57: aload 19
    //   59: astore 11
    //   61: aload_0
    //   62: new 271	java/net/URL
    //   65: dup
    //   66: aload_0
    //   67: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   70: getfield 273	com/baidu/carlife/k/a/g:c	Ljava/lang/String;
    //   73: invokespecial 274	java/net/URL:<init>	(Ljava/lang/String;)V
    //   76: invokevirtual 278	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   79: checkcast 280	java/net/HttpURLConnection
    //   82: putfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   85: aload 20
    //   87: astore 13
    //   89: aload 21
    //   91: astore 14
    //   93: aload 22
    //   95: astore 15
    //   97: aload 23
    //   99: astore 10
    //   101: aload 19
    //   103: astore 11
    //   105: aload_0
    //   106: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   109: ldc_w 284
    //   112: invokevirtual 287	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   115: aload 20
    //   117: astore 13
    //   119: aload 21
    //   121: astore 14
    //   123: aload 22
    //   125: astore 15
    //   127: aload 23
    //   129: astore 10
    //   131: aload 19
    //   133: astore 11
    //   135: aload_0
    //   136: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   139: sipush 15000
    //   142: invokevirtual 290	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   145: aload 20
    //   147: astore 13
    //   149: aload 21
    //   151: astore 14
    //   153: aload 22
    //   155: astore 15
    //   157: aload 23
    //   159: astore 10
    //   161: aload 19
    //   163: astore 11
    //   165: aload_0
    //   166: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   169: iconst_0
    //   170: invokevirtual 294	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   173: aload 20
    //   175: astore 13
    //   177: aload 21
    //   179: astore 14
    //   181: aload 22
    //   183: astore 15
    //   185: aload 23
    //   187: astore 10
    //   189: aload 19
    //   191: astore 11
    //   193: aload_0
    //   194: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   197: getfield 220	com/baidu/carlife/k/a/g:g	Z
    //   200: ifne +146 -> 346
    //   203: aload 20
    //   205: astore 13
    //   207: aload 21
    //   209: astore 14
    //   211: aload 22
    //   213: astore 15
    //   215: aload 23
    //   217: astore 10
    //   219: aload 19
    //   221: astore 11
    //   223: aload_0
    //   224: getfield 225	com/baidu/carlife/k/a/i:h	Ljava/io/File;
    //   227: invokevirtual 297	java/io/File:length	()J
    //   230: lstore 5
    //   232: aload 20
    //   234: astore 13
    //   236: aload 21
    //   238: astore 14
    //   240: aload 22
    //   242: astore 15
    //   244: aload 23
    //   246: astore 10
    //   248: aload 19
    //   250: astore 11
    //   252: aload_0
    //   253: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   256: ldc_w 299
    //   259: new 185	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 301
    //   269: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: lload 5
    //   274: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: ldc_w 306
    //   280: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokevirtual 310	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload 20
    //   291: astore 13
    //   293: aload 21
    //   295: astore 14
    //   297: aload 22
    //   299: astore 15
    //   301: aload 23
    //   303: astore 10
    //   305: aload 19
    //   307: astore 11
    //   309: getstatic 49	com/baidu/carlife/k/a/i:b	Ljava/lang/String;
    //   312: new 185	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   319: aload_0
    //   320: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   323: getfield 160	com/baidu/carlife/k/a/g:d	Ljava/lang/String;
    //   326: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 312
    //   332: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: lload 5
    //   337: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 316	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload 20
    //   348: astore 13
    //   350: aload 21
    //   352: astore 14
    //   354: aload 22
    //   356: astore 15
    //   358: aload 23
    //   360: astore 10
    //   362: aload 19
    //   364: astore 11
    //   366: aload_0
    //   367: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   370: invokevirtual 319	java/net/HttpURLConnection:getResponseCode	()I
    //   373: sipush 200
    //   376: if_icmpeq +36 -> 412
    //   379: aload 20
    //   381: astore 13
    //   383: aload 21
    //   385: astore 14
    //   387: aload 22
    //   389: astore 15
    //   391: aload 23
    //   393: astore 10
    //   395: aload 19
    //   397: astore 11
    //   399: aload_0
    //   400: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   403: invokevirtual 319	java/net/HttpURLConnection:getResponseCode	()I
    //   406: sipush 206
    //   409: if_icmpne +411 -> 820
    //   412: aload 20
    //   414: astore 13
    //   416: aload 21
    //   418: astore 14
    //   420: aload 22
    //   422: astore 15
    //   424: aload 23
    //   426: astore 10
    //   428: aload 19
    //   430: astore 11
    //   432: aload_0
    //   433: getstatic 321	com/baidu/carlife/k/a/h$b:c	Lcom/baidu/carlife/k/a/h$b;
    //   436: getstatic 88	com/baidu/carlife/k/a/h$a:a	Lcom/baidu/carlife/k/a/h$a;
    //   439: invokespecial 91	com/baidu/carlife/k/a/i:a	(Lcom/baidu/carlife/k/a/h$b;Lcom/baidu/carlife/k/a/h$a;)V
    //   442: aload 20
    //   444: astore 13
    //   446: aload 21
    //   448: astore 14
    //   450: aload 22
    //   452: astore 15
    //   454: aload 23
    //   456: astore 10
    //   458: aload 19
    //   460: astore 11
    //   462: aload_0
    //   463: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   466: invokevirtual 325	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   469: astore 9
    //   471: aload 9
    //   473: astore 13
    //   475: aload 9
    //   477: astore 14
    //   479: aload 9
    //   481: astore 15
    //   483: aload 9
    //   485: astore 10
    //   487: aload 19
    //   489: astore 11
    //   491: aload_0
    //   492: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   495: invokevirtual 328	java/net/HttpURLConnection:getContentLength	()I
    //   498: istore_1
    //   499: iload_1
    //   500: iflt +35 -> 535
    //   503: aload 9
    //   505: astore 13
    //   507: aload 9
    //   509: astore 14
    //   511: aload 9
    //   513: astore 15
    //   515: aload 9
    //   517: astore 10
    //   519: aload 19
    //   521: astore 11
    //   523: aload_0
    //   524: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   527: iload_1
    //   528: i2l
    //   529: lload 5
    //   531: ladd
    //   532: putfield 330	com/baidu/carlife/k/a/g:f	J
    //   535: aload 9
    //   537: astore 13
    //   539: aload 9
    //   541: astore 14
    //   543: aload 9
    //   545: astore 15
    //   547: aload 9
    //   549: astore 10
    //   551: aload 19
    //   553: astore 11
    //   555: getstatic 49	com/baidu/carlife/k/a/i:b	Ljava/lang/String;
    //   558: new 185	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   565: aload_0
    //   566: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   569: getfield 160	com/baidu/carlife/k/a/g:d	Ljava/lang/String;
    //   572: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: ldc_w 332
    //   578: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: iload_1
    //   582: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: ldc_w 337
    //   588: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload_0
    //   592: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   595: getfield 330	com/baidu/carlife/k/a/g:f	J
    //   598: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   601: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 316	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: aload 9
    //   609: astore 13
    //   611: aload 9
    //   613: astore 14
    //   615: aload 9
    //   617: astore 15
    //   619: aload 9
    //   621: astore 10
    //   623: aload 19
    //   625: astore 11
    //   627: new 339	java/io/RandomAccessFile
    //   630: dup
    //   631: aload_0
    //   632: getfield 225	com/baidu/carlife/k/a/i:h	Ljava/io/File;
    //   635: ldc_w 341
    //   638: invokespecial 344	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   641: astore 12
    //   643: aload 12
    //   645: lload 5
    //   647: invokevirtual 348	java/io/RandomAccessFile:seek	(J)V
    //   650: sipush 1024
    //   653: newarray <illegal type>
    //   655: astore 10
    //   657: iconst_0
    //   658: istore 4
    //   660: iconst_0
    //   661: istore_3
    //   662: lload 5
    //   664: lstore 7
    //   666: iload_3
    //   667: istore_1
    //   668: iload 4
    //   670: istore_2
    //   671: aload_0
    //   672: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   675: getfield 330	com/baidu/carlife/k/a/g:f	J
    //   678: lconst_0
    //   679: lcmp
    //   680: ifle +61 -> 741
    //   683: lload 5
    //   685: lstore 7
    //   687: iload_3
    //   688: istore_1
    //   689: iload 4
    //   691: istore_2
    //   692: aload_0
    //   693: getfield 94	com/baidu/carlife/k/a/i:m	Z
    //   696: ifne +45 -> 741
    //   699: aload_0
    //   700: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   703: getfield 330	com/baidu/carlife/k/a/g:f	J
    //   706: ldc2_w 349
    //   709: ldiv
    //   710: l2i
    //   711: istore_2
    //   712: aload_0
    //   713: lload 5
    //   715: l2d
    //   716: dconst_0
    //   717: dadd
    //   718: aload_0
    //   719: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   722: getfield 330	com/baidu/carlife/k/a/g:f	J
    //   725: l2d
    //   726: ddiv
    //   727: ldc2_w 351
    //   730: dmul
    //   731: d2i
    //   732: invokespecial 354	com/baidu/carlife/k/a/i:a	(I)V
    //   735: iload_3
    //   736: istore_1
    //   737: lload 5
    //   739: lstore 7
    //   741: aload 9
    //   743: aload 10
    //   745: invokevirtual 360	java/io/InputStream:read	([B)I
    //   748: istore_3
    //   749: iload_3
    //   750: iconst_m1
    //   751: if_icmpeq +69 -> 820
    //   754: aload_0
    //   755: getfield 94	com/baidu/carlife/k/a/i:m	Z
    //   758: ifne +62 -> 820
    //   761: aload 12
    //   763: aload 10
    //   765: iconst_0
    //   766: iload_3
    //   767: invokevirtual 364	java/io/RandomAccessFile:write	([BII)V
    //   770: iload_2
    //   771: ifeq -30 -> 741
    //   774: iload_1
    //   775: iload_3
    //   776: iadd
    //   777: istore_3
    //   778: iload_3
    //   779: istore_1
    //   780: iload_3
    //   781: iload_2
    //   782: if_icmple -41 -> 741
    //   785: lload 7
    //   787: iload_3
    //   788: i2l
    //   789: ladd
    //   790: lstore 7
    //   792: aload_0
    //   793: lload 7
    //   795: l2d
    //   796: dconst_0
    //   797: dadd
    //   798: aload_0
    //   799: getfield 61	com/baidu/carlife/k/a/i:g	Lcom/baidu/carlife/k/a/g;
    //   802: getfield 330	com/baidu/carlife/k/a/g:f	J
    //   805: l2d
    //   806: ddiv
    //   807: ldc2_w 351
    //   810: dmul
    //   811: d2i
    //   812: invokespecial 354	com/baidu/carlife/k/a/i:a	(I)V
    //   815: iconst_0
    //   816: istore_1
    //   817: goto -76 -> 741
    //   820: aload 9
    //   822: ifnull +8 -> 830
    //   825: aload 9
    //   827: invokevirtual 367	java/io/InputStream:close	()V
    //   830: aload 12
    //   832: ifnull +8 -> 840
    //   835: aload 12
    //   837: invokevirtual 368	java/io/RandomAccessFile:close	()V
    //   840: aload_0
    //   841: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   844: ifnull -837 -> 7
    //   847: aload_0
    //   848: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   851: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   854: return
    //   855: astore 10
    //   857: aload 16
    //   859: astore 12
    //   861: aload 13
    //   863: astore 9
    //   865: aload 10
    //   867: astore 13
    //   869: aload 9
    //   871: astore 10
    //   873: aload 12
    //   875: astore 11
    //   877: aload_0
    //   878: getstatic 168	com/baidu/carlife/k/a/h$b:f	Lcom/baidu/carlife/k/a/h$b;
    //   881: getstatic 373	com/baidu/carlife/k/a/h$a:e	Lcom/baidu/carlife/k/a/h$a;
    //   884: invokespecial 91	com/baidu/carlife/k/a/i:a	(Lcom/baidu/carlife/k/a/h$b;Lcom/baidu/carlife/k/a/h$a;)V
    //   887: aload 9
    //   889: astore 10
    //   891: aload 12
    //   893: astore 11
    //   895: aload 13
    //   897: invokevirtual 374	java/net/MalformedURLException:printStackTrace	()V
    //   900: aload 9
    //   902: ifnull +8 -> 910
    //   905: aload 9
    //   907: invokevirtual 367	java/io/InputStream:close	()V
    //   910: aload 12
    //   912: ifnull +8 -> 920
    //   915: aload 12
    //   917: invokevirtual 368	java/io/RandomAccessFile:close	()V
    //   920: aload_0
    //   921: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   924: ifnull -917 -> 7
    //   927: aload_0
    //   928: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   931: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   934: return
    //   935: astore 13
    //   937: aload 17
    //   939: astore 12
    //   941: aload 14
    //   943: astore 9
    //   945: aload 9
    //   947: astore 10
    //   949: aload 12
    //   951: astore 11
    //   953: aload_0
    //   954: getstatic 168	com/baidu/carlife/k/a/h$b:f	Lcom/baidu/carlife/k/a/h$b;
    //   957: getstatic 373	com/baidu/carlife/k/a/h$a:e	Lcom/baidu/carlife/k/a/h$a;
    //   960: invokespecial 91	com/baidu/carlife/k/a/i:a	(Lcom/baidu/carlife/k/a/h$b;Lcom/baidu/carlife/k/a/h$a;)V
    //   963: aload 9
    //   965: astore 10
    //   967: aload 12
    //   969: astore 11
    //   971: aload 13
    //   973: invokevirtual 231	java/io/IOException:printStackTrace	()V
    //   976: aload 9
    //   978: astore 10
    //   980: aload 12
    //   982: astore 11
    //   984: getstatic 49	com/baidu/carlife/k/a/i:b	Ljava/lang/String;
    //   987: ldc_w 376
    //   990: invokestatic 378	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: aload 9
    //   995: ifnull +8 -> 1003
    //   998: aload 9
    //   1000: invokevirtual 367	java/io/InputStream:close	()V
    //   1003: aload 12
    //   1005: ifnull +8 -> 1013
    //   1008: aload 12
    //   1010: invokevirtual 368	java/io/RandomAccessFile:close	()V
    //   1013: aload_0
    //   1014: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1017: ifnull -1010 -> 7
    //   1020: aload_0
    //   1021: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1024: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   1027: return
    //   1028: astore 13
    //   1030: aload 18
    //   1032: astore 12
    //   1034: aload 15
    //   1036: astore 9
    //   1038: aload 9
    //   1040: astore 10
    //   1042: aload 12
    //   1044: astore 11
    //   1046: aload_0
    //   1047: getstatic 168	com/baidu/carlife/k/a/h$b:f	Lcom/baidu/carlife/k/a/h$b;
    //   1050: getstatic 373	com/baidu/carlife/k/a/h$a:e	Lcom/baidu/carlife/k/a/h$a;
    //   1053: invokespecial 91	com/baidu/carlife/k/a/i:a	(Lcom/baidu/carlife/k/a/h$b;Lcom/baidu/carlife/k/a/h$a;)V
    //   1056: aload 9
    //   1058: astore 10
    //   1060: aload 12
    //   1062: astore 11
    //   1064: aload 13
    //   1066: invokevirtual 379	java/lang/Exception:printStackTrace	()V
    //   1069: aload 9
    //   1071: astore 10
    //   1073: aload 12
    //   1075: astore 11
    //   1077: getstatic 49	com/baidu/carlife/k/a/i:b	Ljava/lang/String;
    //   1080: ldc_w 381
    //   1083: invokestatic 378	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: aload 9
    //   1088: ifnull +8 -> 1096
    //   1091: aload 9
    //   1093: invokevirtual 367	java/io/InputStream:close	()V
    //   1096: aload 12
    //   1098: ifnull +8 -> 1106
    //   1101: aload 12
    //   1103: invokevirtual 368	java/io/RandomAccessFile:close	()V
    //   1106: aload_0
    //   1107: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1110: ifnull -1103 -> 7
    //   1113: aload_0
    //   1114: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1117: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   1120: return
    //   1121: astore 9
    //   1123: aload 10
    //   1125: ifnull +8 -> 1133
    //   1128: aload 10
    //   1130: invokevirtual 367	java/io/InputStream:close	()V
    //   1133: aload 11
    //   1135: ifnull +8 -> 1143
    //   1138: aload 11
    //   1140: invokevirtual 368	java/io/RandomAccessFile:close	()V
    //   1143: aload_0
    //   1144: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1147: ifnull +10 -> 1157
    //   1150: aload_0
    //   1151: getfield 282	com/baidu/carlife/k/a/i:i	Ljava/net/HttpURLConnection;
    //   1154: invokevirtual 371	java/net/HttpURLConnection:disconnect	()V
    //   1157: aload 9
    //   1159: athrow
    //   1160: astore 10
    //   1162: goto -19 -> 1143
    //   1165: astore 13
    //   1167: aload 12
    //   1169: astore 11
    //   1171: aload 9
    //   1173: astore 10
    //   1175: aload 13
    //   1177: astore 9
    //   1179: goto -56 -> 1123
    //   1182: astore 9
    //   1184: goto -78 -> 1106
    //   1187: astore 13
    //   1189: goto -151 -> 1038
    //   1192: astore 9
    //   1194: goto -181 -> 1013
    //   1197: astore 13
    //   1199: goto -254 -> 945
    //   1202: astore 9
    //   1204: goto -284 -> 920
    //   1207: astore 13
    //   1209: goto -340 -> 869
    //   1212: astore 9
    //   1214: goto -374 -> 840
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1217	0	this	i
    //   498	319	1	i1	int
    //   670	113	2	i2	int
    //   661	127	3	i3	int
    //   658	32	4	i4	int
    //   39	699	5	l1	long
    //   664	130	7	l2	long
    //   21	1071	9	localObject1	Object
    //   1121	51	9	localObject2	Object
    //   1177	1	9	localObject3	Object
    //   1182	1	9	localIOException1	IOException
    //   1192	1	9	localIOException2	IOException
    //   1202	1	9	localIOException3	IOException
    //   1212	1	9	localIOException4	IOException
    //   55	709	10	localObject4	Object
    //   855	11	10	localMalformedURLException1	java.net.MalformedURLException
    //   871	258	10	localObject5	Object
    //   1160	1	10	localIOException5	IOException
    //   1173	1	10	localObject6	Object
    //   59	1111	11	localObject7	Object
    //   36	1132	12	localObject8	Object
    //   43	853	13	localObject9	Object
    //   935	37	13	localIOException6	IOException
    //   1028	37	13	localException1	Exception
    //   1165	11	13	localObject10	Object
    //   1187	1	13	localException2	Exception
    //   1197	1	13	localIOException7	IOException
    //   1207	1	13	localMalformedURLException2	java.net.MalformedURLException
    //   47	895	14	localObject11	Object
    //   51	984	15	localObject12	Object
    //   24	834	16	localObject13	Object
    //   27	911	17	localObject14	Object
    //   30	1001	18	localObject15	Object
    //   33	591	19	localObject16	Object
    //   9	434	20	localObject17	Object
    //   12	435	21	localObject18	Object
    //   15	436	22	localObject19	Object
    //   18	437	23	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   61	85	855	java/net/MalformedURLException
    //   105	115	855	java/net/MalformedURLException
    //   135	145	855	java/net/MalformedURLException
    //   165	173	855	java/net/MalformedURLException
    //   193	203	855	java/net/MalformedURLException
    //   223	232	855	java/net/MalformedURLException
    //   252	289	855	java/net/MalformedURLException
    //   309	346	855	java/net/MalformedURLException
    //   366	379	855	java/net/MalformedURLException
    //   399	412	855	java/net/MalformedURLException
    //   432	442	855	java/net/MalformedURLException
    //   462	471	855	java/net/MalformedURLException
    //   491	499	855	java/net/MalformedURLException
    //   523	535	855	java/net/MalformedURLException
    //   555	607	855	java/net/MalformedURLException
    //   627	643	855	java/net/MalformedURLException
    //   61	85	935	java/io/IOException
    //   105	115	935	java/io/IOException
    //   135	145	935	java/io/IOException
    //   165	173	935	java/io/IOException
    //   193	203	935	java/io/IOException
    //   223	232	935	java/io/IOException
    //   252	289	935	java/io/IOException
    //   309	346	935	java/io/IOException
    //   366	379	935	java/io/IOException
    //   399	412	935	java/io/IOException
    //   432	442	935	java/io/IOException
    //   462	471	935	java/io/IOException
    //   491	499	935	java/io/IOException
    //   523	535	935	java/io/IOException
    //   555	607	935	java/io/IOException
    //   627	643	935	java/io/IOException
    //   61	85	1028	java/lang/Exception
    //   105	115	1028	java/lang/Exception
    //   135	145	1028	java/lang/Exception
    //   165	173	1028	java/lang/Exception
    //   193	203	1028	java/lang/Exception
    //   223	232	1028	java/lang/Exception
    //   252	289	1028	java/lang/Exception
    //   309	346	1028	java/lang/Exception
    //   366	379	1028	java/lang/Exception
    //   399	412	1028	java/lang/Exception
    //   432	442	1028	java/lang/Exception
    //   462	471	1028	java/lang/Exception
    //   491	499	1028	java/lang/Exception
    //   523	535	1028	java/lang/Exception
    //   555	607	1028	java/lang/Exception
    //   627	643	1028	java/lang/Exception
    //   61	85	1121	finally
    //   105	115	1121	finally
    //   135	145	1121	finally
    //   165	173	1121	finally
    //   193	203	1121	finally
    //   223	232	1121	finally
    //   252	289	1121	finally
    //   309	346	1121	finally
    //   366	379	1121	finally
    //   399	412	1121	finally
    //   432	442	1121	finally
    //   462	471	1121	finally
    //   491	499	1121	finally
    //   523	535	1121	finally
    //   555	607	1121	finally
    //   627	643	1121	finally
    //   877	887	1121	finally
    //   895	900	1121	finally
    //   953	963	1121	finally
    //   971	976	1121	finally
    //   984	993	1121	finally
    //   1046	1056	1121	finally
    //   1064	1069	1121	finally
    //   1077	1086	1121	finally
    //   1128	1133	1160	java/io/IOException
    //   1138	1143	1160	java/io/IOException
    //   643	657	1165	finally
    //   671	683	1165	finally
    //   692	735	1165	finally
    //   741	749	1165	finally
    //   754	770	1165	finally
    //   792	815	1165	finally
    //   1091	1096	1182	java/io/IOException
    //   1101	1106	1182	java/io/IOException
    //   643	657	1187	java/lang/Exception
    //   671	683	1187	java/lang/Exception
    //   692	735	1187	java/lang/Exception
    //   741	749	1187	java/lang/Exception
    //   754	770	1187	java/lang/Exception
    //   792	815	1187	java/lang/Exception
    //   998	1003	1192	java/io/IOException
    //   1008	1013	1192	java/io/IOException
    //   643	657	1197	java/io/IOException
    //   671	683	1197	java/io/IOException
    //   692	735	1197	java/io/IOException
    //   741	749	1197	java/io/IOException
    //   754	770	1197	java/io/IOException
    //   792	815	1197	java/io/IOException
    //   905	910	1202	java/io/IOException
    //   915	920	1202	java/io/IOException
    //   643	657	1207	java/net/MalformedURLException
    //   671	683	1207	java/net/MalformedURLException
    //   692	735	1207	java/net/MalformedURLException
    //   741	749	1207	java/net/MalformedURLException
    //   754	770	1207	java/net/MalformedURLException
    //   792	815	1207	java/net/MalformedURLException
    //   825	830	1212	java/io/IOException
    //   835	840	1212	java/io/IOException
  }
  
  protected void h()
  {
    if (d()) {
      return;
    }
    a(100);
    a(h.b.e, h.a.a);
    com.baidu.carlife.core.i.b(b, this.g.d + ":下载成功");
  }
  
  public void run()
  {
    f();
    g();
    h();
  }
  
  public String toString()
  {
    return this.g.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */