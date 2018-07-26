package com.indooratlas.android.sdk._internal;

public final class hm {
    /* renamed from: a */
    int f24223a;
    /* renamed from: b */
    int f24224b;
    /* renamed from: c */
    int f24225c;
    /* renamed from: d */
    final int[] f24226d = new int[10];

    /* renamed from: a */
    final hm m20982a(int i, int i2, int i3) {
        if (i < this.f24226d.length) {
            int i4 = 1 << i;
            this.f24223a |= i4;
            if ((i2 & 1) != 0) {
                this.f24224b |= i4;
            } else {
                this.f24224b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.f24225c = i4 | this.f24225c;
            } else {
                this.f24225c = (i4 ^ -1) & this.f24225c;
            }
            this.f24226d[i] = i3;
        }
        return this;
    }

    /* renamed from: a */
    final boolean m20983a(int i) {
        if (((1 << i) & this.f24223a) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    final int m20985b(int i) {
        int i2;
        int i3 = 0;
        if (((1 << i) & this.f24225c) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (((1 << i) & this.f24224b) != 0) {
            i3 = 1;
        }
        if (i3 != 0) {
            return i2 | 1;
        }
        return i2;
    }

    /* renamed from: a */
    final int m20981a() {
        return (this.f24223a & 2) != 0 ? this.f24226d[1] : -1;
    }

    /* renamed from: b */
    public final int m20984b() {
        return (this.f24223a & 128) != 0 ? this.f24226d[7] : 65536;
    }
}
