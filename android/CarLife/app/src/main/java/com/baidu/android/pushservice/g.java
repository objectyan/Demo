package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.IOException;

@SuppressLint({"WorldReadableFiles", "InlinedApi"})
public class g
{
  public static e a;
  private static String b = "PushSDK";
  private static g c = null;
  private static int d = 180000;
  private static int e = 1800000;
  private static final Object g = new Object();
  private static LocalServerSocket h;
  private static Object j = new Object();
  private int f;
  private Boolean i = Boolean.valueOf(false);
  private Context k;
  private Handler l;
  private boolean m;
  private PushServiceReceiver n;
  private RegistrationReceiver o;
  private boolean p;
  private Runnable q = new Runnable()
  {
    public void run()
    {
      g.this.a(new Intent());
    }
  };
  private Runnable r = new Runnable()
  {
    public void run()
    {
      g.this.d();
    }
  };
  private Runnable s = new Runnable()
  {
    public void run()
    {
      synchronized ()
      {
        if (g.a != null) {
          g.a.b();
        }
        return;
      }
    }
  };
  
  private g(Context paramContext)
  {
    this.l = new Handler(paramContext.getMainLooper());
    this.k = paramContext.getApplicationContext();
    this.f = d;
    p.g(this.k.getApplicationContext());
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new g(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static void b()
  {
    if (c != null) {
      c.j();
    }
    com.baidu.android.pushservice.i.d.a().b();
  }
  
  private boolean b(Context paramContext)
  {
    String str = p.v(paramContext);
    paramContext = paramContext.getPackageName();
    if (paramContext.equals(str))
    {
      com.baidu.android.pushservice.g.a.a(b, "Try use current push service, package name is: " + paramContext, this.k);
      return false;
    }
    com.baidu.android.pushservice.g.a.a(b, "Current push service : " + paramContext + " should stop!!!" + " highest priority service is: " + str, this.k);
    return true;
  }
  
  private void h()
  {
    if (this.n == null)
    {
      this.n = new PushServiceReceiver();
      this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
      this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
      this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.intent.action.USER_PRESENT"));
      this.k.getApplicationContext().registerReceiver(this.n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
    if (this.o == null)
    {
      this.o = new RegistrationReceiver();
      this.k.getApplicationContext().registerReceiver(this.o, new IntentFilter("android.intent.action.PACKAGE_REMOVED"));
    }
  }
  
  private void i()
  {
    if (this.o != null) {
      this.k.getApplicationContext().unregisterReceiver(this.o);
    }
    if (this.n != null) {
      this.k.getApplicationContext().unregisterReceiver(this.n);
    }
  }
  
  private void j()
  {
    com.baidu.android.pushservice.g.a.a(b, "destroy", this.k);
    try
    {
      synchronized (j)
      {
        if (h != null)
        {
          h.close();
          h = null;
        }
        if (a != null) {
          synchronized (g)
          {
            a.c();
            a = null;
          }
        }
      }
      try
      {
        com.baidu.android.pushservice.d.a.a();
        if (this.m) {
          i();
        }
        c = null;
        return;
        localObject4 = finally;
        throw ((Throwable)localObject4);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private void k()
  {
    synchronized (g)
    {
      a = e.a(this.k);
      return;
    }
  }
  
  private void l()
  {
    m();
    long l1 = System.currentTimeMillis();
    long l2 = this.f + l1;
    int i1 = (int)(l2 / 60000L % 5L);
    int i2 = (int)(l2 / 1000L);
    l1 = l2;
    if (i1 == 0)
    {
      l1 = l2;
      if (i2 % 60 < 15) {
        l1 = l2 + ((Math.random() * (this.f - 20000)) + 15000L);
      }
    }
    AlarmManager localAlarmManager = (AlarmManager)this.k.getSystemService("alarm");
    try
    {
      localAlarmManager.setRepeating(0, l1, this.f, t());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void m()
  {
    AlarmManager localAlarmManager = (AlarmManager)this.k.getSystemService("alarm");
    try
    {
      localAlarmManager.cancel(t());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void n()
  {
    com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("tryConnect", (short)98)
    {
      public void a()
      {
        if (g.e() == null) {
          return;
        }
        synchronized (g.e())
        {
          boolean bool = k.e(g.a(g.this));
          com.baidu.android.pushservice.g.a.a(g.f(), "tryConnect networkConnected :" + bool, g.a(g.this));
          if (!bool)
          {
            if (a.b() > 0) {
              q.a(g.a(g.this), "039912");
            }
            return;
          }
        }
        if (a.b() > 0) {
          q.a(g.a(g.this), "039914");
        }
        if ((g.a != null) && (!g.a.a()))
        {
          if (j.a(g.a(g.this)).c()) {
            break label160;
          }
          com.baidu.android.pushservice.g.a.d(g.f(), "Channel token is not available, start NETWORK REGISTER SERVICE .", g.a(g.this));
          g.b(g.this);
        }
        for (;;)
        {
          return;
          label160:
          g.c(g.this);
        }
      }
    });
  }
  
  private boolean o()
  {
    if (h == null) {}
    try
    {
      com.baidu.android.pushservice.d.c.b(this.k, null);
      h = new LocalServerSocket(p.p(this.k));
      s();
      com.baidu.android.pushservice.d.c.b(this.k, this.k.getPackageName());
      return true;
    }
    catch (Exception localException)
    {
      com.baidu.android.pushservice.g.a.a(b, "--- Socket Adress (" + p.p(this.k) + ") in use --- @ " + this.k.getPackageName(), this.k);
      o.b(this.k);
    }
    return false;
  }
  
  private boolean p()
  {
    boolean bool1 = true;
    com.baidu.android.pushservice.message.a.d.a(this.k);
    boolean bool2 = k.a(this.k);
    com.baidu.android.pushservice.g.a.a(b, "heartbeat networkConnected :" + bool2, this.k);
    Object localObject = p.v(this.k);
    if ((p.c(this.k)) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (!this.k.getPackageName().equals(localObject))))
    {
      m();
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (bool2) {
          break;
        }
        if (a != null) {
          a.a(true);
        }
      } while (a.b() <= 0);
      q.a(this.k, "039912");
      return true;
      if (a.b() > 0) {
        q.a(this.k, "039914");
      }
    } while (a == null);
    if (!a.a()) {
      if (!j.a(this.k).c())
      {
        com.baidu.android.pushservice.g.a.c(b, "Channel token is not available, start NETWORK REGISTER SERVICE .", this.k);
        q();
      }
    }
    for (;;)
    {
      p.b("heartbeat PushConnection isConnected " + a.a() + " at Time " + System.currentTimeMillis(), this.k.getApplicationContext());
      return true;
      r();
      continue;
      a.d();
      if (!this.p)
      {
        this.p = true;
        localObject = new Intent("com.baidu.android.pushservice.action.METHOD");
        ((Intent)localObject).putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        c().a((Intent)localObject);
      }
    }
  }
  
  private void q()
  {
    this.l.removeCallbacks(this.r);
    this.l.postDelayed(this.r, 500L);
  }
  
  private void r()
  {
    if ((h != null) || (o()))
    {
      this.l.removeCallbacks(this.s);
      this.l.postDelayed(this.s, 1000L);
    }
  }
  
  private void s()
  {
    if (!p.F(this.k))
    {
      com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_prio", a.a());
      com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg", this.k.getPackageName());
    }
    String str;
    do
    {
      return;
      str = com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg");
    } while ((TextUtils.isEmpty(str)) || (!str.equals(this.k.getPackageName())));
    com.baidu.android.pushservice.j.b.a(this.k, "com.baidu.push.cur_pkg", null);
  }
  
  private PendingIntent t()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("AlarmAlert", "OK");
    localIntent.setFlags(32);
    localIntent.setClass(this.k, PushService.class);
    return PendingIntent.getService(this.k.getApplicationContext(), 0, localIntent, 134217728);
  }
  
  public void a(int paramInt)
  {
    com.baidu.android.pushservice.g.a.a(b, "heartbeat set : " + paramInt + " secs", this.k);
    if (paramInt > 0) {
      this.f = (paramInt * 1000);
    }
    l();
  }
  
  public boolean a()
  {
    com.baidu.android.pushservice.g.a.a(b, "Create PushSDK from : " + this.k.getPackageName(), this.k);
    m();
    this.i = Boolean.valueOf(true);
    if ((p.c(this.k.getApplicationContext())) || (b(this.k)))
    {
      com.baidu.android.pushservice.g.a.a(b, "onCreate shouldStopSelf", this.k);
      return false;
    }
    synchronized (j)
    {
      if (!PushSocket.a) {
        return false;
      }
    }
    if (!o())
    {
      p.u(this.k);
      String str = p.v(this.k);
      if (!this.k.getPackageName().equals(str)) {
        return false;
      }
    }
    this.m = p.G(this.k);
    if (this.m) {
      h();
    }
    h.b(this.k);
    Thread.setDefaultUncaughtExceptionHandler(new b(this.k.getApplicationContext()));
    k();
    i.a(this.k);
    PushSettings.l(this.k);
    if (h != null)
    {
      this.l.postDelayed(this.q, 500L);
      n();
    }
    return true;
  }
  
  public boolean a(Intent arg1)
  {
    com.baidu.android.pushservice.g.a.a(b, "PushSDK handleOnStart go", this.k);
    Intent localIntent1 = ???;
    if (??? == null)
    {
      localIntent1 = new Intent();
      com.baidu.android.pushservice.g.a.c(b, "--- handleOnStart by null intent!", this.k);
    }
    if (!this.i.booleanValue()) {
      a();
    }
    boolean bool;
    synchronized (j)
    {
      this.l.removeCallbacks(this.q);
      if (h == null)
      {
        if ("com.baidu.android.pushservice.action.METHOD".equals(localIntent1.getAction()))
        {
          bool = c().a(localIntent1);
          return bool;
        }
        return true;
      }
    }
    if (localIntent2.getStringExtra("AlarmAlert") != null)
    {
      bool = p();
      return bool;
    }
    long l1;
    int i1;
    int i2;
    if ((("pushservice_restart_v2".equals(localIntent2.getStringExtra("method"))) || ("pushservice_restart_v3".equals(localIntent2.getStringExtra("method")))) && (h != null)) {
      if (p.F(this.k))
      {
        l1 = localIntent2.getLongExtra("priority3", 0L);
        com.baidu.android.pushservice.c.d.a(this.k).e();
        if ((l1 <= p.h(this.k)) || (com.baidu.android.pushservice.c.d.a(this.k).b() == 3)) {
          break label329;
        }
        i1 = 1;
        if (com.baidu.android.pushservice.c.d.a(this.k).b() != 4) {
          break label334;
        }
        i2 = 1;
        break label318;
      }
    }
    label263:
    label310:
    label318:
    label329:
    label334:
    label337:
    for (;;)
    {
      return false;
      l1 = localIntent2.getLongExtra("priority2", 0L);
      break;
      if (c().a(localIntent2))
      {
        com.baidu.android.pushservice.g.a.c(b, "-- handleOnStart -- intent handled  by mRegistrationService ", this.k);
        return true;
      }
      n();
      return true;
      for (;;)
      {
        if (i1 != 0) {
          break label337;
        }
        if (i2 == 0) {
          break label310;
        }
        break label263;
        i1 = 0;
        break;
        i2 = 0;
      }
    }
  }
  
  public i c()
  {
    return i.a(this.k);
  }
  
  void d()
  {
    com.baidu.android.pushservice.g.a.a(b, ">> sendRequestTokenIntent", this.k);
    Intent localIntent = new Intent("com.baidu.pushservice.action.TOKEN");
    o.b(this.k, localIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */