package com.baidu.carlife.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication;
import com.baidu.carlife.protobuf.CarlifeBTHfpResponseProto.CarlifeBTHfpResponse;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.navi.util.StatisticManager;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b
{
  private static final String B = b.class.getSimpleName();
  private static final int I = 1000;
  private static final int J = 100;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 1;
  public static final int n = 0;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 0;
  public static final int x = 1;
  public static b y = null;
  public boolean A = false;
  private int C = 0;
  private b D = null;
  private List<d> E = null;
  private List<a> F = null;
  private String G;
  private Context H;
  private int K;
  private int L;
  private boolean M = true;
  public boolean z = false;
  
  public b()
  {
    k.a(this.D);
  }
  
  public static b a()
  {
    if (y == null) {}
    try
    {
      if (y == null) {
        y = new b();
      }
      return y;
    }
    finally {}
  }
  
  private void n()
  {
    this.K += 1;
    this.D.removeMessages(100);
    this.D.sendEmptyMessageDelayed(100, 1000L);
  }
  
  private void o()
  {
    i.a();
    if (f.a().c(this.G))
    {
      c.b(2, this.G);
      return;
    }
    c.b(0, this.G);
  }
  
  public void a(int paramInt)
  {
    if (this.A)
    {
      if (q.f().c() != 2) {
        com.baidu.carlife.core.i.b(B, "sendDTMF : send DTMF is not allowed in call inactive state");
      }
    }
    else {
      return;
    }
    c.a(5, paramInt);
    n();
  }
  
  public void a(Context paramContext)
  {
    this.H = paramContext;
  }
  
  public void a(a parama)
  {
    if (this.F == null) {
      this.F = new ArrayList();
    }
    if ((!this.F.contains(parama)) && (parama != null)) {
      this.F.add(parama);
    }
  }
  
  public void a(d paramd)
  {
    if (this.E == null) {
      this.E = new ArrayList();
    }
    if ((!this.E.contains(paramd)) && (paramd != null))
    {
      this.E.add(paramd);
      paramd.a(this.A);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.baidu.carlife.core.i.b(B, "Enable Telephone lifecycle listener");
      this.M = true;
      return;
    }
    com.baidu.carlife.core.i.b(B, "Disable Telephone lifecycle listener");
    this.M = false;
  }
  
  public void b()
  {
    k.a(this.D);
    this.A = true;
    if (this.E != null)
    {
      Iterator localIterator = this.E.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void b(a parama)
  {
    if ((this.F == null) || (parama == null)) {
      return;
    }
    this.F.remove(parama);
  }
  
  public void b(d paramd)
  {
    if ((this.E == null) || (paramd == null)) {
      return;
    }
    this.E.remove(paramd);
  }
  
  public void c()
  {
    k.b(this.D);
    this.A = false;
    if (this.E != null)
    {
      Iterator localIterator = this.E.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(false);
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("xiaomi"))
    {
      com.baidu.carlife.core.i.b(B, "Try to bring Carlife to foreground via adb command used by XiaoMi");
      d(paramInt);
      return;
    }
    d(paramInt);
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    com.baidu.carlife.core.i.b(B, "Try to bring Carlife to foreground via local intent");
    Context localContext = BaiduNaviApplication.getInstance().getApplicationContext();
    Intent localIntent = new Intent(localContext, CarlifeActivity.class);
    localIntent.putExtra("com.baidu.carlife.callstate", paramInt);
    localIntent.addFlags(268435456);
    localContext.startActivity(localIntent);
  }
  
  public void e()
  {
    if (this.A)
    {
      if (q.f().c() != 1) {
        com.baidu.carlife.core.i.b(B, "answerCall : No incoming call");
      }
    }
    else {
      return;
    }
    StatisticManager.onEvent("PHONE_0003");
    c.a(3, "");
    n();
  }
  
  public void f()
  {
    if (this.A)
    {
      if (q.f().c() != 1) {
        com.baidu.carlife.core.i.b(B, "rejectCall : No incoming call");
      }
    }
    else {
      return;
    }
    c.a(4, "");
    n();
  }
  
  public void g()
  {
    if (this.A)
    {
      if (q.f().c() != 0) {
        com.baidu.carlife.core.i.b(B, "terminateCall : No ongoing call");
      }
    }
    else {
      return;
    }
    c.a(2, "");
    n();
  }
  
  public void h()
  {
    if (this.A)
    {
      if (q.f().c() == 0) {
        com.baidu.carlife.core.i.b(B, "muteMic : Mute mic not in call active");
      }
    }
    else {
      return;
    }
    c.a(6, "");
    n();
  }
  
  public void i()
  {
    if (this.A)
    {
      if (q.f().c() == 0) {
        com.baidu.carlife.core.i.b(B, "muteMic : Unmute mic not in call active");
      }
    }
    else {
      return;
    }
    c.a(7, "");
    n();
  }
  
  public int j()
  {
    return this.C;
  }
  
  public boolean k()
  {
    if (this.M)
    {
      com.baidu.carlife.core.i.b(B, "My Telephone lifecycle listener is enabled");
      return true;
    }
    com.baidu.carlife.core.i.b(B, "My Telephone lifecycle listener is disabled");
    return false;
  }
  
  public void l()
  {
    com.baidu.carlife.core.i.b(B, "Try to bring Carlife to foreground via adb command");
    if (!a.a().N()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject).c(65592);
    localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
    a.a().a((Message)localObject);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  }
  
  private class b
    extends j
  {
    private b() {}
    
    public void careAbout()
    {
      addMsg(98382);
      addMsg(98369);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 1002: 
      case 98307: 
      case 98382: 
      case 98370: 
      case 98369: 
        for (;;)
        {
          return;
          paramMessage = b.a(b.this).iterator();
          while (paramMessage.hasNext()) {
            ((d)paramMessage.next()).a(false);
          }
          continue;
          try
          {
            paramMessage = CarlifeDeviceInfoProto.CarlifeDeviceInfo.parseFrom(((com.baidu.carlife.core.connect.c)paramMessage.obj).f());
            b.a(b.this, paramMessage.getBtaddress());
            com.baidu.carlife.core.i.b(b.m(), "MSG_CMD_HU_INFO: HU's bt address is " + b.b(b.this));
            b.c(b.this);
            return;
          }
          catch (Exception paramMessage)
          {
            com.baidu.carlife.core.i.e(b.m(), "get hu info error");
            paramMessage.printStackTrace();
            return;
          }
          paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          int i;
          try
          {
            paramMessage = CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.parseFrom(paramMessage.f());
            if (paramMessage == null) {
              continue;
            }
            i = paramMessage.getCmd();
            int j = paramMessage.getStatus();
            int k = paramMessage.getDtmfCode();
            com.baidu.carlife.core.i.b(b.m(), "MD<---HU: HFP Response cmdID = " + i + ",status = " + j + ",code = " + k);
            b.d(b.this);
            if (b.e(b.this) == null) {
              continue;
            }
            paramMessage = b.e(b.this).iterator();
            while (paramMessage.hasNext()) {
              ((b.a)paramMessage.next()).a(i, j, k);
            }
            paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          String str;
          try
          {
            paramMessage = CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.parseFrom(paramMessage.f());
            if (paramMessage == null) {
              continue;
            }
            i = paramMessage.getState();
            paramMessage = paramMessage.getAddress();
            str = i.a();
            switch (i)
            {
            default: 
              return;
            }
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          com.baidu.carlife.core.i.b(b.m(), "MD <--- HU: HFP DISCONNECTED,Local Address = " + str + ",Connected Address = " + paramMessage);
          if (!TextUtils.isEmpty(paramMessage))
          {
            if (paramMessage.equals(str))
            {
              b.this.z = false;
              paramMessage = b.a(b.this).iterator();
              while (paramMessage.hasNext()) {
                ((d)paramMessage.next()).a(false);
              }
              continue;
              com.baidu.carlife.core.i.b(b.m(), "MD <--- HU: HFP CONNECTED,Local Address = " + str + ",Connected Address = " + paramMessage);
              if (!TextUtils.isEmpty(paramMessage))
              {
                if (paramMessage.toLowerCase().equals(str)) {
                  b.this.z = true;
                }
              }
              else
              {
                com.baidu.carlife.core.i.b(b.m(), "HU has connected with unknown device");
                return;
                com.baidu.carlife.core.i.b(b.m(), "MD <--- HU: HFP CONNECTING,Local Address = " + str + ",Connected Address = " + paramMessage);
                if (!TextUtils.isEmpty(paramMessage))
                {
                  com.baidu.carlife.core.i.b(b.m(), "Connecting with address = " + paramMessage);
                  return;
                }
                com.baidu.carlife.core.i.b(b.m(), "Connecting with unknonw device");
              }
            }
          }
          else
          {
            com.baidu.carlife.core.i.b(b.m(), "Disconnected with unkownn device");
            return;
            paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
          }
          try
          {
            paramMessage = CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.parseFrom(paramMessage.f());
            if (paramMessage != null)
            {
              i = paramMessage.getState();
              com.baidu.carlife.core.i.b(b.m(), "MD<---HU: HFP indication state = " + i);
              switch (i)
              {
              default: 
                return;
              }
            }
          }
          catch (InvalidProtocolBufferException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        paramMessage = paramMessage.getPhoneNum();
        if (!TextUtils.isEmpty(paramMessage))
        {
          com.baidu.carlife.core.i.b(b.m(), "New incoming call, Number :" + paramMessage);
          b.this.b(2);
        }
        for (;;)
        {
          paramMessage = b.a(b.this).iterator();
          while (paramMessage.hasNext()) {
            ((d)paramMessage.next()).a();
          }
          com.baidu.carlife.core.i.b(b.m(), "New incoming call, Number : unkown");
        }
        com.baidu.carlife.core.i.b(b.m(), "New outgoning call");
        b.this.b(3);
        paramMessage = b.a(b.this).iterator();
        while (paramMessage.hasNext()) {
          ((d)paramMessage.next()).b();
        }
        com.baidu.carlife.core.i.b(b.m(), "Call is active");
        b.this.b(1);
        paramMessage = b.a(b.this).iterator();
        while (paramMessage.hasNext()) {
          ((d)paramMessage.next()).c();
        }
        com.baidu.carlife.core.i.b(b.m(), "Call is inactive");
        b.this.b(0);
        paramMessage = b.a(b.this).iterator();
        while (paramMessage.hasNext()) {
          ((d)paramMessage.next()).d();
        }
        com.baidu.carlife.core.i.b(b.m(), "MultiCall is active");
        b.this.b(4);
        paramMessage = b.a(b.this).iterator();
        while (paramMessage.hasNext()) {
          ((d)paramMessage.next()).e();
        }
      }
      if (b.f(b.this) > b.g(b.this))
      {
        com.baidu.carlife.core.i.b(b.m(), "MD<---HU: HFP Response timeout,requestNum=" + b.f(b.this) + ",responseNum=" + b.g(b.this));
        if (b.e(b.this) != null)
        {
          paramMessage = b.e(b.this).iterator();
          while (paramMessage.hasNext()) {
            ((b.a)paramMessage.next()).a(0, 0, 0);
          }
        }
      }
      else
      {
        com.baidu.carlife.core.i.b(b.m(), "MD<---HU: HFP Response suc,requestNum=" + b.f(b.this) + ",responseNum=" + b.g(b.this));
      }
      b.a(b.this, 0);
      b.b(b.this, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */