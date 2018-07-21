package com.baidu.tts.o.a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.b.b.b.b.a;
import com.baidu.tts.f.n;
import com.baidu.tts.f.n.a;
import com.baidu.tts.m.e;
import com.baidu.tts.m.f;
import com.baidu.tts.m.g;
import com.baidu.tts.m.i;
import com.baidu.tts.m.j;

public class d
  extends a
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  public TtsError b()
  {
    TtsError localTtsError = this.a.h();
    if (localTtsError != null)
    {
      Object localObject = localTtsError.getErrorEnum();
      if (localObject != null)
      {
        localObject = ((n)localObject).a();
        if (n.a.a.equals(localObject)) {
          a(this.a.g());
        }
      }
      return localTtsError;
    }
    a(this.a.g());
    return localTtsError;
  }
  
  public void c()
  {
    this.a.p();
  }
  
  public void d()
  {
    this.a.p();
  }
  
  public void e()
  {
    this.a.p();
  }
  
  public void f() {}
  
  public int freeCustomResource(e parame)
  {
    return this.a.p();
  }
  
  public int loadCustomResource(e parame)
  {
    return this.a.p();
  }
  
  public int loadEnglishModel(f paramf)
  {
    return this.a.p();
  }
  
  public int loadModel(g paramg)
  {
    return this.a.p();
  }
  
  public int setAudioStreamType(int paramInt)
  {
    this.a.getTtsParams().e().a(paramInt);
    return 0;
  }
  
  public int setStereoVolume(float paramFloat1, float paramFloat2)
  {
    b.a locala = this.a.getTtsParams().e();
    locala.a(paramFloat1);
    locala.b(paramFloat2);
    return 0;
  }
  
  public void speak(i parami)
  {
    this.a.p();
  }
  
  public void synthesize(i parami)
  {
    this.a.p();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/o/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */