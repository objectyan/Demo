package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.m;
import java.util.Timer;
import java.util.TimerTask;

public class ar
{
  private static volatile ar b = null;
  private Timer a = null;
  private Context c = null;
  
  private ar(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new Timer(false);
  }
  
  public static ar a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ar(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public void a()
  {
    if (f.a() == h.f)
    {
      long l = f.m() * 60 * 1000;
      if (f.b()) {
        m.b().b("setupPeriodTimer delay:" + l);
      }
      a(new as(this), l);
    }
  }
  
  public void a(TimerTask paramTimerTask, long paramLong)
  {
    if (this.a != null)
    {
      if (f.b()) {
        m.b().b("setupPeriodTimer schedule delay:" + paramLong);
      }
      this.a.schedule(paramTimerTask, paramLong);
    }
    while (!f.b()) {
      return;
    }
    m.b().f("setupPeriodTimer schedule timer == null");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */