package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGSlightLockImageView
  extends RGSlightBaseView
{
  private static final String TAG = RGSlightLockImageView.class.getSimpleName();
  private boolean mHasScreenShotSuccess = false;
  private int[] mImageBuf = null;
  private int mImgHeight = 0;
  private int mImgWidth = 0;
  public boolean mIsMapstart = false;
  public boolean mIsMapstatusNeedBack = false;
  private JNIBaseMap mJniBaseMap = new JNIBaseMap();
  private Bitmap mLockBitmap = null;
  private ImageView mLockImage;
  private int mScreenshotType;
  
  public RGSlightLockImageView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initView();
    initListener();
  }
  
  private void parserBuddle(Bundle paramBundle)
  {
    if (this.mImageBuf != null) {
      this.mImageBuf = null;
    }
    this.mImgWidth = paramBundle.getInt("unImageWidth");
    this.mImgHeight = paramBundle.getInt("unImageHeight");
    this.mImageBuf = paramBundle.getIntArray("pbtImageData");
    LogUtil.e("wangyang", "parserBuddle mImgWidth=" + this.mImgWidth + " mImgHeight=" + this.mImgHeight);
  }
  
  private void releaseBGBitmap()
  {
    try
    {
      if ((this.mLockBitmap != null) && (!this.mLockBitmap.isRecycled())) {
        this.mLockBitmap.recycle();
      }
      this.mLockBitmap = null;
      return;
    }
    catch (Exception localException)
    {
      this.mLockBitmap = null;
    }
  }
  
  private boolean setRasterImage()
  {
    for (;;)
    {
      try
      {
        if ((this.mImageBuf != null) && (this.mImageBuf.length > 0) && (this.mImgWidth > 0) && (this.mImgHeight > 0))
        {
          LogUtil.e("wangyang", "LightNaviLockView setRasterImage: image width=" + this.mImgWidth + ", height=" + this.mImgHeight);
          releaseBGBitmap();
          try
          {
            this.mLockBitmap = Bitmap.createBitmap(this.mImageBuf, this.mImgWidth, this.mImgHeight, Bitmap.Config.ARGB_8888);
            this.mImageBuf = null;
            if (this.mLockBitmap == null) {
              LogUtil.e("wangyang", "LightNaviLockView setRasterImage: create bitmap failed!!!!");
            }
            bool = true;
            return bool;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            this.mLockBitmap = null;
            continue;
          }
        }
        LogUtil.e("wangyang", "LightNaviLockView setRasterImage: null imageBuf!!");
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean checkNeedShowLockImage(int paramInt)
  {
    if (this.mScreenshotType != paramInt)
    {
      this.mScreenshotType = paramInt;
      return true;
    }
    return false;
  }
  
  public void getScreenShot(RGSlightYellowBannerView paramRGSlightYellowBannerView, int paramInt)
  {
    if (BNLightNaviManager.getInstance().getType() == 1)
    {
      onMapResume();
      zoomToSlightNaviFullView(paramRGSlightYellowBannerView, paramInt);
      paramRGSlightYellowBannerView = ScreenUtil.getInstance();
      BNMapController.getInstance().setNightMode(true);
      this.mJniBaseMap.setScreenShotParam(2, paramRGSlightYellowBannerView.getWidthPixels(), paramRGSlightYellowBannerView.getHeightPixels() - ScreenUtil.getInstance().dip2px(160), 0L, 0L, 0);
    }
  }
  
  public void initListener() {}
  
  public void initView()
  {
    this.mLockImage = ((ImageView)this.mRootViewGroup.findViewById(1711866206));
  }
  
  public void isMapstatusNeedBack()
  {
    if (this.mIsMapstatusNeedBack)
    {
      BNMapController.getInstance().onPause();
      this.mIsMapstart = false;
      this.mIsMapstatusNeedBack = false;
    }
  }
  
  public boolean isScreenShotSuccess()
  {
    try
    {
      boolean bool = this.mHasScreenShotSuccess;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onMapPause()
  {
    if (this.mIsMapstart)
    {
      boolean bool = BNLightNaviManager.getInstance().isSwitching();
      LogUtil.e(TAG, "onMapPause: switching --> " + bool);
      if (!bool) {
        BNMapController.getInstance().onPause();
      }
      this.mIsMapstart = false;
      this.mIsMapstatusNeedBack = false;
    }
  }
  
  public void onMapResume()
  {
    if (!this.mIsMapstart)
    {
      BNMapController.getInstance().onResume();
      this.mIsMapstart = true;
      this.mIsMapstatusNeedBack = false;
    }
  }
  
  public void setScreenShotSuccess(boolean paramBoolean)
  {
    try
    {
      this.mHasScreenShotSuccess = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void updateLockImage()
  {
    Bundle localBundle = new Bundle();
    this.mJniBaseMap.getScreenShotImage(localBundle);
    parserBuddle(localBundle);
    setRasterImage();
    this.mLockImage.setImageBitmap(this.mLockBitmap);
  }
  
  public void zoomToSlightNaviFullView(RGSlightYellowBannerView paramRGSlightYellowBannerView, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isVertical", true);
    if (BNLightNaviManager.getInstance().getType() == 2)
    {
      j = ScreenUtil.getInstance().dip2px(50);
      i = j;
      if (paramRGSlightYellowBannerView.isBrightConditionShow()) {
        i = j + ScreenUtil.getInstance().dip2px(48);
      }
      j = ScreenUtil.getInstance().dip2px(81);
      if (paramInt != 0) {}
      for (;;)
      {
        localBundle.putInt("unLeftHeight", 0);
        localBundle.putInt("unRightHeight", 0);
        localBundle.putInt("widthP", BNMapController.getInstance().getScreenWidth());
        localBundle.putInt("unTopHeight", i);
        localBundle.putInt("unBottomHeight", j);
        localBundle.putInt("heightP", paramInt);
        BNMapController.getInstance().zoomToSlightNaviFullView(localBundle, true);
        BNMapController.getInstance().updateLayer(13);
        return;
        paramInt = BNMapController.getInstance().getScreenHeight();
      }
    }
    int j = ScreenUtil.getInstance().dip2px(80);
    int i = j;
    if (paramRGSlightYellowBannerView.isLockConditionShow()) {
      i = j + ScreenUtil.getInstance().dip2px(20);
    }
    j = ScreenUtil.getInstance().dip2px(80);
    if (paramInt != 0) {}
    for (;;)
    {
      localBundle.putInt("unLeftHeight", 100);
      localBundle.putInt("unRightHeight", 100);
      break;
      paramInt = BNMapController.getInstance().getScreenHeight();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/RGSlightLockImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */