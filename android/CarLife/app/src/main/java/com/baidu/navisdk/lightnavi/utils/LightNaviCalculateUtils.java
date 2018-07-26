package com.baidu.navisdk.lightnavi.utils;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class LightNaviCalculateUtils {
    public static String calculateTotalRemainDistString(int nDist) {
        StringBuffer builder = new StringBuffer();
        StringUtils.formatDistance(nDist, UnitLangEnum.ZH, builder);
        return builder.toString();
    }

    public static String calculateArriveTime(int remainTime) {
        long mArriveTimeLong = System.currentTimeMillis();
        Date curDate = new Date(mArriveTimeLong);
        Date arriveDate = new Date(mArriveTimeLong + ((long) (remainTime * 1000)));
        String mArriveTimeStr = new SimpleDateFormat("HH:mm").format(arriveDate);
        if (curDate.getDay() == arriveDate.getDay()) {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{mArriveTimeStr});
        }
        int interval = getIntervalDays(curDate, arriveDate);
        if (interval == 1) {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{BNStyleManager.getString(C4048R.string.nsdk_string_rg_tomorrow)});
        } else if (interval == 2) {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{BNStyleManager.getString(C4048R.string.nsdk_string_rg_the_day_after_tomorrow)});
        } else if (interval > 2) {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time_after_day), new Object[]{"" + interval});
        } else {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{mArriveTimeStr});
        }
    }

    public static String calculateTotalRemainTimeString(int nTime) {
        StringBuffer timeBuffer = new StringBuffer();
        StringUtils.formatTime2(nTime, 2, timeBuffer);
        String timeText = timeBuffer.toString();
        if (timeText.equals("0分钟")) {
            timeText = "1分钟";
        }
        return "剩余 " + timeText.toString();
    }

    public static String calculateNaviRemainTimeString(int remainTime) {
        long mArriveTime = System.currentTimeMillis();
        Date curDate = new Date(mArriveTime);
        Date arriveDate = new Date(mArriveTime + ((long) (remainTime * 1000)));
        String mArriveTimeS = new SimpleDateFormat("HH:mm").format(arriveDate);
        GregorianCalendar curCal = new GregorianCalendar();
        curCal.setTime(curDate);
        GregorianCalendar arriveCal = new GregorianCalendar();
        arriveCal.setTime(arriveDate);
        if (curCal.get(5) != arriveCal.get(5)) {
            int interval = getIntervalDays(curDate, arriveDate);
            if (interval == 1) {
                if (arriveCal.get(11) < 0 || arriveCal.get(11) >= 4) {
                    return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{BNStyleManager.getString(C4048R.string.nsdk_string_rg_tomorrow)});
                }
                return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{BNStyleManager.getString(C4048R.string.nsdk_string_rg_wee_hours)});
            } else if (interval == 2) {
                return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{BNStyleManager.getString(C4048R.string.nsdk_string_rg_the_day_after_tomorrow)});
            } else if (interval > 2) {
                return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time_after_day), new Object[]{"" + interval});
            } else {
                return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{mArriveTimeS});
            }
        } else if (arriveCal.get(11) == 0) {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time_at_wee), new Object[]{mArriveTimeS});
        } else {
            return String.format(BNStyleManager.getString(C4048R.string.nsdk_string_rg_arrive_time), new Object[]{mArriveTimeS});
        }
    }

    private static int getIntervalDays(Date fDate, Date oDate) {
        if (fDate == null || oDate == null) {
            return 0;
        }
        return (int) ((oDate.getTime() - fDate.getTime()) / 86400000);
    }
}
