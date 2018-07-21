package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class RGStateNorth2D
  extends RGState
{
  public void enter()
  {
    super.enter();
    if (RGControlPanelModel.getInstance().getFullviewState())
    {
      RGCacheStatus.sMapIsLastFullViewState = true;
      return;
    }
    RGCacheStatus.sMapIsLastFullViewState = false;
  }
  
  public void excute()
  {
    super.excute();
    LogUtil.e("RouteGuide", "excute by reflection");
  }
  
  public void exit()
  {
    super.exit();
  }
  
  protected void onActionLayers()
  {
    if (!RGControlPanelModel.getInstance().ismIsConfigChange()) {
      BNRouteGuider.getInstance().SetFullViewState(false);
    }
  }
  
  protected void onActionMapStatus()
  {
    RGControlPanelModel.getInstance().resetAdjustLevel();
    if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus)
    {
      RGMultiRouteModel.getInstance().isAvoidTrafficStatus = false;
      BNRouteGuider.getInstance().SetFullViewState(false);
    }
    Object localObject2 = RGEngineControl.getInstance().getCarGeoPoint();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((GeoPoint)localObject2).isValid())
      {
        localObject1 = localObject2;
        if (!BNLocationManagerProxy.getInstance().isLocationValid()) {}
      }
    }
    else
    {
      localObject1 = BNLocationManagerProxy.getInstance().getLastValidLocation();
    }
    BNMapController.getInstance().sendCommandToMapEngine(4, null);
    localObject2 = null;
    if ((this.enterParams == null) || (!this.enterParams.getBoolean("not_set_mapstate", false))) {
      localObject2 = NMapControlProxy.getInstance().getMapStatus();
    }
    int j;
    String str;
    int i;
    if (localObject2 != null)
    {
      ((MapStatus)localObject2)._Rotation = 1;
      ((MapStatus)localObject2)._Overlooking = 0;
      j = 0;
      str = RouteGuideFSM.getInstance().getCurrentState();
      if ((!"EnlargeRoadmap".equals(str)) || (!RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing())) {
        break label263;
      }
      i = 1;
      if (1 != RGCacheStatus.sOrientation) {
        break label310;
      }
      ((MapStatus)localObject2)._Xoffset = 0L;
      if (i == 0) {
        break label291;
      }
      ((MapStatus)localObject2)._Yoffset = (0L - ScreenUtil.getInstance().getHeightPixels() / 5);
    }
    label263:
    label291:
    label310:
    while (2 != RGCacheStatus.sOrientation) {
      for (;;)
      {
        localObject1 = CoordinateTransformUtil.LL2MC(((GeoPoint)localObject1).getLongitudeE6() / 100000.0D, ((GeoPoint)localObject1).getLatitudeE6() / 100000.0D);
        ((MapStatus)localObject2)._CenterPtX = ((Bundle)localObject1).getInt("MCx");
        ((MapStatus)localObject2)._CenterPtY = ((Bundle)localObject1).getInt("MCy");
        ((MapStatus)localObject2)._Level = -1.0F;
        NMapControlProxy.getInstance().setMapStatus((MapStatus)localObject2, MapController.AnimationType.eAnimationArc);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        return;
        i = j;
        if (!"Colladamap".equals(str)) {
          break;
        }
        i = j;
        if (!RGViewController.getInstance().ismIsShowColladaView()) {
          break;
        }
        i = 1;
        break;
        ((MapStatus)localObject2)._Yoffset = (0L - ScreenUtil.getInstance().dip2px(20));
      }
    }
    if (i != 0) {}
    for (((MapStatus)localObject2)._Xoffset = (ScreenUtil.getInstance().getHeightPixels() / 4);; ((MapStatus)localObject2)._Xoffset = (ScreenUtil.getInstance().getHeightPixels() / 8))
    {
      ((MapStatus)localObject2)._Yoffset = 0L;
      break;
    }
  }
  
  protected void onActionNaviEngine()
  {
    BNRouteGuider.getInstance().setRotateMode(1);
    RGEngineControl.getInstance().enableManualSound();
  }
  
  protected void onActionUI()
  {
    if (!RGMultiRouteModel.getInstance().isSwitchButtonShowing)
    {
      RGViewController.getInstance().hideMultiRouteSwitcherView(false);
      BNMapController.getInstance().recoveryHighLightRoute();
    }
    RGControlPanelModel.getInstance().updateLocateStatus(2);
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
      if (("EnlargeRoadmap".equals(RouteGuideFSM.getInstance().getCurrentState())) && (RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()))
      {
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
      }
      if (("Colladamap".equals(RouteGuideFSM.getInstance().getCurrentState())) && (RGViewController.getInstance().ismIsShowColladaView())) {
        RGViewController.getInstance().showColladaView(true);
      }
      RGControlPanelModel.getInstance().updateFullviewState(false);
      RGViewController.getInstance().cancleAutoHideControlPanel();
      RGViewController.getInstance().showAssistView();
      RGViewController.getInstance().showUserRightView();
      RGViewController.getInstance().showCommonView(true);
      RGViewController.getInstance().hideParkPointView();
      RGViewController.getInstance().showHighWayServiceView();
      NaviStatItem.getInstance().setStartNorthTime();
      if ((this.enterParams == null) || (!this.enterParams.getBoolean("orientation_change", false))) {
        RGNotificationController.getInstance().recoveryOperableNotification();
      }
      RGNotificationController.getInstance().showQuietMode();
      RGViewController.getInstance().setToolBoxStatus(0);
      RGViewController.getInstance().updateAssistFullViewModeBtn();
      RGViewController.getInstance().updateHighwayFsmSate("North2D");
      RGViewController.getInstance().showCurRoadNameView();
      if (RGSimpleGuideModel.getInstance().isYawing())
      {
        RGViewController.getInstance().hideAssistInfo();
        RGViewController.getInstance().hideHighwayView();
        RGViewController.getInstance().hideDeviceStateView();
        RGViewController.getInstance().hideMainAuxiliaryBridgeView();
      }
      RGViewController.getInstance().setRoadConditionBarVisible(0);
      return;
      RGViewController.getInstance().showRGSimpleGuideView();
      RGViewController.getInstance().hideHighwayView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateNorth2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */