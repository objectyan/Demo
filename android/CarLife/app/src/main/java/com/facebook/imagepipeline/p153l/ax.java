package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C5372f;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.memory.ab;
import com.facebook.imagepipeline.nativecode.C5657b;
import com.facebook.imagepipeline.nativecode.C5658c;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.p269f.C5434b;
import com.facebook.p269f.C5435c;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: WebpTranscodeProducer */
/* renamed from: com.facebook.imagepipeline.l.ax */
public class ax implements ai<C2952d> {
    /* renamed from: a */
    private static final String f22579a = "WebpTranscodeProducer";
    /* renamed from: b */
    private static final int f22580b = 80;
    /* renamed from: c */
    private final Executor f22581c;
    /* renamed from: d */
    private final C5642z f22582d;
    /* renamed from: e */
    private final ai<C2952d> f22583e;

    /* compiled from: WebpTranscodeProducer */
    /* renamed from: com.facebook.imagepipeline.l.ax$a */
    private class C5574a extends C5549m<C2952d, C2952d> {
        /* renamed from: a */
        final /* synthetic */ ax f22576a;
        /* renamed from: b */
        private final aj f22577b;
        /* renamed from: c */
        private C5372f f22578c = C5372f.UNSET;

        public C5574a(ax axVar, C5517j<C2952d> consumer, aj context) {
            this.f22576a = axVar;
            super(consumer);
            this.f22577b = context;
        }

        /* renamed from: a */
        protected void m19292a(@Nullable C2952d newResult, boolean isLast) {
            if (this.f22578c == C5372f.UNSET && newResult != null) {
                this.f22578c = ax.m19299b(newResult);
            }
            if (this.f22578c == C5372f.NO) {
                m19142d().mo4087b(newResult, isLast);
            } else if (!isLast) {
            } else {
                if (this.f22578c != C5372f.YES || newResult == null) {
                    m19142d().mo4087b(newResult, isLast);
                } else {
                    this.f22576a.m19296a(newResult, m19142d(), this.f22577b);
                }
            }
        }
    }

    public ax(Executor executor, C5642z pooledByteBufferFactory, ai<C2952d> inputProducer) {
        this.f22581c = (Executor) C5350k.m18310a((Object) executor);
        this.f22582d = (C5642z) C5350k.m18310a((Object) pooledByteBufferFactory);
        this.f22583e = (ai) C5350k.m18310a((Object) inputProducer);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj context) {
        this.f22583e.mo4122a(new C5574a(this, consumer, context), context);
    }

    /* renamed from: a */
    private void m19296a(C2952d originalResult, C5517j<C2952d> consumer, aj producerContext) {
        C5350k.m18310a((Object) originalResult);
        final C2952d encodedImageCopy = C2952d.a(originalResult);
        this.f22581c.execute(new ap<C2952d>(this, consumer, producerContext.m19213c(), f22579a, producerContext.m19212b()) {
            /* renamed from: h */
            final /* synthetic */ ax f22574h;

            /* renamed from: a */
            protected /* synthetic */ void mo4126a(Object obj) {
                m19288b((C2952d) obj);
            }

            /* renamed from: b */
            protected /* synthetic */ void mo4128b(Object obj) {
                m19284a((C2952d) obj);
            }

            /* renamed from: c */
            protected /* synthetic */ Object mo4129c() throws Exception {
                return m19291d();
            }

            /* renamed from: d */
            protected C2952d m19291d() throws Exception {
                C2921a<C5640y> ref;
                ab outputStream = this.f22574h.f22582d.mo4160b();
                try {
                    ax.m19300b(encodedImageCopy, outputStream);
                    ref = C2921a.a(outputStream.mo4167c());
                    C2952d encodedImage = new C2952d(ref);
                    encodedImage.b(encodedImageCopy);
                    C2921a.c(ref);
                    outputStream.close();
                    return encodedImage;
                } catch (Throwable th) {
                    outputStream.close();
                }
            }

            /* renamed from: a */
            protected void m19284a(C2952d result) {
                C2952d.d(result);
            }

            /* renamed from: b */
            protected void m19288b(C2952d result) {
                C2952d.d(encodedImageCopy);
                super.mo4126a((Object) result);
            }

            /* renamed from: a */
            protected void mo4125a(Exception e) {
                C2952d.d(encodedImageCopy);
                super.mo4125a(e);
            }

            /* renamed from: b */
            protected void mo4127b() {
                C2952d.d(encodedImageCopy);
                super.mo4127b();
            }
        });
    }

    /* renamed from: b */
    private static C5372f m19299b(C2952d encodedImage) {
        C5350k.m18310a((Object) encodedImage);
        C5434b imageFormat = C5435c.m18678b(encodedImage.d());
        switch (imageFormat) {
            case WEBP_SIMPLE:
            case WEBP_LOSSLESS:
            case WEBP_EXTENDED:
            case WEBP_EXTENDED_WITH_ALPHA:
                C5657b webpTranscoder = C5658c.m19645a();
                if (webpTranscoder == null) {
                    return C5372f.NO;
                }
                return C5372f.m18391a(!webpTranscoder.m19644a(imageFormat));
            case UNKNOWN:
                return C5372f.UNSET;
            default:
                return C5372f.NO;
        }
    }

    /* renamed from: b */
    private static void m19300b(C2952d encodedImage, ab outputStream) throws Exception {
        InputStream imageInputStream = encodedImage.d();
        switch (C5435c.m18678b(imageInputStream)) {
            case WEBP_SIMPLE:
            case WEBP_EXTENDED:
                C5658c.m19645a().m19643a(imageInputStream, outputStream, 80);
                return;
            case WEBP_LOSSLESS:
            case WEBP_EXTENDED_WITH_ALPHA:
                C5658c.m19645a().m19642a(imageInputStream, outputStream);
                return;
            default:
                throw new IllegalArgumentException("Wrong image format");
        }
    }
}
