package com.baidu.baidunavis;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
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
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.debug.BNEyeSpyPaperController;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class BaiduNaviManager
{
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
  public static volatile boolean sIsBaseEngineInitial;
  public static volatile boolean sIsBaseEngineInitialized;
  public static boolean sIsEngineInitialFailed;
  public static volatile boolean sIsNaviSoLoadSuccess = false;
  private boolean hasDismiss = false;
  public boolean mIsMapUseGPS = false;
  public long mLastestQuitNaviTime = -1L;
  private Handler mMapHandler = null;
  private Handler mNaviHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      if (1 == paramAnonymousMessage.what) {}
      do
      {
        return;
        if (2 == paramAnonymousMessage.what)
        {
          BaiduNaviManager localBaiduNaviManager = BaiduNaviManager.this;
          if (paramAnonymousMessage.arg1 == 1) {}
          for (;;)
          {
            localBaiduNaviManager.mIsMapUseGPS = bool;
            NavLogUtils.e(BaiduNaviManager.TAG, "handleMessage() mIsMapUseGPS=" + BaiduNaviManager.this.mIsMapUseGPS + ", sIsBaseEngineInitialized=" + BaiduNaviManager.sIsBaseEngineInitialized);
            if (!BaiduNaviManager.sIsBaseEngineInitialized) {
              break;
            }
            NavLocationManager.getInstance().notifyMapGPSEnable(BaiduNaviManager.this.mIsMapUseGPS);
            return;
            bool = false;
          }
        }
      } while (3 != paramAnonymousMessage.what);
      NavLogUtils.e(BaiduNaviManager.TAG, "handleMessage() selectroute.timeout");
      NavMapAdapter.getInstance().dismissMProgressDialog();
    }
  };
  
  static
  {
    sIsBaseEngineInitial = false;
    sIsBaseEngineInitialized = false;
    sIsEngineInitialFailed = false;
  }
  
  private boolean calcRouteForPBDataInner(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, Bundle paramBundle)
  {
    if (paramRouteNode1 != null) {
      NavLogUtils.e(TAG, "calcRouteForPBDataInner() unPreference=" + paramInt1 + ", startCityID=" + paramRouteNode1.mProvinceID + "-" + paramRouteNode1.mCityID + ", from=" + paramRouteNode1.mFromType + ", gpsAngle=" + paramRouteNode1.mGPSAngle + ", gpsAccu=" + paramRouteNode1.mGPSAccuracy + ", altitude=" + paramRouteNode1.mAltitude);
    }
    if (paramRouteNode2 != null) {
      NavLogUtils.e(TAG, "calcRouteForPBDataInner() endCityID=" + paramRouteNode2.mProvinceID + "-" + paramRouteNode2.mCityID);
    }
    if ((paramRouteNode2 != null) && (paramRouteNode2.mFromType != 99) && (NavCommonFuncController.getInstance().isFastDoubleClick()))
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteForPBDataInner isFastDoubleClick or mFromType:" + paramRouteNode2.mFromType);
      return false;
    }
    if (31 == paramInt6)
    {
      NavLogUtils.e(TAG, "本次算路为前置算路的话，重置防止重复算路时间");
      NavCommonFuncController.getInstance().resetLastDoubleClickTime();
    }
    if ((paramRouteNode2 != null) && (NavCommonFuncController.getInstance().checkFactoryMode(paramRouteNode2.mName)))
    {
      NavCommonFuncController.getInstance().drivingToolAction();
      return false;
    }
    if (NavUserBehaviour.getInstance() != null) {
      NavUserBehaviour.getInstance().resetNaviStatItem();
    }
    int i;
    if ((paramBundle != null) && (paramBundle.containsKey("src_open_api")))
    {
      BNRoutePlaner.getInstance().setExtSrc(paramBundle.getString("src_open_api"));
      NavSearchController.getInstance().setRpEntry(paramInt6);
      i = paramInt6;
      paramInt6 = i;
      if (paramRouteNode2 != null)
      {
        if (paramRouteNode2.mFromType != 4) {
          break label461;
        }
        paramInt6 = 20;
        BNRoutePlaner.getInstance().setComeFrom(20);
      }
    }
    for (;;)
    {
      NavSearchController.getInstance().setIsFromMap(true);
      NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
      NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
      NavRoutePlanModel.getInstance().setViaNodes(paramList);
      NavRoutePlanModel.getInstance().setPreference(paramInt1);
      NavRoutePlanModel.getInstance().setDriveRefTime(paramInt2, paramInt3);
      NavRoutePlanModel.getInstance().setStrategy(paramInt4);
      NavRoutePlanModel.getInstance().setRouteInfoStatus(paramInt5);
      NavRoutePlanModel.getInstance().mCarPANumber = paramString;
      NavRoutePlanModel.getInstance().setEntry(paramInt6);
      NavRoutePlanModel.getInstance().setExtBundle(paramBundle);
      NavRoutePlanController.getInstance().calcRouteForPBData(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramInt6);
      return true;
      if (paramInt6 == 7) {
        break;
      }
      BNRoutePlaner.getInstance().setExtSrc(null);
      break;
      label461:
      paramInt6 = i;
      if (paramRouteNode2.mFromType == 5)
      {
        paramInt6 = 21;
        BNRoutePlaner.getInstance().setComeFrom(21);
      }
    }
  }
  
  private void calcRouteToNaviRouteInner(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bundle paramBundle)
  {
    if (paramRouteNode1 != null) {
      NavLogUtils.e(TAG, "calcRouteToNaviRouteInner() , from=" + paramRouteNode1.mFromType + ", gpsAngle=" + paramRouteNode1.mGPSAngle + ", gpsAccu=" + paramRouteNode1.mGPSAccuracy);
    }
    if (NavCommonFuncController.getInstance().isFastDoubleClick())
    {
      NavLogUtils.e(TAG, "不允许短频内进行重复算路,直接返回");
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteToNaviRouteInner isFastDoubleClick");
    }
    label312:
    do
    {
      do
      {
        return;
        NavSearchController.getInstance().setIsFromMap(false);
      } while ((paramRouteNode2 != null) && (NavCommonFuncController.getInstance().checkFactoryMode(paramRouteNode2.mName)));
      if ((paramBundle != null) && (paramBundle.containsKey("src_open_api"))) {
        BNRoutePlaner.getInstance().setExtSrc(paramBundle.getString("src_open_api"));
      }
      for (;;)
      {
        NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
        NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
        NavRoutePlanModel.getInstance().setViaNodes(paramList);
        NavRoutePlanModel.getInstance().setPreference(paramInt1);
        NavRoutePlanModel.getInstance().setDriveRefTime(paramInt2, paramInt3);
        NavRoutePlanModel.getInstance().setStrategy(paramInt4);
        NavRoutePlanModel.getInstance().setEntry(paramInt5);
        NavRoutePlanModel.getInstance().setExtBundle(paramBundle);
        if (paramRouteNode1 != null)
        {
          paramBundle = paramRouteNode1.mGeoPoint;
          paramBundle = new GeoPoint(paramBundle.getLongitudeE6(), paramBundle.getLatitudeE6());
          NavPoiController.getInstance().setMyPositionGeo(paramBundle);
        }
        if ((paramRouteNode1 == null) || (paramRouteNode1.mFromType != 2)) {
          break label312;
        }
        NavSearchController.getInstance().setIsFromMap(true);
        if ((paramRouteNode1.mName == null) || (paramRouteNode1.mName.length() <= 0)) {
          break;
        }
        NavRoutePlanController.getInstance().calcRouteToNaviRoute(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, 0, "", paramInt5);
        return;
        BNRoutePlaner.getInstance().setExtSrc(null);
      }
      int i = 0;
      while ((paramList != null) && (i < paramList.size()))
      {
        paramBundle = (RouteNode)paramList.get(i);
        if ((paramBundle != null) && (paramBundle.mFromType == 2))
        {
          NavSearchController.getInstance().setIsFromMap(true);
          if ((paramBundle.mName != null) && (paramBundle.mName.length() > 0))
          {
            NavLogUtils.e(TAG, "calcRouteToNaviRouteInner() search via route node. name=" + paramBundle.mName + ", viaIndex=" + i);
            NavRoutePlanController.getInstance().calcRouteToNaviRoute(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, 0, "", paramInt5);
            return;
          }
        }
        i += 1;
      }
      if ((paramRouteNode2 == null) || (paramRouteNode2.mFromType != 2)) {
        break;
      }
      NavSearchController.getInstance().setIsFromMap(true);
    } while ((paramRouteNode2.mName == null) || (paramRouteNode2.mName.length() <= 0));
    NavRoutePlanController.getInstance().calcRouteToNaviRoute(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, 0, "", paramInt5);
    return;
    NavRoutePlanController.getInstance().calcRouteToNaviRoute(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static BaiduNaviManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new BaiduNaviManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static boolean isNaviSoLoadSuccess()
  {
    return sIsNaviSoLoadSuccess;
  }
  
  private void searchByKeyForPBData(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    NavSearchController.getInstance().searchByKeyForPBData(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private boolean ttsActionInner(Bundle paramBundle)
  {
    boolean bool = true;
    NavLogUtils.e(TAG, "ttsActionInner");
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while ((!sIsBaseEngineInitialized) || (paramBundle == null)) {
      return false;
    }
    Object localObject1 = "unknown";
    Object localObject2 = "unknown";
    String str = "openapi";
    if (paramBundle.containsKey("action")) {
      localObject1 = paramBundle.getString("action");
    }
    if (paramBundle.containsKey("ypid")) {
      localObject2 = paramBundle.getString("ypid");
    }
    if (paramBundle.containsKey("entry")) {
      str = paramBundle.getString("entry");
    }
    NavLogUtils.e(TAG, "ttsAction() action=" + (String)localObject1 + ", ypid=" + (String)localObject2 + ", entry=" + str);
    NavCommonFuncController.getInstance().setVoiceEnter(str);
    localObject2 = NavCommonFuncModel.getInstance().getActivity();
    if ((localObject1 == null) || (((String)localObject1).length() == 0) || (localObject2 == null))
    {
      paramBundle = TAG;
      localObject1 = new StringBuilder().append("ttsAction() activity=null?");
      if (localObject2 == null) {}
      for (;;)
      {
        NavLogUtils.e(paramBundle, bool);
        return false;
        bool = false;
      }
    }
    if ("voicemain".equals(localObject1))
    {
      NavLogUtils.e(TAG, "ttsAction() start VoiceMain Page.");
      NavCommonFuncController.getInstance().setExternalCall(true, paramBundle);
    }
    for (;;)
    {
      return true;
      if ("download".equals(localObject1))
      {
        NavLogUtils.e(TAG, "ttsAction() start VoiceMain Page.");
        if (isNaviBegin()) {
          return true;
        }
      }
      else if ("record".equals(localObject1))
      {
        NavLogUtils.e(TAG, "ttsAction() start VoiceRecord Page.");
      }
    }
  }
  
  public void addRoutePlanSuccessLog(long paramLong)
  {
    NavCommonFuncController.getInstance().addRoutePlanSuccessLog(paramLong);
  }
  
  public void addTrimMemoryStat()
  {
    NavCommonFuncController.getInstance().addTrimMemoryStat();
  }
  
  public boolean calcRouteForPBData(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6)
  {
    return calcRouteForPBData(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramInt6, null);
  }
  
  public boolean calcRouteForPBData(final RouteNode paramRouteNode1, final RouteNode paramRouteNode2, final List<RouteNode> paramList, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString, final int paramInt6, final Bundle paramBundle)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("calcRouteForPBData() --> endNode.mFromType = ");
    Object localObject;
    if (paramRouteNode2 == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append(localObject).append(", endNode.mUID = ");
      if (paramRouteNode2 != null) {
        break label322;
      }
      localObject = "null";
      label53:
      NavLogUtils.e(str, (String)localObject + ", entry=" + paramInt6);
      NaviRecoveryModel.getInstance().setHasCalcRoute(true);
      if (paramInt6 == 7) {
        break label334;
      }
      paramInt1 = NavMapAdapter.getInstance().getPreferValue();
      if (paramInt1 != 0) {
        break label331;
      }
      paramInt1 = NavMapAdapter.getInstance().onGetLastPreferValue();
      NavMapAdapter.getInstance().setPreferValue(paramInt1);
    }
    for (;;)
    {
      NavLogUtils.e(TAG, "routesort calroute prefer " + paramInt1);
      NavSearchController.getInstance().setIsFromMap(true);
      NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
      NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
      NavRoutePlanModel.getInstance().setViaNodes(paramList);
      NavRoutePlanModel.getInstance().setPreference(paramInt1);
      NavRoutePlanModel.getInstance().setDriveRefTime(paramInt2, paramInt3);
      NavRoutePlanModel.getInstance().setStrategy(paramInt4);
      NavRoutePlanModel.getInstance().setRouteInfoStatus(paramInt5);
      NavRoutePlanModel.getInstance().mCarPANumber = paramString;
      NavRoutePlanModel.getInstance().setEntry(paramInt6);
      NavRoutePlanModel.getInstance().setExtBundle(paramBundle);
      localObject = NavCommonFuncModel.getInstance().getActivity();
      if ((localObject == null) || (NavMapAdapter.getInstance().isExternalStorageEnabled())) {
        break label355;
      }
      NavTipTool.onCreateToastDialog((Context)localObject, 2131296667);
      if (getInstance().getMapHandler() != null)
      {
        paramRouteNode1 = getInstance().getMapHandler().obtainMessage(1003);
        paramRouteNode1.arg1 = 0;
        paramRouteNode1.sendToTarget();
      }
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteForPBData isExternalStorageEnabled false ");
      return false;
      localObject = Integer.valueOf(paramRouteNode2.mFromType);
      break;
      label322:
      localObject = paramRouteNode2.mUID;
      break label53;
      label331:
      continue;
      label334:
      paramInt1 = NavMapAdapter.getInstance().mappingPreferValue(paramInt1);
      NavMapAdapter.getInstance().setPreferValue(paramInt1);
    }
    label355:
    if (sIsBaseEngineInitial) {
      BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("calcRouteForPBData()", null)new BNWorkerConfig
      {
        private int i = 1;
        
        protected String execute()
        {
          while (BaiduNaviManager.sIsBaseEngineInitial)
          {
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder().append("calcRouteForPBData() while ");
            int j = this.i;
            this.i = (j + 1);
            NavLogUtils.e(str, j);
            try
            {
              Thread.sleep(1000L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
          if (BaiduNaviManager.sIsBaseEngineInitialized)
          {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
            {
              protected String execute()
              {
                NavLogUtils.e(TAG, "calcRouteForPBData() wait ok.");
                BaiduNaviManager.this.calcRouteForPBDataInner(BaiduNaviManager.1.this.val$startNode, BaiduNaviManager.1.this.val$endNode, BaiduNaviManager.1.this.val$viaNodes, BaiduNaviManager.1.this.val$calcPrefer, BaiduNaviManager.1.this.val$driveRefTimeInterval, BaiduNaviManager.1.this.val$driveRefTimeDuration, BaiduNaviManager.1.this.val$strategy, BaiduNaviManager.1.this.val$routeInfoStatus, BaiduNaviManager.1.this.val$carPANumber, BaiduNaviManager.1.this.val$entry, BaiduNaviManager.1.this.val$extBundle);
                return null;
              }
            }, new BNWorkerConfig(100, 0));
            return null;
          }
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteForPBData sIsBaseEngineInitialized false ");
          return null;
        }
      }, new BNWorkerConfig(100, 0));
    }
    for (;;)
    {
      return true;
      if (sIsBaseEngineInitialized) {
        break;
      }
      if (localObject == null)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteForPBData activity is null");
        return false;
      }
      getInstance().initBaseEngine((Activity)localObject, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              if (BaiduNaviManager.getInstance().getMapHandler() != null)
              {
                Message localMessage = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1003);
                localMessage.arg1 = 0;
                localMessage.sendToTarget();
              }
              SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteForPBData engineInitFail");
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart() {}
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              BaiduNaviManager.this.calcRouteForPBDataInner(BaiduNaviManager.2.this.val$startNode, BaiduNaviManager.2.this.val$endNode, BaiduNaviManager.2.this.val$viaNodes, BaiduNaviManager.2.this.val$calcPrefer, BaiduNaviManager.2.this.val$driveRefTimeInterval, BaiduNaviManager.2.this.val$driveRefTimeDuration, BaiduNaviManager.2.this.val$strategy, BaiduNaviManager.2.this.val$routeInfoStatus, BaiduNaviManager.2.this.val$carPANumber, BaiduNaviManager.2.this.val$entry, BaiduNaviManager.2.this.val$extBundle);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
    }
    return calcRouteForPBDataInner(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString, paramInt6, paramBundle);
  }
  
  public boolean calcRouteToNaviRoute(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return calcRouteToNaviRoute(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null);
  }
  
  public boolean calcRouteToNaviRoute(final RouteNode paramRouteNode1, final RouteNode paramRouteNode2, final List<RouteNode> paramList, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final Bundle paramBundle)
  {
    PerformStatisticsController.peByType(1, "map_poi_click_start", NavCommonFuncModel.sPoiToNaviTime1);
    if (PerformStatItem.sUserTest)
    {
      PerformStatisticsController.peByType(1, "ad_poi_routeplan_start", System.currentTimeMillis());
      PerformStatItem.sPoiToNaviTime2 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("2", "基线到适配层v2", "MapBaseLine", NavCommonFuncModel.sPoiToNaviTime1, PerformStatItem.sPoiToNaviTime2);
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("calcRouteToNaviRoute() --> endNode.mFromType = ");
    Object localObject;
    if (paramRouteNode2 == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append(localObject).append(", endNode.mUID = ");
      if (paramRouteNode2 != null) {
        break label286;
      }
      localObject = "null";
      label107:
      NavLogUtils.e(str, (String)localObject);
      NaviRecoveryModel.getInstance().setHasCalcRoute(true);
      if (paramInt5 == 7) {
        break label295;
      }
      paramInt1 = NavMapAdapter.getInstance().onGetLastPreferValue();
      NavMapAdapter.getInstance().setPreferValue(paramInt1);
    }
    for (;;)
    {
      NavSearchController.getInstance().setRpEntry(paramInt5);
      NavSearchController.getInstance().setIsFromMap(true);
      NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
      NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
      NavRoutePlanModel.getInstance().setViaNodes(paramList);
      NavRoutePlanModel.getInstance().setPreference(paramInt1);
      NavRoutePlanModel.getInstance().setDriveRefTime(paramInt2, paramInt3);
      NavRoutePlanModel.getInstance().setStrategy(paramInt4);
      NavRoutePlanModel.getInstance().setEntry(paramInt5);
      NavRoutePlanModel.getInstance().setExtBundle(paramBundle);
      localObject = NavCommonFuncModel.getInstance().getActivity();
      if ((localObject == null) || (NavMapAdapter.getInstance().isExternalStorageEnabled())) {
        break label316;
      }
      NavTipTool.onCreateToastDialog((Context)localObject, 2131296667);
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteToNaviRoute isExternalStorageEnabled false");
      return false;
      localObject = Integer.valueOf(paramRouteNode2.mFromType);
      break;
      label286:
      localObject = paramRouteNode2.mUID;
      break label107;
      label295:
      paramInt1 = NavMapAdapter.getInstance().mappingPreferValue(paramInt1);
      NavMapAdapter.getInstance().setPreferValue(paramInt1);
    }
    label316:
    if (!sIsBaseEngineInitialized)
    {
      if (localObject == null)
      {
        SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteToNaviRoute activity is null");
        return false;
      }
      getInstance().initBaseEngine((Activity)localObject, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteToNaviRoute engineInitFail");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart() {}
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              BaiduNaviManager.this.calcRouteToNaviRouteInner(BaiduNaviManager.3.this.val$startNode, BaiduNaviManager.3.this.val$endNode, BaiduNaviManager.3.this.val$viaNodes, BaiduNaviManager.3.this.val$calcPrefer, BaiduNaviManager.3.this.val$driveRefTimeInterval, BaiduNaviManager.3.this.val$driveRefTimeDuration, BaiduNaviManager.3.this.val$strategy, BaiduNaviManager.3.this.val$entry, BaiduNaviManager.3.this.val$extBundle);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
    }
    for (;;)
    {
      return true;
      calcRouteToNaviRouteInner(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBundle);
    }
  }
  
  public boolean calcRouteWithPBData(final RouteNode paramRouteNode1, final RouteNode paramRouteNode2, final List<RouteNode> paramList, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    NavLogUtils.e(TAG, "calcRouteWithPBData() ");
    NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
    NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
    NavRoutePlanModel.getInstance().setViaNodes(paramList);
    NavRoutePlanModel.getInstance().setPreference(paramInt1);
    NavRoutePlanModel.getInstance().pbData = paramArrayOfByte;
    NavRoutePlanModel.getInstance().pbDataLen = paramInt2;
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if (localActivity == null)
    {
      NavLogUtils.e(TAG, "calcRouteWithPBData() activity == null");
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData activity is null");
      return false;
    }
    if (!sIsBaseEngineInitialized)
    {
      NavLogUtils.e(TAG, "calcRouteWithPBData() start to init guidance engine");
      getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          LogUtil.e("SDKHelper", "calcRouteWithPBData() engineInitFail");
          SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData engineInitFail");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart()
        {
          LogUtil.e("SDKHelper", "calcRouteWithPBData() engineInitStart");
        }
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "calcRouteWithPBData() engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavLogUtils.e(TAG, "calcRouteWithPBData() real call 1");
              NavRoutePlanController.getInstance().calcRouteWithPBData(BaiduNaviManager.4.this.val$startNode, BaiduNaviManager.4.this.val$endNode, BaiduNaviManager.4.this.val$viaNodes, BaiduNaviManager.4.this.val$unPreference, BaiduNaviManager.4.this.val$pbData, BaiduNaviManager.4.this.val$pbDataLen);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
    }
    for (;;)
    {
      return true;
      NavLogUtils.e(TAG, "calcRouteWithPBData() real call 2");
      NavRoutePlanController.getInstance().calcRouteWithPBData(paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramArrayOfByte, paramInt2);
    }
  }
  
  public void cancleCalcRouteRequest()
  {
    NavRoutePlanController.getInstance().cancleCalcRouteRequest();
  }
  
  public boolean checkLastNaviStatus(Handler paramHandler)
  {
    return NavRecoverController.getInstance().checkLastNaviStatus(paramHandler);
  }
  
  public boolean clearLastNaviRoutelnfo()
  {
    try
    {
      boolean bool = NavRecoverController.getInstance().clearLastNaviRoutelnfo();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean clearRouteBuffer()
  {
    if (!isNaviSoLoadSuccess()) {
      return false;
    }
    return NavRoutePlanController.getInstance().clearRouteBuffer();
  }
  
  public boolean continueLastNavi()
  {
    return NavRecoverController.getInstance().continueLastNavi();
  }
  
  public int downLoadCityMapData(int paramInt)
  {
    if (!sIsBaseEngineInitialized) {
      return -1;
    }
    return NavCommonFuncController.getInstance().downLoadCityMapData(paramInt);
  }
  
  public void enterLightNavi(Context paramContext, int paramInt) {}
  
  public void forceQuitWithoutDialog()
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return;
    }
    NavRouteGuideController.getInstance().forceQuitWithoutDialog();
  }
  
  public Bitmap getCarNaviBusinessImage()
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return null;
    }
    return NavTrajectoryController.getInstance().getCarNaviBusinessImage();
  }
  
  public String getCurrentTTSVoiceDataPath()
  {
    return BaseTTSPlayer.getInstance().getCurrentTTSVoiceDataPath();
  }
  
  public Bundle getHomeAndCompanyRouteInfo(RouteNode paramRouteNode1, RouteNode paramRouteNode2, int paramInt1, int paramInt2)
  {
    NavLogUtils.e(TAG, "getHomeAndCompanyRouteInfo  entry: " + paramInt2);
    if (!sIsBaseEngineInitialized) {
      return null;
    }
    return NavRoutePlanController.getInstance().getHomeAndCompanyRouteInfo(paramRouteNode1, paramRouteNode2, paramInt1, paramInt2);
  }
  
  public long getKilledTime(Context paramContext)
  {
    return NavRecoverController.getInstance().getKilledTime(paramContext);
  }
  
  public Handler getMapHandler()
  {
    return this.mMapHandler;
  }
  
  public Handler getNaviMainHandler()
  {
    return this.mNaviHandler;
  }
  
  public String[] getPhoneAuthArray()
  {
    return new String[] { "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.PROCESS_OUTGOING_CALLS" };
  }
  
  public void getRouteBoundRect(ArrayList<Bundle> paramArrayList)
  {
    BNRoutePlaner.getInstance().getRouteBoundRect(paramArrayList);
  }
  
  public int getRoutePlanRequestID()
  {
    return NavRoutePlanController.getInstance().getRoutePlanRequestID();
  }
  
  public Bundle getRoutePlanStatusInfo()
  {
    if (!sIsBaseEngineInitialized) {
      return null;
    }
    return NavRoutePlanController.getInstance().getRoutePlanStatusInfo();
  }
  
  public Bundle getSearchStatusInfo()
  {
    if (!sIsBaseEngineInitialized) {
      return null;
    }
    return NavSearchController.getInstance().getSearchStatusInfo();
  }
  
  public String getTRURlParam()
  {
    NavLogUtils.e(TAG, "getTRURlParam() URlParam111=");
    return NavRoutePlanController.getInstance().getTRURlParam();
  }
  
  public void goToLightNaviComAddrPage(Context paramContext, int paramInt) {}
  
  public boolean hasGPSPermission(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getPackageManager();
      bool1 = bool2;
      if (paramActivity == null) {}
    }
    try
    {
      int i = paramActivity.checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.baidu.carlife");
      bool1 = bool2;
      if (-1 != i) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramActivity) {}
    return false;
  }
  
  public boolean hasPhoneAuth(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getPhoneAuthArray();
      try
      {
        paramContext = paramContext.getPackageManager();
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label56;
          }
          int k = paramContext.checkPermission(arrayOfString[i], "com.baidu.carlife");
          if (k != 0) {
            break;
          }
          i += 1;
        }
        return true;
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
  }
  
  public void hideEyeSpyPaperButton()
  {
    BNEyeSpyPaperController.getInstance().hideButton();
  }
  
  public void initBaseEngine(Activity paramActivity, NaviEngineInitListener paramNaviEngineInitListener)
  {
    NavLogUtils.e(TAG, "initBaseEngine() sIsNaviSoLoadSuccess=" + sIsNaviSoLoadSuccess);
    NavInitController.getInstance().initBaseEngine(paramActivity, paramNaviEngineInitListener);
  }
  
  @Deprecated
  public void initSensorListener() {}
  
  public void initTTSModule(Context paramContext)
  {
    String str = NavMapAdapter.getInstance().getDataPath() + File.separator + "bnav";
    BaseTTSPlayer.getInstance().initPlayer(paramContext, str);
  }
  
  public void initURLData() {}
  
  public boolean isLastNaviUnfinished(Context paramContext)
  {
    return NavRecoverController.getInstance().isLastNaviUnfinished(paramContext);
  }
  
  public boolean isNaviBegin()
  {
    try
    {
      if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {
        return false;
      }
      if (sIsBaseEngineInitialized)
      {
        boolean bool = NavCommonFuncController.getInstance().isNaviBegin();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public boolean isProvinceDataDownload(int paramInt)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return false;
    }
    return NavCommonFuncController.getInstance().isProvinceDataDownload(paramInt);
  }
  
  public void lauchIPONavi()
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRoutePlanController.getInstance().lauchIPONavi();
  }
  
  public void launchCruiser(Activity paramActivity, Boolean paramBoolean)
  {
    NavRouteGuideController.getInstance().launchCruiser(paramActivity, paramBoolean);
  }
  
  public void launchDownloadActivity(final Context paramContext, final String paramString)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if (!sIsBaseEngineInitialized)
    {
      getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().dismissMProgressDialog();
              NavCommonFuncController.getInstance().launchDownloadActivity(BaiduNaviManager.9.this.val$ctx, BaiduNaviManager.9.this.val$isFromCruiser);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
      return;
    }
    NavCommonFuncController.getInstance().launchDownloadActivity(paramContext, paramString);
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, NavGeoPoint paramNavGeoPoint1, String paramString1, NavGeoPoint paramNavGeoPoint2, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRouteGuideController.getInstance().launchNavigator(paramActivity, paramNavGeoPoint1, paramString1, paramNavGeoPoint2, paramString2, paramInt1, paramBoolean, paramInt2, false);
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, NavGeoPoint paramNavGeoPoint1, String paramString1, NavGeoPoint paramNavGeoPoint2, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRouteGuideController.getInstance().launchNavigator(paramActivity, paramNavGeoPoint1, paramString1, paramNavGeoPoint2, paramString2, paramInt1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRouteGuideController.getInstance().launchNavigator(paramActivity, paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramBoolean, paramInt2, false);
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRouteGuideController.getInstance().launchNavigator(paramActivity, paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public void launchUgcMangerActivity(Context paramContext)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    try
    {
      NavCommonFuncModel.getInstance().getActivity();
      NavCommonFuncController.getInstance().launchUgcMangerActivity(paramContext);
      return;
    }
    catch (NullPointerException paramContext) {}
  }
  
  public void launchUgcPickActivity(Context paramContext, Bundle paramBundle)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncModel.getInstance().getActivity();
    NavCommonFuncController.getInstance().launchUgcPickActivity(paramContext, paramBundle);
  }
  
  public void notifyMapGPSEnable(boolean paramBoolean)
  {
    if (this.mNaviHandler.hasMessages(2)) {
      this.mNaviHandler.removeMessages(2);
    }
    Message localMessage = this.mNaviHandler.obtainMessage(2);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mNaviHandler.sendMessageDelayed(localMessage, 500L);
      return;
    }
  }
  
  public void notifyNaviBeginChanged(String paramString)
  {
    NavMapAdapter.getInstance().setUgcInfo(paramString);
  }
  
  public boolean onBackPressRCEvent()
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while ((!sIsBaseEngineInitialized) || (!sIsBaseEngineInitialized)) {
      return false;
    }
    return NavCommonFuncController.getInstance().onBackPressRCEvent();
  }
  
  public void onCarNaviRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {}
    while (NavCommonFuncModel.getInstance().mHasRequestReadPhoneStatePermission) {
      return;
    }
    NavCommonFuncModel.getInstance().mHasRequestReadPhoneStatePermission = true;
    paramArrayOfString = NavRoutePlanModel.getInstance().getStartRouteNode();
    paramArrayOfInt = NavRoutePlanModel.getInstance().getEndRouteNode();
    List localList = NavRoutePlanModel.getInstance().getViaNodes();
    paramInt = NavRoutePlanModel.getInstance().getPreference();
    int i = NavRoutePlanModel.getInstance().getDriveRefTimeInterval();
    int j = NavRoutePlanModel.getInstance().getDriveRefTimeDuration();
    int k = NavRoutePlanModel.getInstance().getStrategy();
    int m = NavRoutePlanModel.getInstance().getRouteInfoStatus();
    String str = NavRoutePlanModel.getInstance().mCarPANumber;
    int n = NavRoutePlanModel.getInstance().getEntry();
    byte[] arrayOfByte = NavRoutePlanModel.getInstance().pbData;
    int i1 = NavRoutePlanModel.getInstance().pbDataLen;
    Bundle localBundle = NavRoutePlanModel.getInstance().getExtBundle();
    switch (sCurrentCalSource)
    {
    default: 
      return;
    case 1: 
      calcRouteForPBData(paramArrayOfString, paramArrayOfInt, localList, paramInt, i, j, k, m, str, n, localBundle);
      sCurrentCalSource = 0;
      return;
    case 2: 
      calcRouteToNaviRoute(paramArrayOfString, paramArrayOfInt, localList, paramInt, i, j, k, n, localBundle);
      sCurrentCalSource = 0;
      return;
    case 3: 
      calcRouteWithPBData(paramArrayOfString, paramArrayOfInt, localList, paramInt, arrayOfByte, i1);
      sCurrentCalSource = 0;
      return;
    case 4: 
      enterLightNavi(NavCommonFuncModel.getInstance().getActivity(), n);
      sCurrentCalSource = 0;
      return;
    }
    goToLightNaviComAddrPage(NavCommonFuncModel.getInstance().getActivity(), n);
    sCurrentCalSource = 0;
  }
  
  public void onRestoreData(boolean paramBoolean)
  {
    if (sIsBaseEngineInitialized)
    {
      NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = false;
      UserOPController.getInstance().add("1.q");
      return;
    }
    NavCommonFuncModel.getInstance().mIsOnRestoreInstanceData = paramBoolean;
  }
  
  public void pauseAllDownload()
  {
    if (!sIsBaseEngineInitialized) {}
    while (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().pauseAllDownload();
  }
  
  public boolean recordTimeLog(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    paramString2 = paramString1 + "-" + paramString2 + "-" + paramString3 + "_" + paramLong1 + "_" + paramLong2 + "=" + (paramLong2 - paramLong1);
    NavLogUtils.e("CarRoutePlanTime", paramString2);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("CarRoutePlanTime", paramString2);
      return com.baidu.platform.comapi.b.c.a().a(2110, 1, "CarRoutePlanTime", paramString1.toString());
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
  }
  
  public int refreshRouteForDrivingCar()
  {
    if (!sIsBaseEngineInitialized) {
      return -1;
    }
    return NavDrivingCarController.getInstance().refreshRouteForDrivingCar();
  }
  
  public void registerNavEventListener(BaiduNaviParams.NaviEvent paramNaviEvent)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().addNaviEventListener(paramNaviEvent);
  }
  
  public void releaseResources()
  {
    NavFragmentManager.getInstance().destroy();
  }
  
  public boolean resetEndNodeInNavi(RouteNode paramRouteNode)
  {
    if ((!isNaviBegin()) || (paramRouteNode == null) || (paramRouteNode.mGeoPoint == null) || (!paramRouteNode.mGeoPoint.isValid())) {}
    while (!sIsBaseEngineInitialized) {
      return false;
    }
    return NavRouteGuideController.getInstance().resetEndNodeInNavi(paramRouteNode);
  }
  
  public void resetLastDoubleClickTime()
  {
    NavCommonFuncController.getInstance().resetLastDoubleClickTime();
  }
  
  public boolean routeSearchForMapPoiResultPB(final int paramInt1, final String paramString1, final int paramInt2, final int paramInt3, final String paramString2, final int paramInt4, final int paramInt5, final Handler paramHandler)
  {
    NavLogUtils.e(TAG, "routeSearchForMapPoiResultPB() routeSearchMode=" + paramInt1 + ", searchWord=" + paramString1 + ", searchRange=" + paramInt2 + ", sortType=" + paramInt3 + ", mrsl=" + paramString2);
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
    {
      NavTipTool.onCreateToastDialog(localActivity, 2131296667);
      return false;
    }
    if (!sIsBaseEngineInitialized)
    {
      if (localActivity == null) {
        return false;
      }
      getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().dismissMProgressDialog();
              NavSearchController.getInstance().routeSearchForMapPoiResultPB(BaiduNaviManager.7.this.val$routeSearchMode, BaiduNaviManager.7.this.val$searchWord, BaiduNaviManager.7.this.val$searchRange, BaiduNaviManager.7.this.val$sortType, BaiduNaviManager.7.this.val$mrsl, BaiduNaviManager.7.this.val$poiCount, BaiduNaviManager.7.this.val$pageNumber, BaiduNaviManager.7.this.val$handler);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
      return true;
    }
    return NavSearchController.getInstance().routeSearchForMapPoiResultPB(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramInt4, paramInt5, paramHandler);
  }
  
  public void runOnUIThread(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
    {
      protected String execute()
      {
        paramRunnable.run();
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public boolean searchByCircleForMapPoiResultPB(final String paramString, final int paramInt1, final NavSearchCircle paramNavSearchCircle, final int paramInt2, final int paramInt3, final Handler paramHandler)
  {
    NavPerformanceModel.getInstance().startSearchByCircleForMapPoiResultPB();
    NavLogUtils.e(TAG, "searchByCircleForMapPoiResultPB() name=" + paramString + ", districtID=" + paramInt1);
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
    {
      NavTipTool.onCreateToastDialog(localActivity, 2131296667);
      return false;
    }
    if (!sIsBaseEngineInitialized)
    {
      if (localActivity == null) {
        return false;
      }
      getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().dismissMProgressDialog();
              NavSearchController.getInstance().searchByCircleForMapPoiResultPB(BaiduNaviManager.6.this.val$name, BaiduNaviManager.6.this.val$districtID, BaiduNaviManager.6.this.val$circle, BaiduNaviManager.6.this.val$poiCount, BaiduNaviManager.6.this.val$pageNumber, BaiduNaviManager.6.this.val$handler);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
      return true;
    }
    return NavSearchController.getInstance().searchByCircleForMapPoiResultPB(paramString, paramInt1, paramNavSearchCircle, paramInt2, paramInt3, paramHandler);
  }
  
  public boolean searchByNameForMapPoiResultPB(final String paramString, final int paramInt1, final NavSearchCircle paramNavSearchCircle, final int paramInt2, final int paramInt3, final Handler paramHandler)
  {
    NavPerformanceModel.getInstance().startSearchByNameForMapPoiResultPB();
    NavLogUtils.e(TAG, "searchByNameForMapPoiResultPB() name=" + paramString + ", districtID=" + paramInt1);
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
    {
      NavTipTool.onCreateToastDialog(localActivity, 2131296667);
      return false;
    }
    if (!sIsBaseEngineInitialized)
    {
      if (localActivity == null) {
        return false;
      }
      getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
              NavMapAdapter.getInstance().dismissMProgressDialog();
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitStart()
        {
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
        
        public void engineInitSuccess()
        {
          LogUtil.e("SDKHelper", "engineInitSuccess");
          BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
          {
            protected String execute()
            {
              NavMapAdapter.getInstance().dismissMProgressDialog();
              NavSearchController.getInstance().searchByNameForMapPoiResultPB(BaiduNaviManager.5.this.val$name, BaiduNaviManager.5.this.val$districtID, BaiduNaviManager.5.this.val$circle, BaiduNaviManager.5.this.val$poiCount, BaiduNaviManager.5.this.val$pageNumber, BaiduNaviManager.5.this.val$handler);
              return null;
            }
          }, new BNWorkerConfig(100, 0));
        }
      });
      return true;
    }
    return NavSearchController.getInstance().searchByNameForMapPoiResultPB(paramString, paramInt1, paramNavSearchCircle, paramInt2, paramInt3, paramHandler);
  }
  
  public boolean selectRoute(String paramString, boolean paramBoolean)
  {
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    NavRoutePlanModel.getInstance().mStartDriv = paramBoolean;
    NavRoutePlanModel.getInstance().mCurMrsl = paramString;
    return NavDrivingCarController.getInstance().selectRoute(paramString, paramBoolean);
  }
  
  public boolean selectRouteToNavi(String paramString, boolean paramBoolean1, boolean paramBoolean2, RouteNode paramRouteNode)
  {
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    NavRoutePlanModel.getInstance().mCurMrsl = paramString;
    if ((paramRouteNode != null) && (paramRouteNode.mUID != null))
    {
      RouteNode localRouteNode = NavRoutePlanModel.getInstance().getEndRouteNode();
      if ((localRouteNode != null) && ((localRouteNode.mUID == null) || (localRouteNode.mUID.length() == 0))) {
        NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode);
      }
    }
    return NavRoutePlanController.getInstance().selectRouteToNavi(paramString, paramBoolean1, paramBoolean2, 4);
  }
  
  public boolean selectRouteToNavi(String paramString, boolean paramBoolean1, boolean paramBoolean2, RouteNode paramRouteNode, int paramInt1, int paramInt2)
  {
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    if (PerformStatItem.sUserTest)
    {
      PerformStatItem.sRoutePageToNaviTime2 = System.currentTimeMillis();
      PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("2", "基线到适配层", "MapBaseLine", NavCommonFuncModel.sRoutePageToNaviTime1, PerformStatItem.sRoutePageToNaviTime2);
    }
    NavRoutePlanModel.getInstance().mCurMrsl = paramString;
    if ((paramRouteNode != null) && (paramRouteNode.mUID != null))
    {
      RouteNode localRouteNode = NavRoutePlanModel.getInstance().getEndRouteNode();
      if ((localRouteNode != null) && ((localRouteNode.mUID == null) || (localRouteNode.mUID.length() == 0))) {
        NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode);
      }
    }
    NavRouteGuideController.getInstance().setUserChooseRouteBit(paramInt1);
    return NavRoutePlanController.getInstance().selectRouteToNavi(paramString, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void sendNaviStatistics(RouteNode paramRouteNode1, RouteNode paramRouteNode2, String paramString1, String paramString2)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavUserBehaviour.getInstance().sendNaviStatistics(paramRouteNode1, paramRouteNode2, paramString1, NavRoutePlanModel.getInstance().getStrategyForUserBeh(), paramString2);
  }
  
  public void setBNotBuildCarData(boolean paramBoolean)
  {
    NavRoutePlanController.getInstance().setBNotBuildCarData(paramBoolean);
  }
  
  public void setCalcPrference(final int paramInt)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (!sIsBaseEngineInitialized);
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if ((localActivity != null) && (!NavMapAdapter.getInstance().isExternalStorageEnabled()))
      {
        NavTipTool.onCreateToastDialog(localActivity, 2131296667);
        return;
      }
      if (sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitSuccess()
      {
        LogUtil.e("SDKHelper", "engineInitSuccess");
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            NavRouteGuideController.getInstance().setCalcPrference(BaiduNaviManager.8.this.val$preference);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    return;
    NavRouteGuideController.getInstance().setCalcPrference(paramInt);
  }
  
  public void setCarInfo(String paramString)
  {
    NavRoutePlanController.getInstance().setCarInfo(new NavCarInfo(paramString));
  }
  
  public boolean setDestNodes(List<RouteNode> paramList, RouteNode paramRouteNode)
  {
    NavLogUtils.e(TAG, "setDestsWithPBData() ");
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    return NavRoutePlanController.getInstance().setDestNodes(paramList, paramRouteNode);
  }
  
  public void setIsChangeBackground(int paramInt)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return;
    }
    BNRoutePlaner.getInstance().setIsChangeBackground(paramInt);
  }
  
  public void setKilledTime(Context paramContext, long paramLong)
  {
    BNRecoverNaviHelper.getInstance().setKilledTime(paramContext, paramLong);
  }
  
  public void setMapHandler(Handler paramHandler)
  {
    this.mMapHandler = paramHandler;
  }
  
  public void setSensor(int paramInt)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRoutePlanModel.getInstance().setmMapSensorAngle(paramInt);
  }
  
  public boolean setTTSVoiceDataPath(String paramString)
  {
    return BaseTTSPlayer.getInstance().setTTSVoiceDataPath(paramString);
  }
  
  public boolean setVoiceModeInNavi(int paramInt)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while ((!sIsBaseEngineInitialized) || (!sIsBaseEngineInitialized)) {
      return false;
    }
    NavRouteGuideController.getInstance().setVoiceModeInNavi(paramInt);
    return true;
  }
  
  public void showEyeSpyPaperButton()
  {
    BNEyeSpyPaperController.getInstance().showButton();
  }
  
  public void showNavPage(String paramString, Bundle paramBundle)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().showNavPage(paramString, paramBundle);
  }
  
  public boolean startDrivingCar()
  {
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    return NavDrivingCarController.getInstance().startDrivingCar();
  }
  
  public void statNaviIntentTime()
  {
    if (sIsBaseEngineInitialized) {
      NavUserBehaviour.getInstance().statNaviIntentTime();
    }
  }
  
  public void statNaviIntentTime2()
  {
    if ((sIsBaseEngineInitialized) && (NavUserBehaviour.getInstance() != null)) {
      NavUserBehaviour.getInstance().statNaviIntentTime2();
    }
  }
  
  public boolean stopDrivingCar()
  {
    if (!sIsBaseEngineInitialized) {
      return false;
    }
    return NavDrivingCarController.getInstance().stopDrivingCar();
  }
  
  public boolean switchTTSVoiceData(String paramString)
  {
    return BaseTTSPlayer.getInstance().switchTTSVoiceData(paramString, null);
  }
  
  public boolean switchTTSVoiceData(String paramString, OnTTSVoiceDataSwitchListener paramOnTTSVoiceDataSwitchListener)
  {
    return BaseTTSPlayer.getInstance().switchTTSVoiceData(paramString, paramOnTTSVoiceDataSwitchListener);
  }
  
  public void triggerStartSensorData(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavRoutePlanModel.getInstance().triggerStartSensorData(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public boolean ttsAction(final Bundle paramBundle)
  {
    NavLogUtils.e(TAG, "ttsAction");
    if (!sIsBaseEngineInitialized) {}
    final Activity localActivity;
    do
    {
      return false;
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if (sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(com.baidu.platform.comapi.c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity)BaiduNaviManager.10.this.val$activity, "", BaiduNaviManager.10.this.val$activity.getString(2131296659));
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitSuccess()
      {
        LogUtil.e("SDKHelper", "engineInitSuccess");
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            BaiduNaviManager.this.ttsActionInner(BaiduNaviManager.10.this.val$data);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    return true;
    return ttsActionInner(paramBundle);
  }
  
  public void uninitEngine()
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavInitController.getInstance().uninitEngine();
  }
  
  public void unregisterNavEventListener(BaiduNaviParams.NaviEvent paramNaviEvent)
  {
    if (!NavMapAdapter.getInstance().isNaviInjectSuccess()) {}
    while (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().removeNaviEventListener(paramNaviEvent);
  }
  
  public void updateAccountInfoWhenLoginSuccess()
  {
    if (!sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().updateAccountInfoWhenLoginSuccess();
  }
  
  public static abstract interface CalRouteSource
  {
    public static final int SOURCE_ENTERLIGHT = 4;
    public static final int SOURCE_LIGTHPAGE = 5;
    public static final int SOURCE_NAVIROUTE = 2;
    public static final int SOURCE_PBDATA = 1;
    public static final int SOURCE_WITHPBDATA = 3;
  }
  
  public static abstract interface UgcNaviMsgCallBack
  {
    public abstract void onUgcPageFinish();
    
    public abstract void onUgcReportBtnClick();
    
    public abstract void showUgcReportBtn(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/BaiduNaviManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */