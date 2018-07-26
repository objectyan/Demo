package com.facebook.imagepipeline.p277h;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.C5342c;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5536c;
import com.facebook.imagepipeline.p152i.C5537g;
import com.facebook.imagepipeline.p152i.C5538f;
import com.facebook.imagepipeline.p271a.p272a.C5445d;
import com.facebook.imagepipeline.p276e.C5492a;
import com.facebook.imagepipeline.p279k.C5543e;
import com.facebook.p269f.C5432a;
import com.facebook.p269f.C5434b;
import com.facebook.p269f.C5435c;
import java.io.InputStream;

/* compiled from: ImageDecoder */
/* renamed from: com.facebook.imagepipeline.h.b */
public class C5526b {
    /* renamed from: a */
    private final C5445d f22433a;
    /* renamed from: b */
    private final Config f22434b;
    /* renamed from: c */
    private final C5543e f22435c;

    public C5526b(C5445d animatedImageFactory, C5543e platformDecoder, Config bitmapConfig) {
        this.f22433a = animatedImageFactory;
        this.f22434b = bitmapConfig;
        this.f22435c = platformDecoder;
    }

    /* renamed from: a */
    public C5534b m19024a(C2952d encodedImage, int length, C5537g qualityInfo, C5492a options) {
        C5434b imageFormat = encodedImage.e();
        if (imageFormat == null || imageFormat == C5434b.UNKNOWN) {
            imageFormat = C5435c.m18678b(encodedImage.d());
        }
        switch (imageFormat) {
            case UNKNOWN:
                throw new IllegalArgumentException("unknown image format");
            case JPEG:
                return m19027a(encodedImage, length, qualityInfo);
            case GIF:
                return m19025a(encodedImage, options);
            case WEBP_ANIMATED:
                return m19028b(encodedImage, options);
            default:
                return m19026a(encodedImage);
        }
    }

    /* renamed from: a */
    public C5534b m19025a(C2952d encodedImage, C5492a options) {
        InputStream is = encodedImage.d();
        if (is == null) {
            return null;
        }
        try {
            C5534b a;
            if (options.f22328g || this.f22433a == null || !C5432a.m18669a(is)) {
                a = m19026a(encodedImage);
                C5342c.m18274a(is);
                return a;
            }
            a = this.f22433a.m18701a(encodedImage, options, this.f22434b);
            return a;
        } finally {
            C5342c.m18274a(is);
        }
    }

    /* renamed from: a */
    public C5536c m19026a(C2952d encodedImage) {
        C2921a<Bitmap> bitmapReference = this.f22435c.mo4117a(encodedImage, this.f22434b);
        try {
            C5536c c5536c = new C5536c(bitmapReference, C5538f.f22457a, encodedImage.f());
            return c5536c;
        } finally {
            bitmapReference.close();
        }
    }

    /* renamed from: a */
    public C5536c m19027a(C2952d encodedImage, int length, C5537g qualityInfo) {
        C2921a<Bitmap> bitmapReference = this.f22435c.mo4118a(encodedImage, this.f22434b, length);
        try {
            C5536c c5536c = new C5536c(bitmapReference, qualityInfo, encodedImage.f());
            return c5536c;
        } finally {
            bitmapReference.close();
        }
    }

    /* renamed from: b */
    public C5534b m19028b(C2952d encodedImage, C5492a options) {
        return this.f22433a.m18702b(encodedImage, options, this.f22434b);
    }
}
