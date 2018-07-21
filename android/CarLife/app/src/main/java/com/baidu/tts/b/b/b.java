package com.baidu.tts.b.b;

import com.baidu.tts.b.b.b.c;

public class b
{
  private static volatile b a = null;
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private com.baidu.tts.b.b.b.b c()
  {
    return new com.baidu.tts.b.b.b.b();
  }
  
  public c b()
  {
    return c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */