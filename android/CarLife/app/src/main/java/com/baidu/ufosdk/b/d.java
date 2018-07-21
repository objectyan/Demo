package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.baidu.ufosdk.util.c;

public final class d
{
  private static Context a;
  private static PackageManager b;
  private static PackageInfo c;
  private static String d;
  
  public static String a()
  {
    if (a == null) {
      return "N/A";
    }
    return a.getPackageName();
  }
  
  public static void a(Context paramContext)
  {
    if (a == null)
    {
      a = paramContext;
      b = paramContext.getPackageManager();
    }
    try
    {
      c = b.getPackageInfo(a.getPackageName(), 0);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      c.a("PackageCollector.init fail.", paramContext);
    }
  }
  
  public static String b()
  {
    if (d == null)
    {
      if (c == null) {
        return "N/A";
      }
      d = c.applicationInfo.loadLabel(b).toString();
    }
    return d;
  }
  
  public static String c()
  {
    if (c == null) {
      return "N/A";
    }
    return c.versionName;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */