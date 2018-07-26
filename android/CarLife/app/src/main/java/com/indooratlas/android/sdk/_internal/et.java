package com.indooratlas.android.sdk._internal;

public final class et {
    /* renamed from: d */
    private static final double f23540d = ((Math.atan(Math.sinh(3.141592653589793d)) / 3.141592653589793d) * 180.0d);
    /* renamed from: a */
    public final int f23541a;
    /* renamed from: b */
    public final int f23542b;
    /* renamed from: c */
    final int f23543c;

    public et(int i, int i2, int i3) {
        this.f23541a = i;
        this.f23542b = i2;
        this.f23543c = i3;
    }

    /* renamed from: a */
    public static et m20429a(double d, double d2, int i) {
        if (Math.abs(d) > f23540d) {
            throw new IllegalArgumentException("Latitude is outside the valid range");
        }
        int i2 = 1 << i;
        double d3 = (3.141592653589793d * d) / 180.0d;
        int floor = (int) Math.floor(((double) i2) * ((180.0d + d2) / 360.0d));
        int floor2 = (int) Math.floor(((1.0d - (Math.log((1.0d / Math.cos(d3)) + Math.tan(d3)) / 3.141592653589793d)) * ((double) i2)) / 2.0d);
        floor %= i2;
        if (floor < 0) {
            floor += i2;
        }
        return new et(floor, floor2, i);
    }

    public final boolean equals(Object o) {
        if (o == null || !(o instanceof et)) {
            return false;
        }
        et etVar = (et) o;
        if (this.f23543c == etVar.f23543c && this.f23541a == etVar.f23541a && this.f23542b == etVar.f23542b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((int) (((long) this.f23543c) ^ (((long) this.f23543c) >>> 32))) + 37) * 37) + ((int) (((long) this.f23541a) ^ (((long) this.f23541a) >>> 32)))) * 37) + ((int) (((long) this.f23542b) ^ (((long) this.f23542b) >>> 32)));
    }

    public final String toString() {
        int i = this.f23541a;
        int i2 = this.f23542b;
        return "TileLocation(x=" + i + ", y=" + i2 + ", zoomLevel=" + this.f23543c + ")";
    }
}
