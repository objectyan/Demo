package com.facebook.imagepipeline.p153l;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5536c;
import com.facebook.imagepipeline.p152i.C5538f;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p275c.C5461f;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: LocalVideoThumbnailProducer */
/* renamed from: com.facebook.imagepipeline.l.ab */
public class ab implements ai<C2921a<C5534b>> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22490a = "VideoThumbnailProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22491b = "createdThumbnail";
    /* renamed from: c */
    private final Executor f22492c;

    public ab(Executor executor) {
        this.f22492c = executor;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5534b>> consumer, aj producerContext) {
        al listener = producerContext.m19213c();
        String requestId = producerContext.m19212b();
        final C2959c imageRequest = producerContext.m19210a();
        final ap cancellableProducerRunnable = new ap<C2921a<C5534b>>(this, consumer, listener, f22490a, requestId) {
            /* renamed from: h */
            final /* synthetic */ ab f22487h;

            /* renamed from: c */
            protected /* synthetic */ Object mo4129c() throws Exception {
                return m19169d();
            }

            /* renamed from: c */
            protected /* synthetic */ Map mo4130c(Object obj) {
                return m19164a((C2921a) obj);
            }

            /* renamed from: d */
            protected C2921a<C5534b> m19169d() throws Exception {
                Bitmap thumbnailBitmap = ThumbnailUtils.createVideoThumbnail(imageRequest.m().getPath(), ab.m19172b(imageRequest));
                if (thumbnailBitmap == null) {
                    return null;
                }
                return C2921a.a(new C5536c(thumbnailBitmap, C5461f.m18739a(), C5538f.f22457a, 0));
            }

            /* renamed from: a */
            protected Map<String, String> m19164a(C2921a<C5534b> result) {
                return C5346g.m18282a(ab.f22491b, String.valueOf(result != null));
            }

            /* renamed from: b */
            protected void m19165b(C2921a<C5534b> result) {
                C2921a.c(result);
            }
        };
        producerContext.m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ ab f22489b;

            /* renamed from: a */
            public void mo4052a() {
                cancellableProducerRunnable.m18106a();
            }
        });
        this.f22492c.execute(cancellableProducerRunnable);
    }

    /* renamed from: b */
    private static int m19172b(C2959c imageRequest) {
        if (imageRequest.c() > 96 || imageRequest.d() > 96) {
            return 1;
        }
        return 3;
    }
}
