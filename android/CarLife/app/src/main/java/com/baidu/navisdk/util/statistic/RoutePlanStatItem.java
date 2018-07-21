package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RoutePlanStatItem
  implements StatisitcsDataCheck
{
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
  private Long engRoutePlanEndTime = Long.valueOf(0L);
  private Long engRoutePlanStartTime = Long.valueOf(0L);
  private Long engineTime = Long.valueOf(0L);
  public Long enntCostTime = Long.valueOf(0L);
  public long intime = -1L;
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
  private Long rouPlanDetailViewShowTime = Long.valueOf(0L);
  private Long rouPlanDetailViewStartTime = Long.valueOf(0L);
  public boolean startRoutePlanStat;
  
  private void checkIfOpenApi()
  {
    if (this.mEntry == 7)
    {
      this.osSrc = ProcessManagerUtils.getOpenApiStatFlag();
      return;
    }
    this.osSrc = "0";
  }
  
  public static RoutePlanStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new RoutePlanStatItem();
      }
      RoutePlanStatItem localRoutePlanStatItem = mInstance;
      return localRoutePlanStatItem;
    }
    finally {}
  }
  
  private Long getRoutePlanResponseTime()
  {
    Object localObject;
    if ((this.rouPlanDetailViewShowTime.longValue() == 0L) || (this.rouPlanDetailViewStartTime.longValue() <= 0L)) {
      localObject = Long.valueOf(-1L);
    }
    Long localLong;
    do
    {
      return (Long)localObject;
      localLong = Long.valueOf(this.rouPlanDetailViewShowTime.longValue() - this.rouPlanDetailViewStartTime.longValue());
      localObject = localLong;
    } while (localLong.longValue() >= 0L);
    return Long.valueOf(-1L);
  }
  
  private void statRoutePlanTag()
  {
    int i = BNRoutePlaner.getInstance().getCalcPreference();
    this.mStatPairList.add(new BasicNameValuePair("rou_tag", Integer.toString(i)));
    this.mDataCheckBundle.putInt("rou_tag", i);
  }
  
  public String getCalcType()
  {
    return this.mCalcType;
  }
  
  public Bundle getDataBundle()
  {
    return this.mDataCheckBundle;
  }
  
  public int getEntry()
  {
    return this.mEntry;
  }
  
  public String getID()
  {
    return "50002";
  }
  
  public boolean hasOnEven()
  {
    return this.engRoutePlanStartTime.longValue() == 0L;
  }
  
  public void init()
  {
    this.mCalcType = "1";
    this.mSwitchRouteCount = 0;
    this.mRouteIndex = 0;
    this.rouPlanDetailViewShowTime = Long.valueOf(0L);
    this.mRoutePlanTime = 0L;
    this.mRoutePlanDist = 0L;
    this.mStartNavi = false;
    this.mRouteCount = 0;
    this.mRouteSwitchEndTime = 0L;
    this.mRouteSwitchStartTime = 0L;
    this.mRecommendPos = 0;
    this.mEntry = 3;
    this.mCurrLocationType = 0;
    this.mStatAll = true;
    this.mHasSensor = -1;
    this.engineTime = Long.valueOf(0L);
    this.mStartFromType = -1;
    this.rouEntry = -1;
    this.rouPlanDetailViewStartTime = Long.valueOf(0L);
    this.engRoutePlanStartTime = Long.valueOf(0L);
    this.engRoutePlanEndTime = Long.valueOf(0L);
    this.startRoutePlanStat = false;
    try
    {
      this.mErrorType = -1;
      this.mStatPairList = new ArrayList();
      this.mDataCheckBundle.clear();
      LogUtil.e(TAG, "stat test route plan response time init");
      return;
    }
    finally {}
  }
  
  public void onEvent()
  {
    checkIfOpenApi();
    this.mStatPairList.add(new BasicNameValuePair("cal_type", this.mCalcType));
    Bundle localBundle = this.mDataCheckBundle;
    Object localObject;
    if (this.mCalcType != null)
    {
      localObject = this.mCalcType;
      localBundle.putString("cal_type", (String)localObject);
      localObject = getRoutePlanResponseTime();
      this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(((Long)localObject).longValue())));
      this.mDataCheckBundle.putLong("re_time", ((Long)localObject).longValue());
      if (this.mRouteCount <= 0) {
        this.mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
      }
      this.mStatPairList.add(new BasicNameValuePair("rou_ret", Integer.toString(this.mRouteCount)));
      this.mDataCheckBundle.putInt("rou_ret", this.mRouteCount);
      this.mStatPairList.add(new BasicNameValuePair("start_from", Integer.toString(this.mStartFromType)));
      this.mDataCheckBundle.putInt("start_from", this.mStartFromType);
      this.mStatPairList.add(new BasicNameValuePair("rou_entry", Integer.toString(this.rouEntry)));
      this.mDataCheckBundle.putInt("rou_entry", this.rouEntry);
      if (BNaviModuleManager.getLastPreferValue() != RGRouteSortController.getInstance().getPreferValue()) {
        break label561;
      }
      this.mStatPairList.add(new BasicNameValuePair("rou_defsort", "1"));
      this.mDataCheckBundle.putInt("rou_defsort", 1);
    }
    for (;;)
    {
      if (this.mStatAll) {
        break label596;
      }
      LogUtil.e(TAG, "do nothing come from in navi or map route");
      this.mStatPairList.add(new BasicNameValuePair("rou_way", String.valueOf(this.mEntry)));
      this.mDataCheckBundle.putInt("rou_way", this.mEntry);
      this.mStatPairList.add(new BasicNameValuePair("loc_type", Integer.toString(this.mCurrLocationType)));
      this.mDataCheckBundle.putInt("loc_type", this.mCurrLocationType);
      this.mStatPairList.add(new BasicNameValuePair("has_s", Integer.toString(this.mHasSensor)));
      this.mStatPairList.add(new BasicNameValuePair("os_src", this.osSrc));
      this.mDataCheckBundle.putString("os_src", this.osSrc);
      localObject = Long.valueOf(this.engRoutePlanEndTime.longValue() - this.engRoutePlanStartTime.longValue());
      this.mStatPairList.add(new BasicNameValuePair("en_time", Long.toString(((Long)localObject).longValue())));
      this.mDataCheckBundle.putLong("en_time", ((Long)localObject).longValue());
      this.mStatPairList.add(new BasicNameValuePair("ennt_time", Long.toString(this.enntCostTime.longValue())));
      this.mDataCheckBundle.putString("ennt_time", Long.toString(this.enntCostTime.longValue()));
      statRoutePlanTag();
      BNStatisticsManager.getInstance().onEventWithParam(50002, null, this.mStatPairList);
      DataCheckCenter.getInstance().check(this);
      init();
      return;
      localObject = "null";
      break;
      label561:
      this.mStatPairList.add(new BasicNameValuePair("rou_defsort", "2"));
      this.mDataCheckBundle.putInt("rou_defsort", 2);
    }
    label596:
    this.mStatPairList.add(new BasicNameValuePair("sel_times", Integer.toString(this.mSwitchRouteCount)));
    this.mDataCheckBundle.putInt("sel_times", this.mSwitchRouteCount);
    this.mStatPairList.add(new BasicNameValuePair("recomm_pos", this.mRecommendPos + "/" + this.mRouteCount));
    this.mDataCheckBundle.putString("recomm_pos", this.mRecommendPos + "/" + this.mRouteCount);
    if (this.mStartNavi) {}
    for (int i = this.mRouteIndex + 1;; i = 0)
    {
      this.mStatPairList.add(new BasicNameValuePair("sel_pos", i + "/" + this.mRouteCount));
      this.mDataCheckBundle.putString("sel_pos", i + "/" + this.mRouteCount);
      this.mStatPairList.add(new BasicNameValuePair("switch_time", Long.toString(this.mRouteSwitchEndTime - this.mRouteSwitchStartTime)));
      this.mDataCheckBundle.putLong("switch_time", this.mRouteSwitchEndTime - this.mRouteSwitchStartTime);
      this.mStatPairList.add(new BasicNameValuePair("rou_dis", Long.toString(this.mRoutePlanDist)));
      this.mStatPairList.add(new BasicNameValuePair("rou_time", Long.toString(this.mRoutePlanTime)));
      break;
    }
  }
  
  public void setCalcType(String paramString)
  {
    this.mCalcType = paramString;
  }
  
  public void setCurrLocationType(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      this.mCurrLocationType = 0;
      return;
    case 61: 
      this.mCurrLocationType = 1;
      return;
    case 161: 
      if (paramBoolean)
      {
        this.mCurrLocationType = 2;
        return;
      }
      this.mCurrLocationType = 3;
      return;
    }
    this.mCurrLocationType = 4;
  }
  
  public void setEngRoutePlanEndTime(Long paramLong)
  {
    if (this.engRoutePlanEndTime.longValue() == 0L) {
      this.engRoutePlanEndTime = paramLong;
    }
  }
  
  public void setEngRoutePlanStartTime(Long paramLong)
  {
    this.engRoutePlanStartTime = paramLong;
  }
  
  public void setEntry(int paramInt)
  {
    this.mEntry = paramInt;
  }
  
  public void setErrorCode(int paramInt)
  {
    for (;;)
    {
      try
      {
        this.mErrorType = paramInt;
        this.mStatPairList.add(new BasicNameValuePair("rou_ret", "-" + Integer.toString(this.mErrorType)));
        this.mDataCheckBundle.putInt("rou_ret", -this.mErrorType);
        SDKDebugUtil.getInstance().recordRPErrorCode(-this.mErrorType);
        statRoutePlanTag();
        ArrayList localArrayList = this.mStatPairList;
        if (this.mCalcType != null)
        {
          Object localObject1 = this.mCalcType;
          localArrayList.add(new BasicNameValuePair("cal_type", (String)localObject1));
          if (paramInt < 5000)
          {
            localObject1 = getRoutePlanResponseTime();
            this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(((Long)localObject1).longValue())));
            this.mDataCheckBundle.putLong("re_time", ((Long)localObject1).longValue());
          }
          this.mStatPairList.add(new BasicNameValuePair("rou_way", String.valueOf(this.mEntry)));
          this.mDataCheckBundle.putInt("rou_way", this.mEntry);
          this.mStatPairList.add(new BasicNameValuePair("has_s", Integer.toString(this.mHasSensor)));
          BNStatisticsManager.getInstance().onEventWithParam(50002, null, this.mStatPairList);
          DataCheckCenter.getInstance().check(this);
          init();
          return;
        }
      }
      finally {}
      String str = "null";
    }
  }
  
  public void setRecommendRoutePos(int paramInt)
  {
    this.mRecommendPos = paramInt;
  }
  
  public void setResponseTime(long paramLong)
  {
    LogUtil.e(TAG, "stat test setresponsetime time = " + paramLong);
  }
  
  public void setRouPlanDetailViewShowTime(Long paramLong)
  {
    if (!this.startRoutePlanStat) {}
    while (this.rouPlanDetailViewShowTime.longValue() > 0L) {
      return;
    }
    this.rouPlanDetailViewShowTime = paramLong;
  }
  
  public void setRouPlanDetailViewStartTime(Long paramLong)
  {
    this.rouPlanDetailViewStartTime = paramLong;
  }
  
  public void setRoutePlanTimeAndDist(long paramLong1, long paramLong2)
  {
    this.mRoutePlanTime = paramLong1;
    this.mRoutePlanDist = paramLong2;
  }
  
  public void setStatAll(boolean paramBoolean)
  {
    this.mStatAll = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/RoutePlanStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */