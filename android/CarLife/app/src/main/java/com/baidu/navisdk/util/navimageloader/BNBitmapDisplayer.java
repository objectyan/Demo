package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public abstract interface BNBitmapDisplayer
{
  public abstract void display(String paramString, Bitmap paramBitmap, ImageView paramImageView);
  
  public abstract void display(String paramString, Drawable paramDrawable, ImageView paramImageView);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/navimageloader/BNBitmapDisplayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */