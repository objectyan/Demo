package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class RGStatePickPoint
  extends RGState
{
  public void excute()
  {
    super.excute();
  }
  
  public void exit()
  {
    BNMapController.getInstance().showLayer(4, false);
    BNRouteGuider.getInstance().setBrowseStatus(false);
    RGViewController.getInstance().hidePickPointView();
    RGPickPointModel.getInstance().setPickPointShow(false);
    super.exit();
  }
  
  protected void onActionLayers()
  {
    MapStatus localMapStatus;
    if (RGRouteSearchModel.getInstance().isRouteSearchMode())
    {
      BNMapController.getInstance().showLayer(4, false);
      localMapStatus = NMapControlProxy.getInstance().getMapStatus();
      if (localMapStatus != null)
      {
        if (1 != RGCacheStatus.sOrientation) {
          break label89;
        }
        localMapStatus._Xoffset = 0L;
        localMapStatus._Yoffset = (0 - ScreenUtil.getInstance().dip2px(64));
      }
    }
    for (;;)
    {
      localMapStatus._Rotation = 1;
      localMapStatus._Overlooking = 0;
      NMapControlProxy.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationAll);
      return;
      BNMapController.getInstance().showLayer(4, true);
      break;
      label89:
      if (2 == RGCacheStatus.sOrientation)
      {
        localMapStatus._Xoffset = (ScreenUtil.getInstance().getHeightPixels() / 6);
        localMapStatus._Yoffset = ((0.0D - ScreenUtil.getInstance().getWidthPixels() * 0.1D));
      }
    }
  }
  
  protected void onActionMapStatus() {}
  
  protected void onActionNaviEngine()
  {
    BNRouteGuider.getInstance().setBrowseStatus(true);
    RGEngineControl.getInstance().disableManuSound();
  }
  
  protected void onActionUI()
  {
    RGViewController.getInstance().hideAllViews();
    RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
    RGViewController.getInstance().showRGSimpleGuideView();
    RGViewController.getInstance().showDeviceStateView();
    RGViewController.getInstance().showControlPanel();
    RGMapModeViewController.getInstance().showControlManualOperatePanel(true);
    RGViewController.getInstance().showPickPointView();
    RGPickPointModel.getInstance().setPickPointShow(true);
    RGControlPanelModel.getInstance().updateLocateStatus(3);
    RGViewController.getInstance().showCommonView(false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStatePickPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */