package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class CruiseStatItem
{
  private static final String TAG = CruiseStatItem.class.getSimpleName();
  private static CruiseStatItem mInstance = null;
  public String mCruiseFrom;
  public boolean mIsGPSLocated = false;
  public long mLocatingTime = -1L;
  public int mLostGPSCount = 0;
  public long mStartCruiseEngineTime = -1L;
  public long mStartCruiseTime = -1L;
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  public long mTotalDistance = 0L;
  
  private CruiseStatItem()
  {
    init();
  }
  
  public static CruiseStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new CruiseStatItem();
      }
      CruiseStatItem localCruiseStatItem = mInstance;
      return localCruiseStatItem;
    }
    finally {}
  }
  
  private void statTotalTimeAndDist()
  {
    Long localLong = Long.valueOf(0L);
    if (this.mStartCruiseEngineTime > 0L) {
      localLong = Long.valueOf((SystemClock.elapsedRealtime() - this.mStartCruiseEngineTime) / 1000L);
    }
    this.mStatPairList.add(new BasicNameValuePair("real_time", localLong.toString()));
    this.mStatPairList.add(new BasicNameValuePair("real_dis", Long.toString(this.mTotalDistance)));
  }
  
  public void init()
  {
    this.mCruiseFrom = "1";
    this.mStartCruiseTime = -1L;
    this.mStartCruiseEngineTime = -1L;
    this.mLocatingTime = -1L;
    this.mTotalDistance = 0L;
    this.mLostGPSCount = 0;
    this.mIsGPSLocated = false;
    this.mStatPairList = new ArrayList();
  }
  
  public void onEvent()
  {
    if (this.mStartCruiseEngineTime > 0L) {
      this.mLocatingTime = ((this.mStartCruiseEngineTime - this.mStartCruiseTime) / 1000L);
    }
    this.mStatPairList.add(new BasicNameValuePair("st_route", this.mCruiseFrom));
    statTotalTimeAndDist();
    this.mStatPairList.add(new BasicNameValuePair("loc_time", Long.toString(this.mLocatingTime)));
    if (this.mStartCruiseEngineTime > 0L) {
      this.mStatPairList.add(new BasicNameValuePair("lost_times", Integer.toString(this.mLostGPSCount)));
    }
    BNStatisticsManager.getInstance().onEventWithParam(50004, null, this.mStatPairList);
    init();
  }
  
  public void setCruiseFrom(String paramString)
  {
    this.mCruiseFrom = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/CruiseStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */