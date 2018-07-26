package com.baidu.baidunavis.ui;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams.BackBundle;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.BNRouteGuideDialogManager;
import com.baidu.baidunavis.control.NavAoiRender;
import com.baidu.baidunavis.control.NavComponentController;
import com.baidu.baidunavis.control.NavDayNightController;
import com.baidu.baidunavis.control.NavDayNightController.OnDayNightChangedListener;
import com.baidu.baidunavis.control.NavItemizedOverlayUtil;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.logic.C1772k;
import com.baidu.carlife.logic.voice.C1903m;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.p086j.C1612a;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.view.dialog.C0770k;
import com.baidu.carlife.view.dialog.C2282f;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.navi.adapter.NaviRouteSearchAdapter;
import com.baidu.navi.adapter.NaviSettingDialogAdapter;
import com.baidu.navi.controller.BottomTabDisplayController;
import com.baidu.navi.track.TrackCarDataSolveModel;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SensorData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator$OnNaviBeginListener;
import com.baidu.navisdk.ui.routeguide.IBNavigatorListener;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController$VolumeChangeListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationShowFocusListener;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SystemAuth.IOnRequestAuthrityListener;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

public class BNRouteGuideFragment extends CarNaviMapPage {
    protected static final long WATCH_EXIT_TIME = 1500;
    protected static boolean isStopedByWatch = false;
    protected static long sWatchEixtTime = 0;
    private Object mArg = null;
    private IBNavigatorListener mBNavigatorListener = new C08934();
    private View mBridgeView;
    private BNRouteGuideDialogManager mDialogManager;
    private long mExitTime = 0;
    private C1443g mFocusAreaLeft;
    private C1443g mFocusAreaUp;
    private final Handler mHandler = new Handler();
    private boolean mIsNaviBegin = false;
    private int mJumpTiming = -1;
    private View mMAView;
    private View mMapControllView;
    private NaviRouteSearchAdapter mNaviRouteSearchAdapter = null;
    private C2282f mNaviRouteSearchDialog = null;
    private C2282f mNaviSettingDialog = null;
    private NaviSettingDialogAdapter mNaviSettingDialogAdapter = null;
    private long mNaviStartTime;
    private boolean mNotificationShow;
    private NotificationShowFocusListener mNotificationShowFocusListener = new C08923();
    private OnDayNightChangedListener mOnDayNightChangedListener = new C08967();
    private BNavigator$OnNaviBeginListener mOnNaviBeginListener = new C08912();
    private OnKeyListener mPickPointOnKeyListener = new OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                View focus;
                switch (keyCode) {
                    case 300:
                        if (!(BNRouteGuideFragment.this.mContentView == null || BNRouteGuideFragment.this.mViewConfirm == null)) {
                            focus = BNRouteGuideFragment.this.mContentView.findFocus();
                            if (focus != null && focus.equals(BNRouteGuideFragment.this.mViewConfirm)) {
                                BNRouteGuideFragment.this.handleBkgClick(RGRouteSearchModel.getInstance().getLastBkgItemId() + 1);
                                return true;
                            }
                        }
                    case 301:
                        if (!(BNRouteGuideFragment.this.mContentView == null || BNRouteGuideFragment.this.mViewCancel == null)) {
                            focus = BNRouteGuideFragment.this.mContentView.findFocus();
                            if (focus != null && focus.equals(BNRouteGuideFragment.this.mViewCancel)) {
                                BNRouteGuideFragment.this.handleBkgClick(RGRouteSearchModel.getInstance().getLastBkgItemId() - 1);
                                return true;
                            }
                        }
                }
            }
            return false;
        }
    };
    private View mQuitLoading;
    private View mRefresh;
    private View mSetViaView;
    private View mViewCancel;
    private View mViewChange;
    private View mViewClear;
    private View mViewConfirm;
    private View mViewContinue;
    private View mViewContinue2;
    private View mViewExit;
    private View mViewMap;
    private View mViewSetting;
    private RGMapModeViewController$VolumeChangeListener mVolumeChangeListener = new C08901();
    private View mZoomIn;
    private View mZoomOut;
    private int poiListSize = -1;

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$1 */
    class C08901 implements RGMapModeViewController$VolumeChangeListener {
        C08901() {
        }

        public int onVolumeUpKeyDown(AudioManager audioManager, int maxVolume) {
            return BNRouteGuideFragment.this.adjustVolumeUpKeyDown(audioManager, maxVolume);
        }

        public int onVolumeDownKeyDown(AudioManager audioManager, int maxVolume) {
            return BNRouteGuideFragment.this.adjustVolumeDownKeyDown(audioManager, maxVolume);
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$2 */
    class C08912 implements BNavigator$OnNaviBeginListener {
        C08912() {
        }

        public void onNaviBegin(String s) {
            BaiduNaviManager.getInstance().notifyNaviBeginChanged(s);
            if (!"0".equals(s)) {
            }
        }

        public void onRoadInfoUpdate(String roadInfo) {
            NavMapAdapter.getInstance().setUgcInfo(roadInfo);
        }

        public void onArriveDest() {
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$3 */
    class C08923 implements NotificationShowFocusListener {
        C08923() {
        }

        public void show() {
            BNRouteGuideFragment.this.mNotificationShow = true;
            BNRouteGuideFragment.this.onInitFocus();
        }

        public void hide() {
            BNRouteGuideFragment.this.mNotificationShow = false;
            BNRouteGuideFragment.this.onInitFocus();
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$4 */
    class C08934 implements IBNavigatorListener {
        C08934() {
        }

        public void onYawingRequestSuccess() {
            NavAoiRender.INSTANCE.renderAoiByStartBid();
        }

        public void onYawingRequestStart() {
            C1903m.m7252a().m7255b();
        }

        public void onPageJump(int jumpTiming, Object arg) {
            if (1 == jumpTiming || 2 == jumpTiming) {
                if (BNRouteGuideFragment.this.mJumpTiming == -1) {
                    C1612a.m5884a().m5891a(false);
                    C1772k.m6480a().m6485a(2, 0);
                    C1261k.m4461b(506);
                    long routeGuideTime = System.currentTimeMillis() - BNRouteGuideFragment.this.mNaviStartTime;
                    StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.NAVI_0017, StatisticConstants.HOME_MAP_NAVI_STATUS_TIME, (int) routeGuideTime);
                    if (!NavTrajectoryController.hasConnected) {
                        StatisticManager.onEventDuration(C1157a.m3876a(), StatisticConstants.NAVI_0031, StatisticConstants.HOME_MAP_NAVI_STATUS_TIME, (int) routeGuideTime);
                    }
                    if (routeGuideTime >= 18000000) {
                        StatisticManager.onEvent(StatisticConstants.NAVI_0018, StatisticConstants.NAVI_0018);
                    }
                }
                if (BNRouteGuideFragment.this.isCarlifeFragment(BNRouteGuideFragment.this.getCurrentFragmentType())) {
                    BNRouteGuideFragment.this.mJumpTiming = jumpTiming;
                    BNRouteGuideFragment.this.mArg = arg;
                    NavRouteGuideController.getInstance().setBNavigatorListener(null);
                    return;
                }
            }
            if (7 != jumpTiming) {
                if (arg != null && (arg instanceof Bundle)) {
                    Bundle bd = (Bundle) arg;
                    RouteNode endNode = NavRoutePlanModel.getInstance().getEndRouteNode();
                    if (endNode != null) {
                        endNode.mBusinessPoi = bd.getBoolean(BNavConfig.KEY_ROUTEGUIDE_WANDA, false) ? 1 : 0;
                        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
                    }
                }
                if (1 == jumpTiming || 2 == jumpTiming) {
                    String endName = RGHighwayModel.getInstance().getCurRoadName();
                    if (endName == null || endName.length() == 0) {
                        endName = "未知点";
                    }
                    if (NavTrajectoryController.getInstance().endRecord(endName, true, 1) == 0) {
                        NavLogUtils.m3003e("RouteGuideActivityWrapper", "end record ok 2.");
                        BusinessActivityManager.getInstance().uploadData(null, 1501);
                    } else {
                        NavLogUtils.m3003e("RouteGuideActivityWrapper", "failed to end record 2.");
                    }
                    BaiduNaviManager.getInstance().mLastestQuitNaviTime = System.currentTimeMillis();
                    BNavigator.getInstance().setOnNaviBeginListener(null);
                    BNavigator.getInstance().setRequestAuthrityListener(null);
                    BNRouteGuideFragment.this.exit();
                    if (-1 == BNRouteGuideFragment.this.mJumpTiming) {
                        NavRouteGuideController.getInstance().onPageJump(jumpTiming, arg);
                    }
                    if (BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
                        BNLightNaviSwitchManager.getInstance().unInit();
                    }
                    NavTrajectoryController.getInstance().setEndNaviByOpenApi(false);
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_DRIVING_CAR_ARRIVE_DEST).sendToTarget();
                    }
                }
                NavCommonFuncModel.sIsAnologNavi = false;
                BNRouteGuideFragment.this.mJumpTiming = -1;
                BNRouteGuideFragment.this.mArg = null;
            }
        }

        public void notifyGPSStatusData(int arg0) {
        }

        public void notifyLoacteData(LocData arg0) {
        }

        public void notifyNmeaData(String arg0) {
        }

        public void notifySensorData(SensorData arg0) {
        }

        public void notifyStartNav() {
            NavRouteGuideController.getInstance().dismissWaitProgressDialog();
            LogUtil.e("RoutePlan", "notifyStartNav");
            BNRouteGuideFragment.this.delayInitModule();
            NavAoiRender.INSTANCE.renderAoiByStartBid();
            C1261k.m4453a(505, 3000);
            C1612a.m5884a().m5891a(true);
        }

        public void notifyViewModeChanged(int arg0) {
        }

        public void notifyOtherAction(int arg0, int arg1, int arg2, Object arg3) {
            LogUtil.e("RoutePlan", "notifyOtherAction arg0: " + arg0 + " arg1: " + arg1 + " arg3: ");
            if (105 == arg0) {
                BNRouteGuideFragment.this.showNaviSettingDialog();
            } else if (106 == arg0) {
                StatisticManager.onEvent(StatisticConstants.NAVI_0021);
                BNRouteGuideFragment.this.showNaviRouteSearchDialog();
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$5 */
    class C08945 implements IJumpToDownloadListener {
        C08945() {
        }

        public void onJumpToDownloadOfflineData() {
            BNavigator.getInstance().quitNav(false);
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$6 */
    class C08956 implements IOnRequestAuthrityListener {
        C08956() {
        }

        @SuppressLint({"NewApi"})
        public boolean onRequestAuthrity(String authType, int source, Bundle arg2) {
            return false;
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$7 */
    class C08967 implements OnDayNightChangedListener {
        C08967() {
        }

        public void onDayNightChanged(boolean isDay) {
            BNMapController.getInstance().setNightMode(!isDay);
            BNavigator.getInstance().onUpdateStyle(isDay);
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$8 */
    class C08978 implements OnItemClickListener {
        C08978() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            BNRouteGuideFragment.this.onRouteSearchListViewItemClick(position);
        }
    }

    /* renamed from: com.baidu.baidunavis.ui.BNRouteGuideFragment$9 */
    class C08989 implements C0770k {
        C08989() {
        }

        public void onDismiss() {
            BottomTabDisplayController.getInstance().panelHide();
        }

        public void onShow() {
            BottomTabDisplayController.getInstance().panelShow();
        }
    }

    public int getPageType() {
        return 1;
    }

    public String getPageClsName() {
        return BNRouteGuideFragment.class.getName();
    }

    public boolean isMapPage() {
        return true;
    }

    public boolean forbidsConfigurationChange() {
        return false;
    }

    public boolean is3DGestureEnable() {
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sPoiToNaviTime11 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("11", PerformStatItem.PoiToNaviStep11, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime10, PerformStatItem.sPoiToNaviTime11);
            PerformStatItem.sRoutePageToNaviTime5 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("5", "页面周期开始函数", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sRoutePageToNaviTime4, PerformStatItem.sRoutePageToNaviTime5);
        }
    }

    public View onCreateContentView(LayoutInflater inflater) {
        int i;
        boolean z = false;
        BaseTTSPlayer.getInstance().setEnableTimeOut(true);
        BaseTTSPlayer.getInstance().setTTSVocoderParam();
        String str = "BNRouteGuideActivityWrapper";
        StringBuilder append = new StringBuilder().append("updateAccountInfoWhenLoginSuccess()  updateUserInfo, bduss=").append(NavMapAdapter.getInstance().getBduss()).append(", uid=").append(NavMapAdapter.getInstance().getUid()).append(", islogin=");
        if (NavMapAdapter.getInstance().isLogin()) {
            i = 1;
        } else {
            i = 0;
        }
        NavLogUtils.m3003e(str, append.append(i).toString());
        try {
            JNITrajectoryControl jNITrajectoryControl = JNITrajectoryControl.sInstance;
            String bduss = NavMapAdapter.getInstance().getBduss();
            String uid = NavMapAdapter.getInstance().getUid();
            if (NavMapAdapter.getInstance().isLogin()) {
                i = 1;
            } else {
                i = 0;
            }
            jNITrajectoryControl.updateUserInfo(bduss, uid, i);
        } catch (Throwable th) {
        }
        Bundle bundle = this.mShowBundle;
        if (bundle != null && bundle.containsKey(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE)) {
            boolean z2;
            int anolog = bundle.getInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 2);
            if (anolog == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            NavCommonFuncModel.sIsAnologNavi = z2;
            if (C1663a.m5979a().m5993N() && anolog == 1 && C1609a.m5871a().m5880b() && C1609a.m5871a().m5882d() && C1609a.m5871a().m5881c()) {
                bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, 5);
                NavRouteGuideController.getInstance().setLocateMode(5);
            }
        }
        NavRouteGuideController.getInstance().setNavUserBehaviourCallback();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE, 1);
        this.mDialogManager = new BNRouteGuideDialogManager(NavMapAdapter.getInstance().getContext(), this);
        RGViewController.getInstance().setRouteGuideDialogManagerInterface(this.mDialogManager.getRouteGuideDialogManagerInterface());
        View navigatorView = BNavigator.getInstance().init(mActivity, bundle, null);
        if (navigatorView == null) {
            super.goBack();
            return null;
        }
        RGNotificationController.getInstance().setNotificationShowFocusListener(this.mNotificationShowFocusListener);
        if (!C1663a.m5979a().m5993N()) {
            TrackCarDataSolveModel.setCarlifeStatisticsInfo(null);
        }
        BNLightNaviManager.getInstance().setSwitching(false);
        BNRoutePlaner.getInstance().setObserver(new RoutePlanObserver(new C08945()));
        BNavigator.getInstance().setListener(this.mBNavigatorListener);
        BNavigator.getInstance().setOnNaviBeginListener(this.mOnNaviBeginListener);
        Bundle bd = new Bundle();
        bd.putString("clbduss", NavMapAdapter.getInstance().getBduss());
        String str2 = "bNormol";
        if (BNSettingManager.getVoicePersonality() == 0) {
            z = true;
        }
        bd.putBoolean(str2, z);
        NavMapAdapter.getInstance().setIsSelectPlate();
        BNavigator.getInstance().startNav(bd);
        this.mIsNaviBegin = true;
        BNavigator.getInstance().setRequestAuthrityListener(new C08956());
        BNRoutePlaner.getInstance().EnableRoadCondition(true);
        BNRoutePlaner.getInstance().setComeFrom(4);
        this.mOnDayNightChangedListener.onDayNightChanged(NavDayNightController.getInstance().isDay());
        RGMapModeViewController.getInstance().setVolumeChangeListener(this.mVolumeChangeListener);
        C1772k.m6480a().m6485a(2, 1);
        StatisticManager.onEvent(StatisticConstants.NAVI_0002, StatisticConstants.NAVI_0002);
        this.mNaviStartTime = System.currentTimeMillis();
        return navigatorView;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        C1260i.m4434b("BNRouteGuideFragment");
        if (hidden) {
            dismissDialog(this.mNaviSettingDialog);
            dismissDialog(this.mNaviRouteSearchDialog);
            BottomTabDisplayController.getInstance().onNaviRGFragmentInvisiable();
            return;
        }
        BottomTabDisplayController.getInstance().onNaviRGFragmentVisiable();
    }

    public void onResume() {
        super.onResume();
        LogUtil.e("", "resume:  zzt  ");
        BNavigator.getInstance().resume();
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sPoiToNaviTime12 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi(PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX, PerformStatItem.PoiToNaviStep12, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime11, PerformStatItem.sPoiToNaviTime12);
            PerformStatItem.sRoutePageToNaviTime6 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi(C2578b.f8568g, "页面周期显示函数", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sRoutePageToNaviTime5, PerformStatItem.sRoutePageToNaviTime6);
        }
        if (NavCommonFuncModel.sNaviTimeType == 1 && NaviStatItem.getInstance() != null) {
            NaviStatItem.getInstance().intimeType = 1;
            NaviStatItem.getInstance().intime = System.currentTimeMillis() - NavCommonFuncModel.sRoutePageToNaviTime1;
            NavCommonFuncModel.sNaviTimeType = -1;
        } else if (NavCommonFuncModel.sNaviTimeType == 2 && NaviStatItem.getInstance() != null) {
            NaviStatItem.getInstance().intimeType = 2;
            NaviStatItem.getInstance().intime = System.currentTimeMillis() - NavCommonFuncModel.sPoiToNaviTime1;
            NavCommonFuncModel.sNaviTimeType = -1;
        } else if (NaviStatItem.getInstance() != null) {
            NaviStatItem.getInstance().intimeType = -1;
            NaviStatItem.getInstance().intime = -1;
            NavCommonFuncModel.sNaviTimeType = -1;
        }
        if (!(this.mJumpTiming == -1 || this.mBNavigatorListener == null)) {
            this.mBNavigatorListener.onPageJump(this.mJumpTiming, this.mArg);
        }
        if (C1663a.m5979a().m5993N()) {
            BaseTTSPlayer.getInstance().setCarLifeConnected(true);
        } else {
            BaseTTSPlayer.getInstance().setCarLifeConnected(false);
        }
        C1260i.m4434b("BNRouteGuideFragment");
        BottomTabDisplayController.getInstance().onNaviRGFragmentVisiable();
    }

    public void onPause() {
        super.onPause();
        BNavigator.getInstance().pause();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BNavigator.getInstance().onConfigurationChanged(newConfig, true);
    }

    public boolean onBackPressed() {
        if (RGViewController.getInstance().ismIsFellowTipsShow()) {
            RGViewController.getInstance().hideFellowTips();
        } else if (RGViewController.getInstance().isMenuVisible() || !RGViewController.getInstance().getFellowStatus()) {
            C1307e.m4686a().mo1468c();
            if (RGRouteSearchModel.getInstance().isRouteSearchMode() && NavMapAdapter.getInstance().isFocusUIEnable()) {
                RGViewController.getInstance().onEmptyPoiAction();
                onInitFocusAreas();
            } else {
                BNavigator.getInstance().onBackPressed();
            }
        } else if (System.currentTimeMillis() - this.mExitTime > 2000) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.fellow_exit_tips));
            this.mExitTime = System.currentTimeMillis();
        } else {
            RGViewController.getInstance().closeFellow();
        }
        return true;
    }

    protected void onInitView() {
        if (this.mJumpTiming != -1 && this.mBNavigatorListener != null) {
            this.mBNavigatorListener.onPageJump(this.mJumpTiming, this.mArg);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        NavItemizedOverlayUtil.getInstance().unInitWrapper();
        BaseTTSPlayer.getInstance().setEnableTimeOut(false);
        NavDayNightController.getInstance().unregisterDayNightListener(this.mOnDayNightChangedListener);
        BNavigator.getInstance().setOnNaviBeginListener(null);
        BaiduNaviManager.getInstance().notifyNaviBeginChanged("0");
        BNavigator.getInstance().setListener(null);
        BNavigator.getInstance().setRequestAuthrityListener(null);
        NavRouteGuideController.getInstance().UnSetNavUserBehaviourCallback();
        BNavigator.destory();
        NavAoiRender.INSTANCE.clear();
        NavMapAdapter.getInstance().restoreMapData();
        NavComponentController.getInstance().addColladaUserOP();
        BottomTabDisplayController.getInstance().onNaviRGFragmentInvisiable();
        BNRouteGuider.getInstance().setRotateMode(0);
    }

    public void exit() {
        NavLogUtils.m3003e("BNRouteGuideFragment", "exit (187):  --> ");
        BNRoutePlaner.getInstance().setObserver(null);
        Bundle bd = new Bundle();
        if (!NavCommonFuncModel.sIsAnologNavi) {
            bd.putBoolean(BackBundle.back_from_nav, true);
        }
        backTo(17, null);
    }

    public void onStart() {
        super.onStart();
        if (this.mIsNaviBegin) {
            BNavigator.getInstance().start();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.mIsNaviBegin) {
            BNavigator.getInstance().stop();
        }
    }

    public int adjustVolumeUpKeyDown(AudioManager audio, int maxVolume) {
        hideSystemVolume(audio);
        int current = audio.getStreamVolume(3);
        NavLogUtils.m3003e("adjustVolume Up", "volume = " + BaseTTSPlayer.getInstance().getCurrentVolume());
        audio.adjustStreamVolume(3, 1, 8);
        current = audio.getStreamVolume(3);
        int ttsVolume = BaseTTSPlayer.getInstance().getCurrentVolume();
        if (ttsVolume > 8) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_k, null, null, ttsVolume + "");
        }
        RGMapModeViewController.getInstance().showVolume(current, maxVolume, BaseTTSPlayer.getInstance().getCurrentVolume(), true);
        return current;
    }

    public int adjustVolumeDownKeyDown(AudioManager audio, int maxVolume) {
        hideSystemVolume(audio);
        audio.adjustStreamVolume(3, -1, 8);
        int current = audio.getStreamVolume(3);
        RGMapModeViewController.getInstance().showVolume(current, maxVolume, BaseTTSPlayer.getInstance().getCurrentVolume(), false);
        NavLogUtils.m3003e("adjustVolume Down", "volume = " + BaseTTSPlayer.getInstance().getCurrentVolume());
        return current;
    }

    private void hideSystemVolume(AudioManager audio) {
        audio.adjustStreamVolume(3, 0, 0);
    }

    private void delayInitModule() {
        NavDayNightController.getInstance().registerDayNightListener(this.mOnDayNightChangedListener);
        if (!getArguments().containsKey(BNavConfig.KEY_ROUTEGUIDE_IPO_SWITCH)) {
            RoutePlanModel rpm = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
            String startName = "";
            if (!(rpm == null || rpm.getStartNode() == null)) {
                startName = rpm.getStartNode().getName();
                GeoPoint startGeoPoint = rpm.getStartNode().mGeoPoint;
            }
            if ((rpm != null && startName == null) || startName.length() == 0) {
                startName = rpm.getStartName(NavMapAdapter.getInstance().getContext(), true);
            }
            NavTrajectoryController.getInstance().startRecord("", startName, 2, true, true);
            UserOPController.getInstance().add(UserOPParams.RECORD_START_8_2_1, "1", null, null);
            NavTrajectoryController.getInstance().startRecordForNaviResult(1);
        }
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        if (!isDialogShown()) {
            onInitFocus();
        }
    }

    private void showNaviRouteSearchDialog() {
        if (this.mNaviRouteSearchAdapter == null) {
            this.mNaviRouteSearchAdapter = new NaviRouteSearchAdapter(C1157a.m3876a());
        }
        if (this.mNaviRouteSearchDialog == null) {
            this.mNaviRouteSearchDialog = new C2282f(C1157a.m3876a(), this.mNaviRouteSearchAdapter, new C08978());
            this.mNaviRouteSearchDialog.setDialogShowHideListener(new C08989());
            this.mNaviRouteSearchDialog.m8636j();
        } else {
            dismissDialog(this.mNaviRouteSearchDialog);
        }
        showDialog(this.mNaviRouteSearchDialog, C1265a.Right);
    }

    private void onRouteSearchListViewItemClick(int position) {
        dismissDialog(this.mNaviRouteSearchDialog);
        String key = this.mNaviRouteSearchAdapter.getSearchKey(position);
        if (!TextUtils.isEmpty(key)) {
            routeSearchKeywordMTJ(key);
            RGRouteSearchModel.getInstance().setmLastKey(key);
            if (BNavigator.getInstance().routeSearchKeywords(key, new Handler() {
                public void handleMessage(Message msg) {
                    if (msg.what == 1005) {
                        C1307e.m4686a().mo1468c();
                        BNavigator.getInstance().handleRouteSearch(msg);
                        BNRouteGuideFragment.this.poiListSize = -1;
                        if (NavMapAdapter.getInstance().isFocusUIEnable()) {
                            BNRouteGuideFragment.this.handleBkgClick(0);
                        }
                    }
                }
            })) {
                C1307e.m4686a().mo1467b(getResources().getString(C0965R.string.progress_searching));
            }
        }
    }

    private void handleBkgClick(int poiIndex) {
        if ((this.poiListSize == -1 || (poiIndex >= 0 && poiIndex < this.poiListSize)) && RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                BNMapController.getInstance().updateLayer(4);
                RGRouteSearchModel.getInstance().resetLastBkgItemId();
            }
            List<SearchPoiPager> searchPoiPagerList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
            if (searchPoiPagerList != null && searchPoiPagerList.size() > 0) {
                SearchPoiPager searchPoiPager = (SearchPoiPager) searchPoiPagerList.get(0);
                if (searchPoiPager != null) {
                    List<SearchPoi> poiList = searchPoiPager.getPoiList();
                    if (poiList != null && poiIndex >= 0 && poiIndex < poiList.size()) {
                        this.poiListSize = poiList.size();
                        SearchPoi searchPoi = (SearchPoi) poiList.get(poiIndex);
                        if (searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
                            C1440d.m5251a().m5265f();
                            BNMapController.getInstance().focusItem(4, poiIndex, true);
                            RGPickPointModel.getInstance().updatePickPoint(searchPoi.mViewPoint);
                            RGPickPointModel.getInstance().updateAntiSearchPoi(searchPoi);
                            RGMapModeViewController.getInstance().showControlManualOperatePanel(false);
                            RGViewController.getInstance().updatePickPointView();
                            RGViewController.getInstance().showPickPointWithType();
                            RGPickPointModel.getInstance().setPickPointShow(true);
                            RGRouteSearchModel.getInstance().setLastBkgItemId(poiIndex);
                        }
                    }
                }
            }
        }
    }

    private void routeSearchKeywordMTJ(String keyword) {
        if (!TextUtils.isEmpty(keyword)) {
            String eventId = "";
            if (ActionTypeSearchParams.Gas_Station.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0022;
            } else if (ActionTypeSearchParams.Park.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0023;
            } else if (ActionTypeSearchParams.Toilet.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0024;
            } else if (ActionTypeSearchParams.Restaurant.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0025;
            } else if (ActionTypeSearchParams.Hotel.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0026;
            } else if (ActionTypeSearchParams.Bank.equals(keyword)) {
                eventId = StatisticConstants.NAVI_0027;
            }
            if (eventId.length() > 0) {
                StatisticManager.onEvent(eventId);
            }
        }
    }

    public void updateSettingDialog() {
        if (this.mNaviSettingDialogAdapter != null) {
            this.mNaviSettingDialogAdapter.notifyDataSetChanged();
        }
    }

    private void showNaviSettingDialog() {
        if (this.mNaviSettingDialogAdapter == null) {
            this.mNaviSettingDialogAdapter = new NaviSettingDialogAdapter(NavCommonFuncModel.getInstance().getActivity());
        }
        if (this.mNaviSettingDialog == null) {
            this.mNaviSettingDialog = new C2282f(C1157a.m3876a(), C0965R.string.navi_setting, this.mNaviSettingDialogAdapter, new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    BNRouteGuideFragment.this.onNaviSettingListViewItemClick(position);
                }
            });
            this.mNaviSettingDialog.setDialogShowHideListener(new C0770k() {
                public void onDismiss() {
                    BottomTabDisplayController.getInstance().panelHide();
                }

                public void onShow() {
                    BottomTabDisplayController.getInstance().panelShow();
                }
            });
            this.mNaviSettingDialog.m8636j();
        } else {
            dismissDialog(this.mNaviSettingDialog);
        }
        showDialog(this.mNaviSettingDialog, C1265a.Right);
    }

    private void onNaviSettingListViewItemClick(int position) {
        boolean z = true;
        if (position == 0) {
            BNavigator.getInstance().onLocationAction(1);
        } else if (position == 1) {
            BNavigator.getInstance().onLocationAction(2);
        } else if (position == 2) {
            StatisticManager.onEvent("NAVI_0005", "NAVI_0005");
            if (!BNSettingManager.isRoadCondOnOrOff()) {
                StatisticManager.onEvent("NAVI_0006", "NAVI_0006");
            }
            BNavigator instance = BNavigator.getInstance();
            if (BNSettingManager.isRoadCondOnOrOff()) {
                z = false;
            }
            instance.onITSAction(z);
        } else if (position == 3) {
            handleCruiseVoiceChanged(true, true);
        }
        if (this.mNaviSettingDialogAdapter != null) {
            this.mNaviSettingDialogAdapter.updateView(position);
        }
    }

    private void handleCruiseVoiceChanged(boolean isShowToast, boolean open) {
        BaseTTSPlayer.getInstance().setNaviMuteState(open);
        if (!isShowToast) {
            return;
        }
        if (BaseTTSPlayer.getInstance().isNaviMuteState()) {
            TipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), C0965R.string.nav_voice_close);
        } else {
            TipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), C0965R.string.nav_voice_open);
        }
    }

    public void onInitFocus() {
        if (this.mContentView != null) {
            this.mSetViaView = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_route_search);
            this.mZoomIn = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_zoomin);
            this.mZoomOut = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_zoomout);
            this.mMAView = this.mContentView.findViewById(C4048R.id.bnav_rg_rl_main_auxiliary_switch);
            this.mBridgeView = this.mContentView.findViewById(C4048R.id.bnav_rg_rl_bridge_switch);
            this.mRefresh = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_refresh_road);
            this.mViewExit = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_quit_ly);
            this.mViewContinue = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_continue_nav);
            this.mViewSetting = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_open_close_ly);
            this.mViewContinue2 = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_resume_tv);
            this.mViewChange = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_switch_route_tv);
            this.mViewClear = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_clear_poi_tv);
            this.mViewMap = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_map_switch);
            this.mMapControllView = this.mContentView.findViewById(C4048R.id.bnav_rg_cp_mapcontroll_rc);
            this.mViewCancel = this.mContentView.findViewById(C4048R.id.bnav_rg_operable_notification_cancel_relative);
            this.mViewConfirm = this.mContentView.findViewById(C4048R.id.bnav_rg_operable_notification_confirm_relative);
            this.mQuitLoading = this.mContentView.findViewById(C4048R.id.bnav_rg_toolbox_rp_watting_cancle);
            if (RGRouteSearchModel.getInstance().isRouteSearchMode() && NavMapAdapter.getInstance().isFocusUIEnable()) {
                if (this.mViewCancel != null && this.mViewConfirm != null) {
                    this.mFocusAreaLeft = new C1443g(this.mContentView, 4);
                    this.mFocusAreaLeft.m5300d(this.mViewCancel).m5300d(this.mViewConfirm);
                    this.mFocusAreaLeft.m5295a(this.mPickPointOnKeyListener);
                    this.mFocusAreaLeft.m5297b(this.mViewConfirm);
                    C1440d.m5251a().m5256b(this.mFocusAreaLeft);
                    C1440d.m5251a().m5268h(this.mFocusAreaLeft);
                }
            } else if (this.mNotificationShow) {
                if (this.mViewCancel != null && this.mViewConfirm != null) {
                    this.mFocusAreaLeft = new C1443g(this.mContentView, 4);
                    this.mFocusAreaLeft.m5300d(this.mViewCancel).m5300d(this.mViewConfirm);
                    this.mFocusAreaLeft.m5295a(this.mPickPointOnKeyListener);
                    this.mFocusAreaLeft.m5297b(this.mViewConfirm);
                    C1440d.m5251a().m5256b(this.mFocusAreaLeft);
                    C1440d.m5251a().m5268h(this.mFocusAreaLeft);
                }
            } else if (this.mRefresh != null && this.mZoomIn != null && this.mZoomOut != null && this.mSetViaView != null && this.mMAView != null && this.mBridgeView != null && this.mViewExit != null && this.mViewContinue != null && this.mViewContinue2 != null && this.mViewChange != null && this.mViewClear != null && this.mViewSetting != null && this.mViewMap != null && this.mMapControllView != null && this.mQuitLoading != null) {
                this.mFocusAreaUp = new C1443g(this.mContentView, 2, true);
                this.mFocusAreaUp.m5300d(this.mSetViaView).m5300d(this.mZoomIn).m5300d(this.mZoomOut).m5300d(this.mViewMap).m5300d(this.mViewSetting).m5300d(this.mQuitLoading).m5300d(this.mViewClear).m5300d(this.mViewChange).m5300d(this.mViewContinue2).m5300d(this.mViewContinue).m5300d(this.mViewExit).m5300d(this.mMapControllView).m5300d(this.mRefresh).m5300d(this.mBridgeView).m5300d(this.mMAView);
                C1440d.m5251a().m5256b(this.mFocusAreaUp);
                C1440d.m5251a().m5268h(this.mFocusAreaUp);
            }
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (type == 2) {
            switch (subType) {
                case 2:
                    BNMapController.getInstance().zoomOut();
                    replyVoiceCommand(type, 1, needResponse);
                    return true;
                case 3:
                    BNMapController.getInstance().zoomIn();
                    replyVoiceCommand(type, 1, needResponse);
                    return true;
                case 7:
                    VoiceCommandHelper.onITSChanged(true);
                    updateSettingDialog();
                    return true;
                case 8:
                    VoiceCommandHelper.onITSChanged(false);
                    updateSettingDialog();
                    return true;
                case 29:
                case 53:
                    BNavigator.getInstance().onLocationAction(2);
                    updateSettingDialog();
                    return true;
                case 30:
                    BNavigator.getInstance().onLocationAction(1);
                    updateSettingDialog();
                    return true;
            }
        }
        return false;
    }
}
