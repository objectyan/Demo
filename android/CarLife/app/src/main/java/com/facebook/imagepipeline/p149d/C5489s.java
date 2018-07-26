package com.facebook.imagepipeline.p149d;

import com.facebook.common.p257e.C5320a;
import com.facebook.common.p258g.C5323a;

/* compiled from: NativeMemoryCacheTrimStrategy */
/* renamed from: com.facebook.imagepipeline.d.s */
public class C5489s implements h$a {
    /* renamed from: a */
    private static final String f22317a = "NativeMemoryCacheTrimStrategy";

    /* renamed from: a */
    public double mo4061a(C5323a trimType) {
        switch (trimType) {
            case OnCloseToDalvikHeapLimit:
                return 0.0d;
            case OnAppBackgrounded:
            case OnSystemLowMemoryWhileAppInForeground:
            case OnSystemLowMemoryWhileAppInBackground:
                return 1.0d;
            default:
                C5320a.m18194f(f22317a, "unknown trim type: %s", trimType);
                return 0.0d;
        }
    }
}
