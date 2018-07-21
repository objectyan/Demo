package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InterruptedIOException;

public class il
  extends je
{
  private static il a;
  private boolean c;
  private il d;
  private long e;
  
  private static void a(il paramil, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          a = new il();
          new a().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramil.e = (Math.min(paramLong, paramil.c() - l) + l);
          paramLong = paramil.e;
          localil = a;
          if ((localil.d != null) && (paramLong - l >= localil.d.e - l)) {
            break label177;
          }
          paramil.d = localil.d;
          localil.d = paramil;
          if (localil == a) {
            il.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramil.e = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label169;
        }
      }
      finally {}
      paramil.e = paramil.c();
      continue;
      label169:
      throw new AssertionError();
      label177:
      il localil = localil.d;
    }
  }
  
  /* Error */
  private static boolean a(il paramil)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	com/indooratlas/android/sdk/_internal/il:a	Lcom/indooratlas/android/sdk/_internal/il;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +39 -> 47
    //   11: aload_2
    //   12: getfield 48	com/indooratlas/android/sdk/_internal/il:d	Lcom/indooratlas/android/sdk/_internal/il;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 48	com/indooratlas/android/sdk/_internal/il:d	Lcom/indooratlas/android/sdk/_internal/il;
    //   24: putfield 48	com/indooratlas/android/sdk/_internal/il:d	Lcom/indooratlas/android/sdk/_internal/il;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 48	com/indooratlas/android/sdk/_internal/il:d	Lcom/indooratlas/android/sdk/_internal/il;
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: aload_2
    //   40: getfield 48	com/indooratlas/android/sdk/_internal/il:d	Lcom/indooratlas/android/sdk/_internal/il;
    //   43: astore_2
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramil	il
    //   33	16	1	bool	boolean
    //   6	38	2	localil	il
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private static il g()
    throws InterruptedException
  {
    il localil1 = null;
    for (;;)
    {
      il localil2;
      try
      {
        localil2 = a.d;
        if (localil2 == null)
        {
          il.class.wait();
          return localil1;
        }
        long l1 = System.nanoTime();
        l1 = localil2.e - l1;
        if (l1 > 0L)
        {
          long l2 = l1 / 1000000L;
          il.class.wait(l2, (int)(l1 - 1000000L * l2));
          continue;
        }
        a.d = localil2.d;
      }
      finally {}
      localil2.d = null;
      Object localObject2 = localil2;
    }
  }
  
  public IOException a(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public void a() {}
  
  final void a(boolean paramBoolean)
    throws IOException
  {
    if ((b_()) && (paramBoolean)) {
      throw a(null);
    }
  }
  
  public final void a_()
  {
    if (this.c) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = c_();
    boolean bool = d_();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.c = true;
    a(this, l, bool);
  }
  
  final IOException b(IOException paramIOException)
    throws IOException
  {
    if (!b_()) {
      return paramIOException;
    }
    return a(paramIOException);
  }
  
  public final boolean b_()
  {
    if (!this.c) {
      return false;
    }
    this.c = false;
    return a(this);
  }
  
  static final class a
    extends Thread
  {
    public a()
    {
      super();
      setDaemon(true);
    }
    
    public final void run()
    {
      try
      {
        for (;;)
        {
          il localil = il.e();
          if (localil != null) {
            localil.a();
          }
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */