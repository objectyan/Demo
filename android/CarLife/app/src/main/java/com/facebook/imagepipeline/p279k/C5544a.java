package com.facebook.imagepipeline.p279k;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p261k.C5357a;
import com.facebook.common.p261k.C5358b;
import com.facebook.imagepipeline.memory.C5629d;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.p148h.C2940a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: ArtDecoder */
/* renamed from: com.facebook.imagepipeline.k.a */
public class C5544a implements C5543e {
    /* renamed from: b */
    private static final int f22466b = 16384;
    /* renamed from: d */
    private static final byte[] f22467d = new byte[]{(byte) -1, (byte) -39};
    @VisibleForTesting
    /* renamed from: a */
    final SynchronizedPool<ByteBuffer> f22468a;
    /* renamed from: c */
    private final C5629d f22469c;

    public C5544a(C5629d bitmapPool, int maxNumThreads, SynchronizedPool decodeBuffers) {
        this.f22469c = bitmapPool;
        this.f22468a = decodeBuffers;
        for (int i = 0; i < maxNumThreads; i++) {
            this.f22468a.release(ByteBuffer.allocate(16384));
        }
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4117a(C2952d encodedImage, Config bitmapConfig) {
        Options options = C5544a.m19113b(encodedImage, bitmapConfig);
        boolean retryOnFail = options.inPreferredConfig != Config.ARGB_8888;
        try {
            return m19116a(encodedImage.d(), options);
        } catch (RuntimeException re) {
            if (retryOnFail) {
                return mo4117a(encodedImage, Config.ARGB_8888);
            }
            throw re;
        }
    }

    /* renamed from: a */
    public C2921a<Bitmap> mo4118a(C2952d encodedImage, Config bitmapConfig, int length) {
        InputStream jpegDataStream;
        boolean isJpegComplete = encodedImage.f(length);
        Options options = C5544a.m19113b(encodedImage, bitmapConfig);
        InputStream jpegDataStream2 = encodedImage.d();
        C5350k.m18310a((Object) jpegDataStream2);
        if (encodedImage.j() > length) {
            jpegDataStream = new C5357a(jpegDataStream2, length);
        } else {
            jpegDataStream = jpegDataStream2;
        }
        if (isJpegComplete) {
            jpegDataStream2 = jpegDataStream;
        } else {
            jpegDataStream2 = new C5358b(jpegDataStream, f22467d);
        }
        boolean retryOnFail = options.inPreferredConfig != Config.ARGB_8888;
        try {
            return m19116a(jpegDataStream2, options);
        } catch (RuntimeException re) {
            if (retryOnFail) {
                return mo4117a(encodedImage, Config.ARGB_8888);
            }
            throw re;
        }
    }

    /* renamed from: a */
    protected C2921a<Bitmap> m19116a(InputStream inputStream, Options options) {
        C5350k.m18310a((Object) inputStream);
        Bitmap bitmapToReuse = (Bitmap) this.f22469c.mo4144a(C2940a.a(options.outWidth, options.outHeight, options.inPreferredConfig));
        if (bitmapToReuse == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmapToReuse;
        ByteBuffer byteBuffer = (ByteBuffer) this.f22468a.acquire();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(16384);
        }
        try {
            options.inTempStorage = byteBuffer.array();
            Bitmap decodedBitmap = BitmapFactory.decodeStream(inputStream, null, options);
            this.f22468a.release(byteBuffer);
            if (bitmapToReuse == decodedBitmap) {
                return C2921a.a(decodedBitmap, this.f22469c);
            }
            this.f22469c.mo4017a((Object) bitmapToReuse);
            decodedBitmap.recycle();
            throw new IllegalStateException();
        } catch (RuntimeException re) {
            this.f22469c.mo4017a((Object) bitmapToReuse);
            throw re;
        } catch (Throwable th) {
            this.f22468a.release(byteBuffer);
        }
    }

    /* renamed from: b */
    private static Options m19113b(C2952d encodedImage, Config bitmapConfig) {
        Options options = new Options();
        options.inSampleSize = encodedImage.i();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.d(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = bitmapConfig;
        options.inMutable = true;
        return options;
    }
}
