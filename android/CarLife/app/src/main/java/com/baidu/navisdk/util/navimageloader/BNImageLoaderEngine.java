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
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BNImageLoaderEngine
{
  public static final int BITMAP_FROM_DISK = 1;
  public static final int BITMAP_FROM_FAILED = 4;
  public static final int BITMAP_FROM_LOADING = 3;
  public static final int BITMAP_FROM_LOADING_QUEUE = 2;
  public static final int BITMAP_FROM_MEMORY = 0;
  private Map<String, ImageInfoSet> loadingImageSets = new HashMap();
  private final Object pauseLock = new Object();
  
  private void displayFail(LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
  {
    if (!paramLoadAndDisplayImageTask.checkIsValid()) {}
    do
    {
      return;
      paramLoadAndDisplayImageTask.options.getDisplayer().display(paramLoadAndDisplayImageTask.uri, paramLoadAndDisplayImageTask.options.getImageOnFail(), paramLoadAndDisplayImageTask.imageView);
    } while (paramLoadAndDisplayImageTask.listener == null);
    paramLoadAndDisplayImageTask.listener.onLoadingComplete(paramLoadAndDisplayImageTask.uri, paramLoadAndDisplayImageTask.imageView, null, paramLoadAndDisplayImageTask.mBitmapFrom);
  }
  
  private void displaySuccess(Bitmap paramBitmap, LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
  {
    if ((!paramLoadAndDisplayImageTask.checkIsValid()) || (paramBitmap == null)) {}
    for (;;)
    {
      return;
      paramLoadAndDisplayImageTask.options.getDisplayer().display(paramLoadAndDisplayImageTask.uri, paramBitmap, paramLoadAndDisplayImageTask.imageView);
      if (paramLoadAndDisplayImageTask.options.isPersistCache()) {
        if (!BNImageLoader.mPersistCache.containsKey(paramLoadAndDisplayImageTask.key)) {
          BNImageLoader.mPersistCache.put(paramLoadAndDisplayImageTask.key, paramBitmap);
        }
      }
      while (paramLoadAndDisplayImageTask.listener != null)
      {
        paramLoadAndDisplayImageTask.listener.onLoadingComplete(paramLoadAndDisplayImageTask.uri, paramLoadAndDisplayImageTask.imageView, paramBitmap, paramLoadAndDisplayImageTask.mBitmapFrom);
        return;
        if ((paramLoadAndDisplayImageTask.options.isCacheInMemory()) && (!paramLoadAndDisplayImageTask.sUrlCache.containsKey(paramLoadAndDisplayImageTask.key))) {
          paramLoadAndDisplayImageTask.sUrlCache.put(paramLoadAndDisplayImageTask.key, paramBitmap);
        }
      }
    }
  }
  
  boolean preparedBitmapLoad(String paramString, LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
  {
    if (paramLoadAndDisplayImageTask == null) {
      return false;
    }
    if (this.loadingImageSets == null) {
      this.loadingImageSets = new HashMap();
    }
    if (this.loadingImageSets.containsKey(paramString))
    {
      ((ImageInfoSet)this.loadingImageSets.get(paramString)).add(paramLoadAndDisplayImageTask);
      return false;
    }
    this.loadingImageSets.put(paramString, new ImageInfoSet(paramLoadAndDisplayImageTask));
    return true;
  }
  
  void removeBitmapLoad(String paramString)
  {
    if (this.loadingImageSets != null) {
      this.loadingImageSets.remove(paramString);
    }
  }
  
  void submit(final LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
  {
    if (paramLoadAndDisplayImageTask == null) {
      return;
    }
    BNWorkerCenter.getInstance().submitCallbackTask(new BNWorkerCallbackTask("BNImageLoaderEngine-submit", null)new BNWorkerConfig
    {
      public void callback(Bitmap paramAnonymousBitmap)
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("BNImageLoaderEngine-submit-2", paramAnonymousBitmap)new BNWorkerConfig
        {
          protected String execute()
          {
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (BNImageLoaderEngine.this.loadingImageSets != null)
            {
              BNImageLoaderEngine.ImageInfoSet localImageInfoSet = (BNImageLoaderEngine.ImageInfoSet)BNImageLoaderEngine.this.loadingImageSets.get(BNImageLoaderEngine.1.this.val$task.uri);
              localObject1 = localObject2;
              if (localImageInfoSet != null) {
                localObject1 = BNImageLoaderEngine.ImageInfoSet.access$100(localImageInfoSet);
              }
            }
            int i;
            if ((this.inData != null) && (!((Bitmap)this.inData).isRecycled()))
            {
              if (localObject1 != null)
              {
                i = 0;
                while (i < ((ArrayList)localObject1).size())
                {
                  BNImageLoaderEngine.this.displaySuccess((Bitmap)this.inData, (BNImageLoaderEngine.LoadAndDisplayImageTask)((ArrayList)localObject1).get(i));
                  i += 1;
                }
              }
              BNImageLoaderEngine.this.displaySuccess((Bitmap)this.inData, BNImageLoaderEngine.1.this.val$task);
            }
            for (;;)
            {
              BNImageLoaderEngine.this.removeBitmapLoad(BNImageLoaderEngine.1.this.val$task.uri);
              return null;
              if (localObject1 != null)
              {
                i = 0;
                while (i < ((ArrayList)localObject1).size())
                {
                  BNImageLoaderEngine.this.displayFail((BNImageLoaderEngine.LoadAndDisplayImageTask)((ArrayList)localObject1).get(i));
                  i += 1;
                }
              }
              else
              {
                BNImageLoaderEngine.this.displayFail(BNImageLoaderEngine.1.this.val$task);
              }
            }
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      protected Bitmap execute()
      {
        paramLoadAndDisplayImageTask.run();
        return paramLoadAndDisplayImageTask.getLoadedBitMap();
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  static class ImageInfoSet
  {
    private ArrayList<BNImageLoaderEngine.LoadAndDisplayImageTask> imageViewAList = new ArrayList();
    
    ImageInfoSet(BNImageLoaderEngine.LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
    {
      this.imageViewAList.add(paramLoadAndDisplayImageTask);
    }
    
    public void add(BNImageLoaderEngine.LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
    {
      this.imageViewAList.add(paramLoadAndDisplayImageTask);
    }
  }
  
  static class LoadAndDisplayImageTask
    implements Runnable
  {
    ImageView imageView;
    String key;
    String keyPath;
    BNImageLoadingListener listener;
    int mBitmapFrom;
    Bitmap mBmp;
    BNDisplayImageOptions options;
    ImageCache sUrlCache;
    String uri;
    
    LoadAndDisplayImageTask(String paramString1, String paramString2, String paramString3, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener, ImageCache paramImageCache)
    {
      this.keyPath = paramString2;
      this.uri = paramString3;
      this.imageView = paramImageView;
      this.options = paramBNDisplayImageOptions;
      this.listener = paramBNImageLoadingListener;
      this.sUrlCache = paramImageCache;
      this.key = paramString1;
    }
    
    private boolean checkIsValid()
    {
      return (this.uri != null) && (this.sUrlCache != null) && (this.options != null);
    }
    
    public Bitmap getLoadedBitMap()
    {
      return this.mBmp;
    }
    
    public void run()
    {
      if (!checkIsValid()) {
        return;
      }
      this.mBmp = ImageTools.getBitmapFromPath(this.keyPath);
      if (this.mBmp != null)
      {
        this.mBitmapFrom = 1;
        return;
      }
      try
      {
        new BaseHttpClient().get(this.uri, new BitmapRspHandler()
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            BNImageLoaderEngine.LoadAndDisplayImageTask.this.mBmp = null;
          }
          
          public void onRevBitmap(Bitmap paramAnonymousBitmap)
          {
            BNImageLoaderEngine.LoadAndDisplayImageTask.this.mBmp = paramAnonymousBitmap;
            if ((BNImageLoaderEngine.LoadAndDisplayImageTask.this.mBmp != null) && (BNImageLoaderEngine.LoadAndDisplayImageTask.this.options.isCacheOnDisk())) {
              BNImageLoaderEngine.LoadAndDisplayImageTask.this.sUrlCache.cache2Disk(BNImageLoaderEngine.LoadAndDisplayImageTask.this.keyPath, BNImageLoaderEngine.LoadAndDisplayImageTask.this.mBmp);
            }
          }
        });
        return;
      }
      catch (Exception localException)
      {
        this.mBmp = null;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/navimageloader/BNImageLoaderEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */