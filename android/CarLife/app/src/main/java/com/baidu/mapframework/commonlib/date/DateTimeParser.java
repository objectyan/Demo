package com.baidu.mapframework.commonlib.date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DateTimeParser
{
  private static final Pattern a = Pattern.compile("(\\d{1,4})-(\\d\\d)-(\\d\\d)|(\\d{1,4})-(\\d\\d)|(\\d{1,4})");
  private static final String b = "\\:";
  private static final String c = "(\\d\\d)";
  private static final String d = "9";
  private static final Integer e = Integer.valueOf("9");
  private static final Pattern f = Pattern.compile("(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)\\.(\\d{1,9})|(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)|(\\d\\d)\\:(\\d\\d)|(\\d\\d)");
  private static final String g = ":";
  private static final int h = 2;
  private Integer i;
  private Integer j;
  private Integer k;
  private Integer l;
  private Integer m;
  private Integer n;
  private Integer o;
  
  private String a(Matcher paramMatcher, int... paramVarArgs)
  {
    String str = null;
    int i2 = paramVarArgs.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        str = paramMatcher.group(paramVarArgs[i1]);
        if (str == null) {}
      }
      else
      {
        return str;
      }
      i1 += 1;
    }
  }
  
  private Parts c(String paramString)
  {
    Parts localParts = new Parts(null);
    int i2 = b(paramString);
    if ((i2 > 0) && (i2 < paramString.length())) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      localParts.a = paramString.substring(0, i2);
      localParts.b = paramString.substring(i2 + 1);
      return localParts;
    }
    if (d(paramString))
    {
      localParts.b = paramString;
      return localParts;
    }
    localParts.a = paramString;
    return localParts;
  }
  
  private boolean d(String paramString)
  {
    boolean bool = false;
    if (paramString.length() >= 2) {
      bool = ":".equals(paramString.substring(2, 3));
    }
    return bool;
  }
  
  private void e(String paramString)
  {
    Matcher localMatcher = a.matcher(paramString);
    if (localMatcher.matches())
    {
      paramString = a(localMatcher, new int[] { 1, 4, 6 });
      if (paramString != null) {
        this.i = Integer.valueOf(paramString);
      }
      paramString = a(localMatcher, new int[] { 2, 5 });
      if (paramString != null) {
        this.j = Integer.valueOf(paramString);
      }
      paramString = a(localMatcher, new int[] { 3 });
      if (paramString != null) {
        this.k = Integer.valueOf(paramString);
      }
      return;
    }
    throw new UnknownDateTimeFormat("Unexpected format for date:" + paramString);
  }
  
  private void f(String paramString)
  {
    Matcher localMatcher = f.matcher(paramString);
    if (localMatcher.matches())
    {
      paramString = a(localMatcher, new int[] { 1, 5, 8, 10 });
      if (paramString != null) {
        this.l = Integer.valueOf(paramString);
      }
      paramString = a(localMatcher, new int[] { 2, 6, 9 });
      if (paramString != null) {
        this.m = Integer.valueOf(paramString);
      }
      paramString = a(localMatcher, new int[] { 3, 7 });
      if (paramString != null) {
        this.n = Integer.valueOf(paramString);
      }
      paramString = a(localMatcher, new int[] { 4 });
      if (paramString != null) {
        this.o = Integer.valueOf(g(paramString));
      }
      return;
    }
    throw new UnknownDateTimeFormat("Unexpected format for time:" + paramString);
  }
  
  private String g(String paramString)
  {
    paramString = new StringBuilder(paramString);
    while (paramString.length() < e.intValue()) {
      paramString.append("0");
    }
    return paramString.toString();
  }
  
  DateTime a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("DateTime string is null");
    }
    paramString = c(paramString.trim());
    if (paramString.a())
    {
      e(paramString.a);
      f(paramString.b);
    }
    for (;;)
    {
      return new DateTime(this.i, this.j, this.k, this.l, this.m, this.n, this.o);
      if (paramString.b()) {
        e(paramString.a);
      } else if (paramString.c()) {
        f(paramString.b);
      }
    }
  }
  
  int b(String paramString)
  {
    int i2 = paramString.indexOf(" ");
    int i1 = i2;
    if (i2 == -1) {
      i1 = paramString.indexOf("T");
    }
    return i1;
  }
  
  private class Parts
  {
    String a;
    String b;
    
    private Parts() {}
    
    boolean a()
    {
      return (this.a != null) && (this.b != null);
    }
    
    boolean b()
    {
      return this.b == null;
    }
    
    boolean c()
    {
      return this.a == null;
    }
  }
  
  static final class UnknownDateTimeFormat
    extends RuntimeException
  {
    private static final long a = -7179421566055773208L;
    
    UnknownDateTimeFormat(String paramString)
    {
      super();
    }
    
    UnknownDateTimeFormat(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/DateTimeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */