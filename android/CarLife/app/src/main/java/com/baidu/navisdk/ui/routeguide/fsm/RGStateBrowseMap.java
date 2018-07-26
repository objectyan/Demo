package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateBrowseMap extends RGState {
    public void enter() {
        super.enter();
        if (FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getTopState()) && FsmEvent.TOUCH_MAP.equals(RouteGuideFSM.getInstance().getCurrentEvent()) && (RGControlPanelModel.getInstance().sAdjustLevel == -1 || RGControlPanelModel.getInstance().sAdjustLevel == 1)) {
            RGControlPanelModel.getInstance().sAdjustLevel = 1;
        } else {
            RGControlPanelModel.getInstance().sAdjustLevel = 0;
        }
        LogUtil.m15791e("RGStateBrowseMap", "enter() sAdjustLevel=" + RGControlPanelModel.getInstance().sAdjustLevel);
    }

    protected void onActionUI() {
        RGControlPanelModel.getInstance().updateLocateStatus(3);
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            RGViewController.getInstance().showControlManualOperatePanel(false);
        } else {
            RGViewController.getInstance().showControlManualOperatePanel(true);
        }
        RGViewController.getInstance().showCommonView(false);
        RGViewController.getInstance().hideHighWayServiceView();
        RGNotificationController.getInstance().hideAllView(false, true);
        RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
        if (RGHighwayModel.getInstance().isExists()) {
            RGViewController.getInstance().showHighwayView();
            RGViewController.getInstance().hideRGSimpleGuideView();
        } else {
            RGViewController.getInstance().showRGSimpleGuideView();
            RGViewController.getInstance().hideHighwayView();
        }
        RGViewController.getInstance().showDeviceStateView();
        RGViewController.getInstance().updateMainAuxiliaryBridgeViewByLastType();
        RGViewController.getInstance().showScaleLevelView();
        if (FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            RGViewController.getInstance().hideEnlargeRoadMapWithoutAnimation();
        }
        if (FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            RGViewController.getInstance().showColladaView(false);
        }
        if (RGParkPointModel.getInstance().ismIsParkPointShow()) {
            RGControlPanelModel.getInstance().setmIsParkSearching(true);
            RGViewController.getInstance().showParkPointView();
            BNavigator.getInstance().autoHideParkPoint(HttpsClient.CONN_MGR_TIMEOUT);
        }
        RGViewController.getInstance().setToolBoxStatus(1);
        RGViewController.getInstance().hideCurRoadNameView();
    }

    protected void onActionNaviEngine() {
        BNRouteGuider.getInstance().setBrowseStatus(true);
        RGEngineControl.getInstance().disableManuSound();
    }

    protected void onActionLayers() {
    }

    protected void onActionMapStatus() {
        NMapControlProxy.getInstance().enableTouchEventLookover(true);
    }

    public void excute() {
        super.excute();
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "excute by reflection");
    }
}
