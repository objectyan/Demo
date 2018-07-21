package b;

import b.a.c;
import b.a.d.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class m
{
  private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private final String e;
  private final String f;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  m(a parama)
  {
    if (parama.a == null) {
      throw new NullPointerException("builder.name == null");
    }
    if (parama.b == null) {
      throw new NullPointerException("builder.value == null");
    }
    if (parama.d == null) {
      throw new NullPointerException("builder.domain == null");
    }
    this.e = parama.a;
    this.f = parama.b;
    this.g = parama.c;
    this.h = parama.d;
    this.i = parama.e;
    this.j = parama.f;
    this.k = parama.g;
    this.l = parama.h;
    this.m = parama.i;
  }
  
  private m(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int n = paramString.charAt(paramInt1);
      if (((n < 32) && (n != 9)) || (n >= 127) || ((n >= 48) && (n <= 57)) || ((n >= 97) && (n <= 122)) || ((n >= 65) && (n <= 90)) || (n == 58))
      {
        n = 1;
        if (paramBoolean) {
          break label107;
        }
      }
      label107:
      for (int i1 = 1;; i1 = 0)
      {
        if (n != i1) {
          break label113;
        }
        return paramInt1;
        n = 0;
        break;
      }
      label113:
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  private static long a(String paramString)
  {
    long l1 = Long.MIN_VALUE;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
      l2 = l1;
      if (l1 <= 0L) {
        l2 = Long.MIN_VALUE;
      }
      return l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-")) {}
        for (;;)
        {
          return l1;
          l1 = Long.MAX_VALUE;
        }
      }
      throw localNumberFormatException;
    }
  }
  
  private static long a(String paramString, int paramInt1, int paramInt2)
  {
    int i5 = a(paramString, paramInt1, paramInt2, false);
    int i4 = -1;
    int i3 = -1;
    int i1 = -1;
    int i2 = -1;
    int n = -1;
    paramInt1 = -1;
    Matcher localMatcher = d.matcher(paramString);
    if (i5 < paramInt2)
    {
      int i11 = a(paramString, i5 + 1, paramInt2, true);
      localMatcher.region(i5, i11);
      int i10;
      int i7;
      int i8;
      int i6;
      int i9;
      if ((i4 == -1) && (localMatcher.usePattern(d).matches()))
      {
        i10 = Integer.parseInt(localMatcher.group(1));
        i5 = Integer.parseInt(localMatcher.group(2));
        i7 = Integer.parseInt(localMatcher.group(3));
        i8 = paramInt1;
        i6 = n;
        i9 = i2;
      }
      for (;;)
      {
        i11 = a(paramString, i11 + 1, paramInt2, false);
        i2 = i9;
        i4 = i10;
        i3 = i5;
        n = i6;
        i1 = i7;
        paramInt1 = i8;
        i5 = i11;
        break;
        if ((i2 == -1) && (localMatcher.usePattern(c).matches()))
        {
          i9 = Integer.parseInt(localMatcher.group(1));
          i10 = i4;
          i5 = i3;
          i6 = n;
          i7 = i1;
          i8 = paramInt1;
        }
        else if ((n == -1) && (localMatcher.usePattern(b).matches()))
        {
          String str = localMatcher.group(1).toLowerCase(Locale.US);
          i6 = b.pattern().indexOf(str) / 4;
          i9 = i2;
          i10 = i4;
          i5 = i3;
          i7 = i1;
          i8 = paramInt1;
        }
        else
        {
          i9 = i2;
          i10 = i4;
          i5 = i3;
          i6 = n;
          i7 = i1;
          i8 = paramInt1;
          if (paramInt1 == -1)
          {
            i9 = i2;
            i10 = i4;
            i5 = i3;
            i6 = n;
            i7 = i1;
            i8 = paramInt1;
            if (localMatcher.usePattern(a).matches())
            {
              i8 = Integer.parseInt(localMatcher.group(1));
              i9 = i2;
              i10 = i4;
              i5 = i3;
              i6 = n;
              i7 = i1;
            }
          }
        }
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 < 1601) {
      throw new IllegalArgumentException();
    }
    if (n == -1) {
      throw new IllegalArgumentException();
    }
    if ((i2 < 1) || (i2 > 31)) {
      throw new IllegalArgumentException();
    }
    if ((i4 < 0) || (i4 > 23)) {
      throw new IllegalArgumentException();
    }
    if ((i3 < 0) || (i3 > 59)) {
      throw new IllegalArgumentException();
    }
    if ((i1 < 0) || (i1 > 59)) {
      throw new IllegalArgumentException();
    }
    paramString = new GregorianCalendar(c.f);
    paramString.setLenient(false);
    paramString.set(1, paramInt1);
    paramString.set(2, n - 1);
    paramString.set(5, i2);
    paramString.set(11, i4);
    paramString.set(12, i3);
    paramString.set(13, i1);
    paramString.set(14, 0);
    return paramString.getTimeInMillis();
  }
  
  static m a(long paramLong, u paramu, String paramString)
  {
    int i1 = paramString.length();
    int n = c.a(paramString, 0, i1, ';');
    int i2 = c.a(paramString, 0, n, '=');
    if (i2 == n) {
      return null;
    }
    String str1 = c.c(paramString, 0, i2);
    if (str1.isEmpty()) {
      return null;
    }
    String str2 = c.c(paramString, i2 + 1, n);
    l1 = 253402300799999L;
    l2 = -1L;
    localObject2 = null;
    localObject1 = null;
    bool4 = false;
    boolean bool5 = false;
    bool2 = true;
    bool3 = false;
    n += 1;
    String str3;
    Object localObject3;
    if (n < i1)
    {
      i2 = c.a(paramString, n, i1, ';');
      int i3 = c.a(paramString, n, i2, '=');
      str3 = c.c(paramString, n, i3);
      if (i3 < i2)
      {
        localObject3 = c.c(paramString, i3 + 1, i2);
        label162:
        if (!str3.equalsIgnoreCase("expires")) {
          break label252;
        }
      }
    }
    for (;;)
    {
      try
      {
        l3 = a((String)localObject3, 0, ((String)localObject3).length());
        bool1 = true;
        l4 = l2;
        bool7 = bool2;
        bool6 = bool4;
        localObject7 = localObject1;
        localObject3 = localObject2;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        label252:
        long l3 = l1;
        Object localObject6 = localObject2;
        Object localObject7 = localObject1;
        boolean bool6 = bool4;
        boolean bool7 = bool2;
        boolean bool1 = bool3;
        long l4 = l2;
        continue;
      }
      n = i2 + 1;
      l1 = l3;
      localObject2 = localObject3;
      localObject1 = localObject7;
      bool4 = bool6;
      bool2 = bool7;
      bool3 = bool1;
      l2 = l4;
      break;
      localObject3 = "";
      break label162;
      if (str3.equalsIgnoreCase("max-age")) {}
      try
      {
        l4 = a((String)localObject3);
        bool1 = true;
        l3 = l1;
        localObject3 = localObject2;
        localObject7 = localObject1;
        bool6 = bool4;
        bool7 = bool2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l3 = l1;
        localObject4 = localObject2;
        localObject7 = localObject1;
        bool6 = bool4;
        bool7 = bool2;
        bool1 = bool3;
        l4 = l2;
      }
      if (str3.equalsIgnoreCase("domain")) {}
      try
      {
        localObject3 = b((String)localObject3);
        bool7 = false;
        l3 = l1;
        localObject7 = localObject1;
        bool6 = bool4;
        bool1 = bool3;
        l4 = l2;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        Object localObject4;
        l3 = l1;
        Object localObject5 = localObject2;
        localObject7 = localObject1;
        bool6 = bool4;
        bool7 = bool2;
        bool1 = bool3;
        l4 = l2;
      }
      if (str3.equalsIgnoreCase("path"))
      {
        localObject7 = localObject3;
        l3 = l1;
        localObject3 = localObject2;
        bool6 = bool4;
        bool7 = bool2;
        bool1 = bool3;
        l4 = l2;
      }
      else if (str3.equalsIgnoreCase("secure"))
      {
        bool6 = true;
        l3 = l1;
        localObject3 = localObject2;
        localObject7 = localObject1;
        bool7 = bool2;
        bool1 = bool3;
        l4 = l2;
      }
      else
      {
        l3 = l1;
        localObject3 = localObject2;
        localObject7 = localObject1;
        bool6 = bool4;
        bool7 = bool2;
        bool1 = bool3;
        l4 = l2;
        if (str3.equalsIgnoreCase("httponly"))
        {
          bool5 = true;
          l3 = l1;
          localObject3 = localObject2;
          localObject7 = localObject1;
          bool6 = bool4;
          bool7 = bool2;
          bool1 = bool3;
          l4 = l2;
          continue;
          if (l2 == Long.MIN_VALUE)
          {
            l1 = Long.MIN_VALUE;
            if (localObject2 == null)
            {
              localObject3 = paramu.i();
              if (localObject1 != null)
              {
                paramString = (String)localObject1;
                if (((String)localObject1).startsWith("/")) {}
              }
              else
              {
                paramu = paramu.l();
                n = paramu.lastIndexOf('/');
                if (n == 0) {
                  continue;
                }
                paramString = paramu.substring(0, n);
              }
              return new m(str1, str2, l1, (String)localObject3, paramString, bool4, bool5, bool2, bool3);
            }
          }
          else
          {
            if (l2 == -1L) {
              continue;
            }
            if (l2 <= 9223372036854775L)
            {
              l1 = l2 * 1000L;
              l2 = paramLong + l1;
              if (l2 >= paramLong)
              {
                l1 = l2;
                if (l2 <= 253402300799999L) {
                  continue;
                }
              }
              l1 = 253402300799999L;
              continue;
            }
            l1 = Long.MAX_VALUE;
            continue;
          }
          localObject3 = localObject2;
          if (!b(paramu, (String)localObject2))
          {
            return null;
            paramString = "/";
            continue;
          }
        }
      }
    }
  }
  
  public static m a(u paramu, String paramString)
  {
    return a(System.currentTimeMillis(), paramu, paramString);
  }
  
  public static List<m> a(u paramu, t paramt)
  {
    List localList = paramt.c("Set-Cookie");
    paramt = null;
    int n = 0;
    int i1 = localList.size();
    if (n < i1)
    {
      m localm = a(paramu, (String)localList.get(n));
      if (localm == null) {}
      for (;;)
      {
        n += 1;
        break;
        Object localObject = paramt;
        if (paramt == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localm);
        paramt = (t)localObject;
      }
    }
    if (paramt != null) {
      return Collections.unmodifiableList(paramt);
    }
    return Collections.emptyList();
  }
  
  private static String b(String paramString)
  {
    if (paramString.endsWith(".")) {
      throw new IllegalArgumentException();
    }
    String str = paramString;
    if (paramString.startsWith(".")) {
      str = paramString.substring(1);
    }
    paramString = c.b(str);
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    return paramString;
  }
  
  private static boolean b(u paramu, String paramString)
  {
    paramu = paramu.i();
    if (paramu.equals(paramString)) {}
    while ((paramu.endsWith(paramString)) && (paramu.charAt(paramu.length() - paramString.length() - 1) == '.') && (!c.c(paramu))) {
      return true;
    }
    return false;
  }
  
  private static boolean c(u paramu, String paramString)
  {
    paramu = paramu.l();
    if (paramu.equals(paramString)) {}
    while ((paramu.startsWith(paramString)) && ((paramString.endsWith("/")) || (paramu.charAt(paramString.length()) == '/'))) {
      return true;
    }
    return false;
  }
  
  public String a()
  {
    return this.e;
  }
  
  String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('=');
    localStringBuilder.append(this.f);
    if (this.l)
    {
      if (this.g != Long.MIN_VALUE) {
        break label145;
      }
      localStringBuilder.append("; max-age=0");
    }
    for (;;)
    {
      if (!this.m)
      {
        localStringBuilder.append("; domain=");
        if (paramBoolean) {
          localStringBuilder.append(".");
        }
        localStringBuilder.append(this.h);
      }
      localStringBuilder.append("; path=").append(this.i);
      if (this.j) {
        localStringBuilder.append("; secure");
      }
      if (this.k) {
        localStringBuilder.append("; httponly");
      }
      return localStringBuilder.toString();
      label145:
      localStringBuilder.append("; expires=").append(d.a(new Date(this.g)));
    }
  }
  
  public boolean a(u paramu)
  {
    boolean bool;
    if (this.m)
    {
      bool = paramu.i().equals(this.h);
      if (bool) {
        break label37;
      }
    }
    label37:
    while ((!c(paramu, this.i)) || ((this.j) && (!paramu.d())))
    {
      return false;
      bool = b(paramu, this.h);
      break;
    }
    return true;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public long d()
  {
    return this.g;
  }
  
  public boolean e()
  {
    return this.m;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof m)) {}
    do
    {
      return false;
      paramObject = (m)paramObject;
    } while ((!((m)paramObject).e.equals(this.e)) || (!((m)paramObject).f.equals(this.f)) || (!((m)paramObject).h.equals(this.h)) || (!((m)paramObject).i.equals(this.i)) || (((m)paramObject).g != this.g) || (((m)paramObject).j != this.j) || (((m)paramObject).k != this.k) || (((m)paramObject).l != this.l) || (((m)paramObject).m != this.m));
    return true;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public boolean h()
  {
    return this.k;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = this.e.hashCode();
    int i5 = this.f.hashCode();
    int i6 = this.h.hashCode();
    int i7 = this.i.hashCode();
    int i8 = (int)(this.g ^ this.g >>> 32);
    int n;
    int i1;
    label72:
    int i2;
    if (this.j)
    {
      n = 0;
      if (!this.k) {
        break label145;
      }
      i1 = 0;
      if (!this.l) {
        break label150;
      }
      i2 = 0;
      label81:
      if (!this.m) {
        break label155;
      }
    }
    for (;;)
    {
      return ((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
      n = 1;
      break;
      label145:
      i1 = 1;
      break label72;
      label150:
      i2 = 1;
      break label81;
      label155:
      i3 = 1;
    }
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public String toString()
  {
    return a(false);
  }
  
  public static final class a
  {
    String a;
    String b;
    long c = 253402300799999L;
    String d;
    String e = "/";
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    
    private a a(String paramString, boolean paramBoolean)
    {
      if (paramString == null) {
        throw new NullPointerException("domain == null");
      }
      String str = c.b(paramString);
      if (str == null) {
        throw new IllegalArgumentException("unexpected domain: " + paramString);
      }
      this.d = str;
      this.i = paramBoolean;
      return this;
    }
    
    public a a()
    {
      this.f = true;
      return this;
    }
    
    public a a(long paramLong)
    {
      long l = paramLong;
      if (paramLong <= 0L) {
        l = Long.MIN_VALUE;
      }
      paramLong = l;
      if (l > 253402300799999L) {
        paramLong = 253402300799999L;
      }
      this.c = paramLong;
      this.h = true;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("name == null");
      }
      if (!paramString.trim().equals(paramString)) {
        throw new IllegalArgumentException("name is not trimmed");
      }
      this.a = paramString;
      return this;
    }
    
    public a b()
    {
      this.g = true;
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("value == null");
      }
      if (!paramString.trim().equals(paramString)) {
        throw new IllegalArgumentException("value is not trimmed");
      }
      this.b = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      return a(paramString, false);
    }
    
    public m c()
    {
      return new m(this);
    }
    
    public a d(String paramString)
    {
      return a(paramString, true);
    }
    
    public a e(String paramString)
    {
      if (!paramString.startsWith("/")) {
        throw new IllegalArgumentException("path must start with '/'");
      }
      this.e = paramString;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */