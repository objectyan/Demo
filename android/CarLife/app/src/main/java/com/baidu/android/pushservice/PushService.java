package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.a.a.a;
import com.baidu.android.pushservice.a.b;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.j.d;
import com.baidu.android.pushservice.j.p;
import org.json.JSONObject;

public class PushService
  extends Service
{
  private boolean a = false;
  private Handler b = new Handler();
  private SDcardRemovedReceiver c;
  private boolean d = false;
  private Runnable e = new Runnable()
  {
    public void run()
    {
      int j = 1;
      PushService.this.stopSelf();
      g.b();
      int i;
      if (PushService.a(PushService.this) > 0)
      {
        i = 1;
        if (PushService.this.getPackageName().equals(p.v(PushService.this.getApplicationContext()))) {
          break label66;
        }
      }
      for (;;)
      {
        if ((i & j) != 0) {
          PushService.this.onDestroy();
        }
        return;
        i = 0;
        break;
        label66:
        j = 0;
      }
    }
  };
  private int f = 0;
  private final a.a g = new a.a()
  {
    public int a(String paramAnonymousString, int paramAnonymousInt)
      throws RemoteException
    {
      return 0;
    }
    
    public String a()
      throws RemoteException
    {
      return null;
    }
    
    public String a(String paramAnonymousString)
      throws RemoteException
    {
      return null;
    }
    
    public String a(String paramAnonymousString, int paramAnonymousInt1, boolean paramAnonymousBoolean, int paramAnonymousInt2, int paramAnonymousInt3)
      throws RemoteException
    {
      return null;
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2, b paramAnonymousb)
      throws RemoteException
    {
      paramAnonymousb.b(30602, PushService.a(PushService.this, paramAnonymousString1, null));
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, b paramAnonymousb)
      throws RemoteException
    {
      paramAnonymousb.a(30602, PushService.a(PushService.this, paramAnonymousString1, null));
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean, String paramAnonymousString3, b paramAnonymousb)
      throws RemoteException
    {
      paramAnonymousb.a(30602, PushService.a(PushService.this, paramAnonymousString1, paramAnonymousString1));
    }
    
    public boolean a(String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      return true;
    }
    
    public boolean a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      throws RemoteException
    {
      return true;
    }
    
    public boolean a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      throws RemoteException
    {
      return true;
    }
    
    public boolean a(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      return true;
    }
    
    public int b(String paramAnonymousString)
      throws RemoteException
    {
      return 0;
    }
    
    public int b(String paramAnonymousString, int paramAnonymousInt)
      throws RemoteException
    {
      return 0;
    }
    
    public String b()
      throws RemoteException
    {
      return null;
    }
    
    public void b(String paramAnonymousString1, String paramAnonymousString2, b paramAnonymousb)
      throws RemoteException
    {
      paramAnonymousb.c(30602, PushService.a(PushService.this, paramAnonymousString1, null));
    }
    
    public boolean b(String paramAnonymousString1, String paramAnonymousString2)
      throws RemoteException
    {
      return true;
    }
    
    public int c()
      throws RemoteException
    {
      return a.a();
    }
    
    public int c(String paramAnonymousString)
      throws RemoteException
    {
      return 0;
    }
    
    public int c(String paramAnonymousString, int paramAnonymousInt)
      throws RemoteException
    {
      return 0;
    }
    
    public int d(String paramAnonymousString)
      throws RemoteException
    {
      return 0;
    }
    
    public boolean e(String paramAnonymousString)
      throws RemoteException
    {
      return true;
    }
    
    public String f(String paramAnonymousString)
      throws RemoteException
    {
      return null;
    }
  };
  
  private String a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error", 30602);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("app_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("api_key", paramString2);
      }
      localJSONObject.put("error_msg", "NOT SUPPORTED ANYMORE");
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    return localJSONObject.toString();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    com.baidu.android.pushservice.g.a.a("PushService", "stopSelf : exitOnDestroy=" + paramBoolean1 + " --- immediate=" + paramBoolean2, getApplicationContext());
    if (paramBoolean2)
    {
      this.e.run();
      return;
    }
    this.b.removeCallbacks(this.e);
    this.b.postDelayed(this.e, 3000L);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    this.f += 1;
    if (this.d) {
      return this.g;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    com.baidu.android.pushservice.g.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
    p.b("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
    this.d = g.a(this).a();
    if (!this.d)
    {
      a(true, false);
      return;
    }
    try
    {
      this.c = new SDcardRemovedReceiver();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      registerReceiver(this.c, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.b(getApplicationContext(), null);
    com.baidu.android.pushservice.g.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
    p.b("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
    if (this.c != null) {}
    try
    {
      unregisterReceiver(this.c);
      g.b();
      if (this.a) {
        Process.killProcess(Process.myPid());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      paramIntent = new Intent();
      com.baidu.android.pushservice.g.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
    }
    for (;;)
    {
      this.b.removeCallbacks(this.e);
      if ("com.baidu.android.pushservice.action.CROSS_REQUEST".equals(paramIntent.getAction()))
      {
        if (a.b() > 0) {
          paramIntent.putExtra("bd.message.rate.BACK", System.currentTimeMillis());
        }
        d.a(getApplicationContext(), paramIntent);
      }
      try
      {
        this.d = g.a(this).a(paramIntent);
        if (this.d) {
          break;
        }
        a(true, false);
        return 2;
      }
      catch (Exception paramIntent)
      {
        String str;
        a(true, false);
        return 2;
      }
      try
      {
        str = paramIntent.toUri(0);
        p.b("PushService onStartCommand from " + getPackageName() + " Intent " + str + " at Time " + System.currentTimeMillis(), getApplicationContext());
      }
      catch (Exception localException) {}
    }
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    this.f -= 1;
    return super.onUnbind(paramIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */