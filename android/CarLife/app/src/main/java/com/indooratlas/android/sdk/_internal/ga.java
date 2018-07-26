package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.gj.C5924b;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ga {
    /* renamed from: a */
    private int f23833a = 64;
    /* renamed from: b */
    private int f23834b = 5;
    /* renamed from: c */
    private ExecutorService f23835c;
    /* renamed from: d */
    private final Deque<C5924b> f23836d = new ArrayDeque();
    /* renamed from: e */
    private final Deque<C5924b> f23837e = new ArrayDeque();
    /* renamed from: f */
    private final Deque<gj> f23838f = new ArrayDeque();

    /* renamed from: b */
    private synchronized ExecutorService m20599b() {
        if (this.f23835c == null) {
            this.f23835c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), gy.m20788a("OkHttp Dispatcher", false));
        }
        return this.f23835c;
    }

    /* renamed from: a */
    final synchronized void m20604a(C5924b c5924b) {
        if (this.f23837e.size() >= this.f23833a || m20600c(c5924b) >= this.f23834b) {
            this.f23836d.add(c5924b);
        } else {
            this.f23837e.add(c5924b);
            m20599b().execute(c5924b);
        }
    }

    /* renamed from: a */
    public final synchronized void m20602a() {
        for (C5924b c5924b : this.f23836d) {
            c5924b.f23939a.mo4696c();
        }
        for (C5924b c5924b2 : this.f23837e) {
            c5924b2.f23939a.mo4696c();
        }
        for (gj c : this.f23838f) {
            c.mo4696c();
        }
    }

    /* renamed from: b */
    final synchronized void m20606b(C5924b c5924b) {
        if (this.f23837e.remove(c5924b)) {
            m20601c();
        } else {
            throw new AssertionError("AsyncCall wasn't running!");
        }
    }

    /* renamed from: c */
    private void m20601c() {
        if (this.f23837e.size() < this.f23833a && !this.f23836d.isEmpty()) {
            Iterator it = this.f23836d.iterator();
            while (it.hasNext()) {
                C5924b c5924b = (C5924b) it.next();
                if (m20600c(c5924b) < this.f23834b) {
                    it.remove();
                    this.f23837e.add(c5924b);
                    m20599b().execute(c5924b);
                }
                if (this.f23837e.size() >= this.f23833a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m20600c(C5924b c5924b) {
        int i = 0;
        for (C5924b a : this.f23837e) {
            int i2;
            if (a.m20689a().equals(c5924b.m20689a())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: a */
    final synchronized void m20605a(gj gjVar) {
        this.f23838f.add(gjVar);
    }

    /* renamed from: a */
    final synchronized void m20603a(fr frVar) {
        if (!this.f23838f.remove(frVar)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
    }
}
