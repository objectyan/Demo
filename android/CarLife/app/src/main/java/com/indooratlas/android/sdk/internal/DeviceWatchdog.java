package com.indooratlas.android.sdk.internal;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.indooratlas.android.sdk._internal.be;
import com.indooratlas.android.sdk._internal.be.a;
import com.indooratlas.android.sdk._internal.bf;
import com.indooratlas.android.sdk._internal.bf.b;
import com.indooratlas.android.sdk._internal.ct;
import com.indooratlas.android.sdk._internal.cv;

public final class DeviceWatchdog
{
  public final DeviceStatusObserver a = new DeviceStatusObserver();
  public a b;
  public DeviceWatchdog c;
  NetworkInfo d;
  boolean e = false;
  boolean f = true;
  public boolean g = false;
  boolean h = false;
  boolean i = false;
  public bf j;
  ConnectivityManager k;
  WifiManager l;
  private boolean m = false;
  private LocationManager n;
  
  public DeviceWatchdog(bf parambf)
  {
    if (parambf == null) {
      throw new NullPointerException("SDK Engine not initialised yet");
    }
    this.j = parambf;
    if (this.j.s != null)
    {
      this.k = this.j.s;
      this.l = ((WifiManager)this.j.o.getSystemService("wifi"));
      this.n = ((LocationManager)this.j.o.getSystemService("location"));
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction("android.intent.action.AIRPLANE_MODE");
      localIntentFilter.addAction("android.location.PROVIDERS_CHANGED");
      if (be.a.i) {
        localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      }
      this.j.o.registerReceiver(this.a, localIntentFilter);
      this.e = this.l.isWifiEnabled();
      this.f = cv.a(this.l);
      this.d = this.k.getActiveNetworkInfo();
      if (this.d == null) {
        break label367;
      }
      bool1 = true;
      label245:
      this.g = bool1;
      if (Build.VERSION.SDK_INT >= 17) {
        break label377;
      }
      if (Settings.System.getInt(parambf.o.getContentResolver(), "airplane_mode_on", 0) == 0) {
        break label372;
      }
    }
    label367:
    label372:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.h = bool1;
      if (be.a.i)
      {
        bool1 = bool2;
        if (ct.a(this.j.o, "android.permission.BLUETOOTH"))
        {
          parambf = BluetoothAdapter.getDefaultAdapter();
          bool1 = bool2;
          if (parambf != null)
          {
            bool1 = bool2;
            if (parambf.getState() == 12) {
              bool1 = true;
            }
          }
        }
        this.i = bool1;
      }
      b();
      this.c = this;
      return;
      this.k = ((ConnectivityManager)this.j.o.getSystemService("connectivity"));
      break;
      bool1 = false;
      break label245;
    }
    label377:
    if (Settings.System.getInt(parambf.o.getContentResolver(), "airplane_mode_on", 0) != 0) {}
    for (bool1 = true;; bool1 = false)
    {
      this.h = bool1;
      break;
    }
  }
  
  public final int a()
  {
    if (this.g)
    {
      this.f = cv.a(this.l);
      if ((this.f) && (!this.h) && ((Build.VERSION.SDK_INT < 23) || (this.m))) {
        return 2;
      }
    }
    return 10;
  }
  
  final void b()
  {
    this.m = this.n.isProviderEnabled("network");
  }
  
  public class DeviceStatusObserver
    extends BroadcastReceiver
  {
    public DeviceStatusObserver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
        DeviceWatchdog.this.h = paramIntent.getBooleanExtra("state", false);
      }
      if (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {}
      boolean bool;
      label169:
      int i;
      switch (paramIntent.getIntExtra("wifi_state", 4))
      {
      default: 
        DeviceWatchdog.this.f = cv.a(DeviceWatchdog.this.l);
        if (paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
          DeviceWatchdog.this.f = cv.a(DeviceWatchdog.this.l);
        }
        if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          DeviceWatchdog.this.d = DeviceWatchdog.this.k.getActiveNetworkInfo();
          paramContext = DeviceWatchdog.this;
          if (DeviceWatchdog.this.d != null)
          {
            bool = true;
            paramContext.g = bool;
            paramContext = DeviceWatchdog.this.d;
            paramContext = DeviceWatchdog.this.j.a;
            if (!DeviceWatchdog.this.g) {
              break label342;
            }
            i = 1019;
            label208:
            paramContext.b(i, DeviceWatchdog.this.d);
          }
        }
        else
        {
          if (paramIntent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
            DeviceWatchdog.this.b();
          }
          if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction())) {
            switch (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10))
            {
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (DeviceWatchdog.this.b != null) {
          DeviceWatchdog.this.b.a(DeviceWatchdog.this.c);
        }
        return;
        DeviceWatchdog.this.e = true;
        break;
        DeviceWatchdog.this.e = false;
        break;
        bool = false;
        break label169;
        label342:
        i = 1020;
        break label208;
        DeviceWatchdog.this.i = be.a.i;
        DeviceWatchdog.this.j.a.b(1023);
        continue;
        DeviceWatchdog.this.i = false;
        DeviceWatchdog.this.j.a.b(1024);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(DeviceWatchdog paramDeviceWatchdog);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/internal/DeviceWatchdog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */