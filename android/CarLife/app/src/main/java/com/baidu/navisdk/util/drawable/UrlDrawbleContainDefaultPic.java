package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import java.util.HashMap;

public class UrlDrawbleContainDefaultPic extends Drawable {
    private static final int K_CACHE_CAPACITY = 80;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurlpic");
    private static boolean mHasInit = false;
    private static HashMap<String, UrlDrawbleContainDefaultPic> mLoadingMap = new HashMap();
    public static ImageCache sUrlCache;
    private Drawable mCurrent;
    private boolean mNeedSqureBound = true;

    private UrlDrawbleContainDefaultPic(final String url, final String keyPath, int defaultDrawableId) {
        this.mCurrent = BNStyleManager.getDrawable(defaultDrawableId);
        this.mNeedSqureBound = true;
        if (this.mCurrent == null) {
            this.mCurrent = new BitmapDrawable(ImageTools.getBitmapFromResId(C4048R.drawable.ugc_default_pic));
        }
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navisdk.util.drawable.UrlDrawbleContainDefaultPic$1$1 */
            class C46541 extends BitmapRspHandler {
                C46541() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C46551.this.mBmp = retBmp;
                    if (C46551.this.mBmp != null) {
                        UrlDrawbleContainDefaultPic.sUrlCache.cache2Disk(keyPath, C46551.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C46551.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = ImageTools.getBitmapFromPath(keyPath);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                try {
                    new BaseHttpClient().get(url, new C46541());
                } catch (Exception e) {
                    this.mBmp = null;
                }
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                if (bmp != null) {
                    UrlDrawbleContainDefaultPic.sUrlCache.put(keyPath, this.mBmp);
                    UrlDrawbleContainDefaultPic d = (UrlDrawbleContainDefaultPic) UrlDrawbleContainDefaultPic.mLoadingMap.remove(keyPath);
                    if (d != null) {
                        UrlDrawbleContainDefaultPic.this.mNeedSqureBound = false;
                        Drawable draw = PathDrawable.getDrawable(keyPath, bmp, UrlDrawbleContainDefaultPic.sUrlCache);
                        draw.setBounds(d.mCurrent.getBounds());
                        d.mCurrent = draw;
                        d.invalidateSelf();
                        return;
                    }
                    return;
                }
                UrlDrawbleContainDefaultPic.mLoadingMap.remove(keyPath);
            }
        }.execute("");
    }

    private static synchronized void init() {
        synchronized (UrlDrawbleContainDefaultPic.class) {
            if (!mHasInit) {
                sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
            }
            mHasInit = true;
        }
    }

    public static Drawable getDrawable(String url, int defaultDrawableId) {
        init();
        if (url == null) {
            return BNStyleManager.getDrawable(defaultDrawableId);
        }
        Object key = sUrlCache.getCachePath(url);
        Bitmap bmp = sUrlCache.get(key);
        if (bmp != null) {
            return PathDrawable.getDrawable(key, bmp, sUrlCache);
        }
        UrlDrawbleContainDefaultPic d = (UrlDrawbleContainDefaultPic) mLoadingMap.get(key);
        if (d != null) {
            return d;
        }
        Drawable d2 = new UrlDrawbleContainDefaultPic(url, key, defaultDrawableId);
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
