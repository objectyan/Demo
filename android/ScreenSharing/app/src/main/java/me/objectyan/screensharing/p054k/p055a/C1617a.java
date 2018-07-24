package com.baidu.carlife.p054k.p055a;

import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

/* compiled from: BitmapCache */
/* renamed from: com.baidu.carlife.k.a.a */
public class C1617a implements ImageCache {
    /* renamed from: a */
    private LruCache<String, Bitmap> f4947a = new LruCache<String, Bitmap>(this, ((int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 8) {
        /* renamed from: a */
        final /* synthetic */ C1617a f4946a;

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m5896a((String) obj, (Bitmap) obj2);
        }

        /* renamed from: a */
        protected int m5896a(String key, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public Bitmap getBitmap(String url) {
        return (Bitmap) this.f4947a.get(url);
    }

    public void putBitmap(String url, Bitmap bitmap) {
        this.f4947a.put(url, bitmap);
    }
}
