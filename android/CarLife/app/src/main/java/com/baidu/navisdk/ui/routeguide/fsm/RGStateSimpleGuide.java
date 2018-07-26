package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;

public class RGStateSimpleGuide extends RGState {
    protected void onActionUI() {
        RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
        RGViewController.getInstance().updateSimpleMapLayout();
        RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
        RGViewController.getInstance().showRGSimpleGuideView();
        RGViewController.getInstance().showDeviceStateView();
        RGViewController.getInstance().hideControlManualOperatePanel();
        RGViewController.getInstance().showControlPanel();
        RGViewController.getInstance().showAssistView();
        RGViewController.getInstance().showUserRightView();
        RGViewController.getInstance().updateHighwayFsmSate(FsmState.SimpleGuide);
        RGViewController.getInstance().updateMenuMoreView();
        if (RGSimpleGuideModel.mIsOfflineToOnline) {
            RGViewController.getInstance().requestShowExpendView(10, true);
        }
    }

    protected void onActionNaviEngine() {
        RGEngineControl.getInstance().enableManualSound();
    }

    protected void onActionLayers() {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode() || RGParkPointModel.getInstance().ismIsParkPointShow()) {
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().updateLayer(4);
        }
        BNavigator.getInstance().updateParkPointOnMap();
    }

    protected void onActionMapStatus() {
        NMapControlProxy.getInstance().enableTouchEventLookover(true);
        BNMapController.getInstance().setEnlargedStatus(false);
        BNMapController.getInstance().setMapShowScreenRect();
    }

    public void exit() {
        super.exit();
    }
}
