package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.baidu.baidumaps.p042f.p043a.p045b.C0706a;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanKey;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.CarNaviTrajectoryModel;
import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviAction;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviEnter;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailType;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.MapComponentCallback;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.statistic.IBNPerformStatListener;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RoutePlanStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOP;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.navisdk.util.worker.loop.BNMainLooperMsgHandler;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class NavRoutePlanController {
    private static final int MSG_CANCEL_MAP_LIGHT_SEARCH = 4445;
    private static final int MSG_Type_Request_Map_Light_Search = 4444;
    private static final int ROUTE_PLAN_TYPE_FOR_NAVI = 2;
    private static final int ROUTE_PLAN_TYPE_FOR_PB = 0;
    private static final int ROUTE_PLAN_TYPE_WITH_PB = 1;
    public static final String TAG = NavRoutePlanController.class.getSimpleName();
    private static NavRoutePlanController sInstance = null;
    private boolean isMulRoutePlan = false;
    private int mDistrictID = 0;
    private MsgHandler mHandler = new BNMainLooperMsgHandler() {
        public void onMessage(Message msg) {
            NavLogUtils.m3003e(NavRoutePlanController.TAG, "handleMessage() what=" + msg.what + ", arg1=" + msg.arg1 + ", arg2=" + msg.arg2);
            if (4115 == msg.what) {
                if (3 == msg.arg1 && NavRoutePlanModel.getInstance().mStartDriv) {
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "NavDrivingCar===  Message() selectRoute -> fordravingcar===");
                    NavRoutePlanModel.getInstance().mStartDriv = false;
                    if (!BNRoutePlaner.getInstance().isBuildRouteReady(false, NavRoutePlanModel.getInstance().mCurMrsl) || BaiduNaviManager.getInstance().getMapHandler() == null) {
                        NavRoutePlanModel.getInstance().mNotBuildReady = true;
                    } else {
                        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_DRIVING_CAR_SELECT_ROUTE_SUCCESS).sendToTarget();
                    }
                    if (BNSettingManager.isShowJavaLog()) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" NavDrivingCar===  Message() selectRoute -> fordravingcar===");
                    }
                }
            } else if (NavRoutePlanController.MSG_CANCEL_MAP_LIGHT_SEARCH == msg.what) {
                NavLogUtils.m3003e(NavRoutePlanController.TAG, "mapLightSearch() execute timout, mMapLightSearchRequestID=" + NavRoutePlanController.this.mMapLightSearchRequestID);
                NavRoutePlanController.this.cancelMapLightSearch();
                BNRoutePlaner.getInstance().lightCalcRoute(-1);
            } else if (MsgDefine.MSG_NAVI_TYPE_Car_Navi_Route_Plan_Result == msg.what) {
                byte[] pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
                NavLogUtils.m3003e(NavRoutePlanController.TAG, "NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=" + (pbData == null ? 0 : pbData.length));
                Bundle data = new Bundle();
                data.putByteArray("pb_data", pbData);
                data.putInt(RoutePlanKey.Route_Refresh_Reason, msg.arg2);
                if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                    if (msg.arg2 == 2) {
                    }
                    Message sucMsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(msg.arg2 == 2 ? BaiduNaviManager.MSG_NAVI_DRIVING_CAR_ROUTE_REFRESH : 1002);
                    C0706a.m2986a().f2297r = true;
                    sucMsg.obj = data;
                    sucMsg.sendToTarget();
                }
                if (!NavCommonFuncModel.getInstance().mIsAppForeground) {
                    NavDrivingCarController.getInstance().hasYawRouteMsg = true;
                }
                if (BNSettingManager.isShowJavaLog()) {
                    SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=" + (pbData == null ? Integer.valueOf(0) : pbData.length + " msg.arg2= " + msg.arg2));
                }
            } else if (4098 == msg.what) {
                int nMsgType = msg.arg1;
                NavLogUtils.m3003e(NavRoutePlanController.TAG, "NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + nMsgType);
                if (BNSettingManager.isShowJavaLog()) {
                    SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add("NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + nMsgType);
                }
                if (nMsgType == 6 && BaiduNaviManager.getInstance().getMapHandler() != null) {
                    BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_DRIVING_CAR_ARRIVE_DEST).sendToTarget();
                }
            }
        }

        public void careAbout() {
            observe(4115);
            observe(MsgDefine.MSG_NAVI_TYPE_Car_Navi_Route_Plan_Result);
            observe(4098);
        }
    };
    private boolean mHasDirectyStartRouteGuide = false;
    private boolean mIsRequestShowRouteGuideView = false;
    private MapComponentCallback mMapComponentCallback = null;
    public int mMapLightSearchRequestID = -1;
    private long mMapLightSearchTimeout = BNOffScreenParams.MIN_ENTER_INTERVAL;
    private String mMapLightSearchUrl = null;
    private MapSearchAPIWrapper mMapSearchAPIWrapper = null;
    private IBNPerformStatListener mPerformStatListener = new C08361();
    private Handler mRPHandler = new C08449();
    private NavRoutePlanObserver mRoutePlanObserver = null;
    private int mRoutePlanType = -1;
    private int reCalNum = 2;

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$1 */
    class C08361 implements IBNPerformStatListener {
        C08361() {
        }

        public boolean onLogRecord(int type, int level, String strAction, String actionParam) {
            return NavMapAdapter.getInstance().addPerformLog(type, level, strAction, actionParam);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$2 */
    class C08372 implements IJumpToDownloadListener {
        C08372() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$3 */
    class C08383 implements IJumpToDownloadListener {
        C08383() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$4 */
    class C08394 implements OnCancelListener {
        C08394() {
        }

        public void onCancel(DialogInterface dialog) {
            BNRoutePlaner.setSelectRouteCallback(null);
            Handler tpHD = BaiduNaviManager.getInstance().getNaviMainHandler();
            if (tpHD != null && tpHD.hasMessages(3)) {
                tpHD.removeMessages(3);
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$6 */
    class C08416 implements IJumpToDownloadListener {
        C08416() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$7 */
    class C08427 implements IJumpToDownloadListener {
        C08427() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$8 */
    class C08438 implements IJumpToDownloadListener {
        C08438() {
        }

        public void onJumpToDownloadOfflineData() {
            BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRoutePlanController$9 */
    class C08449 extends BNMainLooperHandler {
        C08449() {
        }

        public void onMessage(Message msg) {
            byte[] pbData;
            switch (msg.what) {
                case 7:
                    NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
                    if (NavRoutePlanController.this.mRoutePlanType != 2) {
                        NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle RP_FAIL_NORMAL ");
                        NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                        NavLogUtils.m3003e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    } else if (NavRoutePlanController.this.mRoutePlanType == 2 && NavRoutePlanModel.getInstance().getEntry() == 16) {
                        NavRoutePlanController.this.reCalRouteForDrivingCar();
                    }
                    if (NavRoutePlanController.this.mRoutePlanType != 0 || NavRoutePlanModel.getInstance().getRouteInfoStatus() != 2) {
                        BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                        return;
                    }
                    return;
                case 8:
                    if (NavRoutePlanController.this.mRoutePlanType != 2) {
                        NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle .RP_BEFORE_START");
                        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                            BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1000);
                            return;
                        }
                        return;
                    }
                    return;
                case 33:
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "NavDrivingCar===rpHandle RP_SUCCESS_BUILD ");
                    if (NavRoutePlanModel.getInstance().mNotBuildReady) {
                        NavRoutePlanModel.getInstance().mNotBuildReady = false;
                        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                            BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_DRIVING_CAR_SELECT_ROUTE_SUCCESS).sendToTarget();
                        }
                    }
                    pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(2);
                    Bundle dataBundle = new Bundle();
                    dataBundle.putByteArray("pb_data", pbData);
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        Message Msg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1004);
                        Msg.obj = dataBundle;
                        Msg.sendToTarget();
                        return;
                    }
                    return;
                case 34:
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle RP_FAIL_BUILD ");
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1005);
                    }
                    if (NavRoutePlanController.this.mRoutePlanType != 0 || !NavRoutePlanController.this.isMulRoutePlan) {
                        BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                        return;
                    }
                    return;
                case 35:
                    NavLogUtils.m3003e("OPENAPI", "NavRoutePlanerController Recv KEYWORD_RESULT MSG, time = " + System.currentTimeMillis());
                    pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(0);
                    if (pbData != null) {
                        NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle RP_MAP_KEYWORD_RESULT routePB.len=" + pbData.length);
                    }
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle RP_MAP_KEYWORD_RESULT");
                    Bundle data = new Bundle();
                    data.putByteArray("pb_data", pbData);
                    NavCommonFuncController.getInstance().resetLastDoubleClickTime();
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        Message failMsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1020);
                        failMsg.obj = data;
                        failMsg.sendToTarget();
                    }
                    BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                    return;
                case 37:
                    if (NavRoutePlanModel.getInstance().getEntry() != 16) {
                        NavRoutePlanController.this.lauchIPONavi();
                        return;
                    } else if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_RP_IPO_SUCCESS_NORMAL).sendToTarget();
                        return;
                    } else {
                        return;
                    }
                case 38:
                    if (NavRoutePlanModel.getInstance().getEntry() == 16) {
                        NavRoutePlanController.this.reCalRouteForDrivingCar();
                        return;
                    }
                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_RP_IPO_FAIL_NORMAL).sendToTarget();
                    }
                    NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
                    BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                    return;
                case NavRoutePlanController.MSG_Type_Request_Map_Light_Search /*4444*/:
                    if (NavMapAdapter.getInstance().getDebugConfigUserTest()) {
                        PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, "7", PerformStatItem.MAP_MODULE_NAME, PerformStatItem.REQUEST_MAP_LIGHT_SERVICE_STEP_NAME, PerformStatItem.sRequestMapLightServiceStart, System.currentTimeMillis());
                        PerformStatItem.sNetWorkRequestStart = System.currentTimeMillis();
                    }
                    NavRoutePlanController.this.mMapLightSearchRequestID = NavMapAdapter.getInstance().mapLightSearch(NavRoutePlanController.this.mMapLightSearchUrl, NavRoutePlanController.this.mHandler, NavRoutePlanController.MSG_CANCEL_MAP_LIGHT_SEARCH, NavRoutePlanController.this.mMapSearchAPIWrapper, NavRoutePlanController.this.mMapLightSearchTimeout);
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "rpHandle .mMapLightSearchRequestID:" + NavRoutePlanController.this.mMapLightSearchRequestID);
                    return;
                default:
                    return;
            }
        }
    }

    private NavRoutePlanController() {
        VMsgDispatcher.registerMsgHandler(this.mHandler);
        this.mMapSearchAPIWrapper = new MapSearchAPIWrapper("test");
    }

    public static NavRoutePlanController getInstance() {
        if (sInstance == null) {
            sInstance = new NavRoutePlanController();
        }
        return sInstance;
    }

    public void init() {
        initMapSearchListener();
        setCarInfo(NavMapAdapter.getInstance().getCarInfoFromMap());
        if (NavMapAdapter.getInstance().getDebugConfigUserTest()) {
            PerformStatItem.sUserTest = NavMapAdapter.getInstance().getDebugConfigUserTest();
            PerformStatisticsController.getInstance().setPerformStatListener(this.mPerformStatListener);
        }
    }

    public void setRequestShowRouteGuideView(boolean show) {
        this.mIsRequestShowRouteGuideView = show;
    }

    public void setCarInfo(NavCarInfo carInfo) {
        if (carInfo != null && carInfo.carPANumber != null && carInfo.carPANumber.length() > 0) {
            try {
                BNRoutePlaner.getInstance().setCalcPrefCarNo(carInfo.carPANumber);
            } catch (Throwable th) {
            }
        }
    }

    public void calcRouteForPBData(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int routeInfoStatus, String carPANumber, int entry) {
        NavInitController.getInstance().handleAppSource();
        Context activity = BNaviModuleManager.getActivity();
        if (activity != null) {
            if (endNode.mFromType == 99) {
                endNode.mFromType = 1;
                this.isMulRoutePlan = true;
            } else {
                this.isMulRoutePlan = false;
            }
            NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
            NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
            NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = -1;
            NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
            this.mHasDirectyStartRouteGuide = false;
            setRequestShowRouteGuideView(false);
            ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
            RoutePlanNode startRoutePlanNode = NavModelHelper.convertRouteNode(startNode);
            if (PerformStatItem.sEnableTestData) {
                startRoutePlanNode.setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119d, 40.040642d));
            }
            rpNodeLists.add(startRoutePlanNode);
            if (NavLogUtils.LOGGABLE) {
                NavTipTool.onCreateToastDialog(activity, "速度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSAccuracy);
            }
            if (viaNodes != null && viaNodes.size() > 0) {
                for (int i = 0; i < viaNodes.size(); i++) {
                    RouteNode tNode = (RouteNode) viaNodes.get(i);
                    if (tNode != null) {
                        rpNodeLists.add(NavModelHelper.convertRouteNode(tNode));
                    }
                }
            }
            rpNodeLists.add(NavModelHelper.convertRouteNode(endNode));
            this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new C08372());
            BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
            String mrsl = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
            BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
            this.mRoutePlanType = 0;
            BNRoutePlaner.getInstance().setCalcPrference(unPreference);
            BNRoutePlaner.getInstance().setDriveRefTimeParams(30, 1440);
            int rpSource = routeInfoStatus == 2 ? 1 : 0;
            BNRoutePlaner.getInstance().setEntry(entry);
            BNRoutePlaner.getInstance().setPointsToCalcRouteForMap(rpNodeLists, -1, false, null, rpSource);
            CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
            NavLogUtils.m3003e(CarNaviTrajectoryModel.TAG, "is from route plan");
        }
    }

    public boolean selectRouteToNavi(String routeMrsl, boolean isGPSNav, boolean isRedirector, int entry) {
        NavLogUtils.m3003e(TAG, "NavRoutePlanController.selectRouteToNavi() mrsl=" + routeMrsl + "  entry= " + entry);
        Activity activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null) {
            return false;
        }
        this.mHasDirectyStartRouteGuide = false;
        getInstance().setRequestShowRouteGuideView(true);
        NavRouteGuideController.getInstance().setLocateMode(isGPSNav ? 1 : 2);
        NavRoutePlanModel.getInstance().setEntry(entry);
        this.mRoutePlanObserver = null;
        this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new C08383());
        BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
        if (entry == 16 || entry == 10) {
            return selectRouteToIpoNav(routeMrsl, isGPSNav, isRedirector, entry);
        }
        if (BNRoutePlaner.getInstance().selectRouteWithMrsl(routeMrsl) >= 0) {
            gotoRouteGuideViewDirectly(routeMrsl);
            return true;
        }
        getInstance().setRequestShowRouteGuideView(false);
        return false;
    }

    private boolean selectRouteToIpoNav(final String routeMrsl, boolean isGPSNav, boolean isRedirector, final int entry) {
        if (!BNRoutePlaner.getInstance().isBuildRouteReady(false, routeMrsl)) {
            Activity activity = NavCommonFuncModel.getInstance().getActivity();
            if (!(activity == null || entry == 16)) {
                NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity) activity, null, null, new C08394());
                Handler tpHD = BaiduNaviManager.getInstance().getNaviMainHandler();
                if (tpHD != null) {
                    if (tpHD.hasMessages(3)) {
                        tpHD.removeMessages(3);
                    }
                    tpHD.sendEmptyMessageDelayed(3, 60000);
                }
            }
            BNRoutePlaner.setSelectRouteCallback(new MapComponentCallback() {
                public int onMapComponentCall(int what, int i1, int i2, Object o) {
                    switch (what) {
                        case MsgDefine.MSG_NAVI_Success_BuildGuideRoute /*4170*/:
                            if (entry != 16) {
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                Handler tpHD = BaiduNaviManager.getInstance().getNaviMainHandler();
                                if (tpHD != null && tpHD.hasMessages(3)) {
                                    tpHD.removeMessages(3);
                                }
                            }
                            if (BNRoutePlaner.getInstance().selectRouteWithMrsl(routeMrsl) < 0) {
                                NavRoutePlanController.getInstance().setRequestShowRouteGuideView(false);
                                break;
                            }
                            NavRoutePlanController.this.gotoRouteGuideViewDirectly(routeMrsl);
                            break;
                        case MsgDefine.MSG_NAVI_Fail_BuildGuideRoute /*4173*/:
                            if (entry != 16) {
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                Handler tpHD2 = BaiduNaviManager.getInstance().getNaviMainHandler();
                                if (tpHD2 != null && tpHD2.hasMessages(3)) {
                                    tpHD2.removeMessages(3);
                                    break;
                                }
                            }
                            break;
                    }
                    return 0;
                }
            });
            return true;
        } else if (BNRoutePlaner.getInstance().selectRouteWithMrsl(routeMrsl) >= 0) {
            gotoRouteGuideViewDirectly(routeMrsl);
            return true;
        } else {
            getInstance().setRequestShowRouteGuideView(false);
            return false;
        }
    }

    private void gotoRouteGuideViewDirectly(String mrsl) {
        int entry = NavRoutePlanModel.getInstance().getEntry();
        NavLogUtils.m3003e(TAG, "NavRoutePlanController.handleMessage() selectRoute -> showRouteGuide(). entry= " + entry);
        NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_ROUTE_NAV);
        int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
        BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
        if (entry == 16) {
            this.mIsRequestShowRouteGuideView = false;
            if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_RP_IPO_SUCCESS_NORMAL).sendToTarget();
            }
        } else if (entry == 10) {
            this.mIsRequestShowRouteGuideView = false;
            lauchIPONavi();
        } else {
            this.mIsRequestShowRouteGuideView = false;
            Bundle bundle = createNaviParam(NavRouteGuideController.getInstance().getLocateMode(), false);
            String str = BNavConfig.KEY_ROUTEGUIDE_SELECTED_ROUTE_MRSL;
            if (mrsl == null) {
                mrsl = "";
            }
            bundle.putString(str, mrsl);
            NavRouteGuideController.getInstance().startRouteGuideView(false, bundle);
            NavRouteGuideController.getInstance().setLocateMode(1);
        }
        BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_ROUTE_NAV);
        if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" NavRoutePlanController.gotoRouteGuideViewDirectly() selectRoute -> showRouteGuide(). entry= " + entry + " gpsState= " + gpsState);
        }
    }

    public boolean clearRouteBuffer() {
        return BNRoutePlaner.getInstance().clearRouteBuffer();
    }

    public int getRoutePlanRequestID() {
        return BNRoutePlaner.getInstance().getRoutePlanRequestID();
    }

    public void cancleCalcRouteRequest() {
        this.mHasDirectyStartRouteGuide = false;
        BNRoutePlaner.getInstance().cancleCalcRouteRequest();
    }

    public Bundle getRoutePlanStatusInfo() {
        Bundle data = new Bundle();
        NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = true;
        RoutePlanModel routePlanMode = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (routePlanMode != null) {
            ArrayList<RoutePlanNode> nodes = routePlanMode.getRouteInput();
            if (nodes != null && nodes.size() > 0) {
                for (int i = 0; i < nodes.size(); i++) {
                    DistrictInfo districtInfo;
                    RoutePlanNode node = (RoutePlanNode) nodes.get(i);
                    if (node != null && node.mFrom != 2 && node.mGeoPoint != null) {
                        districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(node.mGeoPoint, 0);
                    } else if (node == null || node.mDistrictID <= 1) {
                        districtInfo = null;
                    } else {
                        districtInfo = BNPoiSearcher.getInstance().getDistrictById(node.mDistrictID);
                    }
                    if (districtInfo == null) {
                        NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
                        break;
                    }
                    while (districtInfo != null && districtInfo.mType > 2) {
                        districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
                    }
                    if (districtInfo == null || districtInfo.mType != 2) {
                        NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
                    } else {
                        NavRoutePlanModel instance = NavRoutePlanModel.getInstance();
                        instance.mIsContainsAllNodeOfflineData &= BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId);
                    }
                    if (!NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData) {
                        break;
                    }
                }
            }
        }
        NavLogUtils.m3003e(TAG, "getRoutePlanStatusInfo() result=" + NavRoutePlanModel.getInstance().mRoutePlanResultOK + ", failedType=" + NavCommonFuncController.getInstance().getFormatErrorCode(NavRoutePlanModel.getInstance().mRoutePlanResultFailedType) + ", netmode=" + BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() + ", hasOfflineData=" + NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData + ", calcTime=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
        data.putBoolean("result", NavRoutePlanModel.getInstance().mRoutePlanResultOK);
        data.putInt(BaiduNaviParams.KEY_FAILED_TYPE, NavCommonFuncController.getInstance().getFormatErrorCode(NavRoutePlanModel.getInstance().mRoutePlanResultFailedType));
        data.putInt(BaiduNaviParams.KEY_NETMODE, BNRoutePlaner.getInstance().getEngineCalcRouteNetMode());
        data.putBoolean(BaiduNaviParams.KEY_HASOFFLINEDATA, NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData);
        data.putLong(BaiduNaviParams.KEY_TIME, NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime);
        return data;
    }

    public void calcRouteToNaviRoute(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int entry) {
        NavInitController.getInstance().handleAppSource();
        NavLogUtils.m3003e(TAG, "calcRouteToNaviRoute() unPreference=" + unPreference + ", strategy=" + strategy);
        Context activity = BNaviModuleManager.getActivity();
        if (activity == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteToNaviRoute activity is null");
            return;
        }
        this.mHasDirectyStartRouteGuide = false;
        setRequestShowRouteGuideView(false);
        checkNodeIsValid(startNode, endNode, entry);
        NavRoutePlanModel.getInstance().setStrategy(2);
        ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
        NavRoutePlanModel.getInstance().setViaNodes(viaNodes);
        RoutePlanNode startRoutePlanNode = NavModelHelper.convertRouteNode(startNode);
        if (PerformStatItem.sEnableTestData) {
            startRoutePlanNode.setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119d, 40.040642d));
        }
        startNode.mCityID = startRoutePlanNode.mDistrictID;
        NavRoutePlanModel.getInstance().setStartRouteNode(startNode);
        rpNodeLists.add(startRoutePlanNode);
        if (NavLogUtils.LOGGABLE) {
            NavTipTool.onCreateToastDialog(activity, "速度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSAccuracy);
        }
        if (viaNodes != null && viaNodes.size() > 0) {
            for (int i = 0; i < viaNodes.size(); i++) {
                RouteNode tNode = (RouteNode) viaNodes.get(i);
                if (tNode != null) {
                    rpNodeLists.add(NavModelHelper.convertRouteNode(tNode));
                }
            }
        }
        RoutePlanNode endRoutePlanNode = NavModelHelper.convertRouteNode(endNode);
        endNode.mCityID = endRoutePlanNode.mDistrictID;
        NavRoutePlanModel.getInstance().setEndRouteNode(endNode);
        rpNodeLists.add(endRoutePlanNode);
        this.mRoutePlanObserver = null;
        this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new C08416());
        BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        this.mRoutePlanType = 2;
        int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
        BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
        BNRoutePlaner.getInstance().setCalcPrference(unPreference);
        BNRoutePlaner.getInstance().setEntry(entry);
        boolean hasMrsl = entry == 10 || entry == 16 || entry == 4;
        NavLogUtils.m3003e(CarNaviTrajectoryModel.TAG, "cal-jx 6");
        this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(startNode, endNode, entry);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, -1, hasMrsl, hasMrsl ? NavMapAdapter.getInstance().getCarRoutePlanMrsl() : null, 0);
        CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
        NavLogUtils.m3003e(CarNaviTrajectoryModel.TAG, "is from route plan");
        startNavPageDirectly(startNode, endNode, entry);
    }

    public void calcRouteToNaviRoute(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, int driveRefTimeInterval, int driveRefTimeDuration, int strategy, int routeInfoStatus, String carPANumber, int entry) {
        NavInitController.getInstance().handleAppSource();
        Context activity = BNaviModuleManager.getActivity();
        if (activity != null) {
            int netMode;
            this.mHasDirectyStartRouteGuide = false;
            setRequestShowRouteGuideView(false);
            checkNodeIsValid(startNode, endNode, entry);
            NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
            NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
            NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = -1;
            NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
            ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
            RoutePlanNode startRoutePlanNode = NavModelHelper.convertRouteNode(startNode);
            if (PerformStatItem.sEnableTestData) {
                startRoutePlanNode.setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119d, 40.040642d));
            }
            rpNodeLists.add(startRoutePlanNode);
            if (NavLogUtils.LOGGABLE) {
                NavTipTool.onCreateToastDialog(activity, "速度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode) rpNodeLists.get(0)).mGPSAccuracy);
            }
            if (viaNodes != null && viaNodes.size() > 0) {
                for (int i = 0; i < viaNodes.size(); i++) {
                    RouteNode tNode = (RouteNode) viaNodes.get(i);
                    if (tNode != null) {
                        rpNodeLists.add(NavModelHelper.convertRouteNode(tNode));
                    }
                }
            }
            rpNodeLists.add(NavModelHelper.convertRouteNode(endNode));
            this.mRoutePlanObserver = null;
            this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new C08427());
            DistrictInfo mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
            if (mDistrictInfo == null) {
                mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
            }
            this.mDistrictID = mDistrictInfo.mId;
            if (NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData()) {
                netMode = BNSettingManager.getPrefRoutPlanMode();
            } else {
                netMode = 1;
            }
            SearchPoiPager mSearchPoiPager = new SearchPoiPager(startNode.mName, mDistrictInfo, 10, netMode);
            BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
            String mrsl = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
            BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
            this.mRoutePlanType = 2;
            BNRoutePlaner.getInstance().setCalcPrference(unPreference);
            BNRoutePlaner.getInstance().setDriveRefTimeParams(30, 1440);
            BNRoutePlaner.getInstance().setEntry(entry);
            boolean hasMrsl = entry == 10 || entry == 16 || entry == 4;
            this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(startNode, endNode, entry);
            BNRoutePlaner.getInstance().setPointsToCalcRouteForMap(rpNodeLists, -1, hasMrsl, hasMrsl ? NavMapAdapter.getInstance().getCarRoutePlanMrsl() : null, 0);
            CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
            NavLogUtils.m3003e(CarNaviTrajectoryModel.TAG, "is from route plan");
            startNavPageDirectly(startNode, endNode, entry);
        }
    }

    public Bundle getHomeAndCompanyRouteInfo(RouteNode startNode, RouteNode endNode, int from, int entry) {
        return BNRoutePlaner.getInstance().getHomeAndCompanyRouteInfo(NavModelHelper.convertRouteNode(startNode), NavModelHelper.convertRouteNode(endNode), NavMapAdapter.getInstance().onGetLastPreferValue(), from, entry, NavRoutePlanModel.getInstance().routePlanStatistcsUrl);
    }

    public void calcRouteWithPBData(RouteNode startNode, RouteNode endNode, List<RouteNode> viaNodes, int unPreference, byte[] pbData, int pbDataLen) {
        NavInitController.getInstance().handleAppSource();
        NavLogUtils.m3003e(TAG, "calcRouteWithPBData()");
        NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
        NavLogUtils.m3003e("route_plan_time", "navi_time_diff_map_start=" + (NavCommonFuncModel.getInstance().mNaviStartTime - NavCommonFuncModel.getInstance().mMapStartTime) + "ms");
        this.mHasDirectyStartRouteGuide = false;
        setRequestShowRouteGuideView(false);
        Activity activity = BNaviModuleManager.getActivity();
        if (activity == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData activity is null");
            return;
        }
        ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
        rpNodeLists.add(NavModelHelper.convertRouteNode(startNode));
        if (viaNodes != null && viaNodes.size() > 0) {
            for (int i = 0; i < viaNodes.size(); i++) {
                RouteNode tNode = (RouteNode) viaNodes.get(i);
                if (tNode != null) {
                    rpNodeLists.add(NavModelHelper.convertRouteNode(tNode));
                }
            }
        }
        rpNodeLists.add(NavModelHelper.convertRouteNode(endNode));
        this.mRoutePlanObserver = null;
        this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new C08438());
        BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
        this.mRoutePlanType = 1;
        BNRoutePlaner.getInstance().setCalcPrference(unPreference);
        BNRoutePlaner.getInstance().SetCalcRouteNetMode(3);
        BNRoutePlaner.getInstance().setEntry(8);
        BNRoutePlaner.getInstance().setComeFrom(8);
        NavLogUtils.m3003e(TAG, "NavRoutePlanController.calcRouteWithPBData() ret" + BNRoutePlaner.getInstance().calcRouteWithPB(1, 0, rpNodeLists, unPreference, pbData, pbDataLen));
        CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
        NavLogUtils.m3003e(CarNaviTrajectoryModel.TAG, "is from route plan");
    }

    public boolean setDestNodes(List<RouteNode> viaNodes, RouteNode endNode) {
        NavLogUtils.m3003e(TAG, "setDestsWithPBData() ");
        ArrayList<RoutePlanNode> rpNodeLists = new ArrayList();
        if (viaNodes != null && viaNodes.size() > 0) {
            for (int i = 0; i < viaNodes.size(); i++) {
                RouteNode tNode = (RouteNode) viaNodes.get(i);
                if (tNode != null) {
                    rpNodeLists.add(NavModelHelper.convertRouteNode(tNode));
                }
            }
        }
        rpNodeLists.add(NavModelHelper.convertRouteNode(endNode));
        NavLogUtils.m3003e(TAG, "setDestsWithPBData() ret " + false);
        return false;
    }

    public String getTRURlParam() {
        if (NavLogUtils.LOGGABLE) {
            NavLogUtils.m3003e(TAG, "getTRURlParam() =" + BNRoutePlaner.getInstance().getTRURlParam());
        }
        try {
            return BNRoutePlaner.getInstance().getTRURlParam();
        } catch (Throwable th) {
            return null;
        }
    }

    public void calcRouteWithMapLightPBData(byte[] pbData, int pbDataLen) {
        NavInitController.getInstance().handleAppSource();
        NavLogUtils.m3003e(TAG, "calcRouteWithMapLightPBData() pbDataLen=" + pbDataLen);
        this.mHasDirectyStartRouteGuide = false;
        setRequestShowRouteGuideView(false);
        int pref = NavRoutePlanModel.getInstance().getPreference();
        if (!NavSearchController.getInstance().isFromMap()) {
            pref = BNRoutePlaner.getInstance().getTMPCalcPreference();
        }
        try {
            NavLogUtils.m3003e(TAG, "NavRoutePlanController.calcRouteWithMapLightPBData() ret" + BNRoutePlaner.getInstance().calcRouteWithPB(1, 1, null, pref, pbData, pbDataLen));
        } catch (Throwable th) {
        }
    }

    public void lauchIPONavi() {
        Handler mMapHandler = BaiduNaviManager.getInstance().getMapHandler();
        if (mMapHandler != null) {
            Message outmsg = mMapHandler.obtainMessage(1031);
            if (outmsg != null) {
                outmsg.sendToTarget();
            }
        }
        NavMapAdapter.getInstance().removeRequestByType(NavMapAdapter.getInstance().getResultKeyMCarRoute());
        new Bundle().putString(LightNaviParams.LIGHT_NAVI_FLAG, LightNaviParams.DEFAULT_PACKAGE_NAME);
    }

    private void reCalRouteForDrivingCar() {
        if (this.reCalNum > 0) {
            this.reCalNum--;
            BaiduNaviManager.getInstance().calcRouteToNaviRoute(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavRoutePlanModel.getInstance().getViaNodes(), NavRoutePlanModel.getInstance().getPreference(), NavRoutePlanModel.getInstance().getDriveRefTimeInterval(), NavRoutePlanModel.getInstance().getDriveRefTimeDuration(), NavRoutePlanModel.getInstance().getStrategy(), NavRoutePlanModel.getInstance().getEntry());
            return;
        }
        this.reCalNum = 2;
        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
            BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_RP_IPO_FAIL_NORMAL).sendToTarget();
        }
        NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
    }

    private void initMapSearchListener() {
        this.mMapComponentCallback = new MapComponentCallback() {
            public int onMapComponentCall(int type, int arg1, int arg2, Object data) {
                NavLogUtils.m3003e(NavRoutePlanController.TAG, "MapComponentCallback.onMapComponentCall() type=" + type + ", arg1=" + arg1 + ", arg2=" + arg2);
                int entry = NavRoutePlanModel.getInstance().getEntry();
                NavLogUtils.m3003e(NavRoutePlanController.TAG, "onMapComponentCall() entry=" + entry);
                switch (type) {
                    case 1:
                        if (data != null && (data instanceof String)) {
                            NavRoutePlanController.this.mMapLightSearchTimeout = (long) arg1;
                            NavRoutePlanController.this.mMapLightSearchUrl = (String) data;
                            NavRoutePlanController.this.mRPHandler.sendEmptyMessage(NavRoutePlanController.MSG_Type_Request_Map_Light_Search);
                            return 1;
                        }
                    case 4:
                        if (!NavComponentController.getInstance().invokeCollada()) {
                            NavComponentController.getInstance().loadColladaSo(CloudlConfigDataModel.getInstance().mCommonConfig.colladaComponentDownload);
                        }
                        NavRoutePlanModel.getInstance().mRoutePlanResultOK = true;
                        byte[] pbData;
                        Bundle dataBundle;
                        Message sucMsg;
                        if (NavRoutePlanController.this.mRoutePlanType == 2) {
                            BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                            int gpsState = NavMapAdapter.getInstance().isGpsEnabled() ? NavMapAdapter.getInstance().isGPSLocationValid() ? 1 : 2 : 0;
                            BNRoutePlaner.getInstance().triggerGPSStatus(gpsState);
                            NavRoutePlanModel.getInstance().setmNavEnter(NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                            if (entry == 16) {
                                NavLogUtils.m3003e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_IPO_NO_LOADING");
                                if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                    BaiduNaviManager.getInstance().getMapHandler().obtainMessage(BaiduNaviManager.MSG_NAVI_RP_IPO_SUCCESS_NORMAL).sendToTarget();
                                }
                            } else if (entry == 10) {
                                NavLogUtils.m3003e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_ROUTE_SELECT_ROUTE");
                                if (!BaiduNaviManager.getInstance().isNaviBegin()) {
                                    NavRoutePlanController.this.lauchIPONavi();
                                }
                            } else {
                                if (entry == 7) {
                                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_OPENAPI");
                                    pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
                                    dataBundle = new Bundle();
                                    dataBundle.putByteArray("pb_data", pbData);
                                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                        sucMsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1002);
                                        C0706a.m2986a().f2297r = true;
                                        sucMsg.obj = dataBundle;
                                        sucMsg.sendToTarget();
                                    }
                                }
                                if (PerformStatItem.sUserTest) {
                                    PerformStatItem.sPoiToNaviTime9 = System.currentTimeMillis();
                                    PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("9", PerformStatItem.PoiToNaviStep9, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime8, PerformStatItem.sPoiToNaviTime9);
                                }
                                if (!(BaiduNaviManager.getInstance().isNaviBegin() || NavRoutePlanController.this.mHasDirectyStartRouteGuide)) {
                                    if (NavRouteGuideController.getInstance().getLocateMode() == 1) {
                                        NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.this.createNaviParam(1, true));
                                    } else {
                                        NavRouteGuideController.getInstance().setLocateMode(1);
                                        NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.this.createNaviParam(2, true));
                                    }
                                }
                            }
                            BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                        } else {
                            pbData = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(NavRoutePlanController.this.entryToCarsDataType(entry));
                            if (NavMapAdapter.getInstance().getDebugConfigUserTest() && pbData != null) {
                                PerformStatisticsController.getInstance().addDataLog(2110, 1, PerformStatItem.DATA_ACTION_TAG, "15", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.DATA_SIZE_HANDLE_AFTER_ENGINE_ANALYZE_STEP_NAME, (long) pbData.length);
                            }
                            NavLogUtils.m3003e(NavRoutePlanController.TAG, "NavDrivingCar===rpHandle RP_SUCCESS_NORMAL routePB.lenth=" + (pbData == null ? 0 : pbData.length));
                            if (pbData != null && pbData.length != 0) {
                                RoutePlanModel rpModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
                                if (rpModel == null || rpModel.getEnComfrom() != 21) {
                                    dataBundle = new Bundle();
                                    dataBundle.putByteArray("pb_data", pbData);
                                    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                        sucMsg = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1002);
                                        C0706a.m2986a().f2297r = true;
                                        sucMsg.obj = dataBundle;
                                        sucMsg.sendToTarget();
                                    }
                                    BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN, NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_ROUTE_NAV);
                                } else {
                                    NavRoutePlanController.this.savePreloadRouteJsonResult(pbData);
                                }
                            } else if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                                BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
                            }
                            NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                            NavLogUtils.m3003e("route_plan_time", "success.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                        }
                        if (BaiduNaviManager.getInstance().isNaviBegin()) {
                            NavAoiRender.INSTANCE.renderAoiByStartBid();
                        }
                        if (!(NavRoutePlanController.this.mRoutePlanType == 0 && NavRoutePlanModel.getInstance().getRouteInfoStatus() == 2)) {
                            BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
                        }
                        if (NavRoutePlanController.this.mRoutePlanType == 0 && NavRoutePlanController.this.isMulRoutePlan) {
                            BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
                        }
                        NavRoutePlanController.this.statisticsRoutePlanSuc(NavRoutePlanController.this.mRoutePlanType == 0);
                        return 1;
                    case 32:
                        NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
                        if (!(NavRoutePlanController.this.mRoutePlanType == 2 || BaiduNaviManager.getInstance().getMapHandler() == null)) {
                            BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1001);
                        }
                        if (NavRoutePlanController.this.mMapLightSearchRequestID != -1) {
                            NavRoutePlanController.this.cancelMapLightSearch();
                        }
                        BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
                        break;
                }
                return -1;
            }
        };
        BNRoutePlaner.setMapComponentCallback(this.mMapComponentCallback);
    }

    public Bundle createNaviParam(int locateMode, boolean bShowFullview) {
        Bundle launchParams = new Bundle();
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_VIEW_MODE, 1);
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_CALCROUTE_DONE, 0);
        RouteNode startRouteNode = NavRoutePlanModel.getInstance().getStartRouteNode();
        if (startRouteNode != null) {
            NavGeoPoint sGeoPoint = startRouteNode.mGeoPoint;
            if (sGeoPoint != null) {
                launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_START_X, sGeoPoint.getLongitudeE6());
                launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_START_Y, sGeoPoint.getLatitudeE6());
            }
            try {
                launchParams.putString("start_name", startRouteNode.mName);
            } catch (Exception e) {
            }
        }
        RouteNode endRouteNode = NavRoutePlanModel.getInstance().getEndRouteNode();
        if (endRouteNode != null) {
            NavGeoPoint eGeoPoint = endRouteNode.mGeoPoint;
            if (eGeoPoint != null) {
                launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_END_X, eGeoPoint.getLongitudeE6());
                launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_END_Y, eGeoPoint.getLatitudeE6());
            }
            try {
                launchParams.putString("end_name", endRouteNode.mName);
            } catch (Exception e2) {
            }
        }
        launchParams.putInt(BNavConfig.KEY_ROUTEGUIDE_LOCATE_MODE, locateMode);
        launchParams.putBoolean(BNavConfig.KEY_ROUTEGUIDE_NET_FRESH_ENABLE, true);
        launchParams.putBoolean(BNavConfig.KEY_ROUTEGUIDE_SHOW_FULLVIEW, bShowFullview);
        launchParams.putBoolean(BNavConfig.KEY_ROUTEGUIDE_CAR_RESULT_HAS_SHOW_ANIM, false);
        return launchParams;
    }

    public void continueLastNavi(ArrayList<RoutePlanNode> rpNodeLists) {
        this.mHasDirectyStartRouteGuide = false;
        if (rpNodeLists != null && rpNodeLists.size() >= 2) {
            final RoutePlanNode startRoutePlanNode = (RoutePlanNode) rpNodeLists.get(0);
            final RoutePlanNode endRoutePlanNode = (RoutePlanNode) rpNodeLists.get(rpNodeLists.size() - 1);
            if (startRoutePlanNode != null) {
                startRoutePlanNode.mNodeType = 3;
            }
            if (endRoutePlanNode != null) {
                endRoutePlanNode.mNodeType = 1;
            }
            BNRoutePlaner.getInstance().addRouteResultHandler(new BNMainLooperHandler() {
                public void onMessage(Message msg) {
                    NavLogUtils.m3003e(NavRoutePlanController.TAG, "continueLastNavi calc route msg.what:" + msg.what);
                    switch (msg.what) {
                        case 4:
                            NavLogUtils.m3003e(NavRoutePlanController.TAG, "continueLastNavi calc route success");
                            BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                            NavUserBehaviour.getInstance().sendNaviStatisticsTransfer(startRoutePlanNode, endRoutePlanNode, "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), NavUserBehaviourNaviEnter.BEHAVIOUR_NAVI_ENTER_NAV_NAV);
                            return;
                        case 7:
                            BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                            return;
                        case 32:
                            BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                            return;
                        default:
                            return;
                    }
                }
            });
            Activity activity = NavCommonFuncModel.getInstance().getActivity();
            if (activity != null) {
                this.mRoutePlanObserver = null;
                this.mRoutePlanObserver = new NavRoutePlanObserver(activity, new IJumpToDownloadListener() {
                    public void onJumpToDownloadOfflineData() {
                        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
                    }
                });
                NavRoutePlanModel.getInstance().setEntry(22);
                BNRoutePlaner.getInstance().setEntry(22);
                BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
                int calcPrefer = NavMapAdapter.getInstance().onGetLastPreferValue();
                NavMapAdapter.getInstance().setPreferValue(calcPrefer);
                String calcNum = BNSettingManager.getPlateFromLocal(NavMapAdapter.getInstance().getJNIInitializerContext());
                NavMapAdapter.getInstance().setCalcPrference(calcPrefer);
                if (!TextUtils.isEmpty(calcNum)) {
                    BNRoutePlaner.getInstance().setCalcPrefCarNo(calcNum);
                }
                this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(null, null, 22);
                BNRoutePlaner.getInstance().setComeFrom(22);
                BNRoutePlaner.getInstance().setPointsToCalcRoute(rpNodeLists, 0);
                NavLogUtils.m3003e(TAG, "continueLastNavi calc route ");
                startNavPageDirectly(null, null, 22);
            }
        }
    }

    public void statisticsRoutePlanSuc() {
        statisticsRoutePlanSuc(false);
    }

    public void statisticsRoutePlanSuc(boolean isPBType) {
        UserOPController.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
        RoutePlanStatItem.getInstance().startRoutePlanStat = true;
        NaviStatItem.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
        NaviIPOStatItem.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
        String StrEncoder = "";
        UserOP userOP = new UserOP();
        userOP.op = UserOPParams.ROUTE_2_1;
        if (isPBType) {
            switch (BNRoutePlaner.currentDesNode.mFrom) {
                case 1:
                    String uid = BNRoutePlaner.currentDesNode.getUID();
                    if (!TextUtils.isEmpty(uid)) {
                        try {
                            if (uid.length() >= 2) {
                                uid = uid.substring(uid.length() - 2);
                            }
                            StrEncoder = URLEncoder.encode(uid, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                        }
                        userOP.f19725b = StrEncoder;
                        break;
                    }
                    userOP.f19724a = "";
                    break;
                case 2:
                    if (!TextUtils.isEmpty(BNRoutePlaner.currentDesNode.getName())) {
                        try {
                            StrEncoder = URLEncoder.encode(BNRoutePlaner.currentDesNode.getName(), "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                        }
                        userOP.f19726c = StrEncoder;
                        break;
                    }
                    break;
                default:
                    userOP.f19724a = "";
                    break;
            }
        }
        UserOPController.getInstance().cacheOP(userOP);
    }

    private boolean checkNodeIsValid(RouteNode startNode, RouteNode endNode, int entry) {
        if (startNode == null || endNode == null) {
            return false;
        }
        boolean ret = true;
        NavGeoPoint mStartNavGeoPoint = startNode.mGeoPoint;
        if (mStartNavGeoPoint == null || mStartNavGeoPoint.getLatitudeE6() < 1 || mStartNavGeoPoint.getLongitudeE6() < 1) {
            UserOPController.getInstance().add(UserOPParams.ROUTEPLAN_9_1, "" + entry, null, null);
            ret = false;
        }
        NavGeoPoint mEndNavGeoPoint = endNode.mGeoPoint;
        if (endNode.mFromType == 2) {
            return ret;
        }
        if (mEndNavGeoPoint != null && mEndNavGeoPoint.getLatitudeE6() >= 1 && mEndNavGeoPoint.getLongitudeE6() >= 1) {
            return ret;
        }
        UserOPController.getInstance().add(UserOPParams.ROUTEPLAN_9_2, "" + entry, null, null);
        return false;
    }

    public int getFailTypePermissionDenied() {
        return FailType.PERMISSION_DENIED;
    }

    public void setBNotBuildCarData(boolean flag) {
        BNRoutePlaner.bNotBuildCarData = flag;
    }

    private boolean startNavPageDirectly(RouteNode startNode, RouteNode endNode, int entry) {
        if (entry == 16 || entry == 10) {
            this.mHasDirectyStartRouteGuide = false;
        } else if (entry != 7) {
            boolean isShowFullView;
            if (BNRoutePlaner.getInstance().getComeFrom() != 28) {
                isShowFullView = true;
            } else {
                isShowFullView = false;
            }
            this.mHasDirectyStartRouteGuide = NavRouteGuideController.getInstance().startRouteGuideView(false, createNaviParam(1, isShowFullView));
        } else if (startNode == null || endNode == null || !((startNode.mFromType == 1 || startNode.mFromType == 3) && (endNode.mFromType == 1 || endNode.mFromType == 3))) {
            this.mHasDirectyStartRouteGuide = false;
        } else {
            this.mHasDirectyStartRouteGuide = NavRouteGuideController.getInstance().startRouteGuideView(false, createNaviParam(1, true));
        }
        return this.mHasDirectyStartRouteGuide;
    }

    private boolean isCanStartNavPageDirectly(RouteNode startNode, RouteNode endNode, int entry) {
        if (entry == 16 || entry == 10) {
            return false;
        }
        if (entry != 7) {
            return true;
        }
        if (startNode == null || endNode == null || ((startNode.mFromType != 1 && startNode.mFromType != 3) || (endNode.mFromType != 1 && endNode.mFromType != 3))) {
            return false;
        }
        return true;
    }

    public int entryToCarsDataType(int entry) {
        int type;
        switch (entry) {
            case 30:
            case 32:
                type = 1;
                break;
            default:
                if (getRoutePlanNaviMode() != 2) {
                    type = 0;
                    break;
                }
                type = 1;
                break;
        }
        NavLogUtils.m3003e(TAG, "entryToCarsDataType() entry=" + entry + ", type=" + type);
        return type;
    }

    public int getRoutePlanNaviMode() {
        RoutePlanModel model = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (model != null) {
            return model.getEnNaviType();
        }
        return 0;
    }

    public boolean removeRoute(int type) {
        return BNRouteGuider.getInstance().removeRoute(type);
    }

    private void addWdAddrInRouteNode(RouteNode node) {
        if (!RoutePlanParams.MY_LOCATION.equals(node.mName) && !TextUtils.isEmpty(node.mAddr) && !node.mName.contains(" " + node.mAddr)) {
            node.mName += " " + node.mAddr;
        }
    }

    private void savePreloadRouteJsonResult(byte[] pbData) {
    }

    private void cancelMapLightSearch() {
        NavLogUtils.m3003e(TAG, "cancelMapLightSearch mMapLightSearchRequestID =" + this.mMapLightSearchRequestID);
        if (this.mHandler != null && this.mHandler.hasMessages(MSG_CANCEL_MAP_LIGHT_SEARCH)) {
            this.mHandler.removeMessages(MSG_CANCEL_MAP_LIGHT_SEARCH);
        }
        NavMapAdapter.getInstance().cancleRequest(this.mMapSearchAPIWrapper, this.mMapLightSearchRequestID);
        this.mMapLightSearchRequestID = -1;
    }
}
