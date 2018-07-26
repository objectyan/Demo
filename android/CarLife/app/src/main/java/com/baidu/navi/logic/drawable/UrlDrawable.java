package com.baidu.navi.logic.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.carlife.C0965R;
import com.baidu.navi.utils.Tools;
import com.baidu.navi.utils.cache.ImageCache;
import com.baidu.navi.utils.http.BaseHttpClient;
import com.baidu.navi.utils.http.BitmapRspHandler;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
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

            /* renamed from: com.baidu.navi.logic.drawable.UrlDrawable$1$1 */
            class C39381 extends BitmapRspHandler {
                C39381() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C39391.this.mBmp = retBmp;
                    if (C39391.this.mBmp != null) {
                        UrlDrawable.sUrlCache.cache2Disk(keyPath, C39391.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C39391.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = Tools.getBitmapFromPath(keyPath);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                new BaseHttpClient().get(url, new C39381());
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
                    draw.setBounds(Tools.calcSquareRect(d.mCurrent.getBounds()));
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
                mDefaultBitmap = Tools.getBitmapFromResId(C0965R.drawable.ic_launcher);
                mFailedBitmap = Tools.getBitmapFromResId(C0965R.drawable.icon_fail);
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
                this.mCurrent.setBounds(Tools.calcSquareRect(bounds));
            } else {
                this.mCurrent.setBounds(bounds);
            }
        }
        super.onBoundsChange(bounds);
    }
}
