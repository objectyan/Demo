package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class am<R>
  implements aa<R>
{
  fr a;
  z<R> b;
  
  am(fr paramfr, z<R> paramz)
  {
    this.a = paramfr;
    this.b = paramz;
  }
  
  final x a(final gm paramgm)
  {
    new x()
    {
      public final String a()
      {
        return paramgm.a().a().toString();
      }
      
      public final int b()
      {
        return paramgm.b();
      }
      
      public final String c()
      {
        return paramgm.d();
      }
      
      public final String d()
        throws IOException
      {
        return paramgm.f().d();
      }
      
      public final boolean e()
      {
        return paramgm.c();
      }
      
      public final String toString()
      {
        return "HttpResponse{code: " + paramgm.b() + "}";
      }
    };
  }
  
  @TargetApi(11)
  public final void a()
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        am.this.a.c();
        localCountDownLatch.countDown();
      }
    };
    if (Build.VERSION.SDK_INT >= 11) {
      AsyncTask.THREAD_POOL_EXECUTOR.execute(local1);
    }
    for (;;)
    {
      try
      {
        localCountDownLatch.await(3L, TimeUnit.SECONDS);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str = an.d;
      }
      Executors.newSingleThreadExecutor().submit(local1);
    }
  }
  
  public final void a(final ag<R> paramag)
  {
    this.a.a(new fs()
    {
      public final void a(fr paramAnonymousfr, IOException paramAnonymousIOException)
      {
        paramag.a(ad.a(paramAnonymousfr.a().a().toString(), paramAnonymousIOException));
      }
      
      public final void a(gm paramAnonymousgm)
        throws IOException
      {
        paramAnonymousgm = am.this.a(paramAnonymousgm);
        if (z.b(paramAnonymousgm))
        {
          paramag.a(ad.a(paramAnonymousgm.a(), paramAnonymousgm));
          return;
        }
        try
        {
          paramag.a(ae.a(paramAnonymousgm, am.this.b.a(paramAnonymousgm)));
          return;
        }
        catch (Throwable localThrowable)
        {
          paramag.a(ad.a(paramAnonymousgm.a(), paramAnonymousgm, localThrowable));
        }
      }
    });
  }
  
  public final boolean b()
  {
    return this.a.d();
  }
  
  /* Error */
  public final ae<R> c()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 25	com/indooratlas/android/sdk/_internal/am:a	Lcom/indooratlas/android/sdk/_internal/fr;
    //   5: invokeinterface 118 1 0
    //   10: invokevirtual 120	com/indooratlas/android/sdk/_internal/am:a	(Lcom/indooratlas/android/sdk/_internal/gm;)Lcom/indooratlas/android/sdk/_internal/x;
    //   13: astore_2
    //   14: aload_2
    //   15: invokestatic 125	com/indooratlas/android/sdk/_internal/z:b	(Lcom/indooratlas/android/sdk/_internal/x;)Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq +41 -> 61
    //   23: aload_2
    //   24: invokevirtual 130	com/indooratlas/android/sdk/_internal/x:a	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 135	com/indooratlas/android/sdk/_internal/ad:a	(Ljava/lang/String;Lcom/indooratlas/android/sdk/_internal/x;)Lcom/indooratlas/android/sdk/_internal/ad;
    //   31: aload_0
    //   32: getfield 27	com/indooratlas/android/sdk/_internal/am:b	Lcom/indooratlas/android/sdk/_internal/z;
    //   35: aload_2
    //   36: invokevirtual 138	com/indooratlas/android/sdk/_internal/z:a	(Lcom/indooratlas/android/sdk/_internal/x;)Ljava/lang/Object;
    //   39: invokestatic 143	com/indooratlas/android/sdk/_internal/ae:a	(Lcom/indooratlas/android/sdk/_internal/ad;Ljava/lang/Object;)Lcom/indooratlas/android/sdk/_internal/ae;
    //   42: astore_3
    //   43: aload_3
    //   44: areturn
    //   45: astore_3
    //   46: aload_2
    //   47: invokevirtual 130	com/indooratlas/android/sdk/_internal/x:a	()Ljava/lang/String;
    //   50: aload_2
    //   51: invokestatic 135	com/indooratlas/android/sdk/_internal/ad:a	(Ljava/lang/String;Lcom/indooratlas/android/sdk/_internal/x;)Lcom/indooratlas/android/sdk/_internal/ad;
    //   54: aconst_null
    //   55: invokestatic 143	com/indooratlas/android/sdk/_internal/ae:a	(Lcom/indooratlas/android/sdk/_internal/ad;Ljava/lang/Object;)Lcom/indooratlas/android/sdk/_internal/ae;
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 27	com/indooratlas/android/sdk/_internal/am:b	Lcom/indooratlas/android/sdk/_internal/z;
    //   66: aload_2
    //   67: invokevirtual 138	com/indooratlas/android/sdk/_internal/z:a	(Lcom/indooratlas/android/sdk/_internal/x;)Ljava/lang/Object;
    //   70: invokestatic 146	com/indooratlas/android/sdk/_internal/ae:a	(Lcom/indooratlas/android/sdk/_internal/x;Ljava/lang/Object;)Lcom/indooratlas/android/sdk/_internal/ae;
    //   73: astore_3
    //   74: aload_3
    //   75: areturn
    //   76: astore_3
    //   77: aload_2
    //   78: invokevirtual 130	com/indooratlas/android/sdk/_internal/x:a	()Ljava/lang/String;
    //   81: aload_2
    //   82: aload_3
    //   83: invokestatic 149	com/indooratlas/android/sdk/_internal/ad:a	(Ljava/lang/String;Lcom/indooratlas/android/sdk/_internal/x;Ljava/lang/Throwable;)Lcom/indooratlas/android/sdk/_internal/ad;
    //   86: aconst_null
    //   87: invokestatic 143	com/indooratlas/android/sdk/_internal/ae:a	(Lcom/indooratlas/android/sdk/_internal/ad;Ljava/lang/Object;)Lcom/indooratlas/android/sdk/_internal/ae;
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_2
    //   94: aconst_null
    //   95: aload_2
    //   96: invokestatic 152	com/indooratlas/android/sdk/_internal/ad:a	(Ljava/lang/String;Ljava/io/IOException;)Lcom/indooratlas/android/sdk/_internal/ad;
    //   99: aconst_null
    //   100: invokestatic 143	com/indooratlas/android/sdk/_internal/ae:a	(Lcom/indooratlas/android/sdk/_internal/ad;Ljava/lang/Object;)Lcom/indooratlas/android/sdk/_internal/ae;
    //   103: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	am
    //   18	2	1	bool	boolean
    //   13	79	2	localObject	Object
    //   93	3	2	localIOException	IOException
    //   42	2	3	localae1	ae
    //   45	1	3	localThrowable1	Throwable
    //   73	2	3	localae2	ae
    //   76	7	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	43	45	java/lang/Throwable
    //   61	74	76	java/lang/Throwable
    //   0	19	93	java/io/IOException
    //   23	43	93	java/io/IOException
    //   46	59	93	java/io/IOException
    //   61	74	93	java/io/IOException
    //   77	91	93	java/io/IOException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */