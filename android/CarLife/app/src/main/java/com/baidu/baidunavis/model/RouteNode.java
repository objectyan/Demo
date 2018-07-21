package com.baidu.baidunavis.model;

import com.baidu.platform.comapi.map.MapStatus.GeoBound;

public class RouteNode
{
  public static final int From_Company = 5;
  public static final int From_Home = 4;
  public static final int From_Keyword = 2;
  public static final int From_MulRoutePlan = 99;
  public static final int From_MyLoc = 3;
  public static final int From_Pos = 1;
  public static final int From_UID = 0;
  public String mAddr = null;
  public double mAltitude = -1.0D;
  public int mBusinessPoi = -1;
  public int mCityID = -1;
  public int mFromType = -1;
  public float mGPSAccuracy = -2.0F;
  public float mGPSAngle = -1.0F;
  public float mGPSSpeed = -2.0F;
  public NavGeoPoint mGeoPoint = null;
  public int mIndex = -99999;
  public float mLevel = -1.0F;
  public int mLocType = -1;
  public MapStatus.GeoBound mMapGeoBound = null;
  public String mName = null;
  public String mNetworkLocStr = null;
  public int mNodeType = -1;
  public int mProvinceID = -1;
  public String mUID = null;
  
  public void resetIndex()
  {
    this.mIndex = -99999;
  }
  
  public static class SubNodeType
  {
    public static final int From_Keyword = 2;
    public static final int From_MyLoc = 3;
    public static final int From_Pos = 1;
    public static final int From_Sug = 4;
    public static final int From_UID = 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/RouteNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */