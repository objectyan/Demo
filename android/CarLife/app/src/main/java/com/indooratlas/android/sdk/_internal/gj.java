package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.List;

final class gj
  implements fr
{
  final gh a;
  volatile boolean b;
  gk c;
  hv d;
  private boolean e;
  
  protected gj(gh paramgh, gk paramgk)
  {
    this.a = paramgh;
    this.c = paramgk;
  }
  
  public final gk a()
  {
    return this.c;
  }
  
  /* Error */
  final gm a(gk paramgk, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 75	com/indooratlas/android/sdk/_internal/gk:d	Lcom/indooratlas/android/sdk/_internal/gl;
    //   4: astore 16
    //   6: aload 16
    //   8: ifnull +3105 -> 3113
    //   11: aload_1
    //   12: invokevirtual 78	com/indooratlas/android/sdk/_internal/gk:e	()Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   15: astore_1
    //   16: aload 16
    //   18: invokevirtual 83	com/indooratlas/android/sdk/_internal/gl:a	()Lcom/indooratlas/android/sdk/_internal/gg;
    //   21: astore 17
    //   23: aload 17
    //   25: ifnull +15 -> 40
    //   28: aload_1
    //   29: ldc 85
    //   31: aload 17
    //   33: invokevirtual 88	com/indooratlas/android/sdk/_internal/gg:toString	()Ljava/lang/String;
    //   36: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   39: pop
    //   40: aload 16
    //   42: invokevirtual 96	com/indooratlas/android/sdk/_internal/gl:b	()J
    //   45: lstore 6
    //   47: lload 6
    //   49: ldc2_w 97
    //   52: lcmp
    //   53: ifeq +80 -> 133
    //   56: aload_1
    //   57: ldc 100
    //   59: lload 6
    //   61: invokestatic 105	java/lang/Long:toString	(J)Ljava/lang/String;
    //   64: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   67: pop
    //   68: aload_1
    //   69: ldc 107
    //   71: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 112	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   79: astore_1
    //   80: aload_0
    //   81: new 114	com/indooratlas/android/sdk/_internal/hv
    //   84: dup
    //   85: aload_0
    //   86: getfield 26	com/indooratlas/android/sdk/_internal/gj:a	Lcom/indooratlas/android/sdk/_internal/gh;
    //   89: aload_1
    //   90: iconst_0
    //   91: iconst_0
    //   92: iload_2
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokespecial 117	com/indooratlas/android/sdk/_internal/hv:<init>	(Lcom/indooratlas/android/sdk/_internal/gh;Lcom/indooratlas/android/sdk/_internal/gk;ZZZLcom/indooratlas/android/sdk/_internal/ig;Lcom/indooratlas/android/sdk/_internal/gm;)V
    //   98: putfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: getfield 32	com/indooratlas/android/sdk/_internal/gj:b	Z
    //   107: ifeq +45 -> 152
    //   110: aload_0
    //   111: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   114: getfield 122	com/indooratlas/android/sdk/_internal/hv:c	Lcom/indooratlas/android/sdk/_internal/ig;
    //   117: iconst_0
    //   118: iconst_1
    //   119: iconst_0
    //   120: invokevirtual 127	com/indooratlas/android/sdk/_internal/ig:a	(ZZZ)V
    //   123: new 68	java/io/IOException
    //   126: dup
    //   127: ldc -127
    //   129: invokespecial 132	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: aload_1
    //   134: ldc 107
    //   136: ldc -122
    //   138: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   141: pop
    //   142: aload_1
    //   143: ldc 100
    //   145: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   148: pop
    //   149: goto -74 -> 75
    //   152: aload_0
    //   153: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   156: astore 18
    //   158: aload 18
    //   160: getfield 138	com/indooratlas/android/sdk/_internal/hv:r	Lcom/indooratlas/android/sdk/_internal/hq;
    //   163: ifnonnull +430 -> 593
    //   166: aload 18
    //   168: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   171: ifnull +39 -> 210
    //   174: new 143	java/lang/IllegalStateException
    //   177: dup
    //   178: invokespecial 144	java/lang/IllegalStateException:<init>	()V
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 147	com/indooratlas/android/sdk/_internal/ia:a	()Ljava/io/IOException;
    //   187: athrow
    //   188: astore_1
    //   189: iconst_1
    //   190: istore_3
    //   191: iload_3
    //   192: ifeq +16 -> 208
    //   195: aload_0
    //   196: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   199: invokevirtual 150	com/indooratlas/android/sdk/_internal/hv:b	()Lcom/indooratlas/android/sdk/_internal/ig;
    //   202: iconst_0
    //   203: iconst_1
    //   204: iconst_0
    //   205: invokevirtual 127	com/indooratlas/android/sdk/_internal/ig:a	(ZZZ)V
    //   208: aload_1
    //   209: athrow
    //   210: aload 18
    //   212: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 78	com/indooratlas/android/sdk/_internal/gk:e	()Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   220: astore 16
    //   222: aload_1
    //   223: ldc -101
    //   225: invokevirtual 158	com/indooratlas/android/sdk/_internal/gk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   228: ifnonnull +18 -> 246
    //   231: aload 16
    //   233: ldc -101
    //   235: aload_1
    //   236: getfield 39	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   239: invokestatic 163	com/indooratlas/android/sdk/_internal/gy:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Ljava/lang/String;
    //   242: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   245: pop
    //   246: aload_1
    //   247: ldc -91
    //   249: invokevirtual 158	com/indooratlas/android/sdk/_internal/gk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   252: ifnonnull +13 -> 265
    //   255: aload 16
    //   257: ldc -91
    //   259: ldc -89
    //   261: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   264: pop
    //   265: aload_1
    //   266: ldc -87
    //   268: invokevirtual 158	com/indooratlas/android/sdk/_internal/gk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   271: ifnonnull +19 -> 290
    //   274: aload 18
    //   276: iconst_1
    //   277: putfield 172	com/indooratlas/android/sdk/_internal/hv:g	Z
    //   280: aload 16
    //   282: ldc -87
    //   284: ldc -82
    //   286: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   289: pop
    //   290: aload 18
    //   292: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   295: getfield 182	com/indooratlas/android/sdk/_internal/gh:h	Lcom/indooratlas/android/sdk/_internal/fz;
    //   298: invokeinterface 187 1 0
    //   303: astore 17
    //   305: aload 17
    //   307: invokeinterface 193 1 0
    //   312: ifne +16 -> 328
    //   315: aload 16
    //   317: ldc -61
    //   319: aload 17
    //   321: invokestatic 198	com/indooratlas/android/sdk/_internal/hv:a	(Ljava/util/List;)Ljava/lang/String;
    //   324: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   327: pop
    //   328: aload_1
    //   329: ldc -56
    //   331: invokevirtual 158	com/indooratlas/android/sdk/_internal/gk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   334: ifnonnull +13 -> 347
    //   337: aload 16
    //   339: ldc -56
    //   341: ldc -54
    //   343: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   346: pop
    //   347: aload 16
    //   349: invokevirtual 112	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   352: astore 19
    //   354: getstatic 207	com/indooratlas/android/sdk/_internal/gs:b	Lcom/indooratlas/android/sdk/_internal/gs;
    //   357: aload 18
    //   359: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   362: invokevirtual 210	com/indooratlas/android/sdk/_internal/gs:a	(Lcom/indooratlas/android/sdk/_internal/gh;)Lcom/indooratlas/android/sdk/_internal/gt;
    //   365: astore_1
    //   366: aload_1
    //   367: ifnull +301 -> 668
    //   370: aload_1
    //   371: invokeinterface 215 1 0
    //   376: astore 16
    //   378: new 217	com/indooratlas/android/sdk/_internal/hq$a
    //   381: dup
    //   382: invokestatic 222	java/lang/System:currentTimeMillis	()J
    //   385: aload 19
    //   387: aload 16
    //   389: invokespecial 225	com/indooratlas/android/sdk/_internal/hq$a:<init>	(JLcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;)V
    //   392: astore 20
    //   394: aload 20
    //   396: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   399: ifnonnull +275 -> 674
    //   402: new 230	com/indooratlas/android/sdk/_internal/hq
    //   405: dup
    //   406: aload 20
    //   408: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   411: aconst_null
    //   412: iconst_0
    //   413: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   416: astore_1
    //   417: aload_1
    //   418: astore 17
    //   420: aload_1
    //   421: getfield 237	com/indooratlas/android/sdk/_internal/hq:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   424: ifnull +32 -> 456
    //   427: aload_1
    //   428: astore 17
    //   430: aload 20
    //   432: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   435: invokevirtual 241	com/indooratlas/android/sdk/_internal/gk:f	()Lcom/indooratlas/android/sdk/_internal/fq;
    //   438: getfield 246	com/indooratlas/android/sdk/_internal/fq:k	Z
    //   441: ifeq +15 -> 456
    //   444: new 230	com/indooratlas/android/sdk/_internal/hq
    //   447: dup
    //   448: aconst_null
    //   449: aconst_null
    //   450: iconst_0
    //   451: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   454: astore 17
    //   456: aload 18
    //   458: aload 17
    //   460: putfield 138	com/indooratlas/android/sdk/_internal/hv:r	Lcom/indooratlas/android/sdk/_internal/hq;
    //   463: aload 18
    //   465: aload 18
    //   467: getfield 138	com/indooratlas/android/sdk/_internal/hv:r	Lcom/indooratlas/android/sdk/_internal/hq;
    //   470: getfield 237	com/indooratlas/android/sdk/_internal/hq:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   473: putfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   476: aload 18
    //   478: aload 18
    //   480: getfield 138	com/indooratlas/android/sdk/_internal/hv:r	Lcom/indooratlas/android/sdk/_internal/hq;
    //   483: getfield 251	com/indooratlas/android/sdk/_internal/hq:b	Lcom/indooratlas/android/sdk/_internal/gm;
    //   486: putfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   489: aload 16
    //   491: ifnull +19 -> 510
    //   494: aload 18
    //   496: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   499: ifnonnull +11 -> 510
    //   502: aload 16
    //   504: getfield 258	com/indooratlas/android/sdk/_internal/gm:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   507: invokestatic 261	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
    //   510: aload 18
    //   512: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   515: ifnonnull +914 -> 1429
    //   518: aload 18
    //   520: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   523: ifnonnull +906 -> 1429
    //   526: new 263	com/indooratlas/android/sdk/_internal/gm$a
    //   529: dup
    //   530: invokespecial 264	com/indooratlas/android/sdk/_internal/gm$a:<init>	()V
    //   533: astore_1
    //   534: aload_1
    //   535: aload 18
    //   537: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   540: putfield 265	com/indooratlas/android/sdk/_internal/gm$a:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   543: aload_1
    //   544: aload 18
    //   546: getfield 267	com/indooratlas/android/sdk/_internal/hv:d	Lcom/indooratlas/android/sdk/_internal/gm;
    //   549: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   552: invokevirtual 273	com/indooratlas/android/sdk/_internal/gm$a:c	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   555: astore_1
    //   556: aload_1
    //   557: getstatic 278	com/indooratlas/android/sdk/_internal/gi:b	Lcom/indooratlas/android/sdk/_internal/gi;
    //   560: putfield 279	com/indooratlas/android/sdk/_internal/gm$a:b	Lcom/indooratlas/android/sdk/_internal/gi;
    //   563: aload_1
    //   564: sipush 504
    //   567: putfield 282	com/indooratlas/android/sdk/_internal/gm$a:c	I
    //   570: aload_1
    //   571: ldc_w 284
    //   574: putfield 287	com/indooratlas/android/sdk/_internal/gm$a:d	Ljava/lang/String;
    //   577: aload_1
    //   578: getstatic 289	com/indooratlas/android/sdk/_internal/hv:a	Lcom/indooratlas/android/sdk/_internal/gn;
    //   581: putfield 290	com/indooratlas/android/sdk/_internal/gm$a:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   584: aload 18
    //   586: aload_1
    //   587: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   590: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   593: aload_0
    //   594: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   597: astore 17
    //   599: aload 17
    //   601: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   604: ifnonnull +1368 -> 1972
    //   607: aload 17
    //   609: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   612: ifnonnull +1166 -> 1778
    //   615: aload 17
    //   617: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   620: ifnonnull +1158 -> 1778
    //   623: new 143	java/lang/IllegalStateException
    //   626: dup
    //   627: ldc_w 296
    //   630: invokespecial 297	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   633: athrow
    //   634: astore_1
    //   635: aload_0
    //   636: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   639: aload_1
    //   640: getfield 300	com/indooratlas/android/sdk/_internal/id:b	Ljava/io/IOException;
    //   643: invokevirtual 303	com/indooratlas/android/sdk/_internal/hv:a	(Ljava/io/IOException;)Lcom/indooratlas/android/sdk/_internal/hv;
    //   646: astore 16
    //   648: aload 16
    //   650: ifnull +1884 -> 2534
    //   653: aload_0
    //   654: aload 16
    //   656: putfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   659: goto -556 -> 103
    //   662: iconst_0
    //   663: istore_3
    //   664: astore_1
    //   665: goto -474 -> 191
    //   668: aconst_null
    //   669: astore 16
    //   671: goto -293 -> 378
    //   674: aload 20
    //   676: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   679: invokevirtual 305	com/indooratlas/android/sdk/_internal/gk:g	()Z
    //   682: ifeq +57 -> 739
    //   685: aload 20
    //   687: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   690: getfield 308	com/indooratlas/android/sdk/_internal/gm:e	Lcom/indooratlas/android/sdk/_internal/gc;
    //   693: ifnonnull +46 -> 739
    //   696: new 230	com/indooratlas/android/sdk/_internal/hq
    //   699: dup
    //   700: aload 20
    //   702: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   705: aconst_null
    //   706: iconst_0
    //   707: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   710: astore_1
    //   711: goto -294 -> 417
    //   714: astore_1
    //   715: aload_0
    //   716: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   719: aload_1
    //   720: invokevirtual 303	com/indooratlas/android/sdk/_internal/hv:a	(Ljava/io/IOException;)Lcom/indooratlas/android/sdk/_internal/hv;
    //   723: astore 16
    //   725: aload 16
    //   727: ifnull +1812 -> 2539
    //   730: aload_0
    //   731: aload 16
    //   733: putfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   736: goto -633 -> 103
    //   739: aload 20
    //   741: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   744: aload 20
    //   746: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   749: invokestatic 311	com/indooratlas/android/sdk/_internal/hq:a	(Lcom/indooratlas/android/sdk/_internal/gm;Lcom/indooratlas/android/sdk/_internal/gk;)Z
    //   752: ifne +21 -> 773
    //   755: new 230	com/indooratlas/android/sdk/_internal/hq
    //   758: dup
    //   759: aload 20
    //   761: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   764: aconst_null
    //   765: iconst_0
    //   766: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   769: astore_1
    //   770: goto -353 -> 417
    //   773: aload 20
    //   775: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   778: invokevirtual 241	com/indooratlas/android/sdk/_internal/gk:f	()Lcom/indooratlas/android/sdk/_internal/fq;
    //   781: astore_1
    //   782: aload_1
    //   783: getfield 313	com/indooratlas/android/sdk/_internal/fq:c	Z
    //   786: ifne +14 -> 800
    //   789: aload 20
    //   791: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   794: invokestatic 316	com/indooratlas/android/sdk/_internal/hq$a:a	(Lcom/indooratlas/android/sdk/_internal/gk;)Z
    //   797: ifeq +21 -> 818
    //   800: new 230	com/indooratlas/android/sdk/_internal/hq
    //   803: dup
    //   804: aload 20
    //   806: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   809: aconst_null
    //   810: iconst_0
    //   811: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   814: astore_1
    //   815: goto -398 -> 417
    //   818: aload 20
    //   820: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   823: ifnull +2293 -> 3116
    //   826: lconst_0
    //   827: aload 20
    //   829: getfield 322	com/indooratlas/android/sdk/_internal/hq$a:j	J
    //   832: aload 20
    //   834: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   837: invokevirtual 327	java/util/Date:getTime	()J
    //   840: lsub
    //   841: invokestatic 333	java/lang/Math:max	(JJ)J
    //   844: lstore 6
    //   846: lload 6
    //   848: lstore 8
    //   850: aload 20
    //   852: getfield 335	com/indooratlas/android/sdk/_internal/hq$a:l	I
    //   855: iconst_m1
    //   856: if_icmpeq +22 -> 878
    //   859: lload 6
    //   861: getstatic 341	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   864: aload 20
    //   866: getfield 335	com/indooratlas/android/sdk/_internal/hq$a:l	I
    //   869: i2l
    //   870: invokevirtual 345	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   873: invokestatic 333	java/lang/Math:max	(JJ)J
    //   876: lstore 8
    //   878: lload 8
    //   880: aload 20
    //   882: getfield 322	com/indooratlas/android/sdk/_internal/hq$a:j	J
    //   885: aload 20
    //   887: getfield 347	com/indooratlas/android/sdk/_internal/hq$a:i	J
    //   890: lsub
    //   891: ladd
    //   892: aload 20
    //   894: getfield 349	com/indooratlas/android/sdk/_internal/hq$a:a	J
    //   897: aload 20
    //   899: getfield 322	com/indooratlas/android/sdk/_internal/hq$a:j	J
    //   902: lsub
    //   903: ladd
    //   904: lstore 14
    //   906: aload 20
    //   908: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   911: invokevirtual 351	com/indooratlas/android/sdk/_internal/gm:h	()Lcom/indooratlas/android/sdk/_internal/fq;
    //   914: astore 17
    //   916: aload 17
    //   918: getfield 353	com/indooratlas/android/sdk/_internal/fq:e	I
    //   921: iconst_m1
    //   922: if_icmpeq +235 -> 1157
    //   925: getstatic 341	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   928: aload 17
    //   930: getfield 353	com/indooratlas/android/sdk/_internal/fq:e	I
    //   933: i2l
    //   934: invokevirtual 345	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   937: lstore 6
    //   939: aload_1
    //   940: getfield 353	com/indooratlas/android/sdk/_internal/fq:e	I
    //   943: iconst_m1
    //   944: if_icmpeq +2166 -> 3110
    //   947: lload 6
    //   949: getstatic 341	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   952: aload_1
    //   953: getfield 353	com/indooratlas/android/sdk/_internal/fq:e	I
    //   956: i2l
    //   957: invokevirtual 345	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   960: invokestatic 356	java/lang/Math:min	(JJ)J
    //   963: lstore 6
    //   965: aload_1
    //   966: getfield 358	com/indooratlas/android/sdk/_internal/fq:j	I
    //   969: iconst_m1
    //   970: if_icmpeq +2134 -> 3104
    //   973: getstatic 341	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   976: aload_1
    //   977: getfield 358	com/indooratlas/android/sdk/_internal/fq:j	I
    //   980: i2l
    //   981: invokevirtual 345	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   984: lstore 8
    //   986: lconst_0
    //   987: lstore 12
    //   989: aload 20
    //   991: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   994: invokevirtual 351	com/indooratlas/android/sdk/_internal/gm:h	()Lcom/indooratlas/android/sdk/_internal/fq;
    //   997: astore 17
    //   999: lload 12
    //   1001: lstore 10
    //   1003: aload 17
    //   1005: getfield 360	com/indooratlas/android/sdk/_internal/fq:h	Z
    //   1008: ifne +28 -> 1036
    //   1011: lload 12
    //   1013: lstore 10
    //   1015: aload_1
    //   1016: getfield 362	com/indooratlas/android/sdk/_internal/fq:i	I
    //   1019: iconst_m1
    //   1020: if_icmpeq +16 -> 1036
    //   1023: getstatic 341	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   1026: aload_1
    //   1027: getfield 362	com/indooratlas/android/sdk/_internal/fq:i	I
    //   1030: i2l
    //   1031: invokevirtual 345	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   1034: lstore 10
    //   1036: aload 17
    //   1038: getfield 313	com/indooratlas/android/sdk/_internal/fq:c	Z
    //   1041: ifne +266 -> 1307
    //   1044: lload 14
    //   1046: lload 8
    //   1048: ladd
    //   1049: lload 10
    //   1051: lload 6
    //   1053: ladd
    //   1054: lcmp
    //   1055: ifge +252 -> 1307
    //   1058: aload 20
    //   1060: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1063: invokevirtual 365	com/indooratlas/android/sdk/_internal/gm:g	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1066: astore_1
    //   1067: lload 8
    //   1069: lload 14
    //   1071: ladd
    //   1072: lload 6
    //   1074: lcmp
    //   1075: iflt +14 -> 1089
    //   1078: aload_1
    //   1079: ldc_w 367
    //   1082: ldc_w 369
    //   1085: invokevirtual 372	com/indooratlas/android/sdk/_internal/gm$a:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1088: pop
    //   1089: lload 14
    //   1091: ldc2_w 373
    //   1094: lcmp
    //   1095: ifle +45 -> 1140
    //   1098: aload 20
    //   1100: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1103: invokevirtual 351	com/indooratlas/android/sdk/_internal/gm:h	()Lcom/indooratlas/android/sdk/_internal/fq;
    //   1106: getfield 353	com/indooratlas/android/sdk/_internal/fq:e	I
    //   1109: iconst_m1
    //   1110: if_icmpne +2024 -> 3134
    //   1113: aload 20
    //   1115: getfield 376	com/indooratlas/android/sdk/_internal/hq$a:h	Ljava/util/Date;
    //   1118: ifnonnull +2016 -> 3134
    //   1121: iconst_1
    //   1122: istore 4
    //   1124: iload 4
    //   1126: ifeq +14 -> 1140
    //   1129: aload_1
    //   1130: ldc_w 367
    //   1133: ldc_w 378
    //   1136: invokevirtual 372	com/indooratlas/android/sdk/_internal/gm$a:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1139: pop
    //   1140: new 230	com/indooratlas/android/sdk/_internal/hq
    //   1143: dup
    //   1144: aconst_null
    //   1145: aload_1
    //   1146: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   1149: iconst_0
    //   1150: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   1153: astore_1
    //   1154: goto -737 -> 417
    //   1157: aload 20
    //   1159: getfield 376	com/indooratlas/android/sdk/_internal/hq$a:h	Ljava/util/Date;
    //   1162: ifnull +61 -> 1223
    //   1165: aload 20
    //   1167: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   1170: ifnull +43 -> 1213
    //   1173: aload 20
    //   1175: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   1178: invokevirtual 327	java/util/Date:getTime	()J
    //   1181: lstore 6
    //   1183: aload 20
    //   1185: getfield 376	com/indooratlas/android/sdk/_internal/hq$a:h	Ljava/util/Date;
    //   1188: invokevirtual 327	java/util/Date:getTime	()J
    //   1191: lload 6
    //   1193: lsub
    //   1194: lstore 8
    //   1196: lload 8
    //   1198: lstore 6
    //   1200: lload 8
    //   1202: lconst_0
    //   1203: lcmp
    //   1204: ifgt -265 -> 939
    //   1207: lconst_0
    //   1208: lstore 6
    //   1210: goto -271 -> 939
    //   1213: aload 20
    //   1215: getfield 322	com/indooratlas/android/sdk/_internal/hq$a:j	J
    //   1218: lstore 6
    //   1220: goto -37 -> 1183
    //   1223: aload 20
    //   1225: getfield 380	com/indooratlas/android/sdk/_internal/hq$a:f	Ljava/util/Date;
    //   1228: ifnull +1900 -> 3128
    //   1231: aload 20
    //   1233: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1236: getfield 381	com/indooratlas/android/sdk/_internal/gm:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1239: getfield 39	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   1242: invokevirtual 383	com/indooratlas/android/sdk/_internal/ge:g	()Ljava/lang/String;
    //   1245: ifnonnull +1883 -> 3128
    //   1248: aload 20
    //   1250: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   1253: ifnull +44 -> 1297
    //   1256: aload 20
    //   1258: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   1261: invokevirtual 327	java/util/Date:getTime	()J
    //   1264: lstore 6
    //   1266: lload 6
    //   1268: aload 20
    //   1270: getfield 380	com/indooratlas/android/sdk/_internal/hq$a:f	Ljava/util/Date;
    //   1273: invokevirtual 327	java/util/Date:getTime	()J
    //   1276: lsub
    //   1277: lstore 6
    //   1279: lload 6
    //   1281: lconst_0
    //   1282: lcmp
    //   1283: ifle +1839 -> 3122
    //   1286: lload 6
    //   1288: ldc2_w 384
    //   1291: ldiv
    //   1292: lstore 6
    //   1294: goto -355 -> 939
    //   1297: aload 20
    //   1299: getfield 347	com/indooratlas/android/sdk/_internal/hq$a:i	J
    //   1302: lstore 6
    //   1304: goto -38 -> 1266
    //   1307: aload 20
    //   1309: getfield 232	com/indooratlas/android/sdk/_internal/hq$a:b	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1312: invokevirtual 78	com/indooratlas/android/sdk/_internal/gk:e	()Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   1315: astore_1
    //   1316: aload 20
    //   1318: getfield 387	com/indooratlas/android/sdk/_internal/hq$a:k	Ljava/lang/String;
    //   1321: ifnull +46 -> 1367
    //   1324: aload_1
    //   1325: ldc_w 389
    //   1328: aload 20
    //   1330: getfield 387	com/indooratlas/android/sdk/_internal/hq$a:k	Ljava/lang/String;
    //   1333: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   1336: pop
    //   1337: aload_1
    //   1338: invokevirtual 112	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   1341: astore_1
    //   1342: aload_1
    //   1343: invokestatic 316	com/indooratlas/android/sdk/_internal/hq$a:a	(Lcom/indooratlas/android/sdk/_internal/gk;)Z
    //   1346: ifeq +69 -> 1415
    //   1349: new 230	com/indooratlas/android/sdk/_internal/hq
    //   1352: dup
    //   1353: aload_1
    //   1354: aload 20
    //   1356: getfield 228	com/indooratlas/android/sdk/_internal/hq$a:c	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1359: iconst_0
    //   1360: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   1363: astore_1
    //   1364: goto -947 -> 417
    //   1367: aload 20
    //   1369: getfield 380	com/indooratlas/android/sdk/_internal/hq$a:f	Ljava/util/Date;
    //   1372: ifnull +19 -> 1391
    //   1375: aload_1
    //   1376: ldc_w 391
    //   1379: aload 20
    //   1381: getfield 393	com/indooratlas/android/sdk/_internal/hq$a:g	Ljava/lang/String;
    //   1384: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   1387: pop
    //   1388: goto -51 -> 1337
    //   1391: aload 20
    //   1393: getfield 319	com/indooratlas/android/sdk/_internal/hq$a:d	Ljava/util/Date;
    //   1396: ifnull -59 -> 1337
    //   1399: aload_1
    //   1400: ldc_w 391
    //   1403: aload 20
    //   1405: getfield 395	com/indooratlas/android/sdk/_internal/hq$a:e	Ljava/lang/String;
    //   1408: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   1411: pop
    //   1412: goto -75 -> 1337
    //   1415: new 230	com/indooratlas/android/sdk/_internal/hq
    //   1418: dup
    //   1419: aload_1
    //   1420: aconst_null
    //   1421: iconst_0
    //   1422: invokespecial 235	com/indooratlas/android/sdk/_internal/hq:<init>	(Lcom/indooratlas/android/sdk/_internal/gk;Lcom/indooratlas/android/sdk/_internal/gm;B)V
    //   1425: astore_1
    //   1426: goto -1009 -> 417
    //   1429: aload 18
    //   1431: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1434: ifnonnull +70 -> 1504
    //   1437: aload 18
    //   1439: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1442: invokevirtual 365	com/indooratlas/android/sdk/_internal/gm:g	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1445: astore_1
    //   1446: aload_1
    //   1447: aload 18
    //   1449: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1452: putfield 265	com/indooratlas/android/sdk/_internal/gm$a:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1455: aload 18
    //   1457: aload_1
    //   1458: aload 18
    //   1460: getfield 267	com/indooratlas/android/sdk/_internal/hv:d	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1463: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1466: invokevirtual 273	com/indooratlas/android/sdk/_internal/gm$a:c	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1469: aload 18
    //   1471: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1474: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1477: invokevirtual 397	com/indooratlas/android/sdk/_internal/gm$a:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1480: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   1483: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1486: aload 18
    //   1488: aload 18
    //   1490: aload 18
    //   1492: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1495: invokevirtual 399	com/indooratlas/android/sdk/_internal/hv:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1498: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1501: goto -908 -> 593
    //   1504: aload 18
    //   1506: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1509: getfield 401	com/indooratlas/android/sdk/_internal/gk:b	Ljava/lang/String;
    //   1512: ldc_w 403
    //   1515: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1518: ifne +151 -> 1669
    //   1521: iconst_1
    //   1522: istore 5
    //   1524: aload 18
    //   1526: aload 18
    //   1528: getfield 122	com/indooratlas/android/sdk/_internal/hv:c	Lcom/indooratlas/android/sdk/_internal/ig;
    //   1531: aload 18
    //   1533: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   1536: getfield 412	com/indooratlas/android/sdk/_internal/gh:v	I
    //   1539: aload 18
    //   1541: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   1544: getfield 415	com/indooratlas/android/sdk/_internal/gh:w	I
    //   1547: aload 18
    //   1549: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   1552: getfield 418	com/indooratlas/android/sdk/_internal/gh:x	I
    //   1555: aload 18
    //   1557: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   1560: getfield 421	com/indooratlas/android/sdk/_internal/gh:u	Z
    //   1563: iload 5
    //   1565: invokevirtual 424	com/indooratlas/android/sdk/_internal/ig:a	(IIIZZ)Lcom/indooratlas/android/sdk/_internal/hx;
    //   1568: putfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1571: aload 18
    //   1573: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1576: aload 18
    //   1578: invokeinterface 429 2 0
    //   1583: aload 18
    //   1585: getfield 432	com/indooratlas/android/sdk/_internal/hv:o	Z
    //   1588: ifeq +87 -> 1675
    //   1591: aload 18
    //   1593: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1596: invokestatic 433	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gk;)Z
    //   1599: ifeq +76 -> 1675
    //   1602: aload 18
    //   1604: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   1607: ifnonnull +68 -> 1675
    //   1610: iconst_1
    //   1611: istore 4
    //   1613: iload 4
    //   1615: ifeq -1022 -> 593
    //   1618: aload 19
    //   1620: invokestatic 442	com/indooratlas/android/sdk/_internal/hy:a	(Lcom/indooratlas/android/sdk/_internal/gk;)J
    //   1623: lstore 6
    //   1625: aload 18
    //   1627: getfield 443	com/indooratlas/android/sdk/_internal/hv:h	Z
    //   1630: ifeq +108 -> 1738
    //   1633: lload 6
    //   1635: ldc2_w 444
    //   1638: lcmp
    //   1639: ifle +42 -> 1681
    //   1642: new 143	java/lang/IllegalStateException
    //   1645: dup
    //   1646: ldc_w 447
    //   1649: invokespecial 297	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   1652: athrow
    //   1653: astore_1
    //   1654: aload 16
    //   1656: ifnull +11 -> 1667
    //   1659: aload 16
    //   1661: getfield 258	com/indooratlas/android/sdk/_internal/gm:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   1664: invokestatic 261	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
    //   1667: aload_1
    //   1668: athrow
    //   1669: iconst_0
    //   1670: istore 5
    //   1672: goto -148 -> 1524
    //   1675: iconst_0
    //   1676: istore 4
    //   1678: goto -65 -> 1613
    //   1681: lload 6
    //   1683: ldc2_w 97
    //   1686: lcmp
    //   1687: ifeq +36 -> 1723
    //   1690: aload 18
    //   1692: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1695: aload 18
    //   1697: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1700: invokeinterface 450 2 0
    //   1705: aload 18
    //   1707: new 452	com/indooratlas/android/sdk/_internal/ic
    //   1710: dup
    //   1711: lload 6
    //   1713: l2i
    //   1714: invokespecial 455	com/indooratlas/android/sdk/_internal/ic:<init>	(I)V
    //   1717: putfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   1720: goto -1127 -> 593
    //   1723: aload 18
    //   1725: new 452	com/indooratlas/android/sdk/_internal/ic
    //   1728: dup
    //   1729: invokespecial 456	com/indooratlas/android/sdk/_internal/ic:<init>	()V
    //   1732: putfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   1735: goto -1142 -> 593
    //   1738: aload 18
    //   1740: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1743: aload 18
    //   1745: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1748: invokeinterface 450 2 0
    //   1753: aload 18
    //   1755: aload 18
    //   1757: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1760: aload 18
    //   1762: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1765: lload 6
    //   1767: invokeinterface 459 4 0
    //   1772: putfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   1775: goto -1182 -> 593
    //   1778: aload 17
    //   1780: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1783: ifnull +189 -> 1972
    //   1786: aload 17
    //   1788: getfield 462	com/indooratlas/android/sdk/_internal/hv:p	Z
    //   1791: ifeq +201 -> 1992
    //   1794: aload 17
    //   1796: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   1799: aload 17
    //   1801: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1804: invokeinterface 450 2 0
    //   1809: aload 17
    //   1811: invokevirtual 464	com/indooratlas/android/sdk/_internal/hv:c	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   1814: astore_1
    //   1815: aload 17
    //   1817: aload_1
    //   1818: getfield 467	com/indooratlas/android/sdk/_internal/gm:f	Lcom/indooratlas/android/sdk/_internal/gd;
    //   1821: invokevirtual 470	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gd;)V
    //   1824: aload 17
    //   1826: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1829: ifnull +412 -> 2241
    //   1832: aload 17
    //   1834: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1837: aload_1
    //   1838: invokestatic 473	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;Lcom/indooratlas/android/sdk/_internal/gm;)Z
    //   1841: ifeq +389 -> 2230
    //   1844: aload 17
    //   1846: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1849: invokevirtual 365	com/indooratlas/android/sdk/_internal/gm:g	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1852: astore 16
    //   1854: aload 16
    //   1856: aload 17
    //   1858: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1861: putfield 265	com/indooratlas/android/sdk/_internal/gm$a:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   1864: aload 17
    //   1866: aload 16
    //   1868: aload 17
    //   1870: getfield 267	com/indooratlas/android/sdk/_internal/hv:d	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1873: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1876: invokevirtual 273	com/indooratlas/android/sdk/_internal/gm$a:c	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1879: aload 17
    //   1881: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1884: getfield 467	com/indooratlas/android/sdk/_internal/gm:f	Lcom/indooratlas/android/sdk/_internal/gd;
    //   1887: aload_1
    //   1888: getfield 467	com/indooratlas/android/sdk/_internal/gm:f	Lcom/indooratlas/android/sdk/_internal/gd;
    //   1891: invokestatic 476	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gd;Lcom/indooratlas/android/sdk/_internal/gd;)Lcom/indooratlas/android/sdk/_internal/gd;
    //   1894: invokevirtual 479	com/indooratlas/android/sdk/_internal/gm$a:a	(Lcom/indooratlas/android/sdk/_internal/gd;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1897: aload 17
    //   1899: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1902: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1905: invokevirtual 397	com/indooratlas/android/sdk/_internal/gm$a:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1908: aload_1
    //   1909: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1912: invokevirtual 481	com/indooratlas/android/sdk/_internal/gm$a:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   1915: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   1918: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1921: aload_1
    //   1922: getfield 258	com/indooratlas/android/sdk/_internal/gm:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   1925: invokevirtual 486	com/indooratlas/android/sdk/_internal/gn:close	()V
    //   1928: aload 17
    //   1930: getfield 122	com/indooratlas/android/sdk/_internal/hv:c	Lcom/indooratlas/android/sdk/_internal/ig;
    //   1933: invokevirtual 488	com/indooratlas/android/sdk/_internal/ig:b	()V
    //   1936: getstatic 207	com/indooratlas/android/sdk/_internal/gs:b	Lcom/indooratlas/android/sdk/_internal/gs;
    //   1939: aload 17
    //   1941: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   1944: invokevirtual 210	com/indooratlas/android/sdk/_internal/gs:a	(Lcom/indooratlas/android/sdk/_internal/gh;)Lcom/indooratlas/android/sdk/_internal/gt;
    //   1947: pop
    //   1948: aload 17
    //   1950: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1953: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1956: pop
    //   1957: aload 17
    //   1959: aload 17
    //   1961: aload 17
    //   1963: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1966: invokevirtual 399	com/indooratlas/android/sdk/_internal/hv:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   1969: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1972: aload_0
    //   1973: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   1976: astore_1
    //   1977: aload_1
    //   1978: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   1981: ifnonnull +560 -> 2541
    //   1984: new 143	java/lang/IllegalStateException
    //   1987: dup
    //   1988: invokespecial 144	java/lang/IllegalStateException:<init>	()V
    //   1991: athrow
    //   1992: aload 17
    //   1994: getfield 432	com/indooratlas/android/sdk/_internal/hv:o	Z
    //   1997: ifne +30 -> 2027
    //   2000: new 490	com/indooratlas/android/sdk/_internal/hv$a
    //   2003: dup
    //   2004: aload 17
    //   2006: iconst_0
    //   2007: aload 17
    //   2009: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2012: invokespecial 493	com/indooratlas/android/sdk/_internal/hv$a:<init>	(Lcom/indooratlas/android/sdk/_internal/hv;ILcom/indooratlas/android/sdk/_internal/gk;)V
    //   2015: aload 17
    //   2017: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2020: invokevirtual 496	com/indooratlas/android/sdk/_internal/hv$a:a	(Lcom/indooratlas/android/sdk/_internal/gk;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2023: astore_1
    //   2024: goto -209 -> 1815
    //   2027: aload 17
    //   2029: getfield 500	com/indooratlas/android/sdk/_internal/hv:n	Lcom/indooratlas/android/sdk/_internal/io;
    //   2032: ifnull +32 -> 2064
    //   2035: aload 17
    //   2037: getfield 500	com/indooratlas/android/sdk/_internal/hv:n	Lcom/indooratlas/android/sdk/_internal/io;
    //   2040: invokeinterface 505 1 0
    //   2045: getfield 509	com/indooratlas/android/sdk/_internal/in:b	J
    //   2048: lconst_0
    //   2049: lcmp
    //   2050: ifle +14 -> 2064
    //   2053: aload 17
    //   2055: getfield 500	com/indooratlas/android/sdk/_internal/hv:n	Lcom/indooratlas/android/sdk/_internal/io;
    //   2058: invokeinterface 512 1 0
    //   2063: pop
    //   2064: aload 17
    //   2066: getfield 514	com/indooratlas/android/sdk/_internal/hv:f	J
    //   2069: ldc2_w 97
    //   2072: lcmp
    //   2073: ifne +86 -> 2159
    //   2076: aload 17
    //   2078: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2081: invokestatic 442	com/indooratlas/android/sdk/_internal/hy:a	(Lcom/indooratlas/android/sdk/_internal/gk;)J
    //   2084: ldc2_w 97
    //   2087: lcmp
    //   2088: ifne +56 -> 2144
    //   2091: aload 17
    //   2093: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2096: instanceof 452
    //   2099: ifeq +45 -> 2144
    //   2102: aload 17
    //   2104: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2107: checkcast 452	com/indooratlas/android/sdk/_internal/ic
    //   2110: getfield 517	com/indooratlas/android/sdk/_internal/ic:a	Lcom/indooratlas/android/sdk/_internal/in;
    //   2113: getfield 509	com/indooratlas/android/sdk/_internal/in:b	J
    //   2116: lstore 6
    //   2118: aload 17
    //   2120: aload 17
    //   2122: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2125: invokevirtual 78	com/indooratlas/android/sdk/_internal/gk:e	()Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2128: ldc 100
    //   2130: lload 6
    //   2132: invokestatic 105	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2135: invokevirtual 93	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2138: invokevirtual 112	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   2141: putfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2144: aload 17
    //   2146: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   2149: aload 17
    //   2151: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2154: invokeinterface 450 2 0
    //   2159: aload 17
    //   2161: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2164: ifnull -355 -> 1809
    //   2167: aload 17
    //   2169: getfield 500	com/indooratlas/android/sdk/_internal/hv:n	Lcom/indooratlas/android/sdk/_internal/io;
    //   2172: ifnull +45 -> 2217
    //   2175: aload 17
    //   2177: getfield 500	com/indooratlas/android/sdk/_internal/hv:n	Lcom/indooratlas/android/sdk/_internal/io;
    //   2180: invokeinterface 518 1 0
    //   2185: aload 17
    //   2187: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2190: instanceof 452
    //   2193: ifeq -384 -> 1809
    //   2196: aload 17
    //   2198: getfield 141	com/indooratlas/android/sdk/_internal/hv:e	Lcom/indooratlas/android/sdk/_internal/hx;
    //   2201: aload 17
    //   2203: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2206: checkcast 452	com/indooratlas/android/sdk/_internal/ic
    //   2209: invokeinterface 521 2 0
    //   2214: goto -405 -> 1809
    //   2217: aload 17
    //   2219: getfield 437	com/indooratlas/android/sdk/_internal/hv:m	Lcom/indooratlas/android/sdk/_internal/jc;
    //   2222: invokeinterface 524 1 0
    //   2227: goto -42 -> 2185
    //   2230: aload 17
    //   2232: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2235: getfield 258	com/indooratlas/android/sdk/_internal/gm:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   2238: invokestatic 261	com/indooratlas/android/sdk/_internal/gy:a	(Ljava/io/Closeable;)V
    //   2241: aload_1
    //   2242: invokevirtual 365	com/indooratlas/android/sdk/_internal/gm:g	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   2245: astore 16
    //   2247: aload 16
    //   2249: aload 17
    //   2251: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2254: putfield 265	com/indooratlas/android/sdk/_internal/gm$a:a	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2257: aload 17
    //   2259: aload 16
    //   2261: aload 17
    //   2263: getfield 267	com/indooratlas/android/sdk/_internal/hv:d	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2266: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2269: invokevirtual 273	com/indooratlas/android/sdk/_internal/gm$a:c	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   2272: aload 17
    //   2274: getfield 253	com/indooratlas/android/sdk/_internal/hv:k	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2277: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2280: invokevirtual 397	com/indooratlas/android/sdk/_internal/gm$a:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   2283: aload_1
    //   2284: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2287: invokevirtual 481	com/indooratlas/android/sdk/_internal/gm$a:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   2290: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   2293: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2296: aload 17
    //   2298: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2301: invokestatic 527	com/indooratlas/android/sdk/_internal/hv:c	(Lcom/indooratlas/android/sdk/_internal/gm;)Z
    //   2304: ifeq -332 -> 1972
    //   2307: getstatic 207	com/indooratlas/android/sdk/_internal/gs:b	Lcom/indooratlas/android/sdk/_internal/gs;
    //   2310: aload 17
    //   2312: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   2315: invokevirtual 210	com/indooratlas/android/sdk/_internal/gs:a	(Lcom/indooratlas/android/sdk/_internal/gh;)Lcom/indooratlas/android/sdk/_internal/gt;
    //   2318: astore_1
    //   2319: aload_1
    //   2320: ifnull +76 -> 2396
    //   2323: aload 17
    //   2325: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2328: aload 17
    //   2330: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2333: invokestatic 311	com/indooratlas/android/sdk/_internal/hq:a	(Lcom/indooratlas/android/sdk/_internal/gm;Lcom/indooratlas/android/sdk/_internal/gk;)Z
    //   2336: ifne +96 -> 2432
    //   2339: aload 17
    //   2341: getfield 249	com/indooratlas/android/sdk/_internal/hv:j	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2344: getfield 401	com/indooratlas/android/sdk/_internal/gk:b	Ljava/lang/String;
    //   2347: astore_1
    //   2348: aload_1
    //   2349: ldc_w 529
    //   2352: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2355: ifne +41 -> 2396
    //   2358: aload_1
    //   2359: ldc_w 531
    //   2362: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2365: ifne +31 -> 2396
    //   2368: aload_1
    //   2369: ldc_w 533
    //   2372: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2375: ifne +21 -> 2396
    //   2378: aload_1
    //   2379: ldc_w 535
    //   2382: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2385: ifne +11 -> 2396
    //   2388: aload_1
    //   2389: ldc_w 537
    //   2392: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2395: pop
    //   2396: aload 17
    //   2398: getfield 541	com/indooratlas/android/sdk/_internal/hv:q	Lcom/indooratlas/android/sdk/_internal/hp;
    //   2401: astore 18
    //   2403: aload 17
    //   2405: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2408: astore 16
    //   2410: aload 18
    //   2412: ifnonnull +43 -> 2455
    //   2415: aload 16
    //   2417: astore_1
    //   2418: aload 17
    //   2420: aload 17
    //   2422: aload_1
    //   2423: invokevirtual 399	com/indooratlas/android/sdk/_internal/hv:b	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2426: putfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2429: goto -457 -> 1972
    //   2432: aload 17
    //   2434: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2437: invokestatic 270	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/gm;
    //   2440: pop
    //   2441: aload 17
    //   2443: aload_1
    //   2444: invokeinterface 544 1 0
    //   2449: putfield 541	com/indooratlas/android/sdk/_internal/hv:q	Lcom/indooratlas/android/sdk/_internal/hp;
    //   2452: goto -56 -> 2396
    //   2455: aload 18
    //   2457: invokeinterface 549 1 0
    //   2462: astore 19
    //   2464: aload 16
    //   2466: astore_1
    //   2467: aload 19
    //   2469: ifnull -51 -> 2418
    //   2472: new 551	com/indooratlas/android/sdk/_internal/hv$2
    //   2475: dup
    //   2476: aload 17
    //   2478: aload 16
    //   2480: getfield 258	com/indooratlas/android/sdk/_internal/gm:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   2483: invokevirtual 554	com/indooratlas/android/sdk/_internal/gn:c	()Lcom/indooratlas/android/sdk/_internal/ip;
    //   2486: aload 18
    //   2488: aload 19
    //   2490: invokestatic 559	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jc;)Lcom/indooratlas/android/sdk/_internal/io;
    //   2493: invokespecial 562	com/indooratlas/android/sdk/_internal/hv$2:<init>	(Lcom/indooratlas/android/sdk/_internal/hv;Lcom/indooratlas/android/sdk/_internal/ip;Lcom/indooratlas/android/sdk/_internal/hp;Lcom/indooratlas/android/sdk/_internal/io;)V
    //   2496: astore_1
    //   2497: aload 16
    //   2499: invokevirtual 365	com/indooratlas/android/sdk/_internal/gm:g	()Lcom/indooratlas/android/sdk/_internal/gm$a;
    //   2502: astore 18
    //   2504: aload 18
    //   2506: new 564	com/indooratlas/android/sdk/_internal/hz
    //   2509: dup
    //   2510: aload 16
    //   2512: getfield 467	com/indooratlas/android/sdk/_internal/gm:f	Lcom/indooratlas/android/sdk/_internal/gd;
    //   2515: aload_1
    //   2516: invokestatic 567	com/indooratlas/android/sdk/_internal/ix:a	(Lcom/indooratlas/android/sdk/_internal/jd;)Lcom/indooratlas/android/sdk/_internal/ip;
    //   2519: invokespecial 570	com/indooratlas/android/sdk/_internal/hz:<init>	(Lcom/indooratlas/android/sdk/_internal/gd;Lcom/indooratlas/android/sdk/_internal/ip;)V
    //   2522: putfield 290	com/indooratlas/android/sdk/_internal/gm$a:g	Lcom/indooratlas/android/sdk/_internal/gn;
    //   2525: aload 18
    //   2527: invokevirtual 291	com/indooratlas/android/sdk/_internal/gm$a:a	()Lcom/indooratlas/android/sdk/_internal/gm;
    //   2530: astore_1
    //   2531: goto -113 -> 2418
    //   2534: aload_1
    //   2535: getfield 300	com/indooratlas/android/sdk/_internal/id:b	Ljava/io/IOException;
    //   2538: athrow
    //   2539: aload_1
    //   2540: athrow
    //   2541: aload_1
    //   2542: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2545: astore 17
    //   2547: aload_0
    //   2548: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   2551: astore 16
    //   2553: aload 16
    //   2555: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2558: ifnonnull +11 -> 2569
    //   2561: new 143	java/lang/IllegalStateException
    //   2564: dup
    //   2565: invokespecial 144	java/lang/IllegalStateException:<init>	()V
    //   2568: athrow
    //   2569: aload 16
    //   2571: getfield 122	com/indooratlas/android/sdk/_internal/hv:c	Lcom/indooratlas/android/sdk/_internal/ig;
    //   2574: invokevirtual 573	com/indooratlas/android/sdk/_internal/ig:a	()Lcom/indooratlas/android/sdk/_internal/ii;
    //   2577: astore_1
    //   2578: aload_1
    //   2579: ifnull +128 -> 2707
    //   2582: aload_1
    //   2583: invokeinterface 578 1 0
    //   2588: astore_1
    //   2589: aload 16
    //   2591: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2594: getfield 579	com/indooratlas/android/sdk/_internal/gm:c	I
    //   2597: istore 4
    //   2599: aload 16
    //   2601: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2604: getfield 401	com/indooratlas/android/sdk/_internal/gk:b	Ljava/lang/String;
    //   2607: astore 18
    //   2609: iload 4
    //   2611: lookupswitch	default:+73->2684, 300:+191->2802, 301:+191->2802, 302:+191->2802, 303:+191->2802, 307:+169->2780, 308:+169->2780, 401:+143->2754, 407:+101->2712
    //   2684: aconst_null
    //   2685: astore_1
    //   2686: aload_1
    //   2687: ifnonnull +311 -> 2998
    //   2690: iload_2
    //   2691: ifne +13 -> 2704
    //   2694: aload_0
    //   2695: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   2698: getfield 122	com/indooratlas/android/sdk/_internal/hv:c	Lcom/indooratlas/android/sdk/_internal/ig;
    //   2701: invokevirtual 488	com/indooratlas/android/sdk/_internal/ig:b	()V
    //   2704: aload 17
    //   2706: areturn
    //   2707: aconst_null
    //   2708: astore_1
    //   2709: goto -120 -> 2589
    //   2712: aload_1
    //   2713: ifnull +29 -> 2742
    //   2716: aload_1
    //   2717: getfield 584	com/indooratlas/android/sdk/_internal/go:b	Ljava/net/Proxy;
    //   2720: astore_1
    //   2721: aload_1
    //   2722: invokevirtual 590	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   2725: getstatic 596	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   2728: if_acmpeq +26 -> 2754
    //   2731: new 598	java/net/ProtocolException
    //   2734: dup
    //   2735: ldc_w 600
    //   2738: invokespecial 601	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   2741: athrow
    //   2742: aload 16
    //   2744: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   2747: getfield 602	com/indooratlas/android/sdk/_internal/gh:b	Ljava/net/Proxy;
    //   2750: astore_1
    //   2751: goto -30 -> 2721
    //   2754: aload 16
    //   2756: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   2759: getfield 605	com/indooratlas/android/sdk/_internal/gh:p	Lcom/indooratlas/android/sdk/_internal/fo;
    //   2762: astore_1
    //   2763: aload 16
    //   2765: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2768: astore 16
    //   2770: aload_1
    //   2771: invokeinterface 608 1 0
    //   2776: astore_1
    //   2777: goto -91 -> 2686
    //   2780: aload 18
    //   2782: ldc_w 403
    //   2785: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2788: ifne +14 -> 2802
    //   2791: aload 18
    //   2793: ldc_w 610
    //   2796: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2799: ifeq -115 -> 2684
    //   2802: aload 16
    //   2804: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   2807: getfield 613	com/indooratlas/android/sdk/_internal/gh:t	Z
    //   2810: ifeq -126 -> 2684
    //   2813: aload 16
    //   2815: getfield 294	com/indooratlas/android/sdk/_internal/hv:l	Lcom/indooratlas/android/sdk/_internal/gm;
    //   2818: ldc_w 615
    //   2821: invokevirtual 616	com/indooratlas/android/sdk/_internal/gm:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2824: astore_1
    //   2825: aload_1
    //   2826: ifnull -142 -> 2684
    //   2829: aload 16
    //   2831: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2834: getfield 39	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   2837: aload_1
    //   2838: invokevirtual 46	com/indooratlas/android/sdk/_internal/ge:c	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/ge;
    //   2841: astore_1
    //   2842: aload_1
    //   2843: ifnull -159 -> 2684
    //   2846: aload_1
    //   2847: getfield 618	com/indooratlas/android/sdk/_internal/ge:a	Ljava/lang/String;
    //   2850: aload 16
    //   2852: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2855: getfield 39	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   2858: getfield 618	com/indooratlas/android/sdk/_internal/ge:a	Ljava/lang/String;
    //   2861: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2864: ifne +14 -> 2878
    //   2867: aload 16
    //   2869: getfield 176	com/indooratlas/android/sdk/_internal/hv:b	Lcom/indooratlas/android/sdk/_internal/gh;
    //   2872: getfield 621	com/indooratlas/android/sdk/_internal/gh:s	Z
    //   2875: ifeq -191 -> 2684
    //   2878: aload 16
    //   2880: getfield 153	com/indooratlas/android/sdk/_internal/hv:i	Lcom/indooratlas/android/sdk/_internal/gk;
    //   2883: invokevirtual 78	com/indooratlas/android/sdk/_internal/gk:e	()Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2886: astore 19
    //   2888: aload 18
    //   2890: invokestatic 626	com/indooratlas/android/sdk/_internal/hw:b	(Ljava/lang/String;)Z
    //   2893: ifeq +56 -> 2949
    //   2896: aload 18
    //   2898: ldc_w 628
    //   2901: invokevirtual 409	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2904: ifne +76 -> 2980
    //   2907: iconst_1
    //   2908: istore 4
    //   2910: iload 4
    //   2912: ifeq +74 -> 2986
    //   2915: aload 19
    //   2917: ldc_w 403
    //   2920: aconst_null
    //   2921: invokevirtual 631	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Lcom/indooratlas/android/sdk/_internal/gl;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2924: pop
    //   2925: aload 19
    //   2927: ldc 107
    //   2929: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2932: pop
    //   2933: aload 19
    //   2935: ldc 100
    //   2937: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2940: pop
    //   2941: aload 19
    //   2943: ldc 85
    //   2945: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2948: pop
    //   2949: aload 16
    //   2951: aload_1
    //   2952: invokevirtual 634	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Z
    //   2955: ifne +12 -> 2967
    //   2958: aload 19
    //   2960: ldc_w 636
    //   2963: invokevirtual 110	com/indooratlas/android/sdk/_internal/gk$a:b	(Ljava/lang/String;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2966: pop
    //   2967: aload 19
    //   2969: aload_1
    //   2970: invokevirtual 639	com/indooratlas/android/sdk/_internal/gk$a:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2973: invokevirtual 112	com/indooratlas/android/sdk/_internal/gk$a:a	()Lcom/indooratlas/android/sdk/_internal/gk;
    //   2976: astore_1
    //   2977: goto -291 -> 2686
    //   2980: iconst_0
    //   2981: istore 4
    //   2983: goto -73 -> 2910
    //   2986: aload 19
    //   2988: aload 18
    //   2990: aconst_null
    //   2991: invokevirtual 631	com/indooratlas/android/sdk/_internal/gk$a:a	(Ljava/lang/String;Lcom/indooratlas/android/sdk/_internal/gl;)Lcom/indooratlas/android/sdk/_internal/gk$a;
    //   2994: pop
    //   2995: goto -70 -> 2925
    //   2998: aload_0
    //   2999: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   3002: invokevirtual 150	com/indooratlas/android/sdk/_internal/hv:b	()Lcom/indooratlas/android/sdk/_internal/ig;
    //   3005: astore 16
    //   3007: iload_3
    //   3008: iconst_1
    //   3009: iadd
    //   3010: istore_3
    //   3011: iload_3
    //   3012: bipush 20
    //   3014: if_icmple +36 -> 3050
    //   3017: aload 16
    //   3019: iconst_0
    //   3020: iconst_1
    //   3021: iconst_0
    //   3022: invokevirtual 127	com/indooratlas/android/sdk/_internal/ig:a	(ZZZ)V
    //   3025: new 598	java/net/ProtocolException
    //   3028: dup
    //   3029: new 48	java/lang/StringBuilder
    //   3032: dup
    //   3033: ldc_w 641
    //   3036: invokespecial 642	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3039: iload_3
    //   3040: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3043: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3046: invokespecial 601	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   3049: athrow
    //   3050: aload_0
    //   3051: getfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   3054: aload_1
    //   3055: getfield 39	com/indooratlas/android/sdk/_internal/gk:a	Lcom/indooratlas/android/sdk/_internal/ge;
    //   3058: invokevirtual 634	com/indooratlas/android/sdk/_internal/hv:a	(Lcom/indooratlas/android/sdk/_internal/ge;)Z
    //   3061: ifne +40 -> 3101
    //   3064: aload 16
    //   3066: iconst_0
    //   3067: iconst_1
    //   3068: iconst_0
    //   3069: invokevirtual 127	com/indooratlas/android/sdk/_internal/ig:a	(ZZZ)V
    //   3072: aconst_null
    //   3073: astore 16
    //   3075: aload_0
    //   3076: new 114	com/indooratlas/android/sdk/_internal/hv
    //   3079: dup
    //   3080: aload_0
    //   3081: getfield 26	com/indooratlas/android/sdk/_internal/gj:a	Lcom/indooratlas/android/sdk/_internal/gh;
    //   3084: aload_1
    //   3085: iconst_0
    //   3086: iconst_0
    //   3087: iload_2
    //   3088: aload 16
    //   3090: aload 17
    //   3092: invokespecial 117	com/indooratlas/android/sdk/_internal/hv:<init>	(Lcom/indooratlas/android/sdk/_internal/gh;Lcom/indooratlas/android/sdk/_internal/gk;ZZZLcom/indooratlas/android/sdk/_internal/ig;Lcom/indooratlas/android/sdk/_internal/gm;)V
    //   3095: putfield 119	com/indooratlas/android/sdk/_internal/gj:d	Lcom/indooratlas/android/sdk/_internal/hv;
    //   3098: goto -2995 -> 103
    //   3101: goto -26 -> 3075
    //   3104: lconst_0
    //   3105: lstore 8
    //   3107: goto -2121 -> 986
    //   3110: goto -2145 -> 965
    //   3113: goto -3033 -> 80
    //   3116: lconst_0
    //   3117: lstore 6
    //   3119: goto -2273 -> 846
    //   3122: lconst_0
    //   3123: lstore 6
    //   3125: goto -2186 -> 939
    //   3128: lconst_0
    //   3129: lstore 6
    //   3131: goto -2192 -> 939
    //   3134: iconst_0
    //   3135: istore 4
    //   3137: goto -2013 -> 1124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3140	0	this	gj
    //   0	3140	1	paramgk	gk
    //   0	3140	2	paramBoolean	boolean
    //   102	2938	3	i	int
    //   1122	2014	4	j	int
    //   1522	149	5	bool	boolean
    //   45	3085	6	l1	long
    //   848	2258	8	l2	long
    //   1001	49	10	l3	long
    //   987	25	12	l4	long
    //   904	186	14	l5	long
    //   4	3085	16	localObject1	Object
    //   21	3070	17	localObject2	Object
    //   156	2833	18	localObject3	Object
    //   352	2635	19	localObject4	Object
    //   392	1012	20	locala	hq.a
    // Exception table:
    //   from	to	target	type
    //   152	182	182	com/indooratlas/android/sdk/_internal/ia
    //   210	246	182	com/indooratlas/android/sdk/_internal/ia
    //   246	265	182	com/indooratlas/android/sdk/_internal/ia
    //   265	290	182	com/indooratlas/android/sdk/_internal/ia
    //   290	328	182	com/indooratlas/android/sdk/_internal/ia
    //   328	347	182	com/indooratlas/android/sdk/_internal/ia
    //   347	366	182	com/indooratlas/android/sdk/_internal/ia
    //   370	378	182	com/indooratlas/android/sdk/_internal/ia
    //   378	417	182	com/indooratlas/android/sdk/_internal/ia
    //   420	427	182	com/indooratlas/android/sdk/_internal/ia
    //   430	456	182	com/indooratlas/android/sdk/_internal/ia
    //   456	489	182	com/indooratlas/android/sdk/_internal/ia
    //   494	510	182	com/indooratlas/android/sdk/_internal/ia
    //   510	593	182	com/indooratlas/android/sdk/_internal/ia
    //   593	634	182	com/indooratlas/android/sdk/_internal/ia
    //   674	711	182	com/indooratlas/android/sdk/_internal/ia
    //   739	770	182	com/indooratlas/android/sdk/_internal/ia
    //   773	800	182	com/indooratlas/android/sdk/_internal/ia
    //   800	815	182	com/indooratlas/android/sdk/_internal/ia
    //   818	846	182	com/indooratlas/android/sdk/_internal/ia
    //   850	878	182	com/indooratlas/android/sdk/_internal/ia
    //   878	939	182	com/indooratlas/android/sdk/_internal/ia
    //   939	965	182	com/indooratlas/android/sdk/_internal/ia
    //   965	986	182	com/indooratlas/android/sdk/_internal/ia
    //   989	999	182	com/indooratlas/android/sdk/_internal/ia
    //   1003	1011	182	com/indooratlas/android/sdk/_internal/ia
    //   1015	1036	182	com/indooratlas/android/sdk/_internal/ia
    //   1036	1044	182	com/indooratlas/android/sdk/_internal/ia
    //   1058	1067	182	com/indooratlas/android/sdk/_internal/ia
    //   1078	1089	182	com/indooratlas/android/sdk/_internal/ia
    //   1098	1121	182	com/indooratlas/android/sdk/_internal/ia
    //   1129	1140	182	com/indooratlas/android/sdk/_internal/ia
    //   1140	1154	182	com/indooratlas/android/sdk/_internal/ia
    //   1157	1183	182	com/indooratlas/android/sdk/_internal/ia
    //   1183	1196	182	com/indooratlas/android/sdk/_internal/ia
    //   1213	1220	182	com/indooratlas/android/sdk/_internal/ia
    //   1223	1266	182	com/indooratlas/android/sdk/_internal/ia
    //   1266	1279	182	com/indooratlas/android/sdk/_internal/ia
    //   1286	1294	182	com/indooratlas/android/sdk/_internal/ia
    //   1297	1304	182	com/indooratlas/android/sdk/_internal/ia
    //   1307	1337	182	com/indooratlas/android/sdk/_internal/ia
    //   1337	1364	182	com/indooratlas/android/sdk/_internal/ia
    //   1367	1388	182	com/indooratlas/android/sdk/_internal/ia
    //   1391	1412	182	com/indooratlas/android/sdk/_internal/ia
    //   1415	1426	182	com/indooratlas/android/sdk/_internal/ia
    //   1429	1501	182	com/indooratlas/android/sdk/_internal/ia
    //   1659	1667	182	com/indooratlas/android/sdk/_internal/ia
    //   1667	1669	182	com/indooratlas/android/sdk/_internal/ia
    //   1778	1809	182	com/indooratlas/android/sdk/_internal/ia
    //   1809	1815	182	com/indooratlas/android/sdk/_internal/ia
    //   1815	1972	182	com/indooratlas/android/sdk/_internal/ia
    //   1992	2024	182	com/indooratlas/android/sdk/_internal/ia
    //   2027	2064	182	com/indooratlas/android/sdk/_internal/ia
    //   2064	2144	182	com/indooratlas/android/sdk/_internal/ia
    //   2144	2159	182	com/indooratlas/android/sdk/_internal/ia
    //   2159	2185	182	com/indooratlas/android/sdk/_internal/ia
    //   2185	2214	182	com/indooratlas/android/sdk/_internal/ia
    //   2217	2227	182	com/indooratlas/android/sdk/_internal/ia
    //   2230	2241	182	com/indooratlas/android/sdk/_internal/ia
    //   2241	2319	182	com/indooratlas/android/sdk/_internal/ia
    //   2323	2396	182	com/indooratlas/android/sdk/_internal/ia
    //   2396	2410	182	com/indooratlas/android/sdk/_internal/ia
    //   2418	2429	182	com/indooratlas/android/sdk/_internal/ia
    //   2432	2452	182	com/indooratlas/android/sdk/_internal/ia
    //   2455	2464	182	com/indooratlas/android/sdk/_internal/ia
    //   2472	2531	182	com/indooratlas/android/sdk/_internal/ia
    //   152	182	188	finally
    //   183	188	188	finally
    //   210	246	188	finally
    //   246	265	188	finally
    //   265	290	188	finally
    //   290	328	188	finally
    //   328	347	188	finally
    //   347	366	188	finally
    //   370	378	188	finally
    //   378	417	188	finally
    //   420	427	188	finally
    //   430	456	188	finally
    //   456	489	188	finally
    //   494	510	188	finally
    //   510	593	188	finally
    //   593	634	188	finally
    //   635	648	188	finally
    //   674	711	188	finally
    //   715	725	188	finally
    //   739	770	188	finally
    //   773	800	188	finally
    //   800	815	188	finally
    //   818	846	188	finally
    //   850	878	188	finally
    //   878	939	188	finally
    //   939	965	188	finally
    //   965	986	188	finally
    //   989	999	188	finally
    //   1003	1011	188	finally
    //   1015	1036	188	finally
    //   1036	1044	188	finally
    //   1058	1067	188	finally
    //   1078	1089	188	finally
    //   1098	1121	188	finally
    //   1129	1140	188	finally
    //   1140	1154	188	finally
    //   1157	1183	188	finally
    //   1183	1196	188	finally
    //   1213	1220	188	finally
    //   1223	1266	188	finally
    //   1266	1279	188	finally
    //   1286	1294	188	finally
    //   1297	1304	188	finally
    //   1307	1337	188	finally
    //   1337	1364	188	finally
    //   1367	1388	188	finally
    //   1391	1412	188	finally
    //   1415	1426	188	finally
    //   1429	1501	188	finally
    //   1659	1667	188	finally
    //   1667	1669	188	finally
    //   1778	1809	188	finally
    //   1809	1815	188	finally
    //   1815	1972	188	finally
    //   1992	2024	188	finally
    //   2027	2064	188	finally
    //   2064	2144	188	finally
    //   2144	2159	188	finally
    //   2159	2185	188	finally
    //   2185	2214	188	finally
    //   2217	2227	188	finally
    //   2230	2241	188	finally
    //   2241	2319	188	finally
    //   2323	2396	188	finally
    //   2396	2410	188	finally
    //   2418	2429	188	finally
    //   2432	2452	188	finally
    //   2455	2464	188	finally
    //   2472	2531	188	finally
    //   2534	2539	188	finally
    //   2539	2541	188	finally
    //   152	182	634	com/indooratlas/android/sdk/_internal/id
    //   210	246	634	com/indooratlas/android/sdk/_internal/id
    //   246	265	634	com/indooratlas/android/sdk/_internal/id
    //   265	290	634	com/indooratlas/android/sdk/_internal/id
    //   290	328	634	com/indooratlas/android/sdk/_internal/id
    //   328	347	634	com/indooratlas/android/sdk/_internal/id
    //   347	366	634	com/indooratlas/android/sdk/_internal/id
    //   370	378	634	com/indooratlas/android/sdk/_internal/id
    //   378	417	634	com/indooratlas/android/sdk/_internal/id
    //   420	427	634	com/indooratlas/android/sdk/_internal/id
    //   430	456	634	com/indooratlas/android/sdk/_internal/id
    //   456	489	634	com/indooratlas/android/sdk/_internal/id
    //   494	510	634	com/indooratlas/android/sdk/_internal/id
    //   510	593	634	com/indooratlas/android/sdk/_internal/id
    //   593	634	634	com/indooratlas/android/sdk/_internal/id
    //   674	711	634	com/indooratlas/android/sdk/_internal/id
    //   739	770	634	com/indooratlas/android/sdk/_internal/id
    //   773	800	634	com/indooratlas/android/sdk/_internal/id
    //   800	815	634	com/indooratlas/android/sdk/_internal/id
    //   818	846	634	com/indooratlas/android/sdk/_internal/id
    //   850	878	634	com/indooratlas/android/sdk/_internal/id
    //   878	939	634	com/indooratlas/android/sdk/_internal/id
    //   939	965	634	com/indooratlas/android/sdk/_internal/id
    //   965	986	634	com/indooratlas/android/sdk/_internal/id
    //   989	999	634	com/indooratlas/android/sdk/_internal/id
    //   1003	1011	634	com/indooratlas/android/sdk/_internal/id
    //   1015	1036	634	com/indooratlas/android/sdk/_internal/id
    //   1036	1044	634	com/indooratlas/android/sdk/_internal/id
    //   1058	1067	634	com/indooratlas/android/sdk/_internal/id
    //   1078	1089	634	com/indooratlas/android/sdk/_internal/id
    //   1098	1121	634	com/indooratlas/android/sdk/_internal/id
    //   1129	1140	634	com/indooratlas/android/sdk/_internal/id
    //   1140	1154	634	com/indooratlas/android/sdk/_internal/id
    //   1157	1183	634	com/indooratlas/android/sdk/_internal/id
    //   1183	1196	634	com/indooratlas/android/sdk/_internal/id
    //   1213	1220	634	com/indooratlas/android/sdk/_internal/id
    //   1223	1266	634	com/indooratlas/android/sdk/_internal/id
    //   1266	1279	634	com/indooratlas/android/sdk/_internal/id
    //   1286	1294	634	com/indooratlas/android/sdk/_internal/id
    //   1297	1304	634	com/indooratlas/android/sdk/_internal/id
    //   1307	1337	634	com/indooratlas/android/sdk/_internal/id
    //   1337	1364	634	com/indooratlas/android/sdk/_internal/id
    //   1367	1388	634	com/indooratlas/android/sdk/_internal/id
    //   1391	1412	634	com/indooratlas/android/sdk/_internal/id
    //   1415	1426	634	com/indooratlas/android/sdk/_internal/id
    //   1429	1501	634	com/indooratlas/android/sdk/_internal/id
    //   1659	1667	634	com/indooratlas/android/sdk/_internal/id
    //   1667	1669	634	com/indooratlas/android/sdk/_internal/id
    //   1778	1809	634	com/indooratlas/android/sdk/_internal/id
    //   1809	1815	634	com/indooratlas/android/sdk/_internal/id
    //   1815	1972	634	com/indooratlas/android/sdk/_internal/id
    //   1992	2024	634	com/indooratlas/android/sdk/_internal/id
    //   2027	2064	634	com/indooratlas/android/sdk/_internal/id
    //   2064	2144	634	com/indooratlas/android/sdk/_internal/id
    //   2144	2159	634	com/indooratlas/android/sdk/_internal/id
    //   2159	2185	634	com/indooratlas/android/sdk/_internal/id
    //   2185	2214	634	com/indooratlas/android/sdk/_internal/id
    //   2217	2227	634	com/indooratlas/android/sdk/_internal/id
    //   2230	2241	634	com/indooratlas/android/sdk/_internal/id
    //   2241	2319	634	com/indooratlas/android/sdk/_internal/id
    //   2323	2396	634	com/indooratlas/android/sdk/_internal/id
    //   2396	2410	634	com/indooratlas/android/sdk/_internal/id
    //   2418	2429	634	com/indooratlas/android/sdk/_internal/id
    //   2432	2452	634	com/indooratlas/android/sdk/_internal/id
    //   2455	2464	634	com/indooratlas/android/sdk/_internal/id
    //   2472	2531	634	com/indooratlas/android/sdk/_internal/id
    //   653	659	662	finally
    //   730	736	662	finally
    //   152	182	714	java/io/IOException
    //   210	246	714	java/io/IOException
    //   246	265	714	java/io/IOException
    //   265	290	714	java/io/IOException
    //   290	328	714	java/io/IOException
    //   328	347	714	java/io/IOException
    //   347	366	714	java/io/IOException
    //   370	378	714	java/io/IOException
    //   378	417	714	java/io/IOException
    //   420	427	714	java/io/IOException
    //   430	456	714	java/io/IOException
    //   456	489	714	java/io/IOException
    //   494	510	714	java/io/IOException
    //   510	593	714	java/io/IOException
    //   593	634	714	java/io/IOException
    //   674	711	714	java/io/IOException
    //   739	770	714	java/io/IOException
    //   773	800	714	java/io/IOException
    //   800	815	714	java/io/IOException
    //   818	846	714	java/io/IOException
    //   850	878	714	java/io/IOException
    //   878	939	714	java/io/IOException
    //   939	965	714	java/io/IOException
    //   965	986	714	java/io/IOException
    //   989	999	714	java/io/IOException
    //   1003	1011	714	java/io/IOException
    //   1015	1036	714	java/io/IOException
    //   1036	1044	714	java/io/IOException
    //   1058	1067	714	java/io/IOException
    //   1078	1089	714	java/io/IOException
    //   1098	1121	714	java/io/IOException
    //   1129	1140	714	java/io/IOException
    //   1140	1154	714	java/io/IOException
    //   1157	1183	714	java/io/IOException
    //   1183	1196	714	java/io/IOException
    //   1213	1220	714	java/io/IOException
    //   1223	1266	714	java/io/IOException
    //   1266	1279	714	java/io/IOException
    //   1286	1294	714	java/io/IOException
    //   1297	1304	714	java/io/IOException
    //   1307	1337	714	java/io/IOException
    //   1337	1364	714	java/io/IOException
    //   1367	1388	714	java/io/IOException
    //   1391	1412	714	java/io/IOException
    //   1415	1426	714	java/io/IOException
    //   1429	1501	714	java/io/IOException
    //   1659	1667	714	java/io/IOException
    //   1667	1669	714	java/io/IOException
    //   1778	1809	714	java/io/IOException
    //   1809	1815	714	java/io/IOException
    //   1815	1972	714	java/io/IOException
    //   1992	2024	714	java/io/IOException
    //   2027	2064	714	java/io/IOException
    //   2064	2144	714	java/io/IOException
    //   2144	2159	714	java/io/IOException
    //   2159	2185	714	java/io/IOException
    //   2185	2214	714	java/io/IOException
    //   2217	2227	714	java/io/IOException
    //   2230	2241	714	java/io/IOException
    //   2241	2319	714	java/io/IOException
    //   2323	2396	714	java/io/IOException
    //   2396	2410	714	java/io/IOException
    //   2418	2429	714	java/io/IOException
    //   2432	2452	714	java/io/IOException
    //   2455	2464	714	java/io/IOException
    //   2472	2531	714	java/io/IOException
    //   1504	1521	1653	finally
    //   1524	1610	1653	finally
    //   1618	1633	1653	finally
    //   1642	1653	1653	finally
    //   1690	1720	1653	finally
    //   1723	1735	1653	finally
    //   1738	1775	1653	finally
  }
  
  final gm a(boolean paramBoolean)
    throws IOException
  {
    return new a(0, this.c, paramBoolean).a(this.c);
  }
  
  public final void a(fs paramfs)
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    this.a.a.a(new b(paramfs, (byte)0));
  }
  
  public final gm b()
    throws IOException
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    try
    {
      this.a.a.a(this);
      gm localgm1 = a(false);
      if (localgm1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.a.a.a(this);
    }
    this.a.a.a(this);
    return localgm2;
  }
  
  public final void c()
  {
    this.b = true;
    Object localObject2;
    if (this.d != null) {
      localObject2 = this.d.c;
    }
    do
    {
      synchronized (((ig)localObject2).b)
      {
        ((ig)localObject2).e = true;
        hx localhx = ((ig)localObject2).f;
        localObject2 = ((ig)localObject2).d;
        if (localhx != null)
        {
          localhx.a();
          return;
        }
      }
    } while (localObject2 == null);
    gy.a(((ii)localObject2).b);
  }
  
  public final boolean d()
  {
    return this.b;
  }
  
  final class a
    implements gf.a
  {
    private final int b;
    private final gk c;
    private final boolean d;
    
    a(int paramInt, gk paramgk, boolean paramBoolean)
    {
      this.b = paramInt;
      this.c = paramgk;
      this.d = paramBoolean;
    }
    
    public final gk a()
    {
      return this.c;
    }
    
    public final gm a(gk paramgk)
      throws IOException
    {
      if (this.b < gj.this.a.e.size())
      {
        Object localObject = new a(gj.this, this.b + 1, paramgk, this.d);
        paramgk = (gf)gj.this.a.e.get(this.b);
        localObject = paramgk.a((gf.a)localObject);
        if (localObject == null) {
          throw new NullPointerException("application interceptor " + paramgk + " returned null");
        }
        return (gm)localObject;
      }
      return gj.this.a(paramgk, this.d);
    }
    
    public final fv b()
    {
      return null;
    }
  }
  
  final class b
    extends gu
  {
    private final fs c;
    private final boolean d;
    
    private b(fs paramfs)
    {
      super(new Object[] { gj.this.c.a.toString() });
      this.c = paramfs;
      this.d = false;
    }
    
    final String a()
    {
      return gj.this.c.a.b;
    }
    
    /* Error */
    protected final void b()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   6: aload_0
      //   7: getfield 42	com/indooratlas/android/sdk/_internal/gj$b:d	Z
      //   10: invokevirtual 55	com/indooratlas/android/sdk/_internal/gj:a	(Z)Lcom/indooratlas/android/sdk/_internal/gm;
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   18: getfield 57	com/indooratlas/android/sdk/_internal/gj:b	Z
      //   21: istore_2
      //   22: iload_2
      //   23: ifeq +40 -> 63
      //   26: aload_0
      //   27: getfield 40	com/indooratlas/android/sdk/_internal/gj$b:c	Lcom/indooratlas/android/sdk/_internal/fs;
      //   30: aload_0
      //   31: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   34: new 52	java/io/IOException
      //   37: dup
      //   38: ldc 59
      //   40: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   43: invokeinterface 67 3 0
      //   48: aload_0
      //   49: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   52: getfield 70	com/indooratlas/android/sdk/_internal/gj:a	Lcom/indooratlas/android/sdk/_internal/gh;
      //   55: getfield 75	com/indooratlas/android/sdk/_internal/gh:a	Lcom/indooratlas/android/sdk/_internal/ga;
      //   58: aload_0
      //   59: invokevirtual 80	com/indooratlas/android/sdk/_internal/ga:b	(Lcom/indooratlas/android/sdk/_internal/gj$b;)V
      //   62: return
      //   63: aload_0
      //   64: getfield 40	com/indooratlas/android/sdk/_internal/gj$b:c	Lcom/indooratlas/android/sdk/_internal/fs;
      //   67: aload_3
      //   68: invokeinterface 83 2 0
      //   73: goto -25 -> 48
      //   76: astore_3
      //   77: iload_1
      //   78: ifeq +50 -> 128
      //   81: getstatic 88	com/indooratlas/android/sdk/_internal/gs:a	Ljava/util/logging/Logger;
      //   84: getstatic 94	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   87: new 96	java/lang/StringBuilder
      //   90: dup
      //   91: ldc 98
      //   93: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   96: aload_0
      //   97: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   100: invokestatic 102	com/indooratlas/android/sdk/_internal/gj:a	(Lcom/indooratlas/android/sdk/_internal/gj;)Ljava/lang/String;
      //   103: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   109: aload_3
      //   110: invokevirtual 113	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   113: aload_0
      //   114: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   117: getfield 70	com/indooratlas/android/sdk/_internal/gj:a	Lcom/indooratlas/android/sdk/_internal/gh;
      //   120: getfield 75	com/indooratlas/android/sdk/_internal/gh:a	Lcom/indooratlas/android/sdk/_internal/ga;
      //   123: aload_0
      //   124: invokevirtual 80	com/indooratlas/android/sdk/_internal/ga:b	(Lcom/indooratlas/android/sdk/_internal/gj$b;)V
      //   127: return
      //   128: aload_0
      //   129: getfield 40	com/indooratlas/android/sdk/_internal/gj$b:c	Lcom/indooratlas/android/sdk/_internal/fs;
      //   132: aload_0
      //   133: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   136: aload_3
      //   137: invokeinterface 67 3 0
      //   142: goto -29 -> 113
      //   145: astore_3
      //   146: aload_0
      //   147: getfield 17	com/indooratlas/android/sdk/_internal/gj$b:a	Lcom/indooratlas/android/sdk/_internal/gj;
      //   150: getfield 70	com/indooratlas/android/sdk/_internal/gj:a	Lcom/indooratlas/android/sdk/_internal/gh;
      //   153: getfield 75	com/indooratlas/android/sdk/_internal/gh:a	Lcom/indooratlas/android/sdk/_internal/ga;
      //   156: aload_0
      //   157: invokevirtual 80	com/indooratlas/android/sdk/_internal/ga:b	(Lcom/indooratlas/android/sdk/_internal/gj$b;)V
      //   160: aload_3
      //   161: athrow
      //   162: astore_3
      //   163: iconst_0
      //   164: istore_1
      //   165: goto -88 -> 77
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	168	0	this	b
      //   1	164	1	i	int
      //   21	2	2	bool	boolean
      //   13	55	3	localgm	gm
      //   76	61	3	localIOException1	IOException
      //   145	16	3	localObject	Object
      //   162	1	3	localIOException2	IOException
      // Exception table:
      //   from	to	target	type
      //   26	48	76	java/io/IOException
      //   63	73	76	java/io/IOException
      //   2	22	145	finally
      //   26	48	145	finally
      //   63	73	145	finally
      //   81	113	145	finally
      //   128	142	145	finally
      //   2	22	162	java/io/IOException
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */