package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import java.io.File;
import java.util.HashMap;

public class PathDrawable extends Drawable {
    private static final int K_CACHE_CAPACITY = 80;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/icons");
    private static Bitmap mDefaultBitmap;
    private static boolean mHasInit = false;
    private static HashMap<String, PathDrawable> mLoadingMap = new HashMap();
    private static ImageCache sIconCache;
    private Drawable mCurrent;
    private ImageCache mImageCache;
    private String mKeyPath;

    /* renamed from: com.baidu.navisdk.util.drawable.PathDrawable$1 */
    class C46431 extends UserTask<String, String, Bitmap> {
        C46431() {
        }

        public Bitmap doInBackground(String... params) {
            return ImageTools.getBitmapFromPath(PathDrawable.this.mKeyPath);
        }

        public void onPostExecute(Bitmap bmp) {
            if (bmp != null) {
                PathDrawable.this.mImageCache.put(PathDrawable.this.mKeyPath, bmp);
                PathDrawable d = (PathDrawable) PathDrawable.mLoadingMap.remove(PathDrawable.this.mKeyPath);
                if (d != null) {
                    Drawable draw = new BitmapDrawable(bmp);
                    draw.setBounds(d.mCurrent.getBounds());
                    d.mCurrent = draw;
                    d.invalidateSelf();
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.drawable.PathDrawable$2 */
    class C46442 extends UserTask<String, String, Bitmap> {
        C46442() {
        }

        public Bitmap doInBackground(String... params) {
            return ImageTools.getBitmapFromPath(PathDrawable.this.mKeyPath);
        }

        public void onPostExecute(Bitmap bmp) {
            if (bmp != null) {
                PathDrawable.this.mImageCache.put(PathDrawable.this.mKeyPath, bmp);
                Drawable draw = new BitmapDrawable(bmp);
                draw.setBounds(PathDrawable.this.mCurrent.getBounds());
                PathDrawable.this.mCurrent = draw;
                PathDrawable.this.invalidateSelf();
            }
        }
    }

    private PathDrawable(String keyPath, ImageCache cache) {
        this.mKeyPath = keyPath;
        this.mImageCache = cache;
        this.mCurrent = new BitmapDrawable(mDefaultBitmap);
        new C46431().execute("");
    }

    private void changeBitmap() {
        this.mCurrent = new BitmapDrawable(mDefaultBitmap);
        new C46442().execute("");
    }

    private PathDrawable(String keyPath, Bitmap bmp, ImageCache cache) {
        this.mKeyPath = keyPath;
        this.mImageCache = cache;
        this.mCurrent = new BitmapDrawable(bmp);
    }

    private static synchronized void init() {
        synchronized (PathDrawable.class) {
            if (!mHasInit) {
                sIconCache = new ImageCache(getCachePath(), 80);
                mDefaultBitmap = ImageTools.getBitmapFromResId(C4048R.drawable.voice_common_head_view);
            }
            mHasInit = true;
        }
    }

    public static String getCachePath() {
        File file = new File(K_DEFAULT_CACHE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return K_DEFAULT_CACHE_PATH;
    }

    public static Drawable getDrawable(String keyPath) {
        return getDrawable(keyPath, null, null);
    }

    public static Drawable getDrawable(String keyPath, Bitmap bmp, ImageCache cache) {
        init();
        if (keyPath == null) {
            return new BitmapDrawable(mDefaultBitmap);
        }
        Drawable d;
        if (cache == null) {
            cache = sIconCache;
        }
        if (bmp == null) {
            bmp = cache.get((Object) keyPath);
        }
        if (bmp != null) {
            d = new PathDrawable(keyPath, bmp, cache);
        } else {
            d = new PathDrawable(keyPath, cache);
        }
        mLoadingMap.put(keyPath, d);
        return d;
    }

    public void draw(Canvas canvas) {
        if (this.mCurrent.getBitmap().isRecycled()) {
            changeBitmap();
        } else {
            this.mCurrent.draw(canvas);
        }
    }

    public int getOpacity() {
        if (this.mCurrent != null) {
            return this.mCurrent.getOpacity();
        }
        return -2;
    }

    public void setAlpha(int alpha) {
        if (this.mCurrent != null) {
            this.mCurrent.setAlpha(alpha);
        }
    }

    public void setColorFilter(ColorFilter cf) {
        if (this.mCurrent != null) {
            this.mCurrent.setColorFilter(cf);
        }
    }

    public void onBoundsChange(Rect bounds) {
        if (this.mCurrent != null) {
            this.mCurrent.setBounds(bounds);
        }
        super.onBoundsChange(bounds);
    }
}
