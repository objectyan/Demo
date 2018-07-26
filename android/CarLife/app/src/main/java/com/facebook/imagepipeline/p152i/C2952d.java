package com.facebook.imagepipeline.p152i;

import android.util.Pair;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p140h.C5331d;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.aa;
import com.facebook.p148h.C2940a;
import com.facebook.p148h.C5437b;
import com.facebook.p269f.C5434b;
import com.facebook.p269f.C5435c;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: EncodedImage */
/* renamed from: com.facebook.imagepipeline.i.d */
public class C2952d implements Closeable {
    /* renamed from: a */
    public static final int f13127a = -1;
    /* renamed from: b */
    public static final int f13128b = -1;
    /* renamed from: c */
    public static final int f13129c = -1;
    /* renamed from: d */
    public static final int f13130d = -1;
    /* renamed from: e */
    public static final int f13131e = 1;
    @Nullable
    /* renamed from: f */
    private final C2921a<C5640y> f13132f;
    @Nullable
    /* renamed from: g */
    private final C5273m<FileInputStream> f13133g;
    /* renamed from: h */
    private C5434b f13134h;
    /* renamed from: i */
    private int f13135i;
    /* renamed from: j */
    private int f13136j;
    /* renamed from: k */
    private int f13137k;
    /* renamed from: l */
    private int f13138l;
    /* renamed from: m */
    private int f13139m;

    public C2952d(C2921a<C5640y> pooledByteBufferRef) {
        this.f13134h = C5434b.f22195j;
        this.f13135i = -1;
        this.f13136j = -1;
        this.f13137k = -1;
        this.f13138l = 1;
        this.f13139m = -1;
        C5350k.a(C2921a.m11257a((C2921a) pooledByteBufferRef));
        this.f13132f = pooledByteBufferRef.m11261b();
        this.f13133g = null;
    }

    public C2952d(C5273m<FileInputStream> inputStreamSupplier) {
        this.f13134h = C5434b.f22195j;
        this.f13135i = -1;
        this.f13136j = -1;
        this.f13137k = -1;
        this.f13138l = 1;
        this.f13139m = -1;
        C5350k.a(inputStreamSupplier);
        this.f13132f = null;
        this.f13133g = inputStreamSupplier;
    }

    public C2952d(C5273m<FileInputStream> inputStreamSupplier, int streamSize) {
        this((C5273m) inputStreamSupplier);
        this.f13139m = streamSize;
    }

    /* renamed from: a */
    public static C2952d m11779a(C2952d encodedImage) {
        return encodedImage != null ? encodedImage.m11783a() : null;
    }

    /* renamed from: a */
    public C2952d m11783a() {
        C2952d encodedImage;
        if (this.f13133g != null) {
            encodedImage = new C2952d(this.f13133g, this.f13139m);
        } else {
            C2921a pooledByteBufferRef = C2921a.m11258b(this.f13132f);
            if (pooledByteBufferRef == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new C2952d(pooledByteBufferRef);
                } catch (Throwable th) {
                    C2921a.m11259c(pooledByteBufferRef);
                }
            }
            C2921a.m11259c(pooledByteBufferRef);
        }
        if (encodedImage != null) {
            encodedImage.m11787b(this);
        }
        return encodedImage;
    }

    public void close() {
        C2921a.m11259c(this.f13132f);
    }

    /* renamed from: b */
    public synchronized boolean m11788b() {
        boolean z;
        z = C2921a.m11257a(this.f13132f) || this.f13133g != null;
        return z;
    }

    /* renamed from: c */
    public C2921a<C5640y> m11789c() {
        return C2921a.m11258b(this.f13132f);
    }

    /* renamed from: d */
    public InputStream m11791d() {
        if (this.f13133g != null) {
            return (InputStream) this.f13133g.b();
        }
        C2921a<C5640y> pooledByteBufferRef = C2921a.m11258b(this.f13132f);
        if (pooledByteBufferRef == null) {
            return null;
        }
        try {
            InputStream aaVar = new aa((C5640y) pooledByteBufferRef.m11260a());
            return aaVar;
        } finally {
            C2921a.m11259c(pooledByteBufferRef);
        }
    }

    /* renamed from: a */
    public void m11785a(C5434b imageFormat) {
        this.f13134h = imageFormat;
    }

    /* renamed from: a */
    public void m11784a(int height) {
        this.f13137k = height;
    }

    /* renamed from: b */
    public void m11786b(int width) {
        this.f13136j = width;
    }

    /* renamed from: c */
    public void m11790c(int rotationAngle) {
        this.f13135i = rotationAngle;
    }

    /* renamed from: d */
    public void m11792d(int sampleSize) {
        this.f13138l = sampleSize;
    }

    /* renamed from: e */
    public void m11794e(int streamSize) {
        this.f13139m = streamSize;
    }

    /* renamed from: e */
    public C5434b m11793e() {
        return this.f13134h;
    }

    /* renamed from: f */
    public int m11795f() {
        return this.f13135i;
    }

    /* renamed from: g */
    public int m11797g() {
        return this.f13136j;
    }

    /* renamed from: h */
    public int m11798h() {
        return this.f13137k;
    }

    /* renamed from: i */
    public int m11799i() {
        return this.f13138l;
    }

    /* renamed from: f */
    public boolean m11796f(int length) {
        if (this.f13134h != C5434b.f22191f || this.f13133g != null) {
            return true;
        }
        C5350k.a(this.f13132f);
        C5640y buf = (C5640y) this.f13132f.m11260a();
        if (buf.a(length - 2) == (byte) -1 && buf.a(length - 1) == (byte) -39) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public int m11800j() {
        if (this.f13132f == null || this.f13132f.m11260a() == null) {
            return this.f13139m;
        }
        return ((C5640y) this.f13132f.m11260a()).a();
    }

    /* renamed from: k */
    public void m11801k() {
        C5434b imageFormat = C5435c.b(m11791d());
        this.f13134h = imageFormat;
        if (!C5434b.a(imageFormat)) {
            Pair<Integer, Integer> dimensions = C2940a.m11593a(m11791d());
            if (dimensions != null) {
                this.f13136j = ((Integer) dimensions.first).intValue();
                this.f13137k = ((Integer) dimensions.second).intValue();
                if (imageFormat != C5434b.f22191f) {
                    this.f13135i = 0;
                } else if (this.f13135i == -1) {
                    this.f13135i = C5437b.a(C5437b.a(m11791d()));
                }
            }
        }
    }

    /* renamed from: b */
    public void m11787b(C2952d encodedImage) {
        this.f13134h = encodedImage.m11793e();
        this.f13136j = encodedImage.m11797g();
        this.f13137k = encodedImage.m11798h();
        this.f13135i = encodedImage.m11795f();
        this.f13138l = encodedImage.m11799i();
        this.f13139m = encodedImage.m11800j();
    }

    /* renamed from: c */
    public static boolean m11780c(C2952d encodedImage) {
        return encodedImage.f13135i >= 0 && encodedImage.f13136j >= 0 && encodedImage.f13137k >= 0;
    }

    /* renamed from: d */
    public static void m11781d(@Nullable C2952d encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    /* renamed from: e */
    public static boolean m11782e(@Nullable C2952d encodedImage) {
        return encodedImage != null && encodedImage.m11788b();
    }

    @VisibleForTesting
    /* renamed from: l */
    public synchronized C5331d<C5640y> m11802l() {
        return this.f13132f != null ? this.f13132f.m11264e() : null;
    }
}
