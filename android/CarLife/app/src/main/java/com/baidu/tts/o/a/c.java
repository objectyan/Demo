package com.baidu.tts.o.a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.f.m;
import com.baidu.tts.f.n;
import com.baidu.tts.m.e;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;
import com.baidu.tts.m.j;

public class c
  implements ITts
{
  private j b = new j();
  private TtsListener c;
  private m d;
  private com.baidu.tts.a.c.c e;
  private volatile a f = this.g;
  private d g = new d(this);
  private b h = new b(this);
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  int a(float paramFloat1, float paramFloat2)
  {
    return this.e.a(paramFloat1, paramFloat2);
  }
  
  int a(int paramInt)
  {
    try
    {
      paramInt = this.e.f().a().a(paramInt);
      return paramInt;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  int a(com.baidu.tts.f.g paramg, String paramString)
  {
    if (this.b != null) {
      return this.b.a(paramg, paramString);
    }
    return 0;
  }
  
  int a(e parame)
  {
    return this.e.a(parame);
  }
  
  int a(com.baidu.tts.m.f paramf)
  {
    return this.e.a(paramf);
  }
  
  int a(com.baidu.tts.m.g paramg)
  {
    return this.e.a(paramg);
  }
  
  public d a()
  {
    return this.g;
  }
  
  void a(Context paramContext)
  {
    com.baidu.tts.h.b.b.a().a(paramContext);
  }
  
  public void a(TtsError paramTtsError)
  {
    a(h.b(paramTtsError));
  }
  
  void a(TtsListener paramTtsListener)
  {
    if ((paramTtsListener != null) && (paramTtsListener != this.c))
    {
      this.c = paramTtsListener;
      if (this.e != null) {
        this.e.a(this.c);
      }
    }
  }
  
  void a(m paramm)
  {
    this.d = paramm;
  }
  
  public void a(h paramh)
  {
    if (this.c != null) {
      this.c.onError(paramh);
    }
  }
  
  void a(i parami)
  {
    this.e.a(parami);
  }
  
  void a(a parama)
  {
    this.f = parama;
  }
  
  public AuthInfo auth(m paramm)
  {
    return this.f.auth(paramm);
  }
  
  int b(e parame)
  {
    return this.e.b(parame);
  }
  
  public TtsError b()
  {
    return this.f.b();
  }
  
  AuthInfo b(m paramm)
  {
    return com.baidu.tts.auth.a.a().a(paramm, this.b);
  }
  
  void b(i parami)
  {
    this.e.b(parami);
  }
  
  public void c()
  {
    this.f.c();
  }
  
  public void d()
  {
    this.f.d();
  }
  
  public void e()
  {
    this.f.e();
  }
  
  public void f()
  {
    this.f.f();
  }
  
  public int freeCustomResource(e parame)
  {
    return this.f.freeCustomResource(parame);
  }
  
  public b g()
  {
    return this.h;
  }
  
  public m getMode()
  {
    return this.f.getMode();
  }
  
  public TtsListener getTtsListener()
  {
    return this.f.getTtsListener();
  }
  
  public j getTtsParams()
  {
    return this.f.getTtsParams();
  }
  
  TtsError h()
  {
    Object localObject1 = null;
    if (this.d == null) {
      this.d = m.a;
    }
    if (this.b == null) {
      this.b = new j();
    }
    Object localObject2 = com.baidu.tts.h.b.b.a().b();
    if ((!a) && (localObject2 != null)) {
      throw new AssertionError();
    }
    switch (1.a[this.d.ordinal()])
    {
    default: 
      localObject2 = null;
    }
    while ((localObject2 != null) && (localObject1 != null))
    {
      ((com.baidu.tts.b.a.a.d)localObject2).a(localObject1);
      localObject1 = new com.baidu.tts.b.b.a.f();
      ((com.baidu.tts.b.b.a.c)localObject1).a(this.b.b());
      this.e = new com.baidu.tts.a.c.c();
      localObject1 = new com.baidu.tts.a.c.b((com.baidu.tts.b.a.a.d)localObject2, (com.baidu.tts.b.b.a.c)localObject1, this.b);
      this.e.a((com.baidu.tts.a.c.a)localObject1);
      if (this.c != null) {
        this.e.a(this.c);
      }
      return this.e.a();
      localObject2 = com.baidu.tts.b.a.a.a().a(com.baidu.tts.f.f.a);
      localObject1 = this.b.c();
      continue;
      localObject2 = com.baidu.tts.b.a.a.a().a(com.baidu.tts.f.f.b);
      localObject1 = this.b.d();
      continue;
      localObject2 = com.baidu.tts.b.a.a.a().a(com.baidu.tts.f.f.c);
      localObject1 = this.b.a();
    }
    return com.baidu.tts.h.a.c.a().b(n.S);
  }
  
  void i()
  {
    this.e.b();
  }
  
  void j()
  {
    this.e.c();
  }
  
  void k()
  {
    this.e.d();
  }
  
  void l()
  {
    this.e.e();
    com.baidu.tts.auth.a.a().b();
    com.baidu.tts.h.b.b.a().f();
    this.b = new j();
  }
  
  public int loadCustomResource(e parame)
  {
    return this.f.loadCustomResource(parame);
  }
  
  public int loadEnglishModel(com.baidu.tts.m.f paramf)
  {
    return this.f.loadEnglishModel(paramf);
  }
  
  public int loadModel(com.baidu.tts.m.g paramg)
  {
    return this.f.loadModel(paramg);
  }
  
  TtsListener m()
  {
    return this.c;
  }
  
  m n()
  {
    return this.d;
  }
  
  j o()
  {
    return this.b;
  }
  
  public int p()
  {
    if (this.c == null) {
      throw new IllegalStateException(n.S.c());
    }
    a(com.baidu.tts.h.a.c.a().b(n.S));
    return -1;
  }
  
  public boolean q()
  {
    return this.h == this.f;
  }
  
  public int setAudioStreamType(int paramInt)
  {
    return this.f.setAudioStreamType(paramInt);
  }
  
  public void setContext(Context paramContext)
  {
    this.f.setContext(paramContext);
  }
  
  public void setMode(m paramm)
  {
    this.f.setMode(paramm);
  }
  
  public int setParam(com.baidu.tts.f.g paramg, String paramString)
  {
    return this.f.setParam(paramg, paramString);
  }
  
  public int setStereoVolume(float paramFloat1, float paramFloat2)
  {
    return this.f.setStereoVolume(paramFloat1, paramFloat2);
  }
  
  public void setTtsListener(TtsListener paramTtsListener)
  {
    this.f.setTtsListener(paramTtsListener);
  }
  
  public void speak(i parami)
  {
    this.f.speak(parami);
  }
  
  public void synthesize(i parami)
  {
    this.f.synthesize(parami);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/o/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */