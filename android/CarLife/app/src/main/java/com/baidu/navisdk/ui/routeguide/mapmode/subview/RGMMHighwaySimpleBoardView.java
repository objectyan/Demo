package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMHighwaySimpleBoardView
  extends BNBaseView
{
  private static final String TAG = "RGMMHighwaySimpleBoardView";
  private View mRootView = null;
  private ImageView mServiceAreaBottomIcon = null;
  private TextView mServiceAreaBottomRemainDist = null;
  private TextView mServiceAreaBottomUnit = null;
  private View mServiceAreaBottomView = null;
  private TextView mServiceAreaExitCode = null;
  private LinearLayout mServiceAreaExitLayout = null;
  private TextView mServiceAreaExitName = null;
  private TextView mServiceAreaExitOrEnter = null;
  private View mServiceAreaExitSplitLine = null;
  private ImageView mServiceAreaTopIcon = null;
  private TextView mServiceAreaTopName = null;
  private TextView mServiceAreaTopRemainDist = null;
  private TextView mServiceAreaTopUnit = null;
  private View mServiceAreaTopView = null;
  private ViewGroup mViewContainer = null;
  
  public RGMMHighwaySimpleBoardView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
  }
  
  private void addToContainner()
  {
    this.mViewContainer = RGViewController.getInstance().getViewContails(1711866436);
    if (this.mViewContainer == null) {
      LogUtil.e("RGMMHighwaySimpleBoardView", "");
    }
    do
    {
      return;
      this.mViewContainer.removeAllViews();
    } while (this.mRootView == null);
    Object localObject = (ViewGroup)this.mRootView.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.mRootView);
    }
    if (!isVisibility())
    {
      this.mViewContainer.setVisibility(8);
      return;
    }
    int j;
    if (BNavConfig.pRGLocateMode == 2)
    {
      i = 0;
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      j = ScreenUtil.getInstance().dip2px(4.7F);
      if ((BNSettingManager.getIsShowMapSwitch() != 1) || (i == 0)) {
        break label171;
      }
    }
    label171:
    for (int i = ScreenUtil.getInstance().dip2px(30.0F);; i = j)
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(j, j, i, j);
      this.mViewContainer.addView(this.mRootView, (ViewGroup.LayoutParams)localObject);
      this.mViewContainer.setVisibility(0);
      return;
      i = 1;
      break;
    }
  }
  
  private void initViews()
  {
    this.mRootView = JarUtils.inflate((Activity)this.mContext, 1711472711, null);
    if (this.mRootView == null)
    {
      LogUtil.e("RGMMHighwaySimpleBoardView", "initViews mRootView is null");
      return;
    }
    this.mServiceAreaTopView = this.mRootView.findViewById(1711866493);
    this.mServiceAreaTopIcon = ((ImageView)this.mRootView.findViewById(1711866497));
    this.mServiceAreaTopName = ((TextView)this.mRootView.findViewById(1711866504));
    this.mServiceAreaTopRemainDist = ((TextView)this.mRootView.findViewById(1711866502));
    this.mServiceAreaTopUnit = ((TextView)this.mRootView.findViewById(1711866503));
    this.mServiceAreaBottomView = this.mRootView.findViewById(1711866492);
    this.mServiceAreaBottomIcon = ((ImageView)this.mRootView.findViewById(1711866494));
    this.mServiceAreaBottomRemainDist = ((TextView)this.mRootView.findViewById(1711866495));
    this.mServiceAreaBottomUnit = ((TextView)this.mRootView.findViewById(1711866496));
    this.mServiceAreaExitLayout = ((LinearLayout)this.mRootView.findViewById(1711866498));
    this.mServiceAreaExitOrEnter = ((TextView)this.mRootView.findViewById(1711866499));
    this.mServiceAreaExitCode = ((TextView)this.mRootView.findViewById(1711866501));
    this.mServiceAreaExitSplitLine = this.mRootView.findViewById(1711866500);
    this.mServiceAreaExitName = ((TextView)this.mRootView.findViewById(1711866505));
    updateDataByLastest();
  }
  
  private String subExitName(int paramInt, String paramString)
  {
    if (this.mServiceAreaExitName == null) {}
    int i;
    do
    {
      do
      {
        return paramString;
      } while (UIUtils.isTextFullDisplay(this.mServiceAreaExitName, paramInt, paramString, 1));
      i = paramString.lastIndexOf(" ");
    } while (i < 0);
    return subExitName(paramInt, paramString.substring(0, i));
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e("RGMMHighwaySimpleBoardView", "hide");
    if (this.mViewContainer != null) {
      this.mViewContainer.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    addToContainner();
  }
  
  public void setViewMarginRight(boolean paramBoolean)
  {
    if ((this.mViewContainer == null) || (this.mRootView == null))
    {
      LogUtil.e("RGMMHighwaySimpleBoardView", "");
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    int j = ScreenUtil.getInstance().dip2px(4.7F);
    if (paramBoolean) {}
    for (int i = JarUtils.getResources().getDimensionPixelOffset(1711734810) + ScreenUtil.getInstance().dip2px(2.0F);; i = j)
    {
      localLayoutParams.setMargins(j, j, i, j);
      this.mRootView.setLayoutParams(localLayoutParams);
      this.mViewContainer.invalidate();
      return;
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e("RGMMHighwaySimpleBoardView", "show");
    if ((this.mViewContainer == null) || (this.mViewContainer.getChildCount() == 0)) {
      addToContainner();
    }
    if (this.mViewContainer != null) {
      this.mViewContainer.setVisibility(0);
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    updateServiceView();
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
  
  public void updateServiceView()
  {
    Object localObject1 = RGHighwayModel.getInstance().getSimpleBoardShowType();
    if ((localObject1 == null) || (localObject1.length == 0)) {
      if (this.mRootView != null) {
        this.mRootView.setVisibility(8);
      }
    }
    label91:
    label205:
    label315:
    label451:
    label470:
    label491:
    label604:
    label780:
    do
    {
      return;
      if (this.mRootView != null) {
        this.mRootView.setVisibility(0);
      }
      Object localObject2;
      if (localObject1.length > 0)
      {
        if (this.mServiceAreaTopView != null)
        {
          this.mServiceAreaTopView.setVisibility(0);
          if (localObject1[0] != 2) {
            break label451;
          }
          this.mServiceAreaTopView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407668));
        }
        if ((localObject1[0] != 4) && (localObject1[0] != 0) && (localObject1[0] != 5)) {
          break label604;
        }
        if ((this.mServiceAreaExitLayout != null) && (this.mServiceAreaExitCode != null) && (this.mServiceAreaExitOrEnter != null) && (this.mServiceAreaExitSplitLine != null))
        {
          this.mServiceAreaExitLayout.setVisibility(0);
          if (localObject1[0] != 4) {
            break label491;
          }
          this.mServiceAreaExitOrEnter.setText("出口");
          if (TextUtils.isEmpty(RGHighwayModel.getInstance().getExitCode())) {
            break label470;
          }
          this.mServiceAreaExitCode.setText(RGHighwayModel.getInstance().getExitCode());
          this.mServiceAreaExitCode.setVisibility(0);
          this.mServiceAreaExitSplitLine.setVisibility(0);
        }
        if (this.mServiceAreaExitName != null)
        {
          localObject2 = RGHighwayModel.getInstance().getTypeName(localObject1[0]);
          this.mServiceAreaExitName.setText(subExitName(ScreenUtil.getInstance().dip2px(132), (String)localObject2));
          this.mServiceAreaExitName.setVisibility(0);
        }
        if ((this.mServiceAreaTopRemainDist != null) && (this.mServiceAreaTopUnit != null))
        {
          this.mServiceAreaTopRemainDist.setVisibility(8);
          this.mServiceAreaTopUnit.setVisibility(8);
        }
        if (this.mServiceAreaTopName != null) {
          this.mServiceAreaTopName.setVisibility(8);
        }
        if (this.mServiceAreaTopIcon != null) {
          this.mServiceAreaTopIcon.setVisibility(8);
        }
      }
      if (localObject1.length > 1)
      {
        if (this.mServiceAreaBottomView != null)
        {
          this.mServiceAreaBottomView.setVisibility(0);
          if ((localObject1[1] != 2) && (localObject1[1] != 3)) {
            break label780;
          }
          this.mServiceAreaBottomView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407667));
        }
        for (;;)
        {
          int i;
          String str;
          if ((this.mServiceAreaBottomRemainDist != null) && (this.mServiceAreaBottomUnit != null))
          {
            i = RGHighwayModel.getInstance().getTypeRemainDist(localObject1[1]);
            localObject2 = new StringBuffer();
            str = StringUtils.formatDistance(i, (StringBuffer)localObject2);
            this.mServiceAreaBottomRemainDist.setText(((StringBuffer)localObject2).toString());
            this.mServiceAreaBottomUnit.setText(str);
          }
          if (this.mServiceAreaBottomIcon == null) {
            break;
          }
          localObject1 = RGHighwayModel.getInstance().getTypeIcon(localObject1[1]);
          this.mServiceAreaBottomIcon.setImageDrawable((Drawable)localObject1);
          return;
          this.mServiceAreaTopView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407671));
          break label91;
          this.mServiceAreaExitCode.setVisibility(8);
          this.mServiceAreaExitSplitLine.setVisibility(8);
          break label205;
          if (localObject1[0] == 5)
          {
            this.mServiceAreaExitOrEnter.setText("出口");
            if (!TextUtils.isEmpty(RGHighwayModel.getInstance().getExitFastwayId()))
            {
              this.mServiceAreaExitCode.setText(RGHighwayModel.getInstance().getExitFastwayId());
              this.mServiceAreaExitCode.setVisibility(0);
              this.mServiceAreaExitSplitLine.setVisibility(0);
              break label205;
            }
            this.mServiceAreaExitCode.setVisibility(8);
            this.mServiceAreaExitSplitLine.setVisibility(8);
            break label205;
          }
          this.mServiceAreaExitOrEnter.setText("入口");
          this.mServiceAreaExitSplitLine.setVisibility(8);
          this.mServiceAreaExitCode.setVisibility(8);
          break label205;
          if (this.mServiceAreaExitLayout != null) {
            this.mServiceAreaExitLayout.setVisibility(8);
          }
          if (this.mServiceAreaExitName != null) {
            this.mServiceAreaExitName.setVisibility(8);
          }
          if ((this.mServiceAreaTopRemainDist != null) && (this.mServiceAreaTopUnit != null))
          {
            i = RGHighwayModel.getInstance().getTypeRemainDist(localObject1[0]);
            localObject2 = new StringBuffer();
            str = StringUtils.formatDistance(i, (StringBuffer)localObject2);
            this.mServiceAreaTopRemainDist.setText(((StringBuffer)localObject2).toString());
            this.mServiceAreaTopUnit.setText(str);
            this.mServiceAreaTopRemainDist.setVisibility(0);
            this.mServiceAreaTopUnit.setVisibility(0);
          }
          if (this.mServiceAreaTopName != null)
          {
            localObject2 = RGHighwayModel.getInstance().getTypeName(localObject1[0]);
            this.mServiceAreaTopName.setText((CharSequence)localObject2);
            this.mServiceAreaTopName.setVisibility(0);
          }
          if (this.mServiceAreaTopIcon == null) {
            break label315;
          }
          localObject2 = RGHighwayModel.getInstance().getTypeIcon(localObject1[0]);
          this.mServiceAreaTopIcon.setImageDrawable((Drawable)localObject2);
          this.mServiceAreaTopIcon.setVisibility(0);
          break label315;
          this.mServiceAreaBottomView.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407670));
        }
      }
    } while (this.mServiceAreaBottomView == null);
    this.mServiceAreaBottomView.setVisibility(8);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMHighwaySimpleBoardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */