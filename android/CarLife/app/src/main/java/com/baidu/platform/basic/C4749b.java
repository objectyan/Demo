package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.C2911f;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BMThread */
/* renamed from: com.baidu.platform.basic.b */
public class C4749b extends Thread {
    /* renamed from: a */
    public static final String f19752a = "BMThread";
    /* renamed from: b */
    private static final AtomicInteger f19753b = new AtomicInteger();
    /* renamed from: c */
    private static final AtomicInteger f19754c = new AtomicInteger();
    /* renamed from: d */
    private static volatile boolean f19755d = false;

    public C4749b(String threadName) {
        super(threadName);
    }

    public C4749b(Runnable runnable) {
        super(runnable, f19752a);
    }

    public C4749b(Runnable runnable, String threadName) {
        super(runnable, threadName + "-" + f19753b.incrementAndGet());
    }

    /* renamed from: a */
    public static int m15809a() {
        return f19753b.get();
    }

    /* renamed from: b */
    public static int m15811b() {
        return f19754c.get();
    }

    /* renamed from: c */
    public static boolean m15812c() {
        return f19755d;
    }

    /* renamed from: a */
    public static void m15810a(boolean debug) {
        f19755d = debug;
    }

    public void run() {
        boolean debug = f19755d;
        long timeStamp = System.nanoTime();
        if (debug) {
            C2911f.c(f19752a, "Created BMThread " + getName());
        }
        try {
            f19754c.incrementAndGet();
            super.run();
            f19754c.decrementAndGet();
            if (debug) {
                C2911f.c(f19752a, String.format(Locale.getDefault(), "Exiting BMThread %s,duration %d ns, Alive Thread num:%d", new Object[]{getName(), Long.valueOf(System.nanoTime() - timeStamp), Integer.valueOf(C4749b.m15811b())}));
            }
        } catch (Throwable th) {
            f19754c.decrementAndGet();
            if (debug) {
                C2911f.c(f19752a, String.format(Locale.getDefault(), "Exiting BMThread %s,duration %d ns, Alive Thread num:%d", new Object[]{getName(), Long.valueOf(System.nanoTime() - timeStamp), Integer.valueOf(C4749b.m15811b())}));
            }
        }
    }
}
