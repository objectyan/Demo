package com.baidu.baidunavis.model;

import android.os.Bundle;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;

public class TrajectorySummaryInfo
{
  public static final int TRAJECTORY_FROM_EDOG = 1;
  public static final int TRAJECTORY_FROM_MAP_EDOG = 3;
  public static final int TRAJECTORY_FROM_MAP_NAVI = 2;
  public static final int TRAJECTORY_FROM_MAP_SLIGHT_NAVI = 6;
  public static final int TRAJECTORY_FROM_NAVIGATION = 0;
  public boolean bIsChangedKey;
  public String clBduss;
  public String clCUID;
  public String clDataSign;
  public String clEndLatitude;
  public String clEndLongtitude;
  public String clEndName;
  public String clPoiID;
  public String clSessionID;
  public String clSessionSign;
  public String clTrackID;
  public String clUrl;
  public float mAverageSpeed;
  public int mBusinessPoi = -1;
  public long mDate;
  public float mDistance;
  public long mDuration;
  public int mFromType;
  public boolean mHasGpsMock = RGCacheStatus.sMockGpsGuide;
  public boolean mHasSync;
  public int mLastestRequestID;
  public float mMaxSpeed;
  public String mName;
  public String mUUID;
  public int nKeyVersion;
  public long ulCreateTime;
  public int unMileageDist;
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("guid", this.mUUID);
    if ((this.mName != null) && (this.mName.length() > 0))
    {
      String[] arrayOfString = this.mName.split("->");
      if ((arrayOfString != null) && (arrayOfString.length >= 2))
      {
        localBundle.putString("start_addr", arrayOfString[0]);
        localBundle.putString("end_addr", arrayOfString[1]);
      }
    }
    localBundle.putString("distance", "" + (int)this.mDistance);
    localBundle.putString("c_time", "" + (int)this.mDate);
    localBundle.putString("duration", "" + (int)this.mDuration);
    localBundle.putString("ave_speed", "" + this.mAverageSpeed);
    localBundle.putBoolean("has_gps_mock", this.mHasGpsMock);
    localBundle.putInt("mileageDist", this.unMileageDist);
    localBundle.putLong("createTime", this.ulCreateTime);
    localBundle.putBoolean("isChangedKey", this.bIsChangedKey);
    localBundle.putInt("keyVersion", this.nKeyVersion);
    localBundle.putString("clTrackID", this.clTrackID);
    localBundle.putString("clCUID", this.clCUID);
    localBundle.putString("clSessionID", this.clSessionID);
    localBundle.putString("clBduss", this.clBduss);
    localBundle.putString("clPoiID", this.clPoiID);
    localBundle.putString("clDataSign", this.clDataSign);
    localBundle.putString("clSessionSign", this.clSessionSign);
    localBundle.putInt(NavMapAdapter.getInstance().getEnerGyRequestIDBundleKey(), NavTrajectoryController.getInstance().mLastestRequestID);
    localBundle.putString("clEndLatitude", this.clEndLatitude);
    localBundle.putString("clEndLongtitude", this.clEndLongtitude);
    localBundle.putString("clEndName", this.clEndName);
    return localBundle;
  }
  
  public String toString()
  {
    return "uuid:" + this.mUUID + ", name:" + this.mName + ", hasSync:" + this.mHasSync + ", distance:" + this.mDistance + ", date:" + this.mDate + ", duration:" + this.mDuration + ", speed:" + this.mAverageSpeed + ", mFromType:" + this.mFromType + ", mHasGpsMock:" + this.mHasGpsMock;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/TrajectorySummaryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */