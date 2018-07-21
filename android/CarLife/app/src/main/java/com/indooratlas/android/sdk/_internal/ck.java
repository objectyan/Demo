package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class ck
{
  private static ck d;
  public final String a;
  public final String b;
  public final int c;
  
  private ck(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        str = paramContext.packageName;
        this.a = str;
        if (paramContext == null) {
          break label74;
        }
        str = paramContext.versionName;
        this.b = str;
        if (paramContext == null) {
          break label80;
        }
        i = paramContext.versionCode;
        this.c = i;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
        continue;
        String str = "n/a";
        continue;
        label74:
        str = "n/a";
        continue;
        label80:
        int i = -1;
      }
    }
  }
  
  public static ck a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new ck(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */