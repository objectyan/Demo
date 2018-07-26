package com.facebook.imagepipeline.p153l;

import android.graphics.Bitmap;
import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.memory.C5630f;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5536c;
import com.facebook.imagepipeline.p152i.C5537g;
import com.facebook.imagepipeline.p152i.C5538f;
import com.facebook.imagepipeline.p153l.C5606t.C5561a;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p276e.C5492a;
import com.facebook.imagepipeline.p277h.C5526b;
import com.facebook.imagepipeline.p277h.C5527c;
import com.facebook.imagepipeline.p277h.C5528d;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: DecodeProducer */
/* renamed from: com.facebook.imagepipeline.l.l */
public class C5588l implements ai<C2921a<C5534b>> {
    /* renamed from: a */
    public static final String f22614a = "DecodeProducer";
    /* renamed from: b */
    private static final String f22615b = "bitmapSize";
    /* renamed from: c */
    private static final String f22616c = "hasGoodQuality";
    /* renamed from: d */
    private static final String f22617d = "imageType";
    /* renamed from: e */
    private static final String f22618e = "isFinal";
    /* renamed from: f */
    private final C5630f f22619f;
    /* renamed from: g */
    private final Executor f22620g;
    /* renamed from: h */
    private final C5526b f22621h;
    /* renamed from: i */
    private final C5527c f22622i;
    /* renamed from: j */
    private final ai<C2952d> f22623j;
    /* renamed from: k */
    private final boolean f22624k;
    /* renamed from: l */
    private final boolean f22625l;

    /* compiled from: DecodeProducer */
    /* renamed from: com.facebook.imagepipeline.l.l$c */
    private abstract class C5583c extends C5549m<C2952d, C2921a<C5534b>> {
        /* renamed from: a */
        private final aj f22598a;
        /* renamed from: b */
        final /* synthetic */ C5588l f22599b;
        /* renamed from: c */
        private final al f22600c;
        /* renamed from: d */
        private final C5492a f22601d;
        @GuardedBy("this")
        /* renamed from: e */
        private boolean f22602e = false;
        /* renamed from: f */
        private final C5606t f22603f;

        /* renamed from: a */
        protected abstract int mo4139a(C2952d c2952d);

        /* renamed from: c */
        protected abstract C5537g mo4141c();

        /* renamed from: a */
        public /* synthetic */ void mo4091a(Object obj, boolean z) {
            m19339b((C2952d) obj, z);
        }

        public C5583c(final C5588l c5588l, C5517j<C2921a<C5534b>> consumer, final aj producerContext) {
            this.f22599b = c5588l;
            super(consumer);
            this.f22598a = producerContext;
            this.f22600c = producerContext.m19213c();
            this.f22601d = producerContext.m19210a().f();
            this.f22603f = new C5606t(c5588l.f22620g, new C5561a(this) {
                /* renamed from: c */
                final /* synthetic */ C5583c f22611c;

                /* renamed from: a */
                public void mo4134a(C2952d encodedImage, boolean isLast) {
                    if (encodedImage != null) {
                        if (this.f22611c.f22599b.f22624k) {
                            C2959c request = producerContext.m19210a();
                            if (this.f22611c.f22599b.f22625l || !C2924g.a(request.b())) {
                                encodedImage.d(C5594o.m19375a(request, encodedImage));
                            }
                        }
                        this.f22611c.m19329c(encodedImage, isLast);
                    }
                }
            }, this.f22601d.f22322a);
            this.f22598a.m19211a(new C5450e(this) {
                /* renamed from: b */
                final /* synthetic */ C5583c f22613b;

                /* renamed from: c */
                public void mo4054c() {
                    if (this.f22613b.f22598a.m19218h()) {
                        this.f22613b.f22603f.m19406b();
                    }
                }
            });
        }

        /* renamed from: b */
        public void m19339b(C2952d newResult, boolean isLast) {
            if (isLast && !C2952d.e(newResult)) {
                m19330c(new NullPointerException("Encoded image is not valid."));
            } else if (!mo4140a(newResult, isLast)) {
            } else {
                if (isLast || this.f22598a.m19218h()) {
                    this.f22603f.m19406b();
                }
            }
        }

        /* renamed from: a */
        protected void mo4090a(float progress) {
            super.mo4090a(0.99f * progress);
        }

        /* renamed from: a */
        public void mo4092a(Throwable t) {
            m19330c(t);
        }

        /* renamed from: a */
        public void mo4089a() {
            m19332f();
        }

        /* renamed from: a */
        protected boolean mo4140a(C2952d ref, boolean isLast) {
            return this.f22603f.m19405a(ref, isLast);
        }

        /* renamed from: c */
        private void m19329c(C2952d encodedImage, boolean isLast) {
            long queueTime;
            C5537g quality;
            C5534b image;
            if (!m19331e() && C2952d.e(encodedImage)) {
                try {
                    queueTime = this.f22603f.m19407c();
                    int length = isLast ? encodedImage.j() : mo4139a(encodedImage);
                    quality = isLast ? C5538f.f22457a : mo4141c();
                    this.f22600c.mo4111a(this.f22598a.m19212b(), C5588l.f22614a);
                    image = null;
                    image = this.f22599b.f22621h.m19024a(encodedImage, length, quality, this.f22601d);
                    this.f22600c.mo4114a(this.f22598a.m19212b(), C5588l.f22614a, m19324a(image, queueTime, quality, isLast));
                    m19325a(image, isLast);
                } catch (Exception e) {
                    this.f22600c.mo4113a(this.f22598a.m19212b(), C5588l.f22614a, e, m19324a(image, queueTime, quality, isLast));
                    m19330c(e);
                } finally {
                    C2952d.d(encodedImage);
                }
            }
        }

        /* renamed from: a */
        private Map<String, String> m19324a(@Nullable C5534b image, long queueTime, C5537g quality, boolean isFinal) {
            if (!this.f22600c.mo4116b(this.f22598a.m19212b())) {
                return null;
            }
            String queueStr = String.valueOf(queueTime);
            String qualityStr = String.valueOf(quality.mo4105b());
            String finalStr = String.valueOf(isFinal);
            String cacheChoiceStr = String.valueOf(this.f22598a.m19210a().a());
            if (!(image instanceof C5536c)) {
                return C5346g.m18285a("queueTime", queueStr, C5588l.f22616c, qualityStr, C5588l.f22618e, finalStr, C5588l.f22617d, cacheChoiceStr);
            }
            Bitmap bitmap = ((C5536c) image).mo4098a();
            return C5346g.m18286a(C5588l.f22615b, bitmap.getWidth() + "x" + bitmap.getHeight(), "queueTime", queueStr, C5588l.f22616c, qualityStr, C5588l.f22618e, finalStr, C5588l.f22617d, cacheChoiceStr);
        }

        /* renamed from: e */
        private synchronized boolean m19331e() {
            return this.f22602e;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private void m19327a(boolean r3) {
            /*
            r2 = this;
            monitor-enter(r2);
            if (r3 == 0) goto L_0x0007;
        L_0x0003:
            r0 = r2.f22602e;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0009;
        L_0x0007:
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
        L_0x0008:
            return;
        L_0x0009:
            r0 = r2.m19142d();	 Catch:{ all -> 0x001c }
            r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r0.mo4086b(r1);	 Catch:{ all -> 0x001c }
            r0 = 1;
            r2.f22602e = r0;	 Catch:{ all -> 0x001c }
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            r0 = r2.f22603f;
            r0.m19404a();
            goto L_0x0008;
        L_0x001c:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.l.l.c.a(boolean):void");
        }

        /* renamed from: a */
        private void m19325a(C5534b decodedImage, boolean isFinal) {
            C2921a<C5534b> decodedImageRef = C2921a.a(decodedImage);
            try {
                m19327a(isFinal);
                m19142d().mo4087b(decodedImageRef, isFinal);
            } finally {
                C2921a.c(decodedImageRef);
            }
        }

        /* renamed from: c */
        private void m19330c(Throwable t) {
            m19327a(true);
            m19142d().mo4088b(t);
        }

        /* renamed from: f */
        private void m19332f() {
            m19327a(true);
            m19142d().mo4085b();
        }
    }

    /* compiled from: DecodeProducer */
    /* renamed from: com.facebook.imagepipeline.l.l$a */
    private class C5584a extends C5583c {
        /* renamed from: a */
        final /* synthetic */ C5588l f22604a;

        public C5584a(C5588l c5588l, C5517j<C2921a<C5534b>> consumer, aj producerContext) {
            this.f22604a = c5588l;
            super(c5588l, consumer, producerContext);
        }

        /* renamed from: a */
        protected synchronized boolean mo4140a(C2952d encodedImage, boolean isLast) {
            boolean a;
            if (isLast) {
                a = super.mo4140a(encodedImage, isLast);
            } else {
                a = false;
            }
            return a;
        }

        /* renamed from: a */
        protected int mo4139a(C2952d encodedImage) {
            return encodedImage.j();
        }

        /* renamed from: c */
        protected C5537g mo4141c() {
            return C5538f.m19064a(0, false, false);
        }
    }

    /* compiled from: DecodeProducer */
    /* renamed from: com.facebook.imagepipeline.l.l$b */
    private class C5585b extends C5583c {
        /* renamed from: a */
        final /* synthetic */ C5588l f22605a;
        /* renamed from: c */
        private final C5528d f22606c;
        /* renamed from: d */
        private final C5527c f22607d;
        /* renamed from: e */
        private int f22608e = 0;

        public C5585b(C5588l c5588l, C5517j<C2921a<C5534b>> consumer, aj producerContext, C5528d progressiveJpegParser, C5527c progressiveJpegConfig) {
            this.f22605a = c5588l;
            super(c5588l, consumer, producerContext);
            this.f22606c = (C5528d) C5350k.m18310a((Object) progressiveJpegParser);
            this.f22607d = (C5527c) C5350k.m18310a((Object) progressiveJpegConfig);
        }

        /* renamed from: a */
        protected synchronized boolean mo4140a(C2952d encodedImage, boolean isLast) {
            boolean ret;
            ret = super.mo4140a(encodedImage, isLast);
            if (!isLast && C2952d.e(encodedImage)) {
                if (this.f22606c.m19035a(encodedImage)) {
                    int scanNum = this.f22606c.m19037c();
                    if (scanNum <= this.f22608e || scanNum < this.f22607d.mo4095a(this.f22608e)) {
                        ret = false;
                    } else {
                        this.f22608e = scanNum;
                    }
                } else {
                    ret = false;
                }
            }
            return ret;
        }

        /* renamed from: a */
        protected int mo4139a(C2952d encodedImage) {
            return this.f22606c.m19036b();
        }

        /* renamed from: c */
        protected C5537g mo4141c() {
            return this.f22607d.mo4096b(this.f22606c.m19037c());
        }
    }

    public C5588l(C5630f byteArrayPool, Executor executor, C5526b imageDecoder, C5527c progressiveJpegConfig, boolean downsampleEnabled, boolean downsampleEnabledForNetwork, ai<C2952d> inputProducer) {
        this.f22619f = (C5630f) C5350k.m18310a((Object) byteArrayPool);
        this.f22620g = (Executor) C5350k.m18310a((Object) executor);
        this.f22621h = (C5526b) C5350k.m18310a((Object) imageDecoder);
        this.f22622i = (C5527c) C5350k.m18310a((Object) progressiveJpegConfig);
        this.f22624k = downsampleEnabled;
        this.f22625l = downsampleEnabledForNetwork;
        this.f22623j = (ai) C5350k.m18310a((Object) inputProducer);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5534b>> consumer, aj producerContext) {
        C5583c progressiveDecoder;
        if (C2924g.a(producerContext.m19210a().b())) {
            progressiveDecoder = new C5585b(this, consumer, producerContext, new C5528d(this.f22619f), this.f22622i);
        } else {
            progressiveDecoder = new C5584a(this, consumer, producerContext);
        }
        this.f22623j.mo4122a(progressiveDecoder, producerContext);
    }
}
