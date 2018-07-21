package com.baidu.carlife.bluetooth;

import android.content.Intent;
import android.content.res.Configuration;
import com.baidu.carlife.core.b.a;
import com.baidu.carlife.core.i;

public class j
  implements com.baidu.carlife.c
{
  private static final String a = "CarlifeActivity#CycleListener";
  
  public void a() {}
  
  public void a(Intent paramIntent) {}
  
  public void b()
  {
    if (a.a())
    {
      i.b("CarlifeActivity#CycleListener", "onStop: Internal screen capture not send background msg. ");
      return;
    }
    i.b("CarlifeActivity#CycleListener", "onStop: full screen capture send background msg.");
    c.a(false, false);
  }
  
  public void c() {}
  
  public void d()
  {
    if (a.a())
    {
      i.b("CarlifeActivity#CycleListener", "onResume: Internal screen capture not send forground msg.");
      return;
    }
    i.b("CarlifeActivity#CycleListener", "onResume: full screen capture send forground msg.");
    c.a(false, true);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    i.b("CarlifeActivity#CycleListener", "onConfigurationChanged: newConfig=" + paramConfiguration);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */