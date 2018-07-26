package com.facebook.imagepipeline.p149d;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.p135b.p136a.C5247d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: StagingArea */
/* renamed from: com.facebook.imagepipeline.d.u */
public class C5491u {
    /* renamed from: a */
    private static final Class<?> f22319a = C5491u.class;
    @GuardedBy("this")
    /* renamed from: b */
    private Map<C5247d, C2952d> f22320b = new HashMap();

    private C5491u() {
    }

    /* renamed from: a */
    public static C5491u m18838a() {
        return new C5491u();
    }

    /* renamed from: a */
    public synchronized void m18840a(C5247d key, C2952d encodedImage) {
        C5350k.m18310a((Object) key);
        C5350k.m18315a(C2952d.e(encodedImage));
        C2952d.d((C2952d) this.f22320b.put(key, C2952d.a(encodedImage)));
        m18839c();
    }

    /* renamed from: b */
    public void m18843b() {
        synchronized (this) {
            List<C2952d> old = new ArrayList(this.f22320b.values());
            this.f22320b.clear();
        }
        for (int i = 0; i < old.size(); i++) {
            C2952d encodedImage = (C2952d) old.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    /* renamed from: a */
    public boolean m18841a(C5247d key) {
        C5350k.m18310a((Object) key);
        synchronized (this) {
            C2952d encodedImage = (C2952d) this.f22320b.remove(key);
        }
        if (encodedImage == null) {
            return false;
        }
        try {
            boolean b = encodedImage.b();
            return b;
        } finally {
            encodedImage.close();
        }
    }

    /* renamed from: b */
    public synchronized boolean m18844b(C5247d key, C2952d encodedImage) {
        boolean z = false;
        synchronized (this) {
            C5350k.m18310a((Object) key);
            C5350k.m18310a((Object) encodedImage);
            C5350k.m18315a(C2952d.e(encodedImage));
            C2952d oldValue = (C2952d) this.f22320b.get(key);
            if (oldValue != null) {
                C2921a<C5640y> oldRef = oldValue.c();
                C2921a<C5640y> ref = encodedImage.c();
                if (!(oldRef == null || ref == null)) {
                    try {
                        if (oldRef.a() == ref.a()) {
                            this.f22320b.remove(key);
                            m18839c();
                            z = true;
                        }
                    } finally {
                        C2921a.c(ref);
                        C2921a.c(oldRef);
                        C2952d.d(oldValue);
                    }
                }
                C2921a.c(ref);
                C2921a.c(oldRef);
                C2952d.d(oldValue);
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized com.facebook.imagepipeline.p152i.C2952d m18842b(com.facebook.p135b.p136a.C5247d r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        com.facebook.common.internal.C5350k.m18310a(r8);	 Catch:{ all -> 0x0052 }
        r2 = r7.f22320b;	 Catch:{ all -> 0x0052 }
        r0 = r2.get(r8);	 Catch:{ all -> 0x0052 }
        r0 = (com.facebook.imagepipeline.p152i.C2952d) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x004c;
    L_0x000e:
        monitor-enter(r0);	 Catch:{ all -> 0x0052 }
        r2 = com.facebook.imagepipeline.p152i.C2952d.e(r0);	 Catch:{ all -> 0x004e }
        if (r2 != 0) goto L_0x0046;
    L_0x0015:
        r2 = r7.f22320b;	 Catch:{ all -> 0x004e }
        r2.remove(r8);	 Catch:{ all -> 0x004e }
        r2 = f22319a;	 Catch:{ all -> 0x004e }
        r3 = "Found closed reference %d for key %s (%d)";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x004e }
        r5 = 0;
        r6 = java.lang.System.identityHashCode(r0);	 Catch:{ all -> 0x004e }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x004e }
        r4[r5] = r6;	 Catch:{ all -> 0x004e }
        r5 = 1;
        r6 = r8.toString();	 Catch:{ all -> 0x004e }
        r4[r5] = r6;	 Catch:{ all -> 0x004e }
        r5 = 2;
        r6 = java.lang.System.identityHashCode(r8);	 Catch:{ all -> 0x004e }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x004e }
        r4[r5] = r6;	 Catch:{ all -> 0x004e }
        com.facebook.common.p257e.C5320a.m18174d(r2, r3, r4);	 Catch:{ all -> 0x004e }
        r2 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x004e }
    L_0x0044:
        monitor-exit(r7);
        return r2;
    L_0x0046:
        r1 = com.facebook.imagepipeline.p152i.C2952d.a(r0);	 Catch:{ all -> 0x004e }
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        r0 = r1;
    L_0x004c:
        r2 = r0;
        goto L_0x0044;
    L_0x004e:
        r2 = move-exception;
        r1 = r0;
    L_0x0050:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        throw r2;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r2 = move-exception;
        monitor-exit(r7);
        throw r2;
    L_0x0055:
        r2 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.d.u.b(com.facebook.b.a.d):com.facebook.imagepipeline.i.d");
    }

    /* renamed from: c */
    public synchronized boolean m18845c(C5247d key) {
        boolean z = false;
        synchronized (this) {
            C5350k.m18310a((Object) key);
            if (this.f22320b.containsKey(key)) {
                C2952d storedEncodedImage = (C2952d) this.f22320b.get(key);
                synchronized (storedEncodedImage) {
                    if (C2952d.e(storedEncodedImage)) {
                        z = true;
                    } else {
                        this.f22320b.remove(key);
                        C5320a.m18174d(f22319a, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(storedEncodedImage)), key.toString(), Integer.valueOf(System.identityHashCode(key)));
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    private synchronized void m18839c() {
        C5320a.m18123a(f22319a, "Count = %d", Integer.valueOf(this.f22320b.size()));
    }
}
