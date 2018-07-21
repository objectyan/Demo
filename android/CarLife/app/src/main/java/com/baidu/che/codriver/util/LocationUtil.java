package com.baidu.che.codriver.util;

import com.baidu.che.codriver.sdk.a.m;

public class LocationUtil
  implements INoProguard
{
  public static final String COORDINATE_SYSTEM_BD09 = "bd09ll";
  public static final String COORDINATE_SYSTEM_GCJ02 = "gcj02ll";
  private static LocationUtil mInstance;
  private String mCoordinateSystem = "gcj02ll";
  private m mNaviTool;
  
  public static LocationUtil getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null)
      {
        mInstance = new LocationUtil();
        LocationUtil localLocationUtil = mInstance;
        return localLocationUtil;
      }
      return mInstance;
    }
    finally {}
  }
  
  public double calculateDistance(double paramDouble1, double paramDouble2)
  {
    if (this.mNaviTool == null) {
      return -1.0D;
    }
    return this.mNaviTool.calculateDistance(paramDouble1, paramDouble2);
  }
  
  public String getCity()
  {
    if (this.mNaviTool == null) {
      return "";
    }
    return this.mNaviTool.getCity();
  }
  
  public String getCoordinateSysmem()
  {
    return this.mCoordinateSystem;
  }
  
  public double getLatitude()
  {
    if (this.mNaviTool == null) {
      return 39.912733D;
    }
    return this.mNaviTool.getLatitude();
  }
  
  public double getLatitudeBd09ll()
  {
    if (this.mNaviTool == null) {
      return 39.912733D;
    }
    return this.mNaviTool.getLatitudeBd09ll();
  }
  
  public double getLatitudeBd09mc()
  {
    if (this.mNaviTool == null) {
      return 4443113.458D;
    }
    return this.mNaviTool.getLatitudeBd09mc();
  }
  
  public double getLongitude()
  {
    if (this.mNaviTool == null) {
      return 116.403963D;
    }
    return this.mNaviTool.getLongitude();
  }
  
  public double getLongitudeBd09ll()
  {
    if (this.mNaviTool == null) {
      return 116.403963D;
    }
    return this.mNaviTool.getLongitudeBd09ll();
  }
  
  public double getLongitudeBd09mc()
  {
    if (this.mNaviTool == null) {
      return 1.2474104174E7D;
    }
    return this.mNaviTool.getLongitudeBd09mc();
  }
  
  public boolean isReady()
  {
    if (this.mNaviTool == null) {
      return false;
    }
    return this.mNaviTool.isLocationReady();
  }
  
  public void setCoordinateSystem(String paramString)
  {
    this.mCoordinateSystem = paramString;
  }
  
  public void setNaviTool(m paramm)
  {
    this.mNaviTool = paramm;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/LocationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */