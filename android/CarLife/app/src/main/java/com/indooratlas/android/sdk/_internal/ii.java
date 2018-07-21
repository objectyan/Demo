package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class ii
  implements fv
{
  public final go a;
  public Socket b;
  public Socket c;
  public gc d;
  public volatile hc e;
  public int f;
  public ip g;
  public io h;
  public final List<Reference<ig>> i = new ArrayList();
  public boolean j;
  public long k = Long.MAX_VALUE;
  private gi l;
  
  public ii(go paramgo)
  {
    this.a = paramgo;
  }
  
  public final go a()
  {
    return this.a;
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, List<fx> paramList, boolean paramBoolean)
    throws id
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   4: ifnull +13 -> 17
    //   7: new 65	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 67
    //   13: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 72	com/indooratlas/android/sdk/_internal/gq
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 75	com/indooratlas/android/sdk/_internal/gq:<init>	(Ljava/util/List;)V
    //   26: astore 15
    //   28: aload_0
    //   29: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   32: getfield 80	com/indooratlas/android/sdk/_internal/go:b	Ljava/net/Proxy;
    //   35: astore 16
    //   37: aload_0
    //   38: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   41: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   44: astore 17
    //   46: aload_0
    //   47: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   50: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   53: getfield 88	com/indooratlas/android/sdk/_internal/fn:i	Ljavax/net/ssl/SSLSocketFactory;
    //   56: ifnonnull +1475 -> 1531
    //   59: aload 4
    //   61: getstatic 93	com/indooratlas/android/sdk/_internal/fx:c	Lcom/indooratlas/android/sdk/_internal/fx;
    //   64: invokeinterface 99 2 0
    //   69: ifne +1462 -> 1531
    //   72: new 51	com/indooratlas/android/sdk/_internal/id
    //   75: dup
    //   76: new 101	java/net/UnknownServiceException
    //   79: dup
    //   80: new 103	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 105
    //   86: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 4
    //   91: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 115	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   100: invokespecial 118	com/indooratlas/android/sdk/_internal/id:<init>	(Ljava/io/IOException;)V
    //   103: athrow
    //   104: aconst_null
    //   105: astore 11
    //   107: aload_0
    //   108: aload 12
    //   110: putfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   118: invokestatic 125	com/indooratlas/android/sdk/_internal/ix:b	(Ljava/net/Socket;)Lcom/indooratlas/android/sdk/_internal/jd;
    //   121: invokestatic 128	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jd;)Lcom/indooratlas/android/sdk/_internal/ip;
    //   124: putfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   132: invokestatic 133	com/indooratlas/android/sdk/_internal/ix:a	(Ljava/net/Socket;)Lcom/indooratlas/android/sdk/_internal/jc;
    //   135: invokestatic 136	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jc;)Lcom/indooratlas/android/sdk/_internal/io;
    //   138: putfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   141: aload_0
    //   142: aload 14
    //   144: putfield 140	com/indooratlas/android/sdk/_internal/ii:d	Lcom/indooratlas/android/sdk/_internal/gc;
    //   147: aload 11
    //   149: ifnull +1274 -> 1423
    //   152: aload 11
    //   154: invokestatic 145	com/indooratlas/android/sdk/_internal/gi:a	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gi;
    //   157: astore 11
    //   159: aload_0
    //   160: aload 11
    //   162: putfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   165: aload 12
    //   167: ifnull +11 -> 178
    //   170: invokestatic 150	com/indooratlas/android/sdk/_internal/gw:a	()Lcom/indooratlas/android/sdk/_internal/gw;
    //   173: aload 12
    //   175: invokevirtual 153	com/indooratlas/android/sdk/_internal/gw:a	(Ljavax/net/ssl/SSLSocket;)V
    //   178: aload_0
    //   179: getfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   182: getstatic 155	com/indooratlas/android/sdk/_internal/gi:c	Lcom/indooratlas/android/sdk/_internal/gi;
    //   185: if_acmpeq +13 -> 198
    //   188: aload_0
    //   189: getfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   192: getstatic 157	com/indooratlas/android/sdk/_internal/gi:d	Lcom/indooratlas/android/sdk/_internal/gi;
    //   195: if_acmpne +167 -> 362
    //   198: aload_0
    //   199: getfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   202: iconst_0
    //   203: invokevirtual 163	java/net/Socket:setSoTimeout	(I)V
    //   206: new 165	com/indooratlas/android/sdk/_internal/hc$a
    //   209: dup
    //   210: invokespecial 166	com/indooratlas/android/sdk/_internal/hc$a:<init>	()V
    //   213: astore 11
    //   215: aload_0
    //   216: getfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   219: astore 12
    //   221: aload_0
    //   222: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   225: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   228: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   231: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   234: astore 13
    //   236: aload_0
    //   237: getfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   240: astore 14
    //   242: aload_0
    //   243: getfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   246: astore 18
    //   248: aload 11
    //   250: aload 12
    //   252: putfield 176	com/indooratlas/android/sdk/_internal/hc$a:a	Ljava/net/Socket;
    //   255: aload 11
    //   257: aload 13
    //   259: putfield 177	com/indooratlas/android/sdk/_internal/hc$a:b	Ljava/lang/String;
    //   262: aload 11
    //   264: aload 14
    //   266: putfield 179	com/indooratlas/android/sdk/_internal/hc$a:c	Lcom/indooratlas/android/sdk/_internal/ip;
    //   269: aload 11
    //   271: aload 18
    //   273: putfield 181	com/indooratlas/android/sdk/_internal/hc$a:d	Lcom/indooratlas/android/sdk/_internal/io;
    //   276: aload 11
    //   278: aload_0
    //   279: getfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   282: putfield 183	com/indooratlas/android/sdk/_internal/hc$a:f	Lcom/indooratlas/android/sdk/_internal/gi;
    //   285: new 185	com/indooratlas/android/sdk/_internal/hc
    //   288: dup
    //   289: aload 11
    //   291: iconst_0
    //   292: invokespecial 188	com/indooratlas/android/sdk/_internal/hc:<init>	(Lcom/indooratlas/android/sdk/_internal/hc$a;B)V
    //   295: astore 11
    //   297: aload 11
    //   299: getfield 191	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   302: invokeinterface 195 1 0
    //   307: aload 11
    //   309: getfield 191	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   312: aload 11
    //   314: getfield 198	com/indooratlas/android/sdk/_internal/hc:e	Lcom/indooratlas/android/sdk/_internal/hm;
    //   317: invokeinterface 201 2 0
    //   322: aload 11
    //   324: getfield 198	com/indooratlas/android/sdk/_internal/hc:e	Lcom/indooratlas/android/sdk/_internal/hm;
    //   327: invokevirtual 206	com/indooratlas/android/sdk/_internal/hm:b	()I
    //   330: istore 6
    //   332: iload 6
    //   334: ldc -49
    //   336: if_icmpeq +20 -> 356
    //   339: aload 11
    //   341: getfield 191	com/indooratlas/android/sdk/_internal/hc:i	Lcom/indooratlas/android/sdk/_internal/hb;
    //   344: iconst_0
    //   345: iload 6
    //   347: ldc -49
    //   349: isub
    //   350: i2l
    //   351: invokeinterface 210 4 0
    //   356: aload_0
    //   357: aload 11
    //   359: putfield 212	com/indooratlas/android/sdk/_internal/ii:e	Lcom/indooratlas/android/sdk/_internal/hc;
    //   362: aload_0
    //   363: getfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   366: ifnonnull +1140 -> 1506
    //   369: aload 16
    //   371: invokevirtual 218	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   374: getstatic 224	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   377: if_acmpeq +14 -> 391
    //   380: aload 16
    //   382: invokevirtual 218	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   385: getstatic 227	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   388: if_acmpne +592 -> 980
    //   391: aload 17
    //   393: getfield 230	com/indooratlas/android/sdk/_internal/fn:c	Ljavax/net/SocketFactory;
    //   396: invokevirtual 236	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   399: astore 11
    //   401: aload_0
    //   402: aload 11
    //   404: putfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   407: aload_0
    //   408: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   411: iload_2
    //   412: invokevirtual 163	java/net/Socket:setSoTimeout	(I)V
    //   415: invokestatic 150	com/indooratlas/android/sdk/_internal/gw:a	()Lcom/indooratlas/android/sdk/_internal/gw;
    //   418: aload_0
    //   419: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   422: aload_0
    //   423: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   426: getfield 241	com/indooratlas/android/sdk/_internal/go:c	Ljava/net/InetSocketAddress;
    //   429: iload_1
    //   430: invokevirtual 244	com/indooratlas/android/sdk/_internal/gw:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   433: aload_0
    //   434: aload_0
    //   435: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   438: invokestatic 125	com/indooratlas/android/sdk/_internal/ix:b	(Ljava/net/Socket;)Lcom/indooratlas/android/sdk/_internal/jd;
    //   441: invokestatic 128	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jd;)Lcom/indooratlas/android/sdk/_internal/ip;
    //   444: putfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   447: aload_0
    //   448: aload_0
    //   449: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   452: invokestatic 133	com/indooratlas/android/sdk/_internal/ix:a	(Ljava/net/Socket;)Lcom/indooratlas/android/sdk/_internal/jc;
    //   455: invokestatic 136	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jc;)Lcom/indooratlas/android/sdk/_internal/io;
    //   458: putfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   461: aload_0
    //   462: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   465: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   468: getfield 88	com/indooratlas/android/sdk/_internal/fn:i	Ljavax/net/ssl/SSLSocketFactory;
    //   471: ifnull +967 -> 1438
    //   474: aload_0
    //   475: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   478: astore 11
    //   480: aload 11
    //   482: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   485: getfield 88	com/indooratlas/android/sdk/_internal/fn:i	Ljavax/net/ssl/SSLSocketFactory;
    //   488: ifnull +1052 -> 1540
    //   491: aload 11
    //   493: getfield 80	com/indooratlas/android/sdk/_internal/go:b	Ljava/net/Proxy;
    //   496: invokevirtual 218	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   499: getstatic 227	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   502: if_acmpne +1038 -> 1540
    //   505: iconst_1
    //   506: istore 6
    //   508: iload 6
    //   510: ifeq +585 -> 1095
    //   513: new 246	com/indooratlas/android/sdk/_internal/gk$a
    //   516: dup
    //   517: invokespecial 247	com/indooratlas/android/sdk/_internal/gk$a:<init>	()V
    //   520: aload_0
    //   521: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   524: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   527: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   530: invokevirtual 250	com/indooratlas/android/sdk/_internal/gk$a:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   533: ldc -4
    //   535: aload_0
    //   536: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   539: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   542: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   545: invokestatic 257	com/indooratlas/android/sdk/_internal/gy:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Ljava/lang/String;
    //   548: invokevirtual 260	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   551: ldc_w 262
    //   554: ldc_w 264
    //   557: invokevirtual 260	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   560: ldc_w 266
    //   563: ldc_w 268
    //   566: invokevirtual 260	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   569: invokevirtual 271	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   572: astore 11
    //   574: aload 11
    //   576: getfield 274	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   579: astore 12
    //   581: new 103	java/lang/StringBuilder
    //   584: dup
    //   585: ldc_w 276
    //   588: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: aload 12
    //   593: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   596: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 281
    //   602: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 12
    //   607: getfield 283	com/indooratlas/android/sdk/_internal/ge:c	I
    //   610: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: ldc_w 288
    //   616: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: astore 13
    //   624: new 290	com/indooratlas/android/sdk/_internal/hs
    //   627: dup
    //   628: aconst_null
    //   629: aload_0
    //   630: getfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   633: aload_0
    //   634: getfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   637: invokespecial 293	com/indooratlas/android/sdk/_internal/hs:<init>	(Lcom/indooratlas/android/sdk/_internal/ig;Lcom/indooratlas/android/sdk/_internal/ip;Lcom/indooratlas/android/sdk/_internal/io;)V
    //   640: astore 12
    //   642: aload_0
    //   643: getfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   646: invokeinterface 298 1 0
    //   651: iload_2
    //   652: i2l
    //   653: getstatic 304	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   656: invokevirtual 309	com/indooratlas/android/sdk/_internal/je:a	(JLjava/util/concurrent/TimeUnit;)Lcom/indooratlas/android/sdk/_internal/je;
    //   659: pop
    //   660: aload_0
    //   661: getfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   664: invokeinterface 312 1 0
    //   669: iload_3
    //   670: i2l
    //   671: getstatic 304	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   674: invokevirtual 309	com/indooratlas/android/sdk/_internal/je:a	(JLjava/util/concurrent/TimeUnit;)Lcom/indooratlas/android/sdk/_internal/je;
    //   677: pop
    //   678: aload 12
    //   680: aload 11
    //   682: getfield 315	com/indooratlas/android/sdk/_internal/gk:c	Lcom/indooratlas/android/sdk/_internal/gd;
    //   685: aload 13
    //   687: invokevirtual 318	com/indooratlas/android/sdk/_internal/hs:a	(Lcom/indooratlas/android/sdk/_internal/gd;Ljava/lang/String;)V
    //   690: aload 12
    //   692: invokevirtual 320	com/indooratlas/android/sdk/_internal/hs:c	()V
    //   695: aload 12
    //   697: invokevirtual 323	com/indooratlas/android/sdk/_internal/hs:d	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   700: astore 13
    //   702: aload 13
    //   704: aload 11
    //   706: putfield 328	com/indooratlas/android/sdk/_internal/gm$a:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   709: aload 13
    //   711: invokevirtual 331	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   714: astore 11
    //   716: aload 11
    //   718: invokestatic 336	com/indooratlas/android/sdk/_internal/hy:a	(Lcom/indooratlas/android/sdk/_internal/gm;)J
    //   721: lstore 9
    //   723: lload 9
    //   725: lstore 7
    //   727: lload 9
    //   729: ldc2_w 337
    //   732: lcmp
    //   733: ifne +6 -> 739
    //   736: lconst_0
    //   737: lstore 7
    //   739: aload 12
    //   741: lload 7
    //   743: invokevirtual 341	com/indooratlas/android/sdk/_internal/hs:a	(J)Lcom/indooratlas/android/sdk/_internal/jd;
    //   746: astore 12
    //   748: aload 12
    //   750: ldc_w 342
    //   753: getstatic 304	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   756: invokestatic 345	com/indooratlas/android/sdk/_internal/gy:a	(Lcom/indooratlas/android/sdk/_internal/jd;ILjava/util/concurrent/TimeUnit;)Z
    //   759: pop
    //   760: aload 12
    //   762: invokeinterface 350 1 0
    //   767: aload 11
    //   769: getfield 353	com/indooratlas/android/sdk/_internal/gm:c	I
    //   772: lookupswitch	default:+765->1537, 200:+255->1027, 407:+296->1068
    //   800: new 55	java/io/IOException
    //   803: dup
    //   804: new 103	java/lang/StringBuilder
    //   807: dup
    //   808: ldc_w 355
    //   811: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   814: aload 11
    //   816: getfield 353	com/indooratlas/android/sdk/_internal/gm:c	I
    //   819: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokespecial 356	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   828: athrow
    //   829: astore 11
    //   831: aload_0
    //   832: getfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   835: invokestatic 359	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/net/Socket;)V
    //   838: aload_0
    //   839: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   842: invokestatic 359	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/net/Socket;)V
    //   845: aload_0
    //   846: aconst_null
    //   847: putfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   850: aload_0
    //   851: aconst_null
    //   852: putfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   855: aload_0
    //   856: aconst_null
    //   857: putfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   860: aload_0
    //   861: aconst_null
    //   862: putfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   865: aload_0
    //   866: aconst_null
    //   867: putfield 140	com/indooratlas/android/sdk/_internal/ii:d	Lcom/indooratlas/android/sdk/_internal/gc;
    //   870: aload_0
    //   871: aconst_null
    //   872: putfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   875: aload 4
    //   877: ifnonnull +579 -> 1456
    //   880: new 51	com/indooratlas/android/sdk/_internal/id
    //   883: dup
    //   884: aload 11
    //   886: invokespecial 118	com/indooratlas/android/sdk/_internal/id:<init>	(Ljava/io/IOException;)V
    //   889: astore 4
    //   891: iload 5
    //   893: ifeq +84 -> 977
    //   896: aload 15
    //   898: iconst_1
    //   899: putfield 361	com/indooratlas/android/sdk/_internal/gq:b	Z
    //   902: aload 15
    //   904: getfield 363	com/indooratlas/android/sdk/_internal/gq:a	Z
    //   907: ifeq +590 -> 1497
    //   910: aload 11
    //   912: instanceof 365
    //   915: ifne +582 -> 1497
    //   918: aload 11
    //   920: instanceof 367
    //   923: ifne +574 -> 1497
    //   926: aload 11
    //   928: instanceof 369
    //   931: ifeq +14 -> 945
    //   934: aload 11
    //   936: invokevirtual 373	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   939: instanceof 375
    //   942: ifne +555 -> 1497
    //   945: aload 11
    //   947: instanceof 377
    //   950: ifne +547 -> 1497
    //   953: aload 11
    //   955: instanceof 369
    //   958: ifne +11 -> 969
    //   961: aload 11
    //   963: instanceof 379
    //   966: ifeq +531 -> 1497
    //   969: iconst_1
    //   970: istore 6
    //   972: iload 6
    //   974: ifne +529 -> 1503
    //   977: aload 4
    //   979: athrow
    //   980: new 159	java/net/Socket
    //   983: dup
    //   984: aload 16
    //   986: invokespecial 382	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   989: astore 11
    //   991: goto -590 -> 401
    //   994: astore 11
    //   996: new 57	java/net/ConnectException
    //   999: dup
    //   1000: new 103	java/lang/StringBuilder
    //   1003: dup
    //   1004: ldc_w 384
    //   1007: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1010: aload_0
    //   1011: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   1014: getfield 241	com/indooratlas/android/sdk/_internal/go:c	Ljava/net/InetSocketAddress;
    //   1017: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1020: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1023: invokespecial 385	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   1026: athrow
    //   1027: aload_0
    //   1028: getfield 130	com/indooratlas/android/sdk/_internal/ii:g	Lcom/indooratlas/android/sdk/_internal/ip;
    //   1031: invokeinterface 388 1 0
    //   1036: invokevirtual 393	com/indooratlas/android/sdk/_internal/in:d	()Z
    //   1039: ifeq +18 -> 1057
    //   1042: aload_0
    //   1043: getfield 138	com/indooratlas/android/sdk/_internal/ii:h	Lcom/indooratlas/android/sdk/_internal/io;
    //   1046: invokeinterface 394 1 0
    //   1051: invokevirtual 393	com/indooratlas/android/sdk/_internal/in:d	()Z
    //   1054: ifne +41 -> 1095
    //   1057: new 55	java/io/IOException
    //   1060: dup
    //   1061: ldc_w 396
    //   1064: invokespecial 356	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1067: athrow
    //   1068: aload_0
    //   1069: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   1072: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   1075: getfield 399	com/indooratlas/android/sdk/_internal/fn:d	Lcom/indooratlas/android/sdk/_internal/fo;
    //   1078: invokeinterface 402 1 0
    //   1083: pop
    //   1084: new 55	java/io/IOException
    //   1087: dup
    //   1088: ldc_w 404
    //   1091: invokespecial 356	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1094: athrow
    //   1095: aload_0
    //   1096: getfield 46	com/indooratlas/android/sdk/_internal/ii:a	Lcom/indooratlas/android/sdk/_internal/go;
    //   1099: getfield 83	com/indooratlas/android/sdk/_internal/go:a	Lcom/indooratlas/android/sdk/_internal/fn;
    //   1102: astore 13
    //   1104: aload 13
    //   1106: getfield 88	com/indooratlas/android/sdk/_internal/fn:i	Ljavax/net/ssl/SSLSocketFactory;
    //   1109: astore 12
    //   1111: aconst_null
    //   1112: astore 11
    //   1114: aconst_null
    //   1115: astore 14
    //   1117: aload 12
    //   1119: aload_0
    //   1120: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   1123: aload 13
    //   1125: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1128: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   1131: aload 13
    //   1133: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1136: getfield 283	com/indooratlas/android/sdk/_internal/ge:c	I
    //   1139: iconst_1
    //   1140: invokevirtual 409	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   1143: checkcast 411	javax/net/ssl/SSLSocket
    //   1146: astore 12
    //   1148: aload 15
    //   1150: aload 12
    //   1152: invokevirtual 414	com/indooratlas/android/sdk/_internal/gq:a	(Ljavax/net/ssl/SSLSocket;)Lcom/indooratlas/android/sdk/_internal/fx;
    //   1155: astore 11
    //   1157: aload 11
    //   1159: getfield 416	com/indooratlas/android/sdk/_internal/fx:d	Z
    //   1162: ifeq +24 -> 1186
    //   1165: invokestatic 150	com/indooratlas/android/sdk/_internal/gw:a	()Lcom/indooratlas/android/sdk/_internal/gw;
    //   1168: aload 12
    //   1170: aload 13
    //   1172: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1175: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   1178: aload 13
    //   1180: getfield 418	com/indooratlas/android/sdk/_internal/fn:e	Ljava/util/List;
    //   1183: invokevirtual 421	com/indooratlas/android/sdk/_internal/gw:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   1186: aload 12
    //   1188: invokevirtual 424	javax/net/ssl/SSLSocket:startHandshake	()V
    //   1191: aload 12
    //   1193: invokevirtual 428	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   1196: invokestatic 433	com/indooratlas/android/sdk/_internal/gc:a	(Ljavax/net/ssl/SSLSession;)Lcom/indooratlas/android/sdk/_internal/gc;
    //   1199: astore 14
    //   1201: aload 13
    //   1203: getfield 436	com/indooratlas/android/sdk/_internal/fn:j	Ljavax/net/ssl/HostnameVerifier;
    //   1206: aload 13
    //   1208: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1211: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   1214: aload 12
    //   1216: invokevirtual 428	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   1219: invokeinterface 442 3 0
    //   1224: ifne +157 -> 1381
    //   1227: aload 14
    //   1229: getfield 444	com/indooratlas/android/sdk/_internal/gc:b	Ljava/util/List;
    //   1232: iconst_0
    //   1233: invokeinterface 448 2 0
    //   1238: checkcast 450	java/security/cert/X509Certificate
    //   1241: astore 11
    //   1243: new 377	javax/net/ssl/SSLPeerUnverifiedException
    //   1246: dup
    //   1247: new 103	java/lang/StringBuilder
    //   1250: dup
    //   1251: ldc_w 452
    //   1254: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1257: aload 13
    //   1259: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1262: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   1265: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: ldc_w 454
    //   1271: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: aload 11
    //   1276: invokestatic 459	com/indooratlas/android/sdk/_internal/ft:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   1279: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: ldc_w 461
    //   1285: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aload 11
    //   1290: invokevirtual 465	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   1293: invokeinterface 470 1 0
    //   1298: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: ldc_w 472
    //   1304: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: aload 11
    //   1309: invokestatic 477	com/indooratlas/android/sdk/_internal/ik:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   1312: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: invokespecial 478	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   1321: athrow
    //   1322: astore 13
    //   1324: aload 12
    //   1326: astore 11
    //   1328: aload 13
    //   1330: invokestatic 481	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/lang/AssertionError;)Z
    //   1333: ifeq +98 -> 1431
    //   1336: aload 12
    //   1338: astore 11
    //   1340: new 55	java/io/IOException
    //   1343: dup
    //   1344: aload 13
    //   1346: invokespecial 484	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   1349: athrow
    //   1350: astore 13
    //   1352: aload 11
    //   1354: astore 12
    //   1356: aload 13
    //   1358: astore 11
    //   1360: aload 12
    //   1362: ifnull +11 -> 1373
    //   1365: invokestatic 150	com/indooratlas/android/sdk/_internal/gw:a	()Lcom/indooratlas/android/sdk/_internal/gw;
    //   1368: aload 12
    //   1370: invokevirtual 153	com/indooratlas/android/sdk/_internal/gw:a	(Ljavax/net/ssl/SSLSocket;)V
    //   1373: aload 12
    //   1375: invokestatic 359	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/net/Socket;)V
    //   1378: aload 11
    //   1380: athrow
    //   1381: aload 13
    //   1383: getfield 487	com/indooratlas/android/sdk/_internal/fn:k	Lcom/indooratlas/android/sdk/_internal/ft;
    //   1386: aload 13
    //   1388: getfield 169	com/indooratlas/android/sdk/_internal/fn:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1391: getfield 174	com/indooratlas/android/sdk/_internal/ge:b	Ljava/lang/String;
    //   1394: aload 14
    //   1396: getfield 444	com/indooratlas/android/sdk/_internal/gc:b	Ljava/util/List;
    //   1399: invokevirtual 490	com/indooratlas/android/sdk/_internal/ft:a	(Ljava/lang/String;Ljava/util/List;)V
    //   1402: aload 11
    //   1404: getfield 416	com/indooratlas/android/sdk/_internal/fx:d	Z
    //   1407: ifeq -1303 -> 104
    //   1410: invokestatic 150	com/indooratlas/android/sdk/_internal/gw:a	()Lcom/indooratlas/android/sdk/_internal/gw;
    //   1413: aload 12
    //   1415: invokevirtual 493	com/indooratlas/android/sdk/_internal/gw:b	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   1418: astore 11
    //   1420: goto -1313 -> 107
    //   1423: getstatic 495	com/indooratlas/android/sdk/_internal/gi:b	Lcom/indooratlas/android/sdk/_internal/gi;
    //   1426: astore 11
    //   1428: goto -1269 -> 159
    //   1431: aload 12
    //   1433: astore 11
    //   1435: aload 13
    //   1437: athrow
    //   1438: aload_0
    //   1439: getstatic 495	com/indooratlas/android/sdk/_internal/gi:b	Lcom/indooratlas/android/sdk/_internal/gi;
    //   1442: putfield 63	com/indooratlas/android/sdk/_internal/ii:l	Lcom/indooratlas/android/sdk/_internal/gi;
    //   1445: aload_0
    //   1446: aload_0
    //   1447: getfield 238	com/indooratlas/android/sdk/_internal/ii:b	Ljava/net/Socket;
    //   1450: putfield 120	com/indooratlas/android/sdk/_internal/ii:c	Ljava/net/Socket;
    //   1453: goto -1275 -> 178
    //   1456: aload 4
    //   1458: getfield 498	com/indooratlas/android/sdk/_internal/id:b	Ljava/io/IOException;
    //   1461: astore 12
    //   1463: getstatic 501	com/indooratlas/android/sdk/_internal/id:a	Ljava/lang/reflect/Method;
    //   1466: ifnull +21 -> 1487
    //   1469: getstatic 501	com/indooratlas/android/sdk/_internal/id:a	Ljava/lang/reflect/Method;
    //   1472: aload 11
    //   1474: iconst_1
    //   1475: anewarray 4	java/lang/Object
    //   1478: dup
    //   1479: iconst_0
    //   1480: aload 12
    //   1482: aastore
    //   1483: invokevirtual 507	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1486: pop
    //   1487: aload 4
    //   1489: aload 11
    //   1491: putfield 498	com/indooratlas/android/sdk/_internal/id:b	Ljava/io/IOException;
    //   1494: goto -603 -> 891
    //   1497: iconst_0
    //   1498: istore 6
    //   1500: goto -528 -> 972
    //   1503: goto -1141 -> 362
    //   1506: return
    //   1507: astore 12
    //   1509: goto -22 -> 1487
    //   1512: astore 12
    //   1514: goto -27 -> 1487
    //   1517: astore 11
    //   1519: goto -159 -> 1360
    //   1522: astore 13
    //   1524: aload 14
    //   1526: astore 12
    //   1528: goto -204 -> 1324
    //   1531: aconst_null
    //   1532: astore 4
    //   1534: goto -1172 -> 362
    //   1537: goto -737 -> 800
    //   1540: iconst_0
    //   1541: istore 6
    //   1543: goto -1035 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1546	0	this	ii
    //   0	1546	1	paramInt1	int
    //   0	1546	2	paramInt2	int
    //   0	1546	3	paramInt3	int
    //   0	1546	4	paramList	List<fx>
    //   0	1546	5	paramBoolean	boolean
    //   330	1212	6	m	int
    //   725	17	7	l1	long
    //   721	7	9	l2	long
    //   105	710	11	localObject1	Object
    //   829	133	11	localIOException	IOException
    //   989	1	11	localSocket	Socket
    //   994	1	11	localConnectException	java.net.ConnectException
    //   1112	378	11	localObject2	Object
    //   1517	1	11	localObject3	Object
    //   108	1373	12	localObject4	Object
    //   1507	1	12	localIllegalAccessException	IllegalAccessException
    //   1512	1	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1526	1	12	localObject5	Object
    //   234	1024	13	localObject6	Object
    //   1322	23	13	localAssertionError1	AssertionError
    //   1350	86	13	localObject7	Object
    //   1522	1	13	localAssertionError2	AssertionError
    //   142	1383	14	localObject8	Object
    //   26	1123	15	localgq	gq
    //   35	950	16	localProxy	java.net.Proxy
    //   44	348	17	localfn	fn
    //   246	26	18	localio	io
    // Exception table:
    //   from	to	target	type
    //   170	178	829	java/io/IOException
    //   178	198	829	java/io/IOException
    //   198	332	829	java/io/IOException
    //   339	356	829	java/io/IOException
    //   356	362	829	java/io/IOException
    //   369	391	829	java/io/IOException
    //   391	401	829	java/io/IOException
    //   401	415	829	java/io/IOException
    //   415	433	829	java/io/IOException
    //   433	505	829	java/io/IOException
    //   513	723	829	java/io/IOException
    //   739	800	829	java/io/IOException
    //   800	829	829	java/io/IOException
    //   980	991	829	java/io/IOException
    //   996	1027	829	java/io/IOException
    //   1027	1057	829	java/io/IOException
    //   1057	1068	829	java/io/IOException
    //   1068	1095	829	java/io/IOException
    //   1095	1111	829	java/io/IOException
    //   1365	1373	829	java/io/IOException
    //   1373	1381	829	java/io/IOException
    //   1438	1453	829	java/io/IOException
    //   415	433	994	java/net/ConnectException
    //   107	147	1322	java/lang/AssertionError
    //   152	159	1322	java/lang/AssertionError
    //   159	165	1322	java/lang/AssertionError
    //   1148	1186	1322	java/lang/AssertionError
    //   1186	1322	1322	java/lang/AssertionError
    //   1381	1420	1322	java/lang/AssertionError
    //   1423	1428	1322	java/lang/AssertionError
    //   1117	1148	1350	finally
    //   1328	1336	1350	finally
    //   1340	1350	1350	finally
    //   1435	1438	1350	finally
    //   1469	1487	1507	java/lang/IllegalAccessException
    //   1469	1487	1512	java/lang/reflect/InvocationTargetException
    //   107	147	1517	finally
    //   152	159	1517	finally
    //   159	165	1517	finally
    //   1148	1186	1517	finally
    //   1186	1322	1517	finally
    //   1381	1420	1517	finally
    //   1423	1428	1517	finally
    //   1117	1148	1522	java/lang/AssertionError
  }
  
  public final boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.c.isClosed()) || (this.c.isInputShutdown()) || (this.c.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.e != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int m = this.c.getSoTimeout();
      try
      {
        this.c.setSoTimeout(1);
        paramBoolean = this.g.d();
        return !paramBoolean;
      }
      finally
      {
        this.c.setSoTimeout(m);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Connection{").append(this.a.a.a.b).append(":").append(this.a.a.a.c).append(", proxy=").append(this.a.b).append(" hostAddress=").append(this.a.c).append(" cipherSuite=");
    if (this.d != null) {}
    for (Object localObject = this.d.a;; localObject = "none") {
      return localObject + " protocol=" + this.l + '}';
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */