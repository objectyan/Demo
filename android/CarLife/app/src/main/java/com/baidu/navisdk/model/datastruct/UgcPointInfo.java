package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class UgcPointInfo {
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

    public UgcPointInfo() {
        this.mUgcPointIdx = -1;
        this.mUgcPointRoadName = null;
        this.longitude = 0;
        this.latitude = 0;
        this.mViewPoint = null;
    }

    public UgcPointInfo(int ugcPointIdx, String ugcPointRoadName, int longi, int lati) {
        this.mUgcPointIdx = ugcPointIdx;
        this.mUgcPointRoadName = ugcPointRoadName;
        this.longitude = longi;
        this.latitude = lati;
        this.mViewPoint = new GeoPoint(this.longitude, this.latitude);
    }

    public void setUgcViewPoint(int longi, int lati) {
        this.mViewPoint = new GeoPoint(longi, lati);
    }
}
