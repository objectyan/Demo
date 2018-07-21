package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public abstract class BNBaseOrientationView
  extends BNBaseView
{
  private static final String TAG = "BNBaseOrientationView";
  private boolean hasInitView = false;
  protected View mRootView = null;
  protected ViewGroup mRootViewContainer = null;
  
  public BNBaseOrientationView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  public BNBaseOrientationView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
  }
  
  private void initView()
  {
    this.hasInitView = true;
    if (1 == RGViewController.getInstance().getOrientation()) {
      this.mCurOrientation = 1;
    }
    for (this.mRootView = JarUtils.inflate((Activity)this.mContext, getPortraitLayoutId(), null);; this.mRootView = JarUtils.inflate((Activity)this.mContext, getLandscapeLayoutId(), null))
    {
      initViewById();
      initListener();
      updateDataByLast();
      updateStyle(BNStyleManager.getDayStyle());
      return;
      this.mCurOrientation = 2;
    }
  }
  
  public void addToContainer(boolean paramBoolean)
  {
    if (this.mRootViewContainer == null)
    {
      LogUtil.e("BNBaseOrientationView", "addToContainner mRootViewContainer is null");
      return;
    }
    if ((this.mRootViewContainer.getChildCount() != 0) && (!paramBoolean))
    {
      LogUtil.e("BNBaseOrientationView", "addToContainner has done");
      return;
    }
    this.mRootViewContainer.removeAllViews();
    if (this.mRootView == null)
    {
      LogUtil.e("BNBaseOrientationView", "addToContainner mRootView is null");
      return;
    }
    Object localObject = (ViewGroup)this.mRootView.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.mRootView);
    }
    if (!isVisibility())
    {
      this.mRootViewContainer.setVisibility(8);
      LogUtil.e("BNBaseOrientationView", "addToContainer isVisibility false");
      return;
    }
    localObject = generalLayoutParams();
    if (localObject != null) {
      this.mRootView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.mRootViewContainer.addView(this.mRootView);
    this.mRootViewContainer.setVisibility(0);
  }
  
  public void dispose()
  {
    super.dispose();
    if (this.mRootView != null) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.mRootView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.mRootView);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("BNBaseOrientationView", "webview dispose exception");
      }
    }
    this.mRootViewContainer = null;
    this.mRootView = null;
  }
  
  public abstract ViewGroup.LayoutParams generalLayoutParams();
  
  public abstract int getContainerViewId();
  
  public abstract int getLandscapeLayoutId();
  
  public abstract int getPortraitLayoutId();
  
  public void hide()
  {
    super.hide();
    if (this.mRootViewContainer != null) {
      this.mRootViewContainer.setVisibility(8);
    }
  }
  
  public abstract void initListener();
  
  public abstract void initViewById();
  
  protected void initViewContainner(boolean paramBoolean)
  {
    if ((this.mRootViewContainer == null) || (paramBoolean)) {
      this.mRootViewContainer = ((ViewGroup)this.mRootViewGroup.findViewById(getContainerViewId()));
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    resetStateBeforOrientation(paramInt);
    super.orientationChanged(paramViewGroup, paramInt);
    initViewContainner(true);
    if (getPortraitLayoutId() != getLandscapeLayoutId()) {
      initView();
    }
    if (isVisibility()) {
      addToContainer(true);
    }
    do
    {
      return;
      paramViewGroup = (ViewGroup)this.mRootView.getParent();
    } while (paramViewGroup == null);
    paramViewGroup.removeView(this.mRootView);
  }
  
  public void preloadView()
  {
    initView();
  }
  
  protected void resetStateBeforOrientation(int paramInt) {}
  
  public final void show()
  {
    show(null);
  }
  
  public void show(Bundle paramBundle)
  {
    super.show(paramBundle);
    if (!this.hasInitView) {
      initView();
    }
    initViewContainner(false);
    addToContainer(false);
    if (this.mRootViewContainer != null) {
      this.mRootViewContainer.setVisibility(0);
    }
  }
  
  public abstract void updateDataByLast();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNBaseOrientationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */