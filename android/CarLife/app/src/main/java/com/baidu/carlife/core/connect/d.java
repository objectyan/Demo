package com.baidu.carlife.core.connect;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;

public class d
  implements h
{
  private static final String a = "ConnectClient";
  private static final String b = "ConnectClientHandlerThread";
  private static d l = null;
  private Context c = null;
  private ConnectServiceReceiver d = null;
  private UsbConnectStateReceiver e = null;
  private a f = null;
  private Messenger g = null;
  private Messenger h = null;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private ServiceConnection m = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      i.b("ConnectClient", "onServiceConnected");
      d.b(d.this, true);
      d.a(d.this, new Messenger(paramAnonymousIBinder));
      paramAnonymousComponentName = Message.obtain(null, 901);
      d.this.a(paramAnonymousComponentName);
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      i.b("ConnectClient", "onServiceDisconnected");
      d.b(d.this, false);
      d.a(d.this, null);
    }
  };
  
  public static d a()
  {
    if (l == null) {}
    try
    {
      if (l == null) {
        l = new d();
      }
      return l;
    }
    finally {}
  }
  
  private void e()
  {
    i.b("ConnectClient", "start ConnectService");
    Intent localIntent = new Intent(this.c, ConnectService.class);
    this.c.startService(localIntent);
  }
  
  private void f()
  {
    i.b("ConnectClient", "stop ConnectService");
    Intent localIntent = new Intent(this.c, ConnectService.class);
    this.c.stopService(localIntent);
  }
  
  private void g()
  {
    i.b("ConnectClient", "bind ConnectService");
    Intent localIntent = new Intent(this.c, ConnectService.class);
    this.c.bindService(localIntent, this.m, 1);
  }
  
  private void h()
  {
    i.b("ConnectClient", "unbind ConnectService");
    this.c.unbindService(this.m);
    a(Message.obtain(null, 902));
  }
  
  private void i()
  {
    if (this.d != null)
    {
      this.d.a();
      i.b("ConnectClient", "register ConnectServiceReceiver");
    }
  }
  
  private void j()
  {
    if (this.e != null)
    {
      this.e.a();
      i.b("ConnectClient", "register UsbConnectStateReceiver");
    }
  }
  
  private void k()
  {
    if (this.d != null)
    {
      this.d.b();
      i.b("ConnectClient", "unregister ConnectServiceReceiver");
    }
  }
  
  private void l()
  {
    if (this.e != null)
    {
      this.e.b();
      i.b("ConnectClient", "unregister UsbConnectStateReceiver");
    }
  }
  
  public void a(Context paramContext)
  {
    i.b("ConnectClient", "init");
    this.c = paramContext;
    HandlerThread localHandlerThread = new HandlerThread("ConnectClientHandlerThread");
    localHandlerThread.start();
    this.f = new a(localHandlerThread.getLooper());
    this.h = new Messenger(this.f);
    this.d = new ConnectServiceReceiver(paramContext, this.f);
    this.e = new UsbConnectStateReceiver(paramContext, this.f);
    try
    {
      i();
      j();
      g();
      return;
    }
    catch (Exception paramContext)
    {
      i.e("ConnectClient", "UsbConnectStateManager init fail");
      paramContext.printStackTrace();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 185	com/baidu/carlife/core/connect/d:c	()Z
    //   6: ifeq +21 -> 27
    //   9: iload_1
    //   10: ifne +17 -> 27
    //   13: aload_0
    //   14: iload_1
    //   15: putfield 60	com/baidu/carlife/core/connect/d:j	Z
    //   18: sipush 1002
    //   21: invokestatic 190	com/baidu/carlife/core/k:b	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: invokevirtual 185	com/baidu/carlife/core/connect/d:c	()Z
    //   31: ifne -7 -> 24
    //   34: iload_1
    //   35: ifeq -11 -> 24
    //   38: aload_0
    //   39: iload_1
    //   40: putfield 60	com/baidu/carlife/core/connect/d:j	Z
    //   43: sipush 1004
    //   46: invokestatic 190	com/baidu/carlife/core/k:b	(I)V
    //   49: goto -25 -> 24
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	d
    //   0	57	1	paramBoolean	boolean
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	52	finally
    //   13	24	52	finally
    //   27	34	52	finally
    //   38	49	52	finally
  }
  
  public boolean a(Message paramMessage)
  {
    i.b("ConnectClient", "Send Msg to Service, what = 0x" + j.a(paramMessage.what, 8));
    if (this.g == null)
    {
      i.e("ConnectClient", "mConnectService is null");
      return false;
    }
    if (this.h == null)
    {
      i.e("ConnectClient", "mConnectClient is null");
      return false;
    }
    try
    {
      paramMessage.replyTo = this.h;
      this.g.send(paramMessage);
      return true;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    i.b("ConnectClient", "uninit");
    try
    {
      k();
      l();
      h();
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectClient", "UsbConnectStateManager uninit fail");
      localException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public boolean d()
  {
    return this.i;
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
      if (paramMessage == null) {}
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1032: 
            case 1033: 
            default: 
              super.handleMessage(paramMessage);
              return;
            case 1031: 
              if (paramMessage.arg1 == 1032)
              {
                d.a(d.this, true);
                i.e("ConnectClient", "USB Cable is connected!");
                return;
              }
              break;
            }
          } while (paramMessage.arg1 != 1033);
          d.a(d.this, false);
          i.e("ConnectClient", "USB Cable is disconnected!");
        } while ((e.a().b() != 2) || (!d.a(d.this)));
        d.this.a(false);
        return;
        if (paramMessage.arg1 == 1035)
        {
          d.b(d.this);
          return;
        }
      } while (paramMessage.arg1 != 1036);
      d.c(d.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */