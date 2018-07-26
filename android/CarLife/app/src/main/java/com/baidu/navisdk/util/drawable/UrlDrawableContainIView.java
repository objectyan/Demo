package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import com.baidu.navisdk.util.jar.JarUtils;

public class UrlDrawableContainIView {
    private static final int K_CACHE_CAPACITY = 80;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurliview");
    public static final int RET_FAILED = 1;
    public static final int RET_SUCCESS = 0;
    public static final int WHAT_MSG_DOWNLOAD_COMPLETED = 8192;
    private static boolean mHasInit = false;
    private static Bitmap mPersistBitmap = null;
    private static String mPersistKey = null;
    public static ImageCache sUrlCache;
    private boolean mNeedSqureBound = true;

    private UrlDrawableContainIView(String url, String keyPath, ImageView mImageView, Handler mHandler) {
        final String str = keyPath;
        final String str2 = url;
        final ImageView imageView = mImageView;
        final Handler handler = mHandler;
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navisdk.util.drawable.UrlDrawableContainIView$1$1 */
            class C46501 extends BitmapRspHandler {
                C46501() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C46511.this.mBmp = retBmp;
                    if (C46511.this.mBmp != null) {
                        UrlDrawableContainIView.sUrlCache.cache2Disk(str, C46511.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C46511.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = ImageTools.getBitmapFromPath(str);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                try {
                    new BaseHttpClient().get(str2, new C46501());
                } catch (Exception e) {
                    this.mBmp = null;
                }
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                if (bmp != null && !bmp.isRecycled()) {
                    if (str.equals(UrlDrawableContainIView.mPersistKey)) {
                        UrlDrawableContainIView.mPersistBitmap = this.mBmp;
                        imageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
                    } else {
                        UrlDrawableContainIView.sUrlCache.put(str, this.mBmp);
                        imageView.setBackgroundDrawable(new BitmapDrawable(this.mBmp));
                    }
                    if (handler != null) {
                        UrlDrawableContainIView.onDownloadCompletedCallBack(str2, handler, 0);
                    }
                    LogUtil.m15791e("caizhirui", "get new");
                } else if (handler != null) {
                    UrlDrawableContainIView.onDownloadCompletedCallBack(str2, handler, 1);
                }
            }
        }.execute("");
    }

    private static synchronized void init() {
        synchronized (UrlDrawableContainIView.class) {
            if (!mHasInit) {
                sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
            }
            mHasInit = true;
        }
    }

    public static void getDrawable(String url, int defaultDrawableId, ImageView mImageView, Handler mHandler) {
        getDrawable(url, defaultDrawableId, mImageView, mHandler, false);
    }

    public static void getDrawable(String url, int defaultDrawableId, ImageView mImageView, Handler mHandler, boolean fitScreen) {
        if (mImageView != null) {
            init();
            Drawable mDrawable;
            if (url == null) {
                mDrawable = BNStyleManager.getDrawable(defaultDrawableId);
                if (mDrawable == null) {
                    mDrawable = new BitmapDrawable(ImageTools.getBitmapFromResId(C4048R.drawable.ugc_default_pic));
                }
                mImageView.setBackgroundDrawable(mDrawable);
                LogUtil.m15791e("caizhirui", "url == null");
                return;
            }
            Object key = sUrlCache.getCachePath(url);
            if (!key.equals(mPersistKey)) {
                Bitmap bmp = sUrlCache.get(key);
                if (bmp != null && bmp.isRecycled()) {
                    sUrlCache.remove(bmp);
                } else if (bmp != null) {
                    if (fitScreen) {
                        mImageView.setImageDrawable(zoomDrawable(bmp, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), true));
                    } else {
                        mImageView.setBackgroundDrawable(new BitmapDrawable(bmp));
                    }
                    LogUtil.m15791e("caizhirui", "in memory cache");
                    if (mHandler != null) {
                        onDownloadCompletedCallBack(url, mHandler, 0);
                        return;
                    }
                    return;
                }
            } else if (!(mPersistBitmap == null || mPersistBitmap.isRecycled())) {
                mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), mPersistBitmap));
                if (mHandler != null) {
                    onDownloadCompletedCallBack(url, mHandler, 0);
                    return;
                }
                return;
            }
            mDrawable = BNStyleManager.getDrawable(defaultDrawableId);
            if (mDrawable == null) {
                mDrawable = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(C4048R.drawable.ugc_default_pic));
            }
            if (key.equals(mPersistKey)) {
                mImageView.setImageDrawable(mDrawable);
            } else {
                mImageView.setBackgroundDrawable(mDrawable);
            }
            LogUtil.m15791e("caizhirui", "use default");
            UrlDrawableContainIView urlDrawableContainIView = new UrlDrawableContainIView(url, key, mImageView, mHandler);
        }
    }

    private static Drawable zoomDrawable(Bitmap bitmap, int desWidth, int desHeight, boolean fitBoth) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) desWidth) / ((float) bitmap.getWidth());
        float scaleHeight = ((float) desHeight) / ((float) bitmap.getHeight());
        if (fitBoth) {
            if (scaleHeight < scaleWidth) {
                scaleWidth = scaleHeight;
            } else {
                scaleHeight = scaleWidth;
            }
        }
        matrix.postScale(scaleWidth, scaleHeight);
        return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
    }

    private static void onDownloadCompletedCallBack(String url, Handler mHandler, int ret) {
        if (mHandler != null) {
            Message msg = mHandler.obtainMessage();
            msg.what = 8192;
            msg.arg1 = ret;
            msg.obj = url;
            mHandler.sendMessage(msg);
        }
    }

    public static void setPersistKey(String url) {
        if (url != null) {
            init();
            mPersistKey = sUrlCache.getCachePath(url);
        }
    }

    public static void recycleBitmap() {
        if (sUrlCache != null) {
            sUrlCache.clear();
        }
    }

    public static void getSrcDrawable(String url, int defaultDrawableId, ImageView mImageView, Handler mHandler) {
        if (mImageView != null) {
            Drawable mDrawable;
            if (StringUtils.isEmpty(url)) {
                mDrawable = BNStyleManager.getDrawable(defaultDrawableId);
                if (mDrawable == null) {
                    mDrawable = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(C4048R.drawable.nsdk_drawable_common_ic_safe_nav));
                }
                mImageView.setImageDrawable(mDrawable);
                return;
            }
            init();
            Object key = sUrlCache.getCachePath(url);
            Bitmap bmp = sUrlCache.get(key);
            if (bmp != null && bmp.isRecycled()) {
                sUrlCache.remove(bmp);
            } else if (bmp != null) {
                mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bmp));
                if (mHandler != null) {
                    onDownloadCompletedCallBack(url, mHandler, 0);
                    return;
                }
                return;
            }
            mDrawable = BNStyleManager.getDrawable(defaultDrawableId);
            if (mDrawable == null) {
                mDrawable = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(C4048R.drawable.nsdk_drawable_common_ic_safe_nav));
            }
            mImageView.setImageDrawable(mDrawable);
            UrlSrcDrawableView(url, key, mImageView, mHandler);
        }
    }

    private static void UrlSrcDrawableView(final String url, final String keyPath, final ImageView mImageView, final Handler mHandler) {
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navisdk.util.drawable.UrlDrawableContainIView$2$1 */
            class C46521 extends BitmapRspHandler {
                C46521() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C46532.this.mBmp = retBmp;
                    if (C46532.this.mBmp != null) {
                        UrlDrawableContainIView.sUrlCache.cache2Disk(keyPath, C46532.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C46532.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = ImageTools.getBitmapFromPath(keyPath);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                try {
                    new BaseHttpClient().get(url, new C46521());
                } catch (Exception e) {
                    this.mBmp = null;
                }
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                if (bmp != null && !bmp.isRecycled()) {
                    UrlDrawableContainIView.sUrlCache.put(keyPath, this.mBmp);
                    mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
                    if (mHandler != null) {
                        UrlDrawableContainIView.onDownloadCompletedCallBack(url, mHandler, 0);
                    }
                } else if (mHandler != null) {
                    UrlDrawableContainIView.onDownloadCompletedCallBack(url, mHandler, 1);
                }
            }
        }.execute("");
    }
}
