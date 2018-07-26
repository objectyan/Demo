package com.facebook.p148h;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.Pair;
import com.facebook.common.internal.C5350k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: BitmapUtil */
/* renamed from: com.facebook.h.a */
public final class C2940a {
    /* renamed from: a */
    public static final int f13028a = 1;
    /* renamed from: b */
    public static final int f13029b = 2;
    /* renamed from: c */
    public static final int f13030c = 4;
    /* renamed from: d */
    public static final int f13031d = 2;
    /* renamed from: e */
    public static final float f13032e = 2048.0f;
    /* renamed from: f */
    private static final int f13033f = 16384;
    /* renamed from: g */
    private static final int f13034g = 12;
    /* renamed from: h */
    private static final SynchronizedPool<ByteBuffer> f13035h = new SynchronizedPool(12);

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static int m11592a(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (VERSION.SDK_INT > 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        if (VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getWidth() * bitmap.getRowBytes();
    }

    @Nullable
    /* renamed from: a */
    public static Pair<Integer, Integer> m11594a(byte[] bytes) {
        return C2940a.m11593a(new ByteArrayInputStream(bytes));
    }

    @Nullable
    /* renamed from: a */
    public static Pair<Integer, Integer> m11593a(InputStream is) {
        Pair<Integer, Integer> pair = null;
        C5350k.a(is);
        ByteBuffer byteBuffer = (ByteBuffer) f13035h.acquire();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(16384);
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBuffer.array();
            BitmapFactory.decodeStream(is, null, options);
            if (!(options.outWidth == -1 || options.outHeight == -1)) {
                pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
            }
            f13035h.release(byteBuffer);
            return pair;
        } catch (Throwable th) {
            f13035h.release(byteBuffer);
        }
    }

    /* renamed from: a */
    public static int m11591a(Config bitmapConfig) {
        switch (a$1.f22212a[bitmapConfig.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    /* renamed from: a */
    public static int m11590a(int width, int height, Config bitmapConfig) {
        return (width * height) * C2940a.m11591a(bitmapConfig);
    }
}
