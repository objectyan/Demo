package com.indooratlas.android.sdk._internal;

import android.hardware.Sensor;

public final class de implements cw {
    /* renamed from: a */
    int f23381a;

    /* renamed from: com.indooratlas.android.sdk._internal.de$a */
    public static class C5847a {
        /* renamed from: a */
        private de f23379a = new de();
        /* renamed from: b */
        private boolean f23380b;

        /* renamed from: a */
        public final C5847a m20303a(int i) {
            this.f23379a.f23381a = i;
            this.f23380b = true;
            return this;
        }

        /* renamed from: a */
        public final de m20304a() {
            if (this.f23380b) {
                return this.f23379a;
            }
            throw new IllegalStateException("sensor type must be set");
        }
    }

    private de() {
        this.f23381a = 0;
    }

    /* renamed from: a */
    public final int mo4658a() {
        return this.f23381a;
    }

    public final String toString() {
        return "SimpleSensor{mType=" + this.f23381a + '}';
    }

    /* renamed from: b */
    public final Sensor mo4659b() {
        return null;
    }
}
