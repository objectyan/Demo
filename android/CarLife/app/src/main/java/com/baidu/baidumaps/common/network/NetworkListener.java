package com.baidu.baidumaps.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.f;

public class NetworkListener
  extends BroadcastReceiver
{
  public static final String a = "NetworkListener";
  public static final String b = "com.baidu.BaiduMap.CONNECTIVIY_CHANGED";
  public static final String c = "com.baidu.BaiduMap.MANUAL_CONNECTIVIY_CHANGED";
  public static final String d = "android.net.conn.CONNECTIVITY_CHANGE";
  public static final String e = "android.net.wifi.WIFI_STATE_CHANGED";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    f.b("NetworkListener.onReceive");
    if (!c.a()) {
      return;
    }
    paramIntent = NetworkUtil.getCurrentNetMode(paramContext);
    com.baidu.platform.comapi.c.b.a().a(paramIntent);
    paramIntent = new Intent();
    paramIntent.setAction("com.baidu.BaiduMap.CONNECTIVIY_CHANGED");
    BaiduNaviApplication.getInstance().sendBroadcast(paramIntent);
    paramIntent = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = null;
    try
    {
      paramIntent = paramIntent.getActiveNetworkInfo();
      paramContext = paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;) {}
    }
    paramIntent = new com.baidu.baidumaps.common.a.b();
    if (paramContext != null)
    {
      paramIntent.a = paramContext.getType();
      paramIntent.b = paramContext.isConnected();
    }
    BMEventBus.getInstance().post(paramIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/common/network/NetworkListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */