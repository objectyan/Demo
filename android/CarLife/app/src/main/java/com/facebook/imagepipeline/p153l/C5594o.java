package com.facebook.imagepipeline.p153l;

import com.baidu.platform.comapi.util.C4820d;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p257e.C5320a;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p276e.C5495d;
import com.facebook.p269f.C5434b;

/* compiled from: DownsampleUtil */
/* renamed from: com.facebook.imagepipeline.l.o */
public class C5594o {
    /* renamed from: a */
    private static final float f22650a = 2048.0f;
    /* renamed from: b */
    private static final float f22651b = 0.33333334f;
    /* renamed from: c */
    private static final int f22652c = 1;

    private C5594o() {
    }

    /* renamed from: a */
    public static int m19375a(C2959c imageRequest, C2952d encodedImage) {
        if (!C2952d.c(encodedImage)) {
            return 1;
        }
        int sampleSize;
        float ratio = C5594o.m19376b(imageRequest, encodedImage);
        if (encodedImage.e() == C5434b.JPEG) {
            sampleSize = C5594o.m19377b(ratio);
        } else {
            sampleSize = C5594o.m19373a(ratio);
        }
        int maxDimension = Math.max(encodedImage.h(), encodedImage.g());
        while (((float) (maxDimension / sampleSize)) > 2048.0f) {
            if (encodedImage.e() == C5434b.JPEG) {
                sampleSize *= 2;
            } else {
                sampleSize++;
            }
        }
        return sampleSize;
    }

    @VisibleForTesting
    /* renamed from: b */
    static float m19376b(C2959c imageRequest, C2952d encodedImage) {
        C5350k.m18315a(C2952d.c(encodedImage));
        C5495d resizeOptions = imageRequest.e();
        if (resizeOptions == null || resizeOptions.f22341b <= 0 || resizeOptions.f22340a <= 0 || encodedImage.g() == 0 || encodedImage.h() == 0) {
            return 1.0f;
        }
        boolean swapDimensions;
        int rotationAngle = C5594o.m19378c(imageRequest, encodedImage);
        if (rotationAngle == 90 || rotationAngle == 270) {
            swapDimensions = true;
        } else {
            swapDimensions = false;
        }
        C5320a.m18136a("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(resizeOptions.f22340a), Integer.valueOf(resizeOptions.f22341b), Integer.valueOf(swapDimensions ? encodedImage.h() : encodedImage.g()), Integer.valueOf(swapDimensions ? encodedImage.g() : encodedImage.h()), Float.valueOf(((float) resizeOptions.f22340a) / ((float) (swapDimensions ? encodedImage.h() : encodedImage.g()))), Float.valueOf(((float) resizeOptions.f22341b) / ((float) (swapDimensions ? encodedImage.g() : encodedImage.h()))), Float.valueOf(Math.max(((float) resizeOptions.f22340a) / ((float) (swapDimensions ? encodedImage.h() : encodedImage.g())), ((float) resizeOptions.f22341b) / ((float) (swapDimensions ? encodedImage.g() : encodedImage.h())))), imageRequest.b().toString());
        return Math.max(((float) resizeOptions.f22340a) / ((float) (swapDimensions ? encodedImage.h() : encodedImage.g())), ((float) resizeOptions.f22341b) / ((float) (swapDimensions ? encodedImage.g() : encodedImage.h())));
    }

    @VisibleForTesting
    /* renamed from: a */
    static int m19373a(float ratio) {
        if (ratio > 0.6666667f) {
            return 1;
        }
        int sampleSize = 2;
        while (true) {
            if ((1.0d / ((double) sampleSize)) + (0.3333333432674408d * (1.0d / (Math.pow((double) sampleSize, 2.0d) - ((double) sampleSize)))) <= ((double) ratio)) {
                return sampleSize - 1;
            }
            sampleSize++;
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    static int m19377b(float ratio) {
        if (ratio > 0.6666667f) {
            return 1;
        }
        int sampleSize = 2;
        while (true) {
            if ((1.0d / ((double) (sampleSize * 2))) + (0.3333333432674408d * (1.0d / ((double) (sampleSize * 2)))) <= ((double) ratio)) {
                return sampleSize;
            }
            sampleSize *= 2;
        }
    }

    /* renamed from: c */
    private static int m19378c(C2959c imageRequest, C2952d encodedImage) {
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

    @VisibleForTesting
    /* renamed from: a */
    static int m19374a(int sampleSize) {
        int compare = 1;
        while (compare < sampleSize) {
            compare *= 2;
        }
        return compare;
    }
}
