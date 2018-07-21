package cz.msebera.android.httpclient.i.b.a;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class b
  implements Closeable
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final aq b;
  private final Set<String> c;
  private final j d;
  private final x e;
  
  b(aq paramaq)
  {
    this.b = paramaq;
    this.c = new HashSet();
    this.d = new j();
    this.e = new u();
  }
  
  public b(f paramf)
  {
    this(new af(paramf));
  }
  
  Set<String> a()
  {
    return Collections.unmodifiableSet(this.c);
  }
  
  /* Error */
  public void a(p paramp, cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg, cz.msebera.android.httpclient.b.a.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	cz/msebera/android/httpclient/i/b/a/b:d	Lcz/msebera/android/httpclient/i/b/a/j;
    //   6: aload 4
    //   8: invokevirtual 76	cz/msebera/android/httpclient/b/f/c:v	()Lcz/msebera/android/httpclient/r;
    //   11: aload_3
    //   12: aload 6
    //   14: invokevirtual 79	cz/msebera/android/httpclient/i/b/a/j:a	(Lcz/msebera/android/httpclient/r;Lcz/msebera/android/httpclient/u;Lcz/msebera/android/httpclient/b/a/d;)Ljava/lang/String;
    //   17: astore 7
    //   19: aload_0
    //   20: getfield 40	cz/msebera/android/httpclient/i/b/a/b:c	Ljava/util/Set;
    //   23: aload 7
    //   25: invokeinterface 85 2 0
    //   30: ifne +56 -> 86
    //   33: new 87	cz/msebera/android/httpclient/i/b/a/a
    //   36: dup
    //   37: aload_0
    //   38: aload_1
    //   39: aload_2
    //   40: aload_3
    //   41: aload 4
    //   43: aload 5
    //   45: aload 6
    //   47: aload 7
    //   49: aload_0
    //   50: getfield 50	cz/msebera/android/httpclient/i/b/a/b:e	Lcz/msebera/android/httpclient/i/b/a/x;
    //   53: aload 7
    //   55: invokeinterface 92 2 0
    //   60: invokespecial 95	cz/msebera/android/httpclient/i/b/a/a:<init>	(Lcz/msebera/android/httpclient/i/b/a/b;Lcz/msebera/android/httpclient/i/b/a/p;Lcz/msebera/android/httpclient/e/b/b;Lcz/msebera/android/httpclient/b/d/o;Lcz/msebera/android/httpclient/b/f/c;Lcz/msebera/android/httpclient/b/d/g;Lcz/msebera/android/httpclient/b/a/d;Ljava/lang/String;I)V
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 35	cz/msebera/android/httpclient/i/b/a/b:b	Lcz/msebera/android/httpclient/i/b/a/aq;
    //   68: aload_1
    //   69: invokeinterface 100 2 0
    //   74: aload_0
    //   75: getfield 40	cz/msebera/android/httpclient/i/b/a/b:c	Ljava/util/Set;
    //   78: aload 7
    //   80: invokeinterface 103 2 0
    //   85: pop
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 33	cz/msebera/android/httpclient/i/b/a/b:a	Lcz/msebera/android/httpclient/h/b;
    //   94: new 105	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   101: ldc 108
    //   103: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 7
    //   108: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 114
    //   113: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokevirtual 123	cz/msebera/android/httpclient/h/b:a	(Ljava/lang/Object;)V
    //   126: goto -40 -> 86
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	b
    //   0	134	1	paramp	p
    //   0	134	2	paramb	cz.msebera.android.httpclient.e.b.b
    //   0	134	3	paramo	cz.msebera.android.httpclient.b.d.o
    //   0	134	4	paramc	cz.msebera.android.httpclient.b.f.c
    //   0	134	5	paramg	cz.msebera.android.httpclient.b.d.g
    //   0	134	6	paramd	cz.msebera.android.httpclient.b.a.d
    //   17	90	7	str	String
    // Exception table:
    //   from	to	target	type
    //   64	86	89	java/util/concurrent/RejectedExecutionException
    //   2	64	129	finally
    //   64	86	129	finally
    //   90	126	129	finally
  }
  
  void a(String paramString)
  {
    try
    {
      this.c.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  void b(String paramString)
  {
    this.e.b(paramString);
  }
  
  void c(String paramString)
  {
    this.e.c(paramString);
  }
  
  public void close()
    throws IOException
  {
    this.b.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */