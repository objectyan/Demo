package com.baidu.navisdk.model.datastruct;

public class RoutePlanResultItem {
    public int angle = 0;
    private String mBubleDesc;
    private int mIconResId;
    private int mLatitude;
    private int mLongitude;
    private int mRoadCondition;
    private String mRouteNodeDesc;
    private String mRouteNodeDescNight;
    public String roadName = "";

    public int getIconResId() {
        return this.mIconResId;
    }

    public String getNodeDesc() {
        return this.mRouteNodeDesc;
    }

    public String getNodeDescNight() {
        return this.mRouteNodeDescNight;
    }

    public String getNextRoadName() {
        return this.mBubleDesc;
    }

    public int getLongitude() {
        return this.mLongitude;
    }

    public int getLatitude() {
        return this.mLatitude;
    }

    public int getRoadCondition() {
        return this.mRoadCondition;
    }

    public RoutePlanResultItem(int mResId, String nodeDesc, String nodeDescNight, String bubleDesc, int longitude, int latitude, int roadCondition) {
        this.mIconResId = mResId;
        this.mRouteNodeDesc = nodeDesc;
        this.mRouteNodeDescNight = nodeDescNight;
        this.mBubleDesc = bubleDesc;
        this.mLongitude = longitude;
        this.mLatitude = latitude;
        this.mRoadCondition = roadCondition;
    }
}
