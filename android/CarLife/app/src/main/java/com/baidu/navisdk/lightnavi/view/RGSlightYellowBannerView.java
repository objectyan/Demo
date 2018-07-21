package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.model.YellowBarMessage;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGSlightYellowBannerView
  extends RGSlightBaseView
{
  private static final String TAG = RGSlightYellowBannerView.class.getSimpleName();
  private boolean isShowYellowBanner = false;
  private ConditionMassageUpdateBean mCMUBean;
  private ImageView mIVGuideColse;
  private ImageView mIVGuideJam;
  private boolean mIsShow;
  private int mPriority;
  private TextView mRoadCondition;
  private RelativeLayout mRoadConditionClose;
  private TextView mRoadConditionLock;
  private RelativeLayout mRoadConditionParent;
  private int mRouteIndex;
  
  public RGSlightYellowBannerView(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    initView();
    initListener();
  }
  
  public RGSlightYellowBannerView(Context paramContext, ViewGroup paramViewGroup, Handler paramHandler)
  {
    super(paramContext, paramViewGroup, paramHandler);
    initView();
    initListener();
  }
  
  private void updateYellowBanner(boolean paramBoolean)
  {
    if ((this.isShowYellowBanner != paramBoolean) && (paramBoolean))
    {
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("updateYellowBanner: update show yellow banner bar; \npreview yellow banner status: ");
      if (this.isShowYellowBanner)
      {
        str1 = "show; ";
        localStringBuilder = localStringBuilder.append(str1).append("\nnow yellow banner status: ");
        if (!paramBoolean) {
          break label97;
        }
        str1 = "show";
        LogUtil.e(str2, str1);
        this.isShowYellowBanner = paramBoolean;
        UserOPController.getInstance().add("4.k", "", null, null);
      }
    }
    label97:
    while ((this.isShowYellowBanner == paramBoolean) || (paramBoolean)) {
      for (;;)
      {
        return;
        str1 = "hide; ";
        continue;
        str1 = "hide";
      }
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("updateYellowBanner: update hide yellow banner bar; \npreview yellow banner status: ");
    if (this.isShowYellowBanner)
    {
      str1 = "show; ";
      localStringBuilder = localStringBuilder.append(str1).append("\nnow yellow banner status: ");
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (String str1 = "show";; str1 = "hide")
    {
      LogUtil.e(str2, str1);
      this.isShowYellowBanner = paramBoolean;
      UserOPController.getInstance().add("4.k", null, "", null);
      return;
      str1 = "hide; ";
      break;
    }
  }
  
  public void focusBright()
  {
    if (this.mRoadConditionParent.getVisibility() == 0) {
      this.mRoadCondition.setFocusable(true);
    }
  }
  
  public void focusLock()
  {
    if (this.mRoadConditionLock.getVisibility() == 0) {
      this.mRoadConditionLock.setFocusable(true);
    }
  }
  
  public void hideGuideText(int paramInt)
  {
    LogUtil.e(TAG, "hideGuideText: priority --> " + paramInt);
    if (paramInt >= this.mPriority)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.mPriority == 2)
      {
        bool1 = bool2;
        if (paramInt != 5)
        {
          bool1 = bool2;
          if (paramInt > this.mPriority) {
            bool1 = true;
          }
        }
      }
      LogUtil.e(TAG, "hideGuideText: gpsMsgIsShowing --> " + bool1);
      if (!bool1)
      {
        this.mPriority = 0;
        this.mHandler.sendEmptyMessage(3001);
        if ((this.mRoadConditionParent != null) && (this.mRoadConditionLock != null))
        {
          updateYellowBanner(false);
          this.mRoadConditionParent.setVisibility(8);
          this.mRoadConditionLock.setVisibility(8);
        }
      }
    }
  }
  
  public void initListener()
  {
    this.mRoadConditionClose.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RGSlightYellowBannerView.this.mPriority == 2) {
          com.baidu.navisdk.lightnavi.LightNaviParams.mGpsInfoHasBeenClosed = true;
        }
        RGSlightYellowBannerView.this.hideGuideText(5);
        RGSlightYellowBannerView.this.updateYellowBanner(false);
        com.baidu.navisdk.lightnavi.LightNaviParams.isGuideHasBeanClose = true;
        if (RGSlightYellowBannerView.this.mCMUBean != null) {
          RGSlightYellowBannerView.this.mCMUBean.hasClosed = true;
        }
        if (RGSlightYellowBannerView.this.mPriority == 4) {
          BNSettingManager.setIPOGuideShowTime(0);
        }
      }
    });
  }
  
  public void initView()
  {
    this.mRoadCondition = ((TextView)this.mRootViewGroup.findViewById(1711866145));
    this.mRoadConditionClose = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866144));
    this.mRoadConditionParent = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866142));
    this.mRoadConditionLock = ((TextView)this.mRootViewGroup.findViewById(1711866202));
    this.mIVGuideJam = ((ImageView)this.mRootViewGroup.findViewById(1711866143));
  }
  
  public boolean isBrightConditionShow()
  {
    return (this.mRoadConditionParent != null) && (this.mRoadConditionParent.getVisibility() == 0);
  }
  
  public boolean isLockConditionShow()
  {
    return (this.mRoadConditionLock != null) && (this.mRoadConditionLock.getVisibility() == 0);
  }
  
  public void onRoadConditionUpdate()
  {
    Object localObject = BNRouteGuider.getInstance().getRoadConditionText4LightGuide();
    ConditionMassageUpdateBean localConditionMassageUpdateBean = new ConditionMassageUpdateBean();
    localConditionMassageUpdateBean.mGuideMsg = ((Bundle)localObject).getString("guideStr");
    localConditionMassageUpdateBean.mGuideType = ((Bundle)localObject).getInt("nRoadConditionTextType");
    localConditionMassageUpdateBean.mAddDist = ((Bundle)localObject).getInt("nGPAddDist");
    localConditionMassageUpdateBean.mObstructionLength = ((Bundle)localObject).getInt("nObstructionLengthPara");
    if (this.mCMUBean != null) {
      LogUtil.e("wangyang", "showGuideText_onIPORoadConditionUpdate txt =" + this.mCMUBean.mGuideMsg + " type= ," + localConditionMassageUpdateBean.mGuideType + " addDis= " + this.mCMUBean.mAddDist + "," + localConditionMassageUpdateBean.mAddDist + " olength= " + this.mCMUBean.mObstructionLength + "," + localConditionMassageUpdateBean.mObstructionLength);
    }
    if ((this.mCMUBean != null) && (this.mCMUBean.hasClosed) && (((this.mCMUBean.mGuideType == localConditionMassageUpdateBean.mGuideType) && (this.mCMUBean.mAddDist - localConditionMassageUpdateBean.mAddDist < this.mCMUBean.mObstructionLength)) || (localConditionMassageUpdateBean.mGuideMsg.equals(this.mCMUBean.mGuideMsg)))) {
      return;
    }
    LogUtil.e(TAG, "wy--SLIGHT_JAM show ");
    this.mCMUBean = localConditionMassageUpdateBean.copy(this.mCMUBean);
    localObject = new YellowBarMessage();
    ((YellowBarMessage)localObject).mPriority = 1;
    ((YellowBarMessage)localObject).mMsgContent = this.mCMUBean.mGuideMsg;
    ((YellowBarMessage)localObject).mRouteIndex = -1;
    showGuideText((YellowBarMessage)localObject);
    if (BNLightNaviManager.getInstance().getType() == 2)
    {
      this.mRoadCondition.setFocusable(true);
      return;
    }
    this.mRoadConditionLock.setFocusable(true);
  }
  
  public void showGuideText(YellowBarMessage paramYellowBarMessage)
  {
    LogUtil.e(TAG, "showGuideText: --> mPriority = " + this.mPriority + ", msg.mPriority=" + paramYellowBarMessage.mPriority);
    if (paramYellowBarMessage.mPriority == 4)
    {
      LogUtil.e(TAG, "showGuideText: --> SLIGHT_GUIDE ");
      this.mPriority = paramYellowBarMessage.mPriority;
      if ((this.mRoadCondition != null) && (this.mRoadConditionParent != null))
      {
        this.mRoadCondition.setText(paramYellowBarMessage.mMsgContent);
        this.mRoadConditionParent.setVisibility(0);
        updateYellowBanner(true);
      }
      if (this.mIVGuideJam != null) {
        this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(1711407933));
      }
    }
    label128:
    do
    {
      do
      {
        do
        {
          do
          {
            break label128;
            break label128;
            do
            {
              return;
            } while (paramYellowBarMessage.mPriority < this.mPriority);
            this.mPriority = paramYellowBarMessage.mPriority;
            if (paramYellowBarMessage.mPriority != 3) {
              break;
            }
            LogUtil.e(TAG, "showGuideText: --> SLIGHT_SWITCH ");
            this.mRouteIndex = paramYellowBarMessage.mRouteIndex;
            if (this.mRoadConditionLock != null)
            {
              this.mRoadConditionLock.setText(Html.fromHtml(paramYellowBarMessage.mMsgContent));
              this.mRoadConditionLock.setVisibility(0);
            }
            if ((this.mRoadCondition != null) && (this.mRoadConditionParent != null))
            {
              this.mRoadCondition.setText(Html.fromHtml(paramYellowBarMessage.mMsgContent));
              this.mRoadConditionParent.setVisibility(0);
              updateYellowBanner(true);
            }
          } while (this.mIVGuideJam == null);
          this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(1711407933));
          return;
          if (paramYellowBarMessage.mPriority != 2) {
            break;
          }
          LogUtil.e(TAG, "showGuideText: --> SLIGHT_GPS ");
          if (this.mRoadConditionLock != null)
          {
            this.mRoadConditionLock.setText(paramYellowBarMessage.mMsgContent);
            this.mRoadConditionLock.setVisibility(0);
          }
          if ((this.mRoadCondition != null) && (this.mRoadConditionParent != null))
          {
            this.mRoadCondition.setText(paramYellowBarMessage.mMsgContent);
            this.mRoadConditionParent.setVisibility(0);
            updateYellowBanner(true);
          }
        } while (this.mIVGuideJam == null);
        this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(1711407932));
        return;
      } while (paramYellowBarMessage.mPriority != 1);
      LogUtil.e(TAG, "showGuideText: --> SLIGHT_JAM ");
      if (this.mRoadConditionLock != null)
      {
        this.mRoadConditionLock.setText(paramYellowBarMessage.mMsgContent);
        this.mRoadConditionLock.setVisibility(0);
      }
      if ((this.mRoadCondition != null) && (this.mRoadConditionParent != null))
      {
        this.mRoadCondition.setText(paramYellowBarMessage.mMsgContent);
        this.mRoadConditionParent.setVisibility(0);
        updateYellowBanner(true);
      }
    } while (this.mIVGuideJam == null);
    this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(1711407934));
  }
  
  public void showOnlyBrightCondition()
  {
    if (this.mRoadConditionParent != null)
    {
      this.mRoadConditionLock.setVisibility(8);
      this.mRoadConditionParent.setVisibility(0);
    }
  }
  
  public class ConditionMassageUpdateBean
  {
    public boolean hasClosed = false;
    public int mAddDist;
    public String mGuideMsg;
    public int mGuideType;
    public int mObstructionLength;
    
    public ConditionMassageUpdateBean() {}
    
    public ConditionMassageUpdateBean copy(ConditionMassageUpdateBean paramConditionMassageUpdateBean)
    {
      ConditionMassageUpdateBean localConditionMassageUpdateBean = paramConditionMassageUpdateBean;
      if (paramConditionMassageUpdateBean == null) {
        localConditionMassageUpdateBean = new ConditionMassageUpdateBean(RGSlightYellowBannerView.this);
      }
      localConditionMassageUpdateBean.mGuideMsg = this.mGuideMsg;
      localConditionMassageUpdateBean.mGuideType = this.mGuideType;
      localConditionMassageUpdateBean.mAddDist = this.mAddDist;
      localConditionMassageUpdateBean.mObstructionLength = this.mObstructionLength;
      return localConditionMassageUpdateBean;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/RGSlightYellowBannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */