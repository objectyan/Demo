package com.baidu.platform.comapi.basestruct;

public class GeoPoint
{
  private double mLatitude;
  private double mLongitude;
  
  public GeoPoint(double paramDouble1, double paramDouble2)
  {
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.mLatitude = paramInt1;
    this.mLongitude = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject.getClass() == getClass()) && (Math.abs(this.mLatitude - ((GeoPoint)paramObject).mLatitude) <= 1.0E-6D) && (Math.abs(this.mLongitude - ((GeoPoint)paramObject).mLongitude) <= 1.0E-6D)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public int getLatitudeE6()
  {
    return (int)this.mLatitude;
  }
  
  public double getLongitude()
  {
    return this.mLongitude;
  }
  
  public int getLongitudeE6()
  {
    return (int)this.mLongitude;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public void setLatitude(double paramDouble)
  {
    this.mLatitude = paramDouble;
  }
  
  public void setLatitude(int paramInt)
  {
    this.mLatitude = paramInt;
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.mLatitude = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.mLongitude = paramDouble;
  }
  
  public void setLongitude(int paramInt)
  {
    this.mLongitude = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.mLongitude = paramInt;
  }
  
  public String toString()
  {
    return "GeoPoint: Latitude: " + this.mLatitude + ", Longitude: " + this.mLongitude;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/basestruct/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */