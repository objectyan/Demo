package com.baidu.navisdk.util.statistic;

import com.baidu.platform.comapi.map.provider.RouteLineResConst;

public class MTJStatisticsUtil {
    private static final long level = 300;
    public static long mARDuration = 0;
    public static long mARStartTime = 0;
    public static long mNaviDuration = 0;
    public static long mNaviStartTime = 0;
    public static int yawingCount = 0;

    public static int getDurationLevel(long duration) {
        int durLevel = (int) (duration / level);
        if (durLevel == 0) {
            return 5;
        }
        if (durLevel == 1) {
            return 10;
        }
        if (durLevel == 2) {
            return 15;
        }
        if (durLevel == 3) {
            return 20;
        }
        if (durLevel == 4) {
            return 25;
        }
        if (durLevel == 5) {
            return 30;
        }
        if (durLevel == 6) {
            return 35;
        }
        if (durLevel == 7) {
            return 40;
        }
        if (durLevel == 8) {
            return 45;
        }
        if (durLevel == 9) {
            return 50;
        }
        if (durLevel == 10) {
            return 55;
        }
        if (durLevel == 11) {
            return 60;
        }
        if (durLevel == 12) {
            return 65;
        }
        if (durLevel == 13) {
            return 70;
        }
        if (durLevel == 14) {
            return 75;
        }
        if (durLevel == 15) {
            return 80;
        }
        if (durLevel == 16) {
            return 85;
        }
        if (durLevel == 17) {
            return 90;
        }
        if (durLevel == 18) {
            return 95;
        }
        if (durLevel == 19) {
            return 100;
        }
        if (durLevel == 20) {
            return 105;
        }
        if (durLevel == 21) {
            return 110;
        }
        if (durLevel == 22) {
            return 115;
        }
        if (durLevel == 23) {
            return 120;
        }
        return RouteLineResConst.LINE_FOOT_GREEN_NORMAL;
    }
}
