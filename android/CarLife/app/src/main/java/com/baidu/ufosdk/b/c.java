package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public final class c
{
  private static TelephonyManager a;
  private static ConnectivityManager b;
  
  public static String a(Context paramContext)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      try
      {
        if (b == null) {
          b = (ConnectivityManager)paramContext.getSystemService("connectivity");
        }
        localObject = b.getActiveNetworkInfo();
        if (localObject == null)
        {
          com.baidu.ufosdk.util.c.d("NetworkCollector: Couldn't get NetworkInfo : " + paramContext.getPackageName());
          return "N/A";
        }
        if (((NetworkInfo)localObject).isConnected()) {
          continue;
        }
        localStringBuilder1.append("type: none\n");
      }
      catch (RuntimeException localRuntimeException)
      {
        Object localObject;
        StringBuilder localStringBuilder2;
        com.baidu.ufosdk.util.c.a("NetworkCollector: Couldn't get NetworkInfo : " + paramContext.getPackageName(), localRuntimeException);
        continue;
        String str = "no";
        continue;
      }
      return localStringBuilder1.toString();
      localStringBuilder1.append("type: ").append(((NetworkInfo)localObject).getTypeName()).append("\n");
      if (((NetworkInfo)localObject).getType() == 0)
      {
        localStringBuilder1.append("subType: ").append(((NetworkInfo)localObject).getSubtypeName()).append("\n");
        if (a == null) {
          a = (TelephonyManager)paramContext.getSystemService("phone");
        }
        localStringBuilder2 = localStringBuilder1.append("isRoaming: ");
        if (!a.isNetworkRoaming()) {
          continue;
        }
        localObject = "yes";
        localStringBuilder2.append((String)localObject).append("\n");
      }
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String b(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = (ConnectivityManager)paramContext.getSystemService("connectivity");
      }
      paramContext = b.getActiveNetworkInfo();
      if (paramContext == null)
      {
        com.baidu.ufosdk.util.c.d("getNetworkType fail, getActiveNetworkInfo() is null.");
        return "UNKNOWN";
      }
      boolean bool = paramContext.isConnected();
      if (!bool) {
        return "NONE";
      }
      paramContext = paramContext.getTypeName().toUpperCase();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      com.baidu.ufosdk.util.c.a("getNetworkType fail,", paramContext);
    }
    return "UNKNOWN";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */