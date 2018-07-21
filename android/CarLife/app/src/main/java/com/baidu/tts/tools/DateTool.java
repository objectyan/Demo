package com.baidu.tts.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTool
{
  public static String format(long paramLong, String paramString)
  {
    return format(new Date(paramLong), paramString);
  }
  
  public static String format(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = format(new SimpleDateFormat(paramString2, Locale.CHINA).parse(paramString1), paramString3);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String format(Calendar paramCalendar, String paramString)
  {
    try
    {
      paramCalendar = format(paramCalendar.getTime(), paramString);
      return paramCalendar;
    }
    catch (Exception paramCalendar) {}
    return null;
  }
  
  public static String format(Date paramDate, String paramString)
  {
    return new SimpleDateFormat(paramString, Locale.CHINA).format(paramDate);
  }
  
  public static String formatCurrentDate(String paramString)
  {
    return format(new Date(), paramString);
  }
  
  public static String formatInChinaDate(long paramLong)
  {
    return format(paramLong, "yyyy年M月d日");
  }
  
  public static String formatInHHmm(long paramLong)
  {
    return format(paramLong, "HH:mm");
  }
  
  public static String formatInyyyyMMdd(long paramLong)
  {
    return format(paramLong, "yyyy.MM.dd");
  }
  
  public static Calendar getCalendar(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new SimpleDateFormat(paramString2, Locale.CHINA).parse(paramString1);
      paramString2 = Calendar.getInstance();
      paramString2.setTime(paramString1);
      return paramString2;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static Date getDate(String paramString1, String paramString2)
  {
    paramString2 = new SimpleDateFormat(paramString2, Locale.CHINA);
    try
    {
      paramString1 = paramString2.parse(paramString1);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String[] getDateRange(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getCalendar(paramString1, paramString2);
    paramString2 = paramString1.getTime();
    String[] arrayOfString = new String[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      paramString1.add(5, -(paramInt - i - 1));
      paramString1.getTime();
      arrayOfString[i] = String.valueOf(paramString1.get(5));
      paramString1.setTime(paramString2);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String simpleFormatCurrentDate()
  {
    return formatCurrentDate("yyyy年M月d日 HH:mm:ss:SSS");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/DateTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */