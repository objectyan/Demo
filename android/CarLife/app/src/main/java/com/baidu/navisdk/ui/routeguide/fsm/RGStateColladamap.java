package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateColladamap
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
      RGViewController.getInstance().showColladaView(false);
      BNMapController.getInstance().setEnlargedStatus(false);
    }
    super.exit();
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
    RGViewController.getInstance().hideAssistViewOnly();
    if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
      RGMapModeViewController.getInstance().showLaneLineView();
    }
    RGViewController.getInstance().showColladaView(true);
    RGViewController.getInstance().updateSimpleMapLayout();
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    RGViewController.getInstance().showRGSimpleGuideView();
    RGViewController.getInstance().showDeviceStateView();
    RGViewController.getInstance().hideUserRightTipsView();
    RGNotificationController.getInstance().hideAllView(false, true);
    RGViewController.getInstance().onUgcDestroy();
    RGViewController.getInstance().closeToolbox();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateColladamap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */