package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RGMMNotificationBaseView
  extends BNBaseView
{
  private static final String TAG = RGMMNotificationBaseView.class.getCanonicalName();
  protected AnimListener mAnimListener = null;
  protected int mAutoHideTime = 0;
  protected NotificationDisplayListener mDisplayListener = null;
  private Animation.AnimationListener mInAminListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      LogUtil.e(RGMMNotificationBaseView.TAG, "show onAnimationEnd");
      if (RGMMNotificationBaseView.this.mAnimListener != null) {
        RGMMNotificationBaseView.this.mAnimListener.onShowAnimEnd();
      }
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  public Animation mInAnimation = null;
  protected int mNotificationType = 0;
  protected View mNotificationView = null;
  private View mNotificationViewPanel = null;
  private Animation.AnimationListener mOutAminListener = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      LogUtil.e(RGMMNotificationBaseView.TAG, "hide onAnimationEnd");
      if (RGMMNotificationBaseView.this.mAnimListener != null) {
        RGMMNotificationBaseView.this.mAnimListener.onHideAnimEnd();
      }
      RGMMNotificationBaseView.this.dispose();
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  public Animation mOutAnimation = null;
  protected int mPriority = 0;
  protected ViewGroup mViewContainer = null;
  
  public RGMMNotificationBaseView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initViews();
  }
  
  public RGMMNotificationBaseView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
  }
  
  private void hideWithAnim()
  {
    LogUtil.e(TAG, "hideWithAnim");
    if (this.mAnimListener != null) {
      this.mAnimListener.onHide();
    }
    if (this.mDisplayListener != null) {
      this.mDisplayListener.onHideWithAnim();
    }
    if ((this.mNotificationView == null) || (this.mOutAnimation == null) || (this.mInAnimation == null)) {
      return;
    }
    if ((this.mInAnimation.hasStarted()) && (!this.mInAnimation.hasEnded()))
    {
      LogUtil.e(TAG, "show anim runing");
      this.mNotificationView.clearAnimation();
      if (this.mAnimListener != null) {
        this.mAnimListener.onShowAnimEnd();
      }
      if (this.mAnimListener != null) {
        this.mAnimListener.onHideAnimEnd();
      }
      dispose();
      return;
    }
    if ((this.mOutAnimation.hasStarted()) && (!this.mOutAnimation.hasEnded()))
    {
      LogUtil.e(TAG, "hide anim runing");
      return;
    }
    this.mOutAnimation.setAnimationListener(this.mOutAminListener);
    this.mNotificationView.startAnimation(this.mOutAnimation);
  }
  
  private void initViews()
  {
    if ((this.mRootViewGroup == null) || (this.mContext == null)) {}
    do
    {
      return;
      this.mNotificationViewPanel = RGViewController.getInstance().getViewContails(1711866551);
      this.mViewContainer = RGViewController.getInstance().getViewContails(1711866552);
    } while ((this.mNotificationViewPanel == null) || (this.mViewContainer == null));
    this.mInAnimation = JarUtils.loadAnimation(this.mContext, 1711538186);
    this.mOutAnimation = JarUtils.loadAnimation(this.mContext, 1711538189);
  }
  
  private void showWithAnim()
  {
    LogUtil.e(TAG, "showWithAnim");
    if ((this.mNotificationViewPanel == null) || (this.mViewContainer == null) || (this.mNotificationView == null) || (this.mInAnimation == null)) {}
    do
    {
      return;
      if ((this.mInAnimation.hasStarted()) && (!this.mInAnimation.hasEnded()))
      {
        LogUtil.e(TAG, "show anim runing");
        return;
      }
      this.mNotificationViewPanel.setVisibility(0);
      this.mViewContainer.setVisibility(0);
      this.mNotificationView.setVisibility(0);
      this.mInAnimation.setAnimationListener(this.mInAminListener);
      this.mNotificationView.startAnimation(this.mInAnimation);
      if (this.mAnimListener != null) {
        this.mAnimListener.onShow();
      }
    } while (this.mDisplayListener == null);
    this.mDisplayListener.onShowWithAnim();
  }
  
  private void showWithoutAnim()
  {
    LogUtil.e(TAG, "showWithoutAnim");
    if ((this.mNotificationViewPanel == null) || (this.mViewContainer == null) || (this.mNotificationView == null)) {}
    do
    {
      return;
      this.mNotificationViewPanel.setVisibility(0);
      this.mViewContainer.setVisibility(0);
      this.mNotificationView.setVisibility(0);
      if (this.mAnimListener != null) {
        this.mAnimListener.onShow();
      }
    } while (this.mDisplayListener == null);
    this.mDisplayListener.onShowWithOutAnim();
  }
  
  public void dispose()
  {
    if (this.mNotificationView != null)
    {
      this.mNotificationView.clearAnimation();
      this.mNotificationView.setVisibility(8);
    }
    if (this.mViewContainer != null) {
      this.mViewContainer.removeView(this.mNotificationView);
    }
    ArrayList localArrayList1 = RGNotificationController.getInstance().getCommonViewList();
    ArrayList localArrayList2 = RGNotificationController.getInstance().getOperableViewList();
    if (((localArrayList1 == null) || (localArrayList1.isEmpty())) && ((localArrayList2 == null) || (localArrayList2.isEmpty())))
    {
      if (this.mViewContainer != null) {
        this.mViewContainer.setVisibility(8);
      }
      if (this.mNotificationViewPanel != null) {
        this.mNotificationViewPanel.setVisibility(8);
      }
    }
    this.mNotificationView = null;
    this.mViewContainer = null;
    this.mNotificationViewPanel = null;
    this.mRootViewGroup = null;
    this.mSubViewListener = null;
    this.mContext = null;
    if (this.mInAnimation != null) {
      this.mInAnimation.reset();
    }
    this.mInAnimation = null;
    if (this.mOutAnimation != null) {
      this.mOutAnimation.reset();
    }
    this.mOutAnimation = null;
  }
  
  public void hide()
  {
    LogUtil.e(TAG, "hide");
    super.hide();
    hideWithAnim();
  }
  
  protected void hideWithoutAnim()
  {
    LogUtil.e(TAG, "hideWithoutAnim");
    super.hide();
    if (this.mAnimListener != null) {
      this.mAnimListener.onHide();
    }
    if (this.mDisplayListener != null) {
      this.mDisplayListener.onHideWithOutAnim();
    }
    if (this.mNotificationView == null) {
      return;
    }
    this.mNotificationView.clearAnimation();
    this.mNotificationView.setVisibility(8);
  }
  
  public void recoveryView()
  {
    super.show();
    showWithoutAnim();
  }
  
  public void show()
  {
    LogUtil.e(TAG, "show");
    super.show();
    showWithAnim();
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
  
  protected static abstract interface AnimListener
  {
    public abstract void onHide();
    
    public abstract void onHideAnimEnd();
    
    public abstract void onShow();
    
    public abstract void onShowAnimEnd();
  }
  
  public static abstract interface NotificationDisplayListener
  {
    public abstract void onHideWithAnim();
    
    public abstract void onHideWithOutAnim();
    
    public abstract void onShowWithAnim();
    
    public abstract void onShowWithOutAnim();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMNotificationBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */