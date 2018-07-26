package com.baidu.mapframework.commonlib.date;

import com.baidu.mapframework.commonlib.date.DateTime.DayOverflow;
import com.baidu.mapframework.commonlib.date.DateTime.Unit;

final class DateTimeInterval {
    /* renamed from: a */
    private static final int f18985a = 0;
    /* renamed from: b */
    private static final int f18986b = 9999;
    /* renamed from: c */
    private static final int f18987c = 0;
    /* renamed from: d */
    private static final int f18988d = 999999999;
    /* renamed from: e */
    private static final boolean f18989e = true;
    /* renamed from: f */
    private static final boolean f18990f = false;
    /* renamed from: g */
    private final DateTime f18991g;
    /* renamed from: h */
    private boolean f18992h;
    /* renamed from: i */
    private DayOverflow f18993i;
    /* renamed from: j */
    private int f18994j;
    /* renamed from: k */
    private int f18995k;
    /* renamed from: l */
    private int f18996l;
    /* renamed from: m */
    private int f18997m;
    /* renamed from: n */
    private int f18998n;
    /* renamed from: o */
    private int f18999o;
    /* renamed from: p */
    private int f19000p;
    /* renamed from: q */
    private Integer f19001q;
    /* renamed from: r */
    private Integer f19002r;
    /* renamed from: s */
    private Integer f19003s;
    /* renamed from: t */
    private Integer f19004t;
    /* renamed from: u */
    private Integer f19005u;
    /* renamed from: v */
    private Integer f19006v;
    /* renamed from: w */
    private Integer f19007w;

    DateTimeInterval(DateTime aFrom, DayOverflow aMonthOverflow) {
        int i = 1;
        int i2 = 0;
        this.f18991g = aFrom;
        m15028a();
        this.f19001q = Integer.valueOf(this.f18991g.getYear() == null ? 1 : this.f18991g.getYear().intValue());
        this.f19002r = Integer.valueOf(this.f18991g.getMonth() == null ? 1 : this.f18991g.getMonth().intValue());
        if (this.f18991g.getDay() != null) {
            i = this.f18991g.getDay().intValue();
        }
        this.f19003s = Integer.valueOf(i);
        this.f19004t = Integer.valueOf(this.f18991g.getHour() == null ? 0 : this.f18991g.getHour().intValue());
        this.f19005u = Integer.valueOf(this.f18991g.getMinute() == null ? 0 : this.f18991g.getMinute().intValue());
        this.f19006v = Integer.valueOf(this.f18991g.getSecond() == null ? 0 : this.f18991g.getSecond().intValue());
        if (this.f18991g.getNanoseconds() != null) {
            i2 = this.f18991g.getNanoseconds().intValue();
        }
        this.f19007w = Integer.valueOf(i2);
        this.f18993i = aMonthOverflow;
    }

    /* renamed from: a */
    DateTime m15047a(int aYear, int aMonth, int aDay, int aHour, int aMinute, int aSecond, int aNanosecond) {
        return m15027a(true, Integer.valueOf(aYear), Integer.valueOf(aMonth), Integer.valueOf(aDay), Integer.valueOf(aHour), Integer.valueOf(aMinute), Integer.valueOf(aSecond), Integer.valueOf(aNanosecond));
    }

    /* renamed from: b */
    DateTime m15048b(int aYear, int aMonth, int aDay, int aHour, int aMinute, int aSecond, int aNanosecond) {
        return m15027a(false, Integer.valueOf(aYear), Integer.valueOf(aMonth), Integer.valueOf(aDay), Integer.valueOf(aHour), Integer.valueOf(aMinute), Integer.valueOf(aSecond), Integer.valueOf(aNanosecond));
    }

    /* renamed from: a */
    private void m15028a() {
        boolean success;
        if (this.f18991g.unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND)) {
            success = true;
        } else {
            if (this.f18991g.unitsAllPresent(Unit.YEAR, Unit.MONTH, Unit.DAY)) {
                if (this.f18991g.unitsAllAbsent(Unit.HOUR, Unit.MINUTE, Unit.SECOND)) {
                    success = true;
                }
            }
            if (this.f18991g.unitsAllAbsent(Unit.YEAR, Unit.MONTH, Unit.DAY)) {
                if (this.f18991g.unitsAllPresent(Unit.HOUR, Unit.MINUTE, Unit.SECOND)) {
                    success = true;
                }
            }
            success = false;
        }
        if (!success) {
            throw new IllegalArgumentException("For interval calculations, DateTime must have year-month-day, or hour-minute-second, or both.");
        }
    }

    /* renamed from: a */
    private DateTime m15027a(boolean aIsPlus, Integer aYear, Integer aMonth, Integer aDay, Integer aHour, Integer aMinute, Integer aSecond, Integer aNanosecond) {
        this.f18992h = aIsPlus;
        this.f18994j = aYear.intValue();
        this.f18995k = aMonth.intValue();
        this.f18996l = aDay.intValue();
        this.f18997m = aHour.intValue();
        this.f18998n = aMinute.intValue();
        this.f18999o = aSecond.intValue();
        this.f19000p = aNanosecond.intValue();
        m15030a(Integer.valueOf(this.f18994j), "Year");
        m15030a(Integer.valueOf(this.f18995k), "Month");
        m15030a(Integer.valueOf(this.f18996l), "Day");
        m15030a(Integer.valueOf(this.f18997m), "Hour");
        m15030a(Integer.valueOf(this.f18998n), "Minute");
        m15030a(Integer.valueOf(this.f18999o), "Second");
        m15029a(Integer.valueOf(this.f19000p));
        m15031b();
        m15032c();
        m15046q();
        m15033d();
        m15034e();
        m15035f();
        m15036g();
        m15037h();
        return new DateTime(this.f19001q, this.f19002r, this.f19003s, this.f19004t, this.f19005u, this.f19006v, this.f19007w);
    }

    /* renamed from: a */
    private void m15030a(Integer aValue, String aName) {
        if (aValue.intValue() < 0 || aValue.intValue() > f18986b) {
            throw new IllegalArgumentException(aName + " is not in the range " + 0 + ".." + f18986b);
        }
    }

    /* renamed from: a */
    private void m15029a(Integer aValue) {
        if (aValue.intValue() < 0 || aValue.intValue() > f18988d) {
            throw new IllegalArgumentException("Nanosecond interval is not in the range 0..999999999");
        }
    }

    /* renamed from: b */
    private void m15031b() {
        if (this.f18992h) {
            this.f19001q = Integer.valueOf(this.f19001q.intValue() + this.f18994j);
        } else {
            this.f19001q = Integer.valueOf(this.f18991g.getYear().intValue() - this.f18994j);
        }
    }

    /* renamed from: c */
    private void m15032c() {
        for (int count = 0; count < this.f18995k; count++) {
            m15039j();
        }
    }

    /* renamed from: d */
    private void m15033d() {
        for (int count = 0; count < this.f18996l; count++) {
            m15040k();
        }
    }

    /* renamed from: e */
    private void m15034e() {
        for (int count = 0; count < this.f18997m; count++) {
            m15043n();
        }
    }

    /* renamed from: f */
    private void m15035f() {
        for (int count = 0; count < this.f18998n; count++) {
            m15044o();
        }
    }

    /* renamed from: g */
    private void m15036g() {
        for (int count = 0; count < this.f18999o; count++) {
            m15045p();
        }
    }

    /* renamed from: h */
    private void m15037h() {
        if (this.f18992h) {
            this.f19007w = Integer.valueOf(this.f19007w.intValue() + this.f19000p);
        } else {
            this.f19007w = Integer.valueOf(this.f19007w.intValue() - this.f19000p);
        }
        if (this.f19007w.intValue() > f18988d) {
            m15045p();
            this.f19007w = Integer.valueOf((this.f19007w.intValue() - f18988d) - 1);
        } else if (this.f19007w.intValue() < 0) {
            m15045p();
            this.f19007w = Integer.valueOf((this.f19007w.intValue() + f18988d) + 1);
        }
    }

    /* renamed from: i */
    private void m15038i() {
        if (this.f18992h) {
            this.f19001q = Integer.valueOf(this.f19001q.intValue() + 1);
        } else {
            this.f19001q = Integer.valueOf(this.f19001q.intValue() - 1);
        }
    }

    /* renamed from: j */
    private void m15039j() {
        if (this.f18992h) {
            this.f19002r = Integer.valueOf(this.f19002r.intValue() + 1);
        } else {
            this.f19002r = Integer.valueOf(this.f19002r.intValue() - 1);
        }
        if (this.f19002r.intValue() > 12) {
            this.f19002r = Integer.valueOf(1);
            m15038i();
        } else if (this.f19002r.intValue() < 1) {
            this.f19002r = Integer.valueOf(12);
            m15038i();
        }
    }

    /* renamed from: k */
    private void m15040k() {
        if (this.f18992h) {
            this.f19003s = Integer.valueOf(this.f19003s.intValue() + 1);
        } else {
            this.f19003s = Integer.valueOf(this.f19003s.intValue() - 1);
        }
        if (this.f19003s.intValue() > m15041l()) {
            this.f19003s = Integer.valueOf(1);
            m15039j();
        } else if (this.f19003s.intValue() < 1) {
            this.f19003s = Integer.valueOf(m15042m());
            m15039j();
        }
    }

    /* renamed from: l */
    private int m15041l() {
        return DateTime.m14983a(this.f19001q, this.f19002r).intValue();
    }

    /* renamed from: m */
    private int m15042m() {
        if (this.f19002r.intValue() > 1) {
            return DateTime.m14983a(this.f19001q, Integer.valueOf(this.f19002r.intValue() - 1)).intValue();
        }
        return DateTime.m14983a(Integer.valueOf(this.f19001q.intValue() - 1), Integer.valueOf(12)).intValue();
    }

    /* renamed from: n */
    private void m15043n() {
        if (this.f18992h) {
            this.f19004t = Integer.valueOf(this.f19004t.intValue() + 1);
        } else {
            this.f19004t = Integer.valueOf(this.f19004t.intValue() - 1);
        }
        if (this.f19004t.intValue() > 23) {
            this.f19004t = Integer.valueOf(0);
            m15040k();
        } else if (this.f19004t.intValue() < 0) {
            this.f19004t = Integer.valueOf(23);
            m15040k();
        }
    }

    /* renamed from: o */
    private void m15044o() {
        if (this.f18992h) {
            this.f19005u = Integer.valueOf(this.f19005u.intValue() + 1);
        } else {
            this.f19005u = Integer.valueOf(this.f19005u.intValue() - 1);
        }
        if (this.f19005u.intValue() > 59) {
            this.f19005u = Integer.valueOf(0);
            m15043n();
        } else if (this.f19005u.intValue() < 0) {
            this.f19005u = Integer.valueOf(59);
            m15043n();
        }
    }

    /* renamed from: p */
    private void m15045p() {
        if (this.f18992h) {
            this.f19006v = Integer.valueOf(this.f19006v.intValue() + 1);
        } else {
            this.f19006v = Integer.valueOf(this.f19006v.intValue() - 1);
        }
        if (this.f19006v.intValue() > 59) {
            this.f19006v = Integer.valueOf(0);
            m15044o();
        } else if (this.f19006v.intValue() < 0) {
            this.f19006v = Integer.valueOf(59);
            m15044o();
        }
    }

    /* renamed from: q */
    private void m15046q() {
        int daysInMonth = m15041l();
        if (this.f19003s.intValue() <= daysInMonth) {
            return;
        }
        if (DayOverflow.Abort == this.f18993i) {
            throw new RuntimeException("Day Overflow: Year:" + this.f19001q + " Month:" + this.f19002r + " has " + daysInMonth + " days, but day has value:" + this.f19003s + " To avoid these exceptions, please specify a different DayOverflow policy.");
        } else if (DayOverflow.FirstDay == this.f18993i) {
            this.f19003s = Integer.valueOf(1);
            m15039j();
        } else if (DayOverflow.LastDay == this.f18993i) {
            this.f19003s = Integer.valueOf(daysInMonth);
        } else if (DayOverflow.Spillover == this.f18993i) {
            this.f19003s = Integer.valueOf(this.f19003s.intValue() - daysInMonth);
            m15039j();
        }
    }
}
