package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

public abstract interface Projection
{
  public abstract GeoPoint fromPixels(int paramInt1, int paramInt2);
  
  public abstract float metersToEquatorPixels(float paramFloat);
  
  public abstract Point toPixels(GeoPoint paramGeoPoint, Point paramPoint);
  
  public abstract Point world2Screen(float paramFloat1, float paramFloat2, float paramFloat3);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */