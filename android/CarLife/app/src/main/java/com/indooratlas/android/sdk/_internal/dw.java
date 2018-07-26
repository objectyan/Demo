package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public final class dw {
    /* renamed from: a */
    private final SparseArray<ArrayList<dv>> f23477a = new SparseArray();

    @Nullable
    /* renamed from: a */
    public final dv m20368a(@NonNull cy cyVar, @NonNull cw cwVar, @NonNull da daVar) {
        dv dvVar;
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        eg.m20413a((Object) cwVar, "sensor cannot be null", new Object[0]);
        eg.m20413a((Object) daVar, "params cannot be null", new Object[0]);
        synchronized (this.f23477a) {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) this.f23477a.get(cwVar.mo4658a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(1);
                this.f23477a.append(cwVar.mo4658a(), arrayList2);
                arrayList = arrayList2;
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (((dv) it.next()).f23474a == cyVar) {
                        dvVar = null;
                        break;
                    }
                }
                arrayList = arrayList2;
            }
            dvVar = new dv(cyVar, cwVar, daVar);
            arrayList.add(dvVar);
        }
        return dvVar;
    }

    @NonNull
    /* renamed from: a */
    public final ArrayList<dv> m20369a(@NonNull cy cyVar) {
        eg.m20413a((Object) cyVar, "listener cannot be null", new Object[0]);
        ArrayList<dv> arrayList = new ArrayList(1);
        synchronized (this.f23477a) {
            for (int i = 0; i < this.f23477a.size(); i++) {
                ArrayList arrayList2 = (ArrayList) this.f23477a.valueAt(i);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    dv dvVar = (dv) it.next();
                    if (dvVar.f23474a == cyVar) {
                        arrayList2.remove(dvVar);
                        arrayList.add(dvVar);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.NonNull
    /* renamed from: a */
    public final java.util.ArrayList<com.indooratlas.android.sdk._internal.dv> m20370a(@android.support.annotation.NonNull com.indooratlas.android.sdk._internal.cy r7, @android.support.annotation.NonNull com.indooratlas.android.sdk._internal.cw r8) {
        /*
        r6 = this;
        r2 = 0;
        r0 = "listener cannot be null";
        r1 = new java.lang.Object[r2];
        com.indooratlas.android.sdk._internal.eg.m20413a(r7, r0, r1);
        r0 = "sensor cannot be null";
        r1 = new java.lang.Object[r2];
        com.indooratlas.android.sdk._internal.eg.m20413a(r8, r0, r1);
        r2 = new java.util.ArrayList;
        r0 = 1;
        r2.<init>(r0);
        r3 = r6.f23477a;
        monitor-enter(r3);
        r0 = r6.f23477a;	 Catch:{ all -> 0x0048 }
        r1 = r8.mo4658a();	 Catch:{ all -> 0x0048 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0045;
    L_0x0028:
        r4 = r0.iterator();	 Catch:{ all -> 0x0048 }
    L_0x002c:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x0045;
    L_0x0032:
        r1 = r4.next();	 Catch:{ all -> 0x0048 }
        r1 = (com.indooratlas.android.sdk._internal.dv) r1;	 Catch:{ all -> 0x0048 }
        r5 = r1.f23474a;	 Catch:{ all -> 0x0048 }
        if (r5 != r7) goto L_0x002c;
    L_0x003c:
        r0.remove(r1);	 Catch:{ all -> 0x0048 }
        r2.add(r1);	 Catch:{ all -> 0x0048 }
        monitor-exit(r3);	 Catch:{ all -> 0x0048 }
        r0 = r2;
    L_0x0044:
        return r0;
    L_0x0045:
        monitor-exit(r3);	 Catch:{ all -> 0x0048 }
        r0 = r2;
        goto L_0x0044;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0048 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.dw.a(com.indooratlas.android.sdk._internal.cy, com.indooratlas.android.sdk._internal.cw):java.util.ArrayList<com.indooratlas.android.sdk._internal.dv>");
    }

    /* renamed from: a */
    public final void m20371a(int i, @NonNull cx cxVar) {
        eg.m20413a((Object) cxVar, "Sensor event cannot be null.", new Object[0]);
        synchronized (this.f23477a) {
            ArrayList arrayList = (ArrayList) this.f23477a.get(i);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((dv) it.next()).m20363a(cxVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m20372a(cx cxVar) {
        eg.m20413a((Object) cxVar, "Sensor event cannot be null.", new Object[0]);
        m20371a(cxVar.f23358a.mo4658a(), cxVar);
    }

    /* renamed from: b */
    private int m20365b(int i) {
        int size;
        synchronized (this.f23477a) {
            ArrayList arrayList = (ArrayList) this.f23477a.get(i);
            if (arrayList != null) {
                size = arrayList.size();
            } else {
                size = 0;
            }
        }
        return size;
    }

    /* renamed from: a */
    public final int m20367a(cw cwVar) {
        int b;
        synchronized (this.f23477a) {
            b = m20365b(cwVar.mo4658a());
        }
        return b;
    }

    /* renamed from: a */
    public final int m20366a(int i) {
        int i2;
        ArrayList arrayList = (ArrayList) this.f23477a.get(i);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            int i3 = -1;
            while (it.hasNext()) {
                i2 = ((dv) it.next()).f23476c.f23374c;
                if (i2 == 0) {
                    i2 = 5000;
                } else if (i2 == 1) {
                    i2 = 20000;
                } else if (i2 == 2) {
                    i2 = 60000;
                } else if (i2 == 3) {
                    i2 = 200000;
                }
                if (i3 != -1 && r0 >= i3) {
                    i2 = i3;
                }
                i3 = i2;
            }
            i2 = i3;
        } else {
            i2 = -1;
        }
        return i2 >= 0 ? i2 : 0;
    }

    /* renamed from: b */
    public final int m20373b(cw cwVar) {
        return m20366a(cwVar.mo4658a());
    }
}
