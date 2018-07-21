package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.navisdk.ui.routeguide.model.RGCommonNotificationModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RGMMCommonNotificationView
  extends RGMMNotificationBaseView
{
  private static final String TAG = RGMMCommonNotificationView.class.getSimpleName();
  private BNImageLoadingListener mIconListener = null;
  private BNDisplayImageOptions mIconOptions = null;
  private String mIconUrl = null;
  private int mMainTitleColor = 0;
  private TextView mMainTitleTV = null;
  private String mMainTitleText = null;
  private RGCommonNotificationModel mModel = null;
  private int mNotificationColor = 0;
  private Drawable mNotificationIcon = null;
  private ImageView mNotificationIconIV = null;
  private RelativeLayout mNotificationLayout = null;
  private LinearLayout mSubThirdTitleLayout = null;
  private int mSubTitleColor = 0;
  private TextView mSubTitleTV = null;
  private String mSubTitleText = null;
  private int mThirdTitleColor = 0;
  private TextView mThirdTitleTV = null;
  private String mThirdTitleText = null;
  protected String mViewID = null;
  
  public RGMMCommonNotificationView(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramViewGroup);
    this.mNotificationType = paramInt;
    this.mViewID = String.valueOf(hashCode());
    initViews();
  }
  
  private void addClickListener()
  {
    if (this.mNotificationView == null) {
      return;
    }
    this.mNotificationView.setClickable(true);
    this.mNotificationView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RGMMCommonNotificationView.this.hide();
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
        this.mNotificationView = JarUtils.inflate((Activity)this.mContext, 1711472708, null);
      } while (this.mNotificationView == null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    } while (localLayoutParams == null);
    localLayoutParams.addRule(12);
    this.mViewContainer.addView(this.mNotificationView, localLayoutParams);
    this.mNotificationIconIV = ((ImageView)this.mNotificationView.findViewById(1711866464));
    this.mMainTitleTV = ((TextView)this.mNotificationView.findViewById(1711866467));
    this.mSubTitleTV = ((TextView)this.mNotificationView.findViewById(1711866469));
    this.mThirdTitleTV = ((TextView)this.mNotificationView.findViewById(1711866470));
    this.mNotificationLayout = ((RelativeLayout)this.mNotificationView.findViewById(1711866463));
    this.mSubThirdTitleLayout = ((LinearLayout)this.mNotificationView.findViewById(1711866468));
    removeClickListener();
    this.mAnimListener = new RGMMNotificationBaseView.AnimListener()
    {
      public void onHide() {}
      
      public void onHideAnimEnd()
      {
        RGMMCommonNotificationView.this.removeView();
        RGMMCommonNotificationView.this.removeClickListener();
      }
      
      public void onShow() {}
      
      public void onShowAnimEnd()
      {
        RGNotificationController.getInstance().hideOtherCommonViewBeforeThis(RGMMCommonNotificationView.this.mModel);
        RGMMCommonNotificationView.this.addClickListener();
      }
    };
    setPriority(this.mPriority);
    updateDataByLastest();
  }
  
  private void removeClickListener()
  {
    if (this.mNotificationView == null) {
      return;
    }
    this.mNotificationView.setClickable(false);
  }
  
  private void removeView()
  {
    RGNotificationController.getInstance().removeCommonView(this);
  }
  
  private void updateNotificaitonView()
  {
    setMainTitleText(this.mMainTitleText);
    setSubTitleText(this.mSubTitleText);
    setThirdTitleText(this.mThirdTitleText);
    setMainTitleColor(this.mMainTitleColor);
    setSubTitleColor(this.mSubTitleColor);
    setThirdTitleColor(this.mThirdTitleColor);
    setNotificationIcon(this.mNotificationIcon);
    setNotificationIcon(this.mIconUrl, this.mIconOptions, this.mIconListener);
    setNotificationColor(this.mNotificationColor);
  }
  
  public void hide()
  {
    super.hide();
    removeClickListener();
    RGNotificationController.getInstance().removeCommonModel(this.mModel);
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
    removeView();
    dispose();
  }
  
  public void hideWithoutRemoveModel()
  {
    super.hide();
    removeClickListener();
  }
  
  public void recoveryView()
  {
    if (!RGNotificationController.getInstance().allowNotificationShow(false, this.mNotificationType))
    {
      hideWithoutAnim();
      return;
    }
    super.recoveryView();
    addClickListener();
  }
  
  public RGMMCommonNotificationView setAllTitleColor(int paramInt)
  {
    setMainTitleColor(paramInt);
    setSubTitleColor(paramInt);
    setThirdTitleColor(paramInt);
    return this;
  }
  
  public RGMMCommonNotificationView setAutoHideTime(int paramInt)
  {
    this.mAutoHideTime = paramInt;
    return this;
  }
  
  public RGMMCommonNotificationView setDisplayListener(RGMMNotificationBaseView.NotificationDisplayListener paramNotificationDisplayListener)
  {
    this.mDisplayListener = paramNotificationDisplayListener;
    return this;
  }
  
  public RGMMCommonNotificationView setMainTitleColor(int paramInt)
  {
    if (this.mMainTitleTV == null) {
      return this;
    }
    this.mMainTitleColor = paramInt;
    this.mMainTitleTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMCommonNotificationView setMainTitleText(String paramString)
  {
    if ((this.mMainTitleTV == null) || (this.mSubTitleTV == null) || (this.mThirdTitleTV == null) || (TextUtils.isEmpty(paramString))) {
      return this;
    }
    this.mMainTitleText = paramString;
    this.mMainTitleTV.setText(paramString);
    this.mMainTitleTV.setVisibility(0);
    if ((this.mSubTitleTV.getVisibility() == 8) && (this.mThirdTitleTV.getVisibility() == 8))
    {
      this.mMainTitleTV.setMaxLines(2);
      return this;
    }
    this.mMainTitleTV.setMaxLines(1);
    return this;
  }
  
  public RGMMCommonNotificationView setModel(RGCommonNotificationModel paramRGCommonNotificationModel)
  {
    if (paramRGCommonNotificationModel == null) {
      return this;
    }
    this.mModel = paramRGCommonNotificationModel;
    return this;
  }
  
  public RGMMCommonNotificationView setNotificationColor(int paramInt)
  {
    if (this.mNotificationLayout == null) {
      return this;
    }
    this.mNotificationColor = paramInt;
    this.mNotificationLayout.setBackgroundColor(paramInt);
    return this;
  }
  
  public RGMMCommonNotificationView setNotificationIcon(Drawable paramDrawable)
  {
    if ((this.mNotificationIconIV == null) || (paramDrawable == null)) {
      return this;
    }
    this.mNotificationIcon = paramDrawable;
    this.mNotificationIconIV.setImageDrawable(paramDrawable);
    this.mNotificationIconIV.setVisibility(0);
    return this;
  }
  
  public RGMMCommonNotificationView setNotificationIcon(String paramString, BNDisplayImageOptions paramBNDisplayImageOptions, BNImageLoadingListener paramBNImageLoadingListener)
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
  
  public RGMMCommonNotificationView setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    if (paramInt == 100)
    {
      setNotificationColor(BNStyleManager.getColor(1711800745));
      setMainTitleColor(BNStyleManager.getColor(1711800748));
      setSubTitleColor(BNStyleManager.getColor(1711800749));
      setThirdTitleColor(BNStyleManager.getColor(1711800750));
      this.mAutoHideTime = 3000;
    }
    do
    {
      return this;
      if (paramInt == 200)
      {
        setNotificationColor(BNStyleManager.getColor(1711800746));
        setMainTitleColor(BNStyleManager.getColor(1711800751));
        setSubTitleColor(BNStyleManager.getColor(1711800752));
        setThirdTitleColor(BNStyleManager.getColor(1711800753));
        this.mAutoHideTime = 5000;
        return this;
      }
    } while (paramInt != 300);
    setNotificationColor(BNStyleManager.getColor(1711800747));
    setMainTitleColor(BNStyleManager.getColor(1711800754));
    setSubTitleColor(BNStyleManager.getColor(1711800755));
    setThirdTitleColor(BNStyleManager.getColor(1711800756));
    this.mAutoHideTime = 10000;
    return this;
  }
  
  public RGMMCommonNotificationView setSubTitleColor(int paramInt)
  {
    if (this.mSubTitleTV == null) {
      return this;
    }
    this.mSubTitleColor = paramInt;
    this.mSubTitleTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMCommonNotificationView setSubTitleText(String paramString)
  {
    if ((this.mSubTitleTV == null) || (TextUtils.isEmpty(paramString)) || (this.mMainTitleTV == null)) {
      return this;
    }
    this.mSubTitleText = paramString;
    this.mMainTitleTV.setMaxLines(1);
    this.mSubTitleTV.setText(paramString);
    this.mSubTitleTV.setVisibility(0);
    return this;
  }
  
  public RGMMCommonNotificationView setThirdTitleColor(int paramInt)
  {
    if (this.mThirdTitleTV == null) {
      return this;
    }
    this.mThirdTitleColor = paramInt;
    this.mThirdTitleTV.setTextColor(paramInt);
    return this;
  }
  
  public RGMMCommonNotificationView setThirdTitleText(String paramString)
  {
    if ((this.mMainTitleTV == null) || (this.mThirdTitleTV == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return this;
      this.mThirdTitleText = paramString;
      this.mMainTitleTV.setMaxLines(1);
      this.mThirdTitleTV.setText(paramString);
      this.mThirdTitleTV.setVisibility(0);
    } while ((this.mSubTitleTV == null) || (this.mSubThirdTitleLayout == null));
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("setThirdTitleText1-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        if ((RGMMCommonNotificationView.this.mSubTitleTV == null) || (RGMMCommonNotificationView.this.mSubThirdTitleLayout == null)) {
          return null;
        }
        RGMMCommonNotificationView.this.mSubTitleTV.setMaxWidth(RGMMCommonNotificationView.this.mSubThirdTitleLayout.getWidth() / 3 * 2);
        return null;
      }
    }, new BNWorkerConfig(2, 0));
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("setThirdTitleText2-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        if ((RGMMCommonNotificationView.this.mThirdTitleTV == null) || (RGMMCommonNotificationView.this.mSubThirdTitleLayout == null)) {
          return null;
        }
        RGMMCommonNotificationView.this.mThirdTitleTV.setMaxWidth(RGMMCommonNotificationView.this.mSubThirdTitleLayout.getWidth() / 3);
        return null;
      }
    }, new BNWorkerConfig(2, 0));
    return this;
  }
  
  public void show()
  {
    if ((!RGNotificationController.getInstance().allowNotificationShow(false, this.mNotificationType)) || (RGNotificationController.getInstance().hasOperableNotification()))
    {
      LogUtil.e(TAG, "not allow show or has operable notification showing");
      hideWithoutAnim();
    }
    do
    {
      return;
      if (this.mModel == null) {
        this.mModel = new RGCommonNotificationModel(this, this.mViewID, this.mPriority, this.mAutoHideTime, this.mMainTitleText, this.mSubTitleText, this.mThirdTitleText, this.mMainTitleColor, this.mSubTitleColor, this.mThirdTitleColor, this.mNotificationIcon, this.mNotificationColor, this.mDisplayListener, this.mIconUrl, this.mIconOptions, this.mIconListener, this.mNotificationType);
      }
      if (!RGNotificationController.getInstance().isContainsCommonModel(this.mModel))
      {
        RGNotificationController.getInstance().addCommonModel(this.mModel);
        super.show();
      }
    } while ((this.mModel == null) || (this.mModel.mHandler == null));
    this.mModel.mHandler.removeMessages(1000);
    this.mModel.mHandler.sendEmptyMessageDelayed(1000, this.mAutoHideTime);
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMCommonNotificationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */