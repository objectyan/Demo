package com.baidu.navisdk.util.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.base.LocationUtils;
import com.baidu.navisdk.module.base.OfflineDataUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.statistic.NaviMergeStatItem.NaviStatPackage;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;

public class NaviStatItem implements StatisitcsDataCheck {
    private static final String TAG = NaviStatItem.class.getSimpleName();
    private static NaviStatItem mInstance = null;
    public long intime = -1;
    public int intimeType = -1;
    private long mBackgroundTime = 0;
    private float mBatteryAfterNavi = 0.0f;
    private float mBatteryBeforeNavi = 0.0f;
    private Intent mBatteryInfo = null;
    private BroadcastReceiver mBatteryReceiver = null;
    private int mCity = -1;
    public int mColladaCount = 0;
    private long mDataTraffic = 0;
    public long mDistToDest = 0;
    public int mEnlargementCount;
    public String mEnlargementRatioStr;
    private int mEntry = 3;
    public long mFellowRealTime = 0;
    public long mFullViewRealTime = 0;
    private long mGoBackgroundTime = 0;
    private long mGoForgroundTime = 0;
    private boolean mHasCharge = false;
    public boolean mHasRouteOfflineData = false;
    public String mHudSDKClientPkgName = "";
    public boolean mIsGPSLocated = false;
    public long mLandRealTime = 0;
    public int mLevel;
    public long mLocatingTime = -1;
    public int mLostGPSCount = 0;
    private int mMemBeforeNavi = 0;
    public long mNaviCostTime;
    public long mNaviCostTime2;
    public long mNaviCostTime3;
    public long mNaviIntentTime;
    public long mNaviIntentTime2;
    public long mNaviIntentTime3;
    public long mNaviRoutePlanDist;
    public long mNaviRoutePlanTime;
    private int mNetWrokType = 0;
    public long mNorthRealTime = 0;
    private String mSessionId = null;
    private long mStartFellowTime = 0;
    private long mStartFullViewTime = 0;
    private long mStartLandTime = 0;
    public int mStartNaviFrom = 1;
    private long mStartNorthTime = 0;
    public long mTotalDistance = 0;
    public String mVoiceIDStr;
    public int mYawingCount = 0;
    private int naviStatCountNum = 0;
    public long ppAllTime = -1;
    public long ppEnTime = -1;
    public long ppNsTime = -1;
    public HashMap<String, NaviStatPackage> statCacheMap = null;

    /* renamed from: com.baidu.navisdk.util.statistic.NaviStatItem$1 */
    class C47251 extends BroadcastReceiver {
        C47251() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getIntExtra("status", 1) == 2) {
                    if (!NaviStatItem.this.mHasCharge) {
                        NaviStatItem.this.mHasCharge = true;
                    }
                    LogUtil.m15791e(NaviStatItem.TAG, "startStat battery has charge  :" + NaviStatItem.this.mHasCharge);
                }
                NaviStatItem.this.mBatteryAfterNavi = NaviStatItem.this.getBatteryPercent(intent.getIntExtra("level", 0), intent.getIntExtra("scale", 100));
            }
        }
    }

    public static synchronized NaviStatItem getInstance() {
        NaviStatItem naviStatItem;
        synchronized (NaviStatItem.class) {
            if (mInstance == null) {
                mInstance = new NaviStatItem();
            }
            naviStatItem = mInstance;
        }
        return naviStatItem;
    }

    public void setCity(int city) {
        this.mCity = city;
    }

    public void setEntry(int entry) {
        this.mEntry = entry;
    }

    public void onEvent() {
        endStat();
        if (this.statCacheMap == null) {
            this.statCacheMap = new HashMap();
        }
        if (this.intimeType >= 0 && this.intime >= 0) {
            this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_INTIME_TYPE, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_INTIME_TYPE, Integer.valueOf(this.intimeType), 2));
            this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_INTIME, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_INTIME, Long.valueOf(this.intime), 2));
        }
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_FROM, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_FROM, Integer.valueOf(this.mStartNaviFrom), 2));
        this.statCacheMap.put("rou_dis", new NaviStatPackage("rou_dis", Long.valueOf(this.mNaviRoutePlanDist), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PLANTIME, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PLANTIME, Long.valueOf(this.mNaviRoutePlanTime), 2));
        Long duration = Long.valueOf((SystemClock.elapsedRealtime() - MTJStatisticsUtil.mNaviStartTime) / 1000);
        this.statCacheMap.put("real_time", new NaviStatPackage("real_time", duration, 1));
        this.statCacheMap.put("real_dis", new NaviStatPackage("real_dis", Long.valueOf(this.mTotalDistance), 1));
        LogUtil.m15791e(TAG, "NaviStatItem onevent beforeNavi = " + this.mBatteryBeforeNavi + " afterNavi = " + this.mBatteryAfterNavi + " duration = " + duration + " mHasCharge = " + this.mHasCharge);
        if (!this.mHasCharge) {
            float batteryConsume = this.mBatteryBeforeNavi - this.mBatteryAfterNavi;
            if (duration.longValue() > 0 && batteryConsume >= 0.0f) {
                this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_BPH, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_BPH, Float.valueOf((batteryConsume / ((float) duration.longValue())) * 3600.0f), 4));
            }
        }
        this.statCacheMap.put("loc_time", new NaviStatPackage("loc_time", Long.valueOf(this.mLocatingTime), 2));
        this.statCacheMap.put("lost_times", new NaviStatPackage("lost_times", Integer.valueOf(this.mLostGPSCount), 1));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_YAWINGTIMES, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_YAWINGTIMES, Integer.valueOf(this.mYawingCount), 1));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PS0, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PS0, Integer.valueOf(this.mMemBeforeNavi), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PSS, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PSS, Integer.valueOf(MemStat.getInstance().getProfileVal()), 3));
        this.statCacheMap.put("df", new NaviStatPackage("df", Double.valueOf((double) ((getMobileTrafficBytes() - this.mDataTraffic) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)), 1));
        CpuStat.getInstance().endProfile();
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_JPH, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_JPH, Long.valueOf(CpuStat.getInstance().getProfileVal()), 4));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_HASDATA, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_HASDATA, Integer.valueOf(this.mHasRouteOfflineData ? 1 : 0), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_DIST2DEST, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_DIST2DEST, Long.valueOf(this.mDistToDest), 3));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_BT, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_BT, Long.valueOf(this.mBackgroundTime / 1000), 1));
        this.statCacheMap.put("entry", new NaviStatPackage("entry", Integer.valueOf(this.mEntry), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY, Integer.valueOf(this.mCity), 2));
        this.statCacheMap.put("pn", new NaviStatPackage("pn", this.mEnlargementRatioStr, 5));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_COLLADA, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_COLLADA, Integer.valueOf(this.mColladaCount), 1));
        if (this.mVoiceIDStr != null) {
            this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_VOICE_ID, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_VOICE_ID, this.mVoiceIDStr, 3));
        }
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_IPOLOCKNAVI_NETWORK, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_IPOLOCKNAVI_NETWORK, Integer.valueOf(this.mNetWrokType), 3));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_LAND, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_LAND, Long.valueOf(this.mLandRealTime / 1000), 1));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_FULLT, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_FULLT, Long.valueOf(this.mFullViewRealTime / 1000), 1));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_NORT, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_NORT, Long.valueOf(this.mNorthRealTime / 1000), 1));
        if (this.mSessionId != null) {
            this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, addEscapeSeqToSsid(this.mSessionId), 2));
        }
        if (!StringUtils.isEmpty(this.mHudSDKClientPkgName)) {
            this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, this.mSessionId, 2));
        }
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_ALL_TIME, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_ALL_TIME, Long.valueOf(this.ppAllTime), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_EN_TIME, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_EN_TIME, Long.valueOf(this.ppEnTime), 2));
        this.statCacheMap.put(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_NS_TIME, new NaviStatPackage(NaviStatConstants.K_NSC_KEY_FINISHNAVI_PP_NS_TIME, Long.valueOf(this.ppNsTime), 2));
        LogUtil.m15791e(TAG, "event_test_96 _naviSat, actParams {" + statparamsToString() + "}");
        NaviMergeStatItem.getInstance().addEvent(this.statCacheMap);
        this.naviStatCountNum++;
        init();
    }

    private String statparamsToString() {
        if (this.statCacheMap == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String key : this.statCacheMap.keySet()) {
            if (key != null) {
                sb.append(key).append('=').append(((NaviStatPackage) this.statCacheMap.get(key)).Value).append(',');
            }
        }
        return sb.toString();
    }

    private String paramsToString(Bundle mDataBundle) {
        StringBuilder sb = new StringBuilder();
        if (mDataBundle != null) {
            for (String key : mDataBundle.keySet()) {
                if (key != null) {
                    sb.append(key).append('=').append(mDataBundle.get(key)).append(',');
                }
            }
        }
        return sb.toString();
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

    public void startStat() {
        this.mMemBeforeNavi = MemStat.getInstance().getProfileVal();
        this.mDataTraffic = getMobileTrafficBytes();
        endStat();
        if (this.mBatteryReceiver == null) {
            this.mBatteryReceiver = new C47251();
        }
        if (!(this.mBatteryReceiver == null || BNaviModuleManager.getContext() == null)) {
            try {
                this.mBatteryInfo = BNaviModuleManager.getContext().getApplicationContext().registerReceiver(this.mBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mBatteryInfo != null) {
                LogUtil.m15791e(TAG, "startStat battery has registered :");
                this.mBatteryBeforeNavi = getBatteryPercent(this.mBatteryInfo.getIntExtra("level", 0), this.mBatteryInfo.getIntExtra("scale", 100));
            }
        }
        LogUtil.m15791e(TAG, "startStat battery before :" + this.mBatteryBeforeNavi);
        this.mGoForgroundTime = 0;
        this.mGoBackgroundTime = 0;
        this.mBackgroundTime = 0;
        this.mHasRouteOfflineData = OfflineDataUtils.checkRouteOfflineData();
        setCity(LocationUtils.getCurrentCityId());
    }

    private String addEscapeSeqToSsid(String ssidStr) {
        if (ssidStr == null) {
            return null;
        }
        return ssidStr.replace("\"", "\\\"");
    }

    private void endStat() {
        LogUtil.m15791e(TAG, "endtStat battery after :" + this.mBatteryAfterNavi);
        if (this.mBatteryReceiver != null && BNaviModuleManager.getContext() != null) {
            try {
                BNaviModuleManager.getContext().getApplicationContext().unregisterReceiver(this.mBatteryReceiver);
                LogUtil.m15791e(TAG, "stat startStat battery has unregistered :");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private float getBatteryPercent(int level, int scale) {
        if (scale != 0) {
            return (float) ((level * 100) / scale);
        }
        return 100.0f;
    }

    public void init() {
        this.intimeType = -1;
        this.intime = -1;
        this.mStartNaviFrom = 1;
        this.mNaviRoutePlanTime = 0;
        this.mNaviRoutePlanDist = 0;
        this.mDataTraffic = 0;
        this.mIsGPSLocated = false;
        this.mTotalDistance = 0;
        this.mLostGPSCount = 0;
        this.mYawingCount = 0;
        this.mLocatingTime = -1;
        this.mDistToDest = 0;
        this.mNaviIntentTime = 0;
        this.mNaviCostTime = 0;
        this.mHasRouteOfflineData = false;
        this.mNaviIntentTime2 = 0;
        this.mNaviCostTime2 = 0;
        this.mNaviIntentTime3 = 0;
        this.mNaviCostTime3 = 0;
        this.mBatteryBeforeNavi = 0.0f;
        this.mBatteryAfterNavi = 0.0f;
        this.mBatteryInfo = null;
        this.mBatteryReceiver = null;
        this.mHasCharge = false;
        this.mMemBeforeNavi = 0;
        this.mLevel = 0;
        this.mEnlargementCount = 0;
        this.mColladaCount = 0;
        this.mEnlargementRatioStr = null;
        this.mVoiceIDStr = null;
        this.mFellowRealTime = 0;
        this.mStartFellowTime = 0;
        this.mLandRealTime = 0;
        this.mStartLandTime = 0;
        this.mFullViewRealTime = 0;
        this.mStartFullViewTime = 0;
        this.mNorthRealTime = 0;
        this.mStartNorthTime = 0;
        this.mBackgroundTime = 0;
        this.mGoBackgroundTime = 0;
        this.mGoForgroundTime = 0;
        this.mNetWrokType = 0;
        this.mSessionId = null;
        this.statCacheMap = new HashMap();
        this.mHudSDKClientPkgName = "";
        this.ppAllTime = -1;
        this.ppEnTime = -1;
        this.ppNsTime = -1;
    }

    public void initNaviSataParam() {
        this.naviStatCountNum = 0;
    }

    public void setStartNaviFrom(int startNaviFrom) {
        if (this.naviStatCountNum == 0) {
            this.mStartNaviFrom = startNaviFrom;
        }
    }

    public void setRoutePlanTimeAndDist(long routePlanTime, long routePlanDist) {
        this.mNaviRoutePlanTime = routePlanTime;
        this.mNaviRoutePlanDist = routePlanDist;
    }

    public void setNaviIntentTime(long time) {
        this.mNaviIntentTime = time;
    }

    public void setNaviIntentTime2(long time) {
        this.mNaviIntentTime2 = time;
    }

    public void setNaviIntentTime3(long time) {
        this.mNaviIntentTime3 = time;
    }

    public void onGpsLocated() {
        if (!this.mIsGPSLocated) {
            this.mIsGPSLocated = true;
            this.mNaviCostTime = (SystemClock.elapsedRealtime() - this.mNaviIntentTime) / 1000;
            this.mLocatingTime = (SystemClock.elapsedRealtime() - MTJStatisticsUtil.mNaviStartTime) / 1000;
            this.mNaviCostTime2 = (SystemClock.elapsedRealtime() - this.mNaviIntentTime2) / 1000;
            this.mNaviCostTime3 = (SystemClock.elapsedRealtime() - this.mNaviIntentTime3) / 1000;
        }
    }

    private long getMobileTrafficBytes() {
        int uid = Process.myUid();
        long tx = TrafficStats.getUidRxBytes(uid);
        long rx = TrafficStats.getUidTxBytes(uid);
        if (tx <= 0) {
            tx = 0;
        }
        if (rx <= 0) {
            rx = 0;
        }
        return tx + rx;
    }

    public String getID() {
        return "50003";
    }

    public Bundle getDataBundle() {
        return null;
    }

    public void onBackground() {
        if (this.mGoBackgroundTime == 0) {
            this.mGoForgroundTime = SystemClock.elapsedRealtime();
        }
    }

    public void onForground() {
        if (this.mGoForgroundTime != 0) {
            this.mGoBackgroundTime = SystemClock.elapsedRealtime();
            this.mBackgroundTime += this.mGoBackgroundTime - this.mGoForgroundTime;
        }
        this.mGoForgroundTime = 0;
        this.mGoBackgroundTime = 0;
    }

    public void setStartFellowTime() {
        this.mStartFellowTime = SystemClock.elapsedRealtime();
    }

    public void setFellowRealTime() {
        if (this.mStartFellowTime != 0) {
            this.mFellowRealTime += SystemClock.elapsedRealtime() - this.mStartFellowTime;
        }
        this.mStartFellowTime = 0;
    }

    public void setStartLandTime() {
        this.mStartLandTime = SystemClock.elapsedRealtime();
    }

    public void setLandRealTime() {
        if (this.mStartLandTime != 0) {
            this.mLandRealTime += SystemClock.elapsedRealtime() - this.mStartLandTime;
        }
        this.mStartLandTime = 0;
    }

    public void setStartFullViewTime() {
        this.mStartFullViewTime = SystemClock.elapsedRealtime();
    }

    public void setFullViewRealTime() {
        if (this.mStartFullViewTime != 0) {
            this.mFullViewRealTime += SystemClock.elapsedRealtime() - this.mStartFullViewTime;
        }
        this.mStartFullViewTime = 0;
    }

    public void setStartNorthTime() {
        if (this.mStartNorthTime != 0) {
            setNorthRealTime();
        }
        this.mStartNorthTime = SystemClock.elapsedRealtime();
    }

    public void setNorthRealTime() {
        if (this.mStartNorthTime != 0) {
            this.mNorthRealTime += SystemClock.elapsedRealtime() - this.mStartNorthTime;
        }
        this.mStartNorthTime = 0;
    }

    public void setNaviNetworkType(int type) {
        this.mNetWrokType = type;
    }

    public void setSessionId(String mSession) {
        if (this.mSessionId == null) {
            this.mSessionId = mSession;
        }
    }

    public void fillInAllFullRoutePlanTime() {
        if (this.mEntry == 5) {
            PerformStatisticsController.peByType(0, "lib_network_server", JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
            this.ppAllTime = PerformStatisticsController.getTimeByKey("sdk_routeguide_refresh_firstinfo") - PerformStatisticsController.getTimeByKey("map_poi_click_start");
            this.ppEnTime = PerformStatisticsController.getTimeByKey("sdk_routeguide_refresh_firstinfo") - PerformStatisticsController.getTimeByKey("sdk_start_lib_routeplan");
            this.ppNsTime = PerformStatisticsController.getTimeByKey("lib_network_server");
        }
    }
}
