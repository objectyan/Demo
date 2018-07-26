package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public final class ca {
    /* renamed from: a */
    public ConcurrentLinkedQueue<bz> f23284a = new ConcurrentLinkedQueue();
    /* renamed from: b */
    LinkedBlockingQueue<bz> f23285b = new LinkedBlockingQueue();
    /* renamed from: c */
    cb f23286c;
    /* renamed from: d */
    public HashMap<String, bz> f23287d = new HashMap(30);
    /* renamed from: e */
    public C5833a f23288e = new C5833a(this);
    /* renamed from: f */
    public volatile boolean f23289f;
    /* renamed from: g */
    public CountDownLatch f23290g;

    /* renamed from: com.indooratlas.android.sdk._internal.ca$a */
    public class C5833a extends Thread {
        /* renamed from: a */
        final /* synthetic */ ca f23283a;

        C5833a(ca caVar) {
            this.f23283a = caVar;
        }

        public final void run() {
            while (!this.f23283a.f23289f) {
                try {
                    bz bzVar = (bz) this.f23283a.f23285b.take();
                    this.f23283a.f23286c.mo4646a(bzVar);
                } catch (Throwable e) {
                    ee.m20410a("IACore", e, "saving event failed, skipped", new Object[0]);
                } catch (InterruptedException e2) {
                }
            }
            if (this.f23283a.f23290g != null) {
                this.f23283a.f23290g.countDown();
            }
            Closeable closeable = this.f23283a.f23286c;
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    public ca(cb cbVar) {
        this.f23286c = cbVar;
        this.f23288e.start();
    }

    /* renamed from: a */
    public final boolean m20200a(String str) {
        return this.f23287d.put(str, new bz(str, SystemClock.elapsedRealtime())) != null;
    }

    /* renamed from: b */
    public final boolean m20201b(String str) {
        bz bzVar = (bz) this.f23287d.remove(str);
        if (bzVar != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - bzVar.f23275b;
            bzVar.f23275b = System.currentTimeMillis();
            bzVar.f23281h = new long[]{elapsedRealtime};
            if (this.f23289f) {
                new Object[1][0] = bzVar;
            } else {
                new Object[1][0] = bzVar;
                this.f23285b.offer(bzVar);
            }
            return true;
        }
        new Object[1][0] = str;
        return false;
    }
}
