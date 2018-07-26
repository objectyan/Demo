package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView.LoadingCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGToolBoxPresent extends BaseNavPresent {
    private static final String TAG = "RGToolBoxPresent";
    private LoadingCallback mLoadingCallback;
    private OnRGSubViewListener mSubViewListener;
    private RGToolBoxView mToolBoxView;

    public RGToolBoxPresent(RGToolBoxView toolboxView) {
        this.mToolBoxView = toolboxView;
    }

    public void setOnSubViewClickListener(OnRGSubViewListener listener) {
        this.mSubViewListener = listener;
    }

    public void onClick(View view, int key) {
        LogUtil.m15791e(TAG, "RGToolBoxPresent onClick key :" + key);
        switch (key) {
            case 0:
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_5, null, "3", null);
                RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(BNRoutePlaner.getInstance().getCalcPreference());
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onRouteSortAction();
                }
                closeToolbox();
                return;
            case 1:
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_j_2);
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onMoreRouteSearchAction();
                }
                closeToolbox();
                return;
            case 2:
                if (RightHandResourcesProvider.isInternationalWithToast(this.mToolBoxView.getContext())) {
                    closeToolbox();
                    return;
                } else if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                    if (this.mSubViewListener != null) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_p, "0", null, null);
                        this.mSubViewListener.onUGCMenuAction();
                    }
                    closeToolbox();
                    return;
                } else {
                    closeToolbox();
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "网络连接不可用");
                    return;
                }
            case 3:
                if (!ForbidDaulClickUtils.isFastDoubleClick() && !RightHandResourcesProvider.isInternationalWithToast(this.mToolBoxView.getContext())) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_j_3);
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_y_1, "1", null, null);
                    BusinessActivityManager.getInstance().safetyUpload(0, true);
                    closeToolbox();
                    return;
                }
                return;
            case 4:
                closeToolbox();
                if (BNSettingManager.getMapMode() == 1) {
                    RouteGuideFSM.getInstance().cacheBackMapState(FsmState.North2D);
                    BNSettingManager.setMapMode(2);
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_switch_north2_success), true);
                } else {
                    RouteGuideFSM.getInstance().cacheBackMapState(FsmState.Car3D);
                    BNSettingManager.setMapMode(1);
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_switch_car3d_success), true);
                }
                BNavigator.getInstance().enterNavState();
                updateToolBoxItemState(key);
                return;
            case 5:
                closeToolbox();
                if (NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState()) && this.mSubViewListener != null) {
                    this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
                int voiceMode = BNSettingManager.getVoiceMode();
                if (voiceMode == 0 || voiceMode == 1) {
                    TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice), 1);
                    BNSettingManager.setLastVoiceMode(voiceMode);
                    BNSettingManager.resetVoiceModeParams(2);
                    if (this.mSubViewListener != null) {
                        this.mSubViewListener.onOtherAction(6, 0, 2, null);
                    }
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_i, "", null, null);
                } else if (voiceMode == 2) {
                    int lastVoiceMode = BNSettingManager.getLastVoiceMode();
                    BNSettingManager.resetVoiceModeParams(lastVoiceMode);
                    if (this.mSubViewListener != null) {
                        this.mSubViewListener.onOtherAction(6, 0, lastVoiceMode, null);
                    }
                    TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_close_quiet_voice), 1);
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_i, null, "", null);
                }
                RGNotificationController.getInstance().mIsClickQuietBtn = true;
                RGNotificationController.getInstance().showQuietMode();
                updateToolBoxItemState(key);
                return;
            case 6:
                int type = BNSettingManager.getIsShowMapSwitch();
                if (type == 0) {
                    BNSettingManager.setIsShowMapSwitch(1);
                } else if (type == 1) {
                    BNSettingManager.setIsShowMapSwitch(0);
                }
                RGViewController.getInstance().showAssistMapSwitch();
                if (!(FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState()) || this.mSubViewListener == null)) {
                    this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
                closeToolbox();
                updateToolBoxItemState(key);
                if (type == 1) {
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_notification_mini_map_mode), true);
                    return;
                } else {
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_notification_roadbar_mode), true);
                    return;
                }
            case 7:
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_j_4);
                if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                    int netModeCarplate = BNRoutePlaner.getInstance().getRoutePlanNetMode();
                    int engineNetModeCarplate = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
                    if (netModeCarplate == 1 && (engineNetModeCarplate == 0 || engineNetModeCarplate == 2)) {
                        closeToolbox();
                        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "离线导航路线偏好不可用");
                        return;
                    }
                    closeToolbox();
                    RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(BNRoutePlaner.getInstance().getCalcPreference());
                    if (TextUtils.isEmpty(BNSettingManager.getPlateFromLocal(this.mToolBoxView.getContext()))) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("open_car_plate", true);
                        RGViewController.getInstance().showMenuMoreView(bundle);
                        return;
                    }
                    if (RGCarPreferSettingController.getInstance().isCarLimitOpen()) {
                        RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
                    } else {
                        RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
                    }
                    if (this.mSubViewListener != null) {
                        RGSimpleGuideModel.getInstance();
                        RGSimpleGuideModel.mCalcRouteType = 3;
                        this.mSubViewListener.onJudgePreferWithMenuHide();
                    }
                    updateToolBoxItemState(key);
                    return;
                }
                closeToolbox();
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "网络连接不可用");
                return;
            case 8:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onShowQuitNaviView();
                    return;
                }
                return;
            case 9:
                this.mSubViewListener.onOtherAction(13, 0, 0, null);
                return;
            case 10:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onMenuMoreAction();
                }
                closeToolbox();
                return;
            case 11:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onOtherAction(3, 0, 0, null);
                }
                closeToolbox();
                return;
            case 12:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onLocationAction();
                    return;
                }
                return;
            case 13:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onMultiRouteSwitchAction();
                    return;
                }
                return;
            case 14:
                if (this.mLoadingCallback != null) {
                    this.mLoadingCallback.onQuitClick();
                    this.mLoadingCallback = null;
                }
                if (this.mToolBoxView != null) {
                    this.mToolBoxView.hideLoadingViewHasProgress();
                    return;
                }
                return;
            case 15:
                if (this.mSubViewListener != null) {
                    this.mSubViewListener.onEmptyPoiAction();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void initViewStatus() {
        LogUtil.m15791e(TAG, "initViewStatus");
        updateToolBoxItemState(4);
        updateToolBoxItemState(5);
        updateToolBoxItemState(6);
        updateToolBoxItemState(7);
        onRemainDistTimeUpdate();
    }

    public void updateViewStatus() {
        LogUtil.m15791e(TAG, "updateViewStatus");
        updateToolBoxItemState(4);
        updateToolBoxItemState(5);
        updateToolBoxItemState(6);
        updateToolBoxItemState(7);
    }

    public void updateToolBoxItemState(int index) {
        LogUtil.m15791e(TAG, "updateToolBoxItemState index :" + index);
        switch (index) {
            case 4:
                if (BNSettingManager.getMapMode() == 1) {
                    this.mToolBoxView.updateSettingStatus(index, 1);
                    return;
                } else {
                    this.mToolBoxView.updateSettingStatus(index, 2);
                    return;
                }
            case 5:
                if (BNSettingManager.getVoiceMode() == 2) {
                    this.mToolBoxView.updateSettingStatus(index, 1);
                    return;
                } else {
                    this.mToolBoxView.updateSettingStatus(index, 2);
                    return;
                }
            case 6:
                if (BNSettingManager.getIsShowMapSwitch() == 1) {
                    this.mToolBoxView.updateSettingStatus(index, 2);
                    return;
                } else {
                    this.mToolBoxView.updateSettingStatus(index, 1);
                    return;
                }
            case 7:
                if (RGCarPreferSettingController.getInstance().isCarLimitOpen()) {
                    String carNo = BNSettingManager.getPlateFromLocal(this.mToolBoxView.getContext());
                    if (!TextUtils.isEmpty(carNo)) {
                        this.mToolBoxView.mCarNum = carNo;
                        this.mToolBoxView.updateSettingStatus(index, 1);
                        return;
                    }
                }
                this.mToolBoxView.updateSettingStatus(index, 2);
                return;
            default:
                return;
        }
    }

    public void setToolBoxStatus(int state) {
        switch (state) {
            case 0:
                this.mToolBoxView.showClearPoiView(false);
                this.mToolBoxView.setTopBarState(state);
                return;
            case 1:
                if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                    this.mToolBoxView.showClearPoiView(true);
                    return;
                }
                this.mToolBoxView.showClearPoiView(false);
                this.mToolBoxView.setTopBarState(state);
                return;
            default:
                return;
        }
    }

    public void onRemainDistTimeUpdate() {
        this.mToolBoxView.updateArriveTime(RGSimpleGuideModel.getInstance().getArriveTimeString());
        this.mToolBoxView.updateRemainTimeAndDist(RGSimpleGuideModel.getInstance().getTotalRemainDistString() + " " + RGSimpleGuideModel.getInstance().getTotalRemainTimeString());
    }

    public void showResumeSwitchView() {
        this.mToolBoxView.showResumeSwitchView(true);
    }

    public void hideResumeSwitchView() {
        this.mToolBoxView.showResumeSwitchView(false);
    }

    public void onStartYawing() {
        this.mToolBoxView.showLoadingViewNoProgress("正在计算路线...");
    }

    public void onYawingComplete(boolean success) {
        this.mToolBoxView.hideLoadingViewNoProgress();
    }

    public void onRPWatting() {
        this.mToolBoxView.showLoadingViewNoProgress("正在算路，请稍等");
    }

    public void onRPComplete() {
        this.mToolBoxView.hideLoadingViewNoProgress();
    }

    public void closeToolbox() {
        if (this.mToolBoxView != null && this.mToolBoxView.isOpenStatus()) {
            this.mToolBoxView.closeToolBox();
        }
    }

    public boolean isToolboxOpened() {
        return this.mToolBoxView != null && this.mToolBoxView.isOpenStatus();
    }

    public void showLoading(String text, LoadingCallback callback) {
        this.mToolBoxView.showLoadingViewHasProgress(text);
        this.mLoadingCallback = callback;
    }

    public void hideLoading() {
        this.mToolBoxView.hideLoadingViewHasProgress();
        this.mLoadingCallback = null;
    }

    public void onTopStatus() {
        if (this.mToolBoxView.isLastScrollEvent()) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_j_1, "2", null, null);
        }
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
    }
}
