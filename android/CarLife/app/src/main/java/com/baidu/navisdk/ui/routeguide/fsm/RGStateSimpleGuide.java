package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;

public class RGStateSimpleGuide
  extends RGState
{
  public void exit()
  {
    super.exit();
  }
  
  protected void onActionLayers()
  {
    if ((RGRouteSearchModel.getInstance().isRouteSearchMode()) || (RGParkPointModel.getInstance().ismIsParkPointShow()))
    {
      BNMapController.getInstance().showLayer(4, true);
      BNMapController.getInstance().updateLayer(4);
    }
    BNavigator.getInstance().updateParkPointOnMap();
  }
  
  protected void onActionMapStatus()
  {
    NMapControlProxy.getInstance().enableTouchEventLookover(true);
    BNMapController.getInstance().setEnlargedStatus(false);
    BNMapController.getInstance().setMapShowScreenRect();
  }
  
  protected void onActionNaviEngine()
  {
    RGEngineControl.getInstance().enableManualSound();
  }
  
  protected void onActionUI()
  {
    RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
    RGViewController.getInstance().updateSimpleMapLayout();
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    RGViewController.getInstance().showRGSimpleGuideView();
    RGViewController.getInstance().showDeviceStateView();
    RGViewController.getInstance().hideControlManualOperatePanel();
    RGViewController.getInstance().showControlPanel();
    RGViewController.getInstance().showAssistView();
    RGViewController.getInstance().showUserRightView();
    RGViewController.getInstance().updateHighwayFsmSate("SimpleGuide");
    RGViewController.getInstance().updateMenuMoreView();
    if (RGSimpleGuideModel.mIsOfflineToOnline) {
      RGViewController.getInstance().requestShowExpendView(10, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateSimpleGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */