package com.baidu.android.pushservice.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.pushservice.f.a;
import com.baidu.android.pushservice.f.b;
import com.baidu.android.pushservice.h;

public class k
{
  private static ConnectivityManager a = null;
  
  public static boolean a(Context paramContext)
  {
    paramContext = c(paramContext);
    if (paramContext != null) {
      return paramContext.isConnectedOrConnecting();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = c(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static NetworkInfo c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = null;
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {}
      ConnectivityManager localConnectivityManager = f(paramContext);
      paramContext = localNetworkInfo;
      if (localConnectivityManager != null)
      {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        paramContext = localNetworkInfo;
        if (localNetworkInfo != null) {}
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String d(Context paramContext)
  {
    if (!a(paramContext)) {
      return "connectionless";
    }
    paramContext = c(paramContext);
    int i = -1;
    if (paramContext != null) {
      i = paramContext.getType();
    }
    switch (i)
    {
    default: 
      return "connectionless";
    case 0: 
      return "mobile";
    case 4: 
      return "mobile_dun";
    case 5: 
      return "mobile_hipri";
    case 2: 
      return "mobile_mms";
    case 3: 
      return "mobile_supl";
    case 1: 
      return "wifi";
    }
    return "wimax";
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = a(paramContext);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (!p.u(paramContext, "android.permission.INTERNET")) {}
    }
    try
    {
      paramContext = b.a(h.a(), "GET", null);
      bool1 = bool2;
      if (paramContext.b() != 0)
      {
        paramContext = paramContext.a();
        bool1 = bool2;
        if (paramContext != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool2;
  }
  
  private static ConnectivityManager f(Context paramContext)
  {
    if (paramContext == null) {
      return a;
    }
    if (a == null) {
      a = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    return a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */