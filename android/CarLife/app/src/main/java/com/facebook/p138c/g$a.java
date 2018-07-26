package com.facebook.p138c;

import com.facebook.common.internal.C5273m;
import com.facebook.common.p256c.C5303a;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: FirstAvailableDataSourceSupplier */
/* renamed from: com.facebook.c.g$a */
class g$a extends C2919a<T> {
    /* renamed from: a */
    final /* synthetic */ C5293g f12872a;
    /* renamed from: b */
    private int f12873b = 0;
    /* renamed from: c */
    private C2918d<T> f12874c = null;
    /* renamed from: d */
    private C2918d<T> f12875d = null;

    public g$a(C5293g c5293g) {
        this.f12872a = c5293g;
        if (!m11229j()) {
            m11212a(new RuntimeException("No data source supplier or supplier returned null."));
        }
    }

    @Nullable
    /* renamed from: d */
    public synchronized T mo2015d() {
        C2918d<T> dataSourceWithResult;
        dataSourceWithResult = m11231l();
        return dataSourceWithResult != null ? dataSourceWithResult.mo2015d() : null;
    }

    /* renamed from: c */
    public synchronized boolean mo2014c() {
        boolean z;
        C2918d<T> dataSourceWithResult = m11231l();
        z = dataSourceWithResult != null && dataSourceWithResult.mo2014c();
        return z;
    }

    /* renamed from: h */
    public boolean mo2019h() {
        synchronized (this) {
            if (super.mo2019h()) {
                C2918d<T> currentDataSource = this.f12874c;
                this.f12874c = null;
                C2918d<T> dataSourceWithResult = this.f12875d;
                this.f12875d = null;
                m11228e(dataSourceWithResult);
                m11228e(currentDataSource);
                return true;
            }
            return false;
        }
    }

    /* renamed from: j */
    private boolean m11229j() {
        C2918d<T> dataSource;
        C5273m<C2918d<T>> dataSourceSupplier = m11230k();
        if (dataSourceSupplier != null) {
            dataSource = (C2918d) dataSourceSupplier.b();
        } else {
            dataSource = null;
        }
        if (!m11223a(dataSource) || dataSource == null) {
            m11228e(dataSource);
            return false;
        }
        dataSource.mo2011a(new g$a$a(this, null), C5303a.a());
        return true;
    }

    @Nullable
    /* renamed from: k */
    private synchronized C5273m<C2918d<T>> m11230k() {
        C5273m<C2918d<T>> c5273m;
        if (mo2012a() || this.f12873b >= C5293g.a(this.f12872a).size()) {
            c5273m = null;
        } else {
            List a = C5293g.a(this.f12872a);
            int i = this.f12873b;
            this.f12873b = i + 1;
            c5273m = (C5273m) a.get(i);
        }
        return c5273m;
    }

    /* renamed from: a */
    private synchronized boolean m11223a(C2918d<T> dataSource) {
        boolean z;
        if (mo2012a()) {
            z = false;
        } else {
            this.f12874c = dataSource;
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private synchronized boolean m11225b(C2918d<T> dataSource) {
        boolean z;
        if (mo2012a() || dataSource != this.f12874c) {
            z = false;
        } else {
            this.f12874c = null;
            z = true;
        }
        return z;
    }

    @Nullable
    /* renamed from: l */
    private synchronized C2918d<T> m11231l() {
        return this.f12875d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m11221a(com.facebook.p138c.C2918d<T> r3, boolean r4) {
        /*
        r2 = this;
        r0 = 0;
        monitor-enter(r2);
        r1 = r2.f12874c;	 Catch:{ all -> 0x001b }
        if (r3 != r1) goto L_0x000a;
    L_0x0006:
        r1 = r2.f12875d;	 Catch:{ all -> 0x001b }
        if (r3 != r1) goto L_0x000c;
    L_0x000a:
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
    L_0x000b:
        return;
    L_0x000c:
        r1 = r2.f12875d;	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0012;
    L_0x0010:
        if (r4 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r2.f12875d;	 Catch:{ all -> 0x001b }
        r2.f12875d = r3;	 Catch:{ all -> 0x001b }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        r2.m11228e(r0);
        goto L_0x000b;
    L_0x001b:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.c.g$a.a(com.facebook.c.d, boolean):void");
    }

    /* renamed from: c */
    private void m11226c(C2918d<T> dataSource) {
        if (m11225b(dataSource)) {
            if (dataSource != m11231l()) {
                m11228e(dataSource);
            }
            if (!m11229j()) {
                m11212a(dataSource.mo2017f());
            }
        }
    }

    /* renamed from: d */
    private void m11227d(C2918d<T> dataSource) {
        m11221a((C2918d) dataSource, dataSource.mo2013b());
        if (dataSource == m11231l()) {
            m11211a(null, dataSource.mo2013b());
        }
    }

    /* renamed from: e */
    private void m11228e(C2918d<T> dataSource) {
        if (dataSource != null) {
            dataSource.mo2019h();
        }
    }
}
