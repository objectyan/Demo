package com.indooratlas.android.sdk._internal;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class fw {
    /* renamed from: a */
    static final Executor f23798a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), gy.m20788a("OkHttp ConnectionPool", true));
    /* renamed from: g */
    static final /* synthetic */ boolean f23799g = (!fw.class.desiredAssertionStatus());
    /* renamed from: b */
    final int f23800b;
    /* renamed from: c */
    final Runnable f23801c;
    /* renamed from: d */
    final Deque<ii> f23802d;
    /* renamed from: e */
    final gx f23803e;
    /* renamed from: f */
    boolean f23804f;
    /* renamed from: h */
    private final long f23805h;

    /* renamed from: com.indooratlas.android.sdk._internal.fw$1 */
    class C59121 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ fw f23797a;

        C59121(fw fwVar) {
            this.f23797a = fwVar;
        }

        public final void run() {
            while (true) {
                long a = this.f23797a.m20576a(System.nanoTime());
                if (a != -1) {
                    if (a > 0) {
                        long j = a / 1000000;
                        a -= j * 1000000;
                        synchronized (this.f23797a) {
                            try {
                                this.f23797a.wait(j, (int) a);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public fw() {
        this(TimeUnit.MINUTES);
    }

    private fw(TimeUnit timeUnit) {
        this.f23801c = new C59121(this);
        this.f23802d = new ArrayDeque();
        this.f23803e = new gx();
        this.f23800b = 5;
        this.f23805h = timeUnit.toNanos(5);
        if (5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: 5");
        }
    }

    /* renamed from: a */
    final long m20576a(long j) {
        ii iiVar = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (ii iiVar2 : this.f23802d) {
                int i3;
                long j3;
                List list = iiVar2.f24364i;
                int i4 = 0;
                while (i4 < list.size()) {
                    if (((Reference) list.get(i4)).get() != null) {
                        i4++;
                    } else {
                        gs.f23876a.warning("A connection to " + iiVar2.f24356a.f23983a.f23707a + " was leaked. Did you forget to close a response body?");
                        list.remove(i4);
                        iiVar2.f24365j = true;
                        if (list.isEmpty()) {
                            iiVar2.f24366k = j - this.f23805h;
                            i3 = 0;
                            break;
                        }
                    }
                }
                i3 = list.size();
                if (i3 > 0) {
                    i2++;
                } else {
                    ii iiVar3;
                    int i5 = i + 1;
                    long j4 = j - iiVar2.f24366k;
                    if (j4 > j2) {
                        long j5 = j4;
                        iiVar3 = iiVar2;
                        j3 = j5;
                    } else {
                        j3 = j2;
                        iiVar3 = iiVar;
                    }
                    j2 = j3;
                    iiVar = iiVar3;
                    i = i5;
                }
            }
            if (j2 >= this.f23805h || i > this.f23800b) {
                this.f23802d.remove(iiVar);
                gy.m20792a(iiVar.f24358c);
                return 0;
            } else if (i > 0) {
                j3 = this.f23805h - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.f23805h;
                return j3;
            } else {
                this.f23804f = false;
                return -1;
            }
        }
    }
}
