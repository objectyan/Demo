package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.t;
import cz.msebera.android.httpclient.e.o;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.n.k;
import cz.msebera.android.httpclient.n.m;
import cz.msebera.android.httpclient.n.z;
import cz.msebera.android.httpclient.o.g;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

@Immutable
public class e
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final m b;
  private final o c;
  private final cz.msebera.android.httpclient.b d;
  private final cz.msebera.android.httpclient.e.h e;
  private final k f;
  private final cz.msebera.android.httpclient.b.c g;
  private final cz.msebera.android.httpclient.b.c h;
  private final cz.msebera.android.httpclient.i.a.f i;
  private final t j;
  private final cz.msebera.android.httpclient.e.b.c k;
  
  public e(m paramm, o paramo, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.b.c paramc1, cz.msebera.android.httpclient.b.c paramc2, t paramt)
  {
    cz.msebera.android.httpclient.o.a.a(paramm, "HTTP request executor");
    cz.msebera.android.httpclient.o.a.a(paramo, "Client connection manager");
    cz.msebera.android.httpclient.o.a.a(paramb, "Connection reuse strategy");
    cz.msebera.android.httpclient.o.a.a(paramh, "Connection keep alive strategy");
    cz.msebera.android.httpclient.o.a.a(paramc1, "Target authentication strategy");
    cz.msebera.android.httpclient.o.a.a(paramc2, "Proxy authentication strategy");
    cz.msebera.android.httpclient.o.a.a(paramt, "User token handler");
    this.i = new cz.msebera.android.httpclient.i.a.f();
    this.f = new cz.msebera.android.httpclient.n.u(new w[] { new z(), new cz.msebera.android.httpclient.b.f.h() });
    this.k = new cz.msebera.android.httpclient.e.b.a();
    this.b = paramm;
    this.c = paramo;
    this.d = paramb;
    this.e = paramh;
    this.g = paramc1;
    this.h = paramc2;
    this.j = paramt;
  }
  
  private boolean a(cz.msebera.android.httpclient.a.i parami1, cz.msebera.android.httpclient.a.i parami2, cz.msebera.android.httpclient.e.b.b paramb, x paramx, cz.msebera.android.httpclient.b.f.c paramc)
  {
    if (paramc.p().j())
    {
      Object localObject2 = paramc.v();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramb.a();
      }
      localObject2 = localObject1;
      if (((r)localObject1).b() < 0) {
        localObject2 = new r(((r)localObject1).a(), paramb.a().b(), ((r)localObject1).c());
      }
      boolean bool1 = this.i.a((r)localObject2, paramx, this.g, parami1, paramc);
      r localr = paramb.e();
      localObject1 = localr;
      if (localr == null) {
        localObject1 = paramb.a();
      }
      boolean bool2 = this.i.a((r)localObject1, paramx, this.h, parami2, paramc);
      if (bool1) {
        return this.i.b((r)localObject2, paramx, this.g, parami1, paramc);
      }
      if (bool2) {
        return this.i.b((r)localObject1, paramx, this.h, parami2, paramc);
      }
    }
    return false;
  }
  
  private boolean a(cz.msebera.android.httpclient.e.b.b paramb, int paramInt, cz.msebera.android.httpclient.b.f.c paramc)
    throws p
  {
    throw new p("Proxy chains are not supported.");
  }
  
  private boolean b(cz.msebera.android.httpclient.a.i parami, j paramj, cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.u paramu, cz.msebera.android.httpclient.b.f.c paramc)
    throws p, IOException
  {
    cz.msebera.android.httpclient.b.b.c localc = paramc.p();
    int n = localc.n();
    Object localObject = paramb.a();
    r localr = paramb.e();
    x localx = null;
    localObject = new cz.msebera.android.httpclient.k.i("CONNECT", ((r)localObject).f(), paramu.getProtocolVersion());
    this.b.a((cz.msebera.android.httpclient.u)localObject, this.f, paramc);
    paramu = localx;
    while (paramu == null)
    {
      if (!paramj.c())
      {
        paramu = this.c;
        if (n <= 0) {
          break label199;
        }
      }
      label199:
      for (int m = n;; m = 0)
      {
        paramu.a(paramj, paramb, m, paramc);
        ((cz.msebera.android.httpclient.u)localObject).removeHeaders("Proxy-Authorization");
        this.i.a((cz.msebera.android.httpclient.u)localObject, parami, paramc);
        localx = this.b.a((cz.msebera.android.httpclient.u)localObject, paramj, paramc);
        if (localx.a().b() >= 200) {
          break;
        }
        throw new p("Unexpected response to CONNECT request: " + localx.a());
      }
      paramu = localx;
      if (localc.j())
      {
        paramu = localx;
        if (this.i.a(localr, localx, this.h, parami, paramc))
        {
          paramu = localx;
          if (this.i.b(localr, localx, this.h, parami, paramc))
          {
            if (this.d.a(localx, paramc))
            {
              this.a.a("Connection kept alive");
              g.b(localx.b());
            }
            for (;;)
            {
              paramu = null;
              break;
              paramj.close();
            }
          }
        }
      }
    }
    if (paramu.a().b() > 299)
    {
      parami = paramu.b();
      if (parami != null) {
        paramu.a(new cz.msebera.android.httpclient.g.c(parami));
      }
      paramj.close();
      throw new n("CONNECT refused by proxy: " + paramu.a(), paramu);
    }
    return false;
  }
  
  /* Error */
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, p
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 265
    //   4: invokestatic 51	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_2
    //   9: ldc_w 267
    //   12: invokestatic 51	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_3
    //   17: ldc_w 269
    //   20: invokestatic 51	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   23: pop
    //   24: aload_3
    //   25: invokevirtual 273	cz/msebera/android/httpclient/b/f/c:m	()Lcz/msebera/android/httpclient/a/i;
    //   28: astore 10
    //   30: aload 10
    //   32: astore 9
    //   34: aload 10
    //   36: ifnonnull +21 -> 57
    //   39: new 275	cz/msebera/android/httpclient/a/i
    //   42: dup
    //   43: invokespecial 276	cz/msebera/android/httpclient/a/i:<init>	()V
    //   46: astore 9
    //   48: aload_3
    //   49: ldc_w 278
    //   52: aload 9
    //   54: invokevirtual 281	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   57: aload_3
    //   58: invokevirtual 283	cz/msebera/android/httpclient/b/f/c:n	()Lcz/msebera/android/httpclient/a/i;
    //   61: astore 11
    //   63: aload 11
    //   65: astore 10
    //   67: aload 11
    //   69: ifnonnull +21 -> 90
    //   72: new 275	cz/msebera/android/httpclient/a/i
    //   75: dup
    //   76: invokespecial 276	cz/msebera/android/httpclient/a/i:<init>	()V
    //   79: astore 10
    //   81: aload_3
    //   82: ldc_w 285
    //   85: aload 10
    //   87: invokevirtual 281	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   90: aload_2
    //   91: instanceof 287
    //   94: ifeq +10 -> 104
    //   97: aload_2
    //   98: checkcast 287	cz/msebera/android/httpclient/o
    //   101: invokestatic 292	cz/msebera/android/httpclient/i/f/j:a	(Lcz/msebera/android/httpclient/o;)V
    //   104: aload_3
    //   105: invokevirtual 296	cz/msebera/android/httpclient/b/f/c:o	()Ljava/lang/Object;
    //   108: astore 12
    //   110: aload_0
    //   111: getfield 92	cz/msebera/android/httpclient/i/f/e:c	Lcz/msebera/android/httpclient/e/o;
    //   114: aload_1
    //   115: aload 12
    //   117: invokeinterface 299 3 0
    //   122: astore 11
    //   124: aload 4
    //   126: ifnull +41 -> 167
    //   129: aload 4
    //   131: invokeinterface 304 1 0
    //   136: ifeq +22 -> 158
    //   139: aload 11
    //   141: invokeinterface 308 1 0
    //   146: pop
    //   147: new 310	cz/msebera/android/httpclient/i/f/i
    //   150: dup
    //   151: ldc_w 312
    //   154: invokespecial 313	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;)V
    //   157: athrow
    //   158: aload 4
    //   160: aload 11
    //   162: invokeinterface 317 2 0
    //   167: aload_3
    //   168: invokevirtual 110	cz/msebera/android/httpclient/b/f/c:p	()Lcz/msebera/android/httpclient/b/b/c;
    //   171: astore 15
    //   173: aload 15
    //   175: invokevirtual 319	cz/msebera/android/httpclient/b/b/c:m	()I
    //   178: istore 5
    //   180: iload 5
    //   182: ifle +166 -> 348
    //   185: iload 5
    //   187: i2l
    //   188: lstore 7
    //   190: aload 11
    //   192: lload 7
    //   194: getstatic 325	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   197: invokeinterface 328 4 0
    //   202: astore 16
    //   204: aload_3
    //   205: ldc_w 330
    //   208: aload 16
    //   210: invokevirtual 281	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   213: aload 15
    //   215: invokevirtual 332	cz/msebera/android/httpclient/b/b/c:d	()Z
    //   218: ifeq +50 -> 268
    //   221: aload 16
    //   223: invokeinterface 182 1 0
    //   228: ifeq +40 -> 268
    //   231: aload_0
    //   232: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   235: ldc_w 334
    //   238: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   241: aload 16
    //   243: invokeinterface 335 1 0
    //   248: ifeq +20 -> 268
    //   251: aload_0
    //   252: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   255: ldc_w 337
    //   258: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   261: aload 16
    //   263: invokeinterface 241 1 0
    //   268: new 339	cz/msebera/android/httpclient/i/f/c
    //   271: dup
    //   272: aload_0
    //   273: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   276: aload_0
    //   277: getfield 92	cz/msebera/android/httpclient/i/f/e:c	Lcz/msebera/android/httpclient/e/o;
    //   280: aload 16
    //   282: invokespecial 342	cz/msebera/android/httpclient/i/f/c:<init>	(Lcz/msebera/android/httpclient/h/b;Lcz/msebera/android/httpclient/e/o;Lcz/msebera/android/httpclient/j;)V
    //   285: astore 14
    //   287: aload 4
    //   289: ifnull +878 -> 1167
    //   292: aload 4
    //   294: aload 14
    //   296: invokeinterface 317 2 0
    //   301: goto +866 -> 1167
    //   304: iload 5
    //   306: iconst_1
    //   307: if_icmple +92 -> 399
    //   310: aload_2
    //   311: invokestatic 345	cz/msebera/android/httpclient/i/f/j:a	(Lcz/msebera/android/httpclient/u;)Z
    //   314: ifne +85 -> 399
    //   317: new 347	cz/msebera/android/httpclient/b/m
    //   320: dup
    //   321: ldc_w 349
    //   324: invokespecial 350	cz/msebera/android/httpclient/b/m:<init>	(Ljava/lang/String;)V
    //   327: athrow
    //   328: astore_1
    //   329: new 352	java/io/InterruptedIOException
    //   332: dup
    //   333: ldc_w 354
    //   336: invokespecial 355	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
    //   339: astore_2
    //   340: aload_2
    //   341: aload_1
    //   342: invokevirtual 359	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   345: pop
    //   346: aload_2
    //   347: athrow
    //   348: lconst_0
    //   349: lstore 7
    //   351: goto -161 -> 190
    //   354: astore_1
    //   355: invokestatic 365	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   358: invokevirtual 368	java/lang/Thread:interrupt	()V
    //   361: new 310	cz/msebera/android/httpclient/i/f/i
    //   364: dup
    //   365: ldc_w 312
    //   368: aload_1
    //   369: invokespecial 371	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: athrow
    //   373: astore_2
    //   374: aload_2
    //   375: invokevirtual 375	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   378: astore_3
    //   379: aload_3
    //   380: astore_1
    //   381: aload_3
    //   382: ifnonnull +5 -> 387
    //   385: aload_2
    //   386: astore_1
    //   387: new 310	cz/msebera/android/httpclient/i/f/i
    //   390: dup
    //   391: ldc_w 377
    //   394: aload_1
    //   395: invokespecial 371	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   398: athrow
    //   399: aload 4
    //   401: ifnull +32 -> 433
    //   404: aload 4
    //   406: invokeinterface 304 1 0
    //   411: ifeq +22 -> 433
    //   414: new 310	cz/msebera/android/httpclient/i/f/i
    //   417: dup
    //   418: ldc_w 312
    //   421: invokespecial 313	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;)V
    //   424: athrow
    //   425: astore_1
    //   426: aload 14
    //   428: invokevirtual 379	cz/msebera/android/httpclient/i/f/c:b	()V
    //   431: aload_1
    //   432: athrow
    //   433: aload 16
    //   435: invokeinterface 182 1 0
    //   440: ifne +41 -> 481
    //   443: aload_0
    //   444: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   447: new 208	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 381
    //   457: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   470: aload_0
    //   471: aload 10
    //   473: aload 16
    //   475: aload_1
    //   476: aload_2
    //   477: aload_3
    //   478: invokevirtual 384	cz/msebera/android/httpclient/i/f/e:a	(Lcz/msebera/android/httpclient/a/i;Lcz/msebera/android/httpclient/j;Lcz/msebera/android/httpclient/e/b/b;Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/b/f/c;)V
    //   481: aload 15
    //   483: invokevirtual 386	cz/msebera/android/httpclient/b/b/c:o	()I
    //   486: istore 6
    //   488: iload 6
    //   490: iflt +12 -> 502
    //   493: aload 16
    //   495: iload 6
    //   497: invokeinterface 389 2 0
    //   502: aload 4
    //   504: ifnull +134 -> 638
    //   507: aload 4
    //   509: invokeinterface 304 1 0
    //   514: ifeq +124 -> 638
    //   517: new 310	cz/msebera/android/httpclient/i/f/i
    //   520: dup
    //   521: ldc_w 312
    //   524: invokespecial 313	cz/msebera/android/httpclient/i/f/i:<init>	(Ljava/lang/String;)V
    //   527: athrow
    //   528: astore_1
    //   529: aload 14
    //   531: invokevirtual 379	cz/msebera/android/httpclient/i/f/c:b	()V
    //   534: aload_1
    //   535: athrow
    //   536: astore_1
    //   537: aload_0
    //   538: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   541: invokevirtual 390	cz/msebera/android/httpclient/h/b:a	()Z
    //   544: ifeq +14 -> 558
    //   547: aload_0
    //   548: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   551: aload_1
    //   552: invokevirtual 393	cz/msebera/android/httpclient/i/f/n:getMessage	()Ljava/lang/String;
    //   555: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   558: aload_1
    //   559: invokevirtual 396	cz/msebera/android/httpclient/i/f/n:a	()Lcz/msebera/android/httpclient/x;
    //   562: astore 11
    //   564: aload 12
    //   566: astore_1
    //   567: aload 12
    //   569: ifnonnull +22 -> 591
    //   572: aload_0
    //   573: getfield 102	cz/msebera/android/httpclient/i/f/e:j	Lcz/msebera/android/httpclient/b/t;
    //   576: aload_3
    //   577: invokeinterface 401 2 0
    //   582: astore_1
    //   583: aload_3
    //   584: ldc_w 403
    //   587: aload_1
    //   588: invokevirtual 281	cz/msebera/android/httpclient/b/f/c:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   591: aload_1
    //   592: ifnull +9 -> 601
    //   595: aload 14
    //   597: aload_1
    //   598: invokevirtual 404	cz/msebera/android/httpclient/i/f/c:a	(Ljava/lang/Object;)V
    //   601: aload 11
    //   603: invokeinterface 233 1 0
    //   608: astore_1
    //   609: aload_1
    //   610: ifnull +12 -> 622
    //   613: aload_1
    //   614: invokeinterface 409 1 0
    //   619: ifne +534 -> 1153
    //   622: aload 14
    //   624: invokevirtual 412	cz/msebera/android/httpclient/i/f/c:i_	()V
    //   627: new 414	cz/msebera/android/httpclient/i/f/d
    //   630: dup
    //   631: aload 11
    //   633: aconst_null
    //   634: invokespecial 417	cz/msebera/android/httpclient/i/f/d:<init>	(Lcz/msebera/android/httpclient/x;Lcz/msebera/android/httpclient/i/f/c;)V
    //   637: areturn
    //   638: aload_0
    //   639: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   642: invokevirtual 390	cz/msebera/android/httpclient/h/b:a	()Z
    //   645: ifeq +33 -> 678
    //   648: aload_0
    //   649: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   652: new 208	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 419
    //   662: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 425	cz/msebera/android/httpclient/b/d/o:getRequestLine	()Lcz/msebera/android/httpclient/am;
    //   669: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   678: aload_2
    //   679: ldc_w 427
    //   682: invokevirtual 431	cz/msebera/android/httpclient/b/d/o:containsHeader	(Ljava/lang/String;)Z
    //   685: ifne +55 -> 740
    //   688: aload_0
    //   689: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   692: invokevirtual 390	cz/msebera/android/httpclient/h/b:a	()Z
    //   695: ifeq +34 -> 729
    //   698: aload_0
    //   699: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   702: new 208	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 433
    //   712: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 9
    //   717: invokevirtual 436	cz/msebera/android/httpclient/a/i:b	()Lcz/msebera/android/httpclient/a/c;
    //   720: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   729: aload_0
    //   730: getfield 68	cz/msebera/android/httpclient/i/f/e:i	Lcz/msebera/android/httpclient/i/a/f;
    //   733: aload_2
    //   734: aload 9
    //   736: aload_3
    //   737: invokevirtual 195	cz/msebera/android/httpclient/i/a/f:a	(Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/a/i;Lcz/msebera/android/httpclient/n/g;)V
    //   740: aload_2
    //   741: ldc -67
    //   743: invokevirtual 431	cz/msebera/android/httpclient/b/d/o:containsHeader	(Ljava/lang/String;)Z
    //   746: ifne +62 -> 808
    //   749: aload_1
    //   750: invokevirtual 438	cz/msebera/android/httpclient/e/b/b:g	()Z
    //   753: ifne +55 -> 808
    //   756: aload_0
    //   757: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   760: invokevirtual 390	cz/msebera/android/httpclient/h/b:a	()Z
    //   763: ifeq +34 -> 797
    //   766: aload_0
    //   767: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   770: new 208	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 440
    //   780: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 10
    //   785: invokevirtual 436	cz/msebera/android/httpclient/a/i:b	()Lcz/msebera/android/httpclient/a/c;
    //   788: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   797: aload_0
    //   798: getfield 68	cz/msebera/android/httpclient/i/f/e:i	Lcz/msebera/android/httpclient/i/a/f;
    //   801: aload_2
    //   802: aload 10
    //   804: aload_3
    //   805: invokevirtual 195	cz/msebera/android/httpclient/i/a/f:a	(Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/a/i;Lcz/msebera/android/httpclient/n/g;)V
    //   808: aload_0
    //   809: getfield 90	cz/msebera/android/httpclient/i/f/e:b	Lcz/msebera/android/httpclient/n/m;
    //   812: aload_2
    //   813: aload 16
    //   815: aload_3
    //   816: invokevirtual 198	cz/msebera/android/httpclient/n/m:a	(Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/j;Lcz/msebera/android/httpclient/n/g;)Lcz/msebera/android/httpclient/x;
    //   819: astore 13
    //   821: aload_0
    //   822: getfield 94	cz/msebera/android/httpclient/i/f/e:d	Lcz/msebera/android/httpclient/b;
    //   825: aload 13
    //   827: aload_3
    //   828: invokeinterface 226 3 0
    //   833: ifeq +200 -> 1033
    //   836: aload_0
    //   837: getfield 96	cz/msebera/android/httpclient/i/f/e:e	Lcz/msebera/android/httpclient/e/h;
    //   840: aload 13
    //   842: aload_3
    //   843: invokeinterface 445 3 0
    //   848: lstore 7
    //   850: aload_0
    //   851: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   854: invokevirtual 390	cz/msebera/android/httpclient/h/b:a	()Z
    //   857: ifeq +73 -> 930
    //   860: lload 7
    //   862: lconst_0
    //   863: lcmp
    //   864: ifle +318 -> 1182
    //   867: new 208	java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   874: ldc_w 447
    //   877: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: lload 7
    //   882: invokevirtual 450	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   885: ldc_w 452
    //   888: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: getstatic 325	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   894: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   897: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: astore 11
    //   902: aload_0
    //   903: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   906: new 208	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   913: ldc_w 454
    //   916: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: aload 11
    //   921: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   930: aload 14
    //   932: lload 7
    //   934: getstatic 325	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   937: invokevirtual 457	cz/msebera/android/httpclient/i/f/c:a	(JLjava/util/concurrent/TimeUnit;)V
    //   940: aload 14
    //   942: invokevirtual 459	cz/msebera/android/httpclient/i/f/c:d	()V
    //   945: aload 13
    //   947: astore 11
    //   949: aload_0
    //   950: aload 9
    //   952: aload 10
    //   954: aload_1
    //   955: aload 13
    //   957: aload_3
    //   958: invokespecial 461	cz/msebera/android/httpclient/i/f/e:a	(Lcz/msebera/android/httpclient/a/i;Lcz/msebera/android/httpclient/a/i;Lcz/msebera/android/httpclient/e/b/b;Lcz/msebera/android/httpclient/x;Lcz/msebera/android/httpclient/b/f/c;)Z
    //   961: ifeq -397 -> 564
    //   964: aload 13
    //   966: invokeinterface 233 1 0
    //   971: astore 11
    //   973: aload 14
    //   975: invokevirtual 462	cz/msebera/android/httpclient/i/f/c:c	()Z
    //   978: ifeq +71 -> 1049
    //   981: aload 11
    //   983: invokestatic 238	cz/msebera/android/httpclient/o/g:b	(Lcz/msebera/android/httpclient/n;)V
    //   986: aload_2
    //   987: invokevirtual 465	cz/msebera/android/httpclient/b/d/o:a	()Lcz/msebera/android/httpclient/u;
    //   990: astore 11
    //   992: aload 11
    //   994: ldc_w 427
    //   997: invokeinterface 466 2 0
    //   1002: ifne +10 -> 1012
    //   1005: aload_2
    //   1006: ldc_w 427
    //   1009: invokevirtual 467	cz/msebera/android/httpclient/b/d/o:removeHeaders	(Ljava/lang/String;)V
    //   1012: aload 11
    //   1014: ldc -67
    //   1016: invokeinterface 466 2 0
    //   1021: ifne +152 -> 1173
    //   1024: aload_2
    //   1025: ldc -67
    //   1027: invokevirtual 467	cz/msebera/android/httpclient/b/d/o:removeHeaders	(Ljava/lang/String;)V
    //   1030: goto +143 -> 1173
    //   1033: aload 14
    //   1035: invokevirtual 469	cz/msebera/android/httpclient/i/f/c:e	()V
    //   1038: goto -93 -> 945
    //   1041: astore_1
    //   1042: aload 14
    //   1044: invokevirtual 379	cz/msebera/android/httpclient/i/f/c:b	()V
    //   1047: aload_1
    //   1048: athrow
    //   1049: aload 16
    //   1051: invokeinterface 241 1 0
    //   1056: aload 10
    //   1058: invokevirtual 436	cz/msebera/android/httpclient/a/i:b	()Lcz/msebera/android/httpclient/a/c;
    //   1061: getstatic 474	cz/msebera/android/httpclient/a/c:e	Lcz/msebera/android/httpclient/a/c;
    //   1064: if_acmpne +39 -> 1103
    //   1067: aload 10
    //   1069: invokevirtual 477	cz/msebera/android/httpclient/a/i:c	()Lcz/msebera/android/httpclient/a/d;
    //   1072: ifnull +31 -> 1103
    //   1075: aload 10
    //   1077: invokevirtual 477	cz/msebera/android/httpclient/a/i:c	()Lcz/msebera/android/httpclient/a/d;
    //   1080: invokeinterface 480 1 0
    //   1085: ifeq +18 -> 1103
    //   1088: aload_0
    //   1089: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   1092: ldc_w 482
    //   1095: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   1098: aload 10
    //   1100: invokevirtual 484	cz/msebera/android/httpclient/a/i:a	()V
    //   1103: aload 9
    //   1105: invokevirtual 436	cz/msebera/android/httpclient/a/i:b	()Lcz/msebera/android/httpclient/a/c;
    //   1108: getstatic 474	cz/msebera/android/httpclient/a/c:e	Lcz/msebera/android/httpclient/a/c;
    //   1111: if_acmpne -125 -> 986
    //   1114: aload 9
    //   1116: invokevirtual 477	cz/msebera/android/httpclient/a/i:c	()Lcz/msebera/android/httpclient/a/d;
    //   1119: ifnull -133 -> 986
    //   1122: aload 9
    //   1124: invokevirtual 477	cz/msebera/android/httpclient/a/i:c	()Lcz/msebera/android/httpclient/a/d;
    //   1127: invokeinterface 480 1 0
    //   1132: ifeq -146 -> 986
    //   1135: aload_0
    //   1136: getfield 44	cz/msebera/android/httpclient/i/f/e:a	Lcz/msebera/android/httpclient/h/b;
    //   1139: ldc_w 486
    //   1142: invokevirtual 230	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   1145: aload 9
    //   1147: invokevirtual 484	cz/msebera/android/httpclient/a/i:a	()V
    //   1150: goto -164 -> 986
    //   1153: new 414	cz/msebera/android/httpclient/i/f/d
    //   1156: dup
    //   1157: aload 11
    //   1159: aload 14
    //   1161: invokespecial 417	cz/msebera/android/httpclient/i/f/d:<init>	(Lcz/msebera/android/httpclient/x;Lcz/msebera/android/httpclient/i/f/c;)V
    //   1164: astore_1
    //   1165: aload_1
    //   1166: areturn
    //   1167: iconst_1
    //   1168: istore 5
    //   1170: goto -866 -> 304
    //   1173: iload 5
    //   1175: iconst_1
    //   1176: iadd
    //   1177: istore 5
    //   1179: goto -875 -> 304
    //   1182: ldc_w 488
    //   1185: astore 11
    //   1187: goto -285 -> 902
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1190	0	this	e
    //   0	1190	1	paramb	cz.msebera.android.httpclient.e.b.b
    //   0	1190	2	paramo	cz.msebera.android.httpclient.b.d.o
    //   0	1190	3	paramc	cz.msebera.android.httpclient.b.f.c
    //   0	1190	4	paramg	cz.msebera.android.httpclient.b.d.g
    //   178	1000	5	m	int
    //   486	10	6	n	int
    //   188	745	7	l	long
    //   32	1114	9	localObject1	Object
    //   28	1071	10	localObject2	Object
    //   61	1125	11	localObject3	Object
    //   108	460	12	localObject4	Object
    //   819	146	13	localx	x
    //   285	875	14	localc	c
    //   171	311	15	localc1	cz.msebera.android.httpclient.b.b.c
    //   202	848	16	localj	j
    // Exception table:
    //   from	to	target	type
    //   292	301	328	cz/msebera/android/httpclient/i/c/i
    //   310	328	328	cz/msebera/android/httpclient/i/c/i
    //   404	425	328	cz/msebera/android/httpclient/i/c/i
    //   433	470	328	cz/msebera/android/httpclient/i/c/i
    //   470	481	328	cz/msebera/android/httpclient/i/c/i
    //   481	488	328	cz/msebera/android/httpclient/i/c/i
    //   493	502	328	cz/msebera/android/httpclient/i/c/i
    //   507	528	328	cz/msebera/android/httpclient/i/c/i
    //   537	558	328	cz/msebera/android/httpclient/i/c/i
    //   558	564	328	cz/msebera/android/httpclient/i/c/i
    //   572	591	328	cz/msebera/android/httpclient/i/c/i
    //   595	601	328	cz/msebera/android/httpclient/i/c/i
    //   601	609	328	cz/msebera/android/httpclient/i/c/i
    //   613	622	328	cz/msebera/android/httpclient/i/c/i
    //   622	638	328	cz/msebera/android/httpclient/i/c/i
    //   638	678	328	cz/msebera/android/httpclient/i/c/i
    //   678	729	328	cz/msebera/android/httpclient/i/c/i
    //   729	740	328	cz/msebera/android/httpclient/i/c/i
    //   740	797	328	cz/msebera/android/httpclient/i/c/i
    //   797	808	328	cz/msebera/android/httpclient/i/c/i
    //   808	860	328	cz/msebera/android/httpclient/i/c/i
    //   867	902	328	cz/msebera/android/httpclient/i/c/i
    //   902	930	328	cz/msebera/android/httpclient/i/c/i
    //   930	945	328	cz/msebera/android/httpclient/i/c/i
    //   949	986	328	cz/msebera/android/httpclient/i/c/i
    //   986	1012	328	cz/msebera/android/httpclient/i/c/i
    //   1012	1030	328	cz/msebera/android/httpclient/i/c/i
    //   1033	1038	328	cz/msebera/android/httpclient/i/c/i
    //   1049	1103	328	cz/msebera/android/httpclient/i/c/i
    //   1103	1150	328	cz/msebera/android/httpclient/i/c/i
    //   1153	1165	328	cz/msebera/android/httpclient/i/c/i
    //   173	180	354	java/lang/InterruptedException
    //   190	204	354	java/lang/InterruptedException
    //   173	180	373	java/util/concurrent/ExecutionException
    //   190	204	373	java/util/concurrent/ExecutionException
    //   292	301	425	cz/msebera/android/httpclient/p
    //   310	328	425	cz/msebera/android/httpclient/p
    //   404	425	425	cz/msebera/android/httpclient/p
    //   433	470	425	cz/msebera/android/httpclient/p
    //   470	481	425	cz/msebera/android/httpclient/p
    //   481	488	425	cz/msebera/android/httpclient/p
    //   493	502	425	cz/msebera/android/httpclient/p
    //   507	528	425	cz/msebera/android/httpclient/p
    //   537	558	425	cz/msebera/android/httpclient/p
    //   558	564	425	cz/msebera/android/httpclient/p
    //   572	591	425	cz/msebera/android/httpclient/p
    //   595	601	425	cz/msebera/android/httpclient/p
    //   601	609	425	cz/msebera/android/httpclient/p
    //   613	622	425	cz/msebera/android/httpclient/p
    //   622	638	425	cz/msebera/android/httpclient/p
    //   638	678	425	cz/msebera/android/httpclient/p
    //   678	729	425	cz/msebera/android/httpclient/p
    //   729	740	425	cz/msebera/android/httpclient/p
    //   740	797	425	cz/msebera/android/httpclient/p
    //   797	808	425	cz/msebera/android/httpclient/p
    //   808	860	425	cz/msebera/android/httpclient/p
    //   867	902	425	cz/msebera/android/httpclient/p
    //   902	930	425	cz/msebera/android/httpclient/p
    //   930	945	425	cz/msebera/android/httpclient/p
    //   949	986	425	cz/msebera/android/httpclient/p
    //   986	1012	425	cz/msebera/android/httpclient/p
    //   1012	1030	425	cz/msebera/android/httpclient/p
    //   1033	1038	425	cz/msebera/android/httpclient/p
    //   1049	1103	425	cz/msebera/android/httpclient/p
    //   1103	1150	425	cz/msebera/android/httpclient/p
    //   1153	1165	425	cz/msebera/android/httpclient/p
    //   292	301	528	java/io/IOException
    //   310	328	528	java/io/IOException
    //   404	425	528	java/io/IOException
    //   433	470	528	java/io/IOException
    //   470	481	528	java/io/IOException
    //   481	488	528	java/io/IOException
    //   493	502	528	java/io/IOException
    //   507	528	528	java/io/IOException
    //   537	558	528	java/io/IOException
    //   558	564	528	java/io/IOException
    //   572	591	528	java/io/IOException
    //   595	601	528	java/io/IOException
    //   601	609	528	java/io/IOException
    //   613	622	528	java/io/IOException
    //   622	638	528	java/io/IOException
    //   638	678	528	java/io/IOException
    //   678	729	528	java/io/IOException
    //   729	740	528	java/io/IOException
    //   740	797	528	java/io/IOException
    //   797	808	528	java/io/IOException
    //   808	860	528	java/io/IOException
    //   867	902	528	java/io/IOException
    //   902	930	528	java/io/IOException
    //   930	945	528	java/io/IOException
    //   949	986	528	java/io/IOException
    //   986	1012	528	java/io/IOException
    //   1012	1030	528	java/io/IOException
    //   1033	1038	528	java/io/IOException
    //   1049	1103	528	java/io/IOException
    //   1103	1150	528	java/io/IOException
    //   1153	1165	528	java/io/IOException
    //   470	481	536	cz/msebera/android/httpclient/i/f/n
    //   292	301	1041	java/lang/RuntimeException
    //   310	328	1041	java/lang/RuntimeException
    //   404	425	1041	java/lang/RuntimeException
    //   433	470	1041	java/lang/RuntimeException
    //   470	481	1041	java/lang/RuntimeException
    //   481	488	1041	java/lang/RuntimeException
    //   493	502	1041	java/lang/RuntimeException
    //   507	528	1041	java/lang/RuntimeException
    //   537	558	1041	java/lang/RuntimeException
    //   558	564	1041	java/lang/RuntimeException
    //   572	591	1041	java/lang/RuntimeException
    //   595	601	1041	java/lang/RuntimeException
    //   601	609	1041	java/lang/RuntimeException
    //   613	622	1041	java/lang/RuntimeException
    //   622	638	1041	java/lang/RuntimeException
    //   638	678	1041	java/lang/RuntimeException
    //   678	729	1041	java/lang/RuntimeException
    //   729	740	1041	java/lang/RuntimeException
    //   740	797	1041	java/lang/RuntimeException
    //   797	808	1041	java/lang/RuntimeException
    //   808	860	1041	java/lang/RuntimeException
    //   867	902	1041	java/lang/RuntimeException
    //   902	930	1041	java/lang/RuntimeException
    //   930	945	1041	java/lang/RuntimeException
    //   949	986	1041	java/lang/RuntimeException
    //   986	1012	1041	java/lang/RuntimeException
    //   1012	1030	1041	java/lang/RuntimeException
    //   1033	1038	1041	java/lang/RuntimeException
    //   1049	1103	1041	java/lang/RuntimeException
    //   1103	1150	1041	java/lang/RuntimeException
    //   1153	1165	1041	java/lang/RuntimeException
  }
  
  void a(cz.msebera.android.httpclient.a.i parami, j paramj, cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.u paramu, cz.msebera.android.httpclient.b.f.c paramc)
    throws p, IOException
  {
    int m = paramc.p().n();
    cz.msebera.android.httpclient.e.b.f localf = new cz.msebera.android.httpclient.e.b.f(paramb);
    Object localObject = localf.l();
    int i1 = this.k.a(paramb, (cz.msebera.android.httpclient.e.b.e)localObject);
    int n;
    switch (i1)
    {
    default: 
      throw new IllegalStateException("Unknown step indicator " + i1 + " from RouteDirector.");
    case 1: 
      localObject = this.c;
      if (m > 0)
      {
        n = m;
        label134:
        ((o)localObject).a(paramj, paramb, n, paramc);
        localf.a(paramb.j());
      }
      break;
    }
    while (i1 <= 0)
    {
      return;
      n = 0;
      break label134;
      localObject = this.c;
      if (m > 0) {}
      for (n = m;; n = 0)
      {
        ((o)localObject).a(paramj, paramb, n, paramc);
        localf.a(paramb.e(), false);
        break;
      }
      boolean bool = b(parami, paramj, paramb, paramu, paramc);
      this.a.a("Tunnel to target created.");
      localf.b(bool);
      continue;
      n = ((cz.msebera.android.httpclient.e.b.b)localObject).d() - 1;
      bool = a(paramb, n, paramc);
      this.a.a("Tunnel to proxy created.");
      localf.b(paramb.a(n), bool);
      continue;
      this.c.a(paramj, paramb, paramc);
      localf.c(paramb.j());
      continue;
      throw new p("Unable to establish route: planned = " + paramb + "; current = " + localObject);
      this.c.b(paramj, paramb, paramc);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */