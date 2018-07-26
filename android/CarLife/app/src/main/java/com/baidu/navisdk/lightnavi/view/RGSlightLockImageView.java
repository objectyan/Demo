package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGSlightLockImageView extends RGSlightBaseView {
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

    public synchronized boolean isScreenShotSuccess() {
        return this.mHasScreenShotSuccess;
    }

    public synchronized void setScreenShotSuccess(boolean flag) {
        this.mHasScreenShotSuccess = flag;
    }

    public RGSlightLockImageView(Context c, ViewGroup p) {
        super(c, p);
        initView();
        initListener();
    }

    public void initView() {
        this.mLockImage = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lock_img);
    }

    public void initListener() {
    }

    private void parserBuddle(Bundle bundle) {
        if (this.mImageBuf != null) {
            this.mImageBuf = null;
        }
        this.mImgWidth = bundle.getInt("unImageWidth");
        this.mImgHeight = bundle.getInt("unImageHeight");
        this.mImageBuf = bundle.getIntArray("pbtImageData");
        LogUtil.m15791e("wangyang", "parserBuddle mImgWidth=" + this.mImgWidth + " mImgHeight=" + this.mImgHeight);
    }

    private synchronized boolean setRasterImage() {
        boolean z;
        if (this.mImageBuf == null || this.mImageBuf.length <= 0 || this.mImgWidth <= 0 || this.mImgHeight <= 0) {
            LogUtil.m15791e("wangyang", "LightNaviLockView setRasterImage: null imageBuf!!");
            z = false;
        } else {
            LogUtil.m15791e("wangyang", "LightNaviLockView setRasterImage: image width=" + this.mImgWidth + ", height=" + this.mImgHeight);
            releaseBGBitmap();
            try {
                this.mLockBitmap = Bitmap.createBitmap(this.mImageBuf, this.mImgWidth, this.mImgHeight, Config.ARGB_8888);
                this.mImageBuf = null;
            } catch (OutOfMemoryError e) {
                this.mLockBitmap = null;
            }
            if (this.mLockBitmap == null) {
                LogUtil.m15791e("wangyang", "LightNaviLockView setRasterImage: create bitmap failed!!!!");
            }
            z = true;
        }
        return z;
    }

    private void releaseBGBitmap() {
        try {
            if (!(this.mLockBitmap == null || this.mLockBitmap.isRecycled())) {
                this.mLockBitmap.recycle();
            }
            this.mLockBitmap = null;
        } catch (Exception e) {
            this.mLockBitmap = null;
        }
    }

    public void onMapResume() {
        if (!this.mIsMapstart) {
            BNMapController.getInstance().onResume();
            this.mIsMapstart = true;
            this.mIsMapstatusNeedBack = false;
        }
    }

    public void onMapPause() {
        if (this.mIsMapstart) {
            boolean switching = BNLightNaviManager.getInstance().isSwitching();
            LogUtil.m15791e(TAG, "onMapPause: switching --> " + switching);
            if (!switching) {
                BNMapController.getInstance().onPause();
            }
            this.mIsMapstart = false;
            this.mIsMapstatusNeedBack = false;
        }
    }

    public void getScreenShot(RGSlightYellowBannerView mRGSlightYellowBannerView, int viewHeight) {
        if (BNLightNaviManager.getInstance().getType() == 1) {
            onMapResume();
            zoomToSlightNaviFullView(mRGSlightYellowBannerView, viewHeight);
            ScreenUtil mScreen = ScreenUtil.getInstance();
            BNMapController.getInstance().setNightMode(true);
            this.mJniBaseMap.setScreenShotParam(2, mScreen.getWidthPixels(), mScreen.getHeightPixels() - ScreenUtil.getInstance().dip2px(160), 0, 0, 0);
        }
    }

    public void zoomToSlightNaviFullView(RGSlightYellowBannerView mRGSlightYellowBannerView, int viewHeight) {
        int topHeight;
        int bottomHeight;
        int heigth;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVertical", true);
        if (BNLightNaviManager.getInstance().getType() == 2) {
            topHeight = ScreenUtil.getInstance().dip2px(50);
            if (mRGSlightYellowBannerView.isBrightConditionShow()) {
                topHeight += ScreenUtil.getInstance().dip2px(48);
            }
            bottomHeight = ScreenUtil.getInstance().dip2px(81);
            if (viewHeight != 0) {
                heigth = viewHeight;
            } else {
                heigth = BNMapController.getInstance().getScreenHeight();
            }
            bundle.putInt("unLeftHeight", 0);
            bundle.putInt("unRightHeight", 0);
        } else {
            topHeight = ScreenUtil.getInstance().dip2px(80);
            if (mRGSlightYellowBannerView.isLockConditionShow()) {
                topHeight += ScreenUtil.getInstance().dip2px(20);
            }
            bottomHeight = ScreenUtil.getInstance().dip2px(80);
            if (viewHeight != 0) {
                heigth = viewHeight;
            } else {
                heigth = BNMapController.getInstance().getScreenHeight();
            }
            bundle.putInt("unLeftHeight", 100);
            bundle.putInt("unRightHeight", 100);
        }
        bundle.putInt("widthP", BNMapController.getInstance().getScreenWidth());
        bundle.putInt("unTopHeight", topHeight);
        bundle.putInt("unBottomHeight", bottomHeight);
        bundle.putInt("heightP", heigth);
        BNMapController.getInstance().zoomToSlightNaviFullView(bundle, true);
        BNMapController.getInstance().updateLayer(13);
    }

    public void updateLockImage() {
        Bundle bundle = new Bundle();
        this.mJniBaseMap.getScreenShotImage(bundle);
        parserBuddle(bundle);
        setRasterImage();
        this.mLockImage.setImageBitmap(this.mLockBitmap);
    }

    public void isMapstatusNeedBack() {
        if (this.mIsMapstatusNeedBack) {
            BNMapController.getInstance().onPause();
            this.mIsMapstart = false;
            this.mIsMapstatusNeedBack = false;
        }
    }

    public boolean checkNeedShowLockImage(int tag) {
        if (this.mScreenshotType == tag) {
            return false;
        }
        this.mScreenshotType = tag;
        return true;
    }
}
