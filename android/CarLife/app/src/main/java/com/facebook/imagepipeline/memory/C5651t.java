package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p258g.C5325c;
import com.facebook.common.p258g.C5328f;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: PoolConfig */
/* renamed from: com.facebook.imagepipeline.memory.t */
public class C5651t {
    /* renamed from: a */
    private final C5653v f22800a;
    /* renamed from: b */
    private final C5646w f22801b;
    /* renamed from: c */
    private final C5653v f22802c;
    /* renamed from: d */
    private final C5325c f22803d;
    /* renamed from: e */
    private final C5653v f22804e;
    /* renamed from: f */
    private final C5646w f22805f;
    /* renamed from: g */
    private final C5653v f22806g;
    /* renamed from: h */
    private final C5646w f22807h;

    /* compiled from: PoolConfig */
    /* renamed from: com.facebook.imagepipeline.memory.t$a */
    public static class C5650a {
        /* renamed from: a */
        private C5653v f22792a;
        /* renamed from: b */
        private C5646w f22793b;
        /* renamed from: c */
        private C5653v f22794c;
        /* renamed from: d */
        private C5325c f22795d;
        /* renamed from: e */
        private C5653v f22796e;
        /* renamed from: f */
        private C5646w f22797f;
        /* renamed from: g */
        private C5653v f22798g;
        /* renamed from: h */
        private C5646w f22799h;

        private C5650a() {
        }

        /* renamed from: a */
        public C5650a m19607a(C5653v bitmapPoolParams) {
            this.f22792a = (C5653v) C5350k.m18310a((Object) bitmapPoolParams);
            return this;
        }

        /* renamed from: a */
        public C5650a m19608a(C5646w bitmapPoolStatsTracker) {
            this.f22793b = (C5646w) C5350k.m18310a((Object) bitmapPoolStatsTracker);
            return this;
        }

        /* renamed from: b */
        public C5650a m19610b(C5653v flexByteArrayPoolParams) {
            this.f22794c = flexByteArrayPoolParams;
            return this;
        }

        /* renamed from: a */
        public C5650a m19606a(C5325c memoryTrimmableRegistry) {
            this.f22795d = memoryTrimmableRegistry;
            return this;
        }

        /* renamed from: c */
        public C5650a m19612c(C5653v nativeMemoryChunkPoolParams) {
            this.f22796e = (C5653v) C5350k.m18310a((Object) nativeMemoryChunkPoolParams);
            return this;
        }

        /* renamed from: b */
        public C5650a m19611b(C5646w nativeMemoryChunkPoolStatsTracker) {
            this.f22797f = (C5646w) C5350k.m18310a((Object) nativeMemoryChunkPoolStatsTracker);
            return this;
        }

        /* renamed from: d */
        public C5650a m19614d(C5653v commonByteArrayPoolParams) {
            this.f22798g = (C5653v) C5350k.m18310a((Object) commonByteArrayPoolParams);
            return this;
        }

        /* renamed from: c */
        public C5650a m19613c(C5646w smallByteArrayPoolStatsTracker) {
            this.f22799h = (C5646w) C5350k.m18310a((Object) smallByteArrayPoolStatsTracker);
            return this;
        }

        /* renamed from: a */
        public C5651t m19609a() {
            return new C5651t();
        }
    }

    private C5651t(C5650a builder) {
        C5653v a;
        C5646w a2;
        C5325c a3;
        if (builder.f22792a == null) {
            a = C5631g.m19511a();
        } else {
            a = builder.f22792a;
        }
        this.f22800a = a;
        if (builder.f22793b == null) {
            a2 = C5647q.m19588a();
        } else {
            a2 = builder.f22793b;
        }
        this.f22801b = a2;
        if (builder.f22794c == null) {
            a = C5633i.m19515a();
        } else {
            a = builder.f22794c;
        }
        this.f22802c = a;
        if (builder.f22795d == null) {
            a3 = C5328f.m18243a();
        } else {
            a3 = builder.f22795d;
        }
        this.f22803d = a3;
        if (builder.f22796e == null) {
            a = C5634j.m19516a();
        } else {
            a = builder.f22796e;
        }
        this.f22804e = a;
        if (builder.f22797f == null) {
            a2 = C5647q.m19588a();
        } else {
            a2 = builder.f22797f;
        }
        this.f22805f = a2;
        if (builder.f22798g == null) {
            a = C5632h.m19513a();
        } else {
            a = builder.f22798g;
        }
        this.f22806g = a;
        if (builder.f22799h == null) {
            a2 = C5647q.m19588a();
        } else {
            a2 = builder.f22799h;
        }
        this.f22807h = a2;
    }

    /* renamed from: a */
    public C5653v m19616a() {
        return this.f22800a;
    }

    /* renamed from: b */
    public C5646w m19617b() {
        return this.f22801b;
    }

    /* renamed from: c */
    public C5325c m19618c() {
        return this.f22803d;
    }

    /* renamed from: d */
    public C5653v m19619d() {
        return this.f22804e;
    }

    /* renamed from: e */
    public C5646w m19620e() {
        return this.f22805f;
    }

    /* renamed from: f */
    public C5653v m19621f() {
        return this.f22802c;
    }

    /* renamed from: g */
    public C5653v m19622g() {
        return this.f22806g;
    }

    /* renamed from: h */
    public C5646w m19623h() {
        return this.f22807h;
    }

    /* renamed from: i */
    public static C5650a m19615i() {
        return new C5650a();
    }
}
