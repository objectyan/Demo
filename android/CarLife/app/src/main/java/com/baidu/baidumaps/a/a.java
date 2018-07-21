package com.baidu.baidumaps.a;

public class a
{
  public static final int a = 2909;
  public static final int b = 2910;
  public static final int c = 2934;
  public static final int d = 9000;
  private static a e = new a();
  
  public static a a()
  {
    return e;
  }
  
  public boolean a(double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = b.a((int)paramDouble1, (int)paramDouble2);
    }
    return (i == 2909) || ((i >= 2910) && (i <= 2934)) || (i >= 9000);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */