package com.baidu.carlife.core.screen.presentation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.screen.n;

public class f
  implements ServiceConnection, h
{
  private static final String a = "CarlifeActivity#ServiceConnection";
  private Activity b;
  private i c;
  private AbsCarlifeActivityService d;
  private IBinder e;
  private n f;
  private boolean g;
  private Class h;
  private IBinder.DeathRecipient i = new IBinder.DeathRecipient()
  {
    public void binderDied()
    {
      com.baidu.carlife.core.i.b("CarlifeActivity#ServiceConnection", "binderDied()");
      f.b(f.this).unlinkToDeath(f.a(f.this), 0);
      if (f.c(f.this) != null) {
        f.c(f.this).a();
      }
    }
  };
  
  public f(Activity paramActivity, n paramn, i parami, Class paramClass)
  {
    this.b = paramActivity;
    this.c = parami;
    this.f = paramn;
    this.h = paramClass;
  }
  
  private void a(IBinder paramIBinder)
  {
    this.e = paramIBinder;
    try
    {
      paramIBinder.linkToDeath(this.i, 0);
      com.baidu.carlife.core.i.b("CarlifeActivity#ServiceConnection", "bindDeathRecipient binder=" + paramIBinder);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      paramIBinder.printStackTrace();
    }
  }
  
  public void a()
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#ServiceConnection", "unBindService()");
    if (this.g) {}
    try
    {
      this.b.unbindService(this);
      Intent localIntent = new Intent(this.b, this.h);
      this.b.stopService(localIntent);
      this.g = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#ServiceConnection", "onServiceConnected className=" + paramComponentName);
    paramComponentName = ((AbsCarlifeActivityService.a)paramIBinder).a();
    this.g = true;
    a(paramIBinder);
    if (paramComponentName != null)
    {
      this.d = paramComponentName;
      paramComponentName.b(this.c);
      return;
    }
    try
    {
      this.b.unbindService(this);
      return;
    }
    catch (IllegalArgumentException paramComponentName)
    {
      com.baidu.carlife.core.i.e("CarlifeActivity#ServiceConnection", paramComponentName.getMessage());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#ServiceConnection", "onServiceDisconnected componentName=" + paramComponentName);
    try
    {
      this.b.unbindService(this);
      return;
    }
    catch (IllegalArgumentException paramComponentName)
    {
      com.baidu.carlife.core.i.e("CarlifeActivity#ServiceConnection", paramComponentName.getMessage());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */