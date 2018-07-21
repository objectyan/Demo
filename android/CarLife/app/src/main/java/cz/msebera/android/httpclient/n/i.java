package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@ThreadSafe
public class i
{
  public static final String a = "EEE, dd MMM yyyy HH:mm:ss zzz";
  public static final TimeZone b = TimeZone.getTimeZone("GMT");
  @GuardedBy("this")
  private final DateFormat c = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
  @GuardedBy("this")
  private long d = 0L;
  @GuardedBy("this")
  private String e = null;
  
  public i()
  {
    this.c.setTimeZone(b);
  }
  
  public String a()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (l - this.d > 1000L)
      {
        this.e = this.c.format(new Date(l));
        this.d = l;
      }
      String str = this.e;
      return str;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */