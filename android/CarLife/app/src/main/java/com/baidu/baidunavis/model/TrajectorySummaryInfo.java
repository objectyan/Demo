package com.baidu.baidunavis.model;

import android.os.Bundle;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;

public class TrajectorySummaryInfo {
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

    public Bundle toBundle() {
        Bundle data = new Bundle();
        data.putString("guid", this.mUUID);
        if (this.mName != null && this.mName.length() > 0) {
            String[] ss = this.mName.split("->");
            if (ss != null && ss.length >= 2) {
                data.putString(DataBaseConstants.START_ADDR, ss[0]);
                data.putString(DataBaseConstants.END_ADDR, ss[1]);
            }
        }
        data.putString("distance", "" + ((int) this.mDistance));
        data.putString("c_time", "" + ((int) this.mDate));
        data.putString("duration", "" + ((int) this.mDuration));
        data.putString("ave_speed", "" + ((double) this.mAverageSpeed));
        data.putBoolean("has_gps_mock", this.mHasGpsMock);
        data.putInt("mileageDist", this.unMileageDist);
        data.putLong("createTime", this.ulCreateTime);
        data.putBoolean("isChangedKey", this.bIsChangedKey);
        data.putInt("keyVersion", this.nKeyVersion);
        data.putString("clTrackID", this.clTrackID);
        data.putString("clCUID", this.clCUID);
        data.putString("clSessionID", this.clSessionID);
        data.putString("clBduss", this.clBduss);
        data.putString("clPoiID", this.clPoiID);
        data.putString("clDataSign", this.clDataSign);
        data.putString("clSessionSign", this.clSessionSign);
        data.putInt(NavMapAdapter.getInstance().getEnerGyRequestIDBundleKey(), NavTrajectoryController.getInstance().mLastestRequestID);
        data.putString("clEndLatitude", this.clEndLatitude);
        data.putString("clEndLongtitude", this.clEndLongtitude);
        data.putString("clEndName", this.clEndName);
        return data;
    }

    public String toString() {
        return "uuid:" + this.mUUID + ", name:" + this.mName + ", hasSync:" + this.mHasSync + ", distance:" + this.mDistance + ", date:" + this.mDate + ", duration:" + this.mDuration + ", speed:" + this.mAverageSpeed + ", mFromType:" + this.mFromType + ", mHasGpsMock:" + this.mHasGpsMock;
    }
}
