package com.baidu.navisdk.util.common;

import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import java.util.Calendar;
import java.util.TimeZone;

public class RoutePlanTimeUtil {
    private static RoutePlanTimeUtil mNaviCalcRoutTimeUtil;
    private Calendar mCalendar = Calendar.getInstance(TimeZone.getDefault());
    private RoutePlanTime mRoutePlanTime = new RoutePlanTime(0, 0, true);
    private boolean mTimeSetByUser = false;

    private RoutePlanTimeUtil() {
    }

    public static RoutePlanTimeUtil getInstance() {
        if (mNaviCalcRoutTimeUtil == null) {
            mNaviCalcRoutTimeUtil = new RoutePlanTimeUtil();
        }
        return mNaviCalcRoutTimeUtil;
    }

    public int getCurrerntHour() {
        return this.mCalendar.get(11);
    }

    public int getCurrerntMinite() {
        return this.mCalendar.get(12);
    }

    public RoutePlanTime getRoutePlanTime() {
        if (!this.mTimeSetByUser) {
            resetToCurrentTime();
        }
        return this.mRoutePlanTime;
    }

    public void setRoutePlanTime(int hour, int minute) {
        this.mTimeSetByUser = true;
        this.mRoutePlanTime.setHour(hour);
        this.mRoutePlanTime.setMinute(minute);
    }

    public void resetToCurrentTime() {
        this.mTimeSetByUser = false;
        this.mRoutePlanTime.setHour(getCurrerntHour());
        this.mRoutePlanTime.setMinute(getCurrerntMinite());
    }

    public boolean getTimeSetState() {
        return this.mTimeSetByUser;
    }

    public void setRoutePlanTimeValid(boolean b) {
        this.mRoutePlanTime.setValid(b);
    }
}
