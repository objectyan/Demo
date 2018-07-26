package com.facebook.p135b.p137b;

import android.content.Context;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5353n;
import com.facebook.common.p254b.C5301b;
import com.facebook.p135b.p136a.C5244a;
import com.facebook.p135b.p136a.C5246c;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: DiskCacheConfig */
/* renamed from: com.facebook.b.b.c$a */
public class c$a {
    /* renamed from: a */
    private int f12846a;
    /* renamed from: b */
    private String f12847b;
    /* renamed from: c */
    private C5273m<File> f12848c;
    /* renamed from: d */
    private long f12849d;
    /* renamed from: e */
    private long f12850e;
    /* renamed from: f */
    private long f12851f;
    /* renamed from: g */
    private C5270i f12852g;
    /* renamed from: h */
    private C5244a f12853h;
    /* renamed from: i */
    private C5246c f12854i;
    /* renamed from: j */
    private C5301b f12855j;
    @Nullable
    /* renamed from: k */
    private final Context f12856k;

    private c$a(@Nullable Context context) {
        this.f12846a = 1;
        this.f12847b = "image_cache";
        this.f12849d = 41943040;
        this.f12850e = 10485760;
        this.f12851f = 2097152;
        this.f12852g = new C5271b();
        this.f12856k = context;
    }

    /* renamed from: a */
    public c$a m11166a(int version) {
        this.f12846a = version;
        return this;
    }

    /* renamed from: a */
    public c$a m11174a(String baseDirectoryName) {
        this.f12847b = baseDirectoryName;
        return this;
    }

    /* renamed from: a */
    public c$a m11173a(File baseDirectoryPath) {
        this.f12848c = C5353n.a(baseDirectoryPath);
        return this;
    }

    /* renamed from: a */
    public c$a m11172a(C5273m<File> baseDirectoryPathSupplier) {
        this.f12848c = baseDirectoryPathSupplier;
        return this;
    }

    /* renamed from: a */
    public c$a m11167a(long maxCacheSize) {
        this.f12849d = maxCacheSize;
        return this;
    }

    /* renamed from: b */
    public c$a m11176b(long maxCacheSizeOnLowDiskSpace) {
        this.f12850e = maxCacheSizeOnLowDiskSpace;
        return this;
    }

    /* renamed from: c */
    public c$a m11177c(long maxCacheSizeOnVeryLowDiskSpace) {
        this.f12851f = maxCacheSizeOnVeryLowDiskSpace;
        return this;
    }

    /* renamed from: a */
    public c$a m11170a(C5270i supplier) {
        this.f12852g = supplier;
        return this;
    }

    /* renamed from: a */
    public c$a m11168a(C5244a cacheErrorLogger) {
        this.f12853h = cacheErrorLogger;
        return this;
    }

    /* renamed from: a */
    public c$a m11169a(C5246c cacheEventListener) {
        this.f12854i = cacheEventListener;
        return this;
    }

    /* renamed from: a */
    public c$a m11171a(C5301b diskTrimmableRegistry) {
        this.f12855j = diskTrimmableRegistry;
        return this;
    }

    /* renamed from: a */
    public C5274c m11175a() {
        boolean z = (this.f12848c == null && this.f12856k == null) ? false : true;
        C5350k.b(z, "Either a non-null context or a base directory path or supplier must be provided.");
        if (this.f12848c == null && this.f12856k != null) {
            this.f12848c = new c$a$1(this);
        }
        return new C5274c(this, null);
    }
}
