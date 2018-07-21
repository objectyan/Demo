package com.baidu.carlife.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.carlife.protobuf.CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.carlife.util.x;
import com.google.protobuf.InvalidProtocolBufferException;

public class a
  extends n
{
  private static final String C = a.class.getSimpleName();
  private static a D = null;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  public static final int t = 0;
  public static final int u = 1;
  public static final int v = 2;
  private g E = new g(null);
  private f F = new f(null);
  private c G = new c(null);
  private b H = new b(null);
  private e I = new e(null);
  private a J = new a(null);
  private d K = new d(null);
  private Context L;
  private String M = "";
  private String N = "";
  private boolean O = false;
  private final BroadcastReceiver P = new BtDeviceManager.1(this);
  public boolean w = false;
  public boolean x = false;
  
  protected a(String paramString)
  {
    super(C, Looper.getMainLooper());
    a(this.F);
    a(this.G, this.F);
    a(this.H, this.F);
    a(this.K, this.H);
    a(this.I, this.H);
    a(this.J, this.H);
    b(this.F);
  }
  
  private void D()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    if (this.L != null) {
      this.L.registerReceiver(this.P, localIntentFilter);
    }
    if (this.E != null) {
      k.a(this.E);
    }
  }
  
  private void E()
  {
    if ((this.L != null) && (this.P != null)) {
      this.L.unregisterReceiver(this.P);
    }
    if (this.E != null) {
      k.b(this.E);
    }
  }
  
  public static a a()
  {
    if (D == null) {}
    try
    {
      if (D == null) {
        D = new a(C);
      }
      return D;
    }
    finally {}
  }
  
  private void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
    if ((i1 == 13) || (i1 == 10)) {
      l();
    }
  }
  
  public void a(Context paramContext)
  {
    this.L = paramContext;
    f.a().a(paramContext);
    b.a().a(paramContext);
    D();
    C();
  }
  
  public void a(com.baidu.carlife.core.connect.c paramc)
  {
    com.baidu.carlife.core.i.b(C, "Got OOB Info msg from HU");
    if (paramc != null) {
      d(a(14, paramc));
    }
  }
  
  public void a(String paramString)
  {
    com.baidu.carlife.core.i.b(C, "send start identify event");
    if (!TextUtils.isEmpty(paramString))
    {
      this.O = true;
      this.M = paramString;
      d(4);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ("BLUETOOTH_AUTO_PAIR".equals(paramString)) {
      if (paramInt == 1)
      {
        com.baidu.carlife.core.i.b(C, "BT Auto Pair is supported by HU");
        this.x = true;
      }
    }
    for (;;)
    {
      d(15);
      return;
      com.baidu.carlife.core.i.b(C, "BT Auto Pair is NOT supported by HU");
      this.x = false;
      continue;
      if ("BLUETOOTH_INTERNAL_UI".equals(paramString)) {
        if (paramInt == 1)
        {
          com.baidu.carlife.core.i.b(C, "Internal Tele UI is supported by HU");
          if (com.baidu.carlife.core.b.a.a()) {
            this.w = true;
          } else {
            this.w = false;
          }
        }
        else
        {
          com.baidu.carlife.core.i.b(C, "Internal Tele UI is NOT supported by HU");
          this.w = false;
        }
      }
    }
  }
  
  public void b()
  {
    b.a().d();
    f.a().e();
    E();
  }
  
  public void b(String paramString)
  {
    this.M = paramString;
  }
  
  public void c()
  {
    com.baidu.carlife.core.i.b(C, "send usb connected event");
    d(1);
  }
  
  public void d()
  {
    com.baidu.carlife.core.i.b(C, "send carlife authenticated event");
    d(3);
  }
  
  public void e()
  {
    com.baidu.carlife.core.i.b(C, "send usb disconnected event");
    d(2);
  }
  
  public void f()
  {
    com.baidu.carlife.core.i.b(C, "send enter legacy event");
    d(12);
  }
  
  protected void g()
  {
    com.baidu.carlife.core.i.b(C, "Halting SM!!");
  }
  
  public void h()
  {
    com.baidu.carlife.core.i.b(C, "finish identify event");
    d(5);
  }
  
  public void i()
  {
    com.baidu.carlife.core.i.b(C, "start bt pairing event");
    d(6);
  }
  
  public void j()
  {
    com.baidu.carlife.core.i.b(C, "finish bt pairing event");
    d(7);
  }
  
  public void k()
  {
    com.baidu.carlife.core.i.b(C, "HU support BT telephone, and enable this feature");
    d(9);
  }
  
  public void l()
  {
    com.baidu.carlife.core.i.b(C, "Hfp connection with HU is disconnected");
    d(10);
  }
  
  public void m()
  {
    d(16);
  }
  
  public void n()
  {
    d(17);
  }
  
  public void o()
  {
    d(18);
  }
  
  public String p()
  {
    return this.M;
  }
  
  private class a
    extends m
  {
    private a() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering CarlifeBtTele State");
      c.c(1, a.a(a.this));
      b.a().b();
    }
    
    public boolean a(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return false;
      }
      a.this.a(paramMessage);
      a.this.a(a.e(a.this));
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting CarlifeBtTele State");
      b.a().c();
      c.c(0, a.a(a.this));
    }
  }
  
  private class b
    extends m
  {
    private b() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering CarlifeConnected State");
      if (i.d()) {
        f.a().b();
      }
    }
    
    public boolean a(Message paramMessage)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      switch (paramMessage.what)
      {
      case 8: 
      case 9: 
      case 11: 
      case 13: 
      default: 
        bool1 = false;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            if (!f.a().c(a.a(a.this))) {
              break;
            }
            if (a.this.w)
            {
              a.this.a(a.f(a.this));
              return true;
            }
            bool1 = bool2;
          } while (x.b());
          c.c(0, a.a(a.this));
          return true;
          c.c(0, a.a(a.this));
          bool1 = bool2;
        } while (!a.this.x);
        a.this.a(a.this.c(6));
        a.this.a(a.g(a.this));
        return true;
        a.this.a(a.d(a.this));
        return true;
        a.this.a(a.h(a.this));
        return true;
        com.baidu.carlife.core.i.b(a.q(), "HU INFO: Old Auto Pairing Mechanism");
        a.this.f();
        f.a().v.sendMessageDelayed(a.this.a(98309, paramMessage.obj), 500L);
        return true;
        bool1 = bool2;
      } while (!a.i(a.this));
      a.this.a(4, 500L);
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting CarlifeConnected State");
    }
  }
  
  private class c
    extends m
  {
    private c() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering CarlifeConnecting State");
    }
    
    public boolean a(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 2: 
        a.this.a(a.d(a.this));
        return true;
      }
      a.this.a(a.e(a.this));
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting CarlifeConnecting State");
    }
  }
  
  private class d
    extends m
  {
    private d() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering CarlifeLegacy State");
      a.this.d(13);
      f.a().f();
    }
    
    public boolean a(Message paramMessage)
    {
      boolean bool = true;
      switch (paramMessage.what)
      {
      case 8: 
      case 9: 
      case 11: 
      case 12: 
      case 14: 
      case 15: 
      default: 
        bool = false;
      case 7: 
      case 10: 
      case 13: 
        return bool;
      }
      a.this.a(a.e(a.this));
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting CarlifeLegacy State");
      f.a().g();
    }
  }
  
  private class e
    extends m
  {
    private e() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering CarlifePairing State");
      f.a().f();
    }
    
    public boolean a(Message paramMessage)
    {
      boolean bool = true;
      switch (paramMessage.what)
      {
      default: 
        bool = false;
      case 10: 
      case 14: 
        return bool;
      case 6: 
        c.a(a.b(a.this));
        return true;
      case 16: 
        com.baidu.carlife.core.i.b(a.q(), "Auto pairing failed");
        a.this.a(a.e(a.this));
        return true;
      }
      com.baidu.carlife.core.i.b(a.q(), "Audo pairing done in success");
      a.this.a(a.e(a.this));
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting CarlifePairing State");
      f.a().g();
    }
  }
  
  private class f
    extends m
  {
    private f() {}
    
    public void a()
    {
      com.baidu.carlife.core.i.b(a.q(), "Entering Idle State");
      com.baidu.carlife.core.i.b(a.q(), "bdaddr for MD = " + a.b(a.this));
      a.a(a.this, "");
      a.this.w = false;
      a.this.x = false;
      a.a(a.this, false);
    }
    
    public boolean a(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return false;
      }
      a.this.a(a.c(a.this));
      return true;
    }
    
    public void b()
    {
      com.baidu.carlife.core.i.b(a.q(), "Exiting Idle State");
    }
  }
  
  private class g
    extends j
  {
    private g() {}
    
    public void careAbout()
    {
      addMsg(1002);
      addMsg(1004);
      addMsg(98387);
      addMsg(98370);
      addMsg(98307);
      addMsg(98309);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        a.this.c();
        return;
        a.this.e();
        return;
        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        try
        {
          paramMessage = CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.parseFrom(paramMessage.f());
          if (paramMessage == null) {
            continue;
          }
          paramMessage = paramMessage.getAddress();
          com.baidu.carlife.core.i.b(a.q(), "MD <--- HU: Start Identify Req,address = " + paramMessage);
          if (TextUtils.isEmpty(paramMessage)) {
            continue;
          }
          a.this.a(paramMessage);
          return;
        }
        catch (InvalidProtocolBufferException paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        Object localObject;
        for (;;)
        {
          try
          {
            localObject = CarlifeBTPairInfoProto.CarlifeBTPairInfo.parseFrom(paramMessage.f());
            if (localObject == null) {
              break;
            }
            if (!((CarlifeBTPairInfoProto.CarlifeBTPairInfo)localObject).hasAddress())
            {
              com.baidu.carlife.core.i.b(a.q(), "OOB INFO: Unexpected OOB INFO message, no bluetooth address");
              if (((CarlifeBTPairInfoProto.CarlifeBTPairInfo)localObject).getStatus() != 0) {
                break;
              }
              a.this.a(paramMessage);
              return;
            }
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          String str = ((CarlifeBTPairInfoProto.CarlifeBTPairInfo)localObject).getAddress();
          if ((!TextUtils.isEmpty(str)) && (BluetoothAdapter.checkBluetoothAddress(str)))
          {
            a.a(a.this, str);
            com.baidu.carlife.core.i.b(a.q(), "OOB INFO: bluetooth address  = " + a.a(a.this));
          }
          else
          {
            com.baidu.carlife.core.i.b(a.q(), "OOB INFO: bluetooth address invalid");
          }
        }
        try
        {
          paramMessage = CarlifeDeviceInfoProto.CarlifeDeviceInfo.parseFrom(((com.baidu.carlife.core.connect.c)paramMessage.obj).f());
          if (!paramMessage.hasBtaddress())
          {
            com.baidu.carlife.core.i.b(a.q(), "HU INFO: Old HU without BtAddress");
            return;
          }
        }
        catch (Exception paramMessage)
        {
          com.baidu.carlife.core.i.e(a.q(), "get hu info error");
          paramMessage.printStackTrace();
          return;
        }
        paramMessage = paramMessage.getBtaddress();
        if ((!TextUtils.isEmpty(paramMessage)) && (BluetoothAdapter.checkBluetoothAddress(paramMessage)))
        {
          a.a(a.this, paramMessage);
          com.baidu.carlife.core.i.b(a.q(), "HU INFO: bluetooth address  = " + a.a(a.this));
          return;
        }
        com.baidu.carlife.core.i.b(a.q(), "HU INFO: bluetooth address invalid");
        return;
        paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
        try
        {
          paramMessage = CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.parseFrom(paramMessage.f());
          if (paramMessage != null)
          {
            int i = paramMessage.getState();
            paramMessage = paramMessage.getAddress();
            localObject = i.a();
            switch (i)
            {
            default: 
              return;
            }
            com.baidu.carlife.core.i.b(a.q(), "MD <--- HU: HFP CONNECTED,Local Address = " + (String)localObject + ",Connected Address = " + paramMessage);
            if (!TextUtils.isEmpty(paramMessage)) {
              if (!paramMessage.toLowerCase().equals(localObject)) {
                continue;
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
      com.baidu.carlife.core.i.b(a.q(), "HU has connected with unknown device");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */