package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView.LoadingCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGToolBoxPresent
  extends BaseNavPresent
{
  private static final String TAG = "RGToolBoxPresent";
  private RGToolBoxView.LoadingCallback mLoadingCallback;
  private OnRGSubViewListener mSubViewListener;
  private RGToolBoxView mToolBoxView;
  
  public RGToolBoxPresent(RGToolBoxView paramRGToolBoxView)
  {
    this.mToolBoxView = paramRGToolBoxView;
  }
  
  public void closeToolbox()
  {
    if ((this.mToolBoxView != null) && (this.mToolBoxView.isOpenStatus())) {
      this.mToolBoxView.closeToolBox();
    }
  }
  
  public void hideLoading()
  {
    this.mToolBoxView.hideLoadingViewHasProgress();
    this.mLoadingCallback = null;
  }
  
  public void hideResumeSwitchView()
  {
    this.mToolBoxView.showResumeSwitchView(false);
  }
  
  protected void initViewStatus()
  {
    LogUtil.e("RGToolBoxPresent", "initViewStatus");
    updateToolBoxItemState(4);
    updateToolBoxItemState(5);
    updateToolBoxItemState(6);
    updateToolBoxItemState(7);
    onRemainDistTimeUpdate();
  }
  
  public boolean isToolboxOpened()
  {
    return (this.mToolBoxView != null) && (this.mToolBoxView.isOpenStatus());
  }
  
  public void onClick(View paramView, int paramInt)
  {
    LogUtil.e("RGToolBoxPresent", "RGToolBoxPresent onClick key :" + paramInt);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                UserOPController.getInstance().add("2.i.5", null, "3", null);
                paramInt = BNRoutePlaner.getInstance().getCalcPreference();
                RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(paramInt);
                if (this.mSubViewListener != null) {
                  this.mSubViewListener.onRouteSortAction();
                }
                closeToolbox();
                return;
                UserOPController.getInstance().add("3.5.j.2");
                if (this.mSubViewListener != null) {
                  this.mSubViewListener.onMoreRouteSearchAction();
                }
                closeToolbox();
                return;
                if (RightHandResourcesProvider.isInternationalWithToast(this.mToolBoxView.getContext()))
                {
                  closeToolbox();
                  return;
                }
                if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
                {
                  closeToolbox();
                  TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "网络连接不可用");
                  return;
                }
                if (this.mSubViewListener != null)
                {
                  UserOPController.getInstance().add("3.p", "0", null, null);
                  this.mSubViewListener.onUGCMenuAction();
                }
                closeToolbox();
                return;
              } while ((ForbidDaulClickUtils.isFastDoubleClick()) || (RightHandResourcesProvider.isInternationalWithToast(this.mToolBoxView.getContext())));
              UserOPController.getInstance().add("3.5.j.3");
              UserOPController.getInstance().add("3.y.1", "1", null, null);
              BusinessActivityManager.getInstance().safetyUpload(0, true);
              closeToolbox();
              return;
              closeToolbox();
              if (BNSettingManager.getMapMode() == 1)
              {
                RouteGuideFSM.getInstance().cacheBackMapState("North2D");
                BNSettingManager.setMapMode(2);
                paramView = BNStyleManager.getString(1711670376);
                RGNotificationController.getInstance().showCommonResultMsg(paramView, true);
              }
              for (;;)
              {
                BNavigator.getInstance().enterNavState();
                updateToolBoxItemState(paramInt);
                return;
                RouteGuideFSM.getInstance().cacheBackMapState("Car3D");
                BNSettingManager.setMapMode(1);
                paramView = BNStyleManager.getString(1711670377);
                RGNotificationController.getInstance().showCommonResultMsg(paramView, true);
              }
              closeToolbox();
              if (("NAV_STATE_OPERATE".equals(RGControlPanelModel.getInstance().getNavState())) && (this.mSubViewListener != null)) {
                this.mSubViewListener.onOtherAction(3, 0, 0, null);
              }
              int i = BNSettingManager.getVoiceMode();
              if ((i == 0) || (i == 1))
              {
                TTSPlayerControl.playTTS(BNStyleManager.getString(1711670316), 1);
                BNSettingManager.setLastVoiceMode(i);
                BNSettingManager.resetVoiceModeParams(2);
                if (this.mSubViewListener != null) {
                  this.mSubViewListener.onOtherAction(6, 0, 2, null);
                }
                UserOPController.getInstance().add("3.i", "", null, null);
              }
              for (;;)
              {
                RGNotificationController.getInstance().mIsClickQuietBtn = true;
                RGNotificationController.getInstance().showQuietMode();
                updateToolBoxItemState(paramInt);
                return;
                if (i == 2)
                {
                  i = BNSettingManager.getLastVoiceMode();
                  BNSettingManager.resetVoiceModeParams(i);
                  if (this.mSubViewListener != null) {
                    this.mSubViewListener.onOtherAction(6, 0, i, null);
                  }
                  TTSPlayerControl.playTTS(BNStyleManager.getString(1711670319), 1);
                  UserOPController.getInstance().add("3.i", null, "", null);
                }
              }
              i = BNSettingManager.getIsShowMapSwitch();
              if (i == 0) {
                BNSettingManager.setIsShowMapSwitch(1);
              }
              for (;;)
              {
                RGViewController.getInstance().showAssistMapSwitch();
                if ((!"BrowseMap".equals(RouteGuideFSM.getInstance().getLastestGlassState())) && (this.mSubViewListener != null)) {
                  this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
                closeToolbox();
                updateToolBoxItemState(paramInt);
                if (i != 1) {
                  break;
                }
                RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(1711670368), true);
                return;
                if (i == 1) {
                  BNSettingManager.setIsShowMapSwitch(0);
                }
              }
              RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(1711670369), true);
              return;
              UserOPController.getInstance().add("3.5.j.4");
              if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
              {
                closeToolbox();
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "网络连接不可用");
                return;
              }
              i = BNRoutePlaner.getInstance().getRoutePlanNetMode();
              int j = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
              if ((i == 1) && ((j == 0) || (j == 2)))
              {
                closeToolbox();
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "离线导航路线偏好不可用");
                return;
              }
              closeToolbox();
              i = BNRoutePlaner.getInstance().getCalcPreference();
              RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(i);
              if (TextUtils.isEmpty(BNSettingManager.getPlateFromLocal(this.mToolBoxView.getContext())))
              {
                paramView = new Bundle();
                paramView.putBoolean("open_car_plate", true);
                RGViewController.getInstance().showMenuMoreView(paramView);
                return;
              }
              if (RGCarPreferSettingController.getInstance().isCarLimitOpen()) {
                RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
              }
              for (;;)
              {
                if (this.mSubViewListener != null)
                {
                  RGSimpleGuideModel.getInstance();
                  RGSimpleGuideModel.mCalcRouteType = 3;
                  this.mSubViewListener.onJudgePreferWithMenuHide();
                }
                updateToolBoxItemState(paramInt);
                return;
                RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
              }
            } while (this.mSubViewListener == null);
            this.mSubViewListener.onShowQuitNaviView();
            return;
            this.mSubViewListener.onOtherAction(13, 0, 0, null);
            return;
            if (this.mSubViewListener != null) {
              this.mSubViewListener.onMenuMoreAction();
            }
            closeToolbox();
            return;
            if (this.mSubViewListener != null) {
              this.mSubViewListener.onOtherAction(3, 0, 0, null);
            }
            closeToolbox();
            return;
          } while (this.mSubViewListener == null);
          this.mSubViewListener.onLocationAction();
          return;
        } while (this.mSubViewListener == null);
        this.mSubViewListener.onMultiRouteSwitchAction();
        return;
        if (this.mLoadingCallback != null)
        {
          this.mLoadingCallback.onQuitClick();
          this.mLoadingCallback = null;
        }
      } while (this.mToolBoxView == null);
      this.mToolBoxView.hideLoadingViewHasProgress();
      return;
    } while (this.mSubViewListener == null);
    this.mSubViewListener.onEmptyPoiAction();
  }
  
  public void onRPComplete()
  {
    this.mToolBoxView.hideLoadingViewNoProgress();
  }
  
  public void onRPWatting()
  {
    this.mToolBoxView.showLoadingViewNoProgress("正在算路，请稍等");
  }
  
  public void onRemainDistTimeUpdate()
  {
    this.mToolBoxView.updateArriveTime(RGSimpleGuideModel.getInstance().getArriveTimeString());
    this.mToolBoxView.updateRemainTimeAndDist(RGSimpleGuideModel.getInstance().getTotalRemainDistString() + " " + RGSimpleGuideModel.getInstance().getTotalRemainTimeString());
  }
  
  public void onStartYawing()
  {
    this.mToolBoxView.showLoadingViewNoProgress("正在计算路线...");
  }
  
  public void onTopStatus()
  {
    if (this.mToolBoxView.isLastScrollEvent()) {
      UserOPController.getInstance().add("3.5.j", "2", null, null);
    }
    RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
    RouteGuideFSM.getInstance().run("收到放大图隐藏消息");
  }
  
  public void onYawingComplete(boolean paramBoolean)
  {
    this.mToolBoxView.hideLoadingViewNoProgress();
  }
  
  public void setOnSubViewClickListener(OnRGSubViewListener paramOnRGSubViewListener)
  {
    this.mSubViewListener = paramOnRGSubViewListener;
  }
  
  public void setToolBoxStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (RGRouteSearchModel.getInstance().isRouteSearchMode())
      {
        this.mToolBoxView.showClearPoiView(true);
        return;
      }
      this.mToolBoxView.showClearPoiView(false);
      this.mToolBoxView.setTopBarState(paramInt);
      return;
    }
    this.mToolBoxView.showClearPoiView(false);
    this.mToolBoxView.setTopBarState(paramInt);
  }
  
  public void showLoading(String paramString, RGToolBoxView.LoadingCallback paramLoadingCallback)
  {
    this.mToolBoxView.showLoadingViewHasProgress(paramString);
    this.mLoadingCallback = paramLoadingCallback;
  }
  
  public void showResumeSwitchView()
  {
    this.mToolBoxView.showResumeSwitchView(true);
  }
  
  public void updateToolBoxItemState(int paramInt)
  {
    LogUtil.e("RGToolBoxPresent", "updateToolBoxItemState index :" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      if (BNSettingManager.getMapMode() == 1)
      {
        this.mToolBoxView.updateSettingStatus(paramInt, 1);
        return;
      }
      this.mToolBoxView.updateSettingStatus(paramInt, 2);
      return;
    case 5: 
      if (BNSettingManager.getVoiceMode() == 2)
      {
        this.mToolBoxView.updateSettingStatus(paramInt, 1);
        return;
      }
      this.mToolBoxView.updateSettingStatus(paramInt, 2);
      return;
    case 6: 
      if (BNSettingManager.getIsShowMapSwitch() == 1)
      {
        this.mToolBoxView.updateSettingStatus(paramInt, 2);
        return;
      }
      this.mToolBoxView.updateSettingStatus(paramInt, 1);
      return;
    }
    if (RGCarPreferSettingController.getInstance().isCarLimitOpen())
    {
      String str = BNSettingManager.getPlateFromLocal(this.mToolBoxView.getContext());
      if (!TextUtils.isEmpty(str))
      {
        this.mToolBoxView.mCarNum = str;
        this.mToolBoxView.updateSettingStatus(paramInt, 1);
        return;
      }
    }
    this.mToolBoxView.updateSettingStatus(paramInt, 2);
  }
  
  public void updateViewStatus()
  {
    LogUtil.e("RGToolBoxPresent", "updateViewStatus");
    updateToolBoxItemState(4);
    updateToolBoxItemState(5);
    updateToolBoxItemState(6);
    updateToolBoxItemState(7);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/toolbox/present/RGToolBoxPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */