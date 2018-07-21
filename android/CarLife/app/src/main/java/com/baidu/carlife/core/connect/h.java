package com.baidu.carlife.core.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdServiceResponseListener;
import android.net.wifi.p2p.WifiP2pManager.DnsSdTxtRecordListener;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.i;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h
  implements WifiP2pManager.ConnectionInfoListener, WifiP2pManager.PeerListListener
{
  public static final String a = "available";
  public static final String b = "_ClfWfd";
  public static final String c = "_Clf._Wifi";
  public static final int d = 65537;
  private static final String e = "[WifiDirect]";
  private static h f = null;
  private final IntentFilter g = new IntentFilter();
  private Context h = null;
  private BroadcastReceiver i = null;
  private WifiP2pManager j = null;
  private WifiP2pManager.Channel k = null;
  private WifiManager l = null;
  private WifiP2pDnsSdServiceRequest m = null;
  private WifiP2pDnsSdServiceInfo n = null;
  private WifiP2pDevice o = null;
  private InetAddress p = null;
  private a q = null;
  private HandlerThread r;
  private List s = new ArrayList();
  
  public static h a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new h();
      }
      return f;
    }
    finally {}
  }
  
  private void i()
  {
    this.j.stopPeerDiscovery(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.b("[WifiDirect]", "WifiDirectManager: stop discovery failed");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: stop discovery Success");
      }
    });
    i.b("[WifiDirect]", "Activity: WifiDirectManager: stopDiscoverServices");
  }
  
  private void j()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("available", "visible");
    this.n = WifiP2pDnsSdServiceInfo.newInstance("_ClfWfd", "_Clf._Wifi", localHashMap);
    this.j.addLocalService(this.k, this.n, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.b("[WifiDirect]", "WifiDirectManager: Failed to add a service");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: Added Local Service");
        h.b(h.this);
      }
    });
  }
  
  private void k()
  {
    this.j.setDnsSdResponseListeners(this.k, new WifiP2pManager.DnsSdServiceResponseListener()new WifiP2pManager.DnsSdTxtRecordListener
    {
      public void onDnsSdServiceAvailable(String paramAnonymousString1, String paramAnonymousString2, WifiP2pDevice paramAnonymousWifiP2pDevice)
      {
        i.b("[WifiDirect]", "WifiDirectManager: discover service : " + paramAnonymousString1);
        if (paramAnonymousString1.equalsIgnoreCase("_ClfWfd"))
        {
          if (h.c(h.this) == null) {
            h.a(h.this, new WifiP2pDevice());
          }
          h.a(h.this, paramAnonymousWifiP2pDevice);
          h.this.a(h.c(h.this));
        }
      }
    }, new WifiP2pManager.DnsSdTxtRecordListener()
    {
      public void onDnsSdTxtRecordAvailable(String paramAnonymousString, Map<String, String> paramAnonymousMap, WifiP2pDevice paramAnonymousWifiP2pDevice)
      {
        i.b("[WifiDirect]", "WifiDirectManager: TxtRecord Available : ---------------");
        i.b("[WifiDirect]", "WifiDirectManager: " + paramAnonymousWifiP2pDevice.deviceName + " is " + (String)paramAnonymousMap.get("available"));
      }
    });
    this.j.clearServiceRequests(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.b("[WifiDirect]", "WifiDirectManager: Failed clearing service discovery request");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: Cleared service discovery request");
        h.a(h.this, WifiP2pDnsSdServiceRequest.newInstance());
        h.f(h.this).addServiceRequest(h.d(h.this), h.e(h.this), new WifiP2pManager.ActionListener()
        {
          public void onFailure(int paramAnonymous2Int)
          {
            i.b("[WifiDirect]", "WifiDirectManager: Failed adding service discovery request");
          }
          
          public void onSuccess()
          {
            i.b("[WifiDirect]", "WifiDirectManager: Added service discovery request");
            h.f(h.this).discoverPeers(h.d(h.this), new WifiP2pManager.ActionListener()
            {
              public void onFailure(int paramAnonymous3Int)
              {
                i.b("[WifiDirect]", "WifiDirectManager: Wifi P2P discover peers failure !");
              }
              
              public void onSuccess()
              {
                i.b("[WifiDirect]", "WifiDirectManager:  --------------------------------");
              }
            });
          }
        });
      }
    });
  }
  
  private boolean l()
  {
    if (this.l == null)
    {
      Context localContext1 = this.h;
      Context localContext2 = this.h;
      this.l = ((WifiManager)localContext1.getSystemService("wifi"));
    }
    if (this.l != null) {
      return this.l.isWifiEnabled();
    }
    return false;
  }
  
  private void m()
  {
    this.l.setWifiEnabled(true);
  }
  
  private void n()
  {
    this.j.createGroup(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.b("[WifiDirect]", "WifiDirectManager: Set group owener failure !");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: Set group owener success !");
      }
    });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    this.q.sendMessage(localMessage);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    i.b("[WifiDirect]", "WifiDirectManager: ++++++++ WifiP2pManager  init ++++++++");
    this.h = paramContext;
    if (this.q == null)
    {
      this.r = new HandlerThread("WifiDirectManMsgHandlerThread");
      this.r.start();
      this.q = new a(this.r.getLooper());
    }
    if (this.j == null)
    {
      this.l = ((WifiManager)paramContext.getSystemService("wifi"));
      paramContext = this.h;
      Context localContext = this.h;
      this.j = ((WifiP2pManager)paramContext.getSystemService("wifip2p"));
      i.b("[WifiDirect]", "WifiDirectManager: init wifi_p2p_service : " + this.j);
      if (this.j == null) {
        break label206;
      }
      this.k = this.j.initialize(this.h, Looper.getMainLooper(), null);
      if (this.k == null)
      {
        i.b("[WifiDirect]", "WifiDirectManager: setup connection fail");
        this.j = null;
      }
    }
    for (;;)
    {
      if (!l())
      {
        i.b("[WifiDirect]", "WifiDirectManager: Wifi is disable, CarLife will open !");
        m();
      }
      d();
      return;
      label206:
      i.b("[WifiDirect]", "WifiDirectManager: mWifiP2pManager is null");
    }
  }
  
  public void a(WifiP2pDevice paramWifiP2pDevice)
  {
    i.b("[WifiDirect]", "WifiDirectManager: connectP2P");
    WifiP2pConfig localWifiP2pConfig = new WifiP2pConfig();
    localWifiP2pConfig.deviceAddress = paramWifiP2pDevice.deviceAddress;
    localWifiP2pConfig.wps.setup = 0;
    this.j.connect(this.k, localWifiP2pConfig, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt) {}
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: connect to devices：" + h.c(h.this).deviceName + "ipaddress:" + h.c(h.this).deviceAddress);
      }
    });
  }
  
  public void a(WifiP2pManager paramWifiP2pManager, WifiP2pManager.Channel paramChannel, Context paramContext)
  {
    this.j = paramWifiP2pManager;
    this.k = paramChannel;
    this.h = paramContext;
  }
  
  public WifiP2pManager b()
  {
    return this.j;
  }
  
  public void b(WifiP2pDevice paramWifiP2pDevice)
  {
    if (this.j != null)
    {
      if ((paramWifiP2pDevice != null) && (paramWifiP2pDevice.status != 0)) {
        break label23;
      }
      g();
    }
    label23:
    while ((paramWifiP2pDevice.status != 3) && (paramWifiP2pDevice.status != 1)) {
      return;
    }
    this.j.cancelConnect(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt) {}
      
      public void onSuccess() {}
    });
  }
  
  public WifiP2pManager.Channel c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    if (!l())
    {
      i.b("[WifiDirect]", "WifiDirectManager: Wifi is disable, CarLife will open !");
      m();
    }
    this.j.clearLocalServices(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.b("[WifiDirect]", "WifiDirectManager: Clear Local Service failure");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "WifiDirectManager: Clear Local Service");
        h.a(h.this);
      }
    });
    return true;
  }
  
  public void e()
  {
    if (this.n != null)
    {
      this.j.removeLocalService(this.k, this.n, new WifiP2pManager.ActionListener()
      {
        public void onFailure(int paramAnonymousInt)
        {
          i.b("[WifiDirect]", "WifiDirectManager: Removed Local Service failure");
        }
        
        public void onSuccess()
        {
          i.b("[WifiDirect]", "WifiDirectManager: Removed Local Service");
        }
      });
      this.j.clearLocalServices(this.k, new WifiP2pManager.ActionListener()
      {
        public void onFailure(int paramAnonymousInt)
        {
          i.b("[WifiDirect]", "WifiDirectManager: Clear Local Service failure");
        }
        
        public void onSuccess()
        {
          i.b("[WifiDirect]", "WifiDirectManager: Clear Local Service");
        }
      });
    }
    if (this.m != null)
    {
      this.j.removeServiceRequest(this.k, this.m, new WifiP2pManager.ActionListener()
      {
        public void onFailure(int paramAnonymousInt)
        {
          i.b("[WifiDirect]", "WifiDirectManager: Failed removing service discovery request");
        }
        
        public void onSuccess()
        {
          i.b("[WifiDirect]", "WifiDirectManager: Removed service discovery request");
        }
      });
      this.j.clearServiceRequests(this.k, new WifiP2pManager.ActionListener()
      {
        public void onFailure(int paramAnonymousInt)
        {
          i.b("[WifiDirect]", "WifiDirectManager: Failed clearing service discovery request");
        }
        
        public void onSuccess()
        {
          i.b("[WifiDirect]", "WifiDirectManager: Cleared service discovery request");
        }
      });
    }
  }
  
  public void f()
  {
    if (this.s.size() == 0)
    {
      i.b("[WifiDirect]", "WifiDirectManager: Peer divice is null !");
      return;
    }
    WifiP2pDevice localWifiP2pDevice = (WifiP2pDevice)this.s.get(0);
    WifiP2pConfig localWifiP2pConfig = new WifiP2pConfig();
    localWifiP2pConfig.deviceAddress = localWifiP2pDevice.deviceAddress;
    localWifiP2pConfig.wps.setup = 0;
    i.b("[WifiDirect]", "@WifiDirectManager: Star to Connect device");
    this.j.connect(this.k, localWifiP2pConfig, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt)
      {
        i.e("[WifiDirect]", "WifiDirectManager: Failure to connect to peer!!");
      }
      
      public void onSuccess()
      {
        i.b("[WifiDirect]", "@WifiDirectManager: Connect Success!!!");
      }
    });
  }
  
  public void g()
  {
    this.j.removeGroup(this.k, new WifiP2pManager.ActionListener()
    {
      public void onFailure(int paramAnonymousInt) {}
      
      public void onSuccess() {}
    });
  }
  
  public void h()
  {
    i.b("[WifiDirect]", "WifiDirectManager: resetData");
    this.o = null;
  }
  
  public void onConnectionInfoAvailable(WifiP2pInfo paramWifiP2pInfo)
  {
    if (paramWifiP2pInfo.isGroupOwner)
    {
      i.b("[WifiDirect]", "WifiDirectManager: Activity:Connected as group owner");
      return;
    }
    i.b("[WifiDirect]", "WifiDirectManager: Activity:Connected as peer");
    try
    {
      this.p = paramWifiP2pInfo.groupOwnerAddress;
      return;
    }
    catch (Exception paramWifiP2pInfo)
    {
      i.b("[WifiDirect]", "WifiDirectManager: Failed to create connect thread - " + paramWifiP2pInfo.getMessage());
      paramWifiP2pInfo.printStackTrace();
    }
  }
  
  public void onPeersAvailable(WifiP2pDeviceList paramWifiP2pDeviceList)
  {
    i.b("[WifiDirect]", "WifiDirectManager: onPeersAvailable");
    this.s.clear();
    this.s.addAll(paramWifiP2pDeviceList.getDeviceList());
    int i1 = 0;
    while (i1 < this.s.size())
    {
      paramWifiP2pDeviceList = (WifiP2pDevice)this.s.get(0);
      i.b("[WifiDirect]", "WifiDirectManager: dump device :" + i1);
      i.b("[WifiDirect]", "WifiDirectManager:  : " + paramWifiP2pDeviceList.toString());
      i1 += 1;
    }
    if (this.s.size() == 0)
    {
      i.b("[WifiDirect]", "WifiDirectManager: No devices found");
      return;
    }
    i.b("[WifiDirect]", "WifiDirectManager: Get peers : " + this.s.size());
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      }
      i.b("[WifiDirect]", "WifiDirectManager: peer connect");
      h.this.f();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */