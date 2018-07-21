package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.f;
import cz.msebera.android.httpclient.b.f.d;
import cz.msebera.android.httpclient.b.f.n;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@Deprecated
public class p
  implements cz.msebera.android.httpclient.b.j
{
  private final cz.msebera.android.httpclient.b.j a;
  private final w b;
  private final z c;
  
  public p()
  {
    this(new s());
  }
  
  public p(cz.msebera.android.httpclient.b.j paramj)
  {
    this(paramj, new d(), new n());
  }
  
  p(cz.msebera.android.httpclient.b.j paramj, w paramw, z paramz)
  {
    this.a = paramj;
    this.b = paramw;
    this.c = paramz;
  }
  
  public cz.msebera.android.httpclient.l.j a()
  {
    return this.a.a();
  }
  
  public x a(q paramq)
    throws IOException, f
  {
    return a(b(paramq), paramq, (cz.msebera.android.httpclient.n.g)null);
  }
  
  public x a(q paramq, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    return a(b(paramq), paramq, paramg);
  }
  
  public x a(cz.msebera.android.httpclient.r paramr, u paramu)
    throws IOException, f
  {
    return a(paramr, paramu, (cz.msebera.android.httpclient.n.g)null);
  }
  
  /* Error */
  public x a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +100 -> 101
    //   4: aload_2
    //   5: instanceof 64
    //   8: ifeq +114 -> 122
    //   11: new 66	cz/msebera/android/httpclient/i/b/ac
    //   14: dup
    //   15: aload_2
    //   16: checkcast 64	cz/msebera/android/httpclient/o
    //   19: invokespecial 69	cz/msebera/android/httpclient/i/b/ac:<init>	(Lcz/msebera/android/httpclient/o;)V
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 37	cz/msebera/android/httpclient/i/b/p:b	Lcz/msebera/android/httpclient/w;
    //   27: aload_2
    //   28: aload_3
    //   29: invokeinterface 75 3 0
    //   34: aload_0
    //   35: getfield 35	cz/msebera/android/httpclient/i/b/p:a	Lcz/msebera/android/httpclient/b/j;
    //   38: aload_1
    //   39: aload_2
    //   40: aload_3
    //   41: invokeinterface 76 4 0
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 39	cz/msebera/android/httpclient/i/b/p:c	Lcz/msebera/android/httpclient/z;
    //   51: aload_1
    //   52: aload_3
    //   53: invokeinterface 81 3 0
    //   58: getstatic 87	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   61: aload_3
    //   62: ldc 89
    //   64: invokeinterface 92 2 0
    //   69: invokevirtual 96	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +27 -> 99
    //   75: aload_1
    //   76: ldc 98
    //   78: invokeinterface 104 2 0
    //   83: aload_1
    //   84: ldc 106
    //   86: invokeinterface 104 2 0
    //   91: aload_1
    //   92: ldc 108
    //   94: invokeinterface 104 2 0
    //   99: aload_1
    //   100: areturn
    //   101: new 110	cz/msebera/android/httpclient/n/a
    //   104: dup
    //   105: invokespecial 111	cz/msebera/android/httpclient/n/a:<init>	()V
    //   108: astore_3
    //   109: goto -105 -> 4
    //   112: astore_1
    //   113: new 47	cz/msebera/android/httpclient/b/f
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 114	cz/msebera/android/httpclient/b/f:<init>	(Ljava/lang/Throwable;)V
    //   121: athrow
    //   122: new 116	cz/msebera/android/httpclient/i/b/as
    //   125: dup
    //   126: aload_2
    //   127: invokespecial 119	cz/msebera/android/httpclient/i/b/as:<init>	(Lcz/msebera/android/httpclient/u;)V
    //   130: astore_2
    //   131: goto -108 -> 23
    //   134: astore_2
    //   135: aload_1
    //   136: invokeinterface 122 1 0
    //   141: invokestatic 127	cz/msebera/android/httpclient/o/g:b	(Lcz/msebera/android/httpclient/n;)V
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: aload_1
    //   148: invokeinterface 122 1 0
    //   153: invokestatic 127	cz/msebera/android/httpclient/o/g:b	(Lcz/msebera/android/httpclient/n;)V
    //   156: aload_2
    //   157: athrow
    //   158: astore_2
    //   159: aload_1
    //   160: invokeinterface 122 1 0
    //   165: invokestatic 127	cz/msebera/android/httpclient/o/g:b	(Lcz/msebera/android/httpclient/n;)V
    //   168: aload_2
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	p
    //   0	170	1	paramr	cz.msebera.android.httpclient.r
    //   0	170	2	paramu	u
    //   0	170	3	paramg	cz.msebera.android.httpclient.n.g
    // Exception table:
    //   from	to	target	type
    //   4	23	112	cz/msebera/android/httpclient/p
    //   23	47	112	cz/msebera/android/httpclient/p
    //   101	109	112	cz/msebera/android/httpclient/p
    //   122	131	112	cz/msebera/android/httpclient/p
    //   135	146	112	cz/msebera/android/httpclient/p
    //   147	158	112	cz/msebera/android/httpclient/p
    //   159	170	112	cz/msebera/android/httpclient/p
    //   47	99	134	cz/msebera/android/httpclient/p
    //   47	99	146	java/io/IOException
    //   47	99	158	java/lang/RuntimeException
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr)
    throws IOException, f
  {
    return (T)a(b(paramq), paramq, paramr);
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    return (T)a(b(paramq), paramq, paramr, paramg);
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1)
    throws IOException, f
  {
    return (T)a(paramr, paramu, paramr1, null);
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    paramr = a(paramr, paramu, paramg);
    try
    {
      paramu = paramr1.a(paramr);
      return paramu;
    }
    finally
    {
      paramr = paramr.b();
      if (paramr != null) {
        cz.msebera.android.httpclient.o.g.b(paramr);
      }
    }
  }
  
  public c b()
  {
    return this.a.b();
  }
  
  cz.msebera.android.httpclient.r b(q paramq)
  {
    return i.b(paramq.getURI());
  }
  
  public cz.msebera.android.httpclient.b.j c()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */