package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;

public class RGStateHighway extends RGState {
    protected void onActionUI() {
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

    protected void onActionNaviEngine() {
    }

    protected void onActionLayers() {
    }

    protected void onActionMapStatus() {
        NMapControlProxy.getInstance().enableTouchEventLookover(true);
        BNMapController.getInstance().setMapShowScreenRect();
    }

    public void enter() {
        RGViewController.getInstance().showHighwayView();
        RGViewController.getInstance().showDeviceStateView();
        RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
        if (RGViewController.getInstance().getHudShowStatus()) {
            RGViewController.getInstance().showHudSuitableView();
        }
        super.enter();
    }

    public void excute() {
        super.excute();
    }

    public void exit() {
        RGViewController.getInstance().hideHighwayView();
        RGHUDDataModel.setHighWayModel(false);
        if (RouteGuideFSM.getInstance().getCurrentEvent() == null || RouteGuideFSM.getInstance().getCurrentEvent().equals(FsmEvent.MSG_YAWING_START)) {
            super.exit();
        } else {
            super.exit();
        }
    }
}
