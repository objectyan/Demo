package com.baidu.navisdk.module.ugc.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions.Builder;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class UgcImageLoaderUtils
{
  private int getMainCacheIconKey(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    switch (paramInt)
    {
    case 8: 
    default: 
      return paramInt;
    case 5: 
      return 61445;
    case 4: 
      return 61444;
    case 9: 
      return 61449;
    case 10: 
      return 61450;
    case 6: 
      return 61446;
    }
    return 61447;
  }
  
  public boolean updateUgcViewOffline(int paramInt, ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Drawable localDrawable;
    do
    {
      return false;
      if (paramImageView == null) {
        break;
      }
      localDrawable = BNStyleManager.getDrawable(UgcDataProvider.getDrawableIdByType(paramInt));
    } while (localDrawable == null);
    paramImageView.setImageDrawable(localDrawable);
    return true;
  }
  
  public void updateUgcViewOnLine(int paramInt, ImageView paramImageView)
  {
    updateUgcViewOnLine(paramInt, paramImageView, null, null, null);
  }
  
  public void updateUgcViewOnLine(int paramInt, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions)
  {
    updateUgcViewOnLine(paramInt, paramImageView, paramBNDisplayImageOptions, null, null);
  }
  
  public void updateUgcViewOnLine(int paramInt, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener, String paramString)
  {
    if (paramImageView == null) {}
    BNDisplayImageOptions localBNDisplayImageOptions;
    do
    {
      return;
      localBNDisplayImageOptions = paramBNDisplayImageOptions;
      if (paramBNDisplayImageOptions == null) {
        localBNDisplayImageOptions = new BNDisplayImageOptions.Builder().showImageOnLoading(UgcDataProvider.getDrawableIdByType(paramInt)).build();
      }
      paramBNDisplayImageOptions = paramString;
      if (paramString == null) {
        paramBNDisplayImageOptions = UgcDataProvider.getUrlByType(paramInt);
      }
      if (!TextUtils.isEmpty(paramBNDisplayImageOptions)) {
        break;
      }
      updateUgcViewOffline(paramInt, paramImageView);
    } while (paramBNImageLoadingListener == null);
    paramBNImageLoadingListener.onLoadingComplete(paramBNDisplayImageOptions, paramImageView, null, 4);
    return;
    BNImageLoader.getInstance().displayImage(paramBNDisplayImageOptions, paramImageView, localBNDisplayImageOptions, paramBNImageLoadingListener);
  }
  
  public void updateUgcViewOnLine(int paramInt, ImageView paramImageView, BNImageLoadingListener paramBNImageLoadingListener)
  {
    updateUgcViewOnLine(paramInt, paramImageView, null, paramBNImageLoadingListener, null);
  }
  
  public void updateUgcViewOnLine(int paramInt, ImageView paramImageView, String paramString)
  {
    updateUgcViewOnLine(paramInt, paramImageView, null, null, paramString);
  }
  
  public void updateUgcViewOnLine(boolean paramBoolean, int paramInt, ImageView paramImageView)
  {
    updateUgcViewOnLine(paramBoolean, paramInt, paramImageView, null, null, null);
  }
  
  public void updateUgcViewOnLine(boolean paramBoolean, int paramInt, ImageView paramImageView, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener, String paramString)
  {
    if (paramImageView == null) {}
    BNDisplayImageOptions localBNDisplayImageOptions;
    do
    {
      return;
      localBNDisplayImageOptions = paramBNDisplayImageOptions;
      if (paramBNDisplayImageOptions == null) {
        localBNDisplayImageOptions = new BNDisplayImageOptions.Builder().showImageOnLoading(UgcDataProvider.getDrawableIdByType(getMainCacheIconKey(paramInt, paramBoolean))).build();
      }
      paramBNDisplayImageOptions = paramString;
      if (paramString == null) {
        paramBNDisplayImageOptions = UgcDataProvider.getUrlByType(getMainCacheIconKey(paramInt, paramBoolean));
      }
      if (!TextUtils.isEmpty(paramBNDisplayImageOptions)) {
        break;
      }
      updateUgcViewOffline(getMainCacheIconKey(paramInt, paramBoolean), paramImageView);
    } while (paramBNImageLoadingListener == null);
    paramBNImageLoadingListener.onLoadingComplete(paramBNDisplayImageOptions, paramImageView, null, 4);
    return;
    BNImageLoader.getInstance().displayImage(paramBNDisplayImageOptions, paramImageView, localBNDisplayImageOptions, paramBNImageLoadingListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/utils/UgcImageLoaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */