package com.baidu.navisdk.comapi.commontool.sunrisedown;

import java.util.Calendar;
import java.util.TimeZone;

public class BNSunRiseDownTimeHelper {
    private static final double AirRefr = 0.5666666666666667d;
    private static final double DEGS = 57.29577951308232d;
    private static final double PI = 3.141592653589793d;
    private static final double RADS = 0.017453292519943295d;
    private static final double SUNDIA = 0.53d;
    private static final double TPI = 6.283185307179586d;
    private static BNSunRiseDownTimeHelper me;
    /* renamed from: L */
    private double f19698L;
    private double daylen;
    /* renamed from: g */
    private double f19699g;

    private class SunInteger {
        int integer;

        private SunInteger() {
        }

        public int getInteger() {
            return this.integer;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }
    }

    public class SunRiseDownHM {
        private SunInteger downHour;
        private SunInteger downMin;
        private SunInteger riseHour;
        private SunInteger riseMin;

        public SunRiseDownHM() {
            this.riseHour = new SunInteger();
            this.riseMin = new SunInteger();
            this.downHour = new SunInteger();
            this.downMin = new SunInteger();
        }

        public int getRiseHour() {
            return this.riseHour.getInteger();
        }

        public int getRiseMin() {
            return this.riseMin.getInteger();
        }

        public int getDownHour() {
            return this.downHour.getInteger();
        }

        public int getDownMin() {
            return this.downMin.getInteger();
        }
    }

    public static BNSunRiseDownTimeHelper getIntanse() {
        if (me == null) {
            me = new BNSunRiseDownTimeHelper();
        }
        return me;
    }

    private BNSunRiseDownTimeHelper() {
    }

    private double FNday(int y, int m, int d, float h) {
        return (((double) (((long) (((((((m + 9) / 12) + y) * -7) / 4) + ((m * 275) / 9)) + d)) + (((long) y) * 367))) - 730531.5d) + (((double) h) / 24.0d);
    }

    private double FNrange(double x) {
        double b = x / TPI;
        double a = TPI * (b - ((double) ((long) b)));
        if (a < 0.0d) {
            return a + TPI;
        }
        return a;
    }

    private double f0(double lat, double declin) {
        double dfo = 0.014515321612419507d;
        if (lat < 0.0d) {
            dfo = -4579521134997674931;
        }
        double fo = Math.tan(declin + dfo) * Math.tan(RADS * lat);
        if (fo > 0.99999d) {
            fo = 1.0d;
        }
        return Math.asin(fo) + 1.5707963267948966d;
    }

    private double f1(double lat, double declin) {
        double df1 = 0.10471975511965978d;
        if (lat < 0.0d) {
            df1 = -4592210274265328598;
        }
        double fi = Math.tan(declin + df1) * Math.tan(RADS * lat);
        if (fi > 0.99999d) {
            fi = 1.0d;
        }
        return Math.asin(fi) + 1.5707963267948966d;
    }

    private double FNsun(double d) {
        this.f19698L = FNrange(4.894967873435816d + (0.017202792393721557d * d));
        this.f19699g = FNrange(6.240040768070287d + (0.017201970343643867d * d));
        return FNrange((this.f19698L + (0.03342305517569141d * Math.sin(this.f19699g))) + (3.4906585039886593E-4d * Math.sin(2.0d * this.f19699g)));
    }

    private void showhrmn(double dhr, int zonereduc, SunInteger tmh, SunInteger tmm) {
        int hr = (int) dhr;
        int mn = (int) ((dhr - ((double) hr)) * 60.0d);
        tmh.integer = hr + zonereduc;
        tmm.integer = mn;
    }

    public SunRiseDownHM calulatetm(double latitude, double longitude) {
        SunRiseDownHM sunRiseDownHM = new SunRiseDownHM();
        Calendar c = Calendar.getInstance();
        double tzone = (double) ((int) ((longitude / 15.0d) + 1.0d));
        int zonereduc = 8 - ((int) tzone);
        double d = FNday(c.get(1), c.get(2) + 1, c.get(5), (float) 12);
        double lambda = FNsun(d);
        double obliq = 0.4090877233749509d - (6.981317007977318E-9d * d);
        double alpha = Math.atan2(Math.cos(obliq) * Math.sin(lambda), Math.cos(lambda));
        double delta = Math.asin(Math.sin(obliq) * Math.sin(lambda));
        double LL = this.f19698L - alpha;
        if (this.f19698L < PI) {
            LL += TPI;
        }
        double equation = 1440.0d * (1.0d - (LL / TPI));
        double ha = f0(latitude, delta);
        this.daylen = (DEGS * ha) / 7.5d;
        if (this.daylen < 1.0E-4d) {
            this.daylen = 0.0d;
        }
        double riset = (((12.0d - ((12.0d * ha) / PI)) + tzone) - (longitude / 15.0d)) + (equation / 60.0d);
        double settm = (((12.0d + ((12.0d * ha) / PI)) + tzone) - (longitude / 15.0d)) + (equation / 60.0d);
        if (riset > 24.0d) {
            riset -= 24.0d;
        }
        if (settm > 24.0d) {
            settm -= 24.0d;
        }
        showhrmn(riset, zonereduc, sunRiseDownHM.riseHour, sunRiseDownHM.riseMin);
        showhrmn(settm, zonereduc, sunRiseDownHM.downHour, sunRiseDownHM.downMin);
        return sunRiseDownHM;
    }

    private int getTimeZoneHourDiff() {
        TimeZone timeZoneBeijing = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone timeZoneCurrent = TimeZone.getDefault();
        if (timeZoneBeijing == null || timeZoneCurrent == null) {
            return 0;
        }
        Calendar calendarBeijing = Calendar.getInstance(timeZoneBeijing);
        Calendar calendarCurrent = Calendar.getInstance(timeZoneCurrent);
        if (calendarBeijing == null || calendarCurrent == null) {
            return 0;
        }
        return ((calendarCurrent.get(15) + calendarCurrent.get(16)) - calendarBeijing.get(15)) / 3600000;
    }

    public void updateInternationalTimeZone(SunRiseDownHM riseDown) {
        if (riseDown != null && riseDown.downHour != null && riseDown.riseHour != null) {
            int diff = getTimeZoneHourDiff();
            SunInteger access$300 = riseDown.downHour;
            access$300.integer += diff;
            access$300 = riseDown.riseHour;
            access$300.integer += diff;
        }
    }
}
