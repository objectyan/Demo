package com.baidu.tts.f;

public enum d
{
  private final String f;
  private final String g;
  
  private d(String paramString1, String paramString2)
  {
    this.f = paramString1;
    this.g = paramString2;
  }
  
  public static d a(String paramString)
  {
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    int i = 0;
    while (i < j)
    {
      d locald = arrayOfd[i];
      if (locald.b().equals(paramString)) {
        return locald;
      }
      i += 1;
    }
    return null;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.g;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */