package com.baidu.location.indoor.b;

final class c
{
  double a;
  double b;
  int c = Integer.MAX_VALUE;
  int d = Integer.MAX_VALUE;
  int e = Integer.MAX_VALUE;
  
  private double a(double paramDouble1, double paramDouble2)
  {
    return Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
  }
  
  double a()
  {
    return a(this.a, this.b);
  }
  
  double a(c paramc)
  {
    return Math.sqrt((this.a - paramc.a) * (this.a - paramc.a) + (this.b - paramc.b) * (this.b - paramc.b));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */