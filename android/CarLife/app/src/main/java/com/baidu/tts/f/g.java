package com.baidu.tts.f;

public enum g
{
  private final String aj;
  private final String ak;
  private final String al;
  
  private g(String paramString1, String paramString2, String paramString3)
  {
    this.aj = paramString1;
    this.ak = paramString2;
    this.al = paramString3;
  }
  
  public static String a(g paramg)
  {
    if (paramg == null) {
      return null;
    }
    return paramg.name();
  }
  
  public String a()
  {
    return this.aj;
  }
  
  public String b()
  {
    return this.ak;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */