package com.baidu.carlife.view.recyclingviewpager;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import android.view.ViewParent;

public class ScalePageTransformer
  implements ViewPager.PageTransformer
{
  public static final float a = 1.6F;
  public static final float b = 1.0F;
  private static final float c = 0.0F;
  private static final float d = 0.4F;
  private static final float e = 0.7F;
  
  public void a(View paramView, float paramFloat)
  {
    View localView = paramView.findViewById(2131626002);
    float f;
    if (paramFloat < -2.0F)
    {
      f = -2.0F;
      paramFloat = 1.0F + (2.0F - Math.abs(f)) * 0.3F;
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      if ((f < -1.0F) || (f > 1.0F)) {
        break label101;
      }
      localView.setAlpha(0.4F + (1.0F - Math.abs(f)) * -0.4F);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 19) {
        paramView.getParent().requestLayout();
      }
      return;
      f = paramFloat;
      if (paramFloat <= 2.0F) {
        break;
      }
      f = 2.0F;
      break;
      label101:
      localView.setAlpha(0.7F + (2.0F - Math.abs(f)) * -0.29999998F);
    }
  }
  
  public void transformPage(View paramView, float paramFloat)
  {
    View localView = paramView.findViewById(2131626002);
    float f;
    if (paramFloat < -3.0F)
    {
      f = -3.0F;
      paramFloat = 1.0F + (3.0F - Math.abs(f)) * 0.2F;
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      if ((f < -1.0F) || (f > 1.0F)) {
        break label104;
      }
      localView.setAlpha(0.4F + (1.0F - Math.abs(f)) * -0.4F);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 19) {
        paramView.getParent().requestLayout();
      }
      return;
      f = paramFloat;
      if (paramFloat <= 3.0F) {
        break;
      }
      f = 3.0F;
      break;
      label104:
      localView.setAlpha(0.7F + (3.0F - Math.abs(f)) * -0.29999998F);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/recyclingviewpager/ScalePageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */