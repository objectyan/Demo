package com.baidu.navisdk.util.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils
{
  public static String[] WEEK = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
  
  public static String getDataTime(SimpleDateFormat paramSimpleDateFormat)
  {
    return paramSimpleDateFormat.format(new Date(System.currentTimeMillis()));
  }
  
  public static String getWeek(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(7);
    if ((i < 1) || (i > 7)) {
      return null;
    }
    return WEEK[(i - 1)];
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/DateTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */