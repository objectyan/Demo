package com.baidu.baidunavis.model;

public class TrajectoryGPSData
{
  public boolean bBrake;
  public boolean bCurve;
  public boolean bMaxSpeed;
  public boolean bOverSpeed;
  public boolean bRapidAcc;
  public boolean bYaw;
  public float fMaxSpeed;
  public float mAccuracy;
  public float mBearing;
  public long mGpsTime;
  public double mLatitude;
  public double mLongitude;
  public float mSpeed;
  public int unLimitSpeed;
  
  public boolean isEnable()
  {
    return (this.mLongitude != 0.0D) && (this.mLatitude != 0.0D) && (this.mSpeed != 0.0F);
  }
  
  public String toString()
  {
    return "mSpeed:" + this.mSpeed + " mBearing:" + this.mBearing + " mAccuracy:" + this.mAccuracy;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/TrajectoryGPSData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */