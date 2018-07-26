package com.facebook.imagepipeline.p149d;

import android.os.Build.VERSION;
import com.facebook.common.p257e.C5320a;
import com.facebook.common.p258g.C5323a;

/* compiled from: BitmapMemoryCacheTrimStrategy */
/* renamed from: com.facebook.imagepipeline.d.d */
public class C5469d implements h$a {
    /* renamed from: a */
    private static final String f22274a = "BitmapMemoryCacheTrimStrategy";

    /* renamed from: a */
    public double mo4061a(C5323a trimType) {
        switch (trimType) {
            case OnCloseToDalvikHeapLimit:
                if (VERSION.SDK_INT >= 21) {
                    return C5323a.OnCloseToDalvikHeapLimit.m18235a();
                }
                return 0.0d;
            case OnAppBackgrounded:
            case OnSystemLowMemoryWhileAppInForeground:
            case OnSystemLowMemoryWhileAppInBackground:
                return 1.0d;
            default:
                C5320a.m18194f(f22274a, "unknown trim type: %s", trimType);
                return 0.0d;
        }
    }
}
