package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateBrowseMap
  extends RGState
{
  public void enter()
  {
    super.enter();
    if (("SimpleGuide".equals(RouteGuideFSM.getInstance().getTopState())) && ("触碰地图".equals(RouteGuideFSM.getInstance().getCurrentEvent())) && ((RGControlPanelModel.getInstance().sAdjustLevel == -1) || (RGControlPanelModel.getInstance().sAdjustLevel == 1))) {}
    for (RGControlPanelModel.getInstance().sAdjustLevel = 1;; RGControlPanelModel.getInstance().sAdjustLevel = 0)
    {
      LogUtil.e("RGStateBrowseMap", "enter() sAdjustLevel=" + RGControlPanelModel.getInstance().sAdjustLevel);
      return;
    }
  }
  
  public void excute()
  {
    super.excute();
    LogUtil.e("RouteGuide", "excute by reflection");
  }
  
  protected void onActionLayers() {}
  
  protected void onActionMapStatus()
  {
    NMapControlProxy.getInstance().enableTouchEventLookover(true);
  }
  
  protected void onActionNaviEngine()
  {
    BNRouteGuider.getInstance().setBrowseStatus(true);
    RGEngineControl.getInstance().disableManuSound();
  }
  
  protected void onActionUI()
  {
    RGControlPanelModel.getInstance().updateLocateStatus(3);
    if (RGRouteSearchModel.getInstance().isRouteSearchMode())
    {
      RGViewController.getInstance().showControlManualOperatePanel(false);
      RGViewController.getInstance().showCommonView(false);
      RGViewController.getInstance().hideHighWayServiceView();
      RGNotificationController.getInstance().hideAllView(false, true);
      RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
      if (!RGHighwayModel.getInstance().isExists()) {
        break label185;
      }
      RGViewController.getInstance().showHighwayView();
      RGViewController.getInstance().hideRGSimpleGuideView();
    }
    for (;;)
    {
      RGViewController.getInstance().showDeviceStateView();
      RGViewController.getInstance().updateMainAuxiliaryBridgeViewByLastType();
      RGViewController.getInstance().showScaleLevelView();
      if ("EnlargeRoadmap".equals(RouteGuideFSM.getInstance().getCurrentState())) {
        RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
      }
      if ("Colladamap".equals(RouteGuideFSM.getInstance().getCurrentState())) {
        RGViewController.getInstance().showColladaView(false);
      }
      if (RGParkPointModel.getInstance().ismIsParkPointShow())
      {
        RGControlPanelModel.getInstance().setmIsParkSearching(true);
        RGViewController.getInstance().showParkPointView();
        BNavigator.getInstance().autoHideParkPoint(30000L);
      }
      RGViewController.getInstance().setToolBoxStatus(1);
      RGViewController.getInstance().hideCurRoadNameView();
      return;
      RGViewController.getInstance().showControlManualOperatePanel(true);
      break;
      label185:
      RGViewController.getInstance().showRGSimpleGuideView();
      RGViewController.getInstance().hideHighwayView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateBrowseMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */