package com.baidu.navi.utils;

import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.common.LogUtil;

public class StatisticUtils {
    public static void statSetDestFromPoi() {
        int value;
        NaviFragmentManager fragManager = C1328h.a().getNaviFragmentManager();
        if (fragManager.getCurrentFragmentType() == 17) {
            value = 8;
            BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(8));
        } else {
            if (fragManager.findFragmentIndexInStack(49) >= 1) {
                value = 2;
            } else {
                value = 1;
            }
            BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(value));
        }
        LogUtil.m15791e("statistics", "~~set dest, value " + value);
    }

    public static void statSetDestFromQuickLink() {
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(3));
        LogUtil.m15791e("statistics", "~~set dest: WANTGO_LINK");
    }

    public static void statSetDestFromHistory() {
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(5));
        LogUtil.m15791e("statistics", "~~set dest: WANTGO_HISTORY");
    }

    public static void statSetDestFromFavorite() {
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(4));
        LogUtil.m15791e("statistics", "~~set dest: WANTGO_FAVORITE");
    }

    public static void statSetDestFromRoutePlan() {
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(6));
        LogUtil.m15791e("statistics", "~~set dest: ROUTE_PLAN_SET");
    }

    public static void statSetDestFromHistoryRoute() {
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_ROUTEPLAN, NaviStatConstants.K_NSC_KEY_ROUTEPLAN_SETDEST, String.valueOf(7));
        LogUtil.m15791e("statistics", "~~set dest: HISTORY_ROUTE");
    }
}
