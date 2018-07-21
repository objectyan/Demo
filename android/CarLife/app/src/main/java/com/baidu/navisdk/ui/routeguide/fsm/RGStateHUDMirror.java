package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateHUDMirror
  extends RGState
{
  public void enter()
  {
    RGViewController.getInstance().initHUDView(true);
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
    RGViewController.getInstance().showHUDDialog(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateHUDMirror.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */