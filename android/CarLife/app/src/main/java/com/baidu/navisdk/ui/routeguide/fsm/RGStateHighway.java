package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;

public class RGStateHighway
  extends RGState
{
  public void enter()
  {
    RGViewController.getInstance().showHighwayView();
    RGViewController.getInstance().showDeviceStateView();
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    if (RGViewController.getInstance().getHudShowStatus()) {
      RGViewController.getInstance().showHudSuitableView();
    }
    super.enter();
  }
  
  public void excute()
  {
    super.excute();
  }
  
  public void exit()
  {
    RGViewController.getInstance().hideHighwayView();
    RGHUDDataModel.setHighWayModel(false);
    if ((RouteGuideFSM.getInstance().getCurrentEvent() != null) && (RouteGuideFSM.getInstance().getCurrentEvent().equals("收到偏航开始的消息"))) {}
    super.exit();
  }
  
  protected void onActionLayers() {}
  
  protected void onActionMapStatus()
  {
    NMapControlProxy.getInstance().enableTouchEventLookover(true);
    BNMapController.getInstance().setMapShowScreenRect();
  }
  
  protected void onActionNaviEngine() {}
  
  protected void onActionUI()
  {
    RGViewController.getInstance().hideRGSimpleGuideView();
    RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
    RGViewController.getInstance().hideControlManualOperatePanel();
    RGViewController.getInstance().showControlPanel();
    RGViewController.getInstance().showAssistView();
    RGViewController.getInstance().showUserRightView();
    RGViewController.getInstance().updateHighwayView(null);
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    RGViewController.getInstance().showHighwayView();
    RGViewController.getInstance().showDeviceStateView();
    if (RGViewController.getInstance().getHudShowStatus()) {
      RGViewController.getInstance().showHudSuitableView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateHighway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */