package com.baidu.navi.util;

import java.sql.Date;
import java.util.Calendar;

public class RouteCustomUtil
{
  public static final int MILLS_EVERY_DAY = 86400000;
  public static final int ROUTE_CUSTOM_ACTION_CREATE = 1;
  public static final int ROUTE_CUSTOM_ACTION_EDIT = 2;
  public static final int ROUTE_CUSTOM_REPEAT_FRI = 6;
  public static final int ROUTE_CUSTOM_REPEAT_MON = 2;
  public static final int ROUTE_CUSTOM_REPEAT_SAT = 7;
  public static final int ROUTE_CUSTOM_REPEAT_SUN = 1;
  public static final int ROUTE_CUSTOM_REPEAT_THU = 5;
  public static final int ROUTE_CUSTOM_REPEAT_TUE = 3;
  public static final int ROUTE_CUSTOM_REPEAT_WED = 4;
  private static RouteCustomUtil mInstance;
  
  private String format(int paramInt)
  {
    String str2 = "" + paramInt;
    String str1 = str2;
    if (str2.length() == 1) {
      str1 = "0" + str2;
    }
    return str1;
  }
  
  public static RouteCustomUtil getInstance()
  {
    if (mInstance == null) {
      mInstance = new RouteCustomUtil();
    }
    return mInstance;
  }
  
  public long calcPushTime(int paramInt1, int paramInt2, int paramInt3)
  {
    long l3 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.set(11, paramInt1);
    localCalendar.set(12, paramInt2);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l2 = localCalendar.getTimeInMillis();
    long l1 = l2;
    if (paramInt3 == 0)
    {
      l1 = l2;
      if (l2 < l3) {
        l1 = l2 + 86400000L;
      }
    }
    return l1;
  }
  
  public long getPushTimeMillsByWeek(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if (getWeekByTimeMillis(System.currentTimeMillis()) >= paramInt1) {
      i = 7;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.set(7, paramInt1);
    localCalendar.set(11, paramInt2);
    localCalendar.set(12, paramInt3);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() + 86400000 * i;
  }
  
  public String getTimeStr(int paramInt1, int paramInt2)
  {
    return format(paramInt1) + ":" + format(paramInt2);
  }
  
  public int getWeekByTimeMillis(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramLong));
    int j = localCalendar.get(7);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/util/RouteCustomUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */