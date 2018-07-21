package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.util.statistic.datacheck.StatisitcsDataCheck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviMergeStatItem
  implements StatisitcsDataCheck
{
  public static final String[] BU_ACTPARAM_ARR = { "vid", "pn", "pt", "cld", "hud" };
  private static NaviMergeStatItem instance = null;
  private int accumulateTimes = 0;
  private long lostLocTimeCounts = 0L;
  private long lostLocTimeStart = System.currentTimeMillis();
  private Bundle mDataCheckBundle = null;
  public int mDft = 0;
  HashMap<String, NaviStatPackage> mMergestatCacheMap = null;
  private String mNetFlow = null;
  private ArrayList<NameValuePair> mStatBuList = new ArrayList();
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  private boolean startCountLostLocFlag = false;
  
  private NaviStatPackage accumulePackage(NaviStatPackage paramNaviStatPackage1, NaviStatPackage paramNaviStatPackage2)
  {
    if (paramNaviStatPackage1 == null) {
      return paramNaviStatPackage2;
    }
    if (paramNaviStatPackage2 == null) {
      return paramNaviStatPackage1;
    }
    if (!paramNaviStatPackage1.Key.equals(paramNaviStatPackage2.Key)) {
      return null;
    }
    if (((paramNaviStatPackage1.Value instanceof Double)) && ((paramNaviStatPackage1.Value instanceof Double)))
    {
      double d1 = ((Double)paramNaviStatPackage1.Value).doubleValue();
      double d2 = ((Double)paramNaviStatPackage2.Value).doubleValue();
      return new NaviStatPackage(paramNaviStatPackage1.Key, Double.valueOf(d1 + d2), paramNaviStatPackage1.Type);
    }
    if (((paramNaviStatPackage1.Value instanceof Float)) && ((paramNaviStatPackage1.Value instanceof Float)))
    {
      float f1 = ((Float)paramNaviStatPackage1.Value).floatValue();
      float f2 = ((Float)paramNaviStatPackage2.Value).floatValue();
      return new NaviStatPackage(paramNaviStatPackage1.Key, Float.valueOf(f2 + f1), paramNaviStatPackage1.Type);
    }
    if (((paramNaviStatPackage1.Value instanceof Integer)) && ((paramNaviStatPackage1.Value instanceof Integer)))
    {
      int i = ((Integer)paramNaviStatPackage1.Value).intValue();
      int j = ((Integer)paramNaviStatPackage2.Value).intValue();
      return new NaviStatPackage(paramNaviStatPackage1.Key, Integer.valueOf(j + i), paramNaviStatPackage1.Type);
    }
    if (((paramNaviStatPackage1.Value instanceof Long)) && ((paramNaviStatPackage1.Value instanceof Long)))
    {
      long l1 = ((Long)paramNaviStatPackage1.Value).longValue();
      long l2 = ((Long)paramNaviStatPackage2.Value).longValue();
      return new NaviStatPackage(paramNaviStatPackage1.Key, Long.valueOf(l1 + l2), paramNaviStatPackage1.Type);
    }
    return null;
  }
  
  private void addCheckData(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      this.mDataCheckBundle.putInt(paramString, ((Integer)paramObject).intValue());
    }
    do
    {
      return;
      if ((paramObject instanceof Float))
      {
        this.mDataCheckBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        this.mDataCheckBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        this.mDataCheckBundle.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
    } while (!(paramObject instanceof String));
    this.mDataCheckBundle.putString(paramString, (String)paramObject);
  }
  
  private String addPnStat(String paramString1, String paramString2)
  {
    String str;
    if (paramString1 == null) {
      str = paramString2;
    }
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString1;
        } while (paramString2 == null);
        arrayOfString = paramString1.split("/");
        paramString2 = paramString2.split("/");
        str = paramString1;
      } while (arrayOfString.length != 2);
      str = paramString1;
    } while (paramString2.length != 2);
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(paramString2[0]);
      int k = Integer.parseInt(arrayOfString[1]);
      int m = Integer.parseInt(paramString2[1]);
      return i + j + "/" + (k + m);
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  private void averageValue(NaviStatPackage paramNaviStatPackage, int paramInt)
  {
    if ((paramNaviStatPackage.Value instanceof Double)) {
      paramNaviStatPackage.Value = Double.valueOf(((Double)paramNaviStatPackage.Value).doubleValue() / paramInt);
    }
    do
    {
      return;
      if ((paramNaviStatPackage.Value instanceof Float))
      {
        paramNaviStatPackage.Value = Float.valueOf(((Float)paramNaviStatPackage.Value).floatValue() / paramInt);
        return;
      }
      if ((paramNaviStatPackage.Value instanceof Integer))
      {
        paramNaviStatPackage.Value = Integer.valueOf(((Integer)paramNaviStatPackage.Value).intValue() / paramInt);
        return;
      }
    } while (!(paramNaviStatPackage.Value instanceof Long));
    paramNaviStatPackage.Value = Long.valueOf(((Long)paramNaviStatPackage.Value).longValue() / paramInt);
  }
  
  public static NaviMergeStatItem getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new NaviMergeStatItem();
      }
      return instance;
    }
    finally {}
  }
  
  private void init()
  {
    this.mStatBuList = new ArrayList();
    this.mStatPairList = new ArrayList();
    this.accumulateTimes = 0;
    this.mNetFlow = null;
    this.mDft = 0;
    this.mMergestatCacheMap = null;
    this.startCountLostLocFlag = false;
    this.lostLocTimeStart = System.currentTimeMillis();
    this.lostLocTimeCounts = 0L;
  }
  
  private boolean isBelondBuParams(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = BU_ACTPARAM_ARR;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void addEvent(HashMap<String, NaviStatPackage> paramHashMap)
  {
    if (this.mMergestatCacheMap == null) {
      this.mMergestatCacheMap = new HashMap();
    }
    this.accumulateTimes += 1;
    if (this.mMergestatCacheMap.size() <= 0) {
      this.mMergestatCacheMap.putAll(paramHashMap);
    }
    Iterator localIterator;
    Object localObject4;
    do
    {
      return;
      localIterator = paramHashMap.keySet().iterator();
      localObject4 = null;
    } while (!localIterator.hasNext());
    String str = (String)localIterator.next();
    NaviStatPackage localNaviStatPackage1 = (NaviStatPackage)paramHashMap.get(str);
    Object localObject1;
    switch (localNaviStatPackage1.Type)
    {
    default: 
      localObject1 = localObject4;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.mMergestatCacheMap.put(str, localObject1);
      }
      break;
      localObject1 = accumulePackage((NaviStatPackage)this.mMergestatCacheMap.get(str), localNaviStatPackage1);
      continue;
      localObject1 = localObject4;
      if (!this.mMergestatCacheMap.containsKey(str))
      {
        localObject1 = localNaviStatPackage1;
        continue;
        localObject1 = localNaviStatPackage1;
        continue;
        NaviStatPackage localNaviStatPackage2 = (NaviStatPackage)this.mMergestatCacheMap.get(str);
        if (localNaviStatPackage2 == null)
        {
          localObject1 = localNaviStatPackage1;
        }
        else
        {
          Object localObject2;
          if (str.equals("hasData"))
          {
            try
            {
              localObject1 = (Integer)localNaviStatPackage2.Value;
              throw new NullPointerException();
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              localObject2 = localObject4;
            }
          }
          else
          {
            localObject2 = localObject4;
            if (str.equals("pn")) {
              try
              {
                localObject2 = (String)localNaviStatPackage2.Value;
                if (0 == 0) {
                  localObject2 = localNaviStatPackage2;
                } else {
                  throw new NullPointerException();
                }
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
                Object localObject3 = localObject4;
              }
            }
          }
        }
      }
    }
  }
  
  public void endCountLostLoc()
  {
    if (!this.startCountLostLocFlag) {
      return;
    }
    this.startCountLostLocFlag = false;
    this.lostLocTimeCounts += System.currentTimeMillis() - this.lostLocTimeStart;
  }
  
  public Bundle getDataBundle()
  {
    return this.mDataCheckBundle;
  }
  
  public String getID()
  {
    return "50003";
  }
  
  public void onEvent()
  {
    NetFlowStat.getInstance().endStat(BNaviModuleManager.getContext());
    if ((this.mMergestatCacheMap == null) || (this.mMergestatCacheMap.size() <= 0)) {
      init();
    }
    while ((this.mStatBuList == null) || (this.mStatPairList == null)) {
      return;
    }
    this.mStatPairList.clear();
    this.mStatBuList.clear();
    if (this.accumulateTimes == 0) {
      this.accumulateTimes = 1;
    }
    Object localObject = this.mMergestatCacheMap.entrySet().iterator();
    this.mDataCheckBundle = new Bundle();
    while (((Iterator)localObject).hasNext())
    {
      NaviStatPackage localNaviStatPackage = (NaviStatPackage)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localNaviStatPackage.Value != null)
      {
        if ((this.accumulateTimes >= 1) && (localNaviStatPackage.Type == 4)) {
          averageValue(localNaviStatPackage, this.accumulateTimes);
        }
        if (isBelondBuParams(localNaviStatPackage.Key)) {
          this.mStatBuList.add(new BasicNameValuePair(localNaviStatPackage.Key, localNaviStatPackage.Value.toString()));
        }
        for (;;)
        {
          addCheckData(localNaviStatPackage.Key, localNaviStatPackage.Value);
          LogUtil.e("NaviMergeStatItem", "event_test_96 _Merge" + localNaviStatPackage.Key + "," + localNaviStatPackage.Value.toString());
          break;
          this.mStatPairList.add(new BasicNameValuePair(localNaviStatPackage.Key, localNaviStatPackage.Value.toString()));
        }
      }
    }
    this.mStatPairList.add(new BasicNameValuePair("dfd", this.mNetFlow));
    addCheckData("dfd", this.mNetFlow);
    this.mStatPairList.add(new BasicNameValuePair("dft", Integer.toString(this.mDft)));
    addCheckData("dft", Integer.valueOf(this.mDft));
    localObject = Long.valueOf(this.lostLocTimeCounts / 1000L);
    this.mStatPairList.add(new BasicNameValuePair("lost_totaltime", Long.toString(((Long)localObject).longValue())));
    addCheckData("lost_totaltime", localObject);
    LogUtil.e("NaviMergeStatItem", "event_test_96 _Merge, actParams {" + paramsToString(this.mStatPairList) + " }, buParams {" + paramsToString(this.mStatBuList) + "}");
    BNStatisticsManager.getInstance().onEventWithParam(50003, null, this.mStatPairList, this.mStatBuList);
    DataCheckCenter.getInstance().check(this);
    init();
    NaviStatItem.getInstance().initNaviSataParam();
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
  
  public void setNetFlow(String paramString)
  {
    this.mNetFlow = paramString;
  }
  
  public void startCountLostLoc()
  {
    this.startCountLostLocFlag = true;
    this.lostLocTimeCounts = System.currentTimeMillis();
  }
  
  public static abstract interface NaviStatKeyType
  {
    public static final int TYPE_NEEDED_RECORDE_BY_ACCUMULE = 1;
    public static final int TYPE_NEEDED_RECORDE_BY_AVERAGE = 4;
    public static final int TYPE_NEEDED_RECORDE_BY_FIRSTTIME = 2;
    public static final int TYPE_NEEDED_RECORDE_BY_LASTTIME = 3;
    public static final int TYPE_NEEDED_RECORDE_BY_SPECIAL = 5;
  }
  
  public static class NaviStatPackage
  {
    public String Key;
    public int Type;
    public Object Value;
    
    public NaviStatPackage(String paramString, Object paramObject, int paramInt)
    {
      this.Key = paramString;
      this.Value = paramObject;
      this.Type = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/NaviMergeStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */