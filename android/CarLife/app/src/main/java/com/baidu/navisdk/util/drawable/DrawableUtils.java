package com.baidu.navisdk.util.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;

public class DrawableUtils
{
  public static Drawable getDrawableFromView(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.setDrawingCacheEnabled(true);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(null, Bitmap.createBitmap(paramView.getDrawingCache(true)));
    paramView.destroyDrawingCache();
    paramView.setDrawingCacheEnabled(false);
    return localBitmapDrawable;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/drawable/DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */