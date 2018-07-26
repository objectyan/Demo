package com.facebook.common.p262l;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
/* compiled from: AwakeTimeSinceBootClock */
/* renamed from: com.facebook.common.l.a */
public class C5360a implements C5359d {
    @DoNotStrip
    /* renamed from: a */
    private static final C5360a f21944a = new C5360a();

    private C5360a() {
    }

    @DoNotStrip
    /* renamed from: a */
    public static C5360a m18356a() {
        return f21944a;
    }

    @DoNotStrip
    /* renamed from: b */
    public long mo4019b() {
        return SystemClock.uptimeMillis();
    }
}
