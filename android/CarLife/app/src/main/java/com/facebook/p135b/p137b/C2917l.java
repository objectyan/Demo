package com.facebook.p135b.p137b;

import com.facebook.p135b.p136a.C2915b;
import com.facebook.p135b.p136a.C5246c.C5245a;
import com.facebook.p135b.p136a.C5247d;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: SettableCacheEvent */
/* renamed from: com.facebook.b.b.l */
public class C2917l implements C2915b {
    /* renamed from: a */
    private C5247d f12859a;
    /* renamed from: b */
    private String f12860b;
    /* renamed from: c */
    private long f12861c;
    /* renamed from: d */
    private long f12862d;
    /* renamed from: e */
    private long f12863e;
    /* renamed from: f */
    private IOException f12864f;
    /* renamed from: g */
    private C5245a f12865g;

    @Nullable
    /* renamed from: a */
    public C5247d mo2004a() {
        return this.f12859a;
    }

    /* renamed from: a */
    public C2917l m11181a(C5247d cacheKey) {
        this.f12859a = cacheKey;
        return this;
    }

    @Nullable
    /* renamed from: b */
    public String mo2005b() {
        return this.f12860b;
    }

    /* renamed from: a */
    public C2917l m11183a(String resourceId) {
        this.f12860b = resourceId;
        return this;
    }

    /* renamed from: c */
    public long mo2006c() {
        return this.f12861c;
    }

    /* renamed from: a */
    public C2917l m11179a(long itemSize) {
        this.f12861c = itemSize;
        return this;
    }

    /* renamed from: d */
    public long mo2007d() {
        return this.f12863e;
    }

    /* renamed from: b */
    public C2917l m11184b(long cacheSize) {
        this.f12863e = cacheSize;
        return this;
    }

    /* renamed from: e */
    public long mo2008e() {
        return this.f12862d;
    }

    /* renamed from: c */
    public C2917l m11187c(long cacheLimit) {
        this.f12862d = cacheLimit;
        return this;
    }

    @Nullable
    /* renamed from: f */
    public IOException mo2009f() {
        return this.f12864f;
    }

    /* renamed from: a */
    public C2917l m11182a(IOException exception) {
        this.f12864f = exception;
        return this;
    }

    @Nullable
    /* renamed from: g */
    public C5245a mo2010g() {
        return this.f12865g;
    }

    /* renamed from: a */
    public C2917l m11180a(C5245a evictionReason) {
        this.f12865g = evictionReason;
        return this;
    }
}
