package com.baidu.tts.d.a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.f.l;
import com.baidu.tts.f.n;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;

public class b
  extends com.baidu.tts.j.a
{
  private volatile a a = this.b;
  private i b = new i(this);
  private f c = new f(this);
  private d f = new d(this);
  private h g = new h(this);
  private ThreadPoolExecutor h;
  private com.baidu.tts.l.a i;
  
  public b()
  {
    b();
  }
  
  public a a()
  {
    return this.a;
  }
  
  public e a(c paramc)
  {
    return this.a.a(paramc);
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(com.baidu.tts.l.a parama)
  {
    this.i = parama;
  }
  
  e b(c paramc)
  {
    a locala = new a(paramc);
    paramc.c();
    LoggerProxy.d("DownloadEngine", "before submit");
    locale = null;
    try
    {
      Future localFuture = this.h.submit(locala);
      paramc = localFuture;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LoggerProxy.d("DownloadEngine", "submit exception");
        paramc.a(com.baidu.tts.h.a.c.a().a(n.ak, localException));
        paramc = locale;
      }
    }
    locale = new e();
    locale.a(paramc);
    locale.a(locala);
    return locale;
  }
  
  protected TtsError g()
  {
    return this.a.b();
  }
  
  protected void h()
  {
    this.a.a();
  }
  
  protected void i()
  {
    this.a.c();
  }
  
  protected void j()
  {
    this.a.d();
  }
  
  protected void k()
  {
    this.a.e();
  }
  
  protected void l()
  {
    this.a.f();
  }
  
  public boolean m()
  {
    return this.a == this.g;
  }
  
  public boolean n()
  {
    return (Thread.currentThread().isInterrupted()) || (this.a == this.c);
  }
  
  public i o()
  {
    return this.b;
  }
  
  public f p()
  {
    return this.c;
  }
  
  public d q()
  {
    return this.f;
  }
  
  public h r()
  {
    return this.g;
  }
  
  void s()
  {
    this.h = ((ThreadPoolExecutor)Executors.newFixedThreadPool(5, new com.baidu.tts.g.a.a("downloadPoolThread")));
  }
  
  void t()
  {
    LoggerProxy.d("DownloadEngine", "enter stop");
    if (this.h != null) {
      if (!this.h.isShutdown()) {
        this.h.shutdownNow();
      }
    }
    try
    {
      LoggerProxy.d("DownloadEngine", "before awaitTermination");
      boolean bool = this.h.awaitTermination(l.a.a(), TimeUnit.MILLISECONDS);
      LoggerProxy.d("DownloadEngine", "after awaitTermination isTermination=" + bool);
      this.h = null;
      LoggerProxy.d("DownloadEngine", "end stop");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public class a
    implements Callable<Void>
  {
    private c b;
    private SyncHttpClient c;
    
    public a(c paramc)
    {
      this.b = paramc;
    }
    
    public Void a()
      throws Exception
    {
      this.b.d();
      final Object localObject1 = this.b.a();
      LoggerProxy.d("DownloadEngine", "DownloadWork start fileId=" + (String)localObject1);
      if (StringTool.isEmpty((String)localObject1))
      {
        localObject1 = com.baidu.tts.h.a.c.a().a(n.ac, "fileId is null");
        this.b.a((TtsError)localObject1);
      }
      for (;;)
      {
        LoggerProxy.d("DownloadEngine", "DownloadWork end");
        return null;
        Object localObject2 = new HashSet();
        ((Set)localObject2).add(localObject1);
        localObject2 = (ModelFileBags)b.a(b.this).a((Set)localObject2).get();
        if (localObject2 != null)
        {
          localObject2 = ((ModelFileBags)localObject2).getUrl(0);
          if (localObject2 != null)
          {
            if (((String)localObject2).startsWith("https")) {}
            for (this.c = new SyncHttpClient(true, 80, 443);; this.c = new SyncHttpClient())
            {
              this.c.setURLEncodingEnabled(false);
              this.c.setTimeout(l.a.b());
              this.c.setMaxRetriesAndTimeout(5, 1500);
              g local1 = new g(FileTools.getFile(this.b.b()), this.b)
              {
                public void onFailure(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, Throwable paramAnonymousThrowable, File paramAnonymousFile)
                {
                  LoggerProxy.d("DownloadEngine", "1isInterrupted=" + Thread.currentThread().isInterrupted());
                  if (b.this.C()) {
                    super.onFailure(paramAnonymousInt, paramAnonymousArrayOfHeader, paramAnonymousThrowable, paramAnonymousFile);
                  }
                }
                
                public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2)
                {
                  if (b.this.C()) {
                    super.onProgress(paramAnonymousLong1, paramAnonymousLong2);
                  }
                }
                
                public void onSuccess(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, File paramAnonymousFile)
                {
                  LoggerProxy.d("DownloadEngine", "2isInterrupted=" + Thread.currentThread().isInterrupted() + "--fileId=" + localObject1);
                  if (b.this.C()) {
                    super.onSuccess(paramAnonymousInt, paramAnonymousArrayOfHeader, paramAnonymousFile);
                  }
                }
              };
              local1.setUseSynchronousMode(true);
              LoggerProxy.d("DownloadEngine", "before get fileId=" + (String)localObject1);
              this.c.get((String)localObject2, local1);
              break;
            }
          }
          localObject1 = com.baidu.tts.h.a.c.a().a(n.ac, "url is null");
          this.b.a((TtsError)localObject1);
        }
        else
        {
          localObject1 = com.baidu.tts.h.a.c.a().a(n.ac, "urlbags is null");
          this.b.a((TtsError)localObject1);
        }
      }
    }
    
    public void b()
    {
      if (this.c != null) {
        this.c.stop();
      }
    }
    
    public c c()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */