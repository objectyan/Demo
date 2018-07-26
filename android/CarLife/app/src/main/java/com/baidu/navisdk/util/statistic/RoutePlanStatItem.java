package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RoutePlanStatItem implements StatisitcsDataCheck {
    public static final int LOCATION_TYPE_CELL = 3;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 4;
    public static final int LOCATION_TYPE_OTHER = 0;
    public static final int LOCATION_TYPE_WIFI = 2;
    public static final int SENSOR_ANGLE_DEFUALT = -1;
    public static final int SENSOR_ANGLE_IGNORE = 2;
    public static final int SENSOR_ANGLE_NOT = 0;
    public static final int SENSOR_ANGLE_YES = 1;
    private static final String TAG = RoutePlanStatItem.class.getSimpleName();
    private static RoutePlanStatItem mInstance = null;
    private Long engRoutePlanEndTime = Long.valueOf(0);
    private Long engRoutePlanStartTime = Long.valueOf(0);
    private Long engineTime = Long.valueOf(0);
    public Long enntCostTime = Long.valueOf(0);
    public long intime = -1;
    public int intimeType = -1;
    public String mCalcType = "1";
    public int mCurrLocationType;
    private Bundle mDataCheckBundle = new Bundle();
    int mEntry = 4;
    private int mErrorType = -1;
    public int mHasSensor = -1;
    public int mRecommendPos;
    public int mRouteCount;
    public int mRouteIndex;
    public long mRoutePlanDist;
    public long mRoutePlanTime;
    public long mRouteSwitchEndTime;
    public long mRouteSwitchStartTime;
    public int mStartFromType;
    public boolean mStartNavi;
    private boolean mStatAll = true;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();
    public int mSwitchRouteCount;
    private String osSrc = null;
    public int rouEntry = -1;
    private Long rouPlanDetailViewShowTime = Long.valueOf(0);
    private Long rouPlanDetailViewStartTime = Long.valueOf(0);
    public boolean startRoutePlanStat;

    public static synchronized RoutePlanStatItem getInstance() {
        RoutePlanStatItem routePlanStatItem;
        synchronized (RoutePlanStatItem.class) {
            if (mInstance == null) {
                mInstance = new RoutePlanStatItem();
            }
            routePlanStatItem = mInstance;
        }
        return routePlanStatItem;
    }

    public void setRouPlanDetailViewStartTime(Long mTime) {
        this.rouPlanDetailViewStartTime = mTime;
    }

    public void setEngRoutePlanStartTime(Long mTime) {
        this.engRoutePlanStartTime = mTime;
    }

    public void setEngRoutePlanEndTime(Long mTime) {
        if (this.engRoutePlanEndTime.longValue() == 0) {
            this.engRoutePlanEndTime = mTime;
        }
    }

    public void setRouPlanDetailViewShowTime(Long mTime) {
        if (this.startRoutePlanStat && this.rouPlanDetailViewShowTime.longValue() <= 0) {
            this.rouPlanDetailViewShowTime = mTime;
        }
    }

    public boolean hasOnEven() {
        return this.engRoutePlanStartTime.longValue() == 0;
    }

    public void init() {
        this.mCalcType = "1";
        this.mSwitchRouteCount = 0;
        this.mRouteIndex = 0;
        this.rouPlanDetailViewShowTime = Long.valueOf(0);
        this.mRoutePlanTime = 0;
        this.mRoutePlanDist = 0;
        this.mStartNavi = false;
        this.mRouteCount = 0;
        this.mRouteSwitchEndTime = 0;
        this.mRouteSwitchStartTime = 0;
        this.mRecommendPos = 0;
        this.mEntry = 3;
        this.mCurrLocationType = 0;
        this.mStatAll = true;
        this.mHasSensor = -1;
        this.engineTime = Long.valueOf(0);
        this.mStartFromType = -1;
        this.rouEntry = -1;
        this.rouPlanDetailViewStartTime = Long.valueOf(0);
        this.engRoutePlanStartTime = Long.valueOf(0);
        this.engRoutePlanEndTime = Long.valueOf(0);
        this.startRoutePlanStat = false;
        synchronized (this) {
            this.mErrorType = -1;
        }
        this.mStatPairList = new ArrayList();
        this.mDataCheckBundle.clear();
        LogUtil.m15791e(TAG, "stat test route plan response time init");
    }

    public void setStatAll(boolean all) {
        this.mStatAll = all;
    }

    public void onEvent() {
        checkIfOpenApi();
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_CALTYPE, this.mCalcType));
        this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_CALTYPE, this.mCalcType != null ? this.mCalcType : "null");
        Long mResponseTime = getRoutePlanResponseTime();
        this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(mResponseTime.longValue())));
        this.mDataCheckBundle.putLong("re_time", mResponseTime.longValue());
        if (this.mRouteCount <= 0) {
            this.mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, Integer.toString(this.mRouteCount)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, this.mRouteCount);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_START_FROM_TYPE, Integer.toString(this.mStartFromType)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_START_FROM_TYPE, this.mStartFromType);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROU_ENTRY, Integer.toString(this.rouEntry)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROU_ENTRY, this.rouEntry);
        if (BNaviModuleManager.getLastPreferValue() == RGRouteSortController.getInstance().getPreferValue()) {
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_DEFSORT, "1"));
            this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_DEFSORT, 1);
        } else {
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_DEFSORT, "2"));
            this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_DEFSORT, 2);
        }
        if (this.mStatAll) {
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SELECTTIMES, Integer.toString(this.mSwitchRouteCount)));
            this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SELECTTIMES, this.mSwitchRouteCount);
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RECOMM_POS, this.mRecommendPos + "/" + this.mRouteCount));
            this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RECOMM_POS, this.mRecommendPos + "/" + this.mRouteCount);
            int selectPos = this.mStartNavi ? this.mRouteIndex + 1 : 0;
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SELECT_POS, selectPos + "/" + this.mRouteCount));
            this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SELECT_POS, selectPos + "/" + this.mRouteCount);
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SWITCH_TIME, Long.toString(this.mRouteSwitchEndTime - this.mRouteSwitchStartTime)));
            this.mDataCheckBundle.putLong(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SWITCH_TIME, this.mRouteSwitchEndTime - this.mRouteSwitchStartTime);
            this.mStatPairList.add(new BasicNameValuePair("rou_dis", Long.toString(this.mRoutePlanDist)));
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PLANTIME, Long.toString(this.mRoutePlanTime)));
        } else {
            LogUtil.m15791e(TAG, "do nothing come from in navi or map route");
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, String.valueOf(this.mEntry)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, this.mEntry);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_LOC_TYPE, Integer.toString(this.mCurrLocationType)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_LOC_TYPE, this.mCurrLocationType);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_HAS_SENSOR, Integer.toString(this.mHasSensor)));
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_OS_SRC, this.osSrc));
        this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_OS_SRC, this.osSrc);
        Long engineSumTime = Long.valueOf(this.engRoutePlanEndTime.longValue() - this.engRoutePlanStartTime.longValue());
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_EN_TIME, Long.toString(engineSumTime.longValue())));
        this.mDataCheckBundle.putLong(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_EN_TIME, engineSumTime.longValue());
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENNT_TIME, Long.toString(this.enntCostTime.longValue())));
        this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENNT_TIME, Long.toString(this.enntCostTime.longValue()));
        statRoutePlanTag();
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, null, this.mStatPairList);
        DataCheckCenter.getInstance().check(this);
        init();
    }

    private void checkIfOpenApi() {
        if (this.mEntry == 7) {
            this.osSrc = ProcessManagerUtils.getOpenApiStatFlag();
        } else {
            this.osSrc = "0";
        }
    }

    public void setErrorCode(int errorCode) {
        synchronized (this) {
            this.mErrorType = errorCode;
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, "-" + Integer.toString(this.mErrorType)));
            this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, -this.mErrorType);
            SDKDebugUtil.getInstance().recordRPErrorCode(-this.mErrorType);
        }
        statRoutePlanTag();
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_CALTYPE, this.mCalcType != null ? this.mCalcType : "null"));
        if (errorCode < 5000) {
            Long mResponseTime = getRoutePlanResponseTime();
            this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(mResponseTime.longValue())));
            this.mDataCheckBundle.putLong("re_time", mResponseTime.longValue());
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, String.valueOf(this.mEntry)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, this.mEntry);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_HAS_SENSOR, Integer.toString(this.mHasSensor)));
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, null, this.mStatPairList);
        DataCheckCenter.getInstance().check(this);
        init();
    }

    private void statRoutePlanTag() {
        int pref = BNRoutePlaner.getInstance().getCalcPreference();
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ROUTETAG, Integer.toString(pref)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ROUTETAG, pref);
    }

    public void setCalcType(String calcType) {
        this.mCalcType = calcType;
    }

    public String getCalcType() {
        return this.mCalcType;
    }

    public void setResponseTime(long time) {
        LogUtil.m15791e(TAG, "stat test setresponsetime time = " + time);
    }

    private Long getRoutePlanResponseTime() {
        if (this.rouPlanDetailViewShowTime.longValue() == 0 || this.rouPlanDetailViewStartTime.longValue() <= 0) {
            return Long.valueOf(-1);
        }
        Long resposeTime = Long.valueOf(this.rouPlanDetailViewShowTime.longValue() - this.rouPlanDetailViewStartTime.longValue());
        if (resposeTime.longValue() < 0) {
            return Long.valueOf(-1);
        }
        return resposeTime;
    }

    public void setRoutePlanTimeAndDist(long routePlanTime, long routePlanDist) {
        this.mRoutePlanTime = routePlanTime;
        this.mRoutePlanDist = routePlanDist;
    }

    public void setRecommendRoutePos(int recommendPos) {
        this.mRecommendPos = recommendPos;
    }

    public void setEntry(int entry) {
        this.mEntry = entry;
    }

    public int getEntry() {
        return this.mEntry;
    }

    public void setCurrLocationType(int locType, boolean isWifiLocType) {
        switch (locType) {
            case 61:
                this.mCurrLocationType = 1;
                return;
            case 66:
            case 68:
                this.mCurrLocationType = 4;
                return;
            case 161:
                if (isWifiLocType) {
                    this.mCurrLocationType = 2;
                    return;
                } else {
                    this.mCurrLocationType = 3;
                    return;
                }
            default:
                this.mCurrLocationType = 0;
                return;
        }
    }

    public String getID() {
        return "50002";
    }

    public Bundle getDataBundle() {
        return this.mDataCheckBundle;
    }
}
