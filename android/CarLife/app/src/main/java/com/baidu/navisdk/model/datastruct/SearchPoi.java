package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchPoi {
    public static final int POI_TYPE_CHILD = 1;
    public static final int POI_TYPE_CITY_LIST = 1;
    public static final int POI_TYPE_NORMAL = 0;
    public static final int POI_TYPE_PARENT = 0;
    public String mAddress;
    public String mAliasName;
    public int mChildCnt;
    public int mDistrictId;
    public int mFCType;
    public GeoPoint mGuidePoint;
    public int mId;
    public String mName;
    public String mOriginUID = null;
    public String mPhone;
    public int mPoiCount;
    public int mShowCatalog;
    public String mStreetId;
    public int mType;
    public String mUid = null;
    public GeoPoint mViewPoint;
    public int mWanda;
    public int mWeight;

    public SearchPoi(SearchPoi poi) {
        copy(poi);
    }

    public void copy(SearchPoi poi) {
        if (poi != null) {
            if (poi.mName != null) {
                this.mName = new String(poi.mName);
            } else {
                this.mName = "";
            }
            if (poi.mAddress != null) {
                this.mAddress = new String(poi.mAddress);
            } else {
                this.mAddress = "";
            }
            if (poi.mPhone != null) {
                this.mPhone = new String(poi.mPhone);
            } else {
                this.mPhone = "";
            }
            if (poi.mGuidePoint != null) {
                this.mGuidePoint = new GeoPoint(poi.mGuidePoint.getLongitudeE6(), poi.mGuidePoint.getLatitudeE6());
            } else {
                this.mGuidePoint = new GeoPoint();
            }
            if (poi.mViewPoint != null) {
                this.mViewPoint = new GeoPoint(poi.mViewPoint.getLongitudeE6(), poi.mViewPoint.getLatitudeE6());
            } else {
                this.mViewPoint = new GeoPoint();
            }
            this.mDistrictId = poi.mDistrictId;
            this.mType = poi.mType;
            if (poi.mStreetId != null) {
                this.mStreetId = new String(poi.mStreetId);
            } else {
                this.mStreetId = null;
            }
            if (poi.mOriginUID != null) {
                this.mOriginUID = new String(poi.mOriginUID);
            } else {
                this.mOriginUID = null;
            }
            this.mId = poi.mId;
        }
    }
}
