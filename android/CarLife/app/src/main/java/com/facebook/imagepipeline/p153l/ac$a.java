package com.facebook.imagepipeline.p153l;

import android.util.Pair;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5351l;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.l.ac$a.a;
import com.facebook.imagepipeline.p276e.C5494c;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
/* compiled from: MultiplexProducer */
/* renamed from: com.facebook.imagepipeline.l.ac$a */
class ac$a {
    /* renamed from: a */
    final /* synthetic */ ac f13140a;
    /* renamed from: b */
    private final K f13141b;
    /* renamed from: c */
    private final CopyOnWriteArraySet<Pair<C5517j<T>, aj>> f13142c = C5351l.c();
    @GuardedBy("Multiplexer.this")
    @Nullable
    /* renamed from: d */
    private T f13143d;
    @GuardedBy("Multiplexer.this")
    /* renamed from: e */
    private float f13144e;
    @GuardedBy("Multiplexer.this")
    @Nullable
    /* renamed from: f */
    private C2954d f13145f;
    @GuardedBy("Multiplexer.this")
    @Nullable
    /* renamed from: g */
    private a f13146g;

    public ac$a(ac this$0, K key) {
        this.f13140a = this$0;
        this.f13141b = key;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m11822a(com.facebook.imagepipeline.p153l.C5517j<T> r10, com.facebook.imagepipeline.p153l.aj r11) {
        /*
        r9 = this;
        r6 = 0;
        r0 = android.util.Pair.create(r10, r11);
        monitor-enter(r9);
        r7 = r9.f13140a;	 Catch:{ all -> 0x0050 }
        r8 = r9.f13141b;	 Catch:{ all -> 0x0050 }
        r7 = com.facebook.imagepipeline.p153l.ac.a(r7, r8);	 Catch:{ all -> 0x0050 }
        if (r7 == r9) goto L_0x0012;
    L_0x0010:
        monitor-exit(r9);	 Catch:{ all -> 0x0050 }
    L_0x0011:
        return r6;
    L_0x0012:
        r6 = r9.f13142c;	 Catch:{ all -> 0x0050 }
        r6.add(r0);	 Catch:{ all -> 0x0050 }
        r4 = r9.m11807b();	 Catch:{ all -> 0x0050 }
        r5 = r9.m11815f();	 Catch:{ all -> 0x0050 }
        r1 = r9.m11811d();	 Catch:{ all -> 0x0050 }
        r2 = r9.f13143d;	 Catch:{ all -> 0x0050 }
        r3 = r9.f13144e;	 Catch:{ all -> 0x0050 }
        monitor-exit(r9);	 Catch:{ all -> 0x0050 }
        com.facebook.imagepipeline.p153l.C2954d.m11878b(r4);
        com.facebook.imagepipeline.p153l.C2954d.m11880d(r5);
        com.facebook.imagepipeline.p153l.C2954d.m11879c(r1);
        monitor-enter(r0);
        monitor-enter(r9);	 Catch:{ all -> 0x005f }
        r6 = r9.f13143d;	 Catch:{ all -> 0x005c }
        if (r2 == r6) goto L_0x0053;
    L_0x0037:
        r2 = 0;
    L_0x0038:
        monitor-exit(r9);	 Catch:{ all -> 0x005c }
        if (r2 == 0) goto L_0x004a;
    L_0x003b:
        r6 = 0;
        r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0043;
    L_0x0040:
        r10.b(r3);	 Catch:{ all -> 0x005f }
    L_0x0043:
        r6 = 0;
        r10.b(r2, r6);	 Catch:{ all -> 0x005f }
        r9.m11806a(r2);	 Catch:{ all -> 0x005f }
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x005f }
        r9.m11804a(r0, r11);
        r6 = 1;
        goto L_0x0011;
    L_0x0050:
        r6 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0050 }
        throw r6;
    L_0x0053:
        if (r2 == 0) goto L_0x0038;
    L_0x0055:
        r6 = r9.f13140a;	 Catch:{ all -> 0x005c }
        r2 = r6.a(r2);	 Catch:{ all -> 0x005c }
        goto L_0x0038;
    L_0x005c:
        r6 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x005c }
        throw r6;	 Catch:{ all -> 0x005f }
    L_0x005f:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x005f }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ac$a.a(com.facebook.imagepipeline.l.j, com.facebook.imagepipeline.l.aj):boolean");
    }

    /* renamed from: a */
    private void m11804a(Pair<C5517j<T>, aj> consumerContextPair, aj producerContext) {
        producerContext.a(new ac$a$1(this, consumerContextPair));
    }

    /* renamed from: a */
    private void m11803a() {
        boolean z = true;
        synchronized (this) {
            C5350k.a(this.f13145f == null);
            if (this.f13146g != null) {
                z = false;
            }
            C5350k.a(z);
            if (this.f13142c.isEmpty()) {
                ac.a(this.f13140a, this.f13141b, this);
                return;
            }
            aj producerContext = ((Pair) this.f13142c.iterator().next()).second;
            this.f13145f = new C2954d(producerContext.a(), producerContext.b(), producerContext.c(), producerContext.d(), producerContext.e(), m11810c(), m11814e(), m11817g());
            this.f13146g = new ac$a$a(this, null);
            C2954d multiplexProducerContext = this.f13145f;
            a forwardingConsumer = this.f13146g;
            ac.a(this.f13140a).a(forwardingConsumer, multiplexProducerContext);
        }
    }

    @Nullable
    /* renamed from: b */
    private synchronized List<ak> m11807b() {
        List<ak> list;
        if (this.f13145f == null) {
            list = null;
        } else {
            list = this.f13145f.m11883a(m11810c());
        }
        return list;
    }

    /* renamed from: c */
    private synchronized boolean m11810c() {
        boolean z;
        Iterator it = this.f13142c.iterator();
        while (it.hasNext()) {
            if (!((aj) ((Pair) it.next()).second).f()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    @Nullable
    /* renamed from: d */
    private synchronized List<ak> m11811d() {
        List<ak> list;
        if (this.f13145f == null) {
            list = null;
        } else {
            list = this.f13145f.m11886b(m11814e());
        }
        return list;
    }

    /* renamed from: e */
    private synchronized boolean m11814e() {
        boolean z;
        Iterator it = this.f13142c.iterator();
        while (it.hasNext()) {
            if (((aj) ((Pair) it.next()).second).h()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    @Nullable
    /* renamed from: f */
    private synchronized List<ak> m11815f() {
        List<ak> list;
        if (this.f13145f == null) {
            list = null;
        } else {
            list = this.f13145f.m11882a(m11817g());
        }
        return list;
    }

    /* renamed from: g */
    private synchronized C5494c m11817g() {
        C5494c priority;
        priority = C5494c.f22336a;
        Iterator it = this.f13142c.iterator();
        while (it.hasNext()) {
            priority = C5494c.a(priority, ((aj) ((Pair) it.next()).second).g());
        }
        return priority;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m11821a(com.facebook.imagepipeline.l.ac$a.a r5, java.lang.Throwable r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r2 = r4.f13146g;	 Catch:{ all -> 0x003b }
        if (r2 == r5) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
    L_0x0006:
        return;
    L_0x0007:
        r2 = r4.f13142c;	 Catch:{ all -> 0x003b }
        r0 = r2.iterator();	 Catch:{ all -> 0x003b }
        r2 = r4.f13142c;	 Catch:{ all -> 0x003b }
        r2.clear();	 Catch:{ all -> 0x003b }
        r2 = r4.f13140a;	 Catch:{ all -> 0x003b }
        r3 = r4.f13141b;	 Catch:{ all -> 0x003b }
        com.facebook.imagepipeline.p153l.ac.a(r2, r3, r4);	 Catch:{ all -> 0x003b }
        r2 = r4.f13143d;	 Catch:{ all -> 0x003b }
        r4.m11806a(r2);	 Catch:{ all -> 0x003b }
        r2 = 0;
        r4.f13143d = r2;	 Catch:{ all -> 0x003b }
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
    L_0x0022:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0006;
    L_0x0028:
        r1 = r0.next();
        r1 = (android.util.Pair) r1;
        monitor-enter(r1);
        r2 = r1.first;	 Catch:{ all -> 0x0038 }
        r2 = (com.facebook.imagepipeline.p153l.C5517j) r2;	 Catch:{ all -> 0x0038 }
        r2.b(r6);	 Catch:{ all -> 0x0038 }
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        goto L_0x0022;
    L_0x0038:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        throw r2;
    L_0x003b:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ac$a.a(com.facebook.imagepipeline.l.ac$a$a, java.lang.Throwable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m11820a(com.facebook.imagepipeline.l.ac$a.a r5, T r6, boolean r7) {
        /*
        r4 = this;
        monitor-enter(r4);
        r2 = r4.f13146g;	 Catch:{ all -> 0x0046 }
        if (r2 == r5) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
    L_0x0006:
        return;
    L_0x0007:
        r2 = r4.f13143d;	 Catch:{ all -> 0x0046 }
        r4.m11806a(r2);	 Catch:{ all -> 0x0046 }
        r2 = 0;
        r4.f13143d = r2;	 Catch:{ all -> 0x0046 }
        r2 = r4.f13142c;	 Catch:{ all -> 0x0046 }
        r0 = r2.iterator();	 Catch:{ all -> 0x0046 }
        if (r7 != 0) goto L_0x0039;
    L_0x0017:
        r2 = r4.f13140a;	 Catch:{ all -> 0x0046 }
        r2 = r2.a(r6);	 Catch:{ all -> 0x0046 }
        r4.f13143d = r2;	 Catch:{ all -> 0x0046 }
    L_0x001f:
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
    L_0x0020:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0006;
    L_0x0026:
        r1 = r0.next();
        r1 = (android.util.Pair) r1;
        monitor-enter(r1);
        r2 = r1.first;	 Catch:{ all -> 0x0036 }
        r2 = (com.facebook.imagepipeline.p153l.C5517j) r2;	 Catch:{ all -> 0x0036 }
        r2.b(r6, r7);	 Catch:{ all -> 0x0036 }
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        goto L_0x0020;
    L_0x0036:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        throw r2;
    L_0x0039:
        r2 = r4.f13142c;	 Catch:{ all -> 0x0046 }
        r2.clear();	 Catch:{ all -> 0x0046 }
        r2 = r4.f13140a;	 Catch:{ all -> 0x0046 }
        r3 = r4.f13141b;	 Catch:{ all -> 0x0046 }
        com.facebook.imagepipeline.p153l.ac.a(r2, r3, r4);	 Catch:{ all -> 0x0046 }
        goto L_0x001f;
    L_0x0046:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ac$a.a(com.facebook.imagepipeline.l.ac$a$a, java.io.Closeable, boolean):void");
    }

    /* renamed from: a */
    public void m11818a(a forwardingConsumer) {
        synchronized (this) {
            if (this.f13146g != forwardingConsumer) {
                return;
            }
            this.f13146g = null;
            this.f13145f = null;
            m11806a(this.f13143d);
            this.f13143d = null;
            m11803a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m11819a(com.facebook.imagepipeline.l.ac$a.a r4, float r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r2 = r3.f13146g;	 Catch:{ all -> 0x0029 }
        if (r2 == r4) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x0006:
        return;
    L_0x0007:
        r3.f13144e = r5;	 Catch:{ all -> 0x0029 }
        r2 = r3.f13142c;	 Catch:{ all -> 0x0029 }
        r0 = r2.iterator();	 Catch:{ all -> 0x0029 }
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x0010:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0006;
    L_0x0016:
        r1 = r0.next();
        r1 = (android.util.Pair) r1;
        monitor-enter(r1);
        r2 = r1.first;	 Catch:{ all -> 0x0026 }
        r2 = (com.facebook.imagepipeline.p153l.C5517j) r2;	 Catch:{ all -> 0x0026 }
        r2.b(r5);	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x0010;
    L_0x0026:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r2;
    L_0x0029:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.ac$a.a(com.facebook.imagepipeline.l.ac$a$a, float):void");
    }

    /* renamed from: a */
    private void m11806a(Closeable obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
    }
}
