package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import java.util.HashMap;

public class UrlDrawable
  extends Drawable
{
  private static final int K_CACHE_CAPACITY = 80;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/urlpic";
  private static final int K_DEFAULT_HEIGHT = 100;
  private static final int K_DEFAULT_WIDTH = 100;
  public static Bitmap mDefaultBitmap;
  public static Bitmap mFailedBitmap;
  private static boolean mHasInit = false;
  private static HashMap<String, UrlDrawable> mLoadingMap = new HashMap();
  public static ImageCache sUrlCache;
  private Drawable mCurrent = new BitmapDrawable(mDefaultBitmap);
  private boolean mNeedSqureBound = true;
  
  private UrlDrawable(final String paramString1, final String paramString2)
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
              UrlDrawable.1.this.mBmp = null;
            }
            
            public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
            {
              UrlDrawable.1.this.mBmp = paramAnonymous2Bitmap;
              if (UrlDrawable.1.this.mBmp != null) {
                UrlDrawable.sUrlCache.cache2Disk(UrlDrawable.1.this.val$keyPath, UrlDrawable.1.this.mBmp);
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
        if (paramAnonymousBitmap != null)
        {
          UrlDrawable.sUrlCache.put(paramString2, this.mBmp);
          localObject = (UrlDrawable)UrlDrawable.mLoadingMap.remove(paramString2);
          if (localObject != null) {}
        }
        do
        {
          return;
          UrlDrawable.access$102(UrlDrawable.this, false);
          paramAnonymousBitmap = PathDrawable.getDrawable(paramString2, paramAnonymousBitmap, UrlDrawable.sUrlCache);
          paramAnonymousBitmap.setBounds(((UrlDrawable)localObject).mCurrent.getBounds());
          UrlDrawable.access$202((UrlDrawable)localObject, paramAnonymousBitmap);
          ((UrlDrawable)localObject).invalidateSelf();
          return;
          paramAnonymousBitmap = (UrlDrawable)UrlDrawable.mLoadingMap.remove(paramString2);
        } while (paramAnonymousBitmap == null);
        UrlDrawable.access$102(UrlDrawable.this, true);
        Object localObject = new BitmapDrawable(UrlDrawable.mFailedBitmap);
        ((Drawable)localObject).setBounds(ImageTools.calcSquareRect(paramAnonymousBitmap.mCurrent.getBounds()));
        UrlDrawable.access$202(paramAnonymousBitmap, (Drawable)localObject);
        paramAnonymousBitmap.invalidateSelf();
      }
    }.execute(new String[] { "" });
  }
  
  public static Drawable getDrawable(String paramString)
  {
    
    Object localObject;
    if (paramString == null) {
      localObject = new BitmapDrawable(mDefaultBitmap);
    }
    String str;
    UrlDrawable localUrlDrawable;
    do
    {
      return (Drawable)localObject;
      str = sUrlCache.getCachePath(paramString);
      localObject = sUrlCache.get(str);
      if (localObject != null) {
        return PathDrawable.getDrawable(str, (Bitmap)localObject, sUrlCache);
      }
      localUrlDrawable = (UrlDrawable)mLoadingMap.get(str);
      localObject = localUrlDrawable;
    } while (localUrlDrawable != null);
    paramString = new UrlDrawable(paramString, str);
    mLoadingMap.put(str, paramString);
    return paramString;
  }
  
  private static void init()
  {
    try
    {
      if (!mHasInit)
      {
        sUrlCache = new ImageCache(K_DEFAULT_CACHE_PATH, 80);
        mDefaultBitmap = ImageTools.getBitmapFromResId(1711408146);
        mFailedBitmap = ImageTools.getBitmapFromResId(1711408146);
      }
      mHasInit = true;
      return;
    }
    finally {}
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mCurrent != null) {
      this.mCurrent.draw(paramCanvas);
    }
  }
  
  public Drawable getCurrent()
  {
    return this.mCurrent;
  }
  
  public int getOpacity()
  {
    if (this.mCurrent != null) {
      return this.mCurrent.getOpacity();
    }
    return -2;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    if (this.mCurrent != null)
    {
      if (!this.mNeedSqureBound) {
        break label31;
      }
      this.mCurrent.setBounds(ImageTools.calcSquareRect(paramRect));
    }
    for (;;)
    {
      super.onBoundsChange(paramRect);
      return;
      label31:
      this.mCurrent.setBounds(paramRect);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mCurrent != null) {
      this.mCurrent.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mCurrent != null) {
      this.mCurrent.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/UrlDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */