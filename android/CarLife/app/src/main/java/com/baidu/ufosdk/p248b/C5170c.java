package com.baidu.ufosdk.p248b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.ufosdk.util.C5210c;

/* compiled from: NetworkCollector */
/* renamed from: com.baidu.ufosdk.b.c */
public final class C5170c {
    /* renamed from: a */
    private static TelephonyManager f21382a;
    /* renamed from: b */
    private static ConnectivityManager f21383b;

    /* renamed from: a */
    public static String m17556a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (f21383b == null) {
                f21383b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f21383b.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                C5210c.m17736d("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName());
                return "N/A";
            }
            if (activeNetworkInfo.isConnected()) {
                stringBuilder.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
                if (activeNetworkInfo.getType() == 0) {
                    stringBuilder.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                    if (f21382a == null) {
                        f21382a = (TelephonyManager) context.getSystemService("phone");
                    }
                    stringBuilder.append("isRoaming: ").append(f21382a.isNetworkRoaming() ? C2848p.f9291R : C2848p.f9292S).append("\n");
                }
            } else {
                stringBuilder.append("type: none\n");
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            C5210c.m17733a("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName(), e);
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: b */
    public static String m17557b(Context context) {
        try {
            if (f21383b == null) {
                f21383b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f21383b.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                C5210c.m17736d("getNetworkType fail, getActiveNetworkInfo() is null.");
                return "UNKNOWN";
            } else if (activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getTypeName().toUpperCase();
            } else {
                return "NONE";
            }
        } catch (Throwable e) {
            C5210c.m17733a("getNetworkType fail,", e);
            return "UNKNOWN";
        }
    }
}
