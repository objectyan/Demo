package cz.msebera.android.httpclient.e.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Immutable
public class a
{
  private static final String a = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
  private static final Pattern b = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
  private static final Pattern c = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
  private static final Pattern d = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
  private static final Pattern e = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
  private static final char f = ':';
  private static final int g = 7;
  
  public static boolean a(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  public static boolean b(String paramString)
  {
    return c.matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    return d.matcher(paramString).matches();
  }
  
  public static boolean d(String paramString)
  {
    int j = 0;
    int i = 0;
    while (i < paramString.length())
    {
      int k = j;
      if (paramString.charAt(i) == ':') {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return (j <= 7) && (e.matcher(paramString).matches());
  }
  
  public static boolean e(String paramString)
  {
    return (c(paramString)) || (d(paramString));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */