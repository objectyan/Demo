package com.indooratlas.android.sdk._internal;

import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.baidu.mobstat.Config;
import java.util.Locale;

public final class cv {
    /* renamed from: a */
    public static long m20272a(String str) {
        String toLowerCase = str.replaceAll(Config.TRACE_TODAY_VISIT_SPLIT, "").replaceAll("-", "").toLowerCase(Locale.US);
        if (toLowerCase.length() != 12) {
            return -1;
        }
        return Long.parseLong(toLowerCase, 16);
    }

    /* renamed from: a */
    public static boolean m20273a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return false;
        }
        if (VERSION.SDK_INT < 18) {
            return true;
        }
        if (wifiManager.isWifiEnabled() || wifiManager.isScanAlwaysAvailable()) {
            return true;
        }
        return false;
    }
}
