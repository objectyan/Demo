package com.baidu.tts.a.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tts.aop.IProxyFactory;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.tts.TtsFactory;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.f.l;
import com.baidu.tts.f.n;
import com.baidu.tts.m.e;
import com.baidu.tts.m.f;
import com.baidu.tts.m.h;
import com.baidu.tts.tools.ResourceTools;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class a
{
  private ITts a = g();
  private SpeechSynthesizerListener b;
  private ThreadPoolExecutor c;
  private TtsListener d = new TtsListener()
  {
    private boolean a(h paramAnonymoush)
    {
      try
      {
        paramAnonymoush = paramAnonymoush.f().getTtsErrorFlyweight().a();
        int i = a.2.a[paramAnonymoush.ordinal()];
        switch (i)
        {
        default: 
          return false;
        }
        return true;
      }
      catch (Exception paramAnonymoush)
      {
        LoggerProxy.d("SpeechSynthesizerAdapter", "isStopped exception=" + paramAnonymoush.toString());
      }
      return false;
    }
    
    public void onError(h paramAnonymoush)
    {
      if ((a.b(a.this) != null) && (!a(paramAnonymoush)))
      {
        String str = a.a(a.this, paramAnonymoush);
        paramAnonymoush = a.b(a.this, paramAnonymoush);
        a.b(a.this).onError(str, paramAnonymoush);
      }
    }
    
    public void onPlayFinished(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        paramAnonymoush = a.a(a.this, paramAnonymoush);
        a.b(a.this).onSpeechFinish(paramAnonymoush);
      }
    }
    
    public void onPlayProgressUpdate(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        String str = a.a(a.this, paramAnonymoush);
        int i = paramAnonymoush.c();
        a.b(a.this).onSpeechProgressChanged(str, i);
      }
    }
    
    public void onPlayStart(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        paramAnonymoush = a.a(a.this, paramAnonymoush);
        a.b(a.this).onSpeechStart(paramAnonymoush);
      }
    }
    
    public void onSynthesizeDataArrived(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        String str = a.a(a.this, paramAnonymoush);
        byte[] arrayOfByte = paramAnonymoush.d();
        int i = paramAnonymoush.c();
        a.b(a.this).onSynthesizeDataArrived(str, arrayOfByte, i);
      }
    }
    
    public void onSynthesizeFinished(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        paramAnonymoush = a.a(a.this, paramAnonymoush);
        a.b(a.this).onSynthesizeFinish(paramAnonymoush);
      }
    }
    
    public void onSynthesizeStart(h paramAnonymoush)
    {
      if (a.b(a.this) != null)
      {
        paramAnonymoush = a.a(a.this, paramAnonymoush);
        a.b(a.this).onSynthesizeStart(paramAnonymoush);
      }
    }
  };
  
  public a()
  {
    this.a.setTtsListener(this.d);
  }
  
  private int a(String paramString, Callable<Void> paramCallable)
  {
    paramString = ResourceTools.isTextValid(paramString);
    if (paramString == null) {
      return a(paramCallable);
    }
    return paramString.b();
  }
  
  private int a(Callable<Void> paramCallable)
  {
    try
    {
      h().submit(paramCallable);
      return 0;
    }
    catch (RejectedExecutionException paramCallable)
    {
      int i = ((ThreadPoolExecutor)h()).getQueue().size();
      Log.e("bdtts-Queue", " count=" + i);
    }
    return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
  }
  
  private String a(h paramh)
  {
    if (paramh != null)
    {
      paramh = paramh.e();
      if (paramh != null) {
        return paramh.f();
      }
    }
    LoggerProxy.d("SpeechSynthesizerAdapter", "getUtteranceId null");
    return null;
  }
  
  private SpeechError b(h paramh)
  {
    if (paramh != null)
    {
      paramh = paramh.f();
      if (paramh != null)
      {
        int i = paramh.getDetailCode();
        paramh = paramh.getDetailMessage();
        SpeechError localSpeechError = new SpeechError();
        localSpeechError.code = i;
        localSpeechError.description = paramh;
        return localSpeechError;
      }
      LoggerProxy.d("SpeechSynthesizerAdapter", "ttsError is null");
    }
    paramh = new SpeechError();
    paramh.code = n.al.b();
    paramh.description = n.al.c();
    return paramh;
  }
  
  private ITts g()
  {
    return (ITts)new TtsFactory().makeProxy();
  }
  
  private ExecutorService h()
  {
    try
    {
      if (this.c == null) {
        this.c = new com.baidu.tts.c.a(15000, "SpeechSynthesizerPoolThread", new ThreadPoolExecutor.AbortPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = this.c;
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  private void i()
  {
    if (this.c != null) {
      if (!this.c.isShutdown()) {
        this.c.shutdownNow();
      }
    }
    try
    {
      boolean bool = this.c.awaitTermination(l.a.a(), TimeUnit.MILLISECONDS);
      LoggerProxy.d("SpeechSynthesizerAdapter", "isTerminated=" + bool);
      this.c = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LoggerProxy.d("SpeechSynthesizerAdapter", "InterruptedException");
      }
    }
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return this.a.setStereoVolume(paramFloat1, paramFloat2);
  }
  
  public int a(int paramInt)
  {
    return this.a.setAudioStreamType(paramInt);
  }
  
  public int a(String paramString)
  {
    e locale = new e();
    locale.a(paramString);
    return this.a.loadCustomResource(locale);
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = com.baidu.tts.f.g.valueOf(paramString1);
      int i = this.a.setParam(paramString1, paramString2);
      return i;
    }
    catch (Exception paramString1) {}
    return n.Y.b();
  }
  
  public int a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, new b(paramString1, paramString2));
  }
  
  public int a(List<SpeechSynthesizeBag> paramList)
  {
    if (paramList.size() <= 100) {
      return a(new a(paramList));
    }
    return SpeechSynthesizer.ERROR_LIST_IS_TOO_LONG;
  }
  
  public TtsError a(TtsMode paramTtsMode)
  {
    this.a.setMode(paramTtsMode.getTtsEnum());
    return this.a.b();
  }
  
  public String a()
  {
    return com.baidu.tts.h.b.b.a().j();
  }
  
  public void a(Context paramContext)
  {
    this.a.setContext(paramContext);
  }
  
  public void a(SpeechSynthesizerListener paramSpeechSynthesizerListener)
  {
    if (this.b != paramSpeechSynthesizerListener) {
      this.b = paramSpeechSynthesizerListener;
    }
  }
  
  public int b()
  {
    if (this.a != null) {
      this.a.d();
    }
    return 0;
  }
  
  public int b(String paramString1, String paramString2)
  {
    com.baidu.tts.m.g localg = new com.baidu.tts.m.g();
    localg.b(paramString1);
    localg.a(paramString2);
    return this.a.loadModel(localg);
  }
  
  public int b(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, new c(paramString1, paramString2));
  }
  
  public AuthInfo b(TtsMode paramTtsMode)
  {
    return this.a.auth(paramTtsMode.getTtsEnum());
  }
  
  public int c()
  {
    if (this.a != null) {
      this.a.c();
    }
    return 0;
  }
  
  public int c(String paramString1, String paramString2)
  {
    f localf = new f();
    localf.a(paramString1);
    localf.b(paramString2);
    return this.a.loadEnglishModel(localf);
  }
  
  public int d()
  {
    i();
    if (this.a != null) {
      this.a.e();
    }
    return 0;
  }
  
  public int e()
  {
    i();
    try
    {
      if (this.a != null)
      {
        this.a.f();
        this.a = null;
      }
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int f()
  {
    return this.a.freeCustomResource(null);
  }
  
  private class a
    implements Callable<Void>
  {
    List<SpeechSynthesizeBag> a;
    
    public a()
    {
      List localList;
      this.a = localList;
    }
    
    public Void a()
      throws Exception
    {
      if (this.a != null)
      {
        int j = this.a.size();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            SpeechSynthesizeBag localSpeechSynthesizeBag = (SpeechSynthesizeBag)this.a.get(i);
            if (localSpeechSynthesizeBag != null)
            {
              String str2 = localSpeechSynthesizeBag.getText();
              String str1 = localSpeechSynthesizeBag.getUtteranceId();
              Object localObject = str1;
              if (TextUtils.isEmpty(str1))
              {
                localObject = String.valueOf(i);
                localSpeechSynthesizeBag.setUtteranceId((String)localObject);
              }
              if (Thread.currentThread().isInterrupted()) {
                break;
              }
              localObject = new com.baidu.tts.m.i(str2, (String)localObject);
              ((com.baidu.tts.m.i)localObject).a(com.baidu.tts.f.i.b);
              a.a(a.this).speak((com.baidu.tts.m.i)localObject);
            }
            i += 1;
          }
        }
      }
      return null;
    }
  }
  
  private class b
    implements Callable<Void>
  {
    private String b;
    private String c;
    
    public b(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public Void a()
      throws Exception
    {
      com.baidu.tts.m.i locali = new com.baidu.tts.m.i(this.b, this.c);
      locali.a(com.baidu.tts.f.i.b);
      a.a(a.this).speak(locali);
      return null;
    }
  }
  
  private class c
    implements Callable<Void>
  {
    private String b;
    private String c;
    
    public c(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public Void a()
      throws Exception
    {
      com.baidu.tts.m.i locali = new com.baidu.tts.m.i(this.b, this.c);
      locali.a(com.baidu.tts.f.i.a);
      a.a(a.this).synthesize(locali);
      return null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */