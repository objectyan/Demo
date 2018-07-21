package com.baidu.mapframework.commonlib.date;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTime
  implements Serializable, Comparable<DateTime>
{
  private static final int a = 0;
  private static final long b = -1300068157085493891L;
  private static int c = 2400000;
  private String d;
  private Integer e;
  private Integer f;
  private Integer g;
  private Integer h;
  private Integer i;
  private Integer j;
  private Integer k;
  private boolean l;
  private int m;
  
  public DateTime(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7)
  {
    this.l = true;
    this.e = paramInteger1;
    this.f = paramInteger2;
    this.g = paramInteger3;
    this.h = paramInteger4;
    this.i = paramInteger5;
    this.j = paramInteger6;
    this.k = paramInteger7;
    e();
  }
  
  public DateTime(String paramString)
  {
    this.l = false;
    if (paramString == null) {
      throw new IllegalArgumentException("String passed to DateTime constructor is null. You can use an empty string, but not a null reference.");
    }
    this.d = paramString;
  }
  
  static DateTime a(int paramInt)
  {
    int n = paramInt + 68569;
    paramInt = n * 4 / 146097;
    int i1 = n - (146097 * paramInt + 3) / 4;
    n = (i1 + 1) * 4000 / 1461001;
    i1 = i1 - n * 1461 / 4 + 31;
    int i2 = i1 * 80 / 2447;
    int i3 = i2 * 2447 / 80;
    int i4 = i2 / 11;
    return forDateOnly(Integer.valueOf((paramInt - 49) * 100 + n + i4), Integer.valueOf(i2 + 2 - i4 * 12), Integer.valueOf(i1 - i3));
  }
  
  private DateTime a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    c();
    return new DateTime(this.e, this.f, paramInteger1, paramInteger2, paramInteger3, paramInteger4, paramInteger5);
  }
  
  static Integer a(Integer paramInteger1, Integer paramInteger2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInteger1 != null)
    {
      localObject1 = localObject2;
      if (paramInteger2 != null)
      {
        if (paramInteger2.intValue() != 1) {
          break label33;
        }
        localObject1 = Integer.valueOf(31);
      }
    }
    return (Integer)localObject1;
    label33:
    if (paramInteger2.intValue() == 2)
    {
      if (a(paramInteger1)) {}
      for (int n = 29;; n = 28) {
        return Integer.valueOf(n);
      }
    }
    if (paramInteger2.intValue() == 3) {
      return Integer.valueOf(31);
    }
    if (paramInteger2.intValue() == 4) {
      return Integer.valueOf(30);
    }
    if (paramInteger2.intValue() == 5) {
      return Integer.valueOf(31);
    }
    if (paramInteger2.intValue() == 6) {
      return Integer.valueOf(30);
    }
    if (paramInteger2.intValue() == 7) {
      return Integer.valueOf(31);
    }
    if (paramInteger2.intValue() == 8) {
      return Integer.valueOf(31);
    }
    if (paramInteger2.intValue() == 9) {
      return Integer.valueOf(30);
    }
    if (paramInteger2.intValue() == 10) {
      return Integer.valueOf(31);
    }
    if (paramInteger2.intValue() == 11) {
      return Integer.valueOf(30);
    }
    if (paramInteger2.intValue() == 12) {
      return Integer.valueOf(31);
    }
    throw new AssertionError("Month is out of range 1..12:" + paramInteger2);
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws ClassNotFoundException, IOException
  {
    paramObjectInputStream.defaultReadObject();
    e();
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
  }
  
  private void a(Integer paramInteger, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInteger != null) && ((paramInteger.intValue() < paramInt1) || (paramInteger.intValue() > paramInt2))) {
      throw new ItemOutOfRange(paramString + " is not in the range " + paramInt1 + ".." + paramInt2 + ". Value is:" + paramInteger);
    }
  }
  
  private void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if ((b(paramInteger1, paramInteger2, paramInteger3)) && (paramInteger3.intValue() > a(paramInteger1, paramInteger2).intValue())) {
      throw new ItemOutOfRange("The day-of-the-month value '" + paramInteger3 + "' exceeds the number of days in the month: " + a(paramInteger1, paramInteger2));
    }
  }
  
  private void a(String paramString, Object paramObject, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramString + ":" + String.valueOf(paramObject) + " ");
  }
  
  private static boolean a(Integer paramInteger)
  {
    boolean bool = false;
    if (paramInteger.intValue() % 100 == 0) {
      if (paramInteger.intValue() % 400 == 0) {
        bool = true;
      }
    }
    while (paramInteger.intValue() % 4 != 0) {
      return bool;
    }
    return true;
  }
  
  private boolean a(Object... paramVarArgs)
  {
    boolean bool2 = true;
    int i1 = paramVarArgs.length;
    int n = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (n < i1)
      {
        if (paramVarArgs[n] == null) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      n += 1;
    }
  }
  
  private int b()
  {
    int n = this.e.intValue();
    int i1 = this.f.intValue();
    int i2 = this.g.intValue();
    return (n + 4800 + (i1 - 14) / 12) * 1461 / 4 + (i1 - 2 - (i1 - 14) / 12 * 12) * 367 / 12 - (n + 4900 + (i1 - 14) / 12) / 100 * 3 / 4 + i2 - 32075;
  }
  
  private boolean b(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return a(new Object[] { paramInteger1, paramInteger2, paramInteger3 });
  }
  
  private void c()
  {
    a();
    if (!hasYearMonthDay()) {
      throw new MissingItem("DateTime does not include year/month/day.");
    }
  }
  
  private int d()
  {
    int i1 = 0;
    if (this.j != null) {
      i1 = 0 + this.j.intValue();
    }
    int n = i1;
    if (this.i != null) {
      n = i1 + this.i.intValue() * 60;
    }
    i1 = n;
    if (this.h != null) {
      i1 = n + this.h.intValue() * 3600;
    }
    return i1;
  }
  
  private void e()
  {
    a(this.e, 1, 9999, "Year");
    a(this.f, 1, 12, "Month");
    a(this.g, 1, 31, "Day");
    a(this.h, 0, 23, "Hour");
    a(this.i, 0, 59, "Minute");
    a(this.j, 0, 59, "Second");
    a(this.k, 0, 999999999, "Nanosecond");
    a(this.e, this.f, this.g);
  }
  
  private void f()
  {
    DateTime localDateTime = new DateTimeParser().a(this.d);
    this.e = localDateTime.e;
    this.f = localDateTime.f;
    this.g = localDateTime.g;
    this.h = localDateTime.h;
    this.i = localDateTime.i;
    this.j = localDateTime.j;
    this.k = localDateTime.k;
    e();
  }
  
  public static DateTime forDateOnly(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return new DateTime(paramInteger1, paramInteger2, paramInteger3, null, null, null, null);
  }
  
  public static DateTime forInstant(long paramLong, TimeZone paramTimeZone)
  {
    paramTimeZone = new GregorianCalendar(paramTimeZone);
    paramTimeZone.setTimeInMillis(paramLong);
    return new DateTime(Integer.valueOf(paramTimeZone.get(1)), Integer.valueOf(paramTimeZone.get(2) + 1), Integer.valueOf(paramTimeZone.get(5)), Integer.valueOf(paramTimeZone.get(11)), Integer.valueOf(paramTimeZone.get(12)), Integer.valueOf(paramTimeZone.get(13)), Integer.valueOf(paramTimeZone.get(14) * 1000 * 1000));
  }
  
  public static DateTime forTimeOnly(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
  {
    return new DateTime(null, null, null, paramInteger1, paramInteger2, paramInteger3, paramInteger4);
  }
  
  private Object[] g()
  {
    return new Object[] { this.e, this.f, this.g, this.h, this.i, this.j, this.k };
  }
  
  private String h()
  {
    Object localObject2 = null;
    Object localObject1;
    if (unitsAllPresent(new Unit[] { Unit.YEAR })) {
      if (unitsAllAbsent(new Unit[] { Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
        localObject1 = "YYYY";
      }
    }
    do
    {
      do
      {
        return (String)localObject1;
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH })) {
          if (unitsAllAbsent(new Unit[] { Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
            return "YYYY-MM";
          }
        }
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY })) {
          if (unitsAllAbsent(new Unit[] { Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
            return "YYYY-MM-DD";
          }
        }
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR })) {
          if (unitsAllAbsent(new Unit[] { Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
            return "YYYY-MM-DD hh";
          }
        }
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE })) {
          if (unitsAllAbsent(new Unit[] { Unit.SECOND, Unit.NANOSECONDS })) {
            return "YYYY-MM-DD hh:mm";
          }
        }
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND })) {
          if (unitsAllAbsent(new Unit[] { Unit.NANOSECONDS })) {
            return "YYYY-MM-DD hh:mm:ss";
          }
        }
        if (unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
          return "YYYY-MM-DD hh:mm:ss.fffffffff";
        }
        if (unitsAllAbsent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY })) {
          if (unitsAllPresent(new Unit[] { Unit.HOUR, Unit.MINUTE, Unit.SECOND, Unit.NANOSECONDS })) {
            return "hh:mm:ss.fffffffff";
          }
        }
        if (unitsAllAbsent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.NANOSECONDS })) {
          if (unitsAllPresent(new Unit[] { Unit.HOUR, Unit.MINUTE, Unit.SECOND })) {
            return "hh:mm:ss";
          }
        }
        localObject1 = localObject2;
      } while (!unitsAllAbsent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY, Unit.SECOND, Unit.NANOSECONDS }));
      localObject1 = localObject2;
    } while (!unitsAllPresent(new Unit[] { Unit.HOUR, Unit.MINUTE }));
    return "hh:mm";
  }
  
  public static DateTime now(TimeZone paramTimeZone)
  {
    return forInstant(System.currentTimeMillis(), paramTimeZone);
  }
  
  public static DateTime today(TimeZone paramTimeZone)
  {
    return now(paramTimeZone).truncate(Unit.DAY);
  }
  
  void a()
  {
    if (!this.l) {
      f();
    }
  }
  
  public DateTime changeTimeZone(TimeZone paramTimeZone1, TimeZone paramTimeZone2)
  {
    c();
    if (unitsAllAbsent(new Unit[] { Unit.HOUR })) {
      throw new IllegalArgumentException("DateTime does not include the hour. Cannot change the time zone if no hour is present.");
    }
    paramTimeZone1 = new GregorianCalendar(paramTimeZone1);
    paramTimeZone1.set(1, getYear().intValue());
    paramTimeZone1.set(2, getMonth().intValue() - 1);
    paramTimeZone1.set(5, getDay().intValue());
    paramTimeZone1.set(11, getHour().intValue());
    if (getMinute() != null)
    {
      paramTimeZone1.set(12, getMinute().intValue());
      paramTimeZone1.set(13, 0);
      paramTimeZone1.set(14, 0);
      paramTimeZone2 = new GregorianCalendar(paramTimeZone2);
      paramTimeZone2.setTimeInMillis(paramTimeZone1.getTimeInMillis());
      if (getMinute() == null) {
        break label222;
      }
    }
    label222:
    for (paramTimeZone1 = Integer.valueOf(paramTimeZone2.get(12));; paramTimeZone1 = null)
    {
      return new DateTime(Integer.valueOf(paramTimeZone2.get(1)), Integer.valueOf(paramTimeZone2.get(2) + 1), Integer.valueOf(paramTimeZone2.get(5)), Integer.valueOf(paramTimeZone2.get(11)), paramTimeZone1, getSecond(), getNanoseconds());
      paramTimeZone1.set(12, 0);
      break;
    }
  }
  
  public int compareTo(DateTime paramDateTime)
  {
    int n;
    if (this == paramDateTime) {
      n = 0;
    }
    int i1;
    do
    {
      ModelUtil.NullsGo localNullsGo;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return n;
                  a();
                  paramDateTime.a();
                  localNullsGo = ModelUtil.NullsGo.FIRST;
                  i1 = ModelUtil.a(this.e, paramDateTime.e, localNullsGo);
                  n = i1;
                } while (i1 != 0);
                i1 = ModelUtil.a(this.f, paramDateTime.f, localNullsGo);
                n = i1;
              } while (i1 != 0);
              i1 = ModelUtil.a(this.g, paramDateTime.g, localNullsGo);
              n = i1;
            } while (i1 != 0);
            i1 = ModelUtil.a(this.h, paramDateTime.h, localNullsGo);
            n = i1;
          } while (i1 != 0);
          i1 = ModelUtil.a(this.i, paramDateTime.i, localNullsGo);
          n = i1;
        } while (i1 != 0);
        i1 = ModelUtil.a(this.j, paramDateTime.j, localNullsGo);
        n = i1;
      } while (i1 != 0);
      i1 = ModelUtil.a(this.k, paramDateTime.k, localNullsGo);
      n = i1;
    } while (i1 != 0);
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    a();
    Boolean localBoolean2 = ModelUtil.a(this, paramObject);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null)
    {
      paramObject = (DateTime)paramObject;
      ((DateTime)paramObject).a();
      localBoolean1 = Boolean.valueOf(ModelUtil.a(g(), ((DateTime)paramObject).g()));
    }
    return localBoolean1.booleanValue();
  }
  
  public String format(String paramString)
  {
    return new DateTimeFormatter(paramString).a(this);
  }
  
  public String format(String paramString, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    return new DateTimeFormatter(paramString, paramList1, paramList2, paramList3).a(this);
  }
  
  public String format(String paramString, Locale paramLocale)
  {
    return new DateTimeFormatter(paramString, paramLocale).a(this);
  }
  
  public Integer getDay()
  {
    a();
    return this.g;
  }
  
  public Integer getDayOfYear()
  {
    c();
    if (isLeapYear().booleanValue()) {}
    for (int n = 1;; n = 2) {
      return Integer.valueOf(this.f.intValue() * 275 / 9 - (this.f.intValue() + 9) / 12 * n + this.g.intValue() - 30);
    }
  }
  
  public DateTime getEndOfDay()
  {
    c();
    return a(this.g, Integer.valueOf(23), Integer.valueOf(59), Integer.valueOf(59), Integer.valueOf(999999999));
  }
  
  public DateTime getEndOfMonth()
  {
    c();
    return a(Integer.valueOf(getNumDaysInMonth()), Integer.valueOf(23), Integer.valueOf(59), Integer.valueOf(59), Integer.valueOf(999999999));
  }
  
  public Integer getHour()
  {
    a();
    return this.h;
  }
  
  public long getMilliseconds(TimeZone paramTimeZone)
  {
    int i3 = 0;
    Integer localInteger1 = getYear();
    Integer localInteger2 = getMonth();
    Integer localInteger3 = getDay();
    int n;
    int i1;
    label39:
    int i2;
    if (getHour() == null)
    {
      n = 0;
      if (getMinute() != null) {
        break label171;
      }
      i1 = 0;
      if (getSecond() != null) {
        break label182;
      }
      i2 = 0;
      label49:
      if (getNanoseconds() != null) {
        break label194;
      }
    }
    for (;;)
    {
      paramTimeZone = new GregorianCalendar(paramTimeZone);
      paramTimeZone.set(1, localInteger1.intValue());
      paramTimeZone.set(2, localInteger2.intValue() - 1);
      paramTimeZone.set(5, localInteger3.intValue());
      paramTimeZone.set(11, Integer.valueOf(n).intValue());
      paramTimeZone.set(12, Integer.valueOf(i1).intValue());
      paramTimeZone.set(13, Integer.valueOf(i2).intValue());
      paramTimeZone.set(14, Integer.valueOf(i3).intValue() / 1000000);
      return paramTimeZone.getTimeInMillis();
      n = getHour().intValue();
      break;
      label171:
      i1 = getMinute().intValue();
      break label39;
      label182:
      i2 = getSecond().intValue();
      break label49;
      label194:
      i3 = getNanoseconds().intValue();
    }
  }
  
  public Integer getMinute()
  {
    a();
    return this.i;
  }
  
  public Integer getModifiedJulianDayNumber()
  {
    c();
    return Integer.valueOf(b() - 1 - c);
  }
  
  public Integer getMonth()
  {
    a();
    return this.f;
  }
  
  public Integer getNanoseconds()
  {
    a();
    return this.k;
  }
  
  public int getNumDaysInMonth()
  {
    c();
    return a(this.e, this.f).intValue();
  }
  
  public Unit getPrecision()
  {
    a();
    Unit localUnit = null;
    if (a(new Object[] { this.k })) {
      localUnit = Unit.NANOSECONDS;
    }
    do
    {
      return localUnit;
      if (a(new Object[] { this.j })) {
        return Unit.SECOND;
      }
      if (a(new Object[] { this.i })) {
        return Unit.MINUTE;
      }
      if (a(new Object[] { this.h })) {
        return Unit.HOUR;
      }
      if (a(new Object[] { this.g })) {
        return Unit.DAY;
      }
      if (a(new Object[] { this.f })) {
        return Unit.MONTH;
      }
    } while (!a(new Object[] { this.e }));
    return Unit.YEAR;
  }
  
  public String getRawDateString()
  {
    return this.d;
  }
  
  public Integer getSecond()
  {
    a();
    return this.j;
  }
  
  public DateTime getStartOfDay()
  {
    c();
    return a(this.g, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public DateTime getStartOfMonth()
  {
    c();
    return a(Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public Integer getWeekDay()
  {
    c();
    return Integer.valueOf((b() + 1) % 7 + 1);
  }
  
  public Integer getWeekIndex()
  {
    return getWeekIndex(forDateOnly(Integer.valueOf(2000), Integer.valueOf(1), Integer.valueOf(2)));
  }
  
  public Integer getWeekIndex(DateTime paramDateTime)
  {
    c();
    paramDateTime.c();
    return Integer.valueOf((getModifiedJulianDayNumber().intValue() - paramDateTime.getModifiedJulianDayNumber().intValue()) / 7 + 1);
  }
  
  public Integer getYear()
  {
    a();
    return this.e;
  }
  
  public boolean gt(DateTime paramDateTime)
  {
    return compareTo(paramDateTime) > 0;
  }
  
  public boolean gteq(DateTime paramDateTime)
  {
    return (compareTo(paramDateTime) > 0) || (equals(paramDateTime));
  }
  
  public boolean hasHourMinuteSecond()
  {
    return unitsAllPresent(new Unit[] { Unit.HOUR, Unit.MINUTE, Unit.SECOND });
  }
  
  public boolean hasYearMonthDay()
  {
    return unitsAllPresent(new Unit[] { Unit.YEAR, Unit.MONTH, Unit.DAY });
  }
  
  public int hashCode()
  {
    if (this.m == 0)
    {
      a();
      this.m = ModelUtil.a(g());
    }
    return this.m;
  }
  
  public boolean isInTheFuture(TimeZone paramTimeZone)
  {
    return now(paramTimeZone).lt(this);
  }
  
  public boolean isInThePast(TimeZone paramTimeZone)
  {
    return now(paramTimeZone).gt(this);
  }
  
  public Boolean isLeapYear()
  {
    a();
    if (a(new Object[] { this.e })) {
      return Boolean.valueOf(a(this.e));
    }
    throw new MissingItem("Year is absent. Cannot determine if leap year.");
  }
  
  public boolean isSameDayAs(DateTime paramDateTime)
  {
    c();
    paramDateTime.c();
    return (this.e.equals(paramDateTime.e)) && (this.f.equals(paramDateTime.f)) && (this.g.equals(paramDateTime.g));
  }
  
  public boolean lt(DateTime paramDateTime)
  {
    return compareTo(paramDateTime) < 0;
  }
  
  public boolean lteq(DateTime paramDateTime)
  {
    return (compareTo(paramDateTime) < 0) || (equals(paramDateTime));
  }
  
  public DateTime minus(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, DayOverflow paramDayOverflow)
  {
    return new DateTimeInterval(this, paramDayOverflow).b(paramInteger1.intValue(), paramInteger2.intValue(), paramInteger3.intValue(), paramInteger4.intValue(), paramInteger5.intValue(), paramInteger6.intValue(), paramInteger7.intValue());
  }
  
  public DateTime minusDays(Integer paramInteger)
  {
    return plusDays(Integer.valueOf(paramInteger.intValue() * -1));
  }
  
  public int numDaysFrom(DateTime paramDateTime)
  {
    return paramDateTime.getModifiedJulianDayNumber().intValue() - getModifiedJulianDayNumber().intValue();
  }
  
  public long numSecondsFrom(DateTime paramDateTime)
  {
    long l2 = 0L;
    long l1 = l2;
    if (hasYearMonthDay())
    {
      l1 = l2;
      if (paramDateTime.hasYearMonthDay()) {
        l1 = numDaysFrom(paramDateTime) * 86400;
      }
    }
    return l1 - d() + paramDateTime.d();
  }
  
  public DateTime plus(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, DayOverflow paramDayOverflow)
  {
    return new DateTimeInterval(this, paramDayOverflow).a(paramInteger1.intValue(), paramInteger2.intValue(), paramInteger3.intValue(), paramInteger4.intValue(), paramInteger5.intValue(), paramInteger6.intValue(), paramInteger7.intValue());
  }
  
  public DateTime plusDays(Integer paramInteger)
  {
    c();
    paramInteger = a(getModifiedJulianDayNumber().intValue() + 1 + c + paramInteger.intValue());
    return new DateTime(paramInteger.getYear(), paramInteger.getMonth(), paramInteger.getDay(), this.h, this.i, this.j, this.k);
  }
  
  public String toString()
  {
    if (Util.a(this.d)) {
      return this.d;
    }
    if (h() != null) {
      return format(h());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a("Y", this.e, localStringBuilder);
    a("M", this.f, localStringBuilder);
    a("D", this.g, localStringBuilder);
    a("h", this.h, localStringBuilder);
    a("m", this.i, localStringBuilder);
    a("s", this.j, localStringBuilder);
    a("f", this.k, localStringBuilder);
    return localStringBuilder.toString().trim();
  }
  
  public DateTime truncate(Unit paramUnit)
  {
    a();
    DateTime localDateTime = null;
    if (Unit.NANOSECONDS == paramUnit) {
      throw new IllegalArgumentException("It makes no sense to truncate to nanosecond precision, since that's the highest precision available.");
    }
    if (Unit.SECOND == paramUnit) {
      localDateTime = new DateTime(this.e, this.f, this.g, this.h, this.i, this.j, null);
    }
    do
    {
      return localDateTime;
      if (Unit.MINUTE == paramUnit) {
        return new DateTime(this.e, this.f, this.g, this.h, this.i, null, null);
      }
      if (Unit.HOUR == paramUnit) {
        return new DateTime(this.e, this.f, this.g, this.h, null, null, null);
      }
      if (Unit.DAY == paramUnit) {
        return new DateTime(this.e, this.f, this.g, null, null, null, null);
      }
      if (Unit.MONTH == paramUnit) {
        return new DateTime(this.e, this.f, null, null, null, null, null);
      }
    } while (Unit.YEAR != paramUnit);
    return new DateTime(this.e, null, null, null, null, null, null);
  }
  
  public boolean unitsAllAbsent(Unit... paramVarArgs)
  {
    boolean bool2 = true;
    a();
    int i1 = paramVarArgs.length;
    int n = 0;
    if (n < i1)
    {
      Unit localUnit = paramVarArgs[n];
      if (Unit.NANOSECONDS == localUnit) {
        if ((bool2) && (this.k == null)) {
          bool1 = true;
        }
      }
      do
      {
        for (;;)
        {
          n += 1;
          bool2 = bool1;
          break;
          bool1 = false;
        }
        if (Unit.SECOND == localUnit)
        {
          if ((bool2) && (this.j == null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.MINUTE == localUnit)
        {
          if ((bool2) && (this.i == null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.HOUR == localUnit)
        {
          if ((bool2) && (this.h == null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.DAY == localUnit)
        {
          if ((bool2) && (this.g == null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.MONTH == localUnit)
        {
          if ((bool2) && (this.f == null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        bool1 = bool2;
      } while (Unit.YEAR != localUnit);
      if ((bool2) && (this.e == null)) {}
      for (boolean bool1 = true;; bool1 = false) {
        break;
      }
    }
    return bool2;
  }
  
  public boolean unitsAllPresent(Unit... paramVarArgs)
  {
    boolean bool2 = true;
    a();
    int i1 = paramVarArgs.length;
    int n = 0;
    if (n < i1)
    {
      Unit localUnit = paramVarArgs[n];
      if (Unit.NANOSECONDS == localUnit) {
        if ((bool2) && (this.k != null)) {
          bool1 = true;
        }
      }
      do
      {
        for (;;)
        {
          n += 1;
          bool2 = bool1;
          break;
          bool1 = false;
        }
        if (Unit.SECOND == localUnit)
        {
          if ((bool2) && (this.j != null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.MINUTE == localUnit)
        {
          if ((bool2) && (this.i != null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.HOUR == localUnit)
        {
          if ((bool2) && (this.h != null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.DAY == localUnit)
        {
          if ((bool2) && (this.g != null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (Unit.MONTH == localUnit)
        {
          if ((bool2) && (this.f != null)) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        bool1 = bool2;
      } while (Unit.YEAR != localUnit);
      if ((bool2) && (this.e != null)) {}
      for (boolean bool1 = true;; bool1 = false) {
        break;
      }
    }
    return bool2;
  }
  
  public static enum DayOverflow
  {
    static
    {
      FirstDay = new DayOverflow("FirstDay", 1);
      Spillover = new DayOverflow("Spillover", 2);
    }
    
    private DayOverflow() {}
  }
  
  static final class ItemOutOfRange
    extends RuntimeException
  {
    private static final long a = 4760138291907517660L;
    
    ItemOutOfRange(String paramString)
    {
      super();
    }
  }
  
  static final class MissingItem
    extends RuntimeException
  {
    private static final long a = -7359967338896127755L;
    
    MissingItem(String paramString)
    {
      super();
    }
  }
  
  public static enum Unit
  {
    static
    {
      MONTH = new Unit("MONTH", 1);
      DAY = new Unit("DAY", 2);
      HOUR = new Unit("HOUR", 3);
      MINUTE = new Unit("MINUTE", 4);
      SECOND = new Unit("SECOND", 5);
    }
    
    private Unit() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/DateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */