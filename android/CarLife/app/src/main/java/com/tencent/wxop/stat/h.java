package com.tencent.wxop.stat;

public enum h
{
  int h;
  
  private h(int paramInt)
  {
    this.h = paramInt;
  }
  
  public static h a(int paramInt)
  {
    h[] arrayOfh = values();
    int k = arrayOfh.length;
    int j = 0;
    while (j < k)
    {
      h localh = arrayOfh[j];
      if (paramInt == localh.a()) {
        return localh;
      }
      j += 1;
    }
    return null;
  }
  
  public final int a()
  {
    return this.h;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */