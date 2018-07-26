package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RespTimeStatItem {
    private static final String TAG = RespTimeStatItem.class.getSimpleName();
    private boolean mEngTime = false;
    private boolean mIsCommitted = false;
    public long mLocatedTime;
    public long mSDKInitStartTime;
    public long mSDKInitTime;
    private boolean mSetInitTime = false;
    private boolean mSetLocateTime = false;
    public long mStartAppTime;
    public long mStartInitEngineTime = -1;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();
    public long mSumInitEngineTime;

    private static class LazyHolder {
        private static RespTimeStatItem sInstance = new RespTimeStatItem();

        private LazyHolder() {
        }
    }

    public static RespTimeStatItem getInstance() {
        return LazyHolder.sInstance;
    }

    public synchronized void onEvent() {
        if (!this.mIsCommitted) {
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_RESPTIME_SDKINITTIME, Long.toString(this.mSDKInitTime)));
            long locatingTime = -1;
            if (this.mLocatedTime > 0) {
                locatingTime = this.mLocatedTime - this.mStartAppTime;
            }
            this.mStatPairList.add(new BasicNameValuePair("loc_time", Long.toString(locatingTime)));
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_RESPTIME_ENGINETIME, Long.toString(this.mSumInitEngineTime)));
            BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_RESPTIME, null, this.mStatPairList);
            this.mIsCommitted = true;
        }
    }

    public void setStartAppTime() {
        this.mStartAppTime = SystemClock.elapsedRealtime();
    }

    public void setAppLocatedTime() {
        if (0 == this.mLocatedTime) {
            this.mLocatedTime = SystemClock.elapsedRealtime();
            this.mSetLocateTime = true;
            if (this.mSetInitTime && this.mSetLocateTime && this.mEngTime) {
                onEvent();
            }
        }
    }

    public void setStartEngineTime() {
        this.mStartInitEngineTime = SystemClock.elapsedRealtime();
    }

    public void setEndEngineTime() {
        this.mEngTime = true;
        if (this.mStartInitEngineTime <= -1) {
            this.mSumInitEngineTime = -1;
        } else {
            this.mSumInitEngineTime = SystemClock.elapsedRealtime() - this.mStartInitEngineTime;
        }
        if (this.mSetInitTime && this.mSetLocateTime && this.mEngTime) {
            onEvent();
        }
    }

    public void startCountSDKInitTime() {
        this.mSDKInitStartTime = SystemClock.elapsedRealtime();
    }

    public void addSDKInitTime() {
        this.mSDKInitTime += SystemClock.elapsedRealtime() - this.mSDKInitStartTime;
        this.mSetInitTime = true;
        if (this.mSetInitTime && this.mSetLocateTime && this.mEngTime) {
            onEvent();
        }
    }
}
