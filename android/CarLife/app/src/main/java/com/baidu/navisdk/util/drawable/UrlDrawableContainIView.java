package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
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

public class UrlDrawableContainIView
{
  private static final int K_CACHE_CAPACITY = 80;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurliview";
  public static final int RET_FAILED = 1;
  public static final int RET_SUCCESS = 0;
  public static final int WHAT_MSG_DOWNLOAD_COMPLETED = 8192;
  private static boolean mHasInit = false;
  private static Bitmap mPersistBitmap = null;
  private static String mPersistKey = null;
  public static ImageCache sUrlCache;
  private boolean mNeedSqureBound = true;
  
  private UrlDrawableContainIView(final String paramString1, final String paramString2, final ImageView paramImageView, final Handler paramHandler)
  {
    new UserTask()
    {
      Bitmap mBmp;
      
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        this.mBmp = ImageTools.getBitmapFromPath(paramString2);
        if (this.mBmp != null) {
          return this.mBmp;
        }
        try
        {
          new BaseHttpClient().get(paramString1, new BitmapRspHandler()
          {
            public void onFailure(Throwable paramAnonymous2Throwable)
            {
              UrlDrawableContainIView.1.this.mBmp = null;
            }
            
            public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
            {
              UrlDrawableContainIView.1.this.mBmp = paramAnonymous2Bitmap;
              if (UrlDrawableContainIView.1.this.mBmp != null) {
                UrlDrawableContainIView.sUrlCache.cache2Disk(UrlDrawableContainIView.1.this.val$keyPath, UrlDrawableContainIView.1.this.mBmp);
              }
            }
          });
          return this.mBmp;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          for (;;)
          {
            this.mBmp = null;
          }
        }
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          if (!paramString2.equals(UrlDrawableContainIView.mPersistKey))
          {
            UrlDrawableContainIView.sUrlCache.put(paramString2, this.mBmp);
            paramImageView.setBackgroundDrawable(new BitmapDrawable(this.mBmp));
            if (paramHandler != null) {
              UrlDrawableContainIView.onDownloadCompletedCallBack(paramString1, paramHandler, 0);
            }
            LogUtil.e("caizhirui", "get new");
          }
        }
        while (paramHandler == null) {
          for (;;)
          {
            return;
            UrlDrawableContainIView.access$102(this.mBmp);
            paramImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
          }
        }
        UrlDrawableContainIView.onDownloadCompletedCallBack(paramString1, paramHandler, 1);
      }
    }.execute(new String[] { "" });
  }
  
  private static void UrlSrcDrawableView(final String paramString1, String paramString2, final ImageView paramImageView, final Handler paramHandler)
  {
    new UserTask()
    {
      Bitmap mBmp;
      
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        this.mBmp = ImageTools.getBitmapFromPath(this.val$keyPath);
        if (this.mBmp != null) {
          return this.mBmp;
        }
        try
        {
          new BaseHttpClient().get(paramString1, new BitmapRspHandler()
          {
            public void onFailure(Throwable paramAnonymous2Throwable)
            {
              UrlDrawableContainIView.2.this.mBmp = null;
            }
            
            public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
            {
              UrlDrawableContainIView.2.this.mBmp = paramAnonymous2Bitmap;
              if (UrlDrawableContainIView.2.this.mBmp != null) {
                UrlDrawableContainIView.sUrlCache.cache2Disk(UrlDrawableContainIView.2.this.val$keyPath, UrlDrawableContainIView.2.this.mBmp);
              }
            }
          });
          return this.mBmp;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          for (;;)
          {
            this.mBmp = null;
          }
        }
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          UrlDrawableContainIView.sUrlCache.put(this.val$keyPath, this.mBmp);
          paramImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
          if (paramHandler != null) {
            UrlDrawableContainIView.onDownloadCompletedCallBack(paramString1, paramHandler, 0);
          }
        }
        while (paramHandler == null) {
          return;
        }
        UrlDrawableContainIView.onDownloadCompletedCallBack(paramString1, paramHandler, 1);
      }
    }.execute(new String[] { "" });
  }
  
  public static void getDrawable(String paramString, int paramInt, ImageView paramImageView, Handler paramHandler)
  {
    getDrawable(paramString, paramInt, paramImageView, paramHandler, false);
  }
  
  public static void getDrawable(String paramString, int paramInt, ImageView paramImageView, Handler paramHandler, boolean paramBoolean)
  {
    if (paramImageView == null) {
      return;
    }
    init();
    if (paramString == null)
    {
      paramHandler = BNStyleManager.getDrawable(paramInt);
      paramString = paramHandler;
      if (paramHandler == null) {
        paramString = new BitmapDrawable(ImageTools.getBitmapFromResId(1711408123));
      }
      paramImageView.setBackgroundDrawable(paramString);
      LogUtil.e("caizhirui", "url == null");
      return;
    }
    String str = sUrlCache.getCachePath(paramString);
    Object localObject;
    if (!str.equals(mPersistKey))
    {
      localObject = sUrlCache.get(str);
      if ((localObject != null) && (((Bitmap)localObject).isRecycled()))
      {
        sUrlCache.remove(localObject);
        label101:
        Drawable localDrawable = BNStyleManager.getDrawable(paramInt);
        localObject = localDrawable;
        if (localDrawable == null) {
          localObject = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(1711408123));
        }
        if (str.equals(mPersistKey)) {
          break label280;
        }
        paramImageView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    for (;;)
    {
      LogUtil.e("caizhirui", "use default");
      new UrlDrawableContainIView(paramString, str, paramImageView, paramHandler);
      return;
      if (localObject == null) {
        break label101;
      }
      if (paramBoolean) {
        paramImageView.setImageDrawable(zoomDrawable((Bitmap)localObject, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), true));
      }
      for (;;)
      {
        LogUtil.e("caizhirui", "in memory cache");
        if (paramHandler == null) {
          break;
        }
        onDownloadCompletedCallBack(paramString, paramHandler, 0);
        return;
        paramImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
      }
      if ((mPersistBitmap == null) || (mPersistBitmap.isRecycled())) {
        break label101;
      }
      paramImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), mPersistBitmap));
      if (paramHandler == null) {
        break;
      }
      onDownloadCompletedCallBack(paramString, paramHandler, 0);
      return;
      label280:
      paramImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  public static void getSrcDrawable(String paramString, int paramInt, ImageView paramImageView, Handler paramHandler)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      if (StringUtils.isEmpty(paramString))
      {
        paramHandler = BNStyleManager.getDrawable(paramInt);
        paramString = paramHandler;
        if (paramHandler == null) {
          paramString = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(1711407525));
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      init();
      String str = sUrlCache.getCachePath(paramString);
      Object localObject = sUrlCache.get(str);
      if ((localObject != null) && (((Bitmap)localObject).isRecycled())) {
        sUrlCache.remove(localObject);
      }
      while (localObject == null)
      {
        Drawable localDrawable = BNStyleManager.getDrawable(paramInt);
        localObject = localDrawable;
        if (localDrawable == null) {
          localObject = new BitmapDrawable(JarUtils.getResources(), ImageTools.getBitmapFromResId(1711407525));
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        UrlSrcDrawableView(paramString, str, paramImageView, paramHandler);
        return;
      }
      paramImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), (Bitmap)localObject));
    } while (paramHandler == null);
    onDownloadCompletedCallBack(paramString, paramHandler, 0);
  }
  
  private static void init()
  {
    try
    {
      if (!mHasInit) {
        sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
      }
      mHasInit = true;
      return;
    }
    finally {}
  }
  
  private static void onDownloadCompletedCallBack(String paramString, Handler paramHandler, int paramInt)
  {
    if (paramHandler != null)
    {
      Message localMessage = paramHandler.obtainMessage();
      localMessage.what = 8192;
      localMessage.arg1 = paramInt;
      localMessage.obj = paramString;
      paramHandler.sendMessage(localMessage);
    }
  }
  
  public static void recycleBitmap()
  {
    if (sUrlCache != null) {
      sUrlCache.clear();
    }
  }
  
  public static void setPersistKey(String paramString)
  {
    if (paramString != null)
    {
      init();
      mPersistKey = sUrlCache.getCachePath(paramString);
    }
  }
  
  private static Drawable zoomDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    float f1 = paramInt1 / paramBitmap.getWidth();
    float f2 = paramInt2 / paramBitmap.getHeight();
    float f3 = f2;
    float f4 = f1;
    if (paramBoolean)
    {
      if (f2 >= f1) {
        break label98;
      }
      f4 = f2;
      f3 = f2;
    }
    for (;;)
    {
      localMatrix.postScale(f4, f3);
      return new BitmapDrawable(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true));
      label98:
      f3 = f1;
      f4 = f1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/UrlDrawableContainIView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */