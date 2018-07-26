package com.indooratlas.android.sdk._internal;

import java.util.Date;

/* renamed from: com.indooratlas.android.sdk._internal.v */
public abstract class C6010v {
    /* renamed from: a */
    private static C6010v f24588a = new C6011a();

    /* renamed from: com.indooratlas.android.sdk._internal.v$a */
    public static class C6011a extends C6010v {
        /* renamed from: a */
        public final long mo4831a() {
            return System.nanoTime() / 1000000;
        }

        /* renamed from: b */
        public final Date mo4832b() {
            return new Date();
        }

        /* renamed from: c */
        public final long mo4833c() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public abstract long mo4831a();

    /* renamed from: b */
    public abstract Date mo4832b();

    /* renamed from: c */
    public abstract long mo4833c();

    /* renamed from: d */
    public static C6010v m21544d() {
        return f24588a;
    }
}
