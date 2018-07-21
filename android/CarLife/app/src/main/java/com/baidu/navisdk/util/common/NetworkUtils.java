package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.vi.VNetworkInfo;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;

public class NetworkUtils
{
  private static final String NET = "net";
  public static final int NETWORK_TYPE_BLUETOOTH = 4;
  public static final int NETWORK_TYPE_EXT_BASE = 1000;
  public static final int NETWORK_TYPE_MOBILE = 3;
  public static final int NETWORK_TYPE_NONE = 0;
  public static final int NETWORK_TYPE_UNKNOWN = 1;
  public static final int NETWORK_TYPE_WIFI = 2;
  private static final String PROXY_IP = "10.0.0.172";
  public static final int STATE_NO = 0;
  public static final int STATE_OK = 1;
  private static final String TAG = "NetworkUtils";
  private static final String WAP = "wap";
  private static final int WIFI_TYPE = 88;
  public static int mConnectState;
  public static String mProxyHost = "";
  public static int mProxyPort = 0;
  public static boolean mUseProxy;
  public static int mWifiState = -1;
  
  static
  {
    mUseProxy = false;
  }
  
  public static void ChangeGprsConnect(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              String str = null;
              try
              {
                ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
                paramContext = str;
                if (localConnectivityManager != null) {
                  paramContext = localConnectivityManager.getActiveNetworkInfo();
                }
              }
              catch (Exception paramContext)
              {
                for (;;)
                {
                  int i;
                  paramContext = str;
                }
              }
            } while ((paramContext == null) || (!paramContext.isAvailable()));
            str = paramContext.getTypeName().toLowerCase();
            if ((str.equals("wifi")) && (1 == mWifiState))
            {
              mUseProxy = false;
              return;
            }
          } while ((!str.equals("mobile")) && ((!str.equals("wifi")) || (mWifiState != 0)));
          paramContext = paramContext.getExtraInfo();
          mUseProxy = false;
          if (paramContext == null) {
            break;
          }
          paramContext = paramContext.toLowerCase();
          if ((paramContext.startsWith("cmwap")) || (paramContext.startsWith("uniwap")) || (paramContext.startsWith("3gwap")))
          {
            mProxyHost = "10.0.0.172";
            mProxyPort = 80;
            mUseProxy = true;
            return;
          }
          if (paramContext.startsWith("ctwap"))
          {
            mProxyHost = "10.0.0.200";
            mProxyPort = 80;
            mUseProxy = true;
            return;
          }
        } while ((!paramContext.startsWith("cmnet")) && (!paramContext.startsWith("uninet")) && (!paramContext.startsWith("ctnet")) && (!paramContext.startsWith("3gnet")));
        mUseProxy = false;
        return;
        paramContext = Proxy.getDefaultHost();
        i = Proxy.getDefaultPort();
      } while ((paramContext == null) || (paramContext.length() <= 0));
      if ("10.0.0.172".equals(paramContext.trim()))
      {
        mProxyHost = "10.0.0.172";
        mProxyPort = i;
        mUseProxy = true;
        return;
      }
    } while (!"10.0.0.200".equals(paramContext.trim()));
    mProxyHost = "10.0.0.200";
    mProxyPort = 80;
    mUseProxy = true;
  }
  
  public static void fillProxy(Context paramContext, HttpParams paramHttpParams)
  {
    if (paramContext == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
          } while ((paramContext == null) || (paramContext.getExtraInfo() == null));
          paramContext = paramContext.getExtraInfo().toLowerCase();
          if (paramContext == null) {
            break;
          }
          if ((paramContext.startsWith("cmwap")) || (paramContext.startsWith("uniwap")) || (paramContext.startsWith("3gwap")))
          {
            paramHttpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80));
            return;
          }
          if (paramContext.startsWith("ctwap"))
          {
            paramHttpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
            return;
          }
        } while ((paramContext.startsWith("cmnet")) || (paramContext.startsWith("uninet")) || (paramContext.startsWith("ctnet")) || (paramContext.startsWith("3gnet")));
        paramContext = Proxy.getDefaultHost();
        i = Proxy.getDefaultPort();
      } while ((paramContext == null) || (paramContext.length() <= 0));
      if ("10.0.0.172".equals(paramContext.trim()))
      {
        paramHttpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", i));
        return;
      }
    } while (!"10.0.0.200".equals(paramContext.trim()));
    paramHttpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
  }
  
  public static int getActiveNetworkSubtype()
  {
    Object localObject = BNaviModuleManager.getContext();
    if (localObject == null) {}
    do
    {
      return -100;
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    } while (localObject == null);
    if (((NetworkInfo)localObject).getType() == 1) {
      return 88;
    }
    return ((NetworkInfo)localObject).getSubtype();
  }
  
  public static boolean getConnectStatus()
  {
    return mConnectState == 1;
  }
  
  public static String getCurrentNetMode(Context paramContext)
  {
    if (paramContext == null) {
      return Integer.toString(1);
    }
    int i = 1;
    localObject3 = null;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = localObject3;
      if (localConnectivityManager != null) {
        localObject1 = localConnectivityManager.getActiveNetworkInfo();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 != null)
    {
      if (((NetworkInfo)localObject1).getType() != 1) {
        break label56;
      }
      i = 2;
    }
    for (;;)
    {
      return Integer.toString(i);
      label56:
      if (SystemAuth.checkAuth("android.permission.READ_PHONE_STATE"))
      {
        i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
        switch (i)
        {
        default: 
          i += 1000;
          break;
        case 11: 
          i += 1000;
          break;
        case 4: 
          i += 1000;
          break;
        case 1: 
        case 2: 
          i += 1000;
          break;
        case 5: 
        case 6: 
        case 7: 
          i += 1000;
          break;
        case 8: 
          i += 1000;
          break;
        case 3: 
        case 9: 
        case 10: 
          i += 1000;
          break;
        }
      }
      else
      {
        i = 1000;
      }
    }
  }
  
  public static int getCurrentNetworkType()
  {
    if (BNaviModuleManager.getContext() == null) {}
    for (;;)
    {
      return 0;
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)BNaviModuleManager.getContext().getSystemService("connectivity");
        if (localConnectivityManager.getActiveNetworkInfo() != null)
        {
          int i = localConnectivityManager.getActiveNetworkInfo().getType();
          switch (i)
          {
          default: 
            return 1;
          case 1: 
            return 2;
          }
          return 3;
        }
      }
      catch (Exception localException) {}
    }
    return 1;
  }
  
  public static int getNetStatus()
  {
    if (BNaviModuleManager.getContext() == null) {}
    NetworkInfo localNetworkInfo;
    int i;
    do
    {
      do
      {
        return 1;
        localNetworkInfo = ((ConnectivityManager)BNaviModuleManager.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      } while (localNetworkInfo == null);
      i = localNetworkInfo.getType();
    } while (!localNetworkInfo.isConnected());
    switch (i)
    {
    default: 
      return 1;
    case 0: 
      return 3;
    }
    return 2;
  }
  
  public static VNetworkInfo getNetworkInfo(int paramInt)
  {
    if (BNaviModuleManager.getContext() == null) {
      return null;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)BNaviModuleManager.getContext().getSystemService("connectivity");
    NetworkInfo localNetworkInfo = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new VNetworkInfo(localNetworkInfo);
      localNetworkInfo = localConnectivityManager.getNetworkInfo(1);
      continue;
      localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        LogUtil.e("NetworkUtils", "ConnectivityManager is null");
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      LogUtil.e("NetworkUtils", "No Connected！");
    }
    return false;
  }
  
  public static boolean isTypeNetworkAvailable(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        LogUtil.e("NetworkUtils", "ConnectivityManager is null");
        return false;
      }
      paramContext = paramContext.getNetworkInfo(paramInt);
      if (paramContext != null)
      {
        paramContext = paramContext.getState();
        if (paramContext != NetworkInfo.State.CONNECTED)
        {
          NetworkInfo.State localState = NetworkInfo.State.CONNECTING;
          if (paramContext != localState) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isWap(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((paramContext == null) || (paramContext.getExtraInfo() == null));
    return paramContext.getExtraInfo().endsWith("wap");
  }
  
  public static boolean isWifi(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while ((paramContext == null) || (paramContext.getType() != 1));
    return true;
  }
  
  public static boolean isWifiConnected()
  {
    if (BNaviModuleManager.getContext() == null) {}
    for (;;)
    {
      return false;
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)BNaviModuleManager.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (localNetworkInfo != null)
        {
          boolean bool = localNetworkInfo.isConnected();
          return bool;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */