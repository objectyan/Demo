package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
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
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import com.baidu.navisdk.util.jar.JarUtils;

public class UrlDrawableContainForNav {
    private static final int K_CACHE_CAPACITY = 80;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/naving");
    public static final int RET_FAILED = 1;
    public static final int RET_SUCCESS = 0;
    public static final int WHAT_MSG_DOWNLOAD_COMPLETED = 8192;
    private static boolean mHasInit = false;
    public static ImageCache sUrlCache;

    private static synchronized void init() {
        synchronized (UrlDrawableContainForNav.class) {
            if (!mHasInit) {
                sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
            }
            mHasInit = true;
        }
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
            try {
                UrlSrcDrawableView(url, key, mImageView, mHandler);
            } catch (Throwable e) {
                LogUtil.m15791e("UrlDrawableContainForNav", "crash:" + e.getMessage());
            }
        }
    }

    private static void UrlSrcDrawableView(final String url, final String keyPath, final ImageView mImageView, final Handler mHandler) {
        new UserTask<String, String, Bitmap>() {
            Bitmap mBmp;

            /* renamed from: com.baidu.navisdk.util.drawable.UrlDrawableContainForNav$1$1 */
            class C46481 extends BitmapRspHandler {
                C46481() {
                }

                public void onRevBitmap(Bitmap retBmp) {
                    C46491.this.mBmp = retBmp;
                    if (C46491.this.mBmp != null) {
                        UrlDrawableContainForNav.sUrlCache.cache2Disk(keyPath, C46491.this.mBmp);
                    }
                }

                public void onFailure(Throwable error) {
                    C46491.this.mBmp = null;
                }
            }

            public Bitmap doInBackground(String... params) {
                this.mBmp = ImageTools.getBitmapFromPath(keyPath);
                if (this.mBmp != null) {
                    return this.mBmp;
                }
                try {
                    new BaseHttpClient().get(url, new C46481());
                } catch (Exception e) {
                    this.mBmp = null;
                }
                return this.mBmp;
            }

            public void onPostExecute(Bitmap bmp) {
                if (bmp != null && !bmp.isRecycled()) {
                    UrlDrawableContainForNav.sUrlCache.put(keyPath, this.mBmp);
                    mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
                    if (mHandler != null) {
                        UrlDrawableContainForNav.onDownloadCompletedCallBack(url, mHandler, 0);
                    }
                } else if (mHandler != null) {
                    UrlDrawableContainForNav.onDownloadCompletedCallBack(url, mHandler, 1);
                }
            }
        }.execute("");
    }
}
