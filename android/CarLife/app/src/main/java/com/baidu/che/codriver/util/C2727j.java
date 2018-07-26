package com.baidu.che.codriver.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* compiled from: NetworkUtil */
/* renamed from: com.baidu.che.codriver.util.j */
public class C2727j {
    /* renamed from: a */
    public static boolean m10218a(Context context) {
        if (context != null) {
            NetworkInfo mNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m10219b(Context context) {
        if (context != null) {
            NetworkInfo mWiFiNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m10220c(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo mMobileNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (mMobileNetworkInfo != null) {
            return mMobileNetworkInfo.isAvailable();
        }
        return false;
    }

    /* renamed from: d */
    public static int m10221d(Context context) {
        if (context != null) {
            NetworkInfo mNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }

    /* renamed from: e */
    public static int m10222e(Context context) {
        int netType = 0;
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null) {
            return 0;
        }
        int nType = networkInfo.getType();
        if (nType == 1) {
            netType = 1;
        } else if (nType == 0) {
            TelephonyManager mTelephony = (TelephonyManager) context.getSystemService("phone");
            if (networkInfo.getSubtype() != 3 || mTelephony.isNetworkRoaming()) {
                netType = 3;
            } else {
                netType = 2;
            }
        }
        return netType;
    }
}
