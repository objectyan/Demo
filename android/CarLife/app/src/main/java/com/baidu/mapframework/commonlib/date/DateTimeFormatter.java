package com.baidu.mapframework.commonlib.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DateTimeFormatter
{
  private static final String a = "|";
  private static final Pattern b = Pattern.compile("\\|[^\\|]*\\|");
  private static final String c = "YYYY";
  private static final String d = "YY";
  private static final String e = "M";
  private static final String f = "MM";
  private static final String g = "MMM";
  private static final String h = "MMMM";
  private static final String i = "D";
  private static final String j = "DD";
  private static final String k = "WWW";
  private static final String l = "WWWW";
  private static final String m = "hh";
  private static final String n = "h";
  private static final String o = "m";
  private static final String p = "mm";
  private static final String q = "s";
  private static final String r = "ss";
  private static final String s = "h12";
  private static final String t = "hh12";
  private static final int u = 0;
  private static final int v = 1;
  private static final String w = "a";
  private static final Pattern x = Pattern.compile("f{1,9}");
  private static final String y = "";
  private static final List<String> z = new ArrayList();
  private final String A;
  private final Locale B;
  private final Map<Locale, List<String>> C = new LinkedHashMap();
  private final Map<Locale, List<String>> D = new LinkedHashMap();
  private final Map<Locale, List<String>> E = new LinkedHashMap();
  private final CustomLocalization F;
  private Collection<InterpretedRange> G;
  private Collection<EscapedRange> H;
  
  static
  {
    z.add("YYYY");
    z.add("YY");
    z.add("MMMM");
    z.add("MMM");
    z.add("MM");
    z.add("M");
    z.add("DD");
    z.add("D");
    z.add("WWWW");
    z.add("WWW");
    z.add("hh12");
    z.add("h12");
    z.add("hh");
    z.add("h");
    z.add("mm");
    z.add("m");
    z.add("ss");
    z.add("s");
    z.add("a");
    z.add("fffffffff");
    z.add("ffffffff");
    z.add("fffffff");
    z.add("ffffff");
    z.add("fffff");
    z.add("ffff");
    z.add("fff");
    z.add("ff");
    z.add("f");
  }
  
  DateTimeFormatter(String paramString)
  {
    this.A = paramString;
    this.B = null;
    this.F = null;
    c();
  }
  
  DateTimeFormatter(String paramString, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    this.A = paramString;
    this.B = null;
    this.F = new CustomLocalization(paramList1, paramList2, paramList3);
    c();
  }
  
  DateTimeFormatter(String paramString, Locale paramLocale)
  {
    this.A = paramString;
    this.B = paramLocale;
    this.F = null;
    c();
  }
  
  private InterpretedRange a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.G.iterator();
    while (localIterator.hasNext())
    {
      InterpretedRange localInterpretedRange = (InterpretedRange)localIterator.next();
      if (localInterpretedRange.a == paramInt) {
        localObject = localInterpretedRange;
      }
    }
    return (InterpretedRange)localObject;
  }
  
  private String a(Integer paramInteger)
  {
    for (paramInteger = a(paramInteger); paramInteger.length() < 9; paramInteger = "0" + paramInteger) {}
    return paramInteger;
  }
  
  private String a(Object paramObject)
  {
    String str = "";
    if (paramObject != null) {
      str = String.valueOf(paramObject);
    }
    return str;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 1;
    while (i1 <= paramString.length())
    {
      localStringBuilder.append("@");
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private String a(String paramString, int paramInt)
  {
    String str1 = paramString;
    String str2 = str1;
    if (Util.a(paramString))
    {
      str2 = str1;
      if (paramString.length() >= paramInt) {
        str2 = paramString.substring(0, paramInt);
      }
    }
    return str2;
  }
  
  private String a(String paramString, DateTime paramDateTime)
  {
    if ("YYYY".equals(paramString)) {
      return a(paramDateTime.getYear());
    }
    if ("YY".equals(paramString)) {
      return b(a(paramDateTime.getYear()));
    }
    if ("MMMM".equals(paramString)) {
      return b(Integer.valueOf(paramDateTime.getMonth().intValue()));
    }
    if ("MMM".equals(paramString)) {
      return d(b(Integer.valueOf(paramDateTime.getMonth().intValue())));
    }
    if ("MM".equals(paramString)) {
      return c(a(paramDateTime.getMonth()));
    }
    if ("M".equals(paramString)) {
      return a(paramDateTime.getMonth());
    }
    if ("DD".equals(paramString)) {
      return c(a(paramDateTime.getDay()));
    }
    if ("D".equals(paramString)) {
      return a(paramDateTime.getDay());
    }
    if ("WWWW".equals(paramString)) {
      return e(Integer.valueOf(paramDateTime.getWeekDay().intValue()));
    }
    if ("WWW".equals(paramString)) {
      return d(e(Integer.valueOf(paramDateTime.getWeekDay().intValue())));
    }
    if ("hh".equals(paramString)) {
      return c(a(paramDateTime.getHour()));
    }
    if ("h".equals(paramString)) {
      return a(paramDateTime.getHour());
    }
    if ("h12".equals(paramString)) {
      return a(h(paramDateTime.getHour()));
    }
    if ("hh12".equals(paramString)) {
      return c(a(h(paramDateTime.getHour())));
    }
    if ("a".equals(paramString)) {
      return i(Integer.valueOf(paramDateTime.getHour().intValue()));
    }
    if ("mm".equals(paramString)) {
      return c(a(paramDateTime.getMinute()));
    }
    if ("m".equals(paramString)) {
      return a(paramDateTime.getMinute());
    }
    if ("ss".equals(paramString)) {
      return c(a(paramDateTime.getSecond()));
    }
    if ("s".equals(paramString)) {
      return a(paramDateTime.getSecond());
    }
    if (paramString.startsWith("f"))
    {
      if (x.matcher(paramString).matches()) {
        return a(a(paramDateTime.getNanoseconds()), paramString.length());
      }
      throw new IllegalArgumentException("Unknown token in date formatting pattern: " + paramString);
    }
    throw new IllegalArgumentException("Unknown token in date formatting pattern: " + paramString);
  }
  
  private void a()
  {
    Matcher localMatcher = b.matcher(this.A);
    while (localMatcher.find())
    {
      EscapedRange localEscapedRange = new EscapedRange(null);
      localEscapedRange.a = localMatcher.start();
      localEscapedRange.b = (localMatcher.end() - 1);
      this.H.add(localEscapedRange);
    }
  }
  
  private boolean a(InterpretedRange paramInterpretedRange)
  {
    boolean bool2 = false;
    Iterator localIterator = this.H.iterator();
    EscapedRange localEscapedRange;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localEscapedRange = (EscapedRange)localIterator.next();
    } while ((localEscapedRange.a > paramInterpretedRange.a) || (paramInterpretedRange.a > localEscapedRange.b));
    boolean bool1 = true;
    return bool1;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < this.A.length())
    {
      String str = b(i1);
      InterpretedRange localInterpretedRange = a(i1);
      int i2;
      if (localInterpretedRange != null)
      {
        localStringBuilder.append(localInterpretedRange.c);
        i2 = localInterpretedRange.b;
      }
      for (;;)
      {
        i1 = i2 + 1;
        break;
        i2 = i1;
        if (!"|".equals(str))
        {
          localStringBuilder.append(str);
          i2 = i1;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private String b(int paramInt)
  {
    String str = "";
    if (this.A.length() >= paramInt + 1) {
      str = this.A.substring(paramInt, paramInt + 1);
    }
    return str;
  }
  
  private String b(Integer paramInteger)
  {
    String str = "";
    if (paramInteger != null)
    {
      if (this.F != null) {
        str = c(paramInteger);
      }
    }
    else {
      return str;
    }
    if (this.B != null) {
      return d(paramInteger);
    }
    throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.a(this.A));
  }
  
  private String b(String paramString)
  {
    String str = "";
    if (Util.a(paramString)) {
      str = paramString.substring(2);
    }
    return str;
  }
  
  private void b(DateTime paramDateTime)
  {
    String str1 = this.A;
    Iterator localIterator = z.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Matcher localMatcher = Pattern.compile(str2).matcher(str1);
      while (localMatcher.find())
      {
        InterpretedRange localInterpretedRange = new InterpretedRange(null);
        localInterpretedRange.a = localMatcher.start();
        localInterpretedRange.b = (localMatcher.end() - 1);
        if (!a(localInterpretedRange))
        {
          localInterpretedRange.c = a(localMatcher.group(), paramDateTime);
          this.G.add(localInterpretedRange);
        }
      }
      str1 = str1.replace(str2, a(str2));
    }
  }
  
  private String c(Integer paramInteger)
  {
    if ((this.F == null) || (this.F.a == null)) {
      return "";
    }
    return (String)this.F.a.get(paramInteger.intValue() - 1);
  }
  
  private String c(String paramString)
  {
    String str1 = paramString;
    String str2 = str1;
    if (Util.a(paramString))
    {
      str2 = str1;
      if (paramString.length() == 1) {
        str2 = "0" + str1;
      }
    }
    return str2;
  }
  
  private void c()
  {
    if (!Util.a(this.A)) {
      throw new IllegalArgumentException("DateTime format has no content.");
    }
  }
  
  private String d(Integer paramInteger)
  {
    if (!this.C.containsKey(this.B))
    {
      ArrayList localArrayList = new ArrayList();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMMM", this.B);
      int i1 = 0;
      while (i1 <= 11)
      {
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        localGregorianCalendar.set(1, 2000);
        localGregorianCalendar.set(2, i1);
        localGregorianCalendar.set(5, 15);
        localArrayList.add(localSimpleDateFormat.format(localGregorianCalendar.getTime()));
        i1 += 1;
      }
      this.C.put(this.B, localArrayList);
    }
    return (String)((List)this.C.get(this.B)).get(paramInteger.intValue() - 1);
  }
  
  private String d(String paramString)
  {
    String str1 = paramString;
    String str2 = str1;
    if (Util.a(paramString))
    {
      str2 = str1;
      if (paramString.length() >= 3) {
        str2 = paramString.substring(0, 3);
      }
    }
    return str2;
  }
  
  private String e(Integer paramInteger)
  {
    String str = "";
    if (paramInteger != null)
    {
      if (this.F != null) {
        str = f(paramInteger);
      }
    }
    else {
      return str;
    }
    if (this.B != null) {
      return g(paramInteger);
    }
    throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.a(this.A));
  }
  
  private String f(Integer paramInteger)
  {
    if ((this.F == null) || (this.F.b == null)) {
      return "";
    }
    return (String)this.F.b.get(paramInteger.intValue() - 1);
  }
  
  private String g(Integer paramInteger)
  {
    if (!this.D.containsKey(this.B))
    {
      ArrayList localArrayList = new ArrayList();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEEE", this.B);
      int i1 = 8;
      while (i1 <= 14)
      {
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        localGregorianCalendar.set(1, 2009);
        localGregorianCalendar.set(2, 1);
        localGregorianCalendar.set(5, i1);
        localArrayList.add(localSimpleDateFormat.format(localGregorianCalendar.getTime()));
        i1 += 1;
      }
      this.D.put(this.B, localArrayList);
    }
    return (String)((List)this.D.get(this.B)).get(paramInteger.intValue() - 1);
  }
  
  private Integer h(Integer paramInteger)
  {
    Integer localInteger1 = paramInteger;
    Integer localInteger2 = localInteger1;
    if (paramInteger != null)
    {
      if (paramInteger.intValue() != 0) {
        break label23;
      }
      localInteger2 = Integer.valueOf(12);
    }
    label23:
    do
    {
      return localInteger2;
      localInteger2 = localInteger1;
    } while (paramInteger.intValue() <= 12);
    return Integer.valueOf(paramInteger.intValue() - 12);
  }
  
  private String i(Integer paramInteger)
  {
    String str = "";
    if (paramInteger != null)
    {
      if (this.F != null) {
        str = j(paramInteger);
      }
    }
    else {
      return str;
    }
    if (this.B != null) {
      return k(paramInteger);
    }
    throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.a(this.A));
  }
  
  private String j(Integer paramInteger)
  {
    String str2 = "";
    String str1 = str2;
    if (this.F != null)
    {
      str1 = str2;
      if (this.F.c != null)
      {
        if (paramInteger.intValue() >= 12) {
          break label52;
        }
        str1 = (String)this.F.c.get(0);
      }
    }
    return str1;
    label52:
    return (String)this.F.c.get(1);
  }
  
  private String k(Integer paramInteger)
  {
    if (!this.E.containsKey(this.B))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(l(Integer.valueOf(6)));
      localArrayList.add(l(Integer.valueOf(18)));
      this.E.put(this.B, localArrayList);
    }
    if (paramInteger.intValue() < 12) {
      return (String)((List)this.E.get(this.B)).get(0);
    }
    return (String)((List)this.E.get(this.B)).get(1);
  }
  
  private String l(Integer paramInteger)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("a", this.B);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(1, 2000);
    localGregorianCalendar.set(2, 6);
    localGregorianCalendar.set(5, 15);
    localGregorianCalendar.set(11, paramInteger.intValue());
    return localSimpleDateFormat.format(localGregorianCalendar.getTime());
  }
  
  String a(DateTime paramDateTime)
  {
    this.H = new ArrayList();
    this.G = new ArrayList();
    a();
    b(paramDateTime);
    return b();
  }
  
  private final class CustomLocalization
  {
    List<String> a;
    List<String> b;
    List<String> c;
    
    CustomLocalization(List<String> paramList1, List<String> paramList2)
    {
      if (paramList1.size() != 12) {
        throw new IllegalArgumentException("Your List of custom months must have size 12, but its size is " + paramList1.size());
      }
      if (paramList2.size() != 7) {
        throw new IllegalArgumentException("Your List of custom weekdays must have size 7, but its size is " + paramList2.size());
      }
      List localList;
      if (localList.size() != 2) {
        throw new IllegalArgumentException("Your List of custom a.m./p.m. indicators must have size 2, but its size is " + localList.size());
      }
      this.a = paramList1;
      this.b = paramList2;
      this.c = localList;
    }
  }
  
  private static final class EscapedRange
  {
    int a;
    int b;
  }
  
  private static final class InterpretedRange
  {
    int a;
    int b;
    String c;
    
    public String toString()
    {
      return "Start:" + this.a + " End:" + this.b + " '" + this.c + "'";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/DateTimeFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */