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
import java.io.File;
import java.util.HashMap;

public class PathDrawable
  extends Drawable
{
  private static final int K_CACHE_CAPACITY = 80;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/icons";
  private static Bitmap mDefaultBitmap;
  private static boolean mHasInit = false;
  private static HashMap<String, PathDrawable> mLoadingMap = new HashMap();
  private static ImageCache sIconCache;
  private Drawable mCurrent;
  private ImageCache mImageCache;
  private String mKeyPath;
  
  private PathDrawable(String paramString, Bitmap paramBitmap, ImageCache paramImageCache)
  {
    this.mKeyPath = paramString;
    this.mImageCache = paramImageCache;
    this.mCurrent = new BitmapDrawable(paramBitmap);
  }
  
  private PathDrawable(String paramString, ImageCache paramImageCache)
  {
    this.mKeyPath = paramString;
    this.mImageCache = paramImageCache;
    this.mCurrent = new BitmapDrawable(mDefaultBitmap);
    new UserTask()
    {
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        return ImageTools.getBitmapFromPath(PathDrawable.this.mKeyPath);
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        PathDrawable localPathDrawable;
        if (paramAnonymousBitmap != null)
        {
          PathDrawable.this.mImageCache.put(PathDrawable.this.mKeyPath, paramAnonymousBitmap);
          localPathDrawable = (PathDrawable)PathDrawable.mLoadingMap.remove(PathDrawable.this.mKeyPath);
          if (localPathDrawable != null) {}
        }
        else
        {
          return;
        }
        paramAnonymousBitmap = new BitmapDrawable(paramAnonymousBitmap);
        paramAnonymousBitmap.setBounds(localPathDrawable.mCurrent.getBounds());
        PathDrawable.access$302(localPathDrawable, paramAnonymousBitmap);
        localPathDrawable.invalidateSelf();
      }
    }.execute(new String[] { "" });
  }
  
  private void changeBitmap()
  {
    this.mCurrent = new BitmapDrawable(mDefaultBitmap);
    new UserTask()
    {
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        return ImageTools.getBitmapFromPath(PathDrawable.this.mKeyPath);
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null)
        {
          PathDrawable.this.mImageCache.put(PathDrawable.this.mKeyPath, paramAnonymousBitmap);
          paramAnonymousBitmap = new BitmapDrawable(paramAnonymousBitmap);
          paramAnonymousBitmap.setBounds(PathDrawable.this.mCurrent.getBounds());
          PathDrawable.access$302(PathDrawable.this, paramAnonymousBitmap);
          PathDrawable.this.invalidateSelf();
        }
      }
    }.execute(new String[] { "" });
  }
  
  public static String getCachePath()
  {
    File localFile = new File(K_DEFAULT_CACHE_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return K_DEFAULT_CACHE_PATH;
  }
  
  public static Drawable getDrawable(String paramString)
  {
    return getDrawable(paramString, null, null);
  }
  
  public static Drawable getDrawable(String paramString, Bitmap paramBitmap, ImageCache paramImageCache)
  {
    
    if (paramString == null) {
      return new BitmapDrawable(mDefaultBitmap);
    }
    ImageCache localImageCache = paramImageCache;
    if (paramImageCache == null) {
      localImageCache = sIconCache;
    }
    paramImageCache = paramBitmap;
    if (paramBitmap == null) {
      paramImageCache = localImageCache.get(paramString);
    }
    if (paramImageCache != null) {}
    for (paramBitmap = new PathDrawable(paramString, paramImageCache, localImageCache);; paramBitmap = new PathDrawable(paramString, localImageCache))
    {
      mLoadingMap.put(paramString, paramBitmap);
      return paramBitmap;
    }
  }
  
  private static void init()
  {
    try
    {
      if (!mHasInit)
      {
        sIconCache = new ImageCache(getCachePath(), 80);
        mDefaultBitmap = ImageTools.getBitmapFromResId(1711408146);
      }
      mHasInit = true;
      return;
    }
    finally {}
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (((BitmapDrawable)this.mCurrent).getBitmap().isRecycled())
    {
      changeBitmap();
      return;
    }
    this.mCurrent.draw(paramCanvas);
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
    if (this.mCurrent != null) {
      this.mCurrent.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/PathDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */