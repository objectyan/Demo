package com.facebook.imagepipeline.p153l;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.memory.aa;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p148h.C2940a;
import com.facebook.p148h.C5437b;
import com.facebook.p269f.C5434b;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: LocalExifThumbnailProducer */
/* renamed from: com.facebook.imagepipeline.l.x */
public class C5610x implements av<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22698a = "LocalExifThumbnailProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22699b = "createdThumbnail";
    /* renamed from: c */
    private static final int f22700c = 512;
    /* renamed from: d */
    private final Executor f22701d;
    /* renamed from: e */
    private final C5642z f22702e;
    /* renamed from: f */
    private final ContentResolver f22703f;

    public C5610x(Executor executor, C5642z pooledByteBufferFactory, ContentResolver contentResolver) {
        this.f22701d = executor;
        this.f22702e = pooledByteBufferFactory;
        this.f22703f = contentResolver;
    }

    /* renamed from: a */
    public boolean mo4142a(C5495d resizeOptions) {
        return aw.m19282a(512, 512, resizeOptions);
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj producerContext) {
        al listener = producerContext.m19213c();
        String requestId = producerContext.m19212b();
        final C2959c imageRequest = producerContext.m19210a();
        final ap cancellableProducerRunnable = new ap<C2952d>(this, consumer, listener, f22698a, requestId) {
            /* renamed from: h */
            final /* synthetic */ C5610x f22695h;

            /* renamed from: b */
            protected /* synthetic */ void mo4128b(Object obj) {
                m19412a((C2952d) obj);
            }

            /* renamed from: c */
            protected /* synthetic */ Object mo4129c() throws Exception {
                return m19417d();
            }

            /* renamed from: c */
            protected /* synthetic */ Map mo4130c(Object obj) {
                return m19413b((C2952d) obj);
            }

            /* renamed from: d */
            protected C2952d m19417d() throws Exception {
                ExifInterface exifInterface = this.f22695h.m19423a(imageRequest.b());
                if (exifInterface == null || !exifInterface.hasThumbnail()) {
                    return null;
                }
                return this.f22695h.m19421a(this.f22695h.f22702e.mo4163b(exifInterface.getThumbnail()), exifInterface);
            }

            /* renamed from: a */
            protected void m19412a(C2952d result) {
                C2952d.d(result);
            }

            /* renamed from: b */
            protected Map<String, String> m19413b(C2952d result) {
                return C5346g.m18282a(C5610x.f22699b, Boolean.toString(result != null));
            }
        };
        producerContext.m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ C5610x f22697b;

            /* renamed from: a */
            public void mo4052a() {
                cancellableProducerRunnable.m18106a();
            }
        });
        this.f22701d.execute(cancellableProducerRunnable);
    }

    @VisibleForTesting
    /* renamed from: a */
    ExifInterface m19423a(Uri uri) throws IOException {
        String realPath = C2924g.a(this.f22703f, uri);
        if (m19426a(realPath)) {
            return new ExifInterface(realPath);
        }
        return null;
    }

    /* renamed from: a */
    private C2952d m19421a(C5640y imageBytes, ExifInterface exifInterface) {
        int width;
        int height = -1;
        Pair<Integer, Integer> dimensions = C2940a.a(new aa(imageBytes));
        int rotationAngle = m19419a(exifInterface);
        if (dimensions != null) {
            width = ((Integer) dimensions.first).intValue();
        } else {
            width = -1;
        }
        if (dimensions != null) {
            height = ((Integer) dimensions.second).intValue();
        }
        C2921a<C5640y> closeableByteBuffer = C2921a.a(imageBytes);
        try {
            C2952d encodedImage = new C2952d(closeableByteBuffer);
            encodedImage.a(C5434b.JPEG);
            encodedImage.c(rotationAngle);
            encodedImage.b(width);
            encodedImage.a(height);
            return encodedImage;
        } finally {
            C2921a.c(closeableByteBuffer);
        }
    }

    /* renamed from: a */
    private int m19419a(ExifInterface exifInterface) {
        return C5437b.m18685a(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    @VisibleForTesting
    /* renamed from: a */
    boolean m19426a(String realPath) throws IOException {
        if (realPath == null) {
            return false;
        }
        File file = new File(realPath);
        if (file.exists() && file.canRead()) {
            return true;
        }
        return false;
    }
}
