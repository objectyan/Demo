package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGOperableNotificationModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGMMOperableNotificationView
  extends RGMMNotificationBaseView
{
  private static final String TAG = RGMMOperableNotificationView.class.getSimpleName();
  private Drawable mCancelBackground = null;
  private int mCancelColor = 0;
  private RelativeLayout mCancelLayout = null;
  private RelativeLayout mCancelRelative = null;
  private TextView mCancelTV = null;
  private String mCancelText = null;
  private Drawable mConfirmBackground = null;
  private int mConfirmColor = 0;
  private RelativeLayout mConfirmLayout = null;
  private RelativeLayout mConfirmRelative = null;
  private TextView mConfirmTV = null;
  private String mConfirmText = null;
  private BNImageLoadingListener mIconListener = null;
  private BNDisplayImageOptions mIconOptions = null;
  private String mIconUrl = null;
  private boolean mIsShowMasking = false;
  private int mMainTitleColor = 0;
  private TextView mMainTitleTV = null;
  private String mMainTitleText = null;
  private RGOperableNotificationModel mModel = null;
  private Drawable mNotificationBackgroud = null;
  private int mNotificationColor = 0;
  private Drawable mNotificationIcon = null;
  private ImageView mNotificationIconIV = null;
  private LinearLayout mNotificationLayout = null;
  private NotificationClickListener mOnBtnClickListener = null;
  private boolean mShowCountingDown = false;
  private int mSubTitleColor = 0;
  private TextView mSubTitleTV = null;
  private String mSubTitleText = null;
  private String mViewID = null;
  
  public RGMMOperableNotificationView(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramViewGroup);
    this.mNotificationType = paramInt;
    this.mViewID = String.valueOf(hashCode());
    initViews();
  }
  
  private void addClickListener()
  {
    if ((this.mConfirmLayout == null) || (this.mCancelLayout == null)) {
      return;
    }
    this.mConfirmLayout.setClickable(true);
    this.mConfirmLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMOperableNotificationView.this.hide();
        if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
          RGMMOperableNotificationView.this.mOnBtnClickListener.onConfirmBtnClick();
        }
      }
    });
    this.mConfirmRelative.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMOperableNotificationView.this.hide();
        if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
          RGMMOperableNotificationView.this.mOnBtnClickListener.onConfirmBtnClick();
        }
      }
    });
    this.mCancelLayout.setClickable(true);
    this.mCancelLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMOperableNotificationView.this.hide();
        if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
          RGMMOperableNotificationView.this.mOnBtnClickListener.onCancelBtnClick();
        }
      }
    });
    this.mCancelRelative.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMOperableNotificationView.this.hide();
        if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
          RGMMOperableNotificationView.this.mOnBtnClickListener.onCancelBtnClick();
        }
      }
    });
  }
  
  private void initViews()
  {
    if ((this.mViewContainer == null) || (this.mContext == null)) {}
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        this.mNotificationView = JarUtils.inflate((Activity)this.mContext, 1711472732, null);
      } while (this.mNotificationView == null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    } while (localLayoutParams == null);
    localLayoutParams.addRule(12);
    this.mViewContainer.addView(this.mNotificationView, localLayoutParams);
    this.mNotificationIconIV = ((ImageView)this.mNotificationView.findViewById(1711866895));
    this.mMainTitleTV = ((TextView)this.mNotificationView.findViewById(1711866897));
    this.mSubTitleTV = ((TextView)this.mNotificationView.findViewById(1711866898));
    this.mConfirmLayout = ((RelativeLayout)this.mNotificationView.findViewById(1711866904));
    this.mCancelLayout = ((RelativeLayout)this.mNotificationView.findViewById(1711866901));
    this.mConfirmTV = ((TextView)this.mNotificationView.findViewById(1711866905));
    this.mCancelTV = ((TextView)this.mNotificationView.findViewById(1711866902));
    this.mNotificationLayout = ((LinearLayout)this.mNotificationView.findViewById(1711866893));
    this.mConfirmRelative = ((RelativeLayout)this.mNotificationView.findViewById(1711866903));
    this.mCancelRelative = ((RelativeLayout)this.mNotificationView.findViewById(1711866900));
    removeClickListener();
    this.mAnimListener = new RGMMNotificationBaseView.AnimListener()
    {
      public void onHide()
      {
        if (!RGNotificationController.getInstance().hasOtherOperableModelShowMasking(RGMMOperableNotificationView.this.mModel)) {
          RGViewController.getInstance().hideInterveneMasking();
        }
      }
      
      public void onHideAnimEnd()
      {
        RGMMOperableNotificationView.this.removeView();
        RGMMOperableNotificationView.this.removeClickListener();
        if (RGNotificationController.getInstance().getNotificationShowFocusListener() != null) {
          RGNotificationController.getInstance().getNotificationShowFocusListener().hide();
        }
      }
      
      public void onShow()
      {
        if (RGMMOperableNotificationView.this.mIsShowMasking) {
          RGViewController.getInstance().showInterveneMasking();
        }
        RGViewController.getInstance().hideControlPanel();
      }
      
      public void onShowAnimEnd()
      {
        RGMMOperableNotificationView.this.addClickListener();
        if (RGNotificationController.getInstance().getNotificationShowFocusListener() != null) {
          RGNotificationController.getInstance().getNotificationShowFocusListener().show();
        }
      }
    };
    setPriority(this.mPriority);
    updateDataByLastest();
  }
  
  private void removeClickListener()
  {
    if ((this.mConfirmLayout == null) || (this.mCancelLayout == null)) {
      return;
    }
    this.mConfirmLayout.setClickable(false);
    this.mCancelLayout.setClickable(false);
  }
  
  private void removeView()
  {
    RGNotificationController.getInstance().removeOperableView(this);
  }
  
  private void updateNotificaitonView()
  {
    setMainTitleText(this.mMainTitleText);
    setSubTitleText(this.mSubTitleText);
    setMainTitleColor(this.mMainTitleColor);
    setSubTitleColor(this.mSubTitleColor);
    setNotificationIcon(this.mNotificationIcon);
    setNotificationIcon(this.mIconUrl, this.mIconOptions, this.mIconListener);
    setNotificationColor(this.mNotificationColor);
    setConfirmText(this.mConfirmText);
    setCancelText(this.mCancelText);
    setConfirmBackground(this.mConfirmBackground);
    setCancelBackground(this.mCancelBackground);
    setConfirmTextColor(this.mConfirmColor);
    setCancelTextColor(this.mCancelColor);
  }
  
  public void autoHideWithoutClick()
  {
    if (this.mOnBtnClickListener != null) {
      this.mOnBtnClickListener.onAutoHideWithoutClick();
    }
  }
  
  public void clickCancelBtn()
  {
    if (this.mOnBtnClickListener != null) {
      this.mOnBtnClickListener.onCancelBtnClick();
    }
  }
  
  public Drawable getIconDrawable()
  {
    return this.mNotificationIconIV.getDrawable();
  }
  
  public ImageView getNotificationIcon()
  {
    return this.mNotificationIconIV;
  }
  
  public void hide()
  {
    super.hide();
    removeClickListener();
    RGNotificationController.getInstance().removeOperableModel(this.mModel);
    if (this.mModel != null)
    {
      this.mModel.reset();
      this.mModel = null;
    }
  }
  
  public void hideWithoutAnim()
  {
    super.hideWithoutAnim();
    removeClickListener();
  }
  
  public void hideWithoutRemoveModel()
  {
    super.hide();
    removeClickListener();
  }
  
  public void recoveryView()
  {
    if (!RGNotificationController.getInstance().allowNotificationShow(true, this.mNotificationType))
    {
      hideWithoutAnim();
      return;
    }
    super.recoveryView();
    addClickListener();
  }
  
  public RGMMOperableNotificationView setAutoHideTime(int paramInt)
  {
    this.mAutoHideTime = paramInt;
    return this;
  }
  
  public RGMMOperableNotificationView setCancelBackground(Drawable paramDrawable)
  {
    if ((this.mCancelLayout == null) || (paramDrawable == null)) {
      return this;
    }
    this.mCancelBackground = paramDrawable;
    this.mCancelLayout.setBackgroundDrawable(paramDrawable);
    this.mCancelLayout.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setCancelText(String paramString)
  {
    if ((this.mCancelTV == null) || (TextUtils.isEmpty(paramString))) {
      return this;
    }
    this.mCancelText = paramString;
    if ((this.mShowCountingDown) && (this.mModel != null) && (this.mModel.mCountingSecs > 0)) {
      this.mCancelTV.setText(paramString + " (" + this.mModel.mCountingSecs + "s)");
    }
    for (;;)
    {
      this.mCancelTV.setVisibility(0);
      return this;
      this.mCancelTV.setText(paramString);
    }
  }
  
  public RGMMOperableNotificationView setCancelTextColor(int paramInt)
  {
    if (this.mCancelTV == null) {
      return this;
    }
    this.mCancelColor = paramInt;
    this.mCancelTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMOperableNotificationView setConfirmBackground(Drawable paramDrawable)
  {
    if ((this.mConfirmLayout == null) || (paramDrawable == null)) {
      return this;
    }
    this.mConfirmBackground = paramDrawable;
    this.mConfirmLayout.setBackgroundDrawable(paramDrawable);
    this.mConfirmLayout.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setConfirmText(String paramString)
  {
    if ((this.mConfirmTV == null) || (TextUtils.isEmpty(paramString))) {
      return this;
    }
    this.mConfirmText = paramString;
    this.mConfirmTV.setText(paramString);
    this.mConfirmTV.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setConfirmTextColor(int paramInt)
  {
    if (this.mConfirmTV == null) {
      return this;
    }
    this.mConfirmColor = paramInt;
    this.mConfirmTV.setTextColor(paramInt);
    return this;
  }
  
  public void setCountingDown(boolean paramBoolean)
  {
    this.mShowCountingDown = paramBoolean;
  }
  
  public RGMMOperableNotificationView setDisplayListener(RGMMNotificationBaseView.NotificationDisplayListener paramNotificationDisplayListener)
  {
    this.mDisplayListener = paramNotificationDisplayListener;
    return this;
  }
  
  public RGMMOperableNotificationView setMainTitleColor(int paramInt)
  {
    if (this.mMainTitleTV == null) {
      return this;
    }
    this.mMainTitleColor = paramInt;
    this.mMainTitleTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMOperableNotificationView setMainTitleLine(int paramInt)
  {
    if ((this.mMainTitleTV == null) || (paramInt <= 0)) {
      return this;
    }
    this.mMainTitleTV.setMaxLines(paramInt);
    return this;
  }
  
  public RGMMOperableNotificationView setMainTitleText(String paramString)
  {
    if ((this.mMainTitleTV == null) || (TextUtils.isEmpty(paramString))) {
      return this;
    }
    this.mMainTitleText = paramString;
    this.mMainTitleTV.setText(paramString);
    this.mMainTitleTV.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setModel(RGOperableNotificationModel paramRGOperableNotificationModel)
  {
    if (paramRGOperableNotificationModel == null) {
      return this;
    }
    this.mModel = paramRGOperableNotificationModel;
    return this;
  }
  
  public RGMMOperableNotificationView setNotificationBackground(Drawable paramDrawable)
  {
    if ((this.mNotificationIconIV == null) || (paramDrawable == null)) {
      return this;
    }
    this.mNotificationBackgroud = paramDrawable;
    this.mNotificationIconIV.setBackgroundDrawable(paramDrawable);
    this.mNotificationIconIV.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setNotificationColor(int paramInt)
  {
    if (this.mNotificationLayout == null) {
      return this;
    }
    this.mNotificationColor = paramInt;
    this.mNotificationLayout.setBackgroundColor(paramInt);
    return this;
  }
  
  public RGMMOperableNotificationView setNotificationIcon(Drawable paramDrawable)
  {
    if ((this.mNotificationIconIV == null) || (paramDrawable == null)) {
      return this;
    }
    this.mNotificationIcon = paramDrawable;
    this.mNotificationIconIV.setImageDrawable(paramDrawable);
    this.mNotificationIconIV.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setNotificationIcon(String paramString, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener)
  {
    if (this.mNotificationIconIV == null) {
      return this;
    }
    this.mIconUrl = paramString;
    this.mIconOptions = paramBNDisplayImageOptions;
    this.mIconListener = paramBNImageLoadingListener;
    BNImageLoader.getInstance().displayImage(paramString, this.mNotificationIconIV, paramBNDisplayImageOptions, paramBNImageLoadingListener);
    this.mNotificationIconIV.setVisibility(0);
    return this;
  }
  
  public RGMMOperableNotificationView setOnClick(NotificationClickListener paramNotificationClickListener)
  {
    this.mOnBtnClickListener = paramNotificationClickListener;
    return this;
  }
  
  public RGMMOperableNotificationView setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    if (paramInt == 100)
    {
      setNotificationColor(BNStyleManager.getColor(1711800757));
      setMainTitleColor(BNStyleManager.getColor(1711800758));
      setSubTitleColor(BNStyleManager.getColor(1711800759));
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(BNStyleManager.getColor(1711800760));
      localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(50));
      setConfirmBackground(localGradientDrawable);
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(1711800688));
      localGradientDrawable.setColor(BNStyleManager.getColor(1711800757));
      localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(50));
      setCancelBackground(localGradientDrawable);
      setConfirmTextColor(BNStyleManager.getColor(1711800762));
      setCancelTextColor(BNStyleManager.getColor(1711800763));
      this.mAutoHideTime = 10000;
    }
    do
    {
      return this;
      if (paramInt == 200)
      {
        setNotificationColor(BNStyleManager.getColor(1711800757));
        setMainTitleColor(BNStyleManager.getColor(1711800758));
        setSubTitleColor(BNStyleManager.getColor(1711800759));
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(BNStyleManager.getColor(1711800764));
        localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
        setConfirmBackground(localGradientDrawable);
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(1711800688));
        localGradientDrawable.setColor(BNStyleManager.getColor(1711800757));
        localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
        setCancelBackground(localGradientDrawable);
        setConfirmTextColor(BNStyleManager.getColor(1711800766));
        setCancelTextColor(BNStyleManager.getColor(1711800767));
        this.mAutoHideTime = 15000;
        return this;
      }
    } while (paramInt != 300);
    setNotificationColor(BNStyleManager.getColor(1711800757));
    setMainTitleColor(BNStyleManager.getColor(1711800758));
    setSubTitleColor(BNStyleManager.getColor(1711800759));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(BNStyleManager.getColor(1711800768));
    localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
    setConfirmBackground(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(1711800688));
    localGradientDrawable.setColor(BNStyleManager.getColor(1711800757));
    localGradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
    setCancelBackground(localGradientDrawable);
    setConfirmTextColor(BNStyleManager.getColor(1711800770));
    setCancelTextColor(BNStyleManager.getColor(1711800771));
    this.mAutoHideTime = 20000;
    return this;
  }
  
  public RGMMOperableNotificationView setShowMasking(boolean paramBoolean)
  {
    this.mIsShowMasking = paramBoolean;
    return this;
  }
  
  public RGMMOperableNotificationView setSubTitleColor(int paramInt)
  {
    if (this.mSubTitleTV == null) {
      return this;
    }
    this.mSubTitleColor = paramInt;
    this.mSubTitleTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMOperableNotificationView setSubTitleText(String paramString)
  {
    if ((this.mSubTitleTV == null) || (TextUtils.isEmpty(paramString))) {
      return this;
    }
    this.mSubTitleText = paramString;
    this.mSubTitleTV.setText(paramString);
    this.mSubTitleTV.setVisibility(0);
    return this;
  }
  
  public void show()
  {
    RGNotificationController.getInstance().hideAllCommonView();
    RGNotificationController.getInstance().hideRepeatedOperableView(this.mNotificationType);
    if (this.mModel == null) {
      this.mModel = new RGOperableNotificationModel(this, this.mViewID, this.mPriority, this.mAutoHideTime, this.mMainTitleText, this.mSubTitleText, this.mMainTitleColor, this.mSubTitleColor, this.mConfirmText, this.mCancelText, this.mConfirmColor, this.mCancelColor, this.mNotificationIcon, this.mNotificationColor, this.mConfirmBackground, this.mCancelBackground, this.mOnBtnClickListener, this.mDisplayListener, this.mIconUrl, this.mIconOptions, this.mIconListener, this.mNotificationType, this.mIsShowMasking);
    }
    if (!RGNotificationController.getInstance().isContainsOperableModel(this.mModel))
    {
      RGNotificationController.getInstance().addOperableModel(this.mModel);
      if (!RGNotificationController.getInstance().allowNotificationShow(true, this.mNotificationType)) {
        break label312;
      }
      super.show();
    }
    for (;;)
    {
      if ((this.mModel != null) && (this.mModel.mHandler != null))
      {
        this.mModel.mHandler.removeMessages(1000);
        if (this.mAutoHideTime >= 0) {
          this.mModel.mHandler.sendEmptyMessageDelayed(1000, this.mAutoHideTime);
        }
      }
      if (this.mShowCountingDown)
      {
        this.mModel.mCountingSecs = ((int)Math.ceil(this.mAutoHideTime / 1000.0D));
        if ((this.mModel != null) && (this.mModel.mHandler != null))
        {
          this.mModel.mHandler.removeMessages(1001);
          if ((this.mAutoHideTime >= 0) && (this.mModel.mCountingSecs > 0)) {
            this.mModel.mHandler.sendEmptyMessageDelayed(1001, 1000L);
          }
        }
      }
      return;
      label312:
      LogUtil.e(TAG, "not allow show");
      hideWithoutAnim();
    }
  }
  
  public RGMMOperableNotificationView showNotificationIcon(boolean paramBoolean)
  {
    if (this.mNotificationIconIV == null) {
      return this;
    }
    ImageView localImageView = this.mNotificationIconIV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return this;
    }
  }
  
  public RGMMOperableNotificationView updateCancelTextCounting()
  {
    if ((this.mCancelTV == null) || (TextUtils.isEmpty(this.mCancelText))) {
      return this;
    }
    if ((this.mShowCountingDown) && (this.mModel != null) && (this.mModel.mCountingSecs > 0)) {
      this.mCancelTV.setText(this.mCancelText + " (" + this.mModel.mCountingSecs + "s)");
    }
    for (;;)
    {
      this.mCancelTV.setVisibility(0);
      return this;
      this.mCancelTV.setText(this.mCancelText);
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    updateNotificaitonView();
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
  
  public static abstract interface NotificationClickListener
  {
    public abstract void onAutoHideWithoutClick();
    
    public abstract void onCancelBtnClick();
    
    public abstract void onConfirmBtnClick();
  }
  
  public static abstract interface NotificationShowFocusListener
  {
    public abstract void hide();
    
    public abstract void show();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMOperableNotificationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */