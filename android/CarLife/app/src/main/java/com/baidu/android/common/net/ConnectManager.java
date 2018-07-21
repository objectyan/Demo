package com.baidu.android.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class ConnectManager
{
  private static final boolean DEBUG = false;
  private static final String TAG = ConnectManager.class.getSimpleName();
  private String mApn;
  private String mNetType;
  private String mPort;
  private String mProxy;
  private int mSubType;
  private String mSubTypeName;
  private boolean mUseWap;
  
  public ConnectManager(Context paramContext)
  {
    checkNetworkType(paramContext);
  }
  
  private void checkApn(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo.getExtraInfo() != null)
    {
      paramContext = paramNetworkInfo.getExtraInfo().toLowerCase();
      if (paramContext != null)
      {
        if ((paramContext.startsWith("cmwap")) || (paramContext.startsWith("uniwap")) || (paramContext.startsWith("3gwap")))
        {
          this.mUseWap = true;
          this.mApn = paramContext;
          this.mProxy = "10.0.0.172";
          this.mPort = "80";
          return;
        }
        if (paramContext.startsWith("ctwap"))
        {
          this.mUseWap = true;
          this.mApn = paramContext;
          this.mProxy = "10.0.0.200";
          this.mPort = "80";
          return;
        }
        if ((paramContext.startsWith("cmnet")) || (paramContext.startsWith("uninet")) || (paramContext.startsWith("ctnet")) || (paramContext.startsWith("3gnet")))
        {
          this.mUseWap = false;
          this.mApn = paramContext;
          return;
        }
      }
    }
    paramContext = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      this.mProxy = paramContext;
      if ("10.0.0.172".equals(this.mProxy.trim()))
      {
        this.mUseWap = true;
        this.mPort = "80";
        return;
      }
      if ("10.0.0.200".equals(this.mProxy.trim()))
      {
        this.mUseWap = true;
        this.mPort = "80";
        return;
      }
      this.mUseWap = false;
      this.mPort = Integer.toString(i);
      return;
    }
    this.mUseWap = false;
  }
  
  private void checkNetworkType(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        if ("wifi".equals(((NetworkInfo)localObject).getTypeName().toLowerCase()))
        {
          this.mNetType = "wifi";
          this.mUseWap = false;
          this.mSubType = ((NetworkInfo)localObject).getSubtype();
          this.mSubTypeName = ((NetworkInfo)localObject).getSubtypeName();
        }
      }
      else {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        NetworkInfo localNetworkInfo = null;
        continue;
        checkApn(paramContext, localNetworkInfo);
        this.mNetType = this.mApn;
      }
    }
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.isConnectedOrConnecting();
    }
    return false;
  }
  
  public String getApn()
  {
    return this.mApn;
  }
  
  public String getNetType()
  {
    return this.mNetType;
  }
  
  public String getProxy()
  {
    return this.mProxy;
  }
  
  public String getProxyPort()
  {
    return this.mPort;
  }
  
  public int getSubType()
  {
    return this.mSubType;
  }
  
  public String getSubTypeName()
  {
    return this.mSubTypeName;
  }
  
  public boolean isWapNetwork()
  {
    return this.mUseWap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/common/net/ConnectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */