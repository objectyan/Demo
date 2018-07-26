package com.baidu.mapframework.nirvana;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NirvanaThread */
/* renamed from: com.baidu.mapframework.nirvana.h */
public class C3543h extends Thread {
    /* renamed from: a */
    static final String f19168a = "NirvanaThread";
    /* renamed from: b */
    static final AtomicInteger f19169b = new AtomicInteger();
    /* renamed from: c */
    static final AtomicInteger f19170c = new AtomicInteger();
    /* renamed from: d */
    private static volatile boolean f19171d = false;

    public C3543h(String threadName) {
        this(null, threadName);
    }

    public C3543h(Runnable runnable) {
        this(runnable, f19168a);
    }

    public C3543h(Runnable runnable, String threadName) {
        super(runnable, threadName + "-" + f19169b.incrementAndGet());
    }

    /* renamed from: a */
    public static int m15177a() {
        return f19169b.get();
    }

    /* renamed from: b */
    public static int m15179b() {
        return f19170c.get();
    }

    /* renamed from: c */
    public static boolean m15180c() {
        return f19171d;
    }

    /* renamed from: a */
    public static void m15178a(boolean debug) {
        f19171d = debug;
    }

    public void run() {
        boolean debug = f19171d;
        long timeStamp = System.nanoTime();
        if (debug) {
            C3560n.m15209a(f19168a, "Created NirvanaThread " + getName() + " isDaemon:" + isDaemon());
        }
        try {
            f19170c.incrementAndGet();
            super.run();
            f19170c.decrementAndGet();
            if (debug) {
                C3560n.m15209a(f19168a, String.format(Locale.getDefault(), "Exiting NirvanaThread %s, duration %d ms, Created Thread Num:%d , Alive Thread Num: %d", new Object[]{getName(), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - timeStamp)), Integer.valueOf(C3543h.m15177a()), Integer.valueOf(C3543h.m15179b())}));
            }
        } catch (Throwable th) {
            f19170c.decrementAndGet();
            if (debug) {
                C3560n.m15209a(f19168a, String.format(Locale.getDefault(), "Exiting NirvanaThread %s, duration %d ms, Created Thread Num:%d , Alive Thread Num: %d", new Object[]{getName(), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - timeStamp)), Integer.valueOf(C3543h.m15177a()), Integer.valueOf(C3543h.m15179b())}));
            }
        }
    }
}
