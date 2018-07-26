package com.facebook.common.p262l;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
/* compiled from: RealtimeSinceBootClock */
/* renamed from: com.facebook.common.l.e */
public class C5363e implements C5359d {
    /* renamed from: a */
    private static final C5363e f21946a = new C5363e();

    private C5363e() {
    }

    @DoNotStrip
    /* renamed from: a */
    public static C5363e m18360a() {
        return f21946a;
    }

    /* renamed from: b */
    public long mo4019b() {
        return SystemClock.elapsedRealtime();
    }
}
