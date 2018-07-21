package com.baidu.navi.utils;

import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.util.common.LogUtil;

public class StatisticUtils
{
  public static void statSetDestFromFavorite()
  {
    BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(4));
    LogUtil.e("statistics", "~~set dest: WANTGO_FAVORITE");
  }
  
  public static void statSetDestFromHistory()
  {
    BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(5));
    LogUtil.e("statistics", "~~set dest: WANTGO_HISTORY");
  }
  
  public static void statSetDestFromHistoryRoute()
  {
    BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(7));
    LogUtil.e("statistics", "~~set dest: HISTORY_ROUTE");
  }
  
  public static void statSetDestFromPoi()
  {
    NaviFragmentManager localNaviFragmentManager = h.a().getNaviFragmentManager();
    if (localNaviFragmentManager.getCurrentFragmentType() == 17)
    {
      i = 8;
      BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(8));
      LogUtil.e("statistics", "~~set dest, value " + i);
      return;
    }
    if (localNaviFragmentManager.findFragmentIndexInStack(49) >= 1) {}
    for (int i = 2;; i = 1)
    {
      BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(i));
      break;
    }
  }
  
  public static void statSetDestFromQuickLink()
  {
    BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(3));
    LogUtil.e("statistics", "~~set dest: WANTGO_LINK");
  }
  
  public static void statSetDestFromRoutePlan()
  {
    BNStatisticsManager.getInstance().onEventWithParam(50002, "set_dest", String.valueOf(6));
    LogUtil.e("statistics", "~~set dest: ROUTE_PLAN_SET");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/StatisticUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */