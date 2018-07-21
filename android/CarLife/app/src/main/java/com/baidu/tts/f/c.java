package com.baidu.tts.f;

public enum c
{
  private final String v;
  private final String w;
  private final double x;
  
  private c(String paramString1, String paramString2, double paramDouble)
  {
    this.v = paramString1;
    this.w = paramString2;
    this.x = paramDouble;
  }
  
  public static c a(String paramString)
  {
    c[] arrayOfc = values();
    int i2 = arrayOfc.length;
    int i1 = 0;
    while (i1 < i2)
    {
      c localc = arrayOfc[i1];
      if (localc.a().equals(paramString)) {
        return localc;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static c[] c()
  {
    return new c[] { a };
  }
  
  public static c[] d()
  {
    return new c[] { b, c, d, e, f, g, h, i, j };
  }
  
  public static c[] e()
  {
    return new c[] { k, l, m, n, o, p };
  }
  
  public String a()
  {
    return this.w;
  }
  
  public double b()
  {
    return this.x;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */