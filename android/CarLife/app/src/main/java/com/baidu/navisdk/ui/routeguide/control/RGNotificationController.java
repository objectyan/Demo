package com.baidu.navisdk.ui.routeguide.control;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.CommonParams.Key;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationShowFocusListener;
import com.baidu.navisdk.ui.routeguide.model.RGCommonNotificationModel;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGJamReportModel;
import com.baidu.navisdk.ui.routeguide.model.RGOperableNotificationModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.voice.model.VoiceInfo;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions$Builder;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RGNotificationController {
    private static final String TAG = RGNotificationController.class.getSimpleName();
    private static RGNotificationController sInstance = null;
    private ArrayList<RGCommonNotificationModel> mCommonModelList = new ArrayList();
    private int mCommonRandomInt = -1;
    private ArrayList<RGMMCommonNotificationView> mCommonViewList = new ArrayList();
    public boolean mIsClickQuietBtn = false;
    private NotificationShowFocusListener mNotificationShowFocusListener;
    private ArrayList<RGOperableNotificationModel> mOperableModelList = new ArrayList();
    private int mOperableRandomInt = -1;
    private ArrayList<RGMMOperableNotificationView> mOperableViewList = new ArrayList();

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$1 */
    class C43411 implements NotificationDisplayListener {
        C43411() {
        }

        public void onShowWithAnim() {
            LogUtil.m15791e(ModuleName.XDVoice, "showPark onShowWithAnim");
            if (BNavigator.getInstance().getContext() != null) {
                AudioUtils.requestAudioFocus(BNavigator.getInstance().getContext());
            }
            XDVoiceInstructManager.getInstance().onStart();
        }

        public void onShowWithOutAnim() {
            LogUtil.m15791e(ModuleName.XDVoice, "showPark onShowWithOutAnim");
        }

        public void onHideWithAnim() {
            LogUtil.m15791e(ModuleName.XDVoice, "showPark onHideWithAnim, xdEnable(true)");
            TTSPlayerControl.stopVoiceTTSOutput();
            XDVoiceInstructManager.getInstance().setWakeupEnable(true);
            XDVoiceInstructManager.getInstance().resetLastInstrut();
            XDVoiceInstructManager.getInstance().onStop();
            if (BNavigator.getInstance().getContext() != null) {
                AudioUtils.releaseAudioFocus(BNavigator.getInstance().getContext());
            }
        }

        public void onHideWithOutAnim() {
            LogUtil.m15791e(ModuleName.XDVoice, "showPark onHideWithOutAnim");
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$3 */
    class C43433 implements NotificationDisplayListener {
        C43433() {
        }

        public void onShowWithAnim() {
        }

        public void onShowWithOutAnim() {
        }

        public void onHideWithAnim() {
            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
        }

        public void onHideWithOutAnim() {
            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$4 */
    class C43444 implements NotificationClickListener {
        C43444() {
        }

        public void onConfirmBtnClick() {
            RGViewController.getInstance().showMenuMoreView();
        }

        public void onCancelBtnClick() {
        }

        public void onAutoHideWithoutClick() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$5 */
    class C43455 implements NotificationDisplayListener {
        C43455() {
        }

        public void onShowWithAnim() {
            BNSettingManager.setVoiceRecommendNotificationShowCnt(BNSettingManager.getVoiceRecommendNotificationShowCnt() + 1);
            UserOPController.getInstance().add(UserOPParams.VOICE_5_4_1, "1", null, null);
        }

        public void onShowWithOutAnim() {
        }

        public void onHideWithAnim() {
        }

        public void onHideWithOutAnim() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$7 */
    class C43477 implements NotificationDisplayListener {
        C43477() {
        }

        public void onShowWithAnim() {
        }

        public void onShowWithOutAnim() {
        }

        public void onHideWithAnim() {
            RGSimpleGuideModel.mIsUgcOfficialEvent = false;
        }

        public void onHideWithOutAnim() {
            RGSimpleGuideModel.mIsUgcOfficialEvent = false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.RGNotificationController$9 */
    class C43499 implements NotificationClickListener {
        C43499() {
        }

        public void onConfirmBtnClick() {
            RGSimpleGuideModel.getInstance().isCalcRouteFail = false;
            RGViewController.getInstance().showRGSimpleGuideSuitableView();
            RGEngineControl.getInstance().reCalcRouteWhenFail();
        }

        public void onCancelBtnClick() {
            BNavigator.getInstance().jumpWhenRoutePlanFail();
        }

        public void onAutoHideWithoutClick() {
        }
    }

    public static RGNotificationController getInstance() {
        if (sInstance == null) {
            synchronized (RGNotificationController.class) {
                if (sInstance == null) {
                    sInstance = new RGNotificationController();
                }
            }
        }
        return sInstance;
    }

    public void setNotificationShowFocusListener(NotificationShowFocusListener mNotificationShowFocusListener) {
        this.mNotificationShowFocusListener = mNotificationShowFocusListener;
    }

    public NotificationShowFocusListener getNotificationShowFocusListener() {
        return this.mNotificationShowFocusListener;
    }

    public void addCommonModel(RGCommonNotificationModel model) {
        if (this.mCommonModelList != null && model != null && !this.mCommonModelList.contains(model)) {
            this.mCommonModelList.add(model);
        }
    }

    public void addOperableModel(RGOperableNotificationModel model) {
        if (this.mOperableModelList != null && model != null && !this.mOperableModelList.contains(model)) {
            this.mOperableModelList.add(model);
        }
    }

    public void removeCommonModel(RGCommonNotificationModel model) {
        if (this.mCommonModelList != null && model != null && this.mCommonModelList.contains(model)) {
            Iterator<RGCommonNotificationModel> it = this.mCommonModelList.iterator();
            while (it.hasNext()) {
                RGCommonNotificationModel e = (RGCommonNotificationModel) it.next();
                if (e != null && e.equals(model)) {
                    e.reset();
                    it.remove();
                    return;
                }
            }
        }
    }

    public void removeOperableModel(RGOperableNotificationModel model) {
        if (this.mOperableModelList != null && model != null && this.mOperableModelList.contains(model)) {
            LogUtil.m15791e(TAG, "removeOperableModel mNotificationType:" + model.mNotificationType);
            Iterator<RGOperableNotificationModel> it = this.mOperableModelList.iterator();
            while (it.hasNext()) {
                RGOperableNotificationModel e = (RGOperableNotificationModel) it.next();
                if (e != null && e.equals(model)) {
                    e.reset();
                    it.remove();
                    return;
                }
            }
        }
    }

    public void removeCommonView(RGMMCommonNotificationView view) {
        if (this.mCommonViewList != null && view != null && this.mCommonViewList.contains(view)) {
            Iterator<RGMMCommonNotificationView> it = this.mCommonViewList.iterator();
            while (it.hasNext()) {
                RGMMCommonNotificationView e = (RGMMCommonNotificationView) it.next();
                if (e != null && e.equals(view)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public boolean isContainsCommonView(RGMMCommonNotificationView view) {
        if (this.mCommonViewList == null || this.mCommonViewList.isEmpty() || view == null) {
            return false;
        }
        return this.mCommonViewList.contains(view);
    }

    public boolean isContainsOperableView(RGMMOperableNotificationView view) {
        if (this.mOperableViewList == null || this.mOperableViewList.isEmpty() || view == null) {
            return false;
        }
        return this.mOperableViewList.contains(view);
    }

    public boolean isContainsCommonModel(RGCommonNotificationModel model) {
        if (this.mCommonModelList == null || this.mCommonModelList.isEmpty() || model == null) {
            return false;
        }
        return this.mCommonModelList.contains(model);
    }

    public boolean isContainsOperableModel(RGOperableNotificationModel model) {
        if (this.mOperableModelList == null || this.mOperableModelList.isEmpty() || model == null) {
            return false;
        }
        return this.mOperableModelList.contains(model);
    }

    public boolean isContainsOperableType(int notificationType) {
        if (this.mOperableModelList == null || this.mOperableModelList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.mOperableModelList.size(); i++) {
            RGOperableNotificationModel model = (RGOperableNotificationModel) this.mOperableModelList.get(i);
            if (model != null && model.mNotificationType == notificationType) {
                return true;
            }
        }
        return false;
    }

    public void hideRepeatedOperableView(int type) {
        if (this.mOperableModelList != null) {
            Iterator<RGOperableNotificationModel> it = this.mOperableModelList.iterator();
            while (it.hasNext()) {
                RGOperableNotificationModel e = (RGOperableNotificationModel) it.next();
                if (e != null && e.mNotificationType == type && e.mView != null) {
                    e.mView.hideWithoutRemoveModel();
                    e.reset();
                    it.remove();
                    return;
                }
            }
        }
    }

    public RGMMOperableNotificationView getRepeatedOperableView(int type) {
        RGMMOperableNotificationView operableNotificationView = null;
        if (this.mOperableModelList == null) {
            return null;
        }
        Iterator<RGOperableNotificationModel> it = this.mOperableModelList.iterator();
        while (it.hasNext()) {
            RGOperableNotificationModel e = (RGOperableNotificationModel) it.next();
            if (e != null && e.mNotificationType == type && e.mView != null) {
                operableNotificationView = e.mView;
                break;
            }
        }
        return operableNotificationView;
    }

    private void hideOperableViewInner(int type) {
        if (this.mOperableModelList != null) {
            Iterator<RGOperableNotificationModel> it = this.mOperableModelList.iterator();
            while (it.hasNext()) {
                RGOperableNotificationModel e = (RGOperableNotificationModel) it.next();
                if (!(e == null || e.mNotificationType != type || e.mView == null)) {
                    e.mView.hideWithoutRemoveModel();
                    e.reset();
                    it.remove();
                }
            }
        }
    }

    private void hideCommonViewInner(int type) {
        if (this.mCommonModelList != null) {
            int size = this.mCommonModelList.size();
            if (size != 0) {
                RGCommonNotificationModel lastModel = (RGCommonNotificationModel) this.mCommonModelList.get(size - 1);
                if (lastModel != null && lastModel.mNotificationType == type) {
                    if (lastModel.mView != null) {
                        lastModel.mView.hideWithoutRemoveModel();
                    }
                    lastModel.reset();
                    if (!this.mCommonModelList.isEmpty()) {
                        this.mCommonModelList.remove(this.mCommonModelList.size() - 1);
                    }
                }
            }
        }
    }

    public void removeOperableView(RGMMOperableNotificationView view) {
        if (this.mOperableViewList != null && view != null && this.mOperableViewList.contains(view)) {
            Iterator<RGMMOperableNotificationView> it = this.mOperableViewList.iterator();
            while (it.hasNext()) {
                RGMMOperableNotificationView e = (RGMMOperableNotificationView) it.next();
                if (e != null && e.equals(view)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void addCommonView(RGMMCommonNotificationView view) {
        if (this.mCommonViewList != null && view != null && !this.mCommonViewList.contains(view)) {
            this.mCommonViewList.add(view);
        }
    }

    public void addOperableView(RGMMOperableNotificationView view) {
        if (this.mOperableViewList != null && view != null && !this.mOperableViewList.contains(view)) {
            this.mOperableViewList.add(view);
        }
    }

    public ArrayList<RGCommonNotificationModel> getCommonModelList() {
        return this.mCommonModelList;
    }

    public ArrayList<RGOperableNotificationModel> getOperableModelList() {
        return this.mOperableModelList;
    }

    public ArrayList<RGMMCommonNotificationView> getCommonViewList() {
        return this.mCommonViewList;
    }

    public ArrayList<RGMMOperableNotificationView> getOperableViewList() {
        return this.mOperableViewList;
    }

    public void onConfigurationChanged() {
        if (this.mCommonModelList != null && this.mOperableModelList != null) {
            if (this.mOperableModelList.isEmpty()) {
                Iterator<RGCommonNotificationModel> it = this.mCommonModelList.iterator();
                while (it.hasNext()) {
                    RGCommonNotificationModel model = (RGCommonNotificationModel) it.next();
                    if (model != null) {
                        if (it.hasNext()) {
                            model.reset();
                            it.remove();
                        } else {
                            LogUtil.m15791e(TAG, "recoveryCommonView NotificationType:" + model.mNotificationType);
                            model.mView = RGMapModeViewController.getInstance().newCommonNotification(model.mNotificationType);
                            if (model.mView != null) {
                                model.mID = String.valueOf(model.mView.hashCode());
                                if (model.mPriority == 100 || model.mPriority == 200 || model.mPriority == 300) {
                                    model.mView.setModel(model).setPriority(model.mPriority).setMainTitleText(model.mMainTitleText).setSubTitleText(model.mSubTitleText).setThirdTitleText(model.mThirdTitleText).setNotificationIcon(model.mNotificationIcon).setNotificationIcon(model.mIconUrl, model.mIconOptions, model.mIconListener).setDisplayListener(model.mDisplayListener).recoveryView();
                                } else {
                                    model.mView.setModel(model).setMainTitleText(model.mMainTitleText).setSubTitleText(model.mSubTitleText).setThirdTitleText(model.mThirdTitleText).setMainTitleColor(model.mMainTitleColor).setSubTitleColor(model.mSubTitleColor).setThirdTitleColor(model.mThirdTitleColor).setNotificationColor(model.mNotificationColor).setNotificationIcon(model.mNotificationIcon).setNotificationIcon(model.mIconUrl, model.mIconOptions, model.mIconListener).setDisplayListener(model.mDisplayListener).recoveryView();
                                }
                            }
                        }
                    }
                }
                return;
            }
            Iterator<RGOperableNotificationModel> it2 = this.mOperableModelList.iterator();
            while (it2.hasNext()) {
                RGOperableNotificationModel model2 = (RGOperableNotificationModel) it2.next();
                if (model2 != null) {
                    LogUtil.m15791e(TAG, "recoveryOperableView NotificationType:" + model2.mNotificationType);
                    model2.mView = RGMapModeViewController.getInstance().newOperableNotification(model2.mNotificationType);
                    if (model2.mView != null) {
                        model2.mID = String.valueOf(model2.mView.hashCode());
                        if (model2.mPriority == 100 || model2.mPriority == 200 || model2.mPriority == 300) {
                            model2.mView.setModel(model2).setPriority(model2.mPriority).setMainTitleText(model2.mMainTitleText).setSubTitleText(model2.mSubTitleText).setNotificationIcon(model2.mNotificationIcon).setNotificationIcon(model2.mIconUrl, model2.mIconOptions, model2.mIconListener).setConfirmText(model2.mConfirmText).setCancelText(model2.mCancelText).setOnClick(model2.mOnBtnClickListener).setDisplayListener(model2.mDisplayListener).setShowMasking(model2.mIsShowMasking).recoveryView();
                        } else {
                            model2.mView.setModel(model2).setMainTitleText(model2.mMainTitleText).setSubTitleText(model2.mSubTitleText).setMainTitleColor(model2.mMainTitleColor).setSubTitleColor(model2.mSubTitleColor).setConfirmText(model2.mConfirmText).setCancelText(model2.mCancelText).setConfirmTextColor(model2.mConfirmColor).setCancelTextColor(model2.mCancelColor).setNotificationIcon(model2.mNotificationIcon).setNotificationIcon(model2.mIconUrl, model2.mIconOptions, model2.mIconListener).setNotificationColor(model2.mNotificationColor).setConfirmBackground(model2.mConfirmBackground).setCancelBackground(model2.mCancelBackground).setOnClick(model2.mOnBtnClickListener).setDisplayListener(model2.mDisplayListener).setShowMasking(model2.mIsShowMasking).recoveryView();
                        }
                    }
                }
            }
        }
    }

    public void hideCommonViewByHandler(RGMMCommonNotificationView view) {
        view.hide();
    }

    public void hideOperableViewByHandler(RGMMOperableNotificationView view) {
        view.autoHideWithoutClick();
        view.hide();
    }

    public void updateOperableViewCountingByHandler(RGMMOperableNotificationView view) {
        if (view != null) {
            view.updateCancelTextCounting();
        }
    }

    public void dispose() {
        if (this.mCommonViewList != null && this.mOperableViewList != null) {
            if (!this.mCommonViewList.isEmpty()) {
                ArrayList<RGMMCommonNotificationView> tmpCommonList = new ArrayList(this.mCommonViewList);
                this.mCommonViewList.clear();
                Iterator<RGMMCommonNotificationView> it = tmpCommonList.iterator();
                while (it.hasNext()) {
                    ((RGMMCommonNotificationView) it.next()).dispose();
                }
                tmpCommonList.clear();
            }
            if (!this.mOperableViewList.isEmpty()) {
                ArrayList<RGMMOperableNotificationView> tmpOperableList = new ArrayList(this.mOperableViewList);
                this.mCommonViewList.clear();
                Iterator<RGMMOperableNotificationView> it2 = tmpOperableList.iterator();
                while (it2.hasNext()) {
                    ((RGMMOperableNotificationView) it2.next()).dispose();
                }
                tmpOperableList.clear();
            }
            View rootView = RGViewController.getInstance().getView();
            ViewGroup rootViewGroup = null;
            if (rootView != null) {
                rootViewGroup = (ViewGroup) rootView;
            }
            if (rootViewGroup != null) {
                View notificationViewPanel = RGViewController.getInstance().getViewContails(C4048R.id.bnav_rg_notification_panel);
                ViewGroup viewContainer = RGViewController.getInstance().getViewContails(C4048R.id.bnav_rg_notification_container);
                if (viewContainer != null) {
                    rootViewGroup.removeView(viewContainer);
                    viewContainer.setVisibility(8);
                }
                if (notificationViewPanel != null) {
                    rootViewGroup.removeView(notificationViewPanel);
                    notificationViewPanel.setVisibility(8);
                }
            }
        }
    }

    public void uninit() {
        if (this.mCommonModelList != null && this.mCommonViewList != null && this.mOperableModelList != null && this.mOperableViewList != null) {
            if (!this.mCommonModelList.isEmpty()) {
                Iterator<RGCommonNotificationModel> it = this.mCommonModelList.iterator();
                while (it.hasNext()) {
                    RGCommonNotificationModel model = (RGCommonNotificationModel) it.next();
                    if (model != null) {
                        model.reset();
                    }
                    it.remove();
                }
            }
            if (!this.mOperableModelList.isEmpty()) {
                Iterator<RGOperableNotificationModel> it2 = this.mOperableModelList.iterator();
                while (it2.hasNext()) {
                    RGOperableNotificationModel model2 = (RGOperableNotificationModel) it2.next();
                    if (model2 != null) {
                        model2.reset();
                    }
                    it2.remove();
                }
            }
            this.mIsClickQuietBtn = false;
        }
    }

    public void hideAllView(boolean isCommonViewRecoverable, boolean isOperableViewRecoverable) {
        LogUtil.m15791e(TAG, "hideAllView isCommonViewRecoverable = " + isCommonViewRecoverable + ", isOperableViewRecoverable = " + isOperableViewRecoverable);
        if (this.mCommonModelList != null && this.mOperableModelList != null) {
            Iterator<RGCommonNotificationModel> commonIt = this.mCommonModelList.iterator();
            while (commonIt.hasNext()) {
                RGCommonNotificationModel model = (RGCommonNotificationModel) commonIt.next();
                if (!(model == null || model.mView == null)) {
                    model.mView.hideWithoutAnim();
                    if (!isCommonViewRecoverable) {
                        model.reset();
                        commonIt.remove();
                    }
                }
            }
            Iterator<RGOperableNotificationModel> operableIt = this.mOperableModelList.iterator();
            while (operableIt.hasNext()) {
                RGOperableNotificationModel model2 = (RGOperableNotificationModel) operableIt.next();
                if (!(model2 == null || model2.mView == null)) {
                    model2.mView.hideWithoutAnim();
                    if (!isOperableViewRecoverable) {
                        model2.mView.dispose();
                        model2.reset();
                        operableIt.remove();
                    }
                }
            }
        }
    }

    public void hideAllCommonView() {
        if (this.mCommonModelList != null) {
            Iterator<RGCommonNotificationModel> commonIt = this.mCommonModelList.iterator();
            while (commonIt.hasNext()) {
                RGCommonNotificationModel model = (RGCommonNotificationModel) commonIt.next();
                if (!(model == null || model.mView == null || model.mView.mInAnimation == null)) {
                    if (model.mView.mInAnimation.hasEnded()) {
                        model.mView.hideWithoutRemoveModel();
                    } else {
                        model.mView.hideWithoutAnim();
                    }
                    model.reset();
                    commonIt.remove();
                }
            }
        }
    }

    public void hideOtherCommonViewBeforeThis(RGCommonNotificationModel model) {
        if (this.mCommonModelList == null || model == null) {
            LogUtil.m15791e(TAG, "mCommonModelList = " + this.mCommonModelList + ", model = " + model);
        } else if (this.mCommonModelList.contains(model)) {
            Iterator<RGCommonNotificationModel> commonIt = this.mCommonModelList.iterator();
            while (commonIt.hasNext()) {
                RGCommonNotificationModel e = (RGCommonNotificationModel) commonIt.next();
                if (e == null || e.equals(model)) {
                    if (e != null && e.equals(model)) {
                        return;
                    }
                } else if (e.mView != null) {
                    e.mView.hideWithoutAnim();
                    e.reset();
                    commonIt.remove();
                }
            }
        } else {
            LogUtil.m15791e(TAG, "mode is not in the list");
        }
    }

    public void hideAllOperableView() {
        if (this.mOperableModelList != null) {
            Iterator<RGOperableNotificationModel> operableIt = this.mOperableModelList.iterator();
            while (operableIt.hasNext()) {
                RGOperableNotificationModel model = (RGOperableNotificationModel) operableIt.next();
                if (!(model == null || model.mView == null || model.mView.mInAnimation == null)) {
                    if (model.mView.mInAnimation.hasEnded()) {
                        model.mView.hideWithoutRemoveModel();
                    } else {
                        model.mView.hideWithoutAnim();
                    }
                    model.reset();
                    operableIt.remove();
                }
            }
        }
    }

    public boolean hasOperableNotification() {
        if (this.mOperableModelList == null || this.mOperableModelList.isEmpty()) {
            return false;
        }
        return true;
    }

    public void recoveryOperableNotification() {
        if (this.mOperableModelList != null) {
            Iterator<RGOperableNotificationModel> operableIt = this.mOperableModelList.iterator();
            while (operableIt.hasNext()) {
                RGOperableNotificationModel model = (RGOperableNotificationModel) operableIt.next();
                if (!(model == null || model.mView == null)) {
                    model.mView.recoveryView();
                }
            }
        }
    }

    public boolean allowNotificationShow(boolean isOperable, int type) {
        boolean isNavOperate = NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState());
        ViewGroup safety = RGViewController.getInstance().getSafetyViewContails();
        ViewGroup module = RGViewController.getInstance().getModuleContails();
        boolean isSafetyVisible = safety == null ? false : safety.getVisibility() == 0;
        boolean isModuleVisible = module == null ? false : module.getVisibility() == 0;
        boolean isBlueToothUSBGuideVisible = RGViewController.getInstance().isBlueToothUSBGuideVisible();
        boolean isMenuMoreVisible = RGViewController.getInstance().isMenuMoreVisible();
        boolean isRouteSearchVisible = RGViewController.getInstance().isRouteSearchVisible();
        boolean isUGCPanelVisible = RGViewController.getInstance().isUGCPanelVisible();
        boolean isCommomViewShow = RGViewController.getInstance().isCommomViewShow();
        boolean isEnlargeOrColladaShow = RGViewController.getInstance().isEnlargeOrColladaShow();
        boolean isHUDStatus = RGMapModeViewController.getInstance().getHudShowStatus();
        boolean isRouteSortViewVisible = RGMapModeViewController.getInstance().isRouteSortViewVisible();
        boolean isToolboxOpened = RGMapModeViewController.getInstance().isToolboxOpened();
        LogUtil.m15791e(TAG, "allowNotificationShow isNavOperate = " + isNavOperate + ", isSafetyVisible = " + isSafetyVisible + ", isModuleVisible = " + isModuleVisible + ", isBlueToothUSBGuideVisible = " + isBlueToothUSBGuideVisible + ", isMenuMoreVisible = " + isMenuMoreVisible + ", isRouteSearchVisible = " + isRouteSearchVisible + ", isUGCPanelVisible = " + isUGCPanelVisible + ", isCommomViewShow = " + isCommomViewShow + ", isEnlargeOrColladaShow = " + isEnlargeOrColladaShow + ", isHUDStatus = " + isHUDStatus + ", isRouteSortViewVisible = " + isRouteSortViewVisible + ", isToolboxOpened = " + isToolboxOpened);
        if (!isOperable || (!(type == 103 || type == 107 || type == 108 || type == 102) || isMenuMoreVisible || isHUDStatus || isEnlargeOrColladaShow)) {
            if ((isOperable && type == 106) || (!isOperable && type == 112)) {
                isNavOperate = false;
            }
            if (isOperable && (type == 100 || type == 105 || type == 104 || type == 101)) {
                isToolboxOpened = false;
            }
            if (isNavOperate || isSafetyVisible || isModuleVisible || isBlueToothUSBGuideVisible || isMenuMoreVisible || isRouteSearchVisible || isUGCPanelVisible || isCommomViewShow || isEnlargeOrColladaShow || isHUDStatus || isRouteSortViewVisible || isToolboxOpened) {
                return false;
            }
            return true;
        }
        LogUtil.m15791e(TAG, "allowNotificationShow return true type = " + type);
        return true;
    }

    private void commonModelListToString() {
        if (this.mCommonModelList == null || this.mCommonModelList.isEmpty()) {
            LogUtil.m15791e(TAG, "mCommonModelList = " + this.mCommonModelList);
            return;
        }
        for (int i = 0; i < this.mCommonModelList.size(); i++) {
            if (this.mCommonModelList.get(i) == null) {
                LogUtil.m15791e(TAG, "mCommonModelList (" + i + ") is null");
            } else {
                LogUtil.m15791e(TAG, i + "mCommonModelList mID = " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mID + " mPriority = " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mPriority + ", mMainTitleText = " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mMainTitleText + ", mSubTitleText = " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mSubTitleText + ", mThirdTitleText + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mThirdTitleText + ", mMainTitleColor + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mMainTitleColor + ", mSubTitleColor + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mSubTitleColor + ", mThirdTitleColor + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mThirdTitleColor + ", mNotificationColor + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mNotificationColor + ", mAutoHideTime + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mAutoHideTime + ", mNotificationIcon + " + ((RGCommonNotificationModel) this.mCommonModelList.get(i)).mNotificationIcon);
            }
        }
    }

    private void commonViewListToString() {
        if (this.mCommonViewList == null || this.mCommonViewList.isEmpty()) {
            LogUtil.m15791e(TAG, "mCommonViewList = " + this.mCommonViewList);
            return;
        }
        for (int i = 0; i < this.mCommonViewList.size(); i++) {
            if (this.mCommonModelList.get(i) == null) {
                LogUtil.m15791e(TAG, "mCommonViewList (" + i + ") is null");
            } else {
                LogUtil.m15791e(TAG, i + "mCommonViewList hashCode = " + ((RGMMCommonNotificationView) this.mCommonViewList.get(i)).hashCode());
            }
        }
    }

    private void operableModelListToString() {
        if (this.mOperableModelList == null || this.mOperableModelList.isEmpty()) {
            LogUtil.m15791e(TAG, "mOperableModelList = " + this.mOperableModelList);
            return;
        }
        for (int i = 0; i < this.mOperableModelList.size(); i++) {
            if (this.mOperableModelList.get(i) == null) {
                LogUtil.m15791e(TAG, "mOperableModelList (" + i + ") is null");
            } else {
                LogUtil.m15791e(TAG, i + "mOperableModelList mID = " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mID + " mPriority = " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mPriority + ", mMainTitleText = " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mMainTitleText + ", mSubTitleText = " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mSubTitleText + ", mMainTitleColor + " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mMainTitleColor + ", mSubTitleColor + " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mSubTitleColor + ", mNotificationColor + " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mNotificationColor + ", mAutoHideTime + " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mAutoHideTime + ", mNotificationIcon + " + ((RGOperableNotificationModel) this.mOperableModelList.get(i)).mNotificationIcon);
            }
        }
    }

    private void operableViewListToString() {
        if (this.mOperableViewList == null || this.mOperableViewList.isEmpty()) {
            LogUtil.m15791e(TAG, "mOperableViewList = " + this.mOperableViewList);
            return;
        }
        for (int i = 0; i < this.mOperableViewList.size(); i++) {
            if (this.mOperableViewList.get(i) == null) {
                LogUtil.m15791e(TAG, "mOperableViewList (" + i + ") is null");
            } else {
                LogUtil.m15791e(TAG, i + "mOperableViewList hashCode = " + ((RGMMOperableNotificationView) this.mOperableViewList.get(i)).hashCode());
            }
        }
    }

    public int getLocalRouteType() {
        Bundle bundle = new Bundle();
        boolean result = JNIGuidanceControl.getInstance().GetLocalRouteInfo(bundle);
        if (bundle == null || !result || TextUtils.isEmpty(Html.fromHtml(bundle.getString("info")).toString())) {
            return -1;
        }
        return bundle.getInt("type");
    }

    private String getLocalRouteInfo() {
        Bundle bundle = new Bundle();
        boolean result = JNIGuidanceControl.getInstance().GetLocalRouteInfo(bundle);
        if (bundle == null || !result) {
            return "";
        }
        return Html.fromHtml(bundle.getString("info")).toString();
    }

    public void showLocalRoute(boolean isStartNav) {
        int type = getLocalRouteType();
        String info = getLocalRouteInfo();
        if (type == 1) {
            RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_traffic_restriction)).setMainTitleText(info).show();
        } else if (type == 0 && isStartNav) {
            RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_traffic_restriction)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_set_car_nummber_maintitle)).setSubTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_set_car_nummber_subtitle)).show();
        }
    }

    public void showSwitchRouteSuccess() {
        RGViewController.getInstance().newCommonNotification(108).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_success)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_build_success)).show();
    }

    public void showSwitchRouteFail() {
        RGViewController.getInstance().newCommonNotification(107).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_fail)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_build_fail)).show();
    }

    public void showFloatWindowSuccess() {
        RGViewController.getInstance().newCommonNotification(101).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_success)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_show_float_window)).show();
    }

    public void showPark() {
        if (BNavigator.getInstance().getCanParkShow()) {
            final SearchParkPoi poi = getNearestParkPoi();
            if (poi != null) {
                String showText = "";
                if (poi.mLeftCnt > 0) {
                    showText = String.format("%1$d个空车位，距离终点%2$d米", new Object[]{Integer.valueOf(poi.mLeftCnt), Integer.valueOf(poi.mDistance)});
                } else {
                    showText = String.format("停车场距终点%1$d米", new Object[]{Integer.valueOf(poi.mDistance)});
                }
                RGViewController.getInstance().closeToolbox();
                RGViewController.getInstance().hideRouteSearchView();
                RGViewController.getInstance().hideRouteSortView();
                RGViewController.getInstance().hideMenuMoreView();
                RGViewController.getInstance().onUgcDestroy();
                RGViewController.getInstance().newOperableNotification(102).setPriority(100).setAutoHideTime(20000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_park)).setMainTitleText(showText).setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_park_confirm)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_cancel)).setOnClick(new NotificationClickListener() {
                    public void onConfirmBtnClick() {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_PARK_STOP, NaviStatConstants.NAVI_PARK_STOP);
                        BNavigator.getInstance().setmCanParkShow(false);
                        BNRoutePlaner.getInstance().setGuideSceneType(4);
                        if (poi != null) {
                            GeoPoint point = poi.mGuidePoint;
                            RGSimpleGuideModel.getInstance();
                            RGSimpleGuideModel.mCalcRouteType = 4;
                            RGEngineControl.getInstance().setEndPtToCalcRoute(point);
                        }
                    }

                    public void onCancelBtnClick() {
                        BNavigator.getInstance().setmCanParkShow(false);
                        RGViewController.getInstance().hideParkPointView();
                        RGParkPointModel.getInstance().setmIsParkPointShow(false);
                        BNMapController.getInstance().showLayer(4, false);
                    }

                    public void onAutoHideWithoutClick() {
                        BNavigator.getInstance().setmCanParkShow(false);
                        RGViewController.getInstance().hideParkPointView();
                        RGParkPointModel.getInstance().setmIsParkPointShow(false);
                        BNMapController.getInstance().showLayer(4, false);
                    }
                }).setDisplayListener(new C43411()).show();
            }
        }
    }

    private SearchParkPoi getNearestParkPoi() {
        ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
        if (list == null || list.size() == 0) {
            return null;
        }
        int nearDistance = 10000;
        int nearItemIndex = 0;
        ArrayList<SearchParkPoi> localList = new ArrayList(list);
        for (int i = 0; i < localList.size(); i++) {
            SearchParkPoi poi = (SearchParkPoi) localList.get(i);
            if (poi != null && poi.mDistance < nearDistance) {
                nearDistance = poi.mDistance;
                nearItemIndex = i;
            }
        }
        if (nearItemIndex < localList.size()) {
            return (SearchParkPoi) localList.get(nearItemIndex);
        }
        return null;
    }

    public void showUpdateRCFail() {
        if (RGUpdateRCFailModel.getInstance().isRCUpdateFialCanShow()) {
            RGViewController.getInstance().newCommonNotification(111).setPriority(200).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_road_condition_fail)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_update_road_condition_fail)).setDisplayListener(new C43433()).show();
        }
    }

    public void showBlueTooth() {
        LogUtil.m15791e(TAG, "showBlueTooth");
        if (isContainsOperableType(104)) {
            LogUtil.m15791e(TAG, "domestic clould config voice recommend operable notification is showing");
        } else if (isContainsOperableType(105)) {
            LogUtil.m15791e(TAG, "international clould config voice recommend operable notification is showing");
        } else {
            RGViewController.getInstance().newOperableNotification(100).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_bluetooth)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_bluetooth_main_title)).setSubTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_bluetooth_sub_title)).setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_bluetooth_confirm)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_bluetooth_cancel)).setOnClick(new C43444()).show();
        }
    }

    public void showBusinessVoiceRecommend() {
        LogUtil.m15791e(TAG, "showBusinessVoiceRecommend");
        if (BNavigator.getInstance().hasCalcRouteOk() && BusinessActivityManager.getInstance().getModel().mIsShowVoiceNotificaiton && !BNSettingManager.getHasVoiceRecommendClicked()) {
            RoutePlanModel model = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
            if ((model == null || model.getEnNaviType() == 0) && BNSettingManager.getVoiceRecommendNotificationShowCnt() < BusinessActivityManager.getInstance().getModel().mVoiceShowTime) {
                final String voiceDetailURL = BusinessActivityManager.getInstance().getModel().mVoiceDetailURL;
                String voiceIconURL = BusinessActivityManager.getInstance().getModel().mVoiceIconURL;
                String voiceMainTitle = BusinessActivityManager.getInstance().getModel().mVoiceMainTitle;
                String voiceSubTitle = BusinessActivityManager.getInstance().getModel().mVoiceSubTitle;
                final String voiceTaskId = BusinessActivityManager.getInstance().getModel().mVoiceTaskId;
                if (!TextUtils.isEmpty(voiceDetailURL) && !TextUtils.isEmpty(voiceIconURL) && !TextUtils.isEmpty(voiceMainTitle) && !TextUtils.isEmpty(voiceSubTitle) && !TextUtils.isEmpty(voiceTaskId) && !VoiceHelper.getInstance().isTaskDownloadFinish(voiceTaskId)) {
                    RGViewController.getInstance().newOperableNotification(104).setPriority(100).setAutoHideTime(BusinessActivityManager.getInstance().getModel().mVoiceAutoHideTime * 1000).setNotificationIcon(voiceIconURL, new BNDisplayImageOptions$Builder().showImageOnLoading(C4048R.drawable.nsdk_notification_default_business_voice).build(), null).setMainTitleText(voiceMainTitle).setSubTitleText(voiceSubTitle).setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_voice_recommend_confirm)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_voice_recommend_cancel)).setOnClick(new NotificationClickListener() {
                        public void onConfirmBtnClick() {
                            UserOPController.getInstance().add(UserOPParams.VOICE_5_4_1, "2", null, null);
                            String url = "";
                            if (VoiceHelper.getInstance().isTaskDownloadFinish(voiceTaskId)) {
                                url = voiceDetailURL + "&isload=1";
                            } else {
                                url = voiceDetailURL + "&isload=0";
                            }
                            RGNotificationController.this.handleClickVoiceDownloadBtn(url);
                            BNSettingManager.setHasVoiceRecommendClicked(true);
                        }

                        public void onCancelBtnClick() {
                            UserOPController.getInstance().add(UserOPParams.VOICE_5_4_1, "3", null, null);
                            BNSettingManager.setHasVoiceRecommendClicked(true);
                        }

                        public void onAutoHideWithoutClick() {
                        }
                    }).setDisplayListener(new C43455()).show();
                }
            }
        }
    }

    private void handleClickVoiceDownloadBtn(String url) {
        if (!TextUtils.isEmpty(url)) {
            VoiceInfo info = new VoiceInfo();
            info.status = 4;
            info.voiceUrl = url;
            Bundle bundle = new Bundle();
            bundle.putInt(Key.BUNDLE_ROOT_PAGE_TYPE, 2);
            bundle.putBundle(BNVoiceParams.BUNDLE_VOICEINFO, info.toBundle());
            BNVoice.getInstance().setInternalCall(bundle);
            BNavigator.getInstance().jumpToRecommendVoicePage(bundle);
        }
    }

    public void showQuietMode() {
        LogUtil.m15791e(TAG, "showQuietMode");
        if (!RGControlPanelModel.getInstance().ismIsConfigChange() && this.mIsClickQuietBtn) {
            this.mIsClickQuietBtn = false;
            if (BNSettingManager.getVoiceMode() == 2) {
                RGViewController.getInstance().newCommonNotification(104).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_quiet_mode_open)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_open_quiet_mode_maintitle)).setSubTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_open_quiet_mode_subtitle)).show();
            } else {
                RGViewController.getInstance().newCommonNotification(105).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_quiet_mode_close)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_close_quiet_mode)).show();
            }
        }
    }

    public void showUgcOfficialEvent() {
        LogUtil.m15791e(TAG, "showUgcOfficialEvent");
        if (RGSimpleGuideModel.mIsUgcOfficialEvent) {
            String text = JNIGuidanceControl.getInstance().GetRoadEventText();
            if (TextUtils.isEmpty(text)) {
                LogUtil.m15791e(TAG, "title is null or empty");
            } else {
                RGViewController.getInstance().newCommonNotification(109).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_ugc_official_event)).setMainTitleText(text).setDisplayListener(new C43477()).show();
            }
        }
    }

    public void showRouteRecommend() {
        LogUtil.m15791e(TAG, "showRouteRecommend");
        if (RGRouteRecommendModel.getInstance().isViewCanShow) {
            RGViewController.getInstance().closeToolbox();
            RGViewController.getInstance().hideRouteSearchView();
            RGViewController.getInstance().hideRouteSortView();
            RGViewController.getInstance().hideMenuMoreView();
            RGViewController.getInstance().onUgcDestroy();
            RGMMOperableNotificationView view = RGRouteRecommendModel.getInstance().getNotificationView();
            if (view != null) {
                view.show();
            }
        }
    }

    public void updateVoiceNotificationStatus(final int voiceStatus) {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("updateVoiceNotificationStatus-" + getClass().getSimpleName(), null) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected java.lang.String execute() {
                /*
                r8 = this;
                r7 = 0;
                r4 = com.baidu.navisdk.ui.routeguide.control.RGNotificationController.this;
                r4 = r4.mOperableModelList;
                if (r4 == 0) goto L_0x007d;
            L_0x0009:
                r4 = com.baidu.navisdk.ui.routeguide.control.RGNotificationController.this;
                r4 = r4.mOperableModelList;
                r4 = r4.size();
                if (r4 <= 0) goto L_0x007d;
            L_0x0015:
                r4 = com.baidu.navisdk.ui.routeguide.control.RGNotificationController.this;
                r4 = r4.mOperableModelList;
                r4 = r4.iterator();
            L_0x001f:
                r5 = r4.hasNext();
                if (r5 == 0) goto L_0x007d;
            L_0x0025:
                r1 = r4.next();
                r1 = (com.baidu.navisdk.ui.routeguide.model.RGOperableNotificationModel) r1;
                r5 = r1.mNotificationType;
                r6 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
                if (r5 == r6) goto L_0x0037;
            L_0x0031:
                r5 = r1.mNotificationType;
                r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
                if (r5 != r6) goto L_0x001f;
            L_0x0037:
                r4 = r1.mView;
                if (r4 == 0) goto L_0x007d;
            L_0x003b:
                r4 = r1.mView;
                r4 = r4.isVisibility();
                if (r4 == 0) goto L_0x007d;
            L_0x0043:
                r2 = -1;
                r4 = r6;
                switch(r4) {
                    case 0: goto L_0x0099;
                    case 1: goto L_0x009d;
                    case 2: goto L_0x00a1;
                    case 3: goto L_0x0049;
                    case 4: goto L_0x007e;
                    default: goto L_0x0049;
                };
            L_0x0049:
                r2 = 1711407997; // 0x6602037d float:1.53493E23 double:8.455478973E-315;
            L_0x004c:
                r4 = r1.mView;
                r5 = 1711408006; // 0x66020386 float:1.5349316E23 double:8.45547902E-315;
                r5 = com.baidu.navisdk.ui.util.BNStyleManager.getDrawable(r5);
                r4.setNotificationBackground(r5);
                r4 = r1.mView;
                r5 = com.baidu.navisdk.ui.util.BNStyleManager.getDrawable(r2);
                r4.setNotificationIcon(r5);
                r4 = r1.mView;
                r4 = r4.getNotificationIcon();
                r5 = java.lang.Integer.valueOf(r2);
                r4.setTag(r5);
                r4 = r1.mView;
                r0 = r4.getIconDrawable();
                r4 = r0 instanceof android.graphics.drawable.AnimationDrawable;
                if (r4 == 0) goto L_0x007d;
            L_0x0078:
                r0 = (android.graphics.drawable.AnimationDrawable) r0;
                r0.start();
            L_0x007d:
                return r7;
            L_0x007e:
                r4 = r1.mView;
                r4 = r4.getNotificationIcon();
                r3 = r4.getTag();
                if (r3 == 0) goto L_0x0095;
            L_0x008a:
                r3 = (java.lang.Integer) r3;
                r4 = r3.intValue();
                r5 = 1711408004; // 0x66020384 float:1.5349312E23 double:8.45547901E-315;
                if (r4 == r5) goto L_0x007d;
            L_0x0095:
                r2 = 1711408002; // 0x66020382 float:1.5349309E23 double:8.455479E-315;
                goto L_0x004c;
            L_0x0099:
                r2 = 1711408003; // 0x66020383 float:1.534931E23 double:8.455479003E-315;
                goto L_0x004c;
            L_0x009d:
                r2 = 1711408005; // 0x66020385 float:1.5349314E23 double:8.455479013E-315;
                goto L_0x004c;
            L_0x00a1:
                r2 = 1711408004; // 0x66020384 float:1.5349312E23 double:8.45547901E-315;
                goto L_0x004c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.control.RGNotificationController.8.execute():java.lang.String");
            }
        }, new BNWorkerConfig(2, 0));
    }

    public void hideRouteRecommend() {
        LogUtil.m15791e(TAG, "hideRouteRecommend");
        if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
            RGViewController.getInstance().showHighWayServiceView();
        }
    }

    public void showCancelRouteRecommend() {
        LogUtil.m15791e(TAG, "showCancelRouteRecommend");
        RGViewController.getInstance().newCommonNotification(100).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_fail)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_cancel_route_recommend)).show();
    }

    public void showWaitRPResult(int errorCode) {
        LogUtil.m15791e(TAG, "showWaitRPResult");
        RGViewController.getInstance().newOperableNotification(101).setPriority(100).setAutoHideTime(-1).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_fail)).setMainTitleText(BNStyleManager.getString(C4048R.string.f19695xeeac2bf2)).setSubTitleText(BNStyleManager.getString(C4048R.string.f19697x6efa8ff9)).setConfirmText(BNStyleManager.getString(C4048R.string.f19694x60c47b20)).setCancelText(BNStyleManager.getString(C4048R.string.f19693x65728e1a)).setOnClick(new C43499()).show();
    }

    public void showUgcReportSuccess(String subtitle) {
        RGViewController.getInstance().newCommonNotification(110).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_success)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_report_success_maintitle)).setSubTitleText(subtitle).show();
    }

    public void showGPSWeak() {
        if (RGSimpleGuideModel.mIsSatellite) {
            RGViewController.getInstance().newCommonNotification(102).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_gps)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_gps_weak_maintitle)).show();
        }
    }

    public void showRPPrefer() {
        if (RGSimpleGuideModel.mIsRPPrefer) {
            String tips = getRPPreferTipsText();
            if (!TextUtils.isEmpty(tips)) {
                RGViewController.getInstance().newCommonNotification(106).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_success)).setMainTitleText(tips).setDisplayListener(new NotificationDisplayListener() {
                    public void onShowWithAnim() {
                    }

                    public void onShowWithOutAnim() {
                    }

                    public void onHideWithAnim() {
                        RGSimpleGuideModel.mIsRPPrefer = false;
                    }

                    public void onHideWithOutAnim() {
                        RGSimpleGuideModel.mIsRPPrefer = false;
                    }
                }).show();
            }
        }
    }

    private String getRPPreferTipsText() {
        String str = "";
        if (TextUtils.isEmpty(RGRouteSortController.getInstance().getCurrentRouteSortName())) {
            return str;
        }
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_common_notification_route_prefer, new Object[]{preferName});
    }

    private boolean isOnLineNetMode() {
        int netMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
        if (netMode == 3 || netMode == 1) {
            return true;
        }
        return false;
    }

    public boolean hasOtherOperableModelShowMasking(RGOperableNotificationModel model) {
        if (this.mOperableModelList == null || model == null) {
            return false;
        }
        Iterator<RGOperableNotificationModel> it = this.mOperableModelList.iterator();
        while (it.hasNext()) {
            RGOperableNotificationModel e = (RGOperableNotificationModel) it.next();
            if (e != null && !e.equals(model) && e.mIsShowMasking) {
                return true;
            }
        }
        return false;
    }

    public void hideOperableView(int type) {
        LogUtil.m15791e(TAG, "hideOperableView type = " + type);
        hideOperableViewInner(type);
        switch (type) {
            case 103:
            case 107:
            case 108:
                if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
                    RGViewController.getInstance().showHighWayServiceView();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void hideCommonView(int type) {
        LogUtil.m15791e(TAG, "hideCommonView type = " + type);
        hideCommonViewInner(type);
        switch (type) {
        }
    }

    public void debugCommonNotification(boolean isShow) {
        if (isShow) {
            updateCommonRandomInt();
        }
        switch (this.mCommonRandomInt) {
            case 0:
                if (isShow) {
                    showCancelRouteRecommend();
                    return;
                }
                return;
            case 1:
                if (isShow) {
                    RGViewController.getInstance().newCommonNotification(109).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_ugc_official_event)).setMainTitleText("假数据：UGC交警").setDisplayListener(new NotificationDisplayListener() {
                        public void onShowWithAnim() {
                        }

                        public void onShowWithOutAnim() {
                        }

                        public void onHideWithAnim() {
                            RGSimpleGuideModel.mIsUgcOfficialEvent = false;
                        }

                        public void onHideWithOutAnim() {
                            RGSimpleGuideModel.mIsUgcOfficialEvent = false;
                        }
                    }).show();
                    return;
                } else {
                    hideCommonView(109);
                    return;
                }
            case 2:
                if (isShow) {
                    showFloatWindowSuccess();
                    return;
                }
                return;
            case 3:
                if (isShow) {
                    showSwitchRouteFail();
                    return;
                }
                return;
            case 4:
                if (isShow) {
                    showSwitchRouteSuccess();
                    return;
                }
                return;
            case 5:
                if (isShow) {
                    RGViewController.getInstance().newCommonNotification(111).setPriority(200).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_road_condition_fail)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_update_road_condition_fail)).setDisplayListener(new NotificationDisplayListener() {
                        public void onShowWithAnim() {
                        }

                        public void onShowWithOutAnim() {
                        }

                        public void onHideWithAnim() {
                            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
                        }

                        public void onHideWithOutAnim() {
                            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
                        }
                    }).show();
                    return;
                } else {
                    hideCommonView(111);
                    return;
                }
            case 6:
                if (isShow) {
                    RGViewController.getInstance().newCommonNotification(103).setPriority(300).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_traffic_restriction)).setMainTitleText("起点在深圳限行区域，合理安排出行避免违章").show();
                    return;
                }
                return;
            case 7:
                if (isShow) {
                    RGViewController.getInstance().newCommonNotification(104).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_quiet_mode_open)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_open_quiet_mode_maintitle)).setSubTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_open_quiet_mode_subtitle)).show();
                    return;
                }
                return;
            case 8:
                if (isShow) {
                    RGViewController.getInstance().newCommonNotification(105).setPriority(100).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_quiet_mode_close)).setMainTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_common_notification_close_quiet_mode)).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void debugOperableNotification(boolean isShow) {
        if (isShow) {
            updateOperableRandomInt();
        }
        switch (this.mOperableRandomInt) {
            case 0:
                if (isShow) {
                    final SearchParkPoi poi = getNearestParkPoi();
                    if (poi != null) {
                        String showText = "";
                        if (poi.mLeftCnt > 0) {
                            showText = String.format("%1$d个空车位，距离终点%2$d米", new Object[]{Integer.valueOf(poi.mLeftCnt), Integer.valueOf(poi.mDistance)});
                        } else {
                            showText = String.format("停车场距终点%1$d米", new Object[]{Integer.valueOf(poi.mDistance)});
                        }
                        RGViewController.getInstance().newOperableNotification(102).setPriority(100).setAutoHideTime(20000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_park)).setMainTitleText("假数据：目的地停车场主标题").setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_park_confirm)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_operable_notification_cancel)).setOnClick(new NotificationClickListener() {
                            public void onConfirmBtnClick() {
                                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_PARK_STOP, NaviStatConstants.NAVI_PARK_STOP);
                                BNavigator.getInstance().setmCanParkShow(false);
                                BNRoutePlaner.getInstance().setGuideSceneType(4);
                                BNRouteGuider.getInstance().stopRouteGuide();
                                if (poi != null) {
                                    GeoPoint point = poi.mGuidePoint;
                                    RGSimpleGuideModel.getInstance();
                                    RGSimpleGuideModel.mCalcRouteType = 4;
                                    RGEngineControl.getInstance().setEndPtToCalcRoute(point);
                                }
                            }

                            public void onCancelBtnClick() {
                                BNavigator.getInstance().setmCanParkShow(false);
                                RGViewController.getInstance().hideParkPointView();
                                RGParkPointModel.getInstance().setmIsParkPointShow(false);
                                BNMapController.getInstance().showLayer(4, false);
                            }

                            public void onAutoHideWithoutClick() {
                                BNavigator.getInstance().setmCanParkShow(false);
                                RGViewController.getInstance().hideParkPointView();
                                RGParkPointModel.getInstance().setmIsParkPointShow(false);
                                BNMapController.getInstance().showLayer(4, false);
                            }
                        }).show();
                        return;
                    }
                    return;
                }
                hideOperableView(102);
                return;
            case 1:
                if (isShow) {
                    showBlueTooth();
                    return;
                }
                return;
            case 2:
                if (!isShow) {
                    RGRouteRecommendModel.getInstance().isViewCanShow = false;
                    BNavigator.getInstance().enterNavState();
                    JNIGuidanceControl.getInstance().setShowRouteChoose(2);
                    hideOperableView(103);
                    BNMapController.getInstance().recoveryHighLightRoute();
                    return;
                } else if (!BNavigator.getInstance().isBackgroundNavi() && !RGViewController.getInstance().isEnlargeOrColladaShow() && !RGViewController.getInstance().isUGCFBackMenuVisible() && RouteGuideFSM.getInstance().getLastestGlassState() != null && !RouteGuideFSM.getInstance().getLastestGlassState().equals(FsmState.BrowseMap)) {
                    if (RGMapModeViewController.getInstance().getHudShowStatus()) {
                        LogUtil.m15791e(TAG, "showRouteRecommend hud is showing");
                        return;
                    }
                    RGRouteRecommendModel.getInstance().isViewCanShow = true;
                    JNIGuidanceControl.getInstance().setShowRouteChoose(1);
                    RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_FULL_VIEW);
                    RGViewController.getInstance().updateZoomViewState();
                    BNMapController.getInstance().setHighLightAvoidTrafficRoute(RGRouteRecommendModel.getInstance().getmRouteId());
                    if (RGRouteRecommendModel.getInstance().isViewCanShow) {
                        if (RGRouteRecommendModel.getInstance().getmContent() == null) {
                            String titleName = "";
                        }
                        if (RGRouteRecommendModel.getInstance().getmSubContent() == null) {
                            String roadName = "";
                        }
                        RGViewController.getInstance().newOperableNotification(103).setPriority(100).setAutoHideTime(RGRouteRecommendModel.getInstance().getAutoHideTime()).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_route_recommend)).setMainTitleText("假数据：更快路线推荐主标题").setSubTitleText("假数据：更快路线推荐副标题").setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_ok)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_cancle)).setShowMasking(true).setOnClick(new NotificationClickListener() {
                            public void onConfirmBtnClick() {
                                RGRouteRecommendModel.getInstance().isViewCanShow = false;
                                BNavigator.getInstance().actionRouteRecommendClick(true, false);
                            }

                            public void onCancelBtnClick() {
                                RGRouteRecommendModel.getInstance().isViewCanShow = false;
                                BNavigator.getInstance().actionRouteRecommendClick(false, false);
                            }

                            public void onAutoHideWithoutClick() {
                                RGRouteRecommendModel.getInstance().isViewCanShow = false;
                                BNavigator.getInstance().actionRouteRecommendClick(false, false);
                            }
                        }).setDisplayListener(new NotificationDisplayListener() {
                            public void onShowWithAnim() {
                                RGViewController.getInstance().hideHighWayServiceView();
                            }

                            public void onShowWithOutAnim() {
                                RGViewController.getInstance().hideHighWayServiceView();
                            }

                            public void onHideWithAnim() {
                                if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
                                    RGViewController.getInstance().showHighWayServiceView();
                                }
                            }

                            public void onHideWithOutAnim() {
                            }
                        }).show();
                        JNIGuidanceControl.getInstance().setShowRouteChoose(0);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 3:
                if (isShow) {
                    showWaitRPResult(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void updateCommonRandomInt() {
        this.mCommonRandomInt = new Random().nextInt(9);
        LogUtil.m15791e(TAG, "mCommonRandomInt = " + this.mCommonRandomInt);
    }

    private void updateOperableRandomInt() {
        this.mOperableRandomInt = new Random().nextInt(4);
        LogUtil.m15791e(TAG, "mOperableRandomInt = " + this.mOperableRandomInt);
    }

    public void showCommonResultMsg(String title, boolean success) {
        Drawable drawable;
        RGMMCommonNotificationView priority = RGViewController.getInstance().newCommonNotification(112).setPriority(100);
        if (success) {
            drawable = BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_success);
        } else {
            drawable = BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_fail);
        }
        priority.setNotificationIcon(drawable).setMainTitleText(title).show();
    }

    public void showPickPointWithType() {
        RGMMOperableNotificationView repeatedOperableView = getRepeatedOperableView(106);
        if (repeatedOperableView != null) {
            SearchPoi poi = RGPickPointModel.getInstance().getAntiSearchPoi();
            repeatedOperableView.setSubTitleText(poi.mAddress).setMainTitleText(poi.mName);
            return;
        }
        showPickPoint();
    }

    public void showPickPoint() {
        LogUtil.m15791e(TAG, "showPickPoint");
        SearchPoi poi = RGPickPointModel.getInstance().getAntiSearchPoi();
        RGViewController.getInstance().newOperableNotification(106).setPriority(100).setAutoHideTime(-1).setSubTitleText(poi.mAddress).setConfirmText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_route_search_add_via)).setCancelText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_faster_route_btn_cancle)).setOnClick(new NotificationClickListener() {
            public void onConfirmBtnClick() {
                RGNotificationController.this.comfirmPickPoint();
            }

            public void onCancelBtnClick() {
                RGPickPointModel.getInstance().setPickPointShow(false);
            }

            public void onAutoHideWithoutClick() {
                RGPickPointModel.getInstance().setPickPointShow(false);
            }
        }).setDisplayListener(new NotificationDisplayListener() {
            public void onShowWithAnim() {
                RGViewController.getInstance().moveContrilBottomButton(true);
            }

            public void onShowWithOutAnim() {
                RGViewController.getInstance().moveContrilBottomButton(true);
            }

            public void onHideWithAnim() {
                RGPickPointModel.getInstance().setPickPointShow(false);
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                RGViewController.getInstance().moveContrilBottomButton(false);
            }

            public void onHideWithOutAnim() {
                RGPickPointModel.getInstance().setPickPointShow(false);
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                RGViewController.getInstance().moveContrilBottomButton(false);
            }
        }).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_notification_via_point)).setMainTitleText(poi.mName).show();
    }

    public void comfirmPickPoint() {
        RGPickPointModel.getInstance().setPickPointShow(false);
        BNRoutePlaner.getInstance().setGuideEndType(1);
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            RGRouteSearchModel.getInstance().setRouteSearchMode(false);
            BNPoiSearcher.getInstance().clearBkgCache();
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, false);
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_ROUTE_SEARCH_VIA, NaviStatConstants.NAVI_ROUTE_SEARCH_VIA);
        }
        RGSimpleGuideModel.getInstance();
        RGSimpleGuideModel.mCalcRouteType = 1;
        RGEngineControl.getInstance().addViaPtToCalcRoute(RGPickPointModel.getInstance().getPickPoint(), RGPickPointModel.getInstance().getAntiSearchPoi() != null ? RGPickPointModel.getInstance().getAntiSearchPoi().mName : "");
        if (BNavigator.getInstance().getmVoiceSearchCallBack() != null) {
            BNavigator.getInstance().getmVoiceSearchCallBack().comfirmSuccess(RGPickPointModel.getInstance().getAntiSearchPoi().mName);
        }
    }

    public void updatePickPoint() {
    }

    public void hidePickPoint() {
        hideOperableView(106);
    }

    public void showJamReport() {
        LogUtil.m15791e(TAG, "showJamReport: --> " + RGJamReportModel.getInstance().isViewCanShow);
        if (RGJamReportModel.getInstance().isViewCanShow) {
            RGViewController.getInstance().closeToolbox();
            RGViewController.getInstance().hideRouteSearchView();
            RGViewController.getInstance().hideRouteSortView();
            RGViewController.getInstance().hideMenuMoreView();
            RGViewController.getInstance().onUgcDestroy();
            RGJamReportModel.getInstance().getNotificationView().show();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u_6, null, null, null);
            RGJamReportModel.getInstance().setHasJamReportShown(true);
        }
    }

    public void showFirstVoiceGuide() {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>(getClass().getSimpleName(), null) {
            protected String execute() {
                LogUtil.m15791e(ModuleName.XDVoice, "showFirstVoiceGuide()");
                RGViewController.getInstance().newCommonNotification(113).setPriority(100).setAutoHideTime(10000).setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.nsdk_asr_normal)).setMainTitleText("呼叫'小度小度'开启语音控制").show();
                BNSettingManager.setFirstVoiceNotifyGuide(false);
                return null;
            }
        }, new BNWorkerConfig(100, 0), Config.BPLUS_DELAY_TIME);
    }
}
