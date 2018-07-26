package com.facebook.common.p260j;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.C5354o;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: StatFsHelper */
/* renamed from: com.facebook.common.j.a */
public class C5356a {
    /* renamed from: a */
    private static C5356a f21930a;
    /* renamed from: b */
    private static final long f21931b = TimeUnit.MINUTES.toMillis(2);
    /* renamed from: c */
    private volatile StatFs f21932c = null;
    /* renamed from: d */
    private volatile File f21933d;
    /* renamed from: e */
    private volatile StatFs f21934e = null;
    /* renamed from: f */
    private volatile File f21935f;
    @GuardedBy("lock")
    /* renamed from: g */
    private long f21936g;
    /* renamed from: h */
    private final Lock f21937h = new ReentrantLock();
    /* renamed from: i */
    private volatile boolean f21938i = false;

    /* compiled from: StatFsHelper */
    /* renamed from: com.facebook.common.j.a$a */
    public enum C5355a {
        INTERNAL,
        EXTERNAL
    }

    /* renamed from: a */
    public static synchronized C5356a m18347a() {
        C5356a c5356a;
        synchronized (C5356a.class) {
            if (f21930a == null) {
                f21930a = new C5356a();
            }
            c5356a = f21930a;
        }
        return c5356a;
    }

    protected C5356a() {
    }

    /* renamed from: c */
    private void m18348c() {
        if (!this.f21938i) {
            this.f21937h.lock();
            try {
                if (!this.f21938i) {
                    this.f21933d = Environment.getDataDirectory();
                    this.f21935f = Environment.getExternalStorageDirectory();
                    m18350e();
                    this.f21938i = true;
                }
                this.f21937h.unlock();
            } catch (Throwable th) {
                this.f21937h.unlock();
            }
        }
    }

    /* renamed from: a */
    public boolean m18352a(C5355a storageType, long freeSpaceThreshold) {
        m18348c();
        long availableStorageSpace = m18351a(storageType);
        if (availableStorageSpace <= 0 || availableStorageSpace < freeSpaceThreshold) {
            return true;
        }
        return false;
    }

    @SuppressLint({"DeprecatedMethod"})
    /* renamed from: a */
    public long m18351a(C5355a storageType) {
        m18348c();
        m18349d();
        StatFs statFS = storageType == C5355a.INTERNAL ? this.f21932c : this.f21934e;
        if (statFS == null) {
            return 0;
        }
        long blockSize;
        long availableBlocks;
        if (VERSION.SDK_INT >= 18) {
            blockSize = statFS.getBlockSizeLong();
            availableBlocks = statFS.getAvailableBlocksLong();
        } else {
            blockSize = (long) statFS.getBlockSize();
            availableBlocks = (long) statFS.getAvailableBlocks();
        }
        return blockSize * availableBlocks;
    }

    /* renamed from: d */
    private void m18349d() {
        if (this.f21937h.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f21936g > f21931b) {
                    m18350e();
                }
                this.f21937h.unlock();
            } catch (Throwable th) {
                this.f21937h.unlock();
            }
        }
    }

    /* renamed from: b */
    public void m18353b() {
        if (this.f21937h.tryLock()) {
            try {
                m18348c();
                m18350e();
            } finally {
                this.f21937h.unlock();
            }
        }
    }

    @GuardedBy("lock")
    /* renamed from: e */
    private void m18350e() {
        this.f21932c = m18345a(this.f21932c, this.f21933d);
        this.f21934e = m18345a(this.f21934e, this.f21935f);
        this.f21936g = SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    private StatFs m18345a(@Nullable StatFs statfs, @Nullable File dir) {
        if (dir == null || !dir.exists()) {
            return null;
        }
        if (statfs == null) {
            try {
                statfs = C5356a.m18346a(dir.getAbsolutePath());
            } catch (IllegalArgumentException e) {
                statfs = null;
            } catch (Throwable ex) {
                RuntimeException b = C5354o.m18340b(ex);
            }
        } else {
            statfs.restat(dir.getAbsolutePath());
        }
        return statfs;
    }

    /* renamed from: a */
    protected static StatFs m18346a(String path) {
        return new StatFs(path);
    }
}
