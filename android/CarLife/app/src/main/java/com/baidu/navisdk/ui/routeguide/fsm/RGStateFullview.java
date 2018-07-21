package com.baidu.navisdk.ui.routeguide.fsm;

import android.graphics.Rect;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

public class RGStateFullview
  extends RGState
{
  public void enter()
  {
    super.enter();
  }
  
  public void excute()
  {
    LogUtil.e("RouteGuide", "excute by reflection");
    RGControlPanelModel.getInstance().updateFullviewState(true);
    super.excute();
  }
  
  public void exit()
  {
    super.exit();
  }
  
  protected void onActionLayers()
  {
    BNRouteGuider.getInstance().setBrowseStatus(true);
  }
  
  protected void onActionMapStatus()
  {
    boolean bool = false;
    if (!RGControlPanelModel.getInstance().ismIsConfigChange()) {
      BNRouteGuider.getInstance().SetFullViewState(true);
    }
    int j;
    int m;
    int k;
    int i;
    if (RGControlPanelModel.getInstance().getFullviewState())
    {
      NMapControlProxy.getInstance().enableTouchEventLookover(false);
      ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getRouteNodeData();
      if (1 != RGCacheStatus.sOrientation) {
        break label182;
      }
      j = 10;
      m = ScreenUtil.getInstance().dip2px(124);
      k = ScreenUtil.getInstance().getWidthPixels() - 10;
      i = ScreenUtil.getInstance().getHeightPixels();
      if (!RGRouteRecommendModel.getInstance().isViewCanShow) {
        break label168;
      }
      i -= ScreenUtil.getInstance().dip2px(138);
    }
    for (;;)
    {
      Rect localRect = new Rect(j, m, k, i);
      if (1 == RGCacheStatus.sOrientation) {
        bool = true;
      }
      BNMapController.getInstance().zoomToFullView(localRect, bool, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), RGControlPanelModel.getInstance().mNeedAnimForFullview);
      RGControlPanelModel.getInstance().mNeedAnimForFullview = true;
      return;
      label168:
      i -= ScreenUtil.getInstance().dip2px(60);
      continue;
      label182:
      j = ScreenUtil.getInstance().getHeightPixels() / 4 + 10;
      m = 20;
      k = ScreenUtil.getInstance().getHeightPixels() - 10;
      i = ScreenUtil.getInstance().getWidthPixels();
      if (RGRouteRecommendModel.getInstance().isViewCanShow) {
        i -= ScreenUtil.getInstance().dip2px(138);
      } else {
        i -= ScreenUtil.getInstance().dip2px(60);
      }
    }
  }
  
  protected void onActionNaviEngine()
  {
    RGEngineControl.getInstance().enableManualSound();
  }
  
  protected void onActionUI()
  {
    RGControlPanelModel.getInstance().updateLocateStatus(3);
    RGViewController.getInstance().setToolBoxStatus(0);
    RGViewController.getInstance().updateAssistFullViewModeBtn();
    RGViewController.getInstance().showCurRoadNameView();
    RGViewController.getInstance().setRoadConditionBarVisible(8);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/fsm/RGStateFullview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */