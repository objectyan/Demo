package b.a.d;

import b.a;
import b.ab;
import b.ab.a;
import b.ac;
import b.ad;
import b.af;
import b.b;
import b.u;
import b.v;
import b.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j
  implements v
{
  private static final int a = 20;
  private final y b;
  private final boolean c;
  private b.a.c.g d;
  private Object e;
  private volatile boolean f;
  
  public j(y paramy, boolean paramBoolean)
  {
    this.b = paramy;
    this.c = paramBoolean;
  }
  
  private a a(u paramu)
  {
    SSLSocketFactory localSSLSocketFactory = null;
    HostnameVerifier localHostnameVerifier = null;
    b.g localg = null;
    if (paramu.d())
    {
      localSSLSocketFactory = this.b.l();
      localHostnameVerifier = this.b.m();
      localg = this.b.n();
    }
    return new a(paramu.i(), paramu.j(), this.b.j(), this.b.k(), localSSLSocketFactory, localHostnameVerifier, localg, this.b.p(), this.b.e(), this.b.v(), this.b.w(), this.b.f());
  }
  
  private ab a(ad paramad)
    throws IOException
  {
    if (paramad == null) {
      throw new IllegalStateException();
    }
    Object localObject1 = this.d.b();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((b.j)localObject1).a();
      int i = paramad.c();
      localObject2 = paramad.a().b();
      switch (i)
      {
      }
    }
    label407:
    do
    {
      u localu;
      do
      {
        do
        {
          do
          {
            return null;
            localObject1 = null;
            break;
            if (localObject1 != null) {}
            for (localObject2 = ((af)localObject1).b(); ((Proxy)localObject2).type() != Proxy.Type.HTTP; localObject2 = this.b.e()) {
              throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            return this.b.p().a((af)localObject1, paramad);
            return this.b.o().a((af)localObject1, paramad);
          } while (((!((String)localObject2).equals("GET")) && (!((String)localObject2).equals("HEAD"))) || (!this.b.s()));
          localObject1 = paramad.b("Location");
        } while (localObject1 == null);
        localu = paramad.a().a().e((String)localObject1);
      } while ((localu == null) || ((!localu.c().equals(paramad.a().a().c())) && (!this.b.r())));
      ab.a locala = paramad.a().f();
      boolean bool;
      if (f.c((String)localObject2))
      {
        bool = f.d((String)localObject2);
        if (!f.e((String)localObject2)) {
          break label407;
        }
        locala.a("GET", null);
        if (!bool)
        {
          locala.b("Transfer-Encoding");
          locala.b("Content-Length");
          locala.b("Content-Type");
        }
      }
      if (!a(paramad, localu)) {
        locala.b("Authorization");
      }
      return locala.a(localu).d();
      if (bool) {}
      for (localObject1 = paramad.a().d();; localObject1 = null)
      {
        locala.a((String)localObject2, (ac)localObject1);
        break;
      }
    } while ((paramad.a().d() instanceof l));
    return paramad.a();
  }
  
  private boolean a(ad paramad, u paramu)
  {
    paramad = paramad.a().a();
    return (paramad.i().equals(paramu.i())) && (paramad.j() == paramu.j()) && (paramad.c().equals(paramu.c()));
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException))
      {
        if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean)) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    } while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean, ab paramab)
  {
    this.d.a(paramIOException);
    if (!this.b.t()) {}
    while (((paramBoolean) && ((paramab.d() instanceof l))) || (!a(paramIOException, paramBoolean)) || (!this.d.f())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public ad a(b.v.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 248 1 0
    //   6: astore 4
    //   8: aload_0
    //   9: new 95	b/a/c/g
    //   12: dup
    //   13: aload_0
    //   14: getfield 25	b/a/d/j:b	Lb/y;
    //   17: invokevirtual 252	b/y:q	()Lb/k;
    //   20: aload_0
    //   21: aload 4
    //   23: invokevirtual 166	b/ab:a	()Lb/u;
    //   26: invokespecial 254	b/a/d/j:a	(Lb/u;)Lb/a;
    //   29: aload_0
    //   30: getfield 256	b/a/d/j:e	Ljava/lang/Object;
    //   33: invokespecial 259	b/a/c/g:<init>	(Lb/k;Lb/a;Ljava/lang/Object;)V
    //   36: putfield 93	b/a/d/j:d	Lb/a/c/g;
    //   39: iconst_0
    //   40: istore_2
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_0
    //   45: getfield 261	b/a/d/j:f	Z
    //   48: ifeq +21 -> 69
    //   51: aload_0
    //   52: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   55: invokevirtual 263	b/a/c/g:c	()V
    //   58: new 88	java/io/IOException
    //   61: dup
    //   62: ldc_w 265
    //   65: invokespecial 266	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: aload_1
    //   70: checkcast 268	b/a/d/g
    //   73: aload 4
    //   75: aload_0
    //   76: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 271	b/a/d/g:a	(Lb/ab;Lb/a/c/g;Lb/a/d/c;Lb/j;)Lb/ad;
    //   84: astore 6
    //   86: iconst_0
    //   87: ifeq +18 -> 105
    //   90: aload_0
    //   91: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   94: aconst_null
    //   95: invokevirtual 235	b/a/c/g:a	(Ljava/io/IOException;)V
    //   98: aload_0
    //   99: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   102: invokevirtual 263	b/a/c/g:c	()V
    //   105: aload 6
    //   107: astore 4
    //   109: aload 5
    //   111: ifnull +28 -> 139
    //   114: aload 6
    //   116: invokevirtual 274	b/ad:i	()Lb/ad$a;
    //   119: aload 5
    //   121: invokevirtual 274	b/ad:i	()Lb/ad$a;
    //   124: aconst_null
    //   125: invokevirtual 279	b/ad$a:a	(Lb/ae;)Lb/ad$a;
    //   128: invokevirtual 282	b/ad$a:a	()Lb/ad;
    //   131: invokevirtual 285	b/ad$a:c	(Lb/ad;)Lb/ad$a;
    //   134: invokevirtual 282	b/ad$a:a	()Lb/ad;
    //   137: astore 4
    //   139: aload_0
    //   140: aload 4
    //   142: invokespecial 287	b/a/d/j:a	(Lb/ad;)Lb/ab;
    //   145: astore 6
    //   147: aload 6
    //   149: ifnonnull +141 -> 290
    //   152: aload_0
    //   153: getfield 27	b/a/d/j:c	Z
    //   156: ifne +10 -> 166
    //   159: aload_0
    //   160: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   163: invokevirtual 263	b/a/c/g:c	()V
    //   166: aload 4
    //   168: areturn
    //   169: astore 6
    //   171: aload_0
    //   172: aload 6
    //   174: invokevirtual 290	b/a/c/e:a	()Ljava/io/IOException;
    //   177: iconst_0
    //   178: aload 4
    //   180: invokespecial 292	b/a/d/j:a	(Ljava/io/IOException;ZLb/ab;)Z
    //   183: ifne +31 -> 214
    //   186: aload 6
    //   188: invokevirtual 290	b/a/c/e:a	()Ljava/io/IOException;
    //   191: athrow
    //   192: astore_1
    //   193: iconst_1
    //   194: ifeq +18 -> 212
    //   197: aload_0
    //   198: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   201: aconst_null
    //   202: invokevirtual 235	b/a/c/g:a	(Ljava/io/IOException;)V
    //   205: aload_0
    //   206: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   209: invokevirtual 263	b/a/c/g:c	()V
    //   212: aload_1
    //   213: athrow
    //   214: iconst_0
    //   215: ifeq -171 -> 44
    //   218: aload_0
    //   219: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   222: aconst_null
    //   223: invokevirtual 235	b/a/c/g:a	(Ljava/io/IOException;)V
    //   226: aload_0
    //   227: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   230: invokevirtual 263	b/a/c/g:c	()V
    //   233: goto -189 -> 44
    //   236: astore 6
    //   238: aload 6
    //   240: instanceof 294
    //   243: ifne +20 -> 263
    //   246: iconst_1
    //   247: istore_3
    //   248: aload_0
    //   249: aload 6
    //   251: iload_3
    //   252: aload 4
    //   254: invokespecial 292	b/a/d/j:a	(Ljava/io/IOException;ZLb/ab;)Z
    //   257: ifne +11 -> 268
    //   260: aload 6
    //   262: athrow
    //   263: iconst_0
    //   264: istore_3
    //   265: goto -17 -> 248
    //   268: iconst_0
    //   269: ifeq -225 -> 44
    //   272: aload_0
    //   273: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   276: aconst_null
    //   277: invokevirtual 235	b/a/c/g:a	(Ljava/io/IOException;)V
    //   280: aload_0
    //   281: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   284: invokevirtual 263	b/a/c/g:c	()V
    //   287: goto -243 -> 44
    //   290: aload 4
    //   292: invokevirtual 298	b/ad:h	()Lb/ae;
    //   295: invokestatic 303	b/a/c:a	(Ljava/io/Closeable;)V
    //   298: iload_2
    //   299: iconst_1
    //   300: iadd
    //   301: istore_2
    //   302: iload_2
    //   303: bipush 20
    //   305: if_icmple +38 -> 343
    //   308: aload_0
    //   309: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   312: invokevirtual 263	b/a/c/g:c	()V
    //   315: new 132	java/net/ProtocolException
    //   318: dup
    //   319: new 305	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 308
    //   329: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: iload_2
    //   333: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokespecial 137	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   342: athrow
    //   343: aload 6
    //   345: invokevirtual 213	b/ab:d	()Lb/ac;
    //   348: instanceof 215
    //   351: ifeq +26 -> 377
    //   354: aload_0
    //   355: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   358: invokevirtual 263	b/a/c/g:c	()V
    //   361: new 320	java/net/HttpRetryException
    //   364: dup
    //   365: ldc_w 322
    //   368: aload 4
    //   370: invokevirtual 107	b/ad:c	()I
    //   373: invokespecial 325	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   376: athrow
    //   377: aload_0
    //   378: aload 4
    //   380: aload 6
    //   382: invokevirtual 166	b/ab:a	()Lb/u;
    //   385: invokespecial 203	b/a/d/j:a	(Lb/ad;Lb/u;)Z
    //   388: ifne +52 -> 440
    //   391: aload_0
    //   392: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   395: invokevirtual 263	b/a/c/g:c	()V
    //   398: aload_0
    //   399: new 95	b/a/c/g
    //   402: dup
    //   403: aload_0
    //   404: getfield 25	b/a/d/j:b	Lb/y;
    //   407: invokevirtual 252	b/y:q	()Lb/k;
    //   410: aload_0
    //   411: aload 6
    //   413: invokevirtual 166	b/ab:a	()Lb/u;
    //   416: invokespecial 254	b/a/d/j:a	(Lb/u;)Lb/a;
    //   419: aload_0
    //   420: getfield 256	b/a/d/j:e	Ljava/lang/Object;
    //   423: invokespecial 259	b/a/c/g:<init>	(Lb/k;Lb/a;Ljava/lang/Object;)V
    //   426: putfield 93	b/a/d/j:d	Lb/a/c/g;
    //   429: aload 4
    //   431: astore 5
    //   433: aload 6
    //   435: astore 4
    //   437: goto -393 -> 44
    //   440: aload_0
    //   441: getfield 93	b/a/d/j:d	Lb/a/c/g;
    //   444: invokevirtual 328	b/a/c/g:a	()Lb/a/d/c;
    //   447: ifnull -18 -> 429
    //   450: new 90	java/lang/IllegalStateException
    //   453: dup
    //   454: new 305	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 330
    //   464: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 4
    //   469: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: ldc_w 335
    //   475: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokespecial 336	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   484: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	j
    //   0	485	1	parama	b.v.a
    //   40	293	2	i	int
    //   247	18	3	bool	boolean
    //   6	462	4	localObject1	Object
    //   42	390	5	localObject2	Object
    //   84	64	6	localObject3	Object
    //   169	18	6	locale	b.a.c.e
    //   236	198	6	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   69	86	169	b/a/c/e
    //   69	86	192	finally
    //   171	192	192	finally
    //   238	246	192	finally
    //   248	263	192	finally
    //   69	86	236	java/io/IOException
  }
  
  public void a()
  {
    this.f = true;
    b.a.c.g localg = this.d;
    if (localg != null) {
      localg.e();
    }
  }
  
  public void a(Object paramObject)
  {
    this.e = paramObject;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public b.a.c.g c()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */