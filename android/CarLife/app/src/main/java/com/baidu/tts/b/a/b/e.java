package com.baidu.tts.b.a.b;

import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.b.a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.n;
import com.baidu.tts.h.b.b;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener;
import com.baidu.tts.m.g;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e
  extends a
{
  private b b;
  private long[] c = new long[1];
  private com.baidu.tts.e.c d;
  
  public int a(com.baidu.tts.m.e parame)
  {
    return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(parame.a()), this.c[0]);
  }
  
  public int a(com.baidu.tts.m.f paramf)
  {
    String str = paramf.b();
    paramf = paramf.a();
    boolean bool = TextUtils.isEmpty(str);
    if ((TextUtils.isEmpty(paramf)) || (bool)) {
      return n.Y.b();
    }
    int i = EmbeddedSynthesizerEngine.loadEnglishEngine(ResourceTools.stringToByteArrayAddNull(paramf), ResourceTools.stringToByteArrayAddNull(str), this.c[0]);
    LoggerProxy.d("OfflineSynthesizer", "loadEnglishModel ret=" + i);
    return i;
  }
  
  public int a(g paramg)
  {
    int j = 0;
    String str = paramg.b();
    paramg = paramg.a();
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool2 = TextUtils.isEmpty(paramg);
    if ((bool1) && (bool2)) {
      return n.Y.b();
    }
    if (!bool2) {}
    for (int i = EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(paramg), this.c[0]);; i = 0)
    {
      if (!bool1) {
        j = EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(str), this.c[0]);
      }
      return j + i;
    }
  }
  
  public TtsError a()
  {
    int i;
    try
    {
      this.d = com.baidu.tts.e.c.a(b.a().h());
      if (this.b == null) {
        this.b = new b();
      }
      Object localObject1 = com.baidu.tts.auth.a.a().a(this.b);
      if (!((b.a)localObject1).g()) {
        break label166;
      }
      Object localObject2 = this.b.d();
      localObject1 = this.b.e();
      localObject2 = ResourceTools.stringToByteArrayAddNull((String)localObject2);
      localObject1 = ResourceTools.stringToByteArrayAddNull((String)localObject1);
      LoggerProxy.d("OfflineSynthesizer", "before bdTTSEngineInit");
      i = EmbeddedSynthesizerEngine.bdTTSEngineInit((byte[])localObject2, (byte[])localObject1, this.c);
      LoggerProxy.d("OfflineSynthesizer", "engine init ret = " + i);
      if (i == 0) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LoggerProxy.d("OfflineSynthesizer", "embedded statistics open exception=" + localException.toString());
      }
    }
    return com.baidu.tts.h.a.c.a().a(n.y, i, "bdTTSEngineInit result not 0");
    label166:
    return localException.b();
  }
  
  public TtsError a(i parami)
    throws InterruptedException
  {
    try
    {
      parami = new c(parami).a();
      return parami;
    }
    catch (InterruptedException parami)
    {
      throw parami;
    }
    catch (Exception parami) {}
    return com.baidu.tts.h.a.c.a().a(n.A, parami);
  }
  
  public <OfflineSynthesizerParams> void a(OfflineSynthesizerParams paramOfflineSynthesizerParams)
  {
    this.b = ((b)paramOfflineSynthesizerParams);
  }
  
  public int b(com.baidu.tts.m.e parame)
  {
    return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(this.c[0]);
  }
  
  public TtsError b()
  {
    EmbeddedSynthesizerEngine.bdTTSEngineUninit(this.c[0]);
    return null;
  }
  
  private class a
    implements Runnable
  {
    private int b;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      try
      {
        synchronized (e.c(e.this))
        {
          if (e.c(e.this) != null) {
            e.c(e.this).a(System.currentTimeMillis(), this.b, 0, 0, "");
          }
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        LoggerProxy.d("OfflineSynthesizer", "AddPVResultsToDB exception=" + localException.toString());
      }
    }
  }
  
  public static class b
    extends com.baidu.tts.m.d<b>
  {
    private String a = "0";
    private String b = "0";
    private String c = "0";
    private String d;
    private String e;
    private String f;
    private String g;
    
    public int a(String paramString)
    {
      if (DataTool.isLong(paramString))
      {
        this.a = paramString;
        return 0;
      }
      return n.Y.b();
    }
    
    public long a()
    {
      try
      {
        long l = Long.parseLong(this.a);
        return l;
      }
      catch (Exception localException) {}
      return 0L;
    }
    
    public long b()
    {
      try
      {
        long l = Long.parseLong(this.b);
        return l;
      }
      catch (Exception localException) {}
      return 0L;
    }
    
    public void b(String paramString)
    {
      this.b = paramString;
    }
    
    public int c(String paramString)
    {
      if (DataTool.isLong(paramString))
      {
        this.c = paramString;
        return 0;
      }
      return n.Y.b();
    }
    
    public long c()
    {
      try
      {
        long l = Long.parseLong(this.c);
        return l;
      }
      catch (Exception localException) {}
      return 0L;
    }
    
    public String d()
    {
      return this.d;
    }
    
    public void d(String paramString)
    {
      this.d = paramString;
    }
    
    public String e()
    {
      return this.e;
    }
    
    public void e(String paramString)
    {
      this.e = paramString;
    }
    
    public String f()
    {
      return this.f;
    }
    
    public void f(String paramString)
    {
      this.f = paramString;
    }
    
    public String g()
    {
      return this.g;
    }
    
    public void g(String paramString)
    {
      this.g = paramString;
    }
  }
  
  private class c
    implements EmbeddedSynthesizerEngine.OnNewDataListener, Callable<TtsError>
  {
    ExecutorService a = Executors.newCachedThreadPool();
    private i c;
    private int d = 0;
    
    public c(i parami)
    {
      this.c = parami;
    }
    
    public TtsError a()
      throws Exception
    {
      Object localObject = com.baidu.tts.auth.a.a().a(e.a(e.this));
      if (localObject != null)
      {
        if (((b.a)localObject).g())
        {
          int i = EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 0, 0L);
          LoggerProxy.d("OfflineSynthesizer", "engineResult = " + i);
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 5, e.a(e.this).y());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 6, e.a(e.this).z());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 7, e.a(e.this).A());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 18, e.a(e.this).a());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 19, e.a(e.this).b());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 20, e.a(e.this).c());
          EmbeddedSynthesizerEngine.bdTTSSetParam(e.b(e.this)[0], 10, e.a(e.this).u());
          EmbeddedSynthesizerEngine.setOnNewDataListener(this);
          this.c.c(com.baidu.tts.f.d.d.a());
          localObject = this.c.e();
          LoggerProxy.d("OfflineSynthesizer", "before bdttssynthesis");
          i = EmbeddedSynthesizerEngine.bdTTSSynthesis(e.b(e.this)[0], (byte[])localObject, localObject.length);
          LoggerProxy.d("OfflineSynthesizer", "after bdttssynthesis result = " + i);
          try
          {
            this.a.execute(new e.a(e.this, i));
            if (i == 0) {
              return null;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              LoggerProxy.d("OfflineSynthesizer", "AddPVResultsToDB start exception=" + localException.toString());
            }
          }
          return com.baidu.tts.h.a.c.a().a(n.B, i);
        }
        return localException.b();
      }
      return com.baidu.tts.h.a.c.a().b(n.u);
    }
    
    public int onNewData(byte[] paramArrayOfByte, int paramInt)
    {
      h localh = h.b(this.c);
      localh.e(com.baidu.tts.f.f.b.a());
      localh.a(com.baidu.tts.f.a.a);
      localh.a(paramArrayOfByte);
      localh.d(paramInt);
      this.d += 1;
      localh.b(this.d);
      e.this.a(localh);
      if (Thread.currentThread().isInterrupted())
      {
        LoggerProxy.d("OfflineSynthesizer", "interrupted to interrupt syn");
        return -1;
      }
      return 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */