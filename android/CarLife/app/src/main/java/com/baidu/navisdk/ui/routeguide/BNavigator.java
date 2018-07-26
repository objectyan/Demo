package com.baidu.navisdk.ui.routeguide;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.location.GpsStatus.NmeaListener;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviSDKManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.adapter.impl.BNRouteGuideManager.OnNavigationListener;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.IGpsStatusListener;
import com.baidu.navisdk.comapi.routeguide.INaviSightListener;
import com.baidu.navisdk.comapi.routeguide.IRGSubStatusListener;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.NavState;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.ExpandMap;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.HighWayInfo;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RasterType;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.comapi.statistics.NaviStatHelper;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.OnVoiceCommandListener;
import com.baidu.navisdk.comapi.voicecommand.VoiceCommandHelper;
import com.baidu.navisdk.db.OperatorDBCallback.CurRoutePoiDBCallback;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager.NormalNaviSwitchSlightListener;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDUtils;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGLaneLineController;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.control.RouteGuideAsyncEventManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmParamsKey;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.BNRCEventDetailsMenuView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGAvoidTrafficModel;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGJamReportModel;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGMainAuxiliaryModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteItemModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteRecommendModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGUpdateRCFailModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.control.UgcFeedbackController.UgcFeedbackCallback;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.DebugGate;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.BNVoiceParams.StatisticsVoiceID;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.util.common.AudioUtils;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.RouteGuideThread;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.common.SystemAuth.IOnRequestAuthrityListener;
import com.baidu.navisdk.util.drivertool.BNScreentShotManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BatteryStatusReceiver;
import com.baidu.navisdk.util.listener.BlueToothListener;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.RGScreenStatusReceiver;
import com.baidu.navisdk.util.listener.RingModeStatusReceiver;
import com.baidu.navisdk.util.listener.UsbListener;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.logic.BNSysSensorManager;
import com.baidu.navisdk.util.statistic.GuideStatItem;
import com.baidu.navisdk.util.statistic.MTJStatisticsUtil;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviMergeStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.NetFlowStat;
import com.baidu.navisdk.util.statistic.OfflineDataStatItem;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.SettingStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.task.TaskExecutor;
import com.baidu.navisdk.util.task.TaskRunnable;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BNavigator implements IGpsStatusListener, INaviSightListener, IRGSubStatusListener, OnRGInfoListener, OnVoiceCommandListener {
    public static final int CONFIG_CLACROUTE_DONE = 0;
    public static final int CONFIG_CLACROUTE_NOT = 1;
    public static final int CONFIG_VIEW_MODE_INFLATE_MAP = 0;
    public static final int CONFIG_VIEW_MODE_NOT_INFLATE_MAP = 1;
    private static final int DELAY_TIME_OPEN_BLUETOOTH_SCO = 10000;
    private static final int GPS_DISABLE_TIME = 30000;
    public static final int INIT_ARG1_VIEW_DELAY_REFRESH = 1;
    public static int MAP_ZOOM_DELAY = 1200;
    private static final int MSG_GPS_ENABLE = 10931;
    public static final int MSG_TYPE_INIT = 10921;
    private static final int MSG_TYPE_OPEN_BLUETOOTH_SCO = 10901;
    private static final String TAG = "RouteGuide";
    public static int VIEW_INDEX_MAPVIEW = 0;
    public static int VIEW_INDEX_MENU = 2;
    public static int VIEW_INDEX_ROUTEGUIDE_UI = 1;
    public static int VIEW_INDEX_SPACE_SEARCH = 3;
    public static volatile boolean hasCallCheckOtherRoute = false;
    public static volatile boolean hasCallRerouted = false;
    public static volatile boolean hasReallyStartedNav = false;
    public static volatile boolean hasShowEnterAnim = false;
    private static CurRoutePoiDBCallback mCurRoutePoiDBCallback = null;
    private static BNCommonProgressDialog mWaitProgress = null;
    private static volatile BNavigator me = null;
    private static BNWorkerNormalTask<String, String> miniMapRequestTask = new BNavigator$4("miniMapRequestTask", null);
    public static boolean sCanBackgroundSpeak = true;
    private BNWorkerNormalTask<String, String> autoHideParkPointTask = new BNavigator$31(this, "autoHideParkPointTask", null);
    private boolean bFirstSearchPark = false;
    private boolean bInitialized = false;
    private Runnable carLocDelegate = new BNavigator$33(this);
    public boolean gotoUgcRelsutPage = false;
    private Long gpsStatusChangeStart = Long.valueOf(-1);
    private boolean hasGasData = true;
    private boolean hasSpeaked = false;
    private boolean isGasStationPreference;
    private volatile boolean isNaviBegin;
    private boolean isNeedShowRCSuccessTips;
    private boolean isNeedShowStartAnim = false;
    private volatile boolean isNeedSpeakSpecVoice = true;
    private boolean isVoiceSearch = false;
    private boolean isWanda = false;
    private String lastFulu = "f0";
    private String lastGaojia = "g0";
    private Activity mActivity;
    private BNMapObserver mBNMapObserver = new BNavigator$27(this);
    private IBNavigatorListener mBNavigatorListener;
    private final String mBackgroundSpeakMsg = "<usraud>百度地图将持续为您导航</usraud>";
    private boolean mCanParkPoiOnMapShow = false;
    private boolean mCanParkShow = false;
    private Context mContext;
    private int mCurOrientation = 2;
    private int mCurrentRouteGPCnt = 0;
    private BNWorkerNormalTask<String, String> mFsmRunInitialStateTask = new BNavigator$5(this, "FsmRunInitialStateTask", null);
    private ContentObserver mGPSOpenCloseStateObs = null;
    private Handler mHandler = new BNavigator$1(this, Looper.getMainLooper());
    private BNavigator$OnHUDSDKNavStatusCallback mHudSdkNavStatusCallback;
    private ISDKNaviStatusListener mISDKNaviStatusListener;
    private BNWorkerNormalTask mInitFirstRGInfoTask = new BNavigator$40(this, "execute-mInitFirstRGInfoTask", null);
    private BNWorkerNormalTask<String, String> mInitResultViewTask = new BNavigator$42(this, "InitResultViewTask", null);
    private boolean mIsARRouteBuildSuccess = false;
    private boolean mIsBackground = false;
    private boolean mIsFirstResume = true;
    public boolean mIsGPSDisable = false;
    private boolean mIsMapSwitchInited = false;
    public boolean mIsStartRouteGuideSuc = false;
    private boolean mIsYawed;
    int mLastConfirmType = 0;
    private int mLastMilea = 0;
    private LocData mLocDataCache = null;
    private BNLocationManager mLocationManager;
    private ContentObserver mMockGpsStateObs = null;
    private MapGLSurfaceView mNMapView;
    private final BroadcastReceiver mNavQuitReceiver = new BNavigator$9(this);
    private TaskExecutor mNavTaskExecutor = null;
    private BNavigator$NavUserBehaviourCallback mNavUserBehaviourCallback;
    private Handler mNetChangeHandler = new BNavigator$36(this, Looper.getMainLooper());
    private NmeaListener mNmeaListener = new BNavigator$10(this);
    private NormalNaviSwitchSlightListener mNormalNaviSwitchSlightListener = new BNavigator$37(this);
    private BNavigator$OnNaviBeginListener mOnNaviBeginListener = null;
    private OnNavigationListener mOnNavigationListener;
    private FrameLayout mParentView = null;
    private boolean mParkNoShown = false;
    private ILocationChangeListener mRGLocationLisnter = new BNavigator$11(this);
    OnRGSubViewListener mRGSubViewListener = null;
    private Callback mRGThreadCallback = new BNavigator$39(this);
    private Handler mRPHandler = new BNavigator$20(this, Looper.getMainLooper());
    public boolean mReAddGpsLocation = false;
    private BNWorkerNormalTask<String, String> mReAddGpsLocationTask = new BNavigator$14(this, "ReAddGpsLocationTask", null);
    public IOnRequestAuthrityListener mRequestListener = null;
    private MsgHandler mRouteGuideUiHandler = new BNavigator$19(this, Looper.getMainLooper());
    private final String mSDKBackgroundSpeakMsg = "百度导航持续为您服务";
    private Handler mSearchHandler;
    private int mShowRCFailTimes = 0;
    private BNWorkerNormalTask mStartNavReallyTask = new BNavigator$41(this, "execute-startNavReally", null);
    private long mStartTime = 0;
    private boolean mTrigger_wifi_gps = true;
    private UgcFeedbackCallback mUgcFeedbackCallback = new BNavigator$38(this);
    BNWorkerNormalTask<String, String> mUpdateRCFailTask = new BNavigator$35(this, "mUpdateRCFailTask", null);
    private BNavigator$VoiceSearchCallback mVoiceSearchCallBack;
    private BNWorkerNormalTask<String, String> mockToastTask = new BNavigator$26(this, "mockToastTask", null);
    private BNWorkerNormalTask<String, String> parkClickTask = new BNavigator$32(this, "parkClickTask", null);
    private BNWorkerNormalTask<String, String> parkDetailNoActiondelegateTask = new BNavigator$34(this, "parkDetailNoActiondelegateTask", null);
    private int parkIndex = 0;
    private long preBackTime = 0;
    private boolean preGpsStatusLost = true;
    private BNWorkerNormalTask<String, String> refreshTotalRemainDistTimeTask = new BNavigator$15(this, "refreshTotalRemainDistTimeTask", null);
    private String ugcUidCache = null;

    public void setmCanParkShow(boolean mCanParkShow) {
        this.mCanParkShow = mCanParkShow;
    }

    public void addSDKNaviStatusListener(ISDKNaviStatusListener listener) {
        this.mISDKNaviStatusListener = listener;
    }

    public void removeSDKNaviStatusListener() {
        this.mISDKNaviStatusListener = null;
    }

    public void setNavigationListener(OnNavigationListener lis) {
        this.mOnNavigationListener = lis;
    }

    public void setCurRoutePoiDBCallback(CurRoutePoiDBCallback callback) {
        mCurRoutePoiDBCallback = callback;
    }

    public BNavigator$VoiceSearchCallback getmVoiceSearchCallBack() {
        return this.mVoiceSearchCallBack;
    }

    public void setmVoiceSearchCallBack(BNavigator$VoiceSearchCallback mVoiceSearchCallBack) {
        this.mVoiceSearchCallBack = mVoiceSearchCallBack;
    }

    public void setmNavUserBehaviourCallback(BNavigator$NavUserBehaviourCallback NavUserBehaviourCallback) {
        this.mNavUserBehaviourCallback = NavUserBehaviourCallback;
    }

    public BNavigator$NavUserBehaviourCallback getmNavUserBehaviourCallback() {
        return this.mNavUserBehaviourCallback;
    }

    public void setRequestAuthrityListener(IOnRequestAuthrityListener requestListener) {
        this.mRequestListener = requestListener;
    }

    public void requestAuth(String authType) {
        if (this.mRequestListener != null && VERSION.SDK_INT >= 23 && !TextUtils.isEmpty(authType)) {
            this.mRequestListener.onRequestAuthrity(authType, 1000, null);
        }
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public static BNavigator getInstance() {
        if (me == null) {
            synchronized (BNavigator.class) {
                if (me == null) {
                    me = new BNavigator();
                }
            }
        }
        return me;
    }

    public void setParentViewBg() {
        if (this.mParentView != null) {
            this.mParentView.setBackgroundColor(JarUtils.getResources().getColor(C4048R.color.common_list_bg_color));
        }
    }

    public static void destory() {
        if (me != null) {
            synchronized (RGViewController.class) {
                if (me != null) {
                    me.dispose();
                }
            }
        }
        me = null;
        PerformStatisticsController.peByType(7, "on_quit_nav_destory", System.currentTimeMillis());
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peDiffByType(7);
        }
    }

    public static void destroyRGViewController() {
        RGViewController.destory();
    }

    private void dispose() {
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
            this.mParentView = null;
        }
        RGViewController.getInstance().hideAllDialogs();
        RGViewController.getInstance().releaseAllDialogs();
        RGViewController.getInstance().hideRGFloatView();
        RGViewController.getInstance().hideRGFloatOpenGuidDialog();
        BNEyeSpyPaperController.getInstance().hideButton();
        RouteGuideThread.getInstance().getHandler().post(new BNavigator$2(this));
        this.mRGSubViewListener = null;
        this.bInitialized = false;
        this.mActivity = null;
        this.mContext = null;
    }

    public View init(Activity activity, Bundle configParams, MapGLSurfaceView mapView) {
        LogUtil.e("RouteGuide", "init START");
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(0, "sdk_routeguide_init_start", System.currentTimeMillis());
        }
        this.isNaviBegin = true;
        hasReallyStartedNav = false;
        hasShowEnterAnim = false;
        this.bInitialized = false;
        this.gotoUgcRelsutPage = false;
        hasCallRerouted = false;
        hasCallCheckOtherRoute = false;
        this.mIsFirstResume = true;
        this.mContext = activity.getApplicationContext();
        this.mActivity = activity;
        this.mNMapView = mapView;
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        RGMapModeViewController.getInstance().isShowingUgcBtnLayout = false;
        RGCacheStatus.sOrientation = 2;
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
        }
        try {
            this.mParentView = (FrameLayout) JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_rg_main_layout, null);
            parseConfigParams(configParams);
            initRGSubViewListener();
            initMapView();
            setupUI(this.mNMapView);
            LogUtil.e("RouteGuide", "init End");
            return this.mParentView;
        } catch (Exception e) {
            this.mParentView = null;
            return null;
        }
    }

    private void initOnBGThread() {
        LogUtil.e("RouteGuide", "time initOnBGThread start");
        BNSettingManager.setQuitForExceptionInNaviMode(true);
        BNRouteGuider.getInstance().setNaviMode(1);
        BNMapController.getInstance().showTrafficMap(BNSettingManager.isRoadCondOnOrOff(), false);
        initSilentIcon();
        RouteGuideAsyncEventManager.init();
        CommonHandlerThread.getInstance().sendMessage(100);
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_1_1, NetworkUtils.getActiveNetworkSubtype() + "", null, null);
        if (BNavConfig.pRGLocateMode == 2) {
            JNIGuidanceControl.getInstance().setFuncConfigParams(true, RGMultiRouteModel.DETAULT_INSTANT_CLOUD_MULTI_ROUTE_PST_LABEL_DIS, 1);
        }
        if (BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            NaviStatItem.getInstance().setStartNaviFrom(8);
        } else {
            UgcNaviDynamicMarkRespository.getInstance().clear();
            NaviStatItem.getInstance().setStartNaviFrom(2 == BNavConfig.pRGLocateMode ? 9 : 1);
        }
        createSearchHandler();
        initExpandmapDownload();
        if (BNOffScreenManager.sIsModelueActive) {
            BNOffScreenManager.getInstance().initOffScreen();
        }
        if (2 == BNavConfig.pRGLocateMode) {
            BNMapController.getInstance().setAnimationGlobalSwitch(true);
        } else if (1 == PreferenceHelper.getInstance(this.mContext).getInt(Key.NAVI_POWER_SAVE_MODE, 0)) {
            BNMapController.getInstance().setAnimationGlobalSwitch(false);
        } else {
            BNMapController.getInstance().setAnimationGlobalSwitch(true);
        }
        CommonHandlerThread.getInstance().sendMessage(30);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$3(this, "initOnBGThread-" + getClass().getSimpleName(), null), new BNWorkerConfig(2, 0), 300);
        RGScreenStatusReceiver.initScreenStatusReceiver(this.mContext);
        RGJamReportModel.getInstance().setHasJamReportShown(false);
        LogUtil.e("RouteGuide", "time initOnBGThread start end");
    }

    public void initOnMainThread() {
        LogUtil.e("RouteGuide", "initLogic START");
        RouteGuideThread.getInstance().registerCallback(this.mRGThreadCallback);
        VMsgDispatcher.registerMsgHandler(this.mRouteGuideUiHandler, 0);
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            RGParkPointModel.getInstance().setCanParkPoiShow(true);
            NetFlowStat.getInstance().initStat(this.mActivity);
            TTSPlayerControl.clearTagList();
        }
        if (!BNSysLocationManager.getInstance().isLocateInitSuccessful) {
            BNSysLocationManager.getInstance().restartLocateModule();
        }
        initRouteGuider();
        initRGEngine();
        initLocationService();
        initGPSOpenCloseStateListener();
        initNavQuitReceiver();
        if (BusinessActivityManager.getInstance().getModel() != null) {
            if (BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5 || BNavConfig.pRGLocateMode == 6) {
                BusinessActivityManager.getInstance().getModel().isNeedUploadDataFromLocal = true;
            } else {
                BusinessActivityManager.getInstance().getModel().isNeedUploadDataFromLocal = false;
            }
        }
        RGCacheStatus.sMockGpsGuide = false;
        checkMockGpsState(false);
        initMockGpsStateListener();
        BNLightNaviSwitchManager.getInstance().setNormalNaviSwitchSlightListener(this.mNormalNaviSwitchSlightListener);
        BNPowerSaver.getInstance().init(this.mActivity);
        BNMapController.getInstance().setNaviStatus(true);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(miniMapRequestTask, new BNWorkerConfig(2, 0), 1000);
        int netmode = BNRoutePlaner.getInstance().getCalcRouteNetMode();
        if (netmode == 1 || netmode == 3) {
            registerNetworkListener();
        }
        BNaviSDKManager.getInstance().SDKNavigatorInit();
        registerConnectReceiver();
        BNEyeSpyPaperController.getInstance().showButton();
        this.bInitialized = true;
        LogUtil.e("RouteGuide", "initLogic end");
    }

    private void initSilentIcon() {
        if (BNSettingManager.getVoiceMode() == 2) {
            RGSimpleGuideModel.getInstance().canSilentIconShow = true;
        } else if (this.mActivity != null && AudioUtils.getCurrentVolume(this.mActivity) <= 0) {
            RGSimpleGuideModel.getInstance().canSilentIconShow = true;
        } else if (AudioUtils.isSmartisanPanelMute()) {
            RGSimpleGuideModel.getInstance().canSilentIconShow = true;
        } else {
            RGSimpleGuideModel.getInstance().canSilentIconShow = false;
        }
    }

    public void setListener(IBNavigatorListener listener) {
        this.mBNavigatorListener = listener;
    }

    public View getView() {
        return this.mParentView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public boolean startNav(Bundle bd) {
        LogUtil.e("RouteGuide", "time startNav start");
        this.hasSpeaked = false;
        this.mIsYawed = false;
        if (bd != null) {
            String bduss = bd.getString("clbduss");
            boolean bNormol = bd.getBoolean("bNormol");
            LogUtil.e("RouteGuide", "startNav bduss " + bduss + " bNormol " + bNormol);
            BNRouteGuider.getInstance().updateSpecVoiceText(bduss, bNormol);
        }
        Bundle bundle = new Bundle();
        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
        RGSimpleGuideModel.getInstance().setFirstRGInfo(bundle);
        if (RGSimpleGuideModel.getInstance().isFirstDataOk) {
            RGViewController.getInstance().initFirstRGInfo();
        } else {
            RGViewController.getInstance().showLoadingWhileWaitCal();
        }
        this.mNavTaskExecutor = initNavTask();
        LogUtil.e("RouteGuide", "time startNav end");
        return true;
    }

    private TaskExecutor initNavTask() {
        TaskRunnable<String, String> initFirstRGInfoTask = new BNavigator$6(this, "initFirstRGInfoTask", null, 0);
        TaskRunnable<String, String> initOtherTask = new BNavigator$7(this, "initOtherTask", null, 0);
        TaskExecutor taskExecutor = TaskExecutor.create();
        taskExecutor.addTask(initFirstRGInfoTask);
        taskExecutor.addTask(initOtherTask);
        return taskExecutor;
    }

    private boolean startRouteGuide() {
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            this.isNeedSpeakSpecVoice = true;
        }
        this.mIsStartRouteGuideSuc = BNRouteGuider.getInstance().startRouteGuide(this.isNeedSpeakSpecVoice);
        LogUtil.e("RouteGuide", "startRouteGuide: mIsStartRouteGuideSuc --> " + this.mIsStartRouteGuideSuc);
        if (this.mIsStartRouteGuideSuc) {
            this.isNeedSpeakSpecVoice = false;
        }
        return this.mIsStartRouteGuideSuc;
    }

    public boolean startNavReally() {
        LogUtil.e("RouteGuide", "time startNavReally start");
        RGSimpleGuideModel.mIsRPPrefer = true;
        if (TextUtils.isEmpty(BNavConfig.pRGMrsl)) {
            NaviStatItem.getInstance().fillInAllFullRoutePlanTime();
        }
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peDiffByType(1);
        }
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            RGCacheStatus.hasClosedFoatView = false;
            RGCacheStatus.hasRecordFloatViewShow = false;
        }
        this.mIsGPSDisable = true;
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MSG_GPS_ENABLE);
            this.mHandler.sendEmptyMessageDelayed(MSG_GPS_ENABLE, HttpsClient.CONN_MGR_TIMEOUT);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(MSG_TYPE_INIT, 1, 0));
        this.isNeedShowStartAnim = shouldShowStartAnimation();
        RGViewController.getInstance().showAssistView();
        if (this.mHandler != null) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mFsmRunInitialStateTask, new BNWorkerConfig(2, 0), 0);
        } else {
            initRouteGuideFSM();
            RouteGuideFSM.getInstance().runInitialState(null);
        }
        MTJStatisticsUtil.mNaviStartTime = SystemClock.elapsedRealtime();
        notifyNaviBeginListener(String.valueOf(1));
        BNEventManager.getInstance().onOtherAction(3, 0, 0, null);
        notifyHUDSDKNavStatus(true);
        if (this.mBNavigatorListener != null) {
            this.mBNavigatorListener.notifyStartNav();
        }
        BNRecoverNaviHelper.getInstance().addLastNaviPointsToDB(((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getRouteInput());
        if (2 != BNavConfig.pRGLocateMode) {
            CommonHandlerThread.getInstance().sendMessage(302);
            BNRecoverNaviHelper.getInstance().setNaviFlag(BNaviModuleManager.getContext().getApplicationContext(), true);
        }
        SettingStatItem.getInstance().onEvent();
        OfflineDataStatItem.getInstance().onEvent();
        Bundle totalInfoBundle = RGSimpleGuideModel.getInstance().getTotalInfo();
        int distance = 0;
        int time = 0;
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalDist)) {
            distance = totalInfoBundle.getInt(SimpleGuideInfo.TotalDist);
        }
        if (totalInfoBundle != null && totalInfoBundle.containsKey(SimpleGuideInfo.TotalTime)) {
            time = totalInfoBundle.getInt(SimpleGuideInfo.TotalTime);
        }
        NaviStatItem.getInstance().setRoutePlanTimeAndDist((long) time, (long) distance);
        RoutePlanModel rpm = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        LogUtil.e("RouteGuide_", "" + rpm.mCurRouteIndex);
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_1, rpm.getEndName(this.mContext, false), "0", rpm.getStartName(this.mContext, false));
        checkTTsVolume();
        if (BNavConfig.pRGLocateMode != 2 && BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() == 2) {
            RGSimpleGuideModel.mIsOfflineToOnline = true;
            RGViewController.getInstance().requestShowExpendView(10, true);
        }
        if (BNSettingManager.getVoiceMode() == 2) {
            RGViewController.getInstance().showVoiceModeToast(true);
        }
        RGNotificationController.getInstance().showLocalRoute(true);
        if (RGSimpleGuideModel.mIsRPPrefer && RGNotificationController.getInstance().getLocalRouteType() == -1) {
            RGNotificationController.getInstance().showRPPrefer();
        }
        if (XDVoiceInstructManager.getInstance().xdIsWakeUpOn() && BNSettingManager.getFirstVoiceNotifyGuide() && SystemAuth.checkAuth("android.permission.RECORD_AUDIO") && CloudlConfigDataModel.getInstance().mCommonConfig.xdVoice == 0) {
            RGNotificationController.getInstance().showFirstVoiceGuide();
        }
        checkAndShowGPSSettingDialog();
        if (!BNSettingManager.hasPlateFromLocal(this.mContext)) {
            BNaviModuleManager.fetchCarOwnerData(this.mContext);
        }
        RGViewController.getInstance().updateToolBoxStatus();
        LogUtil.e("RouteGuide", "time startNavReally end mIsStartRouteGuideSuc:" + this.mIsStartRouteGuideSuc);
        return true;
    }

    private boolean shouldShowStartAnimation() {
        if (this.mHandler == null || !BNavConfig.pRGShowFullview || !RGMultiRouteModel.getInstance().isEnable() || BNRecoverNaviHelper.getInstance().getNaviFlag(BNaviModuleManager.getContext().getApplicationContext()) || BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            return false;
        }
        LogUtil.e("RouteGuide", "shouldShowStartAnimation true");
        return true;
    }

    private void parseConfigParams(Bundle configParams) {
        if (configParams != null) {
            BNavConfig.pRGViewMode = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE);
            BNavConfig.pRGCalcDone = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_CALCROUTE_DONE);
            BNavConfig.pRGStartX = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_START_X);
            BNavConfig.pRGStartY = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_START_Y);
            BNavConfig.pRGEndX = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_END_X);
            BNavConfig.pRGEndY = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_END_Y);
            BNavConfig.pRGStartName = configParams.getString("start_name");
            BNavConfig.pRGEndName = configParams.getString("end_name");
            BNavConfig.pRGLocateMode = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE);
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_SHOW_FULLVIEW)) {
                BNavConfig.pRGShowFullview = configParams.getBoolean(BNavConfig.KEY_ROUTEGUIDE_SHOW_FULLVIEW);
            } else {
                BNavConfig.pRGShowFullview = true;
            }
            LogUtil.e("RouteGuide", "pRGLocateMode = " + BNavConfig.pRGLocateMode + ", pRGShowFullview=" + BNavConfig.pRGShowFullview);
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_MENU_TYPE)) {
                BNavConfig.pRGMenuType = configParams.getInt(BNavConfig.KEY_ROUTEGUIDE_MENU_TYPE);
            }
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_NET_FRESH_ENABLE)) {
                BNavConfig.pRGNetRefreshEnable = configParams.getBoolean(BNavConfig.KEY_ROUTEGUIDE_NET_FRESH_ENABLE);
            }
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_ROAD_CONDITION_ENABLE)) {
                BNavConfig.pRGRoadConditionEnable = configParams.getBoolean(BNavConfig.KEY_ROUTEGUIDE_ROAD_CONDITION_ENABLE);
            }
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_SELECTED_ROUTE_MRSL)) {
                BNavConfig.pRGMrsl = configParams.getString(BNavConfig.KEY_ROUTEGUIDE_SELECTED_ROUTE_MRSL);
            } else {
                BNavConfig.pRGMrsl = null;
            }
            LogUtil.e("RouteGuide", "pRGMenuType = " + BNavConfig.pRGMenuType);
            if (configParams.containsKey(BNavConfig.KEY_ROUTEGUIDE_CAR_RESULT_HAS_SHOW_ANIM)) {
                hasShowEnterAnim = configParams.getBoolean(BNavConfig.KEY_ROUTEGUIDE_CAR_RESULT_HAS_SHOW_ANIM);
            } else {
                hasShowEnterAnim = false;
            }
        }
    }

    private void setupMapView(MapGLSurfaceView mapView) {
        if (BNavConfig.pRGViewMode != 0) {
            return;
        }
        if (mapView != null) {
            ViewParent tMapParent = mapView.getParent();
            if (tMapParent != null && (tMapParent instanceof ViewGroup)) {
                ((ViewGroup) tMapParent).removeView(mapView);
            }
            LayoutParams lp = new LayoutParams(-1, -1);
            if (this.mParentView != null) {
                this.mParentView.addView(mapView, VIEW_INDEX_MAPVIEW, lp);
                this.mParentView.requestLayout();
                return;
            }
            return;
        }
        BNavConfig.pRGViewMode = 1;
    }

    private void setupUI(MapGLSurfaceView mapView) {
        RGViewController.getInstance().initView(this.mActivity, this.mParentView, mapView, this.mRGSubViewListener);
        RGViewController.getInstance().hideAssistMapSwitch();
        DebugGate.debug(this.mParentView);
    }

    private void updateUILayoutParams() {
        if (this.mParentView != null) {
            this.mParentView.getViewTreeObserver().addOnGlobalLayoutListener(new BNavigator$8(this));
        }
    }

    public void updateCompassLocation(Context context) {
        RGCacheStatus.sWidth = ScreenUtil.getInstance().getWidthPixels();
        LogUtil.e("RouteGuide", "updateCompassLocation sWidth=" + RGCacheStatus.sWidth + ",sHeight=" + RGCacheStatus.sHeight);
    }

    private void initDebugConfig() {
    }

    private void initRouteGuider() {
        BNRouteGuider.getInstance().setGpsStatusListener(this);
        BNRouteGuider.getInstance().setOnRGInfoListener(this);
        BNRouteGuider.getInstance().setRGSubStatusListener(this);
        BNRouteGuider.getInstance().setSightListener(this);
    }

    private void unInitRouteGuider() {
        try {
            BNRouteGuider.getInstance().setGpsStatusListener(null);
            BNRouteGuider.getInstance().setOnRGInfoListener(null);
            BNRouteGuider.getInstance().setRGSubStatusListener(null);
            BNRouteGuider.getInstance().setSightListener(null);
        } catch (Throwable th) {
        }
    }

    private void initRGEngine() {
        if (BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5) {
            BNRouteGuider.getInstance().setLocateMode(1);
        } else if (BNavConfig.pRGLocateMode == 2) {
            BNRouteGuider.getInstance().setLocateMode(2);
        }
        updateRGEngineSpeekStatus();
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler, true);
    }

    private void initExpandmapDownload() {
        BNRouteGuider.getInstance().enableExpandmapDownload(BNSettingManager.getPrefRealEnlargementNavi());
    }

    public void updateRGEngineSpeekStatus() {
        int voiceMode = BNSettingManager.getVoiceMode();
        BNRouteGuider.getInstance().setVoiceMode(voiceMode);
        if (2 == voiceMode) {
            BNRouteGuider.getInstance().setElecCameraSpeak(false);
            BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
            BNRouteGuider.getInstance().setSaftyDriveSpeak(false);
            BNRouteGuider.getInstance().setRoadConditionSpeak(false);
            BNRouteGuider.getInstance().setStraightDirectSpeak(false);
            return;
        }
        BNRouteGuider.getInstance().setElecCameraSpeak(BNSettingManager.isElecCameraSpeakEnable());
        BNRouteGuider.getInstance().setSpeedCameraSpeak(BNSettingManager.isSpeedCameraSpeakEnable());
        BNRouteGuider.getInstance().setSaftyDriveSpeak(BNSettingManager.isSaftyDriveSpeakEnable());
        BNRouteGuider.getInstance().setRoadConditionSpeak(BNSettingManager.isRoadConditionSpeakEnable());
        BNRouteGuider.getInstance().setStraightDirectSpeak(BNSettingManager.isStraightDirectSpeakEnable());
    }

    private void initNavQuitReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(RouteGuideParams.ACTION_QUITNAVI);
        try {
            this.mContext.registerReceiver(this.mNavQuitReceiver, filter);
        } catch (Exception e) {
        }
    }

    private void initScreenAlwaysOn() {
        VDeviceAPI.setScreenAlwaysOn(BNSettingManager.isAlwaysBright());
    }

    private void restoreScreenAlwaysOn() {
        VDeviceAPI.setScreenAlwaysOn(false);
    }

    private void initLocationService() {
        BNLocationManagerProxy.getInstance().startNaviLocate(this.mContext);
        addGpsLocation();
    }

    public void initLightNavi(Activity activity) {
        this.mContext = activity.getApplicationContext();
        this.mActivity = activity;
        notifyNaviBeginListener(String.valueOf(9));
        BNavConfig.pRGLocateMode = 6;
        BNRouteGuider.getInstance().setLocateMode(1);
        BNRoutePlaner.getInstance().triggerGPSStatus(BNLocationManagerProxy.getInstance().getGpsState());
        if (!BNSysLocationManager.getInstance().isLocateInitSuccessful) {
            BNSysLocationManager.getInstance().restartLocateModule();
        }
        BNRouteGuider.getInstance().startRouteGuide(true);
        BNLocationManagerProxy.getInstance().startNaviLocate(this.mContext);
        addGpsLocation();
        RouteGuideAsyncEventManager.init();
        MTJStatisticsUtil.mNaviStartTime = SystemClock.elapsedRealtime();
        CommonHandlerThread.getInstance().sendMessage(200);
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            NetFlowStat.getInstance().initStat(activity);
        }
        RGCacheStatus.sMockGpsGuide = false;
        BusinessActivityManager.getInstance().getModel().isNeedUploadDataFromLocal = true;
        checkMockGpsState(false);
        initMockGpsStateListener();
    }

    private void initMapView() {
        boolean z = true;
        LogUtil.e("RouteGuide", "time initMapView start");
        NMapControlProxy.getInstance().deleteAllObserver();
        NMapControlProxy.getInstance().addMapObserver(this.mBNMapObserver);
        NMapControlProxy.getInstance().setDrawHouse(false, false);
        BNPoiSearcher.getInstance().clearBkgCache();
        BNPoiSearcher.getInstance().clearPoiCache();
        MapController mapController = BNMapController.getInstance().getMapController();
        if (mapController != null) {
            try {
                if (BNSettingManager.isAutoLevelMode()) {
                    mapController.setAutoLevel(true);
                } else {
                    mapController.setAutoLevel(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BNMapController instance = BNMapController.getInstance();
        if (BNStyleManager.getRealDayStyle()) {
            z = false;
        }
        instance.setNightMode(z);
        BNMapController.getInstance().setRedLineRender(BNSettingManager.getShowCarLogoToEnd());
        LogUtil.e("RouteGuide", "time initMapView end");
    }

    private void restoreMapView() {
        NMapControlProxy.getInstance().setDrawHouse(true, true);
        NMapControlProxy.getInstance().deleteMapObserver(this.mBNMapObserver);
    }

    private void initRouteGuideFSM() {
        RouteGuideFSM.getInstance().setInitialState(FsmState.SimpleGuide);
        RouteGuideFSM.getInstance().setDestStateListener(new BNavigator$12(this));
    }

    private void forbidConflictModule() {
    }

    private void restoreConflictModule() {
    }

    private void exitFSM() {
        String state = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
        if (state == null || !state.equals(FsmState.North2D)) {
            BNSettingManager.setMapMode(1);
        } else {
            BNSettingManager.setMapMode(2);
        }
    }

    public void forceQuitNav() {
        LogUtil.e("RouteGuide", "forceQuitNav: --> ");
        BNWorkerCenter.getInstance().cancelTask(miniMapRequestTask, false);
        BNWorkerCenter.getInstance().cancelTask(this.refreshTotalRemainDistTimeTask, false);
        BNWorkerCenter.getInstance().cancelTask(this.mReAddGpsLocationTask, false);
        RGViewController.getInstance().dismissHUDDialog();
        BNMapController.getInstance().setNaviStatus(false);
        TTSPlayerControl.stopVoiceTTSOutput();
        boolean isSwitch = BNLightNaviSwitchManager.getInstance().getHaveSwitched();
        LogUtil.e("RouteGuide", "forceQuitNav: isSwitch --> " + isSwitch);
        quitNav(isSwitch, false);
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            UserOPController.getInstance().end();
            CommonHandlerThread.getInstance().sendMessage(250);
        }
        UgcSoundsRecordDialog.stopRecordAndDismiss();
    }

    public void quitNav(boolean isSwitch) {
        LogUtil.e("RouteGuide", "quitNav isNaviBegin:" + this.isNaviBegin + " isSwitch:" + isSwitch);
        if (this.isNaviBegin) {
            quitNav(isSwitch, true);
        }
    }

    private void quitNavView(boolean isSwitch) {
        LogUtil.e("RouteGuide", "quitNavView isSwitch:" + isSwitch);
        if (this.mNavTaskExecutor != null) {
            this.mNavTaskExecutor.cancleAll();
            this.mNavTaskExecutor = null;
        }
        VMsgDispatcher.unregisterMsgHandler(this.mRouteGuideUiHandler);
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
        RouteGuideThread.getInstance().unregisterCallback(this.mRGThreadCallback);
        RouteGuideThread.getInstance().removeMessage(501);
        RouteGuideThread.getInstance().removeMessage(502);
        BNWorkerCenter.getInstance().cancelTask(this.mInitFirstRGInfoTask, false);
        BNWorkerCenter.getInstance().cancelTask(this.mStartNavReallyTask, false);
        MapController mapController = BNMapController.getInstance().getMapController();
        if (mapController != null) {
            mapController.stopAllAnimation();
        }
        UgcSoundsRecordDialog.stopRecordAndDismiss();
        RGViewController.getInstance().dismissHUDDialog();
        RGViewController.getInstance().onUgcDestroy();
        RGViewController.getInstance().hideRCStyleGuideView();
        resetRouteSearch();
        BNPowerSaver.getInstance().uninit();
        if (BlueToothListener.sIsOpenBTChannel) {
            BlueToothListener.sIsOpenBTChannel = false;
            RGMapModeViewController.getInstance().closeSCO(14);
        }
        AudioUtils.sIsBTCloseFromPhone = false;
        if (!isSwitch) {
            BusinessActivityManager.getInstance().safetyUpload(1, false);
            BusinessActivityManager.getInstance().isShareSuc = false;
        }
        if (isSwitch && this.mParkNoShown) {
            RGParkPointModel.getInstance().setCanParkPoiShow(false);
        } else {
            RGParkPointModel.getInstance().setCanParkPoiShow(true);
        }
        RGParkPointModel.getInstance().setDoneWithParkSearch(false);
        if (BNOffScreenManager.sIsModelueActive) {
            BNOffScreenManager.getInstance().uninitOffScreen();
        }
        RGNotificationController.getInstance().uninit();
        BNLocationManagerProxy.getInstance().stopNaviLocate();
        resetViewModel();
        LogUtil.e("RouteGuide", "quitNavView END:");
    }

    private void quitNavLogic(boolean isSwitch, boolean isNormalQuit) {
        LogUtil.e("RouteGuide", "quitNavLogic isSwitch:" + isSwitch + " isNormalQuit" + isNormalQuit);
        this.isNaviBegin = false;
        hasCallRerouted = false;
        hasReallyStartedNav = false;
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        RGRouteRecommendModel.getInstance().isViewCanShow = false;
        RGSimpleGuideModel.mIsRPPrefer = false;
        RGSimpleGuideModel.mIsSatellite = false;
        RGSimpleGuideModel.mIsUgcOfficialEvent = false;
        RGMMUGCOperationActMenuView.isViewShow = false;
        BNRCEventDetailsMenuView.isViewShow = false;
        BNSysLocationManager.getInstance().mSensorFingerEnable = false;
        RGCarPreferSettingController.getInstance().reset();
        this.mCanParkPoiOnMapShow = false;
        this.mParkNoShown = false;
        this.bFirstSearchPark = false;
        this.mShowRCFailTimes = 0;
        this.mIsGPSDisable = false;
        BNWorkerCenter.getInstance().cancelTask(this.mFsmRunInitialStateTask, false);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MSG_GPS_ENABLE);
        }
        notifyHUDSDKNavStatus(false);
        BNaviModuleManager.releaseAudioFocus();
        if (!isSwitch) {
            removeGpsLocation();
        }
        RGViewController.getInstance().removeSlightSwitchMsg();
        uninitGPSOpenCloseStateListener();
        uninitMockGpsStateListener();
        unregisterNetworkListener();
        BNWorkerCenter.getInstance().cancelTask(this.mUpdateRCFailTask, false);
        removeOpenBTSCOMessages();
        UnRegisterConnectReceiver();
        BNaviModuleManager.unregisterMapSensorListener();
        BNSysSensorManager.getInstance().uninitSensorFinger();
        if (BNavConfig.pRGLocateMode == 2 && RGMultiRouteModel.getInstance().isEnable()) {
            BNRoutePlaner.getInstance().updateFuncConfigParams();
        }
        if (!isSwitch) {
            BNSettingManager.setQuitForExceptionInNaviMode(false);
        }
        BNRouteGuider.getInstance().SetFullViewState(false);
        BNRouteGuider.getInstance().setGuideEndType(0);
        BNRouteGuider.getInstance().stopRouteGuide();
        BNRoutePlaner.getInstance().cancleCalcWhenQuitNavi();
        unInitRouteGuider();
        BNMapController.getInstance().setHighLightRoute(0, 0);
        this.mCurrentRouteGPCnt = BNRouteGuider.getInstance().getCurrentRouteGPCnt();
        if (this.mCurrentRouteGPCnt != 0) {
            NaviStatItem.getInstance().mEnlargementRatioStr = NaviStatItem.getInstance().mEnlargementCount + "/" + this.mCurrentRouteGPCnt;
        }
        String voiceIdStr = VoiceHelper.getInstance().getCurrentUsedTTSId();
        if (voiceIdStr == null) {
            NaviStatItem.getInstance().mVoiceIDStr = StatisticsVoiceID.PUTONGHUA_STRING;
        } else if (voiceIdStr.equals("9999")) {
            NaviStatItem.getInstance().mVoiceIDStr = "9999";
        } else {
            NaviStatItem.getInstance().mVoiceIDStr = voiceIdStr;
        }
        MTJStatisticsUtil.mNaviDuration = (SystemClock.elapsedRealtime() - MTJStatisticsUtil.mNaviStartTime) / 1000;
        String naviDuration;
        if (MTJStatisticsUtil.getDurationLevel(MTJStatisticsUtil.mNaviDuration) == RouteLineResConst.LINE_FOOT_GREEN_NORMAL) {
            naviDuration = JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_last_more_than_twohours);
        } else {
            naviDuration = "" + MTJStatisticsUtil.getDurationLevel(MTJStatisticsUtil.mNaviDuration) + JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_minute);
        }
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_END, NaviStatConstants.NAVIGATION_END);
        String uuid = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (StringUtils.isEmpty(uuid)) {
            NaviStatItem.getInstance().mTotalDistance = 0;
        } else {
            NaviStatItem.getInstance().mTotalDistance = JNITrajectoryControl.sInstance.getTrajectoryLength(uuid);
        }
        NaviStatItem.getInstance().setNaviNetworkType(NetworkUtils.getActiveNetworkSubtype());
        NaviStatItem.getInstance().setFellowRealTime();
        NaviStatItem.getInstance().setLandRealTime();
        NaviStatItem.getInstance().setFullViewRealTime();
        NaviStatItem.getInstance().setNorthRealTime();
        CommonHandlerThread.getInstance().sendMessage(101);
        restoreMapView();
        BNMapController.getInstance().setEnlargedStatus(false);
        notifyNaviBeginListener(String.valueOf(0));
        BNEventManager.getInstance().onOtherAction(4, 0, 0, null);
        exitFSM();
        restoreScreenAlwaysOn();
        stopCarLocCountDown();
        if (mCurRoutePoiDBCallback != null) {
            mCurRoutePoiDBCallback.onClear();
        }
        int mode = BNSettingManager.getVoicePersonality();
        if (mode == 0) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_MANDARIN_USAGE, NaviStatConstants.NAVI_MANDARIN_USAGE);
        } else if (mode == 1) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_MCDULL_USAGE, NaviStatConstants.NAVI_MCDULL_USAGE);
        } else if (mode == 3) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_OTHER_FULL_DOSE_USAGE, NaviStatConstants.NAVI_OTHER_FULL_DOSE_USAGE);
        } else {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_RECORDING_USAGE, NaviStatConstants.NAVI_RECORDING_USAGE);
        }
        if (isNormalQuit) {
            BNRecoverNaviHelper.getInstance().clearLastNaviInfo();
            BNRecoverNaviHelper.getInstance().setNaviFlag(BNaviModuleManager.getContext().getApplicationContext(), false);
        }
        CommonHandlerThread.getInstance().removeMessage(302);
        RGLaneLineController.getInstance().uninit();
        RGRouteSortController.getInstance().uninit();
        if (isMapSwitchInited()) {
            setIsMapSwitchInited(false);
            BNMapController.getInstance().destroyMiniMapControl();
        }
        RGScreenStatusReceiver.uninitScreenStatusReceiver();
        LogUtil.e("RouteGuide", "quitNavLogic END");
    }

    private void quitNav(boolean isSwitch, boolean isNormalQuit) {
        LogUtil.e("RouteGuide", "quitNav isSwitch:" + isSwitch + " isNormalQuit:" + isNormalQuit);
        quitNavView(isSwitch);
        quitNavLogic(isSwitch, isNormalQuit);
    }

    public void quitIPONavi(boolean switchFlag) {
        BNavConfig.pRGLocateMode = 0;
        BNRouteGuider.getInstance().stopRouteGuide();
        CommonHandlerThread.getInstance().sendMessage(201);
        NaviStatItem.getInstance().init();
        if (!switchFlag) {
            BusinessActivityManager.getInstance().safetyUpload(1, false);
            BusinessActivityManager.getInstance().isShareSuc = false;
            removeGpsLocation();
            BNSettingManager.setQuitForExceptionInNaviMode(false);
        }
        uninitMockGpsStateListener();
        if (this.mOnNavigationListener != null) {
            this.mOnNavigationListener.onNaviGuideEnd();
        }
    }

    public void onBackPressed() {
        boolean isLastOpen = true;
        PerformStatisticsController.peByType(7, "on_quit_back_press", System.currentTimeMillis());
        if (RGViewController.getInstance().isShowQuitNaviDialog()) {
            RGViewController.getInstance().dismissQuitNaviDialog();
            if (this.mRGSubViewListener != null) {
                this.mRGSubViewListener.onQuitNaviGuide(false, false);
            }
        } else if (RGMapModeViewController.getInstance().isBlueToothUSBGuideVisible()) {
            RGViewController.getInstance().hideBlueToothUSBGuide();
        } else if (RGMapModeViewController.getInstance().isMenuMoreVisible()) {
            if (RGViewController.getInstance().menuMoreViewCloseAble()) {
                RGViewController.getInstance().hideMenuMoreView();
                if (this.mRGSubViewListener != null) {
                    boolean isCurOpen = RGCarPreferSettingController.getInstance().isCarLimitOpen();
                    if ((RGCarPreferSettingController.getInstance().mLastRPPreferSetting & 32) == 0) {
                        isLastOpen = false;
                    }
                    if (isCurOpen != isLastOpen) {
                        RGSimpleGuideModel.mCalcRouteType = 3;
                    }
                    this.mRGSubViewListener.onJudgePreferWithMenuHide();
                }
            }
        } else if (RGMapModeViewController.getInstance().isRouteSearchVisible()) {
            RGViewController.getInstance().hideRouteSearchView();
            int currentPrefer = BNRoutePlaner.getInstance().getCalcPreference();
            if (RGCarPreferSettingController.getInstance().isRPPreferSettingValueChange(currentPrefer)) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_a, Integer.toString(currentPrefer), "1", null);
                RGEngineControl.getInstance().reCalcRoute();
            }
        } else if (RGMapModeViewController.getInstance().isRouteSortViewVisible()) {
            RGViewController.getInstance().hideRouteSortView();
        } else {
            if (FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            } else if (FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            } else if (FsmState.PickPoint.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            } else if (FsmState.RouteItem.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            } else if (RGMapModeViewController.getInstance().isShowRCStyleGuideView()) {
                RGMapModeViewController.getInstance().hideRCStyleGuideView();
                return;
            } else if (RGViewController.getInstance().isUGCFBackMenuVisible()) {
                RGViewController.getInstance().onUgcBackPress();
                return;
            } else if (RGViewController.getInstance().isBNRCEventDetailsMenuVisible()) {
                RGViewController.getInstance().onBNRCEventBackPress();
                return;
            } else if (RGViewController.getInstance().isMenuMoreVisible()) {
                RGViewController.getInstance().hideMenuMoreView();
                return;
            } else if (RGViewController.getInstance().isRouteSearchVisible()) {
                RGViewController.getInstance().hideRouteSearchView();
                RGViewController.getInstance().cancleAutoHideControlPanel();
                RGViewController.getInstance().showControlManualOperatePanel(true);
                return;
            } else if (RGViewController.getInstance().isToolboxOpened()) {
                RGViewController.getInstance().closeToolbox();
                return;
            } else {
                UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "1", null, null);
                RGViewController.getInstance().showQuitNaviDialog(false);
            }
            new RoutePlanObserver(this.mActivity, null).dismissWaitProgressDialog();
        }
    }

    public void forceQuitWithoutDialog() {
        if (this.mRGSubViewListener != null) {
            this.mRGSubViewListener.onQuitNaviGuide(false, false);
        }
    }

    public void resume() {
        LogUtil.e("RouteGuide", "resume START");
        sCanBackgroundSpeak = true;
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            if (hasCalcRouteOk()) {
                if (!RGEnlargeRoadMapModel.getInstance().isAnyEnlargeRoadMapShowing()) {
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$13(this, "resume-" + getClass().getSimpleName(), null), new BNWorkerConfig(2, 0), 100);
                }
                onConfigurationChanged(this.mActivity.getResources().getConfiguration(), false);
                if (BNOffScreenManager.sIsModelueActive && BNOffScreenManager.sIsInOffScreenMode) {
                    BNMapController.getInstance().onPause();
                }
                BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler, true);
            }
            RGViewController.getInstance().hideRGFloatView();
            JNIGuidanceControl.getInstance().setGroundMode(2);
            if (this.mIsFirstResume && this.mNavTaskExecutor != null) {
                this.mNavTaskExecutor.start();
            }
            this.mIsFirstResume = false;
            if (PerformStatItem.sUserTest) {
                PerformStatisticsController.peByType(0, "sdk_routeguide_resume_end", System.currentTimeMillis());
            }
            LogUtil.e("RouteGuide", "resume end");
        }
    }

    private void checkAndShowGPSSettingDialog() {
        if (BNavConfig.pRGLocateMode == 1) {
            if (this.mLocationManager == null || this.mLocationManager.isGpsEnabled()) {
                RGViewController.getInstance().dismissGPSSettingDialog();
            } else {
                RGViewController.getInstance().showGPSSettingDialog();
            }
        } else if (BNavConfig.pRGLocateMode != 5) {
            RGViewController.getInstance().dismissGPSSettingDialog();
        } else if (!(this.mLocationManager == null || this.mLocationManager.isGpsEnabled())) {
            RGViewController.getInstance().showCarGPSSettingDialog();
        }
        RGViewController.getInstance().showRGSimpleGuideSuitableView();
    }

    public void pause() {
        boolean switching = BNLightNaviManager.getInstance().isSwitching();
        LogUtil.e("BNavigator", "pause: switching --> " + switching);
        if (!switching) {
            BNMapController.getInstance().onPause();
        }
    }

    public void start() {
        LogUtil.e("RouteGuide", "BNavigator.start()");
        this.mStartTime = SystemClock.elapsedRealtime();
        NaviStatItem.getInstance().onForground();
        VDeviceAPI.setScreenAlwaysOn(true);
        this.mIsBackground = false;
    }

    public void stop() {
        LogUtil.e("RouteGuide", "BNavigator.stop()");
        if (this.isNaviBegin && sCanBackgroundSpeak && hasCalcRouteOk() && 2 != BNSettingManager.getVoiceMode() && BNSettingManager.isPlayBackgroundSpeak()) {
            long curTime = SystemClock.elapsedRealtime();
            if (!this.hasSpeaked || curTime - this.mStartTime > 60000) {
                this.hasSpeaked = true;
                TTSPlayerControl.playTTS("<usraud>百度地图将持续为您导航</usraud>", 0);
                BNSettingManager.setPlayBackgroundSpeak(false);
            }
            this.mStartTime = curTime;
        }
        NaviStatItem.getInstance().onBackground();
        VDeviceAPI.setScreenAlwaysOn(false);
        this.mIsBackground = true;
        UgcSoundsRecordDialog.stopRecordAndDismiss();
    }

    public void onConfigurationChanged(Configuration newConfig, boolean isConfigurationChanged) {
        if (this.mActivity != null && this.mContext != null) {
            this.mCurOrientation = 2;
            String navState = NavState.NAV_STATE_NAVING;
            if (2 != RGCacheStatus.sOrientation) {
                LogUtil.e("RouteGuide", "Orientation changed!");
                UserOPController.getInstance().add(UserOPParams.COMMON_1_6);
                if (2 == 1) {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410275", "410275");
                } else {
                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410274", "410274");
                }
                if (2 == 2) {
                    NaviStatItem.getInstance().setStartLandTime();
                } else {
                    NaviStatItem.getInstance().setLandRealTime();
                }
                RGCacheStatus.sOrientation = 2;
                RGControlPanelModel.getInstance().setmIsConfigChange(true);
                boolean fullView = RGControlPanelModel.getInstance().getFullviewState();
                navState = RGControlPanelModel.getInstance().getNavState();
                RGViewController.getInstance().onOrientationChanged(newConfig);
                Bundle fsmBundle = new Bundle();
                fsmBundle.putBoolean(FsmParamsKey.ORIENTATION_CHANGE, true);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, fsmBundle);
                if (NavState.NAV_STATE_OPERATE.equals(navState)) {
                    RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                }
                if (fullView) {
                    RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_FULL_VIEW);
                    RGViewController.getInstance().updateZoomViewState();
                }
                if (NavState.NAV_STATE_OPERATE.equals(navState)) {
                    if (RGParkPointModel.getInstance().ismIsParkPointShow()) {
                        onParkSearchShow(RGParkPointModel.getInstance().getParkPoiIndex());
                    } else if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                        showRouteSearchPoiList(RGRouteSearchModel.getInstance().mSearchPoiPager, true);
                        BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), true);
                    } else if (RGPickPointModel.getInstance().isPickPointShow()) {
                        RGViewController.getInstance().updatePickPointView();
                        RGViewController.getInstance().showPickPointView();
                    } else {
                        resetRouteSearch();
                    }
                } else if (NavState.NAV_STATE_NAVING.equals(navState)) {
                    if (RGParkPointModel.getInstance().ismIsParkPointShow()) {
                        RGControlPanelModel.getInstance().setmIsParkSearching(true);
                        BNMapController.getInstance().showLayer(4, true);
                        BNMapController.getInstance().updateLayer(4);
                    } else if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
                        BNMapController.getInstance().showLayer(4, true);
                        BNMapController.getInstance().updateLayer(4);
                    } else if (RGPickPointModel.getInstance().isPickPointShow()) {
                        RGViewController.getInstance().updatePickPointView();
                    } else {
                        resetRouteSearch();
                    }
                }
                RGControlPanelModel.getInstance().setmIsConfigChange(false);
            }
            checkAndShowGPSSettingDialog();
            if (BNRCEventDetailsMenuView.isViewShow) {
                RGViewController.getInstance().showBNRCEventDetailsMenu(this.ugcUidCache);
            }
            if (RGControlPanelModel.mIsRouteSearchVisible) {
                RGViewController.getInstance().showRouteSearchView();
            }
            if (RGControlPanelModel.sIsBlueToothUSBGuideVisible) {
                RGViewController.getInstance().showBlueToothUSBGuide();
            }
            if (RGSimpleGuideModel.mIsSafetyShareGuideShow && RGMapModeViewController.getInstance().getSafetyViewContails() != null) {
                RGMapModeViewController.getInstance().getSafetyViewContails().setVisibility(0);
            }
            BNaviSDKManager.getInstance().SDKNavigatorInit();
            if (isConfigurationChanged) {
                RGNotificationController.getInstance().onConfigurationChanged();
            }
            if (BNSettingManager.isShowNotificationDebug()) {
                RGViewController.getInstance().showNotificationDebugView();
            } else {
                RGViewController.getInstance().hideNotificationDebugView();
            }
            if (RGControlPanelModel.sIsRouteSortViewVisible) {
                RGViewController.getInstance().showRouteSortView();
            }
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        RGViewController.getInstance().onUpdateStyle(dayStyle);
        XDVoiceInstructManager.getInstance().setXDPlan(RGMapModeViewController.getInstance().getOrientation(), 0);
    }

    public void onGpsServiceProcess(Message msg) {
        LogUtil.e("RouteGuide", "onGpsServiceProcess");
        checkAndShowGPSSettingDialog();
    }

    public void onGpsStatusChange(Message msg) {
        boolean z;
        LogUtil.e("sunhao", "BNavigator.MsgDefine.onGpsStatusChange arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
        if (BNSettingManager.isShowJavaLog()) {
            TipTool.onCreateToastDialog(this.mActivity, "来自引擎：gps changed, arg1=" + msg.arg1);
            SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: onGpsStatusChange msg.arg1=" + msg.arg1);
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "From enginee: onGpsStatusChange msg.arg1= " + msg.arg1);
        if (msg.arg1 == 1 && RGSimpleGuideModel.getInstance().getSatelliteNum() > 3) {
            this.mIsGPSDisable = false;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(MSG_GPS_ENABLE);
            }
        }
        if (this.mHandler != null && msg.arg1 == 0) {
            BNWorkerCenter.getInstance().cancelTask(this.mReAddGpsLocationTask, false);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mReAddGpsLocationTask, new BNWorkerConfig(2, 0), 60000);
        } else if (this.mHandler != null && msg.arg1 == 1) {
            BNWorkerCenter.getInstance().cancelTask(this.mReAddGpsLocationTask, false);
        }
        if (RGSimpleGuideModel.getInstance().isGPSFixed()) {
            if (msg.arg1 == 0) {
                if (RouteGuideParams.getRouteGuideMode() == 2) {
                    NaviIPOStatItem instance = NaviIPOStatItem.getInstance();
                    instance.mLostGPSCount++;
                } else {
                    NaviStatItem instance2 = NaviStatItem.getInstance();
                    instance2.mLostGPSCount++;
                }
                NaviMergeStatItem.getInstance().startCountLostLoc();
            } else {
                NaviMergeStatItem.getInstance().endCountLostLoc();
            }
        }
        if (msg.arg1 == 0) {
            z = true;
        } else {
            z = false;
        }
        gpsStatusChangeStatics(z);
        if (msg.arg1 == 0 || msg.arg1 == 1) {
            RGSimpleGuideModel instance3 = RGSimpleGuideModel.getInstance();
            if (msg.arg1 == 1) {
                z = true;
            } else {
                z = false;
            }
            instance3.updateGPSFixed(z);
            if (RGViewController.getInstance().isHighwayViewShowing()) {
                RGViewController.getInstance().showDeviceStateView();
                RGViewController.getInstance().showRGSimpleGuideLeftPanelView();
            }
            RGViewController.getInstance().updateSatelliteNum(RGSimpleGuideModel.getInstance().getSatelliteNum());
            RGViewController.getInstance().showRGSimpleGuideSuitableView();
            RGViewController.getInstance().showHudSuitableView();
            BusinessActivityManager.getInstance().updateGPSFixed(msg.arg1 == 1);
            if (RGSimpleGuideModel.getInstance().isGPSFixed()) {
                RGAssistGuideModel.getInstance().mIsGPSFix = true;
            } else {
                RGAssistGuideModel.getInstance().mIsGPSFix = false;
            }
            RGViewController.getInstance().updateCurCarSpeed();
        }
    }

    private void gpsStatusChangeStatics(boolean lostGPS) {
        if (this.gpsStatusChangeStart.longValue() <= 0) {
            this.gpsStatusChangeStart = Long.valueOf(System.currentTimeMillis());
            this.preGpsStatusLost = lostGPS;
        } else if (this.preGpsStatusLost != lostGPS) {
            if (this.preGpsStatusLost) {
                int timeSum = (int) ((System.currentTimeMillis() - this.gpsStatusChangeStart.longValue()) / 1000);
                if (timeSum <= 0) {
                    timeSum = 1;
                }
                if (RouteGuideParams.getRouteGuideMode() == 2) {
                    UserOPController.getInstance().add(UserOPParams.LOST_GPS_8_3_2, "2", timeSum + "", "");
                } else {
                    UserOPController.getInstance().add(UserOPParams.LOST_GPS_8_3_2, "1", timeSum + "", "");
                }
                LogUtil.e("gpsStatusChangeStatics lost times:", timeSum + "");
            } else {
                this.gpsStatusChangeStart = Long.valueOf(System.currentTimeMillis());
            }
            this.preGpsStatusLost = lostGPS;
        }
    }

    public void onRoutePlanYawing(Message msg) {
        LogUtil.e("RouteGuide", "Yawing onRoutePlanYawing");
        LogUtil.e(ModuleName.GUIDE_INFO, "Yawing onRoutePlanYawing");
        this.mIsYawed = true;
        RGSimpleGuideModel.getInstance().setIsYawing(true);
        RGHUDDataModel.getInstance().setIsYaw(true);
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        if ("HUD".equals(RouteGuideFSM.getInstance().getCurrentState()) || FsmState.HUDMirror.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            LogUtil.e("", "HUD=========111=");
            RGViewController.getInstance().showHudSuitableView();
        } else {
            if (NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState())) {
                enterNavState();
            }
            RGHighwayModel.getInstance().updateExists(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_YAWING_START);
        }
        RGViewController.getInstance().hideAllDialogs();
        resetRouteSearch();
        RGAssistGuideModel.getInstance().reset();
        RGHighwayModel.getInstance().reset();
        RGAvoidTrafficModel.getInstance().setmCanAvoidTrafficShow(false);
        RGMainAuxiliaryModel.getInstance().setmCanMainAuxiliaryShow(false);
        RGUpdateRCFailModel.getInstance().setmCanRCUpdateFialShow(false);
        RGParkPointModel.getInstance().reset();
        RGNotificationController.getInstance().hideAllView(false, false);
        RGViewController.getInstance().hideRCStyleGuideView();
        RGViewController.getInstance().hideAssistInfo();
        RGViewController.getInstance().hideDeviceStateView();
        RGViewController.getInstance().hideMainAuxiliaryBridgeView();
        RGViewController.getInstance().handleLaneLineViewShow(false);
        RGViewController.getInstance().hideHighWayServiceView();
        RGViewController.getInstance().hideReRoutePlanView();
        RGViewController.getInstance().hideRefreshRoadProgess();
        RGViewController.getInstance().showStartYawing();
        RGViewController.getInstance().hideCurRoadNameView();
        BusinessActivityManager.getInstance().onYawing();
        if (this.mBNavigatorListener != null) {
            this.mBNavigatorListener.onYawingRequestStart();
        }
        if (BNOffScreenManager.sIsModelueActive && BNOffScreenManager.sIsInOffScreenMode) {
            BNOffScreenManager.sIsReallyLeave = false;
            BNOffScreenManager.getInstance().handleExitOffScreen();
        }
        NaviStatItem instance = NaviStatItem.getInstance();
        instance.mYawingCount++;
        BNNaviResultModel.getInstance().setYawNum();
        if (this.mNavUserBehaviourCallback != null) {
            this.mNavUserBehaviourCallback.onYawing();
        }
        if (XDVoiceInstructManager.XD_ROUSED) {
            LogUtil.e(ModuleName.XDVoice, "onRoutePlanYawing（） , XDPlan can't show");
            XDVoiceInstructManager.getInstance().closePanel();
            XDVoiceInstructManager.getInstance().setWakeupEnable(false);
        }
        RGMapModeViewController.getInstance().showRGSimpleGuideViewProgress(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_nav_route_plan_yawing_text));
        if (this.mISDKNaviStatusListener != null) {
            this.mISDKNaviStatusListener.onRoutePlanYawing();
        }
    }

    public void onReRouteComplete(Message msg) {
        LogUtil.e("RouteGuide", "Yawing onReRouteComplete");
        LogUtil.e(ModuleName.GUIDE_INFO, "Yawing onReRouteComplete");
        RGSimpleGuideModel.mIsUgcOfficialEvent = false;
        RGSimpleGuideModel.getInstance().setIsYawing(false);
        RGHUDDataModel.getInstance().setIsYaw(false);
        RGSimpleGuideModel.getInstance().updateCarlogoFree(false);
        RGHighwayModel.getInstance().reset();
        RGViewController.getInstance().hideHighWayServiceView();
        RGViewController.getInstance().updateMainAuxiliaryOrBridgeView(0);
        if (RGRouteRecommendModel.getInstance().isViewCanShow) {
            hideRouteRecommend();
        }
        RGViewController.getInstance().showCurRoadNameView();
        RGViewController.getInstance().resetRoadConditionData();
        RGViewController.getInstance().updateRoadCondition();
        RGViewController.getInstance().hideAllDialogs();
        RGViewController.getInstance().hideYawingView();
        RGViewController.getInstance().hideReRoutePlanView();
        RGViewController.getInstance().hideRefreshRoadProgess();
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RGMapModeViewController.getInstance().setmIsShowColladaView(false);
        RGViewController.getInstance().resetColladaView();
        if ("HUD".equals(RouteGuideFSM.getInstance().getCurrentState()) || FsmState.HUDMirror.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            LogUtil.e("", "HUD=========222=");
            RGHUDDataModel.setHighWayModel(false);
            RGViewController.getInstance().hudSwitchToSimpleGuideView();
            RGHUDDataModel.totalDistance = RGEngineControl.getInstance().getTotalDistance();
        } else {
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_YAWING_REROUTED);
        }
        if (this.mBNavigatorListener != null) {
            this.mBNavigatorListener.onYawingRequestSuccess();
        }
        RGLaneLineController.getInstance().handleSimulateHide();
        Bundle data = new Bundle();
        int subResult = BNRoutePlaner.getInstance().getRoutePlanSubResult(null, data);
        LogUtil.e("RouteGuide", "OfflineToOnline getRoutePlanSubResult subResult " + subResult);
        if (BNavConfig.pRGLocateMode != 2 && subResult == 1) {
            RGSimpleGuideModel.mIsOfflineToOnline = true;
            RGViewController.getInstance().requestShowExpendView(10, true);
        }
        if (data != null && data.containsKey("enPlanNetMode")) {
            BNRoutePlaner.getInstance().setRoutePlanNetMode(data.getInt("enPlanNetMode"));
        }
        LogUtil.e(ModuleName.XDVoice, "onReRouteComplete（） , XDPlan setEnable(true)");
        XDVoiceInstructManager.getInstance().closePanel();
        XDVoiceInstructManager.getInstance().setWakeupEnable(true);
        if (this.mISDKNaviStatusListener != null) {
            this.mISDKNaviStatusListener.onReRouteComplete();
        }
    }

    public void onArriveDestNear(Message msg) {
        LogUtil.e("RouteGuide", "onArriveDestNear");
        BNRecoverNaviHelper.getInstance().setNaviFlag(BNaviModuleManager.getContext().getApplicationContext(), false);
        CommonHandlerThread.getInstance().removeMessage(302);
    }

    public void onArriveDest(Message msg) {
        LogUtil.e("RouteGuide", "onArriveDest");
        SDKDebugFileUtil.get(SDKDebugFileUtil.END_GUIDE_FILENAME).add("onArriveDest: will quit routeguide!!!");
        UserOPController.getInstance().add(UserOPParams.COMMON_1_5, "2", null, null);
        BNNaviResultModel.getInstance().setDestArrived(true);
        RGViewController.getInstance().hideParkPointView();
        RGParkPointModel.getInstance().setmIsParkPointShow(false);
        stopCarLocCountDown();
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_QUIT_NORMAL, NaviStatConstants.NAVI_QUIT_NORMAL);
        if (this.mOnNavigationListener != null) {
            this.mOnNavigationListener.notifyOtherAction(0, -1, -1, null);
        }
        RGViewController.getInstance().showQuitNaviDialog(true);
    }

    public void onSimpleGuideInfoShow(Message msg) {
    }

    public void onSimpleGuideInfoUpdate(Message msg) {
        LogUtil.e("RouteGuide", "RGSimpleGuideModel=== onSimpleGuideInfoUpdate");
        Bundle simpleGuideData = getMsgData(msg);
        if (simpleGuideData != null) {
            RGSimpleGuideModel.getInstance().isFirstDataOk = true;
            RGSimpleGuideModel.getInstance().updateCarlogoFree(false);
            int remainDist = simpleGuideData.getInt(SimpleGuideInfo.RemainDist);
            RGSimpleGuideModel.sSimpleGuideBundle = simpleGuideData;
            Bundle data = RGSimpleGuideModel.getInstance().updateNextGuideInfo();
            RGViewController.getInstance().updateSimpleGuideInfo(data);
            RGViewController.getInstance().updateRGFloatView(data, false);
            if (RGViewController.getInstance().getHudShowStatus() && !RGHUDDataModel.isHighWayModel()) {
                RGViewController.getInstance().updateHudInfo(RGHUDDataModel.getInstance().simpleGuideToHUD(data));
            }
            RGHighwayModel.getInstance().setNextPointRemainDist(remainDist);
            RGAssistGuideModel.getInstance().updateCarProgress();
            RGViewController.getInstance().updateCarProgress();
            if (data == null || !data.containsKey(SimpleGuideInfo.CurRoadName)) {
                RGHighwayModel.getInstance().setCurRoadName(null);
                return;
            }
            String curRoadName = data.getString(SimpleGuideInfo.CurRoadName);
            RGSimpleGuideModel.getInstance().updateCurRoadName(curRoadName);
            RGHighwayModel.getInstance().setCurRoadName(curRoadName);
            RGViewController.getInstance().updateCurRoadName();
            RGViewController.getInstance().updateCurRoadName(curRoadName);
        }
    }

    public void onSimpleGuideInfoHide(Message msg) {
    }

    public void onTotalRemainDistTimeUpdate(Message msg) {
        LogUtil.e("RouteGuide", "RGSimpleGuideModel===   onRemainDistTimeUpdate");
        RGViewController.getInstance().updateSimpleGuideInfo(RGSimpleGuideModel.getInstance().updateTotalRemainDistAndTime(msg.arg1, msg.arg2));
        RGViewController.getInstance().updateTotalRemainInfo();
        BNWorkerCenter.getInstance().cancelTask(this.refreshTotalRemainDistTimeTask, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.refreshTotalRemainDistTimeTask, new BNWorkerConfig(2, 0), 60000);
        if (RGSimpleGuideModel.getInstance().mCompletePercentage > 0.1d && !BNNaviResultController.getInstance().hasPreloadView()) {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mInitResultViewTask, new BNWorkerConfig(2, 0), 100);
        }
        RGViewController.getInstance().updateUserCurMileaInfo();
    }

    public void onAssistInfoShow(Message msg) {
        LogUtil.e("RouteGuide", "Assist SHOW");
        RGViewController.getInstance().updateAssistView(RGAssistGuideModel.getInstance().updateAssistData(1, msg.arg1, msg.arg2));
    }

    public void onAssistInfoUpdate(Message msg) {
        LogUtil.e("RouteGuide", "Assist UPDATE");
        RGViewController.getInstance().updateAssistView(RGAssistGuideModel.getInstance().updateAssistData(2, msg.arg1, msg.arg2));
    }

    public void onAssistInfoHide(Message msg) {
        LogUtil.e("RouteGuide", "Assist HIDE");
        RGViewController.getInstance().updateAssistView(RGAssistGuideModel.getInstance().updateAssistData(3, msg.arg1, msg.arg2));
    }

    public void onRasterExpandMapShow(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onRasterExpandMapShow");
        HandleRasterExpandMapShowMsg(msg);
    }

    public void onRasterExpandMapUpdate(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onRasterExpandMapUpdate");
        HandleEnlargeRoadMapUpdateMsg(msg);
    }

    public void onRasterExpandMapHide(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onRasterExpandMapHide");
        HandleEnlargeRoadMapHideMsg(msg);
    }

    public void onDirectBoardShow(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onDirectBoardShow()");
        HandleDirectBoardShowMsg(msg);
    }

    public void onDirectBoardUpdate(Message msg) {
        HandleDirectBoardUpdateMsg(msg);
    }

    public void onDirectBoardHide(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onDirectBoardHide()");
        HandleDirectBoardHideMsg(msg);
    }

    public void onDestStreetViewShow(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onDestStreetViewShow()");
        if (RGViewController.getInstance().isAllowEnlargeMapShow()) {
            Bundle bundle = getMsgData(msg);
            if (bundle == null || bundle.isEmpty()) {
                LogUtil.e("RouteGuide", "ExpandMap type onDestStreetViewShow failed!");
                return;
            }
            RGMapModeViewController.getInstance().resetEnlargeRoadMap();
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.DEST_STREET_VIEW_SHOW, NaviStatConstants.DEST_STREET_VIEW_SHOW);
            Bundle data = RGEnlargeRoadMapModel.getInstance().getStreetViewData(false, bundle);
            LogUtil.e("RouteGuide", "setCurrentAddDist " + RGEnlargeRoadMapModel.getInstance().getmCurrentAddDistance() + " onDestStreetViewShow");
            if (data != null && RGEnlargeRoadMapModel.getInstance().isBGBitmapValid()) {
                RGViewController.getInstance().updateEnlargeRoadMap(data);
                BNScreentShotManager.getInstance().saveImgDirect(RGViewController.getInstance().getRoadmapBgBitmap());
                RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(true);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW);
                RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(98);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, "98", null, null);
            }
        }
    }

    public void onDestStreetViewUpdate(Message msg) {
        if (RouteGuideFSM.getInstance().getTopState() != null && FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            LogUtil.e("RouteGuide", "!# onDestStreetViewUpdate, args: " + msg.arg1 + ", " + msg.arg2);
            Bundle bundle = getMsgData(msg);
            if (bundle == null || bundle.isEmpty()) {
                LogUtil.e("RouteGuide", "!# onDestStreetViewUpdate failed!");
            } else {
                RGViewController.getInstance().updateEnlargeRoadMap(RGEnlargeRoadMapModel.getInstance().getStreetViewData(true, bundle));
            }
        }
    }

    public void onDestStreetViewHide(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type !# onDestStreetViewHide");
        Bundle bundle = getMsgData(msg);
        if (bundle != null && !bundle.isEmpty()) {
            RGEnlargeRoadMapModel.getInstance().setLatestAddDistance(bundle);
            LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + RGEnlargeRoadMapModel.getInstance().getmLatestAddDistance() + " onDestStreetViewHide");
            RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        }
    }

    public void onDestStreetViewStartDownload(Message msg) {
        LogUtil.e("RouteGuide", "!# onDestStreetViewStartDownload");
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.DEST_STREET_VIEW_START_DOWNLOAD, NaviStatConstants.DEST_STREET_VIEW_START_DOWNLOAD);
    }

    public void onDestStreetViewDownloadSuccess(Message msg) {
        LogUtil.e("RouteGuide", "!# onDestStreetViewDownloadSuccess");
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.DEST_STREET_VIEW_DOWNLOAD_SUCCESS, NaviStatConstants.DEST_STREET_VIEW_DOWNLOAD_SUCCESS);
    }

    public void onVectorExpandMapShow(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow");
        if (RGViewController.getInstance().isAllowEnlargeMapShow()) {
            Bundle bundle = getMsgData(msg);
            if (bundle != null) {
                RGMapModeViewController.getInstance().resetEnlargeRoadMap();
                Bundle data = RGEnlargeRoadMapModel.getInstance().getVectorMapData(false, bundle);
                LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + RGEnlargeRoadMapModel.getInstance().getmCurrentAddDistance() + " onVectorExpandMapShow");
                if (data == null || !RGEnlargeRoadMapModel.getInstance().isBGBitmapValid()) {
                    LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow failed to update vector for bg bitmap is invalid.");
                    return;
                }
                int resid = -1;
                if (data.containsKey("resid")) {
                    resid = data.getInt("resid");
                }
                if (resid <= 0) {
                    Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                    if (!(data == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                        data.putInt("resid", nextGuideData.getInt("resid"));
                    }
                }
                RGViewController.getInstance().updateEnlargeMapByShow(data);
                RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(true);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW);
                Bitmap bg = RGViewController.getInstance().getRoadmapBgBitmap();
                BNScreentShotManager.getInstance().saveImgDirect(bg);
                BNEventManager.getInstance().onRasterMapShow(2, Bitmap.createBitmap(1, 1, Config.ARGB_4444), bg);
                RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(4);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, "4", null, null);
            } else {
                LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapShow getVectorExpandMapInfo failed!");
            }
            RGViewController.getInstance().hideMenuMoreView();
            RGViewController.getInstance().hideRouteSearchView();
        }
    }

    public void onVectorExpandMapUpdate(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate");
        if (RouteGuideFSM.getInstance().getTopState() != null && FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate VectorExpandMapUpdate, args: " + msg.arg1 + ", " + msg.arg2);
            Bundle bundle = getMsgData(msg);
            if (bundle != null) {
                Bundle data = RGEnlargeRoadMapModel.getInstance().getVectorMapData(true, bundle);
                int resid = -1;
                if (data.containsKey("resid")) {
                    resid = data.getInt("resid");
                }
                if (resid <= 0) {
                    Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                    if (!(data == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                        data.putInt("resid", nextGuideData.getInt("resid"));
                    }
                }
                RGViewController.getInstance().updateEnlargeRoadMap(data);
                String roadName = RGViewController.getInstance().getRoadmapRoadName();
                int progress = RGViewController.getInstance().getRoadmapProgress();
                BNEventManager.getInstance().onRasterMapUpdate(RGViewController.getInstance().getRoadmapRemainDis(), progress, roadName);
                return;
            }
            LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapUpdate getVectorExpandMapInfo failed!");
        }
    }

    public void onVectorExpandMapHide(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type onVectorExpandMapHide");
        RGEnlargeRoadMapModel.getInstance().setLatestAddDistance((Bundle) msg.obj);
        LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + RGEnlargeRoadMapModel.getInstance().getmLatestAddDistance() + " onVectorExpandMapHide");
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        BNEventManager.getInstance().onRasterMapHide();
    }

    private void HandleRasterExpandMapShowMsg(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type HandleRasterExpandMapShowMsg");
        if (RGViewController.getInstance().isAllowEnlargeMapShow()) {
            RGMapModeViewController.getInstance().resetEnlargeRoadMap();
            Bundle bundle = RGEnlargeRoadMapModel.getInstance().getData(RasterType.GRID, false, msg.arg1, msg.arg2, (Bundle) msg.obj);
            LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + RGEnlargeRoadMapModel.getInstance().getmCurrentAddDistance() + " HandleRasterExpandMapShowMsg");
            if (bundle == null) {
                LogUtil.e("RouteGuide", "failed to update HandleRasterExpandMapShowMsg for bg bitmap is invalid.");
                return;
            }
            if (RGEnlargeRoadMapModel.getInstance().isRasterImageValid(bundle.getString(ExpandMap.BgName), bundle.getString(ExpandMap.ArrowName)) && RGEnlargeRoadMapModel.getInstance().isBGBitmapValid()) {
                String tagContentStr = "";
                if (bundle.containsKey(ExpandMap.TagContent)) {
                    tagContentStr = bundle.getString(ExpandMap.TagContent);
                }
                GuideStatItem.getInstance().add("3.3", tagContentStr + "|s");
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.JUNCTION_STREET_VIEW_DISPLAY, NaviStatConstants.JUNCTION_STREET_VIEW_DISPLAY);
                int resid = -1;
                if (bundle.containsKey("resid")) {
                    resid = bundle.getInt("resid");
                }
                if (resid <= 0) {
                    Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                    if (!(bundle == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                        bundle.putInt("resid", nextGuideData.getInt("resid"));
                    }
                }
                RGViewController.getInstance().updateEnlargeMapByShow(bundle);
                RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(true);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW);
                NaviStatItem instance = NaviStatItem.getInstance();
                instance.mEnlargementCount++;
                RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(bundle.getInt(ExpandMap.GridmapKind));
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, String.valueOf(bundle.getInt(ExpandMap.GridmapKind)), null, null);
                Bitmap bg = RGViewController.getInstance().getRoadmapBgBitmap();
                Bitmap arrow = RGViewController.getInstance().getRoadmapArrowBitmap();
                BNScreentShotManager.getInstance().saveImgDirect(bg);
                BNEventManager.getInstance().onRasterMapShow(1, arrow, bg);
            }
            RGViewController.getInstance().hideMenuMoreView();
            RGViewController.getInstance().hideRouteSearchView();
        }
    }

    private void HandleEnlargeRoadMapHideMsg(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type HandleEnlargeRoadMapHideMsg");
        Bundle bundle = msg.obj;
        RGEnlargeRoadMapModel.getInstance().setLatestAddDistance(bundle);
        String tagContentStr = "";
        if (bundle.containsKey(ExpandMap.TagContent)) {
            tagContentStr = bundle.getString(ExpandMap.TagContent);
        }
        GuideStatItem.getInstance().add("3.3", tagContentStr + "|h");
        LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + RGEnlargeRoadMapModel.getInstance().getmLatestAddDistance() + " HandleEnlargeRoadMapHideMsg");
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        BNEventManager.getInstance().onRasterMapHide();
    }

    private void HandleEnlargeRoadMapUpdateMsg(Message msg) {
        LogUtil.e("RouteGuide", "ExpandMap type HandleEnlargeRoadMapUpdateMsg");
        Bundle bundle = RGEnlargeRoadMapModel.getInstance().getData(RasterType.GRID, true, msg.arg1, msg.arg2, (Bundle) msg.obj);
        if (RouteGuideFSM.getInstance().getTopState() != null && FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            LogUtil.e("RouteGuide", "HandleEnlargeRoadMapUpdateMsg");
            int resid = -1;
            if (bundle.containsKey("resid")) {
                resid = bundle.getInt("resid");
            }
            if (resid <= 0) {
                Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                if (!(bundle == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                    bundle.putInt("resid", nextGuideData.getInt("resid"));
                }
            }
            RGViewController.getInstance().updateEnlargeRoadMap(bundle);
            String roadName = RGViewController.getInstance().getRoadmapRoadName();
            int progress = RGViewController.getInstance().getRoadmapProgress();
            BNEventManager.getInstance().onRasterMapUpdate(RGViewController.getInstance().getRoadmapRemainDis(), progress, roadName);
        }
    }

    private void HandleDirectBoardShowMsg(Message msg) {
        if (RGViewController.getInstance().isAllowEnlargeMapShow()) {
            RGMapModeViewController.getInstance().resetEnlargeRoadMap();
            Bundle bundle = RGEnlargeRoadMapModel.getInstance().getData(RasterType.DIRECT_BOARD, false, msg.arg1, msg.arg2, (Bundle) msg.obj);
            LogUtil.e("RouteGuide", "dingbbin setCurrentAddDist " + RGEnlargeRoadMapModel.getInstance().getmCurrentAddDistance() + " HandleDirectBoardShowMsg");
            if (bundle == null) {
                LogUtil.e("RouteGuide", "failed to update HandleDirectBoardShowMsg for bg bitmap is invalid.");
                return;
            }
            if (RGEnlargeRoadMapModel.getInstance().isRasterImageValid(bundle.getString(ExpandMap.BgName), bundle.getString(ExpandMap.ArrowName)) && RGEnlargeRoadMapModel.getInstance().isBGBitmapValid()) {
                int resid = -1;
                if (bundle.containsKey("resid")) {
                    resid = bundle.getInt("resid");
                }
                if (resid <= 0) {
                    Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                    if (!(bundle == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                        bundle.putInt("resid", nextGuideData.getInt("resid"));
                    }
                }
                RGViewController.getInstance().updateEnlargeRoadMap(bundle);
                RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(true);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW);
                Bitmap bg = RGViewController.getInstance().getRoadmapBgBitmap();
                Bitmap arrow = RGViewController.getInstance().getRoadmapArrowBitmap();
                BNScreentShotManager.getInstance().saveImgDirect(bg);
                BNEventManager.getInstance().onRasterMapShow(1, arrow, bg);
                RGEnlargeRoadMapModel.getInstance().setEnlargeMapTypeForStatisitcs(3);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, "3", null, null);
            }
        }
    }

    private void HandleDirectBoardHideMsg(Message msg) {
        RGEnlargeRoadMapModel.getInstance().setLatestAddDistance((Bundle) msg.obj);
        LogUtil.e("RouteGuide", "dingbbin setLatestAddDistance " + RGEnlargeRoadMapModel.getInstance().getmLatestAddDistance() + " HandleDirectBoardHideMsg");
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RouteGuideFSM.getInstance().run(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        BNEventManager.getInstance().onRasterMapHide();
    }

    private void HandleDirectBoardUpdateMsg(Message msg) {
        Bundle bundle = RGEnlargeRoadMapModel.getInstance().getData(RasterType.DIRECT_BOARD, true, msg.arg1, msg.arg2, (Bundle) msg.obj);
        if (RouteGuideFSM.getInstance().getTopState() != null && FsmState.EnlargeRoadmap.equalsIgnoreCase(RouteGuideFSM.getInstance().getTopState())) {
            int resid = -1;
            if (bundle.containsKey("resid")) {
                resid = bundle.getInt("resid");
            }
            if (resid <= 0) {
                Bundle nextGuideData = RGSimpleGuideModel.getInstance().getNextGuideInfo();
                if (!(bundle == null || nextGuideData == null || !nextGuideData.containsKey("resid"))) {
                    bundle.putInt("resid", nextGuideData.getInt("resid"));
                }
            }
            RGViewController.getInstance().updateEnlargeRoadMap(bundle);
            String roadName = RGViewController.getInstance().getRoadmapRoadName();
            int progress = RGViewController.getInstance().getRoadmapProgress();
            BNEventManager.getInstance().onRasterMapUpdate(RGViewController.getInstance().getRoadmapRemainDis(), progress, roadName);
        }
    }

    @Deprecated
    public void onCurRoadNameUpdate(Message msg) {
        LogUtil.e("RouteGuide", "onCurRoadNameUpdate");
        Bundle data = getMsgData(msg);
        if (data == null || !data.containsKey("road_name")) {
            RGHighwayModel.getInstance().setCurRoadName(null);
            return;
        }
        RGSimpleGuideModel.getInstance().updateCurRoadName(data.getString("road_name"));
        RGHighwayModel.getInstance().setCurRoadName(data.getString("road_name"));
        RGViewController.getInstance().updateCurRoadName();
    }

    public void onHUDUpdate(Message msg) {
        LogUtil.e("RouteGuide", "onHUDUpdate");
    }

    public void onHighwayInfoShow(Message msg) {
        LogUtil.e("RouteGuide", "onHighwayInfoShow");
        Bundle data = getMsgData(msg);
        boolean noHighwayMode = PreferenceHelper.getInstance(this.mActivity).getBoolean(CommonParams.Key.SP_KEY_CARNET_CONNECTED, false);
        RGSimpleGuideModel.getInstance().updateCarlogoFree(false);
        RGHighwayModel.getInstance().updateData(data);
        if (noHighwayMode || !RGHighwayModel.getInstance().isShowHighwayAlongInfo()) {
            RGHUDDataModel.setHighWayModel(false);
            RGHighwayModel.getInstance().updateExists(false);
        } else {
            RGHUDDataModel.setHighWayModel(true);
            RGHighwayModel.getInstance().updateExists(true);
            RouteGuideFSM.getInstance().run(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER);
        }
        if (!FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            RGViewController.getInstance().showHighWayServiceView();
        }
        RGViewController.getInstance().updateHighWayServiceView();
        RGViewController.getInstance().updateRGFloatView(null, true);
        if (RGViewController.getInstance().getHudShowStatus()) {
            RGViewController.getInstance().updateHudInfo(RGHUDDataModel.getInstance().highWayDataToHUD(data));
            RGViewController.getInstance().showHudSuitableView();
        }
        int unRemainDist = -1;
        if (data.containsKey(HighWayInfo.ExitRemainDist)) {
            unRemainDist = data.getInt(HighWayInfo.ExitRemainDist);
        }
        GuideStatItem.getInstance().add("3.4", "d" + unRemainDist + "|s");
    }

    public void onHighwayInfoUpdate(Message msg) {
        LogUtil.e("RouteGuide", "onHighwayInfoUpdate");
        Bundle data = getMsgData(msg);
        RGHighwayModel.getInstance().updateData(data);
        LogUtil.e("RouteGuide", "onHighwayInfoUpdate data: " + data.toString());
        boolean noHighwayMode = PreferenceHelper.getInstance(this.mActivity).getBoolean(CommonParams.Key.SP_KEY_CARNET_CONNECTED, false);
        if (RGHighwayModel.getInstance().isShowHighwayAlongInfo()) {
            RGHUDDataModel.setHighWayModel(true);
            RGHighwayModel.getInstance().updateExists(true);
            if (noHighwayMode || "Highway".equals(RouteGuideFSM.getInstance().getCurrentState())) {
                if (!RGViewController.getInstance().isHighwayViewShowing()) {
                    RGViewController.getInstance().showHighwayView();
                }
                if (!RGViewController.getInstance().isDeviceStateViewShowing()) {
                    RGViewController.getInstance().showDeviceStateView();
                }
                RGViewController.getInstance().updateHighwayView(null);
            } else {
                RouteGuideFSM.getInstance().run(FsmEvent.VIEW_CLICK_HIGHWAY_ENTER);
            }
            RGViewController.getInstance().updateRGFloatView(null, true);
        } else {
            RGHighwayModel.getInstance().updateExists(false);
            RGHUDDataModel.setHighWayModel(false);
            if (RouteGuideFSM.getInstance().getCurrentState().equals("Highway")) {
                RouteGuideFSM.getInstance().run(FsmEvent.VIEW_CLICK_HIGHWAY_EXIT);
            }
            RGViewController.getInstance().updateRGFloatView(null, false);
        }
        if (!FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            RGViewController.getInstance().showHighWayServiceView();
        }
        RGViewController.getInstance().updateHighWayServiceView();
        if (RGViewController.getInstance().getHudShowStatus()) {
            RGViewController.getInstance().updateHudInfo(RGHUDDataModel.getInstance().highWayDataToHUD(data));
            RGViewController.getInstance().showHudSuitableView();
        }
    }

    public void onHighwayInfoHide(Message msg) {
        LogUtil.e("RouteGuide", "onHighwayInfoHide");
        if (RouteGuideFSM.getInstance().getCurrentState().equals("Highway")) {
            RouteGuideFSM.getInstance().run(FsmEvent.VIEW_CLICK_HIGHWAY_EXIT);
        }
        RGHighwayModel.getInstance().reset();
        RGHighwayModel.getInstance().updateExists(false);
        RGHUDDataModel.setHighWayModel(false);
        Bundle data = getMsgData(msg);
        if (data != null) {
            int unRemainDist = -1;
            if (data.containsKey(HighWayInfo.ExitRemainDist)) {
                unRemainDist = data.getInt(HighWayInfo.ExitRemainDist);
            }
            RGViewController.getInstance().hideHighWayServiceView();
            RGViewController.getInstance().updateRGFloatView(null, false);
            GuideStatItem.getInstance().add("3.4", "d" + unRemainDist + "|h");
        }
    }

    public void onSimpleBoardShow(Message msg) {
        LogUtil.e("RouteGuide", "onSimpleBoardShow type: " + msg.what);
        Bundle data = getMsgData(msg);
        if (msg.what == MsgDefine.MSG_NAVI_IN_HIGHWAY_SHOW) {
            RGHighwayModel.getInstance().updateEntryData(data);
        } else if (msg.what == MsgDefine.MSG_NAVI_EXIT_FASTWAY_SHOW) {
            RGHighwayModel.getInstance().updateExitFastwayData(data);
        }
        RGViewController.getInstance().updateHighWayServiceView();
        if (!FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            RGViewController.getInstance().showHighWayServiceView();
        }
    }

    public void onSimpleBoardHide(Message msg) {
        LogUtil.e("RouteGuide", "onSimpleBoardHide type: " + msg.what);
        if (msg.what == MsgDefine.MSG_NAVI_IN_HIGHWAY_HIDE) {
            RGHighwayModel.getInstance().updateEntryData(null);
        } else if (msg.what == MsgDefine.MSG_NAVI_EXIT_FASTWAY_HIDE) {
            RGHighwayModel.getInstance().updateExitFastwayData(null);
        }
        RGViewController.getInstance().updateHighWayServiceView();
    }

    public void onSimpleBoardUpdate(Message msg) {
        LogUtil.e("RouteGuide", "onSimpleBoardUpdate type " + msg.what);
        Bundle data = getMsgData(msg);
        if (msg.what == MsgDefine.MSG_NAVI_IN_HIGHWAY_UPDATE) {
            RGHighwayModel.getInstance().updateEntryData(data);
        } else if (msg.what == MsgDefine.MSG_NAVI_EXIT_FASTWAY_UPDATE) {
            RGHighwayModel.getInstance().updateExitFastwayData(data);
        }
        LogUtil.e("RouteGuide", "onSimpleBoardUpdate BoardData " + data.toString());
        RGViewController.getInstance().updateHighWayServiceView();
        if (!FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
            RGViewController.getInstance().showHighWayServiceView();
        }
    }

    public void onOtherRGInfo(Message msg) {
        switch (msg.what) {
            case 4152:
                LogUtil.e("sunhao", "BNavigator.onOtherRGInfo() MSG_NAVI_Satellite_Fixing_Update");
                if (BNSettingManager.isShowJavaLog()) {
                    TipTool.onCreateToastDialog(this.mActivity, "来自引擎: MSG_NAVI_Satellite_Fixing_Update");
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Satellite_Fixing_Update");
                }
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "From enginee: MSG_NAVI_Satellite_Fixing_Update");
                RGSimpleGuideModel.getInstance().updateGPSFixed(false);
                RGSimpleGuideModel.getInstance().updateSatelliteNum(0);
                RGViewController.getInstance().updateSatelliteNum(0);
                RGViewController.getInstance().showRGSimpleGuideSuitableView();
                RGViewController.getInstance().showHudSuitableView();
                BusinessActivityManager.getInstance().updateGPSFixed(false);
                return;
            case 4153:
                LogUtil.e("sunhao", "BNavigator.onOtherRGInfo() MSG_NAVI_Satellite_Fix_Success_Update");
                if (BNSettingManager.isShowJavaLog()) {
                    TipTool.onCreateToastDialog(this.mActivity, "来自引擎: MSG_NAVI_Satellite_Fix_Success_Update");
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Satellite_Fix_Success_Update");
                }
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "From enginee: MSG_NAVI_Satellite_Fix_Success_Update");
                if (RGSimpleGuideModel.getInstance().getSatelliteNum() > 3) {
                    this.mIsGPSDisable = false;
                    if (this.mHandler != null) {
                        this.mHandler.removeMessages(MSG_GPS_ENABLE);
                    }
                }
                RGSimpleGuideModel.getInstance().updateGPSFixed(true);
                RGViewController.getInstance().updateSatelliteNum(RGSimpleGuideModel.getInstance().getSatelliteNum());
                RGViewController.getInstance().showRGSimpleGuideSuitableView();
                RGViewController.getInstance().showHudSuitableView();
                BusinessActivityManager.getInstance().updateGPSFixed(true);
                return;
            case MsgDefine.MSG_NAVI_Star_State /*4171*/:
                if (BNSettingManager.isShowJavaLog()) {
                    SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From enginee: MSG_NAVI_Star_State  arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                }
                if (SDKDebugFileUtil.getInstance().isShowCoreLog(2, 1, msg.arg2, null, null)) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_GPS, "From enginee: MSG_NAVI_Star_State  arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                }
                LogUtil.e("RouteGuide", "MsgDefine.MSG_NAVI_Star_State arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
                if (msg.arg2 >= 3) {
                    this.mIsGPSDisable = false;
                    if (this.mHandler != null) {
                        this.mHandler.removeMessages(MSG_GPS_ENABLE);
                    }
                }
                RGSimpleGuideModel.getInstance().updateSatelliteNum(msg.arg2);
                RGViewController.getInstance().updateSatelliteNum(msg.arg2);
                if (msg.arg2 >= 3) {
                    RGSimpleGuideModel.mIsSatellite = false;
                    RGNotificationController.getInstance().hideCommonView(102);
                }
                RGAssistGuideModel.getInstance().updateCarProgress();
                RGViewController.getInstance().updateCarProgress();
                return;
            case MsgDefine.MSG_NAVI_CHECK_OTHER_ROUTE /*4172*/:
                int subType = msg.arg1;
                LogUtil.e("RouteGuide", "MSG_NAVI_CHECK_OTHER_ROUTE --> subType =" + subType + " arg2 :" + msg.arg2);
                RGViewController.getInstance().hideRefreshRoadProgess();
                RGViewController.getInstance().dismissAvoidTrafficLoading();
                XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                if (subType == 5) {
                    RGRouteRecommendModel.getInstance().setmSubType(msg.arg1);
                    RGRouteRecommendModel.getInstance().updateEngineNotificationData();
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    RoutePlanModel mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
                    mRoutePlanModel.saveCurRouteNaviBrowseInfo();
                    int routeCnt = BNRoutePlaner.getInstance().getRouteCnt();
                    ArrayList<Bundle> routeResultBundle = new ArrayList();
                    for (int index = 0; index < routeCnt; index++) {
                        Bundle bundle = new Bundle();
                        int ret = BNRoutePlaner.getInstance().getRouteInfo(index, bundle);
                        routeResultBundle.add(bundle);
                    }
                    mRoutePlanModel.parseRouteResultOutline(routeResultBundle);
                    if (routeResultBundle.size() > 0) {
                        mRoutePlanModel.parseRouteResult(this.mContext, (Bundle) routeResultBundle.get(0));
                    }
                    BNMapController.getInstance().clearLayer(13);
                    this.mBNavigatorListener.onPageJump(4, null);
                    return;
                } else if (subType == 4) {
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    return;
                } else if (subType == 3) {
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
                    if (RGRouteRecommendModel.getInstance().mUpdateRouteSource == 2 || RGRouteRecommendModel.getInstance().mUpdateRouteSource == 1) {
                        TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), 1);
                    }
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    return;
                } else if (subType == 0) {
                    RGRouteRecommendModel.getInstance().setmSubType(msg.arg1);
                    RGRouteRecommendModel.getInstance().updateEngineNotificationData();
                    if (msg.arg2 == 1) {
                        RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_switch_success), true);
                        resetViewWhenRouteChange();
                    } else {
                        RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                        if (RGRouteRecommendModel.getInstance().mUpdateRouteSource == 2 || RGRouteRecommendModel.getInstance().mUpdateRouteSource == 1) {
                            TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), 1);
                        }
                    }
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    return;
                } else if (subType == 1) {
                    RGRouteRecommendModel.getInstance().setmSubType(msg.arg1);
                    RGRouteRecommendModel.getInstance().updateEngineNotificationData();
                    RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), false);
                    if (RGRouteRecommendModel.getInstance().mUpdateRouteSource == 2 || RGRouteRecommendModel.getInstance().mUpdateRouteSource == 1) {
                        TTSPlayerControl.playTTS(BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route), 1);
                    }
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    return;
                } else if (subType == 6) {
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    RGRouteRecommendModel.getInstance().setmSubType(msg.arg1);
                    RGRouteRecommendModel.getInstance().setmRouteId(msg.arg2);
                    RGRouteRecommendModel.getInstance().updateEngineNotificationData();
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_8, "" + RGRouteRecommendModel.getInstance().getmPushType(), null, null);
                    resetViewWhenRouteChange();
                    String voiceTips = RGRouteRecommendModel.getInstance().getmVoiceContent();
                    if (voiceTips == null) {
                        return;
                    }
                    if (TTSPlayerControl.getTTSState() == 1) {
                        TTSPlayerControl.stopVoiceTTSOutput();
                        TTSPlayerControl.playFastRouteVoice();
                        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$16(this, "onOtherRGInfo-" + getClass().getSimpleName(), null, voiceTips), new BNWorkerConfig(2, 0), 1000);
                        return;
                    }
                    TTSPlayerControl.playTTS(voiceTips, 0);
                    return;
                } else if (subType == 7 || subType == 13 || subType == 14) {
                    if (LogUtil.LOGGABLE) {
                        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "路线/ugc推送消息: type = " + msg.arg1);
                    }
                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                    RGRouteRecommendModel.getInstance().setmSubType(msg.arg1);
                    RGRouteRecommendModel.getInstance().setmRouteId(msg.arg2);
                    RGRouteRecommendModel.getInstance().updateEngineNotificationData();
                    if (!showRouteRecommend()) {
                        JNIGuidanceControl.getInstance().setShowRouteChoose(0);
                        return;
                    }
                    return;
                } else if (subType == 11) {
                    RGSimpleGuideModel.mIsOfflineToOnline = false;
                    RGViewController.getInstance().requestShowExpendView(10, false);
                    resetViewWhenRouteChange();
                    BNRoutePlaner.getInstance().setEngineCalcRouteNetMode(3);
                    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_offline_to_online_success));
                    return;
                } else if (subType == 12) {
                    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_offline_to_online_failture));
                    return;
                } else {
                    return;
                }
            case MsgDefine.MSG_NAVI_Type_UGC_ChangeRoadResult /*4192*/:
                LogUtil.e("RouteGuide", "MSG_NAVI_Type_UGC_ChangeRoadResult arg1=" + msg.arg1);
                TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route));
                return;
            case MsgDefine.MSG_NAVI_TYPE_SENSORFINGERPRINT_RECORD_START /*4213*/:
                BNSysLocationManager.getInstance().mSensorFingerEnable = true;
                BNSysSensorManager.getInstance().initSensorFinger(this.mContext);
                return;
            case MsgDefine.MSG_NAVI_TYPE_SENSORFINGERPRINT_RECORD_END /*4214*/:
                BNSysLocationManager.getInstance().mSensorFingerEnable = false;
                BNSysSensorManager.getInstance().uninitSensorFinger();
                return;
            case MsgDefine.MSG_NAVI_TYPE_RCTurnKind_Update /*4215*/:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_RCTurnKind_Update =======msg.arg1 " + msg.arg1 + "arg2 " + msg.arg2);
                if (isNaviBegin()) {
                    StringBuffer buf = new StringBuffer();
                    buf.append(msg.arg1);
                    buf.append("d");
                    buf.append(msg.arg2);
                    LogUtil.e("RouteGuide", "format data " + buf.toString());
                    notifyNaviBeginListener(buf.toString());
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_RCRoadInfo_Update /*4217*/:
                int nChangeType = msg.arg1;
                String roadInfo = "g0,f0";
                if (nChangeType == 1) {
                    roadInfo = this.lastGaojia + "f1";
                    this.lastFulu = "f1";
                } else if (nChangeType == 2) {
                    roadInfo = this.lastGaojia + "f0";
                    this.lastFulu = "f0";
                } else if (nChangeType == 4) {
                    roadInfo = "g1" + this.lastFulu;
                    this.lastGaojia = "g1";
                } else if (nChangeType == 8) {
                    roadInfo = "g0" + this.lastFulu;
                    this.lastGaojia = "g0";
                } else if (nChangeType == 5) {
                    roadInfo = "g1,f1";
                    this.lastGaojia = "g1";
                    this.lastFulu = "f1";
                } else if (nChangeType == 9) {
                    roadInfo = "g0,f1";
                    this.lastGaojia = "g0";
                    this.lastFulu = "f1";
                } else if (nChangeType == 6) {
                    roadInfo = "g1,f0";
                    this.lastGaojia = "g1";
                    this.lastFulu = "f0";
                } else if (nChangeType == 10) {
                    roadInfo = "g0,f0";
                    this.lastGaojia = "g0";
                    this.lastFulu = "f0";
                }
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_RCRoadInfo_Update =======nChangeType " + nChangeType + "  roadInfo " + roadInfo);
                if (BNSettingManager.isShowJavaLog()) {
                }
                if (this.mOnNaviBeginListener != null) {
                    this.mOnNaviBeginListener.onRoadInfoUpdate(roadInfo);
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_MAINSLAVE_VIADUCT_CHANGE /*4219*/:
                LogUtil.e("RouteGuide", "peng enter otherRGInfo MSG_NAVI_TYPE_MAINSLAVE_VIADUCT_CHANGE");
                RGViewController.getInstance().updateMainAuxiliaryOrBridgeView(msg.arg1);
                return;
            case MsgDefine.MSG_NAVI_TYPE_SCREEN_BRIGHT /*4386*/:
                if (BNOffScreenManager.sIsModelueActive) {
                    BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "MSG_NAVI_TYPE_SCREEN_BRIGHT");
                    RGOffScreenModel.sCurrentMsgType = 2;
                    RGOffScreenModel.getInstance().isCurrentLocationActive = false;
                    BNOffScreenManager.sIsBrightOffEffect = false;
                    BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "navi_type_screen_bright");
                    BNOffScreenManager.sIsReallyLeave = true;
                    BNOffScreenManager.getInstance().handeMsgBrightAction(2);
                    if (NavState.NAV_STATE_OPERATE.equals(RGControlPanelModel.getInstance().getNavState()) || RGViewController.getInstance().isEnlargeOrColladaShow()) {
                        RGViewController.getInstance().requestShowExpendView(1, false);
                        RGMapModeViewController.getInstance().cleanViewTimeHandler();
                        RGOffScreenModel.getInstance().isInCounting = false;
                    }
                    LogUtil.e(BNOffScreenManager.MODULE_NAME, "MSG_NAVI_TYPE_SCREEN_BRIGHT");
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_SCREEN_OFF /*4387*/:
                if (BNOffScreenManager.sIsModelueActive) {
                    BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "MSG_NAVI_TYPE_SCREEN_OFF");
                    RGOffScreenModel.sCurrentMsgType = 1;
                    BNOffScreenManager.sIsBrightOffEffect = true;
                    BNOffScreenManager.getInstance().handleOffScreenMsg(1);
                    LogUtil.e(BNOffScreenManager.MODULE_NAME, "MSG_NAVI_TYPE_SCREEN_OFF");
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_LANE_INFO_SHOW /*4388*/:
                LogUtil.e(RGLaneInfoModel.TAG, "MSG_NAVI_TYPE_LANE_INFO_SHOW");
                RGLaneInfoModel data = RGLaneInfoModel.getModel(true);
                data.cloneData(BNRouteGuider.getInstance().getLaneInfo(data));
                data.handleShowMessage();
                return;
            case MsgDefine.MSG_NAVI_TYPE_LANE_INFO_HIDE /*4389*/:
                LogUtil.e(RGLaneInfoModel.TAG, "MSG_NAVI_TYPE_LANE_INFO_HIDE");
                RGLaneInfoModel currentModel = RGLaneInfoModel.getModel(false);
                if (currentModel != null) {
                    currentModel.isShow = false;
                }
                RGLaneLineController.getInstance().mLastImalgeIdList.clear();
                RGMapModeViewController.getInstance().requestShowExpendView(7, false, 2);
                return;
            case MsgDefine.MSG_NAVI_TYPE_HUD_GetRouteInfo /*4396*/:
                this.mIsARRouteBuildSuccess = true;
                return;
            case MsgDefine.MSG_NAVI_TYPE_DrivingRoute_HasHide /*4404*/:
                int preId = msg.arg1;
                int disapperIds = msg.arg2;
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_DrivingRoute_HasHide arg1= " + preId + " arg2= " + disapperIds);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_9, "" + preId, "" + JNIGuidanceControl.getInstance().getSelectRouteIdx(), "" + disapperIds);
                if ((((int) Math.pow(2.0d, (double) preId)) & disapperIds) != 0) {
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_3, null, null, null);
                }
                if (RGMultiRouteModel.getInstance().isSwitchButtonShowing && (((int) Math.pow(2.0d, (double) RGMultiRouteModel.getInstance().mSelectedRouteIndex)) & disapperIds) != 0) {
                    RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
                    enterNavState();
                }
                if (RGRouteRecommendModel.getInstance().isViewCanShow && (((int) Math.pow(2.0d, (double) RGRouteRecommendModel.getInstance().getmRouteId())) & disapperIds) != 0) {
                    hideRouteRecommend();
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_SpeedLimit_Update /*4405*/:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_SpeedLimit_Update =======msg.arg1 " + msg.arg1 + "  msg.arg2 " + msg.arg2);
                RGAssistGuideModel.getInstance().mOverSpeed = msg.arg1;
                return;
            case MsgDefine.MSG_NAVI_SessionIDChange /*4414*/:
                LogUtil.e("RouteGuide", "safe MSG_NAVI_SessionIDChange arg1= ");
                BusinessActivityManager.getInstance().safetyUpload(2, false);
                return;
            case MsgDefine.MSG_NAVI_TYPE_COLLADA_SHOW /*4614*/:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_COLLADA_SHOW =======");
                if (RGViewController.getInstance().isAllowEnlargeMapShow()) {
                    RGMapModeViewController.getInstance().setmIsShowColladaView(true);
                    RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_SHOW);
                    NaviStatItem instance = NaviStatItem.getInstance();
                    instance.mColladaCount++;
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_q, "99", null, null);
                    return;
                }
                return;
            case MsgDefine.MSG_NAVI_TYPE_COLLADA_HIDE /*4615*/:
                LogUtil.e("RouteGuide", "MSG_NAVI_TYPE_COLLADA_HIDE ========");
                RGMapModeViewController.getInstance().setmIsShowColladaView(false);
                RouteGuideFSM.getInstance().run(FsmEvent.MSG_COLLADA_HIDE);
                RGViewController.getInstance().resetColladaView();
                return;
            default:
                return;
        }
    }

    private boolean showRouteRecommend() {
        if (BNavConfig.pRGLocateMode == 2) {
            return false;
        }
        if (XDVoiceInstructManager.XD_ROUSED) {
            LogUtil.e(ModuleName.XDVoice, "XDPlan have been shown , can't showRouteRecommend");
            return false;
        } else if (isBackgroundNavi()) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> isBackgroundNavi");
            return false;
        } else if (RGViewController.getInstance().isEnlargeOrColladaShow()) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> isEnlargeOrColladaShow");
            return false;
        } else if (RGViewController.getInstance().isUGCFBackMenuVisible()) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> isUGCFBackMenuVisible");
            return false;
        } else if (RGViewController.getInstance().isBNRCEventDetailsMenuVisible()) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> isBNRCEventDetailsMenuVisible");
            return false;
        } else if (RouteGuideFSM.getInstance().getLastestGlassState() == null || RouteGuideFSM.getInstance().getLastestGlassState().equals(FsmState.BrowseMap)) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> getLastestGlassState = BrowseMap");
            return false;
        } else if (RGMapModeViewController.getInstance().getHudShowStatus()) {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> hud is showing");
            return false;
        } else if (RGRouteRecommendModel.getInstance().isParamsCorrect()) {
            RGRouteRecommendModel.getInstance().isViewCanShow = true;
            JNIGuidanceControl.getInstance().setShowRouteChoose(1);
            if (RGRouteRecommendModel.getInstance().getmSubType() == 7 || RGRouteRecommendModel.getInstance().getmSubType() == 13) {
                enterFullViewState();
                BNMapController.getInstance().setHighLightAvoidTrafficRoute(RGRouteRecommendModel.getInstance().getmRouteId());
            }
            RGNotificationController.getInstance().showRouteRecommend();
            LogUtil.e("RouteGuide", "showRouteRecommend: mVoiceBroadType --> " + RGRouteRecommendModel.getInstance().getmVoiceBroadType());
            if (RGRouteRecommendModel.getInstance().getmVoiceBroadType() == 1) {
                String voiceTips = RGRouteRecommendModel.getInstance().getmVoiceContent();
                if (voiceTips != null) {
                    TTSPlayerControl.stopVoiceTTSOutput();
                    TTSPlayerControl.playFastRouteVoice();
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$17(this, "showRouteRecommend-" + getClass().getSimpleName(), null, voiceTips), new BNWorkerConfig(2, 0), 1000);
                }
            }
            LogUtil.e(ModuleName.XDVoice, "showRouteRecommend have been shown , XDPlan can't show！");
            XDVoiceInstructManager.getInstance().setWakeupEnable(false);
            return true;
        } else {
            LogUtil.e("RouteGuide", "showRouteRecommend: --> params error");
            return false;
        }
    }

    private void hideRouteRecommend() {
        RGRouteRecommendModel.getInstance().isViewCanShow = false;
        RGNotificationController.getInstance().hideOperableView(103);
        enterNavState();
        JNIGuidanceControl.getInstance().setShowRouteChoose(2);
        BNMapController.getInstance().recoveryHighLightRoute();
    }

    private boolean showJamReport() {
        if (BNavConfig.pRGLocateMode == 2) {
            return false;
        }
        if (XDVoiceInstructManager.XD_ROUSED) {
            LogUtil.e(ModuleName.XDVoice, "XDPlan have been shown , can't showRouteRecommend");
            return false;
        } else if (isBackgroundNavi()) {
            LogUtil.e("RouteGuide", "showJamReport: --> isBackgroundNavi");
            return false;
        } else if (RGViewController.getInstance().isEnlargeOrColladaShow()) {
            LogUtil.e("RouteGuide", "showJamReport: --> isEnlargeOrColladaShow");
            return false;
        } else if (RGViewController.getInstance().isUGCFBackMenuVisible()) {
            LogUtil.e("RouteGuide", "showJamReport: --> isUGCFBackMenuVisible");
            return false;
        } else if (RGViewController.getInstance().isBNRCEventDetailsMenuVisible()) {
            LogUtil.e("RouteGuide", "showJamReport: --> isBNRCEventDetailsMenuVisible");
            return false;
        } else if (RouteGuideFSM.getInstance().getLastestGlassState() == null || RouteGuideFSM.getInstance().getLastestGlassState().equals(FsmState.BrowseMap)) {
            LogUtil.e("RouteGuide", "showJamReport: --> getLastestGlassState = BrowseMap");
            return false;
        } else if (RGMapModeViewController.getInstance().getHudShowStatus()) {
            LogUtil.e("RouteGuide", "showJamReport: --> hud is showing");
            return false;
        } else {
            RGJamReportModel.getInstance().isViewCanShow = true;
            JNIGuidanceControl.getInstance().setShowRouteChoose(1);
            RGNotificationController.getInstance().showJamReport();
            return true;
        }
    }

    public void hideJamReport() {
        RGJamReportModel.getInstance().isViewCanShow = false;
        RGNotificationController.getInstance().hideOperableView(108);
        enterNavState();
        JNIGuidanceControl.getInstance().setShowRouteChoose(2);
    }

    public boolean isARRouteBuildSuccess() {
        return this.mIsARRouteBuildSuccess;
    }

    public void jumpWhenRoutePlanFail() {
        LogUtil.e("RouteGuide", "jumpWhenRoutePlanFail");
        quitNav(false);
        if (this.mBNavigatorListener != null) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNavigator$18(this, "jumpWhenRoutePlanFail-" + getClass().getSimpleName(), null), new BNWorkerConfig(2, 0));
        }
    }

    private void showReRoutePlanNotification(boolean success) {
        if (success) {
            RGNotificationController.getInstance().showLocalRoute(false);
        }
        switch (RGSimpleGuideModel.mCalcRouteType) {
            case 1:
                String addViaStr;
                if (success) {
                    addViaStr = BNStyleManager.getString(C4048R.string.nsdk_string_rg_add_via_success);
                } else {
                    addViaStr = BNStyleManager.getString(C4048R.string.nsdk_string_rg_add_via_fail);
                }
                RGNotificationController.getInstance().showCommonResultMsg(addViaStr, success);
                break;
            case 3:
                String carPlateStr;
                if (!success) {
                    carPlateStr = BNStyleManager.getString(C4048R.string.nsdk_string_rg_route_plan_fail);
                } else if (RGCarPreferSettingController.getInstance().isCarLimitOpen()) {
                    carPlateStr = BNStyleManager.getString(C4048R.string.nsdk_string_rg_car_limit_open);
                } else {
                    carPlateStr = BNStyleManager.getString(C4048R.string.nsdk_string_rg_car_limit_close);
                }
                RGNotificationController.getInstance().showCommonResultMsg(carPlateStr, success);
                RGSimpleGuideModel.mIsRPPrefer = false;
                break;
            case 4:
                RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_switch_car_park_success), success);
                break;
            default:
                if (success) {
                    if (RGSimpleGuideModel.mIsRPPrefer && RGNotificationController.getInstance().getLocalRouteType() != 1) {
                        RGNotificationController.getInstance().showRPPrefer();
                        RGSimpleGuideModel.mIsRPPrefer = false;
                        break;
                    }
                }
                RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_route_plan_fail), false);
                break;
        }
        RGSimpleGuideModel.mCalcRouteType = 0;
    }

    private void resetViewWhenRouteChange() {
        RGSimpleGuideModel.mIsUgcOfficialEvent = false;
        RGNotificationController.getInstance().hideCommonView(109);
        RGViewController.getInstance().hideAllDialogs();
        RGViewController.getInstance().hideHighWayServiceView();
        RGEnlargeRoadMapModel.getInstance().setAnyEnlargeRoadMapShowing(false);
        RGMapModeViewController.getInstance().setmIsShowColladaView(false);
        RGViewController.getInstance().resetColladaView();
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        RGLaneLineController.getInstance().handleSimulateHide();
        RGViewController.getInstance().hideRCStyleGuideView();
        RGViewController.getInstance().hideReRoutePlanView();
        RGViewController.getInstance().hideYawingView();
        if (RGRouteRecommendModel.getInstance().isViewCanShow) {
            hideRouteRecommend();
        }
        String currentState = RouteGuideFSM.getInstance().getCurrentState();
        if (FsmState.EnlargeRoadmap.equals(currentState) || FsmState.Colladamap.equals(currentState)) {
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
        }
        if ("Highway".equals(RouteGuideFSM.getInstance().getCurrentState())) {
            RouteGuideFSM.getInstance().run(FsmEvent.VIEW_CLICK_HIGHWAY_EXIT);
        }
        currentState = RouteGuideFSM.getInstance().getCurrentState();
        if ("HUD".equals(currentState) || FsmState.HUDMirror.equals(currentState)) {
            RGHUDDataModel.setHighWayModel(false);
            RGViewController.getInstance().hudSwitchToSimpleGuideView();
            RGHUDDataModel.totalDistance = RGEngineControl.getInstance().getTotalDistance();
        }
        RGHighwayModel.getInstance().reset();
        resetRouteSearch();
        if (!(FsmState.North2D.equals(RouteGuideFSM.getInstance().getLastestGlassState()) && FsmState.Car3D.equals(RouteGuideFSM.getInstance().getLastestGlassState()))) {
            enterNavState();
        }
        RGViewController.getInstance().resetRoadConditionData();
        RGViewController.getInstance().updateRoadCondition();
    }

    public void onRGSyncOperation(Message msg) {
        if (4 == msg.arg1 && this.mBNavigatorListener != null) {
            this.mBNavigatorListener.notifyStartNav();
        }
    }

    public void switchRouteViewMode() {
        if (FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_ENLARGE_ROAD_MAP);
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$21(this, "switchRouteViewModeTask", null), new BNWorkerConfig(2, 0), 650);
            return;
        }
        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_FULL_VIEW);
    }

    public void turnOnEnlargeRoadMap() {
        if (this.bInitialized) {
            BNRouteGuider.getInstance().turnOnEnlargeRoadMap();
        }
    }

    public void turnOffEnlargeRoadMap() {
        if (this.bInitialized) {
            BNRouteGuider.getInstance().turnOffEnlargeRoadMap();
        }
    }

    public boolean isNaviBegin() {
        return this.isNaviBegin;
    }

    public boolean isNaviYawed() {
        return this.mIsYawed;
    }

    private void resetViewModel() {
        LogUtil.e("RouteGuide", "resetViewModel");
        RGSimpleGuideModel.getInstance().reset();
        RGControlPanelModel.getInstance().reset();
        RGAssistGuideModel.getInstance().reset();
        RGEnlargeRoadMapModel.getInstance().reset();
        RGPickPointModel.getInstance().reset();
        if (BNavConfig.pRGLocateMode != 2) {
            RGRouteItemModel.getInstance().reset();
        }
        RGRouteSearchModel.getInstance().reset();
        RGHighwayModel.getInstance().reset();
    }

    private Bundle getMsgData(Message msg) {
        if (msg == null || !(msg.obj instanceof Bundle)) {
            return null;
        }
        return (Bundle) msg.obj;
    }

    private void initGPSOpenCloseStateListener() {
        if ((BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5) && this.mActivity != null) {
            if (this.mGPSOpenCloseStateObs == null) {
                this.mGPSOpenCloseStateObs = new BNavigator$23(this, new BNavigator$22(this));
            }
            Uri uri = Secure.getUriFor("location_providers_allowed");
            if (uri != null && this.mActivity.getContentResolver() != null) {
                try {
                    this.mActivity.getContentResolver().registerContentObserver(uri, false, this.mGPSOpenCloseStateObs);
                } catch (Exception e) {
                    LogUtil.e("RouteGuide", "registerContentObserver Exception");
                }
            }
        }
    }

    private void uninitGPSOpenCloseStateListener() {
        if ((BNavConfig.pRGLocateMode == 1 || BNavConfig.pRGLocateMode == 5) && this.mActivity != null && this.mGPSOpenCloseStateObs != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.mGPSOpenCloseStateObs);
        }
    }

    private void initMockGpsStateListener() {
        if (VERSION.SDK_INT < 23 && this.mActivity != null) {
            if (this.mMockGpsStateObs == null) {
                this.mMockGpsStateObs = new BNavigator$25(this, new BNavigator$24(this));
            }
            if (this.mActivity != null && this.mActivity.getContentResolver() != null) {
                this.mActivity.getContentResolver().registerContentObserver(Secure.getUriFor("mock_location"), false, this.mMockGpsStateObs);
            }
        }
    }

    private void uninitMockGpsStateListener() {
        if (VERSION.SDK_INT < 23) {
            if (!(this.mActivity == null || this.mMockGpsStateObs == null || this.mActivity.getContentResolver() == null)) {
                this.mActivity.getContentResolver().unregisterContentObserver(this.mMockGpsStateObs);
            }
            BNWorkerCenter.getInstance().cancelTask(this.mockToastTask, false);
        }
    }

    private void checkMockGpsState(boolean onchange) {
        if (VERSION.SDK_INT < 23 && this.mActivity != null) {
            int mockState = Secure.getInt(this.mActivity.getContentResolver(), "mock_location", 0);
            if (mockState == 1 && BusinessActivityManager.getInstance().getModel() != null) {
                BusinessActivityManager.getInstance().getModel().isNeedUploadDataFromLocal = false;
            }
            if (mockState == 1 && !RGCacheStatus.sMockGpsGuide) {
                RGCacheStatus.sMockGpsGuide = true;
                if (onchange) {
                    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_mock_gps_open));
                } else {
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mockToastTask, new BNWorkerConfig(2, 0), BNOffScreenParams.MIN_ENTER_INTERVAL);
                }
            }
        }
    }

    private void handleLongPress(MotionEvent e) {
        if (BNavConfig.pRGLocateMode != 2) {
            GeoPoint geoPt = BNMapController.getInstance().getGeoPosByScreenPos((int) e.getX(), (int) e.getY());
            RGPickPointModel.getInstance().updatePickPoint(geoPt);
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setAntiGeoPoint(geoPt);
            int netMode = 1;
            if (1 == 1 && !NetworkUtils.isNetworkAvailable(this.mContext)) {
                netMode = 0;
            }
            LogUtil.e("RouteGuide", "asynGetPoiByPoint:point = " + geoPt + "netMode = " + netMode);
            BNPoiSearcher.getInstance().asynGetPoiByPoint(geoPt, netMode, 10000, this.mHandler);
        }
    }

    public void handleBkgClick(int poiIndex) {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                BNMapController.getInstance().updateLayer(4);
                if (RGRouteSearchModel.getInstance().getLastBkgItemId() == poiIndex) {
                    RGViewController.getInstance().hidePickPointView();
                    RGPickPointModel.getInstance().setPickPointShow(false);
                    RGRouteSearchModel.getInstance().resetLastBkgItemId();
                    return;
                }
                RGRouteSearchModel.getInstance().resetLastBkgItemId();
            }
            RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
            List<SearchPoiPager> searchPoiPagerList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
            if (searchPoiPagerList != null && searchPoiPagerList.size() >= 1) {
                SearchPoiPager searchPoiPager = (SearchPoiPager) searchPoiPagerList.get(0);
                if (searchPoiPager != null) {
                    List<SearchPoi> poiList = searchPoiPager.getPoiList();
                    if (poiList != null && poiIndex >= 0 && poiIndex < poiList.size()) {
                        SearchPoi searchPoi = (SearchPoi) poiList.get(poiIndex);
                        if (searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
                            if (TextUtils.isEmpty(searchPoi.mAddress)) {
                                LogUtil.e("RouteGuide", "handleBkgClick return searchPoi mAddress is null");
                                return;
                            } else if (RGEngineControl.getInstance().isViaPoint(searchPoi.mViewPoint)) {
                                LogUtil.e("RouteGuide", "handleBkgClick return isViaPoint");
                                return;
                            } else {
                                BNMapController.getInstance().focusItem(4, poiIndex, true);
                                RGPickPointModel.getInstance().updatePickPoint(searchPoi.mViewPoint);
                                RGPickPointModel.getInstance().updateAntiSearchPoi(searchPoi);
                                RGMapModeViewController.getInstance().showControlManualOperatePanel(false);
                                RGViewController.getInstance().mIsPickPointDripShow = false;
                                RGViewController.getInstance().updatePickPointView();
                                RGViewController.getInstance().showPickPointView();
                                RGPickPointModel.getInstance().setPickPointShow(true);
                                RGRouteSearchModel.getInstance().setLastBkgItemId(poiIndex);
                                if (this.mVoiceSearchCallBack != null) {
                                    this.mVoiceSearchCallBack.selectSuccess(searchPoi.mName);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        handleParkBkgClick(poiIndex);
    }

    public void handleVidClick(int poiIndex) {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
                BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
                BNMapController.getInstance().updateLayer(4);
                RGRouteSearchModel.getInstance().resetLastBkgItemId();
            }
            RouteGuideFSM.getInstance().run(FsmEvent.TOUCH_MAP);
            List<SearchPoiPager> searchPoiPagerList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
            if (searchPoiPagerList != null && searchPoiPagerList.size() >= 1) {
                SearchPoiPager searchPoiPager = (SearchPoiPager) searchPoiPagerList.get(0);
                if (searchPoiPager != null) {
                    List<SearchPoi> poiList = searchPoiPager.getPoiList();
                    if (poiList != null && poiIndex >= 0 && poiIndex < poiList.size()) {
                        SearchPoi searchPoi = (SearchPoi) poiList.get(poiIndex);
                        if (searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
                            if (TextUtils.isEmpty(searchPoi.mAddress)) {
                                LogUtil.e("RouteGuide", "handleBkgClick return searchPoi mAddress is null");
                            } else if (RGEngineControl.getInstance().isViaPoint(searchPoi.mViewPoint)) {
                                LogUtil.e("RouteGuide", "handleBkgClick return isViaPoint");
                            } else {
                                BNMapController.getInstance().focusItem(4, poiIndex, true);
                                RGPickPointModel.getInstance().updatePickPoint(searchPoi.mViewPoint);
                                RGPickPointModel.getInstance().updateAntiSearchPoi(searchPoi);
                                RGMapModeViewController.getInstance().showControlManualOperatePanel(false);
                                RGViewController.getInstance().mIsPickPointDripShow = false;
                                RGViewController.getInstance().updatePickPointView();
                                RGViewController.getInstance().showPickPointView();
                                RGPickPointModel.getInstance().setPickPointShow(true);
                                RGRouteSearchModel.getInstance().setLastBkgItemId(poiIndex);
                                if (this.mVoiceSearchCallBack != null) {
                                    this.mVoiceSearchCallBack.selectSuccess(searchPoi.mName);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void handleParkBkgClick(int poiIndex) {
        if (!ForbidDaulClickUtils.isFastDoubleClick(500)) {
            RGMapModeViewController.getInstance().autoHideControlPanelView(10000);
            ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
            if (list != null && list.size() != 0 && poiIndex < list.size() && poiIndex >= 0) {
                SearchParkPoi parkPoi = (SearchParkPoi) list.get(poiIndex);
                RGParkPointModel.getInstance().updateParkPoiIndex(poiIndex);
                RGParkPointModel.getInstance().updateParkPoi(parkPoi);
                RGParkPointModel.getInstance().setmIsParkPointShow(true);
                BNRouteGuider.getInstance().setBrowseStatus(true);
                if (!(RouteGuideFSM.getInstance().getCurrentState() == null || FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState()))) {
                    RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                }
                RGViewController.getInstance().showParkPointView();
                RGViewController.getInstance().updateParkPointView();
                BNMapController.getInstance().focusItem(4, poiIndex, true);
            }
        }
    }

    private void searchDestPark() {
        String endName = "";
        RoutePlanNode node = BNRoutePlaner.currentDesNode;
        if (node != null) {
            SearchCircle circle = new SearchCircle(node.mGeoPoint, 300);
            int netMode = 3;
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                netMode = 2;
            }
            endName = node.mName;
            if (endName.equals(BNStyleManager.getString(C4048R.string.nsdk_string_poi_on_map))) {
                endName = "";
            }
            BNPoiSearcher.getInstance().asynSearchAroudPark(endName, circle, netMode, 3, 10000, this.mSearchHandler);
            LogUtil.e("RouteGuide", "endName = " + endName + "netMode = " + netMode);
        }
    }

    private void showDestPark() {
        if (XDVoiceInstructManager.XD_ROUSED) {
            LogUtil.e(ModuleName.XDVoice, "XDPlan have been shown , showDestPark can't show！");
        } else if (BNavConfig.pRGLocateMode != 2 && BNSettingManager.getPrefParkSearch() && !this.mParkNoShown && RGParkPointModel.getInstance().getCanParkPoiShow()) {
            if (RGParkPointModel.getInstance().getDoneWithParkSearch()) {
                RoutePlanNode node = BNRoutePlaner.currentDesNode;
                if (node.mFrom == 5 || node.mFrom == 4) {
                    setParkNoShow();
                    return;
                }
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_PARK_PUSH, NaviStatConstants.NAVI_PARK_PUSH);
                this.mCanParkShow = true;
                this.mCanParkPoiOnMapShow = true;
                ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
                if (list != null && list.size() != 0) {
                    setNearestParkPoi();
                    String tips = "";
                    SearchParkPoi parkPoi = null;
                    try {
                        parkPoi = RGParkPointModel.getInstance().getNeareastParkPoi();
                    } catch (Exception e) {
                        LogUtil.e("RouteGuide", "getNeareastParkPoi exception");
                    }
                    if (parkPoi != null) {
                        if (parkPoi.mLeftCnt > 0) {
                            tips = String.format("为您找到有空位的停车场，距终点%1$d米", new Object[]{Integer.valueOf(parkPoi.mDistance)});
                        } else {
                            tips = String.format("为您找到停车场，距终点%1$d米", new Object[]{Integer.valueOf(parkPoi.mDistance)});
                        }
                        RGNotificationController.getInstance().showPark();
                        BNMapController.getInstance().showLayer(4, true);
                        ArrayList<GeoPoint> geoPoints = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            geoPoints.add(((SearchParkPoi) it.next()).mGuidePoint);
                        }
                        BNPoiSearcher.getInstance().clearBkgCache();
                        BNPoiSearcher.getInstance().updateBkgCache(geoPoints, 2);
                        BNMapController.getInstance().updateLayer(4);
                        BNMapController.getInstance().showLayer(4, true);
                        setParkNoShow();
                        if (XDUtils.isAsrCanWork() && XDUtils.isInOnLineMode() && !RGMapModeViewController.getInstance().getHudShowStatus()) {
                            XDVoiceInstructManager.getInstance().askNaviToPark(tips, parkPoi.mGuidePoint);
                        } else if (2 != BNSettingManager.getVoiceMode()) {
                            XDUtils.makeParkingSpeak(tips);
                        }
                        LogUtil.e(ModuleName.XDVoice, "showDestPark have been shown , XDPlan can't show！");
                        XDVoiceInstructManager.getInstance().setWakeupEnable(false);
                        return;
                    }
                    return;
                }
                return;
            }
            searchDestPark();
        }
    }

    public void updateParkPointOnMap() {
        if (!this.mCanParkPoiOnMapShow) {
            return;
        }
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            LogUtil.e("RouteGuide", "updateParkPointOnMap reutrn isRouteSearchMode");
        } else {
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNavigator$28(this, "updateParkPointOnMap-" + getClass().getSimpleName(), null), new BNWorkerConfig(2, 0), 100);
        }
    }

    private void setNearestParkPoi() {
        ArrayList<SearchParkPoi> list = new ArrayList(((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi());
        if (list != null && list.size() != 0) {
            int nearDistance = 10000;
            int nearItemIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                SearchParkPoi poi = (SearchParkPoi) list.get(i);
                if (poi != null && poi.mDistance < nearDistance) {
                    nearDistance = poi.mDistance;
                    nearItemIndex = i;
                }
            }
            if (nearItemIndex < list.size()) {
                RGParkPointModel.getInstance().updateNeareastParkPoi((SearchParkPoi) list.get(nearItemIndex));
            }
        }
    }

    private void createSearchHandler() {
        this.mSearchHandler = new BNavigator$29(this, Looper.getMainLooper());
    }

    public int getPoiBkgTypeByName(String name) {
        if (TextUtils.isEmpty(name)) {
            return -1;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Spots)) {
            return 4;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Hotel)) {
            return 5;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Gas_Station)) {
            return 0;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Restaurant)) {
            return 6;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Bank)) {
            return 7;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Toilet)) {
            return 1;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Service)) {
            return 3;
        }
        if (name.equalsIgnoreCase(ActionTypeSearchParams.Park)) {
            return 2;
        }
        return -1;
    }

    private void resetRouteSearch() {
        LogUtil.e("RouteGuide", "resetRouteSearch");
        if (RGRouteSearchModel.getInstance().getLastBkgItemId() > -1) {
            BNMapController.getInstance().focusItem(4, RGRouteSearchModel.getInstance().getLastBkgItemId(), false);
            BNMapController.getInstance().updateLayer(4);
            RGRouteSearchModel.getInstance().resetLastBkgItemId();
        }
        int parkIndex = RGParkPointModel.getInstance().getParkPoiIndex();
        if (parkIndex > -1 || RGParkPointModel.getInstance().ismIsParkPointShow()) {
            RGControlPanelModel.getInstance().setmIsParkSearching(false);
            BNWorkerCenter.getInstance().cancelTask(this.autoHideParkPointTask, false);
            RGViewController.getInstance().hideParkPointView();
            RGParkPointModel.getInstance().setmIsParkPointShow(false);
            BNMapController.getInstance().focusItem(4, parkIndex, false);
            BNMapController.getInstance().updateLayer(4);
            RGParkPointModel.getInstance().updateParkPoiIndex(-1);
        }
        RGViewController.getInstance().hidePickPointView();
        RGPickPointModel.getInstance().setPickPointShow(false);
        RGRouteSearchModel.getInstance().isSearching = false;
        RGRouteSearchModel.getInstance().mSearchPoiPager = null;
        RGRouteSearchModel.getInstance().setRouteSearchMode(false);
        BNPoiSearcher.getInstance().clearPoiCache();
        BNPoiSearcher.getInstance().clearBkgCache();
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().clearLayer(4);
        BNMapController.getInstance().showLayer(4, false);
        BNMapController.getInstance().sendCommandToMapEngine(6, null);
        RGViewController.getInstance().updateControlPanelView();
    }

    private void updatePoiBkgLayer(ArrayList<SearchPoi> searchPois, int type) {
        BNMapController.getInstance().updateLayer(3);
        if (searchPois != null) {
            BNPoiSearcher.getInstance().clearBkgCache();
            ArrayList<GeoPoint> geoList = new ArrayList(searchPois.size());
            for (int i = 0; i < searchPois.size(); i++) {
                SearchPoi poi = (SearchPoi) searchPois.get(i);
                if (poi != null) {
                    geoList.add(poi.mViewPoint);
                }
            }
            BNPoiSearcher.getInstance().updateBkgCache(geoList, type);
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().sendCommandToMapEngine(5, null);
            boolean isVertical = this.mCurOrientation == 1;
            Rect rect = new Rect();
            if (isVertical) {
                rect.left = 0;
                rect.top = (ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight()) - ((int) (0.5f + JarUtils.getResources().getDimension(C4048R.dimen.nsdk_rg_top_panel_height)));
                rect.right = ScreenUtil.getInstance().getWidthPixels();
                rect.bottom = (int) (0.5f + JarUtils.getResources().getDimension(C4048R.dimen.nsdk_rg_cp_bottom_height));
            } else {
                rect.left = ScreenUtil.getInstance().getHeightPixels() / 4;
                rect.top = ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().getStatusBarHeight();
                rect.right = ScreenUtil.getInstance().getHeightPixels();
                rect.bottom = (int) JarUtils.getResources().getDimension(C4048R.dimen.nsdk_rg_cp_bottom_height);
            }
            List<SearchPoi> mapViewList = new ArrayList(searchPois);
            GeoPoint carPt = RGEngineControl.getInstance().getCurrentGeoPoint();
            if (carPt != null && carPt.isValid()) {
                SearchPoi startPoi = new SearchPoi();
                startPoi.mViewPoint = carPt;
                mapViewList.add(startPoi);
            }
            SearchPoi endNodePoi = new SearchPoi();
            endNodePoi.mViewPoint = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEndNode().getGeoPoint();
            mapViewList.add(endNodePoi);
            BNMapController.getInstance().updateMapView(mapViewList, rect, isVertical, AnimationType.eAnimationViewall, 1000);
        }
    }

    private void initRGSubViewListener() {
        this.mRGSubViewListener = new BNavigator$30(this);
    }

    public void actionRouteRecommendClick(boolean ok, boolean isVoice) {
        TTSPlayerControl.stopVoiceTTSOutput();
        String source = RGRouteRecommendModel.getInstance().mUpdateRouteSource + "";
        int type = RGRouteRecommendModel.getInstance().getmPushType();
        if (ok) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_7, "" + type, isVoice ? "2" : "0", source);
            changeRoute(RGRouteRecommendModel.getInstance().getmRouteId());
            return;
        }
        hideRouteRecommend();
        RGNotificationController.getInstance().showCancelRouteRecommend();
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_s_7, "" + type, isVoice ? "3" : "1", source);
    }

    public void changeRoute(int routeId) {
        if (routeId >= 0) {
            BNRoutePlaner.getInstance().selectRoute(routeId);
            BNMapController.getInstance().updateLayer(10);
            BNMapController.getInstance().clearLayer(23);
        }
    }

    public void onUGCMenuActionOuter() {
        if (this.mRGSubViewListener != null) {
            this.mRGSubViewListener.onUGCMenuAction();
        }
    }

    private void hideInstantViewAciton() {
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        RGMapModeViewController.getInstance().hideMultiRouteSwitcherView(true);
        BNMapController.getInstance().recoveryHighLightRoute();
    }

    public void enterFullViewState() {
        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_FULL_VIEW);
        RGViewController.getInstance().updateZoomViewState();
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (2 == type) {
            switch (subType) {
                case 2:
                    NMapControlProxy.getInstance().zoomOut();
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    return true;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 46:
                case 47:
                case 48:
                case 49:
                case 60:
                case 61:
                case 62:
                case 63:
                    if (needResponse) {
                        return false;
                    }
                    if (needResponse) {
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    }
                    return true;
                case 16:
                    if (needResponse) {
                        if (this.mRGSubViewListener != null) {
                            this.mRGSubViewListener.onFullviewAction();
                        }
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    }
                    return true;
                case 17:
                    if (needResponse) {
                        if (!RGAssistGuideModel.getInstance().getMainAuxiliary() || this.mRGSubViewListener == null) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 3);
                        } else {
                            this.mRGSubViewListener.onMainAuxiliarySwitch();
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        }
                    }
                    return true;
                case 25:
                    if (needResponse) {
                        if (VoiceCommandHelper.switchNaviMode()) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        } else {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        }
                    }
                    return true;
                case 26:
                    if (needResponse) {
                        if (VoiceCommandHelper.switchAR()) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        } else {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        }
                    }
                    return true;
                case 27:
                    if (needResponse) {
                        if (VoiceCommandHelper.switchHUDMirror()) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        } else {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        }
                    }
                    return true;
                case 28:
                    if (needResponse) {
                        if (VoiceCommandHelper.switchHUD()) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        } else {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        }
                    }
                    return true;
                case 29:
                case 53:
                    if (needResponse) {
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 3);
                    }
                    return true;
                case 30:
                case 50:
                case 52:
                    if (needResponse) {
                        enterNavState();
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    }
                    return true;
                case 38:
                    if (needResponse) {
                        if (this.mRGSubViewListener != null) {
                            this.mRGSubViewListener.onQuitNaviGuide(false, false);
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                        } else {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 2);
                        }
                    }
                    return true;
                case 54:
                    BNSettingManager.setAlwaysBright(true);
                    VDeviceAPI.setScreenAlwaysOn(true);
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    return true;
                case 55:
                    VDeviceAPI.setScreenAlwaysOn(false);
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
                    return true;
            }
        } else if (3 == type) {
            if (needResponse) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 3);
            }
            return true;
        } else if (5 == type) {
            if (needResponse) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 3);
            }
            return true;
        } else if (4 == type) {
            String speakContent = null;
            StringBuffer sb;
            switch (subType) {
                case 1:
                    speakContent = BNStyleManager.getString(C4048R.string.nsdk_string_rg_nav_direction_unknown);
                    if (BNSysLocationManager.getInstance().isSysLocationValid() && BNSysLocationManager.getInstance().getCurLocation() != null) {
                        speakContent = StringUtils.getDirection((double) BNSysLocationManager.getInstance().getCurLocation().direction, speakContent);
                    }
                    speakContent = speakContent + BNStyleManager.getString(C4048R.string.bnav_string_hw_direction);
                    break;
                case 2:
                    speakContent = RGSimpleGuideModel.getInstance().getCurRoadName();
                    break;
                case 3:
                case 4:
                    sb = new StringBuffer();
                    String distS = StringUtils.formatDistanceToChineseString(RGSimpleGuideModel.getInstance().getTotalRemainDist());
                    if (distS != null) {
                        sb.append("还有");
                        sb.append(distS);
                    }
                    String arriveTime = RGSimpleGuideModel.getInstance().getArriveTimeChineseString();
                    if (arriveTime != null) {
                        sb.append("预计");
                        sb.append(arriveTime);
                    }
                    speakContent = sb.toString();
                    break;
                case 5:
                    speakContent = RGSimpleGuideModel.getInstance().getNextGuidanceChineseWord();
                    break;
                case 6:
                    try {
                        sb = new StringBuffer();
                        sb.append("时速");
                        sb.append(StringUtils.numberToChineseWord(Integer.parseInt(RGAssistGuideModel.getInstance().getCurCarSpeed())));
                        sb.append("公里");
                        speakContent = sb.toString();
                        break;
                    } catch (Exception e) {
                        speakContent = null;
                        break;
                    }
                case 7:
                    if (RGAssistGuideModel.getInstance().getCurLimitSpeed() > 0) {
                        sb = new StringBuffer();
                        sb.append("当前道路限速");
                        sb.append(StringUtils.numberToChineseWord(RGAssistGuideModel.getInstance().getCurLimitSpeed()));
                        sb.append("公里");
                        speakContent = sb.toString();
                        break;
                    }
                    speakContent = "当前道路没有限速数据";
                    break;
                case 8:
                    speakContent = RGAssistGuideModel.getInstance().getCurCarPointRoadConditionChineseWord();
                    break;
                case 10:
                    speakContent = "ManualPlaySound";
                    BNRoutePlaner.getInstance().ManualPlaySound();
                    break;
            }
            if (speakContent == null) {
                return false;
            }
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1, speakContent);
            return true;
        }
        return false;
    }

    public void autoHideParkPoint(long delay) {
        LogUtil.e("RouteGuide", "autoHideParkPoint()");
        BNWorkerCenter.getInstance().cancelTask(this.autoHideParkPointTask, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.autoHideParkPointTask, new BNWorkerConfig(2, 0), delay);
    }

    private void onParkSearchShow(int index) {
        ArrayList<SearchParkPoi> mParkPoiList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
        if (mParkPoiList == null || mParkPoiList.size() == 0) {
            RGControlPanelModel.getInstance().setmIsParkSearching(true);
            RGViewController.getInstance().showAvoidTrafficLoading(JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_park_searching));
            if (RGParkPointModel.getInstance().getDoneWithParkSearch()) {
                RGViewController.getInstance().dismissAvoidTrafficLoading();
                return;
            } else {
                searchDestPark();
                return;
            }
        }
        RGControlPanelModel.getInstance().setmHasChangeLevel(true);
        RGControlPanelModel.getInstance().setmLevelBeforeParkSerach(NMapControlProxy.getInstance().getZoomLevel());
        resetRouteSearch();
        RGControlPanelModel.getInstance().setmIsParkSearching(true);
        ArrayList<GeoPoint> geoList = new ArrayList(mParkPoiList.size());
        for (int i = 0; i < mParkPoiList.size(); i++) {
            SearchParkPoi poi = (SearchParkPoi) mParkPoiList.get(i);
            if (poi != null) {
                geoList.add(poi.mViewPoint);
            }
        }
        BNPoiSearcher.getInstance().updateBkgCache(geoList, 2);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().showLayer(4, true);
        this.parkIndex = index;
        BNWorkerCenter.getInstance().cancelTask(this.parkClickTask, false);
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.parkClickTask, new BNWorkerConfig(2, 0), 1200);
    }

    public void stopCarLocCountDown() {
        LogUtil.e("RouteGuide", "stopCarLocCountDown()");
        if (this.mHandler != null && this.carLocDelegate != null) {
            this.mHandler.removeCallbacks(this.carLocDelegate);
        }
    }

    public boolean getCanParkShow() {
        PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
        if (!this.mCanParkShow || poiSearchModel.getSearchParkPoi() == null || poiSearchModel.getSearchParkPoi().size() <= 0) {
            return false;
        }
        return true;
    }

    public void setParkNoShow() {
        this.mParkNoShown = true;
    }

    public void startParkDetailViewCountDown() {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.parkDetailNoActiondelegateTask, new BNWorkerConfig(2, 0), com.baidu.mobstat.Config.BPLUS_DELAY_TIME);
    }

    public void stopParkDetailViewCountDown() {
        BNWorkerCenter.getInstance().cancelTask(this.parkDetailNoActiondelegateTask, false);
    }

    public void setOnNaviBeginListener(BNavigator$OnNaviBeginListener lis) {
        this.mOnNaviBeginListener = lis;
    }

    public BNavigator$OnNaviBeginListener getOnNaviBeginListener() {
        return this.mOnNaviBeginListener;
    }

    private void notifyNaviBeginListener(String turnInfo) {
        BNavigator$OnNaviBeginListener tmpListener = this.mOnNaviBeginListener;
        if (tmpListener != null) {
            tmpListener.onNaviBegin(turnInfo);
        }
    }

    public void setOnHUDSDKnavStatusCallback(BNavigator$OnHUDSDKNavStatusCallback callback) {
        this.mHudSdkNavStatusCallback = callback;
    }

    private void notifyHUDSDKNavStatus(boolean isStart) {
        if (this.mHudSdkNavStatusCallback != null) {
            this.mHudSdkNavStatusCallback.onNaviStatus(isStart);
        }
    }

    public void onReRouteCarFree(Message msg) {
        LogUtil.e("RouteGuide", "onReRouteCarFree");
        RGSimpleGuideModel.getInstance().updateCarlogoFree(true);
        getInstance().onStartCarlogoFree();
        RGViewController.getInstance().showRGSimpleGuideSuitableView();
    }

    public void onStartCarlogoFree() {
        LogUtil.e("RouteGuide", "onStartCarlogoFree");
        RGSimpleGuideModel.getInstance().setIsYawing(false);
        RGHUDDataModel.getInstance().setIsYaw(false);
        RGViewController.getInstance().hideAllDialogs();
    }

    public boolean routeSearchKeywords(String key, Handler handler) {
        this.isVoiceSearch = false;
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_ROUTE_SEARCH_ALL, NaviStatConstants.NAVI_ROUTE_SEARCH_ALL);
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVI_ROUTE_SEARCH_USE_KEYWORDS, key);
        resetRouteSearch();
        if (NetworkUtils.isNetworkAvailable(this.mContext)) {
            RGRouteSearchModel.getInstance().isSearching = true;
            RGViewController.getInstance().showRouteSearchLoading();
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
            return BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(key, 0, 500, 20, 1), 65000, handler);
        }
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_rs_net_error));
        return false;
    }

    public void routeSearchKeywords(String key) {
        RGRouteSearchModel.getInstance().setmLastKey(key);
        BNPoiSearcher.getInstance().cancelQuery();
        routeSearchKeywords(key, this.mSearchHandler);
        this.isVoiceSearch = true;
    }

    public List<SearchPoi> handleRouteSearch(Message msg) {
        return handleRouteSearch(msg, false);
    }

    private List<SearchPoi> handleRouteSearch(Message msg, boolean isGasStationPreference) {
        RGViewController.getInstance().hideRouteSearchLoading();
        if (RGRouteSearchModel.getInstance().isSearching) {
            RGRouteSearchModel.getInstance().isSearching = false;
            RspData rsp = msg.obj;
            if (msg.arg1 == 0) {
                return showRouteSearchPoiList(rsp.mData, false, isGasStationPreference);
            }
            if (this.mVoiceSearchCallBack != null) {
                this.mVoiceSearchCallBack.searchFail(RGRouteSearchModel.getInstance().getmLastKey());
            }
            RGNotificationController.getInstance().showCommonResultMsg(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_search_fail), false);
            LogUtil.e("RouteGuide", "route search pager fail");
            return null;
        }
        LogUtil.e("RouteGuide", "handleRouteSearch has been cancel");
        return null;
    }

    private void handleRouteSearchWithPreference(Message msg) {
        RspData rsp = msg.obj;
        if (msg.arg1 != 0) {
            RGNotificationController.getInstance().showCommonResultMsg(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_search_fail), false);
            LogUtil.e("RouteGuide", "route search pager fail");
            return;
        }
        SearchPoiPager searchPoiPager = rsp.mData;
        if (searchPoiPager == null || 6 != searchPoiPager.getSearchType()) {
            this.hasGasData = false;
            RGRouteSearchModel.getInstance().setmLastKey(ActionTypeSearchParams.Gas_Station);
            routeSearchKeywords(ActionTypeSearchParams.Gas_Station, this.mSearchHandler);
            return;
        }
        ArrayList<SearchPoi> poiList = searchPoiPager.getPoiList();
        if (poiList == null || poiList.size() <= 0) {
            this.hasGasData = false;
            RGRouteSearchModel.getInstance().setmLastKey(ActionTypeSearchParams.Gas_Station);
            routeSearchKeywords(ActionTypeSearchParams.Gas_Station, this.mSearchHandler);
            return;
        }
        handleRouteSearch(msg, true);
        if (this.mNavUserBehaviourCallback != null) {
            this.mNavUserBehaviourCallback.onRoutePlan();
        }
        this.hasGasData = true;
    }

    private List<SearchPoi> showRouteSearchPoiList(SearchPoiPager searchPoiPager, boolean isByOrientationChange) {
        return showRouteSearchPoiList(searchPoiPager, isByOrientationChange, false);
    }

    private List<SearchPoi> showRouteSearchPoiList(SearchPoiPager searchPoiPager, boolean isByOrientationChange, boolean isGasStationPreference) {
        if (searchPoiPager == null || 6 != searchPoiPager.getSearchType()) {
            if (this.mVoiceSearchCallBack != null) {
                this.mVoiceSearchCallBack.searchFail(RGRouteSearchModel.getInstance().getmLastKey());
            }
            RGRouteSearchModel.getInstance().mSearchPoiPager = null;
            RGNotificationController.getInstance().showCommonResultMsg(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_search_fail), false);
            LogUtil.e("RouteGuide", "route search pager is  null");
        } else {
            ArrayList<SearchPoi> poiList = searchPoiPager.getPoiList();
            if (poiList == null || poiList.size() <= 0) {
                if (this.mVoiceSearchCallBack != null) {
                    this.mVoiceSearchCallBack.searchFail(RGRouteSearchModel.getInstance().getmLastKey());
                }
                RGNotificationController.getInstance().showCommonResultMsg(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_search_fail), false);
                LogUtil.e("RouteGuide", "route search return null");
            } else {
                int type;
                if (!this.hasGasData) {
                    TipTool.onCreateToastDialog(this.mContext, "沿途搜用户：“沿途无" + BNSettingManager.getGasStationPreference() + "加油站，已为您推荐其他加油站。");
                }
                LogUtil.e("RouteGuide", "search by route success");
                if (isGasStationPreference) {
                    type = 0;
                } else {
                    type = getPoiBkgTypeByName(searchPoiPager.getSearchKey());
                }
                if (!isByOrientationChange) {
                    RGControlPanelModel.getInstance().setmHasChangeLevel(true);
                    RGControlPanelModel.getInstance().setmLevelBeforeParkSerach(NMapControlProxy.getInstance().getZoomLevel());
                    RGRouteSearchModel.getInstance().setRouteSearchMode(true);
                    RGRouteSearchModel.getInstance().mSearchPoiPager = searchPoiPager;
                }
                if (FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getLastestGlassState())) {
                    RGViewController.getInstance().setToolBoxStatus(1);
                } else {
                    RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
                }
                if (this.isVoiceSearch) {
                    updatePoiBkgLayer(poiList, -1);
                } else {
                    updatePoiBkgLayer(poiList, type);
                }
                RGMapModeViewController.getInstance().showControlManualOperatePanel(false);
                RGViewController.getInstance().updateZoomViewState();
                if (this.mVoiceSearchCallBack == null) {
                    return poiList;
                }
                if (poiList.size() == 0) {
                    handleBkgClick(0);
                    this.mVoiceSearchCallBack.searchOne(RGRouteSearchModel.getInstance().getmLastKey(), ((SearchPoi) poiList.get(0)).mName);
                    return poiList;
                }
                this.mVoiceSearchCallBack.searchSuccess(RGRouteSearchModel.getInstance().getmLastKey(), poiList.size());
                return poiList;
            }
        }
        return null;
    }

    public boolean isBackgroundNavi() {
        return this.mIsBackground;
    }

    public void addGpsLocation() {
        if (5 == BNavConfig.pRGLocateMode) {
            this.mLocationManager = BNExtGPSLocationManager.getInstance();
        }
        if (1 == BNavConfig.pRGLocateMode) {
            this.mLocationManager = BNSysLocationManager.getInstance();
        }
        if (6 == BNavConfig.pRGLocateMode) {
            this.mLocationManager = BNSysLocationManager.getInstance();
        }
        if (this.mLocationManager == null) {
            this.mLocationManager = BNSysLocationManager.getInstance();
        }
        if (this.mLocationManager != null) {
            if (!BNSysLocationManager.getInstance().isLocateInitSuccessful) {
                BNSysLocationManager.getInstance().restartLocateModule();
            }
            if (this.mLocationManager.startNaviLocate(this.mContext)) {
                BNWorkerCenter.getInstance().cancelTask(this.mReAddGpsLocationTask, false);
            } else {
                BNWorkerCenter.getInstance().cancelTask(this.mReAddGpsLocationTask, false);
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mReAddGpsLocationTask, new BNWorkerConfig(2, 0), com.baidu.mobstat.Config.BPLUS_DELAY_TIME);
            }
            this.mLocationManager.addLocationListener(this.mRGLocationLisnter);
        }
    }

    public void removeGpsLocation() {
        if (this.mLocationManager != null) {
            this.mLocationManager.removeLocationListener(this.mRGLocationLisnter);
            this.mLocationManager.stopNaviLocate();
        }
    }

    public void asrStartCall(String number) {
        this.mActivity.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + number)));
    }

    public void asrQuitNavi() {
        if (this.mRGSubViewListener != null) {
            this.mRGSubViewListener.onQuitNaviGuide(false, false);
        }
    }

    public void enterNavState() {
        RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
        RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getEventToLastestMapState());
    }

    public void enterOperateState() {
        RouteGuideFSM.getInstance().run(FsmEvent.MAP_MOVE);
    }

    public void RecoveryLevelAfterParkSerach() {
        if (RGControlPanelModel.getInstance().ismHasChangeLevel()) {
            RGControlPanelModel.getInstance().setmHasChangeLevel(false);
            NMapControlProxy.getInstance().setLevel((float) RGControlPanelModel.getInstance().getmLevelBeforeParkSerach());
        }
    }

    private void registerNetworkListener() {
        NetworkListener.registerMessageHandler(this.mNetChangeHandler);
    }

    private void unregisterNetworkListener() {
        NetworkListener.unRegisterMessageHandler(this.mNetChangeHandler);
    }

    private void onNetStatusChange(int netStatusWwan) {
        if (this.mNetChangeHandler != null) {
            if (1 == netStatusWwan) {
                BNWorkerCenter.getInstance().cancelTask(this.mUpdateRCFailTask, false);
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mUpdateRCFailTask, new BNWorkerConfig(2, 0), HttpsClient.CONN_MGR_TIMEOUT);
                return;
            }
            BNWorkerCenter.getInstance().cancelTask(this.mUpdateRCFailTask, false);
        }
    }

    private void checkTTsVolume() {
        int voiceMode = BNSettingManager.getVoiceMode();
        if (this.mActivity != null && 2 != voiceMode) {
            try {
                AudioManager mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
                if (mAudioManager == null) {
                    LogUtil.e("RouteGuide", "checkTTsVolume fail mAudioManager is null");
                } else if (mAudioManager.getStreamMaxVolume(3) - (mAudioManager.getStreamVolume(3) * 2) > 0) {
                    TipTool.onCreateToastDialog(this.mActivity, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_tts_volume_too_low));
                }
            } catch (Exception e) {
                LogUtil.e("RouteGuide", "checkTTsVolume Exception");
            }
        }
    }

    private boolean isDoubleBackClick() {
        long curBackTime = System.currentTimeMillis();
        if (curBackTime - this.preBackTime < 2000) {
            this.preBackTime = curBackTime;
            return true;
        }
        this.preBackTime = curBackTime;
        return false;
    }

    public void showStatusBar() {
        LogUtil.e("wangyang", "showStatusBar begin");
        if (this.mActivity != null) {
            Window win = this.mActivity.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            winParams.flags &= -1025;
            win.setAttributes(winParams);
            View decorView = win.getDecorView();
            if (decorView == null) {
                LogUtil.e("wangyang", "showStatusBar fail decorView is null");
            } else if (VERSION.SDK_INT < 14) {
                decorView.setSystemUiVisibility(0);
            } else {
                decorView.setSystemUiVisibility(0);
            }
        }
    }

    public LocData getLocDataCache() {
        return this.mLocDataCache;
    }

    private void registerConnectReceiver() {
        UsbListener.registerReceiver(this.mContext);
        UsbListener.registerMessageHandler(this.mHandler);
        BatteryStatusReceiver.initBatteryStatusReceiver(this.mContext);
        RingModeStatusReceiver.initRingModeStatusReceiver(this.mContext);
    }

    private void UnRegisterConnectReceiver() {
        UsbListener.unRegisterMessageHandler(this.mHandler);
        UsbListener.unregisterReceiver(this.mContext);
        BatteryStatusReceiver.uninitBatteryStatusReceiver(this.mContext);
        RingModeStatusReceiver.uninitRingModeStatusReceiver(this.mContext);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 3001 || requestCode == 3002) {
            RGMapModeViewController.getInstance().onMenuMoreActivityResule(requestCode, resultCode, data);
        } else {
            RGMapModeViewController.getInstance().onUgcActivityResult(requestCode, resultCode, data);
        }
    }

    private void checkBlueToothPhoneChannel() {
        if (this.mHandler != null && allowAutoOpenBTPhoneChannel() && !this.mHandler.hasMessages(MSG_TYPE_OPEN_BLUETOOTH_SCO)) {
            this.mHandler.sendEmptyMessageDelayed(MSG_TYPE_OPEN_BLUETOOTH_SCO, BNOffScreenParams.MIN_ENTER_INTERVAL);
        }
    }

    private boolean allowAutoOpenBTPhoneChannel() {
        if (BlueToothListener.isBTConnect && !TextUtils.isEmpty(BlueToothListener.deviceName) && !TextUtils.isEmpty(BNSettingManager.getBlueToothName()) && BlueToothListener.deviceName.equals(BNSettingManager.getBlueToothName()) && BNSettingManager.isBlueToothPhoneChannel()) {
            return true;
        }
        return false;
    }

    public void removeOpenBTSCOMessages() {
        LogUtil.e("RouteGuide", "removeOpenBTSCOMessages");
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MSG_TYPE_OPEN_BLUETOOTH_SCO);
        }
    }

    public void resetWithReCalcRoute() {
        LogUtil.e("RouteGuide", "resetWithReCalcRoute");
        RGSimpleGuideModel.mIsRPPrefer = true;
        RGSimpleGuideModel.mIsSatellite = false;
    }

    public void saveNaviStatInNaviCrash() {
        NaviStatHelper.hasCrashInNavi = true;
        CommonHandlerThread.getInstance().sendMessage(250);
    }

    public void onUGCEventTipsShow() {
        RGSimpleGuideModel.mIsUgcOfficialEvent = true;
        RGNotificationController.getInstance().showUgcOfficialEvent();
    }

    public void onUGCEventTipsHide() {
    }

    public void onGPSWeak(Message msg) {
        LogUtil.e("RouteGuide", "onGPSWeak receive msg");
        RGSimpleGuideModel.mIsSatellite = true;
        RGNotificationController.getInstance().showGPSWeak();
    }

    public boolean hasCalcRouteOk() {
        return hasReallyStartedNav;
    }

    public void showUgcBtnInNavi(boolean show) {
        if (BNavConfig.pRGLocateMode != 2) {
            RGViewController.getInstance().showUgcBtnLayout(show);
        }
    }

    public void setIsMapSwitchInited(boolean mapSwitchInited) {
        this.mIsMapSwitchInited = mapSwitchInited;
    }

    public boolean isMapSwitchInited() {
        return this.mIsMapSwitchInited;
    }

    public void jumpToRecommendVoicePage(Bundle bd) {
        if (this.mBNavigatorListener != null) {
            this.mBNavigatorListener.onPageJump(9, bd);
        }
    }

    public void showUgcDetailView(String eventId, boolean check) {
        showUgcDetailViewSource(eventId, check, 1);
    }

    public void showUgcDetailViewSource(String eventId, boolean check, int source) {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode()) {
            LogUtil.e("RouteGuide", "showUgcDetailViewSource return by isRouteSearchMode");
        } else if (RGSimpleGuideModel.getInstance().isYawing()) {
            LogUtil.e("RouteGuide", "showUgcDetailViewSource return isyawing");
        } else if (check) {
            this.ugcUidCache = eventId;
            BNRCEventDetailsViewController.getInstance().setSource(source);
            RGViewController.getInstance().showBNRCEventDetailsMenu(eventId);
        } else if (this.mContext != null) {
            TipTool.onCreateToastDialog(this.mContext, "感谢您的反馈，我们将尽快处理");
        }
    }

    public void onXDVoiceStart() {
        if (RGRouteSearchModel.getInstance().isRouteSearchMode() && this.mRGSubViewListener != null) {
            this.mRGSubViewListener.onEmptyPoiAction();
        }
    }

    public void onNaviSightChanged(Message m) {
        LogUtil.e("RouteGuide", "navi sight = " + m.arg2);
        switch (m.arg2) {
            case 5:
                if (m.arg1 == 11) {
                    RGMapModeViewController.getInstance().showFuzzyGuideView(false);
                    return;
                } else {
                    RGMapModeViewController.getInstance().showFuzzyGuideView(true);
                    return;
                }
            default:
                RGMapModeViewController.getInstance().showFuzzyGuideView(false);
                return;
        }
    }

    public void onLocationAction(int mode) {
        MapStatus st;
        switch (mode) {
            case 1:
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
            case 2:
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
            case 3:
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.NAVIGATION_ORIENTATE, NaviStatConstants.NAVIGATION_ORIENTATE);
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_9);
                enterNavState();
                return;
            default:
                return;
        }
    }

    public void quitNavi() {
        RGViewController.getInstance().dismissHUDDialog();
        RGViewController.getInstance().dismissQuitNaviDialog();
        RGViewController.getInstance().dismissGPSSettingDialog();
        if (this.mRGSubViewListener != null) {
            this.mRGSubViewListener.onQuitNaviGuide(false, false);
        }
    }

    public void reInitLocationService(int pRGLocateMode) {
        BNavConfig.pRGLocateMode = pRGLocateMode;
        removeGpsLocation();
        addGpsLocation();
    }

    public void onITSAction(boolean openITS) {
        if (this.mRGSubViewListener != null) {
            if (openITS) {
                UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_2, com.baidu.mobstat.Config.APP_VERSION_CODE, null, null);
                if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                    this.mRGSubViewListener.onITSAction(true);
                    return;
                } else {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), BNStyleManager.getString(C4048R.string.nsdk_string_rg_its_real_offline));
                    return;
                }
            }
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_2, "b", null, null);
            this.mRGSubViewListener.onITSAction(false);
        }
    }
}
