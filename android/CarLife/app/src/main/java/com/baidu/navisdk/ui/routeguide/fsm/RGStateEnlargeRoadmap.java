package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGStateEnlargeRoadmap
  extends RGState
{
  public void enter()
  {
    super.enter();
  }
  
  public void excute()
  {
    super.excute();
    LogUtil.e("RouteGuide", "excute by reflection");
  }
  
  public void exit()
  {
    if (RGMultiRouteModel.getInstance().isSwitchButtonShowing)
    {
      RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
      BNMapController.getInstance().recoveryHighLightRoute();
    }
    if (!RGControlPanelModel.getInstance().ismIsConfigChange())
    {
      RGViewController.getInstance().hideEnlargeRoadMapAnimation();
      BNMapController.getInstance().setEnlargedStatus(false);
    }
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    if (RGHighwayModel.getInstance().isExists())
    {
      RGViewController.getInstance().showHighwayView();
      RGViewController.getInstance().hideRGSimpleGuideView();
    }
    for (;;)
    {
      RGViewController.getInstance().showDeviceStateView();
      RGViewController.getInstance().updateMainAuxiliaryBridgeViewByLastType();
      RGViewController.getInstance().showScaleLevelView();
      if (RGMapModeViewController.getInstance().getOrientation() == 2)
      {
        XDVoiceInstructManager.getInstance().setXDPlan(2, ScreenUtil.getInstance().getHeightPixels() / 4 * 3);
        RGViewController.getInstance().isMoveCurRoadNameView(false);
      }
      super.exit();
      return;
      RGViewController.getInstance().showRGSimpleGuideView();
      RGViewController.getInstance().hideHighwayView();
    }
  }
  
  protected void onActionLayers() {}
  
  protected void onActionMapStatus()
  {
    BNMapController.getInstance().setEnlargedStatus(true);
    BNMapController.getInstance().setMapShowScreenRect();
  }
  
  protected void onActionNaviEngine()
  {
    RGEngineControl.getInstance().disableManuSound();
  }
  
  protected void onActionUI()
  {
    if (RGMultiRouteModel.getInstance().isSwitchButtonShowing)
    {
      RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
      BNMapController.getInstance().recoveryHighLightRoute();
    }
    if (!"NAV_STATE_OPERATE".equals(RGControlPanelModel.getInstance().getNavState())) {
      RGViewController.getInstance().hideAllViews(1);
    }
    if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
      RGMapModeViewController.getInstance().showLaneLineView();
    }
    RGViewController.getInstance().showEnlargeRoadMap();
    RGViewController.getInstance().hideRGSimpleGuideLeftPanelView();
    RGViewController.getInstance().hideRGSimpleGuideView();
    RGViewController.getInstance().hideHighwayView();
    RGViewController.getInstance().hideDeviceStateView();
    if (RGViewController.getInstance().getOrientation() == 2)
    {
      RGViewController.getInstance().hideMainAuxiliaryBridgeView();
      RGViewController.getInstance().hideScaleLevelView();
    }
    RGViewController.getInstance().updateSimpleMapLayout();
    RGViewController.getInstance().hideUserRightTipsView();
    RGViewController.getInstance().hideHighWayServiceView();
    RGViewController.getInstance().onUgcDestroy();
    RGNotificationController.getInstance().hideAllView(false, true);
    LogUtil.e("CurRoadName", "放大图出现，允许路面显示");
    RGViewController.getInstance().showCurRoadNameView();
    if (RGMapModeViewController.getInstance().getOrientation() == 2)
    {
      XDVoiceInstructManager.getInstance().setXDPlan(2, ScreenUtil.getInstance().getHeightPixels() / 2);
      RGViewController.getInstance().isMoveCurRoadNameView(true);
    }
    RGViewController.getInstance().closeToolbox();
    if (RGViewController.getInstance().isBNRCEventDetailsMenuVisible()) {
      RGViewController.getInstance().onBNRCEventDestroy();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateEnlargeRoadmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */