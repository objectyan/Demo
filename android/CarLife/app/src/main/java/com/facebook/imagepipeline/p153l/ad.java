package com.facebook.imagepipeline.p153l;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5630f;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.memory.ab;
import com.facebook.imagepipeline.p152i.C2952d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: NetworkFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.ad */
public class ad implements ai<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f13147a = "NetworkFetchProducer";
    /* renamed from: b */
    public static final String f13148b = "intermediate_result";
    @VisibleForTesting
    /* renamed from: c */
    static final long f13149c = 100;
    /* renamed from: d */
    private static final int f13150d = 16384;
    /* renamed from: e */
    private final C5642z f13151e;
    /* renamed from: f */
    private final C5630f f13152f;
    /* renamed from: g */
    private final ae f13153g;

    public ad(C5642z pooledByteBufferFactory, C5630f byteArrayPool, ae networkFetcher) {
        this.f13151e = pooledByteBufferFactory;
        this.f13152f = byteArrayPool;
        this.f13153g = networkFetcher;
    }

    /* renamed from: a */
    public void m11835a(C5517j<C2952d> consumer, aj context) {
        context.c().a(context.b(), f13147a);
        C5453r fetchState = this.f13153g.m11839b((C5517j) consumer, context);
        this.f13153g.m11837a(fetchState, new ad$1(this, fetchState));
    }

    /* renamed from: a */
    private void m11829a(C5453r fetchState, InputStream responseData, int responseContentLength) throws IOException {
        ab pooledOutputStream;
        if (responseContentLength > 0) {
            pooledOutputStream = this.f13151e.c(responseContentLength);
        } else {
            pooledOutputStream = this.f13151e.b();
        }
        byte[] ioArray = (byte[]) this.f13152f.a(16384);
        while (true) {
            try {
                int length = responseData.read(ioArray);
                if (length < 0) {
                    break;
                } else if (length > 0) {
                    pooledOutputStream.write(ioArray, 0, length);
                    m11831a(pooledOutputStream, fetchState);
                    fetchState.a().b(ad.m11823a(pooledOutputStream.b(), responseContentLength));
                }
            } finally {
                this.f13152f.a(ioArray);
                pooledOutputStream.close();
            }
        }
        this.f13153g.mo2049b(fetchState, pooledOutputStream.b());
        m11833b(pooledOutputStream, fetchState);
    }

    /* renamed from: a */
    private static float m11823a(int downloaded, int total) {
        return total > 0 ? ((float) downloaded) / ((float) total) : 1.0f - ((float) Math.exp(((double) (-downloaded)) / 50000.0d));
    }

    /* renamed from: a */
    private void m11831a(ab pooledOutputStream, C5453r fetchState) {
        long nowMs = SystemClock.uptimeMillis();
        if (m11834b(fetchState) && nowMs - fetchState.f() >= 100) {
            fetchState.a(nowMs);
            fetchState.d().a(fetchState.c(), f13147a, f13148b);
            m11832a(pooledOutputStream, false, fetchState.a());
        }
    }

    /* renamed from: b */
    private void m11833b(ab pooledOutputStream, C5453r fetchState) {
        fetchState.d().a(fetchState.c(), f13147a, m11824a(fetchState, pooledOutputStream.b()));
        m11832a(pooledOutputStream, true, fetchState.a());
    }

    /* renamed from: a */
    private void m11832a(ab pooledOutputStream, boolean isFinal, C5517j<C2952d> consumer) {
        Throwable th;
        C2921a result = C2921a.m11253a(pooledOutputStream.c());
        C2952d encodedImage = null;
        try {
            C2952d encodedImage2 = new C2952d(result);
            try {
                encodedImage2.m11801k();
                consumer.b(encodedImage2, isFinal);
                C2952d.m11781d(encodedImage2);
                C2921a.m11259c(result);
            } catch (Throwable th2) {
                th = th2;
                encodedImage = encodedImage2;
                C2952d.m11781d(encodedImage);
                C2921a.m11259c(result);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C2952d.m11781d(encodedImage);
            C2921a.m11259c(result);
            throw th;
        }
    }

    /* renamed from: a */
    private void m11830a(C5453r fetchState, Throwable e) {
        fetchState.d().a(fetchState.c(), f13147a, e, null);
        fetchState.a().b(e);
    }

    /* renamed from: a */
    private void m11828a(C5453r fetchState) {
        fetchState.d().b(fetchState.c(), f13147a, null);
        fetchState.a().b();
    }

    /* renamed from: b */
    private boolean m11834b(C5453r fetchState) {
        if (fetchState.b().a().m11925h()) {
            return this.f13153g.mo2048a(fetchState);
        }
        return false;
    }

    @Nullable
    /* renamed from: a */
    private Map<String, String> m11824a(C5453r fetchState, int byteSize) {
        if (fetchState.d().b(fetchState.c())) {
            return this.f13153g.mo2047a(fetchState, byteSize);
        }
        return null;
    }
}
