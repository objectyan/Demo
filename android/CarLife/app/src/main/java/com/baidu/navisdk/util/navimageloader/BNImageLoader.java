package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.HashMap;
import java.util.Map;

public class BNImageLoader {
    private static final String KEY_IMAGEVIEW = "key.imageview";
    private static final String KEY_RES = "key.res";
    private static final String KEY_URL = "key.url";
    private static final int K_CACHE_CAPACITY = 50;
    private static final String K_DEFAULT_CACHE_PATH = (SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurliview");
    private static volatile BNImageLoader instance;
    public static HashMap<String, Bitmap> mPersistCache = new HashMap();
    private BNBitmapDisplayer defaultBitmapDisplayer;
    private BNImageLoadingListener defaultImageLoadingListener;
    private BNDisplayImageOptions defaultOptions;
    private BNImageLoaderEngine engine;
    private Handler mainHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg != null) {
                try {
                    Map<String, Object> mMap = msg.obj;
                    String url = (String) mMap.get(BNImageLoader.KEY_URL);
                    ImageView mImageView = (ImageView) mMap.get(BNImageLoader.KEY_IMAGEVIEW);
                    Object res = mMap.get(BNImageLoader.KEY_RES);
                    if (res instanceof Bitmap) {
                        Bitmap bitmap = (Bitmap) res;
                        if (bitmap != null && mImageView != null) {
                            if (mImageView.getTag() == null) {
                                mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                            } else if (mImageView.getTag().equals(url)) {
                                mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                            }
                        }
                    } else if (res instanceof Drawable) {
                        Drawable mDrawable = (Drawable) res;
                        if (mImageView != null && mDrawable != null) {
                            mImageView.setImageDrawable(mDrawable);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public ImageCache sUrlCache;

    /* renamed from: com.baidu.navisdk.util.navimageloader.BNImageLoader$1 */
    class C47141 implements BNBitmapDisplayer {
        C47141() {
        }

        public void display(String url, Drawable mDrawable, ImageView mImageView) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (BNImageLoader.this.mainHandler != null) {
                    Message msg = BNImageLoader.this.mainHandler.obtainMessage();
                    HashMap<String, Object> map = new HashMap(5);
                    map.put(BNImageLoader.KEY_URL, url);
                    map.put(BNImageLoader.KEY_IMAGEVIEW, mImageView);
                    map.put(BNImageLoader.KEY_RES, mDrawable);
                    msg.obj = map;
                    BNImageLoader.this.mainHandler.sendMessage(msg);
                }
            } else if (mImageView != null && mDrawable != null) {
                mImageView.setImageDrawable(mDrawable);
            }
        }

        public void display(String url, Bitmap bitmap, ImageView mImageView) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (BNImageLoader.this.mainHandler != null) {
                    Message msg = BNImageLoader.this.mainHandler.obtainMessage();
                    HashMap<String, Object> map = new HashMap(5);
                    map.put(BNImageLoader.KEY_URL, url);
                    map.put(BNImageLoader.KEY_IMAGEVIEW, mImageView);
                    map.put(BNImageLoader.KEY_RES, bitmap);
                    msg.obj = map;
                    BNImageLoader.this.mainHandler.sendMessage(msg);
                }
            } else if (bitmap != null && mImageView != null) {
                if (mImageView.getTag() == null) {
                    mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                } else if (mImageView.getTag().equals(url)) {
                    mImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.navimageloader.BNImageLoader$3 */
    class C47163 implements BNImageLoadingListener {
        C47163() {
        }

        public void onLoadingStarted(String imageUri, View view) {
        }

        public void onLoadingFailed(String imageUri, View view, String failReason) {
        }

        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage, int from) {
        }
    }

    public static BNImageLoader getInstance() {
        if (instance == null) {
            synchronized (BNImageLoader.class) {
                if (instance == null) {
                    instance = new BNImageLoader();
                }
            }
        }
        return instance;
    }

    private BNDisplayImageOptions createDefaultDisplayImageOptions() {
        if (this.defaultOptions != null) {
            return this.defaultOptions;
        }
        this.defaultOptions = new BNDisplayImageOptions$Builder().build();
        return this.defaultOptions;
    }

    protected BNImageLoader() {
    }

    private void init() {
        if (this.sUrlCache == null) {
            this.sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 50);
        }
        if (mPersistCache == null) {
            mPersistCache = new HashMap();
        }
        if (this.engine == null) {
            this.engine = new BNImageLoaderEngine();
        }
    }

    private boolean hasInit() {
        return (this.engine == null || this.sUrlCache == null || mPersistCache == null) ? false : true;
    }

    public void displayImage(String uri, ImageView imageView) {
        displayImage(uri, imageView, null, null);
    }

    public void displayImage(String uri, ImageView imageView, BNDisplayImageOptions options) {
        displayImage(uri, imageView, options, null);
    }

    public void displayImage(String uri, ImageView imageView, BNImageLoadingListener listener) {
        displayImage(uri, imageView, null, listener);
    }

    public void displayImage(String uri, ImageView imageView, BNDisplayImageOptions options, BNImageLoadingListener listener) {
        if (imageView != null) {
            if (options == null) {
                options = createDefaultDisplayImageOptions();
            }
            if (listener == null) {
                listener = createImageLoadingListener();
            }
            if (!hasInit()) {
                init();
            }
            if (TextUtils.isEmpty(uri)) {
                if (listener != null) {
                    listener.onLoadingStarted(uri, imageView);
                }
                options.getDisplayer().display(null, options.getImageOnFail(), imageView);
                if (listener != null) {
                    listener.onLoadingComplete(uri, imageView, null, 4);
                    return;
                }
                return;
            }
            String memoryCacheKey = this.sUrlCache.getFileNameForKey(uri);
            Bitmap bmp = getAndProceesBitmapFromCache(memoryCacheKey);
            if (listener != null) {
                listener.onLoadingStarted(uri, imageView);
            }
            if (bmp == null || bmp.isRecycled()) {
                options.getDisplayer().display(uri, options.getImageOnLoading(), imageView);
                LoadAndDisplayImageTask displayTask = new LoadAndDisplayImageTask(memoryCacheKey, this.sUrlCache.getCachePath(uri), uri, imageView, options, listener, this.sUrlCache);
                if (options.isSyncLoading()) {
                    displayTask.mBitmapFrom = 3;
                    displayTask.run();
                    return;
                } else if (this.engine.preparedBitmapLoad(uri, displayTask)) {
                    displayTask.mBitmapFrom = 3;
                    this.engine.submit(displayTask);
                    return;
                } else {
                    displayTask.mBitmapFrom = 2;
                    return;
                }
            }
            options.getDisplayer().display(uri, bmp, imageView);
            if (listener != null) {
                listener.onLoadingComplete(uri, imageView, bmp, 0);
            }
        }
    }

    private Bitmap getAndProceesBitmapFromCache(String memoryCacheKey) {
        Bitmap bmp = this.sUrlCache.get((Object) memoryCacheKey);
        if (bmp != null && bmp.isRecycled()) {
            this.sUrlCache.remove(memoryCacheKey);
            bmp = null;
        }
        Bitmap bmpPersist = (Bitmap) mPersistCache.get(memoryCacheKey);
        if (bmpPersist != null && bmp.isRecycled()) {
            mPersistCache.remove(memoryCacheKey);
            bmpPersist = null;
        }
        return bmp == null ? bmpPersist : bmp;
    }

    BNBitmapDisplayer createBitmapDisplayer() {
        if (this.defaultBitmapDisplayer == null) {
            this.defaultBitmapDisplayer = new C47141();
        }
        return this.defaultBitmapDisplayer;
    }

    BNImageLoadingListener createImageLoadingListener() {
        if (this.defaultImageLoadingListener == null) {
            this.defaultImageLoadingListener = new C47163();
        }
        return this.defaultImageLoadingListener;
    }
}
