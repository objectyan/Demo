package com.baidu.navisdk.util.statistic;

public class MTJStatisticsUtil
{
  private static final long level = 300L;
  public static long mARDuration = 0L;
  public static long mARStartTime;
  public static long mNaviDuration;
  public static long mNaviStartTime = 0L;
  public static int yawingCount = 0;
  
  static
  {
    mNaviDuration = 0L;
    mARStartTime = 0L;
  }
  
  public static int getDurationLevel(long paramLong)
  {
    int i = (int)(paramLong / 300L);
    if (i == 0) {
      return 5;
    }
    if (i == 1) {
      return 10;
    }
    if (i == 2) {
      return 15;
    }
    if (i == 3) {
      return 20;
    }
    if (i == 4) {
      return 25;
    }
    if (i == 5) {
      return 30;
    }
    if (i == 6) {
      return 35;
    }
    if (i == 7) {
      return 40;
    }
    if (i == 8) {
      return 45;
    }
    if (i == 9) {
      return 50;
    }
    if (i == 10) {
      return 55;
    }
    if (i == 11) {
      return 60;
    }
    if (i == 12) {
      return 65;
    }
    if (i == 13) {
      return 70;
    }
    if (i == 14) {
      return 75;
    }
    if (i == 15) {
      return 80;
    }
    if (i == 16) {
      return 85;
    }
    if (i == 17) {
      return 90;
    }
    if (i == 18) {
      return 95;
    }
    if (i == 19) {
      return 100;
    }
    if (i == 20) {
      return 105;
    }
    if (i == 21) {
      return 110;
    }
    if (i == 22) {
      return 115;
    }
    if (i == 23) {
      return 120;
    }
    return 125;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/MTJStatisticsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */