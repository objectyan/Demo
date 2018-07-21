package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class UgcPointInfo
{
  public int latitude;
  public int longitude;
  public int mUgPermitType;
  public String mUgcDistrictName;
  public String mUgcId;
  public int mUgcPointIdx;
  public String mUgcPointRoadName;
  public int mUgcSyncStatus;
  public String mUgcTime;
  public int mUgcType;
  public GeoPoint mViewPoint;
  
  public UgcPointInfo()
  {
    this.mUgcPointIdx = -1;
    this.mUgcPointRoadName = null;
    this.longitude = 0;
    this.latitude = 0;
    this.mViewPoint = null;
  }
  
  public UgcPointInfo(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.mUgcPointIdx = paramInt1;
    this.mUgcPointRoadName = paramString;
    this.longitude = paramInt2;
    this.latitude = paramInt3;
    this.mViewPoint = new GeoPoint(this.longitude, this.latitude);
  }
  
  public void setUgcViewPoint(int paramInt1, int paramInt2)
  {
    this.mViewPoint = new GeoPoint(paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/UgcPointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */