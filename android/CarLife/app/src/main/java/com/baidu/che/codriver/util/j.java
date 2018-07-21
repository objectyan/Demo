package com.baidu.che.codriver.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class j
{
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0);
      bool1 = bool2;
      if (paramContext != null) {
        bool1 = paramContext.isAvailable();
      }
    }
    return bool1;
  }
  
  public static int d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isAvailable())) {
        return paramContext.getType();
      }
    }
    return -1;
  }
  
  public static int e(Context paramContext)
  {
    int i = 0;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return 0;
    }
    int j = localNetworkInfo.getType();
    if (j == 1) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (j == 0)
      {
        i = localNetworkInfo.getSubtype();
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if ((i == 3) && (!paramContext.isNetworkRoaming())) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */