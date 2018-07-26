package com.facebook.p135b.p137b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p141m.C5368d;
import com.facebook.common.p254b.C5280a;
import com.facebook.common.p254b.C5301b;
import com.facebook.common.p257e.C5320a;
import com.facebook.common.p260j.C5356a;
import com.facebook.common.p260j.C5356a.C5355a;
import com.facebook.common.p262l.C5361b;
import com.facebook.common.p262l.C5364f;
import com.facebook.p135b.p136a.C5244a;
import com.facebook.p135b.p136a.C5244a.C5243a;
import com.facebook.p135b.p136a.C5246c;
import com.facebook.p135b.p136a.C5246c.C5245a;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p135b.p136a.C5248f;
import com.facebook.p135b.p136a.C5252j;
import com.facebook.p135b.p137b.C5266d.C5259c;
import com.facebook.p135b.p137b.C5266d.C5263d;
import com.facebook.p135b.p137b.C5266d.C5275a;
import com.facebook.p252a.C5240a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: DiskStorageCache */
/* renamed from: com.facebook.b.b.e */
public class C5282e implements C5281j, C5280a {
    /* renamed from: a */
    public static final int f21820a = 1;
    /* renamed from: d */
    private static final Class<?> f21821d = C5282e.class;
    /* renamed from: e */
    private static final long f21822e = TimeUnit.HOURS.toMillis(2);
    /* renamed from: f */
    private static final long f21823f = TimeUnit.MINUTES.toMillis(30);
    /* renamed from: g */
    private static final double f21824g = 0.02d;
    /* renamed from: h */
    private static final long f21825h = -1;
    /* renamed from: i */
    private static final String f21826i = "disk_entries_list";
    @GuardedBy("mLock")
    @VisibleForTesting
    /* renamed from: b */
    Map<Integer, String> f21827b = new HashMap();
    @GuardedBy("mLock")
    @VisibleForTesting
    /* renamed from: c */
    final Set<String> f21828c;
    /* renamed from: j */
    private final long f21829j;
    /* renamed from: k */
    private final long f21830k;
    /* renamed from: l */
    private final CountDownLatch f21831l = new CountDownLatch(1);
    /* renamed from: m */
    private long f21832m;
    /* renamed from: n */
    private final C5246c f21833n;
    /* renamed from: o */
    private final SharedPreferences f21834o;
    @GuardedBy("mLock")
    /* renamed from: p */
    private long f21835p;
    /* renamed from: q */
    private final long f21836q;
    /* renamed from: r */
    private final C5356a f21837r;
    /* renamed from: s */
    private final C5266d f21838s;
    /* renamed from: t */
    private final C5270i f21839t;
    /* renamed from: u */
    private final C5244a f21840u;
    /* renamed from: v */
    private final C5278a f21841v;
    /* renamed from: w */
    private final C5361b f21842w;
    /* renamed from: x */
    private final Object f21843x = new Object();

    /* compiled from: DiskStorageCache */
    /* renamed from: com.facebook.b.b.e$1 */
    class C52771 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5282e f21813a;

        C52771(C5282e this$0) {
            this.f21813a = this$0;
        }

        public void run() {
            synchronized (this.f21813a.f21843x) {
                this.f21813a.m17983j();
            }
            this.f21813a.f21831l.countDown();
        }
    }

    @VisibleForTesting
    /* compiled from: DiskStorageCache */
    /* renamed from: com.facebook.b.b.e$a */
    static class C5278a {
        /* renamed from: a */
        private boolean f21814a = false;
        /* renamed from: b */
        private long f21815b = -1;
        /* renamed from: c */
        private long f21816c = -1;

        C5278a() {
        }

        /* renamed from: a */
        public synchronized boolean m17947a() {
            return this.f21814a;
        }

        /* renamed from: b */
        public synchronized void m17948b() {
            this.f21814a = false;
            this.f21816c = -1;
            this.f21815b = -1;
        }

        /* renamed from: a */
        public synchronized void m17946a(long size, long count) {
            this.f21816c = count;
            this.f21815b = size;
            this.f21814a = true;
        }

        /* renamed from: b */
        public synchronized void m17949b(long sizeIncrement, long countIncrement) {
            if (this.f21814a) {
                this.f21815b += sizeIncrement;
                this.f21816c += countIncrement;
            }
        }

        /* renamed from: c */
        public synchronized long m17950c() {
            return this.f21815b;
        }

        /* renamed from: d */
        public synchronized long m17951d() {
            return this.f21816c;
        }
    }

    /* compiled from: DiskStorageCache */
    /* renamed from: com.facebook.b.b.e$b */
    public static class C5279b {
        /* renamed from: a */
        public final long f21817a;
        /* renamed from: b */
        public final long f21818b;
        /* renamed from: c */
        public final long f21819c;

        public C5279b(long cacheSizeLimitMinimum, long lowDiskSpaceCacheSizeLimit, long defaultCacheSizeLimit) {
            this.f21817a = cacheSizeLimitMinimum;
            this.f21818b = lowDiskSpaceCacheSizeLimit;
            this.f21819c = defaultCacheSizeLimit;
        }
    }

    public C5282e(C5266d diskStorage, C5270i entryEvictionComparatorSupplier, C5279b params, C5246c cacheEventListener, C5244a cacheErrorLogger, @Nullable C5301b diskTrimmableRegistry, Context context) {
        this.f21829j = params.f21818b;
        this.f21830k = params.f21819c;
        this.f21832m = params.f21819c;
        this.f21837r = C5356a.m18347a();
        this.f21838s = diskStorage;
        this.f21839t = entryEvictionComparatorSupplier;
        this.f21835p = -1;
        this.f21833n = cacheEventListener;
        this.f21836q = params.f21817a;
        this.f21840u = cacheErrorLogger;
        this.f21841v = new C5278a();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.mo3993a(this);
        }
        this.f21842w = C5364f.m18362b();
        this.f21834o = C5282e.m17965a(context, this.f21838s.mo3961b());
        this.f21828c = new HashSet();
        Executors.newSingleThreadExecutor().execute(new C52771(this));
    }

    /* renamed from: a */
    public C5275a mo3973a() throws IOException {
        return this.f21838s.mo3966e();
    }

    /* renamed from: b */
    public boolean mo3974b() {
        return this.f21838s.mo3958a();
    }

    @VisibleForTesting
    /* renamed from: c */
    protected void m17991c() {
        try {
            this.f21831l.await();
        } catch (InterruptedException e) {
            C5320a.m18180e(f21821d, "Memory Index is not ready yet. ");
        }
    }

    /* renamed from: a */
    public C5240a mo3971a(C5247d key) {
        String resourceId = null;
        C2917l cacheEvent = new C2917l().a(key);
        Integer hashKey = Integer.valueOf(key.hashCode());
        try {
            C5240a resource;
            synchronized (this.f21843x) {
                resource = null;
                if (this.f21827b.containsKey(hashKey)) {
                    resourceId = (String) this.f21827b.get(hashKey);
                    cacheEvent.a(resourceId);
                    resource = this.f21838s.mo3960b(resourceId, key);
                } else {
                    List<String> resourceIds = C5282e.m17979g(key);
                    for (int i = 0; i < resourceIds.size(); i++) {
                        resourceId = (String) resourceIds.get(i);
                        if (this.f21828c.contains(resourceId)) {
                            cacheEvent.a(resourceId);
                            resource = this.f21838s.mo3960b(resourceId, key);
                            if (resource != null) {
                                break;
                            }
                        }
                    }
                }
                if (resource == null) {
                    this.f21833n.mo3939b(cacheEvent);
                    m17973a(hashKey);
                } else {
                    this.f21833n.mo3938a(cacheEvent);
                    m17974a(hashKey, resourceId);
                }
            }
            return resource;
        } catch (IOException ioe) {
            this.f21840u.mo3937a(C5243a.GENERIC_IO, f21821d, "getResource", ioe);
            cacheEvent.a(ioe);
            this.f21833n.mo3942e(cacheEvent);
            return null;
        }
    }

    /* renamed from: b */
    public boolean mo3975b(C5247d key) {
        String resourceId = null;
        try {
            boolean retval;
            synchronized (this.f21843x) {
                retval = false;
                Integer hashKey = Integer.valueOf(key.hashCode());
                if (this.f21827b.containsKey(hashKey)) {
                    resourceId = (String) this.f21827b.get(hashKey);
                    retval = this.f21838s.mo3965d(resourceId, key);
                } else {
                    List<String> resourceIds = C5282e.m17979g(key);
                    for (int i = 0; i < resourceIds.size(); i++) {
                        resourceId = (String) resourceIds.get(i);
                        if (this.f21828c.contains(resourceId)) {
                            retval = this.f21838s.mo3965d(resourceId, key);
                            if (retval) {
                                break;
                            }
                        }
                    }
                }
                if (retval) {
                    m17974a(hashKey, resourceId);
                }
            }
            return retval;
        } catch (IOException e) {
            this.f21833n.mo3942e(new C2917l().a(key).a(null).a(e));
            return false;
        }
    }

    /* renamed from: a */
    private C5263d m17967a(String resourceId, C5247d key) throws IOException {
        m17981h();
        return this.f21838s.mo3957a(resourceId, key);
    }

    /* renamed from: a */
    private C5240a m17966a(C5263d inserter, C5247d key, String resourceId) throws IOException {
        C5240a resource;
        synchronized (this.f21843x) {
            resource = inserter.mo3953a(key);
            m17974a(Integer.valueOf(key.hashCode()), resourceId);
            this.f21841v.m17949b(resource.mo3932c(), 1);
        }
        return resource;
    }

    /* renamed from: a */
    public C5240a mo3972a(C5247d key, C5252j callback) throws IOException {
        String resourceId;
        C2917l cacheEvent = new C2917l().a(key);
        this.f21833n.mo3940c(cacheEvent);
        synchronized (this.f21843x) {
            Integer hashKey = Integer.valueOf(key.hashCode());
            if (this.f21827b.containsKey(hashKey)) {
                resourceId = (String) this.f21827b.get(hashKey);
            } else {
                resourceId = C5282e.m17978f(key);
            }
        }
        cacheEvent.a(resourceId);
        C5263d inserter;
        try {
            inserter = m17967a(resourceId, key);
            inserter.mo3954a(callback, key);
            C5240a resource = m17966a(inserter, key, resourceId);
            cacheEvent.a(resource.mo3932c()).b(this.f21841v.m17950c());
            this.f21833n.mo3941d(cacheEvent);
            if (!inserter.mo3955a()) {
                C5320a.m18180e(f21821d, "Failed to delete temp file");
            }
            return resource;
        } catch (Throwable ioe) {
            cacheEvent.a(ioe);
            this.f21833n.mo3943f(cacheEvent);
            C5320a.m18181e(f21821d, "Failed inserting a file into the cache", ioe);
            throw ioe;
        } catch (Throwable th) {
            if (!inserter.mo3955a()) {
                C5320a.m18180e(f21821d, "Failed to delete temp file");
            }
        }
    }

    /* renamed from: c */
    public void mo3976c(C5247d key) {
        synchronized (this.f21843x) {
            try {
                Integer hashKey = Integer.valueOf(key.hashCode());
                if (this.f21827b.containsKey(hashKey)) {
                    this.f21838s.mo3959b((String) this.f21827b.get(hashKey));
                } else {
                    List<String> resourceIds = C5282e.m17979g(key);
                    for (int i = 0; i < resourceIds.size(); i++) {
                        this.f21838s.mo3959b((String) resourceIds.get(i));
                    }
                }
                m17973a(hashKey);
            } catch (IOException e) {
                this.f21840u.mo3937a(C5243a.DELETE_FILE, f21821d, "delete: " + e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public long mo3970a(long cacheExpirationMs) {
        long oldestRemainingEntryAgeMs = 0;
        synchronized (this.f21843x) {
            try {
                long now = this.f21842w.mo4020a();
                Collection<C5259c> allEntries = this.f21838s.mo3967g();
                long cacheSizeBeforeClearance = this.f21841v.m17950c();
                int itemsRemovedCount = 0;
                long itemsRemovedSize = 0;
                for (C5259c entry : allEntries) {
                    long entryAgeMs = Math.max(1, Math.abs(now - entry.mo3950b()));
                    if (entryAgeMs >= cacheExpirationMs) {
                        long entryRemovedSize = this.f21838s.mo3956a(entry);
                        m17975a(entry.mo3949a());
                        if (entryRemovedSize > 0) {
                            itemsRemovedCount++;
                            itemsRemovedSize += entryRemovedSize;
                            this.f21833n.mo3944g(new C2917l().a(entry.mo3949a()).a(C5245a.CONTENT_STALE).a(entryRemovedSize).b(cacheSizeBeforeClearance - itemsRemovedSize));
                        }
                    } else {
                        oldestRemainingEntryAgeMs = Math.max(oldestRemainingEntryAgeMs, entryAgeMs);
                    }
                }
                this.f21838s.mo3962c();
                if (itemsRemovedCount > 0) {
                    m17983j();
                    this.f21841v.m17949b(-itemsRemovedSize, (long) (-itemsRemovedCount));
                }
            } catch (IOException ioe) {
                this.f21840u.mo3937a(C5243a.EVICTION, f21821d, "clearOldEntries: " + ioe.getMessage(), ioe);
            }
        }
        return oldestRemainingEntryAgeMs;
    }

    /* renamed from: h */
    private void m17981h() throws IOException {
        synchronized (this.f21843x) {
            boolean calculatedRightNow = m17983j();
            m17982i();
            long cacheSize = this.f21841v.m17950c();
            if (cacheSize > this.f21832m && !calculatedRightNow) {
                this.f21841v.m17948b();
                m17983j();
            }
            if (cacheSize > this.f21832m) {
                m17972a((this.f21832m * 9) / 10, C5245a.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    /* renamed from: a */
    private void m17972a(long desiredSize, C5245a reason) throws IOException {
        try {
            Collection<C5259c> entries = m17970a(this.f21838s.mo3967g());
            long cacheSizeBeforeClearance = this.f21841v.m17950c();
            long deleteSize = cacheSizeBeforeClearance - desiredSize;
            int itemCount = 0;
            long sumItemSizes = 0;
            for (C5259c entry : entries) {
                if (sumItemSizes > deleteSize) {
                    break;
                }
                long deletedSize = this.f21838s.mo3956a(entry);
                m17975a(entry.mo3949a());
                if (deletedSize > 0) {
                    itemCount++;
                    sumItemSizes += deletedSize;
                    this.f21833n.mo3944g(new C2917l().a(entry.mo3949a()).a(reason).a(deletedSize).b(cacheSizeBeforeClearance - sumItemSizes).c(desiredSize));
                }
            }
            this.f21841v.m17949b(-sumItemSizes, (long) (-itemCount));
            this.f21838s.mo3962c();
        } catch (IOException ioe) {
            this.f21840u.mo3937a(C5243a.EVICTION, f21821d, "evictAboveSize: " + ioe.getMessage(), ioe);
            throw ioe;
        }
    }

    /* renamed from: a */
    private Collection<C5259c> m17970a(Collection<C5259c> allEntries) {
        long threshold = this.f21842w.mo4020a() + f21822e;
        ArrayList<C5259c> sortedList = new ArrayList(allEntries.size());
        ArrayList<C5259c> listToSort = new ArrayList(allEntries.size());
        for (C5259c entry : allEntries) {
            if (entry.mo3950b() > threshold) {
                sortedList.add(entry);
            } else {
                listToSort.add(entry);
            }
        }
        Collections.sort(listToSort, this.f21839t.mo3968a());
        sortedList.addAll(listToSort);
        return sortedList;
    }

    @GuardedBy("mLock")
    /* renamed from: i */
    private void m17982i() {
        if (this.f21837r.m18352a(C5355a.INTERNAL, this.f21830k - this.f21841v.m17950c())) {
            this.f21832m = this.f21829j;
        } else {
            this.f21832m = this.f21830k;
        }
    }

    /* renamed from: d */
    public long mo3977d() {
        return this.f21841v.m17950c();
    }

    /* renamed from: e */
    public void mo3979e() {
        synchronized (this.f21843x) {
            try {
                this.f21838s.mo3964d();
                this.f21828c.clear();
                this.f21827b.clear();
            } catch (IOException ioe) {
                this.f21840u.mo3937a(C5243a.EVICTION, f21821d, "clearAll: " + ioe.getMessage(), ioe);
            }
            C5283f.m18000a(this.f21834o);
            this.f21841v.m17948b();
        }
    }

    /* renamed from: d */
    public boolean mo3978d(C5247d key) {
        boolean z = true;
        synchronized (this.f21843x) {
            int hashKey = key.hashCode();
            if (this.f21827b.containsKey(Integer.valueOf(hashKey))) {
            } else {
                List<String> resourceIds = C5282e.m17979g(key);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String resourceId = (String) resourceIds.get(i);
                    if (this.f21828c.contains(resourceId)) {
                        this.f21827b.put(Integer.valueOf(hashKey), resourceId);
                        break;
                    }
                }
                z = false;
            }
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo3980e(C5247d key) {
        boolean z;
        synchronized (this.f21843x) {
            if (mo3978d(key)) {
                z = true;
            } else {
                String resourceId = null;
                z = false;
                try {
                    List<String> resourceIds = C5282e.m17979g(key);
                    for (int i = 0; i < resourceIds.size(); i++) {
                        resourceId = (String) resourceIds.get(i);
                        z = this.f21838s.mo3963c(resourceId, key);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        m17974a(Integer.valueOf(key.hashCode()), resourceId);
                    }
                } catch (IOException e) {
                    z = false;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public void mo3981f() {
        /*
        r12 = this;
        r8 = 0;
        r5 = r12.f21843x;
        monitor-enter(r5);
        r12.m17983j();	 Catch:{ all -> 0x0037 }
        r4 = r12.f21841v;	 Catch:{ all -> 0x0037 }
        r0 = r4.m17950c();	 Catch:{ all -> 0x0037 }
        r6 = r12.f21836q;	 Catch:{ all -> 0x0037 }
        r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x001e;
    L_0x0014:
        r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r4 <= 0) goto L_0x001e;
    L_0x0018:
        r6 = r12.f21836q;	 Catch:{ all -> 0x0037 }
        r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
    L_0x001f:
        return;
    L_0x0020:
        r6 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r8 = r12.f21836q;	 Catch:{ all -> 0x0037 }
        r8 = (double) r8;	 Catch:{ all -> 0x0037 }
        r10 = (double) r0;	 Catch:{ all -> 0x0037 }
        r8 = r8 / r10;
        r2 = r6 - r8;
        r6 = 4581421828931458171; // 0x3f947ae147ae147b float:89128.96 double:0.02;
        r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0035;
    L_0x0032:
        r12.m17971a(r2);	 Catch:{ all -> 0x0037 }
    L_0x0035:
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
        goto L_0x001f;
    L_0x0037:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.b.b.e.f():void");
    }

    /* renamed from: g */
    public void mo3982g() {
        mo3979e();
    }

    /* renamed from: a */
    private void m17971a(double trimRatio) {
        synchronized (this.f21843x) {
            try {
                this.f21841v.m17948b();
                m17983j();
                long cacheSize = this.f21841v.m17950c();
                m17972a(cacheSize - ((long) (((double) cacheSize) * trimRatio)), C5245a.CACHE_MANAGER_TRIMMED);
            } catch (IOException ioe) {
                this.f21840u.mo3937a(C5243a.EVICTION, f21821d, "trimBy: " + ioe.getMessage(), ioe);
            }
        }
    }

    @GuardedBy("mLock")
    /* renamed from: j */
    private boolean m17983j() {
        long now = this.f21842w.mo4020a();
        if (this.f21841v.m17947a() && this.f21835p != -1 && now - this.f21835p <= f21823f) {
            return false;
        }
        m17984k();
        this.f21835p = now;
        return true;
    }

    @GuardedBy("mLock")
    /* renamed from: k */
    private void m17984k() {
        long size = 0;
        int count = 0;
        boolean foundFutureTimestamp = false;
        int numFutureFiles = 0;
        int sizeFutureFiles = 0;
        long maxTimeDelta = -1;
        long now = this.f21842w.mo4020a();
        long timeThreshold = now + f21822e;
        Set<String> tempResourceIndex = new HashSet();
        try {
            for (C5259c entry : this.f21838s.mo3967g()) {
                count++;
                size += entry.mo3951d();
                if (entry.mo3950b() > timeThreshold) {
                    foundFutureTimestamp = true;
                    numFutureFiles++;
                    sizeFutureFiles = (int) (((long) sizeFutureFiles) + entry.mo3951d());
                    maxTimeDelta = Math.max(entry.mo3950b() - now, maxTimeDelta);
                } else {
                    tempResourceIndex.add(entry.mo3949a());
                }
            }
            if (foundFutureTimestamp) {
                this.f21840u.mo3937a(C5243a.READ_INVALID_ENTRY, f21821d, "Future timestamp found in " + numFutureFiles + " files , with a total size of " + sizeFutureFiles + " bytes, and a maximum time delta of " + maxTimeDelta + "ms", null);
            }
            if (this.f21841v.m17951d() != ((long) count) || this.f21841v.m17950c() != size) {
                this.f21828c.clear();
                this.f21828c.addAll(tempResourceIndex);
                this.f21827b = C5283f.m17999a(this.f21834o, this.f21828c);
                this.f21841v.m17946a(size, (long) count);
            }
        } catch (IOException ioe) {
            this.f21840u.mo3937a(C5243a.GENERIC_IO, f21821d, "calcFileCacheSize: " + ioe.getMessage(), ioe);
        }
    }

    /* renamed from: g */
    private static List<String> m17979g(C5247d key) {
        try {
            List<String> ids;
            if (key instanceof C5248f) {
                List<C5247d> keys = ((C5248f) key).m17839a();
                ids = new ArrayList(keys.size());
                for (int i = 0; i < keys.size(); i++) {
                    ids.add(C5282e.m17980h((C5247d) keys.get(i)));
                }
                return ids;
            }
            ids = new ArrayList(1);
            ids.add(C5282e.m17980h(key));
            return ids;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @VisibleForTesting
    /* renamed from: f */
    static String m17978f(C5247d key) {
        try {
            if (key instanceof C5248f) {
                return C5282e.m17980h((C5247d) ((C5248f) key).m17839a().get(0));
            }
            return C5282e.m17980h(key);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: h */
    private static String m17980h(C5247d key) throws UnsupportedEncodingException {
        return C5368d.m18383b(key.toString().getBytes("UTF-8"));
    }

    /* renamed from: a */
    private static SharedPreferences m17965a(Context context, String directoryName) {
        return context.getApplicationContext().getSharedPreferences(f21826i + directoryName, 0);
    }

    @GuardedBy("mLock")
    /* renamed from: a */
    private void m17974a(Integer hashKey, String resourceId) {
        this.f21827b.put(hashKey, resourceId);
        this.f21828c.add(resourceId);
        C5283f.m18002a(hashKey, resourceId, this.f21834o);
    }

    @GuardedBy("mLock")
    /* renamed from: a */
    private void m17973a(Integer hashKey) {
        String resourceId = (String) this.f21827b.remove(hashKey);
        if (resourceId != null) {
            this.f21828c.remove(resourceId);
            C5283f.m18001a(hashKey, this.f21834o);
        }
    }

    @GuardedBy("mLock")
    /* renamed from: a */
    private void m17975a(String resourceId) {
        m17973a(C5282e.m17968a(this.f21827b, resourceId));
    }

    /* renamed from: a */
    private static Integer m17968a(Map<Integer, String> index, String value) {
        for (Entry entry : index.entrySet()) {
            if (entry.getValue().equals(value)) {
                return (Integer) entry.getKey();
            }
        }
        return Integer.valueOf(0);
    }
}
