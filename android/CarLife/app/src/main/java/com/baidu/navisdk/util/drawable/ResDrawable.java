package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.util.cache.ImageCache;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.common.UserTask;
import java.io.File;
import java.util.HashMap;

public class ResDrawable
  extends Drawable
{
  private static final int K_CACHE_CAPACITY_L = 2;
  private static final int K_CACHE_CAPACITY_S = 5;
  private static final String K_DEFAULT_CACHE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ImageCache/icons";
  private static Bitmap mDefaultBitmap;
  private static boolean mHasInit = false;
  private static HashMap<String, ResDrawable> mLoadingMap = new HashMap();
  private static ImageCache sImageCacheL;
  private static ImageCache sImageCacheS;
  private Drawable mCurrent;
  private ImageCache mImageCacheL;
  private ImageCache mImageCacheS;
  private int mResId;
  
  private ResDrawable(int paramInt)
  {
    this.mResId = paramInt;
    this.mImageCacheL = sImageCacheL;
    this.mImageCacheS = sImageCacheS;
    changeBitmap();
  }
  
  private ResDrawable(int paramInt, Bitmap paramBitmap)
  {
    this.mResId = paramInt;
    this.mImageCacheL = sImageCacheL;
    this.mImageCacheS = sImageCacheS;
    this.mCurrent = new BitmapDrawable(paramBitmap);
  }
  
  private void changeBitmap()
  {
    this.mCurrent = new BitmapDrawable(mDefaultBitmap);
    new UserTask()
    {
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        return ImageTools.getBitmapFromResId(ResDrawable.this.mResId);
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null)
        {
          if ((paramAnonymousBitmap.getHeight() <= ScreenUtil.getInstance().getHeightPixels() / 2) && (paramAnonymousBitmap.getWidth() <= ScreenUtil.getInstance().getWidthPixels() / 2)) {
            break label111;
          }
          ResDrawable.this.mImageCacheL.put(ResDrawable.this.mResId + "", paramAnonymousBitmap);
        }
        ResDrawable localResDrawable;
        for (;;)
        {
          localResDrawable = (ResDrawable)ResDrawable.mLoadingMap.remove(ResDrawable.this.mResId + "");
          if (localResDrawable != null) {
            break;
          }
          return;
          label111:
          ResDrawable.this.mImageCacheS.put(ResDrawable.this.mResId + "", paramAnonymousBitmap);
        }
        paramAnonymousBitmap = new BitmapDrawable(paramAnonymousBitmap);
        paramAnonymousBitmap.setBounds(localResDrawable.mCurrent.getBounds());
        ResDrawable.access$402(localResDrawable, paramAnonymousBitmap);
        localResDrawable.invalidateSelf();
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
  
  public static Drawable getDrawable(int paramInt)
  {
    init();
    ImageCache localImageCache = sImageCacheL;
    Bitmap localBitmap = localImageCache.get(sImageCacheL);
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = localImageCache.get(sImageCacheS);
    }
    if (localObject != null) {}
    for (localObject = new ResDrawable(paramInt, (Bitmap)localObject);; localObject = new ResDrawable(paramInt))
    {
      mLoadingMap.put(paramInt + "", localObject);
      return (Drawable)localObject;
    }
  }
  
  private static void init()
  {
    try
    {
      if (!mHasInit)
      {
        sImageCacheS = new ImageCache(getCachePath(), 5);
        sImageCacheL = new ImageCache(getCachePath(), 2);
        mDefaultBitmap = ImageTools.getBitmapFromResId(1711407110);
      }
      mHasInit = true;
      return;
    }
    finally {}
  }
  
  public static void recycle()
  {
    try
    {
      if (sImageCacheS != null) {
        sImageCacheS.clear();
      }
      if (sImageCacheL != null) {
        sImageCacheL.clear();
      }
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/ResDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */