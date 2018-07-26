package com.baidu.navisdk.comapi.trajectory;

import java.io.Serializable;

public class NaviTrajectory implements Serializable {
    public static final int TRAJECTORY_FROM_EDOG = 1;
    public static final int TRAJECTORY_FROM_NAVIGATION = 0;
    private static final long serialVersionUID = -7553390785996603989L;
    public boolean bIsChangedKey;
    public String clBduss;
    public String clCUID;
    public String clDataSign;
    public String clPoiID;
    public String clSessionID;
    public String clSessionSign;
    public String clTrackID;
    public String clUrl;
    public float mAverageSpeed;
    public long mDate;
    public float mDistance;
    public long mDuration;
    public int mFromType;
    public boolean mHasSync;
    public float mMaxSpeed;
    public String mName;
    public String mUUID;
    public int nKeyVersion;
    public long ulCreateTime;
    public int unMileageDist;

    public String toString() {
        return "uuid:" + this.mUUID + ", name:" + this.mName + ", hasSync:" + this.mHasSync + ", distance:" + this.mDistance + ", date:" + this.mDate + ", duration:" + this.mDuration + ", speed:" + this.mAverageSpeed + ", mFromType:" + this.mFromType;
    }
}
