package com.baidu.carlife.core.connect;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.util.Log;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;

public class WifiDirectBroadReceiver
  extends BroadcastReceiver
{
  private static final String b = "[WifiDirect]";
  private static boolean e = false;
  Activity a = null;
  private WifiP2pManager c;
  private WifiP2pManager.Channel d;
  private h f = null;
  
  public WifiDirectBroadReceiver(WifiP2pManager paramWifiP2pManager, WifiP2pManager.Channel paramChannel, Activity paramActivity)
  {
    this.c = paramWifiP2pManager;
    this.d = paramChannel;
    this.a = paramActivity;
  }
  
  public WifiDirectBroadReceiver(WifiP2pManager paramWifiP2pManager, WifiP2pManager.Channel paramChannel, h paramh)
  {
    this.c = paramWifiP2pManager;
    this.d = paramChannel;
    this.f = paramh;
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("wifi_state", 0))
    {
    case 2: 
    default: 
      return;
    case 3: 
      i.b("[WifiDirect]", "Wifi State: Enabled");
      k.a(1071, 1000);
      return;
    }
    i.b("[WifiDirect]", "Wifi State: Disabled");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    i.b("[WifiDirect]", "BroadReceiver: -------------- : " + str);
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(str)) {
      a(paramContext, paramIntent);
    }
    int i;
    label184:
    label340:
    label369:
    label395:
    for (;;)
    {
      return;
      if ("android.net.wifi.p2p.STATE_CHANGED".equals(str))
      {
        i = paramIntent.getIntExtra("wifi_p2p_state", -1);
        if (i == 2) {
          i.b("[WifiDirect]", "BroadReceiver: state WIFI_P2P_STATE_ENABLED :" + i);
        }
      }
      else
      {
        if (("android.net.wifi.p2p.PEERS_CHANGED".equals(str)) && (this.c != null)) {
          i.b("[WifiDirect]", "BroadReceiver: PEERS_CHANGED ");
        }
        if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals(str))
        {
          paramContext = (WifiP2pDevice)paramIntent.getParcelableExtra("wifiP2pDevice");
          i.b("[WifiDirect]", "BroadReceiver: Device status : " + paramContext.status);
          if (paramContext.status != 0) {
            break label340;
          }
          i.b("[WifiDirect]", "BroadReceiver: --------------------- peer connected");
          e = true;
        }
        if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(str))
        {
          i.b("[WifiDirect]", "BroadReceiver: WIFI_P2P_CONNECTION_CHANGED_ACTION : ");
          if (this.c == null) {
            continue;
          }
          paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
          i.b("[WifiDirect]", "BroadReceiver: NetworkInfo Connect state : " + paramContext.isConnected());
          if (paramContext.isConnected())
          {
            i.b("[WifiDirect]", "BroadReceiver: Connected to p2p network. Requesting network details");
            if (this.f == null) {
              break label369;
            }
            this.c.requestConnectionInfo(this.d, this.f);
          }
        }
      }
      for (;;)
      {
        if (!"android.net.wifi.p2p.DISCOVERY_STATE_CHANGE".equals(str)) {
          break label395;
        }
        i = paramIntent.getIntExtra("discoveryState", -1);
        if (2 != i) {
          break label397;
        }
        Log.d("[WifiDirect]", "BroadReceiver: -------- WIFI_P2P_DISCOVERY_STARTED");
        return;
        i.b("[WifiDirect]", "BroadReceiver: state WIFI_P2P_STATE_DISABLED :" + i);
        break;
        if (!e) {
          break label184;
        }
        i.b("[WifiDirect]", "BroadReceiver: --------------------- peer disconnected reset discover");
        e = false;
        k.a(1070, 2000);
        break label184;
        if (this.a != null) {
          this.c.requestConnectionInfo(this.d, (WifiP2pManager.ConnectionInfoListener)this.a);
        }
      }
    }
    label397:
    if (1 == i)
    {
      Log.d("[WifiDirect]", "BroadReceiver: -------- WIFI_P2P_DISCOVERY_STOPPED");
      return;
    }
    Log.d("[WifiDirect]", "BroadReceiver: -------- Unknown state !");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/WifiDirectBroadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */