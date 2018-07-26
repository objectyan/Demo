package com.facebook.imagepipeline.p153l;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.p152i.C2952d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: JobScheduler */
/* renamed from: com.facebook.imagepipeline.l.t */
public class C5606t {
    /* renamed from: a */
    static final String f22681a = "queueTime";
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: b */
    C2952d f22682b = null;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: c */
    boolean f22683c = false;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: d */
    C5605c f22684d = C5605c.IDLE;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: e */
    long f22685e = 0;
    @GuardedBy("this")
    @VisibleForTesting
    /* renamed from: f */
    long f22686f = 0;
    /* renamed from: g */
    private final Executor f22687g;
    /* renamed from: h */
    private final C5561a f22688h;
    /* renamed from: i */
    private final Runnable f22689i = new C56011(this);
    /* renamed from: j */
    private final Runnable f22690j = new C56022(this);
    /* renamed from: k */
    private final int f22691k;

    /* compiled from: JobScheduler */
    /* renamed from: com.facebook.imagepipeline.l.t$a */
    public interface C5561a {
        /* renamed from: a */
        void mo4134a(C2952d c2952d, boolean z);
    }

    /* compiled from: JobScheduler */
    /* renamed from: com.facebook.imagepipeline.l.t$1 */
    class C56011 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5606t f22672a;

        C56011(C5606t this$0) {
            this.f22672a = this$0;
        }

        public void run() {
            this.f22672a.m19402e();
        }
    }

    /* compiled from: JobScheduler */
    /* renamed from: com.facebook.imagepipeline.l.t$2 */
    class C56022 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5606t f22673a;

        C56022(C5606t this$0) {
            this.f22673a = this$0;
        }

        public void run() {
            this.f22673a.m19401d();
        }
    }

    @VisibleForTesting
    /* compiled from: JobScheduler */
    /* renamed from: com.facebook.imagepipeline.l.t$b */
    static class C5604b {
        /* renamed from: a */
        private static ScheduledExecutorService f22675a;

        C5604b() {
        }

        /* renamed from: a */
        static ScheduledExecutorService m19396a() {
            if (f22675a == null) {
                f22675a = Executors.newSingleThreadScheduledExecutor();
            }
            return f22675a;
        }
    }

    @VisibleForTesting
    /* compiled from: JobScheduler */
    /* renamed from: com.facebook.imagepipeline.l.t$c */
    enum C5605c {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public C5606t(Executor executor, C5561a jobRunnable, int minimumJobIntervalMs) {
        this.f22687g = executor;
        this.f22688h = jobRunnable;
        this.f22691k = minimumJobIntervalMs;
    }

    /* renamed from: a */
    public void m19404a() {
        C2952d oldEncodedImage;
        synchronized (this) {
            oldEncodedImage = this.f22682b;
            this.f22682b = null;
            this.f22683c = false;
        }
        C2952d.d(oldEncodedImage);
    }

    /* renamed from: a */
    public boolean m19405a(C2952d encodedImage, boolean isLast) {
        if (!C5606t.m19400b(encodedImage, isLast)) {
            return false;
        }
        C2952d oldEncodedImage;
        synchronized (this) {
            oldEncodedImage = this.f22682b;
            this.f22682b = C2952d.a(encodedImage);
            this.f22683c = isLast;
        }
        C2952d.d(oldEncodedImage);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public boolean m19406b() {
        /*
        r10 = this;
        r0 = android.os.SystemClock.uptimeMillis();
        r4 = 0;
        r2 = 0;
        monitor-enter(r10);
        r3 = r10.f22682b;	 Catch:{ all -> 0x003e }
        r6 = r10.f22683c;	 Catch:{ all -> 0x003e }
        r3 = com.facebook.imagepipeline.p153l.C5606t.m19400b(r3, r6);	 Catch:{ all -> 0x003e }
        if (r3 != 0) goto L_0x0015;
    L_0x0012:
        r3 = 0;
        monitor-exit(r10);	 Catch:{ all -> 0x003e }
    L_0x0014:
        return r3;
    L_0x0015:
        r3 = com.facebook.imagepipeline.p153l.C5606t.C56033.f22674a;	 Catch:{ all -> 0x003e }
        r6 = r10.f22684d;	 Catch:{ all -> 0x003e }
        r6 = r6.ordinal();	 Catch:{ all -> 0x003e }
        r3 = r3[r6];	 Catch:{ all -> 0x003e }
        switch(r3) {
            case 1: goto L_0x002c;
            case 2: goto L_0x0022;
            case 3: goto L_0x0041;
            default: goto L_0x0022;
        };	 Catch:{ all -> 0x003e }
    L_0x0022:
        monitor-exit(r10);	 Catch:{ all -> 0x003e }
        if (r2 == 0) goto L_0x002a;
    L_0x0025:
        r6 = r4 - r0;
        r10.m19397a(r6);
    L_0x002a:
        r3 = 1;
        goto L_0x0014;
    L_0x002c:
        r6 = r10.f22686f;	 Catch:{ all -> 0x003e }
        r3 = r10.f22691k;	 Catch:{ all -> 0x003e }
        r8 = (long) r3;	 Catch:{ all -> 0x003e }
        r6 = r6 + r8;
        r4 = java.lang.Math.max(r6, r0);	 Catch:{ all -> 0x003e }
        r2 = 1;
        r10.f22685e = r0;	 Catch:{ all -> 0x003e }
        r3 = com.facebook.imagepipeline.p153l.C5606t.C5605c.QUEUED;	 Catch:{ all -> 0x003e }
        r10.f22684d = r3;	 Catch:{ all -> 0x003e }
        goto L_0x0022;
    L_0x003e:
        r3 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x003e }
        throw r3;
    L_0x0041:
        r3 = com.facebook.imagepipeline.p153l.C5606t.C5605c.RUNNING_AND_PENDING;	 Catch:{ all -> 0x003e }
        r10.f22684d = r3;	 Catch:{ all -> 0x003e }
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.t.b():boolean");
    }

    /* renamed from: a */
    private void m19397a(long delay) {
        if (delay > 0) {
            C5604b.m19396a().schedule(this.f22690j, delay, TimeUnit.MILLISECONDS);
        } else {
            this.f22690j.run();
        }
    }

    /* renamed from: d */
    private void m19401d() {
        this.f22687g.execute(this.f22689i);
    }

    /* renamed from: e */
    private void m19402e() {
        long now = SystemClock.uptimeMillis();
        synchronized (this) {
            C2952d input = this.f22682b;
            boolean isLast = this.f22683c;
            this.f22682b = null;
            this.f22683c = false;
            this.f22684d = C5605c.RUNNING;
            this.f22686f = now;
        }
        try {
            if (C5606t.m19400b(input, isLast)) {
                this.f22688h.mo4134a(input, isLast);
            }
            C2952d.d(input);
            m19403f();
        } catch (Throwable th) {
            C2952d.d(input);
            m19403f();
        }
    }

    /* renamed from: f */
    private void m19403f() {
        long now = SystemClock.uptimeMillis();
        long when = 0;
        boolean shouldEnqueue = false;
        synchronized (this) {
            if (this.f22684d == C5605c.RUNNING_AND_PENDING) {
                when = Math.max(this.f22686f + ((long) this.f22691k), now);
                shouldEnqueue = true;
                this.f22685e = now;
                this.f22684d = C5605c.QUEUED;
            } else {
                this.f22684d = C5605c.IDLE;
            }
        }
        if (shouldEnqueue) {
            m19397a(when - now);
        }
    }

    /* renamed from: b */
    private static boolean m19400b(C2952d encodedImage, boolean isLast) {
        return isLast || C2952d.e(encodedImage);
    }

    /* renamed from: c */
    public synchronized long m19407c() {
        return this.f22686f - this.f22685e;
    }
}
