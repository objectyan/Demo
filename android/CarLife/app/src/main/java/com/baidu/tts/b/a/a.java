package com.baidu.tts.b.a;

import com.baidu.tts.b.a.a.c;
import com.baidu.tts.b.a.b.b;
import com.baidu.tts.b.a.b.e;

public class a
{
  private static volatile a a = null;
  
  private com.baidu.tts.b.a.a.d a(b paramb)
  {
    c localc = new c();
    localc.a(paramb);
    return localc;
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private com.baidu.tts.b.a.a.d b()
  {
    return a(new com.baidu.tts.b.a.b.f());
  }
  
  private com.baidu.tts.b.a.a.d c()
  {
    return a(new e());
  }
  
  private com.baidu.tts.b.a.a.d d()
  {
    return a(new com.baidu.tts.b.a.b.d());
  }
  
  public com.baidu.tts.b.a.a.d a(com.baidu.tts.f.f paramf)
  {
    switch (1.a[paramf.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return b();
    case 2: 
      return c();
    }
    return d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */