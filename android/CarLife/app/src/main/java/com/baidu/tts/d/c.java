package com.baidu.tts.d;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.d.b.d;
import com.baidu.tts.f.n;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
  implements com.baidu.tts.j.b
{
  private static volatile c a = null;
  private com.baidu.tts.l.a b;
  private com.baidu.tts.d.b.a c = com.baidu.tts.d.b.a.a();
  private com.baidu.tts.d.a.b d = new com.baidu.tts.d.a.b();
  private ExecutorService e;
  
  public static c a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new c();
      }
      return a;
    }
    finally {}
  }
  
  private ExecutorService h()
  {
    try
    {
      if (this.e == null) {
        this.e = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = this.e;
      return localExecutorService;
    }
    finally {}
  }
  
  public DownloadHandler a(DownloadHandler paramDownloadHandler)
  {
    try
    {
      LoggerProxy.d("Downloader", "download handler=" + paramDownloadHandler);
      a locala = new a(paramDownloadHandler);
      paramDownloadHandler.setCheckFuture(h().submit(locala));
      return paramDownloadHandler;
    }
    finally
    {
      paramDownloadHandler = finally;
      throw paramDownloadHandler;
    }
  }
  
  public void a(com.baidu.tts.l.a parama)
  {
    this.b = parama;
    this.c.a(this.b.e());
    this.d.a(this.b);
  }
  
  public TtsError b()
  {
    return null;
  }
  
  public void c()
  {
    try
    {
      this.d.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    try
    {
      this.d.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 57
    //   4: ldc 115
    //   6: invokestatic 78	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 33	com/baidu/tts/d/c:c	Lcom/baidu/tts/d/b/a;
    //   13: invokevirtual 116	com/baidu/tts/d/b/a:c	()V
    //   16: aload_0
    //   17: getfield 49	com/baidu/tts/d/c:e	Ljava/util/concurrent/ExecutorService;
    //   20: ifnull +94 -> 114
    //   23: aload_0
    //   24: getfield 49	com/baidu/tts/d/c:e	Ljava/util/concurrent/ExecutorService;
    //   27: invokeinterface 120 1 0
    //   32: ifne +27 -> 59
    //   35: aload_0
    //   36: getfield 49	com/baidu/tts/d/c:e	Ljava/util/concurrent/ExecutorService;
    //   39: invokeinterface 124 1 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 38	com/baidu/tts/d/c:d	Lcom/baidu/tts/d/a/b;
    //   49: invokevirtual 126	com/baidu/tts/d/a/b:e	()V
    //   52: ldc 57
    //   54: ldc -128
    //   56: invokestatic 78	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 57
    //   61: ldc -126
    //   63: invokestatic 78	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 49	com/baidu/tts/d/c:e	Ljava/util/concurrent/ExecutorService;
    //   70: getstatic 135	com/baidu/tts/f/l:a	Lcom/baidu/tts/f/l;
    //   73: invokevirtual 138	com/baidu/tts/f/l:a	()J
    //   76: getstatic 144	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   79: invokeinterface 148 4 0
    //   84: istore_1
    //   85: ldc 57
    //   87: new 59	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   94: ldc -106
    //   96: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload_1
    //   100: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 78	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 49	com/baidu/tts/d/c:e	Ljava/util/concurrent/ExecutorService;
    //   114: ldc 57
    //   116: ldc -101
    //   118: invokestatic 78	com/baidu/tts/chainofresponsibility/logger/LoggerProxy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: astore_2
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_2
    //   130: goto -21 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	c
    //   84	16	1	bool	boolean
    //   124	4	2	localObject	Object
    //   129	1	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	59	124	finally
    //   59	109	124	finally
    //   109	114	124	finally
    //   114	121	124	finally
    //   59	109	129	java/lang/InterruptedException
  }
  
  public void f() {}
  
  public void g()
  {
    try
    {
      h();
      this.d.A();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public class a
    implements Callable<a>
  {
    private DownloadHandler b;
    
    public a(DownloadHandler paramDownloadHandler)
    {
      this.b = paramDownloadHandler;
    }
    
    public a a()
      throws Exception
    {
      a locala = new a();
      Object localObject2 = c.a(c.this).e();
      Object localObject1 = this.b.getModelId();
      d locald = c.b(c.this).b((String)localObject1);
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        locald.c(this.b);
        if (!locald.a((com.baidu.tts.database.a)localObject2))
        {
          localObject3 = new Conditions();
          ((Conditions)localObject3).appendId((String)localObject1);
          localObject3 = (ModelBags)c.a(c.this).a((Conditions)localObject3).get();
          if ((localObject3 == null) || (((ModelBags)localObject3).isEmpty()))
          {
            localObject2 = com.baidu.tts.h.a.c.a().a(n.ah, "modelId=" + (String)localObject1);
            locald.a(this.b, (TtsError)localObject2);
            return locala;
          }
          locald.a((ModelBags)localObject3, (com.baidu.tts.database.a)localObject2);
        }
        localObject3 = locald.f();
        if (DataTool.isSetEmpty((Set)localObject3))
        {
          localObject2 = com.baidu.tts.h.a.c.a().a(n.ae, "modelId=" + (String)localObject1);
          locald.a(this.b, (TtsError)localObject2);
          return locala;
        }
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = c.b(c.this).c((String)localObject4);
          if (!((com.baidu.tts.d.b.c)localObject5).a((com.baidu.tts.database.a)localObject2))
          {
            localObject6 = new HashSet();
            ((Set)localObject6).add(localObject4);
            localObject6 = (ModelFileBags)c.a(c.this).a((Set)localObject6).get();
            if ((localObject6 == null) || (((ModelFileBags)localObject6).isEmpty()))
            {
              localObject2 = com.baidu.tts.h.a.c.a().a(n.ai, "fileId=" + (String)localObject4);
              locald.a(this.b, (TtsError)localObject2);
              return locala;
            }
            ((ModelFileBags)localObject6).generateAbsPath(c.a(c.this).d());
            ((com.baidu.tts.d.b.c)localObject5).a((ModelFileBags)localObject6, (com.baidu.tts.database.a)localObject2);
          }
        }
        locald.d();
      }
      catch (Exception localException)
      {
        LoggerProxy.d("Downloader", "exception=" + localException.toString());
        localObject1 = com.baidu.tts.h.a.c.a().a(n.aj, "modelId=" + (String)localObject1);
        locald.a(this.b, (TtsError)localObject1);
        return locala;
      }
      Object localObject3 = locald.b();
      TtsError localTtsError;
      if (DataTool.isSetEmpty((Set)localObject3))
      {
        localTtsError = com.baidu.tts.h.a.c.a().a(n.af, "modelId=" + (String)localObject1);
        locald.a(this.b, localTtsError);
        return locala;
      }
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject6 = (String)((Iterator)localObject3).next();
        if (!StringTool.isEmpty((String)localObject6))
        {
          localObject4 = c.b(c.this).a((String)localObject6);
          ((com.baidu.tts.d.b.b)localObject4).a((String)localObject1);
          boolean bool = ((com.baidu.tts.d.b.b)localObject4).a(localTtsError);
          localObject5 = ((com.baidu.tts.d.b.b)localObject4).c();
          LoggerProxy.d("Downloader", "isNeedDownload=" + bool + "--fileId=" + (String)localObject5);
          if (bool)
          {
            if (((com.baidu.tts.d.b.b)localObject4).e()) {
              ((com.baidu.tts.d.b.b)localObject4).f();
            }
            localObject6 = new com.baidu.tts.d.a.c();
            ((com.baidu.tts.d.a.c)localObject6).a((com.baidu.tts.d.b.b)localObject4);
            if (Thread.currentThread().isInterrupted()) {
              return null;
            }
            LoggerProxy.d("Downloader", "before download fileId=" + (String)localObject5);
            ((com.baidu.tts.d.b.b)localObject4).a(c.c(c.this).a((com.baidu.tts.d.a.c)localObject6));
            locala.a(true);
          }
          else
          {
            locala.a((String)localObject6, ((com.baidu.tts.d.b.b)localObject4).d());
          }
        }
      }
      if ((!locala.a()) && (locala.b()))
      {
        this.b.updateProgress(locald);
        localTtsError = com.baidu.tts.h.a.c.a().a(n.ag, "modelId=" + (String)localObject1);
        locald.a(this.b, localTtsError);
      }
      return locala;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */