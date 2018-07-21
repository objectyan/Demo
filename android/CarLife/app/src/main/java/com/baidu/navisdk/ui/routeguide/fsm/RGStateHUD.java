package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateHUD
  extends RGState
{
  public void enter()
  {
    RGViewController.getInstance().initHUDView(false);
    super.enter();
  }
  
  public void excute()
  {
    super.excute();
    LogUtil.e("RouteGuide", "excute by reflection");
  }
  
  public void exit()
  {
    BNRouteGuider.getInstance().setHUDEnabled(false);
    RGViewController.getInstance().hideHUDDialog();
    super.exit();
  }
  
  protected void onActionLayers() {}
  
  protected void onActionMapStatus() {}
  
  protected void onActionNaviEngine()
  {
    RGEngineControl.getInstance().disableManuSound();
    BNRouteGuider.getInstance().setHUDEnabled(true);
  }
  
  protected void onActionUI()
  {
    if (RGMultiRouteModel.getInstance().isSwitchButtonShowing)
    {
      RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
      BNMapController.getInstance().recoveryHighLightRoute();
    }
    com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel.mIsMenuVisible = false;
    RGViewController.getInstance().showHUDDialog(false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateHUD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */