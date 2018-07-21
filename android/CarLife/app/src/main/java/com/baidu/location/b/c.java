package com.baidu.location.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.location.d.b;
import com.baidu.location.f;

public class c
{
  private static c d = null;
  private boolean a = false;
  private String b = null;
  private a c = null;
  private int e = -1;
  
  public static c a()
  {
    try
    {
      if (d == null) {
        d = new c();
      }
      c localc = d;
      return localc;
    }
    finally {}
  }
  
  public void b()
  {
    this.c = new a();
    f.getServiceContext().registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }
  
  public void c()
  {
    if (this.c != null) {}
    try
    {
      f.getServiceContext().unregisterReceiver(this.c);
      this.c = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public String d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      for (;;)
      {
        int i;
        int j;
        try
        {
          if (!paramContext.equals("android.intent.action.BATTERY_CHANGED")) {
            break;
          }
          c.a(c.this, false);
          i = paramIntent.getIntExtra("status", 0);
          j = paramIntent.getIntExtra("plugged", 0);
          int k = paramIntent.getIntExtra("level", -1);
          int m = paramIntent.getIntExtra("scale", -1);
          if ((k > 0) && (m > 0))
          {
            c.a(c.this, k * 100 / m);
            break label216;
            c.a(c.this, null);
            break label247;
            if (!c.a(c.this)) {
              break label209;
            }
            b.a().b();
            return;
          }
          c.a(c.this, -1);
        }
        catch (Exception paramContext)
        {
          c.a(c.this, null);
          return;
        }
        c.a(c.this, "4");
        break label247;
        c.a(c.this, "3");
        break label247;
        c.a(c.this, "6");
        c.a(c.this, true);
        continue;
        c.a(c.this, "5");
        c.a(c.this, true);
        continue;
        label209:
        b.a().c();
        return;
        label216:
        switch (i)
        {
        }
        continue;
        label247:
        switch (j)
        {
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */