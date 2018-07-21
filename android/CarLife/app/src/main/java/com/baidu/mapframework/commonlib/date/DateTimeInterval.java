package com.baidu.mapframework.commonlib.date;

final class DateTimeInterval
{
  private static final int a = 0;
  private static final int b = 9999;
  private static final int c = 0;
  private static final int d = 999999999;
  private static final boolean e = true;
  private static final boolean f = false;
  private final DateTime g;
  private boolean h;
  private DateTime.DayOverflow i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private Integer q;
  private Integer r;
  private Integer s;
  private Integer t;
  private Integer u;
  private Integer v;
  private Integer w;
  
  DateTimeInterval(DateTime paramDateTime, DateTime.DayOverflow paramDayOverflow)
  {
    this.g = paramDateTime;
    a();
    if (this.g.getYear() == null)
    {
      i1 = 1;
      this.q = Integer.valueOf(i1);
      if (this.g.getMonth() != null) {
        break label181;
      }
      i1 = 1;
      label51:
      this.r = Integer.valueOf(i1);
      if (this.g.getDay() != null) {
        break label195;
      }
      i1 = i3;
      label72:
      this.s = Integer.valueOf(i1);
      if (this.g.getHour() != null) {
        break label209;
      }
      i1 = 0;
      label92:
      this.t = Integer.valueOf(i1);
      if (this.g.getMinute() != null) {
        break label223;
      }
      i1 = 0;
      label112:
      this.u = Integer.valueOf(i1);
      if (this.g.getSecond() != null) {
        break label237;
      }
      i1 = 0;
      label132:
      this.v = Integer.valueOf(i1);
      if (this.g.getNanoseconds() != null) {
        break label251;
      }
    }
    label181:
    label195:
    label209:
    label223:
    label237:
    label251:
    for (int i1 = i2;; i1 = this.g.getNanoseconds().intValue())
    {
      this.w = Integer.valueOf(i1);
      this.i = paramDayOverflow;
      return;
      i1 = this.g.getYear().intValue();
      break;
      i1 = this.g.getMonth().intValue();
      break label51;
      i1 = this.g.getDay().intValue();
      break label72;
      i1 = this.g.getHour().intValue();
      break label92;
      i1 = this.g.getMinute().intValue();
      break label112;
      i1 = this.g.getSecond().intValue();
      break label132;
    }
  }
  
  private DateTime a(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7)
  {
    this.h = paramBoolean;
    this.j = paramInteger1.intValue();
    this.k = paramInteger2.intValue();
    this.l = paramInteger3.intValue();
    this.m = paramInteger4.intValue();
    this.n = paramInteger5.intValue();
    this.o = paramInteger6.intValue();
    this.p = paramInteger7.intValue();
    a(Integer.valueOf(this.j), "Year");
    a(Integer.valueOf(this.k), "Month");
    a(Integer.valueOf(this.l), "Day");
    a(Integer.valueOf(this.m), "Hour");
    a(Integer.valueOf(this.n), "Minute");
    a(Integer.valueOf(this.o), "Second");
    a(Integer.valueOf(this.p));
    b();
    c();
    q();
    d();
    e();
    f();
    g();
    h();
    return new DateTime(this.q, this.r, this.s, this.t, this.u, this.v, this.w);
  }
  
  private void a()
  {
    int i1;
    if (this.g.unitsAllPresent(new DateTime.Unit[] { DateTime.Unit.YEAR, DateTime.Unit.MONTH, DateTime.Unit.DAY, DateTime.Unit.HOUR, DateTime.Unit.MINUTE, DateTime.Unit.SECOND })) {
      i1 = 1;
    }
    while (i1 == 0)
    {
      throw new IllegalArgumentException("For interval calculations, DateTime must have year-month-day, or hour-minute-second, or both.");
      if (this.g.unitsAllPresent(new DateTime.Unit[] { DateTime.Unit.YEAR, DateTime.Unit.MONTH, DateTime.Unit.DAY })) {
        if (this.g.unitsAllAbsent(new DateTime.Unit[] { DateTime.Unit.HOUR, DateTime.Unit.MINUTE, DateTime.Unit.SECOND }))
        {
          i1 = 1;
          continue;
        }
      }
      if (this.g.unitsAllAbsent(new DateTime.Unit[] { DateTime.Unit.YEAR, DateTime.Unit.MONTH, DateTime.Unit.DAY })) {
        if (!this.g.unitsAllPresent(new DateTime.Unit[] { DateTime.Unit.HOUR, DateTime.Unit.MINUTE, DateTime.Unit.SECOND })) {}
      }
      for (i1 = 1;; i1 = 0) {
        break;
      }
    }
  }
  
  private void a(Integer paramInteger)
  {
    if ((paramInteger.intValue() < 0) || (paramInteger.intValue() > 999999999)) {
      throw new IllegalArgumentException("Nanosecond interval is not in the range 0..999999999");
    }
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    if ((paramInteger.intValue() < 0) || (paramInteger.intValue() > 9999)) {
      throw new IllegalArgumentException(paramString + " is not in the range " + 0 + ".." + 9999);
    }
  }
  
  private void b()
  {
    if (this.h)
    {
      this.q = Integer.valueOf(this.q.intValue() + this.j);
      return;
    }
    this.q = Integer.valueOf(this.g.getYear().intValue() - this.j);
  }
  
  private void c()
  {
    int i1 = 0;
    while (i1 < this.k)
    {
      j();
      i1 += 1;
    }
  }
  
  private void d()
  {
    int i1 = 0;
    while (i1 < this.l)
    {
      k();
      i1 += 1;
    }
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < this.m)
    {
      n();
      i1 += 1;
    }
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < this.n)
    {
      o();
      i1 += 1;
    }
  }
  
  private void g()
  {
    int i1 = 0;
    while (i1 < this.o)
    {
      p();
      i1 += 1;
    }
  }
  
  private void h()
  {
    if (this.h)
    {
      this.w = Integer.valueOf(this.w.intValue() + this.p);
      if (this.w.intValue() <= 999999999) {
        break label84;
      }
      p();
      this.w = Integer.valueOf(this.w.intValue() - 999999999 - 1);
    }
    label84:
    while (this.w.intValue() >= 0)
    {
      return;
      this.w = Integer.valueOf(this.w.intValue() - this.p);
      break;
    }
    p();
    this.w = Integer.valueOf(this.w.intValue() + 999999999 + 1);
  }
  
  private void i()
  {
    if (this.h)
    {
      this.q = Integer.valueOf(this.q.intValue() + 1);
      return;
    }
    this.q = Integer.valueOf(this.q.intValue() - 1);
  }
  
  private void j()
  {
    if (this.h)
    {
      this.r = Integer.valueOf(this.r.intValue() + 1);
      if (this.r.intValue() <= 12) {
        break label67;
      }
      this.r = Integer.valueOf(1);
      i();
    }
    label67:
    while (this.r.intValue() >= 1)
    {
      return;
      this.r = Integer.valueOf(this.r.intValue() - 1);
      break;
    }
    this.r = Integer.valueOf(12);
    i();
  }
  
  private void k()
  {
    if (this.h)
    {
      this.s = Integer.valueOf(this.s.intValue() + 1);
      if (this.s.intValue() <= l()) {
        break label69;
      }
      this.s = Integer.valueOf(1);
      j();
    }
    label69:
    while (this.s.intValue() >= 1)
    {
      return;
      this.s = Integer.valueOf(this.s.intValue() - 1);
      break;
    }
    this.s = Integer.valueOf(m());
    j();
  }
  
  private int l()
  {
    return DateTime.a(this.q, this.r).intValue();
  }
  
  private int m()
  {
    if (this.r.intValue() > 1) {
      return DateTime.a(this.q, Integer.valueOf(this.r.intValue() - 1)).intValue();
    }
    return DateTime.a(Integer.valueOf(this.q.intValue() - 1), Integer.valueOf(12)).intValue();
  }
  
  private void n()
  {
    if (this.h)
    {
      this.t = Integer.valueOf(this.t.intValue() + 1);
      if (this.t.intValue() <= 23) {
        break label67;
      }
      this.t = Integer.valueOf(0);
      k();
    }
    label67:
    while (this.t.intValue() >= 0)
    {
      return;
      this.t = Integer.valueOf(this.t.intValue() - 1);
      break;
    }
    this.t = Integer.valueOf(23);
    k();
  }
  
  private void o()
  {
    if (this.h)
    {
      this.u = Integer.valueOf(this.u.intValue() + 1);
      if (this.u.intValue() <= 59) {
        break label67;
      }
      this.u = Integer.valueOf(0);
      n();
    }
    label67:
    while (this.u.intValue() >= 0)
    {
      return;
      this.u = Integer.valueOf(this.u.intValue() - 1);
      break;
    }
    this.u = Integer.valueOf(59);
    n();
  }
  
  private void p()
  {
    if (this.h)
    {
      this.v = Integer.valueOf(this.v.intValue() + 1);
      if (this.v.intValue() <= 59) {
        break label67;
      }
      this.v = Integer.valueOf(0);
      o();
    }
    label67:
    while (this.v.intValue() >= 0)
    {
      return;
      this.v = Integer.valueOf(this.v.intValue() - 1);
      break;
    }
    this.v = Integer.valueOf(59);
    o();
  }
  
  private void q()
  {
    int i1 = l();
    if (this.s.intValue() > i1)
    {
      if (DateTime.DayOverflow.Abort == this.i) {
        throw new RuntimeException("Day Overflow: Year:" + this.q + " Month:" + this.r + " has " + i1 + " days, but day has value:" + this.s + " To avoid these exceptions, please specify a different DayOverflow policy.");
      }
      if (DateTime.DayOverflow.FirstDay != this.i) {
        break label117;
      }
      this.s = Integer.valueOf(1);
      j();
    }
    label117:
    do
    {
      return;
      if (DateTime.DayOverflow.LastDay == this.i)
      {
        this.s = Integer.valueOf(i1);
        return;
      }
    } while (DateTime.DayOverflow.Spillover != this.i);
    this.s = Integer.valueOf(this.s.intValue() - i1);
    j();
  }
  
  DateTime a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return a(true, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7));
  }
  
  DateTime b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return a(false, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/DateTimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */