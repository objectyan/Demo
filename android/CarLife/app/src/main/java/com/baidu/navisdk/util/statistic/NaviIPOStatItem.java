package com.baidu.navisdk.util.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.base.LocationUtils;
import com.baidu.navisdk.module.base.OfflineDataUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;

public class NaviIPOStatItem
  implements StatisitcsDataCheck
{
  private static final String TAG = NaviIPOStatItem.class.getSimpleName();
  private static NaviIPOStatItem mInstance = null;
  private long mBackgroundTime = 0L;
  private float mBatteryAfterNavi = 0.0F;
  private float mBatteryBeforeNavi = 0.0F;
  private Intent mBatteryInfo = null;
  private BroadcastReceiver mBatteryReceiver = null;
  private int mCity = -1;
  private Bundle mDataCacheBundle = new Bundle();
  private Bundle mDataCheckBundle = new Bundle();
  private long mDataTraffic = 0L;
  public long mDistToDest = 0L;
  public int mEnlargementCount;
  public String mEnlargementRatioStr;
  private int mEntry = 3;
  public long mFellowRealTime = 0L;
  private long mGoBackgroundTime = 0L;
  private long mGoForgroundTime = 0L;
  private long mGoIPONaviTime = 0L;
  private long mGoLightScreenTime = 0L;
  private long mGoLockScreenTime = 0L;
  private boolean mHasCharge = false;
  public boolean mHasRouteOfflineData = false;
  private long mIPONaviTime = 0L;
  private int mIPONetWrokType = 0;
  public boolean mIsGPSLocated = false;
  public int mLevel;
  private long mLightScreenTime = 0L;
  public long mLocatingTime = -1L;
  private long mLockScreenTime = 0L;
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
  private String mSessionId = null;
  private long mStartFellowTime = 0L;
  public int mStartNaviFrom = 1;
  public long mTotalDistance = 0L;
  public String mVoiceIDStr;
  public int mYawingCount = 0;
  public HashMap<String, NaviMergeStatItem.NaviStatPackage> statCacheMap = null;
  
  private String addEscapeSeqToSsid(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("\"", "\\\"");
  }
  
  private void endStat()
  {
    LogUtil.e(TAG, "endtStat battery after :" + this.mBatteryAfterNavi);
    if ((this.mBatteryReceiver != null) && (BNaviModuleManager.getContext() != null)) {}
    try
    {
      BNaviModuleManager.getContext().getApplicationContext().unregisterReceiver(this.mBatteryReceiver);
      LogUtil.e(TAG, "ipo stat startStat battery has unregistered :");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
  }
  
  private float getBatteryPercent(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return paramInt1 * 100 / paramInt2;
    }
    return 100.0F;
  }
  
  public static NaviIPOStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new NaviIPOStatItem();
      }
      NaviIPOStatItem localNaviIPOStatItem = mInstance;
      return localNaviIPOStatItem;
    }
    finally {}
  }
  
  private long getMobileTrafficBytes()
  {
    int i = Process.myUid();
    long l1 = TrafficStats.getUidRxBytes(i);
    long l2 = TrafficStats.getUidTxBytes(i);
    if (l1 > 0L) {
      if (l2 <= 0L) {
        break label38;
      }
    }
    for (;;)
    {
      return l1 + l2;
      l1 = 0L;
      break;
      label38:
      l2 = 0L;
    }
  }
  
  private String paramsToString(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str != null) {
          localStringBuilder.append(str).append('=').append(paramBundle.get(str)).append(',');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private String statparamsToString()
  {
    if (this.statCacheMap == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.statCacheMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null) {
        localStringBuilder.append(str).append('=').append(((NaviMergeStatItem.NaviStatPackage)this.statCacheMap.get(str)).Value).append(',');
      }
    }
    return localStringBuilder.toString();
  }
  
  public Bundle getDataBundle()
  {
    return this.mDataCheckBundle;
  }
  
  public String getID()
  {
    return "50003";
  }
  
  public void init()
  {
    this.mStartNaviFrom = 1;
    this.mNaviRoutePlanTime = 0L;
    this.mNaviRoutePlanDist = 0L;
    this.mDataTraffic = 0L;
    this.mIsGPSLocated = false;
    this.mTotalDistance = 0L;
    this.mLostGPSCount = 0;
    this.mYawingCount = 0;
    this.mLocatingTime = -1L;
    this.mDistToDest = 0L;
    this.mNaviIntentTime = 0L;
    this.mNaviCostTime = 0L;
    this.mHasRouteOfflineData = false;
    this.mNaviIntentTime2 = 0L;
    this.mNaviCostTime2 = 0L;
    this.mNaviIntentTime3 = 0L;
    this.mNaviCostTime3 = 0L;
    this.mBatteryBeforeNavi = 0.0F;
    this.mBatteryAfterNavi = 0.0F;
    this.mBatteryInfo = null;
    this.mBatteryReceiver = null;
    this.mHasCharge = false;
    this.mMemBeforeNavi = 0;
    this.mLevel = 0;
    this.mEnlargementCount = 0;
    this.mEnlargementRatioStr = null;
    this.mVoiceIDStr = null;
    this.mFellowRealTime = 0L;
    this.mStartFellowTime = 0L;
    this.mBackgroundTime = 0L;
    this.mGoBackgroundTime = 0L;
    this.mGoForgroundTime = 0L;
    this.mDataCheckBundle.clear();
    this.mDataCacheBundle.clear();
    this.mSessionId = null;
    this.mGoBackgroundTime = 0L;
    this.mGoForgroundTime = 0L;
    this.mGoLightScreenTime = 0L;
    this.mGoLockScreenTime = 0L;
    this.mLightScreenTime = 0L;
    this.mLockScreenTime = 0L;
    this.mIPONaviTime = 0L;
    this.mGoIPONaviTime = 0L;
    this.mIPONetWrokType = 0;
    this.statCacheMap = null;
  }
  
  public void onBackground()
  {
    LogUtil.e("wangyang", "NaviIPOStatItem onBackground");
    if (this.mGoBackgroundTime == 0L) {
      this.mGoForgroundTime = SystemClock.elapsedRealtime();
    }
    if (this.mGoLightScreenTime != 0L)
    {
      this.mLightScreenTime += SystemClock.elapsedRealtime() - this.mGoLightScreenTime;
      this.mGoLightScreenTime = 0L;
    }
    if (this.mGoLockScreenTime != 0L)
    {
      this.mLockScreenTime += SystemClock.elapsedRealtime() - this.mGoLockScreenTime;
      this.mGoLockScreenTime = 0L;
    }
    LogUtil.e("wangyang", "NaviIPOStatItem mGoForgroundTime = " + this.mGoForgroundTime);
  }
  
  public void onEvent()
  {
    endStat();
    if (this.statCacheMap == null) {
      this.statCacheMap = new HashMap();
    }
    this.statCacheMap.put("rou_dis", new NaviMergeStatItem.NaviStatPackage("rou_dis", Long.valueOf(this.mNaviRoutePlanDist), 2));
    this.statCacheMap.put("rou_time", new NaviMergeStatItem.NaviStatPackage("rou_time", Long.valueOf(this.mNaviRoutePlanTime), 2));
    Long localLong = Long.valueOf((SystemClock.elapsedRealtime() - MTJStatisticsUtil.mNaviStartTime) / 1000L);
    this.statCacheMap.put("real_time", new NaviMergeStatItem.NaviStatPackage("real_time", localLong, 1));
    this.statCacheMap.put("real_dis", new NaviMergeStatItem.NaviStatPackage("real_dis", Long.valueOf(this.mTotalDistance), 1));
    LogUtil.e(TAG, "NaviStatItem onevent beforeNavi = " + this.mBatteryBeforeNavi + " afterNavi = " + this.mBatteryAfterNavi + " duration = " + localLong + " mHasCharge = " + this.mHasCharge);
    if (!this.mHasCharge)
    {
      float f = this.mBatteryBeforeNavi - this.mBatteryAfterNavi;
      if ((localLong.longValue() > 0L) && (f >= 0.0F))
      {
        f /= (float)localLong.longValue();
        this.statCacheMap.put("bph", new NaviMergeStatItem.NaviStatPackage("bph", Float.valueOf(f * 3600.0F), 4));
      }
    }
    this.statCacheMap.put("loc_time", new NaviMergeStatItem.NaviStatPackage("loc_time", Long.valueOf(this.mLocatingTime), 2));
    this.statCacheMap.put("lost_times", new NaviMergeStatItem.NaviStatPackage("lost_times", Integer.valueOf(this.mLostGPSCount), 1));
    this.statCacheMap.put("out_times", new NaviMergeStatItem.NaviStatPackage("out_times", Integer.valueOf(this.mYawingCount), 1));
    this.statCacheMap.put("ps0", new NaviMergeStatItem.NaviStatPackage("ps0", Integer.valueOf(this.mMemBeforeNavi), 2));
    int i = MemStat.getInstance().getProfileVal();
    this.statCacheMap.put("pss", new NaviMergeStatItem.NaviStatPackage("pss", Integer.valueOf(i), 3));
    double d = (getMobileTrafficBytes() - this.mDataTraffic) / 1024L;
    this.statCacheMap.put("df", new NaviMergeStatItem.NaviStatPackage("df", Double.valueOf(d), 1));
    CpuStat.getInstance().endProfile();
    this.statCacheMap.put("jph", new NaviMergeStatItem.NaviStatPackage("jph", Long.valueOf(CpuStat.getInstance().getProfileVal()), 4));
    if (this.mHasRouteOfflineData) {}
    for (i = 1;; i = 0)
    {
      this.statCacheMap.put("hasData", new NaviMergeStatItem.NaviStatPackage("hasData", Integer.valueOf(i), 2));
      this.statCacheMap.put("dest_dis", new NaviMergeStatItem.NaviStatPackage("dest_dis", Long.valueOf(this.mDistToDest), 3));
      this.statCacheMap.put("bt", new NaviMergeStatItem.NaviStatPackage("bt", Long.valueOf(this.mBackgroundTime / 1000L), 1));
      this.statCacheMap.put("entry", new NaviMergeStatItem.NaviStatPackage("entry", Integer.valueOf(this.mEntry), 2));
      this.statCacheMap.put("city", new NaviMergeStatItem.NaviStatPackage("city", Integer.valueOf(this.mCity), 2));
      this.statCacheMap.put("ipo", new NaviMergeStatItem.NaviStatPackage("ipo", Long.valueOf(this.mIPONaviTime / 1000L), 1));
      this.statCacheMap.put("ipof", new NaviMergeStatItem.NaviStatPackage("ipof", Long.valueOf(this.mLightScreenTime / 1000L), 1));
      this.statCacheMap.put("ipol", new NaviMergeStatItem.NaviStatPackage("ipol", Long.valueOf(this.mLockScreenTime / 1000L), 1));
      if (this.mVoiceIDStr != null) {
        this.statCacheMap.put("vid", new NaviMergeStatItem.NaviStatPackage("vid", this.mVoiceIDStr, 3));
      }
      this.statCacheMap.put("nt", new NaviMergeStatItem.NaviStatPackage("nt", Integer.valueOf(this.mIPONetWrokType), 3));
      if (this.mSessionId != null) {
        this.statCacheMap.put("ssid", new NaviMergeStatItem.NaviStatPackage("ssid", addEscapeSeqToSsid(this.mSessionId), 2));
      }
      LogUtil.e(TAG, "event_test_96 _naviSat, actParams {" + statparamsToString() + "}");
      NaviMergeStatItem.getInstance().addEvent(this.statCacheMap);
      init();
      return;
    }
  }
  
  public void onForground()
  {
    LogUtil.e("wangyang", "NaviIPOStatItem onForground");
    if (this.mGoForgroundTime != 0L)
    {
      this.mGoBackgroundTime = SystemClock.elapsedRealtime();
      this.mBackgroundTime += this.mGoBackgroundTime - this.mGoForgroundTime;
    }
    LogUtil.e("wangyang", "NaviIPOStatItem mBackgroundTime = " + this.mBackgroundTime);
    this.mGoForgroundTime = 0L;
    this.mGoBackgroundTime = 0L;
    this.mGoLightScreenTime = 0L;
    this.mGoLockScreenTime = 0L;
  }
  
  public void onGpsLocated()
  {
    if (!this.mIsGPSLocated)
    {
      this.mIsGPSLocated = true;
      this.mNaviCostTime = ((SystemClock.elapsedRealtime() - this.mNaviIntentTime) / 1000L);
      this.mLocatingTime = ((SystemClock.elapsedRealtime() - MTJStatisticsUtil.mNaviStartTime) / 1000L);
      this.mNaviCostTime2 = ((SystemClock.elapsedRealtime() - this.mNaviIntentTime2) / 1000L);
      this.mNaviCostTime3 = ((SystemClock.elapsedRealtime() - this.mNaviIntentTime3) / 1000L);
    }
  }
  
  public void onIPONaviEnd()
  {
    if (this.mGoLightScreenTime != 0L) {
      this.mLightScreenTime += SystemClock.elapsedRealtime() - this.mGoLightScreenTime;
    }
    if (this.mGoLockScreenTime != 0L) {
      this.mLockScreenTime += SystemClock.elapsedRealtime() - this.mGoLockScreenTime;
    }
    this.mIPONaviTime = (SystemClock.elapsedRealtime() - this.mGoIPONaviTime);
    LogUtil.e("wangyang", "NaviIPOStatItem mIPONaviTime=" + this.mIPONaviTime);
  }
  
  public void onIPONaviStart()
  {
    this.mGoIPONaviTime = SystemClock.elapsedRealtime();
    LogUtil.e("wangyang", "NaviIPOStatItem mGoIPONaviTime=" + this.mGoIPONaviTime);
  }
  
  public void onLightScreen()
  {
    LogUtil.e("wangyang", "NaviIPOStatItem onLightScreen");
    if (this.mGoLightScreenTime == 0L) {
      this.mGoLightScreenTime = SystemClock.elapsedRealtime();
    }
    LogUtil.e("wangyang", "NaviIPOStatItem mGoLightScreenTime=" + this.mGoLightScreenTime);
    if (this.mGoLockScreenTime != 0L)
    {
      this.mLockScreenTime += this.mGoLightScreenTime - this.mGoLockScreenTime;
      LogUtil.e("wangyang", "NaviIPOStatItem mLockScreenTime=" + this.mLockScreenTime);
    }
    this.mGoLockScreenTime = 0L;
  }
  
  public void onLockScreen()
  {
    LogUtil.e("wangyang", "NaviIPOStatItem onLockScreen");
    if (this.mGoLockScreenTime == 0L) {
      this.mGoLockScreenTime = SystemClock.elapsedRealtime();
    }
    LogUtil.e("wangyang", "NaviIPOStatItem mGoLockScreenTime=" + this.mGoLockScreenTime);
    if (this.mGoLightScreenTime != 0L)
    {
      this.mLightScreenTime += this.mGoLockScreenTime - this.mGoLightScreenTime;
      LogUtil.e("wangyang", "NaviIPOStatItem mLightScreenTime=" + this.mLightScreenTime);
    }
    this.mGoLightScreenTime = 0L;
  }
  
  public String paramsToString(List<NameValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramList.next();
        if (localNameValuePair != null) {
          localStringBuilder.append(localNameValuePair.getName()).append('=').append(localNameValuePair.getValue()).append(',');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void setCity(int paramInt)
  {
    this.mCity = paramInt;
  }
  
  public void setEntry(int paramInt)
  {
    this.mEntry = paramInt;
  }
  
  public void setFellowRealTime()
  {
    if (this.mStartFellowTime != 0L) {
      this.mFellowRealTime += SystemClock.elapsedRealtime() - this.mStartFellowTime;
    }
    this.mStartFellowTime = 0L;
  }
  
  public void setIPONaviNetworkType(int paramInt)
  {
    this.mIPONetWrokType = paramInt;
  }
  
  public void setNaviIntentTime(long paramLong)
  {
    this.mNaviIntentTime = paramLong;
  }
  
  public void setNaviIntentTime2(long paramLong)
  {
    this.mNaviIntentTime2 = paramLong;
  }
  
  public void setNaviIntentTime3(long paramLong)
  {
    this.mNaviIntentTime3 = paramLong;
  }
  
  public void setRoutePlanTimeAndDist(long paramLong1, long paramLong2)
  {
    this.mNaviRoutePlanTime = paramLong1;
    this.mNaviRoutePlanDist = paramLong2;
  }
  
  public void setSessionId(String paramString)
  {
    if (this.mSessionId == null) {
      this.mSessionId = paramString;
    }
  }
  
  public void setStartFellowTime()
  {
    this.mStartFellowTime = SystemClock.elapsedRealtime();
  }
  
  public void setStartNaviFrom(int paramInt)
  {
    this.mStartNaviFrom = paramInt;
  }
  
  public void startStat()
  {
    this.mMemBeforeNavi = MemStat.getInstance().getProfileVal();
    this.mDataTraffic = getMobileTrafficBytes();
    if (this.mBatteryReceiver == null) {
      this.mBatteryReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent != null)
          {
            if (paramAnonymousIntent.getIntExtra("status", 1) == 2)
            {
              if (!NaviIPOStatItem.this.mHasCharge) {
                NaviIPOStatItem.access$002(NaviIPOStatItem.this, true);
              }
              LogUtil.e(NaviIPOStatItem.TAG, "startStat battery has charge  :" + NaviIPOStatItem.this.mHasCharge);
            }
            NaviIPOStatItem.access$202(NaviIPOStatItem.this, NaviIPOStatItem.this.getBatteryPercent(paramAnonymousIntent.getIntExtra("level", 0), paramAnonymousIntent.getIntExtra("scale", 100)));
          }
        }
      };
    }
    if ((this.mBatteryReceiver != null) && (BNaviModuleManager.getContext() != null))
    {
      this.mBatteryInfo = BNaviModuleManager.getContext().getApplicationContext().registerReceiver(this.mBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      LogUtil.e(TAG, "ipo stat startStat battery has registered :");
      if (this.mBatteryInfo != null) {
        this.mBatteryBeforeNavi = getBatteryPercent(this.mBatteryInfo.getIntExtra("level", 0), this.mBatteryInfo.getIntExtra("scale", 100));
      }
    }
    LogUtil.e(TAG, "startStat battery before :" + this.mBatteryBeforeNavi);
    this.mGoForgroundTime = 0L;
    this.mGoBackgroundTime = 0L;
    this.mBackgroundTime = 0L;
    this.mHasRouteOfflineData = OfflineDataUtils.checkRouteOfflineData();
    setCity(LocationUtils.getCurrentCityId());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/NaviIPOStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */