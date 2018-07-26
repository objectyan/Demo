package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class DistrictInfo {
    public static final int DISTRICT_ID_INVALID = -1;
    public static final int DISTRICT_TYPE_CITY = 3;
    public static final int DISTRICT_TYPE_COUNTY = 4;
    public static final int DISTRICT_TYPE_INVALID = -1;
    public static final int DISTRICT_TYPE_NATION = 1;
    public static final int DISTRICT_TYPE_PROVINCE = 2;
    public static final int DISTRICT_TYPE_WORLD = 0;
    public int mChildCount;
    public int mCityId;
    public int mId = -1;
    public String mName;
    public GeoPoint mPoint;
    public int mProvinceId;
    public int mType = -1;

    public void copy(DistrictInfo district) {
        if (district != null) {
            this.mType = district.mType;
            this.mId = district.mId;
            this.mName = district.mName;
            this.mChildCount = district.mChildCount;
            this.mPoint = district.mPoint;
        }
    }

    public String toString() {
        return "type " + this.mType + ", id " + this.mId + ", name: " + this.mName;
    }
}
