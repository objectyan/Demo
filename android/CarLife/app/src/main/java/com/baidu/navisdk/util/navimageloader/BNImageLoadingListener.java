package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface BNImageLoadingListener
{
  public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap, int paramInt);
  
  public abstract void onLoadingFailed(String paramString1, View paramView, String paramString2);
  
  public abstract void onLoadingStarted(String paramString, View paramView);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/navimageloader/BNImageLoadingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */