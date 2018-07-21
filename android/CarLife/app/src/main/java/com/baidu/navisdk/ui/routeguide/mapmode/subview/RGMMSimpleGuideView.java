package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.ArrayList;

public class RGMMSimpleGuideView
  extends BNBaseView
{
  private static final String TAG = "guide_info";
  private TextView mAfterLabelInfoTV = null;
  private TextView mAfterMetersInfoTV = null;
  private View mAlongRoadView = null;
  private Animation mAnim = null;
  private ImageView mConsecutiveIcon = null;
  private View mConsecutivePointTV = null;
  private TextView mCurRoadNameTV = null;
  private TextView mCurRoadRemainDistTV = null;
  private TextView mCurRoadRemainDistWordTV = null;
  private TextView mFullviewOrNaviView = null;
  private RelativeLayout mFuzzyLayout = null;
  private TextView mFuzzyTV = null;
  private TextView mGoWhereInfoTV = null;
  private RelativeLayout mGuideInfoLayout = null;
  private boolean mHasRemoveCurVia = false;
  private RelativeLayout mLandspaceLeftPanel = null;
  private TextView mLinkInfoTV = null;
  private TextView mLocationInfoTV = null;
  private View mPortraitTopPanel = null;
  private ImageView mProgress = null;
  private RelativeLayout mProgressLayout = null;
  private int mRemainDist = 0;
  private TextView mSatelliteInfoTV = null;
  private TextView mSatelliteInfoTV2 = null;
  private View mSimpleGuideView = null;
  private LinearLayout mStatusBar = null;
  private ImageView mTurnIcon = null;
  
  public RGMMSimpleGuideView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateDataByLastest();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    this.mSimpleGuideView = this.mRootViewGroup.findViewById(1711866644);
    this.mGuideInfoLayout = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866654));
    this.mProgressLayout = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866649));
    this.mFuzzyLayout = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866645));
    this.mTurnIcon = ((ImageView)this.mRootViewGroup.findViewById(1711866386));
    this.mAfterMetersInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866388));
    this.mAfterLabelInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866389));
    this.mLinkInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866655));
    this.mGoWhereInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866391));
    if (RGViewController.getInstance().getOrientation() == 2)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mGoWhereInfoTV.getLayoutParams();
      localLayoutParams.width = ScreenUtil.getInstance().getGuidePanelWidth();
      this.mGoWhereInfoTV.setLayoutParams(localLayoutParams);
      this.mGoWhereInfoTV.setGravity(1);
    }
    this.mAlongRoadView = this.mRootViewGroup.findViewById(1711866392);
    this.mCurRoadNameTV = ((TextView)this.mRootViewGroup.findViewById(1711866396));
    this.mCurRoadRemainDistTV = ((TextView)this.mRootViewGroup.findViewById(1711866398));
    this.mCurRoadRemainDistWordTV = ((TextView)this.mRootViewGroup.findViewById(1711866656));
    this.mStatusBar = ((LinearLayout)this.mRootViewGroup.findViewById(1711865926));
    this.mLocationInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866651));
    this.mSatelliteInfoTV = ((TextView)this.mRootViewGroup.findViewById(1711866652));
    this.mSatelliteInfoTV2 = ((TextView)this.mRootViewGroup.findViewById(1711866653));
    this.mConsecutivePointTV = this.mRootViewGroup.findViewById(1711866432);
    this.mConsecutiveIcon = ((ImageView)this.mRootViewGroup.findViewById(1711866433));
    this.mProgress = ((ImageView)this.mRootViewGroup.findViewById(1711866650));
    this.mFuzzyTV = ((TextView)this.mFuzzyLayout.findViewById(1711866648));
    if (RGViewController.getInstance().getOrientation() == 2)
    {
      this.mLandspaceLeftPanel = ((RelativeLayout)this.mRootViewGroup.findViewById(1711866556));
      this.mPortraitTopPanel = null;
    }
    for (;;)
    {
      if (this.mSimpleGuideView != null) {
        this.mSimpleGuideView.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return true;
          }
        });
      }
      if (this.mTurnIcon == null) {
        break;
      }
      this.mTurnIcon.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (2 != BNavConfig.pRGLocateMode) {
            UserOPController.getInstance().add("3.8");
          }
        }
      });
      return;
      this.mPortraitTopPanel = this.mRootViewGroup.findViewById(1711866525);
      this.mLandspaceLeftPanel = null;
    }
  }
  
  private void justSetAlongRoadInfoVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if (this.mAlongRoadView != null) {
        this.mAlongRoadView.setVisibility(i);
      }
      if (this.mTurnIcon != null) {
        this.mTurnIcon.setVisibility(i);
      }
      return;
    }
  }
  
  private void justSetConsecutivePointInfoVisible(boolean paramBoolean) {}
  
  private void justSetGPSLocationInfoVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if (this.mLocationInfoTV != null) {
        this.mLocationInfoTV.setVisibility(i);
      }
      if ((this.mSatelliteInfoTV != null) && (this.mSatelliteInfoTV2 != null))
      {
        this.mSatelliteInfoTV.setVisibility(i);
        this.mSatelliteInfoTV2.setVisibility(i);
      }
      return;
    }
  }
  
  private void justSetNormalSGInfoVisible(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (this.mAfterMetersInfoTV != null) {
        this.mAfterMetersInfoTV.setVisibility(i);
      }
      if (this.mAfterLabelInfoTV != null) {
        this.mAfterLabelInfoTV.setVisibility(i);
      }
      if (this.mLinkInfoTV != null) {
        this.mLinkInfoTV.setVisibility(i);
      }
      if ((this.mGoWhereInfoTV != null) && ((this.mGoWhereInfoTV.getVisibility() != 0) || (i != 0))) {
        break label94;
      }
    }
    for (;;)
    {
      if (this.mTurnIcon != null) {
        this.mTurnIcon.setVisibility(i);
      }
      return;
      i = 8;
      break;
      label94:
      this.mGoWhereInfoTV.setVisibility(i);
    }
  }
  
  private void showAlongRoadInfoView()
  {
    justSetGPSLocationInfoVisible(false);
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(true);
    justSetConsecutivePointInfoVisible(false);
  }
  
  private void showCarlogoFreeView()
  {
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(false);
    justSetConsecutivePointInfoVisible(false);
    if ((this.mSatelliteInfoTV != null) && (this.mSatelliteInfoTV2 != null))
    {
      this.mSatelliteInfoTV.setVisibility(8);
      this.mSatelliteInfoTV2.setVisibility(8);
    }
    if (this.mLocationInfoTV != null)
    {
      this.mProgressLayout.setVisibility(0);
      this.mLocationInfoTV.setVisibility(0);
      this.mLocationInfoTV.setText(BNStyleManager.getString(1711669437));
    }
  }
  
  private void showGPSSettingView()
  {
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(false);
    justSetConsecutivePointInfoVisible(false);
    if ((this.mSatelliteInfoTV != null) && (this.mSatelliteInfoTV2 != null))
    {
      this.mSatelliteInfoTV.setVisibility(8);
      this.mSatelliteInfoTV2.setVisibility(8);
    }
    if (this.mLocationInfoTV != null)
    {
      this.mProgressLayout.setVisibility(0);
      this.mLocationInfoTV.setVisibility(0);
      this.mLocationInfoTV.setText(BNStyleManager.getString(1711669436));
    }
  }
  
  private void showLocatingView()
  {
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(false);
    justSetConsecutivePointInfoVisible(false);
    if (this.mLocationInfoTV != null) {
      this.mLocationInfoTV.setVisibility(8);
    }
  }
  
  private void showNormalSGInfoView()
  {
    justSetAlongRoadInfoVisible(false);
    justSetGPSLocationInfoVisible(false);
    justSetNormalSGInfoVisible(true);
    justSetConsecutivePointInfoVisible(false);
  }
  
  private void showWaitCalRouteFinish()
  {
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(false);
    justSetConsecutivePointInfoVisible(false);
    if ((this.mSatelliteInfoTV != null) && (this.mSatelliteInfoTV2 != null))
    {
      this.mSatelliteInfoTV.setVisibility(8);
      this.mSatelliteInfoTV2.setVisibility(8);
    }
    if (this.mLocationInfoTV == null) {
      return;
    }
    this.mProgressLayout.setVisibility(0);
    this.mLocationInfoTV.setVisibility(0);
    if (RGSimpleGuideModel.getInstance().isCalcRouteFail)
    {
      this.mLocationInfoTV.setText(JarUtils.getResources().getString(1711670341));
      return;
    }
    this.mLocationInfoTV.setText(JarUtils.getResources().getString(1711670340));
  }
  
  private void updateConsecutivePointInfo() {}
  
  private void updateTurnIconAnim(int paramInt)
  {
    if (this.mGuideInfoLayout != null)
    {
      localObject = this.mTurnIcon.getTag();
      if ((localObject != null) && (((Integer)localObject).intValue() != paramInt)) {
        if (RGMapModeViewController.getInstance().getOrientation() != 2) {
          break label88;
        }
      }
    }
    label88:
    for (Object localObject = new TranslateAnimation(0.0F, 0.0F, -ScreenUtil.getInstance().dip2px(50), 0.0F);; localObject = new TranslateAnimation(ScreenUtil.getInstance().getWidthPixels() / 3, 0.0F, 0.0F, 0.0F))
    {
      ((TranslateAnimation)localObject).setDuration(400L);
      this.mGuideInfoLayout.startAnimation((Animation)localObject);
      this.mTurnIcon.setTag(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public String debugViewState()
  {
    Object localObject2 = "";
    if (this.mTurnIcon != null) {
      localObject2 = "" + " icon: " + this.mTurnIcon.getVisibility();
    }
    Object localObject1 = localObject2;
    if (this.mAfterMetersInfoTV != null) {
      localObject1 = (String)localObject2 + " AfterM: " + this.mAfterMetersInfoTV.getVisibility();
    }
    localObject2 = localObject1;
    if (this.mGoWhereInfoTV != null) {
      localObject2 = (String)localObject1 + " GoWhere: " + this.mGoWhereInfoTV.getVisibility();
    }
    localObject1 = localObject2;
    if (this.mAlongRoadView != null) {
      localObject1 = (String)localObject2 + " AlongR: " + this.mAlongRoadView.getVisibility();
    }
    localObject2 = localObject1;
    if (this.mLocationInfoTV != null) {
      localObject2 = (String)localObject1 + " Location: " + this.mLocationInfoTV.getVisibility();
    }
    localObject1 = localObject2;
    if (this.mSatelliteInfoTV != null) {
      localObject1 = (String)localObject2 + " Satellite: " + this.mSatelliteInfoTV.getVisibility();
    }
    localObject2 = localObject1;
    if (this.mSatelliteInfoTV2 != null) {
      localObject2 = (String)localObject1 + " Satellite2: " + this.mSatelliteInfoTV2.getVisibility();
    }
    return (String)localObject2;
  }
  
  public void dispose()
  {
    super.dispose();
    UIUtils.releaseImageView(this.mTurnIcon);
  }
  
  public View getRootView()
  {
    if (this.mPortraitTopPanel != null) {
      return this.mPortraitTopPanel;
    }
    if (this.mLandspaceLeftPanel != null) {
      return this.mLandspaceLeftPanel;
    }
    return null;
  }
  
  public int getSBViewHeight()
  {
    if (this.mStatusBar != null) {
      return this.mStatusBar.getHeight();
    }
    return 0;
  }
  
  public int getSPViewHeight()
  {
    if (this.mSimpleGuideView != null) {
      return this.mSimpleGuideView.getHeight();
    }
    return 0;
  }
  
  public void hide()
  {
    super.hide();
    if (this.mSimpleGuideView != null) {
      this.mSimpleGuideView.setVisibility(8);
    }
    if (this.mConsecutivePointTV != null) {
      this.mConsecutivePointTV.setVisibility(8);
    }
  }
  
  public void hideLandspaceLeftPanel()
  {
    if (this.mLandspaceLeftPanel != null) {
      this.mLandspaceLeftPanel.setVisibility(4);
    }
  }
  
  public void hideSatelliteProgressView()
  {
    if ((this.mProgress != null) && (this.mProgress.getVisibility() == 0))
    {
      this.mProgressLayout.setVisibility(8);
      this.mProgress.setVisibility(8);
      this.mProgress.clearAnimation();
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initViews();
    updateDataByLastest();
  }
  
  public void show()
  {
    super.show();
    if (this.mSimpleGuideView != null)
    {
      this.mSimpleGuideView.setVisibility(0);
      if (!RGViewController.getInstance().isDeviceStateViewShowing()) {
        RGViewController.getInstance().showDeviceStateView();
      }
    }
  }
  
  public void showFuzzyGuide(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFuzzyLayout.setVisibility(0);
      this.mGuideInfoLayout.setVisibility(8);
      this.mConsecutivePointTV.setVisibility(8);
      this.mProgressLayout.setVisibility(8);
      this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
    }
    for (;;)
    {
      RGViewController.getInstance().setMapDrawScreenRect();
      return;
      this.mFuzzyLayout.setVisibility(8);
      this.mProgressLayout.setVisibility(0);
      this.mGuideInfoLayout.setVisibility(0);
      this.mConsecutivePointTV.setVisibility(0);
    }
  }
  
  public void showLandspaceLeftPanel()
  {
    if (this.mLandspaceLeftPanel != null) {
      this.mLandspaceLeftPanel.setVisibility(0);
    }
  }
  
  public void showSatelliteProgressView()
  {
    LogUtil.e("guide_info", "showSatelliteProgressView -- ");
    if (this.mProgress != null)
    {
      this.mProgressLayout.setVisibility(0);
      this.mProgress.setVisibility(0);
      if (this.mAnim == null) {
        this.mAnim = BNStyleManager.loadAnimation(this.mContext, 1711538194);
      }
      LinearInterpolator localLinearInterpolator = new LinearInterpolator();
      if (localLinearInterpolator != null) {
        this.mAnim.setInterpolator(localLinearInterpolator);
      }
      if (this.mAnim != null) {
        this.mProgress.startAnimation(this.mAnim);
      }
    }
  }
  
  public void showSuitableView()
  {
    try
    {
      if ((!BNavigator.getInstance().hasCalcRouteOk()) && (!RGSimpleGuideModel.getInstance().isFirstDataOk))
      {
        showWaitCalRouteFinish();
        showSatelliteProgressView();
        LogUtil.e("guide_info", "hasCalcRouteOk -- > false ,  cannot updateData!");
        return;
      }
      if (RGSimpleGuideModel.getInstance().isYawing())
      {
        LogUtil.e("guide_info", "Yawing now! cannot updateData!");
        showYawingProgressView(JarUtils.getResources().getString(1711669432));
        return;
      }
      if ((BNavConfig.pRGLocateMode == 1) || (BNavConfig.pRGLocateMode == 5))
      {
        if (!RGSimpleGuideModel.getInstance().isGPSOpened())
        {
          LogUtil.e("guide_info", "showGPSSettingView!");
          hideSatelliteProgressView();
          showGPSSettingView();
          return;
        }
        if (RGSimpleGuideModel.getInstance().isCarlogoFree())
        {
          LogUtil.e("guide_info", "not data route, showCarlogoFreeView!");
          hideSatelliteProgressView();
          showCarlogoFreeView();
          return;
        }
      }
      hideSatelliteProgressView();
      if (RGSimpleGuideModel.getInstance().isStraight())
      {
        ImageView localImageView = this.mTurnIcon;
        if (localImageView == null) {}
      }
      try
      {
        this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(1711407697));
        showNormalSGInfoView();
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
      return;
    }
    catch (Throwable localThrowable2) {}
  }
  
  public void showYawingProgressView(String paramString)
  {
    LogUtil.e("guide_info", "showYawingProgressView()");
    justSetNormalSGInfoVisible(false);
    justSetAlongRoadInfoVisible(false);
    justSetConsecutivePointInfoVisible(false);
    if ((this.mSatelliteInfoTV != null) && (this.mSatelliteInfoTV2 != null))
    {
      this.mSatelliteInfoTV.setVisibility(8);
      this.mSatelliteInfoTV2.setVisibility(8);
    }
    if (this.mLocationInfoTV == null) {
      return;
    }
    this.mProgressLayout.setVisibility(0);
    this.mLocationInfoTV.setVisibility(0);
    this.mLocationInfoTV.setText(paramString);
    showSatelliteProgressView();
  }
  
  public void updateCurRoadName() {}
  
  public void updateData(Bundle paramBundle)
  {
    LogUtil.e("guide_info", "updateData = " + paramBundle.toString());
    if (paramBundle == null)
    {
      LogUtil.e("guide_info", "updateData --> bundle==null");
      return;
    }
    if (RGSimpleGuideModel.getInstance().isYawing())
    {
      LogUtil.e("guide_info", "Yawing now! cannot updateData!");
      showYawingProgressView(JarUtils.getResources().getString(1711669432));
      return;
    }
    int i = paramBundle.getInt("updatetype");
    Object localObject;
    if (i == 1)
    {
      if ((paramBundle.getBoolean("is_first")) && (RGSimpleGuideModel.getInstance().isFirstGuideFuzzy()))
      {
        showFuzzyGuide(true);
        return;
      }
      if (RGMapModeViewController.getInstance().isFuzzyMode())
      {
        this.mFuzzyTV.setText(RGSimpleGuideModel.getInstance().getFuzzyTV());
        showFuzzyGuide(true);
        return;
      }
      i = paramBundle.getInt("resid", 0);
      paramBundle.getInt("start_dist", 1);
      int j = paramBundle.getInt("remain_dist", 0);
      this.mRemainDist = j;
      String str1 = paramBundle.getString("road_name");
      LogUtil.e("guide_info", "updateData! --> nextRoadName = " + str1);
      if (str1 != null)
      {
        localObject = str1;
        if (str1.length() != 0) {}
      }
      else
      {
        localObject = JarUtils.getResources().getString(1711669540);
      }
      BNEventManager.getInstance().onRoadNameUpdate((String)localObject);
      if (i != 0) {}
      try
      {
        updateTurnIconAnim(i);
        if (RightHandResourcesProvider.getEnNaviType() != 0) {
          break label734;
        }
        this.mTurnIcon.setImageDrawable(JarUtils.getResources().getDrawable(i));
        BNEventManager.getInstance().onRoadTurnInfoIconUpdate(JarUtils.getResources().getDrawable(i));
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          String str3;
          String str2;
          int k;
          continue;
          this.mAfterMetersInfoTV.setTextSize(1, 30.0F);
          this.mAfterMetersInfoTV.setText("现在");
          this.mAfterLabelInfoTV.setText("");
          continue;
          this.mLinkInfoTV.setText(JarUtils.getResources().getString(1711669862));
          continue;
          this.mConsecutiveIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(k));
          continue;
          RGViewController.getInstance().requestShowExpendView(7, false, 1);
          LogUtil.e(RGLaneInfoModel.TAG, "simpleguide false");
          continue;
          this.mHasRemoveCurVia = false;
          continue;
          this.mHasRemoveCurVia = false;
        }
      }
      str3 = RGSimpleGuideModel.getInstance().getFormatAfterMeters(j);
      str1 = RGSimpleGuideModel.getInstance().getDistStart(str3);
      str2 = RGSimpleGuideModel.getInstance().getDistEnd(str3);
      if ((this.mAfterMetersInfoTV != null) && (this.mAfterLabelInfoTV != null) && (str1 != null) && (str2 != null))
      {
        if (j > 10)
        {
          this.mAfterMetersInfoTV.setTextSize(1, 34.0F);
          this.mAfterMetersInfoTV.setText(str1);
          this.mAfterLabelInfoTV.setText(str2 + "后");
        }
      }
      else
      {
        BNEventManager.getInstance().onRoadTurnInfoDistanceUpdate(str3);
        str3 = RGSimpleGuideModel.getInstance().getFormatGoNextRoad((String)localObject);
        if ((str3 != null) && (this.mGoWhereInfoTV != null) && (!this.mGoWhereInfoTV.getText().equals(str3)))
        {
          this.mGoWhereInfoTV.setText(str3);
          LogUtil.e("guide_info", "mGoWhereInfoTV.setText --> " + str3);
        }
        if (this.mLinkInfoTV != null)
        {
          if (!"目的地".equals(localObject)) {
            break label787;
          }
          this.mLinkInfoTV.setText(JarUtils.getResources().getString(1711669863));
        }
        if (this.mConsecutiveIcon != null)
        {
          if (!RGSimpleGuideModel.getInstance().isShowFollowInfo()) {
            break label821;
          }
          k = RGSimpleGuideModel.getInstance().getFollowIcon();
          if (k != -1)
          {
            if (RightHandResourcesProvider.getEnNaviType() != 0) {
              break label806;
            }
            this.mConsecutiveIcon.setImageDrawable(JarUtils.getResources().getDrawable(k));
          }
          RGViewController.getInstance().requestShowExpendView(7, true, 1);
          LogUtil.e(RGLaneInfoModel.TAG, "simpleguide true");
        }
        paramBundle = paramBundle.getString("cur_road_name");
        if ((this.mCurRoadNameTV != null) && (paramBundle != null) && (!paramBundle.equals(this.mCurRoadNameTV.getText()))) {
          this.mCurRoadNameTV.setText(paramBundle);
        }
        if ((this.mCurRoadRemainDistTV != null) && (str1 != null)) {
          this.mCurRoadRemainDistTV.setText(str1);
        }
        if ((this.mCurRoadRemainDistWordTV != null) && (str2 != null)) {
          this.mCurRoadRemainDistWordTV.setText(str2);
        }
        if (RoutePlanModel.sNavNodeList.size() < 3) {
          break label852;
        }
        if (((i != 1711407751) && (i != 1711407752)) || (j >= 120) || (j < 0)) {
          break label844;
        }
        if (!this.mHasRemoveCurVia)
        {
          this.mHasRemoveCurVia = true;
          paramBundle = (RoutePlanNode)RoutePlanModel.sNavNodeList.remove(1);
          this.mSubViewListener.onOtherAction(10, 0, 0, paramBundle);
        }
      }
    }
    for (;;)
    {
      showSuitableView();
      return;
      label734:
      this.mTurnIcon.setImageDrawable(RightHandResourcesProvider.getDrawableIncludeRightHandIcon(i));
      break;
      label787:
      label806:
      label821:
      label844:
      label852:
      if (i == 2)
      {
        paramBundle = JarUtils.getResources().getDrawable(1711407689);
        localObject = JarUtils.getResources().getDrawable(1711407690);
        BNEventManager.getInstance().onRemainDistanceUpdate(RGSimpleGuideModel.getInstance().getTotalRemainDistString(), paramBundle);
        BNEventManager.getInstance().onRemainTimeUpdate(RGSimpleGuideModel.getInstance().getArriveTimeString(), (Drawable)localObject);
      }
    }
  }
  
  public void updateDataByLastest()
  {
    updateData(RGSimpleGuideModel.getInstance().getNextGuideInfo());
    updateData(RGSimpleGuideModel.getInstance().getTotalInfo());
    updateCurRoadName();
    showSuitableView();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMSimpleGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */