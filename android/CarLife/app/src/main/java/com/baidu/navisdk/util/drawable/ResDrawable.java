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
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import java.io.File;
import java.util.HashMap;

public class ResDrawable extends Drawable {
    private static final int K_CACHE_CAPACITY_L = 2;
    private static final int K_CACHE_CAPACITY_S = 5;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/icons");
    private static Bitmap mDefaultBitmap;
    private static boolean mHasInit = false;
    private static HashMap<String, ResDrawable> mLoadingMap = new HashMap();
    private static ImageCache sImageCacheL;
    private static ImageCache sImageCacheS;
    private Drawable mCurrent;
    private ImageCache mImageCacheL = sImageCacheL;
    private ImageCache mImageCacheS = sImageCacheS;
    private int mResId;

    /* renamed from: com.baidu.navisdk.util.drawable.ResDrawable$1 */
    class C46451 extends UserTask<String, String, Bitmap> {
        C46451() {
        }

        public Bitmap doInBackground(String... params) {
            return ImageTools.getBitmapFromResId(ResDrawable.this.mResId);
        }

        public void onPostExecute(Bitmap bmp) {
            if (bmp != null) {
                if (bmp.getHeight() > ScreenUtil.getInstance().getHeightPixels() / 2 || bmp.getWidth() > ScreenUtil.getInstance().getWidthPixels() / 2) {
                    ResDrawable.this.mImageCacheL.put(ResDrawable.this.mResId + "", bmp);
                } else {
                    ResDrawable.this.mImageCacheS.put(ResDrawable.this.mResId + "", bmp);
                }
                ResDrawable d = (ResDrawable) ResDrawable.mLoadingMap.remove(ResDrawable.this.mResId + "");
                if (d != null) {
                    Drawable draw = new BitmapDrawable(bmp);
                    draw.setBounds(d.mCurrent.getBounds());
                    d.mCurrent = draw;
                    d.invalidateSelf();
                }
            }
        }
    }

    private ResDrawable(int resId) {
        this.mResId = resId;
        changeBitmap();
    }

    private ResDrawable(int resId, Bitmap bmp) {
        this.mResId = resId;
        this.mCurrent = new BitmapDrawable(bmp);
    }

    private void changeBitmap() {
        this.mCurrent = new BitmapDrawable(mDefaultBitmap);
        new C46451().execute("");
    }

    private static synchronized void init() {
        synchronized (ResDrawable.class) {
            if (!mHasInit) {
                sImageCacheS = new ImageCache(getCachePath(), 5);
                sImageCacheL = new ImageCache(getCachePath(), 2);
                mDefaultBitmap = ImageTools.getBitmapFromResId(C4048R.drawable.bnav_bear_wait_middle);
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

    public static Drawable getDrawable(int resId) {
        ResDrawable d;
        init();
        ImageCache cache = sImageCacheL;
        Bitmap bmp = cache.get(sImageCacheL);
        if (bmp == null) {
            bmp = cache.get(sImageCacheS);
        }
        if (bmp != null) {
            d = new ResDrawable(resId, bmp);
        } else {
            d = new ResDrawable(resId);
        }
        mLoadingMap.put(resId + "", d);
        return d;
    }

    public static synchronized void recycle() {
        synchronized (ResDrawable.class) {
            if (sImageCacheS != null) {
                sImageCacheS.clear();
            }
            if (sImageCacheL != null) {
                sImageCacheL.clear();
            }
        }
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
