package com.facebook.p138c;

import com.facebook.common.internal.C5273m;
import com.facebook.common.p256c.C5303a;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: IncreasingQualityDataSourceSupplier */
/* renamed from: com.facebook.c.h$a */
class h$a extends C2919a<T> {
    /* renamed from: a */
    final /* synthetic */ C5294h f12876a;
    @GuardedBy("IncreasingQualityDataSource.this")
    @Nullable
    /* renamed from: b */
    private ArrayList<C2918d<T>> f12877b;
    @GuardedBy("IncreasingQualityDataSource.this")
    /* renamed from: c */
    private int f12878c;

    public h$a(C5294h c5294h) {
        this.f12876a = c5294h;
        int n = C5294h.a(c5294h).size();
        this.f12878c = n;
        this.f12877b = new ArrayList(n);
        int i = 0;
        while (i < n) {
            C2918d<T> dataSource = (C2918d) ((C5273m) C5294h.a(c5294h).get(i)).b();
            this.f12877b.add(dataSource);
            dataSource.mo2011a(new h$a$a(this, i), C5303a.a());
            if (!dataSource.mo2014c()) {
                i++;
            } else {
                return;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    private synchronized C2918d<T> m11235a(int i) {
        C2918d<T> c2918d;
        c2918d = (this.f12877b == null || i >= this.f12877b.size()) ? null : (C2918d) this.f12877b.get(i);
        return c2918d;
    }

    @Nullable
    /* renamed from: b */
    private synchronized C2918d<T> m11240b(int i) {
        C2918d<T> c2918d = null;
        synchronized (this) {
            if (this.f12877b != null && i < this.f12877b.size()) {
                c2918d = (C2918d) this.f12877b.set(i, null);
            }
        }
        return c2918d;
    }

    @Nullable
    /* renamed from: j */
    private synchronized C2918d<T> m11244j() {
        return m11235a(this.f12878c);
    }

    @Nullable
    /* renamed from: d */
    public synchronized T mo2015d() {
        C2918d<T> dataSourceWithResult;
        dataSourceWithResult = m11244j();
        return dataSourceWithResult != null ? dataSourceWithResult.mo2015d() : null;
    }

    /* renamed from: c */
    public synchronized boolean mo2014c() {
        boolean z;
        C2918d<T> dataSourceWithResult = m11244j();
        z = dataSourceWithResult != null && dataSourceWithResult.mo2014c();
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public boolean mo2019h() {
        /*
        r3 = this;
        monitor-enter(r3);
        r2 = super.mo2019h();	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x000a;
    L_0x0007:
        r2 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0025 }
    L_0x0009:
        return r2;
    L_0x000a:
        r0 = r3.f12877b;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r3.f12877b = r2;	 Catch:{ all -> 0x0025 }
        monitor-exit(r3);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0028;
    L_0x0012:
        r1 = 0;
    L_0x0013:
        r2 = r0.size();
        if (r1 >= r2) goto L_0x0028;
    L_0x0019:
        r2 = r0.get(r1);
        r2 = (com.facebook.p138c.C2918d) r2;
        r3.m11238a(r2);
        r1 = r1 + 1;
        goto L_0x0013;
    L_0x0025:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0025 }
        throw r2;
    L_0x0028:
        r2 = 1;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.c.h$a.h():boolean");
    }

    /* renamed from: a */
    private void m11236a(int index, C2918d<T> dataSource) {
        m11237a(index, (C2918d) dataSource, dataSource.mo2013b());
        if (dataSource == m11244j()) {
            boolean z = index == 0 && dataSource.mo2013b();
            m11211a(null, z);
        }
    }

    /* renamed from: b */
    private void m11241b(int index, C2918d<T> dataSource) {
        m11238a(m11243c(index, dataSource));
        if (index == 0) {
            m11212a(dataSource.mo2017f());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m11237a(int r5, com.facebook.p138c.C2918d<T> r6, boolean r7) {
        /*
        r4 = this;
        monitor-enter(r4);
        r2 = r4.f12878c;	 Catch:{ all -> 0x002e }
        r1 = r4.f12878c;	 Catch:{ all -> 0x002e }
        r3 = r4.m11235a(r5);	 Catch:{ all -> 0x002e }
        if (r6 != r3) goto L_0x000f;
    L_0x000b:
        r3 = r4.f12878c;	 Catch:{ all -> 0x002e }
        if (r5 != r3) goto L_0x0011;
    L_0x000f:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
    L_0x0010:
        return;
    L_0x0011:
        r3 = r4.m11244j();	 Catch:{ all -> 0x002e }
        if (r3 == 0) goto L_0x001d;
    L_0x0017:
        if (r7 == 0) goto L_0x0020;
    L_0x0019:
        r3 = r4.f12878c;	 Catch:{ all -> 0x002e }
        if (r5 >= r3) goto L_0x0020;
    L_0x001d:
        r1 = r5;
        r4.f12878c = r5;	 Catch:{ all -> 0x002e }
    L_0x0020:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        r0 = r2;
    L_0x0022:
        if (r0 <= r1) goto L_0x0010;
    L_0x0024:
        r3 = r4.m11240b(r0);
        r4.m11238a(r3);
        r0 = r0 + -1;
        goto L_0x0022;
    L_0x002e:
        r3 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.c.h$a.a(int, com.facebook.c.d, boolean):void");
    }

    @Nullable
    /* renamed from: c */
    private synchronized C2918d<T> m11243c(int i, C2918d<T> dataSource) {
        if (dataSource == m11244j()) {
            dataSource = null;
        } else if (dataSource == m11235a(i)) {
            dataSource = m11240b(i);
        }
        return dataSource;
    }

    /* renamed from: a */
    private void m11238a(C2918d<T> dataSource) {
        if (dataSource != null) {
            dataSource.mo2019h();
        }
    }
}
