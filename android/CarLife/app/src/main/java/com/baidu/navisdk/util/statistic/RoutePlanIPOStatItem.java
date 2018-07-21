package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RoutePlanIPOStatItem
  extends RoutePlanStatItem
{
  private static final String TAG = RoutePlanIPOStatItem.class.getSimpleName();
  private static RoutePlanIPOStatItem mInstance = null;
  private Bundle mDataCheckBundle = new Bundle();
  private int mErrorType = -1;
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  
  public static RoutePlanIPOStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new RoutePlanIPOStatItem();
      }
      RoutePlanIPOStatItem localRoutePlanIPOStatItem = mInstance;
      return localRoutePlanIPOStatItem;
    }
    finally {}
  }
  
  public void init()
  {
    super.init();
    this.mCalcType = "1";
    this.mSwitchRouteCount = 0;
    this.mRouteIndex = 0;
    this.mRoutePlanTime = 0L;
    this.mRoutePlanDist = 0L;
    this.mStartNavi = false;
    this.mRouteCount = 0;
    this.mRouteSwitchEndTime = 0L;
    this.mRouteSwitchStartTime = 0L;
    this.mRecommendPos = 0;
    this.mEntry = 3;
    this.mCurrLocationType = 0;
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
    this.mRouteCount = 1;
    this.mStatPairList.add(new BasicNameValuePair("rou_ret", Integer.toString(this.mRouteCount)));
    this.mDataCheckBundle.putInt("rou_ret", this.mRouteCount);
    this.mStatPairList.add(new BasicNameValuePair("rou_way", String.valueOf(this.mEntry)));
    this.mDataCheckBundle.putInt("rou_way", this.mEntry);
    BNStatisticsManager.getInstance().onEventWithParam(50002, null, this.mStatPairList);
    DataCheckCenter.getInstance().check(this);
    SDKDebugUtil.getInstance().recordRPErrorCode(this.mRouteCount);
    init();
  }
  
  public void setErrorCode(int paramInt)
  {
    try
    {
      this.mErrorType = paramInt;
      this.mStatPairList.add(new BasicNameValuePair("rou_ret", "-" + Integer.toString(this.mErrorType)));
      this.mDataCheckBundle.putInt("rou_ret", -this.mErrorType);
      SDKDebugUtil.getInstance().recordRPErrorCode(-this.mErrorType);
      this.mStatPairList.add(new BasicNameValuePair("rou_way", String.valueOf(this.mEntry)));
      this.mDataCheckBundle.putString("rou_way", String.valueOf(this.mEntry));
      BNStatisticsManager.getInstance().onEventWithParam(50002, null, this.mStatPairList);
      DataCheckCenter.getInstance().check(this);
      init();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/RoutePlanIPOStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */