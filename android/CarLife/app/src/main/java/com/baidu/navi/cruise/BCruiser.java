package com.baidu.navi.cruise;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.control.CruiseDialogManager;
import com.baidu.navi.cruise.control.CruiseDialogManager.CruiseDialogManagerInterface;
import com.baidu.navi.cruise.control.CruiseMapController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.cruise.view.CruiseMapView;
import com.baidu.navi.cruise.view.CruiseMapView.IQuitCruiseClickListener;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams.RGKey.SimpleGuideInfo;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.cruise.BCruiserConfig;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.cruise.model.CruiseCacheStatus;
import com.baidu.navisdk.ui.cruise.model.CruiseCameraType;
import com.baidu.navisdk.ui.cruise.model.CruiseParams.Key;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNLocateTrackManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.CruiseStatItem;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BCruiser {
    private static final int CRUISE_FOLLOW_QUIT_DETECT_DELAY = 10000;
    private static final int INVALID_ASSIST_REMAIN_DIST = -1;
    private static final String TAG = "Cruise";
    private static volatile BCruiser me = null;
    private Activity mActivity;
    private IBCruiserListener mBCruiserListener;
    private List<OnCruiseBeginListener> mBCruiserListeners = new ArrayList();
    private IQuitCruiseClickListener mBCruiserQuitCruiseClickListener = new C37325();
    private Context mContext;
    private CruiseDialogManagerInterface mCruiseDialogManagerInterface;
    private ILocationListener mCruiseLocationListener = new C37272();
    private CruiseMapView mCruiseMapView = null;
    private CruiseDialogManager mDialogManager;
    private boolean mGPSAvailable = true;
    private boolean mGPSOpened = true;
    private Handler mHandler;
    private boolean mHasLocation = true;
    private boolean mIsCruiseBegin = false;
    private boolean mIsCruiseTypeShowing = false;
    private boolean mIsCruiserStarted = false;
    private boolean mIsItsOpen = false;
    private boolean mIsNeedShowSettingsMenu = false;
    private boolean mIsTrackLocate = false;
    private MsgHandler mMsgHandler;
    private MapGLSurfaceView mNMapView;
    private OnNaviClickListener mOnDownloadClickListener = new C37347();
    private FrameLayout mParentView = null;
    private Vector<OnRGInfoListener> mRGInfoListeners = new Vector(0);
    CruiseStatItem mStatItem;

    /* renamed from: com.baidu.navi.cruise.BCruiser$2 */
    class C37272 implements ILocationListener {

        /* renamed from: com.baidu.navi.cruise.BCruiser$2$1 */
        class C37261 implements Runnable {
            C37261() {
            }

            public void run() {
                if (!BNSysLocationManager.getInstance().isGpsAvailable() && !C1609a.a().b()) {
                    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                }
            }
        }

        C37272() {
        }

        public void onLocationChange(LocData locData) {
        }

        public void onGpsStatusChange(boolean enabled, boolean available) {
            LogUtil.m15791e("Cruise", "onGpsStatusChange: enabled " + enabled + ", available " + available);
            CruiseStatItem cruiseStatItem;
            if (!enabled) {
                new Handler(BCruiser.this.mActivity.getMainLooper()).postDelayed(new C37261(), BNOffScreenParams.MIN_ENTER_INTERVAL);
                if (BCruiser.this.mGPSOpened && BCruiser.this.mGPSAvailable && BCruiser.this.mStatItem != null) {
                    cruiseStatItem = BCruiser.this.mStatItem;
                    cruiseStatItem.mLostGPSCount++;
                }
                BCruiser.this.mGPSOpened = false;
                BCruiser.this.mGPSAvailable = false;
                if (BCruiser.this.mCruiseMapView != null && BCruiser.this.mDialogManager != null) {
                    BCruiser.this.mCruiseMapView.setViewWhenNoGPS();
                    BCruiser.this.mDialogManager.showGPSSettingDialog();
                }
            } else if (enabled) {
                BCruiser.this.mGPSOpened = true;
                BCruiser.this.mDialogManager.dismissGPSSettingDialog();
                BCruiser.this.mGPSAvailable = available;
                if (BCruiser.this.mGPSAvailable) {
                    BCruiser.this.mCruiseMapView.setViewWhenGPSRecover();
                    return;
                }
                BCruiser.this.mCruiseMapView.setViewWhenNotLocated();
                if (BCruiser.this.mStatItem != null) {
                    cruiseStatItem = BCruiser.this.mStatItem;
                    cruiseStatItem.mLostGPSCount++;
                }
            }
        }

        public void onWGS84LocationChange(LocData wgs84LocData, LocData gcj02LocData) {
            BCruiser.this.startRouteCruise();
            if (BCruiser.this.mBCruiserListener != null) {
                BCruiser.this.mBCruiserListener.notifyLoacteData(gcj02LocData);
            }
            CruiseUIModel.getInstance().setLastLocationData(gcj02LocData);
            BCruiser.this.updateLocation(wgs84LocData, gcj02LocData);
        }
    }

    /* renamed from: com.baidu.navi.cruise.BCruiser$3 */
    class C37293 extends Handler {

        /* renamed from: com.baidu.navi.cruise.BCruiser$3$1 */
        class C37281 implements Runnable {
            C37281() {
            }

            public void run() {
                if (!EnterQuitLogicManager.getmInstance().isNetworkAvailable() && !EnterQuitLogicManager.getmInstance().isOffLineDataAvailable()) {
                    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                }
            }
        }

        C37293() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == NetworkListener.MSG_TYPE_NET_WORK_CHANGE) {
                boolean hasNetwork = msg.arg2 == 1;
                CruiseUIModel.getInstance().setConnected(hasNetwork);
                LogUtil.m15791e("Cruise", "recved MSG_TYPE_NET_WORK_CHANGE, connected " + hasNetwork);
                if (hasNetwork) {
                    BCruiser.this.mDialogManager.hideCruiseUnavailableDialog();
                    if (BCruiser.this.mCruiseMapView != null) {
                        BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
                    }
                } else if (!CruiseUIModel.getInstance().isProvinceDataDownloaded()) {
                    new Handler(BCruiser.this.mActivity.getMainLooper()).postDelayed(new C37281(), BNOffScreenParams.MIN_ENTER_INTERVAL);
                    if (BCruiser.this.mCruiseMapView != null) {
                        BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
                    }
                }
                BCruiser.this.mHasLocation = BCruiser.this.hasLocation();
            }
        }
    }

    /* renamed from: com.baidu.navi.cruise.BCruiser$4 */
    class C37314 extends MsgHandler {

        /* renamed from: com.baidu.navi.cruise.BCruiser$4$1 */
        class C37301 implements Runnable {
            C37301() {
            }

            public void run() {
                if (!EnterQuitLogicManager.getmInstance().isGPSDectectingSucess()) {
                    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
                }
            }
        }

        C37314() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4104:
                    BCruiser.this.mIsCruiseTypeShowing = true;
                    BCruiser.this.onAssistInfoShow(msg);
                    BCruiser.this.notifyAssistIconShow(msg);
                    return;
                case 4105:
                    BCruiser.this.onAssistInfoUpdate(msg);
                    BCruiser.this.notifyAssistIconUpdate(msg);
                    return;
                case 4106:
                    BCruiser.this.mIsCruiseTypeShowing = false;
                    BCruiser.this.onAssistInfoHide(msg);
                    BCruiser.this.notifyAssistIconHide(msg);
                    return;
                case 4108:
                    BCruiser.this.onCurrentRoadNameUpdate(msg);
                    return;
                case 4116:
                    LogUtil.m15791e("Cruise", "recved msg: GPS_STATUS_CHANGE, enable " + (msg.arg1 == 1));
                    if (msg.arg1 == 1) {
                        BCruiser.this.mGPSAvailable = true;
                        if (BCruiser.this.mCruiseMapView != null) {
                            if (BCruiser.this.isCruiserAvailable(BCruiser.this.mActivity)) {
                                BCruiser.this.mCruiseMapView.setViewWhenGPSRecover();
                            } else {
                                BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
                            }
                        }
                    } else if (msg.arg1 == 0) {
                        new Handler(BCruiser.this.mActivity.getMainLooper()).postDelayed(new C37301(), BNOffScreenParams.MIN_ENTER_INTERVAL);
                        BCruiser.this.mGPSAvailable = false;
                        if (BCruiser.this.mCruiseMapView != null) {
                            BCruiser.this.mCruiseMapView.setViewWhenNotLocated();
                        }
                        if (BCruiser.this.mStatItem != null) {
                            CruiseStatItem cruiseStatItem = BCruiser.this.mStatItem;
                            cruiseStatItem.mLostGPSCount++;
                        }
                    }
                    BCruiser.this.notifyGpsStatusChange(msg);
                    return;
                case MsgDefine.MSG_NAVI_CRUISE_YAW /*4143*/:
                    LogUtil.m15791e("Cruise", "~~~ MSG_NAVI_CRUISE_YAW received");
                    BCruiser.this.mIsCruiseTypeShowing = false;
                    BCruiser.this.hideCruiseTypeView();
                    return;
                case MsgDefine.MSG_NAVI_CRUISE_SWITCH_NO_DATA /*4149*/:
                    LogUtil.m15791e("Cruise", "received MSG_NAVI_CRUISE_SWITCH_NO_DATA");
                    CruiseUIModel.getInstance().setProvinceDataDownloaded(false);
                    if (BCruiser.this.mCruiseMapView != null) {
                        BCruiser.this.mCruiseMapView.setCurrentRoadVisible(false);
                        if (NetworkUtils.isNetworkAvailable(BCruiser.this.mActivity)) {
                            BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
                            return;
                        } else {
                            BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
                            return;
                        }
                    }
                    return;
                case 4150:
                    LogUtil.m15791e("Cruise", "received MSG_NAVI_CRUISE_SWITCH_EXIST_DATA");
                    BCruiser.this.mHasLocation = BCruiser.this.hasLocation();
                    CruiseUIModel.getInstance().setProvinceDataDownloaded(true);
                    if (BCruiser.this.mCruiseMapView != null) {
                        BCruiser.this.mCruiseMapView.setCurrentRoadVisible(true);
                        BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
                        return;
                    }
                    return;
                case 4151:
                    BCruiser.this.onNetSwitchHide();
                    return;
                case MsgDefine.MSG_NAVI_Star_State /*4171*/:
                    if (BCruiser.this.mCruiseMapView != null) {
                        BCruiser.this.mCruiseMapView.updateSatelliteViews(msg.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            observe(new int[]{4116, 4104, 4105, 4106, MsgDefine.MSG_NAVI_CRUISE_YAW, MsgDefine.MSG_NAVI_CRUISE_SWITCH_NO_DATA, 4150, 4151, 4108, MsgDefine.MSG_NAVI_Star_State});
        }
    }

    /* renamed from: com.baidu.navi.cruise.BCruiser$5 */
    class C37325 implements IQuitCruiseClickListener {
        C37325() {
        }

        public void onClickQuitCruise() {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
    }

    /* renamed from: com.baidu.navi.cruise.BCruiser$6 */
    class C37336 implements OnNaviClickListener {
        C37336() {
        }

        public void onClick() {
            BCruiser.this.notifyCruiseFragmentQuitCruise();
        }
    }

    /* renamed from: com.baidu.navi.cruise.BCruiser$7 */
    class C37347 implements OnNaviClickListener {
        C37347() {
        }

        public void onClick() {
            BCruiser.this.notifyCruiseFragmentNoData(true);
        }
    }

    public interface OnCruiseBeginListener {
        void onCruiseBegin(boolean z);
    }

    public static BCruiser getInstance() {
        if (me == null) {
            synchronized (BCruiser.class) {
                if (me == null) {
                    me = new BCruiser();
                }
            }
        }
        return me;
    }

    public static void destory() {
        if (me != null) {
            synchronized (BCruiser.class) {
                if (me != null) {
                    me.dispose();
                }
            }
        }
        me = null;
    }

    private void dispose() {
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
        }
        if (this.mActivity != null) {
            this.mActivity = null;
        }
    }

    public void setCruiseDialogManagerInterface(CruiseDialogManagerInterface cruiseDialogManagerInterface) {
        this.mCruiseDialogManagerInterface = cruiseDialogManagerInterface;
    }

    public View init(Activity activity, Bundle configParams, MapGLSurfaceView nmapView) {
        LogUtil.m15791e("Cruise", "init... ");
        this.mIsCruiseBegin = true;
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        BaiduNaviSDKManager.getInstance().setNaviMuteState(true);
        BNPowerSaver.getInstance().init(activity);
        CruiseMapController.getInstance().init(this.mContext);
        createHandler();
        createMsgHandler();
        this.mStatItem = CruiseStatItem.getInstance();
        this.mStatItem.mStartCruiseTime = SystemClock.elapsedRealtime();
        this.mDialogManager = new CruiseDialogManager(this.mActivity);
        this.mDialogManager.setCruiseDialogManagerInterface(this.mCruiseDialogManagerInterface);
        CruiseCacheStatus.sOrientation = 2;
        CruiseUIModel.getInstance().setLastLocationData(GeoLocateModel.getInstance().getLastLocation());
        checkCurrentProvinceDataDownloaded();
        CruiseUIModel.getInstance().setConnected(NetworkUtils.isNetworkAvailable(this.mContext));
        try {
            this.mParentView = (FrameLayout) this.mActivity.getLayoutInflater().inflate(C0965R.layout.nsdk_layout_cruise_main_layout, null);
            this.mNMapView = nmapView;
            parseConfigParams(configParams);
            setupUI();
            VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
            setupListener();
            CruiseMapController.getInstance().initMapView();
            initCruise();
            initLocationService();
            NetworkListener.registerMessageHandler(this.mHandler);
            initScreenAlwaysOn();
            BNMapController.getInstance().sendCommandToMapEngine(2, null);
            if (PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_CRUISE_TEXT_NEWER_GUIDE, true)) {
                PreferenceHelper.getInstance(this.mContext).putBoolean(Key.SP_CRUISE_TEXT_NEWER_GUIDE, false);
            }
            return this.mParentView;
        } catch (Exception e) {
            this.mIsCruiseBegin = false;
            return null;
        }
    }

    public void startCruise() {
    }

    private void startRouteCruise() {
        if (!this.mIsCruiserStarted) {
            LogUtil.m15791e("Cruise", "startRouteCruise... ");
            BNMapController.getInstance().showLayer(20, true);
            BNMapController.getInstance().showLayer(14, false);
            this.mIsCruiserStarted = true;
            BNRouteGuider.getInstance().startRouteCruise();
            BNRouteGuider.getInstance().setBrowseStatus(false);
            CruiseMapController.getInstance().setCruiseEngineStarted(true);
            CruiseMapController.getInstance().initMapStatus();
            if (this.mStatItem != null) {
                this.mStatItem.mStartCruiseEngineTime = SystemClock.elapsedRealtime();
            }
            if (hasLocation() && this.mCruiseMapView != null) {
                this.mCruiseMapView.setViewWhenGPSRecover();
            }
            if (this.mBCruiserListener != null) {
                this.mBCruiserListener.notifyStartCruiser();
            }
            if (this.mBCruiserListeners != null) {
                for (int index = 0; index < this.mBCruiserListeners.size(); index++) {
                    ((OnCruiseBeginListener) this.mBCruiserListeners.get(index)).onCruiseBegin(true);
                }
            }
        }
    }

    public boolean isCruiseBegin() {
        return this.mIsCruiseBegin;
    }

    public boolean isRouteCruiseBegin() {
        return this.mIsCruiserStarted;
    }

    public void updateInitLocation(int longitudeMC, int latitudeMC) {
        LogUtil.m15791e("Cruise", "updateInitLocation: " + longitudeMC + ", " + latitudeMC);
        CruiseCacheStatus.sInitLongitudeMC = longitudeMC;
        CruiseCacheStatus.sInitLatitudeMC = latitudeMC;
        Bundle b = CoordinateTransformUtil.MC2LL(longitudeMC, latitudeMC);
        LocData locData = new LocData();
        locData.longitude = b.getDouble("LLx");
        locData.latitude = b.getDouble("LLy");
        LocData wgs84LocData = new LocData();
        if (locData != null) {
            Bundle wgs84Bundle = CoordinateTransformUtil.transferGCJ02ToWGS84(locData.longitude, locData.latitude);
            wgs84LocData.longitude = wgs84Bundle.getDouble("LLx");
            wgs84LocData.latitude = wgs84Bundle.getDouble("LLy");
        }
        updateLocation(wgs84LocData, locData);
    }

    public void setListener(IBCruiserListener listener) {
        this.mBCruiserListener = listener;
    }

    private void parseConfigParams(Bundle configParams) {
        if (configParams.containsKey(BCruiserConfig.KEY_CRUISER_VIEW_MODE)) {
            BCruiserConfig.pRGViewMode = configParams.getInt(BCruiserConfig.KEY_CRUISER_VIEW_MODE);
        }
    }

    private void setupUI() {
        if (this.mParentView != null) {
            this.mParentView.removeAllViews();
            if (BCruiserConfig.pRGViewMode == 0) {
                if (this.mNMapView != null) {
                    try {
                        ViewGroup parent = (ViewGroup) this.mNMapView.getParent();
                        if (parent != null) {
                            parent.removeAllViews();
                        }
                    } catch (Exception e) {
                    }
                    this.mParentView.addView(this.mNMapView, new LayoutParams(-1, -1));
                    this.mParentView.requestLayout();
                } else {
                    BCruiserConfig.pRGViewMode = 1;
                }
            }
            this.mCruiseMapView = new CruiseMapView(this.mActivity, this.mParentView, false);
            CruiseMapController.getInstance().setCruiseMapView(this.mCruiseMapView);
            this.mCruiseMapView.onUpdateStyle(BNStyleManager.getRealDayStyle());
        }
    }

    private void setupListener() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.setBCruiserQuitCruiseClickListener(this.mBCruiserQuitCruiseClickListener);
        }
    }

    public void setBatteryStatus(int batteryLevel, boolean mIsBatteryCharging) {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.setBatteryStatus(batteryLevel, mIsBatteryCharging);
        }
    }

    private void initCruise() {
        BNRouteGuider.getInstance().setLocateMode(1);
        LocData locData = GeoLocateModel.getInstance().getLastLocation();
        if (locData != null) {
            locData = locData.clone();
            locData.speed = 0.0f;
            locData.satellitesNum = 0;
            updateLocation(null, locData);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        r9 = this;
        r5 = 1;
        r8 = 0;
        r9.checkCurrentProvinceDataDownloaded();
        r3 = r9.checkDataDownload();
        r4 = com.baidu.navisdk.util.logic.BNExtGPSLocationManager.getInstance();
        r4 = r4.isGpsEnabled();
        if (r4 == 0) goto L_0x00ab;
    L_0x0013:
        r4 = com.baidu.navisdk.util.logic.BNExtGPSLocationManager.getInstance();
        r4 = r4.isGpsAvailable();
        if (r4 == 0) goto L_0x00ab;
    L_0x001d:
        r9.mGPSOpened = r5;
        r9.mGPSAvailable = r5;
    L_0x0021:
        r4 = r9.mGPSOpened;
        if (r4 != 0) goto L_0x00c1;
    L_0x0025:
        r4 = r9.mCruiseMapView;
        if (r4 == 0) goto L_0x002e;
    L_0x0029:
        r4 = r9.mCruiseMapView;
        r4.setViewWhenNoGPS();
    L_0x002e:
        if (r3 != 0) goto L_0x0034;
    L_0x0030:
        r4 = r9.mDialogManager;
        if (r4 == 0) goto L_0x0034;
    L_0x0034:
        r4 = r9.mHandler;
        if (r4 != 0) goto L_0x003b;
    L_0x0038:
        r9.createHandler();
    L_0x003b:
        r4 = com.baidu.navisdk.util.worker.BNWorkerCenter.getInstance();
        r5 = new com.baidu.navi.cruise.BCruiser$1;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "onResume-";
        r6 = r6.append(r7);
        r7 = r9.getClass();
        r7 = r7.getSimpleName();
        r6 = r6.append(r7);
        r6 = r6.toString();
        r7 = 0;
        r5.<init>(r6, r7);
        r6 = new com.baidu.navisdk.util.worker.BNWorkerConfig;
        r7 = 8;
        r6.<init>(r7, r8);
        r4.submitMainThreadTask(r5, r6);
        r4 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();
        r4.onResume();
        r4 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();
        r4.setDrawHouse(r8);
        r4 = r9.mCruiseMapView;
        if (r4 == 0) goto L_0x0082;
    L_0x007d:
        r4 = r9.mCruiseMapView;
        r4.onResume();
    L_0x0082:
        r4 = com.baidu.navi.cruise.control.CruiseMapController.getInstance();
        r4.initMapStatus();
        r2 = com.baidu.navisdk.comapi.setting.BNSettingManager.isRoadCondOnOrOff();
        r4 = com.baidu.navisdk.comapi.mapcontrol.BNMapController.getInstance();
        r4.showTrafficMap(r2);
        r4 = r9.mContext;	 Catch:{ Exception -> 0x00d9 }
        if (r4 == 0) goto L_0x00aa;
    L_0x0098:
        r4 = r9.mContext;	 Catch:{ Exception -> 0x00d9 }
        r4 = r4.getResources();	 Catch:{ Exception -> 0x00d9 }
        r0 = r4.getConfiguration();	 Catch:{ Exception -> 0x00d9 }
        r4 = 2;
        r5 = com.baidu.navisdk.ui.cruise.model.CruiseCacheStatus.sOrientation;	 Catch:{ Exception -> 0x00d9 }
        if (r4 == r5) goto L_0x00aa;
    L_0x00a7:
        r9.onConfigurationChanged(r0);	 Catch:{ Exception -> 0x00d9 }
    L_0x00aa:
        return;
    L_0x00ab:
        r4 = com.baidu.navisdk.util.logic.BNSysLocationManager.getInstance();
        r4 = r4.isGpsEnabled();
        r9.mGPSOpened = r4;
        r4 = com.baidu.navisdk.util.logic.BNSysLocationManager.getInstance();
        r4 = r4.isGpsAvailable();
        r9.mGPSAvailable = r4;
        goto L_0x0021;
    L_0x00c1:
        r4 = r9.mDialogManager;
        if (r4 == 0) goto L_0x00ca;
    L_0x00c5:
        r4 = r9.mDialogManager;
        r4.dismissGPSSettingDialog();
    L_0x00ca:
        r4 = r9.mGPSAvailable;
        if (r4 != 0) goto L_0x0034;
    L_0x00ce:
        r4 = r9.mCruiseMapView;
        if (r4 == 0) goto L_0x0034;
    L_0x00d2:
        r4 = r9.mCruiseMapView;
        r4.setViewWhenNotLocated();
        goto L_0x0034;
    L_0x00d9:
        r1 = move-exception;
        r4 = "Cruise";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "onResume e: ";
        r5 = r5.append(r6);
        r6 = r1.getMessage();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.baidu.navisdk.util.common.LogUtil.m15791e(r4, r5);
        goto L_0x00aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.cruise.BCruiser.onResume():void");
    }

    public void onPause() {
        BNMapController.getInstance().onPause();
    }

    public void quitCruise() {
        LogUtil.m15791e("ImportantCruiseBug", "quitCruise map onResume");
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.removeLocModeRunnable();
        }
        stopRouteCruise();
        CruiseMapController.getInstance().restoreMapView();
        BNMapController.getInstance().sendCommandToMapEngine(3, null);
        NetworkListener.unRegisterMessageHandler(this.mHandler);
        BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
        BNSysLocationManager.getInstance().stopNaviLocate();
        BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
        restoreRGSetting();
        restoreScreenAlwaysOn();
        if (this.mBCruiserListener != null) {
            this.mBCruiserListener.notifyQuitCruiser();
        }
        if (this.mBCruiserListeners != null) {
            for (int index = 0; index < this.mBCruiserListeners.size(); index++) {
                ((OnCruiseBeginListener) this.mBCruiserListeners.get(index)).onCruiseBegin(false);
            }
        }
        BNPowerSaver.getInstance().uninit();
        VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
        CruiseUIModel.getInstance().reset();
        if (BNOfflineDataManager.getInstance().getNeedReload()) {
            BNaviEngineManager.getInstance().reload();
            BNOfflineDataManager.getInstance().resetNeedReload();
        }
        CruiseMapController.getInstance().setCruiseMapView(null);
        this.mIsCruiseBegin = false;
        BaiduNaviSDKManager.getInstance().setNaviMuteState(false);
    }

    private void stopRouteCruise() {
        if (this.mStatItem != null) {
            this.mStatItem.mTotalDistance = BNRouteGuider.getInstance().getCurrentRouteDrvieDistance();
            this.mStatItem.onEvent();
        }
        if (this.mIsCruiserStarted) {
            BNRouteGuider.getInstance().stopRouteCruise();
            this.mIsCruiserStarted = false;
            CruiseMapController.getInstance().setCruiseEngineStarted(false);
        }
    }

    protected Context getContext() {
        return this.mContext;
    }

    private void initLocationService() {
        if (C1609a.a().b() && BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
            BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
            BNExtGPSLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
            return;
        }
        BNSysLocationManager.getInstance().startNaviLocate(this.mContext);
        BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
        BNSysLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
    }

    public void reInitLocationService() {
        if (BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
            BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
            BNExtGPSLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
            return;
        }
        BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
        BNSysLocationManager.getInstance().startNaviLocate(this.mContext);
        BNSysLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
    }

    public void updateLocation(LocData wgs84Data, LocData locData) {
        if (locData != null && locData.isValid() && wgs84Data != null && wgs84Data.isValid()) {
            LocationCallback.setData(locData.toLocationOverlayJsonString(PreferenceHelper.getInstance(this.mContext).getBoolean(Key.SP_Last_Cruise_Map_Status, true)));
            BNRouteGuider.getInstance().triggerGPSDataChange((int) (wgs84Data.longitude * 100000.0d), (int) (wgs84Data.latitude * 100000.0d), wgs84Data.speed, wgs84Data.direction, wgs84Data.accuracy, (float) wgs84Data.altitude, wgs84Data.satellitesNum, wgs84Data.locType);
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getVehicleInfo(bundle);
            float angle = (float) bundle.getDouble("vehicle_angle");
            int speedKmPerHour = (int) (locData.speed * 3.6f);
            float addDistKm = new BigDecimal((double) (((float) bundle.getInt("vehicle_angle_add_dist")) / 1000.0f)).setScale(1, 4).floatValue();
            LogUtil.m15791e("Cruise", "updateLocation: speed " + speedKmPerHour + ", angle " + angle + ", " + locData);
            if (this.mCruiseMapView != null) {
                this.mCruiseMapView.updateCurrentSpeed(speedKmPerHour);
            }
        }
    }

    private void createHandler() {
        this.mHandler = new C37293();
    }

    private void createMsgHandler() {
        this.mMsgHandler = new C37314();
    }

    public void onCurrentRoadNameUpdate(Message msg) {
        LogUtil.m15791e("Cruise", "onCurrentRoadNameUpdate");
        Bundle data = getMsgData(msg);
        if (data != null && this.mCruiseMapView != null) {
            this.mCruiseMapView.setCurrentRoadName(data.getString("road_name"));
        }
    }

    private void hideCruiseTypeView() {
        Bundle b = new CruiseCameraType(3, 0, 0).toBundle();
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateData(b);
        }
    }

    public void onAssistInfoShow(Message msg) {
        Bundle b = new CruiseCameraType(1, msg.arg1, msg.arg2).toBundle();
        CruiseUIModel.getInstance().setCameraDistance(getAssistRemainDist(getMsgData(msg)));
        LogUtil.m15791e("Cruise", "onAssistInfoShow msg.arg1 = " + msg.arg1 + " msg.arg2 = " + msg.arg2);
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateData(b);
        }
    }

    public void onAssistInfoUpdate(Message msg) {
        Bundle b = new CruiseCameraType(2, msg.arg1, msg.arg2).toBundle();
        CruiseUIModel.getInstance().setCameraDistance(getAssistRemainDist(getMsgData(msg)));
        LogUtil.m15791e("Cruise", "onAssistInfoUpdate msg.arg1 = " + msg.arg1 + " msg.arg2 = " + msg.arg2);
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateData(b);
        }
    }

    public void onAssistInfoHide(Message msg) {
        Bundle b = new CruiseCameraType(3, msg.arg1, msg.arg2).toBundle();
        CruiseUIModel.getInstance().setCameraDistance(getAssistRemainDist(getMsgData(msg)));
        LogUtil.m15791e("Cruise", "onAssistInfoHide msg.arg1 = " + msg.arg1 + " msg.arg2 = " + msg.arg2 + " distance = " + CruiseCacheStatus.sAssistRemainDist);
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateData(b);
        }
    }

    private Bundle getMsgData(Message msg) {
        if (msg == null || !(msg.obj instanceof Bundle)) {
            return null;
        }
        return (Bundle) msg.obj;
    }

    public boolean onBackPressed() {
        LogUtil.m15791e("Cruise", "onBackPressed");
        if (this.mCruiseMapView != null && this.mCruiseMapView.onBackPressed()) {
            EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        }
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            CruiseCacheStatus.sOrientation = 2;
            LogUtil.m15791e("Cruise", "onConfigurationChanged: portrait " + false);
            if (this.mCruiseMapView != null) {
                if (this.mCruiseMapView.isPortrait()) {
                    this.mParentView.removeView(this.mCruiseMapView.getRootView());
                    this.mCruiseMapView = new CruiseMapView(this.mActivity, this.mParentView, false);
                    setupListener();
                    this.mCruiseMapView.onUpdateStyle(BNStyleManager.getDayStyle());
                    CruiseMapController.getInstance().setCruiseMapView(this.mCruiseMapView);
                } else {
                    this.mCruiseMapView.onConfigurationChanged();
                }
            }
            CruiseMapController.getInstance().onUpdateOrientation(false);
            if (this.mDialogManager.isNewerGuideDialogShowing()) {
                this.mDialogManager.showNewerGuideDialog(false);
            }
        }
    }

    public void showQuitDialog() {
        this.mDialogManager.showQuitDialog(new C37336());
    }

    public void notifyCruiseFragmentQuitCruise() {
        if (this.mBCruiserListener != null) {
            this.mBCruiserListener.onPageJump(1, Integer.valueOf(0));
        }
    }

    public void notifyCruiseFragmentNoData(boolean bshowDataFragment) {
        if (!bshowDataFragment) {
            quitCruise();
        }
        if (this.mBCruiserListener != null) {
            this.mBCruiserListener.onPageJump(2, Boolean.valueOf(bshowDataFragment));
        }
    }

    public void onUpdateStyle(boolean dayStyle) {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.onUpdateStyle(dayStyle);
        }
    }

    private void initGpsLocateViews() {
        this.mGPSOpened = BNSysLocationManager.getInstance().isGpsEnabled();
        this.mGPSAvailable = BNSysLocationManager.getInstance().isGpsAvailable();
        LogUtil.m15791e("Cruise", "initGps, enable " + this.mGPSOpened + ", available " + this.mGPSAvailable);
        if (this.mCruiseMapView == null) {
            return;
        }
        if (!this.mGPSOpened) {
            this.mCruiseMapView.setViewWhenNoGPS();
        } else if (!this.mGPSAvailable) {
            this.mCruiseMapView.setViewWhenNotLocated();
        }
    }

    private boolean checkDataDownload() {
        this.mHasLocation = GeoLocateModel.getInstance().getLastLocation() != null;
        LogUtil.m15791e("Cruise", "checkDataDownload, hasLocation " + this.mHasLocation);
        if (!this.mHasLocation || NetworkUtils.isNetworkAvailable(this.mContext)) {
            return false;
        }
        checkCurrentProvinceDataDownloaded();
        if (CruiseUIModel.getInstance().isProvinceDataDownloaded()) {
            return false;
        }
        if (this.mDialogManager != null) {
        }
        return true;
    }

    public void checkCurrentProvinceDataDownloaded() {
        LocData locData = GeoLocateModel.getInstance().getLastLocation();
        if (locData == null || !locData.isValid()) {
            this.mHasLocation = false;
            LogUtil.m15791e("Cruise", "checkProvinceData: no valid location!");
            return;
        }
        this.mHasLocation = true;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (locData.latitude * 100000.0d));
            geoPoint.setLongitudeE6((int) (locData.longitude * 100000.0d));
            DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
            while (districtInfo != null && districtInfo.mType > 2) {
                districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
            }
            if (districtInfo != null) {
                CruiseUIModel.getInstance().setProvinceDataDownloaded(BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId));
                return;
            }
            return;
        }
        LogUtil.m15791e("Cruise", "no common offline data!");
    }

    private void initScreenAlwaysOn() {
        VDeviceAPI.setScreenAlwaysOn(PreferenceHelper.getInstance(this.mActivity.getApplicationContext()).getBoolean(SettingParams.Key.NAVI_ALWAYS_BRIGHT, true));
    }

    private void restoreScreenAlwaysOn() {
        VDeviceAPI.setScreenAlwaysOn(false);
    }

    private void restoreRGSetting() {
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            BNRouteGuider.getInstance().setVoiceMode(BNSettingManager.getVoiceMode());
            BNRouteGuider.getInstance().SetOtherCameraSpeak(BNSettingManager.isElecCameraSpeakEnable());
            BNRouteGuider.getInstance().SetOverspeedSpeak(BNSettingManager.isSpeedCameraSpeakEnable());
            BNRouteGuider.getInstance().SetStraightSpeak(BNSettingManager.isStraightDirectSpeakEnable());
        }
    }

    public void innerJumpToOfflineDataManagerPage() {
        if (this.mBCruiserListener != null) {
            this.mBCruiserListener.onPageJump(2, Boolean.valueOf(true));
        }
    }

    public boolean isCruiserAvailable(Context context) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            return true;
        }
        boolean hasData = CruiseUIModel.getInstance().isProvinceDataDownloaded();
        return !hasData ? hasData : hasData;
    }

    public boolean isCruiseOnline(Context context) {
        if (CruiseUIModel.getInstance().isProvinceDataDownloaded()) {
            return false;
        }
        return NetworkUtils.isNetworkAvailable(context);
    }

    public boolean isOfflineDataDownloaded() {
        boolean hasData = false;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            LocData locData = BNSysLocationManager.getInstance().getCurLocation();
            if (locData == null) {
                locData = BNLocationManagerProxy.getInstance().getCurLocation();
                if (locData == null) {
                    LogUtil.m15791e("Cruise", "isCruiserAvailable: no location data!");
                    return false;
                }
            }
            if (locData.longitude == -1.0d && locData.latitude == -1.0d) {
                Bundle b = CoordinateTransformUtil.MC2LLE6(CruiseCacheStatus.sInitLongitudeMC, CruiseCacheStatus.sInitLatitudeMC);
                locData.longitude = ((double) b.getInt("LLx")) / 100000.0d;
                locData.latitude = ((double) b.getInt("LLy")) / 100000.0d;
            }
            GeoPoint geoPoint = new GeoPoint();
            if (locData != null) {
                geoPoint.setLatitudeE6((int) (locData.latitude * 100000.0d));
                geoPoint.setLongitudeE6((int) (locData.longitude * 100000.0d));
            }
            DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geoPoint, 0);
            while (districtInfo != null && districtInfo.mType > 2) {
                districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
            }
            if (districtInfo != null) {
                hasData = BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
                CruiseUIModel.getInstance().setProvinceDataDownloaded(hasData);
            } else {
                hasData = true;
            }
        }
        return hasData;
    }

    public boolean hasLocation() {
        if (this.mIsTrackLocate) {
            return BNLocateTrackManager.getInstance().isGpsTrackFileInstalled();
        }
        if (C1609a.a().b() && BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
            return true;
        }
        return BNSysLocationManager.getInstance().isSysLocationValid();
    }

    private void onNetSwitchHide() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateData(new CruiseCameraType(3, 0, 0).toBundle());
        }
    }

    public void setShowMenuFlagOnResume(boolean showMenu) {
        this.mIsNeedShowSettingsMenu = showMenu;
    }

    public int getAssistRemainDist(Bundle data) {
        int rst = -1;
        if (data != null) {
            rst = data.getInt(SimpleGuideInfo.RemainDist, -1);
        }
        if (rst == -1) {
            return CruiseCacheStatus.sAssistRemainDist;
        }
        CruiseCacheStatus.sAssistRemainDist = rst;
        return rst;
    }

    public void addRGInfoListeners(OnRGInfoListener listener) {
        if (listener != null && !this.mRGInfoListeners.contains(listener)) {
            this.mRGInfoListeners.add(listener);
        }
    }

    public void removeRGInfoListeners(OnRGInfoListener listener) {
        if (listener != null && this.mRGInfoListeners.contains(listener)) {
            this.mRGInfoListeners.remove(listener);
        }
    }

    public void notifyAssistIconShow(Message msg) {
        int i = 0;
        while (i < this.mRGInfoListeners.size()) {
            OnRGInfoListener listener = (OnRGInfoListener) this.mRGInfoListeners.get(i);
            if (listener == null) {
                this.mRGInfoListeners.remove(i);
            } else {
                listener.onAssistInfoShow(msg);
                i++;
            }
        }
    }

    public void notifyAssistIconUpdate(Message msg) {
        int i = 0;
        while (i < this.mRGInfoListeners.size()) {
            OnRGInfoListener listener = (OnRGInfoListener) this.mRGInfoListeners.get(i);
            if (listener == null) {
                this.mRGInfoListeners.remove(i);
            } else {
                listener.onAssistInfoUpdate(msg);
                i++;
            }
        }
    }

    public void notifyAssistIconHide(Message msg) {
        int i = 0;
        while (i < this.mRGInfoListeners.size()) {
            OnRGInfoListener listener = (OnRGInfoListener) this.mRGInfoListeners.get(i);
            if (listener == null) {
                this.mRGInfoListeners.remove(i);
            } else {
                listener.onAssistInfoHide(msg);
                i++;
            }
        }
    }

    public void notifyGpsStatusChange(Message msg) {
        int i = 0;
        while (i < this.mRGInfoListeners.size()) {
            OnRGInfoListener listener = (OnRGInfoListener) this.mRGInfoListeners.get(i);
            if (listener == null) {
                this.mRGInfoListeners.remove(i);
            } else {
                listener.onOtherRGInfo(msg);
                i++;
            }
        }
    }

    public void addOnCruiseBeginListener(OnCruiseBeginListener lis) {
        if (lis != null && !this.mBCruiserListeners.contains(lis)) {
            this.mBCruiserListeners.add(lis);
        }
    }

    public void removeOnCruiseBeginListener(OnCruiseBeginListener lis) {
        this.mBCruiserListeners.remove(lis);
    }

    public void updateItsVoiceBtn() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateItsVoiceBtn();
        }
    }

    public void updateItsBtn() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.updateItsBtn();
        }
    }

    private void notifyCruiseBeginListener(boolean isCruiseBegin) {
        for (int i = 0; i < this.mBCruiserListeners.size(); i++) {
            ((OnCruiseBeginListener) this.mBCruiserListeners.get(i)).onCruiseBegin(isCruiseBegin);
        }
    }

    public void changeToCar3DView() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.changeToCar3DView();
        }
    }

    public void changeToNorth2DView() {
        if (this.mCruiseMapView != null) {
            this.mCruiseMapView.changeToNorth2DView();
        }
    }
}
