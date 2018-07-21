package com.baidu.platform.comapi.search;

public abstract interface RouteSearchStrategy
{
  public static final int ARRIVE_TIME_FIRST = 2;
  public static final int BusStrategyBegin = 0;
  public static final int BusStrategyEnd = 4;
  public static final int BusStrategyLessStop = 2;
  public static final int BusStrategyLessTime = 0;
  public static final int BusStrategyLessWalk = 3;
  public static final int BusStrategyNoSubway = 4;
  public static final int C0ACH_START_STATION_ALL = 11;
  public static final int COACH_STRATEGY_START_STATION = 10;
  public static final int CarStrategyBegin = 0;
  public static final int CarStrategyEnd = 3;
  public static final int CarStrategyLessBlock = 3;
  public static final int CarStrategyLessHighway = 2;
  public static final int CarStrategyLessTime = 0;
  public static final int CarStrategyLessWay = 1;
  public static final int MCarStrategyBegin = 0;
  public static final int MCarStrategyEnd = 2;
  public static final int MCarStrategyNOHighway = 2;
  public static final int NEAREST_MY_LOCATION = 9;
  public static final int PRICE_HIGH_TO_LOW = 8;
  public static final int PRICE_LOW_TO_HIGH = 7;
  public static final int RECOMMEND = 10;
  public static final int ROUTE_TIME_FIRST = 0;
  public static final int ROUTE_TIME_LONG_TO_SHORT = 4;
  public static final int ROUTE_TIME_SHORT_TO_LONG = 3;
  public static final int START_TIME_EARLY_TO_LATE = 5;
  public static final int START_TIME_FIRST = 1;
  public static final int START_TIME_LATE_TO_EARLY = 6;
  public static final int TRAIN_NUM_ALL = 0;
  public static final int TRAIN_NUM_GDC = 1;
  public static final int TRAIN_NUM_NOMAL = 2;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/RouteSearchStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */