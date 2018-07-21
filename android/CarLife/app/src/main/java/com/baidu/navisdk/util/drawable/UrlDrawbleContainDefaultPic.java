package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import com.baidu.navisdk.util.http.BaseHttpClient;
import com.baidu.navisdk.util.http.BitmapRspHandler;
import java.util.HashMap;

public class UrlDrawbleContainDefaultPic
  extends Drawable
{
  private static final int K_CACHE_CAPACITY = 80;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/ugcurlpic";
  private static boolean mHasInit = false;
  private static HashMap<String, UrlDrawbleContainDefaultPic> mLoadingMap = new HashMap();
  public static ImageCache sUrlCache;
  private Drawable mCurrent;
  private boolean mNeedSqureBound = true;
  
  private UrlDrawbleContainDefaultPic(final String paramString1, final String paramString2, int paramInt)
  {
    this.mCurrent = BNStyleManager.getDrawable(paramInt);
    this.mNeedSqureBound = true;
    if (this.mCurrent == null) {
      this.mCurrent = new BitmapDrawable(ImageTools.getBitmapFromResId(1711408123));
    }
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
              UrlDrawbleContainDefaultPic.1.this.mBmp = null;
            }
            
            public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
            {
              UrlDrawbleContainDefaultPic.1.this.mBmp = paramAnonymous2Bitmap;
              if (UrlDrawbleContainDefaultPic.1.this.mBmp != null) {
                UrlDrawbleContainDefaultPic.sUrlCache.cache2Disk(UrlDrawbleContainDefaultPic.1.this.val$keyPath, UrlDrawbleContainDefaultPic.1.this.mBmp);
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
          UrlDrawbleContainDefaultPic.sUrlCache.put(paramString2, this.mBmp);
          UrlDrawbleContainDefaultPic localUrlDrawbleContainDefaultPic = (UrlDrawbleContainDefaultPic)UrlDrawbleContainDefaultPic.mLoadingMap.remove(paramString2);
          if (localUrlDrawbleContainDefaultPic == null) {
            return;
          }
          UrlDrawbleContainDefaultPic.access$102(UrlDrawbleContainDefaultPic.this, false);
          paramAnonymousBitmap = PathDrawable.getDrawable(paramString2, paramAnonymousBitmap, UrlDrawbleContainDefaultPic.sUrlCache);
          paramAnonymousBitmap.setBounds(localUrlDrawbleContainDefaultPic.mCurrent.getBounds());
          UrlDrawbleContainDefaultPic.access$202(localUrlDrawbleContainDefaultPic, paramAnonymousBitmap);
          localUrlDrawbleContainDefaultPic.invalidateSelf();
          return;
        }
        UrlDrawbleContainDefaultPic.mLoadingMap.remove(paramString2);
      }
    }.execute(new String[] { "" });
  }
  
  public static Drawable getDrawable(String paramString, int paramInt)
  {
    
    Object localObject;
    if (paramString == null) {
      localObject = BNStyleManager.getDrawable(paramInt);
    }
    String str;
    UrlDrawbleContainDefaultPic localUrlDrawbleContainDefaultPic;
    do
    {
      return (Drawable)localObject;
      str = sUrlCache.getCachePath(paramString);
      localObject = sUrlCache.get(str);
      if (localObject != null) {
        return PathDrawable.getDrawable(str, (Bitmap)localObject, sUrlCache);
      }
      localUrlDrawbleContainDefaultPic = (UrlDrawbleContainDefaultPic)mLoadingMap.get(str);
      localObject = localUrlDrawbleContainDefaultPic;
    } while (localUrlDrawbleContainDefaultPic != null);
    paramString = new UrlDrawbleContainDefaultPic(paramString, str, paramInt);
    mLoadingMap.put(str, paramString);
    return paramString;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/UrlDrawbleContainDefaultPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */