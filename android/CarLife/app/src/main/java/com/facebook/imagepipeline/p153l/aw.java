package com.facebook.imagepipeline.p153l;

import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p276e.C5495d;

/* compiled from: ThumbnailSizeChecker */
/* renamed from: com.facebook.imagepipeline.l.aw */
public final class aw {
    /* renamed from: a */
    public static final float f22570a = 1.3333334f;
    /* renamed from: b */
    private static final int f22571b = 90;
    /* renamed from: c */
    private static final int f22572c = 270;

    /* renamed from: a */
    public static boolean m19282a(int width, int height, C5495d resizeOptions) {
        if (resizeOptions == null) {
            if (((float) aw.m19281a(width)) < 2048.0f || aw.m19281a(height) < 2048) {
                return false;
            }
            return true;
        } else if (aw.m19281a(width) < resizeOptions.f22340a || aw.m19281a(height) < resizeOptions.f22341b) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m19283a(C2952d encodedImage, C5495d resizeOptions) {
        if (encodedImage == null) {
            return false;
        }
        switch (encodedImage.f()) {
            case 90:
            case 270:
                return aw.m19282a(encodedImage.h(), encodedImage.g(), resizeOptions);
            default:
                return aw.m19282a(encodedImage.g(), encodedImage.h(), resizeOptions);
        }
    }

    /* renamed from: a */
    public static int m19281a(int size) {
        return (int) (((float) size) * 1.3333334f);
    }
}
