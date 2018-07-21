package com.indooratlas.android.sdk._internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public final class af
{
  public static final String a = ee.a("BackendWire");
  
  public static String a()
  {
    Date localDate = v.d().b();
    return b().format(localDate);
  }
  
  public static Date a(String paramString)
    throws ParseException
  {
    return b().parse(paramString);
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.toString().trim().equals(""));
  }
  
  private static DateFormat b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(2, "UTC"));
    return localSimpleDateFormat;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */