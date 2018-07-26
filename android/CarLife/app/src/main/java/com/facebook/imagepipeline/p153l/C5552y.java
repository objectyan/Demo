package com.facebook.imagepipeline.p153l;

import android.os.Build.VERSION;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5342c;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: LocalFetchProducer */
/* renamed from: com.facebook.imagepipeline.l.y */
public abstract class C5552y implements ai<C2952d> {
    /* renamed from: a */
    private final Executor f22477a;
    /* renamed from: b */
    private final C5642z f22478b;
    /* renamed from: c */
    private final boolean f22479c;

    /* renamed from: a */
    protected abstract C2952d mo4123a(C2959c c2959c) throws IOException;

    /* renamed from: a */
    protected abstract String mo4124a();

    protected C5552y(Executor executor, C5642z pooledByteBufferFactory, boolean fileDescriptorEnabled) {
        this.f22477a = executor;
        this.f22478b = pooledByteBufferFactory;
        boolean z = fileDescriptorEnabled && VERSION.SDK_INT == 19;
        this.f22479c = z;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj producerContext) {
        al listener = producerContext.m19213c();
        String requestId = producerContext.m19212b();
        final C2959c imageRequest = producerContext.m19210a();
        final ap cancellableProducerRunnable = new ap<C2952d>(this, consumer, listener, mo4124a(), requestId) {
            /* renamed from: h */
            final /* synthetic */ C5552y f22705h;

            /* renamed from: b */
            protected /* synthetic */ void mo4128b(Object obj) {
                m19427a((C2952d) obj);
            }

            /* renamed from: c */
            protected /* synthetic */ Object mo4129c() throws Exception {
                return m19430d();
            }

            /* renamed from: d */
            protected C2952d m19430d() throws Exception {
                C2952d encodedImage = this.f22705h.mo4123a(imageRequest);
                if (encodedImage == null) {
                    return null;
                }
                encodedImage.k();
                return encodedImage;
            }

            /* renamed from: a */
            protected void m19427a(C2952d result) {
                C2952d.d(result);
            }
        };
        producerContext.m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ C5552y f22707b;

            /* renamed from: a */
            public void mo4052a() {
                cancellableProducerRunnable.m18106a();
            }
        });
        this.f22477a.execute(cancellableProducerRunnable);
    }

    /* renamed from: a */
    protected C2952d m19149a(InputStream inputStream, int length) throws IOException {
        C2921a<C5640y> ref = null;
        if (length <= 0) {
            try {
                ref = C2921a.a(this.f22478b.mo4161b(inputStream));
            } catch (Throwable th) {
                C5342c.m18274a(inputStream);
                C2921a.c(ref);
            }
        } else {
            ref = C2921a.a(this.f22478b.mo4162b(inputStream, length));
        }
        C2952d c2952d = new C2952d(ref);
        C5342c.m18274a(inputStream);
        C2921a.c(ref);
        return c2952d;
    }

    /* renamed from: b */
    protected C2952d m19152b(InputStream inputStream, int length) throws IOException {
        Runtime runTime = Runtime.getRuntime();
        long javaMax = runTime.maxMemory();
        long javaFree = Math.min(javaMax - (runTime.totalMemory() - runTime.freeMemory()), 8388608);
        if (this.f22479c && (inputStream instanceof FileInputStream) && javaMax >= 64 * javaFree) {
            return m19148a(new File(inputStream.toString()), length);
        }
        return m19149a(inputStream, length);
    }

    /* renamed from: a */
    protected C2952d m19148a(final File file, int length) throws IOException {
        return new C2952d(new C5273m<FileInputStream>(this) {
            /* renamed from: b */
            final /* synthetic */ C5552y f22709b;

            /* renamed from: b */
            public /* synthetic */ Object mo3969b() {
                return m19432a();
            }

            /* renamed from: a */
            public FileInputStream m19432a() {
                try {
                    return new FileInputStream(file);
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }, length);
    }
}
