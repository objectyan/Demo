package com.baidu.mapframework.commonlib.date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DateTimeParser {
    /* renamed from: a */
    private static final Pattern f19012a = Pattern.compile("(\\d{1,4})-(\\d\\d)-(\\d\\d)|(\\d{1,4})-(\\d\\d)|(\\d{1,4})");
    /* renamed from: b */
    private static final String f19013b = "\\:";
    /* renamed from: c */
    private static final String f19014c = "(\\d\\d)";
    /* renamed from: d */
    private static final String f19015d = "9";
    /* renamed from: e */
    private static final Integer f19016e = Integer.valueOf("9");
    /* renamed from: f */
    private static final Pattern f19017f = Pattern.compile("(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)\\.(\\d{1,9})|(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)|(\\d\\d)\\:(\\d\\d)|(\\d\\d)");
    /* renamed from: g */
    private static final String f19018g = ":";
    /* renamed from: h */
    private static final int f19019h = 2;
    /* renamed from: i */
    private Integer f19020i;
    /* renamed from: j */
    private Integer f19021j;
    /* renamed from: k */
    private Integer f19022k;
    /* renamed from: l */
    private Integer f19023l;
    /* renamed from: m */
    private Integer f19024m;
    /* renamed from: n */
    private Integer f19025n;
    /* renamed from: o */
    private Integer f19026o;

    private class Parts {
        /* renamed from: a */
        String f19008a;
        /* renamed from: b */
        String f19009b;
        /* renamed from: c */
        final /* synthetic */ DateTimeParser f19010c;

        private Parts(DateTimeParser dateTimeParser) {
            this.f19010c = dateTimeParser;
        }

        /* renamed from: a */
        boolean m15049a() {
            return (this.f19008a == null || this.f19009b == null) ? false : true;
        }

        /* renamed from: b */
        boolean m15050b() {
            return this.f19009b == null;
        }

        /* renamed from: c */
        boolean m15051c() {
            return this.f19008a == null;
        }
    }

    static final class UnknownDateTimeFormat extends RuntimeException {
        /* renamed from: a */
        private static final long f19011a = -7179421566055773208L;

        UnknownDateTimeFormat(String aMessage) {
            super(aMessage);
        }

        UnknownDateTimeFormat(String aMessage, Throwable aEx) {
            super(aMessage, aEx);
        }
    }

    DateTimeParser() {
    }

    /* renamed from: a */
    DateTime m15058a(String aDateTime) {
        if (aDateTime == null) {
            throw new NullPointerException("DateTime string is null");
        }
        Parts parts = m15053c(aDateTime.trim());
        if (parts.m15049a()) {
            m15055e(parts.f19008a);
            m15056f(parts.f19009b);
        } else if (parts.m15050b()) {
            m15055e(parts.f19008a);
        } else if (parts.m15051c()) {
            m15056f(parts.f19009b);
        }
        return new DateTime(this.f19020i, this.f19021j, this.f19022k, this.f19023l, this.f19024m, this.f19025n, this.f19026o);
    }

    /* renamed from: c */
    private Parts m15053c(String aDateTime) {
        boolean hasDateTimeSeparator;
        Parts result = new Parts();
        int dateTimeSeparator = m15059b(aDateTime);
        if (dateTimeSeparator <= 0 || dateTimeSeparator >= aDateTime.length()) {
            hasDateTimeSeparator = false;
        } else {
            hasDateTimeSeparator = true;
        }
        if (hasDateTimeSeparator) {
            result.f19008a = aDateTime.substring(0, dateTimeSeparator);
            result.f19009b = aDateTime.substring(dateTimeSeparator + 1);
        } else if (m15054d(aDateTime)) {
            result.f19009b = aDateTime;
        } else {
            result.f19008a = aDateTime;
        }
        return result;
    }

    /* renamed from: b */
    int m15059b(String aDateTime) {
        int i = -1;
        i = aDateTime.indexOf(" ");
        if (i == -1) {
            return aDateTime.indexOf("T");
        }
        return i;
    }

    /* renamed from: d */
    private boolean m15054d(String aDateTime) {
        if (aDateTime.length() >= 2) {
            return ":".equals(aDateTime.substring(2, 3));
        }
        return false;
    }

    /* renamed from: e */
    private void m15055e(String aDate) {
        Matcher matcher = f19012a.matcher(aDate);
        if (matcher.matches()) {
            String year = m15052a(matcher, 1, 4, 6);
            if (year != null) {
                this.f19020i = Integer.valueOf(year);
            }
            String month = m15052a(matcher, 2, 5);
            if (month != null) {
                this.f19021j = Integer.valueOf(month);
            }
            String day = m15052a(matcher, 3);
            if (day != null) {
                this.f19022k = Integer.valueOf(day);
                return;
            }
            return;
        }
        throw new UnknownDateTimeFormat("Unexpected format for date:" + aDate);
    }

    /* renamed from: a */
    private String m15052a(Matcher aMatcher, int... aGroupIds) {
        String result = null;
        for (int id : aGroupIds) {
            result = aMatcher.group(id);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /* renamed from: f */
    private void m15056f(String aTime) {
        Matcher matcher = f19017f.matcher(aTime);
        if (matcher.matches()) {
            String hour = m15052a(matcher, 1, 5, 8, 10);
            if (hour != null) {
                this.f19023l = Integer.valueOf(hour);
            }
            String minute = m15052a(matcher, 2, 6, 9);
            if (minute != null) {
                this.f19024m = Integer.valueOf(minute);
            }
            String second = m15052a(matcher, 3, 7);
            if (second != null) {
                this.f19025n = Integer.valueOf(second);
            }
            String decimalSeconds = m15052a(matcher, 4);
            if (decimalSeconds != null) {
                this.f19026o = Integer.valueOf(m15057g(decimalSeconds));
                return;
            }
            return;
        }
        throw new UnknownDateTimeFormat("Unexpected format for time:" + aTime);
    }

    /* renamed from: g */
    private String m15057g(String aDecimalSeconds) {
        StringBuilder result = new StringBuilder(aDecimalSeconds);
        while (result.length() < f19016e.intValue()) {
            result.append("0");
        }
        return result.toString();
    }
}
