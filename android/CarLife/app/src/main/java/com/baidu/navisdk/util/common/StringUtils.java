package com.baidu.navisdk.util.common;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Html;
import android.text.TextUtils;
import com.baidu.mapframework.common.config.GlobalConfigKey;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final String HTML_DIST = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_DIST_NO_DECIMAL = "<font color=\"#ffffff\">%.0f</font><font color=\"#b5b7b6\">%s</font>";
    private static final String HTML_DIST_TIME = "<font color=\"#b5b7b6\">剩:</font>%s&nbsp;&nbsp;%s";
    private static final String HTML_DIST_WITH_DECIMAL = "<font color=\"#ffffff\">%.1f</font><font color=\"#b5b7b6\">%s</font>";
    public static final String HTML_TIME_HOUR = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    public static final String HTML_TIME_HOUR_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font><font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    public static final String HTML_TIME_MINUTE = "<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>";
    private static final int SECOND_OF_DAY = 86400;
    private static final int SECOND_OF_HOUR = 3600;
    private static final int SECOND_OF_MINUTE = 60;
    public static final int TIME_EN_UNIT = -1;
    public static final int TIME_ZH_UNIT = 2;
    private static final String UNIT_MINUTE = "分";
    public static final String lessOneMinute = "少于1分钟";
    public static final String[] unitDistArray = new String[]{Config.MODEL, "km", "米", "公里"};
    public static final String[] unitTimeArray = new String[]{Config.MODEL, "h", "分钟", "小时"};
    public static final String[] unitTimeArray2 = new String[]{Config.MODEL, "h", "d", "分钟", "小时", "天"};

    public enum UnitLangEnum {
        EN(0),
        ZH(1);
        
        private int nUnit;

        private UnitLangEnum(int nUnit) {
            this.nUnit = nUnit;
        }

        public int getnUnit() {
            return this.nUnit;
        }

        public void setnUnit(int nUnit) {
            this.nUnit = nUnit;
        }
    }

    public static void formatDistAndTime(int nDist, int nTime, StringBuffer formatDistTime) {
        if (formatDistTime != null) {
            StringBuffer dist = new StringBuffer();
            StringBuffer time = new StringBuffer();
            formatHtmlDistance(nDist, dist);
            formatHtmlTime(nTime, time);
            formatDistTime.append(String.format(HTML_DIST_TIME, new Object[]{dist, time}));
        }
    }

    public static String formatDistanceToString(int nDist, UnitLangEnum langEnum) {
        StringBuffer formatDist = new StringBuffer();
        formatDistance(nDist, langEnum, formatDist);
        return formatDist.toString();
    }

    public static void formatDistance(int nDist, UnitLangEnum langEnum, StringBuffer formatDist) {
        boolean bNoZero = false;
        int nUnit = langEnum.getnUnit();
        if (nUnit != 0) {
            nUnit++;
        }
        if (nDist >= 1000) {
            if (nDist % 1000 == 0) {
                bNoZero = true;
            }
            String distFormat = "";
            if (bNoZero) {
                distFormat = "%.0f%s";
            } else {
                distFormat = "%.1f%s";
            }
            if (formatDist != null) {
                if (nDist / 1000 >= 100) {
                    formatDist.append(String.format("%d%s", new Object[]{Integer.valueOf(nDist / 1000), unitDistArray[nUnit + 1]}));
                    return;
                }
                formatDist.append(String.format(distFormat, new Object[]{Double.valueOf(((double) nDist) / 1000.0d), unitDistArray[nUnit + 1]}));
            }
        } else if (formatDist != null) {
            formatDist.append(String.format("%d%s", new Object[]{Integer.valueOf(nDist), unitDistArray[nUnit + 0]}));
        }
    }

    public static String formatDistance(int nDist, StringBuffer formatDist) {
        int offset;
        boolean bNoZero = false;
        if (nDist >= 1000) {
            offset = 1;
            if (nDist % 1000 == 0) {
                bNoZero = true;
            }
            String distFormat = "";
            if (bNoZero) {
                distFormat = "%.0f";
            } else {
                distFormat = "%.1f";
            }
            if (formatDist != null) {
                if (nDist / 1000 >= 100) {
                    formatDist.append(String.format("%d", new Object[]{Integer.valueOf(nDist / 1000)}));
                } else {
                    formatDist.append(String.format(distFormat, new Object[]{Double.valueOf(((double) nDist) / 1000.0d)}));
                }
            }
        } else {
            offset = 0;
            if (formatDist != null) {
                formatDist.append(String.format("%d", new Object[]{Integer.valueOf(nDist)}));
            }
        }
        return unitDistArray[0 + offset];
    }

    public static void formatHtmlDistance(int nDist, StringBuffer formatDist) {
        boolean bNoZero = false;
        if (nDist >= 1000) {
            if (nDist % 1000 == 0) {
                bNoZero = true;
            }
            String distFormat = "";
            if (bNoZero) {
                distFormat = HTML_DIST_NO_DECIMAL;
            } else {
                distFormat = HTML_DIST_WITH_DECIMAL;
            }
            if (formatDist != null) {
                if (nDist / 1000 >= 100) {
                    formatDist.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(nDist / 1000), unitDistArray[1]}));
                    return;
                }
                formatDist.append(String.format(distFormat, new Object[]{Double.valueOf(((double) nDist) / 1000.0d), unitDistArray[1]}));
            }
        } else if (formatDist != null) {
            formatDist.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(nDist), unitDistArray[0]}));
        }
    }

    protected static int formatZeroInt(int nArg, int split) {
        if (split == 0) {
            return 0;
        }
        int i = nArg / split;
        if (0.5d + ((double) (nArg / split)) >= ((double) (i + 1))) {
            i++;
        }
        return i * split;
    }

    public static void formatTime(int nTime, UnitLangEnum langEnum, StringBuffer formatTime) {
        boolean bNoZero = false;
        int nUnit = langEnum.getnUnit();
        if (nUnit != 0) {
            nUnit++;
        }
        if (nTime >= SECOND_OF_HOUR) {
            if (nTime % SECOND_OF_HOUR >= 0 && nTime % SECOND_OF_HOUR < 360) {
                bNoZero = false;
            }
            if (formatTime == null) {
                return;
            }
            if (bNoZero) {
                formatTime.append(String.format("%.1f%s", new Object[]{Double.valueOf(((double) nTime) / 3600.0d), unitTimeArray[nUnit + 1]}));
                return;
            }
            formatTime.append(String.format("%.0f%s", new Object[]{Double.valueOf(((double) nTime) / 3600.0d), unitTimeArray[nUnit + 1]}));
        } else if (nTime < 60) {
            if (formatTime != null) {
                formatTime.append(lessOneMinute);
            }
        } else if (formatTime != null) {
            formatTime.append(String.format("%d%s", new Object[]{Integer.valueOf(nTime / 60), unitTimeArray[nUnit + 0]}));
        }
    }

    public static void formatHtmlTime(int nTime, StringBuffer formatTime) {
        int nMinute;
        if (nTime >= SECOND_OF_HOUR) {
            int nHour = nTime / SECOND_OF_HOUR;
            nMinute = (nTime / 60) % 60;
            if (formatTime == null) {
                return;
            }
            if (nMinute > 0) {
                formatTime.append(String.format(HTML_TIME_HOUR_MINUTE, new Object[]{Integer.valueOf(nHour), unitTimeArray[1], Integer.valueOf(nMinute), unitTimeArray[0]}));
                return;
            }
            formatTime.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(nHour), unitTimeArray[1]}));
            return;
        }
        nMinute = nTime / 60;
        if (nTime < 60) {
            if (formatTime != null) {
                formatTime.append(lessOneMinute);
            }
        } else if (formatTime != null) {
            formatTime.append(String.format("<font color=\"#ffffff\">%d</font><font color=\"#b5b7b6\">%s</font>", new Object[]{Integer.valueOf(nMinute), unitTimeArray[0]}));
        }
    }

    public static int isNavStartEndPointInvalid(int sx, int sy, int ex, int ey, int myptx, int mypty) {
        if (ex == myptx && ey == mypty) {
            return 1;
        }
        if (lineDistance((double) sx, (double) sy, (double) myptx, (double) mypty) > 50.0d) {
            return 2;
        }
        if (lineDistance((double) sx, (double) sy, (double) ex, (double) ey) < 100.0d) {
            return 3;
        }
        return 0;
    }

    public static boolean isNavSetEndPointInvalid(int ex, int ey, int myptx, int mypty) {
        if (Math.sqrt((double) (((myptx - ex) * (myptx - ex)) + ((mypty - ey) * (mypty - ey)))) < 50.0d) {
            return true;
        }
        return false;
    }

    public static double lineDistance(double sx, double sy, double ex, double ey) {
        return Math.sqrt(((ex - sx) * (ex - sx)) + ((ey - sy) * (ey - sy)));
    }

    public static double geoSphereDistance(double sx, double sy, double ex, double ey) {
        double Y1 = sy;
        double Y2 = ey;
        double dy = Y1 - Y2;
        double dx = (sx - ex) * Math.cos(((Y1 + Y2) / 2.0d) * 1.7453292519943294E-7d);
        return Math.sqrt(((dx * dx) + (dy * dy)) * 1.1119104d);
    }

    public static void createDir(String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public static String getFormatTime(long time) {
        if (time < 60) {
            return "小于1分钟";
        }
        long hour1 = time / 3600;
        long minute1 = (time % 3600) / 60;
        if (time % 60 >= 30) {
            minute1++;
        }
        if (minute1 > 59) {
            hour1++;
            minute1 = 0;
        }
        String str = "%s%s";
        Object[] objArr = new Object[2];
        objArr[0] = hour1 < 1 ? "" : hour1 + "小时";
        objArr[1] = minute1 < 1 ? "" : minute1 + "分钟";
        return String.format(str, objArr);
    }

    public static void formatTime2(int nTime, int nUnit, StringBuffer formatTime) {
        if (formatTime == null) {
            return;
        }
        if (nTime < 60) {
            formatTime.append(lessOneMinute);
            return;
        }
        int hour = (nTime / SECOND_OF_HOUR) % 24;
        int minute = (nTime / 60) % 60;
        if (nTime < SECOND_OF_HOUR) {
            formatTime.append(minute).append(unitTimeArray2[nUnit + 1]);
        } else if (nTime < SECOND_OF_DAY) {
            formatTime.append(hour).append(unitTimeArray2[nUnit + 2]);
            if (minute > 0) {
                formatTime.append(minute).append(UNIT_MINUTE);
            }
        } else {
            formatTime.append(nTime / SECOND_OF_DAY).append(unitTimeArray2[nUnit + 3]);
            if (hour > 0) {
                formatTime.append(hour).append(unitTimeArray2[nUnit + 2]);
            }
        }
    }

    public static String formatTime2(int nTime, int nUnit) {
        StringBuffer buffer = new StringBuffer();
        formatTime2(nTime, nUnit, buffer);
        return buffer.toString();
    }

    public static String customedFormatTime(int nTime, String unitDay, String unitHour, String unitMin) {
        StringBuffer formatTime = new StringBuffer();
        if (formatTime == null) {
            return "";
        }
        if (nTime < 60) {
            formatTime.append(lessOneMinute);
        } else {
            if (unitDay == null) {
                unitDay = unitTimeArray2[5];
            }
            if (unitHour == null) {
                unitHour = unitTimeArray2[4];
            }
            if (unitMin == null) {
                unitMin = unitTimeArray2[3];
            }
            int hour = (nTime / SECOND_OF_HOUR) % 24;
            int minute = (nTime / 60) % 60;
            if (nTime < SECOND_OF_HOUR) {
                formatTime.append(minute).append(unitMin);
            } else if (nTime < SECOND_OF_DAY) {
                formatTime.append(hour).append(unitHour);
                if (minute > 0) {
                    formatTime.append(minute).append(unitMin);
                }
            } else {
                formatTime.append(nTime / SECOND_OF_DAY).append(unitDay);
                if (hour > 0) {
                    formatTime.append(hour).append(unitHour);
                }
            }
        }
        return formatTime.toString();
    }

    public static String[] formatDistance(int nDist, UnitLangEnum langEnum) {
        String[] data = new String[2];
        boolean bNoZero = false;
        int nUnit = langEnum.getnUnit();
        if (nUnit != 0) {
            nUnit++;
        }
        if (nDist >= 1000) {
            if (nDist % 1000 == 0) {
                bNoZero = true;
            }
            if (bNoZero) {
                data[0] = String.format("%.0f", new Object[]{Double.valueOf(((double) nDist) / 1000.0d)});
                data[1] = unitDistArray[nUnit + 1];
            } else {
                data[0] = String.format("%.1f", new Object[]{Double.valueOf(((double) nDist) / 1000.0d)});
                data[1] = unitDistArray[nUnit + 1];
            }
        } else {
            data[0] = String.format("%d", new Object[]{Integer.valueOf(nDist)});
            data[1] = unitDistArray[nUnit + 0];
        }
        return data;
    }

    public static boolean isNotEmpty(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    public static String ByteSizeToString(int nSize) {
        try {
            DecimalFormat df = new DecimalFormat();
            if (nSize < 1024) {
                return nSize + "B";
            }
            if (nSize < 1048576) {
                df.applyPattern("0");
                return df.format(((double) nSize) / 1024.0d) + "K";
            } else if (nSize < 1073741824) {
                df.applyPattern("0.0");
                return df.format(((double) nSize) / 1048576.0d) + "M";
            } else {
                df.applyPattern("0.0");
                return df.format(((double) nSize) / 1.073741824E9d) + "G";
            }
        } catch (Exception e) {
            return "0";
        }
    }

    public static String ByteSizeToStringForLong(Long nSize) {
        DecimalFormat df = new DecimalFormat();
        if (nSize.longValue() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return nSize + "B";
        }
        if (nSize.longValue() < 1048576) {
            df.applyPattern("0");
            return df.format(((double) nSize.longValue()) / 1024.0d) + "K";
        } else if (nSize.longValue() < 1073741824) {
            df.applyPattern("0.0");
            return df.format(((double) nSize.longValue()) / 1048576.0d) + "M";
        } else {
            df.applyPattern("0.0");
            return df.format(((double) nSize.longValue()) / 1.073741824E9d) + "G";
        }
    }

    public static void showToastText(Context context, String str) {
        TipTool.onCreateToastDialog(context, str);
    }

    public static String trimString(String str) {
        if (str == null) {
            return null;
        }
        return Html.fromHtml(Html.fromHtml(str.toLowerCase(Locale.getDefault()).replace("\\t", "&#x0009;").replace("\\r", "&#x000d;").replace("\\n", "&#x000a;")).toString()).toString().toUpperCase();
    }

    public static String getUrlDecodeString(String str) {
        String ret = null;
        try {
            ret = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getUrlEncodeString(String str) {
        String ret = null;
        try {
            ret = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return ret;
    }

    public static String getPoiAddress(String originAddress) {
        String retResult = "";
        if (TextUtils.isEmpty(originAddress)) {
            return retResult;
        }
        if (originAddress.endsWith(GlobalConfigKey.TITLE_NEARBY)) {
            return "在" + originAddress;
        }
        return "在" + originAddress + GlobalConfigKey.TITLE_NEARBY;
    }

    public static String getDirection(double dx, double dy) {
        if (dx == 0.0d) {
            if (dy == 0.0d) {
                return "无";
            }
            if (dy > 0.0d) {
                return "北";
            }
            if (dy < 0.0d) {
                return "南";
            }
        }
        double angle = Math.atan(dy / dx);
        String dir = "";
        if (dx > 0.0d) {
            if (angle < -1.1780972450961724d) {
                return "南";
            }
            if (angle < -0.39269908169872414d) {
                return "东南";
            }
            if (angle < 0.39269908169872414d) {
                return "东";
            }
            if (angle < 1.1780972450961724d) {
                return "东北";
            }
            return "北";
        } else if (angle < -1.1780972450961724d) {
            return "北";
        } else {
            if (angle < -0.39269908169872414d) {
                return "西北";
            }
            if (angle < 0.39269908169872414d) {
                return "西";
            }
            if (angle < 1.1780972450961724d) {
                return "西南";
            }
            return "南";
        }
    }

    public static String getDirection(double direction, String defaultValue) {
        String ds = defaultValue;
        while (direction < 0.0d) {
            direction += 360.0d;
        }
        direction %= 360.0d;
        if (direction >= 330.0d || direction <= 30.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_north);
        }
        if (direction > 30.0d && direction <= 60.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_northeast);
        }
        if (direction > 60.0d && direction <= 120.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_east);
        }
        if (direction > 120.0d && direction <= 150.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_southeast);
        }
        if (direction > 150.0d && direction <= 210.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_south);
        }
        if (direction > 210.0d && direction <= 240.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_southwest);
        }
        if (direction > 240.0d && direction <= 300.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_west);
        }
        if (direction <= 300.0d || direction >= 330.0d) {
            return ds;
        }
        return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_northwest);
    }

    public static String getDirectionStrByAngle(double angle, String defaultValue) {
        String ds = defaultValue;
        if (angle < 0.0d) {
            angle += 360.0d;
        }
        angle %= 360.0d;
        if (angle > 315.0d || angle <= 45.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_north);
        }
        if (angle > 45.0d && angle <= 135.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_east);
        }
        if (angle > 135.0d && angle <= 225.0d) {
            return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_south);
        }
        if (angle <= 225.0d || angle > 315.0d) {
            return ds;
        }
        return BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_west);
    }

    public static String getDistance(double dx, double dy) {
        double d = Math.sqrt((dx * dx) + (dy * dy));
        if (d >= 1.0E7d) {
            return " ";
        }
        String dis;
        String unit;
        if (d >= 100000.0d) {
            dis = String.valueOf((int) (d / 1000.0d));
            unit = "km";
        } else if (d >= 1000.0d) {
            dis = String.valueOf(((double) ((int) (d / 100.0d))) / 10.0d);
            unit = "km";
        } else {
            dis = String.valueOf((int) d);
            unit = Config.MODEL;
        }
        return dis + unit;
    }

    public static String numberToChineseWord(int number) {
        String wd = "";
        if (number < 0) {
            return wd;
        }
        if (number < 10) {
            return singleNumberToChineseWord(number);
        }
        if (number < 100) {
            return doubleNumberToChineseWord(number);
        }
        int num = number % 100000;
        if (num >= 10000) {
            wd = wd + singleNumberToChineseWord(num / 10000) + "万";
        }
        num = number % 10000;
        if (num >= 1000) {
            wd = wd + singleNumberToChineseWord(num / 1000) + "千";
        }
        num = number % 1000;
        if (num >= 100) {
            wd = wd + singleNumberToChineseWord(num / 100) + "百";
        }
        num = number % 100;
        if (num >= 10) {
            wd = wd + singleNumberToChineseWord(num / 10) + "十";
        }
        num = number % 10;
        if (num >= 1) {
            wd = wd + singleNumberToChineseWord(num);
        }
        return wd;
    }

    public static String singleNumberToChineseWord(int number) {
        String wd = "";
        switch (number % 10) {
            case 0:
                return "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return wd;
        }
    }

    public static String doubleNumberToChineseWord(int number) {
        number %= 100;
        if (number < 10) {
            return singleNumberToChineseWord(number);
        }
        if (number == 10) {
            return "十";
        }
        StringBuffer sb = new StringBuffer();
        if (number >= 20) {
            sb.append(singleNumberToChineseWord(number / 10));
        }
        sb.append("十");
        if (number % 10 != 0) {
            sb.append(singleNumberToChineseWord(number % 10));
        }
        return sb.toString();
    }

    public static String formatDistanceToChineseString(int nDist) {
        if (nDist <= 0) {
            return "未知";
        }
        if (!XDVoiceInstructManager.XD_ROUSED && nDist >= 100000) {
            return "未知";
        }
        if (nDist < 1000) {
            return numberToChineseWord(nDist) + "米";
        }
        int lit = (nDist % 1000) / 100;
        nDist /= 1000;
        if (lit == 0) {
            return numberToChineseWord(nDist) + "公里";
        }
        return numberToChineseWord(nDist) + "点" + singleNumberToChineseWord(lit) + "公里";
    }

    public static String formatDistToChStrForGuide(int nDist) {
        if (nDist <= 0) {
            return "未知";
        }
        if (nDist < 1000) {
            return numberToChineseWord(nDist) + "米";
        }
        return numberToChineseWord(nDist / 1000) + "公里";
    }

    public static String charArrayToString(char[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (c == '\u0000') {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String shortArrayToString(short[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (short c : array) {
            if (c == (short) 0) {
                break;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }

    public static String extractionChinese(String baseStr) {
        Matcher matcher = Pattern.compile("([一-龥]+)").matcher(baseStr);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return baseStr;
    }
}
