package com.baidu.navisdk.ui.routeguide.mapmode;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonConstant;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.business.BusinessActivityViewManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.BNRCEventDetailsMenuView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGCurRoadNameView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMAssistGuideView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMBlueToothUSBGuideView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMControlPanelView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMDeviceStateView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMEnlargeRoadMapView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMHighwaySimpleBoardView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMHighwayView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMLaneLineView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMainAuxiliaryBridgeView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMenuMoreView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMessageFloatView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationDebugView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOffScreenView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOfflineToOnlineView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMParkPointView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMParkView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRCStyleUserGuideView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRPPreferView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRoadConditionFailView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteGuideFloatView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSearchView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSortView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMSatelliteView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMScaleLevelView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMSimpleGuideView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCFeedbackMenuView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUgcOfficialEventView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGUserRightView;
import com.baidu.navisdk.ui.routeguide.model.RGAvoidTrafficModel;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGMainAuxiliaryModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.hud.RGHUDControlView;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolBoxView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNImageTextDialog;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.ui.widget.BNQuitNaviDialog;
import com.baidu.navisdk.ui.widget.BNVolumeAdjustDialog;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BlueToothListener;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.baidu.nplatform.comapi.map.MapSwitchGLSurfaceView;
import com.baidu.platform.comapi.util.C4820d;
import java.util.ArrayList;

public class RGMapModeViewController {
    private static final boolean ENABLE_PRELOAD = true;
    public static final String KEY_IS_FIRST_GUIDE = "is_first";
    private static final int MSG_AUTO_HIDE_MENU_VIEW = 10702;
    private static final String TAG = "RouteGuide";
    private static final Object mLoadViewLock = new Object();
    private static volatile RGMapModeViewController sInstance = null;
    public boolean isShowingUgcBtnLayout = false;
    private Activity mActivity;
    private AudioUtils mAdudioUtils;
    private RGMMAssistGuideView mAssistGuideView = null;
    private BNCommonProgressDialog mAvoidTrafficDialog = null;
    private BNRCEventDetailsMenuView mBNRCEventDetailsMenuView = null;
    private BNMessageDialog mBTScoDlg = null;
    private LinearLayout mBlackSpacell = null;
    private RGMMBlueToothUSBGuideView mBlueToothUSBGuideView = null;
    private BNCommonProgressDialog mCommentWaitProgress = null;
    private RGMMCommonView mCommonView = null;
    private RGMMControlPanelView mControlPanelView = null;
    private int mCurOrientation = 2;
    private RGCurRoadNameView mCurRoadNameView = null;
    private RGMMDeviceStateView mDeviceStateView = null;
    private RelativeLayout mEnlargeLaneContainer = null;
    private RGMMLaneLineView mEnlargeLaneView = null;
    private RGMMEnlargeRoadMapView mEnlargeRoadMapView = null;
    private BNDialog mExitDialog;
    final BNWorkerNormalTask<String, String> mExitRouteSearchModeTask = new RGMapModeViewController$15(this, "ExitRouteSearchMode", null);
    private BNDialog mFirstItsOnDialog;
    private BNDialog mGPSSettingDialog;
    private boolean mHashNaviBeginIntoBackground = false;
    final BNWorkerNormalTask<String, String> mHideControlPanelTask = new RGMapModeViewController$14(this, "HideControlPanel", null);
    private View mHighwayAssistPanel = null;
    private RGMMHighwaySimpleBoardView mHighwaySimpleBoardView = null;
    private RGMMHighwayView mHighwayView = null;
    private boolean mIsFellowSwitchResident = false;
    private boolean mIsFellowTipsShow = false;
    private boolean mIsFuzzyMode;
    private boolean mIsHudShow = false;
    private boolean mIsInRouteSearchTimeout = false;
    public boolean mIsInterveneMaskingShow = false;
    public boolean mIsPickPointDripShow = true;
    private boolean mIsShowColladaView = false;
    private boolean mIsShowEnlargeRoadMap = false;
    private boolean mIsTimeOut = false;
    private RGMMLaneLineView mLaneView = null;
    private OnLayoutChangeListener mLayoutSizeChangeLis = new RGMapModeViewController$27(this);
    private RGMMMainAuxiliaryBridgeView mMABView = null;
    private int mMainAuxiliaryBridgeType = -1;
    private MapGLSurfaceView mMapView;
    private RGMMMenuMoreView mMenuMoreView = null;
    private MapSwitchGLSurfaceView mMiniMapView;
    private BNDialog mMockGPSSettingDialog;
    public Object mMutex = new Object();
    private RGMMNotificationDebugView mNotificationDebugView = null;
    private RGMMOffScreenView mOffScreenView = null;
    private RGMMOfflineToOnlineView mOfflineToOnlineView = null;
    private BNCommonProgressDialog mOtherRouteProgress = null;
    private ViewGroup mParentViewGroup = null;
    private RGMMParkPointView mParkPointView = null;
    private RGMMParkView mParkView = null;
    public int mPreloadActivityHashcode = -1;
    public int mPreloadOrientation = -99;
    private BNQuitNaviDialog mQuitNaviDialog;
    private RGMMRCStyleUserGuideView mRCStyleGuideView = null;
    private BNImageTextDialog mRGFloatOpenGuideDialog;
    private RGHUDControlView mRGHUDControlView = null;
    private RGMMUGCOperationActMenuView mRGMMUGCOperationActMenuView = null;
    private RGToolBoxView mRGToolboxView = null;
    private RGMMRPPreferView mRPPreferView = null;
    private BNDialog mRequestOverlyPermissionDialog;
    private RGMMRoadConditionFailView mRoadConditonUpdateFailView = null;
    private ViewGroup mRootViewGroup = null;
    private int mRootViewHeight = 0;
    private int mRootViewWidth = 0;
    private RGMapModeViewController$RouteGuideDialogManagerInterface mRouteGuideDialogManagerInterface;
    private RGMMRouteGuideFloatView mRouteGuideFloatView = null;
    private RGMMRouteSearchView mRouteSearchView = null;
    private RGMMRouteSortView mRouteSortView = null;
    private RGMMSatelliteView mSatelliteView = null;
    private RGMMScaleLevelView mScaleLevelView = null;
    private RGMMSimpleGuideView mSimpleGuideView = null;
    private OnRGSubViewListener mSubViewListener;
    private BNCommonProgressDialog mSwitchWaitProgress = null;
    private RGMMUGCFeedbackMenuView mUGCFbackMenuView = null;
    private BNCommonProgressDialog mUgcDetailViewShowProgress = null;
    private RGMMUgcOfficialEventView mUgcOfficialEventView = null;
    private RGUserRightView mUserRightView = null;
    private BNVolumeAdjustDialog mVolumeAdjustDialog = null;
    private RGMapModeViewController$VolumeChangeListener mVolumeChangeListener;
    private BNCommonProgressDialog mWaitCalcRouteProgress = null;
    private BNCommonProgressDialog mWaitProgress = null;
    public Handler mainUIHandler = new RGMapModeViewController$18(this, Looper.getMainLooper());

    public boolean ismIsFellowTipsShow() {
        return this.mIsFellowTipsShow;
    }

    public void setmIsFellowTipsShow(boolean mIsFellowTipsShow) {
        this.mIsFellowTipsShow = mIsFellowTipsShow;
    }

    public void hideFellowTips() {
    }

    public RGMapModeViewController$RouteGuideDialogManagerInterface getRouteGuideDialogManagerInterface() {
        return this.mRouteGuideDialogManagerInterface;
    }

    public void setRouteGuideDialogManagerInterface(RGMapModeViewController$RouteGuideDialogManagerInterface impl) {
        this.mRouteGuideDialogManagerInterface = impl;
    }

    public void setVolumeChangeListener(RGMapModeViewController$VolumeChangeListener volumelistener) {
        this.mVolumeChangeListener = volumelistener;
    }

    public RGMapModeViewController$VolumeChangeListener getVolumeChangeListener() {
        return this.mVolumeChangeListener;
    }

    public boolean getFellowStatus() {
        return false;
    }

    public void closeFellow() {
    }

    public void onProcessHomeKey() {
    }

    public void onBackground() {
        if (BNavigator.getInstance().isNaviBegin()) {
            this.mHashNaviBeginIntoBackground = true;
            UgcSoundsRecordDialog.stopRecordAndDismiss();
            JNIGuidanceControl.getInstance().setGroundMode(1);
            if (this.mMenuMoreView != null) {
                this.mMenuMoreView.onSwitchBackground(true);
            }
            if (this.mHighwayView != null) {
                this.mHighwayView.onSwitchBackground(true);
            }
            if (XDVoiceInstructManager.XD_ROUSED) {
                XDVoiceInstructManager.getInstance().closePanel();
            }
        }
    }

    public void onForeground() {
        if (BNavigator.getInstance().isNaviBegin() && !isShowQuitNaviDialog()) {
            if (!BNSettingManager.isRGFloatOpenGuideHasShow() && this.mHashNaviBeginIntoBackground) {
                if (BNSettingManager.getPrefFloatSwitch()) {
                    BNSettingManager.setRGFloatOpenGuideHasShow();
                } else {
                    BNSettingManager.setRGFloatOpenGuideHasShow();
                }
            }
            JNIGuidanceControl.getInstance().setGroundMode(2);
            if (this.mMenuMoreView != null) {
                this.mMenuMoreView.onSwitchBackground(false);
            }
            if (this.mHighwayView != null) {
                this.mHighwayView.onSwitchBackground(false);
            }
        }
        hideRGFloatView();
    }

    public static RGMapModeViewController getInstance() {
        if (sInstance == null) {
            synchronized (RGMapModeViewController.class) {
                if (sInstance == null) {
                    sInstance = new RGMapModeViewController();
                }
            }
        }
        return sInstance;
    }

    private RGMapModeViewController() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onOrientationChanged(Configuration newConfig) {
        this.mCurOrientation = 2;
        initViewByOrientation(this.mActivity, true);
        if (RGOffScreenModel.getInstance().isInCounting && RGOffScreenModel.getInstance().canEnterOffScreenShow() && !BNOffScreenManager.sIsInOffScreenMode) {
            BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "on orientation start");
            RGOffScreenModel.getInstance().isCurrentLocationActive = true;
            RGViewController.getInstance().requestShowExpendView(1, true);
        }
        BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), true);
        if (this.mVolumeAdjustDialog != null) {
            this.mVolumeAdjustDialog.onOrientationChange();
        }
    }

    public int getOrientation() {
        return RGCacheStatus.sOrientation;
    }

    public int getPreloadOrientation() {
        return RGCacheStatus.sOrientation;
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.updateStyle(dayStyle);
        }
        if (this.mRouteSortView != null) {
            this.mRouteSortView.updateStyle(dayStyle);
        }
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.updateStyle(dayStyle);
        }
        if (this.mBlueToothUSBGuideView != null) {
            this.mBlueToothUSBGuideView.updateStyle(dayStyle);
        }
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.onUpdateStyle(dayStyle);
        }
        if (this.mRouteSearchView != null) {
            this.mRouteSearchView.updateStyle(dayStyle);
        }
        if (this.mUGCFbackMenuView != null) {
            this.mUGCFbackMenuView.updateStyle(dayStyle);
        }
        if (this.mVolumeAdjustDialog != null) {
            this.mVolumeAdjustDialog.onUpdateStyle(dayStyle);
        }
        if (this.mMABView != null) {
            this.mMABView.updateStyle(dayStyle);
        }
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateStyle(dayStyle);
        }
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.updateStyle(dayStyle);
        }
        if (this.mCurRoadNameView != null) {
            this.mCurRoadNameView.updateStyle(dayStyle);
        }
        BusinessActivityViewManager.getInstance().onUpdateStyle(dayStyle, false);
    }

    public boolean getDayStyle() {
        return BNStyleManager.getDayStyle();
    }

    public void initView(Activity activity, ViewGroup viewGroup, MapGLSurfaceView mapView, OnRGSubViewListener listener) {
        this.mActivity = activity;
        this.mParentViewGroup = viewGroup;
        this.mSubViewListener = listener;
        this.mAdudioUtils = new AudioUtils(activity);
        this.mMapView = mapView;
        registRootViewSizeChange();
        initViewByOrientation(activity);
    }

    public View initView(Activity activity, MapGLSurfaceView mapView, OnRGSubViewListener listener) {
        this.mParentViewGroup = null;
        this.mSubViewListener = listener;
        this.mMapView = mapView;
        initViewByOrientation(activity);
        this.mActivity = activity;
        if (this.mSubViewListener != null) {
        }
        return this.mRootViewGroup;
    }

    public static void destory() {
        if (sInstance != null) {
            synchronized (RGMapModeViewController.class) {
                if (sInstance != null) {
                    sInstance.dispose();
                }
            }
        }
        sInstance = null;
    }

    public View getView() {
        return this.mRootViewGroup;
    }

    public boolean preloadViews(Activity activity) {
        return preloadViews(activity, false);
    }

    public boolean preloadViews(Activity activity, boolean isByOrientation) {
        LogUtil.e("RouteGuide", "preloadViews start");
        if (activity == null) {
            return false;
        }
        synchronized (mLoadViewLock) {
            if (this.mRootViewGroup != null && this.mPreloadActivityHashcode == activity.hashCode() && this.mPreloadOrientation == 2) {
                LogUtil.e("RouteGuide", "preloadViews has ok");
                return true;
            }
            try {
                if (loadViews(activity, isByOrientation)) {
                    this.mPreloadActivityHashcode = activity.hashCode();
                    return true;
                }
                this.mPreloadActivityHashcode = -1;
                return false;
            } catch (Throwable e) {
                LogUtil.e("RouteGuide", "preloadViews err:" + e.getMessage());
                this.mPreloadActivityHashcode = -1;
                return false;
            }
        }
    }

    private void updateSubViewListener() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.updateSubListener(this.mSubViewListener);
        }
        if (this.mDeviceStateView != null) {
            this.mDeviceStateView.updateSubListener(this.mSubViewListener);
        }
        if (this.mControlPanelView != null) {
            this.mControlPanelView.updateSubListener(this.mSubViewListener);
        }
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateSubListener(this.mSubViewListener);
        }
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.updateSubListener(this.mSubViewListener);
        }
        if (this.mParkPointView != null) {
            this.mParkPointView.updateSubListener(this.mSubViewListener);
        }
        if (this.mCommonView != null) {
            this.mCommonView.updateSubListener(this.mSubViewListener);
        }
        if (this.mOffScreenView != null) {
            this.mOffScreenView.updateSubListener(this.mSubViewListener);
        }
        if (this.mRoadConditonUpdateFailView != null) {
            this.mRoadConditonUpdateFailView.updateSubListener(this.mSubViewListener);
        }
        if (this.mUserRightView != null) {
            this.mUserRightView.updateSubListener(this.mSubViewListener);
        }
        if (this.mMABView != null) {
            this.mMABView.updateSubListener(this.mSubViewListener);
        }
        if (this.mLaneView != null) {
            this.mLaneView.updateSubListener(this.mSubViewListener);
        }
        if (this.mEnlargeLaneView != null) {
            this.mEnlargeLaneView.updateSubListener(this.mSubViewListener);
        }
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.updateSubListener(this.mSubViewListener);
            this.mRGToolboxView.updateUIForStartNav();
        }
    }

    private boolean loadViews(Activity activity, boolean isByOrientation) {
        if (activity == null) {
            return false;
        }
        if (this.mRootViewGroup != null) {
            this.mRootViewGroup.removeAllViews();
            this.mRootViewGroup = null;
        }
        if (!isByOrientation) {
            releaseSubViews(true);
        }
        if (2 == 2) {
            this.mRootViewGroup = (ViewGroup) JarUtils.inflate(activity, C4048R.layout.nsdk_layout_rg_mapmode_main_land, null);
            if (this.mRootViewGroup == null) {
                return false;
            }
            this.mPreloadOrientation = 2;
        } else {
            this.mRootViewGroup = (ViewGroup) JarUtils.inflate(activity, C4048R.layout.nsdk_layout_rg_mapmode_main, null);
            if (this.mRootViewGroup == null) {
                return false;
            }
            this.mPreloadOrientation = 1;
        }
        if (isByOrientation) {
            updateViewByOrientation(2, activity);
        } else {
            this.mSimpleGuideView = new RGMMSimpleGuideView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mDeviceStateView = new RGMMDeviceStateView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mControlPanelView = new RGMMControlPanelView(activity, this.mRootViewGroup, this.mSubViewListener);
            if (1 == RGViewController.getInstance().getOrientation()) {
                this.mHighwayAssistPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_assist_guide_panel);
                this.mEnlargeLaneContainer = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.enlarge_lane_container);
                this.mEnlargeLaneView = new RGMMLaneLineView(activity, this.mRootViewGroup, this.mSubViewListener, 100);
            } else {
                this.mHighwayAssistPanel = null;
                this.mEnlargeLaneContainer = null;
                this.mEnlargeLaneView = null;
            }
            this.mBlackSpacell = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.black_space_highway);
            this.mAssistGuideView = new RGMMAssistGuideView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mParkPointView = new RGMMParkPointView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mScaleLevelView = new RGMMScaleLevelView(activity, this.mRootViewGroup);
            this.mCommonView = new RGMMCommonView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mRoadConditonUpdateFailView = new RGMMRoadConditionFailView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mUserRightView = new RGUserRightView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mMABView = new RGMMMainAuxiliaryBridgeView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mLaneView = new RGMMLaneLineView(activity, this.mRootViewGroup, this.mSubViewListener, 101);
            this.mEnlargeRoadMapView = new RGMMEnlargeRoadMapView(activity, this.mRootViewGroup, this.mSubViewListener);
            this.mRGToolboxView = new RGToolBoxView(activity, this.mRootViewGroup, C4048R.id.bnav_rg_toolbox_panel_container);
            this.mRGToolboxView.showToolBox();
            this.mCurRoadNameView = new RGCurRoadNameView(activity, this.mRootViewGroup);
        }
        return true;
    }

    private void updateViewByOrientation(int orientation, Activity activity) {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mDeviceStateView != null) {
            this.mDeviceStateView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mControlPanelView != null) {
            this.mControlPanelView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mCurRoadNameView != null) {
            this.mCurRoadNameView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (1 == RGViewController.getInstance().getOrientation()) {
            this.mHighwayAssistPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_assist_guide_panel);
            this.mEnlargeLaneContainer = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.enlarge_lane_container);
            this.mEnlargeLaneView = new RGMMLaneLineView(activity, this.mRootViewGroup, this.mSubViewListener, 100);
        } else {
            this.mHighwayAssistPanel = null;
            this.mEnlargeLaneContainer = null;
            this.mEnlargeLaneView = null;
        }
        this.mBlackSpacell = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.black_space_highway);
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.orientationChanged(this.mRootViewGroup, orientation);
            adjustAssistShow(orientation);
        }
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mCommonView != null) {
            this.mCommonView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mOffScreenView != null) {
            this.mOffScreenView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mRoadConditonUpdateFailView != null) {
            this.mRoadConditonUpdateFailView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mUserRightView != null) {
            this.mUserRightView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mMABView != null) {
            this.mMABView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mLaneView != null) {
            this.mLaneView.orientationChanged(this.mRootViewGroup, orientation, 101);
        }
        if (this.mEnlargeLaneView != null) {
            this.mEnlargeLaneView.orientationChanged(this.mRootViewGroup, orientation, 100);
        }
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.dispose();
            this.mEnlargeRoadMapView = new RGMMEnlargeRoadMapView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.onOrientationChange(this.mRootViewGroup, orientation);
        }
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mRouteSortView != null) {
            this.mRouteSortView.dispose();
            this.mRouteSortView = null;
        }
        if (this.mRouteSearchView != null) {
            this.mRouteSearchView.dispose();
            this.mRouteSearchView = null;
        }
        if (this.mHighwayView != null) {
            this.mHighwayView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mBNRCEventDetailsMenuView != null) {
            this.mBNRCEventDetailsMenuView.dispose();
            this.mBNRCEventDetailsMenuView = null;
        }
        if (this.mRCStyleGuideView != null) {
            this.mRCStyleGuideView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mHighwaySimpleBoardView != null) {
            this.mHighwaySimpleBoardView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (RGMMUGCOperationActMenuView.isViewShow && this.mRGMMUGCOperationActMenuView != null) {
            this.mRGMMUGCOperationActMenuView.orientationChanged(this.mRootViewGroup, orientation);
        }
        if (this.mBlueToothUSBGuideView != null) {
            this.mBlueToothUSBGuideView.dispose();
            this.mBlueToothUSBGuideView = null;
        }
    }

    public void showUgcOfficialEventView(boolean show) {
        if (show && RGSimpleGuideModel.mIsUgcOfficialEvent) {
            if (this.mUgcOfficialEventView == null) {
                this.mUgcOfficialEventView = new RGMMUgcOfficialEventView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
                this.mUgcOfficialEventView.orientationChanged(this.mRootViewGroup, getOrientation());
            }
            if (this.mUgcOfficialEventView != null) {
                this.mUgcOfficialEventView.show();
            }
        } else if (this.mUgcOfficialEventView != null) {
            this.mUgcOfficialEventView.hide();
            this.mUgcOfficialEventView = null;
        }
    }

    private void initViewByOrientation(Activity activity) {
        initViewByOrientation(activity, false);
    }

    private void initViewByOrientation(Activity activity, boolean isByOrientation) {
        if (isByOrientation && this.mMenuMoreView != null) {
            this.mMenuMoreView.setInputMethodShowFlag();
        }
        try {
            if (!(this.mParentViewGroup == null || this.mRootViewGroup == null)) {
                this.mParentViewGroup.removeView(this.mRootViewGroup);
            }
        } catch (Exception e) {
        }
        if (preloadViews(activity, isByOrientation)) {
            updateSubViewListener();
        } else {
            loadViews(activity, isByOrientation);
        }
        if (activity != null) {
            BNSysLocationManager.getInstance().showDebugUI();
            if (this.mMiniMapView == null) {
                this.mMiniMapView = new MapSwitchGLSurfaceView(activity);
            }
            if (this.mAssistGuideView != null) {
                this.mAssistGuideView.initMiniMap(this.mMiniMapView);
            }
            if (this.mRootViewGroup != null) {
                setMapDrawScreenRect();
                if (this.mHighwayAssistPanel != null && 1 == RGViewController.getInstance().getOrientation()) {
                    int i;
                    View view = this.mHighwayAssistPanel;
                    if (RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    view.setVisibility(i);
                }
                if (!(this.mParentViewGroup == null || this.mRootViewGroup == null)) {
                    try {
                        this.mParentViewGroup.addView(this.mRootViewGroup, new LayoutParams(-1, -1));
                    } catch (Exception e2) {
                    }
                    this.mParentViewGroup.requestLayout();
                }
                if (BNavConfig.pRGLocateMode == 2 && this.mRGToolboxView != null) {
                    this.mRGToolboxView.hideToolBox();
                }
                if (BNavigator.getInstance().getHandler() != null && BNavigator.getInstance().hasCalcRouteOk()) {
                    BNavigator.getInstance().getHandler().sendMessageDelayed(BNavigator.getInstance().getHandler().obtainMessage(BNavigator.MSG_TYPE_INIT, 1, 0), 500);
                }
            }
        }
    }

    public void setMapDrawScreenRect() {
        if (2 == RGCacheStatus.sOrientation) {
            BNMapController.getInstance().setMapDrawScreenRect(new Rect((ScreenUtil.getInstance().getHeightPixels() / 4) - 10, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels()));
            return;
        }
        int top;
        if (isHighwayMiniPanelShowing() || isFuzzyMode()) {
            top = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_guide_mini_height) - 10;
        } else {
            top = JarUtils.getResources().getDimensionPixelOffset(C4048R.dimen.nsdk_rg_top_panel_height) - 10;
        }
        BNMapController.getInstance().setMapDrawScreenRect(new Rect(0, top, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels()));
    }

    private void adjustAssistShow(int orientation) {
        if (orientation == 2 && NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState()) && RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
            this.mAssistGuideView.setAssistContainerVisible();
        }
    }

    public void delayRefreshViewAfterInit() {
        if (!(this.mDeviceStateView == null || isShowEnlargeRoadMap())) {
            showDeviceStateView();
        }
        showControlPanel();
        updateScaleLevel();
        updateHUDLayout();
    }

    public boolean isCommomViewShow() {
        if (this.mCommonView != null) {
            return this.mCommonView.isCommonViewShow();
        }
        return false;
    }

    public void releasePreloadSubViews() {
        this.mPreloadActivityHashcode = -1;
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.dispose();
            this.mSimpleGuideView = null;
        }
        if (this.mDeviceStateView != null) {
            this.mDeviceStateView.dispose();
            this.mDeviceStateView = null;
        }
        if (this.mControlPanelView != null) {
            this.mControlPanelView.dispose();
            this.mControlPanelView = null;
        }
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.dispose();
            this.mAssistGuideView = null;
        }
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.dispose();
            this.mEnlargeRoadMapView = null;
        }
        if (this.mParkPointView != null) {
            this.mParkPointView.dispose();
            this.mParkPointView = null;
        }
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView = null;
        }
        if (this.mCommonView != null) {
            this.mCommonView.dispose();
            this.mCommonView = null;
        }
        if (this.mOffScreenView != null) {
            this.mOffScreenView.dispose();
            this.mOffScreenView = null;
        }
        if (this.mRoadConditonUpdateFailView != null) {
            this.mRoadConditonUpdateFailView.dispose();
            this.mRoadConditonUpdateFailView = null;
        }
        if (this.mUserRightView != null) {
            this.mUserRightView.dispose();
            this.mUserRightView = null;
        }
        if (this.mMABView != null) {
            this.mMABView.dispose();
        }
        if (this.mLaneView != null) {
            this.mLaneView.dispose();
            this.mLaneView = null;
        }
        if (this.mEnlargeLaneView != null) {
            this.mEnlargeLaneView.dispose();
            this.mEnlargeLaneView = null;
        }
        if (this.mHighwayAssistPanel != null) {
            this.mHighwayAssistPanel = null;
        }
        if (this.mEnlargeLaneContainer != null) {
            this.mHighwayAssistPanel = null;
        }
    }

    private void releaseSubViews(boolean force) {
        if (force) {
            releasePreloadSubViews();
        }
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.releaseMiniMap();
        }
        if (this.mHighwayView != null) {
            this.mHighwayView.dispose();
            this.mHighwayView = null;
        }
        if (this.mRouteSortView != null) {
            this.mRouteSortView.dispose();
            this.mRouteSortView = null;
        }
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.dispose();
            this.mMenuMoreView = null;
        }
        if (this.mBlueToothUSBGuideView != null) {
            this.mBlueToothUSBGuideView.dispose();
            this.mBlueToothUSBGuideView = null;
        }
        if (this.mParkView != null) {
            this.mParkView.dispose();
            this.mParkView = null;
        }
        if (this.mRouteSearchView != null) {
            this.mRouteSearchView.dispose();
            this.mRouteSearchView = null;
        }
        if (this.mUGCFbackMenuView != null) {
            this.mUGCFbackMenuView.dispose();
            this.mUGCFbackMenuView = null;
        }
        if (this.mBNRCEventDetailsMenuView != null) {
            this.mBNRCEventDetailsMenuView.dispose();
            this.mBNRCEventDetailsMenuView = null;
        }
        if (this.mHighwaySimpleBoardView != null) {
            this.mHighwaySimpleBoardView.dispose();
            this.mHighwaySimpleBoardView = null;
        }
        RGNotificationController.getInstance().dispose();
        if (this.mNotificationDebugView != null) {
            this.mNotificationDebugView.dispose();
            this.mNotificationDebugView = null;
        }
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.onDestroy();
            this.mRGToolboxView = null;
        }
    }

    public void cleanViewTimeHandler() {
        if (this.mOffScreenView != null) {
            this.mOffScreenView.cleanHandler();
        }
    }

    public void releaseAllDialogs() {
        try {
            hideCommentRouteView();
            dismissFirstItsDialog();
            this.mFirstItsOnDialog = null;
            dismissGPSSettingDialog();
            this.mGPSSettingDialog = null;
            dismissMockGPSSettingDialog();
            this.mMockGPSSettingDialog = null;
            dismissLoading();
            this.mWaitProgress = null;
            this.mOtherRouteProgress = null;
            dismissUgcDetailViewShowProgressDialog();
            this.mUgcDetailViewShowProgress = null;
            if (this.mExitDialog != null && this.mExitDialog.isShowing()) {
                this.mExitDialog.dismiss();
            }
            this.mExitDialog = null;
            dismissQuitNaviDialog();
            this.mQuitNaviDialog = null;
            dismissAvoidTrafficLoading();
            this.mAvoidTrafficDialog = null;
            dismissVolumeAdjust();
            this.mVolumeAdjustDialog = null;
            hideRGFloatOpenGuidDialog();
            this.mRGFloatOpenGuideDialog = null;
            hideOpenOverlyPermissonDialog();
            this.mRequestOverlyPermissionDialog = null;
            dismissWaitCalProgressDialog();
            this.mWaitCalcRouteProgress = null;
        } catch (Exception e) {
        }
    }

    public void showUgcDetailViewShowProgressDialog() {
        dismissUgcDetailViewShowProgressDialog();
        try {
            if (this.mUgcDetailViewShowProgress == null && this.mActivity != null) {
                this.mUgcDetailViewShowProgress = new BNCommonProgressDialog(this.mActivity);
                this.mUgcDetailViewShowProgress.setMessage("加载中...");
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mUgcDetailViewShowProgress != null) {
                this.mUgcDetailViewShowProgress.setOnCancelListener(new RGMapModeViewController$1(this));
                this.mUgcDetailViewShowProgress.show();
            }
        } catch (Exception e) {
        }
    }

    public boolean dismissUgcDetailViewShowProgressDialog() {
        try {
            if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mUgcDetailViewShowProgress == null || !this.mUgcDetailViewShowProgress.isShowing())) {
                this.mUgcDetailViewShowProgress.dismiss();
            }
        } catch (Exception e) {
        }
        this.mUgcDetailViewShowProgress = null;
        return true;
    }

    public void initFirstRGInfo() {
        LogUtil.e("RouteGuide", "RGSimpleGuideModel===  initFirstRGInfo --> bundle = " + RGSimpleGuideModel.getInstance().getNextGuideInfo().toString());
        Bundle totalInfoBundle = RGSimpleGuideModel.getInstance().getTotalInfo();
        int distance = RGEngineControl.getInstance().getTotalDistance();
        RGHUDDataModel.totalDistance = distance;
        int time = RGEngineControl.getInstance().getTotalTime();
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalDist)) {
            distance = totalInfoBundle.getInt(SimpleGuideInfo.TotalDist);
        }
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalTime)) {
            time = totalInfoBundle.getInt(SimpleGuideInfo.TotalTime);
        }
        if (distance > 0) {
            RGSimpleGuideModel.getInstance().updateTotalRemainDistAndTime(distance, time);
            RGViewController.getInstance().updateTotalRemainInfo();
        }
        RoutePlanModel.sNavNodeList = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getRouteInput();
        Bundle data = (Bundle) RGSimpleGuideModel.getInstance().getNextGuideInfo().clone();
        if ((data.getInt("resid") > 0 && distance > 0) || RGSimpleGuideModel.getInstance().isFirstGuideFuzzy()) {
            data.putBoolean(KEY_IS_FIRST_GUIDE, true);
            LogUtil.e("RouteGuide", "initFirstRGInfo --> data = " + data.toString());
            RGViewController.getInstance().updateSimpleGuideInfo(data);
            RGViewController.getInstance().updateSimpleGuideInfo(totalInfoBundle);
            PerformStatisticsController.peByType(0, "sdk_routeguide_refresh_firstinfo", System.currentTimeMillis());
        }
    }

    public void hideAllViews() {
        hideAllViews(0);
    }

    public void hideAllViews(int type) {
        LogUtil.e("RouteGuide", "hideAllViews");
        hideControlManualOperatePanel();
        hideControlPanel();
        if (type == 0) {
            hideAssistInfo();
        } else {
            hideAssistViewOnly();
        }
        hideUserRightView();
        showAssistCameraView(false);
        hideEnlargeRoadMapWithoutAnimation();
        hideHighwayView();
        hideMenuMoreView();
        hideBlueToothUSBGuide();
        hideParkPointView();
        hideRouteSearchView();
        showColladaView(false);
        showCommonView(false);
        hideRouteSortView();
    }

    public void hideAllDialogs() {
        dismissFirstItsDialog();
        dismissGPSSettingDialog();
        dismissMockGPSSettingDialog();
        dismissLoading();
        dismissWaitCalProgressDialog();
        try {
            if (this.mExitDialog != null && this.mExitDialog.isShowing()) {
                this.mExitDialog.dismiss();
            }
        } catch (Exception e) {
            this.mExitDialog = null;
        }
        dismissAvoidTrafficLoading();
        dismissQuitNaviDialog();
    }

    public void showNewerGuideDialog() {
    }

    public void quitNavWhenTimeOut() {
    }

    public void quitNavWhenConfirm() {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onQuitNaviGuide(false, false);
        }
    }

    public void showExitDialogWhenArrival() {
    }

    public void showQuitNaviDialog(boolean showCountDown) {
        if (this.mRouteGuideDialogManagerInterface != null) {
            this.mRouteGuideDialogManagerInterface.showQuitDialog(showCountDown);
        } else if (this.mActivity != null) {
            try {
                this.mQuitNaviDialog = new BNQuitNaviDialog(this.mActivity);
                this.mQuitNaviDialog.setOnBtnClickListener(new RGMapModeViewController$2(this));
                if (!(this.mQuitNaviDialog.isShowing() || this.mActivity == null || this.mActivity.isFinishing())) {
                    this.mQuitNaviDialog.show();
                }
                this.mQuitNaviDialog.setCanceledOnTouchOutside(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isShowQuitNaviDialog() {
        if (this.mQuitNaviDialog == null || !this.mQuitNaviDialog.isShowing()) {
            return false;
        }
        return true;
    }

    public void showReCalRouteQuitDialog() {
        if (this.mActivity == null) {
            LogUtil.e("RouteGuide", "showReCalRouteQuitDialog mActivity == null");
            BNRoutePlaner.getInstance().cancleCalcRouteRequest();
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
            return;
        }
        try {
            String string;
            BNDialog titleText = new BNDialog(this.mActivity).enableBackKey(true).setTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip));
            if (BNavConfig.pRGLocateMode == 2) {
                string = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_gps_demo_exit);
            } else {
                string = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_yaw_exit);
            }
            this.mExitDialog = titleText.setContentMessage(string).setSecondBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_exit_check)).setSecondBtnTextColorHighLight().setOnSecondBtnClickListener(new RGMapModeViewController$4(this)).setFirstBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).setOnFirstBtnClickListener(new RGMapModeViewController$3(this));
            this.mExitDialog.setCancelable(false);
            if (!this.mExitDialog.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mExitDialog.show();
            }
        } catch (Exception e) {
        }
    }

    public void showFirstItsDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            try {
                this.mFirstItsOnDialog = new BNDialog(this.mActivity).enableBackKey(true).setTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_first_tip)).setFirstBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_alert_iknown)).setOnFirstBtnClickListener(new RGMapModeViewController$5(this)).setSecondBtnEnabled(false);
                if (!this.mFirstItsOnDialog.isShowing()) {
                    this.mFirstItsOnDialog.show();
                }
            } catch (Exception e) {
                this.mFirstItsOnDialog = null;
            }
        }
    }

    public void showRGFloatOpenGuidDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            try {
                this.mRGFloatOpenGuideDialog = new BNImageTextDialog(this.mActivity).enableBackKey(true).setTopImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_float_guid_dialog)).setBottomImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_image_text_btn_bottom_bg)).setTitleText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_float_open_guide_title)).setContentMessage(BNStyleManager.getString(C4048R.string.nsdk_string_rg_float_open_guide_message)).setFirstBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_float_open_guide_text_no_use)).setSecondBtnText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_float_open_guide_text_use)).setSecondBtnChecked().setOnSecondBtnClickListener(new RGMapModeViewController$7(this)).setOnFirstBtnClickListener(new RGMapModeViewController$6(this));
                this.mRGFloatOpenGuideDialog.show();
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_7, "1", null, null);
            } catch (Exception e) {
            }
        }
    }

    public void hideRGFloatOpenGuidDialog() {
        if (this.mRGFloatOpenGuideDialog != null && this.mActivity != null) {
            try {
                if (!this.mActivity.isFinishing() && this.mRGFloatOpenGuideDialog.isShowing()) {
                    this.mRGFloatOpenGuideDialog.dismiss();
                }
            } catch (Exception e) {
            }
            this.mRGFloatOpenGuideDialog = null;
        }
    }

    public void dismissFirstItsDialog() {
        try {
            if (this.mFirstItsOnDialog != null && this.mActivity != null && !this.mActivity.isFinishing()) {
                if (this.mFirstItsOnDialog.isShowing()) {
                    this.mFirstItsOnDialog.dismiss();
                }
                this.mFirstItsOnDialog = null;
            }
        } catch (Exception e) {
            this.mFirstItsOnDialog = null;
        }
    }

    public void showOtherRouteProgressDialog() {
        dismissOtherRouteProgressDialog();
        try {
            if (this.mOtherRouteProgress == null && this.mActivity != null) {
                this.mOtherRouteProgress = new BNCommonProgressDialog(this.mActivity);
                this.mOtherRouteProgress.setMessage(BNStyleManager.getString(C4048R.string.nsdk_string_rg_switch_other_route));
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mOtherRouteProgress != null) {
                this.mOtherRouteProgress.setOnCancelListener(new RGMapModeViewController$8(this));
                this.mOtherRouteProgress.show();
            }
        } catch (Exception e) {
        }
    }

    public boolean dismissOtherRouteProgressDialog() {
        try {
            if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mOtherRouteProgress == null || !this.mOtherRouteProgress.isShowing())) {
                this.mOtherRouteProgress.dismiss();
            }
        } catch (Exception e) {
        }
        this.mOtherRouteProgress = null;
        return true;
    }

    private String getResString(int strResId) {
        return JarUtils.getResources().getString(strResId);
    }

    public void showCarGPSSettingDialog() {
        try {
            if (this.mGPSSettingDialog == null) {
                String title = getResString(C4048R.string.nsdk_string_rg_nav_title_tip);
                String msg = getResString(C4048R.string.nsdk_string_rg_open_car_gps);
                this.mGPSSettingDialog = new BNDialog(this.mActivity).setTitleText(title).setContentMessage(msg).setFirstBtnText(getResString(C4048R.string.nsdk_string_common_alert_confirm)).setOnFirstBtnClickListener(new RGMapModeViewController$9(this));
            }
            if (this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mGPSSettingDialog.show();
            }
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void showGPSSettingDialog() {
        try {
            if (!(this.mGPSSettingDialog != null || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mGPSSettingDialog = new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_gps_not_open_and_set)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_alert_setting)).setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new RGMapModeViewController$11(this)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).setOnSecondBtnClickListener(new RGMapModeViewController$10(this));
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mGPSSettingDialog.isShowing()) {
                this.mGPSSettingDialog.show();
            }
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void dismissGPSSettingDialog() {
        try {
            if (this.mGPSSettingDialog == null || this.mActivity == null || this.mActivity.isFinishing()) {
                this.mGPSSettingDialog = null;
                return;
            }
            if (this.mGPSSettingDialog.isShowing()) {
                this.mGPSSettingDialog.dismiss();
            }
            this.mGPSSettingDialog = null;
        } catch (Exception e) {
            this.mGPSSettingDialog = null;
        }
    }

    public void showMockGPSSettingDialog() {
        try {
            if (!(this.mMockGPSSettingDialog != null || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mMockGPSSettingDialog = new BNDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_mock_gps_close_and_set)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_alert_setting)).setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new RGMapModeViewController$13(this)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_dialog_cancel)).setOnSecondBtnClickListener(new RGMapModeViewController$12(this));
            }
            if (this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mMockGPSSettingDialog.show();
            }
        } catch (Exception e) {
            this.mMockGPSSettingDialog = null;
        }
    }

    public void dismissMockGPSSettingDialog() {
        try {
            if (this.mMockGPSSettingDialog == null || this.mActivity == null || this.mActivity.isFinishing()) {
                this.mMockGPSSettingDialog = null;
                return;
            }
            if (this.mMockGPSSettingDialog.isShowing()) {
                this.mMockGPSSettingDialog.dismiss();
            }
            this.mMockGPSSettingDialog = null;
        } catch (Exception e) {
            this.mMockGPSSettingDialog = null;
        }
    }

    public void showGPSFixStateTip(int gpsFixState) {
        if (this.mActivity != null) {
            if (gpsFixState == 2) {
                TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_gps_fixing_short));
            } else if (gpsFixState == 1) {
                TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_gps_fixed));
            }
        }
    }

    public void showControlPanel() {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.show();
        }
    }

    public void hideControlPanel() {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.hide();
        }
    }

    public void moveContrilBottomButton(boolean isMoveUp) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.moveUpBottomButton(isMoveUp);
        }
    }

    public void showControlManualOperatePanel(boolean autoHide) {
        LogUtil.e("RouteGuide", "peng showControlManualOperatePanel 1");
        if (this.mControlPanelView != null) {
            this.mControlPanelView.showManualOperateArea(true);
        }
        LogUtil.e("RouteGuide", "peng showControlManualOperatePanel 2");
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.show();
        }
        cancleAutoHideControlPanel();
        hideAssistInfo();
        hideUserRightView();
        hideHighWayServiceView();
        if (autoHide) {
            LogUtil.e("RouteGuide", "RouteGuideFSM.getInstance().getTopState()=" + RouteGuideFSM.getInstance().getTopState());
            if (RouteGuideFSM.getInstance().getTopState() == null) {
                return;
            }
            if (FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getTopState()) || "Highway".equals(RouteGuideFSM.getInstance().getTopState()) || FsmState.Park.equals(RouteGuideFSM.getInstance().getTopState()) || FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState()) || FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState()) || FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getTopState())) {
                autoHideControlPanelView(10000);
            }
        }
    }

    public void hideControlManualOperatePanel() {
        cancleAutoHideControlPanel();
        if (this.mControlPanelView != null) {
            this.mControlPanelView.showManualOperateArea(false);
        }
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.update();
        }
    }

    public void updateControlPanelView() {
        updateZoomViewState();
        updateScaleLevel();
    }

    public void autoHideControlPanelView(int timeout) {
        LogUtil.e("RouteGuide", "autoHideControlPanelView :" + timeout);
        if (RouteGuideFSM.getInstance().getCurrentEvent() == null || !RouteGuideFSM.getInstance().getCurrentEvent().equals(FsmEvent.MSG_YAWING_START)) {
            BNWorkerCenter.getInstance().cancelTask(this.mHideControlPanelTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mHideControlPanelTask, new BNWorkerConfig(2, 0), (long) timeout);
        }
    }

    public void cancleAutoHideControlPanel() {
        LogUtil.e("RouteGuide", "cancleAutoHideControlPanel :");
        BNWorkerCenter.getInstance().cancelTask(this.mHideControlPanelTask, false);
        if (!RGRouteSearchModel.getInstance().isRouteSearchMode() || this.mIsInRouteSearchTimeout) {
            cancelAutoExitRouteSearchMode();
        }
    }

    private void startAutoExitRouteSearchMode(int timeout) {
        BNWorkerCenter.getInstance().cancelTask(this.mExitRouteSearchModeTask, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mExitRouteSearchModeTask, new BNWorkerConfig(2, 0), (long) timeout);
    }

    private void cancelAutoExitRouteSearchMode() {
        BNWorkerCenter.getInstance().cancelTask(this.mExitRouteSearchModeTask, false);
        this.mIsInRouteSearchTimeout = false;
    }

    public boolean isMenuMoreVisible() {
        if (this.mMenuMoreView != null) {
            return this.mMenuMoreView.isVisibility();
        }
        return false;
    }

    public void hideMenuMoreView() {
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.hide();
            RGControlPanelModel.mIsMenuMoreVisible = false;
        }
    }

    public boolean menuMoreViewCloseAble() {
        if (this.mMenuMoreView != null) {
            return this.mMenuMoreView.menuMoreViewCloseAble();
        }
        return true;
    }

    public int getFellowLineVisibility() {
        if (this.mLaneView != null) {
            return this.mLaneView.getVisibility();
        }
        return 0;
    }

    public boolean checkMenuMoreViewPlateChanged() {
        if (this.mMenuMoreView != null) {
            return this.mMenuMoreView.checkMenuMoreViewPlateChanged();
        }
        return false;
    }

    public boolean isUGCFBackMenuVisible() {
        if (this.mRGMMUGCOperationActMenuView != null) {
            return this.mRGMMUGCOperationActMenuView.isVisibility();
        }
        return false;
    }

    public void showUGCFBackMenu() {
        if (this.mRGMMUGCOperationActMenuView == null) {
            this.mRGMMUGCOperationActMenuView = new RGMMUGCOperationActMenuView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mRGMMUGCOperationActMenuView != null) {
            this.mRGMMUGCOperationActMenuView.show();
        }
    }

    public void onUgcActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mRGMMUGCOperationActMenuView != null) {
            this.mRGMMUGCOperationActMenuView.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onUgcBackPress() {
        if (this.mRGMMUGCOperationActMenuView != null) {
            this.mRGMMUGCOperationActMenuView.onBackPress();
        }
    }

    public void onUgcDestroy() {
        if (this.mRGMMUGCOperationActMenuView != null) {
            this.mRGMMUGCOperationActMenuView.onDestroy();
        }
        this.mRGMMUGCOperationActMenuView = null;
    }

    public boolean isBNRCEventDetailsMenuVisible() {
        if (this.mBNRCEventDetailsMenuView != null) {
            return this.mBNRCEventDetailsMenuView.isVisibility();
        }
        return false;
    }

    public void showBNRCEventDetailsMenu(String mUid) {
        if (this.mBNRCEventDetailsMenuView == null) {
            this.mBNRCEventDetailsMenuView = new BNRCEventDetailsMenuView(this.mActivity, this.mRootViewGroup, this.mSubViewListener, mUid);
        }
        if (this.mBNRCEventDetailsMenuView != null) {
            this.mBNRCEventDetailsMenuView.show();
        }
    }

    public void onBNRCEventBackPress() {
        if (this.mBNRCEventDetailsMenuView != null) {
            this.mBNRCEventDetailsMenuView.onBackPress();
        }
    }

    public void onBNRCEventDestroy() {
        if (this.mBNRCEventDetailsMenuView != null) {
            this.mBNRCEventDetailsMenuView.onDestroy();
        }
        this.mBNRCEventDetailsMenuView = null;
    }

    public void onBNRCEventClear() {
        this.mBNRCEventDetailsMenuView = null;
    }

    public void updateMenuMoreBlueToothView(boolean isOpen) {
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.updateBlueToothView(isOpen);
        }
    }

    public void initHUDView(boolean isMirror) {
        if (this.mRGHUDControlView == null) {
            this.mRGHUDControlView = new RGHUDControlView(this.mActivity, null, isMirror);
            if (RGHUDDataModel.getInstance().isYaw()) {
                showHudSuitableView();
            } else if (isMirror) {
                this.mRGHUDControlView.updateLatestData();
            } else {
                RGHUDDataModel.setHighWayModel(false);
                RGViewController.getInstance().updateHudInfo(RGHUDDataModel.getInstance().simpleGuideToHUD(RGSimpleGuideModel.getInstance().getNextGuideInfo()));
            }
        }
    }

    public void showHUDDialog(boolean isMirror) {
        if (!(this.mRGHUDControlView == null || this.mActivity == null || this.mActivity.isFinishing())) {
            this.mRGHUDControlView.setMirrorFlagBeforeShow(isMirror);
            this.mRGHUDControlView.show();
        }
        this.mIsHudShow = true;
    }

    public void dismissHUDDialog() {
        if (!(this.mRGHUDControlView == null || this.mActivity == null || this.mActivity.isFinishing())) {
            this.mRGHUDControlView.dismiss();
        }
        this.mRGHUDControlView = null;
        this.mIsHudShow = false;
    }

    public void hideHUDDialog() {
        if (!(this.mRGHUDControlView == null || this.mActivity == null || this.mActivity.isFinishing())) {
            this.mRGHUDControlView.hide();
        }
        this.mRGHUDControlView = null;
        this.mIsHudShow = false;
    }

    public void hudSwitchToSimpleGuideView() {
        RGHUDDataModel.setHighWayModel(false);
        if (this.mRGHUDControlView != null && this.mActivity != null && !this.mActivity.isFinishing()) {
            this.mRGHUDControlView.updateData(RGHUDDataModel.getInstance().simpleGuideToHUD(RGSimpleGuideModel.getInstance().updateNextGuideInfo()));
            this.mRGHUDControlView.showSuitableView();
        }
    }

    public void updateHUDLayout() {
        if (this.mIsHudShow && this.mRGHUDControlView != null) {
            this.mRGHUDControlView.onOrientationChanged();
        }
    }

    public boolean getHudShowStatus() {
        return this.mIsHudShow;
    }

    public void showHudSuitableView() {
        if (this.mRGHUDControlView != null) {
            this.mRGHUDControlView.showSuitableView();
        }
    }

    public void updateHudInfo(Bundle b) {
        if (this.mRGHUDControlView != null) {
            this.mRGHUDControlView.updateData(b);
        }
    }

    public void updateHudAssistInfo() {
        if (this.mRGHUDControlView != null) {
            this.mRGHUDControlView.updateCurrentCarSpeed();
        }
    }

    public void showHighwayView() {
        if (this.mHighwayView == null) {
            this.mHighwayView = new RGMMHighwayView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mHighwayView != null) {
            this.mHighwayView.show();
        }
    }

    public void hideHighwayView() {
        if (this.mHighwayView != null) {
            this.mHighwayView.hide();
        }
    }

    public void updateHighwayView(Bundle data) {
        if (this.mHighwayView != null) {
            this.mHighwayView.updateData(null);
        }
    }

    public boolean isHighwayViewShowing() {
        if (this.mHighwayView != null) {
            return this.mHighwayView.isVisibility();
        }
        return false;
    }

    public boolean isHighwayMiniPanelShowing() {
        if (this.mHighwayView != null) {
            return this.mHighwayView.ismMiniPanelShowing();
        }
        return false;
    }

    public void resetHighwayPanel() {
        if (this.mHighwayView != null) {
            this.mHighwayView.resetHighwayPanel();
        }
    }

    public void hideHighWayServiceView() {
        if (this.mHighwaySimpleBoardView != null) {
            LogUtil.e("RouteGuide", "HighWayServiceView hide");
            this.mHighwaySimpleBoardView.hide();
        }
    }

    public void showHighWayServiceView() {
        if (!RGRouteRecommendModel.getInstance().isViewCanShow) {
            if (NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState())) {
                LogUtil.e("RouteGuide", "HighWayServiceView is operate state");
            } else if (isShowEnlargeRoadMap()) {
                LogUtil.e("RouteGuide", "HighWayServiceView is showing enlarge road map");
            } else {
                if (this.mHighwaySimpleBoardView == null) {
                    this.mHighwaySimpleBoardView = new RGMMHighwaySimpleBoardView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
                }
                if (this.mHighwaySimpleBoardView != null && !this.mHighwaySimpleBoardView.isVisibility() && RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
                    LogUtil.e("RouteGuide", "HighWayServiceView show");
                    this.mHighwaySimpleBoardView.show();
                }
            }
        }
    }

    public void updateHighWayServiceView() {
        if (this.mHighwaySimpleBoardView != null) {
            this.mHighwaySimpleBoardView.updateServiceView();
        }
    }

    public void updateHighWayServiceViewOritentation() {
        if (this.mHighwaySimpleBoardView != null) {
            this.mHighwaySimpleBoardView.orientationChanged(this.mRootViewGroup, getOrientation());
        }
    }

    public void showCommentLoading(String strTip) {
        try {
            if (!(this.mCommentWaitProgress != null || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mCommentWaitProgress = new BNCommonProgressDialog(this.mActivity);
            }
            if (this.mCommentWaitProgress != null) {
                this.mCommentWaitProgress.setMessage(strTip).setCancelable(true);
                this.mCommentWaitProgress.setYawingStyleGrivity(false);
            }
            if (!this.mCommentWaitProgress.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mCommentWaitProgress.show();
            }
        } catch (Exception e) {
        }
    }

    public void dismissCommentLoading(int isUploadSuc) {
        try {
            if (this.mCommentWaitProgress != null && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mCommentWaitProgress.dismiss();
            }
        } catch (Exception e) {
        }
    }

    public void showSwitchProgressDialog() {
        dismissSwitchProgressDialog();
        try {
            if (this.mSwitchWaitProgress == null) {
                this.mSwitchWaitProgress = new BNCommonProgressDialog(this.mActivity);
            }
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mSwitchWaitProgress != null) {
                this.mSwitchWaitProgress.setOnCancelListener(new RGMapModeViewController$16(this));
                this.mSwitchWaitProgress.setMessage("正在切换路线雷达...");
                this.mSwitchWaitProgress.show();
            }
        } catch (Exception e) {
            LogUtil.e("wangyang", e.toString());
        }
    }

    public boolean dismissSwitchProgressDialog() {
        if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mSwitchWaitProgress == null || !this.mSwitchWaitProgress.isShowing())) {
            try {
                this.mSwitchWaitProgress.dismiss();
            } catch (Exception e) {
                LogUtil.e("wangyang", e.toString());
            }
        }
        this.mSwitchWaitProgress = null;
        return true;
    }

    public void setSwitchProgressDialogCloseGone() {
        if (this.mSwitchWaitProgress != null) {
            this.mSwitchWaitProgress.setCloseGone();
        }
    }

    public void setSwitchProgressDialogCloseVisible() {
        if (this.mSwitchWaitProgress != null) {
            this.mSwitchWaitProgress.setCloseVisible();
        }
    }

    public void showParkView() {
        if (BNavigator.getInstance().getCanParkShow()) {
            if (this.mParkView == null) {
                this.mParkView = new RGMMParkView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
            }
            this.mParkView.orientationChanged(this.mRootViewGroup, getOrientation());
            this.mParkView.show();
        }
    }

    public void hideParkView() {
        if (this.mParkView != null) {
            this.mParkView.hide();
        }
    }

    public boolean isParkViewShowing() {
        if (this.mParkView != null) {
            return this.mParkView.isVisibility();
        }
        return false;
    }

    public void showOffScreenView() {
        if (this.mOffScreenView == null) {
            this.mOffScreenView = new RGMMOffScreenView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        this.mOffScreenView.orientationChanged(this.mRootViewGroup, getOrientation());
        this.mOffScreenView.show();
    }

    public boolean isOffScreenViewVisible() {
        if (this.mOffScreenView != null) {
            return this.mOffScreenView.isVisible();
        }
        return false;
    }

    public void forceShowOffScreen() {
        if (this.mOffScreenView == null) {
            this.mOffScreenView = new RGMMOffScreenView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        this.mOffScreenView.orientationChanged(this.mRootViewGroup, getOrientation());
        this.mOffScreenView.forceShow();
    }

    public void hideOffScreenView() {
        if (this.mOffScreenView != null) {
            this.mOffScreenView.hide();
        }
    }

    public BNCommonProgressDialog showAvoidTrafficLoading(String strTip) {
        if (this.mActivity == null) {
            return null;
        }
        try {
            if (this.mActivity != null) {
                this.mAvoidTrafficDialog = new BNCommonProgressDialog(this.mActivity);
            }
            if (this.mAvoidTrafficDialog != null) {
                this.mAvoidTrafficDialog.setMessage(strTip).setCancelable(true);
            }
            if (!(this.mAvoidTrafficDialog.isShowing() || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mAvoidTrafficDialog.show();
            }
        } catch (Exception e) {
            LogUtil.e("RouteGuide", "Show mAvoidTrafficDialog Loading222222222222");
        }
        return this.mAvoidTrafficDialog;
    }

    public void dismissAvoidTrafficLoading() {
        try {
            if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mAvoidTrafficDialog == null || !this.mAvoidTrafficDialog.isShowing())) {
                this.mAvoidTrafficDialog.dismiss();
            }
        } catch (Exception e) {
            this.mAvoidTrafficDialog = null;
        }
        this.mAvoidTrafficDialog = null;
    }

    public ViewGroup getViewContails(int id) {
        if (this.mRootViewGroup != null) {
            View v = this.mRootViewGroup.findViewById(id);
            if (v != null && (v instanceof ViewGroup)) {
                return (ViewGroup) v;
            }
        }
        return null;
    }

    public void showNotificationDebugView() {
        if (this.mNotificationDebugView == null) {
            this.mNotificationDebugView = new RGMMNotificationDebugView(this.mActivity, this.mRootViewGroup);
        }
        if (this.mNotificationDebugView != null) {
            this.mNotificationDebugView.show();
        }
    }

    public void hideNotificationDebugView() {
        if (this.mNotificationDebugView != null) {
            this.mNotificationDebugView.hide();
        }
    }

    public void showInterveneMasking() {
        if (this.mRootViewGroup != null) {
            View interveneLy = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_intervene_ly);
            if (interveneLy != null) {
                interveneLy.setFocusable(true);
                interveneLy.setFocusableInTouchMode(true);
                interveneLy.setClickable(true);
                interveneLy.setLongClickable(true);
                this.mIsInterveneMaskingShow = true;
            }
        }
    }

    public void hideInterveneMasking() {
        if (this.mRootViewGroup != null) {
            View interveneLy = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_intervene_ly);
            if (interveneLy != null) {
                interveneLy.setFocusable(false);
                interveneLy.setFocusableInTouchMode(false);
                interveneLy.setClickable(false);
                interveneLy.setLongClickable(false);
                this.mIsInterveneMaskingShow = false;
            }
        }
    }

    public void showAssistMapSwitch() {
        if (!(this.mAssistGuideView == null || FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState()))) {
            this.mAssistGuideView.showMapSwitchOrRoadBar();
        }
        moveHightwaySimpleBoardView();
    }

    private void moveHightwaySimpleBoardView() {
        boolean show;
        boolean isRoadBarShow = true;
        if (BNavConfig.pRGLocateMode == 2) {
            show = false;
        } else {
            show = true;
        }
        if (this.mHighwaySimpleBoardView != null) {
            boolean isRoadBarMode;
            if (BNSettingManager.getIsShowMapSwitch() != 1) {
                isRoadBarShow = false;
            }
            if (isRoadBarShow && RGControlPanelModel.getInstance().getFullviewState()) {
                show = false;
            }
            if (show && isRoadBarShow) {
                isRoadBarMode = true;
            } else {
                isRoadBarMode = false;
            }
            this.mHighwaySimpleBoardView.setViewMarginRight(isRoadBarMode);
        }
    }

    public void hideAssistMapSwitch() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.hideMapSwitchOrRoadBar();
        }
    }

    public void showOfflineToOnlineView(boolean show) {
        if (show) {
            int rpNetMode = BNSettingManager.getPrefRoutPlanMode();
            LogUtil.e("RouteGuide", "OfflineToOnline showOfflineToOnlineView rpNetMode " + rpNetMode);
            if (rpNetMode == 1 || rpNetMode == 3) {
                RGSimpleGuideModel.mIsOfflineToOnline = true;
                if (this.mOfflineToOnlineView == null) {
                    this.mOfflineToOnlineView = new RGMMOfflineToOnlineView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
                }
                this.mOfflineToOnlineView.orientationChanged(this.mRootViewGroup, getOrientation());
                if (this.mOfflineToOnlineView != null) {
                    this.mOfflineToOnlineView.show();
                }
            }
        } else if (this.mOfflineToOnlineView != null) {
            this.mOfflineToOnlineView.hide();
            this.mOfflineToOnlineView = null;
        }
    }

    public void showRPPreferView(boolean show) {
        if (show && RGSimpleGuideModel.mIsRPPrefer) {
            if (this.mRPPreferView == null) {
                this.mRPPreferView = new RGMMRPPreferView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
            }
            this.mRPPreferView.orientationChanged(this.mRootViewGroup, getOrientation());
            if (this.mRPPreferView != null) {
                this.mRPPreferView.show();
            }
        } else if (this.mRPPreferView != null) {
            this.mRPPreferView.hide();
            this.mRPPreferView = null;
        }
    }

    public void showSatelliteView(boolean show) {
        if (show && RGSimpleGuideModel.mIsSatellite) {
            if (this.mSatelliteView == null) {
                this.mSatelliteView = new RGMMSatelliteView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
            }
            this.mSatelliteView.orientationChanged(this.mRootViewGroup, getOrientation());
            if (this.mSatelliteView != null) {
                this.mSatelliteView.show();
            }
        } else if (this.mSatelliteView != null) {
            this.mSatelliteView.hide();
            this.mSatelliteView = null;
        }
    }

    public void showFellowView() {
    }

    public void hideFellowView() {
    }

    public void showUserRightView() {
        if (this.mUserRightView != null) {
            this.mUserRightView.show();
        }
    }

    public void hideUserRightView() {
        if (this.mUserRightView != null) {
            this.mUserRightView.hide();
        }
    }

    public void hideUserRightTipsView() {
        if (this.mUserRightView != null) {
            this.mUserRightView.hideUserRightTipsView();
        }
    }

    public void updateUserCurMileaInfo() {
        if (this.mUserRightView != null) {
            this.mUserRightView.updateCurMileaInfo();
        }
    }

    public void showAssistView() {
        hideControlManualOperatePanel();
        showControlPanel();
        if (this.mAssistGuideView != null && !isEnlargeOrColladaShow()) {
            this.mAssistGuideView.show();
            this.mAssistGuideView.updateDataByLastest();
        }
    }

    public boolean isEnlargeOrColladaShow() {
        if (this.mEnlargeRoadMapView != null) {
            return this.mEnlargeRoadMapView.isEnlargeOrColladaShow();
        }
        return false;
    }

    public void showAssistCameraView(boolean show) {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.showCameraView(show);
        }
    }

    public void clearAssistInfo() {
    }

    public void hideAssistInfo() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.hide();
        }
    }

    public void hideAssistViewOnly() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.hideAssistView();
        }
    }

    public void updateCurCarSpeed() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateCurCarSpeed();
        }
    }

    public void setRoadConditionBarVisible(int visible) {
        boolean z = true;
        if (BNavConfig.pRGLocateMode != 2) {
            boolean isRoadBarShow;
            if (BNSettingManager.getIsShowMapSwitch() == 1) {
                isRoadBarShow = true;
            } else {
                isRoadBarShow = false;
            }
            if (this.mAssistGuideView != null && this.mHighwaySimpleBoardView != null && isRoadBarShow) {
                this.mAssistGuideView.setRoadConditionBarVisible(visible);
                RGMMHighwaySimpleBoardView rGMMHighwaySimpleBoardView = this.mHighwaySimpleBoardView;
                if (visible != 0) {
                    z = false;
                }
                rGMMHighwaySimpleBoardView.setViewMarginRight(z);
            }
        }
    }

    public void showRoadConditionUpdateFail() {
        if (this.mRoadConditonUpdateFailView != null) {
            this.mRoadConditonUpdateFailView.show();
        }
    }

    public void hideRoadConditonUpdateFail() {
        if (this.mRoadConditonUpdateFailView != null) {
            this.mRoadConditonUpdateFailView.hide();
        }
    }

    public void updateScaleLevel() {
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.update();
        }
    }

    private void hideStatusBar(Activity context) {
        WindowManager.LayoutParams attrs = context.getWindow().getAttributes();
        attrs.flags |= 1024;
        context.getWindow().setAttributes(attrs);
    }

    private void showStatusBar(Activity context) {
        WindowManager.LayoutParams attrs = context.getWindow().getAttributes();
        attrs.flags &= -1025;
        context.getWindow().setAttributes(attrs);
    }

    public boolean isEnlargeRoadMapValid(String bgName, String arrowName) {
        return false;
    }

    public void resetEnlargeRoadMap() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.reset();
        }
        RGEnlargeRoadMapModel.getInstance().reset();
    }

    public void updateEnlargeRoadMap(Bundle b) {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.updateData(b);
        }
    }

    public void updateEnlargeMapByShow(Bundle b) {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.updateData(b, true);
        }
    }

    public void showEnlargeRoadMap() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.show();
            handleAssistHighwayShow(false);
            LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge showEnlargeRoadMap");
        }
    }

    public void handleLaneEnlargeShow(boolean isShow) {
        if (this.mCommonView != null) {
            this.mCommonView.handleFollowLaneOrientation(RGViewController.getInstance().getOrientation(), isShow);
        }
    }

    public void handleBlackSpaceVisibility(boolean isShow) {
        if (this.mBlackSpacell != null) {
            this.mBlackSpacell.setVisibility(isShow ? 0 : 8);
        }
    }

    public void hideEnlargeRoadMapAnimation() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.hide();
            handleAssistHighwayShow(true);
            handleLaneEnlargeShow(false);
            LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge hideEnlargeRoadMapAnimation");
        }
    }

    public void hideEnlargeRoadMapWithoutAnimation() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.hideWithoutAnimation();
            handleAssistHighwayShow(true);
            handleLaneEnlargeShow(false);
            LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge hideEnlargeRoadMapWithoutAnimation");
        }
    }

    public void handleAssistHighwayShow(boolean show) {
        if (show) {
            if (this.mHighwayAssistPanel != null) {
                this.mHighwayAssistPanel.setVisibility(0);
            }
        } else if (this.mHighwayAssistPanel != null) {
            this.mHighwayAssistPanel.setVisibility(8);
        }
    }

    public void postEnlargeMapProgressRunnable() {
    }

    public void updateAssistView(Bundle data) {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateData(data);
        }
    }

    public void showUgcBtnLayout(boolean show) {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.showUgcBtnLayout(show);
        }
    }

    public boolean isShowingUgcBtnLayout() {
        if (this.mAssistGuideView != null) {
            return this.mAssistGuideView.isShowingUgcBtnLayout();
        }
        return false;
    }

    public void hideRGSimpleGuideLeftPanelView() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.hideLandspaceLeftPanel();
        }
    }

    public void showRGSimpleGuideLeftPanelView() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.showLandspaceLeftPanel();
        }
    }

    public void hideDeviceStateView() {
        if (this.mDeviceStateView != null) {
            this.mDeviceStateView.hide();
        }
    }

    public void showDeviceStateView() {
        if (!isHighwayMiniPanelShowing() && this.mDeviceStateView != null) {
            this.mDeviceStateView.show();
        }
    }

    public boolean isDeviceStateViewShowing() {
        if (this.mDeviceStateView != null) {
            return this.mDeviceStateView.isVisibility();
        }
        return false;
    }

    public void hideRGSimpleGuideView() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.hide();
        }
    }

    public void showRGSimpleGuideView() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.show();
        }
    }

    public void showRGSimpleGuideViewProgress(String text) {
        if (this.mSimpleGuideView != null && this.mSimpleGuideView.isVisibility()) {
            this.mSimpleGuideView.showYawingProgressView(text);
        }
    }

    public void showRGSimpleGuideSuitableView() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.showSuitableView();
        }
    }

    public void updateSimpleGuideInfo(Bundle b) {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.updateData(b);
            LogUtil.e("RouteGuide", "updateSimpleGuideInfo! b --> " + b.toString());
        }
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onRemainDistTimeUpdate();
        }
    }

    public void updateSatelliteNum(int num) {
        if (num < 0) {
            num = 0;
        }
        if (num > 15) {
            num = 15;
        }
        if (num != -1 && this.mDeviceStateView != null) {
            this.mDeviceStateView.updateSatelliteNum(num);
        }
    }

    public void updateTotalRemainInfo() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onRemainDistTimeUpdate();
        }
        if (this.mHighwayView != null) {
            this.mHighwayView.updateTotalRemainInfo();
        }
        if (this.mRGHUDControlView != null) {
            this.mRGHUDControlView.updateTotalRemainInfo();
        }
    }

    public void updateCurRoadName() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.updateCurRoadName();
        }
    }

    public void updateLowBattery() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.updateCurRoadName();
        }
    }

    public void updateLowVolumeView(boolean flag) {
        LogUtil.e("RouteGuide", "updateLowVolumeView flag : " + flag);
        if (this.mSimpleGuideView != null) {
            if (flag) {
                this.mDeviceStateView.updateVolumeView(true);
            } else if (BNSettingManager.getVoiceMode() == 2) {
                this.mDeviceStateView.updateVolumeView(true);
            } else if (AudioUtils.isSmartisanPanelMute()) {
                this.mDeviceStateView.updateVolumeView(true);
            } else {
                this.mDeviceStateView.updateVolumeView(flag);
            }
            LogUtil.e("RouteGuide", "updateLowVolumeView end");
        }
    }

    public void updateSimpleMapLayout() {
        if (this.mSimpleGuideView != null) {
            this.mSimpleGuideView.updateDataByLastest();
        }
    }

    public void showRoutePlan() {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(5, 0, 0, null);
        }
    }

    public BNCommonProgressDialog showLoading(String strTip) {
        if (this.mActivity == null) {
            return null;
        }
        try {
            if (this.mWaitProgress == null && this.mActivity != null) {
                this.mWaitProgress = new BNCommonProgressDialog(this.mActivity);
            }
            if (this.mWaitProgress != null) {
                this.mWaitProgress.setMessage(strTip);
                this.mWaitProgress.setOnCancelListener(new RGMapModeViewController$17(this));
            }
            if (!(this.mWaitProgress.isShowing() || this.mActivity == null || this.mActivity.isFinishing())) {
                this.mWaitProgress.show();
            }
        } catch (Exception e) {
        }
        return this.mWaitProgress;
    }

    public void dismissLoading() {
        try {
            if (this.mWaitProgress != null && this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mWaitProgress.dismiss();
            }
        } catch (Exception e) {
            this.mWaitProgress = null;
        }
    }

    public boolean isMainAuxiliaryBridgeBtnClicked() {
        if (this.mMABView != null) {
            return this.mMABView.isBtnClicked();
        }
        return false;
    }

    public void resetMainAuxiliaryBridgeBtnClicked() {
        if (this.mMABView != null) {
            this.mMABView.resetBtnClicked();
        }
    }

    public void dismissQuitNaviDialog() {
        try {
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mQuitNaviDialog != null && this.mQuitNaviDialog.isShowing()) {
                this.mQuitNaviDialog.dismiss();
            }
        } catch (Exception e) {
            this.mQuitNaviDialog = null;
        }
    }

    public void dismissVolumeAdjust() {
        try {
            if (this.mActivity != null && !this.mActivity.isFinishing() && this.mVolumeAdjustDialog != null && this.mVolumeAdjustDialog.isShowing()) {
                this.mVolumeAdjustDialog.dismiss();
                this.mVolumeAdjustDialog.onDestory();
            }
        } catch (Exception e) {
            this.mVolumeAdjustDialog = null;
        }
    }

    public void updateZoomViewState() {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.updateZoomViewState();
        }
    }

    public void updateMainAuxiliaryOrBridgeView(int type) {
        LogUtil.e("RouteGuide", "peng update MAOrBridge type = " + type);
        if (this.mMABView != null) {
            this.mMainAuxiliaryBridgeType = type;
            this.mMABView.updateMainAuxiliaryBridgeView(type);
        }
    }

    public void updateMainAuxiliaryBridgeViewByLastType() {
        LogUtil.e("RouteGuide", "updateMainAuxiliaryBridgeViewByLastType mMainAuxiliaryBridgeType = " + this.mMainAuxiliaryBridgeType);
        if (this.mMABView != null) {
            this.mMABView.updateMainAuxiliaryBridgeView(this.mMainAuxiliaryBridgeType);
        }
    }

    public void hideMainAuxiliaryBridgeView() {
        if (this.mMABView != null) {
            this.mMABView.updateMainAuxiliaryBridgeView(0);
        }
    }

    public void showAnologNavi(boolean show) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.showAnologNavi(show);
        }
    }

    public void switchAnologNaviControlState(boolean isPlay) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.switchAnologNaviControlState(isPlay);
        }
    }

    public boolean isEnlargeRoadMapViewShow() {
        return false;
    }

    public Bitmap getEnlargeViewBitmap() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.getEnlargeViewBitmap();
        }
        return null;
    }

    public Bitmap getEnlargeBitmap() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.getEnlargeBitmap();
        }
        return null;
    }

    public Handler getUIHandler() {
        return this.mainUIHandler;
    }

    public void showPickPointWithType() {
        if (!isEnlargeOrColladaShow()) {
            RGNotificationController.getInstance().showPickPointWithType();
        }
    }

    public void showPickPointView() {
        if (!isEnlargeOrColladaShow()) {
            RGNotificationController.getInstance().showPickPoint();
        }
    }

    public void updatePickPointView() {
        RGNotificationController.getInstance().updatePickPoint();
    }

    public void hidePickPointView() {
        RGNotificationController.getInstance().hidePickPoint();
    }

    public void showLaneLineView() {
        if (this.mLaneView != null) {
            this.mLaneView.show();
            handleBlackSpaceVisibility(true);
        }
    }

    public void hideLaneLineView() {
        if (this.mLaneView != null) {
            this.mLaneView.hide();
            handleBlackSpaceVisibility(false);
        }
    }

    public boolean isLaneLineViewVisible() {
        if (this.mLaneView != null) {
            return this.mLaneView.isVisibility();
        }
        return false;
    }

    public void updateLaneLineImage(ArrayList<Integer> list) {
        if (this.mLaneView != null) {
            try {
                this.mLaneView.updateImageView(list);
            } catch (Exception e) {
            }
        }
    }

    public void updateEnlargeLaneLineImage(ArrayList<Integer> list) {
        if (this.mEnlargeLaneView != null) {
            try {
                this.mEnlargeLaneView.updateImageView(list);
            } catch (Exception e) {
            }
        }
    }

    private void resetEnlargeLaneLineViewMargin() {
        if (this.mEnlargeLaneContainer != null) {
            LayoutParams lp = (LayoutParams) this.mEnlargeLaneContainer.getLayoutParams();
            int margin = (ScreenUtil.getInstance().getHeightPixels() / 2) - ScreenUtil.getInstance().dip2px(36.0f);
            if (lp.topMargin != margin) {
                lp.topMargin = margin;
                this.mEnlargeLaneContainer.setLayoutParams(lp);
            }
        }
    }

    public void handlePortraitLargeLaneViewShow(boolean isEnlargeShow) {
        LogUtil.e(RGLaneInfoModel.TAG, "handlePortraitLargeLaneViewShow " + isEnlargeShow);
        if (isEnlargeShow) {
            if (isLaneViewShow()) {
                setEnlargeLaneShow(true);
            }
            hideLaneLineView();
            return;
        }
        if (isLaneViewShow()) {
            showLaneLineView();
        }
        setEnlargeLaneShow(false);
    }

    public void hanldleLandScapeLaneShow(boolean isEnlarge) {
        if (isEnlarge) {
            if (isLaneViewShow()) {
                showLaneLineView();
            }
        } else if (isLaneViewShow()) {
            showLaneLineView();
        }
        setEnlargeLaneShow(false);
        LogUtil.e(RGLaneInfoModel.TAG, "hanldleLandScapeLaneShow " + isEnlarge);
    }

    private boolean isLaneViewShow() {
        LogUtil.e(RGLaneInfoModel.TAG, "isLaneViewShow " + NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState()));
        if (RGLaneInfoModel.getModel(false).isShowLaneLineView() && NavState.NAV_STATE_NAVING.equals(RGControlPanelModel.getInstance().getNavState())) {
            return true;
        }
        return false;
    }

    public void setEnlargeLaneShow(boolean show) {
        if (this.mEnlargeLaneView == null) {
            return;
        }
        if (!show) {
            this.mEnlargeLaneView.hide();
        } else if (getOrientation() != 2) {
            resetEnlargeLaneLineViewMargin();
            this.mEnlargeLaneView.show();
        }
    }

    public void handleLaneLineViewShow(boolean show) {
        if (show) {
            boolean isEnarlgeShow = getInstance().isEnlargeOrColladaShow();
            if (getOrientation() == 2) {
                showLaneLineView();
                setEnlargeLaneShow(false);
            } else if (isEnarlgeShow) {
                setEnlargeLaneShow(true);
                hideLaneLineView();
            } else {
                showLaneLineView();
                setEnlargeLaneShow(false);
            }
            LogUtil.e(RGLaneInfoModel.TAG, "handleLaneLineViewShow " + isEnarlgeShow + "," + getOrientation());
            return;
        }
        hideLaneLineView();
        setEnlargeLaneShow(false);
    }

    public void dispose() {
        synchronized (mLoadViewLock) {
            if (BNavigator.getInstance().isNaviBegin()) {
                LogUtil.e("RouteGuide", "dispose return isNaviBegin");
                return;
            }
            unRegistRootViewSizeChange();
            cancleAutoHideControlPanel();
            cancelAutoExitRouteSearchMode();
            releaseAllDialogs();
            releaseSubViews(false);
            try {
                RGViewController.getInstance().hideRGFloatView();
                this.mRouteGuideFloatView = null;
            } catch (Exception e) {
                LogUtil.e("RouteGuide", "dispose hideRGFloatView e:" + e.getMessage());
            }
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).clearSearchParkPoi();
            RGAvoidTrafficModel.getInstance().setCountDown(false);
            RGAvoidTrafficModel.getInstance().setmCanAvoidTrafficShow(false);
            RGMainAuxiliaryModel.getInstance().setmCanMainAuxiliaryShow(false);
            RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
            unInitAutioUtil();
            if (this.mMiniMapView != null) {
                this.mMiniMapView.unInit();
                this.mMiniMapView = null;
            }
            this.mActivity = null;
        }
    }

    public void showCommentRouteView() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(2, 1, 1, Integer.valueOf(getOrientation()));
        }
    }

    public void hideCommentRouteView() {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onOtherAction(2, 0, 1, Integer.valueOf(getOrientation()));
        }
    }

    public void showParkPointView() {
        if (this.mParkPointView == null) {
            this.mParkPointView = new RGMMParkPointView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        this.mParkPointView.show();
    }

    public void updateParkPointView() {
        if (this.mParkPointView != null) {
            this.mParkPointView.updateData(null);
        }
    }

    public void hideParkPointView() {
        if (this.mParkPointView != null) {
            this.mParkPointView.hide();
            this.mParkPointView.dispose();
            this.mParkPointView = null;
        }
    }

    public void showRouteSearchView() {
        if (this.mRouteSearchView == null) {
            this.mRouteSearchView = new RGMMRouteSearchView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mRouteSearchView != null) {
            RGControlPanelModel.mIsRouteSearchVisible = true;
            this.mRouteSearchView.show();
        }
    }

    public void showMenuMoreView(Bundle bundle) {
        if (this.mMenuMoreView == null) {
            this.mMenuMoreView = new RGMMMenuMoreView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.show(bundle);
            RGControlPanelModel.mIsMenuMoreVisible = true;
        }
    }

    public void showMenuMoreView() {
        if (this.mMenuMoreView == null) {
            this.mMenuMoreView = new RGMMMenuMoreView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.show();
            RGControlPanelModel.mIsMenuMoreVisible = true;
        }
    }

    public void updateMenuMoreView() {
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.updateGuideAngleSeletor();
        }
    }

    public void onMenuMoreActivityResule(int requestCode, int resultCode, Intent data) {
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void hideRouteSearchView() {
        if (this.mRouteSearchView != null) {
            RGControlPanelModel.mIsRouteSearchVisible = false;
            this.mRouteSearchView.hide();
        }
    }

    public boolean isRouteSearchVisible() {
        if (this.mRouteSearchView != null) {
            return this.mRouteSearchView.isVisibility();
        }
        return false;
    }

    public void showCommonView(boolean show) {
        if (this.mCommonView != null) {
            this.mCommonView.showCommonView(show);
        }
    }

    public boolean requestShowExpendView(int expendViewType, boolean show) {
        if (this.mCommonView != null) {
            return this.mCommonView.requestShowExpendView(expendViewType, show);
        }
        return false;
    }

    public boolean requestShowExpendView(int expendViewType, boolean show, int source) {
        if (this.mCommonView != null) {
            return this.mCommonView.requestShowExpendView(expendViewType, show, source);
        }
        return false;
    }

    public void showBtOscDialog() {
        if (this.mActivity != null) {
            try {
                if (this.mBTScoDlg == null && this.mActivity != null) {
                    this.mBTScoDlg = new BNMessageDialog(this.mActivity).setTitleText(JarUtils.getResources().getString(C4048R.string.alert_bt_osc_title)).setMessage(JarUtils.getResources().getString(C4048R.string.alert_bt_osc_msg)).setFirstBtnText(JarUtils.getResources().getString(C4048R.string.alert_bt_osc_open)).setOnFirstBtnClickListener(new RGMapModeViewController$20(this)).setSecondBtnText(JarUtils.getResources().getString(C4048R.string.alert_cancel)).setOnSecondBtnClickListener(new RGMapModeViewController$19(this));
                }
                if (this.mBTScoDlg != null && !this.mBTScoDlg.isShowing() && this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mBTScoDlg.show();
                }
            } catch (Exception e) {
            }
        }
    }

    public void showFellowSwitch() {
    }

    public void hideFellowSwitch() {
    }

    public boolean isShowEnlargeRoadMap() {
        boolean z;
        synchronized (this.mMutex) {
            z = this.mIsShowEnlargeRoadMap;
        }
        return z;
    }

    public void setIsShowEnlargeRoadMap(boolean mShowEnlargeRoadMap) {
        synchronized (this.mMutex) {
            this.mIsShowEnlargeRoadMap = mShowEnlargeRoadMap;
        }
    }

    public boolean ismIsShowColladaView() {
        return this.mIsShowColladaView;
    }

    public void setmIsShowColladaView(boolean mIsShowColladaView) {
        this.mIsShowColladaView = mIsShowColladaView;
    }

    public boolean isOpenFellow() {
        return false;
    }

    public void miniRequestRender(boolean render) {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.miniRequestRender(render);
        }
    }

    public void showColladaView(boolean show) {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.showColladaView(show);
            if (show) {
                RGViewController.getInstance().hideMenuMoreView();
                RGViewController.getInstance().hideRouteSearchView();
            }
        }
    }

    public void resetColladaView() {
        if (this.mEnlargeRoadMapView != null) {
            this.mEnlargeRoadMapView.resetColladaView();
        }
    }

    public void hideStatusBar() {
        if (this.mActivity == null) {
            LogUtil.e("RoutePlan", "hideStatusBar fail mActivity is null");
            return;
        }
        Window win = this.mActivity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.flags |= 1024;
        win.setAttributes(winParams);
        View decorView = win.getDecorView();
        if (decorView == null) {
            LogUtil.e("RoutePlan", "hideStatusBar fail decorView is null");
        } else if (VERSION.SDK_INT < 16) {
            decorView.setSystemUiVisibility(4);
        } else {
            decorView.setSystemUiVisibility(4);
        }
    }

    public void showStatusBar() {
        if (this.mActivity == null) {
            LogUtil.e("RoutePlan", "showStatusBar fail mActivity is null");
            return;
        }
        Window win = this.mActivity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.flags &= -1025;
        win.setAttributes(winParams);
        View decorView = win.getDecorView();
        if (decorView == null) {
            LogUtil.e("RoutePlan", "showStatusBar fail decorView is null");
        } else if (VERSION.SDK_INT < 14) {
            decorView.setSystemUiVisibility(0);
        } else if (VERSION.SDK_INT < 16) {
            decorView.setSystemUiVisibility(0);
        } else {
            decorView.setSystemUiVisibility(1024);
        }
    }

    public Bitmap getRoadmapBgBitmap() {
        return RGEnlargeRoadMapModel.getInstance().getBGBitmap();
    }

    public Bitmap getRoadmapArrowBitmap() {
        return RGEnlargeRoadMapModel.getInstance().getArrowBitmap();
    }

    public String getRoadmapRoadName() {
        return RGEnlargeRoadMapModel.getInstance().getRoadName();
    }

    public int getRoadmapProgress() {
        return RGEnlargeRoadMapModel.getInstance().getRoadmapProgress();
    }

    public String getRoadmapRemainDis() {
        StringBuffer distance = new StringBuffer();
        StringUtils.formatDistance(RGEnlargeRoadMapModel.getInstance().getRoadmapRemainDis(), UnitLangEnum.ZH, distance);
        return distance.toString();
    }

    public ViewGroup getModuleContails() {
        if (this.mRootViewGroup != null) {
            View v = this.mRootViewGroup.findViewById(C4048R.id.module_contains);
            if (v != null && (v instanceof ViewGroup)) {
                return (ViewGroup) v;
            }
        }
        return null;
    }

    public ViewGroup getUserGuideViewContails() {
        if (this.mRootViewGroup != null) {
            View v = this.mRootViewGroup.findViewById(C4048R.id.navi_rg_first_enter_guide);
            if (v != null && (v instanceof ViewGroup)) {
                return (ViewGroup) v;
            }
        }
        return null;
    }

    public ViewGroup getSafetyViewContails() {
        if (this.mRootViewGroup != null) {
            View v = this.mRootViewGroup.findViewById(C4048R.id.navi_rg_safety_guide);
            if (v != null && (v instanceof ViewGroup)) {
                return (ViewGroup) v;
            }
        }
        return null;
    }

    public LinearLayout getDebugLinearLayout() {
        if (this.mRootViewGroup == null) {
            return null;
        }
        LinearLayout v = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.common_debug_layout);
        if (v != null) {
            return v;
        }
        ViewStub stub = (ViewStub) this.mRootViewGroup.findViewById(C4048R.id.common_debug_viewstub);
        if (stub != null) {
            return (LinearLayout) stub.inflate();
        }
        return v;
    }

    public TextView getDebugText() {
        if (this.mRootViewGroup != null) {
            return (TextView) this.mRootViewGroup.findViewById(C4048R.id.common_debug_text);
        }
        return null;
    }

    public String debugViewState() {
        if (this.mSimpleGuideView != null) {
            return this.mSimpleGuideView.debugViewState();
        }
        return "";
    }

    public void removeSlightSwitchMsg() {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.removeCancelSwitch();
        }
    }

    public void showMultiRouteSwitcherView() {
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = true;
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().showResumeSwitchView();
        }
    }

    public void hideMultiRouteSwitcherView(boolean isBrowseState) {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().hideResumeSwitchView();
        }
    }

    public void showScaleLevelView() {
        if (this.mRootViewGroup != null) {
            if (this.mScaleLevelView == null) {
                this.mScaleLevelView = new RGMMScaleLevelView(this.mActivity, this.mRootViewGroup);
            }
            if (this.mScaleLevelView != null) {
                this.mScaleLevelView.show();
            }
        }
    }

    public void hideScaleLevelView() {
        if (this.mScaleLevelView != null) {
            this.mScaleLevelView.hide();
        }
    }

    public void showVoiceModeToast(boolean isShowToast) {
        if (isShowToast) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_voice_mode_switch_on_text));
        } else {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_voice_mode_switch_off_text));
        }
    }

    public void openSCO(int fromType) {
        if (this.mAdudioUtils != null) {
            this.mAdudioUtils.openSCO(fromType);
        }
    }

    public void closeSCO(int fromType) {
        LogUtil.e("AudioUtils", "closeSCO");
        if (this.mAdudioUtils != null) {
            if (fromType == 11) {
                this.mAdudioUtils.removeSCOMsg();
            }
            this.mAdudioUtils.closeSCO(fromType);
        }
    }

    public void resetAudio() {
        if (this.mAdudioUtils != null) {
            this.mAdudioUtils.resetAudio();
        }
    }

    public void unInitAutioUtil() {
        if (this.mAdudioUtils != null) {
            this.mAdudioUtils.uninit();
        }
    }

    public void setBluetoothScoOn(boolean flag) {
        if (this.mAdudioUtils != null) {
            this.mAdudioUtils.setBluetoothScoOn(flag);
        }
    }

    public boolean isShowRCStyleGuideView() {
        if (this.mRCStyleGuideView != null) {
            return this.mRCStyleGuideView.isVisibility();
        }
        return false;
    }

    public void showRCStyleGuideView() {
        if (this.mRCStyleGuideView == null) {
            this.mRCStyleGuideView = new RGMMRCStyleUserGuideView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        this.mRCStyleGuideView.show();
    }

    public void hideRCStyleGuideView() {
        if (this.mRCStyleGuideView != null) {
            this.mRCStyleGuideView.hide();
            this.mRCStyleGuideView = null;
        }
    }

    public void disposeUserGuideView() {
        if (this.mRCStyleGuideView != null) {
            this.mRCStyleGuideView.dispose();
        }
    }

    public void showVolume(int curSystemVolume, int maxSystemVolume, int curTTSVolume, boolean volumeUp) {
        if (this.mActivity != null) {
            try {
                if (this.mVolumeAdjustDialog == null) {
                    this.mVolumeAdjustDialog = new BNVolumeAdjustDialog(this.mActivity);
                }
                LogUtil.e("wangyang", "Show BNVolumeAdjustDialog Loading");
                if (!(this.mVolumeAdjustDialog.isShowing() || this.mActivity == null || this.mActivity.isFinishing())) {
                    this.mVolumeAdjustDialog.show();
                }
                if (this.mVolumeAdjustDialog != null && this.mVolumeAdjustDialog.isShowing()) {
                    this.mVolumeAdjustDialog.showVolume(curSystemVolume, maxSystemVolume, curTTSVolume, volumeUp, this.mSimpleGuideView.getSPViewHeight(), this.mSimpleGuideView.getSBViewHeight());
                    updateBlueToothUSBPanel();
                }
            } catch (Exception e) {
            }
        }
    }

    public void updateBlueToothUSBPanel() {
        if (this.mVolumeAdjustDialog != null) {
            if (isBlueToothUSBGuideVisible() || getHudShowStatus()) {
                this.mVolumeAdjustDialog.showBTUSBPanel(false);
            } else if (BlueToothListener.isBTConnect) {
                RGMMBlueToothUSBGuideView.sPanelContentType = 1;
                this.mVolumeAdjustDialog.setBTUSBContent(1);
                this.mVolumeAdjustDialog.showBTUSBPanel(true);
            } else {
                this.mVolumeAdjustDialog.showBTUSBPanel(false);
            }
        }
    }

    public void showBlueToothUSBGuide() {
        if (this.mBlueToothUSBGuideView == null) {
            this.mBlueToothUSBGuideView = new RGMMBlueToothUSBGuideView(this.mActivity, this.mRootViewGroup, this.mSubViewListener);
        }
        if (this.mBlueToothUSBGuideView != null) {
            RGControlPanelModel.sIsBlueToothUSBGuideVisible = true;
            this.mBlueToothUSBGuideView.show();
        }
    }

    public void hideBlueToothUSBGuide() {
        if (this.mBlueToothUSBGuideView != null) {
            RGControlPanelModel.sIsBlueToothUSBGuideVisible = false;
            this.mBlueToothUSBGuideView.hide();
        }
    }

    public boolean isBlueToothUSBGuideVisible() {
        if (this.mBlueToothUSBGuideView != null) {
            return this.mBlueToothUSBGuideView.isVisibility();
        }
        return false;
    }

    public void disMissRGMMControlPanelViewSDKUI() {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.disMissSDKUI();
            this.mControlPanelView.updateNaviStatus();
        }
    }

    public void showRGFloatView() {
        if (!BNavigator.getInstance().isNaviBegin() || RGCacheStatus.hasClosedFoatView || !BNavigator.getInstance().isBackgroundNavi()) {
            return;
        }
        if (BNaviModuleManager.hasPermission(NaviCommonConstant.OVERLAY_PERMISSION)) {
            LogUtil.e("RouteGuide", "showRGFloatView success has permission");
            if (BNSettingManager.getPrefFloatSwitch()) {
                if (this.mRouteGuideFloatView == null) {
                    this.mRouteGuideFloatView = new RGMMRouteGuideFloatView();
                }
                this.mRouteGuideFloatView.show();
                return;
            }
            return;
        }
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_x_6);
        LogUtil.e("RouteGuide", "showRGFloatView success has no permission");
    }

    public void hideRGFloatView() {
        LogUtil.e("RouteGuide", "hideRGFloatView : " + (this.mRouteGuideFloatView == null));
        if (this.mRouteGuideFloatView != null && this.mRouteGuideFloatView.isShow()) {
            this.mRouteGuideFloatView.hide();
        }
    }

    public void updateRGFloatView(Bundle bundle, boolean isHighway) {
        if (this.mRouteGuideFloatView != null && this.mRouteGuideFloatView.isShow()) {
            this.mRouteGuideFloatView.updateData(bundle, isHighway);
        }
    }

    public void showCloseRGFloatViewMsg() {
        RGMMMessageFloatView msgView = new RGMMMessageFloatView();
        msgView.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_float));
        msgView.show();
    }

    public void showOpenOverlyPermissonDialog() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            if (this.mRequestOverlyPermissionDialog == null || !this.mRequestOverlyPermissionDialog.isShowing()) {
                Resources res = JarUtils.getResources();
                this.mRequestOverlyPermissionDialog = new BNDialog(this.mActivity);
                this.mRequestOverlyPermissionDialog.setContentMessage(res.getString(C4048R.string.nsdk_string_rg_float_dialog_description));
                this.mRequestOverlyPermissionDialog.setFirstBtnText(res.getString(C4048R.string.nsdk_string_rg_float_dialog_cancle));
                this.mRequestOverlyPermissionDialog.setSecondBtnTextColorHighLight();
                this.mRequestOverlyPermissionDialog.setSecondBtnText(res.getString(C4048R.string.nsdk_string_rg_float_dialog_ok));
                this.mRequestOverlyPermissionDialog.setOnSecondBtnClickListener(new RGMapModeViewController$21(this));
                try {
                    if (this.mActivity != null && !this.mActivity.isFinishing()) {
                        this.mRequestOverlyPermissionDialog.show();
                    }
                } catch (Exception e) {
                    LogUtil.e("RouteGuide", "dialog show failed because activity is NOT running!");
                }
            }
        }
    }

    public void hideOpenOverlyPermissonDialog() {
        if (this.mRequestOverlyPermissionDialog != null && this.mActivity != null) {
            try {
                if (!this.mActivity.isFinishing() && this.mRequestOverlyPermissionDialog.isShowing()) {
                    this.mRequestOverlyPermissionDialog.dismiss();
                }
            } catch (Exception e) {
            }
            this.mRequestOverlyPermissionDialog = null;
        }
    }

    public void shareSafetyEnd(int exitState) {
        if (exitState == 0) {
            RGSimpleGuideModel.mIsSafetyShareGuideShow = false;
        } else {
            RGSimpleGuideModel.mIsSafetyShareGuideShow = false;
        }
        if (getSafetyViewContails() != null) {
            getSafetyViewContails().setVisibility(8);
        }
        BNLightNaviManager.getInstance().showSafetyGuide(false);
    }

    public RGMMCommonNotificationView newCommonNotification(int notificationType) {
        RGMMCommonNotificationView view = new RGMMCommonNotificationView(this.mActivity, this.mRootViewGroup, notificationType);
        RGNotificationController.getInstance().addCommonView(view);
        return view;
    }

    public RGMMOperableNotificationView newOperableNotification(int notificationType) {
        RGMMOperableNotificationView view = new RGMMOperableNotificationView(this.mActivity, this.mRootViewGroup, notificationType);
        RGNotificationController.getInstance().addOperableView(view);
        return view;
    }

    public boolean isWaitCalProgressShowing() {
        return this.mWaitCalcRouteProgress != null && this.mWaitCalcRouteProgress.isShowing();
    }

    public void showWaitCalProgressDialog(Activity act) {
        dismissWaitCalProgressDialog();
        try {
            if (this.mWaitCalcRouteProgress == null && act != null) {
                this.mWaitCalcRouteProgress = new BNCommonProgressDialog(act);
            }
            if (act != null && !act.isFinishing() && this.mWaitCalcRouteProgress != null) {
                this.mWaitCalcRouteProgress.setOnCancelListener(new RGMapModeViewController$22(this));
                this.mWaitCalcRouteProgress.setDimAmount(0.0f);
                this.mWaitCalcRouteProgress.setMessage(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_is_preparing_nav));
                this.mWaitCalcRouteProgress.show();
            }
        } catch (Exception e) {
            LogUtil.e("RouteGuide", "showWaitCalProgressDialog err:" + e.getMessage());
        }
    }

    public void dismissWaitCalProgressDialog() {
        if (!(this.mActivity == null || this.mActivity.isFinishing() || this.mWaitCalcRouteProgress == null || !this.mWaitCalcRouteProgress.isShowing())) {
            try {
                this.mWaitCalcRouteProgress.dismiss();
            } catch (Exception e) {
            }
        }
        this.mWaitCalcRouteProgress = null;
    }

    public boolean isUGCPanelVisible() {
        View v = getViewContails(C4048R.id.bnav_rg_ugc_menu_panel);
        if (v != null && v.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void showRouteSortView() {
        if (this.mRouteSortView == null && this.mRootViewGroup != null) {
            this.mRouteSortView = new RGMMRouteSortView(this.mActivity, this.mRootViewGroup, this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_route_sort_panel), this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_route_sort_container), 2);
        }
        if (this.mRouteSortView != null) {
            this.mRouteSortView.show();
            RGControlPanelModel.sIsRouteSortViewVisible = true;
        }
    }

    public void hideRouteSortView() {
        if (this.mRouteSortView != null) {
            this.mRouteSortView.hide();
            RGControlPanelModel.sIsRouteSortViewVisible = false;
        }
    }

    public boolean isRouteSortViewVisible() {
        if (this.mRouteSortView != null) {
            return this.mRouteSortView.isVisibility();
        }
        return false;
    }

    public void showEnterNavAnim() {
        if (VERSION.SDK_INT >= 11 && this.mSimpleGuideView != null) {
            View view = this.mSimpleGuideView.getRootView();
            if (view != null) {
                AnimatorSet anim = createShowAnim(view);
                if (anim != null) {
                    anim.start();
                }
            }
        }
    }

    public AnimatorSet createShowAnim(View view) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator top = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-ScreenUtil.getInstance().dip2px((int) C4820d.f19955a)), 0.0f});
        top.setDuration(300);
        top.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(top);
        return animatorSet;
    }

    public AnimatorSet createHideAnim(View view) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (getOrientation() == 2) {
            ObjectAnimator left = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) (-((ScreenUtil.getInstance().getHeightPixels() / 3) + ScreenUtil.getInstance().dip2px(36)))});
            left.setDuration(300);
            left.setInterpolator(new AccelerateInterpolator());
            animatorSet.play(left);
            return animatorSet;
        }
        ObjectAnimator top = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) (-ScreenUtil.getInstance().dip2px((int) C4820d.f19955a))});
        top.setDuration(300);
        top.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(top);
        return animatorSet;
    }

    public void setToolBoxStatus(int rgstate) {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().setToolBoxStatus(rgstate);
        }
    }

    public void closeToolbox() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().closeToolbox();
        }
    }

    public boolean isToolboxOpened() {
        if (this.mRGToolboxView != null) {
            return this.mRGToolboxView.getPresent().isToolboxOpened();
        }
        return false;
    }

    public boolean isToolboxScrolling() {
        if (this.mRGToolboxView != null) {
            return this.mRGToolboxView.isToolboxScrolling();
        }
        return false;
    }

    public void updateToolBoxStatus() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().updateViewStatus();
        }
    }

    public void updateToolBoxItem(int viewIndex) {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().updateToolBoxItemState(viewIndex);
        }
    }

    public void updateRoadCondition() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateRoadConditionBar();
        }
    }

    public void resetRoadConditionData() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.resetRoadConditionData();
        }
    }

    public void updateCarProgress() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateCarProgress();
        }
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateRoadConditionBarTimeInterval();
        }
    }

    public void updateAssistFullViewModeBtn() {
        if (this.mAssistGuideView != null) {
            this.mAssistGuideView.updateAssistFullViewModeBtn();
        }
    }

    @Deprecated
    public boolean isMenuVisible() {
        return false;
    }

    public void showSafetyShareLoading() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().showLoading("分享请求中...", new RGMapModeViewController$23(this));
        }
    }

    public void hideSafetyShareLoading() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().hideLoading();
        }
    }

    public void showReRoutePlanLoading(String tips) {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().showLoading(tips, new RGMapModeViewController$24(this));
        }
    }

    public void hideReRoutePlanView() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().hideLoading();
        }
    }

    public void showRouteSearchLoading() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().showLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_loading_route_poi), new RGMapModeViewController$25(this));
        }
    }

    public void hideRouteSearchLoading() {
        if (this.mRGToolboxView == null) {
            LogUtil.e("RouteGuide", "hideRouteSearchLoading return mRGToolboxView is null");
        } else {
            this.mRGToolboxView.getPresent().hideLoading();
        }
    }

    private void setRefreshButtonEnable(boolean enable) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.setRefreshButtonEnable(enable);
        }
    }

    public void showRefreshRoadProgess() {
        if (this.mRGToolboxView == null) {
            LogUtil.e("RouteGuide", "showRefreshRoadProgess return mRGToolboxView is null");
            return;
        }
        this.mRGToolboxView.getPresent().showLoading(BNStyleManager.getString(C4048R.string.nsdk_string_rg_refresh_loading_text), new RGMapModeViewController$26(this));
        setRefreshButtonEnable(false);
    }

    public void hideRefreshRoadProgess() {
        hideReRoutePlanView();
        setRefreshButtonEnable(true);
    }

    public void showStartYawing() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onStartYawing();
        }
    }

    public void hideYawingView() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onYawingComplete(true);
        }
    }

    public void showLoadingWhileWaitCal() {
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onRPWatting();
        }
    }

    public void hideWaitCalLoading() {
        if (RGSimpleGuideModel.getInstance().isYawing()) {
            LogUtil.e("RouteGuide", "hideWaitCalLoading return isYawing");
        } else if (this.mRGToolboxView != null) {
            this.mRGToolboxView.getPresent().onRPComplete();
        }
    }

    public boolean isAllowEnlargeMapShow() {
        if (!BNSettingManager.getPrefRealEnlargementNavi()) {
            LogUtil.e("RouteGuide", "get enlarge show setting not show");
            return false;
        } else if (RGRouteRecommendModel.getInstance().isViewCanShow) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow routeRecommend is show ");
            return false;
        } else if (RGViewController.getInstance().isMenuMoreVisible()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow isMenuMoreVisible is show ");
            return false;
        } else if (FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail BrowseMap");
            return false;
        } else if (!RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            return true;
        } else {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail isRouteSearchMode");
            return false;
        }
    }

    public void updateHighwayFsmSate(String state) {
        if (this.mHighwayView != null) {
            this.mHighwayView.updateHighwayFsmSate(state);
        }
    }

    public void showCurRoadNameView() {
        if (this.mCurRoadNameView == null) {
            this.mCurRoadNameView = new RGCurRoadNameView(this.mActivity, this.mRootViewGroup);
        }
        if (this.mCurRoadNameView != null) {
            this.mCurRoadNameView.show();
        }
    }

    public void hideCurRoadNameView() {
        if (this.mCurRoadNameView != null) {
            this.mCurRoadNameView.hide();
        }
    }

    public void isMoveCurRoadNameView(boolean isMove) {
        if (this.mCurRoadNameView == null) {
            return;
        }
        if (isMove) {
            this.mCurRoadNameView.moveRightView();
        } else {
            this.mCurRoadNameView.resetViewPosition();
        }
    }

    public void updateCurRoadName(String curRoadName) {
        if (this.mCurRoadNameView != null) {
            this.mCurRoadNameView.updateRoadName(curRoadName);
        }
    }

    public int getRootViewWidth() {
        if (this.mRootViewWidth == 0) {
            this.mRootViewWidth = ScreenUtil.getInstance().getWidthPixels();
        }
        return this.mRootViewWidth;
    }

    public int getmRootViewHeight() {
        if (this.mRootViewHeight == 0) {
            this.mRootViewHeight = ScreenUtil.getInstance().getHeightPixels();
        }
        return this.mRootViewHeight;
    }

    private void registRootViewSizeChange() {
        if (this.mParentViewGroup != null && VERSION.SDK_INT >= 11) {
            this.mParentViewGroup.addOnLayoutChangeListener(this.mLayoutSizeChangeLis);
        }
    }

    private void unRegistRootViewSizeChange() {
        if (this.mParentViewGroup != null && VERSION.SDK_INT >= 11) {
            this.mParentViewGroup.removeOnLayoutChangeListener(this.mLayoutSizeChangeLis);
        }
    }

    private void onSizeChanged() {
        LogUtil.e("RouteGuide", "onLayoutChange: w:" + this.mRootViewWidth + " h:" + this.mRootViewHeight);
        if (this.mRGToolboxView != null) {
            this.mRGToolboxView.onSizeChanged();
        }
    }

    public void showFuzzyGuideView(boolean fuzzy) {
        if (this.mSimpleGuideView != null) {
            this.mIsFuzzyMode = fuzzy;
            LogUtil.e("RouteGuide", "show fuzzy:" + fuzzy);
            if (!fuzzy) {
                updateNextRoadIfNeeded();
            }
            this.mSimpleGuideView.showFuzzyGuide(fuzzy);
            updateRGFloatView(null, false);
        }
    }

    private void updateNextRoadIfNeeded() {
        Bundle nextGuide = RGSimpleGuideModel.getInstance().getNextGuideInfo();
        String nextRoad = nextGuide.getString("road_name");
        int remainDist = nextGuide.getInt("road_name");
        if (TextUtils.isEmpty(nextRoad) && remainDist <= 0 && RGSimpleGuideModel.getInstance().isFirstGuideFuzzy()) {
            LogUtil.e("RouteGuide", "next guide info empty, and update top panel by gfgi");
            Bundle bundle = new Bundle();
            JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
            LogUtil.e("RouteGuide", "bundle: " + bundle.toString());
            int resId = bundle.getInt("resid", 0);
            remainDist = bundle.getInt(SimpleGuideInfo.RemainDist, 0);
            nextRoad = bundle.getString("road_name");
            if (resId > 0) {
                updateSimpleGuideInfo(RGSimpleGuideModel.getInstance().updateNextGuideInfo(resId, remainDist, nextRoad));
            }
        }
    }

    public boolean isFuzzyMode() {
        return this.mIsFuzzyMode;
    }

    public void updateVoiceModeBtn() {
        if (BNSettingManager.getVoiceMode() == 2) {
            this.mRGToolboxView.updateSettingStatus(5, 1);
        } else {
            this.mRGToolboxView.updateSettingStatus(5, 2);
        }
    }

    public void updatePanelView(boolean on) {
        if (this.mControlPanelView != null) {
            this.mControlPanelView.setTrafficStatus(on);
        }
    }

    public void setNaviDayAndNightMode(int mode) {
        if (this.mMenuMoreView != null) {
            this.mMenuMoreView.setNaviDayAndNightMode(mode);
        }
    }

    public void onEmptyPoiAction() {
        if (this.mSubViewListener != null) {
            this.mSubViewListener.onEmptyPoiAction();
        }
    }
}
