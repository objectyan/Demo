package com.baidu.tts.f;

public enum b
{
  private final String d;
  
  private b(String paramString)
  {
    this.d = paramString;
  }
  
  public static b a(String paramString)
  {
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.a().equals(paramString)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public abstract c[] b();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */