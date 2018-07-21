package com.baidu.tts.o.a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.f.g;
import com.baidu.tts.f.m;
import com.baidu.tts.m.j;

public abstract class a
  implements ITts
{
  protected c a;
  
  public a(c paramc)
  {
    this.a = paramc;
  }
  
  public void a(a parama)
  {
    this.a.a(parama);
  }
  
  public AuthInfo auth(m paramm)
  {
    return this.a.b(paramm);
  }
  
  public m getMode()
  {
    return this.a.n();
  }
  
  public TtsListener getTtsListener()
  {
    return this.a.m();
  }
  
  public j getTtsParams()
  {
    return this.a.o();
  }
  
  public void setContext(Context paramContext)
  {
    this.a.a(paramContext);
  }
  
  public void setMode(m paramm)
  {
    this.a.a(paramm);
  }
  
  public int setParam(g paramg, String paramString)
  {
    return this.a.a(paramg, paramString);
  }
  
  public void setTtsListener(TtsListener paramTtsListener)
  {
    this.a.a(paramTtsListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/o/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */