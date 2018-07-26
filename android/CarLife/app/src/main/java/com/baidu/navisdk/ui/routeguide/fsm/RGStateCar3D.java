package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmParamsKey;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
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

public class RGStateCar3D extends RGState {
    protected void onActionUI() {
        if (!RGMultiRouteModel.getInstance().isSwitchButtonShowing) {
            RGViewController.getInstance().hideMultiRouteSwitcherView(false);
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        RGControlPanelModel.getInstance().updateLocateStatus(1);
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
        if (FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState()) && RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
            RGViewController.getInstance().showEnlargeRoadMap();
            RGViewController.getInstance().hideRGSimpleGuideLeftPanelView();
            RGViewController.getInstance().hideRGSimpleGuideView();
            RGViewController.getInstance().hideHighwayView();
            RGViewController.getInstance().hideDeviceStateView();
            if (RGViewController.getInstance().getOrientation() == 2) {
                RGViewController.getInstance().hideMainAuxiliaryBridgeView();
                RGViewController.getInstance().hideScaleLevelView();
            }
        }
        if (FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getCurrentState()) && RGViewController.getInstance().ismIsShowColladaView()) {
            RGViewController.getInstance().showColladaView(true);
        }
        RGControlPanelModel.getInstance().updateFullviewState(false);
        RGViewController.getInstance().cancleAutoHideControlPanel();
        RGViewController.getInstance().showAssistView();
        RGViewController.getInstance().showUserRightView();
        RGViewController.getInstance().showCommonView(true);
        RGViewController.getInstance().hideParkPointView();
        RGViewController.getInstance().showHighWayServiceView();
        NaviStatItem.getInstance().setNorthRealTime();
        if (this.enterParams == null || !this.enterParams.getBoolean(FsmParamsKey.ORIENTATION_CHANGE, false)) {
            RGNotificationController.getInstance().recoveryOperableNotification();
        }
        RGNotificationController.getInstance().showQuietMode();
        RGViewController.getInstance().setToolBoxStatus(0);
        RGViewController.getInstance().updateAssistFullViewModeBtn();
        RGViewController.getInstance().updateHighwayFsmSate(FsmState.Car3D);
        RGViewController.getInstance().showCurRoadNameView();
        if (RGSimpleGuideModel.getInstance().isYawing()) {
            RGViewController.getInstance().hideAssistInfo();
            RGViewController.getInstance().hideHighwayView();
            RGViewController.getInstance().hideDeviceStateView();
            RGViewController.getInstance().hideMainAuxiliaryBridgeView();
        }
        RGViewController.getInstance().setRoadConditionBarVisible(0);
    }

    protected void onActionNaviEngine() {
        BNRouteGuider.getInstance().setRotateMode(0);
        RGEngineControl.getInstance().enableManualSound();
    }

    protected void onActionLayers() {
        if (!RGControlPanelModel.getInstance().ismIsConfigChange()) {
            BNRouteGuider.getInstance().SetFullViewState(false);
        }
    }

    protected void onActionMapStatus() {
        NMapControlProxy.getInstance().enableTouchEventLookover(true);
        RGControlPanelModel.getInstance().resetAdjustLevel();
        if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus) {
            RGMultiRouteModel.getInstance().isAvoidTrafficStatus = false;
            BNRouteGuider.getInstance().SetFullViewState(false);
        }
        GeoPoint carPt = RGEngineControl.getInstance().getCarGeoPoint();
        if (carPt == null || (!carPt.isValid() && BNLocationManagerProxy.getInstance().isLocationValid())) {
            carPt = BNLocationManagerProxy.getInstance().getLastValidLocation();
        }
        BNMapController.getInstance().sendCommandToMapEngine(4, null);
        MapStatus st = null;
        if (this.enterParams == null || !this.enterParams.getBoolean("not_set_mapstate", false)) {
            st = NMapControlProxy.getInstance().getMapStatus();
        }
        if (st != null) {
            if (1 == RGCacheStatus.sOrientation) {
                st._Xoffset = 0;
                st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getHeightPixels()) * 0.25d));
            } else if (2 == RGCacheStatus.sOrientation) {
                boolean isEnlargeShow = false;
                String currentState = RouteGuideFSM.getInstance().getCurrentState();
                if (FsmState.EnlargeRoadmap.equals(currentState) && RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
                    isEnlargeShow = true;
                } else if (FsmState.Colladamap.equals(currentState) && RGViewController.getInstance().ismIsShowColladaView()) {
                    isEnlargeShow = true;
                }
                if (isEnlargeShow) {
                    st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 4);
                } else {
                    st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 8);
                }
                st._Yoffset = 0 - ((long) ScreenUtil.getInstance().dip2px(20));
            }
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getVehicleInfo(bundle);
            if (bundle.containsKey("vehicle_angle")) {
                st._Rotation = (int) bundle.getDouble("vehicle_angle");
            } else {
                st._Rotation = (int) BNRouteGuider.getInstance().GetCarRotateAngle();
            }
            st._Overlooking = -45;
            if (carPt != null) {
                Bundle b = CoordinateTransformUtil.LL2MC(((double) carPt.getLongitudeE6()) / 100000.0d, ((double) carPt.getLatitudeE6()) / 100000.0d);
                st._CenterPtX = b.getInt("MCx");
                st._CenterPtY = b.getInt("MCy");
            }
            st._Level = -1.0f;
            NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationArc);
        }
        BNRouteGuider.getInstance().setBrowseStatus(false);
    }

    public void excute() {
        super.excute();
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "excute by reflection");
    }

    public void enter(Bundle enterParams) {
        super.enter(enterParams);
        if (RGControlPanelModel.getInstance().getFullviewState()) {
            RGCacheStatus.sMapIsLastFullViewState = true;
        } else {
            RGCacheStatus.sMapIsLastFullViewState = false;
        }
    }

    public void exit() {
        super.exit();
    }
}
