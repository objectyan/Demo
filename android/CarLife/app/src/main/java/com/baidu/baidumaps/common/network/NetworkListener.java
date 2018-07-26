package com.baidu.baidumaps.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.baidumaps.common.p039a.C0697b;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.p208c.C4766b;
import com.baidu.platform.comapi.util.BMEventBus;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.NetworkUtil;

public class NetworkListener extends BroadcastReceiver {
    /* renamed from: a */
    public static final String f2254a = "NetworkListener";
    /* renamed from: b */
    public static final String f2255b = "com.baidu.BaiduMap.CONNECTIVIY_CHANGED";
    /* renamed from: c */
    public static final String f2256c = "com.baidu.BaiduMap.MANUAL_CONNECTIVIY_CHANGED";
    /* renamed from: d */
    public static final String f2257d = "android.net.conn.CONNECTIVITY_CHANGE";
    /* renamed from: e */
    public static final String f2258e = "android.net.wifi.WIFI_STATE_CHANGED";

    public void onReceive(Context context, Intent intent) {
        C2911f.m11014b("NetworkListener.onReceive");
        if (C2907c.m10971a()) {
            C4766b.a().a(NetworkUtil.getCurrentNetMode(context));
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(f2255b);
            BaiduNaviApplication.getInstance().sendBroadcast(broadcastIntent);
            NetworkInfo activeNetInfo = null;
            try {
                activeNetInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e) {
            }
            C0697b networkTypeChangeEvent = new C0697b();
            if (activeNetInfo != null) {
                networkTypeChangeEvent.f2250a = activeNetInfo.getType();
                networkTypeChangeEvent.f2251b = activeNetInfo.isConnected();
            }
            BMEventBus.getInstance().post(networkTypeChangeEvent);
        }
    }
}
