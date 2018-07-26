package com.facebook.p269f;

/* compiled from: ImageFormat */
/* renamed from: com.facebook.f.b */
public enum C5434b {
    WEBP_SIMPLE,
    WEBP_LOSSLESS,
    WEBP_EXTENDED,
    WEBP_EXTENDED_WITH_ALPHA,
    WEBP_ANIMATED,
    JPEG,
    PNG,
    GIF,
    BMP,
    UNKNOWN;

    /* renamed from: a */
    public static boolean m18671a(C5434b imageFormat) {
        return imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA || imageFormat == WEBP_ANIMATED;
    }

    /* renamed from: b */
    public static String m18672b(C5434b imageFormat) throws UnsupportedOperationException {
        switch (imageFormat) {
            case WEBP_SIMPLE:
            case WEBP_LOSSLESS:
            case WEBP_EXTENDED:
            case WEBP_EXTENDED_WITH_ALPHA:
            case WEBP_ANIMATED:
                return "webp";
            case JPEG:
                return "jpeg";
            case PNG:
                return "png";
            case GIF:
                return "gif";
            case BMP:
                return "bmp";
            default:
                throw new UnsupportedOperationException("Unknown image format " + imageFormat.name());
        }
    }
}
