package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.n.aa;
import cz.msebera.android.httpclient.n.k;
import cz.msebera.android.httpclient.n.m;
import cz.msebera.android.httpclient.n.u;
import cz.msebera.android.httpclient.n.z;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.l;
import java.net.URI;
import java.net.URISyntaxException;

@Immutable
public class f
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final m b;
  private final cz.msebera.android.httpclient.e.o c;
  private final cz.msebera.android.httpclient.b d;
  private final cz.msebera.android.httpclient.e.h e;
  private final k f;
  
  public f(m paramm, cz.msebera.android.httpclient.e.o paramo, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh)
  {
    a.a(paramm, "HTTP request executor");
    a.a(paramo, "Client connection manager");
    a.a(paramb, "Connection reuse strategy");
    a.a(paramh, "Connection keep alive strategy");
    this.f = new u(new cz.msebera.android.httpclient.w[] { new cz.msebera.android.httpclient.n.w(), new z(), new cz.msebera.android.httpclient.b.f.h(), new aa(l.a("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass())) });
    this.b = paramm;
    this.c = paramo;
    this.d = paramb;
    this.e = paramh;
  }
  
  static void a(cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.e.b.b paramb)
    throws aj
  {
    try
    {
      paramb = paramo.getURI();
      if (paramb != null)
      {
        if (paramb.isAbsolute()) {}
        for (paramb = i.a(paramb, null, true);; paramb = i.a(paramb))
        {
          paramo.a(paramb);
          return;
        }
      }
      return;
    }
    catch (URISyntaxException paramb)
    {
      throw new aj("Invalid URI: " + paramo.getRequestLine().c(), paramb);
    }
  }
  
  /* Error */
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws java.io.IOException, cz.msebera.android.httpclient.p
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -99
    //   3: invokestatic 42	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc -97
    //   10: invokestatic 42	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_3
    //   15: ldc -95
    //   17: invokestatic 42	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   20: pop
    //   21: aload_2
    //   22: aload_1
    //   23: invokestatic 163	cz/msebera/android/httpclient/i/f/f:a	(Lcz/msebera/android/httpclient/b/d/o;Lcz/msebera/android/httpclient/e/b/b;)V
    //   26: aload_0
    //   27: getfield 84	cz/msebera/android/httpclient/i/f/f:c	Lcz/msebera/android/httpclient/e/o;
    //   30: aload_1
    //   31: aconst_null
    //   32: invokeinterface 168 3 0
    //   37: astore 9
    //   39: aload 4
    //   41: ifnull +40 -> 81
    //   44: aload 4
    //   46: invokeinterface 173 1 0
    //   51: ifeq +21 -> 72
    //   54: aload 9
    //   56: invokeinterface 177 1 0
    //   61: pop
    //   62: new 179	cz/msebera/android/httpclient/i/f/i
    //   65: dup
    //   66: ldc -75
    //   68: invokespecial 182	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;)V
    //   71: athrow
    //   72: aload 4
    //   74: aload 9
    //   76: invokeinterface 186 2 0
    //   81: aload_3
    //   82: invokevirtual 192	cz/msebera/android/httpclient/b/f/c:p	()Lcz/msebera/android/httpclient/b/b/c;
    //   85: astore 8
    //   87: aload 8
    //   89: invokevirtual 198	cz/msebera/android/httpclient/b/b/c:m	()I
    //   92: istore 5
    //   94: iload 5
    //   96: ifle +90 -> 186
    //   99: iload 5
    //   101: i2l
    //   102: lstore 6
    //   104: aload 9
    //   106: lload 6
    //   108: getstatic 204	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   111: invokeinterface 207 4 0
    //   116: astore 10
    //   118: new 209	cz/msebera/android/httpclient/i/f/c
    //   121: dup
    //   122: aload_0
    //   123: getfield 35	cz/msebera/android/httpclient/i/f/f:a	Lcz/msebera/android/httpclient/h/b;
    //   126: aload_0
    //   127: getfield 84	cz/msebera/android/httpclient/i/f/f:c	Lcz/msebera/android/httpclient/e/o;
    //   130: aload 10
    //   132: invokespecial 212	cz/msebera/android/httpclient/i/f/c:<init>	(Lcz/msebera/android/httpclient/h/b;Lcz/msebera/android/httpclient/e/o;Lcz/msebera/android/httpclient/j;)V
    //   135: astore 9
    //   137: aload 4
    //   139: ifnull +105 -> 244
    //   142: aload 4
    //   144: invokeinterface 173 1 0
    //   149: ifeq +86 -> 235
    //   152: aload 9
    //   154: invokevirtual 215	cz/msebera/android/httpclient/i/f/c:close	()V
    //   157: new 179	cz/msebera/android/httpclient/i/f/i
    //   160: dup
    //   161: ldc -75
    //   163: invokespecial 182	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: astore_1
    //   168: new 217	java/io/InterruptedIOException
    //   171: dup
    //   172: ldc -37
    //   174: invokespecial 220	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
    //   177: astore_2
    //   178: aload_2
    //   179: aload_1
    //   180: invokevirtual 224	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   183: pop
    //   184: aload_2
    //   185: athrow
    //   186: lconst_0
    //   187: lstore 6
    //   189: goto -85 -> 104
    //   192: astore_1
    //   193: invokestatic 230	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   196: invokevirtual 233	java/lang/Thread:interrupt	()V
    //   199: new 179	cz/msebera/android/httpclient/i/f/i
    //   202: dup
    //   203: ldc -75
    //   205: aload_1
    //   206: invokespecial 234	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: athrow
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 238	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   215: astore_3
    //   216: aload_3
    //   217: astore_1
    //   218: aload_3
    //   219: ifnonnull +5 -> 224
    //   222: aload_2
    //   223: astore_1
    //   224: new 179	cz/msebera/android/httpclient/i/f/i
    //   227: dup
    //   228: ldc -16
    //   230: aload_1
    //   231: invokespecial 234	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   234: athrow
    //   235: aload 4
    //   237: aload 9
    //   239: invokeinterface 186 2 0
    //   244: aload 10
    //   246: invokeinterface 244 1 0
    //   251: ifne +47 -> 298
    //   254: aload 8
    //   256: invokevirtual 247	cz/msebera/android/httpclient/b/b/c:n	()I
    //   259: istore 5
    //   261: aload_0
    //   262: getfield 84	cz/msebera/android/httpclient/i/f/f:c	Lcz/msebera/android/httpclient/e/o;
    //   265: astore 4
    //   267: iload 5
    //   269: ifle +320 -> 589
    //   272: aload 4
    //   274: aload 10
    //   276: aload_1
    //   277: iload 5
    //   279: aload_3
    //   280: invokeinterface 250 5 0
    //   285: aload_0
    //   286: getfield 84	cz/msebera/android/httpclient/i/f/f:c	Lcz/msebera/android/httpclient/e/o;
    //   289: aload 10
    //   291: aload_1
    //   292: aload_3
    //   293: invokeinterface 253 4 0
    //   298: aload 8
    //   300: invokevirtual 256	cz/msebera/android/httpclient/b/b/c:o	()I
    //   303: istore 5
    //   305: iload 5
    //   307: iflt +12 -> 319
    //   310: aload 10
    //   312: iload 5
    //   314: invokeinterface 259 2 0
    //   319: aconst_null
    //   320: astore 8
    //   322: aload_2
    //   323: invokevirtual 262	cz/msebera/android/httpclient/b/d/o:a	()Lcz/msebera/android/httpclient/u;
    //   326: astore 11
    //   328: aload 8
    //   330: astore 4
    //   332: aload 11
    //   334: instanceof 264
    //   337: ifeq +51 -> 388
    //   340: aload 11
    //   342: checkcast 264	cz/msebera/android/httpclient/b/d/q
    //   345: invokeinterface 265 1 0
    //   350: astore 11
    //   352: aload 8
    //   354: astore 4
    //   356: aload 11
    //   358: invokevirtual 106	java/net/URI:isAbsolute	()Z
    //   361: ifeq +27 -> 388
    //   364: new 267	cz/msebera/android/httpclient/r
    //   367: dup
    //   368: aload 11
    //   370: invokevirtual 270	java/net/URI:getHost	()Ljava/lang/String;
    //   373: aload 11
    //   375: invokevirtual 273	java/net/URI:getPort	()I
    //   378: aload 11
    //   380: invokevirtual 276	java/net/URI:getScheme	()Ljava/lang/String;
    //   383: invokespecial 279	cz/msebera/android/httpclient/r:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: astore 4
    //   388: aload 4
    //   390: astore 8
    //   392: aload 4
    //   394: ifnonnull +9 -> 403
    //   397: aload_1
    //   398: invokevirtual 284	cz/msebera/android/httpclient/e/b/b:a	()Lcz/msebera/android/httpclient/r;
    //   401: astore 8
    //   403: aload_3
    //   404: ldc_w 286
    //   407: aload 8
    //   409: invokevirtual 289	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   412: aload_3
    //   413: ldc_w 291
    //   416: aload_2
    //   417: invokevirtual 289	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   420: aload_3
    //   421: ldc_w 293
    //   424: aload 10
    //   426: invokevirtual 289	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   429: aload_3
    //   430: ldc_w 295
    //   433: aload_1
    //   434: invokevirtual 289	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   437: aload_0
    //   438: getfield 80	cz/msebera/android/httpclient/i/f/f:f	Lcz/msebera/android/httpclient/n/k;
    //   441: aload_2
    //   442: aload_3
    //   443: invokeinterface 301 3 0
    //   448: aload_0
    //   449: getfield 82	cz/msebera/android/httpclient/i/f/f:b	Lcz/msebera/android/httpclient/n/m;
    //   452: aload_2
    //   453: aload 10
    //   455: aload_3
    //   456: invokevirtual 306	cz/msebera/android/httpclient/n/m:a	(Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/j;Lcz/msebera/android/httpclient/n/g;)Lcz/msebera/android/httpclient/x;
    //   459: astore_1
    //   460: aload_0
    //   461: getfield 80	cz/msebera/android/httpclient/i/f/f:f	Lcz/msebera/android/httpclient/n/k;
    //   464: aload_1
    //   465: aload_3
    //   466: invokeinterface 309 3 0
    //   471: aload_0
    //   472: getfield 86	cz/msebera/android/httpclient/i/f/f:d	Lcz/msebera/android/httpclient/b;
    //   475: aload_1
    //   476: aload_3
    //   477: invokeinterface 314 3 0
    //   482: ifeq +62 -> 544
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 88	cz/msebera/android/httpclient/i/f/f:e	Lcz/msebera/android/httpclient/e/h;
    //   491: aload_1
    //   492: aload_3
    //   493: invokeinterface 319 3 0
    //   498: getstatic 204	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   501: invokevirtual 322	cz/msebera/android/httpclient/i/f/c:a	(JLjava/util/concurrent/TimeUnit;)V
    //   504: aload 9
    //   506: invokevirtual 324	cz/msebera/android/httpclient/i/f/c:d	()V
    //   509: aload_1
    //   510: invokeinterface 329 1 0
    //   515: astore_2
    //   516: aload_2
    //   517: ifnull +12 -> 529
    //   520: aload_2
    //   521: invokeinterface 334 1 0
    //   526: ifne +34 -> 560
    //   529: aload 9
    //   531: invokevirtual 337	cz/msebera/android/httpclient/i/f/c:i_	()V
    //   534: new 339	cz/msebera/android/httpclient/i/f/d
    //   537: dup
    //   538: aload_1
    //   539: aconst_null
    //   540: invokespecial 342	cz/msebera/android/httpclient/i/f/d:<init>	(Lcz/msebera/android/httpclient/x;Lcz/msebera/android/httpclient/i/f/c;)V
    //   543: areturn
    //   544: aload 9
    //   546: invokevirtual 344	cz/msebera/android/httpclient/i/f/c:e	()V
    //   549: goto -40 -> 509
    //   552: astore_1
    //   553: aload 9
    //   555: invokevirtual 346	cz/msebera/android/httpclient/i/f/c:b	()V
    //   558: aload_1
    //   559: athrow
    //   560: new 339	cz/msebera/android/httpclient/i/f/d
    //   563: dup
    //   564: aload_1
    //   565: aload 9
    //   567: invokespecial 342	cz/msebera/android/httpclient/i/f/d:<init>	(Lcz/msebera/android/httpclient/x;Lcz/msebera/android/httpclient/i/f/c;)V
    //   570: astore_1
    //   571: aload_1
    //   572: areturn
    //   573: astore_1
    //   574: aload 9
    //   576: invokevirtual 346	cz/msebera/android/httpclient/i/f/c:b	()V
    //   579: aload_1
    //   580: athrow
    //   581: astore_1
    //   582: aload 9
    //   584: invokevirtual 346	cz/msebera/android/httpclient/i/f/c:b	()V
    //   587: aload_1
    //   588: athrow
    //   589: iconst_0
    //   590: istore 5
    //   592: goto -320 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	f
    //   0	595	1	paramb	cz.msebera.android.httpclient.e.b.b
    //   0	595	2	paramo	cz.msebera.android.httpclient.b.d.o
    //   0	595	3	paramc	cz.msebera.android.httpclient.b.f.c
    //   0	595	4	paramg	cz.msebera.android.httpclient.b.d.g
    //   92	499	5	i	int
    //   102	86	6	l	long
    //   85	323	8	localObject1	Object
    //   37	546	9	localObject2	Object
    //   116	338	10	localj	cz.msebera.android.httpclient.j
    //   326	53	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   142	167	167	cz/msebera/android/httpclient/i/c/i
    //   235	244	167	cz/msebera/android/httpclient/i/c/i
    //   244	267	167	cz/msebera/android/httpclient/i/c/i
    //   272	298	167	cz/msebera/android/httpclient/i/c/i
    //   298	305	167	cz/msebera/android/httpclient/i/c/i
    //   310	319	167	cz/msebera/android/httpclient/i/c/i
    //   322	328	167	cz/msebera/android/httpclient/i/c/i
    //   332	352	167	cz/msebera/android/httpclient/i/c/i
    //   356	388	167	cz/msebera/android/httpclient/i/c/i
    //   397	403	167	cz/msebera/android/httpclient/i/c/i
    //   403	509	167	cz/msebera/android/httpclient/i/c/i
    //   509	516	167	cz/msebera/android/httpclient/i/c/i
    //   520	529	167	cz/msebera/android/httpclient/i/c/i
    //   529	544	167	cz/msebera/android/httpclient/i/c/i
    //   544	549	167	cz/msebera/android/httpclient/i/c/i
    //   560	571	167	cz/msebera/android/httpclient/i/c/i
    //   87	94	192	java/lang/InterruptedException
    //   104	118	192	java/lang/InterruptedException
    //   87	94	210	java/util/concurrent/ExecutionException
    //   104	118	210	java/util/concurrent/ExecutionException
    //   142	167	552	cz/msebera/android/httpclient/p
    //   235	244	552	cz/msebera/android/httpclient/p
    //   244	267	552	cz/msebera/android/httpclient/p
    //   272	298	552	cz/msebera/android/httpclient/p
    //   298	305	552	cz/msebera/android/httpclient/p
    //   310	319	552	cz/msebera/android/httpclient/p
    //   322	328	552	cz/msebera/android/httpclient/p
    //   332	352	552	cz/msebera/android/httpclient/p
    //   356	388	552	cz/msebera/android/httpclient/p
    //   397	403	552	cz/msebera/android/httpclient/p
    //   403	509	552	cz/msebera/android/httpclient/p
    //   509	516	552	cz/msebera/android/httpclient/p
    //   520	529	552	cz/msebera/android/httpclient/p
    //   529	544	552	cz/msebera/android/httpclient/p
    //   544	549	552	cz/msebera/android/httpclient/p
    //   560	571	552	cz/msebera/android/httpclient/p
    //   142	167	573	java/io/IOException
    //   235	244	573	java/io/IOException
    //   244	267	573	java/io/IOException
    //   272	298	573	java/io/IOException
    //   298	305	573	java/io/IOException
    //   310	319	573	java/io/IOException
    //   322	328	573	java/io/IOException
    //   332	352	573	java/io/IOException
    //   356	388	573	java/io/IOException
    //   397	403	573	java/io/IOException
    //   403	509	573	java/io/IOException
    //   509	516	573	java/io/IOException
    //   520	529	573	java/io/IOException
    //   529	544	573	java/io/IOException
    //   544	549	573	java/io/IOException
    //   560	571	573	java/io/IOException
    //   142	167	581	java/lang/RuntimeException
    //   235	244	581	java/lang/RuntimeException
    //   244	267	581	java/lang/RuntimeException
    //   272	298	581	java/lang/RuntimeException
    //   298	305	581	java/lang/RuntimeException
    //   310	319	581	java/lang/RuntimeException
    //   322	328	581	java/lang/RuntimeException
    //   332	352	581	java/lang/RuntimeException
    //   356	388	581	java/lang/RuntimeException
    //   397	403	581	java/lang/RuntimeException
    //   403	509	581	java/lang/RuntimeException
    //   509	516	581	java/lang/RuntimeException
    //   520	529	581	java/lang/RuntimeException
    //   529	544	581	java/lang/RuntimeException
    //   544	549	581	java/lang/RuntimeException
    //   560	571	581	java/lang/RuntimeException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */