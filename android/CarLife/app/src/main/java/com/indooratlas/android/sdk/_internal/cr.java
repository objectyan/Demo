package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;

public interface cr {

    /* renamed from: com.indooratlas.android.sdk._internal.cr$a */
    public static class C5843a implements cr {
        /* renamed from: a */
        private volatile long f23351a = SystemClock.elapsedRealtime();

        /* renamed from: a */
        public final long mo4654a() {
            long elapsedRealtime;
            synchronized (this) {
                elapsedRealtime = SystemClock.elapsedRealtime() - this.f23351a;
            }
            return elapsedRealtime;
        }

        /* renamed from: b */
        public final long mo4655b() {
            return System.currentTimeMillis();
        }

        /* renamed from: c */
        public final void mo4656c() {
            synchronized (this) {
                this.f23351a = SystemClock.elapsedRealtime();
            }
        }
    }

    /* renamed from: a */
    long mo4654a();

    /* renamed from: b */
    long mo4655b();

    /* renamed from: c */
    void mo4656c();
}
