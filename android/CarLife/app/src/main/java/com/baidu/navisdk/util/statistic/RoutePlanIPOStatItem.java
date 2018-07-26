package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RoutePlanIPOStatItem extends RoutePlanStatItem {
    private static final String TAG = RoutePlanIPOStatItem.class.getSimpleName();
    private static RoutePlanIPOStatItem mInstance = null;
    private Bundle mDataCheckBundle = new Bundle();
    private int mErrorType = -1;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();

    public static synchronized RoutePlanIPOStatItem getInstance() {
        RoutePlanIPOStatItem routePlanIPOStatItem;
        synchronized (RoutePlanIPOStatItem.class) {
            if (mInstance == null) {
                mInstance = new RoutePlanIPOStatItem();
            }
            routePlanIPOStatItem = mInstance;
        }
        return routePlanIPOStatItem;
    }

    public void init() {
        super.init();
        this.mCalcType = "1";
        this.mSwitchRouteCount = 0;
        this.mRouteIndex = 0;
        this.mRoutePlanTime = 0;
        this.mRoutePlanDist = 0;
        this.mStartNavi = false;
        this.mRouteCount = 0;
        this.mRouteSwitchEndTime = 0;
        this.mRouteSwitchStartTime = 0;
        this.mRecommendPos = 0;
        this.mEntry = 3;
        this.mCurrLocationType = 0;
        synchronized (this) {
            this.mErrorType = -1;
        }
        this.mStatPairList = new ArrayList();
        this.mDataCheckBundle.clear();
        LogUtil.m15791e(TAG, "stat test route plan response time init");
    }

    public void onEvent() {
        this.mRouteCount = 1;
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, Integer.toString(this.mRouteCount)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, this.mRouteCount);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, String.valueOf(this.mEntry)));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, this.mEntry);
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, null, this.mStatPairList);
        DataCheckCenter.getInstance().check(this);
        SDKDebugUtil.getInstance().recordRPErrorCode(this.mRouteCount);
        init();
    }

    public void setErrorCode(int errorCode) {
        synchronized (this) {
            this.mErrorType = errorCode;
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, "-" + Integer.toString(this.mErrorType)));
            this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_RET, -this.mErrorType);
            SDKDebugUtil.getInstance().recordRPErrorCode(-this.mErrorType);
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, String.valueOf(this.mEntry)));
        this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_ROUTEPLAN_ENTRY, String.valueOf(this.mEntry));
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, null, this.mStatPairList);
        DataCheckCenter.getInstance().check(this);
        init();
    }
}
