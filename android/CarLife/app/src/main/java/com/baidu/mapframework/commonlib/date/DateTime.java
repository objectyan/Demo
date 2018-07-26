package com.baidu.mapframework.commonlib.date;

import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.RoutePlanDataStruct;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTime implements Serializable, Comparable<DateTime> {
    /* renamed from: a */
    private static final int f18929a = 0;
    /* renamed from: b */
    private static final long f18930b = -1300068157085493891L;
    /* renamed from: c */
    private static int f18931c = 2400000;
    /* renamed from: d */
    private String f18932d;
    /* renamed from: e */
    private Integer f18933e;
    /* renamed from: f */
    private Integer f18934f;
    /* renamed from: g */
    private Integer f18935g;
    /* renamed from: h */
    private Integer f18936h;
    /* renamed from: i */
    private Integer f18937i;
    /* renamed from: j */
    private Integer f18938j;
    /* renamed from: k */
    private Integer f18939k;
    /* renamed from: l */
    private boolean f18940l = true;
    /* renamed from: m */
    private int f18941m;

    public enum DayOverflow {
        LastDay,
        FirstDay,
        Spillover,
        Abort
    }

    static final class ItemOutOfRange extends RuntimeException {
        /* renamed from: a */
        private static final long f18926a = 4760138291907517660L;

        ItemOutOfRange(String aMessage) {
            super(aMessage);
        }
    }

    static final class MissingItem extends RuntimeException {
        /* renamed from: a */
        private static final long f18927a = -7359967338896127755L;

        MissingItem(String aMessage) {
            super(aMessage);
        }
    }

    public enum Unit {
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        NANOSECONDS
    }

    public DateTime(String aDateTime) {
        if (aDateTime == null) {
            throw new IllegalArgumentException("String passed to DateTime constructor is null. You can use an empty string, but not a null reference.");
        }
        this.f18932d = aDateTime;
    }

    public DateTime(Integer aYear, Integer aMonth, Integer aDay, Integer aHour, Integer aMinute, Integer aSecond, Integer aNanoseconds) {
        this.f18933e = aYear;
        this.f18934f = aMonth;
        this.f18935g = aDay;
        this.f18936h = aHour;
        this.f18937i = aMinute;
        this.f18938j = aSecond;
        this.f18939k = aNanoseconds;
        m14995e();
    }

    public static DateTime forDateOnly(Integer aYear, Integer aMonth, Integer aDay) {
        return new DateTime(aYear, aMonth, aDay, null, null, null, null);
    }

    public static DateTime forTimeOnly(Integer aHour, Integer aMinute, Integer aSecond, Integer aNanoseconds) {
        return new DateTime(null, null, null, aHour, aMinute, aSecond, aNanoseconds);
    }

    public static DateTime forInstant(long aMilliseconds, TimeZone aTimeZone) {
        Calendar calendar = new GregorianCalendar(aTimeZone);
        calendar.setTimeInMillis(aMilliseconds);
        return new DateTime(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)), Integer.valueOf((calendar.get(14) * 1000) * 1000));
    }

    public static DateTime now(TimeZone aTimeZone) {
        return forInstant(System.currentTimeMillis(), aTimeZone);
    }

    public static DateTime today(TimeZone aTimeZone) {
        return now(aTimeZone).truncate(Unit.DAY);
    }

    /* renamed from: a */
    static Integer m14983a(Integer aYear, Integer aMonth) {
        if (aYear == null || aMonth == null) {
            return null;
        }
        if (aMonth.intValue() == 1) {
            return Integer.valueOf(31);
        }
        if (aMonth.intValue() == 2) {
            return Integer.valueOf(m14989a(aYear) ? 29 : 28);
        } else if (aMonth.intValue() == 3) {
            return Integer.valueOf(31);
        } else {
            if (aMonth.intValue() == 4) {
                return Integer.valueOf(30);
            }
            if (aMonth.intValue() == 5) {
                return Integer.valueOf(31);
            }
            if (aMonth.intValue() == 6) {
                return Integer.valueOf(30);
            }
            if (aMonth.intValue() == 7) {
                return Integer.valueOf(31);
            }
            if (aMonth.intValue() == 8) {
                return Integer.valueOf(31);
            }
            if (aMonth.intValue() == 9) {
                return Integer.valueOf(30);
            }
            if (aMonth.intValue() == 10) {
                return Integer.valueOf(31);
            }
            if (aMonth.intValue() == 11) {
                return Integer.valueOf(30);
            }
            if (aMonth.intValue() == 12) {
                return Integer.valueOf(31);
            }
            throw new AssertionError("Month is out of range 1..12:" + aMonth);
        }
    }

    /* renamed from: a */
    static DateTime m14981a(int aJDAtNoon) {
        int l = aJDAtNoon + 68569;
        int n = (l * 4) / 146097;
        l -= ((146097 * n) + 3) / 4;
        int i = ((l + 1) * m_AppUI.MSG_APP_SAVESCREEN) / 1461001;
        l = (l - ((i * 1461) / 4)) + 31;
        int j = (l * 80) / 2447;
        int d = l - ((j * 2447) / 80);
        l = j / 11;
        return forDateOnly(Integer.valueOf((((n - 49) * 100) + i) + l), Integer.valueOf((j + 2) - (l * 12)), Integer.valueOf(d));
    }

    /* renamed from: a */
    private static boolean m14989a(Integer aYear) {
        if (aYear.intValue() % 100 == 0) {
            if (aYear.intValue() % 400 == 0) {
                return true;
            }
            return false;
        } else if (aYear.intValue() % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public long getMilliseconds(TimeZone aTimeZone) {
        int i = 0;
        Integer year = getYear();
        Integer month = getMonth();
        Integer day = getDay();
        Integer hour = Integer.valueOf(getHour() == null ? 0 : getHour().intValue());
        Integer minute = Integer.valueOf(getMinute() == null ? 0 : getMinute().intValue());
        Integer second = Integer.valueOf(getSecond() == null ? 0 : getSecond().intValue());
        if (getNanoseconds() != null) {
            i = getNanoseconds().intValue();
        }
        Integer nanos = Integer.valueOf(i);
        Calendar calendar = new GregorianCalendar(aTimeZone);
        calendar.set(1, year.intValue());
        calendar.set(2, month.intValue() - 1);
        calendar.set(5, day.intValue());
        calendar.set(11, hour.intValue());
        calendar.set(12, minute.intValue());
        calendar.set(13, second.intValue());
        calendar.set(14, nanos.intValue() / 1000000);
        return calendar.getTimeInMillis();
    }

    public String getRawDateString() {
        return this.f18932d;
    }

    public Integer getYear() {
        m14999a();
        return this.f18933e;
    }

    public Integer getMonth() {
        m14999a();
        return this.f18934f;
    }

    public Integer getDay() {
        m14999a();
        return this.f18935g;
    }

    public Integer getHour() {
        m14999a();
        return this.f18936h;
    }

    public Integer getMinute() {
        m14999a();
        return this.f18937i;
    }

    public Integer getSecond() {
        m14999a();
        return this.f18938j;
    }

    public Integer getNanoseconds() {
        m14999a();
        return this.f18939k;
    }

    public Integer getModifiedJulianDayNumber() {
        m14993c();
        return Integer.valueOf((m14991b() - 1) - f18931c);
    }

    public Integer getWeekDay() {
        m14993c();
        return Integer.valueOf(((m14991b() + 1) % 7) + 1);
    }

    public Integer getDayOfYear() {
        m14993c();
        return Integer.valueOf(((((this.f18934f.intValue() * 275) / 9) - (((this.f18934f.intValue() + 9) / 12) * (isLeapYear().booleanValue() ? 1 : 2))) + this.f18935g.intValue()) - 30);
    }

    public Boolean isLeapYear() {
        m14999a();
        if (m14990a(this.f18933e)) {
            return Boolean.valueOf(m14989a(this.f18933e));
        }
        throw new MissingItem("Year is absent. Cannot determine if leap year.");
    }

    public int getNumDaysInMonth() {
        m14993c();
        return m14983a(this.f18933e, this.f18934f).intValue();
    }

    public Integer getWeekIndex(DateTime aStartingFromDate) {
        m14993c();
        aStartingFromDate.m14993c();
        return Integer.valueOf(((getModifiedJulianDayNumber().intValue() - aStartingFromDate.getModifiedJulianDayNumber().intValue()) / 7) + 1);
    }

    public Integer getWeekIndex() {
        return getWeekIndex(forDateOnly(Integer.valueOf(2000), Integer.valueOf(1), Integer.valueOf(2)));
    }

    public boolean isSameDayAs(DateTime aThat) {
        m14993c();
        aThat.m14993c();
        return this.f18933e.equals(aThat.f18933e) && this.f18934f.equals(aThat.f18934f) && this.f18935g.equals(aThat.f18935g);
    }

    public boolean lt(DateTime aThat) {
        return compareTo(aThat) < 0;
    }

    public boolean lteq(DateTime aThat) {
        return compareTo(aThat) < 0 || equals(aThat);
    }

    public boolean gt(DateTime aThat) {
        return compareTo(aThat) > 0;
    }

    public boolean gteq(DateTime aThat) {
        return compareTo(aThat) > 0 || equals(aThat);
    }

    public Unit getPrecision() {
        m14999a();
        if (m14990a(this.f18939k)) {
            return Unit.NANOSECONDS;
        }
        if (m14990a(this.f18938j)) {
            return Unit.SECOND;
        }
        if (m14990a(this.f18937i)) {
            return Unit.MINUTE;
        }
        if (m14990a(this.f18936h)) {
            return Unit.HOUR;
        }
        if (m14990a(this.f18935g)) {
            return Unit.DAY;
        }
        if (m14990a(this.f18934f)) {
            return Unit.MONTH;
        }
        if (m14990a(this.f18933e)) {
            return Unit.YEAR;
        }
        return null;
    }

    public DateTime truncate(Unit aPrecision) {
        m14999a();
        if (Unit.NANOSECONDS == aPrecision) {
            throw new IllegalArgumentException("It makes no sense to truncate to nanosecond precision, since that's the highest precision available.");
        } else if (Unit.SECOND == aPrecision) {
            return new DateTime(this.f18933e, this.f18934f, this.f18935g, this.f18936h, this.f18937i, this.f18938j, null);
        } else {
            if (Unit.MINUTE == aPrecision) {
                return new DateTime(this.f18933e, this.f18934f, this.f18935g, this.f18936h, this.f18937i, null, null);
            }
            if (Unit.HOUR == aPrecision) {
                return new DateTime(this.f18933e, this.f18934f, this.f18935g, this.f18936h, null, null, null);
            }
            if (Unit.DAY == aPrecision) {
                return new DateTime(this.f18933e, this.f18934f, this.f18935g, null, null, null, null);
            }
            if (Unit.MONTH == aPrecision) {
                return new DateTime(this.f18933e, this.f18934f, null, null, null, null, null);
            }
            if (Unit.YEAR == aPrecision) {
                return new DateTime(this.f18933e, null, null, null, null, null, null);
            }
            return null;
        }
    }

    public boolean unitsAllPresent(Unit... aUnits) {
        boolean result = true;
        m14999a();
        for (Unit unit : aUnits) {
            if (Unit.NANOSECONDS == unit) {
                if (!result || this.f18939k == null) {
                    result = false;
                } else {
                    result = true;
                }
            } else if (Unit.SECOND == unit) {
                result = result && this.f18938j != null;
            } else if (Unit.MINUTE == unit) {
                result = result && this.f18937i != null;
            } else if (Unit.HOUR == unit) {
                result = result && this.f18936h != null;
            } else if (Unit.DAY == unit) {
                result = result && this.f18935g != null;
            } else if (Unit.MONTH == unit) {
                result = result && this.f18934f != null;
            } else if (Unit.YEAR == unit) {
                result = result && this.f18933e != null;
            }
        }
        return result;
    }

    public boolean hasYearMonthDay() {
        return unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY);
    }

    public boolean hasHourMinuteSecond() {
        return unitsAllPresent(Unit.HOUR, Unit.MINUTE, Unit.SECOND);
    }

    public boolean unitsAllAbsent(Unit... aUnits) {
        boolean result = true;
        m14999a();
        for (Unit unit : aUnits) {
            if (Unit.NANOSECONDS == unit) {
                if (result && this.f18939k == null) {
                    result = true;
                } else {
                    result = false;
                }
            } else if (Unit.SECOND == unit) {
                result = result && this.f18938j == null;
            } else if (Unit.MINUTE == unit) {
                result = result && this.f18937i == null;
            } else if (Unit.HOUR == unit) {
                result = result && this.f18936h == null;
            } else if (Unit.DAY == unit) {
                result = result && this.f18935g == null;
            } else if (Unit.MONTH == unit) {
                result = result && this.f18934f == null;
            } else if (Unit.YEAR == unit) {
                result = result && this.f18933e == null;
            }
        }
        return result;
    }

    public DateTime getStartOfDay() {
        m14993c();
        return m14982a(this.f18935g, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    }

    public DateTime getEndOfDay() {
        m14993c();
        return m14982a(this.f18935g, Integer.valueOf(23), Integer.valueOf(59), Integer.valueOf(59), Integer.valueOf(999999999));
    }

    public DateTime getStartOfMonth() {
        m14993c();
        return m14982a(Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    }

    public DateTime getEndOfMonth() {
        m14993c();
        return m14982a(Integer.valueOf(getNumDaysInMonth()), Integer.valueOf(23), Integer.valueOf(59), Integer.valueOf(59), Integer.valueOf(999999999));
    }

    public DateTime plus(Integer aNumYears, Integer aNumMonths, Integer aNumDays, Integer aNumHours, Integer aNumMinutes, Integer aNumSeconds, Integer aNumNanoseconds, DayOverflow aDayOverflow) {
        return new DateTimeInterval(this, aDayOverflow).m15047a(aNumYears.intValue(), aNumMonths.intValue(), aNumDays.intValue(), aNumHours.intValue(), aNumMinutes.intValue(), aNumSeconds.intValue(), aNumNanoseconds.intValue());
    }

    public DateTime minus(Integer aNumYears, Integer aNumMonths, Integer aNumDays, Integer aNumHours, Integer aNumMinutes, Integer aNumSeconds, Integer aNumNanoseconds, DayOverflow aDayOverflow) {
        return new DateTimeInterval(this, aDayOverflow).m15048b(aNumYears.intValue(), aNumMonths.intValue(), aNumDays.intValue(), aNumHours.intValue(), aNumMinutes.intValue(), aNumSeconds.intValue(), aNumNanoseconds.intValue());
    }

    public DateTime plusDays(Integer aNumDays) {
        m14993c();
        DateTime datePortion = m14981a(((getModifiedJulianDayNumber().intValue() + 1) + f18931c) + aNumDays.intValue());
        return new DateTime(datePortion.getYear(), datePortion.getMonth(), datePortion.getDay(), this.f18936h, this.f18937i, this.f18938j, this.f18939k);
    }

    public DateTime minusDays(Integer aNumDays) {
        return plusDays(Integer.valueOf(aNumDays.intValue() * -1));
    }

    public int numDaysFrom(DateTime aThat) {
        return aThat.getModifiedJulianDayNumber().intValue() - getModifiedJulianDayNumber().intValue();
    }

    public long numSecondsFrom(DateTime aThat) {
        long result = 0;
        if (hasYearMonthDay() && aThat.hasYearMonthDay()) {
            result = (long) (numDaysFrom(aThat) * 86400);
        }
        return (result - ((long) m14994d())) + ((long) aThat.m14994d());
    }

    public String format(String aFormat) {
        return new DateTimeFormatter(aFormat).m15026a(this);
    }

    public String format(String aFormat, Locale aLocale) {
        return new DateTimeFormatter(aFormat, aLocale).m15026a(this);
    }

    public String format(String aFormat, List<String> aMonths, List<String> aWeekdays, List<String> aAmPmIndicators) {
        return new DateTimeFormatter(aFormat, aMonths, aWeekdays, aAmPmIndicators).m15026a(this);
    }

    public boolean isInTheFuture(TimeZone aTimeZone) {
        return now(aTimeZone).lt(this);
    }

    public boolean isInThePast(TimeZone aTimeZone) {
        return now(aTimeZone).gt(this);
    }

    public DateTime changeTimeZone(TimeZone aFromTimeZone, TimeZone aToTimeZone) {
        m14993c();
        if (unitsAllAbsent(Unit.HOUR)) {
            throw new IllegalArgumentException("DateTime does not include the hour. Cannot change the time zone if no hour is present.");
        }
        Calendar fromDate = new GregorianCalendar(aFromTimeZone);
        fromDate.set(1, getYear().intValue());
        fromDate.set(2, getMonth().intValue() - 1);
        fromDate.set(5, getDay().intValue());
        fromDate.set(11, getHour().intValue());
        if (getMinute() != null) {
            fromDate.set(12, getMinute().intValue());
        } else {
            fromDate.set(12, 0);
        }
        fromDate.set(13, 0);
        fromDate.set(14, 0);
        Calendar toDate = new GregorianCalendar(aToTimeZone);
        toDate.setTimeInMillis(fromDate.getTimeInMillis());
        return new DateTime(Integer.valueOf(toDate.get(1)), Integer.valueOf(toDate.get(2) + 1), Integer.valueOf(toDate.get(5)), Integer.valueOf(toDate.get(11)), getMinute() != null ? Integer.valueOf(toDate.get(12)) : null, getSecond(), getNanoseconds());
    }

    public int compareTo(DateTime aThat) {
        if (this == aThat) {
            return 0;
        }
        m14999a();
        aThat.m14999a();
        NullsGo nullsGo = NullsGo.FIRST;
        int comparison = ModelUtil.m15068a(this.f18933e, aThat.f18933e, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18934f, aThat.f18934f, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18935g, aThat.f18935g, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18936h, aThat.f18936h, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18937i, aThat.f18937i, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18938j, aThat.f18938j, nullsGo);
        if (comparison != 0) {
            return comparison;
        }
        comparison = ModelUtil.m15068a(this.f18939k, aThat.f18939k, nullsGo);
        if (comparison == 0) {
            return 0;
        }
        return comparison;
    }

    public boolean equals(Object aThat) {
        m14999a();
        Boolean result = ModelUtil.m15070a((Object) this, aThat);
        if (result == null) {
            DateTime that = (DateTime) aThat;
            that.m14999a();
            result = Boolean.valueOf(ModelUtil.m15078a(m14997g(), that.m14997g()));
        }
        return result.booleanValue();
    }

    public int hashCode() {
        if (this.f18941m == 0) {
            m14999a();
            this.f18941m = ModelUtil.m15069a(m14997g());
        }
        return this.f18941m;
    }

    public String toString() {
        String result = "";
        if (Util.m15096a(this.f18932d)) {
            return this.f18932d;
        }
        if (m14998h() != null) {
            return format(m14998h());
        }
        StringBuilder builder = new StringBuilder();
        m14988a(RoutePlanDataStruct.KEY_Y, this.f18933e, builder);
        m14988a("M", this.f18934f, builder);
        m14988a("D", this.f18935g, builder);
        m14988a("h", this.f18936h, builder);
        m14988a(Config.MODEL, this.f18937i, builder);
        m14988a("s", this.f18938j, builder);
        m14988a(Regular.CATEGORY_FIX_VALUE, this.f18939k, builder);
        return builder.toString().trim();
    }

    /* renamed from: a */
    void m14999a() {
        if (!this.f18940l) {
            m14996f();
        }
    }

    /* renamed from: b */
    private int m14991b() {
        int y = this.f18933e.intValue();
        int m = this.f18934f.intValue();
        return (((((((y + 4800) + ((m - 14) / 12)) * 1461) / 4) + ((((m - 2) - (((m - 14) / 12) * 12)) * 367) / 12)) - (((((y + 4900) + ((m - 14) / 12)) / 100) * 3) / 4)) + this.f18935g.intValue()) - 32075;
    }

    /* renamed from: c */
    private void m14993c() {
        m14999a();
        if (!hasYearMonthDay()) {
            throw new MissingItem("DateTime does not include year/month/day.");
        }
    }

    /* renamed from: d */
    private int m14994d() {
        int result = 0;
        if (this.f18938j != null) {
            result = 0 + this.f18938j.intValue();
        }
        if (this.f18937i != null) {
            result += this.f18937i.intValue() * 60;
        }
        if (this.f18936h != null) {
            return result + (this.f18936h.intValue() * 3600);
        }
        return result;
    }

    /* renamed from: e */
    private void m14995e() {
        m14986a(this.f18933e, 1, 9999, "Year");
        m14986a(this.f18934f, 1, 12, "Month");
        m14986a(this.f18935g, 1, 31, "Day");
        m14986a(this.f18936h, 0, 23, "Hour");
        m14986a(this.f18937i, 0, 59, "Minute");
        m14986a(this.f18938j, 0, 59, "Second");
        m14986a(this.f18939k, 0, 999999999, "Nanosecond");
        m14987a(this.f18933e, this.f18934f, this.f18935g);
    }

    /* renamed from: a */
    private void m14986a(Integer aValue, int aMin, int aMax, String aName) {
        if (aValue == null) {
            return;
        }
        if (aValue.intValue() < aMin || aValue.intValue() > aMax) {
            throw new ItemOutOfRange(aName + " is not in the range " + aMin + ".." + aMax + ". Value is:" + aValue);
        }
    }

    /* renamed from: a */
    private void m14987a(Integer aYear, Integer aMonth, Integer aDay) {
        if (m14992b(aYear, aMonth, aDay) && aDay.intValue() > m14983a(aYear, aMonth).intValue()) {
            throw new ItemOutOfRange("The day-of-the-month value '" + aDay + "' exceeds the number of days in the month: " + m14983a(aYear, aMonth));
        }
    }

    /* renamed from: f */
    private void m14996f() {
        DateTime dateTime = new DateTimeParser().m15058a(this.f18932d);
        this.f18933e = dateTime.f18933e;
        this.f18934f = dateTime.f18934f;
        this.f18935g = dateTime.f18935g;
        this.f18936h = dateTime.f18936h;
        this.f18937i = dateTime.f18937i;
        this.f18938j = dateTime.f18938j;
        this.f18939k = dateTime.f18939k;
        m14995e();
    }

    /* renamed from: b */
    private boolean m14992b(Integer aYear, Integer aMonth, Integer aDay) {
        return m14990a(aYear, aMonth, aDay);
    }

    /* renamed from: g */
    private Object[] m14997g() {
        return new Object[]{this.f18933e, this.f18934f, this.f18935g, this.f18936h, this.f18937i, this.f18938j, this.f18939k};
    }

    /* renamed from: a */
    private void m14988a(String aName, Object aValue, StringBuilder aBuilder) {
        aBuilder.append(aName + Config.TRACE_TODAY_VISIT_SPLIT + String.valueOf(aValue) + " ");
    }

    /* renamed from: a */
    private boolean m14990a(Object... aItems) {
        for (Object item : aItems) {
            if (item == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private DateTime m14982a(Integer aDay, Integer aHour, Integer aMinute, Integer aSecond, Integer aNanosecond) {
        m14993c();
        return new DateTime(this.f18933e, this.f18934f, aDay, aHour, aMinute, aSecond, aNanosecond);
    }

    /* renamed from: h */
    private String m14998h() {
        if (unitsAllPresent(Unit.YEAR)) {
            if (unitsAllAbsent(Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
                return "YYYY";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH)) {
            if (unitsAllAbsent(Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
                return "YYYY-MM";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY)) {
            if (unitsAllAbsent(Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
                return "YYYY-MM-DD";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR)) {
            if (unitsAllAbsent(Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
                return "YYYY-MM-DD hh";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE)) {
            if (unitsAllAbsent(Unit.SECOND, Unit.NANOSECONDS)) {
                return "YYYY-MM-DD hh:mm";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND)) {
            if (unitsAllAbsent(Unit.NANOSECONDS)) {
                return "YYYY-MM-DD hh:mm:ss";
            }
        }
        if (unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
            return "YYYY-MM-DD hh:mm:ss.fffffffff";
        }
        if (unitsAllAbsent(Unit.YEAR, Unit.MONTH, Unit.DAY)) {
            if (unitsAllPresent(Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS)) {
                return "hh:mm:ss.fffffffff";
            }
        }
        if (unitsAllAbsent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.NANOSECONDS)) {
            if (unitsAllPresent(Unit.HOUR, Unit.MINUTE, Unit.SECOND)) {
                return "hh:mm:ss";
            }
        }
        if (!unitsAllAbsent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.SECOND, Unit.NANOSECONDS)) {
            return null;
        }
        if (unitsAllPresent(Unit.HOUR, Unit.MINUTE)) {
            return "hh:mm";
        }
        return null;
    }

    /* renamed from: a */
    private void m14984a(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
        aInputStream.defaultReadObject();
        m14995e();
    }

    /* renamed from: a */
    private void m14985a(ObjectOutputStream aOutputStream) throws IOException {
        aOutputStream.defaultWriteObject();
    }
}
