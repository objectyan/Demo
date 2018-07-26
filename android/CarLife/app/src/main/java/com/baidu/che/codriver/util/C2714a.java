package com.baidu.che.codriver.util;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.baidu.android.common.logging.Log;

/* compiled from: BitmapCacheManager */
/* renamed from: com.baidu.che.codriver.util.a */
public class C2714a {
    /* renamed from: a */
    private static ImageLoader f8885a;
    /* renamed from: b */
    private static C2713a f8886b;

    /* compiled from: BitmapCacheManager */
    /* renamed from: com.baidu.che.codriver.util.a$a */
    public static class C2713a implements ImageCache {
        /* renamed from: a */
        private LruCache<String, Bitmap> f8884a = new LruCache<String, Bitmap>(this, Log.FILE_LIMETE) {
            /* renamed from: a */
            final /* synthetic */ C2713a f8883a;

            protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
                return m10133a((String) obj, (Bitmap) obj2);
            }

            /* renamed from: a */
            protected int m10133a(String key, Bitmap value) {
                if (value != null) {
                    return value.getRowBytes() * value.getHeight();
                }
                return 0;
            }
        };

        public Bitmap getBitmap(String url) {
            return (Bitmap) this.f8884a.get(url);
        }

        public void putBitmap(String url, Bitmap bitmap) {
            this.f8884a.put(url, bitmap);
        }

        /* renamed from: a */
        public void m10134a() {
            this.f8884a.evictAll();
        }
    }

    /* renamed from: a */
    public static ImageLoader m10135a() {
        if (f8885a == null) {
            f8886b = new C2713a();
            f8885a = new ImageLoader(C2735o.m10252a(), f8886b);
        }
        return f8885a;
    }

    /* renamed from: b */
    public static void m10136b() {
        if (f8886b != null) {
            f8886b.m10134a();
        }
        f8885a = null;
    }
}
