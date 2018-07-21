package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f
{
  public static final String a = "BtManager";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 20;
  public static final int i = 21;
  public static final int j = 22;
  public static final int k = 23;
  public static final int l = 24;
  public static final int m = 25;
  public static final int n = 40;
  public static final int o = 41;
  public static final int p = -1;
  public static final int q = -2;
  public static final int r = -3;
  public static final int s = -4;
  public static final int t = 10000;
  public static final int u = 10000;
  private static f x = null;
  private String A = "";
  private String B = "";
  private Context C = null;
  private BluetoothHeadset D;
  private BluetoothA2dp E;
  private Runnable F = null;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private int J = 0;
  private int K = 0;
  private final BroadcastReceiver L = new BtManager.4(this);
  public b v = new b();
  public Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject;
      int i;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 41: 
      case 40: 
      case 20: 
      case 21: 
      case 23: 
        do
        {
          do
          {
            do
            {
              return;
              f.a(f.this, paramAnonymousMessage.getData().getString("bdaddr"));
              f.b(f.this, paramAnonymousMessage.getData().getString("pin"));
              f.a(f.this, f.a(f.this), f.b(f.this));
              return;
              f.c(f.this);
              return;
              f.d(f.this);
              return;
              paramAnonymousMessage = paramAnonymousMessage.getData().getString("bdaddr");
              if (!f.a(f.this).equals(paramAnonymousMessage))
              {
                com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Address is not matched with last stage");
                return;
              }
              if (f.e(f.this) <= 0) {
                break;
              }
              f.f(f.this);
              com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Try to bond with left attempts = " + f.e(f.this));
              if (f.c(f.this, paramAnonymousMessage))
              {
                paramAnonymousMessage = new Message();
                paramAnonymousMessage.what = 23;
                f.this.w.sendMessageDelayed(paramAnonymousMessage, 10000L);
                return;
              }
              localObject = new Message();
              ((Message)localObject).what = 41;
              Bundle localBundle = new Bundle();
              localBundle.putString("bdaddr", paramAnonymousMessage);
              ((Message)localObject).setData(localBundle);
            } while (f.this.w == null);
            f.d(f.this, paramAnonymousMessage);
            f.this.w.sendMessageDelayed((Message)localObject, 500L);
            return;
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Failed as down counter is over");
            f.a(f.this, -2);
            return;
            paramAnonymousMessage = paramAnonymousMessage.getData().getString("bdaddr");
            if (!f.a(f.this).equals(paramAnonymousMessage))
            {
              com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Address is not matched with last stage");
              return;
            }
            if (f.g(f.this) > 0)
            {
              f.h(f.this);
              com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Try to connect hfp with left attempts = " + f.g(f.this));
              f.e(f.this, paramAnonymousMessage);
              paramAnonymousMessage = new Message();
              paramAnonymousMessage.what = 24;
              f.this.w.sendMessageDelayed(paramAnonymousMessage, 10000L);
              return;
            }
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Failed as down counter is over");
            f.a(f.this, -3);
            return;
            if (f.i(f.this) > 0)
            {
              f.j(f.this);
              com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Polling BT Adapter state left times = " + f.i(f.this));
              if (f.k(f.this))
              {
                com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Bluetooth Adapter enabled after polling");
                f.b(f.this, 10);
                paramAnonymousMessage = new Message();
                paramAnonymousMessage.what = 21;
                f.this.w.sendMessageDelayed(paramAnonymousMessage, 1000L);
                return;
              }
              paramAnonymousMessage = new Message();
              paramAnonymousMessage.what = 20;
              f.this.w.sendMessageDelayed(paramAnonymousMessage, 1000L);
              return;
            }
            com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Polling adapter state timeout");
            f.a(f.this, -1);
            return;
            if (f.l(f.this) <= 0) {
              break;
            }
            f.m(f.this);
            com.baidu.carlife.core.i.b("BtManager", "READY STAGE: Polling HFP connection state left times = " + f.l(f.this));
            i = f.this.d();
            if (i == 1)
            {
              com.baidu.carlife.core.i.b("BtManager", "READY STAGE: Get ready for bluetooth connection");
              paramAnonymousMessage = new Message();
              paramAnonymousMessage.what = 22;
              f.this.w.sendMessage(paramAnonymousMessage);
              return;
            }
            if (i == 2)
            {
              paramAnonymousMessage = new Message();
              paramAnonymousMessage.what = 21;
              f.this.w.sendMessageDelayed(paramAnonymousMessage, 1000L);
              return;
            }
          } while (i != 3);
          com.baidu.carlife.core.i.b("BtManager", "READY STAGE: Had been connected with HU");
          return;
          com.baidu.carlife.core.i.b("BtManager", "READY STAGE: Polling HFP connection state timeout");
          f.a(f.this, -4);
          return;
          i = f.f(f.this, f.a(f.this));
          if (i == 12)
          {
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Bonded with HU, start hfp connect");
            f.g(f.this, f.a(f.this));
            return;
          }
          if (i == 11)
          {
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Still in Bonding, cancel bond and restart");
            f.d(f.this, f.a(f.this));
          }
          paramAnonymousMessage = new Message();
          paramAnonymousMessage.what = 41;
          localObject = new Bundle();
          ((Bundle)localObject).putString("bdaddr", f.a(f.this));
          paramAnonymousMessage.setData((Bundle)localObject);
        } while (f.this.w == null);
        f.this.w.sendMessageDelayed(paramAnonymousMessage, 500L);
        return;
      case 24: 
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Connected with HU timeout");
        i = f.this.c();
        if (i == 0) {
          com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Still in disconnected state");
        }
        for (;;)
        {
          paramAnonymousMessage = new Message();
          paramAnonymousMessage.what = 40;
          localObject = new Bundle();
          ((Bundle)localObject).putString("bdaddr", f.a(f.this));
          paramAnonymousMessage.setData((Bundle)localObject);
          if (f.this.w == null) {
            break;
          }
          f.this.w.sendMessageDelayed(paramAnonymousMessage, 500L);
          return;
          if (i == 2)
          {
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Connected with HU yet");
            return;
          }
          com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Still in connecting state, do a disconnect and restart connect");
          f.n(f.this);
        }
      }
      c.a(1);
    }
  };
  private BluetoothAdapter y = null;
  private BluetoothDevice z = null;
  
  public static f a()
  {
    if (x == null) {}
    try
    {
      if (x == null) {
        x = new f();
      }
      return x;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.w != null)
      {
        this.w.removeMessages(24);
        this.w.removeMessages(40);
        this.w.removeMessages(41);
        this.w.removeMessages(23);
      }
      a.a().m();
      return;
      com.baidu.carlife.core.i.b("BtManager", "Auto-Pair Failed in enabling adapter");
      continue;
      com.baidu.carlife.core.i.b("BtManager", "Auto-Pair Failed in pairing");
      continue;
      com.baidu.carlife.core.i.b("BtManager", "Auto-Pair Failed in connecting");
      continue;
      com.baidu.carlife.core.i.b("BtManager", "Auto-Pair Failed in checking hfp connection");
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!q())
    {
      if (this.y != null) {
        new Thread(new Runnable()
        {
          public void run()
          {
            if (f.r(f.this))
            {
              com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Start to enable Bluetooth Adapter, and polling state...");
              f.c(f.this, 10);
              Message localMessage = new Message();
              localMessage.what = 20;
              f.this.w.sendMessageDelayed(localMessage, 1000L);
              return;
            }
            com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Failed to enable Bluetooth Adapter");
          }
        }).start();
      }
      return;
    }
    com.baidu.carlife.core.i.b("BtManager", "IDLE STAGE: Bluetooth Adapter is enabled yet!");
    this.H = 10;
    paramString1 = new Message();
    paramString1.what = 21;
    this.w.sendMessageDelayed(paramString1, 1000L);
  }
  
  private void d(String paramString)
  {
    if (this.w != null)
    {
      Message localMessage = new Message();
      localMessage.what = 40;
      Bundle localBundle = new Bundle();
      localBundle.putString("bdaddr", paramString);
      localMessage.setData(localBundle);
      if (this.w != null)
      {
        this.J = 3;
        this.w.sendMessage(localMessage);
      }
    }
  }
  
  private void e(String paramString)
  {
    if (this.w != null)
    {
      Message localMessage = new Message();
      localMessage.what = 41;
      Bundle localBundle = new Bundle();
      localBundle.putString("bdaddr", paramString);
      localMessage.setData(localBundle);
      if (this.w != null)
      {
        this.I = 3;
        this.w.sendMessage(localMessage);
      }
    }
  }
  
  private void f(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (!BluetoothAdapter.checkBluetoothAddress(paramString));
      paramString = this.y.getRemoteDevice(paramString);
    } while ((this.D == null) || (paramString == null));
    try
    {
      if (i.a(this.D.getClass(), this.D, paramString))
      {
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.connect = TRUE ");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.connect exception");
      return;
    }
    com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.connect = FALSE");
  }
  
  private boolean g(String paramString)
  {
    if ((this.y == null) || (TextUtils.isEmpty(paramString)))
    {
      com.baidu.carlife.core.i.b("BtManager", "pair: mBluetoothAdapter is NULL");
      return false;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(paramString))
    {
      com.baidu.carlife.core.i.b("BtManager", "pair: address is invalid");
      return false;
    }
    paramString = this.y.getRemoteDevice(paramString);
    if (paramString == null)
    {
      com.baidu.carlife.core.i.b("BtManager", "pair: Bluetooth Device is null");
      return false;
    }
    try
    {
      bool = i.a(paramString.getClass(), paramString);
      if (bool)
      {
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.createBond = TRUE ");
        return bool;
      }
    }
    catch (Exception paramString)
    {
      boolean bool;
      paramString.printStackTrace();
      if (Build.DEVICE.toLowerCase().equals("hwh30-t00"))
      {
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Special case for Huawei Honor");
        return true;
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.createBond = FALSE");
        return bool;
      }
    }
    return false;
  }
  
  private void h(String paramString)
  {
    if (this.y != null)
    {
      paramString = this.y.getRemoteDevice(paramString);
      if (paramString != null) {
        try
        {
          if (i.c(paramString.getClass(), paramString))
          {
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.removeBond = TRUE ");
            return;
          }
          com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.removeBond = FALSE");
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  private void i(String paramString)
  {
    if (this.y == null) {
      com.baidu.carlife.core.i.b("BtManager", "stopPair: mBluetoothAdapter is NULL");
    }
    do
    {
      return;
      if (!BluetoothAdapter.checkBluetoothAddress(paramString))
      {
        com.baidu.carlife.core.i.b("BtManager", "stopPair: address is invalid");
        return;
      }
      paramString = this.y.getRemoteDevice(paramString);
      if (paramString == null)
      {
        com.baidu.carlife.core.i.b("BtManager", "stopPair: Bluetooth Device is NULL");
        return;
      }
    } while ((this.y == null) || (paramString == null));
    try
    {
      if (i.b(paramString.getClass(), paramString))
      {
        com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.cancelBondProcess = TRUE ");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      com.baidu.carlife.core.i.b("BtManager", "stopPair: Exception in cancelBondProcess");
      return;
    }
    com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.cancelBondProcess = FALSE");
  }
  
  private int j(String paramString)
  {
    int i2 = 10;
    int i1 = i2;
    if (this.y != null)
    {
      paramString = this.y.getRemoteDevice(paramString);
      i1 = i2;
      if (paramString != null) {
        i1 = paramString.getBondState();
      }
    }
    return i1;
  }
  
  private boolean k(String paramString)
  {
    boolean bool2 = false;
    if (this.y == null) {
      return false;
    }
    Object localObject = this.y.getBondedDevices();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Set)localObject).size() > 0)
      {
        localObject = ((Set)localObject).iterator();
        String str;
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = ((BluetoothDevice)((Iterator)localObject).next()).getAddress();
        } while ((str == null) || (!str.equals(paramString)));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void l()
  {
    if (this.y != null) {}
    try
    {
      this.y.getProfileProxy(this.C, new BluetoothProfile.ServiceListener()
      {
        public void onServiceConnected(int paramAnonymousInt, BluetoothProfile paramAnonymousBluetoothProfile)
        {
          if ((paramAnonymousInt == 1) && (paramAnonymousBluetoothProfile != null))
          {
            f.a(f.this, (BluetoothHeadset)paramAnonymousBluetoothProfile);
            com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: Get headset proxy: " + f.o(f.this));
          }
        }
        
        public void onServiceDisconnected(int paramAnonymousInt)
        {
          f.a(f.this, null);
          com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: Disconnect headset proxy!!!");
        }
      }, 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: getProfileProxy Exception");
    }
  }
  
  private void m()
  {
    if (this.y != null) {}
    try
    {
      this.y.getProfileProxy(this.C, new BluetoothProfile.ServiceListener()
      {
        public void onServiceConnected(int paramAnonymousInt, BluetoothProfile paramAnonymousBluetoothProfile)
        {
          if ((paramAnonymousInt == 2) && (paramAnonymousBluetoothProfile != null))
          {
            f.a(f.this, (BluetoothA2dp)paramAnonymousBluetoothProfile);
            com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: Get A2DP proxy: " + f.p(f.this));
          }
        }
        
        public void onServiceDisconnected(int paramAnonymousInt)
        {
          f.a(f.this, null);
          com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: Disconnect A2DP proxy!!!");
        }
      }, 2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: getA2dpProxy Exception");
    }
  }
  
  private void n()
  {
    a.a().n();
    if (this.w != null)
    {
      this.w.removeMessages(24);
      this.w.removeMessages(40);
      this.w.removeMessages(41);
      this.w.removeMessages(23);
    }
  }
  
  private void o() {}
  
  private boolean p()
  {
    if (this.y == null) {
      return false;
    }
    return this.y.enable();
  }
  
  private boolean q()
  {
    if (this.y != null) {
      return this.y.isEnabled();
    }
    return false;
  }
  
  private void r() {}
  
  private int s()
  {
    return 0;
  }
  
  private void t()
  {
    Object localObject = j();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
        if (localBluetoothDevice != null)
        {
          try
          {
            if (this.D == null) {
              continue;
            }
            if (!i.b(this.D.getClass(), this.D, localBluetoothDevice)) {
              break label84;
            }
            com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.disconnect = TRUE ");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
          label84:
          com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: BtUtils.disconnect = FALSE");
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    this.C = paramContext;
    this.y = BluetoothAdapter.getDefaultAdapter();
    if (this.y == null)
    {
      com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: Failed to obtain Bluetooth Adapter for MD");
      return;
    }
    l();
    m();
  }
  
  public void a(String paramString)
  {
    com.baidu.carlife.core.i.b("BtManager", "HU ---> MD : HU OOB INFO READY, addr = " + paramString);
    if ((paramString == null) || (!paramString.equals(this.A)))
    {
      com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: Received invalid address from HU");
      return;
    }
    if (k(paramString))
    {
      com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: has been paired, just do hfp connection");
      d(paramString);
      return;
    }
    com.baidu.carlife.core.i.b("BtManager", "PAIR STAGE: not paired, start pairing...");
    e(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.baidu.carlife.core.i.b("BtManager", "HU ---> MD : HU OOB INFO IDLE, addr = " + paramString1 + ",pincode = " + paramString2);
    Message localMessage = new Message();
    localMessage.what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putString("bdaddr", paramString1);
    localBundle.putString("pin", paramString2);
    localMessage.setData(localBundle);
    if (this.w != null) {
      this.w.sendMessage(localMessage);
    }
  }
  
  public void b()
  {
    if (this.E == null) {}
    for (;;)
    {
      return;
      Object localObject = this.E.getConnectedDevices();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BluetoothDevice localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
          if (localBluetoothDevice != null)
          {
            try
            {
              if (this.E == null) {
                continue;
              }
              if (!i.c(this.E.getClass(), this.E, localBluetoothDevice)) {
                break label94;
              }
              com.baidu.carlife.core.i.b("BtManager", "BtUtils.disconnectA2dp = TRUE ");
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            label94:
            com.baidu.carlife.core.i.b("BtManager", "BtUtils.disconnectA2dp = FALSE");
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    com.baidu.carlife.core.i.b("BtManager", "HU ---> MD : HU OOB INFO DONE, addr = " + paramString);
    a.a().n();
  }
  
  public int c()
  {
    int i1 = 0;
    try
    {
      if (this.y != null) {
        i1 = this.y.getProfileConnectionState(1);
      }
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.baidu.carlife.core.i.b("BtManager", "Failed in getConnectionState");
    }
    return 0;
  }
  
  public boolean c(String paramString)
  {
    Object localObject1 = j();
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      com.baidu.carlife.core.i.b("BtManager", "isHfpConnectWith: Connected device list is NULL");
    }
    for (;;)
    {
      return false;
      if (!BluetoothAdapter.checkBluetoothAddress(paramString))
      {
        com.baidu.carlife.core.i.b("BtManager", "isHfpConnectWith: Bluetooth address is invalid");
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (BluetoothDevice)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((BluetoothDevice)localObject2).getAddress();
          if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(localObject2)))
          {
            com.baidu.carlife.core.i.b("BtManager", "isHfpConnectWith: Bluetooth has been connected with correct device");
            return true;
          }
          com.baidu.carlife.core.i.b("BtManager", "isHfpConnectWith: Bluetooth has been connected with wrong device");
        }
      }
    }
  }
  
  public int d()
  {
    int i1 = c();
    com.baidu.carlife.core.i.b("BtManager", "checkHfpConnection state = " + i1);
    if (i1 == 0) {
      com.baidu.carlife.core.i.b("BtManager", "HFP is disconnected");
    }
    List localList;
    do
    {
      return 1;
      if (i1 != 2) {
        break;
      }
      if (c(this.A)) {
        return 3;
      }
      localList = j();
    } while ((localList == null) || (localList.size() == 0));
    t();
    return 2;
    if (i1 == 1)
    {
      com.baidu.carlife.core.i.b("BtManager", "HFP is connecting");
      return 2;
    }
    if (i1 == 3)
    {
      com.baidu.carlife.core.i.b("BtManager", "HFP is disconnecting");
      return 2;
    }
    return 2;
  }
  
  public void e()
  {
    if ((this.D != null) && (this.y != null))
    {
      this.y.closeProfileProxy(1, this.D);
      com.baidu.carlife.core.i.b("BtManager", "UNINIT STAGE: Close headset proxy");
    }
  }
  
  public void f()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
    localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    if (this.C != null) {
      this.C.registerReceiver(this.L, localIntentFilter);
    }
    com.baidu.carlife.core.i.b("BtManager", "INIT STAGE: register Bluetooth broadcast receiver");
    if (this.v != null)
    {
      com.baidu.carlife.core.i.b("BtManager", "start register msg handler");
      k.a(this.v);
    }
  }
  
  public void g()
  {
    if ((this.C != null) && (this.L != null)) {}
    try
    {
      this.C.unregisterReceiver(this.L);
      com.baidu.carlife.core.i.b("BtManager", "UNINIT STAGE: unregister Bluetooth broadcast receiver");
      if (this.v != null) {
        k.b(this.v);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void h() {}
  
  public void i()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (f.k(f.this))
        {
          com.baidu.carlife.core.i.b("BtManager", "Bluetooth is Enabled yet");
          return;
        }
        if (f.r(f.this))
        {
          com.baidu.carlife.core.i.b("BtManager", "Enable Bluetooth In Success");
          return;
        }
        com.baidu.carlife.core.i.b("BtManager", "Enable Bluetooth In Failure");
      }
    }).start();
  }
  
  public List<BluetoothDevice> j()
  {
    List localList = null;
    try
    {
      if (this.D != null) {
        localList = this.D.getConnectedDevices();
      }
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public boolean k()
  {
    if (!q()) {}
    List localList;
    do
    {
      return false;
      localList = j();
    } while ((localList == null) || (localList.size() == 0));
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
  }
  
  public class b
    extends j
  {
    public b() {}
    
    public void careAbout()
    {
      addMsg(98309);
      addMsg(2031);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 98309: 
        for (;;)
        {
          return;
          com.baidu.carlife.core.i.b("BtManager", "my OOB info");
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          try
          {
            paramMessage = CarlifeBTPairInfoProto.CarlifeBTPairInfo.parseFrom(paramMessage.f());
            if (paramMessage != null)
            {
              int i = paramMessage.getStatus();
              String str = paramMessage.getAddress();
              com.baidu.carlife.core.i.b("BtManager", "MD <--- HU :address = " + paramMessage.getAddress() + ",status = " + i);
              if ((!TextUtils.isEmpty(str)) && (BluetoothAdapter.checkBluetoothAddress(str))) {
                switch (i)
                {
                default: 
                  return;
                }
              }
            }
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        f.this.a(paramMessage.getAddress(), paramMessage.getPassKey());
        return;
        f.this.a(paramMessage.getAddress());
        return;
        f.this.b(paramMessage.getAddress());
        return;
      }
      f.this.b();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */