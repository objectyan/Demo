package com.baidu.tts.b.a.b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.n;
import com.baidu.tts.m.g;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;

public class d
  extends a
{
  private com.baidu.tts.m.b b;
  private f c = new f();
  private e d = new e();
  private c e = new c();
  private TtsError f;
  private int g = 0;
  private int h = 0;
  
  private h b(h paramh)
  {
    int i = paramh.b();
    if (i >= 0) {
      i += this.h;
    }
    for (;;)
    {
      paramh.b(i);
      paramh.d(paramh.c() + this.g);
      return paramh;
      i -= this.h;
    }
  }
  
  public int a(com.baidu.tts.m.e parame)
  {
    return this.d.a(parame);
  }
  
  public int a(com.baidu.tts.m.f paramf)
  {
    return this.d.a(paramf);
  }
  
  public int a(g paramg)
  {
    if (this.f == null) {
      return this.d.a(paramg);
    }
    String str = paramg.a();
    paramg = paramg.b();
    e.b localb = this.b.b();
    localb.d(str);
    localb.e(paramg);
    this.f = this.d.a();
    if (this.f == null) {
      return 0;
    }
    return this.f.getDetailCode();
  }
  
  public TtsError a()
  {
    this.c.a(new com.baidu.tts.b.a.b()
    {
      public void a(h paramAnonymoush) {}
      
      public void b(h paramAnonymoush) {}
      
      public void c(h paramAnonymoush)
      {
        d.a(d.this, paramAnonymoush.b());
        d.b(d.this, paramAnonymoush.c());
        d.this.a(paramAnonymoush);
      }
      
      public void d(h paramAnonymoush) {}
      
      public void e(h paramAnonymoush) {}
    });
    this.d.a(new com.baidu.tts.b.a.b()
    {
      public void a(h paramAnonymoush) {}
      
      public void b(h paramAnonymoush) {}
      
      public void c(h paramAnonymoush)
      {
        d.this.a(d.a(d.this, paramAnonymoush));
      }
      
      public void d(h paramAnonymoush) {}
      
      public void e(h paramAnonymoush) {}
    });
    this.c.a();
    this.f = this.d.a();
    TtsError localTtsError = null;
    if (this.f != null) {
      localTtsError = com.baidu.tts.h.a.c.a().b(n.N);
    }
    return localTtsError;
  }
  
  public TtsError a(i parami)
    throws InterruptedException
  {
    this.h = 0;
    this.g = 0;
    if (this.e.a())
    {
      TtsError localTtsError2 = this.c.a(parami);
      TtsError localTtsError1 = localTtsError2;
      if (localTtsError2 != null)
      {
        LoggerProxy.d("MixSynthesizer", "online synthesize ttserror=" + localTtsError2.getDetailMessage());
        parami.b(parami.c().substring(this.g));
        localTtsError1 = this.d.a(parami);
      }
      return localTtsError1;
    }
    return this.d.a(parami);
  }
  
  public <AllSynthesizerParams> void a(AllSynthesizerParams paramAllSynthesizerParams)
  {
    this.b = ((com.baidu.tts.m.b)paramAllSynthesizerParams);
    paramAllSynthesizerParams = this.b.a();
    paramAllSynthesizerParams.a(3);
    paramAllSynthesizerParams.b(500);
    this.c.a(paramAllSynthesizerParams);
    paramAllSynthesizerParams = this.b.b();
    this.d.a(paramAllSynthesizerParams);
    this.e.a(this.b);
  }
  
  public int b(com.baidu.tts.m.e parame)
  {
    return this.d.b(parame);
  }
  
  public TtsError b()
  {
    this.c.b();
    this.d.b();
    this.e.a(null);
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */