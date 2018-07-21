package com.baidu.baidunavis.model;

public class NavSearchCircle
{
  public NavGeoPoint mCenter;
  public int mRadius;
  
  public NavSearchCircle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCenter = new NavGeoPoint(paramInt1, paramInt2);
    this.mRadius = paramInt3;
  }
  
  public NavSearchCircle(NavGeoPoint paramNavGeoPoint, int paramInt)
  {
    this.mCenter = paramNavGeoPoint;
    this.mRadius = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavSearchCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */