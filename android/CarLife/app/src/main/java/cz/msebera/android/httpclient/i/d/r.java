package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.g.b;
import java.util.Date;
import java.util.TimeZone;

@Deprecated
@Immutable
public final class r
{
  public static final String a = "EEE, dd MMM yyyy HH:mm:ss zzz";
  public static final String b = "EEE, dd-MMM-yy HH:mm:ss zzz";
  public static final String c = "EEE MMM d HH:mm:ss yyyy";
  public static final TimeZone d = TimeZone.getTimeZone("GMT");
  
  public static String a(Date paramDate)
  {
    return b.a(paramDate);
  }
  
  public static String a(Date paramDate, String paramString)
  {
    return b.a(paramDate, paramString);
  }
  
  public static Date a(String paramString)
    throws q
  {
    return a(paramString, null, null);
  }
  
  public static Date a(String paramString, String[] paramArrayOfString)
    throws q
  {
    return a(paramString, paramArrayOfString, null);
  }
  
  public static Date a(String paramString, String[] paramArrayOfString, Date paramDate)
    throws q
  {
    paramArrayOfString = b.a(paramString, paramArrayOfString, paramDate);
    if (paramArrayOfString == null) {
      throw new q("Unable to parse the date " + paramString);
    }
    return paramArrayOfString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */