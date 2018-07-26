package com.indooratlas.android.sdk._internal;

public final class di {
    /* renamed from: a */
    public String f23405a;
    /* renamed from: b */
    public int f23406b;
    /* renamed from: c */
    public int f23407c;
    /* renamed from: d */
    public int f23408d;
    /* renamed from: e */
    public int f23409e;
    /* renamed from: f */
    public double f23410f;

    public di(String str, int i, int i2, int i3, int i4, double d) {
        this.f23405a = str;
        this.f23407c = i;
        this.f23406b = i2;
        this.f23408d = i3;
        this.f23409e = i4;
        this.f23410f = d;
    }

    public final String toString() {
        return "uuid: " + this.f23405a + " major: " + this.f23407c + " minor: " + this.f23406b + " rssi: " + this.f23408d + " calibratedTxPowerLevel: " + this.f23409e + " accuracy: " + this.f23410f;
    }
}
