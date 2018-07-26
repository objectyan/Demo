package com.baidu.navisdk.comapi.routeplan;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.ConfirmOTArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailArg;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlanObserver.FailType;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams.Key;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.db.OperatorDBCallback.CalcRouteHistoryCallback;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGMainAuxiliaryBridgeController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.RoutePlanTimeUtil;
import com.baidu.navisdk.util.common.Stopwatch;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.NaviIPOStatItem;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.RoutePlanIPOStatItem;
import com.baidu.navisdk.util.statistic.RoutePlanStatItem;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class BNRoutePlaner extends BNLogicController {
    public static final int DRIVE_REF_DEFAULT_TIME_DURATION = 1440;
    public static final int DRIVE_REF_DEFAULT_TIME_INTERVAL = 30;
    private static boolean IS_GUIDE_END = false;
    private static final int K_ROUTEPLAN_TIMEOUT = 50000;
    private static final String TAG = "RoutePlan";
    public static boolean bNotBuildCarData = false;
    public static RoutePlanNode currentDesNode;
    private static volatile BNRoutePlaner mInstance;
    private static MapComponentCallback mMapComponentCallback = null;
    public static int mRouteCnt = 0;
    private static MapComponentCallback mSelectRouteCallback = null;
    public static boolean sIsfetchCarOwnerData = false;
    private static int sRoutePlanMinDistance = 50;
    private int isComeFromParam = 1;
    private Handler mAsynRouteInfoHandler;
    private String mCalcPrefCarNo;
    private int mCalcPreference = 0;
    private int mCalcRequestID = -1;
    private CalcRouteHistoryCallback mCalcRouteHistoryCallback;
    private int mDriveRefTimeDuration = 1440;
    private int mDriveRefTimeInterval = 30;
    public RoutePlanNode mEndNode = null;
    private int mEngineRoutePlanNetMode = this.mRoutePlanNetMode;
    private int mEntry = 3;
    public int mEntryCache = -1;
    private String mExtSrc = null;
    private JNIGuidanceControl mGuidanceControl = null;
    private int mGuideEndType = 0;
    private int mGuideSceneType = 1;
    private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            LogUtil.m15791e("RoutePlan", "wangyang = MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
            ArrayList<Handler> mRPResultHandlersTemp;
            int planResult;
            FailArg failArg;
            Message updateMsg;
            switch (msg.what) {
                case 4099:
                    BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "CancelRoute MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 :" + msg.arg1 + " arg2:" + msg.arg2);
                    if (msg.arg1 == 0) {
                        PerformStatisticsController.peByType(0, "lib_network_server", JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
                    }
                    if (PerformStatItem.sUserTest) {
                        if (msg.arg1 == 0) {
                            PerformStatisticsController.peByType(0, "sdk_routeplan_lib_ok", System.currentTimeMillis());
                            if (PerformStatItem.sBatchTestNetworkAndServerTime) {
                                PerformStatisticsController.getInstance().nextBatchTestNetworkAndServer(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime(), 0, true);
                                return;
                            }
                        }
                        if (msg.arg1 == 0 && msg.arg2 != 2) {
                            PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, "14", PerformStatItem.NAVI_MODULE_NAME, "StartRoutePlanBeginWithMultiNavi", PerformStatItem.sRoutePlanWithMultiNaviStart, System.currentTimeMillis());
                            PerformStatItem.sPoiToNaviTime8 = System.currentTimeMillis();
                            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL, PerformStatItem.PoiToNaviStep8, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime4, PerformStatItem.sPoiToNaviTime8);
                        }
                        PerformStatItem.sGetEngineCalcDataStart = System.currentTimeMillis();
                    }
                    LogUtil.m15791e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    LogUtil.m15791e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- finished");
                    if (BNRoutePlaner.this.mRoutePlanModel != null) {
                        mRPResultHandlersTemp = new ArrayList();
                        synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                            mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                        }
                        RoutePlanTimeUtil.getInstance().resetToCurrentTime();
                        planResult = msg.arg1;
                        int isYawing = msg.arg2;
                        int ret = 0;
                        ArrayList<Bundle> routePlanSubResult = new ArrayList();
                        Bundle data = new Bundle();
                        int subResult = BNRoutePlaner.this.getRoutePlanSubResult(routePlanSubResult, data);
                        RoutePlanStatItem.getInstance().enntCostTime = Long.valueOf(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
                        if (planResult == 0) {
                            int unRoutePlanID = -1;
                            if (data.containsKey("unRoutePlanID")) {
                                unRoutePlanID = data.getInt("unRoutePlanID");
                            }
                            if (unRoutePlanID == BNRoutePlaner.this.mCalcRequestID || unRoutePlanID == 0 || isYawing == 2) {
                                if (data.containsKey("enNaviType")) {
                                    BNRoutePlaner.this.mRoutePlanModel.setEnNaviType(data.getInt("enNaviType"));
                                } else {
                                    BNRoutePlaner.this.mRoutePlanModel.setEnNaviType(0);
                                }
                                if (data.containsKey("enPlanNetMode")) {
                                    BNRoutePlaner.this.mRoutePlanModel.setRoutePlanNetMode(data.getInt("enPlanNetMode"));
                                }
                                if (data.containsKey("enComfrom")) {
                                    BNRoutePlaner.this.mRoutePlanModel.setEnComfrom(data.getInt("enComfrom"));
                                }
                                BNRoutePlaner.this.statisPreCalcRoute(data);
                                LogUtil.m15791e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT planResult: " + planResult + " isYawing: " + isYawing + " subResult: " + subResult + "  unRoutePlanID: " + unRoutePlanID + "  mCalcRequestID: " + BNRoutePlaner.this.mCalcRequestID + " mRoutePlanModel.getEnComfrom(): " + BNRoutePlaner.this.mRoutePlanModel.getEnComfrom());
                                PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt(RoutePlanParams.CALC_PREFERENCE, BNRoutePlaner.this.mCalcPreference);
                                BNRoutePlaner.this.mRoutePlanSuccessTime = System.currentTimeMillis();
                                ArrayList<RoutePlanNode> routePlanNodeList = BNRoutePlaner.this.mRoutePlanModel.getRouteInput();
                                int fromType = 1;
                                if (!(isYawing == 2 || routePlanNodeList == null || routePlanNodeList.size() <= 0)) {
                                    if (routePlanNodeList.get(routePlanNodeList.size() - 1) != null) {
                                        fromType = ((RoutePlanNode) routePlanNodeList.get(routePlanNodeList.size() - 1)).mFrom;
                                    }
                                }
                                if (routePlanSubResult != null && routePlanNodeList.size() == routePlanSubResult.size()) {
                                    for (int i = routePlanSubResult.size() - 1; i >= 0; i--) {
                                        if (i != 0 || !((RoutePlanNode) routePlanNodeList.get(0)).isNodeSettedData()) {
                                            double x = ((Bundle) routePlanSubResult.get(i)).getDouble("x", -2.147483648E9d);
                                            double y = ((Bundle) routePlanSubResult.get(i)).getDouble("y", -2.147483648E9d);
                                            LogUtil.m15791e("RoutePlan", "GetRoutePlanSubResult routePlanSubResult x; " + x + " y: " + y);
                                            ((RoutePlanNode) routePlanNodeList.get(i)).setGeoPoint(new GeoPoint((int) (100000.0d * x), (int) (100000.0d * y)));
                                            ((RoutePlanNode) routePlanNodeList.get(i)).setFrom(1);
                                        }
                                    }
                                }
                                if (routePlanSubResult != null && routePlanSubResult.size() > 0 && ((Bundle) routePlanSubResult.get(0)).containsKey("routeCnt")) {
                                    BNRoutePlaner.mRouteCnt = ((Bundle) routePlanSubResult.get(0)).getInt("routeCnt");
                                }
                                BNRoutePlaner.this.mRoutePlanModel.setRouteInput(routePlanNodeList);
                                if (isYawing != 2) {
                                    if (BNRoutePlaner.currentDesNode == null) {
                                        BNRoutePlaner.currentDesNode = new RoutePlanNode();
                                    }
                                    if (routePlanNodeList != null && routePlanNodeList.size() > 0) {
                                        BNRoutePlaner.currentDesNode.copy((RoutePlanNode) routePlanNodeList.get(routePlanNodeList.size() - 1));
                                        BNRoutePlaner.currentDesNode.mFrom = fromType;
                                    }
                                }
                                Bundle bundle = new Bundle();
                                ret = BNRoutePlaner.getInstance().getRouteInfo(0, bundle);
                                if (ret == 0) {
                                    LogUtil.m15791e("RoutePlan", "in navi step route info: error");
                                    RoutePlanStatItem.getInstance().setErrorCode(FailType.ROUTE_PLAN_PARSE_GET_ROUTEINFO_ERROR);
                                } else if (ret == 1) {
                                    LogUtil.m15791e("RoutePlan", "in navi step route info: part");
                                    int routeCnt = BNRoutePlaner.this.getRouteCnt();
                                    ArrayList<Bundle> routeResultBundle = new ArrayList();
                                    for (int index = 0; index < routeCnt; index++) {
                                        Bundle outlineBundle = new Bundle();
                                        BNRoutePlaner.this.getRouteInfo(index, outlineBundle);
                                        routeResultBundle.add(outlineBundle);
                                    }
                                    BNRoutePlaner.this.mRoutePlanModel.parseRouteResultOutline(routeResultBundle);
                                } else if (ret == 2) {
                                    LogUtil.m15791e("RoutePlan", "in navi step route info: all");
                                    BNRoutePlaner.this.mRoutePlanModel.parseRouteResult(BNaviModuleManager.getContext(), bundle);
                                }
                                if (!RoutePlanStatItem.getInstance().hasOnEven()) {
                                    RoutePlanStatItem.getInstance().setEngRoutePlanEndTime(Long.valueOf(System.currentTimeMillis()));
                                    if (RoutePlanStatItem.getInstance().getEntry() == 5) {
                                        RoutePlanStatItem.getInstance().onEvent();
                                    }
                                }
                                if (subResult == 1) {
                                    RoutePlanStatItem.getInstance().setCalcType("3");
                                    BNRoutePlaner.this.setEngineCalcRouteNetMode(2);
                                    LogUtil.m15791e("RoutePlan", "statics onevent online to offline");
                                    sendMessage(mRPResultHandlersTemp, 1);
                                    FailArg successArg = new FailArg();
                                    successArg.mFailText = JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_toast_online_to_offline);
                                    BNRoutePlaner.this.notifyObservers(1, 21, successArg);
                                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                                    LogUtil.m15791e(ModuleName.XDVoice, "online to offline , XDPlan setEnable(true)");
                                } else if (subResult == 2) {
                                    sendMessage(mRPResultHandlersTemp, 2);
                                    BNRoutePlaner.this.setEngineCalcRouteNetMode(3);
                                    RGSimpleGuideModel.mIsOfflineToOnline = false;
                                    RGViewController.getInstance().requestShowExpendView(10, false);
                                    LogUtil.m15791e("RoutePlan", "statics onevent offline to online");
                                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ONLINE_ROUTE_PLAN, NaviStatConstants.ONLINE_ROUTE_PLAN);
                                    RoutePlanStatItem.getInstance().setCalcType("4");
                                    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
                                    LogUtil.m15791e(ModuleName.XDVoice, "offline to online , XDPlan setEnable(true)");
                                } else if (subResult == 0) {
                                    String calcType = RoutePlanStatItem.getInstance().getCalcType();
                                    if (!calcType.equals("4")) {
                                        if (!calcType.equals("3")) {
                                            if (BNRoutePlaner.this.mRoutePlanNetMode == 1 || BNRoutePlaner.this.mRoutePlanNetMode == 3) {
                                                RoutePlanStatItem.getInstance().setCalcType("1");
                                            } else {
                                                RoutePlanStatItem.getInstance().setCalcType("2");
                                            }
                                        }
                                    }
                                }
                                LogUtil.m15791e("RoutePlan", "mRPResultHandlersTemp" + isYawing);
                                Iterator it = mRPResultHandlersTemp.iterator();
                                while (it.hasNext()) {
                                    LogUtil.m15791e("RoutePlan", "mRPResultHandlersTemp" + ((Handler) it.next()).toString() + isYawing);
                                }
                                if (isYawing == 2) {
                                    sendMessage(mRPResultHandlersTemp, 3);
                                    BNRoutePlaner.this.notifyNavEventToOut(3);
                                    BNRoutePlaner.this.notifyObservers(1, 4, null);
                                } else {
                                    if (PerformStatItem.sUserTest) {
                                        PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, "16", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.GET_ENGINE_CALC_DATA_STEP_NAME, PerformStatItem.sGetEngineCalcDataStart, System.currentTimeMillis());
                                        PerformStatItem.sRoutePlanSuccessNormalStart = System.currentTimeMillis();
                                        PerformStatItem.sRoutePlanSuccessNormalFirstStart = System.currentTimeMillis();
                                    }
                                    if (BNavigator.getInstance().isNaviBegin()) {
                                        sendMessage(mRPResultHandlersTemp, 4);
                                        BNRoutePlaner.this.requestMapHandleRPSucess();
                                    } else {
                                        BNRoutePlaner.this.requestMapHandleRPSucess();
                                        sendMessage(mRPResultHandlersTemp, 4);
                                    }
                                    BNRoutePlaner.this.notifyNavEventToOut(4);
                                    BNRoutePlaner.this.notifyObservers(1, 2, null);
                                }
                                if (BNRoutePlaner.this.getEngineCalcRouteNetMode() == 1 || BNRoutePlaner.this.getEngineCalcRouteNetMode() == 3) {
                                    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ONLINE_ROUTE_PLAN_SUCCESS, NaviStatConstants.ONLINE_ROUTE_PLAN_SUCCESS);
                                    LogUtil.m15791e("RoutePlan", "statics onevent online route plan success");
                                    if ((BNRoutePlaner.this.getCalcPreference() & 64) > 0) {
                                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.OIL_CONSUME_ROUTE_PLAN, NaviStatConstants.OIL_CONSUME_ROUTE_PLAN);
                                    }
                                }
                                if (BNRoutePlaner.getInstance().getEntry() == 2) {
                                    RoutePlanStatItem.getInstance().mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
                                    LogUtil.m15791e("RoutePlan", "stat test map routecount = " + RoutePlanStatItem.getInstance().mRouteCount);
                                    if (!RoutePlanStatItem.getInstance().hasOnEven()) {
                                        RoutePlanStatItem.getInstance().setStatAll(false);
                                        RoutePlanStatItem.getInstance().onEvent();
                                    }
                                }
                            } else {
                                LogUtil.m15791e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT return unRoutePlanID " + unRoutePlanID + " mCalcRequestID " + BNRoutePlaner.this.mCalcRequestID);
                                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "unRoutePlanID " + unRoutePlanID + " mCalcRequestID " + BNRoutePlaner.this.mCalcRequestID);
                                return;
                            }
                        } else if (planResult == 20) {
                            if (isYawing == 3) {
                                LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = SLAVE_ROUTE_PLAN_RESULT");
                                RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(2);
                                if (BNNaviResultModel.getInstance().isSwitch == 0 || BNNaviResultModel.getInstance().isSwitch == 1) {
                                    BNNaviResultModel.getInstance().isSwitch = 1;
                                } else {
                                    BNNaviResultModel.getInstance().isSwitch = 3;
                                }
                            } else if (isYawing == 4) {
                                LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = MAIN_ROUTE_PLAN_RESULT");
                                RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(1);
                                if (BNNaviResultModel.getInstance().isSwitch == 0 || BNNaviResultModel.getInstance().isSwitch == 1) {
                                    BNNaviResultModel.getInstance().isSwitch = 1;
                                } else {
                                    BNNaviResultModel.getInstance().isSwitch = 3;
                                }
                            } else if (isYawing == 5) {
                                LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = VIADUCT_ROUTE_PLAN_RESULT");
                                RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(3);
                                if (BNNaviResultModel.getInstance().isSwitch == 0 || BNNaviResultModel.getInstance().isSwitch == 2) {
                                    BNNaviResultModel.getInstance().isSwitch = 2;
                                } else {
                                    BNNaviResultModel.getInstance().isSwitch = 3;
                                }
                            } else if (isYawing == 6) {
                                LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = GROUND_ROUTE_PLAN_RESULT");
                                RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(4);
                                if (BNNaviResultModel.getInstance().isSwitch == 0 || BNNaviResultModel.getInstance().isSwitch == 2) {
                                    BNNaviResultModel.getInstance().isSwitch = 2;
                                } else {
                                    BNNaviResultModel.getInstance().isSwitch = 3;
                                }
                            } else if (isYawing == 7) {
                                LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = UNKNOWN_ROUTE_PLAN_RESULT");
                            }
                        } else if (planResult == 21) {
                            LogUtil.m15791e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT FAIL_MAIN_SLAVE_VIADUCT_INFO");
                            RGMainAuxiliaryBridgeController.getInstance().onRoutePlanFail();
                        } else if (9 == planResult) {
                            sendMessage(mRPResultHandlersTemp, 5);
                            arg = new FailArg();
                            arg.mFailType = planResult;
                            BNRoutePlaner.this.notifyObservers(1, 22, arg);
                        } else if (503 == planResult) {
                            arg = new FailArg();
                            arg.mFailType = planResult;
                            BNRoutePlaner.this.notifyObservers(1, 23, arg);
                        } else {
                            PerformStatisticsController.peByType(0, "lib_network_server", JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
                            if (PerformStatItem.sUserTest) {
                                PerformStatisticsController.peByType(0, "sdk_routeplan_lib_failed", System.currentTimeMillis());
                                if (PerformStatItem.sBatchTestNetworkAndServerTime) {
                                    PerformStatisticsController.getInstance().nextBatchTestNetworkAndServer(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime(), 0, false);
                                    return;
                                }
                            }
                            if (!(108 != planResult || BNRoutePlaner.this.mRoutePlanModel == null || NetworkUtils.mConnectState == 0 || isYawing == 2)) {
                                BNRoutePlaner.this.showRouteplanOvertimeDialog();
                            }
                            failArg = new FailArg();
                            failArg.mFailType = planResult;
                            failArg.mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(planResult);
                            BNRoutePlaner.this.notifyObservers(1, 7, failArg);
                            if (BNRoutePlaner.this.mRoutePlanNetMode == 1 || BNRoutePlaner.this.mRoutePlanNetMode == 3) {
                                RoutePlanStatItem.getInstance().setCalcType("1");
                            } else {
                                RoutePlanStatItem.getInstance().setCalcType("2");
                            }
                            if (planResult == -1) {
                                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.TEST_FOR_ROUTE_PLAN_ERROR, NaviStatConstants.TEST_FOR_ROUTE_PLAN_ERROR);
                            }
                            RoutePlanStatItem.getInstance().setErrorCode(planResult);
                            BNRoutePlaner.this.mRoutePlanModel.clearRouteResult();
                            if (isYawing == 2) {
                                sendMessage(mRPResultHandlersTemp, 6);
                                BNRoutePlaner.this.notifyNavEventToOut(6);
                                FailArg yawingFailArg = new FailArg();
                                yawingFailArg.mFailText = JarUtils.getResources().getString(C4048R.string.nsdk_string_rp_toast_fail_calc_fail);
                                BNRoutePlaner.this.notifyObservers(1, 5, yawingFailArg);
                            } else {
                                sendMessage(mRPResultHandlersTemp, 7);
                                BNRoutePlaner.this.notifyNavEventToOut(7);
                                BNRoutePlaner.this.notifyObservers(1, 3, null);
                            }
                        }
                        if (BNRoutePlaner.this.mRoutePlanSource == 0) {
                            BNRoutePlaner.this.mIsCalculatingRoute = false;
                            if (!(BNRoutePlaner.this.mCalcRouteHistoryCallback == null || BNRoutePlaner.this.mRoutePlanModel == null)) {
                                BNRoutePlaner.this.mCalcRouteHistoryCallback.onAddViaRoute(BNRoutePlaner.this.mRoutePlanModel.getRouteInput());
                            }
                        }
                        if (BNSettingManager.isShowJavaLog()) {
                            SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what + " subResult= " + subResult + " ret= " + ret + " getEngineCalcRouteNetMode= " + BNRoutePlaner.this.getEngineCalcRouteNetMode() + " getIsFromMap= " + BNRoutePlaner.getInstance().getIsFromMap() + " getEntry= " + BNRoutePlaner.getInstance().getEntry());
                            return;
                        }
                        return;
                    }
                    return;
                case 4115:
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessageWithArg(mRPResultHandlersTemp, 39, msg.arg1);
                    if (BNSettingManager.isShowJavaLog() && 3 == msg.arg1) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_Success_BuildGuideRoute /*4170*/:
                    if (BNRoutePlaner.this.mAsynRouteInfoHandler != null) {
                        updateMsg = BNRoutePlaner.this.mAsynRouteInfoHandler.obtainMessage();
                        updateMsg.what = MsgDefine.MSG_NAVI_Success_BuildGuideRoute;
                        BNRoutePlaner.this.mAsynRouteInfoHandler.dispatchMessage(updateMsg);
                    }
                    if (BNRoutePlaner.mSelectRouteCallback != null) {
                        BNRoutePlaner.mSelectRouteCallback.onMapComponentCall(MsgDefine.MSG_NAVI_Success_BuildGuideRoute, 0, 0, null);
                        BNRoutePlaner.mSelectRouteCallback = null;
                    }
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessage(mRPResultHandlersTemp, 33);
                    BNRoutePlaner.this.notifyNavEventToOut(33);
                    BNRoutePlaner.this.notifyObservers(1, 2, null);
                    LogUtil.m15791e("RoutePlan", "MSG_NAVI_Success_BuildGuideRoute msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    BNRoutePlaner.this.mIsCalculatingRoute = false;
                    if (BNRoutePlaner.this.getEngineCalcRouteNetMode() == 2 || BNRoutePlaner.this.mRoutePlanNetMode == 0) {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ONLINE_ROUTE_PLAN_SUCCESS, NaviStatConstants.ONLINE_ROUTE_PLAN_SUCCESS);
                        if ((BNRoutePlaner.this.getCalcPreference() & 64) > 0) {
                            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.OIL_CONSUME_ROUTE_PLAN, NaviStatConstants.OIL_CONSUME_ROUTE_PLAN);
                        }
                    }
                    if (BNSettingManager.isShowJavaLog()) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_Fail_BuildGuideRoute /*4173*/:
                    if (BNRoutePlaner.this.mAsynRouteInfoHandler != null) {
                        updateMsg = BNRoutePlaner.this.mAsynRouteInfoHandler.obtainMessage();
                        updateMsg.what = MsgDefine.MSG_NAVI_Fail_BuildGuideRoute;
                        BNRoutePlaner.this.mAsynRouteInfoHandler.dispatchMessage(updateMsg);
                    }
                    if (BNRoutePlaner.mSelectRouteCallback != null) {
                        BNRoutePlaner.mSelectRouteCallback.onMapComponentCall(MsgDefine.MSG_NAVI_Success_BuildGuideRoute, 0, 0, null);
                        BNRoutePlaner.mSelectRouteCallback = null;
                    }
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessage(mRPResultHandlersTemp, 34);
                    BNRoutePlaner.this.notifyNavEventToOut(34);
                    BNRoutePlaner.this.notifyObservers(1, 3, null);
                    LogUtil.m15791e("RoutePlan", "MSG_NAVI_Fail_BuildGuideRoute msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    BNRoutePlaner.this.mIsCalculatingRoute = false;
                    RoutePlanStatItem.getInstance().setErrorCode(501);
                    if (BNSettingManager.isShowJavaLog()) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_UpdateRoadCondition /*4174*/:
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessage(mRPResultHandlersTemp, 5);
                    BNRoutePlaner.this.notifyObservers(1, 22, new FailArg());
                    return;
                case MsgDefine.MSG_NAVI_KeyWordResult /*4175*/:
                    LogUtil.m15791e("RoutePlan", "MSG_NAVI_KeyWordResult msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "CancelRoute MSG_NAVI_KeyWordResult arg1 :" + msg.arg1 + " arg2 :" + msg.arg2);
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    if (msg.arg1 == 0 || msg.arg1 == 2) {
                        BNRoutePlaner.this.mRoutePlanStopwatch.stop();
                        SearchStatItem.getInstance().setResponseTime((long) ((int) BNRoutePlaner.this.mRoutePlanStopwatch.ElapsedTicks()));
                        if (BNRoutePlaner.this.mRoutePlanNetMode == 3 || BNRoutePlaner.this.mRoutePlanNetMode == 1) {
                            SearchStatItem.getInstance().setSearchType("1");
                        } else {
                            SearchStatItem.getInstance().setSearchType("2");
                        }
                        SearchStatItem.getInstance().setSearchResult(true);
                        SearchStatItem.getInstance().onEvent();
                        sendMessage(mRPResultHandlersTemp, 35);
                        BNRoutePlaner.this.notifyObservers(1, 2, null);
                    }
                    if (BNSettingManager.isShowJavaLog()) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_TYPE_IPO_ROUTE_PLAN_RESULT /*4209*/:
                    LogUtil.m15791e("wy", "MSG_NAVI_TYPE_IPO_ROUTE_PLAN_RESULT msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "CancelRoute IPO_ROUTE_PLAN_RESULT arg1 :" + msg.arg1 + " arg2 :" + msg.arg2);
                    BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
                    BNaviModuleManager.removeIPO();
                    planResult = msg.arg1;
                    if (planResult != 0) {
                        sendMessage(BNRoutePlaner.this.mRPResultHandlers, 38);
                        BNRoutePlaner.this.notifyNavEventToOut(38);
                        failArg = new FailArg();
                        failArg.mFailType = msg.arg1;
                        failArg.mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(failArg.mFailType);
                        BNRoutePlaner.this.notifyObservers(1, 7, failArg);
                        RoutePlanIPOStatItem.getInstance().setErrorCode(planResult);
                        return;
                    } else if (!BNLightNaviManager.getInstance().isNaving()) {
                        sendMessage(BNRoutePlaner.this.mRPResultHandlers, 37);
                        BNRoutePlaner.this.notifyNavEventToOut(37);
                        BNRoutePlaner.this.notifyObservers(1, 2, null);
                        RoutePlanIPOStatItem.getInstance().onEvent();
                        return;
                    } else {
                        return;
                    }
                case MsgDefine.MSG_NAVI_Start_BuildGuideRoute /*4400*/:
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessage(mRPResultHandlersTemp, 48);
                    LogUtil.m15791e("RoutePlan", "BuildGuideRoute msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    return;
                case MsgDefine.MSG_NAVI_Fail_BuildGuideRoute_Auto /*4403*/:
                    mRPResultHandlersTemp = new ArrayList();
                    synchronized (BNRoutePlaner.this.mRPResultHandlers) {
                        mRPResultHandlersTemp.addAll(BNRoutePlaner.this.mRPResultHandlers);
                    }
                    sendMessage(mRPResultHandlersTemp, 49);
                    LogUtil.m15791e("RoutePlan", "BuildGuideRoute msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2);
                    if (BNSettingManager.isShowJavaLog()) {
                        SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" msg.arg1 = " + msg.arg1 + " ||| msg.arg2 = " + msg.arg2 + " msg.what=" + msg.what);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private void sendMessage(ArrayList<Handler> handlers, int rpMsg) {
            Iterator it = handlers.iterator();
            while (it.hasNext()) {
                Handler handler = (Handler) it.next();
                if (handler != null) {
                    Message RPMsg = handler.obtainMessage();
                    RPMsg.what = rpMsg;
                    RPMsg.sendToTarget();
                }
            }
        }

        private void sendMessageWithArg(ArrayList<Handler> handlers, int rpMsg, int arg1) {
            Iterator it = handlers.iterator();
            while (it.hasNext()) {
                Handler handler = (Handler) it.next();
                if (handler != null) {
                    Message RPMsg = handler.obtainMessage();
                    RPMsg.what = rpMsg;
                    RPMsg.arg1 = arg1;
                    RPMsg.sendToTarget();
                }
            }
        }

        public void careAbout() {
            observe(4099);
            observe((int) MsgDefine.MSG_NAVI_Start_BuildGuideRoute);
            observe((int) MsgDefine.MSG_NAVI_Success_BuildGuideRoute);
            observe((int) MsgDefine.MSG_NAVI_Fail_BuildGuideRoute);
            observe((int) MsgDefine.MSG_NAVI_Fail_BuildGuideRoute_Auto);
            observe((int) MsgDefine.MSG_NAVI_UpdateRoadCondition);
            observe((int) MsgDefine.MSG_NAVI_KeyWordResult);
            observe((int) MsgDefine.MSG_NAVI_TYPE_IPO_ROUTE_PLAN_RESULT);
            observe(4115);
        }
    };
    private boolean mIsCalculatingRoute = false;
    private Handler mNetChangeHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what != NetworkListener.MSG_TYPE_NET_WORK_CHANGE) {
                return;
            }
            if (1 == msg.arg2) {
                BNRoutePlaner.this.triggerNetStatusChange(3);
            } else {
                BNRoutePlaner.this.triggerNetStatusChange(1);
            }
        }
    };
    private ArrayList<Handler> mRPResultHandlers = new ArrayList();
    private RoutePlanModel mRoutePlanModel = null;
    private int mRoutePlanNetMode = 3;
    private int mRoutePlanSource = -1;
    private Stopwatch mRoutePlanStopwatch = new Stopwatch();
    public long mRoutePlanSuccessTime = 0;
    private String mStrLackDataCities = "";

    public interface MapComponentCallback {
        public static final int Type_Request_Map_Light_Service = 1;

        int onMapComponentCall(int i, int i2, int i3, Object obj);
    }

    public void setComeFrom(int isComeFrom) {
        this.isComeFromParam = isComeFrom;
    }

    public String getExtSrc() {
        return this.mExtSrc;
    }

    public void setExtSrc(String extSrc) {
        this.mExtSrc = extSrc;
    }

    public int getComeFrom() {
        return this.isComeFromParam;
    }

    public boolean getIsFromMap() {
        return this.isComeFromParam == 1;
    }

    public void setEntry(int entry) {
        this.mEntry = entry;
    }

    public int getEntry() {
        return this.mEntry;
    }

    public boolean isGuideEnd() {
        return IS_GUIDE_END;
    }

    public void setIsGuideEnd(boolean flag) {
        IS_GUIDE_END = flag;
    }

    public int getGuideSceneType() {
        return this.mGuideSceneType;
    }

    public void setGuideSceneType(int type) {
        this.mGuideSceneType = type;
    }

    public int getGuideEndType() {
        return this.mGuideEndType;
    }

    public void setGuideEndType(int type) {
        this.mGuideEndType = type;
    }

    public int getRoutePlanSource() {
        return this.mRoutePlanSource;
    }

    public RoutePlanNode getRouteEndNode() {
        if (this.mEndNode != null) {
            return this.mEndNode;
        }
        return BNSettingManager.getEndNode();
    }

    public void getRouteResultOutline() {
        int routeCnt = getRouteCnt();
        ArrayList<Bundle> routeResultBundle = new ArrayList();
        for (int index = 0; index < routeCnt; index++) {
            Bundle outlineBundle = new Bundle();
            getRouteInfo(index, outlineBundle);
            routeResultBundle.add(outlineBundle);
        }
        this.mRoutePlanModel.parseRouteResultOutline(routeResultBundle);
    }

    private BNRoutePlaner() {
        if (this.mGuidanceControl == null) {
            try {
                this.mGuidanceControl = JNIGuidanceControl.getInstance();
                updateFuncConfigParams();
            } catch (Exception e) {
                LogUtil.m15791e("RoutePlan", e.toString());
            }
        }
        getCalcPreference();
        VMsgDispatcher.registerMsgHandler(this.mHandler);
    }

    public void updateFuncConfigParams() {
        boolean isMultiRouteEnable = RGMultiRouteModel.getInstance().isEnable();
        try {
            this.mGuidanceControl.setFuncConfigParams(!isMultiRouteEnable, RGMultiRouteModel.getInstance().getPstLabelDis(), RGMultiRouteModel.getInstance().getLastMile());
        } catch (Throwable th) {
        }
    }

    public static BNRoutePlaner getInstance() {
        if (mInstance == null) {
            synchronized (BNRoutePlaner.class) {
                if (mInstance == null) {
                    mInstance = new BNRoutePlaner();
                }
            }
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (BNRoutePlaner.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
    }

    public void init(Context context) {
        this.mRoutePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        getCalcPreference();
        getCalcPrefCarNo();
        if (NetworkUtils.getConnectStatus()) {
            triggerNetStatusChange(3);
        } else {
            triggerNetStatusChange(1);
        }
        registerNetworkListener();
    }

    private void dispose() {
        LogUtil.m15791e("RoutePlan", "dispose");
        VMsgDispatcher.unregisterMsgHandler(this.mHandler);
        NaviDataEngine.getInstance().removeModel(ModelName.ROUTE_PLAN);
        this.mGuidanceControl = null;
        this.mRoutePlanModel = null;
        unregisterNetworkListener();
    }

    public void setRouteInfoHandler(Handler handler) {
        LogUtil.m15791e("dengtianjian", "setRouteInfoHandler");
        this.mAsynRouteInfoHandler = handler;
    }

    public void clearRouteInfoHandler() {
        LogUtil.m15791e("dengtianjian", "clearRouteInfoHandler");
        this.mAsynRouteInfoHandler = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addRouteResultHandler(android.os.Handler r4, boolean r5) {
        /*
        r3 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = r3.mRPResultHandlers;
        monitor-enter(r1);
        r0 = r3.mRPResultHandlers;	 Catch:{ all -> 0x0010 }
        r0 = r0.contains(r4);	 Catch:{ all -> 0x0010 }
        if (r0 == 0) goto L_0x0013;
    L_0x000e:
        monitor-exit(r1);	 Catch:{ all -> 0x0010 }
        goto L_0x0002;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        if (r5 == 0) goto L_0x001d;
    L_0x0015:
        r0 = r3.mRPResultHandlers;	 Catch:{ all -> 0x0010 }
        r2 = 0;
        r0.add(r2, r4);	 Catch:{ all -> 0x0010 }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0010 }
        goto L_0x0002;
    L_0x001d:
        r0 = r3.mRPResultHandlers;	 Catch:{ all -> 0x0010 }
        r0.add(r4);	 Catch:{ all -> 0x0010 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.addRouteResultHandler(android.os.Handler, boolean):void");
    }

    public void addRouteResultHandler(Handler handler) {
        addRouteResultHandler(handler, false);
    }

    public void removeRouteResultHandler(Handler handler) {
        if (handler != null) {
            synchronized (this.mRPResultHandlers) {
                if (this.mRPResultHandlers.contains(handler)) {
                    this.mRPResultHandlers.remove(handler);
                    return;
                }
            }
        }
    }

    private void sendMessage(int msg) {
        ArrayList<Handler> rpHanlderList = new ArrayList();
        rpHanlderList.addAll(this.mRPResultHandlers);
        Iterator it = rpHanlderList.iterator();
        while (it.hasNext()) {
            Handler handler = (Handler) it.next();
            if (handler != null) {
                Message RPMsg = handler.obtainMessage();
                RPMsg.what = msg;
                RPMsg.sendToTarget();
            }
        }
    }

    private void notifyNavEventToOut(int eventId) {
        if (8 == eventId) {
            BNEventManager.getInstance().onOtherAction(7, 0, 0, null);
        } else if (eventId == 1 || eventId == 2 || eventId == 3 || eventId == 4 || eventId == 33 || eventId == 39 || eventId == 37) {
            BNEventManager.getInstance().onOtherAction(9, 0, 0, null);
        } else if (eventId == 34 || eventId == 7 || eventId == 36 || eventId == 6 || eventId == 38 || 32 == eventId) {
            BNEventManager.getInstance().onOtherAction(10, 0, 0, null);
        }
    }

    private int calcRoute(int unPreference, int usReqRouteCnt, RoutePlanTime naviCalcTime, boolean hasMrsl, String mrsl, int enRPSource) {
        if (this.mGuidanceControl == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRoute mGuidanceControl is null");
            return -1;
        }
        LogUtil.m15791e("RoutePlan", "calcRoute() hasMrsl=" + hasMrsl + " usReqRouteCnt=" + usReqRouteCnt + ", mrsl=" + mrsl + ", time=" + SystemClock.elapsedRealtime());
        this.mIsCalculatingRoute = true;
        this.mRoutePlanSource = enRPSource;
        if (BNavigator.getInstance().isNaviBegin()) {
            boolean gpsEnabled = BNSysLocationManager.getInstance().isGpsEnabled();
            boolean locValid = BNSysLocationManager.getInstance().isSysLocationValid();
            LogUtil.m15791e("RoutePlan", "calcRoute (1087): --> gpsEnabled: " + gpsEnabled + ", locValid: " + locValid);
            int gpsStatus = gpsEnabled ? locValid ? 1 : 2 : 0;
            triggerGPSStatus(gpsStatus);
            BNRouteGuider.getInstance().setGuideEndType(this.mGuideEndType);
            setGuideEndType(0);
        }
        if (NetworkUtils.getConnectStatus()) {
            triggerNetStatusChange(3);
        } else {
            triggerNetStatusChange(1);
        }
        LogUtil.m15791e("RoutePlan", "calcRoute. mCalcPrefCarNo = " + this.mCalcPrefCarNo);
        if (this.mCalcPrefCarNo != null && this.mCalcPrefCarNo.length() > 0) {
            String carPA = "";
            String carNum = "";
            carPA = this.mCalcPrefCarNo.substring(0, 1);
            carNum = this.mCalcPrefCarNo.substring(1, this.mCalcPrefCarNo.length());
            LogUtil.m15791e("RoutePlan", "calcRoute. mCalcPrefCarNo = " + this.mCalcPrefCarNo + " || carPA = " + carPA + " || carNum = " + carNum);
            this.mGuidanceControl.SetLocalRouteCarInfo(carPA, carNum, 0);
        }
        LogUtil.m15791e("RoutePlan", "calcRoute isComFromParam -->> " + this.isComeFromParam);
        LogUtil.m15791e("RoutePlan", "calcRoute unPreference -->> " + unPreference);
        if (!RoutePlanStatItem.getInstance().hasOnEven()) {
            RoutePlanStatItem.getInstance().onEvent();
        }
        RoutePlanStatItem.getInstance().setEngRoutePlanStartTime(Long.valueOf(System.currentTimeMillis()));
        if (sIsfetchCarOwnerData) {
            sIsfetchCarOwnerData = false;
        }
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, "3", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.CALC_ROUTE_PREPARE_STEP_NAME, PerformStatItem.sCalcRoutePrepareStart, System.currentTimeMillis());
            PerformStatItem.sRoutePlanBeginWithRouteNodeStart = System.currentTimeMillis();
            PerformStatItem.sPoiToNaviTime4 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("4", PerformStatItem.PoiToNaviStep4, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime3, PerformStatItem.sPoiToNaviTime4);
        }
        PerformStatisticsController.peByType(0, "sdk_start_lib_routeplan", System.currentTimeMillis());
        BNEyeSpyPaperController.getInstance().startRoutePlanMonitor();
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "start CalcRoute");
        int ret = this.mGuidanceControl.CalcRoute(unPreference, usReqRouteCnt, naviCalcTime, this.mDriveRefTimeInterval, this.mDriveRefTimeDuration, hasMrsl, mrsl, enRPSource, this.isComeFromParam, bNotBuildCarData, this.mExtSrc);
        RoutePlanStatItem.getInstance().rouEntry = this.isComeFromParam;
        if (bNotBuildCarData) {
            bNotBuildCarData = false;
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "CalcRoute id:" + ret);
        return ret;
    }

    public void SetCalcRouteNetMode(int netmode) {
        this.mRoutePlanNetMode = netmode;
        setEngineCalcRouteNetMode(this.mRoutePlanNetMode);
        SetRouteSpec(false);
        if (netmode == 1 || netmode == 3) {
            this.mGuidanceControl.SetCalcRouteNetMode(netmode);
        } else if (netmode == 2 || netmode == 0) {
            this.mGuidanceControl.SetCalcRouteNetMode(netmode);
        }
    }

    public int getCalcRouteNetMode() {
        return this.mRoutePlanNetMode;
    }

    public void setEngineCalcRouteNetMode(int netmode) {
        this.mEngineRoutePlanNetMode = netmode;
    }

    public int getEngineCalcRouteNetMode() {
        return this.mEngineRoutePlanNetMode;
    }

    public void setPointsToCalcRoute(ArrayList<RoutePlanNode> navNodeList) {
        setPointsToCalcRoute(navNodeList, true, -1, false, null, 1);
    }

    public void setPointsToCalcRoute(ArrayList<RoutePlanNode> navNodeList, int enRPSource) {
        setPointsToCalcRoute(navNodeList, true, -1, false, null, enRPSource);
    }

    public void setPointsToCalcRoute(ArrayList<RoutePlanNode> navNodeList, int netMode, boolean hasMrsl, String mrsl, int enRPSouce) {
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sPoiToNaviTime3 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("3", PerformStatItem.PoiToNaviStep3, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sPoiToNaviTime2, PerformStatItem.sPoiToNaviTime3);
        }
        setPointsToCalcRoute(navNodeList, true, netMode, hasMrsl, mrsl, enRPSouce);
    }

    public void setPointsToCalcRoute(ArrayList<RoutePlanNode> navNodeList, int netMode, boolean hasMrsl, String mrsl) {
        setPointsToCalcRoute(navNodeList, true, netMode, hasMrsl, mrsl, 1);
    }

    private void setPointsToCalcRoute(ArrayList<RoutePlanNode> navNodeList, boolean isAddHistory, int netMode, boolean hasMrsl, String mrsl, int enRPSource) {
        if (netMode == -1) {
            netMode = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(Key.NAVI_RP_NET_MODE, 3);
        }
        if (BNOfflineDataManager.getInstance().getNeedReload() && !BNavigator.getInstance().isNaviBegin()) {
            BNaviEngineManager.getInstance().reload();
            BNOfflineDataManager.getInstance().resetNeedReload();
        }
        int entry = getEntry();
        LogUtil.m15791e("RoutePlan", "setPointsToCalcRoute statistics: entry -->> " + entry);
        RoutePlanStatItem.getInstance().setEntry(entry);
        if (entry != 2) {
            NaviStatItem.getInstance().setEntry(entry);
        }
        SearchStatItem.getInstance().init();
        RoutePlanIPOStatItem.getInstance().setEntry(entry);
        if (entry != 2) {
            NaviIPOStatItem.getInstance().setEntry(entry);
        }
        int retPoints = checkPointListValidate(navNodeList);
        FailArg failArg = new FailArg();
        switch (retPoints) {
            case 2:
                LogUtil.m15791e("RoutePlan", "lackdata set to online");
                SetCalcRouteNetMode(1);
                if (!NetworkUtils.getConnectStatus()) {
                    failArg = new FailArg();
                    failArg.mFailType = 421;
                    failArg.mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(420);
                    notifyObservers(1, 7, failArg);
                    RoutePlanStatItem.getInstance().setErrorCode(retPoints);
                    return;
                }
                break;
            case 3:
                if (netMode != 0 && netMode != 2) {
                    if (netMode == 1 || netMode == 3) {
                        SetCalcRouteNetMode(3);
                        break;
                    }
                }
                SetCalcRouteNetMode(2);
                break;
                break;
            case 5000:
            case 5001:
                failArg.mFailType = retPoints;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(retPoints);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(retPoints);
                RoutePlanIPOStatItem.getInstance().setErrorCode(retPoints);
                return;
            case FailType.ROUTE_PLAN_DISTRICT_GET_FAILD /*5055*/:
                if (netMode != 0 && netMode != 2) {
                    if (netMode == 1 || netMode == 3) {
                        SetCalcRouteNetMode(3);
                        break;
                    }
                } else if (!isInternational(navNodeList)) {
                    SetCalcRouteNetMode(2);
                    break;
                } else {
                    SetCalcRouteNetMode(3);
                    break;
                }
                break;
        }
        if (this.mRoutePlanNetMode == 3 || this.mRoutePlanNetMode == 1) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.ONLINE_ROUTE_PLAN, NaviStatConstants.ONLINE_ROUTE_PLAN);
        }
        if (navNodeList != null && navNodeList.size() >= 2) {
            this.mEndNode = (RoutePlanNode) navNodeList.get(navNodeList.size() - 1);
            BNSettingManager.setEndNode(this.mEndNode);
            LogUtil.m15791e("RoutePlan", "endNode route " + this.mEndNode.toString());
        }
        calcRouteAfterNetworkingConfirm(navNodeList, isAddHistory, hasMrsl, mrsl, enRPSource);
    }

    private boolean isInternational(ArrayList<RoutePlanNode> navNodeList) {
        if (navNodeList == null || navNodeList.isEmpty()) {
            return false;
        }
        ArrayList<RoutePlanNode> nodeList = new ArrayList();
        RoutePlanNode endNode = (RoutePlanNode) navNodeList.get(navNodeList.size() - 1);
        nodeList.add((RoutePlanNode) navNodeList.get(0));
        nodeList.add(endNode);
        for (int i = 0; i < nodeList.size(); i++) {
            RoutePlanNode node = (RoutePlanNode) nodeList.get(i);
            if (node != null && node.isNodeSettedData()) {
                GeoPoint geoPoint = new GeoPoint();
                Bundle bundle = CoordinateTransformUtil.LLE62MC(node.getLongitudeE6(), node.getLatitudeE6());
                if (bundle != null) {
                    geoPoint = new GeoPoint(bundle.getInt("MCy"), bundle.getInt("MCx"));
                }
                if (geoPoint.getLatitudeE6() == 0 && geoPoint.getLongitudeE6() == 0) {
                    return false;
                }
                if (!BNaviModuleManager.isInternational((long) geoPoint.getLongitudeE6(), (long) geoPoint.getLatitudeE6(), 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void calcRouteAfterNetworkingConfirm(ArrayList<RoutePlanNode> routePlanNodeList, boolean isAddHistory, boolean hasMrsl, String mrsl, int enRPSource) {
        int i;
        this.mRoutePlanStopwatch.start();
        if (BNOfflineDataManager.getInstance().isNewProvinceDownload() && !BNavigator.getInstance().isNaviBegin() && (this.mRoutePlanNetMode == 2 || this.mRoutePlanNetMode == 0)) {
            BNaviEngineManager.getInstance().reload();
            BNOfflineDataManager.getInstance().clearNewProvinceDownload();
        }
        ArrayList<RoutePlanNode> navNodeList = new ArrayList();
        for (i = 0; i < routePlanNodeList.size(); i++) {
            RoutePlanNode node = (RoutePlanNode) routePlanNodeList.get(i);
            if (node != null && node.isNodeSettedData()) {
                navNodeList.add(node);
            }
        }
        if (navNodeList == null || navNodeList.size() < 2) {
            FailArg failArg = new FailArg();
            failArg.mFailType = 5000;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
            notifyObservers(1, 6, failArg);
            RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
            return;
        }
        int retSetStartPos = setStartPos((RoutePlanNode) navNodeList.get(0));
        if (17 != retSetStartPos) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteAfterNetworkingConfirm setStartPos fail");
            failArg = new FailArg();
            failArg.mFailType = retSetStartPos;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_START_FAILED);
            notifyObservers(1, 6, failArg);
            RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
            return;
        }
        ArrayList<RoutePlanNode> endPointList = new ArrayList();
        int pointInfoCount = navNodeList.size();
        for (i = 1; i < pointInfoCount; i++) {
            endPointList.add(navNodeList.get(i));
        }
        if (setDestsPos(endPointList)) {
            if (this.mRoutePlanModel != null) {
                this.mRoutePlanModel.setRouteInput(navNodeList);
                this.mRoutePlanModel.clearRouteResult();
            }
            if (isAddHistory) {
                for (i = 0; i < endPointList.size(); i++) {
                    node = (RoutePlanNode) endPointList.get(i);
                    if ((node.mFrom == 1 || node.mFrom == 8 || node.mFrom == 3 || node.mFrom == 6) && this.mCalcRouteHistoryCallback != null) {
                        this.mCalcRouteHistoryCallback.onAddDest(node);
                    }
                }
                if (this.mCalcRouteHistoryCallback != null) {
                    this.mCalcRouteHistoryCallback.onAddRoute(navNodeList);
                }
            }
            checkRPTimeValid();
            LogUtil.m15791e("mystartflag", "xx1");
            sendMessage(8);
            notifyNavEventToOut(8);
            this.mCalcRequestID = calcRoute(this.mCalcPreference, 0, getRPTime(), hasMrsl, mrsl, enRPSource);
            if (BNSettingManager.isShowJavaLog()) {
                SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" RoutePlan calcRoute mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference + "\n stack:\n " + LogUtil.getCallStack());
            }
            LogUtil.m15791e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference);
            LogUtil.m15791e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
            if (this.mCalcRequestID < 0) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteAfterNetworkingConfirm mCalcRequestID < 0");
                failArg = new FailArg();
                failArg.mFailType = FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                return;
            }
            notifyObservers(1, 1, null);
            if ((this.mCalcPreference & 4) != 0) {
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.PREFERENCE_NO_HIGHWAY, NaviStatConstants.PREFERENCE_NO_HIGHWAY);
                return;
            }
            return;
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteAfterNetworkingConfirm setDestsPos fail");
        failArg = new FailArg();
        failArg.mFailType = FailType.ROUTE_PLAN_TOAST_SET_END_FAILED;
        failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_END_FAILED);
        notifyObservers(1, 6, failArg);
        RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
    }

    public int getRoutePlanRequestID() {
        return this.mCalcRequestID;
    }

    public int calcRouteToGetDriveInfo(ArrayList<RoutePlanNode> routePlanNodeList, boolean isAvoidTrafficJam) {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        if (BNOfflineDataManager.getInstance().getNeedReload() && !BNavigator.getInstance().isNaviBegin()) {
            BNaviEngineManager.getInstance().reload();
            BNOfflineDataManager.getInstance().resetNeedReload();
        }
        FailArg failArg;
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            int i;
            this.mRoutePlanStopwatch.start();
            ArrayList<RoutePlanNode> navNodeList = new ArrayList();
            for (i = 0; i < routePlanNodeList.size(); i++) {
                RoutePlanNode node = (RoutePlanNode) routePlanNodeList.get(i);
                if (node != null && node.isNodeSettedData()) {
                    navNodeList.add(node);
                }
            }
            int retSetStartPos = setStartPos((RoutePlanNode) navNodeList.get(0));
            if (17 != retSetStartPos) {
                failArg = new FailArg();
                failArg.mFailType = retSetStartPos;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_START_FAILED);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                return -1;
            }
            ArrayList<RoutePlanNode> endPointList = new ArrayList();
            int pointInfoCount = navNodeList.size();
            for (i = 1; i < pointInfoCount; i++) {
                endPointList.add(navNodeList.get(i));
            }
            if (setDestsPos(endPointList)) {
                int ret;
                LogUtil.m15791e("mystartflag", "xx2");
                sendMessage(8);
                notifyNavEventToOut(8);
                if (this.mRoutePlanModel != null) {
                    this.mRoutePlanModel.setRouteInput(navNodeList);
                    this.mRoutePlanModel.clearRouteResult();
                }
                SetCalcRouteNetMode(1);
                if (isAvoidTrafficJam) {
                    ret = calcRoute(16, 0, getRPTime(), false, null, 1);
                } else {
                    ret = calcRoute(1, 1, getRPTime(), false, null, 1);
                }
                notifyObservers(1, 1, null);
                this.mCalcRequestID = ret;
                return ret;
            }
            failArg = new FailArg();
            failArg.mFailType = FailType.ROUTE_PLAN_TOAST_SET_END_FAILED;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_END_FAILED);
            notifyObservers(1, 6, failArg);
            RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
            return -1;
        }
        failArg = new FailArg();
        failArg.mFailType = FailType.ROUTE_PLAN_TOAST_ACTIVATE_NETWORK_UNCONNECTED;
        failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_ACTIVATE_NETWORK_UNCONNECTED);
        notifyObservers(1, 6, failArg);
        RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
        return -1;
    }

    public Bundle getHomeAndCompanyRouteInfo(RoutePlanNode startNode, RoutePlanNode endNode, int unPreference, int from, int entry, String clMapUrlParams) {
        if (startNode == null || !startNode.isNodeSettedData()) {
            FailArg failArg = new FailArg();
            failArg.mFailType = 5000;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
            return null;
        }
        ArrayList<RoutePlanNode> arry = new ArrayList();
        arry.add(startNode);
        if (endNode != null && endNode.isNodeSettedData()) {
            arry.add(endNode);
        }
        if (arry.size() < 2) {
            return null;
        }
        if (this.mGuidanceControl != null) {
            Bundle data = new Bundle();
            if (this.mGuidanceControl.CalcSpecPoiRouteInfo(arry, unPreference, from, entry, clMapUrlParams, data)) {
                return data;
            }
        }
        return null;
    }

    public void calcRouteToRouteCustom(ArrayList<RoutePlanNode> routePlanNodeList) {
        if (this.mGuidanceControl == null) {
            sendMessage(7);
            notifyNavEventToOut(7);
            return;
        }
        int i;
        if (BNOfflineDataManager.getInstance().getNeedReload() && !BNavigator.getInstance().isNaviBegin()) {
            BNaviEngineManager.getInstance().reload();
            BNOfflineDataManager.getInstance().resetNeedReload();
        }
        int settingNetMode = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(Key.NAVI_RP_NET_MODE, 3);
        int retPoints = checkPointListValidate(routePlanNodeList);
        FailArg failArg = new FailArg();
        switch (retPoints) {
            case 2:
                LogUtil.m15791e("RoutePlan", "lackdata set to online");
                SetCalcRouteNetMode(1);
                break;
            case 3:
                if (settingNetMode != 0 && settingNetMode != 2) {
                    if (settingNetMode == 1 || settingNetMode == 3) {
                        SetCalcRouteNetMode(3);
                        break;
                    }
                }
                SetCalcRouteNetMode(2);
                break;
                break;
            case 5000:
            case 5001:
            case FailType.ROUTE_PLAN_DISTRICT_GET_FAILD /*5055*/:
                failArg.mFailType = retPoints;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(retPoints);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                return;
        }
        this.mRoutePlanStopwatch.start();
        ArrayList<RoutePlanNode> navNodeList = new ArrayList();
        for (i = 0; i < routePlanNodeList.size(); i++) {
            RoutePlanNode node = (RoutePlanNode) routePlanNodeList.get(i);
            if (node != null && node.isNodeSettedData()) {
                navNodeList.add(node);
            }
        }
        int retSetPoints = setStartPos((RoutePlanNode) navNodeList.get(0));
        if (17 != retSetPoints) {
            sendMessage(7);
            notifyNavEventToOut(7);
            RoutePlanStatItem.getInstance().setErrorCode(retSetPoints);
            return;
        }
        ArrayList<RoutePlanNode> endPointList = new ArrayList();
        int pointInfoCount = navNodeList.size();
        for (i = 1; i < pointInfoCount; i++) {
            endPointList.add(navNodeList.get(i));
        }
        if (setDestsPos(endPointList)) {
            if (this.mRoutePlanModel != null) {
                this.mRoutePlanModel.setRouteInput(navNodeList);
                this.mRoutePlanModel.clearRouteResult();
            }
            int ret = calcRoute(1, 1, getRPTime(), false, null, 1);
            this.mCalcRequestID = ret;
            if (ret == -1) {
                sendMessage(7);
                notifyNavEventToOut(7);
                RoutePlanStatItem.getInstance().setErrorCode(FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED);
                return;
            }
            notifyObservers(1, 1, null);
            return;
        }
        sendMessage(7);
        notifyNavEventToOut(7);
        RoutePlanStatItem.getInstance().setErrorCode(FailType.ROUTE_PLAN_TOAST_SET_END_FAILED);
    }

    public void stopWatchRoutePlanStat() {
        RoutePlanStatItem.getInstance().setRouPlanDetailViewShowTime(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean checkPointDataReady(GeoPoint point, DistrictInfo districtInfo) {
        boolean bResult = false;
        if (point == null) {
            return false;
        }
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            DistrictInfo childDistrictInfo = BNPoiSearcher.getInstance().getDistrictByPoint(point, 0);
            if (childDistrictInfo != null) {
                DistrictInfo parentDistrict = BNPoiSearcher.getInstance().getParentDistrict(childDistrictInfo.mId);
                if (parentDistrict != null) {
                    bResult = BNOfflineDataManager.getInstance().isProvinceDataDownload(parentDistrict.mId);
                }
                if (districtInfo != null) {
                    districtInfo.copy(parentDistrict);
                }
            }
        }
        return bResult;
    }

    public boolean checkPointDataReady(DistrictInfo districtInfo) {
        boolean bResult = false;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            DistrictInfo childDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(districtInfo.mCityId);
            if (childDistrictInfo != null) {
                DistrictInfo parentDistrict = BNPoiSearcher.getInstance().getParentDistrict(childDistrictInfo.mId);
                if (parentDistrict != null) {
                    bResult = BNOfflineDataManager.getInstance().isProvinceDataDownload(parentDistrict.mId);
                }
                if (districtInfo != null) {
                    districtInfo.copy(parentDistrict);
                }
            }
        }
        return bResult;
    }

    private int checkPointListValidate(ArrayList<RoutePlanNode> navNodeList) {
        if (navNodeList == null || navNodeList.size() < 2 || navNodeList.size() > 5) {
            return 5000;
        }
        int i;
        int listsize = navNodeList.size();
        for (i = 0; i < listsize; i++) {
            RoutePlanNode node = (RoutePlanNode) navNodeList.get(i);
            if (node == null || !node.isNodeSettedData()) {
                return 5001;
            }
        }
        this.mStrLackDataCities = "";
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            int pointInfoCount = navNodeList.size();
            for (i = 0; i < pointInfoCount; i++) {
                DistrictInfo destDistrict = new DistrictInfo();
                if (!checkPointDataReady(((RoutePlanNode) navNodeList.get(i)).mGeoPoint, destDistrict)) {
                    if (destDistrict.mId < 0) {
                        return FailType.ROUTE_PLAN_DISTRICT_GET_FAILD;
                    }
                    this.mStrLackDataCities += destDistrict.mName;
                }
            }
        } else {
            this.mStrLackDataCities = RoutePlanParams.COUNTRY_OFFLINE_DATA;
        }
        GeoPoint start = ((RoutePlanNode) navNodeList.get(0)).mGeoPoint;
        ArrayList<GeoPoint> array = new ArrayList();
        for (i = 1; i < navNodeList.size(); i++) {
            array.add(((RoutePlanNode) navNodeList.get(i)).mGeoPoint);
        }
        if (!isExistLocalRPData(start, array)) {
            boolean[] data = new boolean[35];
            if (getLackOfData(data)) {
                if (StringUtils.isNotEmpty(this.mStrLackDataCities)) {
                    this.mStrLackDataCities += "、";
                }
                this.mStrLackDataCities += BNRoutePlanHelper.getLackOfDataCities(data);
            }
        }
        if (StringUtils.isNotEmpty(this.mStrLackDataCities)) {
            return 2;
        }
        return 3;
    }

    private int checkPointListValidateJustByDistrictID(ArrayList<RoutePlanNode> navNodeList) {
        if (navNodeList == null || navNodeList.size() < 2 || navNodeList.size() > 5) {
            return 5000;
        }
        this.mStrLackDataCities = "";
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            int pointInfoCount = navNodeList.size();
            for (int i = 0; i < pointInfoCount; i++) {
                DistrictInfo destDistrict = new DistrictInfo();
                destDistrict.mCityId = ((RoutePlanNode) navNodeList.get(i)).mDistrictID;
                if (!checkPointDataReady(destDistrict)) {
                    if (destDistrict.mId < 0) {
                        return FailType.ROUTE_PLAN_DISTRICT_GET_FAILD;
                    }
                    this.mStrLackDataCities += destDistrict.mName;
                }
            }
        } else {
            this.mStrLackDataCities = RoutePlanParams.COUNTRY_OFFLINE_DATA;
        }
        if (StringUtils.isNotEmpty(this.mStrLackDataCities)) {
            return 2;
        }
        return 3;
    }

    public void setCalcPrference(int preference) {
        this.mCalcPreference = preference;
        if (this.mCalcPreference == 0) {
            this.mCalcPreference = 1;
        }
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt(RoutePlanParams.CALC_PREFERENCE, this.mCalcPreference);
    }

    public int getCalcPreference() {
        Context context = BNaviModuleManager.getContext();
        if (this.mCalcPreference >= 1) {
            return this.mCalcPreference;
        }
        if (context != null) {
            this.mCalcPreference = PreferenceHelper.getInstance(context).getInt(RoutePlanParams.CALC_PREFERENCE, 1);
        } else {
            this.mCalcPreference = 1;
        }
        return this.mCalcPreference;
    }

    public int getTMPCalcPreference() {
        return this.mCalcPreference;
    }

    public Boolean hasAvoidTrafficPreference() {
        int pre = getCalcPreference();
        LogUtil.m15791e("RoutePlan", "hasAvoidTrafficPreference pre = " + pre + " ||| (pre & NE_RoutePlan_Mode.ROUTE_PLAN_MOD_AVOID_TAFFICJAM) = " + (pre & 16));
        if ((pre & 16) > 0) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    private void showRouteplanOvertimeDialog() {
        final ArrayList<RoutePlanNode> navNodeList = this.mRoutePlanModel.getRouteInput();
        ConfirmOTArg confirmArg = new ConfirmOTArg();
        confirmArg.mConfirmListener = new OnNaviClickListener() {
            public void onClick() {
                BNRoutePlaner.this.notifyObservers(5, 17, null);
                BNRoutePlaner.this.calcRouteAfterNetworkingConfirm(navNodeList, false, false, null, 0);
            }
        };
        notifyObservers(5, 16, confirmArg);
    }

    public void showReCalRouteProgressDialog() {
        LogUtil.m15791e("RoutePlan", "showReCalRouteProgressDialog");
        notifyObservers(1, 1, null);
    }

    private RoutePlanTime getRPTime() {
        return RoutePlanTimeUtil.getInstance().getRoutePlanTime();
    }

    public void cancleCalcRouteRequest() {
        LogUtil.m15791e("RoutePlan", "cancleCalcRouteRequest() mCalcRequestID = " + this.mCalcRequestID);
        notifyObservers(1, 4, null);
        CancelCalcRoute(this.mCalcRequestID);
        sendMessage(32);
        notifyNavEventToOut(32);
        requestMapHandleRPcancel();
    }

    public void cancleCalcWhenQuitNavi() {
        LogUtil.m15791e("RoutePlan", "cancleCalcRouteRequest() mCalcRequestID = " + this.mCalcRequestID);
        notifyObservers(1, 4, null);
        CancelCalcRoute(this.mCalcRequestID);
        sendMessage(32);
        requestMapHandleRPcancel();
    }

    public void cancelCalcRouteToResumeGuide() {
        CancelCalcRoute(this.mCalcRequestID);
        notifyObservers(1, 4, null);
    }

    public void CancelCurCalcRoute() {
        CancelCalcRoute(this.mCalcRequestID);
    }

    private void requestMapHandleRPcancel() {
        LogUtil.m15791e("RoutePlan", "requestMapHandleRPcancel");
        if (mMapComponentCallback != null) {
            mMapComponentCallback.onMapComponentCall(32, 0, 0, null);
        }
    }

    private void checkRPTimeValid() {
        int rpNetMode = this.mRoutePlanNetMode;
        if (rpNetMode == 0 || 2 == rpNetMode) {
            if (RoutePlanTimeUtil.getInstance().getTimeSetState()) {
                RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(true);
            } else {
                RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(false);
            }
        } else if (1 == rpNetMode || 3 == rpNetMode) {
            RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(true);
        }
    }

    public ArrayList<RoutePlanNode> getRemainedDestList() {
        ArrayList<RoutePlanNode> remainedNodeList = new ArrayList();
        ArrayList<RoutePlanNode> navNodeList = this.mRoutePlanModel.getRouteInput();
        int pointCount = navNodeList.size();
        if (pointCount >= 2) {
            remainedNodeList.clear();
            int pastViaNum = pointCount - 1;
            int remainedDestsNum = getRemainedDests();
            if (remainedDestsNum >= 0) {
                pastViaNum -= remainedDestsNum;
            } else {
                pastViaNum = 0;
            }
            for (int i = 1; i < pointCount; i++) {
                if (i <= 0 || pastViaNum <= 0) {
                    remainedNodeList.add(new RoutePlanNode((RoutePlanNode) navNodeList.get(i)));
                } else {
                    pastViaNum--;
                }
            }
        }
        return remainedNodeList;
    }

    public int getRemainedDests() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        int[] num = new int[]{0};
        if (this.mGuidanceControl.GetDestsRemained(num)) {
            return num[0];
        }
        return -1;
    }

    private void registerNetworkListener() {
        NetworkListener.registerMessageHandler(this.mNetChangeHandler);
    }

    private void unregisterNetworkListener() {
        NetworkListener.unRegisterMessageHandler(this.mNetChangeHandler);
    }

    public void setDriveRefTimeParams(int driveRefTimeInterval, int driveRefTimeDuration) {
        this.mDriveRefTimeInterval = driveRefTimeInterval;
        this.mDriveRefTimeDuration = driveRefTimeDuration;
    }

    public boolean isCalculatingRoute() {
        return this.mIsCalculatingRoute;
    }

    public int getRouteInfo(int unRouteIdx, Bundle bundle) {
        if (this.mGuidanceControl == null) {
            return 0;
        }
        return this.mGuidanceControl.GetRouteInfo(unRouteIdx, bundle);
    }

    public int getRouteCnt() {
        if (this.mGuidanceControl == null) {
            return 0;
        }
        return this.mGuidanceControl.GetRouteCnt();
    }

    public void setPointsToCalcRouteForMap(ArrayList<RoutePlanNode> navNodeList, int netMode, boolean hasMrsl, String mrsl, int enRPSource) {
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sCalcRoutePrepareStart = System.currentTimeMillis();
        }
        if (getEntry() == 31) {
            UserOPController.getInstance().add(UserOPParams.ROUTE_2_g_1);
        }
        boolean isForSearch = false;
        Iterator it = navNodeList.iterator();
        while (it.hasNext()) {
            if (((RoutePlanNode) it.next()).mFrom == 2) {
                isForSearch = true;
                break;
            }
        }
        LogUtil.m15791e("RoutePlan", "stat test stopWatch start");
        this.mRoutePlanStopwatch.start();
        if (isForSearch) {
            if (netMode == -1) {
                netMode = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(Key.NAVI_RP_NET_MODE, 3);
            }
            SearchStatItem.getInstance().init();
            int entry = getEntry();
            RoutePlanStatItem.getInstance().setEntry(entry);
            if (entry != 2) {
                NaviStatItem.getInstance().setEntry(entry);
            }
            int retPoints = checkPointListValidateJustByDistrictID(navNodeList);
            FailArg failArg = new FailArg();
            switch (retPoints) {
                case 2:
                    LogUtil.m15791e("RoutePlan", "lackdata set to online");
                    SetCalcRouteNetMode(1);
                    break;
                case 3:
                    if (netMode != 0 && netMode != 2) {
                        if (netMode == 1 || netMode == 3) {
                            SetCalcRouteNetMode(3);
                            break;
                        }
                    }
                    SetCalcRouteNetMode(2);
                    break;
                    break;
                case 5000:
                case 5001:
                    failArg.mFailType = retPoints;
                    failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(retPoints);
                    notifyObservers(1, 6, failArg);
                    RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                    return;
                case FailType.ROUTE_PLAN_DISTRICT_GET_FAILD /*5055*/:
                    if (netMode != 0 && netMode != 2) {
                        if (netMode == 1 || netMode == 3) {
                            SetCalcRouteNetMode(3);
                            break;
                        }
                    }
                    SetCalcRouteNetMode(2);
                    break;
                    break;
            }
            if (BNOfflineDataManager.getInstance().getNeedReload() && !BNavigator.getInstance().isNaviBegin()) {
                BNaviEngineManager.getInstance().reload();
                BNOfflineDataManager.getInstance().resetNeedReload();
            }
            if (BNOfflineDataManager.getInstance().isNewProvinceDownload() && (this.mRoutePlanNetMode == 2 || this.mRoutePlanNetMode == 0)) {
                BNaviEngineManager.getInstance().reload();
                BNOfflineDataManager.getInstance().clearNewProvinceDownload();
            }
            if (navNodeList == null || navNodeList.size() < 2) {
                failArg.mFailType = 5000;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                return;
            }
            int retSetStartPos = setStartPos((RoutePlanNode) navNodeList.get(0));
            if (17 != retSetStartPos) {
                failArg.mFailType = retSetStartPos;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_START_FAILED);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                return;
            }
            ArrayList<RoutePlanNode> endPointList = new ArrayList();
            int pointInfoCount = navNodeList.size();
            for (int i = 1; i < pointInfoCount; i++) {
                endPointList.add(navNodeList.get(i));
            }
            if (setDestsPos(endPointList)) {
                if (navNodeList != null && navNodeList.size() >= 2) {
                    this.mEndNode = (RoutePlanNode) navNodeList.get(navNodeList.size() - 1);
                    BNSettingManager.setEndNode(this.mEndNode);
                    LogUtil.m15791e("RoutePlan", "endNode route " + this.mEndNode.toString());
                }
                if (this.mRoutePlanModel != null) {
                    this.mRoutePlanModel.setRouteInput(navNodeList);
                    this.mRoutePlanModel.clearRouteResult();
                }
                sendMessage(8);
                notifyNavEventToOut(8);
                this.mCalcRequestID = calcRoute(this.mCalcPreference, 0, getRPTime(), hasMrsl, mrsl, enRPSource);
                if (BNSettingManager.isShowJavaLog()) {
                    SDKDebugFileUtil.get(SDKDebugFileUtil.RoutePlan_FILENAME).add(" RoutePlan calcRoute mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference + "\n stack:\n " + LogUtil.getCallStack());
                }
                LogUtil.m15791e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID + " mCalcPreference = " + this.mCalcPreference);
                LogUtil.m15791e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
                if (this.mCalcRequestID < 0) {
                    failArg.mFailType = FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED;
                    failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED);
                    notifyObservers(1, 6, failArg);
                    RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                    return;
                }
                notifyObservers(1, 1, null);
                return;
            }
            failArg.mFailType = FailType.ROUTE_PLAN_TOAST_SET_END_FAILED;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_END_FAILED);
            notifyObservers(1, 6, failArg);
            RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
            return;
        }
        setPointsToCalcRoute(navNodeList, false, netMode, hasMrsl, mrsl, enRPSource);
    }

    public boolean calcRouteWithPB(int routeDataMode, int outDataType, ArrayList<RoutePlanNode> routePlanNodeList, int unPreference, byte[] pbData, int pbDataLen) {
        if (PerformStatItem.sUserTest && pbData != null) {
            PerformStatisticsController.getInstance().addDataLog(2110, 1, PerformStatItem.DATA_ACTION_TAG, "14", PerformStatItem.NAVI_ENGINE_MODULE_NAME, "StartRoutePlanBeginWithMultiNavi", (long) pbData.length);
        }
        LogUtil.m15791e("RoutePlan", "calcRouteWithPB() routeDataMode=" + routeDataMode + ", outDataType=" + outDataType + ", pbDataLen=" + pbDataLen);
        if (this.mGuidanceControl == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData mGuidanceControl is null");
            return false;
        }
        FailArg failArg = new FailArg();
        int entry = getEntry();
        RoutePlanStatItem.getInstance().setEntry(entry);
        if (entry != 2) {
            NaviStatItem.getInstance().setEntry(entry);
        }
        if (outDataType == 0) {
            int i;
            ArrayList<RoutePlanNode> navNodeList = new ArrayList();
            for (i = 0; i < routePlanNodeList.size(); i++) {
                RoutePlanNode node = (RoutePlanNode) routePlanNodeList.get(i);
                if (node != null && node.isNodeSettedData()) {
                    navNodeList.add(node);
                }
            }
            if (navNodeList == null || navNodeList.size() < 2) {
                failArg.mFailType = 5000;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData navNodeList is null");
                return false;
            }
            int retSetStartPos = setStartPos((RoutePlanNode) navNodeList.get(0));
            if (17 != retSetStartPos) {
                failArg.mFailType = retSetStartPos;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_START_FAILED);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData setStartPos fail");
                return false;
            }
            ArrayList<RoutePlanNode> endPointList = new ArrayList();
            int pointInfoCount = navNodeList.size();
            for (i = 1; i < pointInfoCount; i++) {
                endPointList.add(navNodeList.get(i));
            }
            if (!setDestsPos(endPointList)) {
                failArg.mFailType = FailType.ROUTE_PLAN_TOAST_SET_END_FAILED;
                failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_SET_END_FAILED);
                notifyObservers(1, 6, failArg);
                RoutePlanStatItem.getInstance().setErrorCode(failArg.mFailType);
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData setDestsPos fail");
                return false;
            } else if (this.mRoutePlanModel != null) {
                this.mRoutePlanModel.setRouteInput(navNodeList);
                this.mRoutePlanModel.clearRouteResult();
            }
        } else if (this.mRoutePlanModel != null) {
            this.mRoutePlanModel.clearRouteResult();
        }
        LogUtil.m15791e("mystartflag", "xx4");
        sendMessage(8);
        notifyNavEventToOut(8);
        Bundle pbDataBundle = new Bundle();
        pbDataBundle.putByteArray("pb_data", pbData);
        LogUtil.m15791e("RoutePlan", "calcRouteWithPB: unPreference --> " + unPreference);
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX, PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_NAME, PerformStatItem.sDataHandleAfterLightStart, System.currentTimeMillis());
            PerformStatItem.sRoutePlanWithMultiNaviStart = System.currentTimeMillis();
        }
        this.mCalcRequestID = this.mGuidanceControl.CalcRouteWithPB(routeDataMode, outDataType, unPreference, pbDataBundle, pbDataLen, this.isComeFromParam);
        RoutePlanStatItem.getInstance().rouEntry = this.isComeFromParam;
        LogUtil.m15791e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID);
        LogUtil.m15791e("RoutePlan", "calcRoute. mCalcPreference = " + this.mCalcPreference);
        LogUtil.m15791e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
        if (this.mCalcRequestID < 0) {
            LogUtil.m15791e("RoutePlan", "calcRoute. failed.");
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_Common, "calcRouteWithPBData mCalcRequestID < 0");
            failArg.mFailType = FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED;
            failArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(FailType.ROUTE_PLAN_TOAST_CALC_ROUTE_FAILED);
            notifyObservers(1, 6, failArg);
            return false;
        }
        notifyObservers(1, 1, null);
        return true;
    }

    public boolean lightCalcRoute(int errorCode) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        LogUtil.m15791e("RoutePlan", "lightCalcRoute:" + errorCode);
        return this.mGuidanceControl.LightCalcRoute(errorCode, this.mCalcRequestID);
    }

    public String getTRURlParam() {
        if (this.mGuidanceControl == null) {
            return null;
        }
        return this.mGuidanceControl.GetTRURlParam();
    }

    public boolean selectRoute(int unRouteIdx) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SelectRoute(unRouteIdx);
    }

    private int setStartPos(RoutePlanNode start) {
        boolean z = true;
        if (this.mGuidanceControl == null) {
            return FailType.ROUTE_PLAN_TOAST_SET_START_FAILED_FOR_APP_GUIDANCE_IS_NULL;
        }
        if (start == null) {
            return FailType.ROUTE_PLAN_TOAST_SET_START_FAILED_FOR_APP_START_IS_NULL;
        }
        if (start.mName != null) {
            if (start.mName.equals(RoutePlanParams.MY_LOCATION)) {
                int i;
                RoutePlanStatItem instance = RoutePlanStatItem.getInstance();
                if (start.mSensorAngle >= 0.0f) {
                    i = 1;
                } else {
                    i = 0;
                }
                instance.mHasSensor = i;
            } else {
                RoutePlanStatItem.getInstance().mHasSensor = 2;
            }
        }
        LogUtil.m15791e("RoutePlan", "setStartPos. mHasSensor = " + RoutePlanStatItem.getInstance().mHasSensor);
        RoutePlanStatItem.getInstance().mStartFromType = start.mFrom;
        if (start.mLocType == 1) {
            RoutePlanStatItem.getInstance().mCurrLocationType = 1;
        } else if (start.mLocType == 2) {
            RoutePlanStatItem.getInstance().mCurrLocationType = 2;
        } else if (start.mLocType == 3) {
            RoutePlanStatItem.getInstance().mCurrLocationType = 3;
        } else {
            RoutePlanStatItem.getInstance().mCurrLocationType = 0;
        }
        long startTime = System.currentTimeMillis();
        BNSysLocationManager.getInstance().startRecordStarInfos();
        LogUtil.m15791e("BNRoutePlaner startRecordStarInfos cost :", ((System.currentTimeMillis() - startTime) / 1000) + "");
        LogUtil.m15791e("SetStartPos: fAltitude:", start.mAltitude + "");
        String str = "is GPSLocation:";
        StringBuilder stringBuilder = new StringBuilder();
        if (start.mLocType != 1) {
            z = false;
        }
        LogUtil.m15791e(str, stringBuilder.append(z).append("").toString());
        return this.mGuidanceControl.SetStartPosNav(start);
    }

    public boolean setDestsPos(ArrayList<RoutePlanNode> arry) {
        if (this.mGuidanceControl == null || arry == null || arry.size() == 0) {
            return false;
        }
        for (int i = 0; i < arry.size(); i++) {
            LogUtil.m15791e("JNIGuidanceControl", "setDestsPos() --> endNode.mFromType = " + (arry.get(i) == null ? "null" : Integer.valueOf(((RoutePlanNode) arry.get(i)).mFrom)) + ", endNode.mUID = " + (arry.get(i) == null ? "null" : ((RoutePlanNode) arry.get(i)).mUID));
        }
        return this.mGuidanceControl.SetDestsPosNav(arry);
    }

    public boolean meetingPreloadRoute(RoutePlanNode stStartPos, ArrayList<RoutePlanNode> arry, int enComfrom, Bundle outBundle) {
        if (this.mGuidanceControl == null || stStartPos == null || arry == null || arry.size() == 0) {
            return false;
        }
        return this.mGuidanceControl.MeetingPreloadRoute(stStartPos, arry, enComfrom, outBundle);
    }

    public void CancelCalcRoute(int requestID) {
        BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, "CancelRoute id :" + requestID);
        if (this.mGuidanceControl != null) {
            try {
                this.mGuidanceControl.CancelCalcRoute(requestID);
            } catch (Throwable th) {
            }
        }
    }

    public boolean setNaviCalcResultSpeak(int bOpen) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.SetNaviCaclResultSpeak(bOpen);
    }

    public boolean GetAvoidInfo(int unRouteIdx) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetAvoidInfo(unRouteIdx);
    }

    public String GetAvoidTips(int unRouteIdx) {
        if (this.mGuidanceControl == null) {
            return null;
        }
        return this.mGuidanceControl.GetAvoidTips(unRouteIdx);
    }

    public boolean GetRouteTollMode(int unRouteIdx, int eRoutePlanMode) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetRouteTollMode(unRouteIdx, eRoutePlanMode);
    }

    public boolean ManualPlaySound() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.ManualPlaySound();
    }

    public void EnableRoadCondition(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.EnableRoadCondition(b);
        }
    }

    public void SetRouteSpec(boolean b) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetRouteSpec(b);
        }
    }

    public boolean getLackOfData(boolean[] data) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.GetLackOfData(data);
    }

    public Bundle getDriveInfo(int unRouteIdx) {
        if (this.mGuidanceControl == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.mGuidanceControl.GetDriveInfo(unRouteIdx, bundle)) {
            return bundle;
        }
        return null;
    }

    public int getShowPreferenceTap() {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.GetShowPreferenceTap();
    }

    public int getRoutePlanSubResult(ArrayList<Bundle> routePlanSubResult, Bundle data) {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        return this.mGuidanceControl.GetRoutePlanSubResult(routePlanSubResult, data);
    }

    public void triggerGPSStatus(int eGPSStatus) {
        if (this.mGuidanceControl != null) {
            LogUtil.m15791e("RoutePlan", "triggerGPSStatus (2739): eGPSStatus --> " + eGPSStatus);
            this.mGuidanceControl.TriggerGPSStatus(eGPSStatus);
        }
    }

    public boolean isExistLocalRPData(GeoPoint start, ArrayList<GeoPoint> array) {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.isExistLocalRPData(start, array);
        }
        return false;
    }

    public boolean triggerNetStatusChange(int status) {
        boolean z = false;
        if (this.mGuidanceControl != null) {
            try {
                z = this.mGuidanceControl.TriggerNetStatusChange(status);
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public boolean triggerSensorAngle(double fTrueHeading, double fHeadingAccuracy) {
        boolean z = false;
        if (this.mGuidanceControl != null) {
            try {
                z = this.mGuidanceControl.triggerSensorAngle(fTrueHeading, fHeadingAccuracy);
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public boolean triggerStartSensorData(float x, float y, float z) {
        boolean z2 = false;
        if (this.mGuidanceControl != null) {
            try {
                z2 = this.mGuidanceControl.TriggerStartSensorData(x, y, z);
            } catch (Throwable th) {
            }
        }
        return z2;
    }

    public boolean triggerPressureChange(float fPressureValue) {
        boolean z = false;
        if (this.mGuidanceControl != null) {
            try {
                z = this.mGuidanceControl.triggerPressureChange(fPressureValue);
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public int selectRouteWithMrsl(String routeMrsl) {
        if (PerformStatItem.sUserTest) {
            PerformStatItem.sRoutePageToNaviTime3 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("3", "适配层到SDK", PerformStatItem.NAVI_MODULE_NAME, PerformStatItem.sRoutePageToNaviTime2, PerformStatItem.sRoutePageToNaviTime3);
        }
        LogUtil.m15791e("RoutePlan", "selectRouteWithMrsl() routeMrsl=" + routeMrsl + ", time=" + SystemClock.elapsedRealtime());
        int routeIndex = this.mGuidanceControl.SelectRouteWithMrsl(routeMrsl);
        LogUtil.m15791e("RoutePlan", "selectRouteWithMrsl() routeIndex=" + routeIndex);
        if (routeIndex >= 0) {
            Bundle bundle = new Bundle();
            int ret = getInstance().getRouteInfo(routeIndex, bundle);
            LogUtil.m15791e("RoutePlan", "selectRouteWithMrsl() ret=" + ret);
            if (ret == 2) {
                this.mRoutePlanModel.parseRouteResult(BNaviModuleManager.getContext(), bundle);
            }
        }
        return routeIndex;
    }

    public boolean clearRouteBuffer() {
        if (this.mGuidanceControl == null) {
            return false;
        }
        return this.mGuidanceControl.ClearRouteBuffer();
    }

    public byte[] getRoutePlanResultMapProtoBuf() {
        return getRoutePlanResultMapProtoBuf(0);
    }

    public byte[] getRoutePlanResultMapProtoBuf(int carsType) {
        Bundle data = new Bundle();
        if (this.mGuidanceControl.GetRoutePlanResultMapProtoBuf(data, carsType) && data != null && data.containsKey("pb_data")) {
            return data.getByteArray("pb_data");
        }
        return null;
    }

    public void getRouteBoundRect(ArrayList<Bundle> routeRects) {
        this.mGuidanceControl.GetRouteBoundRect(routeRects);
    }

    public void setIsChangeBackground(int isBackground) {
        this.mGuidanceControl.SetIsChangeBackgroun(isBackground);
    }

    public Bundle getMapVehiclePos() {
        Bundle carPoint = new Bundle();
        return this.mGuidanceControl.GetMapVehiclePos(carPoint) ? carPoint : null;
    }

    public boolean startDrivingCar() {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.StartDrivingCar();
        }
        return false;
    }

    public boolean stopDrivingCar() {
        if (this.mGuidanceControl != null) {
            return this.mGuidanceControl.StopDrivingCar();
        }
        return false;
    }

    public boolean selectRouteForDriving(String routeMrsl) {
        LogUtil.m15791e("RoutePlan", "selectRouteForDriving() routeMrsl=" + routeMrsl + ", time=" + SystemClock.elapsedRealtime());
        if (this.mGuidanceControl == null) {
            return false;
        }
        int routeIndex = this.mGuidanceControl.SelectRouteWithMrsl(routeMrsl);
        LogUtil.m15791e("RoutePlan", "selectRouteForDriving() routeIndex=" + routeIndex);
        if (routeIndex < 0) {
            return false;
        }
        return true;
    }

    public boolean updateRouteRoadCondation(int type) {
        return this.mGuidanceControl.UpdateRouteRoadCondation(type);
    }

    public void setIsMrslRoute(boolean ismrsl, String strMrsl) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetIsMrslRoute(ismrsl, strMrsl);
        }
    }

    public void setNaviPVStat(boolean isPV) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetNaviPVStat(true);
        }
    }

    public String getRoutePlanSessionIDAndMrsl(String clSessionID, String strMrsl) {
        if (this.mGuidanceControl == null) {
            return null;
        }
        return this.mGuidanceControl.GetRoutePlanSessionIDAndMrsl(clSessionID, strMrsl);
    }

    public int getRoutePlanSessionIDAndMrsl(Bundle bundle) {
        if (this.mGuidanceControl != null && this.mGuidanceControl.GetRouteSessionIDAndMrsl(bundle) == 1) {
            return 0;
        }
        return -1;
    }

    public void setRoutePlanStatistcsUrl(String url) {
        if (this.mGuidanceControl != null) {
            this.mGuidanceControl.SetRoutePlanStatistcsUrl(url);
        }
    }

    public void setCalcRouteHistoryCallback(CalcRouteHistoryCallback callback) {
        this.mCalcRouteHistoryCallback = callback;
    }

    public static void setMapComponentCallback(MapComponentCallback callback) {
        mMapComponentCallback = callback;
    }

    public static void setSelectRouteCallback(MapComponentCallback callback) {
        mSelectRouteCallback = callback;
    }

    public static int requestMapLightService(String url, int timeout) {
        LogUtil.m15791e("RoutePlan", "requestMapLightService() url=" + url);
        if (PerformStatItem.sUserTest) {
            PerformStatisticsController.getInstance().addTimeLog(2110, 1, PerformStatItem.TIME_ACTION_TAG, "5", PerformStatItem.NAVI_ENGINE_MODULE_NAME, PerformStatItem.ROUTE_PLAN_BEGIN_WITH_NODE, PerformStatItem.sRoutePlanBeginWithRouteNodeStart, System.currentTimeMillis());
            PerformStatItem.sRequestMapLightServiceStart = System.currentTimeMillis();
        }
        if (mMapComponentCallback == null) {
            return -1;
        }
        LogUtil.m15791e("RoutePlan", "mMapComponentCallback toString=" + mMapComponentCallback.toString());
        return mMapComponentCallback.onMapComponentCall(1, timeout, 0, url);
    }

    private int requestMapHandleRPSucess() {
        LogUtil.m15791e("RoutePlan", "requestMapHandleRPSucess");
        if (mMapComponentCallback != null) {
            return mMapComponentCallback.onMapComponentCall(4, 0, 0, null);
        }
        return -1;
    }

    public void setCalcPrefCarNo(String carno) {
        this.mCalcPrefCarNo = carno;
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.LICENSE_RECORD, NaviStatConstants.LICENSE_RECORD);
    }

    public String getCalcPrefCarNo() {
        return this.mCalcPrefCarNo;
    }

    public void updateCloudTrafficInfo(int cityId, long timeStamp) {
        this.mGuidanceControl.UpdateCloudTrafficInfo(cityId, String.valueOf(timeStamp));
    }

    public boolean isBuildRouteReady(boolean bWholeData, String mrslstr) {
        if (this.mGuidanceControl == null) {
            return false;
        }
        boolean ret = this.mGuidanceControl.isBuildRouteReady(bWholeData, mrslstr);
        LogUtil.m15791e("", "   isBuildRouteReady ret : " + ret);
        return ret;
    }

    public int getLineDist2RpNode(LocData locData, boolean isStartNode) {
        RoutePlanNode rpNode = null;
        if (this.mRoutePlanModel != null) {
            if (isStartNode) {
                rpNode = this.mRoutePlanModel.getStartNode();
            } else {
                rpNode = this.mRoutePlanModel.getEndNode();
            }
        }
        if (rpNode == null || rpNode.getLatitudeE6() == Integer.MIN_VALUE || rpNode.getLongitudeE6() == Integer.MIN_VALUE || locData == null || locData.longitude == -1.0d || locData.latitude == -1.0d) {
            return -1;
        }
        double lDist = StringUtils.lineDistance(locData.longitude * 100000.0d, locData.latitude * 100000.0d, (double) rpNode.getLongitudeE6(), (double) rpNode.getLatitudeE6());
        LogUtil.m15791e("RoutePlan", "getLineDist2RpNode: --> lDist: " + lDist);
        return (int) lDist;
    }

    public int getRoutePlanNetMode() {
        if (this.mRoutePlanModel != null) {
            return this.mRoutePlanModel.getRoutePlanNetMode();
        }
        return -1;
    }

    public void setRoutePlanNetMode(int netmode) {
        if (this.mRoutePlanModel != null) {
            this.mRoutePlanModel.setRoutePlanNetMode(netmode);
        }
    }

    public void statisPreCalcRoute(Bundle data) {
        if (data != null) {
            int enPreCalcRouteResult = 0;
            if (data.containsKey("enPreCalcRouteResult")) {
                enPreCalcRouteResult = data.getInt("enPreCalcRouteResult");
            }
            LogUtil.m15791e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + enPreCalcRouteResult);
            if (enPreCalcRouteResult > 1) {
                double dDist = -1.0d;
                if (data.containsKey("dDist")) {
                    dDist = data.getDouble("dDist");
                }
                long nTickInterval = -1;
                if (data.containsKey("nTickInterval")) {
                    nTickInterval = data.getLong("nTickInterval");
                }
                int enLocationType = -1;
                if (data.containsKey("enLocationType")) {
                    enLocationType = data.getInt("enLocationType");
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.m15791e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + enPreCalcRouteResult + ", dDist=" + dDist + ", nTickInterval=" + nTickInterval + ", enLocationType=" + enLocationType);
                }
                UserOPController.getInstance().add(enPreCalcRouteResult == 2 ? UserOPParams.ROUTE_2_g_2 : UserOPParams.ROUTE_2_g_3, String.valueOf(enLocationType), String.valueOf(nTickInterval), String.valueOf(dDist));
            }
        }
    }
}
