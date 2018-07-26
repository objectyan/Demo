package com.indooratlas.android.sdk._internal;

public final class er {
    /* renamed from: a */
    public final double f23530a;
    /* renamed from: b */
    public final double f23531b;
    /* renamed from: c */
    public final double f23532c;
    /* renamed from: d */
    public final double f23533d;

    public er(double d, double d2, double d3, double d4) {
        if (d3 < d || d4 < d2) {
            throw new IllegalArgumentException(String.format("Invalid values for a rectangle: %f, %f, %f, %f", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}));
        }
        this.f23530a = d;
        this.f23532c = d3;
        this.f23531b = d2;
        this.f23533d = d4;
    }

    public final String toString() {
        return "Rectangle{(" + this.f23530a + ", " + this.f23531b + "), (" + this.f23532c + ", " + this.f23533d + ")}";
    }
}
