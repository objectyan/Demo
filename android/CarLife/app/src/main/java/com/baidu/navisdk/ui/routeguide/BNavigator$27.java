package com.baidu.navisdk.ui.routeguide;

import android.view.MotionEvent;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.nplatform.comapi.MapItem;

class BNavigator$27 implements BNMapObserver {
    final /* synthetic */ BNavigator this$0;

    BNavigator$27(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void update(BNSubject o, int type, int event, Object arg) {
        if ((this.this$0.hasCalcRouteOk() && !RGSimpleGuideModel.getInstance().isYawing()) || 1 == type || event == 274) {
            if (1 == type) {
                switch (event) {
                    case 257:
                    case 274:
                        RGViewController.getInstance().updateControlPanelView();
                        NMapControlProxy.getInstance().updateLayer(10);
                        NMapControlProxy.getInstance().UpdataBaseLayers();
                        break;
                    case 262:
                        RouteGuideFSM.getInstance().run("指南针点击");
                        break;
                    case 265:
                        if (!RGSimpleGuideModel.getInstance().isYawing()) {
                            if (this.this$0.hasCalcRouteOk()) {
                                String layerID = ((MapItem) arg).mUid;
                                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "layerID = " + layerID);
                                int poiIndex = BNPoiSearcher.getInstance().parseBkgLayerId(layerID);
                                if (poiIndex >= 0) {
                                    this.this$0.handleBkgClick(poiIndex);
                                    break;
                                }
                            }
                            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_POI_BKG_LAYER return hasCalcRouteOk false");
                            return;
                        }
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_POI_BKG_LAYER return isyawing");
                        return;
                        break;
                    case 272:
                        if (!RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                            if (!RGPickPointModel.getInstance().isPickPointShow()) {
                                if (FsmState.Park.equals(RouteGuideFSM.getInstance().getTopState())) {
                                    RGMapModeViewController.getInstance().hideParkPointView();
                                    RGParkPointModel.getInstance().setmIsParkPointShow(false);
                                    break;
                                }
                            }
                            RGViewController.getInstance().hidePickPointView();
                            RGPickPointModel.getInstance().setPickPointShow(false);
                            RGPickPointModel.getInstance().updateAntiSearchPoi(null);
                            RGPickPointModel.getInstance().updatePickPoint(null);
                            BNPoiSearcher.getInstance().clearPoiCache();
                            BNMapController.getInstance().showLayer(4, false);
                            BNMapController.getInstance().updateLayer(4);
                            break;
                        }
                        RGViewController.getInstance().hidePickPointView();
                        RGPickPointModel.getInstance().setPickPointShow(false);
                        if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
                            BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                            BNMapController.getInstance().updateLayer(4);
                            RGRouteSearchModel.getInstance().resetLastBkgItemId();
                            break;
                        }
                        break;
                    case 277:
                        if (!RGSimpleGuideModel.getInstance().isYawing()) {
                            if (this.this$0.hasCalcRouteOk()) {
                                if (RGPickPointModel.getInstance().isPickPointShow()) {
                                    RGViewController.getInstance().hidePickPointView();
                                    RGPickPointModel.getInstance().setPickPointShow(false);
                                    RGPickPointModel.getInstance().updateAntiSearchPoi(null);
                                    RGPickPointModel.getInstance().updatePickPoint(null);
                                    BNMapController.getInstance().updateLayer(3);
                                    break;
                                }
                            }
                            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_POI_LAYER return hasCalcRouteOk false");
                            return;
                        }
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_POI_LAYER return isyawing");
                        return;
                        break;
                    case 514:
                        if (!RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                            if (!RGSimpleGuideModel.getInstance().isYawing()) {
                                if (this.this$0.hasCalcRouteOk()) {
                                    MapItem item = (MapItem) arg;
                                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_ROUTE item= " + item.mItemID);
                                    RGMultiRouteModel.getInstance().mSelectedRouteIndex = item.mItemID;
                                    RGMultiRouteModel.getInstance().mCurRouteIndex = item.mCurRouteIdx;
                                    if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus) {
                                        BNMapController.getInstance().setHighLightAvoidTrafficRoute(item.mItemID);
                                    } else {
                                        BNMapController.getInstance().setHighLightRoute(item.mItemID);
                                    }
                                    RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
                                    if (RGMultiRouteModel.getInstance().mSelectedRouteIndex == RGMultiRouteModel.getInstance().mCurRouteIndex) {
                                        if (item.mClickType == 1) {
                                            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_1, null, "", "" + item.mItemID);
                                        } else {
                                            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_2, null, "", "" + item.mItemID);
                                        }
                                        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
                                        RGViewController.getInstance().hideMultiRouteSwitcherView(true);
                                    } else {
                                        if (item.mClickType == 1) {
                                            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_1, "", null, "" + item.mItemID);
                                        } else {
                                            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_2, "", null, "" + item.mItemID);
                                        }
                                        RGViewController.getInstance().showMultiRouteSwitcherView();
                                        if (PreferenceHelper.getInstance(BNavigator.access$000(this.this$0)).getBoolean(PreferenceHelperConst.SP_RG_INSTANT_FIRST_START_GUIDE, true)) {
                                            PreferenceHelper.getInstance(BNavigator.access$000(this.this$0)).putBoolean(PreferenceHelperConst.SP_RG_INSTANT_FIRST_START_GUIDE, false);
                                            TTSPlayerControl.playTTS(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_switch_guide_tts_text), 0);
                                        }
                                    }
                                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "CLICKED_ROUTE item=" + item.mItemID + "curIdx=" + item.mCurRouteIdx);
                                    break;
                                }
                                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_ROUTE return hasCalcRouteOk false");
                                return;
                            }
                            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_ROUTE return isyawing");
                            return;
                        }
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_CLICKED_ROUTE return by isRouteSearchMode");
                        return;
                    case 515:
                        if (arg != null) {
                            this.this$0.showUgcDetailViewSource(((MapItem) arg).mUid, true, 3);
                            break;
                        }
                        return;
                }
            }
            if (2 == type) {
                BNWorkerCenter.getInstance().cancelTask(BNavigator.access$2400(this.this$0), false);
                switch (event) {
                    case 513:
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "TYPE_GESTURE: EVENT_DOUBLE_TAP");
                        RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                        return;
                    case 514:
                        if (RouteGuideFSM.getInstance().getTopState() != null && RouteGuideFSM.getInstance().getTopState().equals(FsmState.EnlargeRoadmap)) {
                            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_INTERSECTIONZOOMOFF, NaviStatConstants.NAVIGATION_INTERSECTIONZOOMOFF);
                        }
                        RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
                        return;
                    case 515:
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_DOWN");
                        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                            RGViewController.getInstance().hidePickPointView();
                            return;
                        }
                        return;
                    case 517:
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "TYPE_GESTURE: EVENT_LONGPRESS");
                        BNavigator.access$2500(this.this$0, (MotionEvent) arg);
                        return;
                    case 518:
                        RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                        return;
                    case 519:
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "EVENT_SCROLL");
                        RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                        return;
                    case 520:
                        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "TYPE_GESTURE: EVENT_DOUBLE_FINGER_ZOOM");
                        RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                        BNMapController.getInstance().getMapController().SetInterruptAutoLevel(true);
                        return;
                    case 521:
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
