package com.baidu.location.d.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.format.Time;
import com.baidu.location.Jni;
import com.baidu.location.f.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class a
{
  public static boolean a = true;
  boolean b = false;
  Runnable c = new Runnable()
  {
    public void run()
    {
      g.a().b();
      e.a().b();
      a.this.c();
    }
  };
  private Context d = null;
  private Handler e = null;
  private AlarmManager f = null;
  private a g = null;
  private PendingIntent h = null;
  private final long i = 600000L;
  private long j = 600000L;
  private PowerManager.WakeLock k = null;
  private f.a l = null;
  private f.a m = null;
  
  private a()
  {
    Object localObject = (PowerManager)this.d.getSystemService("power");
    try
    {
      this.k = ((PowerManager)localObject).newWakeLock(1, "LbsLocWackLock");
      this.k.setReferenceCounted(false);
      g.a().a(new d());
      if ((f.a().b() != null) && (f.a().b().a.containsKey("level0"))) {}
      for (this.l = ((f.a)f.a().b().a.get("level0"));; this.l = new f.a((f)localObject, true))
      {
        if (this.l != null) {
          this.l.a();
        }
        this.e = new Handler()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            if (!com.baidu.location.f.isServing) {
              return;
            }
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            }
            try
            {
              a.a(a.this);
              a.b(a.this);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              paramAnonymousMessage = paramAnonymousMessage;
              a.b(a.this);
              return;
            }
            finally
            {
              paramAnonymousMessage = finally;
              a.b(a.this);
              throw paramAnonymousMessage;
            }
          }
        };
        return;
        localObject = f.a();
        localObject.getClass();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static a a()
  {
    return b.a;
  }
  
  private String a(com.baidu.location.f.a parama, com.baidu.location.f.e parame, Location paramLocation, String paramString)
  {
    return Jni.encodeTp4(com.baidu.location.h.g.a(parama, parame, paramLocation, paramString));
  }
  
  private void a(String paramString)
  {
    if (e() != com.baidu.location.h.c.a().f())
    {
      new c(paramString).b();
      com.baidu.location.h.c.a().f(e());
    }
  }
  
  public static int e()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.yearDay;
  }
  
  public static int f()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.hour;
  }
  
  private void g()
  {
    if (a) {
      this.f.set(0, System.currentTimeMillis() + this.j, this.h);
    }
  }
  
  private void h()
  {
    if (!a) {
      return;
    }
    Object localObject = b.a().f().h();
    int n;
    if ((f.a().b() != null) && (f.a().b().c.containsKey(localObject)))
    {
      localObject = (String)f.a().b().c.get(localObject);
      this.m = ((f.a)f.a().b().a.get(localObject));
      if (this.m == null) {
        this.m = this.l;
      }
      int i1 = f();
      localObject = this.m.b.iterator();
      n = 0;
      label119:
      if (!((Iterator)localObject).hasNext()) {
        break label173;
      }
      f.c localc = (f.c)((Iterator)localObject).next();
      if ((i1 > localc.b) || (i1 < localc.a)) {
        break label236;
      }
      n = 1;
    }
    label173:
    label236:
    for (;;)
    {
      break label119;
      this.m = this.l;
      break;
      if (n != 0)
      {
        if (f.a().b(com.baidu.location.h.g.c()) < this.m.c)
        {
          this.j = (this.m.f * 60 * 1000);
          i();
          return;
        }
        this.j = 3600000L;
        return;
      }
      this.j = 3600000L;
      return;
    }
  }
  
  private void i()
  {
    if ((com.baidu.location.b.c.a().f() > this.m.g * 100.0D) || (com.baidu.location.b.c.a().f() < this.m.h * 100.0D)) {}
    while (!com.baidu.location.f.f.a().t()) {
      return;
    }
    if (!m())
    {
      if (this.m.a != this.l.a)
      {
        k();
        return;
      }
      j();
      return;
    }
    k();
  }
  
  private void j()
  {
    String str2;
    if (e() != com.baidu.location.h.c.a().f())
    {
      str2 = com.baidu.location.a.a.a().f();
      if (!com.baidu.location.f.f.j()) {
        break label73;
      }
    }
    label73:
    for (String str1 = "&cn=32";; str1 = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(b.a().e()) }))
    {
      str1 = str1 + str2;
      a(a(b.a().f(), com.baidu.location.f.f.a().p(), null, str1));
      return;
    }
  }
  
  private void k()
  {
    if (f.a().b(com.baidu.location.h.g.c()) < this.m.c) {
      l();
    }
  }
  
  private void l()
  {
    try
    {
      this.k.acquire();
      this.b = true;
      this.e.postDelayed(this.c, 4500L);
      int n = this.m.e;
      g.a().a((n + 1) * 30);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private boolean m()
  {
    com.baidu.location.f.e locale = com.baidu.location.f.f.a().q();
    if ((locale == null) || (locale.a == null) || (locale.a.size() == 0)) {}
    while (((ScanResult)locale.a.get(0)).level < -70) {
      return false;
    }
    try
    {
      bool = h.a(locale.a);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public void b()
  {
    this.g = new a(null);
    this.f = ((AlarmManager)this.d.getSystemService("alarm"));
    this.d.registerReceiver(this.g, new IntentFilter("com.baidu.location.sen7.3.2"));
    this.h = PendingIntent.getBroadcast(this.d, 0, new Intent("com.baidu.location.sen7.3.2"), 134217728);
    this.f.set(0, System.currentTimeMillis() + 2000L, this.h);
  }
  
  public void c()
  {
    try
    {
      if ((this.k != null) && (this.k.isHeld())) {
        this.k.release();
      }
      this.b = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void d()
  {
    g.a().b();
    e.a().b();
    c();
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("com.baidu.location.sen7.3.2")) {
        a.d(a.this).sendEmptyMessage(1);
      }
    }
  }
  
  private static class b
  {
    public static final a a = new a(null);
  }
  
  private class c
    extends com.baidu.location.h.e
  {
    private String b;
    
    public c(String paramString)
    {
      this.b = paramString;
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = com.baidu.location.h.g.e();
      this.k.put("xlsm", this.b);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null) && (this.j.contains("161"))) {
        a.c(a.this);
      }
    }
    
    public void b()
    {
      i();
    }
  }
  
  class d
    implements g.a
  {
    d() {}
    
    public void a(int paramInt)
    {
      a.d(a.this).removeCallbacks(a.this.c);
      if (paramInt == 0)
      {
        g.a().b();
        e.a().b();
        a.this.c();
      }
      if (paramInt == 1)
      {
        a.a(a.this, 3600000L);
        com.baidu.location.h.c.a().c(a.e());
        f.a().a(com.baidu.location.h.g.c());
        e.a().a(a.e(a.this).d * 60 * 1000);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */