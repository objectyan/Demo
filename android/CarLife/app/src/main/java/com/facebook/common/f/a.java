package com.facebook.common.f;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.g;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class a
{
  public static final Map<String, String> a = g.a("mkv", "video/x-matroska");
  
  public static boolean a(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }
  
  public static boolean b(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("video/"));
  }
  
  @Nullable
  public static String c(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      paramString = null;
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = paramString.toLowerCase(Locale.US);
      str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
      paramString = str1;
    } while (str1 != null);
    return (String)a.get(str2);
  }
  
  public static boolean d(String paramString)
  {
    return a.containsValue(paramString);
  }
  
  @Nullable
  private static String e(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i == paramString.length() - 1)) {
      return null;
    }
    return paramString.substring(i + 1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/common/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */