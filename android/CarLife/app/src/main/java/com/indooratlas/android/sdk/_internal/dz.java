package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor.a;

final class dz
  extends AbstractWifiScanSensor
{
  long f;
  private AbstractWifiScanSensor.a g = new AbstractWifiScanSensor.a(this);
  private long h;
  private Runnable i = new Runnable()
  {
    public final void run()
    {
      dz.a(dz.this);
    }
  };
  
  dz(eb parameb, WifiManager paramWifiManager)
  {
    super(-100, paramWifiManager, parameb);
  }
  
  private void b()
  {
    if (this.c)
    {
      localObject = cz.a;
      this.b.startScan();
      this.h = SystemClock.elapsedRealtime();
      localObject = this.g;
      ((AbstractWifiScanSensor.a)localObject).f += 1;
      return;
    }
    Object localObject = cz.a;
  }
  
  final boolean a()
  {
    if (this.e != null) {
      this.e.removeCallbacks(this.i);
    }
    return super.a();
  }
  
  final boolean a(long paramLong)
  {
    if ((paramLong < 200L) || (paramLong < 0L))
    {
      this.f = 200L;
      String str = cz.a;
    }
    for (;;)
    {
      boolean bool = super.a(paramLong);
      b();
      return bool;
      this.f = paramLong;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction()))
    {
      paramContext = cz.a;
      paramIntent.getAction();
      return;
    }
    if (this.c)
    {
      a(this.b.getScanResults());
      long l1 = SystemClock.elapsedRealtime() - this.h - this.f;
      if (l1 > 0L)
      {
        b();
        return;
      }
      paramContext = cz.a;
      long l2 = -l1;
      this.e.postDelayed(this.i, -l1);
      return;
    }
    paramContext = cz.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */