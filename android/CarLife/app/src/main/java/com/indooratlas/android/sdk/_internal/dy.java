package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor;

final class dy extends AbstractWifiScanSensor {
    dy(eb ebVar, WifiManager wifiManager) {
        super(-101, wifiManager, ebVar);
    }

    public final void onReceive(Context context, Intent intent) {
        a(this.b.getScanResults());
    }
}
