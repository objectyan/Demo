package com.baidu.ufosdk.util;

/* compiled from: ClickUtils */
/* renamed from: com.baidu.ufosdk.util.h */
public final class C5215h {
    /* renamed from: a */
    private static long f21704a;

    /* renamed from: a */
    public static boolean m17755a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f21704a;
        if (0 < j && j < 500) {
            return true;
        }
        f21704a = currentTimeMillis;
        return false;
    }
}
