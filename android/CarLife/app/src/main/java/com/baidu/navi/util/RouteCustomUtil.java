package com.baidu.navi.util;

import com.baidu.mobstat.Config;
import java.sql.Date;
import java.util.Calendar;

public class RouteCustomUtil {
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

    public static RouteCustomUtil getInstance() {
        if (mInstance == null) {
            mInstance = new RouteCustomUtil();
        }
        return mInstance;
    }

    public long getPushTimeMillsByWeek(int week, int hour, int minute) {
        int days = 0;
        if (getWeekByTimeMillis(System.currentTimeMillis()) >= week) {
            days = 7;
        }
        Calendar calende = Calendar.getInstance();
        calende.setTimeInMillis(System.currentTimeMillis());
        calende.set(7, week);
        calende.set(11, hour);
        calende.set(12, minute);
        calende.set(13, 0);
        calende.set(14, 0);
        return calende.getTimeInMillis() + ((long) (86400000 * days));
    }

    public int getWeekByTimeMillis(long mills) {
        Calendar calende = Calendar.getInstance();
        calende.setTime(new Date(mills));
        int week = calende.get(7);
        if (week < 0) {
            return 0;
        }
        return week;
    }

    public long calcPushTime(int hour, int minute, int isRepeat) {
        long curTimeMills = System.currentTimeMillis();
        Calendar calende = Calendar.getInstance();
        calende.setTimeInMillis(System.currentTimeMillis());
        calende.set(11, hour);
        calende.set(12, minute);
        calende.set(13, 0);
        calende.set(14, 0);
        long time = calende.getTimeInMillis();
        if (isRepeat != 0 || time >= curTimeMills) {
            return time;
        }
        return time + 86400000;
    }

    public String getTimeStr(int hour, int minute) {
        String timeStr = "";
        return format(hour) + Config.TRACE_TODAY_VISIT_SPLIT + format(minute);
    }

    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            return "0" + s;
        }
        return s;
    }
}
