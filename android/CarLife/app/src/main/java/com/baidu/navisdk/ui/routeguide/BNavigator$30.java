package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.lightnavi.utils.LightNaviPageJumpHelper;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.ugc.control.UgcFeedbackController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.RouteGuideThread;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;

class BNavigator$30 implements OnRGSubViewListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$30(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onZoomoutAction() {
        UserOPController.getInstance().add(UserOPParams.COMMON_1_a);
        BNMapController.getInstance().setDragMapStatus(true);
        NMapControlProxy.getInstance().zoomOut();
        RGViewController.getInstance().autoHideControlPanelView(10000);
        BNMapController.getInstance().getMapController().SetInterruptAutoLevel(true);
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onZoomOutBtnClick();
        }
    }

    public void onZoominAction() {
        UserOPController.getInstance().add(UserOPParams.COMMON_1_9);
        BNMapController.getInstance().setDragMapStatus(true);
        NMapControlProxy.getInstance().zoomIn();
        RGViewController.getInstance().autoHideControlPanelView(10000);
        BNMapController.getInstance().getMapController().SetInterruptAutoLevel(true);
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onZoomOutBtnClick();
        }
    }

    public void onRouteDescWindowShow() {
    }

    public void onUGCMenuAction() {
        BNavigator.access$3100(this.this$0);
        if (RGViewController.getInstance().isUGCFBackMenuVisible()) {
            RGViewController.getInstance().onUgcDestroy();
            return;
        }
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_u, "2", null, null);
        RGViewController.getInstance().showUGCFBackMenu();
    }

    public void onRouteDescWindowHide() {
        RouteGuideFSM.getInstance().runInitialState(null);
    }

    public void onShowQuitNaviView() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            if (FsmState.RouteItem.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(FsmEvent.CONTINUE_NAVI);
                return;
            }
            UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "2", null, null);
            RGViewController.getInstance().showQuitNaviDialog(false);
        }
    }

    public void onQuitNaviGuide(boolean isStartWalkNaviNo, final boolean isSwitch) {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onQuitNaviGuide");
        PerformStatisticsController.peByType(7, "on_quit_nav_click", System.currentTimeMillis());
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "MapSwitchGLSurfaceView onQuitNaviGuide===========");
        BNWorkerCenter.getInstance().cancelTask(BNavigator.access$600(), false);
        BNWorkerCenter.getInstance().cancelTask(BNavigator.access$1500(this.this$0), false);
        BNWorkerCenter.getInstance().cancelTask(BNavigator.access$3200(this.this$0), false);
        int walkNaviDis = BNNaviResultController.getWalkNaviRemainDist();
        final boolean isStartWalkNavi = BNNaviResultController.needsToShowWalkNavi(walkNaviDis);
        BNNaviResultController.getInstance().updateShowWalkNaviState(isStartWalkNavi, walkNaviDis);
        ItemizedOverlayUtil.getInstance().removeAllItems();
        ItemizedOverlayUtil.getInstance().hide();
        BNMapController.getInstance().setNaviStatus(false);
        BNavigator.access$3300(this.this$0, isSwitch);
        RouteGuideThread.getInstance().getHandler().post(new Runnable() {
            public void run() {
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onQuitNaviGuide doTask bg start :" + isStartWalkNavi);
                if (isStartWalkNavi) {
                    if (isStartWalkNavi) {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_QUIT_START_WALKNAVI, NaviStatConstants.NAVI_QUIT_START_WALKNAVI);
                    } else {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_QUIT_NORMAL, NaviStatConstants.NAVI_QUIT_NORMAL);
                    }
                }
                BNavigator.access$3400(BNavigator$30.this.this$0, isSwitch, true);
                if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
                    UserOPController.getInstance().end();
                    CommonHandlerThread.getInstance().sendMessage(250);
                }
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onQuitNaviGuide doTask bg end");
            }
        });
        if (BNavigator.access$1000(this.this$0) != null) {
            PerformStatisticsController.peByType(7, "on_quit_nav_anim_end", System.currentTimeMillis());
            Bundle bd;
            if (isSwitch) {
                bd = new Bundle();
                bd.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, BNavConfig.pRGLocateMode);
                bd.putBoolean(BNavConfig.KEY_ROUTEGUIDE_WALKNAVI, false);
                bd.putBoolean(BNavConfig.KEY_ROUTEGUIDE_WANDA, false);
                BNavigator.access$1000(this.this$0).onPageJump(8, bd);
                BNRoutePlaner.getInstance().SetCalcRouteNetMode(1);
                BNLightNaviManager.getInstance().setSwitching(true);
                Bundle bundle = new Bundle();
                bundle.putBoolean("switch", true);
                LightNaviPageJumpHelper.getInstance().onPageJump(2, bundle);
            } else {
                bd = new Bundle();
                bd.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, BNavConfig.pRGLocateMode);
                bd.putBoolean(BNavConfig.KEY_ROUTEGUIDE_WALKNAVI, isStartWalkNavi);
                BNavigator.access$3502(this.this$0, BNRouteGuider.getInstance().isDestHitWanDa(false));
                LogUtil.m15791e(ModuleName.ROUTEGUIDE, "startNav  isWanda " + BNavigator.access$3500(this.this$0));
                bd.putBoolean(BNavConfig.KEY_ROUTEGUIDE_WANDA, BNavigator.access$3500(this.this$0));
                if (this.this$0.gotoUgcRelsutPage) {
                    bd.putBoolean(BNavConfig.KEY_ROUTEGUIDE_END_UGCRESULTPAGE, true);
                }
                BNavigator.access$1000(this.this$0).onPageJump(1, bd);
            }
            PerformStatisticsController.peByType(7, "on_quit_nav_end", System.currentTimeMillis());
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onQuitNaviGuide end");
        }
    }

    public void onOtherAction(int what, int arg1, int arg2, Object data) {
        if (what == 0) {
            if (arg1 == 0 || 1 != arg1) {
            }
        } else if (1 == what) {
        } else {
            if (2 == what) {
                if (arg2 == 0) {
                    if (1 == arg1) {
                        RGViewController.getInstance().showCommentRouteView();
                    } else if (arg1 == 0) {
                        RGViewController.getInstance().hideCommentRouteView();
                    }
                } else if (1 == arg1) {
                    if (BNavigator.access$1000(this.this$0) != null) {
                        BNavigator.access$1000(this.this$0).notifyOtherAction(101, 4, ((Integer) data).intValue(), this.this$0.mRGSubViewListener);
                    }
                } else if (arg1 == 0 && BNavigator.access$1000(this.this$0) != null) {
                    BNavigator.access$1000(this.this$0).notifyOtherAction(101, 5, ((Integer) data).intValue(), this.this$0.mRGSubViewListener);
                }
            } else if (7 == what) {
                RGViewController.getInstance().showCommentLoading(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_rpc_feedback_loading));
            } else if (8 == what) {
                RGViewController.getInstance().dismissCommentLoading(arg1);
                if (arg1 == 0) {
                    TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_rpc_feedback_success));
                } else if (1 == arg1) {
                    TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_rpc_feedback_failure));
                }
            } else if (3 == what) {
                this.this$0.enterNavState();
                if (BNavigator.access$3000(this.this$0) != null) {
                    BNavigator.access$3000(this.this$0).onZoomOutBtnClick();
                }
            } else if (4 == what) {
                RGViewController.getInstance().showAssistView();
                RGViewController.getInstance().showUserRightView();
            } else if (5 == what) {
                if (arg1 == 0) {
                    BNavigator.access$1000(this.this$0).onPageJump(3, Integer.valueOf(0));
                } else if (1 == arg1) {
                    RGMapModeViewController.getInstance().showRefreshRoadProgess();
                    BNRouteGuider.getInstance().calcOtherRoute(2, 1);
                } else if (2 == arg1) {
                    if (this.this$0.mRGSubViewListener != null) {
                        this.this$0.mRGSubViewListener.onQuitNaviGuide(false, false);
                    }
                    this.this$0.quitNav(false);
                    BNavigator.access$1000(this.this$0).onPageJump(5, Integer.valueOf(0));
                } else if (3 == arg1) {
                    BNavigator.sCanBackgroundSpeak = false;
                    BNavigator.access$1000(this.this$0).onPageJump(7, Integer.valueOf(0));
                }
            } else if (6 == what) {
                boolean open = arg2 == 1;
                switch (arg1) {
                    case 0:
                        BNSettingManager.setVoiceMode(arg2);
                        this.this$0.updateRGEngineSpeekStatus();
                        if (arg2 == 2) {
                            RGViewController.getInstance().updateLowVolumeView(true);
                            return;
                        } else if (AudioUtils.getCurrentVolume(BNavigator.access$1100(this.this$0)) > 0) {
                            RGViewController.getInstance().updateLowVolumeView(false);
                            return;
                        } else {
                            return;
                        }
                    case 1:
                        BNSettingManager.setElecCameraSpeakEnable(open);
                        BNRouteGuider.getInstance().setElecCameraSpeak(open);
                        return;
                    case 2:
                        BNSettingManager.setSpeedCameraSpeakEnable(open);
                        BNRouteGuider.getInstance().setSpeedCameraSpeak(open);
                        return;
                    case 3:
                        BNSettingManager.setSaftyDriveSpeakEnable(open);
                        BNRouteGuider.getInstance().setSaftyDriveSpeak(open);
                        return;
                    case 4:
                        BNSettingManager.setRoadConditionpeakEnable(open);
                        BNRouteGuider.getInstance().setRoadConditionSpeak(open);
                        return;
                    case 5:
                        BNSettingManager.setStraightDirectSpeakEnable(open);
                        BNRouteGuider.getInstance().setStraightDirectSpeak(open);
                        return;
                    default:
                        return;
                }
            } else if (9 == what) {
                int currentPrefer = BNRoutePlaner.getInstance().getCalcPreference();
                if (RGCarPreferSettingController.getInstance().isRPPreferSettingValueChange(currentPrefer)) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_a, Integer.toString(currentPrefer), "1", null);
                    RGEngineControl.getInstance().reCalcRoute();
                    return;
                }
                String key = (String) data;
                if (key == ActionTypeSearchParams.Gas_Station) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "1", null, null);
                } else if (key == ActionTypeSearchParams.Bank) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "2", null, null);
                } else if (key == ActionTypeSearchParams.Toilet) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "3", null, null);
                } else if (key == ActionTypeSearchParams.Spots) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "4", null, null);
                } else if (key == ActionTypeSearchParams.Hotel) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, C2578b.f8568g, null, null);
                } else if (key == ActionTypeSearchParams.Restaurant) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "5", null, null);
                } else if (key == ActionTypeSearchParams.Service) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, "7", null, null);
                } else if (key == ActionTypeSearchParams.Park) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_3, NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL, null, null);
                }
                if (ActionTypeSearchParams.Gas_Station.equals(key)) {
                    String gasStationPreference = BNSettingManager.getGasStationPreference();
                    if (TextUtils.isEmpty(gasStationPreference)) {
                        BNavigator.access$2702(this.this$0, false);
                        RGRouteSearchModel.getInstance().setmLastKey(key);
                        this.this$0.routeSearchKeywords(key, BNavigator.access$3600(this.this$0));
                        return;
                    }
                    BNavigator.access$2702(this.this$0, true);
                    RGRouteSearchModel.getInstance().setmLastKey(gasStationPreference);
                    this.this$0.routeSearchKeywords(gasStationPreference, BNavigator.access$3600(this.this$0));
                    return;
                }
                BNavigator.access$2702(this.this$0, false);
                RGRouteSearchModel.getInstance().setmLastKey(key);
                this.this$0.routeSearchKeywords(key, BNavigator.access$3600(this.this$0));
            } else if (10 == what) {
                if (BNavigator.access$3700() != null) {
                    BNavigator.access$3700().onRemoveVia((RoutePlanNode) data);
                }
            } else if (11 == what) {
                if (BNavigator.access$1000(this.this$0) != null) {
                    BNavigator.access$1000(this.this$0).notifyOtherAction(6, 0, 0, data);
                }
            } else if (12 == what) {
                String urlStr = null;
                switch (arg1) {
                    case 0:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_p, "1", null, null);
                        urlStr = UgcFeedbackController.getInstance().getNaviUgcURLString(8192, 1);
                        break;
                    case 1:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_p, "2", null, null);
                        urlStr = UgcFeedbackController.getInstance().getNaviUgcURLString(8193, 1);
                        break;
                    case 2:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_p, "3", null, null);
                        urlStr = UgcFeedbackController.getInstance().getNaviUgcURLString(8194, 1);
                        break;
                    case 3:
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_p, "4", null, null);
                        urlStr = UgcFeedbackController.getInstance().getNaviUgcURLString(8195, 1);
                        break;
                }
                if (urlStr == null || BNavigator.access$1700(this.this$0) == null) {
                    LogUtil.m15791e(ModuleName.ROUTEGUIDE, "urlStr is null Exception");
                } else {
                    BNavigator.sCanBackgroundSpeak = false;
                    BNavigator.access$1700(this.this$0).onUgcPageShow(8195, urlStr);
                }
                if (!RGViewController.getInstance().isUGCFBackMenuVisible()) {
                }
            } else if (13 == what) {
                if (BNavigator.access$1000(this.this$0) != null) {
                    BNavigator.access$1000(this.this$0).notifyOtherAction(105, 1, 1, null);
                }
                if (BNavigator.access$3000(this.this$0) != null) {
                    BNavigator.access$3000(this.this$0).onSetingBtnClick();
                }
            } else if (14 == what) {
                if (BNavigator.access$1000(this.this$0) != null) {
                    BNavigator.access$1000(this.this$0).notifyOtherAction(106, 1, 1, null);
                }
                if (BNavigator.access$3000(this.this$0) != null) {
                    BNavigator.access$3000(this.this$0).onViaPointBtnClick();
                }
            }
        }
    }

    public void onMoreMenuAction() {
    }

    public void onRouteSortAction() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                int netMode = BNRoutePlaner.getInstance().getRoutePlanNetMode();
                int engineNetMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
                if (netMode == 1 && (engineNetMode == 0 || engineNetMode == 2)) {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "离线导航路线偏好不可用");
                    return;
                } else if (RGViewController.getInstance().isRouteSortViewVisible()) {
                    RGViewController.getInstance().hideRouteSortView();
                    return;
                } else {
                    RGViewController.getInstance().showRouteSortView();
                    return;
                }
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "网络连接不可用");
        }
    }

    public void onJudgePreferWithMenuHide() {
        int currentPrefer = BNRoutePlaner.getInstance().getCalcPreference();
        boolean isPreferChange = RGCarPreferSettingController.getInstance().isRPPreferSettingValueChange(currentPrefer);
        if (RGMapModeViewController.getInstance().checkMenuMoreViewPlateChanged()) {
            RGSimpleGuideModel.mCalcRouteType = 3;
        }
        if (isPreferChange || RGMapModeViewController.getInstance().checkMenuMoreViewPlateChanged()) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onJudgePreferWithMenuHide() --> reCalcRoute()");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_a, Integer.toString(currentPrefer), "1", null);
            RGEngineControl.getInstance().reCalcRoute();
        }
    }

    public void onMenuSelectedRoutePlan() {
        if (BNavigator.access$1000(this.this$0) != null) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("onMenuSelectedRoutePlan-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNavigator.access$1000(BNavigator$30.this.this$0).onPageJump(3, null);
                    return null;
                }
            }, new BNWorkerConfig(2, 0));
        }
    }

    public void onMenuSelectedRouteDetail() {
    }

    public void onMainAuxiliarySwitch() {
        BNRouteGuider.getInstance().refreshRoute();
        TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), BNStyleManager.getString(C4048R.string.nsdk_string_main_auxiliary_switch));
    }

    public void onLocationAction() {
        MapStatus st;
        switch (RGControlPanelModel.getInstance().getLocateStatus()) {
            case 1:
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, null, "", "1");
                if (BNavConfig.pRGLocateMode == 2) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_NORTH, NaviStatConstants.NAVIGATION_NORTH);
                    NaviStatItem.getInstance().setStartNorthTime();
                    RouteGuideFSM.getInstance().cacheBackMapState(FsmState.North2D);
                    BNSettingManager.setMapMode(2);
                    RGControlPanelModel.getInstance().updateLocateStatus(2);
                    BNRouteGuider.getInstance().setRotateMode(1);
                    st = NMapControlProxy.getInstance().getMapStatus();
                } else {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_NORTH, NaviStatConstants.NAVIGATION_NORTH);
                    NaviStatItem.getInstance().setStartNorthTime();
                    RouteGuideFSM.getInstance().cacheBackMapState(FsmState.North2D);
                    BNSettingManager.setMapMode(2);
                    RGControlPanelModel.getInstance().updateLocateStatus(2);
                    BNRouteGuider.getInstance().setRotateMode(1);
                    st = NMapControlProxy.getInstance().getMapStatus();
                }
                if (st != null) {
                    st._Rotation = 1;
                    st._Overlooking = 0;
                    if (1 == RGCacheStatus.sOrientation) {
                        st._Xoffset = 0;
                        st._Yoffset = (long) (0 - ScreenUtil.getInstance().dip2px(64));
                    } else if (2 == RGCacheStatus.sOrientation) {
                        st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.1d));
                    }
                    st._Level = -1.0f;
                    NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationNone);
                    return;
                }
                return;
            case 2:
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_1, "", null, "1");
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_FOLLOW, NaviStatConstants.NAVIGATION_FOLLOW);
                NaviStatItem.getInstance().setNorthRealTime();
                RouteGuideFSM.getInstance().cacheBackMapState(FsmState.Car3D);
                BNSettingManager.setMapMode(1);
                RGControlPanelModel.getInstance().updateLocateStatus(1);
                BNRouteGuider.getInstance().setRotateMode(0);
                st = NMapControlProxy.getInstance().getMapStatus();
                if (st != null) {
                    st._Rotation = (int) BNRouteGuider.getInstance().GetCarRotateAngle();
                    st._Overlooking = -45;
                    if (1 == RGCacheStatus.sOrientation) {
                        st._Xoffset = 0;
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getHeightPixels()) * 0.25d));
                    } else if (2 == RGCacheStatus.sOrientation) {
                        st._Xoffset = (long) (ScreenUtil.getInstance().getHeightPixels() / 6);
                        st._Yoffset = (long) (0.0d - (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.25d));
                    }
                    st._Level = -1.0f;
                    NMapControlProxy.getInstance().setMapStatus(st, AnimationType.eAnimationNone);
                    return;
                }
                return;
            case 3:
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_ORIENTATE, NaviStatConstants.NAVIGATION_ORIENTATE);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_9);
                this.this$0.enterNavState();
                return;
            case 4:
                onShowQuitNaviView();
                return;
            default:
                return;
        }
    }

    public void onFullviewAction() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            this.this$0.enterFullViewState();
        }
    }

    public void onEnlargeRoadMapShowStart() {
    }

    public void onEnlargeRoadMapShowEnd() {
    }

    public void onEnlargeRoadMapImgTouch() {
        RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_ENLARGE_ROAD_MAP);
    }

    public void onEnlargeRoadMapHideStart() {
    }

    public void onEnlargeRoadMapHideEnd() {
    }

    public void onAnologControlAction(boolean isCurPlaying) {
        boolean z = false;
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            if (isCurPlaying) {
                BNRouteGuider.getInstance().pauseRouteGuide();
            } else {
                BNRouteGuider.getInstance().resumeRouteGuide();
                RGViewController.getInstance().switchAnologNaviControlState(false);
            }
            RGViewController.getInstance().switchAnologNaviControlState(isCurPlaying);
            RGControlPanelModel instance = RGControlPanelModel.getInstance();
            if (!isCurPlaying) {
                z = true;
            }
            instance.updateAnologPlaying(z);
        }
    }

    public void onITSAction(boolean openITS) {
        GeoPoint screenCenter = BNMapController.getInstance().getGeoPosByScreenPos(ScreenUtil.getInstance().getWidthPixels() / 2, ScreenUtil.getInstance().getHeightPixels() / 2);
        DistrictInfo district = null;
        if (screenCenter != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            district = BNPoiSearcher.getInstance().getDistrictByPoint(screenCenter, 0);
        }
        if (!openITS || BNSettingManager.isRoadCondOnOrOff()) {
            if (!openITS && PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getBoolean("NAVI_ROADCOND_ON_OFF", false)) {
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setRoadCondOnOff(false);
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_is_off));
            }
        } else if (BNSettingManager.isNaviRealHistoryITS()) {
            if (BNSettingManager.isFirstItsOn() && !NetworkUtils.isTypeNetworkAvailable(BNavigator.access$1100(this.this$0), 1)) {
                BNSettingManager.setFirstItsOn(false);
                RGViewController.getInstance().showFirstItsDialog();
            }
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                BNMapController.getInstance().showTrafficMap(true);
                BNSettingManager.setRoadCondOnOff(true);
                if (district == null || BNMapController.getInstance().checkRoadConditionSupport(district.mId)) {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_is_on));
                    return;
                } else {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(C4048R.string.nsdk_string_its_online_missing_data));
                    return;
                }
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
        }
    }

    public void onDayNightModeSettingChange(int mode) {
        BNSettingManager.setNaviDayAndNightMode(mode);
    }

    public void onRefreshRoadAction() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            BNavigator.access$3100(this.this$0);
            if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                BNavigator.access$3800(this.this$0);
                this.this$0.enterNavState();
            }
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "AssistantIconUpdate showAvoidTrafficView:");
            if (NetworkUtils.isNetworkAvailable(BNavigator.access$000(this.this$0))) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_h);
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_AVOID_TRAFFIC_REFRESH, NaviStatConstants.NAVI_AVOID_TRAFFIC_REFRESH);
                RGMapModeViewController.getInstance().showRefreshRoadProgess();
                BNRouteGuider.getInstance().calcOtherRoute(2, 1);
                XDVoiceInstructManager.getInstance().setWakeupEnable(false);
                return;
            }
            TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_avoid_traffic_network_failture));
        }
    }

    public void onMoreRouteSearchAction() {
        int netMode = BNRoutePlaner.getInstance().getRoutePlanNetMode();
        int engineNetMode = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
        if (netMode == 1 && (engineNetMode == 0 || engineNetMode == 2)) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "离线导航路沿途搜索不可用");
            return;
        }
        RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(BNRoutePlaner.getInstance().getCalcPreference());
        RGViewController.getInstance().showRouteSearchView();
    }

    public void onMenuMoreAction() {
        if (!RGViewController.getInstance().isMenuMoreVisible()) {
            RGViewController.getInstance().showMenuMoreView();
        } else if (RGViewController.getInstance().menuMoreViewCloseAble()) {
            RGViewController.getInstance().hideMenuMoreView();
            onJudgePreferWithMenuHide();
        } else {
            return;
        }
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onMoreMenuClick();
        }
    }

    public void onCarLogoAction() {
        if (BNavigator.access$1700(this.this$0) != null) {
            BNavigator.sCanBackgroundSpeak = false;
            BNavigator.access$1700(this.this$0).onCarLogoPageShow();
        }
    }

    public void onEmptyPoiAction() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_f);
        BNavigator.access$3100(this.this$0);
        BNavigator.access$3800(this.this$0);
        RGMapModeViewController.getInstance().cancleAutoHideControlPanel();
        this.this$0.enterNavState();
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onEmptyPoiClick();
        }
    }

    public void onCancelLoading() {
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onCancelLoading");
        CommandCenter.getInstance().cancelRequestBySubSystem(1);
    }

    public void onUgcChangeRoadAction() {
    }

    public void onOnlineMainAuxiliarySwitch(int changeType) {
        BNRouteGuider.getInstance().onlineChangeRoute(changeType);
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onMASwitchClick();
        }
    }

    public void onParkSearchAction() {
        if (!ForbidDaulClickUtils.isFastDoubleClick(500)) {
            if (RGControlPanelModel.getInstance().ismIsParkSearching()) {
                RGControlPanelModel.getInstance().setmIsParkSearching(false);
                BNWorkerCenter.getInstance().cancelTask(BNavigator.access$3900(this.this$0), false);
                BNWorkerCenter.getInstance().cancelTask(BNavigator.access$4000(this.this$0), false);
                RGViewController.getInstance().hideParkPointView();
                RGParkPointModel.getInstance().setmIsParkPointShow(false);
                BNMapController.getInstance().showLayer(4, false);
                BNMapController.getInstance().updateLayer(4);
                if (!RGControlPanelModel.getInstance().getFullviewState()) {
                    this.this$0.RecoveryLevelAfterParkSerach();
                    return;
                }
                return;
            }
            BNavigator.access$2600(this.this$0, 0);
        }
    }

    public void onMultiRouteSwitchAction() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            LogUtil.m15791e(ModuleName.ROUTEGUIDE, "onMultiRouteSwitchAction");
            if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_5, null, "", null);
            } else {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_5, "", null, null);
            }
            BNRoutePlaner.getInstance().selectRoute(RGMultiRouteModel.getInstance().mSelectedRouteIndex);
            BNMapController.getInstance().updateLayer(10);
            BNMapController.getInstance().clearLayer(23);
            if (BNavigator.access$3000(this.this$0) != null) {
                BNavigator.access$3000(this.this$0).onMASwitchClick();
            }
        }
    }

    public void onRouteRecommendSwitchOk() {
        this.this$0.actionRouteRecommendClick(true, false);
    }

    public void onRouteRecommendSwitchCancel() {
        this.this$0.actionRouteRecommendClick(false, false);
    }

    public void onMainAuxiliaryShow() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onMainAuxiliaryShow();
        }
    }

    public void onMainAuxiliaryHide() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onMainAuxiliaryHide();
        }
    }

    public void onEnlargeRoadMapViewShow() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onEnlargeRoadMapViewShow();
        }
    }

    public void onEnlargeRoadMapViewHide() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onEnlargeRoadMapViewHide();
        }
    }

    public void onNaviLeftPanelTouch() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onNaviLeftPanelTouch();
        }
    }

    public void onFocusMoreMenu() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onFocusMoreMenu();
        }
    }

    public void onZoomInGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onZoomInGetFocus();
        }
    }

    public void onZoomOutGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onZoomOutGetFocus();
        }
    }

    public void onFocusMoreMenuGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onFocusMoreMenuGetFocus();
        }
    }

    public void onFullOrResumeGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onFullOrResumeGetFocus();
        }
    }

    public void onLocationGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onLocationGetFocus();
        }
    }

    public void onQuitGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onQuitGetFocus();
        }
    }

    public void onSetingGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onSetingGetFocus();
        }
    }

    public void onViaPointGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onViaPointGetFocus();
        }
    }

    public void onResumeNavigatorGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onResumeNavigatorGetFocus();
        }
    }

    public void onRouteSwitchGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onRouteSwitchGetFocus();
        }
    }

    public void onEmptyPoiGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onEmptyPoiGetFocus();
        }
    }

    public void onMASwitchGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onMASwitchGetFocus();
        }
    }

    public void onBridgeSwitchGetFocus() {
        if (BNavigator.access$3000(this.this$0) != null) {
            BNavigator.access$3000(this.this$0).onBridgeSwitchGetFocus();
        }
    }
}
