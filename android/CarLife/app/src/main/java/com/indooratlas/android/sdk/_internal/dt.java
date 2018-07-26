package com.indooratlas.android.sdk._internal;

public abstract class dt {
    /* renamed from: a */
    protected String f23449a = "SensorTimestampFix";

    /* renamed from: com.indooratlas.android.sdk._internal.dt$a */
    public static class C5853a extends dt {
        /* renamed from: b */
        private C5854b f23450b;

        public C5853a() {
            this(new C5854b());
        }

        private C5853a(C5854b c5854b) {
            this.f23450b = c5854b;
        }

        /* renamed from: a */
        public final long mo4668a(int i, long j) {
            return System.nanoTime();
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.dt$b */
    static class C5854b {
        C5854b() {
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.dt$c */
    public static class C5855c extends dt {
        /* renamed from: b */
        C5854b f23451b = new C5854b();
        /* renamed from: c */
        private int f23452c;
        /* renamed from: d */
        private int f23453d;
        /* renamed from: e */
        private long f23454e;
        /* renamed from: f */
        private long f23455f;
        /* renamed from: g */
        private long f23456g;

        public C5855c(int i, int i2, long j, long j2) {
            this.f23452c = i;
            this.f23453d = i2;
            this.f23455f = j2;
            this.f23454e = j;
        }

        /* renamed from: a */
        public final long mo4668a(int i, long j) {
            if (i == this.f23452c) {
                this.f23454e = j;
                this.f23455f = System.nanoTime();
                return j;
            } else if (i != this.f23453d || this.f23455f == 0) {
                return j;
            } else {
                long nanoTime = this.f23454e + (System.nanoTime() - this.f23455f);
                if (nanoTime < this.f23456g) {
                    Object[] objArr = new Object[]{Long.valueOf(nanoTime), Long.valueOf(this.f23456g), Long.valueOf(this.f23454e), Long.valueOf(this.f23455f), Long.valueOf(r2)};
                    nanoTime = this.f23456g;
                } else {
                    this.f23456g = nanoTime;
                }
                return nanoTime;
            }
        }

        public final String toString() {
            return "{mBaseSensorType: " + this.f23452c + ", mAdjustSensorType: " + this.f23453d + ", mLastBaseSensorSystemTime: " + this.f23454e + "}";
        }
    }

    /* renamed from: a */
    public abstract long mo4668a(int i, long j);
}
