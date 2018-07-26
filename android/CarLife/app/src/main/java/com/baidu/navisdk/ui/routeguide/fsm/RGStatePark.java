package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

public class RGStatePark extends RGState {
    protected void onActionUI() {
        RGControlPanelModel.getInstance().updateLocateStatus(3);
        RGViewController.getInstance().hideAllViews();
        RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
        RGViewController.getInstance().showRGSimpleGuideView();
        RGViewController.getInstance().showDeviceStateView();
        RGViewController.getInstance().showControlPanel();
        RGViewController.getInstance().showControlManualOperatePanel(false);
        RGViewController.getInstance().cancleAutoHideControlPanel();
        RGViewController.getInstance().showParkPointView();
        RGParkPointModel.getInstance().setmIsParkPointShow(true);
    }

    protected void onActionNaviEngine() {
        BNRouteGuider.getInstance().setBrowseStatus(true);
        RGEngineControl.getInstance().disableManuSound();
    }

    protected void onActionLayers() {
        BNMapController.getInstance().showLayer(3, true);
        MapStatus st = NMapControlProxy.getInstance().getMapStatus();
        if (st != null) {
            if (1 == RGCacheStatus.sOrientation) {
                st._Xoffset = 0;
                st._Yoffset = (long) (0 - ScreenUtil.getInstance().dip2px(100));
            } else if (2 == RGCacheStatus.sOrientation) {
                st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
                st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.1d));
            }
            st._Rotation = 1;
            st._Overlooking = 0;
            st._Level = -1.0f;
            NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
        }
    }

    protected void onActionMapStatus() {
    }

    public void excute() {
        super.excute();
    }

    public void exit() {
        BNMapController.getInstance().showLayer(3, false);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        RGViewController.getInstance().hideParkPointView();
        RGParkPointModel.getInstance().setmIsParkPointShow(false);
        super.exit();
    }
}
