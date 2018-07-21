package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.platform.comjni.engine.NAEngine;

public class NetworkUtil
{
  public static final int NETYPE_2G = 2;
  public static final int NETYPE_3G = 3;
  public static final int NETYPE_4G = 4;
  public static final int NETYPE_4G_UNKNOWN = 10;
  public static final int NETYPE_MOBILE_3G = 8;
  public static final int NETYPE_MOBILE_UNICOM_2G = 6;
  public static final int NETYPE_NOCON = -1;
  public static final int NETYPE_TELECOM_2G = 5;
  public static final int NETYPE_TELECOM_3G = 7;
  public static final int NETYPE_UNICOM_3G = 9;
  public static final int NETYPE_UNKNOWN = 0;
  public static final int NETYPE_WIFI = 1;
  public static String mProxyHost = "";
  public static int mProxyPort = 0;
  public static boolean mUseProxy = false;
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    boolean bool = false;
    if (paramNetworkInfo != null) {}
    try
    {
      if (1 == paramNetworkInfo.getType())
      {
        bool = paramNetworkInfo.isConnected();
        if (bool)
        {
          bool = true;
          return bool;
        }
      }
      return false;
    }
    catch (Exception paramNetworkInfo) {}
    return false;
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static NetworkInfo[] getAllNetworkInfo(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getAllNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getCurrentNetMode(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
    int i;
    if (localNetworkInfo != null) {
      if (localNetworkInfo.getType() == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      return Integer.toString(i);
      switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
      {
      default: 
        i = 0;
        break;
      case 7: 
      case 11: 
        i = 2;
        break;
      case 13: 
        i = 4;
        break;
      case 4: 
        i = 5;
        break;
      case 1: 
      case 2: 
        i = 6;
        break;
      case 5: 
      case 6: 
      case 12: 
        i = 7;
        break;
      case 8: 
        i = 8;
        break;
      case 3: 
      case 9: 
      case 10: 
      case 15: 
        i = 9;
        break;
      case 14: 
        i = 3;
        continue;
        i = -1;
      }
    }
  }
  
  public static String getNetworkOperatorInfo(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkOperator();
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          paramContext = new StringBuilder(paramContext);
          paramContext.insert(3, ":");
          paramContext = paramContext.toString();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return "";
        }
      }
    }
    return "";
  }
  
  public static int getNetworkOperatorType(Context paramContext)
  {
    paramContext = getNetworkOperatorInfo(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      if ((paramContext.startsWith("460:00")) || (paramContext.startsWith("460:02"))) {
        return 0;
      }
      if (paramContext.startsWith("460:01")) {
        return 1;
      }
      if (paramContext.startsWith("460:03")) {
        return 2;
      }
    }
    return -1;
  }
  
  public static boolean initConnectState()
  {
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      if (isWifiConnected(paramContext)) {
        return true;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool2 = paramContext.isConnectedOrConnecting();
        if (bool2) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    bool2 = false;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    bool1 = bool2;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        bool1 = bool2;
        if (paramContext != null)
        {
          if (1 != paramContext.getType()) {
            continue;
          }
          bool1 = paramContext.isConnected();
          if (!bool1) {
            continue;
          }
          bool1 = true;
        }
      }
      catch (Exception paramContext)
      {
        bool1 = bool2;
        continue;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean isWifiState(Context paramContext)
  {
    if (paramContext == null) {}
    int i;
    do
    {
      return false;
      WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      int j = 1;
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          i = j;
          if (paramContext.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            i = localWifiManager.getWifiState();
          }
        }
        else
        {
          i = localWifiManager.getWifiState();
        }
      }
      catch (Exception paramContext)
      {
        i = j;
      }
    } while (i != 3);
    return true;
  }
  
  public static void updateNetworkProxy(Context paramContext)
  {
    mUseProxy = false;
    paramContext = getActiveNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.isAvailable()))
    {
      String str = paramContext.getTypeName().toLowerCase();
      if ((str.equals("wifi")) && (paramContext.isConnected()))
      {
        NAEngine.setProxyInfo(null, 0);
        return;
      }
      if ((str.equals("mobile")) || ((str.equals("wifi")) && (!a(paramContext))))
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext == null) {
          break label224;
        }
        paramContext = paramContext.toLowerCase();
        if ((!paramContext.startsWith("cmwap")) && (!paramContext.startsWith("uniwap")) && (!paramContext.startsWith("3gwap")) && (!paramContext.startsWith("cuwap"))) {
          break label155;
        }
        mProxyHost = "10.0.0.172";
        mProxyPort = 80;
        mUseProxy = true;
      }
    }
    while (mUseProxy)
    {
      NAEngine.setProxyInfo(mProxyHost, mProxyPort);
      return;
      label155:
      if (paramContext.startsWith("ctwap"))
      {
        mProxyHost = "10.0.0.200";
        mProxyPort = 80;
        mUseProxy = true;
      }
      else if ((paramContext.startsWith("cmnet")) || (paramContext.startsWith("uninet")) || (paramContext.startsWith("ctnet")) || (paramContext.startsWith("3gnet")))
      {
        mUseProxy = false;
        continue;
        label224:
        paramContext = Proxy.getDefaultHost();
        int i = Proxy.getDefaultPort();
        if ((paramContext != null) && (paramContext.length() > 0)) {
          if ("10.0.0.172".equals(paramContext.trim()))
          {
            mProxyHost = "10.0.0.172";
            mProxyPort = i;
            mUseProxy = true;
          }
          else if ("10.0.0.200".equals(paramContext.trim()))
          {
            mProxyHost = "10.0.0.200";
            mProxyPort = 80;
            mUseProxy = true;
          }
        }
      }
    }
    NAEngine.setProxyInfo(null, 0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */