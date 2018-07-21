package com.baidu.carlife.util;

import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class m
{
  public static final double a = 100000.0D;
  private static m b;
  
  public static m a()
  {
    if (b == null) {
      b = new m();
    }
    return b;
  }
  
  public a b()
  {
    Object localObject = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localObject == null) {
      return null;
    }
    localObject = CoordinateTransformUtil.transferGCJ02ToBD09(((LocData)localObject).longitude, ((LocData)localObject).latitude);
    return new a(((GeoPoint)localObject).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject).getLatitudeE6() / 100000.0D);
  }
  
  public class a
  {
    private double b;
    private double c;
    
    public a(double paramDouble1, double paramDouble2)
    {
      this.b = paramDouble1;
      this.c = paramDouble2;
    }
    
    public double a()
    {
      return this.b;
    }
    
    public void a(double paramDouble)
    {
      this.b = paramDouble;
    }
    
    public double b()
    {
      return this.c;
    }
    
    public void b(double paramDouble)
    {
      this.c = paramDouble;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */