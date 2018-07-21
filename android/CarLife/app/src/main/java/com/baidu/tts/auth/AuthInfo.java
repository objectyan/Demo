package com.baidu.tts.auth;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.m;
import com.baidu.tts.f.n;
import com.baidu.tts.h.a.c;

public class AuthInfo
{
  private m a;
  private c.a b;
  private b.a c;
  private TtsError d;
  
  public int getLeftValidDays()
  {
    return this.c.a();
  }
  
  public TtsError getMixTtsError()
  {
    TtsError localTtsError1 = getOnlineTtsError();
    TtsError localTtsError2 = getOfflineTtsError();
    Object localObject2 = null;
    Object localObject1;
    if ((localTtsError1 != null) && (localTtsError2 != null)) {
      localObject1 = c.a().b(n.J);
    }
    while (localObject1 != null)
    {
      return (TtsError)localObject1;
      if ((localTtsError1 == null) && (localTtsError2 != null))
      {
        localObject1 = c.a().b(n.r);
      }
      else
      {
        localObject1 = localObject2;
        if (localTtsError1 != null)
        {
          localObject1 = localObject2;
          if (localTtsError2 == null) {
            localObject1 = c.a().b(n.a);
          }
        }
      }
    }
    return this.d;
  }
  
  public String getNotifyMessage()
  {
    return this.c.c();
  }
  
  public b.a getOfflineResult()
  {
    return this.c;
  }
  
  public TtsError getOfflineTtsError()
  {
    if (this.c != null) {
      return this.c.b();
    }
    return this.d;
  }
  
  public c.a getOnlineResult()
  {
    return this.b;
  }
  
  public TtsError getOnlineTtsError()
  {
    if (this.b != null) {
      return this.b.b();
    }
    return this.d;
  }
  
  public m getTtsEnum()
  {
    return this.a;
  }
  
  public TtsError getTtsError()
  {
    if (this.d == null)
    {
      switch (1.a[this.a.ordinal()])
      {
      default: 
        return null;
      case 1: 
        return this.b.b();
      case 2: 
        return this.c.b();
      }
      return getMixTtsError();
    }
    return this.d;
  }
  
  public boolean isMixSuccess()
  {
    return (isOnlineSuccess()) || (isOfflineSuccess());
  }
  
  public boolean isOfflineSuccess()
  {
    if (this.c != null) {
      return this.c.g();
    }
    return false;
  }
  
  public boolean isOnlineSuccess()
  {
    if (this.b != null) {
      return this.b.g();
    }
    return false;
  }
  
  public boolean isSuccess()
  {
    if (this.d == null)
    {
      if (this.a != null) {}
      switch (1.a[this.a.ordinal()])
      {
      default: 
        return false;
      case 1: 
        return isOnlineSuccess();
      case 2: 
        return isOfflineSuccess();
      }
      return isMixSuccess();
    }
    LoggerProxy.d("AuthInfo", "cause=" + this.d.getThrowable().getMessage());
    return false;
  }
  
  public void setOfflineResult(b.a parama)
  {
    this.c = parama;
  }
  
  public void setOnlineResult(c.a parama)
  {
    this.b = parama;
  }
  
  public void setTtsEnum(m paramm)
  {
    this.a = paramm;
  }
  
  public void setTtsError(TtsError paramTtsError)
  {
    this.d = paramTtsError;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/auth/AuthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */