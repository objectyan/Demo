package com.baidu.location.g;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.a.m;
import com.baidu.location.d.n;
import com.baidu.location.wifihistory.SClient;
import org.json.JSONObject;

public class a
  extends Service
  implements LLSInterface
{
  static a a = null;
  private static long f = 0L;
  Messenger b = null;
  private Looper c;
  private HandlerThread d;
  private boolean e = false;
  
  public static Handler a()
  {
    return a;
  }
  
  private void a(Message paramMessage)
  {
    Log.d("baidu_location_service", "baidu location service register ...");
    com.baidu.location.d.f.a().a("service register!");
    com.baidu.location.a.a.a().a(paramMessage);
    com.baidu.location.e.d.a();
    com.baidu.location.b.d.a().d();
    com.baidu.location.a.j.b().c();
  }
  
  public static long b()
  {
    return f;
  }
  
  private void b(Message paramMessage)
  {
    com.baidu.location.a.a.a().b(paramMessage);
  }
  
  private void c()
  {
    com.baidu.location.a.g.a().a(com.baidu.location.f.getServiceContext());
    com.baidu.location.d.l.a().a(this.c);
    SClient.getInstance().start();
    com.baidu.location.d.a.f.a();
    com.baidu.location.d.a.a.a().b();
    com.baidu.location.d.a.e.a();
    com.baidu.location.d.j.b().e();
    n.a().b();
    com.baidu.location.indoor.a.a.b().e();
    com.baidu.location.c.b.a().a(604800);
    com.baidu.location.c.a.b();
    com.baidu.location.a.e.a().b();
    com.baidu.location.f.d.a().b();
    com.baidu.location.f.b.a().b();
    com.baidu.location.h.b.a();
    com.baidu.location.a.h.c().d();
    com.baidu.location.e.a.a().b();
    com.baidu.location.b.c.a().b();
    com.baidu.location.b.d.a().b();
    com.baidu.location.b.e.a().b();
    com.baidu.location.b.a.a().b();
    com.baidu.location.b.f.a().b();
    com.baidu.location.f.f.a().c();
  }
  
  private void c(Message paramMessage)
  {
    com.baidu.location.a.a.a().c(paramMessage);
  }
  
  private void d()
  {
    com.baidu.location.f.f.a().e();
    com.baidu.location.e.d.a().o();
    com.baidu.location.f.d.a().f();
    com.baidu.location.b.g.a().c();
    com.baidu.location.b.d.a().c();
    com.baidu.location.b.c.a().c();
    com.baidu.location.b.b.a().c();
    com.baidu.location.b.a.a().c();
    com.baidu.location.a.b.a().b();
    com.baidu.location.f.b.a().c();
    com.baidu.location.a.h.c().e();
    com.baidu.location.indoor.d.a().d();
    com.baidu.location.d.j.b().f();
    n.a().c();
    com.baidu.location.a.e.a().c();
    m.g();
    com.baidu.location.a.a.a().b();
    com.baidu.location.d.f.a().c();
    Log.d("baidu_location_service", "baidu location service has stoped ...");
    Process.killProcess(Process.myPid());
  }
  
  public double getVersion()
  {
    return 7.320000171661377D;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    boolean bool = false;
    if (paramIntent != null)
    {
      com.baidu.location.h.b.g = paramIntent.getString("key");
      com.baidu.location.h.b.f = paramIntent.getString("sign");
      this.e = paramIntent.getBoolean("kill_process");
      bool = paramIntent.getBoolean("cache_exception");
    }
    if (!bool) {}
    return this.b.getBinder();
  }
  
  public void onCreate(Context paramContext)
  {
    f = System.currentTimeMillis();
    this.d = com.baidu.location.a.l.a();
    this.c = this.d.getLooper();
    if (this.c == null) {}
    for (a = new a(Looper.getMainLooper());; a = new a(this.c))
    {
      this.b = new Messenger(a);
      a.sendEmptyMessage(0);
      com.baidu.location.d.f.a().b();
      com.baidu.location.d.f.a().a("service creat!");
      Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
      return;
    }
  }
  
  public void onDestroy()
  {
    com.baidu.location.a.a.a().a(new Bundle(), 502);
    com.baidu.location.d.f.a().a("service destroy!");
    com.baidu.location.d.f.a().d();
    try
    {
      a.sendEmptyMessage(1);
      Log.d("baidu_location_service", "baidu location service stop ...");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("baidu_location_service", "baidu location service stop exception...");
        d();
        Process.killProcess(Process.myPid());
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    Log.d("baidu_location_service", "baidu location service remove task...");
  }
  
  public boolean onUnBind(Intent paramIntent)
  {
    return false;
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int j = 0;
      if (com.baidu.location.f.isServing == true) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        if (paramMessage.what == 1) {
          a.a(a.this);
        }
        if (paramMessage.what == 0) {
          a.b(a.this);
        }
        super.handleMessage(paramMessage);
        return;
        a.a(a.this, paramMessage);
        continue;
        a.b(a.this, paramMessage);
        continue;
        a.c(a.this, paramMessage);
        continue;
        com.baidu.location.a.h.c().b(paramMessage);
        continue;
        com.baidu.location.a.h.c().a(true, true);
        continue;
        com.baidu.location.a.h.c().j();
        continue;
        com.baidu.location.indoor.d.a().c();
        continue;
        com.baidu.location.indoor.d.a().d();
        continue;
        com.baidu.location.indoor.d.a().b();
        continue;
        com.baidu.location.indoor.d.a().e();
        continue;
        for (;;)
        {
          Bundle localBundle1;
          try
          {
            localBundle1 = paramMessage.getData();
          }
          catch (Exception localException1) {}
          try
          {
            localObject2 = new JSONObject(localBundle1.getString("ugcInfo", ""));
            if ((!((JSONObject)localObject2).has("action")) || (!((JSONObject)localObject2).has("status"))) {
              break label638;
            }
            if (((JSONObject)localObject2).getInt("status") != 1) {
              break label386;
            }
            com.baidu.location.d.c.a().a(false);
            i = j;
          }
          catch (Exception localException5)
          {
            i = 1;
            continue;
          }
          if (i == 0) {
            break;
          }
          Object localObject2 = com.baidu.location.d.d.a().e().obtainMessage(2);
          ((Message)localObject2).setData(localBundle1);
          ((Message)localObject2).sendToTarget();
          break;
          break;
          label386:
          int i = j;
          Message localMessage;
          if (((JSONObject)localObject2).getInt("status") == 0)
          {
            com.baidu.location.d.c.a().a(true);
            i = j;
            continue;
            byte[] arrayOfByte = paramMessage.getData().getByteArray("errorid");
            localMessage = null;
            Object localObject1 = localMessage;
            if (arrayOfByte != null)
            {
              localObject1 = localMessage;
              if (arrayOfByte.length > 0) {
                localObject1 = new String(arrayOfByte);
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            com.baidu.location.d.f.a().a("receive errorreportid = " + (String)localObject1);
            com.baidu.location.d.f.a().c((String)localObject1);
            break;
            com.baidu.location.a.e.a().e();
            break;
            try
            {
              boolean bool = paramMessage.getData().getBoolean("user");
              com.baidu.location.a.e.a().a(bool);
            }
            catch (Exception localException2) {}
            break;
          }
          Bundle localBundle2;
          try
          {
            localBundle2 = paramMessage.getData();
            i = localBundle2.getInt("status", 0);
            j = localBundle2.getInt("source", 0);
            if (i == 1)
            {
              com.baidu.location.d.h.a().a(j);
              break;
            }
            if (i != 2) {
              break;
            }
            com.baidu.location.d.h.a().c();
          }
          catch (Exception localException4) {}
          try
          {
            localBundle2 = paramMessage.getData();
            if (localBundle2 == null) {
              break;
            }
            localMessage = com.baidu.location.d.d.a().e().obtainMessage(3);
            localMessage.setData(localBundle2);
            localMessage.sendToTarget();
          }
          catch (Exception localException3) {}
          break;
          label638:
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */