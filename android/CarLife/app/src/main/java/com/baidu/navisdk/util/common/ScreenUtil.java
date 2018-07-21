package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;

public class ScreenUtil
{
  public static final int DENSITY_DEFAULT = 160;
  public static final int SCREEN_SIZE_Y_LARGE = 640;
  private static ScreenUtil mInstance = null;
  private DisplayMetrics mDM;
  private int mDPI = 0;
  private float mDensity = 0.0F;
  private int mHeightPixels = 0;
  private int mStatusBarHeight = 0;
  private int mWidthPixels = 0;
  private int mWindowHeightPixels = 0;
  private int mWindowWidthPixels = 0;
  
  public static ScreenUtil getInstance()
  {
    if (mInstance == null) {
      mInstance = new ScreenUtil();
    }
    return mInstance;
  }
  
  private int getStatusBarHeightInner(Activity paramActivity)
  {
    if (paramActivity == null) {
      return 0;
    }
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramActivity.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException)
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.top;
    }
  }
  
  public int dip2px(float paramFloat)
  {
    return (int)(0.5F + this.mDensity * paramFloat);
  }
  
  public int dip2px(int paramInt)
  {
    return (int)(0.5F + this.mDensity * paramInt);
  }
  
  public int getDPI()
  {
    return this.mDPI;
  }
  
  public float getDensity()
  {
    return this.mDensity;
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return this.mDM;
  }
  
  public int getGuidePanelWidth()
  {
    return getHeightPixels() / 4;
  }
  
  public int getHeightPixels()
  {
    return this.mHeightPixels;
  }
  
  public int getStatusBarHeight()
  {
    return this.mStatusBarHeight;
  }
  
  public int getWidthPixels()
  {
    return this.mWidthPixels;
  }
  
  public int getWindowHeight(Activity paramActivity)
  {
    return paramActivity.getWindow().getDecorView().getMeasuredHeight();
  }
  
  @Deprecated
  public int getWindowHeightPixels()
  {
    return this.mWindowHeightPixels;
  }
  
  public int getWindowWidth(Activity paramActivity)
  {
    return paramActivity.getWindow().getDecorView().getMeasuredWidth();
  }
  
  @Deprecated
  public int getWindowWidthPixels()
  {
    return this.mWindowWidthPixels;
  }
  
  public void init(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      this.mDM = paramActivity.getResources().getDisplayMetrics();
      this.mDensity = this.mDM.density;
      this.mWidthPixels = Math.min(this.mDM.widthPixels, this.mDM.heightPixels);
      this.mHeightPixels = Math.max(this.mDM.widthPixels, this.mDM.heightPixels);
      this.mWindowWidthPixels = getWindowWidth(paramActivity);
      this.mWindowHeightPixels = getWindowHeight(paramActivity);
      this.mStatusBarHeight = getStatusBarHeightInner(paramActivity);
      try
      {
        PackageUtil.sdkVersion = Integer.parseInt(Build.VERSION.SDK);
        if (PackageUtil.sdkVersion > 3) {}
        for (this.mDPI = this.mDM.densityDpi; this.mDPI == 0; this.mDPI = 160)
        {
          this.mDPI = 160;
          return;
        }
      }
      catch (Exception paramActivity)
      {
        for (;;) {}
      }
    }
  }
  
  public int percentHeight(float paramFloat)
  {
    return (int)(getHeightPixels() * paramFloat);
  }
  
  public int percentWidth(float paramFloat)
  {
    return (int)(getWidthPixels() * paramFloat);
  }
  
  public int px2dip(float paramFloat)
  {
    return (int)(0.5F + paramFloat / this.mDensity);
  }
  
  public int px2dip(int paramInt)
  {
    return (int)(0.5F + paramInt / this.mDensity);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/util/common/ScreenUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */