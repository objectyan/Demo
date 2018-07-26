package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.C5354o;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: NativePooledByteBufferFactory */
/* renamed from: com.facebook.imagepipeline.memory.o */
public class C5643o implements C5642z {
    /* renamed from: a */
    private final ac f22778a;
    /* renamed from: b */
    private final C5639m f22779b;

    /* renamed from: b */
    public /* synthetic */ ab mo4160b() {
        return m19568a();
    }

    /* renamed from: b */
    public /* synthetic */ C5640y mo4161b(InputStream inputStream) throws IOException {
        return m19564a(inputStream);
    }

    /* renamed from: b */
    public /* synthetic */ C5640y mo4162b(InputStream inputStream, int i) throws IOException {
        return m19565a(inputStream, i);
    }

    /* renamed from: b */
    public /* synthetic */ C5640y mo4163b(byte[] bArr) {
        return m19567a(bArr);
    }

    /* renamed from: c */
    public /* synthetic */ ab mo4164c(int i) {
        return m19570b(i);
    }

    /* renamed from: d */
    public /* synthetic */ C5640y mo4165d(int i) {
        return m19563a(i);
    }

    public C5643o(C5639m pool, ac pooledByteStreams) {
        this.f22779b = pool;
        this.f22778a = pooledByteStreams;
    }

    /* renamed from: a */
    public C5641n m19563a(int size) {
        C5350k.m18315a(size > 0);
        C2921a<NativeMemoryChunk> chunkRef = C2921a.a(this.f22779b.mo4144a(size), this.f22779b);
        try {
            C5641n c5641n = new C5641n(chunkRef, size);
            return c5641n;
        } finally {
            chunkRef.close();
        }
    }

    /* renamed from: a */
    public C5641n m19564a(InputStream inputStream) throws IOException {
        C5645p outputStream = new C5645p(this.f22779b);
        try {
            C5641n a = m19566a(inputStream, outputStream);
            return a;
        } finally {
            outputStream.close();
        }
    }

    /* renamed from: a */
    public C5641n m19567a(byte[] bytes) {
        C5645p outputStream = new C5645p(this.f22779b, bytes.length);
        try {
            outputStream.write(bytes, 0, bytes.length);
            C5641n a = outputStream.m19577a();
            outputStream.close();
            return a;
        } catch (IOException ioe) {
            throw C5354o.m18340b(ioe);
        } catch (Throwable th) {
            outputStream.close();
        }
    }

    /* renamed from: a */
    public C5641n m19565a(InputStream inputStream, int initialCapacity) throws IOException {
        C5645p outputStream = new C5645p(this.f22779b, initialCapacity);
        try {
            C5641n a = m19566a(inputStream, outputStream);
            return a;
        } finally {
            outputStream.close();
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    C5641n m19566a(InputStream inputStream, C5645p outputStream) throws IOException {
        this.f22778a.m19482a(inputStream, outputStream);
        return outputStream.m19577a();
    }

    /* renamed from: a */
    public C5645p m19568a() {
        return new C5645p(this.f22779b);
    }

    /* renamed from: b */
    public C5645p m19570b(int initialCapacity) {
        return new C5645p(this.f22779b, initialCapacity);
    }
}
