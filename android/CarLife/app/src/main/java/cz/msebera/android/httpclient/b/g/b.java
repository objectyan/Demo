package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

@Immutable
public final class b
{
  public static final String a = "EEE, dd MMM yyyy HH:mm:ss zzz";
  public static final String b = "EEE, dd-MMM-yy HH:mm:ss zzz";
  public static final String c = "EEE MMM d HH:mm:ss yyyy";
  public static final TimeZone d;
  private static final String[] e = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private static final Date f;
  
  static
  {
    d = TimeZone.getTimeZone("GMT");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(d);
    localCalendar.set(2000, 0, 1, 0, 0, 0);
    localCalendar.set(14, 0);
    f = localCalendar.getTime();
  }
  
  public static String a(Date paramDate)
  {
    return a(paramDate, "EEE, dd MMM yyyy HH:mm:ss zzz");
  }
  
  public static String a(Date paramDate, String paramString)
  {
    a.a(paramDate, "Date");
    a.a(paramString, "Pattern");
    return a.a(paramString).format(paramDate);
  }
  
  public static Date a(String paramString)
  {
    return a(paramString, null, null);
  }
  
  public static Date a(String paramString, String[] paramArrayOfString)
  {
    return a(paramString, paramArrayOfString, null);
  }
  
  public static Date a(String paramString, String[] paramArrayOfString, Date paramDate)
  {
    a.a(paramString, "Date value");
    label15:
    Object localObject1;
    int j;
    int i;
    if (paramArrayOfString != null)
    {
      if (paramDate == null) {
        break label134;
      }
      localObject1 = paramString;
      paramString = (String)localObject1;
      if (((String)localObject1).length() > 1)
      {
        paramString = (String)localObject1;
        if (((String)localObject1).startsWith("'"))
        {
          paramString = (String)localObject1;
          if (((String)localObject1).endsWith("'")) {
            paramString = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
          }
        }
      }
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label148;
      }
      Object localObject2 = a.a(paramArrayOfString[i]);
      ((SimpleDateFormat)localObject2).set2DigitYearStart(paramDate);
      localObject1 = new ParsePosition(0);
      localObject2 = ((SimpleDateFormat)localObject2).parse(paramString, (ParsePosition)localObject1);
      if (((ParsePosition)localObject1).getIndex() != 0)
      {
        return (Date)localObject2;
        paramArrayOfString = e;
        break;
        label134:
        paramDate = f;
        break label15;
      }
      i += 1;
    }
    label148:
    return null;
  }
  
  public static void a() {}
  
  static final class a
  {
    private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> a = new ThreadLocal()
    {
      protected SoftReference<Map<String, SimpleDateFormat>> a()
      {
        return new SoftReference(new HashMap());
      }
    };
    
    public static SimpleDateFormat a(String paramString)
    {
      Object localObject2 = (Map)((SoftReference)a.get()).get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        a.set(new SoftReference(localObject1));
      }
      SimpleDateFormat localSimpleDateFormat = (SimpleDateFormat)((Map)localObject1).get(paramString);
      localObject2 = localSimpleDateFormat;
      if (localSimpleDateFormat == null)
      {
        localObject2 = new SimpleDateFormat(paramString, Locale.US);
        ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
        ((Map)localObject1).put(paramString, localObject2);
      }
      return (SimpleDateFormat)localObject2;
    }
    
    public static void a()
    {
      a.remove();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */