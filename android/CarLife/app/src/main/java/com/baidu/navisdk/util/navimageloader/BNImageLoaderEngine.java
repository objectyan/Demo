package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import com.baidu.navisdk.util.worker.BNWorkerCallbackTask;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BNImageLoaderEngine {
    public static final int BITMAP_FROM_DISK = 1;
    public static final int BITMAP_FROM_FAILED = 4;
    public static final int BITMAP_FROM_LOADING = 3;
    public static final int BITMAP_FROM_LOADING_QUEUE = 2;
    public static final int BITMAP_FROM_MEMORY = 0;
    private Map<String, ImageInfoSet> loadingImageSets = new HashMap();
    private final Object pauseLock = new Object();

    static class ImageInfoSet {
        private ArrayList<LoadAndDisplayImageTask> imageViewAList = new ArrayList();

        ImageInfoSet(LoadAndDisplayImageTask task) {
            this.imageViewAList.add(task);
        }

        public void add(LoadAndDisplayImageTask task) {
            this.imageViewAList.add(task);
        }
    }

    static class LoadAndDisplayImageTask implements Runnable {
        ImageView imageView;
        String key;
        String keyPath;
        BNImageLoadingListener listener;
        int mBitmapFrom;
        Bitmap mBmp;
        BNDisplayImageOptions options;
        ImageCache sUrlCache;
        String uri;

        /* renamed from: com.baidu.navisdk.util.navimageloader.BNImageLoaderEngine$LoadAndDisplayImageTask$1 */
        class C47191 extends BitmapRspHandler {
            C47191() {
            }

            public void onRevBitmap(Bitmap retBmp) {
                LoadAndDisplayImageTask.this.mBmp = retBmp;
                if (LoadAndDisplayImageTask.this.mBmp != null && LoadAndDisplayImageTask.this.options.isCacheOnDisk()) {
                    LoadAndDisplayImageTask.this.sUrlCache.cache2Disk(LoadAndDisplayImageTask.this.keyPath, LoadAndDisplayImageTask.this.mBmp);
                }
            }

            public void onFailure(Throwable error) {
                LoadAndDisplayImageTask.this.mBmp = null;
            }
        }

        LoadAndDisplayImageTask(String key, String keyPath, String uri, ImageView imageView, BNDisplayImageOptions options, BNImageLoadingListener listener, ImageCache sUrlCache) {
            this.keyPath = keyPath;
            this.uri = uri;
            this.imageView = imageView;
            this.options = options;
            this.listener = listener;
            this.sUrlCache = sUrlCache;
            this.key = key;
        }

        public void run() {
            if (checkIsValid()) {
                this.mBmp = ImageTools.getBitmapFromPath(this.keyPath);
                if (this.mBmp != null) {
                    this.mBitmapFrom = 1;
                    return;
                }
                try {
                    new BaseHttpClient().get(this.uri, new C47191());
                } catch (Exception e) {
                    this.mBmp = null;
                }
            }
        }

        public Bitmap getLoadedBitMap() {
            return this.mBmp;
        }

        private boolean checkIsValid() {
            if (this.uri == null || this.sUrlCache == null || this.options == null) {
                return false;
            }
            return true;
        }
    }

    BNImageLoaderEngine() {
    }

    boolean preparedBitmapLoad(String uri, LoadAndDisplayImageTask mTask) {
        if (mTask == null) {
            return false;
        }
        if (this.loadingImageSets == null) {
            this.loadingImageSets = new HashMap();
        }
        if (this.loadingImageSets.containsKey(uri)) {
            ((ImageInfoSet) this.loadingImageSets.get(uri)).add(mTask);
            return false;
        }
        this.loadingImageSets.put(uri, new ImageInfoSet(mTask));
        return true;
    }

    void removeBitmapLoad(String uri) {
        if (this.loadingImageSets != null) {
            this.loadingImageSets.remove(uri);
        }
    }

    void submit(final LoadAndDisplayImageTask task) {
        if (task != null) {
            BNWorkerCenter.getInstance().submitCallbackTask(new BNWorkerCallbackTask<String, Bitmap>("BNImageLoaderEngine-submit", null) {
                protected Bitmap execute() {
                    task.run();
                    return task.getLoadedBitMap();
                }

                public void callback(Bitmap data) {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<Bitmap, String>("BNImageLoaderEngine-submit-2", data) {
                        protected String execute() {
                            ArrayList<LoadAndDisplayImageTask> mALImageInfo = null;
                            if (BNImageLoaderEngine.this.loadingImageSets != null) {
                                ImageInfoSet mImageInfoSet = (ImageInfoSet) BNImageLoaderEngine.this.loadingImageSets.get(task.uri);
                                if (mImageInfoSet != null) {
                                    mALImageInfo = mImageInfoSet.imageViewAList;
                                }
                            }
                            int i;
                            if (this.inData == null || ((Bitmap) this.inData).isRecycled()) {
                                if (mALImageInfo != null) {
                                    for (i = 0; i < mALImageInfo.size(); i++) {
                                        BNImageLoaderEngine.this.displayFail((LoadAndDisplayImageTask) mALImageInfo.get(i));
                                    }
                                } else {
                                    BNImageLoaderEngine.this.displayFail(task);
                                }
                            } else if (mALImageInfo != null) {
                                for (i = 0; i < mALImageInfo.size(); i++) {
                                    BNImageLoaderEngine.this.displaySuccess((Bitmap) this.inData, (LoadAndDisplayImageTask) mALImageInfo.get(i));
                                }
                            } else {
                                BNImageLoaderEngine.this.displaySuccess((Bitmap) this.inData, task);
                            }
                            BNImageLoaderEngine.this.removeBitmapLoad(task.uri);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    private void displaySuccess(Bitmap mBitmap, LoadAndDisplayImageTask task) {
        if (task.checkIsValid() && mBitmap != null) {
            task.options.getDisplayer().display(task.uri, mBitmap, task.imageView);
            if (task.options.isPersistCache()) {
                if (!BNImageLoader.mPersistCache.containsKey(task.key)) {
                    BNImageLoader.mPersistCache.put(task.key, mBitmap);
                }
            } else if (task.options.isCacheInMemory() && !task.sUrlCache.containsKey(task.key)) {
                task.sUrlCache.put(task.key, mBitmap);
            }
            if (task.listener != null) {
                task.listener.onLoadingComplete(task.uri, task.imageView, mBitmap, task.mBitmapFrom);
            }
        }
    }

    private void displayFail(LoadAndDisplayImageTask task) {
        if (task.checkIsValid()) {
            task.options.getDisplayer().display(task.uri, task.options.getImageOnFail(), task.imageView);
            if (task.listener != null) {
                task.listener.onLoadingComplete(task.uri, task.imageView, null, task.mBitmapFrom);
            }
        }
    }
}
