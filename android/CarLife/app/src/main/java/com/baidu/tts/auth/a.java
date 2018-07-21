package com.baidu.tts.auth;

import com.baidu.tts.b.a.b.e.b;
import com.baidu.tts.b.a.b.f.b;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.l;
import com.baidu.tts.f.m;
import com.baidu.tts.f.n;
import com.baidu.tts.m.j;
import com.baidu.tts.tools.StringTool;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a
{
  private static volatile a a = null;
  private com.baidu.tts.k.c<c, c.a> b = new com.baidu.tts.k.c();
  private com.baidu.tts.k.c<b, b.a> c = new com.baidu.tts.k.c();
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private <T> T a(Callable<T> paramCallable, long paramLong)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (T)a(paramCallable).get(paramLong, TimeUnit.MILLISECONDS);
  }
  
  private <T> FutureTask<T> a(Callable<T> paramCallable)
  {
    paramCallable = new FutureTask(paramCallable);
    new Thread(paramCallable).start();
    return paramCallable;
  }
  
  public AuthInfo a(m paramm, j paramj)
  {
    paramj = paramj.a();
    AuthInfo localAuthInfo = new AuthInfo();
    localAuthInfo.setTtsEnum(paramm);
    switch (3.a[paramm.ordinal()])
    {
    default: 
      return localAuthInfo;
    case 1: 
      localAuthInfo.setOnlineResult(a(paramj.a()));
      return localAuthInfo;
    case 2: 
      localAuthInfo.setOfflineResult(a(paramj.b()));
      return localAuthInfo;
    }
    return a(paramj);
  }
  
  public AuthInfo a(final com.baidu.tts.m.b paramb)
  {
    LoggerProxy.d("AuthClient", "enter authMix");
    localObject1 = new CountDownLatch(2);
    localObject2 = new FutureTask(new Callable()
    {
      public c.a a()
        throws Exception
      {
        try
        {
          Object localObject1 = paramb.a();
          localObject1 = a.this.a((f.b)localObject1);
          return (c.a)localObject1;
        }
        finally
        {
          localObject1.countDown();
        }
      }
    });
    localFutureTask = new FutureTask(new Callable()
    {
      public b.a a()
        throws Exception
      {
        try
        {
          Object localObject1 = paramb.b();
          localObject1 = a.this.a((e.b)localObject1);
          return (b.a)localObject1;
        }
        finally
        {
          localObject1.countDown();
        }
      }
    });
    new Thread((Runnable)localObject2).start();
    new Thread(localFutureTask).start();
    try
    {
      LoggerProxy.d("AuthClient", "+ await");
      ((CountDownLatch)localObject1).await();
      LoggerProxy.d("AuthClient", "- await");
      localObject1 = new c.a();
      LoggerProxy.d("AuthClient", "+ mix online get onlineResult=" + localObject1);
      try
      {
        paramb = (c.a)((FutureTask)localObject2).get();
        localObject1 = paramb;
      }
      catch (InterruptedException paramb)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
          ((FutureTask)localObject2).cancel(true);
          ((c.a)localObject1).a(com.baidu.tts.h.a.c.a().a(n.d, paramb));
        }
      }
      catch (ExecutionException paramb)
      {
        for (;;)
        {
          ((c.a)localObject1).a(com.baidu.tts.h.a.c.a().a(n.e, paramb.getCause()));
        }
      }
      catch (CancellationException paramb)
      {
        for (;;)
        {
          ((c.a)localObject1).a(com.baidu.tts.h.a.c.a().a(n.p, paramb));
        }
      }
      LoggerProxy.d("AuthClient", "- online get");
      paramb = new b.a();
      LoggerProxy.d("AuthClient", "+ mix offline get offlineResult=" + paramb);
      try
      {
        localObject2 = (b.a)localFutureTask.get();
        paramb = (com.baidu.tts.m.b)localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
          localFutureTask.cancel(true);
          paramb.a(com.baidu.tts.h.a.c.a().a(n.v, localInterruptedException));
        }
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;)
        {
          paramb.a(com.baidu.tts.h.a.c.a().a(n.w, localExecutionException.getCause()));
        }
      }
      catch (CancellationException localCancellationException)
      {
        for (;;)
        {
          paramb.a(com.baidu.tts.h.a.c.a().a(n.I, localCancellationException));
        }
      }
      LoggerProxy.d("AuthClient", "- offline get");
      localObject2 = new AuthInfo();
      ((AuthInfo)localObject2).setTtsEnum(m.c);
      ((AuthInfo)localObject2).setOnlineResult((c.a)localObject1);
      ((AuthInfo)localObject2).setOfflineResult(paramb);
      LoggerProxy.d("AuthClient", "end authMix");
      return (AuthInfo)localObject2;
    }
    catch (InterruptedException paramb)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
        ((FutureTask)localObject2).cancel(true);
        localFutureTask.cancel(true);
      }
    }
  }
  
  public b.a a(e.b paramb)
  {
    b.a locala = new b.a();
    try
    {
      paramb = (b.a)a(new a(paramb), l.a.a());
      return paramb;
    }
    catch (InterruptedException paramb)
    {
      Thread.currentThread().interrupt();
      locala.a(com.baidu.tts.h.a.c.a().a(n.v, paramb));
      return locala;
    }
    catch (ExecutionException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.w, paramb.getCause()));
      return locala;
    }
    catch (TimeoutException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.x, paramb));
      return locala;
    }
    catch (CancellationException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.I, paramb));
    }
    return locala;
  }
  
  public c.a a(f.b paramb)
  {
    c.a locala = new c.a();
    try
    {
      paramb = (c.a)a(new b(paramb), l.a.a());
      return paramb;
    }
    catch (InterruptedException paramb)
    {
      Thread.currentThread().interrupt();
      locala.a(com.baidu.tts.h.a.c.a().a(n.d, paramb));
      return locala;
    }
    catch (ExecutionException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.e, paramb.getCause()));
      return locala;
    }
    catch (TimeoutException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.f, paramb));
      return locala;
    }
    catch (CancellationException paramb)
    {
      locala.a(com.baidu.tts.h.a.c.a().a(n.p, paramb));
    }
    return locala;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b.a();
    }
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private class a
    implements Callable<b.a>
  {
    private e.b b;
    
    public a(e.b paramb)
    {
      this.b = paramb;
    }
    
    public b.a a()
      throws Exception
    {
      Object localObject1 = new b.a();
      com.baidu.tts.h.b.a locala = com.baidu.tts.h.b.b.a().g();
      if (locala == null)
      {
        ((b.a)localObject1).a(com.baidu.tts.h.a.c.a().b(n.Z));
        return (b.a)localObject1;
      }
      String str = this.b.g();
      Object localObject2 = this.b.f();
      localObject1 = localObject2;
      if (StringTool.isEmpty((String)localObject2)) {
        localObject1 = locala.b();
      }
      LoggerProxy.d("AuthClient", "appCode=" + str);
      LoggerProxy.d("AuthClient", "licenseFilePath=" + (String)localObject1);
      localObject2 = new b();
      ((b)localObject2).a(str);
      ((b)localObject2).b((String)localObject1);
      return (b.a)a.b(a.this).a((com.baidu.tts.k.b)localObject2);
    }
  }
  
  private class b
    implements Callable<c.a>
  {
    private f.b b;
    
    public b(f.b paramb)
    {
      this.b = paramb;
    }
    
    public c.a a()
      throws Exception
    {
      String str1 = this.b.e();
      String str2 = this.b.a();
      String str3 = this.b.b();
      LoggerProxy.d("AuthClient", "pid=" + str1);
      LoggerProxy.d("AuthClient", "ak=" + str2);
      LoggerProxy.d("AuthClient", "sk=" + str3);
      c localc = new c();
      localc.a(str1);
      localc.b(str2);
      localc.c(str3);
      return (c.a)a.a(a.this).a(localc);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */