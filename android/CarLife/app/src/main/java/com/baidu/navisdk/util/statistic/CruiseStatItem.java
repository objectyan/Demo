package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class CruiseStatItem {
    private static final String TAG = CruiseStatItem.class.getSimpleName();
    private static CruiseStatItem mInstance = null;
    public String mCruiseFrom;
    public boolean mIsGPSLocated = false;
    public long mLocatingTime = -1;
    public int mLostGPSCount = 0;
    public long mStartCruiseEngineTime = -1;
    public long mStartCruiseTime = -1;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();
    public long mTotalDistance = 0;

    public static synchronized CruiseStatItem getInstance() {
        CruiseStatItem cruiseStatItem;
        synchronized (CruiseStatItem.class) {
            if (mInstance == null) {
                mInstance = new CruiseStatItem();
            }
            cruiseStatItem = mInstance;
        }
        return cruiseStatItem;
    }

    private CruiseStatItem() {
        init();
    }

    public void onEvent() {
        if (this.mStartCruiseEngineTime > 0) {
            this.mLocatingTime = (this.mStartCruiseEngineTime - this.mStartCruiseTime) / 1000;
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_CRUISE_FROM, this.mCruiseFrom));
        statTotalTimeAndDist();
        this.mStatPairList.add(new BasicNameValuePair("loc_time", Long.toString(this.mLocatingTime)));
        if (this.mStartCruiseEngineTime > 0) {
            this.mStatPairList.add(new BasicNameValuePair("lost_times", Integer.toString(this.mLostGPSCount)));
        }
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_CRUISE, null, this.mStatPairList);
        init();
    }

    public void init() {
        this.mCruiseFrom = "1";
        this.mStartCruiseTime = -1;
        this.mStartCruiseEngineTime = -1;
        this.mLocatingTime = -1;
        this.mTotalDistance = 0;
        this.mLostGPSCount = 0;
        this.mIsGPSLocated = false;
        this.mStatPairList = new ArrayList();
    }

    private void statTotalTimeAndDist() {
        Long duration = Long.valueOf(0);
        if (this.mStartCruiseEngineTime > 0) {
            duration = Long.valueOf((SystemClock.elapsedRealtime() - this.mStartCruiseEngineTime) / 1000);
        }
        this.mStatPairList.add(new BasicNameValuePair("real_time", duration.toString()));
        this.mStatPairList.add(new BasicNameValuePair("real_dis", Long.toString(this.mTotalDistance)));
    }

    public void setCruiseFrom(String from) {
        this.mCruiseFrom = from;
    }
}
