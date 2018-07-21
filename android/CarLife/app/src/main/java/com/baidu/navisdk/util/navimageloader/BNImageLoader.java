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

public class BNImageLoader
{
  private static final String KEY_IMAGEVIEW = "key.imageview";
  private static final String KEY_RES = "key.res";
  private static final String KEY_URL = "key.url";
  private static final int K_CACHE_CAPACITY = 50;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurliview";
  private static volatile BNImageLoader instance;
  public static HashMap<String, Bitmap> mPersistCache = new HashMap();
  private BNBitmapDisplayer defaultBitmapDisplayer;
  private BNImageLoadingListener defaultImageLoadingListener;
  private BNDisplayImageOptions defaultOptions;
  private BNImageLoaderEngine engine;
  private Handler mainHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {}
      Object localObject1;
      label122:
      do
      {
        Object localObject2;
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject2 = (Map)paramAnonymousMessage.obj;
              localObject1 = (String)((Map)localObject2).get("key.url");
              paramAnonymousMessage = (ImageView)((Map)localObject2).get("key.imageview");
              localObject2 = ((Map)localObject2).get("key.res");
              if (!(localObject2 instanceof Bitmap)) {
                break label122;
              }
              localObject2 = (Bitmap)localObject2;
              if ((localObject2 != null) && (paramAnonymousMessage != null)) {
                if (paramAnonymousMessage.getTag() != null)
                {
                  if (!paramAnonymousMessage.getTag().equals(localObject1)) {
                    continue;
                  }
                  paramAnonymousMessage.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), (Bitmap)localObject2));
                }
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              paramAnonymousMessage.printStackTrace();
              return;
            }
          }
          paramAnonymousMessage.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), (Bitmap)localObject2));
          return;
        } while (!(localObject2 instanceof Drawable));
        localObject1 = (Drawable)localObject2;
      } while ((paramAnonymousMessage == null) || (localObject1 == null));
      paramAnonymousMessage.setImageDrawable((Drawable)localObject1);
    }
  };
  public ImageCache sUrlCache;
  
  private BNDisplayImageOptions createDefaultDisplayImageOptions()
  {
    if (this.defaultOptions != null) {
      return this.defaultOptions;
    }
    this.defaultOptions = new BNDisplayImageOptions.Builder().build();
    return this.defaultOptions;
  }
  
  private Bitmap getAndProceesBitmapFromCache(String paramString)
  {
    Object localObject2 = this.sUrlCache.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((Bitmap)localObject2).isRecycled())
      {
        this.sUrlCache.remove(paramString);
        localObject1 = null;
      }
    }
    Bitmap localBitmap = (Bitmap)mPersistCache.get(paramString);
    localObject2 = localBitmap;
    if (localBitmap != null)
    {
      localObject2 = localBitmap;
      if (((Bitmap)localObject1).isRecycled())
      {
        mPersistCache.remove(paramString);
        localObject2 = null;
      }
    }
    if (localObject1 == null) {
      return (Bitmap)localObject2;
    }
    return (Bitmap)localObject1;
  }
  
  public static BNImageLoader getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BNImageLoader();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean hasInit()
  {
    return (this.engine != null) && (this.sUrlCache != null) && (mPersistCache != null);
  }
  
  private void init()
  {
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
  
  BNBitmapDisplayer createBitmapDisplayer()
  {
    if (this.defaultBitmapDisplayer == null) {
      this.defaultBitmapDisplayer = new BNBitmapDisplayer()
      {
        public void display(String paramAnonymousString, Bitmap paramAnonymousBitmap, ImageView paramAnonymousImageView)
        {
          Message localMessage;
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (BNImageLoader.this.mainHandler != null)
            {
              localMessage = BNImageLoader.this.mainHandler.obtainMessage();
              HashMap localHashMap = new HashMap(5);
              localHashMap.put("key.url", paramAnonymousString);
              localHashMap.put("key.imageview", paramAnonymousImageView);
              localHashMap.put("key.res", paramAnonymousBitmap);
              localMessage.obj = localHashMap;
            }
          }
          do
          {
            BNImageLoader.this.mainHandler.sendMessage(localMessage);
            do
            {
              return;
            } while ((paramAnonymousBitmap == null) || (paramAnonymousImageView == null));
            if (paramAnonymousImageView.getTag() == null) {
              break;
            }
          } while (!paramAnonymousImageView.getTag().equals(paramAnonymousString));
          paramAnonymousImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), paramAnonymousBitmap));
          return;
          paramAnonymousImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), paramAnonymousBitmap));
        }
        
        public void display(String paramAnonymousString, Drawable paramAnonymousDrawable, ImageView paramAnonymousImageView)
        {
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (BNImageLoader.this.mainHandler != null)
            {
              localMessage = BNImageLoader.this.mainHandler.obtainMessage();
              localHashMap = new HashMap(5);
              localHashMap.put("key.url", paramAnonymousString);
              localHashMap.put("key.imageview", paramAnonymousImageView);
              localHashMap.put("key.res", paramAnonymousDrawable);
              localMessage.obj = localHashMap;
              BNImageLoader.this.mainHandler.sendMessage(localMessage);
            }
          }
          while ((paramAnonymousImageView == null) || (paramAnonymousDrawable == null))
          {
            Message localMessage;
            HashMap localHashMap;
            return;
          }
          paramAnonymousImageView.setImageDrawable(paramAnonymousDrawable);
        }
      };
    }
    return this.defaultBitmapDisplayer;
  }
  
  BNImageLoadingListener createImageLoadingListener()
  {
    if (this.defaultImageLoadingListener == null) {
      this.defaultImageLoadingListener = new BNImageLoadingListener()
      {
        public void onLoadingComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, int paramAnonymousInt) {}
        
        public void onLoadingFailed(String paramAnonymousString1, View paramAnonymousView, String paramAnonymousString2) {}
        
        public void onLoadingStarted(String paramAnonymousString, View paramAnonymousView) {}
      };
    }
    return this.defaultImageLoadingListener;
  }
  
  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, paramImageView, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions)
  {
    displayImage(paramString, paramImageView, paramBNDisplayImageOptions, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener)
  {
    if (paramImageView == null) {}
    BNDisplayImageOptions localBNDisplayImageOptions;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        localBNDisplayImageOptions = paramBNDisplayImageOptions;
        if (paramBNDisplayImageOptions == null) {
          localBNDisplayImageOptions = createDefaultDisplayImageOptions();
        }
        paramBNDisplayImageOptions = paramBNImageLoadingListener;
        if (paramBNImageLoadingListener == null) {
          paramBNDisplayImageOptions = createImageLoadingListener();
        }
        if (!hasInit()) {
          init();
        }
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        if (paramBNDisplayImageOptions != null) {
          paramBNDisplayImageOptions.onLoadingStarted(paramString, paramImageView);
        }
        localBNDisplayImageOptions.getDisplayer().display(null, localBNDisplayImageOptions.getImageOnFail(), paramImageView);
      } while (paramBNDisplayImageOptions == null);
      paramBNDisplayImageOptions.onLoadingComplete(paramString, paramImageView, null, 4);
      return;
      paramBNImageLoadingListener = this.sUrlCache.getFileNameForKey(paramString);
      localBitmap = getAndProceesBitmapFromCache(paramBNImageLoadingListener);
      if (paramBNDisplayImageOptions != null) {
        paramBNDisplayImageOptions.onLoadingStarted(paramString, paramImageView);
      }
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break;
      }
      localBNDisplayImageOptions.getDisplayer().display(paramString, localBitmap, paramImageView);
    } while (paramBNDisplayImageOptions == null);
    paramBNDisplayImageOptions.onLoadingComplete(paramString, paramImageView, localBitmap, 0);
    return;
    localBNDisplayImageOptions.getDisplayer().display(paramString, localBNDisplayImageOptions.getImageOnLoading(), paramImageView);
    paramImageView = new BNImageLoaderEngine.LoadAndDisplayImageTask(paramBNImageLoadingListener, this.sUrlCache.getCachePath(paramString), paramString, paramImageView, localBNDisplayImageOptions, paramBNDisplayImageOptions, this.sUrlCache);
    if (localBNDisplayImageOptions.isSyncLoading())
    {
      paramImageView.mBitmapFrom = 3;
      paramImageView.run();
      return;
    }
    if (!this.engine.preparedBitmapLoad(paramString, paramImageView))
    {
      paramImageView.mBitmapFrom = 2;
      return;
    }
    paramImageView.mBitmapFrom = 3;
    this.engine.submit(paramImageView);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, BNImageLoadingListener paramBNImageLoadingListener)
  {
    displayImage(paramString, paramImageView, null, paramBNImageLoadingListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/navimageloader/BNImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */