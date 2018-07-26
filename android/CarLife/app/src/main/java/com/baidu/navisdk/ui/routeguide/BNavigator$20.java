package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.RouteGuideThread;
import com.baidu.navisdk.util.jar.JarUtils;

class BNavigator$20 extends Handler {
    final /* synthetic */ BNavigator this$0;

    BNavigator$20(BNavigator this$0, Looper x0) {
        this.this$0 = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 3:
                NMapControlProxy.getInstance().showLayer(10, true);
                RGNotificationController.getInstance().showLocalRoute(false);
                return;
            case 4:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_SUCCESS_NORMAL:" + BNavigator.hasReallyStartedNav);
                XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                if (BNavigator.hasReallyStartedNav) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_SUCCESS_NORMAL hasCallRerouted:" + BNavigator.hasCallRerouted);
                    if (BNavigator.hasCallRerouted) {
                        BNavigator.hasCallRerouted = false;
                        if (BNavigator.access$1700(this.this$0) != null) {
                            BNavigator.access$1700(this.this$0).onRoutePlan();
                        }
                        Bundle bundle = new Bundle();
                        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                        RGSimpleGuideModel.getInstance().setFirstRGInfo(bundle);
                        RGViewController.getInstance().initFirstRGInfo();
                        RGAssistGuideModel.getInstance().reset();
                        RGControlPanelModel.getInstance().setmIsParkSearching(false);
                        RGParkPointModel.getInstance().setmIsParkPointShow(false);
                        RGNotificationController.getInstance().hideOperableView(102);
                        BNavigator.access$1800(this.this$0);
                        RouteGuideFSM.getInstance().run(FsmEvent.CONTINUE_NAVI);
                        if (BNavConfig.pRGLocateMode == 2 || BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() != 2) {
                            RGSimpleGuideModel.mIsOfflineToOnline = false;
                            RGViewController.getInstance().requestShowExpendView(10, false);
                        } else {
                            RGSimpleGuideModel.mIsOfflineToOnline = true;
                            RGViewController.getInstance().requestShowExpendView(10, true);
                        }
                        RGMapModeViewController.getInstance().hideReRoutePlanView();
                        BNavigator.access$1900(this.this$0, true);
                        return;
                    }
                    return;
                }
                RouteGuideThread.getInstance().removeMessage(502);
                RouteGuideThread.getInstance().sendMessage(502);
                return;
            case 5:
                RGViewController.getInstance().updateRoadCondition();
                if (BNavigator.access$2000(this.this$0)) {
                    BNavigator.access$2002(this.this$0, false);
                    RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
                    RGNotificationController.getInstance().hideCommonView(111);
                    TipTool.onCreateToastDialog(BNavigator.access$1100(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_update_road_condition_success));
                    return;
                }
                return;
            case 6:
                this.this$0.jumpWhenRoutePlanFail();
                return;
            case 7:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_FAIL_NORMAL:" + msg.arg1 + "; " + msg.arg2);
                if (this.this$0.hasCalcRouteOk()) {
                    RGMapModeViewController.getInstance().hideReRoutePlanView();
                    BNavigator.access$1900(this.this$0, false);
                    return;
                }
                RGSimpleGuideModel.getInstance().isCalcRouteFail = true;
                RGViewController.getInstance().showRGSimpleGuideSuitableView();
                RGNotificationController.getInstance().showWaitRPResult(msg.arg1);
                return;
            case 8:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_BEFORE_START:" + msg.arg1 + "; " + msg.arg2);
                BNavigator.hasCallRerouted = true;
                if (this.this$0.hasCalcRouteOk()) {
                    switch (RGSimpleGuideModel.mCalcRouteType) {
                        case 1:
                            RGMapModeViewController.getInstance().showReRoutePlanLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_add_via_loading_text));
                            return;
                        case 4:
                            RGMapModeViewController.getInstance().showReRoutePlanLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_end_car_park_loading_text));
                            return;
                        default:
                            RGMapModeViewController.getInstance().showReRoutePlanLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_change_prefer_loading_text));
                            return;
                    }
                }
                RGMapModeViewController.getInstance().showLoadingWhileWaitCal();
                return;
            case 32:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "peng cancleCalcRouteRequest before jump");
                this.this$0.jumpWhenRoutePlanFail();
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "peng cancleCalcRouteRequest after jump");
                return;
            case 33:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_SUCCESS_BUILD:" + BNavigator.hasCallCheckOtherRoute);
                if (!this.this$0.hasCalcRouteOk()) {
                    RouteGuideThread.getInstance().removeMessage(502);
                    RouteGuideThread.getInstance().sendMessage(502);
                    return;
                } else if (BNavigator.hasCallCheckOtherRoute) {
                    BNavigator.hasCallCheckOtherRoute = false;
                    RGViewController.getInstance().dismissLoading();
                    BNMapController.getInstance().recoveryHighLightRoute();
                    BNavigator.access$1800(this.this$0);
                    RGNotificationController.getInstance().showSwitchRouteSuccess();
                    TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_build_success), 1);
                    BNNaviResultModel instance = BNNaviResultModel.getInstance();
                    instance.instantNum++;
                    return;
                } else {
                    return;
                }
            case 34:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_FAIL_BUILD");
                BNavigator.hasCallCheckOtherRoute = false;
                if (this.this$0.hasCalcRouteOk()) {
                    RGViewController.getInstance().dismissLoading();
                    BNMapController.getInstance().recoveryHighLightRoute();
                    if (RGRouteRecommendModel.getInstance().isViewCanShow) {
                        BNavigator.access$2100(this.this$0);
                    } else {
                        this.this$0.enterNavState();
                    }
                    TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_build_fail), 1);
                    RGNotificationController.getInstance().showSwitchRouteFail();
                    return;
                }
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " reCalcRoute");
                RGEngineControl.getInstance().reCalcRouteWhenFail();
                return;
            case 39:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_SUCCESS_SELECT_ROUTE  msg.arg1: " + msg.arg1 + " msg.arg2 " + msg.arg2);
                if (msg.arg1 == 3 && !this.this$0.mIsStartRouteGuideSuc && !this.this$0.hasCalcRouteOk()) {
                    boolean isReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "RP_SUCCESS_SELECT_ROUTE judgeRouteInfoAllReady isReady:" + isReady);
                    if (isReady) {
                        RouteGuideThread.getInstance().removeMessage(502);
                        RouteGuideThread.getInstance().sendMessage(502);
                        return;
                    }
                    return;
                }
                return;
            case 48:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_START_BUILD:" + BNavigator.hasCallCheckOtherRoute);
                BNavigator.hasCallCheckOtherRoute = true;
                RGViewController.getInstance().showLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_start_build));
                RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
                if (RGMapModeViewController.getInstance().ismIsShowColladaView()) {
                    RGMapModeViewController.getInstance().setmIsShowColladaView(false);
                    RGViewController.getInstance().resetColladaView();
                    return;
                }
                return;
            case 49:
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, " mRPHandler=====  RP_FAIL_BUILD_AUTO");
                RGViewController.getInstance().dismissLoading();
                return;
            default:
                return;
        }
    }
}
