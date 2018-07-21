package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class e
  implements h
{
  public static final String a = "ConnectManager";
  public static final String b = "AcceptThread";
  public static final int c = 1000;
  public static final int d = 1000;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static int h = 1;
  private static e w = null;
  private static int y = 6;
  private Timer A = null;
  private TimerTask B = null;
  private DatagramSocket C = null;
  private DatagramPacket D = null;
  private boolean E = false;
  private a i = null;
  private a j = null;
  private a k = null;
  private a l = null;
  private a m = null;
  private a n = null;
  private a o = null;
  private g p = null;
  private g q = null;
  private g r = null;
  private g s = null;
  private g t = null;
  private g u = null;
  private g v = null;
  private int x = 0;
  private boolean z = false;
  
  public static e a()
  {
    if (w == null) {}
    try
    {
      if (w == null) {
        w = new e();
      }
      return w;
    }
    finally {}
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString.contains(":")) {
      bool = true;
    }
    return bool;
  }
  
  private String j()
  {
    i.b("ConnectManager", "getLocalHostIp ");
    Object localObject1 = null;
    String str = null;
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      Object localObject2;
      for (;;)
      {
        localObject1 = str;
        localObject2 = str;
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localObject1 = str;
        localObject2 = (NetworkInterface)localEnumeration.nextElement();
        localObject1 = str;
        i.b("ConnectManager", "name  : " + ((NetworkInterface)localObject2).getName());
        localObject1 = str;
        if (!((NetworkInterface)localObject2).getName().equals("wlan0"))
        {
          localObject1 = str;
          if (!((NetworkInterface)localObject2).getName().equals("ap0")) {}
        }
        else
        {
          localObject1 = str;
          localObject2 = ((NetworkInterface)localObject2).getInterfaceAddresses().iterator();
          InterfaceAddress localInterfaceAddress;
          Object localObject3;
          do
          {
            do
            {
              localObject1 = str;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = str;
              localInterfaceAddress = (InterfaceAddress)((Iterator)localObject2).next();
              localObject1 = str;
              localObject3 = localInterfaceAddress.getAddress();
              localObject1 = str;
            } while (((InetAddress)localObject3).isLoopbackAddress());
            localObject1 = str;
            localObject3 = ((InetAddress)localObject3).getHostAddress();
            localObject1 = str;
            i.b("ConnectManager", "hostAddress : " + (String)localObject3);
            localObject1 = str;
          } while (a((String)localObject3));
          localObject1 = str;
          str = localInterfaceAddress.getBroadcast().getHostAddress();
          localObject1 = str;
          i.b("ConnectManager", "broadcastAddress : " + str);
        }
      }
      return (String)localObject2;
    }
    catch (SocketException localSocketException)
    {
      i.e("ConnectManager", "获取本地ip地址失败");
      localSocketException.printStackTrace();
      localObject2 = localObject1;
    }
  }
  
  public int a(c paramc)
  {
    if (this.p == null)
    {
      i.e("ConnectManager", "write error: connectSocket is null");
      return -1;
    }
    return this.p.a(paramc);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.q == null)
    {
      i.e("ConnectManager", "write error: video connectSocket is null");
      return -1;
    }
    return this.q.a(paramArrayOfByte, paramInt);
  }
  
  public void a(int paramInt)
  {
    h = paramInt;
  }
  
  public void a(g paramg)
  {
    for (;;)
    {
      try
      {
        if (!paramg.a().equals("Data")) {
          this.x += 1;
        }
        if (this.x >= y) {
          d.a().a(true);
        }
        try
        {
          if (paramg.a().equals("Cmd"))
          {
            this.p = paramg;
            return;
          }
          if (paramg.a().equals("Video"))
          {
            this.q = paramg;
            continue;
          }
        }
        catch (Exception paramg)
        {
          i.e("ConnectManager", "Add ConnectSocket Fail");
          paramg.printStackTrace();
          continue;
        }
        if (!paramg.a().equals("Media")) {
          break label125;
        }
      }
      finally {}
      this.r = paramg;
      continue;
      label125:
      if (paramg.a().equals("TTS")) {
        this.s = paramg;
      } else if (paramg.a().equals("VR")) {
        this.t = paramg;
      } else if (paramg.a().equals("Touch")) {
        this.u = paramg;
      } else if (paramg.a().equals("Data")) {
        this.v = paramg;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public int b()
  {
    return h;
  }
  
  public int b(c paramc)
  {
    if (this.v == null)
    {
      i.e("ConnectManager", "write error: Date connectSocket is null");
      return -1;
    }
    return this.v.a(paramc);
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.q == null)
    {
      i.e("ConnectManager", "read error: video connectSocket is null");
      return -1;
    }
    return this.q.b(paramArrayOfByte, paramInt);
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.r == null)
    {
      i.e("ConnectManager", "write error: audio connectSocket is null");
      return -1;
    }
    return this.r.a(paramArrayOfByte, paramInt);
  }
  
  public void c()
  {
    try
    {
      this.i = new a(7240, "Cmd");
      this.i.start();
      this.j = new a(8240, "Video");
      this.j.start();
      this.k = new a(9240, "Media");
      this.k.start();
      this.l = new a(9241, "TTS");
      this.l.start();
      this.m = new a(9242, "VR");
      this.m.start();
      this.n = new a(9340, "Touch");
      this.n.start();
      this.o = new a(9440, "Data");
      this.o.start();
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectManager", "Start Accept Thread Fail");
      localException.printStackTrace();
    }
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.r == null)
    {
      i.e("ConnectManager", "read error: audio connectSocket is null");
      return -1;
    }
    return this.r.b(paramArrayOfByte, paramInt);
  }
  
  public void d()
  {
    try
    {
      if (this.i != null)
      {
        this.i.a();
        this.i = null;
      }
      if (this.j != null)
      {
        this.j.a();
        this.j = null;
      }
      if (this.k != null)
      {
        this.k.a();
        this.k = null;
      }
      if (this.l != null)
      {
        this.l.a();
        this.l = null;
      }
      if (this.m != null)
      {
        this.m.a();
        this.m = null;
      }
      if (this.n != null)
      {
        this.n.a();
        this.n = null;
      }
      if (this.o != null)
      {
        this.o.a();
        this.o = null;
      }
      e();
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectManager", "Stop Accept Thread Fail");
      localException.printStackTrace();
    }
  }
  
  public int e(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.s == null)
    {
      i.e("ConnectManager", "write error: tts connectSocket is null");
      return -1;
    }
    return this.s.a(paramArrayOfByte, paramInt);
  }
  
  public void e()
  {
    this.x = 0;
    this.z = false;
    f();
  }
  
  public int f(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.s == null)
    {
      i.e("ConnectManager", "read error: tts connectSocket is null");
      return -1;
    }
    return this.s.b(paramArrayOfByte, paramInt);
  }
  
  public void f()
  {
    try
    {
      if (this.p != null)
      {
        this.p.d();
        this.p = null;
      }
      if (this.q != null)
      {
        this.q.d();
        this.q = null;
      }
      if (this.r != null)
      {
        this.r.d();
        this.r = null;
      }
      if (this.s != null)
      {
        this.s.d();
        this.s = null;
      }
      if (this.t != null)
      {
        this.t.d();
        this.t = null;
      }
      if (this.u != null)
      {
        this.u.d();
        this.u = null;
      }
      if (this.v != null)
      {
        this.v.d();
        this.v = null;
      }
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectManager", "Stop Connect Socket Fail");
      localException.printStackTrace();
    }
  }
  
  public int g(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.t == null)
    {
      i.e("ConnectManager", "write error: VR connectSocket is null");
      return -1;
    }
    return this.t.a(paramArrayOfByte, paramInt);
  }
  
  public boolean g()
  {
    return this.z;
  }
  
  public int h(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.t == null)
    {
      i.e("ConnectManager", "read error: VR connectSocket is null");
      return -1;
    }
    return this.t.b(paramArrayOfByte, paramInt);
  }
  
  public void h()
  {
    if (!this.E) {
      return;
    }
    try
    {
      i.b("ConnectManager", "start udp send timer");
      this.C = new DatagramSocket();
      this.A = new Timer();
      this.B = new TimerTask()
      {
        public void run()
        {
          Object localObject = e.a(e.this);
          byte[] arrayOfByte;
          if (localObject != null)
          {
            i.b("ConnectManager", "send udp address : " + (String)localObject);
            arrayOfByte = "CarlifeHost".getBytes();
          }
          try
          {
            localObject = InetAddress.getByName((String)localObject);
            e.a(e.this, new DatagramPacket(arrayOfByte, arrayOfByte.length, (InetAddress)localObject, 7999));
            e.b(e.this).setBroadcast(true);
            e.b(e.this).send(e.c(e.this));
            e.b(e.this).close();
            return;
          }
          catch (UnknownHostException localUnknownHostException)
          {
            localUnknownHostException.printStackTrace();
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
      };
      this.A.schedule(this.B, 5000L, 1000L);
      return;
    }
    catch (Exception localException)
    {
      i.b("ConnectManager", "startUdpSendTimer get exception");
      localException.printStackTrace();
    }
  }
  
  public void i()
  {
    if (!this.E) {}
    do
    {
      return;
      i.b("ConnectManager", "stop udp send timer");
      if (this.A != null)
      {
        this.A.cancel();
        this.A = null;
      }
    } while (this.B == null);
    this.B.cancel();
    this.B = null;
  }
  
  private class a
    extends Thread
  {
    private ServerSocket b = null;
    private boolean c = false;
    private int d = -1;
    private String e = null;
    private String f = null;
    
    public a(int paramInt, String paramString)
    {
      try
      {
        this.f = (paramString + "AcceptThread");
        setName(this.f);
        i.b("ConnectManager", "Create " + this.f);
        this.d = paramInt;
        this.e = paramString;
        this.b = new ServerSocket(this.d);
        this.c = true;
        return;
      }
      catch (Exception this$1)
      {
        i.e("ConnectManager", "Create " + this.f + " fail");
        e.this.printStackTrace();
      }
    }
    
    public void a()
    {
      try
      {
        if (this.b != null) {
          this.b.close();
        }
        this.c = false;
        return;
      }
      catch (Exception localException)
      {
        i.e("ConnectManager", "Close " + this.f + " fail");
        localException.printStackTrace();
      }
    }
    
    public void run()
    {
      i.b("ConnectManager", "Begin to listen in " + this.f);
      while ((this.b != null) && (this.c)) {
        try
        {
          Socket localSocket = this.b.accept();
          if (localSocket != null)
          {
            i.b("ConnectManager", "One client connected in " + this.f);
            if (this.e.equals("Cmd")) {
              k.b(1003);
            }
            new g(this.e, localSocket).c();
          }
        }
        catch (Exception localException)
        {
          i.e("ConnectManager", "Get Exception in " + this.f);
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */