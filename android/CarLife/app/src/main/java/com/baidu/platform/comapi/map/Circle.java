package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;

public class Circle
  extends Geometry
{
  private static final double DELT = 0.06981317007777778D;
  private static final int DISC_PTS_SIZE = 90;
  private static final double PI = 3.1415926535D;
  private GeoPoint center;
  private float radius;
  
  public Circle(Style paramStyle)
  {
    super(paramStyle);
    this.dataType = 1;
    this.styleType = 3;
  }
  
  private boolean genDifferPoints()
  {
    this.mDifferArray = new double['´'];
    this.mDifferArray[0] = (this.center.getLongitude() + this.radius);
    this.mDifferArray[1] = this.center.getLatitude();
    int i = 1;
    while (i < 90)
    {
      this.mDifferArray[(i * 2)] = (this.radius * (Math.cos(i * 0.06981317007777778D) - Math.cos((i - 1) * 0.06981317007777778D)));
      this.mDifferArray[(i * 2 + 1)] = (this.radius * (Math.sin(i * 0.06981317007777778D) - Math.sin((i - 1) * 0.06981317007777778D)));
      i += 1;
    }
    return true;
  }
  
  private boolean genGeoBound()
  {
    if ((this.center == null) || (this.radius <= 0.0F)) {
      return false;
    }
    this.mLL.setLatitude(this.center.getLatitude() - this.radius);
    this.mLL.setLongitude(this.center.getLongitude() - this.radius);
    this.mRU.setLatitude(this.center.getLatitude() + this.radius);
    this.mRU.setLongitude(this.center.getLongitude() + this.radius);
    return true;
  }
  
  public String getData()
  {
    if (this.isNeedRefresh)
    {
      genGeoBound();
      if (genDifferPoints()) {
        break label35;
      }
    }
    label35:
    for (boolean bool = true;; bool = false)
    {
      this.isNeedRefresh = bool;
      return getData(this.dataType);
    }
  }
  
  public Circle setCenter(GeoPoint paramGeoPoint)
  {
    this.center = paramGeoPoint;
    this.isNeedRefresh = true;
    return this;
  }
  
  public Circle setRadius(float paramFloat)
  {
    this.radius = paramFloat;
    this.isNeedRefresh = true;
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/Circle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */