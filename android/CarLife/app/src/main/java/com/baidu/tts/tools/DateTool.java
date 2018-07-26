package com.baidu.tts.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTool {
    public static String simpleFormatCurrentDate() {
        return formatCurrentDate("yyyy年M月d日 HH:mm:ss:SSS");
    }

    public static String formatCurrentDate(String template) {
        return format(new Date(), template);
    }

    public static String formatInChinaDate(long millisecond) {
        return format(millisecond, "yyyy年M月d日");
    }

    public static String formatInyyyyMMdd(long millisecond) {
        return format(millisecond, "yyyy.MM.dd");
    }

    public static String formatInHHmm(long millisecond) {
        return format(millisecond, "HH:mm");
    }

    public static String format(long millisecond, String template) {
        return format(new Date(millisecond), template);
    }

    public static String format(Date date, String template) {
        return new SimpleDateFormat(template, Locale.CHINA).format(date);
    }

    public static String format(Calendar calendar, String template) {
        try {
            return format(calendar.getTime(), template);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(String src, String srcTemplate, String desTemplate) {
        try {
            return format(new SimpleDateFormat(srcTemplate, Locale.CHINA).parse(src), desTemplate);
        } catch (Exception e) {
            return null;
        }
    }

    public static Calendar getCalendar(String date, String template) {
        try {
            Date parse = new SimpleDateFormat(template, Locale.CHINA).parse(date);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return instance;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getDateRange(String date, String template, int range) {
        Calendar calendar = getCalendar(date, template);
        Date time = calendar.getTime();
        String[] strArr = new String[range];
        for (int i = 0; i < range; i++) {
            calendar.add(5, -((range - i) - 1));
            calendar.getTime();
            strArr[i] = String.valueOf(calendar.get(5));
            calendar.setTime(time);
        }
        return strArr;
    }

    public static Date getDate(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.CHINA).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
