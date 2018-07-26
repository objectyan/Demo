package com.baidu.navisdk.model.datastruct;

import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;

public class RoutePlanOutlineItem {
    public static int ROADCONDITION_TYPE_INVALID = 0;
    public static int ROADCONDITION_TYPE_OBSTRUCTION = 3;
    public static int ROADCONDITION_TYPE_SLOW = 2;
    public static int ROADCONDITION_TYPE_STRAIGHTWAY = 1;
    private double mLength;
    private int mLights;
    private String mMainroads;
    private double mPassTime;
    private int mRouteId;
    private String mStrTotalRoadCondition;
    private boolean mTipsHasClosed = false;
    private int mToll;
    private int mTotalRoadCondition;
    private int pusLabelID;
    private String pusLabelName;
    private String pusLabelTips;

    public boolean isTipsHasClosed() {
        return this.mTipsHasClosed;
    }

    public void setTipsHasClosed(boolean mTipsHasClosed) {
        this.mTipsHasClosed = mTipsHasClosed;
    }

    public int getRoutId() {
        return this.mRouteId;
    }

    public String getMainroads() {
        return this.mMainroads;
    }

    public int getToll() {
        return this.mToll;
    }

    public int getLights() {
        return this.mLights;
    }

    public int getTotalRoadCondition() {
        return this.mTotalRoadCondition;
    }

    public String getStrTotalRoadCondition() {
        return this.mStrTotalRoadCondition;
    }

    public double getLength() {
        return this.mLength;
    }

    public double getPassTime() {
        return this.mPassTime;
    }

    public String getPassTimeStr() {
        return StringUtils.formatTime2((int) this.mPassTime, 2);
    }

    public String getLengthStr() {
        StringBuffer dist = new StringBuffer();
        StringUtils.formatDistance((int) this.mLength, UnitLangEnum.ZH, dist);
        return dist.toString();
    }

    public String getPusLabelName() {
        return this.pusLabelName;
    }

    public void setPusLabelName(String pusLabelName) {
        this.pusLabelName = pusLabelName;
    }

    public String getPusLabelTips() {
        return this.pusLabelTips;
    }

    public void setPusLabelTips(String pusLabelTips) {
        this.pusLabelTips = pusLabelTips;
    }

    public int getPusLabelID() {
        return this.pusLabelID;
    }

    public RoutePlanOutlineItem(int routeId, String mainroads, int toll, int lights, int totalRoadCondition, double length, double passTime, String pusLabelName, String pusLabelTips, int pusLabelID) {
        this.mRouteId = routeId;
        this.mMainroads = mainroads;
        this.mTotalRoadCondition = totalRoadCondition;
        this.mLength = length;
        this.mPassTime = passTime;
        this.mToll = toll;
        this.mLights = lights;
        this.pusLabelName = pusLabelName;
        this.pusLabelTips = pusLabelTips;
        this.pusLabelID = pusLabelID;
        if (totalRoadCondition == ROADCONDITION_TYPE_INVALID) {
            this.mStrTotalRoadCondition = "无效";
        } else if (totalRoadCondition == ROADCONDITION_TYPE_STRAIGHTWAY) {
            this.mStrTotalRoadCondition = "顺畅";
        } else if (totalRoadCondition == ROADCONDITION_TYPE_SLOW) {
            this.mStrTotalRoadCondition = "缓慢";
        } else if (totalRoadCondition == ROADCONDITION_TYPE_OBSTRUCTION) {
            this.mStrTotalRoadCondition = "拥堵";
        } else {
            this.mStrTotalRoadCondition = "无效";
        }
    }
}
