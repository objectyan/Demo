package com.baidu.location.indoor;

import java.util.List;

public class g
{
  private static double a = 6378137.0D;
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 * paramDouble2 == -1.0D) {
      return 90.0D;
    }
    return Math.toDegrees(Math.atan(paramDouble2 - paramDouble1 / (1.0D + paramDouble1 * paramDouble2)));
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d2 = Math.toRadians(paramDouble1);
    Math.toRadians(paramDouble2);
    double d1 = Math.toRadians(paramDouble3);
    Math.toRadians(paramDouble4);
    paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
    paramDouble3 = Math.toRadians(paramDouble3 - paramDouble1);
    paramDouble1 = Math.sin(paramDouble3 / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    paramDouble4 = Math.cos(d2);
    d1 = Math.cos(d1);
    d2 = Math.sin(paramDouble2 / 2.0D);
    paramDouble1 = Math.sin(paramDouble2 / 2.0D) * (paramDouble4 * d1 * d2) + paramDouble3 * paramDouble1;
    return Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * a;
  }
  
  public static double a(List<Float> paramList)
  {
    double d1 = ((Float)paramList.get(0)).floatValue();
    int i = 1;
    double d2 = d1;
    if (i < paramList.size())
    {
      double d3 = ((Float)paramList.get(i)).floatValue() - d1;
      if (d3 < -180.0D) {
        d1 = d1 + d3 + 360.0D;
      }
      for (;;)
      {
        d2 += d1;
        i += 1;
        break;
        if (d3 < 180.0D) {
          d1 += d3;
        } else {
          d1 = d1 + d3 - 360.0D;
        }
      }
    }
    return d2 / paramList.size();
  }
  
  public static double b(double paramDouble1, double paramDouble2)
  {
    paramDouble2 -= paramDouble1;
    if (paramDouble2 > 180.0D) {
      paramDouble1 = paramDouble2 - 360.0D;
    }
    do
    {
      return paramDouble1;
      paramDouble1 = paramDouble2;
    } while (paramDouble2 >= -180.0D);
    return paramDouble2 + 360.0D;
  }
  
  public static double b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = Math.toRadians(paramDouble2);
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble3);
    paramDouble3 = Math.toRadians(paramDouble4) - d1;
    paramDouble4 = Math.sin(paramDouble3);
    d1 = Math.cos(paramDouble2);
    double d2 = Math.cos(paramDouble1);
    double d3 = Math.sin(paramDouble2);
    paramDouble1 = Math.sin(paramDouble1);
    paramDouble2 = Math.cos(paramDouble2);
    return (Math.toDegrees(Math.atan2(paramDouble4 * d1, d2 * d3 - Math.cos(paramDouble3) * (paramDouble1 * paramDouble2))) + 360.0D) % 360.0D;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */