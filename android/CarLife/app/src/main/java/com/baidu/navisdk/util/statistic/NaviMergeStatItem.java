package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviMergeStatItem implements StatisitcsDataCheck {
    public static final String[] BU_ACTPARAM_ARR = new String[]{NaviStatConstants.K_NSC_KEY_FINISHNAVI_VOICE_ID, "pn", "pt", NaviStatConstants.K_NSC_KEY_FINISHNAVI_COLLADA, NaviStatConstants.K_NSC_KEY_HUDSDK};
    private static NaviMergeStatItem instance = null;
    private int accumulateTimes = 0;
    private long lostLocTimeCounts = 0;
    private long lostLocTimeStart = System.currentTimeMillis();
    private Bundle mDataCheckBundle = null;
    public int mDft = 0;
    HashMap<String, NaviStatPackage> mMergestatCacheMap = null;
    private String mNetFlow = null;
    private ArrayList<NameValuePair> mStatBuList = new ArrayList();
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();
    private boolean startCountLostLocFlag = false;

    public interface NaviStatKeyType {
        public static final int TYPE_NEEDED_RECORDE_BY_ACCUMULE = 1;
        public static final int TYPE_NEEDED_RECORDE_BY_AVERAGE = 4;
        public static final int TYPE_NEEDED_RECORDE_BY_FIRSTTIME = 2;
        public static final int TYPE_NEEDED_RECORDE_BY_LASTTIME = 3;
        public static final int TYPE_NEEDED_RECORDE_BY_SPECIAL = 5;
    }

    public static class NaviStatPackage {
        public String Key;
        public int Type;
        public Object Value;

        public NaviStatPackage(String Key, Object Value, int Type) {
            this.Key = Key;
            this.Value = Value;
            this.Type = Type;
        }
    }

    public void startCountLostLoc() {
        this.startCountLostLocFlag = true;
        this.lostLocTimeCounts = System.currentTimeMillis();
    }

    public void endCountLostLoc() {
        if (this.startCountLostLocFlag) {
            this.startCountLostLocFlag = false;
            this.lostLocTimeCounts += System.currentTimeMillis() - this.lostLocTimeStart;
        }
    }

    private NaviMergeStatItem() {
    }

    public static NaviMergeStatItem getInstance() {
        if (instance == null) {
            synchronized (NaviMergeStatItem.class) {
                if (instance == null) {
                    instance = new NaviMergeStatItem();
                }
            }
        }
        return instance;
    }

    public void addEvent(HashMap<String, NaviStatPackage> statCacheMap) {
        if (this.mMergestatCacheMap == null) {
            this.mMergestatCacheMap = new HashMap();
        }
        this.accumulateTimes++;
        if (this.mMergestatCacheMap.size() <= 0) {
            this.mMergestatCacheMap.putAll(statCacheMap);
            return;
        }
        NaviStatPackage newNaviStatPackage = null;
        for (String key : statCacheMap.keySet()) {
            NaviStatPackage mNaviStatPackage = (NaviStatPackage) statCacheMap.get(key);
            switch (mNaviStatPackage.Type) {
                case 1:
                case 4:
                    newNaviStatPackage = accumulePackage((NaviStatPackage) this.mMergestatCacheMap.get(key), mNaviStatPackage);
                    break;
                case 2:
                    if (!this.mMergestatCacheMap.containsKey(key)) {
                        newNaviStatPackage = mNaviStatPackage;
                        break;
                    }
                    break;
                case 3:
                    newNaviStatPackage = mNaviStatPackage;
                    break;
                case 5:
                    NaviStatPackage mOldNaviStatPackage = (NaviStatPackage) this.mMergestatCacheMap.get(key);
                    if (mOldNaviStatPackage != null) {
                        if (!key.equals(NaviStatConstants.K_NSC_KEY_FINISHNAVI_HASDATA)) {
                            if (key.equals("pn")) {
                                try {
                                    String oldPn = mOldNaviStatPackage.Value;
                                    if (newNaviStatPackage != null) {
                                        newNaviStatPackage = new NaviStatPackage(key, addPnStat(oldPn, newNaviStatPackage.Value), 5);
                                        break;
                                    } else {
                                        newNaviStatPackage = mOldNaviStatPackage;
                                        break;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    break;
                                }
                            }
                        }
                        try {
                            newNaviStatPackage = new NaviStatPackage(key, Integer.valueOf(newNaviStatPackage.Value.intValue() & mOldNaviStatPackage.Value.intValue()), 5);
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            break;
                        }
                    }
                    newNaviStatPackage = mNaviStatPackage;
                    break;
                    break;
            }
            if (newNaviStatPackage != null) {
                this.mMergestatCacheMap.put(key, newNaviStatPackage);
            }
            newNaviStatPackage = null;
        }
    }

    public void onEvent() {
        NetFlowStat.getInstance().endStat(BNaviModuleManager.getContext());
        if (this.mMergestatCacheMap == null || this.mMergestatCacheMap.size() <= 0) {
            init();
        } else if (this.mStatBuList != null && this.mStatPairList != null) {
            this.mStatPairList.clear();
            this.mStatBuList.clear();
            if (this.accumulateTimes == 0) {
                this.accumulateTimes = 1;
            }
            this.mDataCheckBundle = new Bundle();
            for (Entry<String, NaviStatPackage> mEntry : this.mMergestatCacheMap.entrySet()) {
                NaviStatPackage mNaviStatPackage = (NaviStatPackage) mEntry.getValue();
                if (mNaviStatPackage.Value != null) {
                    if (this.accumulateTimes >= 1 && mNaviStatPackage.Type == 4) {
                        averageValue(mNaviStatPackage, this.accumulateTimes);
                    }
                    if (isBelondBuParams(mNaviStatPackage.Key)) {
                        this.mStatBuList.add(new BasicNameValuePair(mNaviStatPackage.Key, mNaviStatPackage.Value.toString()));
                    } else {
                        this.mStatPairList.add(new BasicNameValuePair(mNaviStatPackage.Key, mNaviStatPackage.Value.toString()));
                    }
                    addCheckData(mNaviStatPackage.Key, mNaviStatPackage.Value);
                    LogUtil.m15791e("NaviMergeStatItem", "event_test_96 _Merge" + mNaviStatPackage.Key + "," + mNaviStatPackage.Value.toString());
                }
            }
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_NETFLOW, this.mNetFlow));
            addCheckData(NaviStatConstants.K_NSC_KEY_NETFLOW, this.mNetFlow);
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_DFT, Integer.toString(this.mDft)));
            addCheckData(NaviStatConstants.K_NSC_KEY_DFT, Integer.valueOf(this.mDft));
            Long totalTimes = Long.valueOf(this.lostLocTimeCounts / 1000);
            this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_FINISHNAVI_LOST_TOTALTIME, Long.toString(totalTimes.longValue())));
            addCheckData(NaviStatConstants.K_NSC_KEY_FINISHNAVI_LOST_TOTALTIME, totalTimes);
            LogUtil.m15791e("NaviMergeStatItem", "event_test_96 _Merge, actParams {" + paramsToString(this.mStatPairList) + " }, buParams {" + paramsToString(this.mStatBuList) + "}");
            BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_FINISHNAVI, null, this.mStatPairList, this.mStatBuList);
            DataCheckCenter.getInstance().check(this);
            init();
            NaviStatItem.getInstance().initNaviSataParam();
        }
    }

    private void averageValue(NaviStatPackage mNaviStatPackage, int sum) {
        if (mNaviStatPackage.Value instanceof Double) {
            mNaviStatPackage.Value = Double.valueOf(((Double) mNaviStatPackage.Value).doubleValue() / ((double) sum));
        } else if (mNaviStatPackage.Value instanceof Float) {
            mNaviStatPackage.Value = Float.valueOf(((Float) mNaviStatPackage.Value).floatValue() / ((float) sum));
        } else if (mNaviStatPackage.Value instanceof Integer) {
            mNaviStatPackage.Value = Integer.valueOf(((Integer) mNaviStatPackage.Value).intValue() / sum);
        } else if (mNaviStatPackage.Value instanceof Long) {
            mNaviStatPackage.Value = Long.valueOf(((Long) mNaviStatPackage.Value).longValue() / ((long) sum));
        }
    }

    private void addCheckData(String key, Object value) {
        if (value instanceof Integer) {
            this.mDataCheckBundle.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Float) {
            this.mDataCheckBundle.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof Double) {
            this.mDataCheckBundle.putDouble(key, ((Double) value).doubleValue());
        } else if (value instanceof Long) {
            this.mDataCheckBundle.putLong(key, ((Long) value).longValue());
        } else if (value instanceof String) {
            this.mDataCheckBundle.putString(key, (String) value);
        }
    }

    private boolean isBelondBuParams(String param) {
        for (String str : BU_ACTPARAM_ARR) {
            if (str.equals(param)) {
                return true;
            }
        }
        return false;
    }

    private String addPnStat(String mOldEnlargementRatio, String mNewEnlargementRatio) {
        if (mOldEnlargementRatio == null) {
            return mNewEnlargementRatio;
        }
        if (mNewEnlargementRatio == null) {
            return mOldEnlargementRatio;
        }
        String[] mOldEnlargementRatioArr = mOldEnlargementRatio.split("/");
        String[] mNewEnlargementRatioArr = mNewEnlargementRatio.split("/");
        if (mOldEnlargementRatioArr.length != 2 || mNewEnlargementRatioArr.length != 2) {
            return mOldEnlargementRatio;
        }
        try {
            return (Integer.parseInt(mOldEnlargementRatioArr[0]) + Integer.parseInt(mNewEnlargementRatioArr[0])) + "/" + (Integer.parseInt(mOldEnlargementRatioArr[1]) + Integer.parseInt(mNewEnlargementRatioArr[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return mOldEnlargementRatio;
        }
    }

    public String paramsToString(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null) {
            for (NameValuePair pair : params) {
                if (pair != null) {
                    sb.append(pair.getName()).append('=').append(pair.getValue()).append(',');
                }
            }
        }
        return sb.toString();
    }

    private void init() {
        this.mStatBuList = new ArrayList();
        this.mStatPairList = new ArrayList();
        this.accumulateTimes = 0;
        this.mNetFlow = null;
        this.mDft = 0;
        this.mMergestatCacheMap = null;
        this.startCountLostLocFlag = false;
        this.lostLocTimeStart = System.currentTimeMillis();
        this.lostLocTimeCounts = 0;
    }

    public String getID() {
        return "50003";
    }

    public Bundle getDataBundle() {
        return this.mDataCheckBundle;
    }

    public void setNetFlow(String mNetFlow) {
        this.mNetFlow = mNetFlow;
    }

    private NaviStatPackage accumulePackage(NaviStatPackage mNaviStatPackage1, NaviStatPackage mNaviStatPackage2) {
        if (mNaviStatPackage1 == null) {
            return mNaviStatPackage2;
        }
        if (mNaviStatPackage2 == null) {
            return mNaviStatPackage1;
        }
        if (!mNaviStatPackage1.Key.equals(mNaviStatPackage2.Key)) {
            return null;
        }
        if ((mNaviStatPackage1.Value instanceof Double) && (mNaviStatPackage1.Value instanceof Double)) {
            return new NaviStatPackage(mNaviStatPackage1.Key, Double.valueOf(((Double) mNaviStatPackage1.Value).doubleValue() + ((Double) mNaviStatPackage2.Value).doubleValue()), mNaviStatPackage1.Type);
        } else if ((mNaviStatPackage1.Value instanceof Float) && (mNaviStatPackage1.Value instanceof Float)) {
            return new NaviStatPackage(mNaviStatPackage1.Key, Float.valueOf(((Float) mNaviStatPackage2.Value).floatValue() + ((Float) mNaviStatPackage1.Value).floatValue()), mNaviStatPackage1.Type);
        } else if ((mNaviStatPackage1.Value instanceof Integer) && (mNaviStatPackage1.Value instanceof Integer)) {
            return new NaviStatPackage(mNaviStatPackage1.Key, Integer.valueOf(((Integer) mNaviStatPackage2.Value).intValue() + ((Integer) mNaviStatPackage1.Value).intValue()), mNaviStatPackage1.Type);
        } else if (!(mNaviStatPackage1.Value instanceof Long) || !(mNaviStatPackage1.Value instanceof Long)) {
            return null;
        } else {
            return new NaviStatPackage(mNaviStatPackage1.Key, Long.valueOf(((Long) mNaviStatPackage1.Value).longValue() + ((Long) mNaviStatPackage2.Value).longValue()), mNaviStatPackage1.Type);
        }
    }
}
