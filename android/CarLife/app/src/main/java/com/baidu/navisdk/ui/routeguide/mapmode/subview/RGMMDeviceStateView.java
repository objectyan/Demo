package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
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

public class RGMMDeviceStateView extends BNBaseOrientationView {
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

    public RGMMDeviceStateView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
    }

    public void initViewById() {
        this.mSatelliteIcon = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_satelite_icon);
        this.mSatelliteNumTV = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_satelite_num);
        this.mSatelliteIcon.setVisibility(0);
        this.mBdigClock = (BNDigitalClock) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_current_time);
        this.mIvBattery = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_battery_icon);
        this.mTvBattery = (TextView) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_battery_percent);
        this.mVolumeIcon = (ImageView) this.mRootView.findViewById(C4048R.id.bnav_rg_sg_volume_icon);
    }

    protected void resetStateBeforOrientation(int orien) {
        cancleSatelliteIconAnim();
        this.mIsSatelliteIconFlash = false;
        this.mLastSateliteNum = -1;
    }

    public void initListener() {
    }

    public int getPortraitLayoutId() {
        return C4048R.layout.nsdk_layout_rg_device_state;
    }

    public int getLandscapeLayoutId() {
        return C4048R.layout.nsdk_layout_rg_device_state_land;
    }

    public int getContainerViewId() {
        return C4048R.id.bnav_rg_device_status_container;
    }

    public LayoutParams generalLayoutParams() {
        return null;
    }

    public void updateDataByLast() {
        updateData(null);
    }

    public void updateData(Bundle b) {
        updateSatelliteNum(RGSimpleGuideModel.getInstance().getSatelliteNum());
        setBatteryStatus(BatteryStatusReceiver.mBatteryLevel, BatteryStatusReceiver.isCharging);
    }

    public void updateVolumeView(boolean flag) {
        if (this.mVolumeIcon != null) {
            if (flag) {
                RGSimpleGuideModel.getInstance().canSilentIconShow = true;
                if (this.mVolumeIcon.getVisibility() == 0) {
                    return;
                }
                return;
            }
            RGSimpleGuideModel.getInstance().canSilentIconShow = false;
            if (this.mVolumeIcon.getVisibility() == 0) {
                this.mVolumeIcon.setVisibility(8);
            }
        }
    }

    public void updateSatelliteNum(int num) {
        if (BNavigator.getInstance().hasCalcRouteOk() && this.mSatelliteIcon != null && this.mSatelliteNumTV != null) {
            if (BNavigator.getInstance().mIsGPSDisable && num < 3) {
                this.mLastSateliteNum = -1;
                this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_satellite_red));
                cancleSatelliteIconAnim();
                this.mSatelliteNumTV.setVisibility(8);
            } else if (this.mLastSateliteNum != num) {
                this.mLastSateliteNum = num;
                int satelliteNum = RGSimpleGuideModel.getInstance().getSatelliteNum();
                if (satelliteNum < 3) {
                    this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_satellite_red));
                    if (!this.mIsSatelliteIconFlash) {
                        startSatelliteIconAnim();
                    }
                    this.mSatelliteNumTV.setVisibility(0);
                    this.mSatelliteNumTV.setTextColor(Color.parseColor("#f44335"));
                    this.mSatelliteNumTV.setText("弱");
                } else if (satelliteNum >= 3 && satelliteNum <= 5) {
                    this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_satellite_yellow));
                    cancleSatelliteIconAnim();
                    this.mSatelliteNumTV.setVisibility(0);
                    this.mSatelliteNumTV.setTextColor(Color.parseColor("#fbe000"));
                    this.mSatelliteNumTV.setText("中");
                } else if (satelliteNum > 5) {
                    this.mSatelliteIcon.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_satellite_green));
                    cancleSatelliteIconAnim();
                    this.mSatelliteNumTV.setVisibility(0);
                    this.mSatelliteNumTV.setTextColor(Color.parseColor("#62d336"));
                    this.mSatelliteNumTV.setText("强");
                }
            }
        }
    }

    public void setBatteryStatus(int batteryLevel, boolean mIsBatteryCharging) {
        if (this.mTvBattery != null) {
            this.mTvBattery.setText(batteryLevel + "%");
        }
        if (!mIsBatteryCharging || this.mIvBattery == null) {
            int resId = -1;
            if (batteryLevel <= 35) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_red;
            } else if (batteryLevel > 35 && batteryLevel <= 65) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_1;
            } else if (batteryLevel > 65 && batteryLevel <= 95) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_2;
            } else if (batteryLevel > 95 && batteryLevel <= 100) {
                resId = C4048R.drawable.nsdk_drawable_rg_ic_battery_white_3;
            }
            if (this.mIvBattery != null && resId != -1) {
                this.mIvBattery.setImageDrawable(JarUtils.getResources().getDrawable(resId));
                return;
            }
            return;
        }
        this.mIvBattery.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_drawable_rg_ic_battery_charging));
    }

    public void show(Bundle bundle) {
        if (BNavigator.getInstance().hasCalcRouteOk()) {
            super.show(bundle);
        }
    }

    public void dispose() {
        super.dispose();
        UIUtils.releaseImageView(this.mSatelliteIcon);
        UIUtils.releaseImageView(this.mVolumeIcon);
        cancleSatelliteIconAnim();
    }

    private void startSatelliteIconAnim() {
        if (PerformStatItem.sIsSatelliteFlashForPerform && this.mSatelliteIcon != null) {
            if (this.mLinearInterpolator == null) {
                this.mLinearInterpolator = new LinearInterpolator();
            }
            if (this.mAnim == null && this.mLinearInterpolator != null) {
                this.mAnim = new AlphaAnimation(1.0f, 0.0f);
                this.mAnim.setDuration(1000);
                this.mAnim.setInterpolator(new LinearInterpolator());
                this.mAnim.setRepeatCount(-1);
                this.mAnim.setRepeatMode(2);
            }
            if (this.mAnim != null) {
                this.mSatelliteIcon.startAnimation(this.mAnim);
            }
            this.mIsSatelliteIconFlash = true;
        }
    }

    private void cancleSatelliteIconAnim() {
        if (PerformStatItem.sIsSatelliteFlashForPerform && this.mSatelliteIcon != null) {
            this.mSatelliteIcon.clearAnimation();
            this.mLinearInterpolator = null;
            this.mAnim = null;
            this.mIsSatelliteIconFlash = false;
        }
    }
}
