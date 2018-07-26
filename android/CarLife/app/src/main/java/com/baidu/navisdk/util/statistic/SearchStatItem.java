package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SearchStatItem implements StatisitcsDataCheck {
    private static final String TAG = SearchStatItem.class.getSimpleName();
    private static SearchStatItem mInstance = null;
    private Bundle mDataCheckBundle = new Bundle();
    public long mResponseTime;
    public int mResultIndex;
    public boolean mSearchSucc;
    public String mSearchType;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();

    public static synchronized SearchStatItem getInstance() {
        SearchStatItem searchStatItem;
        synchronized (SearchStatItem.class) {
            if (mInstance == null) {
                mInstance = new SearchStatItem();
            }
            searchStatItem = mInstance;
        }
        return searchStatItem;
    }

    public void init() {
        this.mSearchType = "1";
        this.mResultIndex = 0;
        this.mResponseTime = 0;
        this.mSearchSucc = false;
        this.mStatPairList = new ArrayList();
        this.mDataCheckBundle.clear();
    }

    public void setResponseTime(long time) {
        this.mResponseTime = time;
    }

    public void setSearchResult(boolean succ) {
        this.mSearchSucc = succ;
    }

    public void onEvent() {
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_POISEARCH_TYPE, this.mSearchType));
        this.mDataCheckBundle.putString(NaviStatConstants.K_NSC_KEY_POISEARCH_TYPE, this.mSearchType);
        this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(this.mResponseTime)));
        this.mDataCheckBundle.putLong("re_time", this.mResponseTime);
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_POISEARCH_RET, this.mSearchSucc ? "1" : "0"));
        this.mDataCheckBundle.putInt(NaviStatConstants.K_NSC_KEY_POISEARCH_RET, this.mSearchSucc ? 1 : 0);
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_POISEARCH, null, this.mStatPairList);
        DataCheckCenter.getInstance().check(this);
        init();
    }

    public String getSearchType() {
        return this.mSearchType;
    }

    public void setResultIndex(int index) {
        this.mResultIndex = index + 1;
    }

    public String getID() {
        return "50001";
    }

    public Bundle getDataBundle() {
        return this.mDataCheckBundle;
    }

    public void searchStatistics(int index) {
        getInstance().setResultIndex(index);
        getInstance().onEvent();
    }

    public void setSearchType(String type) {
        this.mSearchType = type;
    }

    public void setSearchType(int netMode) {
        switch (netMode) {
            case 1:
                this.mSearchType = "1";
                return;
            case 2:
                this.mSearchType = "2";
                return;
            case 3:
                this.mSearchType = "3";
                return;
            case 4:
                this.mSearchType = "4";
                return;
            default:
                return;
        }
    }
}
