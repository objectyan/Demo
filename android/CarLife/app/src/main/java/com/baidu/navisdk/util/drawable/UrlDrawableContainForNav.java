package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
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

public class UrlDrawableContainForNav
{
  private static final int K_CACHE_CAPACITY = 80;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/naving";
  public static final int RET_FAILED = 1;
  public static final int RET_SUCCESS = 0;
  public static final int WHAT_MSG_DOWNLOAD_COMPLETED = 8192;
  private static boolean mHasInit = false;
  public static ImageCache sUrlCache;
  
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
              UrlDrawableContainForNav.1.this.mBmp = null;
            }
            
            public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
            {
              UrlDrawableContainForNav.1.this.mBmp = paramAnonymous2Bitmap;
              if (UrlDrawableContainForNav.1.this.mBmp != null) {
                UrlDrawableContainForNav.sUrlCache.cache2Disk(UrlDrawableContainForNav.1.this.val$keyPath, UrlDrawableContainForNav.1.this.mBmp);
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
          UrlDrawableContainForNav.sUrlCache.put(this.val$keyPath, this.mBmp);
          paramImageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), this.mBmp));
          if (paramHandler != null) {
            UrlDrawableContainForNav.onDownloadCompletedCallBack(paramString1, paramHandler, 0);
          }
        }
        while (paramHandler == null) {
          return;
        }
        UrlDrawableContainForNav.onDownloadCompletedCallBack(paramString1, paramHandler, 1);
      }
    }.execute(new String[] { "" });
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
        try
        {
          UrlSrcDrawableView(paramString, str, paramImageView, paramHandler);
          return;
        }
        catch (Throwable paramString)
        {
          LogUtil.e("UrlDrawableContainForNav", "crash:" + paramString.getMessage());
          return;
        }
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/UrlDrawableContainForNav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */