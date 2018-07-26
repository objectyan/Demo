package com.baidu.baidunavis;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.baidu.baidunavis.BaiduNaviParams.NaviEvent;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.baidunavis.control.NavCommonFuncController;
import com.baidu.baidunavis.control.NavDrivingCarController;
import com.baidu.baidunavis.control.NavInitController;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.baidunavis.control.NavRecoverController;
import com.baidu.baidunavis.control.NavRouteGuideController;
import com.baidu.baidunavis.control.NavRoutePlanController;
import com.baidu.baidunavis.control.NavSearchController;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.NavPerformanceModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.NavSearchCircle;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.navirecover.NaviRecoveryModel;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.baidunavis.ui.NavFragmentManager;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.p132b.C2905c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BaiduNaviManager {
    public static final int MSG_ARG_ROUTE_PLAN_REFRESH = 1;
    public static final int MSG_NAVI_DIMISS_LOADDING = 1031;
    public static final int MSG_NAVI_DRIVING_CAR_ARRIVE_DEST = 3040;
    public static final int MSG_NAVI_DRIVING_CAR_POINT = 3010;
    public static final int MSG_NAVI_DRIVING_CAR_ROUTE_REFRESH = 3020;
    public static final int MSG_NAVI_DRIVING_CAR_SELECT_ROUTE_SUCCESS = 3050;
    public static final int MSG_NAVI_FINISH_NAVI = 2000;
    public static final int MSG_NAVI_NAME_SEARCH_FOR_PB_FAILED = 1021;
    public static final int MSG_NAVI_NAME_SEARCH_FOR_PB_SUCCESS = 1020;
    public static final int MSG_NAVI_RC_HOME_OFFICE = 3070;
    public static final int MSG_NAVI_ROUTE_PLAN_BUILD_FAILED = 1005;
    public static final int MSG_NAVI_ROUTE_PLAN_BUILD_SUCCESS = 1004;
    public static final int MSG_NAVI_ROUTE_PLAN_CANCELED = 1001;
    public static final int MSG_NAVI_ROUTE_PLAN_FAILED = 1003;
    public static final int MSG_NAVI_ROUTE_PLAN_START = 1000;
    public static final int MSG_NAVI_ROUTE_PLAN_SUCCESS = 1002;
    public static final int MSG_NAVI_RP_IPO_FAIL_NORMAL = 3060;
    public static final int MSG_NAVI_RP_IPO_SUCCESS_NORMAL = 3030;
    public static final int MSG_NAVI_UPDATE_ROADCONDITION_FAILED = 1011;
    public static final int MSG_NAVI_UPDATE_ROADCONDITION_SUCCESS = 1010;
    public static final int MSG_UGC_RESPORT_EVENT = 1041;
    private static final int NAVI_MSG_DELAY_REORDER_NAVI_PAGE = 1;
    private static final int NAVI_MSG_NOTIFY_GPS_ENABLE = 2;
    public static final int NAVI_MSG_SELECTROUTE_TIMEOUT_TO_DISMISS_DIALOG = 3;
    public static final String NO_PHONE_AUTH_MSG = "没有电话相关权限，请打开后重试";
    public static final int SO_LOAD_MAX_TIME = 2;
    public static final int STRATEGY_FORCE_ONLINE_PRIORITY = 1;
    public static final int STRATEGY_USER_SETTING = 2;
    public static final String TAG = BaiduNaviManager.class.getSimpleName();
    private static volatile BaiduNaviManager mInstance = null;
    public static int sCurrentCalSource = 0;
    public static volatile boolean sIsBaseEngineInitial = false;
    public static volatile boolean sIsBaseEngineInitialized = false;
    public static boolean sIsEngineInitialFailed = false;
    public static volatile boolean sIsNaviSoLoadSuccess = false;
    private boolean hasDismiss = false;
    public boolean mIsMapUseGPS = false;
    public long mLastestQuitNaviTime = -1;
    private Handler mMapHandler = null;
    private Handler mNaviHandler = new BNMainLooperHandler() {
        public void onMessage(Message msg) {
            boolean z = true;
            if (1 != msg.what) {
                if (2 == msg.what) {
                    BaiduNaviManager baiduNaviManager = BaiduNaviManager.this;
                    if (msg.arg1 != 1) {
                        z = false;
                    }
                    baiduNaviManager.mIsMapUseGPS = z;
                    NavLogUtils.m3003e(BaiduNaviManager.TAG, "handleMessage() mIsMapUseGPS=" + BaiduNaviManager.this.mIsMapUseGPS + ", sIsBaseEngineInitialized=" + BaiduNaviManager.sIsBaseEngineInitialized);
                    if (BaiduNaviManager.sIsBaseEngineInitialized) {
                        NavLocationManager.getInstance().notifyMapGPSEnable(BaiduNaviManager.this.mIsMapUseGPS);
                    }
                } else if (3 == msg.what) {
                    NavLogUtils.m3003e(BaiduNaviManager.TAG, "handleMessage() selectroute.timeout");
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                }
            }
        }
    };

    public interface CalRouteSource {
        public static final int SOURCE_ENTERLIGHT = 4;
        public static final int SOURCE_LIGTHPAGE = 5;
        public static final int SOURCE_NAVIROUTE = 2;
        public static final int SOURCE_PBDATA = 1;
        public static final int SOURCE_WITHPBDATA = 3;
    }

    public interface UgcNaviMsgCallBack {
        void onUgcPageFinish();

        void onUgcReportBtnClick();

        void showUgcReportBtn(boolean z);
    }

    public static boolean isNaviSoLoadSuccess() {
        return sIsNaviSoLoadSuccess;
    }

    public static BaiduNaviManager getInstance() {
        if (mInstance == null) {
            synchronized (BaiduNaviManager.class) {
                if (mInstance == null) {
                    mInstance = new BaiduNaviManager();
                }
            }
        }
        return mInstance;
    }

    public void initTTSModule(Context context) {
        BaseTTSPlayer.getInstance().initPlayer(context, NavMapAdapter.getInstance().getDataPath() + File.separator + "bnav");
    }

    public void initBaseEngine(Activity activity, NaviEngineInitListener naviEngineInitListener) {
        NavLogUtils.m3003e(TAG, "initBaseEngine() sIsNaviSoLoadSuccess=" + sIsNaviSoLoadSuccess);
        NavInitController.getInstance().initBaseEngine(activity, naviEngineInitListener);
    }

    public void statNaviIntentTime() {
        if (sIsBaseEngineInitialized) {
            NavUserBehaviour.getInstance().statNaviIntentTime();
        }
    }

    public void statNaviIntentTime2() {
        if (sIsBaseEngineInitialized && NavUserBehaviour.getInstance() != null) {
            NavUserBehaviour.getInstance().statNaviIntentTime2();
        }
    }

    public void uninitEngine() {
        if (sIsBaseEngineInitialized) {
            NavInitController.getInstance().uninitEngine();
        }
    }

    @Deprecated
    public void launchNavigator(Activity activity, NavGeoPoint startNode, String startName, NavGeoPoint endNode, String endName, int nRPPolicy, boolean isGPSNav, int strategy) {
        if (sIsBaseEngineInitialized) {
            NavRouteGuideController.getInstance().launchNavigator(activity, startNode, startName, endNode, endName, nRPPolicy, isGPSNav, strategy, false);
        }
    }

    @Deprecated
    public void launchNavigator(Activity activity, NavGeoPoint startNode, String startName, NavGeoPoint endNode, String endName, int nRPPolicy, boolean isGPSNav, int strategy, boolean isRedirector) {
        if (sIsBaseEngineInitialized) {
            NavRouteGuideController.getInstance().launchNavigator(activity, startNode, startName, endNode, endName, nRPPolicy, isGPSNav, strategy, isRedirector);
        }
    }

    @Deprecated
    public void launchNavigator(Activity activity, RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int nRPPolicy, boolean isGPSNav, int strategy) {
        if (sIsBaseEngineInitialized) {
            NavRouteGuideController.getInstance().launchNavigator(activity, startNode, endNode, (List) viaNodes, nRPPolicy, isGPSNav, strategy, false);
        }
    }

    @Deprecated
    public void launchNavigator(Activity activity, RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int nRPPolicy, boolean isGPSNav, int strategy, boolean isRedirector) {
        if (sIsBaseEngineInitialized) {
            NavRouteGuideController.getInstance().launchNavigator(activity, startNode, endNode, (List) viaNodes, nRPPolicy, isGPSNav, strategy, isRedirector);
        }
    }

    public void launchCruiser(Activity activity, Boolean from) {
        NavRouteGuideController.getInstance().launchCruiser(activity, from);
    }

    public boolean hasGPSPermission(Activity a) {
        if (a == null) {
            return false;
        }
        PackageManager pm = a.getPackageManager();
        if (pm == null) {
            return false;
        }
        try {
            if (-1 != pm.checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.baidu.carlife")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void notifyNaviBeginChanged(String turnKind) {
        NavMapAdapter.getInstance().setUgcInfo(turnKind);
    }

    public void setMapHandler(Handler handler) {
        this.mMapHandler = handler;
    }

    public Handler getMapHandler() {
        return this.mMapHandler;
    }

    public void onCarNaviRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (grantResults != null && grantResults.length > 0 && !NavCommonFuncModel.getInstance().mHasRequestReadPhoneStatePermission) {
            NavCommonFuncModel.getInstance().mHasRequestReadPhoneStatePermission = true;
            RouteNode startNode = NavRoutePlanModel.getInstance().getStartRouteNode();
            RouteNode endNode = NavRoutePlanModel.getInstance().getEndRouteNode();
            List<RouteNode> viaNodes = NavRoutePlanModel.getInstance().getViaNodes();
            int preferrence = NavRoutePlanModel.getInstance().getPreference();
            int driveRefTimeInterval = NavRoutePlanModel.getInstance().getDriveRefTimeInterval();
            int driveRefTimeDuration = NavRoutePlanModel.getInstance().getDriveRefTimeDuration();
            int strategy = NavRoutePlanModel.getInstance().getStrategy();
            int routeInfoStatus = NavRoutePlanModel.getInstance().getRouteInfoStatus();
            String carPANumber = NavRoutePlanModel.getInstance().mCarPANumber;
            int entry = NavRoutePlanModel.getInstance().getEntry();
            byte[] pbData = NavRoutePlanModel.getInstance().pbData;
            int pbDataLen = NavRoutePlanModel.getInstance().pbDataLen;
            Bundle extBundle = NavRoutePlanModel.getInstance().getExtBundle();
            switch (sCurrentCalSource) {
                case 1:
                    calcRouteForPBData(startNode, endNode, viaNodes, preferrence, driveRefTimeInterval, driveRefTimeDuration, strategy, routeInfoStatus, carPANumber, entry, extBundle);
                    sCurrentCalSource = 0;
                    return;
                case 2:
                    calcRouteToNaviRoute(startNode, endNode, viaNodes, preferrence, driveRefTimeInterval, driveRefTimeDuration, strategy, entry, extBundle);
                    sCurrentCalSource = 0;
                    return;
                case 3:
                    calcRouteWithPBData(startNode, endNode, viaNodes, preferrence, pbData, pbDataLen);
                    sCurrentCalSource = 0;
                    return;
                case 4:
                    enterLightNavi(NavCommonFuncModel.getInstance().getActivity(), entry);
                    sCurrentCalSource = 0;
                    return;
                case 5:
                    goToLightNaviComAddrPage(NavCommonFuncModel.getInstance().getActivity(), entry);
                    sCurrentCalSource = 0;
                    return;
                default:
                    return;
            }
        }
    }

    public String[] getPhoneAuthArray() {
        return new String[]{SystemAuth.READ_PHONE_STATE_AUTH, "android.permission.CALL_PHONE", SystemAuth.PROCESS_OUTGOING_CALLS_AUTH};
    }

    public boolean hasPhoneAuth(Context activity) {
        if (activity == null) {
            return false;
        }
        String[] authArray = getPhoneAuthArray();
        try {
            PackageManager pm = activity.getPackageManager();
            for (String auth : authArray) {
                if (pm.checkPermission(auth, "com.baidu.carlife") != 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean calcRouteForPBData(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int routeInfoStatus, String carPANumber, int entry) {
        return calcRouteForPBData(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, routeInfoStatus, carPANumber, entry, null);
    }

    public boolean calcRouteForPBData(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int routeInfoStatus, String carPANumber, int entry, Bundle extBundle) {
        Object obj;
        String str;
        String str2 = TAG;
        StringBuilder append = new StringBuilder().append("calcRouteForPBData() --> endNode.mFromType = ");
        if (endNode == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(endNode.mFromType);
        }
        append = append.append(obj).append(", endNode.mUID = ");
        if (endNode == null) {
            str = "null";
        } else {
            str = endNode.mUID;
        }
        NavLogUtils.m3003e(str2, append.append(str).append(", entry=").append(entry).toString());
        NaviRecoveryModel.getInstance().setHasCalcRoute(true);
        int prefer = unPreference;
        if (entry != 7) {
            int singlePreferValue = NavMapAdapter.getInstance().getPreferValue();
            if (singlePreferValue == 0) {
                prefer = NavMapAdapter.getInstance().onGetLastPreferValue();
                NavMapAdapter.getInstance().setPreferValue(prefer);
            } else {
                prefer = singlePreferValue;
            }
        } else {
            prefer = NavMapAdapter.getInstance().mappingPreferValue(unPreference);
            NavMapAdapter.getInstance().setPreferValue(prefer);
        }
        NavLogUtils.m3003e(TAG, "routesort calroute prefer " + prefer);
        final int calcPrefer = prefer;
        NavSearchController.getInstance().setIsFromMap(true);
        NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
        NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
        NavRoutePlanModel.getInstance().setPreference(prefer);
        NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
        NavRoutePlanModel.getInstance().setStrategy(strategy);
        NavRoutePlanModel.getInstance().setRouteInfoStatus(routeInfoStatus);
        NavRoutePlanModel.getInstance().mCarPANumber = carPANumber;
        NavRoutePlanModel.getInstance().setEntry(entry);
        NavRoutePlanModel.getInstance().setExtBundle(extBundle);
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null || NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            final RouteNode routeNode;
            final RouteNode routeNode2;
            final List<RouteNode> list;
            final int i;
            final int i2;
            final int i3;
            final int i4;
            final int i5;
            final Bundle bundle;
            if (sIsBaseEngineInitial) {
                routeNode = startNode;
                routeNode2 = endNode;
                list = viaNodes;
                i = driveRefTimeInterval;
                i2 = driveRefTimeDuration;
                i3 = strategy;
                i4 = routeInfoStatus;
                prefer = carPANumber;
                i5 = entry;
                bundle = extBundle;
                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData()", null) {
                    /* renamed from: i */
                    private int f2316i = 1;

                    protected String execute() {
                        while (BaiduNaviManager.sIsBaseEngineInitial) {
                            String str = TAG;
                            StringBuilder append = new StringBuilder().append("calcRouteForPBData() while ");
                            int i = this.f2316i;
                            this.f2316i = i + 1;
                            NavLogUtils.m3003e(str, append.append(i).toString());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                        }
                        if (BaiduNaviManager.sIsBaseEngineInitialized) {
                            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                                protected String execute() {
                                    NavLogUtils.m3003e(TAG, "calcRouteForPBData() wait ok.");
                                    BaiduNaviManager.this.calcRouteForPBDataInner(routeNode, routeNode2, list, calcPrefer, i, i2, i3, i4, prefer, i5, bundle);
                                    return null;
                                }
                            }, new BNWorkerConfig(100, 0));
                        } else {
                            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteForPBData sIsBaseEngineInitialized false ");
                        }
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
            } else if (sIsBaseEngineInitialized) {
                return calcRouteForPBDataInner(startNode, endNode, viaNodes, prefer, driveRefTimeInterval, driveRefTimeDuration, strategy, routeInfoStatus, carPANumber, entry, extBundle);
            } else {
                if (activity == null) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteForPBData activity is null");
                    return false;
                }
                routeNode = startNode;
                routeNode2 = endNode;
                list = viaNodes;
                i = driveRefTimeInterval;
                i2 = driveRefTimeDuration;
                i3 = strategy;
                i4 = routeInfoStatus;
                prefer = carPANumber;
                i5 = entry;
                bundle = extBundle;
                getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                    public void engineInitSuccess() {
                        LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                BaiduNaviManager.this.calcRouteForPBDataInner(routeNode, routeNode2, list, calcPrefer, i, i2, i3, i4, prefer, i5, bundle);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitStart() {
                    }

                    public void engineInitFail() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                                if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                    Message msg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
                                    msg.arg1 = 0;
                                    msg.sendToTarget();
                                }
                                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteForPBData engineInitFail");
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                });
            }
            return true;
        }
        NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
        if (getInstance().getMapHandler() != null) {
            Message msg = getInstance().getMapHandler().obtainMessage(1003);
            msg.arg1 = 0;
            msg.sendToTarget();
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteForPBData isExternalStorageEnabled false ");
        return false;
    }

    private boolean calcRouteForPBDataInner(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int routeInfoStatus, String carPANumber, int entry, Bundle extBundle) {
        if (startNode != null) {
            NavLogUtils.m3003e(TAG, "calcRouteForPBDataInner() unPreference=" + unPreference + ", startCityID=" + startNode.mProvinceID + "-" + startNode.mCityID + ", from=" + startNode.mFromType + ", gpsAngle=" + startNode.mGPSAngle + ", gpsAccu=" + startNode.mGPSAccuracy + ", altitude=" + startNode.mAltitude);
        }
        if (endNode != null) {
            NavLogUtils.m3003e(TAG, "calcRouteForPBDataInner() endCityID=" + endNode.mProvinceID + "-" + endNode.mCityID);
        }
        if (endNode == null || endNode.mFromType == 99 || !NavCommonFuncController.getInstance().isFastDoubleClick()) {
            if (31 == entry) {
                NavLogUtils.m3003e(TAG, "本次算路为前置算路的话，重置防止重复算路时间");
                NavCommonFuncController.getInstance().resetLastDoubleClickTime();
            }
            if (endNode == null || !NavCommonFuncController.getInstance().checkFactoryMode(endNode.mName)) {
                int newEntry;
                if (NavUserBehaviour.getInstance() != null) {
                    NavUserBehaviour.getInstance().resetNaviStatItem();
                }
                if (extBundle != null) {
                    if (extBundle.containsKey(BaiduNaviParams.KEY_OPEN_API_SRC)) {
                        BNRoutePlaner.getInstance().setExtSrc(extBundle.getString(BaiduNaviParams.KEY_OPEN_API_SRC));
                        NavSearchController.getInstance().setRpEntry(entry);
                        newEntry = entry;
                        if (endNode != null) {
                            if (endNode.mFromType == 4) {
                                newEntry = 20;
                                BNRoutePlaner.getInstance().setComeFrom(20);
                            } else if (endNode.mFromType == 5) {
                                newEntry = 21;
                                BNRoutePlaner.getInstance().setComeFrom(21);
                            }
                        }
                        NavSearchController.getInstance().setIsFromMap(true);
                        NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
                        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
                        NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
                        NavRoutePlanModel.getInstance().setPreference(unPreference);
                        NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
                        NavRoutePlanModel.getInstance().setStrategy(strategy);
                        NavRoutePlanModel.getInstance().setRouteInfoStatus(routeInfoStatus);
                        NavRoutePlanModel.getInstance().mCarPANumber = carPANumber;
                        NavRoutePlanModel.getInstance().setEntry(newEntry);
                        NavRoutePlanModel.getInstance().setExtBundle(extBundle);
                        NavRoutePlanController.getInstance().calcRouteForPBData(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, routeInfoStatus, carPANumber, newEntry);
                        return true;
                    }
                }
                if (entry != 7) {
                    BNRoutePlaner.getInstance().setExtSrc(null);
                }
                NavSearchController.getInstance().setRpEntry(entry);
                newEntry = entry;
                if (endNode != null) {
                    if (endNode.mFromType == 4) {
                        newEntry = 20;
                        BNRoutePlaner.getInstance().setComeFrom(20);
                    } else if (endNode.mFromType == 5) {
                        newEntry = 21;
                        BNRoutePlaner.getInstance().setComeFrom(21);
                    }
                }
                NavSearchController.getInstance().setIsFromMap(true);
                NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
                NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
                NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
                NavRoutePlanModel.getInstance().setPreference(unPreference);
                NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
                NavRoutePlanModel.getInstance().setStrategy(strategy);
                NavRoutePlanModel.getInstance().setRouteInfoStatus(routeInfoStatus);
                NavRoutePlanModel.getInstance().mCarPANumber = carPANumber;
                NavRoutePlanModel.getInstance().setEntry(newEntry);
                NavRoutePlanModel.getInstance().setExtBundle(extBundle);
                NavRoutePlanController.getInstance().calcRouteForPBData(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, routeInfoStatus, carPANumber, newEntry);
                return true;
            }
            NavCommonFuncController.getInstance().drivingToolAction();
            return false;
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteForPBDataInner isFastDoubleClick or mFromType:" + endNode.mFromType);
        return false;
    }

    public boolean selectRouteToNavi(String routeMrsl, boolean isGPSNav, boolean isRedirector, RouteNode endNode) {
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        NavRoutePlanModel.getInstance().mCurMrsl = routeMrsl;
        if (!(endNode == null || endNode.mUID == null)) {
            RouteNode tmpEndNode = NavRoutePlanModel.getInstance().getEndRouteNode();
            if (tmpEndNode != null && (tmpEndNode.mUID == null || tmpEndNode.mUID.length() == 0)) {
                NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
            }
        }
        return NavRoutePlanController.getInstance().selectRouteToNavi(routeMrsl, isGPSNav, isRedirector, 4);
    }

    public boolean selectRouteToNavi(String routeMrsl, boolean isGPSNav, boolean isRedirector, RouteNode endNode, int routeSelectBits, int entry) {
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sRoutePageToNaviTime2 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("2", "基线到适配层", PerformStatItem.MAP_MODULE_NAME, NavCommonFuncModel.sRoutePageToNaviTime1, PerformStatItem.sRoutePageToNaviTime2);
        }
        NavRoutePlanModel.getInstance().mCurMrsl = routeMrsl;
        if (!(endNode == null || endNode.mUID == null)) {
            RouteNode tmpEndNode = NavRoutePlanModel.getInstance().getEndRouteNode();
            if (tmpEndNode != null && (tmpEndNode.mUID == null || tmpEndNode.mUID.length() == 0)) {
                NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
            }
        }
        NavRouteGuideController.getInstance().setUserChooseRouteBit(routeSelectBits);
        return NavRoutePlanController.getInstance().selectRouteToNavi(routeMrsl, isGPSNav, isRedirector, entry);
    }

    public boolean clearRouteBuffer() {
        if (isNaviSoLoadSuccess()) {
            return NavRoutePlanController.getInstance().clearRouteBuffer();
        }
        return false;
    }

    public int getRoutePlanRequestID() {
        return NavRoutePlanController.getInstance().getRoutePlanRequestID();
    }

    public void cancleCalcRouteRequest() {
        NavRoutePlanController.getInstance().cancleCalcRouteRequest();
    }

    public Bundle getRoutePlanStatusInfo() {
        if (sIsBaseEngineInitialized) {
            return NavRoutePlanController.getInstance().getRoutePlanStatusInfo();
        }
        return null;
    }

    private void calcRouteToNaviRouteInner(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int entry, Bundle exBundle) {
        if (startNode != null) {
            NavLogUtils.m3003e(TAG, "calcRouteToNaviRouteInner() , from=" + startNode.mFromType + ", gpsAngle=" + startNode.mGPSAngle + ", gpsAccu=" + startNode.mGPSAccuracy);
        }
        if (NavCommonFuncController.getInstance().isFastDoubleClick()) {
            NavLogUtils.m3003e(TAG, "不允许短频内进行重复算路,直接返回");
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteToNaviRouteInner isFastDoubleClick");
            return;
        }
        NavSearchController.getInstance().setIsFromMap(false);
        if (endNode == null || !NavCommonFuncController.getInstance().checkFactoryMode(endNode.mName)) {
            NavGeoPoint geoPoint;
            int i;
            RouteNode viaNode;
            if (exBundle != null) {
                if (exBundle.containsKey(BaiduNaviParams.KEY_OPEN_API_SRC)) {
                    BNRoutePlaner.getInstance().setExtSrc(exBundle.getString(BaiduNaviParams.KEY_OPEN_API_SRC));
                    NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
                    NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
                    NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
                    NavRoutePlanModel.getInstance().setPreference(unPreference);
                    NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
                    NavRoutePlanModel.getInstance().setStrategy(strategy);
                    NavRoutePlanModel.getInstance().setEntry(entry);
                    NavRoutePlanModel.getInstance().setExtBundle(exBundle);
                    if (startNode != null) {
                        geoPoint = startNode.mGeoPoint;
                        NavPoiController.getInstance().setMyPositionGeo(new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()));
                    }
                    if (startNode == null && startNode.mFromType == 2) {
                        NavSearchController.getInstance().setIsFromMap(true);
                        if (startNode.mName != null && startNode.mName.length() > 0) {
                            NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, 0, "", entry);
                            return;
                        }
                        return;
                    }
                    i = 0;
                    while (viaNodes != null && i < viaNodes.size()) {
                        viaNode = (RouteNode) viaNodes.get(i);
                        if (viaNode != null && viaNode.mFromType == 2) {
                            NavSearchController.getInstance().setIsFromMap(true);
                            if (viaNode.mName != null && viaNode.mName.length() > 0) {
                                NavLogUtils.m3003e(TAG, "calcRouteToNaviRouteInner() search via route node. name=" + viaNode.mName + ", viaIndex=" + i);
                                NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, 0, "", entry);
                                return;
                            }
                        }
                        i++;
                    }
                    if (endNode == null && endNode.mFromType == 2) {
                        NavSearchController.getInstance().setIsFromMap(true);
                        if (endNode.mName != null && endNode.mName.length() > 0) {
                            NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, 0, "", entry);
                            return;
                        }
                        return;
                    }
                    NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, entry);
                }
            }
            BNRoutePlaner.getInstance().setExtSrc(null);
            NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
            NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
            NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
            NavRoutePlanModel.getInstance().setPreference(unPreference);
            NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
            NavRoutePlanModel.getInstance().setStrategy(strategy);
            NavRoutePlanModel.getInstance().setEntry(entry);
            NavRoutePlanModel.getInstance().setExtBundle(exBundle);
            if (startNode != null) {
                geoPoint = startNode.mGeoPoint;
                NavPoiController.getInstance().setMyPositionGeo(new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()));
            }
            if (startNode == null) {
            }
            i = 0;
            while (viaNodes != null) {
                viaNode = (RouteNode) viaNodes.get(i);
                NavSearchController.getInstance().setIsFromMap(true);
                NavLogUtils.m3003e(TAG, "calcRouteToNaviRouteInner() search via route node. name=" + viaNode.mName + ", viaIndex=" + i);
                NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, 0, "", entry);
                return;
            }
            if (endNode == null) {
            }
            NavRoutePlanController.getInstance().calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, entry);
        }
    }

    public boolean calcRouteToNaviRoute(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int entry) {
        return calcRouteToNaviRoute(startNode, endNode, viaNodes, unPreference, driveRefTimeInterval, driveRefTimeDuration, strategy, entry, null);
    }

    public boolean calcRouteToNaviRoute(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int entry, Bundle extBundle) {
        Object obj;
        PerformStatisticsController.peByType(1, "map_poi_click_start", NavCommonFuncModel.sPoiToNaviTime1);
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.peByType(1, "ad_poi_routeplan_start", System.currentTimeMillis());
            PerformStatItem.sPoiToNaviTime2 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("2", PerformStatItem.PoiToNaviStep2, PerformStatItem.MAP_MODULE_NAME, NavCommonFuncModel.sPoiToNaviTime1, PerformStatItem.sPoiToNaviTime2);
        }
        String str = TAG;
        StringBuilder append = new StringBuilder().append("calcRouteToNaviRoute() --> endNode.mFromType = ");
        if (endNode == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(endNode.mFromType);
        }
        NavLogUtils.m3003e(str, append.append(obj).append(", endNode.mUID = ").append(endNode == null ? "null" : endNode.mUID).toString());
        NaviRecoveryModel.getInstance().setHasCalcRoute(true);
        int prefer = unPreference;
        if (entry != 7) {
            prefer = NavMapAdapter.getInstance().onGetLastPreferValue();
            NavMapAdapter.getInstance().setPreferValue(prefer);
        } else {
            prefer = NavMapAdapter.getInstance().mappingPreferValue(unPreference);
            NavMapAdapter.getInstance().setPreferValue(prefer);
        }
        NavSearchController.getInstance().setRpEntry(entry);
        NavSearchController.getInstance().setIsFromMap(true);
        NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
        NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
        NavRoutePlanModel.getInstance().setPreference(prefer);
        NavRoutePlanModel.getInstance().setDriveRefTime(driveRefTimeInterval, driveRefTimeDuration);
        NavRoutePlanModel.getInstance().setStrategy(strategy);
        NavRoutePlanModel.getInstance().setEntry(entry);
        NavRoutePlanModel.getInstance().setExtBundle(extBundle);
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null || NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            if (sIsBaseEngineInitialized) {
                calcRouteToNaviRouteInner(startNode, endNode, viaNodes, prefer, driveRefTimeInterval, driveRefTimeDuration, strategy, entry, extBundle);
            } else if (activity == null) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteToNaviRoute activity is null");
                return false;
            } else {
                final int calcPrefer = prefer;
                final RouteNode routeNode = startNode;
                final RouteNode routeNode2 = endNode;
                final List<RouteNode> list = viaNodes;
                final int i = driveRefTimeInterval;
                final int i2 = driveRefTimeDuration;
                final int i3 = strategy;
                final int i4 = entry;
                prefer = extBundle;
                getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                    public void engineInitSuccess() {
                        LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                BaiduNaviManager.this.calcRouteToNaviRouteInner(routeNode, routeNode2, list, calcPrefer, i, i2, i3, i4, prefer);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitStart() {
                    }

                    public void engineInitFail() {
                        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteToNaviRoute engineInitFail");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                });
            }
            return true;
        }
        NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteToNaviRoute isExternalStorageEnabled false");
        return false;
    }

    public boolean calcRouteWithPBData(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, byte[] pbData, int pbDataLen) {
        NavLogUtils.m3003e(TAG, "calcRouteWithPBData() ");
        NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
        NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
        NavRoutePlanModel.getInstance().setPreference(unPreference);
        NavRoutePlanModel.getInstance().pbData = pbData;
        NavRoutePlanModel.getInstance().pbDataLen = pbDataLen;
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null) {
            NavLogUtils.m3003e(TAG, "calcRouteWithPBData() activity == null");
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData activity is null");
            return false;
        }
        if (sIsBaseEngineInitialized) {
            NavLogUtils.m3003e(TAG, "calcRouteWithPBData() real call 2");
            NavRoutePlanController.getInstance().calcRouteWithPBData(startNode, endNode, viaNodes, unPreference, pbData, pbDataLen);
        } else {
            NavLogUtils.m3003e(TAG, "calcRouteWithPBData() start to init guidance engine");
            final RouteNode routeNode = startNode;
            final RouteNode routeNode2 = endNode;
            final List<RouteNode> list = viaNodes;
            final int i = unPreference;
            final byte[] bArr = pbData;
            final int i2 = pbDataLen;
            getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                public void engineInitSuccess() {
                    LogUtil.m3004e("SDKHelper", "calcRouteWithPBData() engineInitSuccess");
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavLogUtils.m3003e(TAG, "calcRouteWithPBData() real call 1");
                            NavRoutePlanController.getInstance().calcRouteWithPBData(routeNode, routeNode2, list, i, bArr, i2);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitStart() {
                    LogUtil.m3004e("SDKHelper", "calcRouteWithPBData() engineInitStart");
                }

                public void engineInitFail() {
                    LogUtil.m3004e("SDKHelper", "calcRouteWithPBData() engineInitFail");
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData engineInitFail");
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            });
        }
        return true;
    }

    public String getTRURlParam() {
        NavLogUtils.m3003e(TAG, "getTRURlParam() URlParam111=");
        return NavRoutePlanController.getInstance().getTRURlParam();
    }

    private void searchByKeyForPBData(String key, int districtId, int poiCount, int strategy, int rpNodeCount, int searchRouteNodeType, int viaRouteNodeIndex) {
        NavSearchController.getInstance().searchByKeyForPBData(key, districtId, poiCount, strategy, rpNodeCount, searchRouteNodeType, viaRouteNodeIndex);
    }

    public boolean searchByNameForMapPoiResultPB(String name, int districtID, NavSearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        NavPerformanceModel.getInstance().startSearchByNameForMapPoiResultPB();
        NavLogUtils.m3003e(TAG, "searchByNameForMapPoiResultPB() name=" + name + ", districtID=" + districtID);
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity != null && !NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
            return false;
        } else if (sIsBaseEngineInitialized) {
            return NavSearchController.getInstance().searchByNameForMapPoiResultPB(name, districtID, circle, poiCount, pageNumber, handler);
        } else {
            if (activity == null) {
                return false;
            }
            final String str = name;
            final int i = districtID;
            final NavSearchCircle navSearchCircle = circle;
            final int i2 = poiCount;
            final int i3 = pageNumber;
            final Handler handler2 = handler;
            getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                public void engineInitSuccess() {
                    LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            NavSearchController.getInstance().searchByNameForMapPoiResultPB(str, i, navSearchCircle, i2, i3, handler2);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitStart() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitFail() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            });
            return true;
        }
    }

    public boolean searchByCircleForMapPoiResultPB(String name, int districtID, NavSearchCircle circle, int poiCount, int pageNumber, Handler handler) {
        NavPerformanceModel.getInstance().startSearchByCircleForMapPoiResultPB();
        NavLogUtils.m3003e(TAG, "searchByCircleForMapPoiResultPB() name=" + name + ", districtID=" + districtID);
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity != null && !NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
            return false;
        } else if (sIsBaseEngineInitialized) {
            return NavSearchController.getInstance().searchByCircleForMapPoiResultPB(name, districtID, circle, poiCount, pageNumber, handler);
        } else {
            if (activity == null) {
                return false;
            }
            final String str = name;
            final int i = districtID;
            final NavSearchCircle navSearchCircle = circle;
            final int i2 = poiCount;
            final int i3 = pageNumber;
            final Handler handler2 = handler;
            getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                public void engineInitSuccess() {
                    LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            NavSearchController.getInstance().searchByCircleForMapPoiResultPB(str, i, navSearchCircle, i2, i3, handler2);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitStart() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitFail() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            });
            return true;
        }
    }

    public Bundle getSearchStatusInfo() {
        if (sIsBaseEngineInitialized) {
            return NavSearchController.getInstance().getSearchStatusInfo();
        }
        return null;
    }

    public boolean routeSearchForMapPoiResultPB(int routeSearchMode, String searchWord, int searchRange, int sortType, String mrsl, int poiCount, int pageNumber, Handler handler) {
        NavLogUtils.m3003e(TAG, "routeSearchForMapPoiResultPB() routeSearchMode=" + routeSearchMode + ", searchWord=" + searchWord + ", searchRange=" + searchRange + ", sortType=" + sortType + ", mrsl=" + mrsl);
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity != null && !NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
            return false;
        } else if (sIsBaseEngineInitialized) {
            return NavSearchController.getInstance().routeSearchForMapPoiResultPB(routeSearchMode, searchWord, searchRange, sortType, mrsl, poiCount, pageNumber, handler);
        } else {
            if (activity == null) {
                return false;
            }
            final int i = routeSearchMode;
            final String str = searchWord;
            final int i2 = searchRange;
            final int i3 = sortType;
            final String str2 = mrsl;
            final int i4 = poiCount;
            final int i5 = pageNumber;
            final Handler handler2 = handler;
            getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                public void engineInitSuccess() {
                    LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            NavSearchController.getInstance().routeSearchForMapPoiResultPB(i, str, i2, i3, str2, i4, i5, handler2);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitStart() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }

                public void engineInitFail() {
                    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                        protected String execute() {
                            NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                            NavMapAdapter.getInstance().dismissMProgressDialog();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            });
            return true;
        }
    }

    public boolean setTTSVoiceDataPath(String newTTSPath) {
        return BaseTTSPlayer.getInstance().setTTSVoiceDataPath(newTTSPath);
    }

    public boolean switchTTSVoiceData(String absTTSPath) {
        return BaseTTSPlayer.getInstance().switchTTSVoiceData(absTTSPath, null);
    }

    public boolean switchTTSVoiceData(String absTTSPath, OnTTSVoiceDataSwitchListener lis) {
        return BaseTTSPlayer.getInstance().switchTTSVoiceData(absTTSPath, lis);
    }

    public String getCurrentTTSVoiceDataPath() {
        return BaseTTSPlayer.getInstance().getCurrentTTSVoiceDataPath();
    }

    public void setCalcPrference(final int preference) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            Context activity = NavCommonFuncModel.getInstance().getActivity();
            if (activity != null && !NavMapAdapter.getInstance().isExternalStorageEnabled()) {
                NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
            } else if (sIsBaseEngineInitialized) {
                NavRouteGuideController.getInstance().setCalcPrference(preference);
            } else if (activity != null) {
                getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                    public void engineInitSuccess() {
                        LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                NavRouteGuideController.getInstance().setCalcPrference(preference);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitStart() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitFail() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                });
            }
        }
    }

    public void sendNaviStatistics(RouteNode startNode, RouteNode endNode, String naviAction, String naviEnter) {
        if (sIsBaseEngineInitialized) {
            NavUserBehaviour.getInstance().sendNaviStatistics(startNode, endNode, naviAction, NavRoutePlanModel.getInstance().getStrategyForUserBeh(), naviEnter);
        }
    }

    public void launchDownloadActivity(final Context ctx, final String isFromCruiser) {
        if (sIsBaseEngineInitialized) {
            Activity activity = NavCommonFuncModel.getInstance().getActivity();
            if (sIsBaseEngineInitialized) {
                NavCommonFuncController.getInstance().launchDownloadActivity(ctx, isFromCruiser);
            } else {
                getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                    public void engineInitSuccess() {
                        LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                NavCommonFuncController.getInstance().launchDownloadActivity(ctx, isFromCruiser);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitStart() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitFail() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                });
            }
        }
    }

    public int downLoadCityMapData(int cityId) {
        if (sIsBaseEngineInitialized) {
            return NavCommonFuncController.getInstance().downLoadCityMapData(cityId);
        }
        return -1;
    }

    public boolean ttsAction(final Bundle data) {
        NavLogUtils.m3003e(TAG, "ttsAction");
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        final Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (sIsBaseEngineInitialized) {
            return ttsActionInner(data);
        }
        if (activity == null) {
            return false;
        }
        getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
            public void engineInitSuccess() {
                LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                    protected String execute() {
                        NavMapAdapter.getInstance().dismissMProgressDialog();
                        BaiduNaviManager.this.ttsActionInner(data);
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
            }

            public void engineInitStart() {
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                    protected String execute() {
                        NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity) activity, "", activity.getString(C0965R.string.nav_engine_is_initializing));
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
            }

            public void engineInitFail() {
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                    protected String execute() {
                        NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                        NavMapAdapter.getInstance().dismissMProgressDialog();
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
            }
        });
        return true;
    }

    private boolean ttsActionInner(Bundle data) {
        boolean z = true;
        NavLogUtils.m3003e(TAG, "ttsActionInner");
        if (!NavMapAdapter.getInstance().isNaviInjectSuccess() || !sIsBaseEngineInitialized || data == null) {
            return false;
        }
        String action = "unknown";
        String ypid = "unknown";
        String entry = "openapi";
        if (data.containsKey(VoiceKey.ACTION)) {
            action = data.getString(VoiceKey.ACTION);
        }
        if (data.containsKey("ypid")) {
            ypid = data.getString("ypid");
        }
        if (data.containsKey("entry")) {
            entry = data.getString("entry");
        }
        NavLogUtils.m3003e(TAG, "ttsAction() action=" + action + ", ypid=" + ypid + ", entry=" + entry);
        NavCommonFuncController.getInstance().setVoiceEnter(entry);
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (action == null || action.length() == 0 || activity == null) {
            String str = TAG;
            StringBuilder append = new StringBuilder().append("ttsAction() activity=null?");
            if (activity != null) {
                z = false;
            }
            NavLogUtils.m3003e(str, append.append(z).toString());
            return false;
        }
        if ("voicemain".equals(action)) {
            NavLogUtils.m3003e(TAG, "ttsAction() start VoiceMain Page.");
            NavCommonFuncController.getInstance().setExternalCall(true, data);
        } else if ("download".equals(action)) {
            NavLogUtils.m3003e(TAG, "ttsAction() start VoiceMain Page.");
            if (isNaviBegin()) {
                return true;
            }
        } else if ("record".equals(action)) {
            NavLogUtils.m3003e(TAG, "ttsAction() start VoiceRecord Page.");
        }
        return true;
    }

    public boolean isNaviBegin() {
        boolean z = false;
        try {
            if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
                z = NavCommonFuncController.getInstance().isNaviBegin();
            }
        } catch (Throwable th) {
        }
        return z;
    }

    public boolean setDestNodes(List<RouteNode> viaNodes, RouteNode endNode) {
        NavLogUtils.m3003e(TAG, "setDestsWithPBData() ");
        if (sIsBaseEngineInitialized) {
            return NavRoutePlanController.getInstance().setDestNodes(viaNodes, endNode);
        }
        return false;
    }

    public void launchUgcMangerActivity(Context ctx) {
        if (sIsBaseEngineInitialized) {
            try {
                NavCommonFuncModel.getInstance().getActivity();
                NavCommonFuncController.getInstance().launchUgcMangerActivity(ctx);
            } catch (NullPointerException e) {
            }
        }
    }

    public void launchUgcPickActivity(Context ctx, Bundle b) {
        if (sIsBaseEngineInitialized) {
            Activity activity = NavCommonFuncModel.getInstance().getActivity();
            NavCommonFuncController.getInstance().launchUgcPickActivity(ctx, b);
        }
    }

    public void showNavPage(String pageName, Bundle data) {
        if (sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().showNavPage(pageName, data);
        }
    }

    public void releaseResources() {
        NavFragmentManager.getInstance().destroy();
    }

    public void notifyMapGPSEnable(boolean useGPS) {
        if (this.mNaviHandler.hasMessages(2)) {
            this.mNaviHandler.removeMessages(2);
        }
        Message msg = this.mNaviHandler.obtainMessage(2);
        msg.arg1 = useGPS ? 1 : 0;
        this.mNaviHandler.sendMessageDelayed(msg, 500);
    }

    public Handler getNaviMainHandler() {
        return this.mNaviHandler;
    }

    public void runOnUIThread(final Runnable runnable) {
        if (runnable != null) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {
                protected String execute() {
                    runnable.run();
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    public boolean isLastNaviUnfinished(Context context) {
        return NavRecoverController.getInstance().isLastNaviUnfinished(context);
    }

    public long getKilledTime(Context context) {
        return NavRecoverController.getInstance().getKilledTime(context);
    }

    public void setKilledTime(Context context, long time) {
        BNRecoverNaviHelper.getInstance().setKilledTime(context, time);
    }

    public boolean checkLastNaviStatus(Handler handler) {
        return NavRecoverController.getInstance().checkLastNaviStatus(handler);
    }

    public boolean continueLastNavi() {
        return NavRecoverController.getInstance().continueLastNavi();
    }

    public boolean clearLastNaviRoutelnfo() {
        try {
            return NavRecoverController.getInstance().clearLastNaviRoutelnfo();
        } catch (Throwable th) {
            return false;
        }
    }

    public void updateAccountInfoWhenLoginSuccess() {
        if (sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().updateAccountInfoWhenLoginSuccess();
        }
    }

    public void setSensor(int angleX) {
        if (sIsBaseEngineInitialized) {
            NavRoutePlanModel.getInstance().setmMapSensorAngle(angleX);
        }
    }

    public void triggerStartSensorData(float x, float y, float z) {
        if (sIsBaseEngineInitialized) {
            NavRoutePlanModel.getInstance().triggerStartSensorData(x, y, z);
        }
    }

    @Deprecated
    public void initSensorListener() {
    }

    public void goToLightNaviComAddrPage(Context ctx, int entry) {
    }

    public void enterLightNavi(Context ctx, int entry) {
    }

    public Bundle getHomeAndCompanyRouteInfo(RouteNode startNode, RouteNode endNode, int from, int entry) {
        NavLogUtils.m3003e(TAG, "getHomeAndCompanyRouteInfo  entry: " + entry);
        if (sIsBaseEngineInitialized) {
            return NavRoutePlanController.getInstance().getHomeAndCompanyRouteInfo(startNode, endNode, from, entry);
        }
        return null;
    }

    public boolean startDrivingCar() {
        if (sIsBaseEngineInitialized) {
            return NavDrivingCarController.getInstance().startDrivingCar();
        }
        return false;
    }

    public boolean stopDrivingCar() {
        if (sIsBaseEngineInitialized) {
            return NavDrivingCarController.getInstance().stopDrivingCar();
        }
        return false;
    }

    public void lauchIPONavi() {
        if (sIsBaseEngineInitialized) {
            NavRoutePlanController.getInstance().lauchIPONavi();
        }
    }

    public int refreshRouteForDrivingCar() {
        if (sIsBaseEngineInitialized) {
            return NavDrivingCarController.getInstance().refreshRouteForDrivingCar();
        }
        return -1;
    }

    public boolean selectRoute(String routeMrsl, boolean StartDriv) {
        if (!sIsBaseEngineInitialized) {
            return false;
        }
        NavRoutePlanModel.getInstance().mStartDriv = StartDriv;
        NavRoutePlanModel.getInstance().mCurMrsl = routeMrsl;
        return NavDrivingCarController.getInstance().selectRoute(routeMrsl, StartDriv);
    }

    public Bitmap getCarNaviBusinessImage() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            return NavTrajectoryController.getInstance().getCarNaviBusinessImage();
        }
        return null;
    }

    public boolean resetEndNodeInNavi(RouteNode newEndNode) {
        if (isNaviBegin() && newEndNode != null && newEndNode.mGeoPoint != null && newEndNode.mGeoPoint.isValid() && sIsBaseEngineInitialized) {
            return NavRouteGuideController.getInstance().resetEndNodeInNavi(newEndNode);
        }
        return false;
    }

    public boolean isProvinceDataDownload(int provinceID) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            return NavCommonFuncController.getInstance().isProvinceDataDownload(provinceID);
        }
        return false;
    }

    public void pauseAllDownload() {
        if (sIsBaseEngineInitialized && sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().pauseAllDownload();
        }
    }

    public boolean setVoiceModeInNavi(int voiceMode) {
        if (!NavMapAdapter.getInstance().isNaviInjectSuccess() || !sIsBaseEngineInitialized || !sIsBaseEngineInitialized) {
            return false;
        }
        NavRouteGuideController.getInstance().setVoiceModeInNavi(voiceMode);
        return true;
    }

    public void forceQuitWithoutDialog() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            NavRouteGuideController.getInstance().forceQuitWithoutDialog();
        }
    }

    public void registerNavEventListener(NaviEvent listener) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().addNaviEventListener(listener);
        }
    }

    public void unregisterNavEventListener(NaviEvent listener) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            NavCommonFuncController.getInstance().removeNaviEventListener(listener);
        }
    }

    public boolean onBackPressRCEvent() {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized && sIsBaseEngineInitialized) {
            return NavCommonFuncController.getInstance().onBackPressRCEvent();
        }
        return false;
    }

    public void addRoutePlanSuccessLog(long endTime) {
        NavCommonFuncController.getInstance().addRoutePlanSuccessLog(endTime);
    }

    public void setBNotBuildCarData(boolean flag) {
        NavRoutePlanController.getInstance().setBNotBuildCarData(flag);
    }

    public boolean recordTimeLog(String stepIndex, String module, String stepName, long startTime, long endTime) {
        String returnVal = stepIndex + "-" + module + "-" + stepName + JNISearchConst.LAYER_ID_DIVIDER + startTime + JNISearchConst.LAYER_ID_DIVIDER + endTime + "=" + (endTime - startTime);
        NavLogUtils.m3003e(PerformStatItem.TIME_ACTION_TAG, returnVal);
        JSONObject retVal = new JSONObject();
        try {
            retVal.put(PerformStatItem.TIME_ACTION_TAG, returnVal);
        } catch (Exception e) {
        }
        return C2905c.m10957a().m10960a(2110, 1, PerformStatItem.TIME_ACTION_TAG, retVal.toString());
    }

    public void addTrimMemoryStat() {
        NavCommonFuncController.getInstance().addTrimMemoryStat();
    }

    public void getRouteBoundRect(ArrayList<Bundle> routeBound) {
        BNRoutePlaner.getInstance().getRouteBoundRect(routeBound);
    }

    public void setIsChangeBackground(int isBackground) {
        if (NavMapAdapter.getInstance().isNaviInjectSuccess() && sIsBaseEngineInitialized) {
            BNRoutePlaner.getInstance().setIsChangeBackground(isBackground);
        }
    }

    public void setCarInfo(String carNum) {
        NavRoutePlanController.getInstance().setCarInfo(new NavCarInfo(carNum));
    }

    public void resetLastDoubleClickTime() {
        NavCommonFuncController.getInstance().resetLastDoubleClickTime();
    }

    public void onRestoreData(boolean restoreData) {
        if (sIsBaseEngineInitialized) {
            NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = false;
            UserOPController.getInstance().add(UserOPParams.COMMON_1_q);
            return;
        }
        NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = restoreData;
    }

    public void initURLData() {
    }

    public void showEyeSpyPaperButton() {
        BNEyeSpyPaperController.getInstance().showButton();
    }

    public void hideEyeSpyPaperButton() {
        BNEyeSpyPaperController.getInstance().hideButton();
    }
}
