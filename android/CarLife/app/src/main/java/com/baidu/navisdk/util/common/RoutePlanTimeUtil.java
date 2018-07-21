package com.baidu.navisdk.util.common;

import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import java.util.Calendar;
import java.util.TimeZone;

public class RoutePlanTimeUtil
{
  private static RoutePlanTimeUtil mNaviCalcRoutTimeUtil;
  private Calendar mCalendar = Calendar.getInstance(TimeZone.getDefault());
  private RoutePlanTime mRoutePlanTime = new RoutePlanTime(0, 0, true);
  private boolean mTimeSetByUser = false;
  
  public static RoutePlanTimeUtil getInstance()
  {
    if (mNaviCalcRoutTimeUtil == null) {
      mNaviCalcRoutTimeUtil = new RoutePlanTimeUtil();
    }
    return mNaviCalcRoutTimeUtil;
  }
  
  public int getCurrerntHour()
  {
    return this.mCalendar.get(11);
  }
  
  public int getCurrerntMinite()
  {
    return this.mCalendar.get(12);
  }
  
  public RoutePlanTime getRoutePlanTime()
  {
    if (!this.mTimeSetByUser) {
      resetToCurrentTime();
    }
    return this.mRoutePlanTime;
  }
  
  public boolean getTimeSetState()
  {
    return this.mTimeSetByUser;
  }
  
  public void resetToCurrentTime()
  {
    this.mTimeSetByUser = false;
    this.mRoutePlanTime.setHour(getCurrerntHour());
    this.mRoutePlanTime.setMinute(getCurrerntMinite());
  }
  
  public void setRoutePlanTime(int paramInt1, int paramInt2)
  {
    this.mTimeSetByUser = true;
    this.mRoutePlanTime.setHour(paramInt1);
    this.mRoutePlanTime.setMinute(paramInt2);
  }
  
  public void setRoutePlanTimeValid(boolean paramBoolean)
  {
    this.mRoutePlanTime.setValid(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/RoutePlanTimeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */