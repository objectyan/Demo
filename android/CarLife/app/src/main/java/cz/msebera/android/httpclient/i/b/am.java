package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.o;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.i.i;
import cz.msebera.android.httpclient.o.a;
import java.util.concurrent.TimeUnit;

@ThreadSafe
class am
  extends m
{
  private final o a;
  private final cz.msebera.android.httpclient.i.f.f c;
  private final cz.msebera.android.httpclient.l.j d;
  
  public am(o paramo)
  {
    this.a = ((o)a.a(paramo, "HTTP connection manager"));
    this.c = new cz.msebera.android.httpclient.i.f.f(new cz.msebera.android.httpclient.n.m(), paramo, i.a, r.a);
    this.d = new cz.msebera.android.httpclient.l.b();
  }
  
  public cz.msebera.android.httpclient.l.j a()
  {
    return this.d;
  }
  
  /* Error */
  protected cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.r paramr, cz.msebera.android.httpclient.u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws java.io.IOException, cz.msebera.android.httpclient.b.f
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 67
    //   3: invokestatic 25	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc 69
    //   10: invokestatic 25	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   13: pop
    //   14: aconst_null
    //   15: astore 4
    //   17: aload_2
    //   18: instanceof 71
    //   21: ifeq +9 -> 30
    //   24: aload_2
    //   25: checkcast 71	cz/msebera/android/httpclient/b/d/g
    //   28: astore 4
    //   30: aload_2
    //   31: invokestatic 76	cz/msebera/android/httpclient/b/d/o:a	(Lcz/msebera/android/httpclient/u;)Lcz/msebera/android/httpclient/b/d/o;
    //   34: astore 5
    //   36: aload_3
    //   37: ifnull +61 -> 98
    //   40: aload_3
    //   41: invokestatic 81	cz/msebera/android/httpclient/b/f/c:b	(Lcz/msebera/android/httpclient/n/g;)Lcz/msebera/android/httpclient/b/f/c;
    //   44: astore_3
    //   45: new 83	cz/msebera/android/httpclient/e/b/b
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 86	cz/msebera/android/httpclient/e/b/b:<init>	(Lcz/msebera/android/httpclient/r;)V
    //   53: astore 6
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_2
    //   58: instanceof 88
    //   61: ifeq +13 -> 74
    //   64: aload_2
    //   65: checkcast 88	cz/msebera/android/httpclient/b/d/d
    //   68: invokeinterface 92 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +8 -> 83
    //   78: aload_3
    //   79: aload_1
    //   80: invokevirtual 95	cz/msebera/android/httpclient/b/f/c:a	(Lcz/msebera/android/httpclient/b/b/c;)V
    //   83: aload_0
    //   84: getfield 49	cz/msebera/android/httpclient/i/b/am:c	Lcz/msebera/android/httpclient/i/f/f;
    //   87: aload 6
    //   89: aload 5
    //   91: aload_3
    //   92: aload 4
    //   94: invokevirtual 98	cz/msebera/android/httpclient/i/f/f:a	(Lcz/msebera/android/httpclient/e/b/b;Lcz/msebera/android/httpclient/b/d/o;Lcz/msebera/android/httpclient/b/f/c;Lcz/msebera/android/httpclient/b/d/g;)Lcz/msebera/android/httpclient/b/d/c;
    //   97: areturn
    //   98: new 100	cz/msebera/android/httpclient/n/a
    //   101: dup
    //   102: invokespecial 101	cz/msebera/android/httpclient/n/a:<init>	()V
    //   105: astore_3
    //   106: goto -66 -> 40
    //   109: astore_1
    //   110: new 63	cz/msebera/android/httpclient/b/f
    //   113: dup
    //   114: aload_1
    //   115: invokespecial 104	cz/msebera/android/httpclient/b/f:<init>	(Ljava/lang/Throwable;)V
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	am
    //   0	119	1	paramr	cz.msebera.android.httpclient.r
    //   0	119	2	paramu	cz.msebera.android.httpclient.u
    //   0	119	3	paramg	cz.msebera.android.httpclient.n.g
    //   15	78	4	localg	cz.msebera.android.httpclient.b.d.g
    //   34	56	5	localo	cz.msebera.android.httpclient.b.d.o
    //   53	35	6	localb	cz.msebera.android.httpclient.e.b.b
    // Exception table:
    //   from	to	target	type
    //   30	36	109	cz/msebera/android/httpclient/p
    //   40	55	109	cz/msebera/android/httpclient/p
    //   57	74	109	cz/msebera/android/httpclient/p
    //   78	83	109	cz/msebera/android/httpclient/p
    //   83	98	109	cz/msebera/android/httpclient/p
    //   98	106	109	cz/msebera/android/httpclient/p
  }
  
  public c b()
  {
    new c()
    {
      public cz.msebera.android.httpclient.e.c.j a()
      {
        throw new UnsupportedOperationException();
      }
      
      public cz.msebera.android.httpclient.e.f a(cz.msebera.android.httpclient.e.b.b paramAnonymousb, Object paramAnonymousObject)
      {
        throw new UnsupportedOperationException();
      }
      
      public void a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        am.a(am.this).a(paramAnonymousLong, paramAnonymousTimeUnit);
      }
      
      public void a(t paramAnonymoust, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        throw new UnsupportedOperationException();
      }
      
      public void b()
      {
        am.a(am.this).a();
      }
      
      public void c()
      {
        am.a(am.this).b();
      }
    };
  }
  
  public void close()
  {
    this.a.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */