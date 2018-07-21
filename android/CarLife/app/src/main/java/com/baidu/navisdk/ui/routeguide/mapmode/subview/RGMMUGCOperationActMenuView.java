package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter.CallBackListener;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;

public class RGMMUGCOperationActMenuView
  extends BNBaseView
{
  public static boolean isViewShow = false;
  private ViewGroup mMenuViewContainer = null;
  private View mMenuViewLandscape = null;
  private View mMenuViewPanel = null;
  private View mMenuViewPortrait = null;
  private UgcReportNaviMainPresenter mPrensenter;
  private UgcReportNaviMainView mUgcReportMapMainView;
  private UgcReportNaviMainPresenter.CallBackListener mUgcResportCallback = new UgcReportNaviMainPresenter.CallBackListener()
  {
    public void onUgcFinish()
    {
      RGMapModeViewController.getInstance().onUgcDestroy();
    }
  };
  
  public RGMMUGCOperationActMenuView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews(paramContext);
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private void initViews(Context paramContext)
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      return;
      this.mMenuViewPanel = this.mRootViewGroup.findViewById(1711866534);
      this.mMenuViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866535));
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.removeAllViews();
      }
      if (this.mMenuViewPanel != null) {
        this.mMenuViewPanel.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            RGViewController.getInstance().onUgcDestroy();
          }
        });
      }
      this.mUgcReportMapMainView = new UgcReportNaviMainView(paramContext, RGViewController.getInstance().getOrientation());
      this.mPrensenter = new UgcReportNaviMainPresenter(this.mUgcReportMapMainView, UgcDataProvider.obtainUgcNaviLayout(), this.mUgcResportCallback);
      this.mUgcReportMapMainView.setPresenter(this.mPrensenter);
      paramContext = this.mUgcReportMapMainView.getParentView();
    } while ((this.mMenuViewContainer == null) || (paramContext == null));
    this.mMenuViewContainer.removeAllViews();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mMenuViewContainer.addView(paramContext, localLayoutParams);
    this.mPrensenter.start();
  }
  
  public void hide()
  {
    super.hide();
    Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_OUT, 0L, 300L);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        RGMMUGCOperationActMenuView.this.onHide();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.startAnimation(localAnimation);
    }
  }
  
  protected void hiedByTimeOut()
  {
    RGViewController.getInstance().onUgcDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mPrensenter != null) {
      this.mPrensenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPress()
  {
    if (!this.mPrensenter.onBackPress()) {
      RGMapModeViewController.getInstance().onUgcDestroy();
    }
  }
  
  public void onDestroy()
  {
    if (this.mPrensenter != null) {
      this.mPrensenter.onDestroy();
    }
    hide();
  }
  
  protected void onHide()
  {
    isViewShow = false;
    if (this.mMenuViewContainer != null) {
      this.mMenuViewContainer.setVisibility(8);
    }
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    if (this.mRootViewGroup == null) {}
    do
    {
      return;
      this.mMenuViewPanel = this.mRootViewGroup.findViewById(1711866534);
      this.mMenuViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866535));
      if (this.mMenuViewContainer != null) {
        this.mMenuViewContainer.removeAllViews();
      }
      if (this.mMenuViewPanel != null) {
        this.mMenuViewPanel.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            RGViewController.getInstance().onUgcDestroy();
          }
        });
      }
      this.mUgcReportMapMainView = new UgcReportNaviMainView(this.mContext, RGViewController.getInstance().getOrientation());
      this.mPrensenter.setRootView(this.mUgcReportMapMainView);
      this.mUgcReportMapMainView.setPresenter(this.mPrensenter);
      paramViewGroup = this.mUgcReportMapMainView.getParentView();
    } while ((this.mMenuViewContainer == null) || (paramViewGroup == null));
    this.mMenuViewContainer.removeAllViews();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mMenuViewContainer.addView(paramViewGroup, localLayoutParams);
    if (this.mPrensenter != null) {
      this.mPrensenter.orientationChanged(paramInt);
    }
    show();
  }
  
  public void show()
  {
    super.show();
    isViewShow = true;
    if (this.mMenuViewPanel != null) {
      this.mMenuViewPanel.setVisibility(0);
    }
    if (this.mMenuViewContainer != null)
    {
      Animation localAnimation = AnimationUtil.getAnimation(AnimationUtil.AnimationType.ANIM_DOWN_IN, 0L, 300L);
      this.mMenuViewContainer.startAnimation(localAnimation);
      this.mMenuViewContainer.setVisibility(0);
    }
  }
  
  public void showAftInited()
  {
    show();
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMUGCOperationActMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */