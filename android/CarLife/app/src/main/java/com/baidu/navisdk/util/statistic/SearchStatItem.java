package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SearchStatItem
  implements StatisitcsDataCheck
{
  private static final String TAG = SearchStatItem.class.getSimpleName();
  private static SearchStatItem mInstance = null;
  private Bundle mDataCheckBundle = new Bundle();
  public long mResponseTime;
  public int mResultIndex;
  public boolean mSearchSucc;
  public String mSearchType;
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  
  public static SearchStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new SearchStatItem();
      }
      SearchStatItem localSearchStatItem = mInstance;
      return localSearchStatItem;
    }
    finally {}
  }
  
  public Bundle getDataBundle()
  {
    return this.mDataCheckBundle;
  }
  
  public String getID()
  {
    return "50001";
  }
  
  public String getSearchType()
  {
    return this.mSearchType;
  }
  
  public void init()
  {
    this.mSearchType = "1";
    this.mResultIndex = 0;
    this.mResponseTime = 0L;
    this.mSearchSucc = false;
    this.mStatPairList = new ArrayList();
    this.mDataCheckBundle.clear();
  }
  
  public void onEvent()
  {
    this.mStatPairList.add(new BasicNameValuePair("sea_type", this.mSearchType));
    this.mDataCheckBundle.putString("sea_type", this.mSearchType);
    this.mStatPairList.add(new BasicNameValuePair("re_time", Long.toString(this.mResponseTime)));
    this.mDataCheckBundle.putLong("re_time", this.mResponseTime);
    Object localObject;
    if (this.mSearchSucc)
    {
      localObject = "1";
      this.mStatPairList.add(new BasicNameValuePair("sea_ret", (String)localObject));
      localObject = this.mDataCheckBundle;
      if (!this.mSearchSucc) {
        break label152;
      }
    }
    label152:
    for (int i = 1;; i = 0)
    {
      ((Bundle)localObject).putInt("sea_ret", i);
      BNStatisticsManager.getInstance().onEventWithParam(50001, null, this.mStatPairList);
      DataCheckCenter.getInstance().check(this);
      init();
      return;
      localObject = "0";
      break;
    }
  }
  
  public void searchStatistics(int paramInt)
  {
    getInstance().setResultIndex(paramInt);
    getInstance().onEvent();
  }
  
  public void setResponseTime(long paramLong)
  {
    this.mResponseTime = paramLong;
  }
  
  public void setResultIndex(int paramInt)
  {
    this.mResultIndex = (paramInt + 1);
  }
  
  public void setSearchResult(boolean paramBoolean)
  {
    this.mSearchSucc = paramBoolean;
  }
  
  public void setSearchType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mSearchType = "1";
      return;
    case 2: 
      this.mSearchType = "2";
      return;
    case 3: 
      this.mSearchType = "3";
      return;
    }
    this.mSearchType = "4";
  }
  
  public void setSearchType(String paramString)
  {
    this.mSearchType = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/SearchStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */