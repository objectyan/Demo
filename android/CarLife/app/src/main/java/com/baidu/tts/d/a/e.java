package com.baidu.tts.d.a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.Future;

public class e
{
  private Future<Void> a;
  private b.a b;
  
  public void a()
  {
    LoggerProxy.d("EngineDownloadHandler", "before stop");
    try
    {
      LoggerProxy.d("EngineDownloadHandler", "stop fileId=" + this.b.c().a());
      if (this.a != null)
      {
        boolean bool = this.a.cancel(true);
        LoggerProxy.d("EngineDownloadHandler", "unDone = " + bool);
      }
      if (this.b != null) {
        this.b.b();
      }
      LoggerProxy.d("EngineDownloadHandler", "after stop");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(b.a parama)
  {
    this.b = parama;
  }
  
  public void a(Future<Void> paramFuture)
  {
    this.a = paramFuture;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */