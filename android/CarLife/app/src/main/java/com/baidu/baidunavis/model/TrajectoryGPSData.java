package com.baidu.baidunavis.model;

public class TrajectoryGPSData {
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

    public boolean isEnable() {
        return (this.mLongitude == 0.0d || this.mLatitude == 0.0d || this.mSpeed == 0.0f) ? false : true;
    }

    public String toString() {
        return "mSpeed:" + this.mSpeed + " mBearing:" + this.mBearing + " mAccuracy:" + this.mAccuracy;
    }
}
