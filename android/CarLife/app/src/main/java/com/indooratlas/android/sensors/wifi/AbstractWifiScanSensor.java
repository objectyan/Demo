package com.indooratlas.android.sensors.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.indooratlas.android.sdk._internal.cz;
import com.indooratlas.android.sdk._internal.dw;
import com.indooratlas.android.sdk._internal.eb;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWifiScanSensor
  extends BroadcastReceiver
{
  protected final eb a;
  public final WifiManager b;
  public volatile boolean c;
  protected final int d;
  public Handler e;
  
  public AbstractWifiScanSensor(int paramInt, WifiManager paramWifiManager, eb parameb)
  {
    this.d = paramInt;
    this.b = paramWifiManager;
    this.a = parameb;
    this.e = new Handler();
  }
  
  public final void a(List<ScanResult> paramList)
  {
    if (!this.c) {
      return;
    }
    if (paramList == null) {
      paramList = new ArrayList(0);
    }
    for (;;)
    {
      Object localObject = cz.a;
      localObject = this.a;
      int i = this.d;
      paramList = ((eb)localObject).a(i, paramList);
      ((eb)localObject).e.a(i, paramList);
      return;
    }
  }
  
  public boolean a()
  {
    if (!this.c)
    {
      str = cz.a;
      getClass().getSimpleName();
      return false;
    }
    this.c = false;
    String str = cz.a;
    int i = this.d;
    this.a.f.unregisterReceiver(this);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.c)
    {
      str = cz.a;
      return false;
    }
    this.c = true;
    String str = cz.a;
    int i = this.d;
    this.a.f.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
    return true;
  }
  
  public final class a
  {
    public int a;
    public long b;
    public long c;
    public long d;
    public float e;
    public int f;
    public long g;
    public int h;
    public int i;
    
    public a() {}
    
    public final String toString()
    {
      return "ScanStats{timesReceived=" + this.a + ", startTime=" + this.b + ", minInterval=" + this.c + ", maxInterval=" + this.d + ", averageFrequency=" + this.e + ", timesScanned=" + this.f + ", lastReceivedMillis=" + this.g + ", maxResults=" + this.h + ", minResults=" + this.i + '}';
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sensors/wifi/AbstractWifiScanSensor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */