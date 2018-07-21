package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor;

final class dy
  extends AbstractWifiScanSensor
{
  dy(eb parameb, WifiManager paramWifiManager)
  {
    super(-101, paramWifiManager, parameb);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    a(this.b.getScanResults());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */