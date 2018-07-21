package com.baidu.navisdk.module.business;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class BusinessActivityViewManager
{
  private static final int MSG_AUTO_HIDE_BANNER_WINDOW = 2;
  private static final int MSG_AUTO_HIDE_POP_WINDOW = 1;
  private static final String TAG = BusinessActivityViewManager.class.getSimpleName();
  private static Object mSyncObj = new Object();
  private static BusinessActivityViewManager sInstance = null;
  private View mBusiBannerArea = null;
  private TextView mBusiBannerContent = null;
  private ImageView mBusiBannerImageView = null;
  private TextView mBusiBannerTips = null;
  private View mBusiLogoArea = null;
  private ImageView mBusiLogoImageView = null;
  private TextView mBusiLogoText = null;
  private View mBusiRootView = null;
  private boolean mDayStyle = true;
  private Handler mHD = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        BusinessActivityViewManager.this.hidePop();
        BusinessActivityManager.getInstance().getModel().resetTrafficJam();
        BusinessActivityManager.getInstance().getModel().resetParking();
        BusinessActivityViewManager.access$302(BusinessActivityViewManager.this, false);
        return;
      }
      BusinessActivityViewManager.this.hideBanner();
      BusinessActivityManager.getInstance().getModel().resetTrafficJam();
      BusinessActivityManager.getInstance().getModel().resetParking();
      BusinessActivityViewManager.access$302(BusinessActivityViewManager.this, false);
    }
  };
  private boolean mIsBannerShowing = false;
  private boolean mIsPopShowing = false;
  private boolean mIsShowing = false;
  
  public static BusinessActivityViewManager getInstance()
  {
    if (sInstance == null) {}
    synchronized (mSyncObj)
    {
      if (sInstance == null) {
        sInstance = new BusinessActivityViewManager();
      }
      return sInstance;
    }
  }
  
  private int getMarginBottom()
  {
    String str2 = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "Car3D";
    }
    if (1 == RGViewController.getInstance().getOrientation())
    {
      if ("Car3D".equals(str1)) {
        return ScreenUtil.getInstance().getHeightPixels() / 2 - (int)(ScreenUtil.getInstance().getHeightPixels() * 0.25D) + 80;
      }
      return ScreenUtil.getInstance().getHeightPixels() / 2 - ScreenUtil.getInstance().dip2px(64) + 80;
    }
    if ("Car3D".equals(str1)) {
      return ScreenUtil.getInstance().getWidthPixels() / 2 - (int)(ScreenUtil.getInstance().getWidthPixels() * 0.25D) + 80;
    }
    return ScreenUtil.getInstance().getWidthPixels() / 2 - (int)(ScreenUtil.getInstance().getWidthPixels() * 0.1D) + 80;
  }
  
  private int getMarginLeft()
  {
    if (1 == RGViewController.getInstance().getOrientation()) {
      return 0;
    }
    return ScreenUtil.getInstance().getHeightPixels() / 3;
  }
  
  private void hideBanner()
  {
    this.mIsBannerShowing = false;
    this.mIsShowing = false;
    if (this.mHD.hasMessages(2)) {
      this.mHD.removeMessages(2);
    }
    if (this.mBusiBannerArea != null) {
      this.mBusiBannerArea.setVisibility(8);
    }
    LogUtil.e(BusinessActivityManager.TAG, "view.hideBanner() ");
  }
  
  private void hidePop()
  {
    this.mIsPopShowing = false;
    if (this.mHD.hasMessages(1)) {
      this.mHD.removeMessages(1);
    }
    if (this.mBusiLogoArea != null) {
      this.mBusiLogoArea.setVisibility(8);
    }
    LogUtil.e(BusinessActivityManager.TAG, "view.hidePop() ");
  }
  
  private boolean loadView(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    try
    {
      this.mBusiRootView = JarUtils.inflate(paramActivity, 1711472706, null);
      if (this.mBusiRootView == null) {
        return false;
      }
      this.mBusiLogoArea = this.mBusiRootView.findViewById(1711866455);
      this.mBusiLogoImageView = ((ImageView)this.mBusiRootView.findViewById(1711866456));
      this.mBusiLogoText = ((TextView)this.mBusiRootView.findViewById(1711866457));
      this.mBusiBannerArea = this.mBusiRootView.findViewById(1711866458);
      this.mBusiBannerContent = ((TextView)this.mBusiRootView.findViewById(1711866460));
      this.mBusiBannerImageView = ((ImageView)this.mBusiRootView.findViewById(1711866459));
      this.mBusiBannerTips = ((TextView)this.mBusiRootView.findViewById(1711866461));
      if ((this.mBusiLogoArea != null) && (this.mBusiLogoImageView != null) && (this.mBusiBannerArea != null) && (this.mBusiBannerContent != null) && (this.mBusiBannerImageView != null) && (this.mBusiBannerTips != null))
      {
        this.mBusiLogoArea.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BusinessActivityViewManager.this.showBanner(false);
            BusinessActivityManager.getInstance().getModel().isPrizeReceived = true;
            paramAnonymousView = BusinessActivityManager.getInstance().getModel();
            paramAnonymousView.hasClickActivityCount += 1;
            UserOPController.getInstance().add("3.n", null, null, "" + BusinessActivityManager.getInstance().getModel().aid);
            LogUtil.e(BusinessActivityViewManager.TAG, "pop.onClick() receive prize.");
          }
        });
        this.mBusiBannerArea.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            BusinessActivityViewManager.this.hideViews();
          }
        });
        paramActivity = RGMapModeViewController.getInstance().getModuleContails();
        if (paramActivity == null) {
          return false;
        }
        paramActivity.removeAllViews();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        paramActivity.setPadding(getMarginLeft(), 0, 0, getMarginBottom());
        paramActivity.addView(this.mBusiRootView, localLayoutParams);
        if (!this.mDayStyle) {
          onUpdateStyle(this.mDayStyle, true);
        }
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      return false;
    }
    return false;
  }
  
  private void releaseViews()
  {
    if (this.mBusiRootView != null) {
      this.mBusiRootView.setVisibility(0);
    }
    if (this.mBusiLogoImageView != null)
    {
      UIUtils.releaseImageView(this.mBusiLogoImageView);
      this.mBusiLogoImageView = null;
    }
    if (this.mBusiBannerImageView != null)
    {
      UIUtils.releaseImageView(this.mBusiBannerImageView);
      this.mBusiBannerImageView = null;
    }
    this.mBusiRootView = null;
  }
  
  private void showBanner(boolean paramBoolean)
  {
    this.mIsBannerShowing = true;
    this.mIsPopShowing = false;
    if (this.mBusiLogoArea != null) {
      this.mBusiLogoArea.setVisibility(8);
    }
    ViewGroup localViewGroup;
    if (this.mBusiBannerArea != null)
    {
      this.mBusiBannerContent.setText(BusinessActivityManager.getInstance().getModel().title);
      this.mBusiBannerImageView.setImageBitmap(BusinessActivityManager.getInstance().getModel().bannerBitmap);
      this.mBusiBannerArea.setVisibility(0);
      this.mBusiBannerImageView.setVisibility(0);
      localViewGroup = RGMapModeViewController.getInstance().getModuleContails();
      if (localViewGroup != null) {
        break label93;
      }
    }
    label93:
    do
    {
      return;
      localViewGroup.setVisibility(0);
    } while (paramBoolean);
    this.mHD.sendEmptyMessageDelayed(2, BusinessActivityManager.getInstance().getModel().rtime * 1000);
  }
  
  private void showPop(boolean paramBoolean)
  {
    if (this.mBusiBannerArea != null) {
      this.mBusiBannerArea.setVisibility(8);
    }
    if (BusinessActivityManager.getInstance().getModel().logoBitmap == null) {}
    Object localObject;
    do
    {
      return;
      this.mBusiLogoImageView.setImageBitmap(BusinessActivityManager.getInstance().getModel().logoBitmap);
      this.mBusiLogoArea.setVisibility(0);
      localObject = RGMapModeViewController.getInstance().getModuleContails();
    } while (localObject == null);
    ((ViewGroup)localObject).setVisibility(0);
    if (!paramBoolean)
    {
      localObject = BusinessActivityManager.getInstance().getModel();
      ((BusinessActivityModel)localObject).hasShowActivityCount += 1;
      BusinessActivityPlayerManager.getInstance().playContentWhenShowActivity();
      UserOPController.getInstance().add("3.m", null, null, "" + BusinessActivityManager.getInstance().getModel().aid);
      this.mHD.sendEmptyMessageDelayed(1, BusinessActivityManager.getInstance().getModel().showTime * 1000);
    }
    this.mIsShowing = true;
    this.mIsPopShowing = true;
    this.mIsBannerShowing = false;
  }
  
  public void hideViews()
  {
    if (this.mHD.hasMessages(1)) {
      this.mHD.removeMessages(1);
    }
    if (this.mHD.hasMessages(2)) {
      this.mHD.removeMessages(2);
    }
    ViewGroup localViewGroup = RGMapModeViewController.getInstance().getModuleContails();
    if (localViewGroup != null)
    {
      localViewGroup.removeAllViews();
      localViewGroup.setVisibility(8);
    }
    if (this.mBusiRootView != null) {
      this.mBusiRootView.setVisibility(0);
    }
    if (this.mBusiLogoImageView != null)
    {
      UIUtils.releaseImageView(this.mBusiLogoImageView);
      this.mBusiLogoImageView = null;
    }
    if (this.mBusiBannerImageView != null)
    {
      UIUtils.releaseImageView(this.mBusiBannerImageView);
      this.mBusiBannerImageView = null;
    }
    this.mBusiRootView = null;
    this.mIsShowing = false;
    this.mIsPopShowing = false;
    this.mIsBannerShowing = false;
    LogUtil.e(BusinessActivityManager.TAG, "view.hideViews() ");
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public void onUpdateStyle(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (this.mDayStyle == paramBoolean1)) {}
    do
    {
      return;
      this.mDayStyle = paramBoolean1;
    } while ((this.mBusiLogoArea == null) || (this.mBusiLogoImageView == null) || (this.mBusiLogoText == null) || (this.mBusiBannerArea == null) || (this.mBusiBannerContent == null) || (this.mBusiBannerImageView == null));
    this.mBusiLogoArea.setBackgroundDrawable(BNStyleManager.getDrawable(1711408028));
    this.mBusiLogoText.setTextColor(BNStyleManager.getColor(1711800674));
    this.mBusiBannerArea.setBackgroundDrawable(BNStyleManager.getDrawable(1711408028));
    this.mBusiBannerTips.setTextColor(BNStyleManager.getColor(1711800678));
  }
  
  public void showViews(Activity paramActivity, boolean paramBoolean)
  {
    if ((this.mIsShowing) && (!paramBoolean)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramActivity == null);
        if ((BusinessActivityManager.getInstance().getModel() == null) || (!BusinessActivityManager.getInstance().getModel().isOpen))
        {
          LogUtil.e(TAG, "showViews() no show for activity is not open.");
          return;
        }
        if ((!paramBoolean) && ((BusinessActivityManager.getInstance().getModel().hasShowActivityCount >= BusinessActivityManager.getInstance().getModel().anum) || (BusinessActivityManager.getInstance().getModel().hasClickActivityCount >= BusinessActivityManager.getInstance().getModel().rnum)))
        {
          LogUtil.e(TAG, "showViews() no show for max. hasShowCount=" + BusinessActivityManager.getInstance().getModel().hasShowActivityCount);
          return;
        }
        LogUtil.e(TAG, "showViews() reShowForOrientaionChanged=" + paramBoolean + ", mIsPopShowing=" + this.mIsPopShowing + ", mIsBannerShowing=" + this.mIsBannerShowing);
        releaseViews();
      } while (!loadView(paramActivity));
      if ((!paramBoolean) || (this.mIsPopShowing))
      {
        showPop(paramBoolean);
        return;
      }
    } while (!this.mIsBannerShowing);
    showBanner(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/business/BusinessActivityViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */