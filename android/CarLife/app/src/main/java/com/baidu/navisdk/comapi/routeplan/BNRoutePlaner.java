package com.baidu.navisdk.comapi.routeplan;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.db.OperatorDBCallback.CalcRouteHistoryCallback;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGMainAuxiliaryBridgeController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
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
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class BNRoutePlaner
  extends BNLogicController
{
  public static final int DRIVE_REF_DEFAULT_TIME_DURATION = 1440;
  public static final int DRIVE_REF_DEFAULT_TIME_INTERVAL = 30;
  private static boolean IS_GUIDE_END = false;
  private static final int K_ROUTEPLAN_TIMEOUT = 50000;
  private static final String TAG = "RoutePlan";
  public static boolean bNotBuildCarData;
  public static RoutePlanNode currentDesNode;
  private static volatile BNRoutePlaner mInstance;
  private static MapComponentCallback mMapComponentCallback = null;
  public static int mRouteCnt;
  private static MapComponentCallback mSelectRouteCallback = null;
  public static boolean sIsfetchCarOwnerData;
  private static int sRoutePlanMinDistance = 50;
  private int isComeFromParam = 1;
  private Handler mAsynRouteInfoHandler;
  private String mCalcPrefCarNo;
  private int mCalcPreference = 0;
  private int mCalcRequestID = -1;
  private OperatorDBCallback.CalcRouteHistoryCallback mCalcRouteHistoryCallback;
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
  private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper())
  {
    private void sendMessage(ArrayList<Handler> paramAnonymousArrayList, int paramAnonymousInt)
    {
      paramAnonymousArrayList = paramAnonymousArrayList.iterator();
      while (paramAnonymousArrayList.hasNext())
      {
        Object localObject = (Handler)paramAnonymousArrayList.next();
        if (localObject != null)
        {
          localObject = ((Handler)localObject).obtainMessage();
          ((Message)localObject).what = paramAnonymousInt;
          ((Message)localObject).sendToTarget();
        }
      }
    }
    
    private void sendMessageWithArg(ArrayList<Handler> paramAnonymousArrayList, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousArrayList = paramAnonymousArrayList.iterator();
      while (paramAnonymousArrayList.hasNext())
      {
        Object localObject = (Handler)paramAnonymousArrayList.next();
        if (localObject != null)
        {
          localObject = ((Handler)localObject).obtainMessage();
          ((Message)localObject).what = paramAnonymousInt1;
          ((Message)localObject).arg1 = paramAnonymousInt2;
          ((Message)localObject).sendToTarget();
        }
      }
    }
    
    public void careAbout()
    {
      observe(4099);
      observe(4400);
      observe(4170);
      observe(4173);
      observe(4403);
      observe(4174);
      observe(4175);
      observe(4209);
      observe(4115);
    }
    
    public void handleMessage(Message arg1)
    {
      LogUtil.e("RoutePlan", "wangyang = MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
      switch (???.what)
      {
      }
      for (;;)
      {
        return;
        BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "CancelRoute MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 :" + ???.arg1 + " arg2:" + ???.arg2);
        if (???.arg1 == 0) {
          PerformStatisticsController.peByType(0, "lib_network_server", JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
        }
        if (PerformStatItem.sUserTest)
        {
          if (???.arg1 == 0)
          {
            PerformStatisticsController.peByType(0, "sdk_routeplan_lib_ok", System.currentTimeMillis());
            if (PerformStatItem.sBatchTestNetworkAndServerTime)
            {
              PerformStatisticsController.getInstance().nextBatchTestNetworkAndServer(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime(), 0, true);
              return;
            }
          }
          if ((???.arg1 == 0) && (???.arg2 != 2))
          {
            PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "14", "NaviSDK", "StartRoutePlanBeginWithMultiNavi", PerformStatItem.sRoutePlanWithMultiNaviStart, System.currentTimeMillis());
            PerformStatItem.sPoiToNaviTime8 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("8", "引擎算路到SDK收到消息v2", "NaviSDK", PerformStatItem.sPoiToNaviTime4, PerformStatItem.sPoiToNaviTime8);
          }
          PerformStatItem.sGetEngineCalcDataStart = System.currentTimeMillis();
        }
        LogUtil.e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
        LogUtil.e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- finished");
        if (BNRoutePlaner.this.mRoutePlanModel == null) {
          continue;
        }
        ??? = new ArrayList();
        int n;
        int k;
        Object localObject5;
        int m;
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          RoutePlanTimeUtil.getInstance().resetToCurrentTime();
          n = ???.arg1;
          k = ???.arg2;
          j = 0;
          ??? = new ArrayList();
          localObject5 = new Bundle();
          m = BNRoutePlaner.this.getRoutePlanSubResult((ArrayList)???, (Bundle)localObject5);
          RoutePlanStatItem.getInstance().enntCostTime = Long.valueOf(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
          if (n != 0) {
            break label2322;
          }
          i = -1;
          if (((Bundle)localObject5).containsKey("unRoutePlanID")) {
            i = ((Bundle)localObject5).getInt("unRoutePlanID");
          }
          if ((i != BNRoutePlaner.this.mCalcRequestID) && (i != 0) && (k != 2))
          {
            LogUtil.e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT return unRoutePlanID " + i + " mCalcRequestID " + BNRoutePlaner.this.mCalcRequestID);
            SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "unRoutePlanID " + i + " mCalcRequestID " + BNRoutePlaner.this.mCalcRequestID);
            return;
          }
        }
        if (((Bundle)localObject5).containsKey("enNaviType"))
        {
          BNRoutePlaner.this.mRoutePlanModel.setEnNaviType(((Bundle)localObject5).getInt("enNaviType"));
          if (((Bundle)localObject5).containsKey("enPlanNetMode")) {
            BNRoutePlaner.this.mRoutePlanModel.setRoutePlanNetMode(((Bundle)localObject5).getInt("enPlanNetMode"));
          }
          if (((Bundle)localObject5).containsKey("enComfrom")) {
            BNRoutePlaner.this.mRoutePlanModel.setEnComfrom(((Bundle)localObject5).getInt("enComfrom"));
          }
          BNRoutePlaner.this.statisPreCalcRoute((Bundle)localObject5);
          LogUtil.e("RoutePlan", "MSG_NAVI_ROUTE_PLAN_RESULT planResult: " + n + " isYawing: " + k + " subResult: " + m + "  unRoutePlanID: " + i + "  mCalcRequestID: " + BNRoutePlaner.this.mCalcRequestID + " mRoutePlanModel.getEnComfrom(): " + BNRoutePlaner.this.mRoutePlanModel.getEnComfrom());
          PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt("calc_preference", BNRoutePlaner.this.mCalcPreference);
          BNRoutePlaner.this.mRoutePlanSuccessTime = System.currentTimeMillis();
          localObject5 = BNRoutePlaner.this.mRoutePlanModel.getRouteInput();
          j = 1;
          i = j;
          if (k != 2)
          {
            i = j;
            if (localObject5 != null)
            {
              i = j;
              if (((ArrayList)localObject5).size() > 0)
              {
                i = j;
                if (((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1) != null) {
                  i = ((RoutePlanNode)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).mFrom;
                }
              }
            }
          }
          if ((??? == null) || (((ArrayList)localObject5).size() != ((ArrayList)???).size())) {
            break label1153;
          }
          j = ((ArrayList)???).size() - 1;
          label978:
          if (j < 0) {
            break label1153;
          }
          if ((j != 0) || (!((RoutePlanNode)((ArrayList)localObject5).get(0)).isNodeSettedData())) {
            break label1026;
          }
        }
        for (;;)
        {
          j -= 1;
          break label978;
          BNRoutePlaner.this.mRoutePlanModel.setEnNaviType(0);
          break;
          label1026:
          double d1 = ((Bundle)((ArrayList)???).get(j)).getDouble("x", -2.147483648E9D);
          double d2 = ((Bundle)((ArrayList)???).get(j)).getDouble("y", -2.147483648E9D);
          LogUtil.e("RoutePlan", "GetRoutePlanSubResult routePlanSubResult x; " + d1 + " y: " + d2);
          ((RoutePlanNode)((ArrayList)localObject5).get(j)).setGeoPoint(new GeoPoint((int)(100000.0D * d1), (int)(100000.0D * d2)));
          ((RoutePlanNode)((ArrayList)localObject5).get(j)).setFrom(1);
        }
        label1153:
        if ((??? != null) && (((ArrayList)???).size() > 0) && (((Bundle)((ArrayList)???).get(0)).containsKey("routeCnt"))) {
          BNRoutePlaner.mRouteCnt = ((Bundle)((ArrayList)???).get(0)).getInt("routeCnt");
        }
        BNRoutePlaner.this.mRoutePlanModel.setRouteInput((ArrayList)localObject5);
        if (k != 2)
        {
          if (BNRoutePlaner.currentDesNode == null) {
            BNRoutePlaner.currentDesNode = new RoutePlanNode();
          }
          if ((localObject5 != null) && (((ArrayList)localObject5).size() > 0))
          {
            BNRoutePlaner.currentDesNode.copy((RoutePlanNode)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1));
            BNRoutePlaner.currentDesNode.mFrom = i;
          }
        }
        ??? = new Bundle();
        int j = BNRoutePlaner.getInstance().getRouteInfo(0, (Bundle)???);
        if (j == 0)
        {
          LogUtil.e("RoutePlan", "in navi step route info: error");
          RoutePlanStatItem.getInstance().setErrorCode(5060);
          if (!RoutePlanStatItem.getInstance().hasOnEven())
          {
            RoutePlanStatItem.getInstance().setEngRoutePlanEndTime(Long.valueOf(System.currentTimeMillis()));
            if (RoutePlanStatItem.getInstance().getEntry() == 5) {
              RoutePlanStatItem.getInstance().onEvent();
            }
          }
          if (m != 1) {
            break label1665;
          }
          RoutePlanStatItem.getInstance().setCalcType("3");
          BNRoutePlaner.this.setEngineCalcRouteNetMode(2);
          LogUtil.e("RoutePlan", "statics onevent online to offline");
          sendMessage((ArrayList)???, 1);
          ??? = new BNRoutePlanObserver.FailArg();
          ((BNRoutePlanObserver.FailArg)???).mFailText = JarUtils.getResources().getString(1711669587);
          BNRoutePlaner.this.notifyObservers(1, 21, ???);
          XDVoiceInstructManager.getInstance().setWakeupEnable(true);
          LogUtil.e("XDVoice", "online to offline , XDPlan setEnable(true)");
        }
        for (;;)
        {
          LogUtil.e("RoutePlan", "mRPResultHandlersTemp" + k);
          ??? = ((ArrayList)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject5 = (Handler)((Iterator)???).next();
            LogUtil.e("RoutePlan", "mRPResultHandlersTemp" + ((Handler)localObject5).toString() + k);
          }
          if (j == 1)
          {
            LogUtil.e("RoutePlan", "in navi step route info: part");
            n = BNRoutePlaner.this.getRouteCnt();
            ??? = new ArrayList();
            i = 0;
            while (i < n)
            {
              localObject5 = new Bundle();
              BNRoutePlaner.this.getRouteInfo(i, (Bundle)localObject5);
              ((ArrayList)???).add(localObject5);
              i += 1;
            }
            BNRoutePlaner.this.mRoutePlanModel.parseRouteResultOutline((ArrayList)???);
            break;
          }
          if (j != 2) {
            break;
          }
          LogUtil.e("RoutePlan", "in navi step route info: all");
          BNRoutePlaner.this.mRoutePlanModel.parseRouteResult(BNaviModuleManager.getContext(), (Bundle)???);
          break;
          label1665:
          if (m == 2)
          {
            sendMessage((ArrayList)???, 2);
            BNRoutePlaner.this.setEngineCalcRouteNetMode(3);
            com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel.mIsOfflineToOnline = false;
            RGViewController.getInstance().requestShowExpendView(10, false);
            LogUtil.e("RoutePlan", "statics onevent offline to online");
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410373", "410373");
            RoutePlanStatItem.getInstance().setCalcType("4");
            XDVoiceInstructManager.getInstance().setWakeupEnable(true);
            LogUtil.e("XDVoice", "offline to online , XDPlan setEnable(true)");
          }
          else if (m == 0)
          {
            ??? = RoutePlanStatItem.getInstance().getCalcType();
            if ((!((String)???).equals("4")) && (!((String)???).equals("3"))) {
              if ((BNRoutePlaner.this.mRoutePlanNetMode == 1) || (BNRoutePlaner.this.mRoutePlanNetMode == 3)) {
                RoutePlanStatItem.getInstance().setCalcType("1");
              } else {
                RoutePlanStatItem.getInstance().setCalcType("2");
              }
            }
          }
        }
        if (k == 2)
        {
          sendMessage((ArrayList)???, 3);
          BNRoutePlaner.this.notifyNavEventToOut(3);
          BNRoutePlaner.this.notifyObservers(1, 4, null);
          if ((BNRoutePlaner.this.getEngineCalcRouteNetMode() == 1) || (BNRoutePlaner.this.getEngineCalcRouteNetMode() == 3))
          {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410371", "410371");
            LogUtil.e("RoutePlan", "statics onevent online route plan success");
            if ((BNRoutePlaner.this.getCalcPreference() & 0x40) > 0) {
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410372", "410372");
            }
          }
          i = j;
          if (BNRoutePlaner.getInstance().getEntry() == 2)
          {
            RoutePlanStatItem.getInstance().mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
            LogUtil.e("RoutePlan", "stat test map routecount = " + RoutePlanStatItem.getInstance().mRouteCount);
            i = j;
            if (!RoutePlanStatItem.getInstance().hasOnEven())
            {
              RoutePlanStatItem.getInstance().setStatAll(false);
              RoutePlanStatItem.getInstance().onEvent();
              i = j;
            }
          }
        }
        for (;;)
        {
          if (BNRoutePlaner.this.mRoutePlanSource == 0)
          {
            BNRoutePlaner.access$902(BNRoutePlaner.this, false);
            if ((BNRoutePlaner.this.mCalcRouteHistoryCallback != null) && (BNRoutePlaner.this.mRoutePlanModel != null)) {
              BNRoutePlaner.this.mCalcRouteHistoryCallback.onAddViaRoute(BNRoutePlaner.this.mRoutePlanModel.getRouteInput());
            }
          }
          if (!BNSettingManager.isShowJavaLog()) {
            break;
          }
          SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what + " subResult= " + m + " ret= " + i + " getEngineCalcRouteNetMode= " + BNRoutePlaner.this.getEngineCalcRouteNetMode() + " getIsFromMap= " + BNRoutePlaner.getInstance().getIsFromMap() + " getEntry= " + BNRoutePlaner.getInstance().getEntry());
          return;
          if (PerformStatItem.sUserTest)
          {
            PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "16", "NaviSDK", "GetEngineCalcData", PerformStatItem.sGetEngineCalcDataStart, System.currentTimeMillis());
            PerformStatItem.sRoutePlanSuccessNormalStart = System.currentTimeMillis();
            PerformStatItem.sRoutePlanSuccessNormalFirstStart = System.currentTimeMillis();
          }
          if (BNavigator.getInstance().isNaviBegin())
          {
            sendMessage((ArrayList)???, 4);
            BNRoutePlaner.this.requestMapHandleRPSucess();
          }
          for (;;)
          {
            BNRoutePlaner.this.notifyNavEventToOut(4);
            BNRoutePlaner.this.notifyObservers(1, 2, null);
            break;
            BNRoutePlaner.this.requestMapHandleRPSucess();
            sendMessage((ArrayList)???, 4);
          }
          label2322:
          if (n == 20)
          {
            if (k == 3)
            {
              LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = SLAVE_ROUTE_PLAN_RESULT");
              RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(2);
              if ((BNNaviResultModel.getInstance().isSwitch == 0) || (BNNaviResultModel.getInstance().isSwitch == 1))
              {
                BNNaviResultModel.getInstance().isSwitch = 1;
                i = j;
              }
              else
              {
                BNNaviResultModel.getInstance().isSwitch = 3;
                i = j;
              }
            }
            else if (k == 4)
            {
              LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = MAIN_ROUTE_PLAN_RESULT");
              RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(1);
              if ((BNNaviResultModel.getInstance().isSwitch == 0) || (BNNaviResultModel.getInstance().isSwitch == 1))
              {
                BNNaviResultModel.getInstance().isSwitch = 1;
                i = j;
              }
              else
              {
                BNNaviResultModel.getInstance().isSwitch = 3;
                i = j;
              }
            }
            else if (k == 5)
            {
              LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = VIADUCT_ROUTE_PLAN_RESULT");
              RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(3);
              if ((BNNaviResultModel.getInstance().isSwitch == 0) || (BNNaviResultModel.getInstance().isSwitch == 2))
              {
                BNNaviResultModel.getInstance().isSwitch = 2;
                i = j;
              }
              else
              {
                BNNaviResultModel.getInstance().isSwitch = 3;
                i = j;
              }
            }
            else if (k == 6)
            {
              LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = GROUND_ROUTE_PLAN_RESULT");
              RGMainAuxiliaryBridgeController.getInstance().playMainAuxiliaryBridgeText(4);
              if ((BNNaviResultModel.getInstance().isSwitch == 0) || (BNNaviResultModel.getInstance().isSwitch == 2))
              {
                BNNaviResultModel.getInstance().isSwitch = 2;
                i = j;
              }
              else
              {
                BNNaviResultModel.getInstance().isSwitch = 3;
                i = j;
              }
            }
            else
            {
              i = j;
              if (k == 7)
              {
                LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT arg2 = UNKNOWN_ROUTE_PLAN_RESULT");
                i = j;
              }
            }
          }
          else if (n == 21)
          {
            LogUtil.e("RoutePlan", "MsgDefine.MSG_NAVI_ROUTE_PLAN_RESULT FAIL_MAIN_SLAVE_VIADUCT_INFO");
            RGMainAuxiliaryBridgeController.getInstance().onRoutePlanFail();
            i = j;
          }
          else if (9 == n)
          {
            sendMessage((ArrayList)???, 5);
            ??? = new BNRoutePlanObserver.FailArg();
            ((BNRoutePlanObserver.FailArg)???).mFailType = n;
            BNRoutePlaner.this.notifyObservers(1, 22, ???);
            i = j;
          }
          else if (503 == n)
          {
            ??? = new BNRoutePlanObserver.FailArg();
            ((BNRoutePlanObserver.FailArg)???).mFailType = n;
            BNRoutePlaner.this.notifyObservers(1, 23, ???);
            i = j;
          }
          else
          {
            PerformStatisticsController.peByType(0, "lib_network_server", JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime());
            if (PerformStatItem.sUserTest)
            {
              PerformStatisticsController.peByType(0, "sdk_routeplan_lib_failed", System.currentTimeMillis());
              if (PerformStatItem.sBatchTestNetworkAndServerTime)
              {
                PerformStatisticsController.getInstance().nextBatchTestNetworkAndServer(JNIGuidanceControl.getInstance().getRoutePlanNetWorkTime(), 0, false);
                return;
              }
            }
            if ((108 == n) && (BNRoutePlaner.this.mRoutePlanModel != null) && (NetworkUtils.mConnectState != 0) && (k != 2)) {
              BNRoutePlaner.this.showRouteplanOvertimeDialog();
            }
            ??? = new BNRoutePlanObserver.FailArg();
            ((BNRoutePlanObserver.FailArg)???).mFailType = n;
            ((BNRoutePlanObserver.FailArg)???).mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(n);
            BNRoutePlaner.this.notifyObservers(1, 7, ???);
            if ((BNRoutePlaner.this.mRoutePlanNetMode == 1) || (BNRoutePlaner.this.mRoutePlanNetMode == 3)) {
              RoutePlanStatItem.getInstance().setCalcType("1");
            }
            for (;;)
            {
              if (n == -1) {
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410390", "410390");
              }
              RoutePlanStatItem.getInstance().setErrorCode(n);
              BNRoutePlaner.this.mRoutePlanModel.clearRouteResult();
              if (k != 2) {
                break label3017;
              }
              sendMessage((ArrayList)???, 6);
              BNRoutePlaner.this.notifyNavEventToOut(6);
              ??? = new BNRoutePlanObserver.FailArg();
              ((BNRoutePlanObserver.FailArg)???).mFailText = JarUtils.getResources().getString(1711669586);
              BNRoutePlaner.this.notifyObservers(1, 5, ???);
              i = j;
              break;
              RoutePlanStatItem.getInstance().setCalcType("2");
            }
            label3017:
            sendMessage((ArrayList)???, 7);
            BNRoutePlaner.this.notifyNavEventToOut(7);
            BNRoutePlaner.this.notifyObservers(1, 3, null);
            i = j;
          }
        }
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessage((ArrayList)???, 48);
          LogUtil.e("RoutePlan", "BuildGuideRoute msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
          return;
        }
        if (BNRoutePlaner.this.mAsynRouteInfoHandler != null)
        {
          ??? = BNRoutePlaner.this.mAsynRouteInfoHandler.obtainMessage();
          ((Message)???).what = 4170;
          BNRoutePlaner.this.mAsynRouteInfoHandler.dispatchMessage((Message)???);
        }
        if (BNRoutePlaner.mSelectRouteCallback != null)
        {
          BNRoutePlaner.mSelectRouteCallback.onMapComponentCall(4170, 0, 0, null);
          BNRoutePlaner.access$1202(null);
        }
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessage((ArrayList)???, 33);
          BNRoutePlaner.this.notifyNavEventToOut(33);
          BNRoutePlaner.this.notifyObservers(1, 2, null);
          LogUtil.e("RoutePlan", "MSG_NAVI_Success_BuildGuideRoute msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
          BNRoutePlaner.access$902(BNRoutePlaner.this, false);
          if ((BNRoutePlaner.this.getEngineCalcRouteNetMode() == 2) || (BNRoutePlaner.this.mRoutePlanNetMode == 0))
          {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410371", "410371");
            if ((BNRoutePlaner.this.getCalcPreference() & 0x40) > 0) {
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410372", "410372");
            }
          }
          if (!BNSettingManager.isShowJavaLog()) {
            continue;
          }
          SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
          return;
        }
        if (BNRoutePlaner.this.mAsynRouteInfoHandler != null)
        {
          ??? = BNRoutePlaner.this.mAsynRouteInfoHandler.obtainMessage();
          ((Message)???).what = 4173;
          BNRoutePlaner.this.mAsynRouteInfoHandler.dispatchMessage((Message)???);
        }
        if (BNRoutePlaner.mSelectRouteCallback != null)
        {
          BNRoutePlaner.mSelectRouteCallback.onMapComponentCall(4170, 0, 0, null);
          BNRoutePlaner.access$1202(null);
        }
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessage((ArrayList)???, 34);
          BNRoutePlaner.this.notifyNavEventToOut(34);
          BNRoutePlaner.this.notifyObservers(1, 3, null);
          LogUtil.e("RoutePlan", "MSG_NAVI_Fail_BuildGuideRoute msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
          BNRoutePlaner.access$902(BNRoutePlaner.this, false);
          RoutePlanStatItem.getInstance().setErrorCode(501);
          if (!BNSettingManager.isShowJavaLog()) {
            continue;
          }
          SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
          return;
        }
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessage((ArrayList)???, 49);
          LogUtil.e("RoutePlan", "BuildGuideRoute msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
          if (!BNSettingManager.isShowJavaLog()) {
            continue;
          }
          SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
          return;
        }
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessage((ArrayList)???, 5);
          ??? = new BNRoutePlanObserver.FailArg();
          BNRoutePlaner.this.notifyObservers(1, 22, ???);
          return;
        }
        LogUtil.e("RoutePlan", "MSG_NAVI_KeyWordResult msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
        BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "CancelRoute MSG_NAVI_KeyWordResult arg1 :" + ???.arg1 + " arg2 :" + ???.arg2);
        ??? = new ArrayList();
        for (;;)
        {
          synchronized (BNRoutePlaner.this.mRPResultHandlers)
          {
            ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
            if ((???.arg1 == 0) || (???.arg1 == 2))
            {
              BNRoutePlaner.this.mRoutePlanStopwatch.stop();
              i = (int)BNRoutePlaner.this.mRoutePlanStopwatch.ElapsedTicks();
              SearchStatItem.getInstance().setResponseTime(i);
              if ((BNRoutePlaner.this.mRoutePlanNetMode == 3) || (BNRoutePlaner.this.mRoutePlanNetMode == 1))
              {
                SearchStatItem.getInstance().setSearchType("1");
                SearchStatItem.getInstance().setSearchResult(true);
                SearchStatItem.getInstance().onEvent();
                sendMessage((ArrayList)???, 35);
                BNRoutePlaner.this.notifyObservers(1, 2, null);
              }
            }
            else
            {
              if (!BNSettingManager.isShowJavaLog()) {
                break;
              }
              SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
              return;
            }
          }
          SearchStatItem.getInstance().setSearchType("2");
        }
        LogUtil.e("wy", "MSG_NAVI_TYPE_IPO_ROUTE_PLAN_RESULT msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2);
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "CancelRoute IPO_ROUTE_PLAN_RESULT arg1 :" + ???.arg1 + " arg2 :" + ???.arg2);
        BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
        BNaviModuleManager.removeIPO();
        int i = ???.arg1;
        if (i == 0)
        {
          if (BNLightNaviManager.getInstance().isNaving()) {
            continue;
          }
          sendMessage(BNRoutePlaner.this.mRPResultHandlers, 37);
          BNRoutePlaner.this.notifyNavEventToOut(37);
          BNRoutePlaner.this.notifyObservers(1, 2, null);
          RoutePlanIPOStatItem.getInstance().onEvent();
          return;
        }
        sendMessage(BNRoutePlaner.this.mRPResultHandlers, 38);
        BNRoutePlaner.this.notifyNavEventToOut(38);
        ??? = new BNRoutePlanObserver.FailArg();
        ((BNRoutePlanObserver.FailArg)???).mFailType = ???.arg1;
        ((BNRoutePlanObserver.FailArg)???).mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(((BNRoutePlanObserver.FailArg)???).mFailType);
        BNRoutePlaner.this.notifyObservers(1, 7, ???);
        RoutePlanIPOStatItem.getInstance().setErrorCode(i);
        return;
        ??? = new ArrayList();
        synchronized (BNRoutePlaner.this.mRPResultHandlers)
        {
          ((ArrayList)???).addAll(BNRoutePlaner.this.mRPResultHandlers);
          sendMessageWithArg((ArrayList)???, 39, ???.arg1);
          if ((!BNSettingManager.isShowJavaLog()) || (3 != ???.arg1)) {
            continue;
          }
          SDKDebugFileUtil.get("RoutePlan_debug").add(" msg.arg1 = " + ???.arg1 + " ||| msg.arg2 = " + ???.arg2 + " msg.what=" + ???.what);
          return;
        }
      }
    }
  };
  private boolean mIsCalculatingRoute = false;
  private Handler mNetChangeHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 5555)
      {
        if (1 == paramAnonymousMessage.arg2) {
          BNRoutePlaner.this.triggerNetStatusChange(3);
        }
      }
      else {
        return;
      }
      BNRoutePlaner.this.triggerNetStatusChange(1);
    }
  };
  private ArrayList<Handler> mRPResultHandlers = new ArrayList();
  private RoutePlanModel mRoutePlanModel = null;
  private int mRoutePlanNetMode = 3;
  private int mRoutePlanSource = -1;
  private Stopwatch mRoutePlanStopwatch = new Stopwatch();
  public long mRoutePlanSuccessTime = 0L;
  private String mStrLackDataCities = "";
  
  static
  {
    IS_GUIDE_END = false;
    bNotBuildCarData = false;
    mRouteCnt = 0;
    sIsfetchCarOwnerData = false;
  }
  
  private BNRoutePlaner()
  {
    if (this.mGuidanceControl == null) {}
    try
    {
      this.mGuidanceControl = JNIGuidanceControl.getInstance();
      updateFuncConfigParams();
      getCalcPreference();
      VMsgDispatcher.registerMsgHandler(this.mHandler);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("RoutePlan", localException.toString());
      }
    }
  }
  
  private int calcRoute(int paramInt1, int paramInt2, RoutePlanTime paramRoutePlanTime, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (this.mGuidanceControl == null)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRoute mGuidanceControl is null");
      return -1;
    }
    LogUtil.e("RoutePlan", "calcRoute() hasMrsl=" + paramBoolean + " usReqRouteCnt=" + paramInt2 + ", mrsl=" + paramString + ", time=" + SystemClock.elapsedRealtime());
    this.mIsCalculatingRoute = true;
    this.mRoutePlanSource = paramInt3;
    int i;
    if (BNavigator.getInstance().isNaviBegin())
    {
      boolean bool1 = BNSysLocationManager.getInstance().isGpsEnabled();
      boolean bool2 = BNSysLocationManager.getInstance().isSysLocationValid();
      LogUtil.e("RoutePlan", "calcRoute (1087): --> gpsEnabled: " + bool1 + ", locValid: " + bool2);
      if (!bool1) {
        break label612;
      }
      if (bool2)
      {
        i = 1;
        triggerGPSStatus(i);
        BNRouteGuider.getInstance().setGuideEndType(this.mGuideEndType);
        setGuideEndType(0);
      }
    }
    else
    {
      if (!NetworkUtils.getConnectStatus()) {
        break label618;
      }
      triggerNetStatusChange(3);
    }
    for (;;)
    {
      LogUtil.e("RoutePlan", "calcRoute. mCalcPrefCarNo = " + this.mCalcPrefCarNo);
      if ((this.mCalcPrefCarNo != null) && (this.mCalcPrefCarNo.length() > 0))
      {
        String str1 = this.mCalcPrefCarNo.substring(0, 1);
        String str2 = this.mCalcPrefCarNo.substring(1, this.mCalcPrefCarNo.length());
        LogUtil.e("RoutePlan", "calcRoute. mCalcPrefCarNo = " + this.mCalcPrefCarNo + " || carPA = " + str1 + " || carNum = " + str2);
        this.mGuidanceControl.SetLocalRouteCarInfo(str1, str2, 0);
      }
      LogUtil.e("RoutePlan", "calcRoute isComFromParam -->> " + this.isComeFromParam);
      LogUtil.e("RoutePlan", "calcRoute unPreference -->> " + paramInt1);
      if (!RoutePlanStatItem.getInstance().hasOnEven()) {
        RoutePlanStatItem.getInstance().onEvent();
      }
      RoutePlanStatItem.getInstance().setEngRoutePlanStartTime(Long.valueOf(System.currentTimeMillis()));
      if (sIsfetchCarOwnerData) {
        sIsfetchCarOwnerData = false;
      }
      if (PerformStatItem.sUserTest)
      {
        PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "3", "NaviSDK", "CalcRoutePrepare", PerformStatItem.sCalcRoutePrepareStart, System.currentTimeMillis());
        PerformStatItem.sRoutePlanBeginWithRouteNodeStart = System.currentTimeMillis();
        PerformStatItem.sPoiToNaviTime4 = System.currentTimeMillis();
        PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("4", "SDK到引擎v2", "NaviSDK", PerformStatItem.sPoiToNaviTime3, PerformStatItem.sPoiToNaviTime4);
      }
      PerformStatisticsController.peByType(0, "sdk_start_lib_routeplan", System.currentTimeMillis());
      BNEyeSpyPaperController.getInstance().startRoutePlanMonitor();
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "start CalcRoute");
      paramInt1 = this.mGuidanceControl.CalcRoute(paramInt1, paramInt2, paramRoutePlanTime, this.mDriveRefTimeInterval, this.mDriveRefTimeDuration, paramBoolean, paramString, paramInt3, this.isComeFromParam, bNotBuildCarData, this.mExtSrc);
      RoutePlanStatItem.getInstance().rouEntry = this.isComeFromParam;
      if (bNotBuildCarData) {
        bNotBuildCarData = false;
      }
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "CalcRoute id:" + paramInt1);
      return paramInt1;
      i = 2;
      break;
      label612:
      i = 0;
      break;
      label618:
      triggerNetStatusChange(1);
    }
  }
  
  private void calcRouteAfterNetworkingConfirm(ArrayList<RoutePlanNode> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt)
  {
    this.mRoutePlanStopwatch.start();
    if ((BNOfflineDataManager.getInstance().isNewProvinceDownload()) && (!BNavigator.getInstance().isNaviBegin()) && ((this.mRoutePlanNetMode == 2) || (this.mRoutePlanNetMode == 0)))
    {
      BNaviEngineManager.getInstance().reload();
      BNOfflineDataManager.getInstance().clearNewProvinceDownload();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    RoutePlanNode localRoutePlanNode;
    while (i < paramArrayList.size())
    {
      localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
      if ((localRoutePlanNode != null) && (localRoutePlanNode.isNodeSettedData())) {
        localArrayList.add(localRoutePlanNode);
      }
      i += 1;
    }
    if ((localArrayList == null) || (localArrayList.size() < 2))
    {
      paramArrayList = new BNRoutePlanObserver.FailArg();
      paramArrayList.mFailType = 5000;
      paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
      notifyObservers(1, 6, paramArrayList);
      RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
    }
    do
    {
      return;
      i = setStartPos((RoutePlanNode)localArrayList.get(0));
      if (17 != i)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteAfterNetworkingConfirm setStartPos fail");
        paramArrayList = new BNRoutePlanObserver.FailArg();
        paramArrayList.mFailType = i;
        paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5051);
        notifyObservers(1, 6, paramArrayList);
        RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
        return;
      }
      paramArrayList = new ArrayList();
      int j = localArrayList.size();
      i = 1;
      while (i < j)
      {
        paramArrayList.add(localArrayList.get(i));
        i += 1;
      }
      if (!setDestsPos(paramArrayList))
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteAfterNetworkingConfirm setDestsPos fail");
        paramArrayList = new BNRoutePlanObserver.FailArg();
        paramArrayList.mFailType = 5052;
        paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5052);
        notifyObservers(1, 6, paramArrayList);
        RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
        return;
      }
      if (this.mRoutePlanModel != null)
      {
        this.mRoutePlanModel.setRouteInput(localArrayList);
        this.mRoutePlanModel.clearRouteResult();
      }
      if (paramBoolean1)
      {
        i = 0;
        while (i < paramArrayList.size())
        {
          localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
          if (((localRoutePlanNode.mFrom == 1) || (localRoutePlanNode.mFrom == 8) || (localRoutePlanNode.mFrom == 3) || (localRoutePlanNode.mFrom == 6)) && (this.mCalcRouteHistoryCallback != null)) {
            this.mCalcRouteHistoryCallback.onAddDest(localRoutePlanNode);
          }
          i += 1;
        }
        if (this.mCalcRouteHistoryCallback != null) {
          this.mCalcRouteHistoryCallback.onAddRoute(localArrayList);
        }
      }
      checkRPTimeValid();
      LogUtil.e("mystartflag", "xx1");
      sendMessage(8);
      notifyNavEventToOut(8);
      this.mCalcRequestID = calcRoute(this.mCalcPreference, 0, getRPTime(), paramBoolean2, paramString, paramInt);
      if (BNSettingManager.isShowJavaLog()) {
        SDKDebugFileUtil.get("RoutePlan_debug").add(" RoutePlan calcRoute mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference + "\n stack:\n " + LogUtil.getCallStack());
      }
      LogUtil.e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference);
      LogUtil.e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
      if (this.mCalcRequestID < 0)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteAfterNetworkingConfirm mCalcRequestID < 0");
        paramArrayList = new BNRoutePlanObserver.FailArg();
        paramArrayList.mFailType = 5050;
        paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5050);
        notifyObservers(1, 6, paramArrayList);
        RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
        return;
      }
      notifyObservers(1, 1, null);
    } while ((this.mCalcPreference & 0x4) == 0);
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410370", "410370");
  }
  
  private int checkPointListValidate(ArrayList<RoutePlanNode> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramArrayList.size() > 5)) {
      return 5000;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (RoutePlanNode)paramArrayList.get(i);
      if ((localObject == null) || (!((RoutePlanNode)localObject).isNodeSettedData())) {
        return 5001;
      }
      i += 1;
    }
    this.mStrLackDataCities = "";
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        localObject = new DistrictInfo();
        if (!checkPointDataReady(((RoutePlanNode)paramArrayList.get(i)).mGeoPoint, (DistrictInfo)localObject))
        {
          if (((DistrictInfo)localObject).mId < 0) {
            return 5055;
          }
          this.mStrLackDataCities += ((DistrictInfo)localObject).mName;
        }
        i += 1;
      }
    }
    this.mStrLackDataCities = "全国基础包";
    Object localObject = ((RoutePlanNode)paramArrayList.get(0)).mGeoPoint;
    ArrayList localArrayList = new ArrayList();
    i = 1;
    while (i < paramArrayList.size())
    {
      localArrayList.add(((RoutePlanNode)paramArrayList.get(i)).mGeoPoint);
      i += 1;
    }
    if (!isExistLocalRPData((GeoPoint)localObject, localArrayList))
    {
      paramArrayList = new boolean[35];
      if (getLackOfData(paramArrayList))
      {
        if (StringUtils.isNotEmpty(this.mStrLackDataCities)) {
          this.mStrLackDataCities += "、";
        }
        this.mStrLackDataCities += BNRoutePlanHelper.getLackOfDataCities(paramArrayList);
      }
    }
    if (StringUtils.isNotEmpty(this.mStrLackDataCities)) {
      return 2;
    }
    return 3;
  }
  
  private int checkPointListValidateJustByDistrictID(ArrayList<RoutePlanNode> paramArrayList)
  {
    int j = 2;
    int i;
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramArrayList.size() > 5)) {
      i = 5000;
    }
    do
    {
      return i;
      this.mStrLackDataCities = "";
      if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
      {
        int k = paramArrayList.size();
        i = 0;
        while (i < k)
        {
          DistrictInfo localDistrictInfo = new DistrictInfo();
          localDistrictInfo.mCityId = ((RoutePlanNode)paramArrayList.get(i)).mDistrictID;
          if (!checkPointDataReady(localDistrictInfo))
          {
            if (localDistrictInfo.mId < 0) {
              return 5055;
            }
            this.mStrLackDataCities += localDistrictInfo.mName;
          }
          i += 1;
        }
      }
      this.mStrLackDataCities = "全国基础包";
      i = j;
    } while (StringUtils.isNotEmpty(this.mStrLackDataCities));
    return 3;
  }
  
  private void checkRPTimeValid()
  {
    int i = this.mRoutePlanNetMode;
    if ((i == 0) || (2 == i)) {
      if (RoutePlanTimeUtil.getInstance().getTimeSetState()) {
        RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(true);
      }
    }
    while ((1 != i) && (3 != i))
    {
      return;
      RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(false);
      return;
    }
    RoutePlanTimeUtil.getInstance().setRoutePlanTimeValid(true);
  }
  
  public static void destory()
  {
    if (mInstance != null) {}
    try
    {
      if (mInstance != null) {
        mInstance.dispose();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    LogUtil.e("RoutePlan", "dispose");
    VMsgDispatcher.unregisterMsgHandler(this.mHandler);
    NaviDataEngine.getInstance().removeModel("RoutePlanModel");
    this.mGuidanceControl = null;
    this.mRoutePlanModel = null;
    unregisterNetworkListener();
  }
  
  public static BNRoutePlaner getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BNRoutePlaner();
      }
      return mInstance;
    }
    finally {}
  }
  
  private RoutePlanTime getRPTime()
  {
    return RoutePlanTimeUtil.getInstance().getRoutePlanTime();
  }
  
  private boolean isInternational(ArrayList<RoutePlanNode> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = (RoutePlanNode)paramArrayList.get(0);
      paramArrayList = (RoutePlanNode)paramArrayList.get(paramArrayList.size() - 1);
      localArrayList.add(localObject);
      localArrayList.add(paramArrayList);
      boolean bool2 = true;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < localArrayList.size())
        {
          localObject = (RoutePlanNode)localArrayList.get(i);
          if ((localObject == null) || (!((RoutePlanNode)localObject).isNodeSettedData())) {
            break label189;
          }
          paramArrayList = new GeoPoint();
          localObject = CoordinateTransformUtil.LLE62MC(((RoutePlanNode)localObject).getLongitudeE6(), ((RoutePlanNode)localObject).getLatitudeE6());
          if (localObject != null) {
            paramArrayList = new GeoPoint(((Bundle)localObject).getInt("MCy"), ((Bundle)localObject).getInt("MCx"));
          }
          if ((paramArrayList.getLatitudeE6() == 0) && (paramArrayList.getLongitudeE6() == 0)) {
            bool1 = false;
          }
        }
        else
        {
          return bool1;
        }
        if (!BNaviModuleManager.isInternational(paramArrayList.getLongitudeE6(), paramArrayList.getLatitudeE6(), 0)) {
          return false;
        }
        label189:
        i += 1;
      }
    }
    return false;
  }
  
  private void notifyNavEventToOut(int paramInt)
  {
    if (8 == paramInt) {
      BNEventManager.getInstance().onOtherAction(7, 0, 0, null);
    }
    do
    {
      return;
      if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 33) || (paramInt == 39) || (paramInt == 37))
      {
        BNEventManager.getInstance().onOtherAction(9, 0, 0, null);
        return;
      }
    } while ((paramInt != 34) && (paramInt != 7) && (paramInt != 36) && (paramInt != 6) && (paramInt != 38) && (32 != paramInt));
    BNEventManager.getInstance().onOtherAction(10, 0, 0, null);
  }
  
  private void registerNetworkListener()
  {
    NetworkListener.registerMessageHandler(this.mNetChangeHandler);
  }
  
  private int requestMapHandleRPSucess()
  {
    LogUtil.e("RoutePlan", "requestMapHandleRPSucess");
    if (mMapComponentCallback != null) {
      return mMapComponentCallback.onMapComponentCall(4, 0, 0, null);
    }
    return -1;
  }
  
  private void requestMapHandleRPcancel()
  {
    LogUtil.e("RoutePlan", "requestMapHandleRPcancel");
    if (mMapComponentCallback != null) {
      mMapComponentCallback.onMapComponentCall(32, 0, 0, null);
    }
  }
  
  public static int requestMapLightService(String paramString, int paramInt)
  {
    LogUtil.e("RoutePlan", "requestMapLightService() url=" + paramString);
    if (PerformStatItem.sUserTest)
    {
      PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "5", "NaviEngine", "RoutePlanBeginWithRouteNode", PerformStatItem.sRoutePlanBeginWithRouteNodeStart, System.currentTimeMillis());
      PerformStatItem.sRequestMapLightServiceStart = System.currentTimeMillis();
    }
    if (mMapComponentCallback != null)
    {
      LogUtil.e("RoutePlan", "mMapComponentCallback toString=" + mMapComponentCallback.toString());
      return mMapComponentCallback.onMapComponentCall(1, paramInt, 0, paramString);
    }
    return -1;
  }
  
  private void sendMessage(int paramInt)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.mRPResultHandlers);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Handler)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((Handler)localObject2).obtainMessage();
        ((Message)localObject2).what = paramInt;
        ((Message)localObject2).sendToTarget();
      }
    }
  }
  
  public static void setMapComponentCallback(MapComponentCallback paramMapComponentCallback)
  {
    mMapComponentCallback = paramMapComponentCallback;
  }
  
  private void setPointsToCalcRoute(ArrayList<RoutePlanNode> paramArrayList, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("NAVI_RP_NET_MODE", 3);
    }
    if ((BNOfflineDataManager.getInstance().getNeedReload()) && (!BNavigator.getInstance().isNaviBegin()))
    {
      BNaviEngineManager.getInstance().reload();
      BNOfflineDataManager.getInstance().resetNeedReload();
    }
    paramInt1 = getEntry();
    LogUtil.e("RoutePlan", "setPointsToCalcRoute statistics: entry -->> " + paramInt1);
    RoutePlanStatItem.getInstance().setEntry(paramInt1);
    if (paramInt1 != 2) {
      NaviStatItem.getInstance().setEntry(paramInt1);
    }
    SearchStatItem.getInstance().init();
    RoutePlanIPOStatItem.getInstance().setEntry(paramInt1);
    if (paramInt1 != 2) {
      NaviIPOStatItem.getInstance().setEntry(paramInt1);
    }
    paramInt1 = checkPointListValidate(paramArrayList);
    BNRoutePlanObserver.FailArg localFailArg = new BNRoutePlanObserver.FailArg();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.mRoutePlanNetMode == 3) || (this.mRoutePlanNetMode == 1)) {
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410373", "410373");
      }
      if ((paramArrayList != null) && (paramArrayList.size() >= 2))
      {
        this.mEndNode = ((RoutePlanNode)paramArrayList.get(paramArrayList.size() - 1));
        BNSettingManager.setEndNode(this.mEndNode);
        LogUtil.e("RoutePlan", "endNode route " + this.mEndNode.toString());
      }
      calcRouteAfterNetworkingConfirm(paramArrayList, paramBoolean1, paramBoolean2, paramString, paramInt2);
      return;
      localFailArg.mFailType = paramInt1;
      localFailArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(paramInt1);
      notifyObservers(1, 6, localFailArg);
      RoutePlanStatItem.getInstance().setErrorCode(paramInt1);
      RoutePlanIPOStatItem.getInstance().setErrorCode(paramInt1);
      return;
      if ((i == 0) || (i == 2))
      {
        if (isInternational(paramArrayList)) {
          SetCalcRouteNetMode(3);
        } else {
          SetCalcRouteNetMode(2);
        }
      }
      else if ((i == 1) || (i == 3))
      {
        SetCalcRouteNetMode(3);
        continue;
        LogUtil.e("RoutePlan", "lackdata set to online");
        SetCalcRouteNetMode(1);
        if (!NetworkUtils.getConnectStatus())
        {
          paramArrayList = new BNRoutePlanObserver.FailArg();
          paramArrayList.mFailType = 421;
          paramArrayList.mFailText = BNRoutePlanHelper.transferEngineFailTypeToString(420);
          notifyObservers(1, 7, paramArrayList);
          RoutePlanStatItem.getInstance().setErrorCode(paramInt1);
          return;
          if ((i == 0) || (i == 2)) {
            SetCalcRouteNetMode(2);
          } else if ((i == 1) || (i == 3)) {
            SetCalcRouteNetMode(3);
          }
        }
      }
    }
  }
  
  public static void setSelectRouteCallback(MapComponentCallback paramMapComponentCallback)
  {
    mSelectRouteCallback = paramMapComponentCallback;
  }
  
  private int setStartPos(RoutePlanNode paramRoutePlanNode)
  {
    boolean bool = true;
    if (this.mGuidanceControl == null) {
      return 5090;
    }
    if (paramRoutePlanNode == null) {
      return 5091;
    }
    Object localObject;
    int i;
    if (paramRoutePlanNode.mName != null)
    {
      if (!paramRoutePlanNode.mName.equals("我的位置")) {
        break label242;
      }
      localObject = RoutePlanStatItem.getInstance();
      if (paramRoutePlanNode.mSensorAngle >= 0.0F)
      {
        i = 1;
        ((RoutePlanStatItem)localObject).mHasSensor = i;
      }
    }
    else
    {
      label63:
      LogUtil.e("RoutePlan", "setStartPos. mHasSensor = " + RoutePlanStatItem.getInstance().mHasSensor);
      RoutePlanStatItem.getInstance().mStartFromType = paramRoutePlanNode.mFrom;
      if (paramRoutePlanNode.mLocType != 1) {
        break label252;
      }
      RoutePlanStatItem.getInstance().mCurrLocationType = 1;
      label118:
      long l = System.currentTimeMillis();
      BNSysLocationManager.getInstance().startRecordStarInfos();
      LogUtil.e("BNRoutePlaner startRecordStarInfos cost :", (System.currentTimeMillis() - l) / 1000L + "");
      LogUtil.e("SetStartPos: fAltitude:", paramRoutePlanNode.mAltitude + "");
      localObject = new StringBuilder();
      if (paramRoutePlanNode.mLocType != 1) {
        break label298;
      }
    }
    for (;;)
    {
      LogUtil.e("is GPSLocation:", bool + "");
      return this.mGuidanceControl.SetStartPosNav(paramRoutePlanNode);
      i = 0;
      break;
      label242:
      RoutePlanStatItem.getInstance().mHasSensor = 2;
      break label63;
      label252:
      if (paramRoutePlanNode.mLocType == 2)
      {
        RoutePlanStatItem.getInstance().mCurrLocationType = 2;
        break label118;
      }
      if (paramRoutePlanNode.mLocType == 3)
      {
        RoutePlanStatItem.getInstance().mCurrLocationType = 3;
        break label118;
      }
      RoutePlanStatItem.getInstance().mCurrLocationType = 0;
      break label118;
      label298:
      bool = false;
    }
  }
  
  private void showRouteplanOvertimeDialog()
  {
    final ArrayList localArrayList = this.mRoutePlanModel.getRouteInput();
    BNRoutePlanObserver.ConfirmOTArg localConfirmOTArg = new BNRoutePlanObserver.ConfirmOTArg();
    localConfirmOTArg.mConfirmListener = new BNBaseDialog.OnNaviClickListener()
    {
      public void onClick()
      {
        BNRoutePlaner.this.notifyObservers(5, 17, null);
        BNRoutePlaner.this.calcRouteAfterNetworkingConfirm(localArrayList, false, false, null, 0);
      }
    };
    notifyObservers(5, 16, localConfirmOTArg);
  }
  
  private void unregisterNetworkListener()
  {
    NetworkListener.unRegisterMessageHandler(this.mNetChangeHandler);
  }
  
  public void CancelCalcRoute(int paramInt)
  {
    BNEyeSpyPaperController.getInstance().endRoutePlanMonitor();
    SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_ALL: ", "CancelRoute id :" + paramInt);
    if (this.mGuidanceControl == null) {
      return;
    }
    try
    {
      this.mGuidanceControl.CancelCalcRoute(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void CancelCurCalcRoute()
  {
    CancelCalcRoute(this.mCalcRequestID);
  }
  
  public void EnableRoadCondition(boolean paramBoolean)
  {
    if (this.mGuidanceControl == null) {
      return;
    }
    this.mGuidanceControl.EnableRoadCondition(paramBoolean);
  }
  
  public boolean GetAvoidInfo(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.GetAvoidInfo(paramInt);
  }
  
  public String GetAvoidTips(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return null;
    }
    return this.mGuidanceControl.GetAvoidTips(paramInt);
  }
  
  public boolean GetRouteTollMode(int paramInt1, int paramInt2)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.GetRouteTollMode(paramInt1, paramInt2);
  }
  
  public boolean ManualPlaySound()
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.ManualPlaySound();
  }
  
  public void SetCalcRouteNetMode(int paramInt)
  {
    this.mRoutePlanNetMode = paramInt;
    setEngineCalcRouteNetMode(this.mRoutePlanNetMode);
    SetRouteSpec(false);
    if ((paramInt == 1) || (paramInt == 3)) {
      this.mGuidanceControl.SetCalcRouteNetMode(paramInt);
    }
    while ((paramInt != 2) && (paramInt != 0)) {
      return;
    }
    this.mGuidanceControl.SetCalcRouteNetMode(paramInt);
  }
  
  public void SetRouteSpec(boolean paramBoolean)
  {
    if (this.mGuidanceControl == null) {
      return;
    }
    this.mGuidanceControl.SetRouteSpec(paramBoolean);
  }
  
  public void addRouteResultHandler(Handler paramHandler)
  {
    addRouteResultHandler(paramHandler, false);
  }
  
  public void addRouteResultHandler(Handler paramHandler, boolean paramBoolean)
  {
    if (paramHandler == null) {
      return;
    }
    synchronized (this.mRPResultHandlers)
    {
      if (this.mRPResultHandlers.contains(paramHandler)) {
        return;
      }
    }
    if (paramBoolean) {
      this.mRPResultHandlers.add(0, paramHandler);
    }
    for (;;)
    {
      return;
      this.mRPResultHandlers.add(paramHandler);
    }
  }
  
  public int calcRouteToGetDriveInfo(ArrayList<RoutePlanNode> paramArrayList, boolean paramBoolean)
  {
    if (this.mGuidanceControl == null) {
      return -1;
    }
    if ((BNOfflineDataManager.getInstance().getNeedReload()) && (!BNavigator.getInstance().isNaviBegin()))
    {
      BNaviEngineManager.getInstance().reload();
      BNOfflineDataManager.getInstance().resetNeedReload();
    }
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      paramArrayList = new BNRoutePlanObserver.FailArg();
      paramArrayList.mFailType = 5030;
      paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5030);
      notifyObservers(1, 6, paramArrayList);
      RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
      return -1;
    }
    this.mRoutePlanStopwatch.start();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      RoutePlanNode localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
      if ((localRoutePlanNode != null) && (localRoutePlanNode.isNodeSettedData())) {
        localArrayList.add(localRoutePlanNode);
      }
      i += 1;
    }
    i = setStartPos((RoutePlanNode)localArrayList.get(0));
    if (17 != i)
    {
      paramArrayList = new BNRoutePlanObserver.FailArg();
      paramArrayList.mFailType = i;
      paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5051);
      notifyObservers(1, 6, paramArrayList);
      RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
      return -1;
    }
    paramArrayList = new ArrayList();
    int j = localArrayList.size();
    i = 1;
    while (i < j)
    {
      paramArrayList.add(localArrayList.get(i));
      i += 1;
    }
    if (!setDestsPos(paramArrayList))
    {
      paramArrayList = new BNRoutePlanObserver.FailArg();
      paramArrayList.mFailType = 5052;
      paramArrayList.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5052);
      notifyObservers(1, 6, paramArrayList);
      RoutePlanStatItem.getInstance().setErrorCode(paramArrayList.mFailType);
      return -1;
    }
    LogUtil.e("mystartflag", "xx2");
    sendMessage(8);
    notifyNavEventToOut(8);
    if (this.mRoutePlanModel != null)
    {
      this.mRoutePlanModel.setRouteInput(localArrayList);
      this.mRoutePlanModel.clearRouteResult();
    }
    SetCalcRouteNetMode(1);
    if (paramBoolean) {}
    for (i = calcRoute(16, 0, getRPTime(), false, null, 1);; i = calcRoute(1, 1, getRPTime(), false, null, 1))
    {
      notifyObservers(1, 1, null);
      this.mCalcRequestID = i;
      return i;
    }
  }
  
  public void calcRouteToRouteCustom(ArrayList<RoutePlanNode> paramArrayList)
  {
    if (this.mGuidanceControl == null)
    {
      sendMessage(7);
      notifyNavEventToOut(7);
      return;
    }
    if ((BNOfflineDataManager.getInstance().getNeedReload()) && (!BNavigator.getInstance().isNaviBegin()))
    {
      BNaviEngineManager.getInstance().reload();
      BNOfflineDataManager.getInstance().resetNeedReload();
    }
    int i = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("NAVI_RP_NET_MODE", 3);
    int j = checkPointListValidate(paramArrayList);
    Object localObject = new BNRoutePlanObserver.FailArg();
    switch (j)
    {
    }
    for (;;)
    {
      this.mRoutePlanStopwatch.start();
      localObject = new ArrayList();
      i = 0;
      while (i < paramArrayList.size())
      {
        RoutePlanNode localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
        if ((localRoutePlanNode != null) && (localRoutePlanNode.isNodeSettedData())) {
          ((ArrayList)localObject).add(localRoutePlanNode);
        }
        i += 1;
      }
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = j;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(j);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
      LogUtil.e("RoutePlan", "lackdata set to online");
      SetCalcRouteNetMode(1);
      continue;
      if ((i == 0) || (i == 2)) {
        SetCalcRouteNetMode(2);
      } else if ((i == 1) || (i == 3)) {
        SetCalcRouteNetMode(3);
      }
    }
    i = setStartPos((RoutePlanNode)((ArrayList)localObject).get(0));
    if (17 != i)
    {
      sendMessage(7);
      notifyNavEventToOut(7);
      RoutePlanStatItem.getInstance().setErrorCode(i);
      return;
    }
    paramArrayList = new ArrayList();
    j = ((ArrayList)localObject).size();
    i = 1;
    while (i < j)
    {
      paramArrayList.add(((ArrayList)localObject).get(i));
      i += 1;
    }
    if (!setDestsPos(paramArrayList))
    {
      sendMessage(7);
      notifyNavEventToOut(7);
      RoutePlanStatItem.getInstance().setErrorCode(5052);
      return;
    }
    if (this.mRoutePlanModel != null)
    {
      this.mRoutePlanModel.setRouteInput((ArrayList)localObject);
      this.mRoutePlanModel.clearRouteResult();
    }
    i = calcRoute(1, 1, getRPTime(), false, null, 1);
    this.mCalcRequestID = i;
    if (i == -1)
    {
      sendMessage(7);
      notifyNavEventToOut(7);
      RoutePlanStatItem.getInstance().setErrorCode(5050);
      return;
    }
    notifyObservers(1, 1, null);
  }
  
  public boolean calcRouteWithPB(int paramInt1, int paramInt2, ArrayList<RoutePlanNode> paramArrayList, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if ((PerformStatItem.sUserTest) && (paramArrayOfByte != null)) {
      PerformStatisticsController.getInstance().addDataLog(2110, 1, "CarRoutePlanData", "14", "NaviEngine", "StartRoutePlanBeginWithMultiNavi", paramArrayOfByte.length);
    }
    LogUtil.e("RoutePlan", "calcRouteWithPB() routeDataMode=" + paramInt1 + ", outDataType=" + paramInt2 + ", pbDataLen=" + paramInt4);
    if (this.mGuidanceControl == null)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData mGuidanceControl is null");
      return false;
    }
    BNRoutePlanObserver.FailArg localFailArg = new BNRoutePlanObserver.FailArg();
    int i = getEntry();
    RoutePlanStatItem.getInstance().setEntry(i);
    if (i != 2) {
      NaviStatItem.getInstance().setEntry(i);
    }
    if (paramInt2 == 0)
    {
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < paramArrayList.size())
      {
        RoutePlanNode localRoutePlanNode = (RoutePlanNode)paramArrayList.get(i);
        if ((localRoutePlanNode != null) && (localRoutePlanNode.isNodeSettedData())) {
          localArrayList.add(localRoutePlanNode);
        }
        i += 1;
      }
      if ((localArrayList == null) || (localArrayList.size() < 2))
      {
        localFailArg.mFailType = 5000;
        localFailArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
        notifyObservers(1, 6, localFailArg);
        RoutePlanStatItem.getInstance().setErrorCode(localFailArg.mFailType);
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData navNodeList is null");
        return false;
      }
      i = setStartPos((RoutePlanNode)localArrayList.get(0));
      if (17 != i)
      {
        localFailArg.mFailType = i;
        localFailArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5051);
        notifyObservers(1, 6, localFailArg);
        RoutePlanStatItem.getInstance().setErrorCode(localFailArg.mFailType);
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData setStartPos fail");
        return false;
      }
      paramArrayList = new ArrayList();
      int j = localArrayList.size();
      i = 1;
      while (i < j)
      {
        paramArrayList.add(localArrayList.get(i));
        i += 1;
      }
      if (!setDestsPos(paramArrayList))
      {
        localFailArg.mFailType = 5052;
        localFailArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5052);
        notifyObservers(1, 6, localFailArg);
        RoutePlanStatItem.getInstance().setErrorCode(localFailArg.mFailType);
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData setDestsPos fail");
        return false;
      }
      if (this.mRoutePlanModel != null)
      {
        this.mRoutePlanModel.setRouteInput(localArrayList);
        this.mRoutePlanModel.clearRouteResult();
      }
    }
    for (;;)
    {
      LogUtil.e("mystartflag", "xx4");
      sendMessage(8);
      notifyNavEventToOut(8);
      paramArrayList = new Bundle();
      paramArrayList.putByteArray("pb_data", paramArrayOfByte);
      LogUtil.e("RoutePlan", "calcRouteWithPB: unPreference --> " + paramInt3);
      if (PerformStatItem.sUserTest)
      {
        PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "12", "NaviSDK", "DataHandleAfterLight", PerformStatItem.sDataHandleAfterLightStart, System.currentTimeMillis());
        PerformStatItem.sRoutePlanWithMultiNaviStart = System.currentTimeMillis();
      }
      this.mCalcRequestID = this.mGuidanceControl.CalcRouteWithPB(paramInt1, paramInt2, paramInt3, paramArrayList, paramInt4, this.isComeFromParam);
      RoutePlanStatItem.getInstance().rouEntry = this.isComeFromParam;
      LogUtil.e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID);
      LogUtil.e("RoutePlan", "calcRoute. mCalcPreference = " + this.mCalcPreference);
      LogUtil.e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
      if (this.mCalcRequestID >= 0) {
        break;
      }
      LogUtil.e("RoutePlan", "calcRoute. failed.");
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData mCalcRequestID < 0");
      localFailArg.mFailType = 5050;
      localFailArg.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5050);
      notifyObservers(1, 6, localFailArg);
      return false;
      if (this.mRoutePlanModel != null) {
        this.mRoutePlanModel.clearRouteResult();
      }
    }
    notifyObservers(1, 1, null);
    return true;
  }
  
  public void cancelCalcRouteToResumeGuide()
  {
    CancelCalcRoute(this.mCalcRequestID);
    notifyObservers(1, 4, null);
  }
  
  public void cancleCalcRouteRequest()
  {
    LogUtil.e("RoutePlan", "cancleCalcRouteRequest() mCalcRequestID = " + this.mCalcRequestID);
    notifyObservers(1, 4, null);
    CancelCalcRoute(this.mCalcRequestID);
    sendMessage(32);
    notifyNavEventToOut(32);
    requestMapHandleRPcancel();
  }
  
  public void cancleCalcWhenQuitNavi()
  {
    LogUtil.e("RoutePlan", "cancleCalcRouteRequest() mCalcRequestID = " + this.mCalcRequestID);
    notifyObservers(1, 4, null);
    CancelCalcRoute(this.mCalcRequestID);
    sendMessage(32);
    requestMapHandleRPcancel();
  }
  
  public boolean checkPointDataReady(DistrictInfo paramDistrictInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      DistrictInfo localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(paramDistrictInfo.mCityId);
      bool2 = bool3;
      if (localDistrictInfo != null)
      {
        localDistrictInfo = BNPoiSearcher.getInstance().getParentDistrict(localDistrictInfo.mId);
        if (localDistrictInfo != null) {
          bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(localDistrictInfo.mId);
        }
        bool2 = bool1;
        if (paramDistrictInfo != null)
        {
          paramDistrictInfo.copy(localDistrictInfo);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public boolean checkPointDataReady(GeoPoint paramGeoPoint, DistrictInfo paramDistrictInfo)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramGeoPoint == null) {
      return false;
    }
    boolean bool2 = bool3;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0);
      bool2 = bool3;
      if (paramGeoPoint != null)
      {
        paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId);
        if (paramGeoPoint != null) {
          bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(paramGeoPoint.mId);
        }
        bool2 = bool1;
        if (paramDistrictInfo != null)
        {
          paramDistrictInfo.copy(paramGeoPoint);
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public boolean clearRouteBuffer()
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.ClearRouteBuffer();
  }
  
  public void clearRouteInfoHandler()
  {
    LogUtil.e("dengtianjian", "clearRouteInfoHandler");
    this.mAsynRouteInfoHandler = null;
  }
  
  public String getCalcPrefCarNo()
  {
    return this.mCalcPrefCarNo;
  }
  
  public int getCalcPreference()
  {
    Context localContext = BNaviModuleManager.getContext();
    if (this.mCalcPreference >= 1) {
      return this.mCalcPreference;
    }
    if (localContext != null) {}
    for (this.mCalcPreference = PreferenceHelper.getInstance(localContext).getInt("calc_preference", 1);; this.mCalcPreference = 1) {
      return this.mCalcPreference;
    }
  }
  
  public int getCalcRouteNetMode()
  {
    return this.mRoutePlanNetMode;
  }
  
  public int getComeFrom()
  {
    return this.isComeFromParam;
  }
  
  public Bundle getDriveInfo(int paramInt)
  {
    Object localObject;
    if (this.mGuidanceControl == null) {
      localObject = null;
    }
    Bundle localBundle;
    do
    {
      return (Bundle)localObject;
      localBundle = new Bundle();
      localObject = localBundle;
    } while (this.mGuidanceControl.GetDriveInfo(paramInt, localBundle));
    return null;
  }
  
  public int getEngineCalcRouteNetMode()
  {
    return this.mEngineRoutePlanNetMode;
  }
  
  public int getEntry()
  {
    return this.mEntry;
  }
  
  public String getExtSrc()
  {
    return this.mExtSrc;
  }
  
  public int getGuideEndType()
  {
    return this.mGuideEndType;
  }
  
  public int getGuideSceneType()
  {
    return this.mGuideSceneType;
  }
  
  public Bundle getHomeAndCompanyRouteInfo(RoutePlanNode paramRoutePlanNode1, RoutePlanNode paramRoutePlanNode2, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramRoutePlanNode1 == null) || (!paramRoutePlanNode1.isNodeSettedData()))
    {
      paramRoutePlanNode1 = new BNRoutePlanObserver.FailArg();
      paramRoutePlanNode1.mFailType = 5000;
      paramRoutePlanNode1.mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
      paramRoutePlanNode1 = null;
    }
    ArrayList localArrayList;
    do
    {
      return paramRoutePlanNode1;
      localArrayList = new ArrayList();
      localArrayList.add(paramRoutePlanNode1);
      if ((paramRoutePlanNode2 != null) && (paramRoutePlanNode2.isNodeSettedData())) {
        localArrayList.add(paramRoutePlanNode2);
      }
      if (localArrayList.size() < 2) {
        return null;
      }
      if (this.mGuidanceControl == null) {
        break;
      }
      paramRoutePlanNode2 = new Bundle();
      paramRoutePlanNode1 = paramRoutePlanNode2;
    } while (this.mGuidanceControl.CalcSpecPoiRouteInfo(localArrayList, paramInt1, paramInt2, paramInt3, paramString, paramRoutePlanNode2));
    return null;
  }
  
  public boolean getIsFromMap()
  {
    return this.isComeFromParam == 1;
  }
  
  public boolean getLackOfData(boolean[] paramArrayOfBoolean)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.GetLackOfData(paramArrayOfBoolean);
  }
  
  public int getLineDist2RpNode(LocData paramLocData, boolean paramBoolean)
  {
    RoutePlanNode localRoutePlanNode = null;
    if (this.mRoutePlanModel != null)
    {
      if (paramBoolean) {
        localRoutePlanNode = this.mRoutePlanModel.getStartNode();
      }
    }
    else {
      if ((localRoutePlanNode != null) && (localRoutePlanNode.getLatitudeE6() != Integer.MIN_VALUE) && (localRoutePlanNode.getLongitudeE6() != Integer.MIN_VALUE)) {
        break label64;
      }
    }
    label64:
    while ((paramLocData == null) || (paramLocData.longitude == -1.0D) || (paramLocData.latitude == -1.0D))
    {
      return -1;
      localRoutePlanNode = this.mRoutePlanModel.getEndNode();
      break;
    }
    double d = StringUtils.lineDistance(paramLocData.longitude * 100000.0D, paramLocData.latitude * 100000.0D, localRoutePlanNode.getLongitudeE6(), localRoutePlanNode.getLatitudeE6());
    LogUtil.e("RoutePlan", "getLineDist2RpNode: --> lDist: " + d);
    return (int)d;
  }
  
  public Bundle getMapVehiclePos()
  {
    Bundle localBundle = new Bundle();
    if (this.mGuidanceControl.GetMapVehiclePos(localBundle)) {
      return localBundle;
    }
    return null;
  }
  
  public ArrayList<RoutePlanNode> getRemainedDestList()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.mRoutePlanModel.getRouteInput();
    int m = localArrayList2.size();
    if (m >= 2)
    {
      localArrayList1.clear();
      int i = getRemainedDests();
      if (i >= 0)
      {
        i = m - 1 - i;
        int k = 1;
        int j = i;
        i = k;
        label58:
        if (i >= m) {
          break label113;
        }
        if ((i <= 0) || (j <= 0)) {
          break label88;
        }
        j -= 1;
      }
      for (;;)
      {
        i += 1;
        break label58;
        i = 0;
        break;
        label88:
        localArrayList1.add(new RoutePlanNode((RoutePlanNode)localArrayList2.get(i)));
      }
    }
    label113:
    return localArrayList1;
  }
  
  public int getRemainedDests()
  {
    if (this.mGuidanceControl == null) {}
    int[] arrayOfInt;
    do
    {
      return -1;
      arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
    } while (!this.mGuidanceControl.GetDestsRemained(arrayOfInt));
    return arrayOfInt[0];
  }
  
  public void getRouteBoundRect(ArrayList<Bundle> paramArrayList)
  {
    this.mGuidanceControl.GetRouteBoundRect(paramArrayList);
  }
  
  public int getRouteCnt()
  {
    if (this.mGuidanceControl == null) {
      return 0;
    }
    return this.mGuidanceControl.GetRouteCnt();
  }
  
  public RoutePlanNode getRouteEndNode()
  {
    if (this.mEndNode != null) {
      return this.mEndNode;
    }
    return BNSettingManager.getEndNode();
  }
  
  public int getRouteInfo(int paramInt, Bundle paramBundle)
  {
    if (this.mGuidanceControl == null) {
      return 0;
    }
    return this.mGuidanceControl.GetRouteInfo(paramInt, paramBundle);
  }
  
  public int getRoutePlanNetMode()
  {
    if (this.mRoutePlanModel != null) {
      return this.mRoutePlanModel.getRoutePlanNetMode();
    }
    return -1;
  }
  
  public int getRoutePlanRequestID()
  {
    return this.mCalcRequestID;
  }
  
  public byte[] getRoutePlanResultMapProtoBuf()
  {
    return getRoutePlanResultMapProtoBuf(0);
  }
  
  public byte[] getRoutePlanResultMapProtoBuf(int paramInt)
  {
    Object localObject2 = null;
    Bundle localBundle = new Bundle();
    Object localObject1 = localObject2;
    if (this.mGuidanceControl.GetRoutePlanResultMapProtoBuf(localBundle, paramInt))
    {
      localObject1 = localObject2;
      if (localBundle != null)
      {
        localObject1 = localObject2;
        if (localBundle.containsKey("pb_data")) {
          localObject1 = localBundle.getByteArray("pb_data");
        }
      }
    }
    return (byte[])localObject1;
  }
  
  public int getRoutePlanSessionIDAndMrsl(Bundle paramBundle)
  {
    if (this.mGuidanceControl == null) {}
    while (this.mGuidanceControl.GetRouteSessionIDAndMrsl(paramBundle) != 1) {
      return -1;
    }
    return 0;
  }
  
  public String getRoutePlanSessionIDAndMrsl(String paramString1, String paramString2)
  {
    if (this.mGuidanceControl == null) {
      return null;
    }
    return this.mGuidanceControl.GetRoutePlanSessionIDAndMrsl(paramString1, paramString2);
  }
  
  public int getRoutePlanSource()
  {
    return this.mRoutePlanSource;
  }
  
  public int getRoutePlanSubResult(ArrayList<Bundle> paramArrayList, Bundle paramBundle)
  {
    if (this.mGuidanceControl == null) {
      return -1;
    }
    return this.mGuidanceControl.GetRoutePlanSubResult(paramArrayList, paramBundle);
  }
  
  public void getRouteResultOutline()
  {
    int j = getRouteCnt();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = new Bundle();
      getRouteInfo(i, localBundle);
      localArrayList.add(localBundle);
      i += 1;
    }
    this.mRoutePlanModel.parseRouteResultOutline(localArrayList);
  }
  
  public int getShowPreferenceTap()
  {
    if (this.mGuidanceControl == null) {
      return -1;
    }
    return this.mGuidanceControl.GetShowPreferenceTap();
  }
  
  public int getTMPCalcPreference()
  {
    return this.mCalcPreference;
  }
  
  public String getTRURlParam()
  {
    if (this.mGuidanceControl == null) {
      return null;
    }
    return this.mGuidanceControl.GetTRURlParam();
  }
  
  public Boolean hasAvoidTrafficPreference()
  {
    int i = getCalcPreference();
    LogUtil.e("RoutePlan", "hasAvoidTrafficPreference pre = " + i + " ||| (pre & NE_RoutePlan_Mode.ROUTE_PLAN_MOD_AVOID_TAFFICJAM) = " + (i & 0x10));
    if ((i & 0x10) > 0) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void init(Context paramContext)
  {
    this.mRoutePlanModel = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel"));
    getCalcPreference();
    getCalcPrefCarNo();
    if (NetworkUtils.getConnectStatus()) {
      triggerNetStatusChange(3);
    }
    for (;;)
    {
      registerNetworkListener();
      return;
      triggerNetStatusChange(1);
    }
  }
  
  public boolean isBuildRouteReady(boolean paramBoolean, String paramString)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    paramBoolean = this.mGuidanceControl.isBuildRouteReady(paramBoolean, paramString);
    LogUtil.e("", "   isBuildRouteReady ret : " + paramBoolean);
    return paramBoolean;
  }
  
  public boolean isCalculatingRoute()
  {
    return this.mIsCalculatingRoute;
  }
  
  public boolean isExistLocalRPData(GeoPoint paramGeoPoint, ArrayList<GeoPoint> paramArrayList)
  {
    if (this.mGuidanceControl != null) {
      return this.mGuidanceControl.isExistLocalRPData(paramGeoPoint, paramArrayList);
    }
    return false;
  }
  
  public boolean isGuideEnd()
  {
    return IS_GUIDE_END;
  }
  
  public boolean lightCalcRoute(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    LogUtil.e("RoutePlan", "lightCalcRoute:" + paramInt);
    return this.mGuidanceControl.LightCalcRoute(paramInt, this.mCalcRequestID);
  }
  
  public boolean meetingPreloadRoute(RoutePlanNode paramRoutePlanNode, ArrayList<RoutePlanNode> paramArrayList, int paramInt, Bundle paramBundle)
  {
    if ((this.mGuidanceControl == null) || (paramRoutePlanNode == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return this.mGuidanceControl.MeetingPreloadRoute(paramRoutePlanNode, paramArrayList, paramInt, paramBundle);
  }
  
  public void removeRouteResultHandler(Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    synchronized (this.mRPResultHandlers)
    {
      if (!this.mRPResultHandlers.contains(paramHandler)) {
        return;
      }
    }
    this.mRPResultHandlers.remove(paramHandler);
  }
  
  public boolean selectRoute(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.SelectRoute(paramInt);
  }
  
  public boolean selectRouteForDriving(String paramString)
  {
    LogUtil.e("RoutePlan", "selectRouteForDriving() routeMrsl=" + paramString + ", time=" + SystemClock.elapsedRealtime());
    int i;
    if (this.mGuidanceControl != null)
    {
      i = this.mGuidanceControl.SelectRouteWithMrsl(paramString);
      LogUtil.e("RoutePlan", "selectRouteForDriving() routeIndex=" + i);
    }
    return i >= 0;
  }
  
  public int selectRouteWithMrsl(String paramString)
  {
    if (PerformStatItem.sUserTest)
    {
      PerformStatItem.sRoutePageToNaviTime3 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("3", "适配层到SDK", "NaviSDK", PerformStatItem.sRoutePageToNaviTime2, PerformStatItem.sRoutePageToNaviTime3);
    }
    LogUtil.e("RoutePlan", "selectRouteWithMrsl() routeMrsl=" + paramString + ", time=" + SystemClock.elapsedRealtime());
    int i = this.mGuidanceControl.SelectRouteWithMrsl(paramString);
    LogUtil.e("RoutePlan", "selectRouteWithMrsl() routeIndex=" + i);
    if (i >= 0)
    {
      paramString = new Bundle();
      int j = getInstance().getRouteInfo(i, paramString);
      LogUtil.e("RoutePlan", "selectRouteWithMrsl() ret=" + j);
      if (j == 2) {
        this.mRoutePlanModel.parseRouteResult(BNaviModuleManager.getContext(), paramString);
      }
    }
    return i;
  }
  
  public void setCalcPrefCarNo(String paramString)
  {
    this.mCalcPrefCarNo = paramString;
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410360", "410360");
  }
  
  public void setCalcPrference(int paramInt)
  {
    this.mCalcPreference = paramInt;
    if (this.mCalcPreference == 0) {
      this.mCalcPreference = 1;
    }
    PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt("calc_preference", this.mCalcPreference);
  }
  
  public void setCalcRouteHistoryCallback(OperatorDBCallback.CalcRouteHistoryCallback paramCalcRouteHistoryCallback)
  {
    this.mCalcRouteHistoryCallback = paramCalcRouteHistoryCallback;
  }
  
  public void setComeFrom(int paramInt)
  {
    this.isComeFromParam = paramInt;
  }
  
  public boolean setDestsPos(ArrayList<RoutePlanNode> paramArrayList)
  {
    if ((this.mGuidanceControl == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("setDestsPos() --> endNode.mFromType = ");
      if (paramArrayList.get(i) == null)
      {
        localObject = "null";
        label57:
        localStringBuilder = localStringBuilder.append(localObject).append(", endNode.mUID = ");
        if (paramArrayList.get(i) != null) {
          break label123;
        }
      }
      label123:
      for (Object localObject = "null";; localObject = ((RoutePlanNode)paramArrayList.get(i)).mUID)
      {
        LogUtil.e("JNIGuidanceControl", (String)localObject);
        i += 1;
        break;
        localObject = Integer.valueOf(((RoutePlanNode)paramArrayList.get(i)).mFrom);
        break label57;
      }
    }
    return this.mGuidanceControl.SetDestsPosNav(paramArrayList);
  }
  
  public void setDriveRefTimeParams(int paramInt1, int paramInt2)
  {
    this.mDriveRefTimeInterval = paramInt1;
    this.mDriveRefTimeDuration = paramInt2;
  }
  
  public void setEngineCalcRouteNetMode(int paramInt)
  {
    this.mEngineRoutePlanNetMode = paramInt;
  }
  
  public void setEntry(int paramInt)
  {
    this.mEntry = paramInt;
  }
  
  public void setExtSrc(String paramString)
  {
    this.mExtSrc = paramString;
  }
  
  public void setGuideEndType(int paramInt)
  {
    this.mGuideEndType = paramInt;
  }
  
  public void setGuideSceneType(int paramInt)
  {
    this.mGuideSceneType = paramInt;
  }
  
  public void setIsChangeBackground(int paramInt)
  {
    this.mGuidanceControl.SetIsChangeBackgroun(paramInt);
  }
  
  public void setIsGuideEnd(boolean paramBoolean)
  {
    IS_GUIDE_END = paramBoolean;
  }
  
  public void setIsMrslRoute(boolean paramBoolean, String paramString)
  {
    if (this.mGuidanceControl == null) {
      return;
    }
    this.mGuidanceControl.SetIsMrslRoute(paramBoolean, paramString);
  }
  
  public boolean setNaviCalcResultSpeak(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    return this.mGuidanceControl.SetNaviCaclResultSpeak(paramInt);
  }
  
  public void setNaviPVStat(boolean paramBoolean)
  {
    if (this.mGuidanceControl == null) {
      return;
    }
    this.mGuidanceControl.SetNaviPVStat(true);
  }
  
  public void setPointsToCalcRoute(ArrayList<RoutePlanNode> paramArrayList)
  {
    setPointsToCalcRoute(paramArrayList, true, -1, false, null, 1);
  }
  
  public void setPointsToCalcRoute(ArrayList<RoutePlanNode> paramArrayList, int paramInt)
  {
    setPointsToCalcRoute(paramArrayList, true, -1, false, null, paramInt);
  }
  
  public void setPointsToCalcRoute(ArrayList<RoutePlanNode> paramArrayList, int paramInt, boolean paramBoolean, String paramString)
  {
    setPointsToCalcRoute(paramArrayList, true, paramInt, paramBoolean, paramString, 1);
  }
  
  public void setPointsToCalcRoute(ArrayList<RoutePlanNode> paramArrayList, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    if (PerformStatItem.sUserTest)
    {
      PerformStatItem.sPoiToNaviTime3 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("3", "适配层到SDKv2", "NaviSDK", PerformStatItem.sPoiToNaviTime2, PerformStatItem.sPoiToNaviTime3);
    }
    setPointsToCalcRoute(paramArrayList, true, paramInt1, paramBoolean, paramString, paramInt2);
  }
  
  public void setPointsToCalcRouteForMap(ArrayList<RoutePlanNode> paramArrayList, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    if (PerformStatItem.sUserTest) {
      PerformStatItem.sCalcRoutePrepareStart = System.currentTimeMillis();
    }
    if (getEntry() == 31) {
      UserOPController.getInstance().add("2.g.1");
    }
    int j = 0;
    Object localObject = paramArrayList.iterator();
    do
    {
      i = j;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((RoutePlanNode)((Iterator)localObject).next()).mFrom != 2);
    int i = 1;
    LogUtil.e("RoutePlan", "stat test stopWatch start");
    this.mRoutePlanStopwatch.start();
    if (i == 0)
    {
      setPointsToCalcRoute(paramArrayList, false, paramInt1, paramBoolean, paramString, paramInt2);
      return;
    }
    i = paramInt1;
    if (paramInt1 == -1) {
      i = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt("NAVI_RP_NET_MODE", 3);
    }
    SearchStatItem.getInstance().init();
    paramInt1 = getEntry();
    RoutePlanStatItem.getInstance().setEntry(paramInt1);
    if (paramInt1 != 2) {
      NaviStatItem.getInstance().setEntry(paramInt1);
    }
    paramInt1 = checkPointListValidateJustByDistrictID(paramArrayList);
    localObject = new BNRoutePlanObserver.FailArg();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((BNOfflineDataManager.getInstance().getNeedReload()) && (!BNavigator.getInstance().isNaviBegin()))
      {
        BNaviEngineManager.getInstance().reload();
        BNOfflineDataManager.getInstance().resetNeedReload();
      }
      if ((BNOfflineDataManager.getInstance().isNewProvinceDownload()) && ((this.mRoutePlanNetMode == 2) || (this.mRoutePlanNetMode == 0)))
      {
        BNaviEngineManager.getInstance().reload();
        BNOfflineDataManager.getInstance().clearNewProvinceDownload();
      }
      if ((paramArrayList != null) && (paramArrayList.size() >= 2)) {
        break;
      }
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = 5000;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5000);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = paramInt1;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(paramInt1);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
      if ((i == 0) || (i == 2))
      {
        SetCalcRouteNetMode(2);
      }
      else if ((i == 1) || (i == 3))
      {
        SetCalcRouteNetMode(3);
        continue;
        LogUtil.e("RoutePlan", "lackdata set to online");
        SetCalcRouteNetMode(1);
        continue;
        if ((i == 0) || (i == 2)) {
          SetCalcRouteNetMode(2);
        } else if ((i == 1) || (i == 3)) {
          SetCalcRouteNetMode(3);
        }
      }
    }
    paramInt1 = setStartPos((RoutePlanNode)paramArrayList.get(0));
    if (17 != paramInt1)
    {
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = paramInt1;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5051);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    i = paramArrayList.size();
    paramInt1 = 1;
    while (paramInt1 < i)
    {
      localArrayList.add(paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    if (!setDestsPos(localArrayList))
    {
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = 5052;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5052);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 2))
    {
      this.mEndNode = ((RoutePlanNode)paramArrayList.get(paramArrayList.size() - 1));
      BNSettingManager.setEndNode(this.mEndNode);
      LogUtil.e("RoutePlan", "endNode route " + this.mEndNode.toString());
    }
    if (this.mRoutePlanModel != null)
    {
      this.mRoutePlanModel.setRouteInput(paramArrayList);
      this.mRoutePlanModel.clearRouteResult();
    }
    sendMessage(8);
    notifyNavEventToOut(8);
    this.mCalcRequestID = calcRoute(this.mCalcPreference, 0, getRPTime(), paramBoolean, paramString, paramInt2);
    if (BNSettingManager.isShowJavaLog()) {
      SDKDebugFileUtil.get("RoutePlan_debug").add(" RoutePlan calcRoute mCalcRequestID = " + this.mCalcRequestID + "   mCalcPreference = " + this.mCalcPreference + "\n stack:\n " + LogUtil.getCallStack());
    }
    LogUtil.e("RoutePlan", "calcRoute. mCalcRequestID = " + this.mCalcRequestID + " mCalcPreference = " + this.mCalcPreference);
    LogUtil.e("MTmark", "[LOG][MTmark][RoutePlan][" + System.currentTimeMillis() + "] -- start");
    if (this.mCalcRequestID < 0)
    {
      ((BNRoutePlanObserver.FailArg)localObject).mFailType = 5050;
      ((BNRoutePlanObserver.FailArg)localObject).mFailText = BNRoutePlanHelper.transferGeneralFailTypeToString(5050);
      notifyObservers(1, 6, localObject);
      RoutePlanStatItem.getInstance().setErrorCode(((BNRoutePlanObserver.FailArg)localObject).mFailType);
      return;
    }
    notifyObservers(1, 1, null);
  }
  
  public void setRouteInfoHandler(Handler paramHandler)
  {
    LogUtil.e("dengtianjian", "setRouteInfoHandler");
    this.mAsynRouteInfoHandler = paramHandler;
  }
  
  public void setRoutePlanNetMode(int paramInt)
  {
    if (this.mRoutePlanModel != null) {
      this.mRoutePlanModel.setRoutePlanNetMode(paramInt);
    }
  }
  
  public void setRoutePlanStatistcsUrl(String paramString)
  {
    if (this.mGuidanceControl != null) {
      this.mGuidanceControl.SetRoutePlanStatistcsUrl(paramString);
    }
  }
  
  public void showReCalRouteProgressDialog()
  {
    LogUtil.e("RoutePlan", "showReCalRouteProgressDialog");
    notifyObservers(1, 1, null);
  }
  
  public boolean startDrivingCar()
  {
    if (this.mGuidanceControl != null) {
      return this.mGuidanceControl.StartDrivingCar();
    }
    return false;
  }
  
  public void statisPreCalcRoute(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      return;
      i = 0;
      if (paramBundle.containsKey("enPreCalcRouteResult")) {
        i = paramBundle.getInt("enPreCalcRouteResult");
      }
      LogUtil.e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + i);
    } while (i <= 1);
    double d = -1.0D;
    if (paramBundle.containsKey("dDist")) {
      d = paramBundle.getDouble("dDist");
    }
    long l = -1L;
    if (paramBundle.containsKey("nTickInterval")) {
      l = paramBundle.getLong("nTickInterval");
    }
    int j = -1;
    if (paramBundle.containsKey("enLocationType")) {
      j = paramBundle.getInt("enLocationType");
    }
    if (LogUtil.LOGGABLE) {
      LogUtil.e("RoutePlan", "statisPreCalcRoute   enPreCalcRouteResult=" + i + ", dDist=" + d + ", nTickInterval=" + l + ", enLocationType=" + j);
    }
    UserOPController localUserOPController = UserOPController.getInstance();
    if (i == 2) {}
    for (paramBundle = "2.g.2";; paramBundle = "2.g.3")
    {
      localUserOPController.add(paramBundle, String.valueOf(j), String.valueOf(l), String.valueOf(d));
      return;
    }
  }
  
  public boolean stopDrivingCar()
  {
    if (this.mGuidanceControl != null) {
      return this.mGuidanceControl.StopDrivingCar();
    }
    return false;
  }
  
  public void stopWatchRoutePlanStat()
  {
    RoutePlanStatItem.getInstance().setRouPlanDetailViewShowTime(Long.valueOf(System.currentTimeMillis()));
  }
  
  public void triggerGPSStatus(int paramInt)
  {
    if (this.mGuidanceControl != null)
    {
      LogUtil.e("RoutePlan", "triggerGPSStatus (2739): eGPSStatus --> " + paramInt);
      this.mGuidanceControl.TriggerGPSStatus(paramInt);
    }
  }
  
  public boolean triggerNetStatusChange(int paramInt)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    try
    {
      boolean bool = this.mGuidanceControl.TriggerNetStatusChange(paramInt);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean triggerPressureChange(float paramFloat)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    try
    {
      boolean bool = this.mGuidanceControl.triggerPressureChange(paramFloat);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean triggerSensorAngle(double paramDouble1, double paramDouble2)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    try
    {
      boolean bool = this.mGuidanceControl.triggerSensorAngle(paramDouble1, paramDouble2);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean triggerStartSensorData(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mGuidanceControl == null) {
      return false;
    }
    try
    {
      boolean bool = this.mGuidanceControl.TriggerStartSensorData(paramFloat1, paramFloat2, paramFloat3);
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void updateCloudTrafficInfo(int paramInt, long paramLong)
  {
    this.mGuidanceControl.UpdateCloudTrafficInfo(paramInt, String.valueOf(paramLong));
  }
  
  public void updateFuncConfigParams()
  {
    boolean bool = RGMultiRouteModel.getInstance().isEnable();
    int[] arrayOfInt = RGMultiRouteModel.getInstance().getPstLabelDis();
    int i = RGMultiRouteModel.getInstance().getLastMile();
    try
    {
      JNIGuidanceControl localJNIGuidanceControl = this.mGuidanceControl;
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        localJNIGuidanceControl.setFuncConfigParams(bool, arrayOfInt, i);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean updateRouteRoadCondation(int paramInt)
  {
    return this.mGuidanceControl.UpdateRouteRoadCondation(paramInt);
  }
  
  public static abstract interface MapComponentCallback
  {
    public static final int Type_Request_Map_Light_Service = 1;
    
    public abstract int onMapComponentCall(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeplan/BNRoutePlaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */