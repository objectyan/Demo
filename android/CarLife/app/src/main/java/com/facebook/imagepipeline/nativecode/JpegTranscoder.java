package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.DoNotStrip;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class JpegTranscoder {
    /* renamed from: a */
    public static final int f22830a = 0;
    /* renamed from: b */
    public static final int f22831b = 100;
    /* renamed from: c */
    public static final int f22832c = 1;
    /* renamed from: d */
    public static final int f22833d = 16;
    /* renamed from: e */
    public static final int f22834e = 8;

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    static {
        C5656a.m19641a();
    }

    /* renamed from: a */
    public static boolean m19640a(int degrees) {
        return degrees >= 0 && degrees <= 270 && degrees % 90 == 0;
    }

    /* renamed from: a */
    public static void m19639a(InputStream inputStream, OutputStream outputStream, int rotationAngle, int scaleNumerator, int quality) throws IOException {
        boolean z;
        boolean z2 = false;
        C5350k.m18315a(scaleNumerator >= 1);
        if (scaleNumerator <= 16) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (quality >= 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        if (quality <= 100) {
            z = true;
        } else {
            z = false;
        }
        C5350k.m18315a(z);
        C5350k.m18315a(m19640a(rotationAngle));
        if (!(scaleNumerator == 8 && rotationAngle == 0)) {
            z2 = true;
        }
        C5350k.m18316a(z2, (Object) "no transformation requested");
        nativeTranscodeJpeg((InputStream) C5350k.m18310a((Object) inputStream), (OutputStream) C5350k.m18310a((Object) outputStream), rotationAngle, scaleNumerator, quality);
    }
}
