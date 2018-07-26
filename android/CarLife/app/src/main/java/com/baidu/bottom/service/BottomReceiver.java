package com.baidu.bottom.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.baidumaps.common.network.NetworkListener;
import com.baidu.mobstat.C3599n;
import com.baidu.mobstat.at;
import com.baidu.mobstat.bd;
import com.baidu.mobstat.dd;
import com.baidu.navisdk.util.common.HttpsClient;

public class BottomReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static dd f2317a;
    /* renamed from: b */
    private static long f2318b;
    /* renamed from: c */
    private static long f2319c;

    public void onReceive(Context context, Intent intent) {
        if (f2317a != null) {
            bd.a("Bottom has alread analyzed.");
            return;
        }
        dd ddVar = new dd();
        if (ddVar.a()) {
            f2317a = ddVar;
            new at(this, context, intent, ddVar).start();
        }
    }

    /* renamed from: a */
    private void m3008a(Context context, Intent intent) {
        String action = intent.getAction();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f2319c - currentTimeMillis) <= HttpsClient.CONN_MGR_TIMEOUT) {
            return;
        }
        if ("android.net.wifi.STATE_CHANGE".equals(action) || NetworkListener.f2258e.equals(action) || NetworkListener.f2257d.equals(action) || "android.net.wifi.SCAN_RESULTS".equals(action)) {
            f2319c = currentTimeMillis;
            C3599n.a(context);
        }
    }

    /* renamed from: b */
    private void m3010b(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
            Object obj = null;
            Uri data = intent.getData();
            if (data != null) {
                obj = data.getSchemeSpecificPart();
            }
            if (!TextUtils.isEmpty(obj)) {
                C3599n.a(context, action, obj);
            }
        }
    }
}
