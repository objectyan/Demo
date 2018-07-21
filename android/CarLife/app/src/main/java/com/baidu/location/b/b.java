package com.baidu.location.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.a.h;
import com.baidu.location.f;
import com.baidu.location.f.d;
import com.baidu.location.h.g;

public class b
{
  private static b a = null;
  private boolean b = false;
  private Handler c = null;
  private AlarmManager d = null;
  private a e = null;
  private PendingIntent f = null;
  private long g = 0L;
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private void f()
  {
    if (System.currentTimeMillis() - this.g < 1000L) {}
    Message localMessage;
    do
    {
      do
      {
        return;
        if (this.f != null)
        {
          this.d.cancel(this.f);
          this.f = null;
        }
        if (this.f == null)
        {
          this.f = PendingIntent.getBroadcast(f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.3.2"), 134217728);
          this.d.set(0, System.currentTimeMillis() + g.V, this.f);
        }
        localMessage = new Message();
        localMessage.what = 22;
      } while (System.currentTimeMillis() - this.g < g.W);
      this.g = System.currentTimeMillis();
    } while (d.a().m());
    h.c().b(localMessage);
  }
  
  private void g()
  {
    if (!this.b) {
      return;
    }
    try
    {
      if (this.f != null)
      {
        this.d.cancel(this.f);
        this.f = null;
      }
      f.getServiceContext().unregisterReceiver(this.e);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.d = null;
    this.e = null;
    this.c = null;
    this.b = false;
  }
  
  public void b()
  {
    if (this.b) {}
    while (g.V < 10000) {
      return;
    }
    if (this.c == null) {
      this.c = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          case 1: 
            try
            {
              b.a(b.this);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              return;
            }
          }
          try
          {
            b.b(b.this);
            return;
          }
          catch (Exception paramAnonymousMessage) {}
        }
      };
    }
    this.d = ((AlarmManager)f.getServiceContext().getSystemService("alarm"));
    this.e = new a(null);
    f.getServiceContext().registerReceiver(this.e, new IntentFilter("com.baidu.location.autonotifyloc_7.3.2"), "android.permission.ACCESS_FINE_LOCATION", null);
    this.f = PendingIntent.getBroadcast(f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.3.2"), 134217728);
    this.d.set(0, System.currentTimeMillis() + g.V, this.f);
    this.b = true;
    this.g = System.currentTimeMillis();
  }
  
  public void c()
  {
    if (!this.b) {}
    while (this.c == null) {
      return;
    }
    this.c.sendEmptyMessage(2);
  }
  
  public void d()
  {
    if (!this.b) {}
    while (this.c == null) {
      return;
    }
    this.c.sendEmptyMessage(1);
  }
  
  public void e()
  {
    if (!this.b) {}
    while (this.c == null) {
      return;
    }
    this.c.sendEmptyMessage(1);
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!b.c(b.this)) {}
      while ((!paramIntent.getAction().equals("com.baidu.location.autonotifyloc_7.3.2")) || (b.d(b.this) == null)) {
        return;
      }
      b.a(b.this, null);
      b.d(b.this).sendEmptyMessage(1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */