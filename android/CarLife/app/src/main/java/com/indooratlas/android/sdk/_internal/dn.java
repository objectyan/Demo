package com.indooratlas.android.sdk._internal;

import android.hardware.Sensor;

final class dn implements cw {
    /* renamed from: a */
    Sensor f23422a;

    dn(Sensor sensor) {
        this.f23422a = sensor;
    }

    /* renamed from: a */
    public static dn m20344a(Sensor sensor) {
        return new dn(sensor);
    }

    public final boolean equals(Object otherSensor) {
        if ((otherSensor instanceof dn) && this.f23422a.getType() == ((dn) otherSensor).f23422a.getType()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f23422a.hashCode();
    }

    /* renamed from: a */
    public final int mo4658a() {
        return dm.m20335b(this.f23422a.getType());
    }

    public final String toString() {
        return this.f23422a.toString();
    }

    /* renamed from: b */
    public final Sensor mo4659b() {
        return this.f23422a;
    }
}
