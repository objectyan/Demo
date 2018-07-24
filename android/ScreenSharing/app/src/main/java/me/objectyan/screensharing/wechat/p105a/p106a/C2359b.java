package com.baidu.carlife.wechat.p105a.p106a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetWorkUtils */
/* renamed from: com.baidu.carlife.wechat.a.a.b */
public final class C2359b {
    /* renamed from: a */
    public static final String f7809a = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36";

    /* renamed from: a */
    public static boolean m8969a(Context context) {
        NetworkInfo activeInfo = C2359b.m8973e(context);
        return activeInfo != null && activeInfo.isConnected();
    }

    /* renamed from: b */
    public static boolean m8970b(Context context) {
        NetworkInfo activeInfo = C2359b.m8973e(context);
        if (activeInfo == null || !activeInfo.isConnected()) {
            return false;
        }
        if (activeInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m8971c(Context context) {
        NetworkInfo activeInfo = C2359b.m8973e(context);
        if (activeInfo != null && activeInfo.isConnected() && activeInfo.getType() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static String m8972d(Context context) {
        NetworkInfo activeInfo = C2359b.m8973e(context);
        return activeInfo == null ? null : activeInfo.getTypeName();
    }

    /* renamed from: e */
    private static NetworkInfo m8973e(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }
}
