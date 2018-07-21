package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseOrientationView;
import com.baidu.navisdk.ui.widget.BNDigitalClock;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BatteryStatusReceiver;
import com.baidu.navisdk.util.statistic.PerformStatItem;

public class RGMMDeviceStateView
  extends BNBaseOrientationView
{
  private Animation mAnim = null;
  private BNDigitalClock mBdigClock;
  private boolean mIsSatelliteIconFlash = false;
  private ImageView mIvBattery = null;
  private int mLastSateliteNum = -1;
  private LinearInterpolator mLinearInterpolator = null;
  private ImageView mSatelliteIcon = null;
  private TextView mSatelliteNumTV = null;
  private TextView mTvBattery = null;
  private ImageView mVolumeIcon = null;
  
  public RGMMDeviceStateView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
  }
  
  private void cancleSatelliteIconAnim()
  {
    if ((!PerformStatItem.sIsSatelliteFlashForPerform) || (this.mSatelliteIcon == null)) {
      return;
    }
    this.mSatelliteIcon.clearAnimation();
    this.mLinearInterpolator = null;
    this.mAnim = null;
    this.mIsSatelliteIconFlash = false;
  }
  
  private void startSatelliteIconAnim()
  {
    if ((!PerformStatItem.sIsSatelliteFlashForPerform) || (this.mSatelliteIcon == null)) {
      return;
    }
    if (this.mLinearInterpolator == null) {
      this.mLinearInterpolator = new LinearInterpolator();
    }
    if ((this.mAnim == null) && (this.mLinearInterpolator != null))
    {
      this.mAnim = new AlphaAnimation(1.0F, 0.0F);
      this.mAnim.setDuration(1000L);
      this.mAnim.setInterpolator(new LinearInterpolator());
      this.mAnim.setRepeatCount(-1);
      this.mAnim.setRepeatMode(2);
    }
    if (this.mAnim != null) {
      this.mSatelliteIcon.startAnimation(this.mAnim);
    }
    this.mIsSatelliteIconFlash = true;
  }
  
  public void dispose()
  {
    super.dispose();
    UIUtils.releaseImageView(this.mSatelliteIcon);
    UIUtils.releaseImageView(this.mVolumeIcon);
    cancleSatelliteIconAnim();
  }
  
  public ViewGroup.LayoutParams generalLayoutParams()
  {
    return null;
  }
  
  public int getContainerViewId()
  {
    return 1711866527;
  }
  
  public int getLandscapeLayoutId()
  {
    return 1711472699;
  }
  
  public int getPortraitLayoutId()
  {
    return 1711472698;
  }
  
  public void initListener() {}
  
  public void initViewById()
  {
    this.mSatelliteIcon = ((ImageView)this.mRootView.findViewById(1711866373));
    this.mSatelliteNumTV = ((TextView)this.mRootView.findViewById(1711866372));
    this.mSatelliteIcon.setVisibility(0);
    this.mBdigClock = ((BNDigitalClock)this.mRootView.findViewById(1711866376));
    this.mIvBattery = ((ImageView)this.mRootView.findViewById(1711865929));
    this.mTvBattery = ((TextView)this.mRootView.findViewById(1711865928));
    this.mVolumeIcon = ((ImageView)this.mRootView.findViewById(1711866374));
  }
  
  protected void resetStateBeforOrientation(int paramInt)
  {
    cancleSatelliteIconAnim();
    this.mIsSatelliteIconFlash = false;
    this.mLastSateliteNum = -1;
  }
  
  public void setBatteryStatus(int paramInt, boolean paramBoolean)
  {
    if (this.mTvBattery != null) {
      this.mTvBattery.setText(paramInt + "%");
    }
    if ((paramBoolean) && (this.mIvBattery != null)) {
      this.mIvBattery.setImageDrawable(JarUtils.getResources().getDrawable(1711407676));
    }
    for (;;)
    {
      return;
      int j = -1;
      int i;
      if (paramInt <= 35) {
        i = 1711407677;
      }
      while ((this.mIvBattery != null) && (i != -1))
      {
        this.mIvBattery.setImageDrawable(JarUtils.getResources().getDrawable(i));
        return;
        if ((paramInt > 35) && (paramInt <= 65))
        {
          i = 1711407678;
        }
        else if ((paramInt > 65) && (paramInt <= 95))
        {
          i = 1711407679;
        }
        else
        {
          i = j;
          if (paramInt > 95)
          {
            i = j;
            if (paramInt <= 100) {
              i = 1711407680;
            }
          }
        }
      }
    }
  }
  
  public void show(Bundle paramBundle)
  {
    if (!BNavigator.getInstance().hasCalcRouteOk()) {
      return;
    }
    super.show(paramBundle);
  }
  
  public void updateData(Bundle paramBundle)
  {
    updateSatelliteNum(RGSimpleGuideModel.getInstance().getSatelliteNum());
    setBatteryStatus(BatteryStatusReceiver.mBatteryLevel, BatteryStatusReceiver.isCharging);
  }
  
  public void updateDataByLast()
  {
    updateData(null);
  }
  
  public void updateSatelliteNum(int paramInt)
  {
    if (!BNavigator.getInstance().hasCalcRouteOk()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.mSatelliteIcon == null) || (this.mSatelliteNumTV == null));
        if ((BNavigator.getInstance().mIsGPSDisable) && (paramInt < 3))
        {
          this.mLastSateliteNum = -1;
          this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(1711407692));
          cancleSatelliteIconAnim();
          this.mSatelliteNumTV.setVisibility(8);
          return;
        }
      } while (this.mLastSateliteNum == paramInt);
      this.mLastSateliteNum = paramInt;
      paramInt = RGSimpleGuideModel.getInstance().getSatelliteNum();
      if (paramInt < 3)
      {
        this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(1711407692));
        if (!this.mIsSatelliteIconFlash) {
          startSatelliteIconAnim();
        }
        this.mSatelliteNumTV.setVisibility(0);
        this.mSatelliteNumTV.setTextColor(Color.parseColor("#f44335"));
        this.mSatelliteNumTV.setText("弱");
        return;
      }
      if ((paramInt >= 3) && (paramInt <= 5))
      {
        this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(1711407693));
        cancleSatelliteIconAnim();
        this.mSatelliteNumTV.setVisibility(0);
        this.mSatelliteNumTV.setTextColor(Color.parseColor("#fbe000"));
        this.mSatelliteNumTV.setText("中");
        return;
      }
    } while (paramInt <= 5);
    this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(1711407691));
    cancleSatelliteIconAnim();
    this.mSatelliteNumTV.setVisibility(0);
    this.mSatelliteNumTV.setTextColor(Color.parseColor("#62d336"));
    this.mSatelliteNumTV.setText("强");
  }
  
  public void updateVolumeView(boolean paramBoolean)
  {
    if (this.mVolumeIcon == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        RGSimpleGuideModel.getInstance().canSilentIconShow = true;
      } while (this.mVolumeIcon.getVisibility() == 0);
      return;
      RGSimpleGuideModel.getInstance().canSilentIconShow = false;
    } while (this.mVolumeIcon.getVisibility() != 0);
    this.mVolumeIcon.setVisibility(8);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMDeviceStateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */