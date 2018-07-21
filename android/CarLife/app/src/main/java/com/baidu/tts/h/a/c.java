package com.baidu.tts.h.a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.f.n;
import java.util.Hashtable;

public class c
{
  private static volatile c a = null;
  private Hashtable<n, b> b = new Hashtable();
  
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
  
  public TtsError a(n paramn, int paramInt)
  {
    return a(paramn, paramInt, null);
  }
  
  public TtsError a(n paramn, int paramInt, String paramString)
  {
    return a(paramn, paramInt, paramString, null);
  }
  
  public TtsError a(n paramn, int paramInt, String paramString, Throwable paramThrowable)
  {
    paramn = b(paramn);
    paramn.setCode(paramInt);
    paramn.setMessage(paramString);
    paramn.setThrowable(paramThrowable);
    return paramn;
  }
  
  public TtsError a(n paramn, String paramString)
  {
    return a(paramn, 0, paramString);
  }
  
  public TtsError a(n paramn, Throwable paramThrowable)
  {
    paramn = b(paramn);
    paramn.setThrowable(paramThrowable);
    return paramn;
  }
  
  public b a(n paramn)
  {
    b localb2 = (b)this.b.get(paramn);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(paramn);
      this.b.put(paramn, localb1);
    }
    return localb1;
  }
  
  public TtsError b(n paramn)
  {
    paramn = a(paramn);
    TtsError localTtsError = new TtsError();
    localTtsError.setTtsErrorFlyweight(paramn);
    return localTtsError;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/h/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */