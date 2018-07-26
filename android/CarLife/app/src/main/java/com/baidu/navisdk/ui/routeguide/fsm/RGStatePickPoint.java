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

public class RGStatePickPoint extends RGState {
    protected void onActionUI() {
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

    protected void onActionNaviEngine() {
        BNRouteGuider.getInstance().setBrowseStatus(true);
        RGEngineControl.getInstance().disableManuSound();
    }

    protected void onActionLayers() {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            BNMapController.getInstance().showLayer(4, false);
        } else {
            BNMapController.getInstance().showLayer(4, true);
        }
        MapStatus st = NMapControlProxy.getInstance().getMapStatus();
        if (st != null) {
            if (1 == RGCacheStatus.sOrientation) {
                st._Xoffset = 0;
                st._Yoffset = (long) (0 - ScreenUtil.getInstance().dip2px(64));
            } else if (2 == RGCacheStatus.sOrientation) {
                st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
                st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.1d));
            }
            st._Rotation = 1;
            st._Overlooking = 0;
            NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationAll);
        }
    }

    protected void onActionMapStatus() {
    }

    public void excute() {
        super.excute();
    }

    public void exit() {
        BNMapController.getInstance().showLayer(4, false);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        RGViewController.getInstance().hidePickPointView();
        RGPickPointModel.getInstance().setPickPointShow(false);
        super.exit();
    }
}
