package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchCircle
{
  public GeoPoint mCenter;
  public int mRadius;
  
  public SearchCircle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCenter = new GeoPoint(paramInt1, paramInt2);
    this.mRadius = paramInt3;
  }
  
  public SearchCircle(GeoPoint paramGeoPoint, int paramInt)
  {
    this.mCenter = paramGeoPoint;
    this.mRadius = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/SearchCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */