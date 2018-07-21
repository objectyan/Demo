package com.baidu.carlife.d.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import b.ab;
import b.p;
import b.u;
import b.y;
import b.y.a;
import com.baidu.carlife.core.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final class e
{
  private static final String a = "network_http";
  private y b;
  private Handler c;
  private a d;
  
  private e()
  {
    Log.i("network_http", "init http manager");
    this.d = new a();
    this.b = new y.a().a(10L, TimeUnit.SECONDS).c(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).a(this.d).a(new HostnameVerifier()
    {
      public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
      {
        return true;
      }
    }).a(b.b()).c();
    this.c = new Handler(Looper.getMainLooper());
  }
  
  public static y a()
  {
    return d().b;
  }
  
  private void a(ab paramab, final c paramc)
  {
    paramc = new b.f()
    {
      /* Error */
      public void a(b.e paramAnonymouse, b.ad paramAnonymousad)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/baidu/carlife/d/a/e$2:b	Lcom/baidu/carlife/d/a/e;
        //   4: aload_0
        //   5: getfield 20	com/baidu/carlife/d/a/e$2:a	Lcom/baidu/carlife/d/a/c;
        //   8: aload_2
        //   9: invokestatic 32	com/baidu/carlife/d/a/f:a	(Lb/ad;)Ljava/util/Map;
        //   12: invokestatic 35	com/baidu/carlife/d/a/e:a	(Lcom/baidu/carlife/d/a/e;Lcom/baidu/carlife/d/a/c;Ljava/util/Map;)V
        //   15: aload_2
        //   16: invokevirtual 41	b/ad:c	()I
        //   19: istore_3
        //   20: aload_2
        //   21: invokevirtual 45	b/ad:d	()Z
        //   24: ifeq +29 -> 53
        //   27: aload_2
        //   28: invokevirtual 49	b/ad:h	()Lb/ae;
        //   31: invokevirtual 55	b/ae:g	()Ljava/lang/String;
        //   34: astore_1
        //   35: aload_0
        //   36: getfield 18	com/baidu/carlife/d/a/e$2:b	Lcom/baidu/carlife/d/a/e;
        //   39: aload_0
        //   40: getfield 20	com/baidu/carlife/d/a/e$2:a	Lcom/baidu/carlife/d/a/c;
        //   43: iload_3
        //   44: aload_1
        //   45: invokestatic 58	com/baidu/carlife/d/a/e:a	(Lcom/baidu/carlife/d/a/e;Lcom/baidu/carlife/d/a/c;ILjava/lang/String;)V
        //   48: aload_2
        //   49: invokevirtual 61	b/ad:close	()V
        //   52: return
        //   53: aload_0
        //   54: getfield 18	com/baidu/carlife/d/a/e$2:b	Lcom/baidu/carlife/d/a/e;
        //   57: aload_0
        //   58: getfield 20	com/baidu/carlife/d/a/e$2:a	Lcom/baidu/carlife/d/a/c;
        //   61: new 63	java/lang/StringBuilder
        //   64: dup
        //   65: invokespecial 64	java/lang/StringBuilder:<init>	()V
        //   68: ldc 66
        //   70: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: iload_3
        //   74: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   77: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   80: invokestatic 79	com/baidu/carlife/d/a/e:a	(Lcom/baidu/carlife/d/a/e;Lcom/baidu/carlife/d/a/c;Ljava/lang/String;)V
        //   83: goto -35 -> 48
        //   86: astore_1
        //   87: aload_0
        //   88: getfield 18	com/baidu/carlife/d/a/e$2:b	Lcom/baidu/carlife/d/a/e;
        //   91: aload_0
        //   92: getfield 20	com/baidu/carlife/d/a/e$2:a	Lcom/baidu/carlife/d/a/c;
        //   95: aload_1
        //   96: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
        //   99: invokestatic 79	com/baidu/carlife/d/a/e:a	(Lcom/baidu/carlife/d/a/e;Lcom/baidu/carlife/d/a/c;Ljava/lang/String;)V
        //   102: aload_2
        //   103: invokevirtual 61	b/ad:close	()V
        //   106: return
        //   107: astore_1
        //   108: aload_2
        //   109: invokevirtual 61	b/ad:close	()V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	2
        //   0	114	1	paramAnonymouse	b.e
        //   0	114	2	paramAnonymousad	b.ad
        //   19	55	3	i	int
        // Exception table:
        //   from	to	target	type
        //   0	48	86	java/lang/Exception
        //   53	83	86	java/lang/Exception
        //   0	48	107	finally
        //   53	83	107	finally
        //   87	102	107	finally
      }
      
      public void a(b.e paramAnonymouse, IOException paramAnonymousIOException)
      {
        e.a(e.this, paramc, paramAnonymousIOException.toString());
      }
    };
    this.b.a(paramab).a(paramc);
  }
  
  private void a(final c paramc, final int paramInt, final String paramString)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (paramc != null) {
          paramc.a(paramInt, paramString);
        }
      }
    });
  }
  
  private void a(final c paramc, final String paramString)
  {
    Log.e("network_http", "error=" + paramString);
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (paramc != null) {
          paramc.a(null, paramString);
        }
      }
    });
  }
  
  private void a(final c paramc, final Map<String, String> paramMap)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        if (paramc != null) {
          paramc.a(paramMap);
        }
      }
    });
  }
  
  public static void a(String paramString)
  {
    Iterator localIterator = d().b.u().f().iterator();
    b.e locale;
    while (localIterator.hasNext())
    {
      locale = (b.e)localIterator.next();
      if (TextUtils.equals(locale.a().a().toString(), paramString))
      {
        locale.c();
        i.e("network_http", "cancel running reuqest, url=" + paramString);
      }
    }
    localIterator = d().b.u().e().iterator();
    while (localIterator.hasNext())
    {
      locale = (b.e)localIterator.next();
      if (TextUtils.equals(locale.a().a().toString(), paramString))
      {
        locale.c();
        i.e("network_http", "cancel queued reuqest, url=" + paramString);
      }
    }
  }
  
  public static void a(String paramString, c paramc)
  {
    paramString = f.a(paramString);
    d().a(paramString, paramc);
  }
  
  public static void a(String paramString1, String paramString2, c paramc)
  {
    Log.i("network_http", "POST url=" + paramString1);
    paramString1 = f.a(paramString1, paramString2);
    d().a(paramString1, paramc);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    Log.i("network_http", "add cookies");
    d().d.a(paramString1, paramString2, paramString3);
  }
  
  public static void a(String paramString, Map<String, String> paramMap, c paramc)
  {
    paramString = f.a(paramString, paramMap);
    d().a(paramString, paramc);
  }
  
  public static void b()
  {
    Log.i("network_http", "cancel all http request");
    d().b.u().d();
  }
  
  public static void b(String paramString, Map<String, String> paramMap, c paramc)
  {
    paramString = f.b(paramString, paramMap);
    d().a(paramString, paramc);
  }
  
  public static void c()
  {
    Log.i("network_http", "clear cookies");
    d().d.a();
  }
  
  public static void c(String paramString, Map<String, String> paramMap, c paramc)
  {
    Log.i("network_http", "POST url=" + paramString);
    paramString = f.c(paramString, paramMap);
    d().a(paramString, paramc);
  }
  
  private static e d()
  {
    return a.a;
  }
  
  private static class a
  {
    public static final e a = new e(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */