package com.facebook.common.p258g;

/* compiled from: MemoryTrimType */
/* renamed from: com.facebook.common.g.a */
public enum C5323a {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);
    
    /* renamed from: e */
    private double f21908e;

    private C5323a(double suggestedTrimRatio) {
        this.f21908e = suggestedTrimRatio;
    }

    /* renamed from: a */
    public double m18235a() {
        return this.f21908e;
    }
}
