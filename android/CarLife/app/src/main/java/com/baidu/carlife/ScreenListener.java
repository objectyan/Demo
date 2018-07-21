package com.baidu.carlife;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public class ScreenListener
{
  private Context a;
  private ScreenBroadcastReceiver b;
  private a c;
  
  public ScreenListener(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ScreenBroadcastReceiver(null);
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.a.registerReceiver(this.b, localIntentFilter);
  }
  
  public void a()
  {
    this.c = null;
    c();
  }
  
  public void a(a parama)
  {
    this.c = parama;
    d();
  }
  
  public void b()
  {
    if (((PowerManager)this.a.getSystemService("power")).isScreenOn()) {
      if (this.c != null) {
        this.c.a();
      }
    }
    while (this.c == null) {
      return;
    }
    this.c.b();
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this.b);
  }
  
  private class ScreenBroadcastReceiver
    extends BroadcastReceiver
  {
    private String b = null;
    
    private ScreenBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.b = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.b)) {
        ScreenListener.a(ScreenListener.this).a();
      }
      do
      {
        return;
        if ("android.intent.action.SCREEN_OFF".equals(this.b))
        {
          ScreenListener.a(ScreenListener.this).b();
          return;
        }
      } while (!"android.intent.action.USER_PRESENT".equals(this.b));
      ScreenListener.a(ScreenListener.this).c();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/ScreenListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */