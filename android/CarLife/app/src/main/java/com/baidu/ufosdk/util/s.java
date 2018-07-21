package com.baidu.ufosdk.util;

import android.content.Context;
import android.content.pm.PackageManager;

public final class s
{
  private static PackageManager a;
  private static Context b;
  
  public static void a(Context paramContext)
  {
    b = paramContext;
    paramContext = paramContext.getPackageManager();
    a = paramContext;
    if (paramContext == null) {
      c.d("PermissionUtil#init fail to get PackageManager.");
    }
  }
  
  public static boolean a(String paramString)
  {
    if (a == null) {
      c.d("PermissionUtil fail to get PackageManager.");
    }
    for (;;)
    {
      return false;
      try
      {
        int i = a.checkPermission(paramString, b.getPackageName());
        if (i == 0) {
          return true;
        }
      }
      catch (RuntimeException paramString)
      {
        c.a("PermissionUtil#hasPermission failed.", paramString);
      }
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */