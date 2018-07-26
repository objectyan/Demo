package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class ej {
    @TargetApi(17)
    /* renamed from: a */
    public static long m20419a() {
        return VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : System.nanoTime();
    }
}
