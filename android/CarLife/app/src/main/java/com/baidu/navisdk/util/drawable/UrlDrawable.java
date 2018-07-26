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
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import java.util.HashMap;

public class UrlDrawable extends Drawable {
    private static final int K_CACHE_CAPACITY = 80;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/urlpic");
    private static final int K_DEFAULT_HEIGHT = 100;
    private static final int K_DEFAULT_WIDTH = 100;
    public static Bitmap mDefaultBitmap;
    public static Bitmap mFailedBitmap;
    private static boolean mHasInit = false;
    private static HashMap<String, UrlDrawable> mLoadingMap = new HashMap();
    public static ImageCache sUrlCache;
    private Drawable mCurrent;
    private boolean mNeedSqureBound;

    private UrlDrawable(final String url, final String keyPath) {
        this.mNeedSqureBound = true;
        this.mCurrent = new BitmapDrawable(mDefaultBitmap);
        this.mNeedSqureBound = true;
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navisdk.util.drawable.UrlDrawable$1$1 */
            class C46461 extends BitmapRspHandler {
                C46461() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C46471.this.mBmp = retBmp;
                    if (C46471.this.mBmp != null) {
                        UrlDrawable.sUrlCache.cache2Disk(keyPath, C46471.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C46471.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = ImageTools.getBitmapFromPath(keyPath);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                try {
                    new BaseHttpClient().get(url, new C46461());
                } catch (Exception e) {
                    this.mBmp = null;
                }
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                UrlDrawable d;
                if (bmp != null) {
                    UrlDrawable.sUrlCache.put(keyPath, this.mBmp);
                    d = (UrlDrawable) UrlDrawable.mLoadingMap.remove(keyPath);
                    if (d != null) {
                        UrlDrawable.this.mNeedSqureBound = false;
                        Drawable draw = PathDrawable.getDrawable(keyPath, bmp, UrlDrawable.sUrlCache);
                        draw.setBounds(d.mCurrent.getBounds());
                        d.mCurrent = draw;
                        d.invalidateSelf();
                        return;
                    }
                    return;
                }
                d = (UrlDrawable) UrlDrawable.mLoadingMap.remove(keyPath);
                if (d != null) {
                    UrlDrawable.this.mNeedSqureBound = true;
                    draw = new BitmapDrawable(UrlDrawable.mFailedBitmap);
                    draw.setBounds(ImageTools.calcSquareRect(d.mCurrent.getBounds()));
                    d.mCurrent = draw;
                    d.invalidateSelf();
                }
            }
        }.execute("");
    }

    private static synchronized void init() {
        synchronized (UrlDrawable.class) {
            if (!mHasInit) {
                sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
                mDefaultBitmap = ImageTools.getBitmapFromResId(C4048R.drawable.voice_common_head_view);
                mFailedBitmap = ImageTools.getBitmapFromResId(C4048R.drawable.voice_common_head_view);
            }
            mHasInit = true;
        }
    }

    public static Drawable getDrawable(String url) {
        init();
        if (url == null) {
            return new BitmapDrawable(mDefaultBitmap);
        }
        Object key = sUrlCache.getCachePath(url);
        Bitmap bmp = sUrlCache.get(key);
        if (bmp != null) {
            return PathDrawable.getDrawable(key, bmp, sUrlCache);
        }
        UrlDrawable d = (UrlDrawable) mLoadingMap.get(key);
        if (d != null) {
            return d;
        }
        Drawable d2 = new UrlDrawable(url, key);
        mLoadingMap.put(key, d2);
        return d2;
    }

    public Drawable getCurrent() {
        return this.mCurrent;
    }

    public void draw(Canvas canvas) {
        if (this.mCurrent != null) {
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
            if (this.mNeedSqureBound) {
                this.mCurrent.setBounds(ImageTools.calcSquareRect(bounds));
            } else {
                this.mCurrent.setBounds(bounds);
            }
        }
        super.onBoundsChange(bounds);
    }
}
