package com.facebook.imagepipeline.p153l;

import com.baidu.platform.comapi.util.C4820d;
import com.facebook.common.internal.C5342c;
import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C5372f;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.memory.ab;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p153l.C5606t.C5561a;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p269f.C5434b;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: ResizeAndRotateProducer */
/* renamed from: com.facebook.imagepipeline.l.an */
public class an implements ai<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final int f22530a = 85;
    @VisibleForTesting
    /* renamed from: b */
    static final int f22531b = 8;
    @VisibleForTesting
    /* renamed from: c */
    static final int f22532c = 100;
    /* renamed from: d */
    private static final String f22533d = "ResizeAndRotateProducer";
    /* renamed from: e */
    private static final String f22534e = "Original size";
    /* renamed from: f */
    private static final String f22535f = "Requested size";
    /* renamed from: g */
    private static final String f22536g = "Fraction";
    /* renamed from: h */
    private static final float f22537h = 0.6666667f;
    /* renamed from: i */
    private final Executor f22538i;
    /* renamed from: j */
    private final C5642z f22539j;
    /* renamed from: k */
    private final ai<C2952d> f22540k;

    /* compiled from: ResizeAndRotateProducer */
    /* renamed from: com.facebook.imagepipeline.l.an$a */
    private class C5564a extends C5549m<C2952d, C2952d> {
        /* renamed from: a */
        final /* synthetic */ an f22526a;
        /* renamed from: b */
        private final aj f22527b;
        /* renamed from: c */
        private boolean f22528c = false;
        /* renamed from: d */
        private final C5606t f22529d;

        public C5564a(final an anVar, final C5517j<C2952d> consumer, aj producerContext) {
            this.f22526a = anVar;
            super(consumer);
            this.f22527b = producerContext;
            this.f22529d = new C5606t(anVar.f22538i, new C5561a(this) {
                /* renamed from: b */
                final /* synthetic */ C5564a f22522b;

                /* renamed from: a */
                public void mo4134a(C2952d encodedImage, boolean isLast) {
                    this.f22522b.m19231b(encodedImage, isLast);
                }
            }, 100);
            this.f22527b.m19211a(new C5450e(this) {
                /* renamed from: c */
                final /* synthetic */ C5564a f22525c;

                /* renamed from: c */
                public void mo4054c() {
                    if (this.f22525c.f22527b.m19218h()) {
                        this.f22525c.f22529d.m19406b();
                    }
                }

                /* renamed from: a */
                public void mo4052a() {
                    this.f22525c.f22529d.m19404a();
                    this.f22525c.f22528c = true;
                    consumer.mo4085b();
                }
            });
        }

        /* renamed from: a */
        protected void m19232a(@Nullable C2952d newResult, boolean isLast) {
            if (!this.f22528c) {
                if (newResult != null) {
                    C5372f shouldTransform = an.m19242d(this.f22527b.m19210a(), newResult);
                    if (!isLast && shouldTransform == C5372f.UNSET) {
                        return;
                    }
                    if (shouldTransform != C5372f.YES) {
                        m19142d().mo4087b(newResult, isLast);
                    } else if (!this.f22529d.m19405a(newResult, isLast)) {
                    } else {
                        if (isLast || this.f22527b.m19218h()) {
                            this.f22529d.m19406b();
                        }
                    }
                } else if (isLast) {
                    m19142d().mo4087b(null, true);
                }
            }
        }

        /* renamed from: b */
        private void m19231b(C2952d encodedImage, boolean isLast) {
            Throwable th;
            C2952d c2952d;
            Throwable e;
            this.f22527b.m19213c().mo4111a(this.f22527b.m19212b(), an.f22533d);
            C2959c imageRequest = this.f22527b.m19210a();
            ab outputStream = this.f22526a.f22539j.mo4160b();
            Map<String, String> extraMap = null;
            InputStream is = null;
            try {
                int numerator = an.m19243e(imageRequest, encodedImage);
                extraMap = m19227a(encodedImage, imageRequest, numerator);
                is = encodedImage.d();
                JpegTranscoder.m19639a(is, outputStream, an.m19244f(imageRequest, encodedImage), numerator, 85);
                C2921a<C5640y> ref = C2921a.a(outputStream.mo4167c());
                try {
                    C2952d ret = new C2952d(ref);
                    try {
                        ret.a(C5434b.JPEG);
                        ret.k();
                        this.f22527b.m19213c().mo4114a(this.f22527b.m19212b(), an.f22533d, (Map) extraMap);
                        m19142d().mo4087b(ret, isLast);
                        C2952d.d(ret);
                    } catch (Throwable th2) {
                        th = th2;
                        c2952d = ret;
                        C2921a.c(ref);
                        throw th;
                    }
                    try {
                        C2921a.c(ref);
                        C5342c.m18274a(is);
                        outputStream.close();
                        c2952d = ret;
                    } catch (Exception e2) {
                        e = e2;
                        c2952d = ret;
                        try {
                            this.f22527b.m19213c().mo4113a(this.f22527b.m19212b(), an.f22533d, e, extraMap);
                            m19142d().mo4088b(e);
                            C5342c.m18274a(is);
                            outputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            C5342c.m18274a(is);
                            outputStream.close();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c2952d = ret;
                        C5342c.m18274a(is);
                        outputStream.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    C2921a.c(ref);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                this.f22527b.m19213c().mo4113a(this.f22527b.m19212b(), an.f22533d, e, extraMap);
                m19142d().mo4088b(e);
                C5342c.m18274a(is);
                outputStream.close();
            }
        }

        /* renamed from: a */
        private Map<String, String> m19227a(C2952d encodedImage, C2959c imageRequest, int numerator) {
            if (!this.f22527b.m19213c().mo4116b(this.f22527b.m19212b())) {
                return null;
            }
            String requestedSize;
            String originalSize = encodedImage.g() + "x" + encodedImage.h();
            if (imageRequest.e() != null) {
                requestedSize = imageRequest.e().f22340a + "x" + imageRequest.e().f22341b;
            } else {
                requestedSize = "Unspecified";
            }
            return C5346g.m18285a(an.f22534e, originalSize, an.f22535f, requestedSize, an.f22536g, numerator > 0 ? numerator + "/8" : "", "queueTime", String.valueOf(this.f22529d.m19407c()));
        }
    }

    public an(Executor executor, C5642z pooledByteBufferFactory, ai<C2952d> inputProducer) {
        this.f22538i = (Executor) C5350k.m18310a((Object) executor);
        this.f22539j = (C5642z) C5350k.m18310a((Object) pooledByteBufferFactory);
        this.f22540k = (ai) C5350k.m18310a((Object) inputProducer);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj context) {
        this.f22540k.mo4122a(new C5564a(this, consumer, context), context);
    }

    /* renamed from: d */
    private static C5372f m19242d(C2959c request, C2952d encodedImage) {
        if (encodedImage == null || encodedImage.e() == C5434b.UNKNOWN) {
            return C5372f.UNSET;
        }
        if (encodedImage.e() != C5434b.JPEG) {
            return C5372f.NO;
        }
        boolean z = an.m19244f(request, encodedImage) != 0 || an.m19238a(an.m19243e(request, encodedImage));
        return C5372f.m18391a(z);
    }

    @VisibleForTesting
    /* renamed from: a */
    static float m19234a(C5495d resizeOptions, int width, int height) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float ratio = Math.max(((float) resizeOptions.f22340a) / ((float) width), ((float) resizeOptions.f22341b) / ((float) height));
        if (((float) width) * ratio > 2048.0f) {
            ratio = 2048.0f / ((float) width);
        }
        if (((float) height) * ratio > 2048.0f) {
            return 2048.0f / ((float) height);
        }
        return ratio;
    }

    @VisibleForTesting
    /* renamed from: a */
    static int m19235a(float maxRatio) {
        return (int) (f22537h + (8.0f * maxRatio));
    }

    /* renamed from: e */
    private static int m19243e(C2959c imageRequest, C2952d encodedImage) {
        C5495d resizeOptions = imageRequest.e();
        if (resizeOptions == null) {
            return 8;
        }
        int widthAfterRotation;
        int heightAfterRotation;
        int rotationAngle = an.m19244f(imageRequest, encodedImage);
        boolean swapDimensions = rotationAngle == 90 || rotationAngle == 270;
        if (swapDimensions) {
            widthAfterRotation = encodedImage.h();
        } else {
            widthAfterRotation = encodedImage.g();
        }
        if (swapDimensions) {
            heightAfterRotation = encodedImage.g();
        } else {
            heightAfterRotation = encodedImage.h();
        }
        int numerator = an.m19235a(an.m19234a(resizeOptions, widthAfterRotation, heightAfterRotation));
        if (numerator > 8) {
            return 8;
        }
        return numerator < 1 ? 1 : numerator;
    }

    /* renamed from: f */
    private static int m19244f(C2959c imageRequest, C2952d encodedImage) {
        boolean z = false;
        if (!imageRequest.g()) {
            return 0;
        }
        int rotationAngle = encodedImage.f();
        if (rotationAngle == 0 || rotationAngle == 90 || rotationAngle == C4820d.f19955a || rotationAngle == 270) {
            z = true;
        }
        C5350k.m18315a(z);
        return rotationAngle;
    }

    /* renamed from: a */
    private static boolean m19238a(int numerator) {
        return numerator < 8;
    }
}
