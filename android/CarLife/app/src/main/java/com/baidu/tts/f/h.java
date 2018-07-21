package com.baidu.tts.f;

public enum h
{
  private final String c;
  private final String d;
  
  private h(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public static h a(String paramString)
  {
    h[] arrayOfh = values();
    int j = arrayOfh.length;
    int i = 0;
    while (i < j)
    {
      h localh = arrayOfh[i];
      if (localh.a().equalsIgnoreCase(paramString)) {
        return localh;
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */