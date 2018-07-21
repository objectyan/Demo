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
import com.baidu.baidumaps.f.a.b.a;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.CarNaviTrajectoryModel;
import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.MapComponentCallback;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
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
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.navisdk.util.worker.loop.BNMainLooperMsgHandler;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class NavRoutePlanController
{
  private static final int MSG_CANCEL_MAP_LIGHT_SEARCH = 4445;
  private static final int MSG_Type_Request_Map_Light_Search = 4444;
  private static final int ROUTE_PLAN_TYPE_FOR_NAVI = 2;
  private static final int ROUTE_PLAN_TYPE_FOR_PB = 0;
  private static final int ROUTE_PLAN_TYPE_WITH_PB = 1;
  public static final String TAG = NavRoutePlanController.class.getSimpleName();
  private static NavRoutePlanController sInstance = null;
  private boolean isMulRoutePlan = false;
  private int mDistrictID = 0;
  private MsgHandler mHandler = new BNMainLooperMsgHandler()
  {
    public void careAbout()
    {
      observe(4115);
      observe(4401);
      observe(4098);
    }
    
    public void onMessage(Message paramAnonymousMessage)
    {
      NavLogUtils.e(NavRoutePlanController.TAG, "handleMessage() what=" + paramAnonymousMessage.what + ", arg1=" + paramAnonymousMessage.arg1 + ", arg2=" + paramAnonymousMessage.arg2);
      if (4115 == paramAnonymousMessage.what) {
        if ((3 == paramAnonymousMessage.arg1) && (NavRoutePlanModel.getInstance().mStartDriv))
        {
          NavLogUtils.e(NavRoutePlanController.TAG, "NavDrivingCar===  Message() selectRoute -> fordravingcar===");
          NavRoutePlanModel.getInstance().mStartDriv = false;
          if ((!BNRoutePlaner.getInstance().isBuildRouteReady(false, NavRoutePlanModel.getInstance().mCurMrsl)) || (BaiduNaviManager.getInstance().getMapHandler() == null)) {
            break label151;
          }
          BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3050).sendToTarget();
          if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.get("RoutePlan_debug").add(" NavDrivingCar===  Message() selectRoute -> fordravingcar===");
          }
        }
      }
      label151:
      int i;
      label339:
      label433:
      label439:
      label477:
      do
      {
        do
        {
          byte[] arrayOfByte;
          do
          {
            return;
            NavRoutePlanModel.getInstance().mNotBuildReady = true;
            break;
            if (4445 == paramAnonymousMessage.what)
            {
              NavLogUtils.e(NavRoutePlanController.TAG, "mapLightSearch() execute timout, mMapLightSearchRequestID=" + NavRoutePlanController.this.mMapLightSearchRequestID);
              NavRoutePlanController.this.cancelMapLightSearch();
              BNRoutePlaner.getInstance().lightCalcRoute(-1);
              return;
            }
            if (4401 != paramAnonymousMessage.what) {
              break label477;
            }
            arrayOfByte = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
            localObject1 = NavRoutePlanController.TAG;
            localObject2 = new StringBuilder().append("NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=");
            if (arrayOfByte != null) {
              break label433;
            }
            i = 0;
            NavLogUtils.e((String)localObject1, i);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putByteArray("pb_data", arrayOfByte);
            ((Bundle)localObject1).putInt("route_refresh_reason", paramAnonymousMessage.arg2);
            if (BaiduNaviManager.getInstance().getMapHandler() != null)
            {
              if (paramAnonymousMessage.arg2 == 2) {}
              localObject2 = BaiduNaviManager.getInstance().getMapHandler();
              if (paramAnonymousMessage.arg2 != 2) {
                break label439;
              }
              i = 3020;
              localObject2 = ((Handler)localObject2).obtainMessage(i);
              a.a().r = true;
              ((Message)localObject2).obj = localObject1;
              ((Message)localObject2).sendToTarget();
            }
            if (!NavCommonFuncModel.getInstance().mIsAppForeground) {
              NavDrivingCarController.getInstance().hasYawRouteMsg = true;
            }
          } while (!BNSettingManager.isShowJavaLog());
          Object localObject1 = SDKDebugFileUtil.get("RoutePlan_debug");
          Object localObject2 = new StringBuilder().append(" NavDrivingCar===NE_RoutePlan_Driving_Car_ROUTE_REFRESH routePB.lenth=");
          if (arrayOfByte == null) {}
          for (paramAnonymousMessage = Integer.valueOf(0);; paramAnonymousMessage = arrayOfByte.length + " msg.arg2= " + paramAnonymousMessage.arg2)
          {
            ((SDKDebugFileUtil)localObject1).add(paramAnonymousMessage);
            return;
            i = arrayOfByte.length;
            break;
            i = 1002;
            break label339;
          }
        } while (4098 != paramAnonymousMessage.what);
        i = paramAnonymousMessage.arg1;
        NavLogUtils.e(NavRoutePlanController.TAG, "NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + i);
        if (BNSettingManager.isShowJavaLog()) {
          SDKDebugFileUtil.get("RoutePlan_debug").add("NavDrivingCar===MSG_NAVI_STATUS_CHANGE nMsgType=" + i);
        }
      } while ((i != 6) || (BaiduNaviManager.getInstance().getMapHandler() == null));
      BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3040).sendToTarget();
    }
  };
  private boolean mHasDirectyStartRouteGuide = false;
  private boolean mIsRequestShowRouteGuideView = false;
  private BNRoutePlaner.MapComponentCallback mMapComponentCallback = null;
  public int mMapLightSearchRequestID = -1;
  private long mMapLightSearchTimeout = 10000L;
  private String mMapLightSearchUrl = null;
  private MapSearchAPIWrapper mMapSearchAPIWrapper = null;
  private IBNPerformStatListener mPerformStatListener = new IBNPerformStatListener()
  {
    public boolean onLogRecord(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
    {
      return NavMapAdapter.getInstance().addPerformLog(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString1, paramAnonymousString2);
    }
  };
  private Handler mRPHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 32: 
      default: 
      case 4444: 
      case 8: 
      case 7: 
      case 33: 
      case 34: 
      case 35: 
      case 37: 
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                if (NavMapAdapter.getInstance().getDebugConfigUserTest())
                {
                  PerformStatisticsController.getInstance().addTimeLog(2110, 1, "CarRoutePlanTime", "7", "MapBaseLine", "RequestMapLightService", PerformStatItem.sRequestMapLightServiceStart, System.currentTimeMillis());
                  PerformStatItem.sNetWorkRequestStart = System.currentTimeMillis();
                }
                NavRoutePlanController.this.mMapLightSearchRequestID = NavMapAdapter.getInstance().mapLightSearch(NavRoutePlanController.this.mMapLightSearchUrl, NavRoutePlanController.this.mHandler, 4445, NavRoutePlanController.this.mMapSearchAPIWrapper, NavRoutePlanController.this.mMapLightSearchTimeout);
                NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle .mMapLightSearchRequestID:" + NavRoutePlanController.this.mMapLightSearchRequestID);
                return;
                if (NavRoutePlanController.this.mRoutePlanType != 2)
                {
                  NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle .RP_BEFORE_START");
                  if (BaiduNaviManager.getInstance().getMapHandler() != null)
                  {
                    BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1000);
                    return;
                    NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
                    if (NavRoutePlanController.this.mRoutePlanType != 2)
                    {
                      NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle RP_FAIL_NORMAL ");
                      NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
                      NavLogUtils.e("route_plan_time", "failed.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
                    }
                    while ((NavRoutePlanController.this.mRoutePlanType != 0) || (NavRoutePlanModel.getInstance().getRouteInfoStatus() != 2))
                    {
                      BNRoutePlaner.getInstance().removeRouteResultHandler(this);
                      return;
                      if ((NavRoutePlanController.this.mRoutePlanType == 2) && (NavRoutePlanModel.getInstance().getEntry() == 16)) {
                        NavRoutePlanController.this.reCalRouteForDrivingCar();
                      }
                    }
                  }
                }
              }
              NavLogUtils.e(NavRoutePlanController.TAG, "NavDrivingCar===rpHandle RP_SUCCESS_BUILD ");
              if (NavRoutePlanModel.getInstance().mNotBuildReady)
              {
                NavRoutePlanModel.getInstance().mNotBuildReady = false;
                if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                  BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3050).sendToTarget();
                }
              }
              localObject = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(2);
              paramAnonymousMessage = new Bundle();
              paramAnonymousMessage.putByteArray("pb_data", (byte[])localObject);
            } while (BaiduNaviManager.getInstance().getMapHandler() == null);
            localObject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1004);
            ((Message)localObject).obj = paramAnonymousMessage;
            ((Message)localObject).sendToTarget();
            return;
            NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle RP_FAIL_BUILD ");
            if (BaiduNaviManager.getInstance().getMapHandler() != null) {
              BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1005);
            }
          } while ((NavRoutePlanController.this.mRoutePlanType == 0) && (NavRoutePlanController.this.isMulRoutePlan));
          BNRoutePlaner.getInstance().removeRouteResultHandler(this);
          return;
          NavLogUtils.e("OPENAPI", "NavRoutePlanerController Recv KEYWORD_RESULT MSG, time = " + System.currentTimeMillis());
          Object localObject = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(0);
          if (localObject != null) {
            NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle RP_MAP_KEYWORD_RESULT routePB.len=" + localObject.length);
          }
          NavLogUtils.e(NavRoutePlanController.TAG, "rpHandle RP_MAP_KEYWORD_RESULT");
          paramAnonymousMessage = new Bundle();
          paramAnonymousMessage.putByteArray("pb_data", (byte[])localObject);
          NavCommonFuncController.getInstance().resetLastDoubleClickTime();
          if (BaiduNaviManager.getInstance().getMapHandler() != null)
          {
            localObject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1020);
            ((Message)localObject).obj = paramAnonymousMessage;
            ((Message)localObject).sendToTarget();
          }
          BNRoutePlaner.getInstance().removeRouteResultHandler(this);
          return;
          if (NavRoutePlanModel.getInstance().getEntry() != 16) {
            break;
          }
        } while (BaiduNaviManager.getInstance().getMapHandler() == null);
        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3030).sendToTarget();
        return;
        NavRoutePlanController.this.lauchIPONavi();
        return;
      }
      if (NavRoutePlanModel.getInstance().getEntry() == 16)
      {
        NavRoutePlanController.this.reCalRouteForDrivingCar();
        return;
      }
      if (BaiduNaviManager.getInstance().getMapHandler() != null) {
        BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3060).sendToTarget();
      }
      NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
      BNRoutePlaner.getInstance().removeRouteResultHandler(this);
    }
  };
  private NavRoutePlanObserver mRoutePlanObserver = null;
  private int mRoutePlanType = -1;
  private int reCalNum = 2;
  
  private NavRoutePlanController()
  {
    VMsgDispatcher.registerMsgHandler(this.mHandler);
    this.mMapSearchAPIWrapper = new MapSearchAPIWrapper("test");
  }
  
  private void addWdAddrInRouteNode(RouteNode paramRouteNode)
  {
    if ((!"我的位置".equals(paramRouteNode.mName)) && (!TextUtils.isEmpty(paramRouteNode.mAddr)) && (!paramRouteNode.mName.contains(" " + paramRouteNode.mAddr))) {
      paramRouteNode.mName = (paramRouteNode.mName + " " + paramRouteNode.mAddr);
    }
  }
  
  private void cancelMapLightSearch()
  {
    NavLogUtils.e(TAG, "cancelMapLightSearch mMapLightSearchRequestID =" + this.mMapLightSearchRequestID);
    if ((this.mHandler != null) && (this.mHandler.hasMessages(4445))) {
      this.mHandler.removeMessages(4445);
    }
    NavMapAdapter.getInstance().cancleRequest(this.mMapSearchAPIWrapper, this.mMapLightSearchRequestID);
    this.mMapLightSearchRequestID = -1;
  }
  
  private boolean checkNodeIsValid(RouteNode paramRouteNode1, RouteNode paramRouteNode2, int paramInt)
  {
    boolean bool2;
    if ((paramRouteNode1 == null) || (paramRouteNode2 == null)) {
      bool2 = false;
    }
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = true;
        paramRouteNode1 = paramRouteNode1.mGeoPoint;
        if ((paramRouteNode1 == null) || (paramRouteNode1.getLatitudeE6() < 1) || (paramRouteNode1.getLongitudeE6() < 1))
        {
          UserOPController.getInstance().add("9.1", "" + paramInt, null, null);
          bool1 = false;
        }
        paramRouteNode1 = paramRouteNode2.mGeoPoint;
        bool2 = bool1;
      } while (paramRouteNode2.mFromType == 2);
      if ((paramRouteNode1 == null) || (paramRouteNode1.getLatitudeE6() < 1)) {
        break;
      }
      bool2 = bool1;
    } while (paramRouteNode1.getLongitudeE6() >= 1);
    UserOPController.getInstance().add("9.2", "" + paramInt, null, null);
    return false;
  }
  
  public static NavRoutePlanController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavRoutePlanController();
    }
    return sInstance;
  }
  
  private void gotoRouteGuideViewDirectly(String paramString)
  {
    int j = NavRoutePlanModel.getInstance().getEntry();
    NavLogUtils.e(TAG, "NavRoutePlanController.handleMessage() selectRoute -> showRouteGuide(). entry= " + j);
    NavRoutePlanModel.getInstance().setmNavEnter("route_nav");
    int i;
    if (NavMapAdapter.getInstance().isGpsEnabled()) {
      if (NavMapAdapter.getInstance().isGPSLocationValid())
      {
        i = 1;
        BNRoutePlaner.getInstance().triggerGPSStatus(i);
        if (j != 16) {
          break label184;
        }
        this.mIsRequestShowRouteGuideView = false;
        if (BaiduNaviManager.getInstance().getMapHandler() != null) {
          BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3030).sendToTarget();
        }
      }
    }
    for (;;)
    {
      BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", "route_nav");
      if (BNSettingManager.isShowJavaLog()) {
        SDKDebugFileUtil.get("RoutePlan_debug").add(" NavRoutePlanController.gotoRouteGuideViewDirectly() selectRoute -> showRouteGuide(). entry= " + j + " gpsState= " + i);
      }
      return;
      i = 2;
      break;
      i = 0;
      break;
      label184:
      if (j == 10)
      {
        this.mIsRequestShowRouteGuideView = false;
        lauchIPONavi();
      }
      else
      {
        this.mIsRequestShowRouteGuideView = false;
        Bundle localBundle = createNaviParam(NavRouteGuideController.getInstance().getLocateMode(), false);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        localBundle.putString("selected_route_mrsl", str);
        NavRouteGuideController.getInstance().startRouteGuideView(false, localBundle);
        NavRouteGuideController.getInstance().setLocateMode(1);
      }
    }
  }
  
  private void initMapSearchListener()
  {
    this.mMapComponentCallback = new BNRoutePlaner.MapComponentCallback()
    {
      public int onMapComponentCall(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        NavLogUtils.e(NavRoutePlanController.TAG, "MapComponentCallback.onMapComponentCall() type=" + paramAnonymousInt1 + ", arg1=" + paramAnonymousInt2 + ", arg2=" + paramAnonymousInt3);
        paramAnonymousInt3 = NavRoutePlanModel.getInstance().getEntry();
        NavLogUtils.e(NavRoutePlanController.TAG, "onMapComponentCall() entry=" + paramAnonymousInt3);
        switch (paramAnonymousInt1)
        {
        default: 
        case 1: 
        case 32: 
          for (;;)
          {
            return -1;
            if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)))
            {
              NavRoutePlanController.access$402(NavRoutePlanController.this, paramAnonymousInt2);
              NavRoutePlanController.access$102(NavRoutePlanController.this, (String)paramAnonymousObject);
              NavRoutePlanController.this.mRPHandler.sendEmptyMessage(4444);
              return 1;
              NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
              if ((NavRoutePlanController.this.mRoutePlanType != 2) && (BaiduNaviManager.getInstance().getMapHandler() != null)) {
                BaiduNaviManager.getInstance().getMapHandler().sendEmptyMessage(1001);
              }
              if (NavRoutePlanController.this.mMapLightSearchRequestID != -1) {
                NavRoutePlanController.this.cancelMapLightSearch();
              }
              BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
            }
          }
        }
        if (!NavComponentController.getInstance().invokeCollada()) {
          NavComponentController.getInstance().loadColladaSo(CloudlConfigDataModel.getInstance().mCommonConfig.colladaComponentDownload);
        }
        NavRoutePlanModel.getInstance().mRoutePlanResultOK = true;
        if (NavRoutePlanController.this.mRoutePlanType == 2)
        {
          BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "route_plan", "nav_nav");
          if (NavMapAdapter.getInstance().isGpsEnabled()) {
            if (NavMapAdapter.getInstance().isGPSLocationValid())
            {
              paramAnonymousInt1 = 1;
              BNRoutePlaner.getInstance().triggerGPSStatus(paramAnonymousInt1);
              NavRoutePlanModel.getInstance().setmNavEnter("nav_nav");
              if (paramAnonymousInt3 != 16) {
                break label518;
              }
              NavLogUtils.e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_IPO_NO_LOADING");
              if (BaiduNaviManager.getInstance().getMapHandler() != null) {
                BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3030).sendToTarget();
              }
              label377:
              BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", "nav_nav");
              if (BaiduNaviManager.getInstance().isNaviBegin()) {
                NavAoiRender.INSTANCE.renderAoiByStartBid();
              }
              if ((NavRoutePlanController.this.mRoutePlanType != 0) || (NavRoutePlanModel.getInstance().getRouteInfoStatus() != 2)) {
                BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
              }
              if ((NavRoutePlanController.this.mRoutePlanType == 0) && (NavRoutePlanController.this.isMulRoutePlan)) {
                BNRoutePlaner.getInstance().removeRouteResultHandler(NavRoutePlanController.this.mRPHandler);
              }
              paramAnonymousObject = NavRoutePlanController.this;
              if (NavRoutePlanController.this.mRoutePlanType != 0) {
                break label1066;
              }
            }
          }
        }
        label518:
        label827:
        label939:
        label1066:
        for (boolean bool = true;; bool = false)
        {
          ((NavRoutePlanController)paramAnonymousObject).statisticsRoutePlanSuc(bool);
          return 1;
          paramAnonymousInt1 = 2;
          break;
          paramAnonymousInt1 = 0;
          break;
          if (paramAnonymousInt3 == 10)
          {
            NavLogUtils.e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_ROUTE_SELECT_ROUTE");
            if (BaiduNaviManager.getInstance().isNaviBegin()) {
              break label377;
            }
            NavRoutePlanController.this.lauchIPONavi();
            break label377;
          }
          if (paramAnonymousInt3 == 7)
          {
            NavLogUtils.e(NavRoutePlanController.TAG, "onMapComponentCall() ROUTE_PLAN_ENTRY_OPENAPI");
            localObject = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf();
            paramAnonymousObject = new Bundle();
            ((Bundle)paramAnonymousObject).putByteArray("pb_data", (byte[])localObject);
            if (BaiduNaviManager.getInstance().getMapHandler() != null)
            {
              localObject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1002);
              a.a().r = true;
              ((Message)localObject).obj = paramAnonymousObject;
              ((Message)localObject).sendToTarget();
            }
          }
          if (PerformStatItem.sUserTest)
          {
            PerformStatItem.sPoiToNaviTime9 = System.currentTimeMillis();
            PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("9", "SDK到适配层v2", "NaviSDK", PerformStatItem.sPoiToNaviTime8, PerformStatItem.sPoiToNaviTime9);
          }
          if ((BaiduNaviManager.getInstance().isNaviBegin()) || (NavRoutePlanController.this.mHasDirectyStartRouteGuide)) {
            break label377;
          }
          if (NavRouteGuideController.getInstance().getLocateMode() == 1)
          {
            NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.this.createNaviParam(1, true));
            break label377;
          }
          NavRouteGuideController.getInstance().setLocateMode(1);
          NavRouteGuideController.getInstance().startRouteGuideView(false, NavRoutePlanController.this.createNaviParam(2, true));
          break label377;
          paramAnonymousObject = BNRoutePlaner.getInstance().getRoutePlanResultMapProtoBuf(NavRoutePlanController.this.entryToCarsDataType(paramAnonymousInt3));
          if ((NavMapAdapter.getInstance().getDebugConfigUserTest()) && (paramAnonymousObject != null)) {
            PerformStatisticsController.getInstance().addDataLog(2110, 1, "CarRoutePlanData", "15", "NaviSDK", "DataSizeHandleAfterEngineAnalysis", paramAnonymousObject.length);
          }
          Object localObject = NavRoutePlanController.TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("NavDrivingCar===rpHandle RP_SUCCESS_NORMAL routePB.lenth=");
          if (paramAnonymousObject == null)
          {
            paramAnonymousInt1 = 0;
            NavLogUtils.e((String)localObject, paramAnonymousInt1);
            if ((paramAnonymousObject != null) && (paramAnonymousObject.length != 0)) {
              break label939;
            }
            if (BaiduNaviManager.getInstance().getMapHandler() != null) {
              BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1031).sendToTarget();
            }
          }
          for (;;)
          {
            NavCommonFuncModel.getInstance().mNaviEndTime = SystemClock.elapsedRealtime();
            NavLogUtils.e("route_plan_time", "success.navi_time=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
            break;
            paramAnonymousInt1 = paramAnonymousObject.length;
            break label827;
            localObject = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
            if ((localObject != null) && (((RoutePlanModel)localObject).getEnComfrom() == 21))
            {
              NavRoutePlanController.this.savePreloadRouteJsonResult((byte[])paramAnonymousObject);
            }
            else
            {
              localObject = new Bundle();
              ((Bundle)localObject).putByteArray("pb_data", (byte[])paramAnonymousObject);
              if (BaiduNaviManager.getInstance().getMapHandler() != null)
              {
                paramAnonymousObject = BaiduNaviManager.getInstance().getMapHandler().obtainMessage(1002);
                a.a().r = true;
                ((Message)paramAnonymousObject).obj = localObject;
                ((Message)paramAnonymousObject).sendToTarget();
              }
              BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "route_plan", "route_nav");
            }
          }
        }
      }
    };
    BNRoutePlaner.setMapComponentCallback(this.mMapComponentCallback);
  }
  
  private boolean isCanStartNavPageDirectly(RouteNode paramRouteNode1, RouteNode paramRouteNode2, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt == 16) || (paramInt == 10)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramInt != 7);
        if ((paramRouteNode1 == null) || (paramRouteNode2 == null) || ((paramRouteNode1.mFromType != 1) && (paramRouteNode1.mFromType != 3))) {
          break;
        }
        bool1 = bool2;
      } while (paramRouteNode2.mFromType == 1);
      bool1 = bool2;
    } while (paramRouteNode2.mFromType == 3);
    return false;
  }
  
  private void reCalRouteForDrivingCar()
  {
    if (this.reCalNum > 0)
    {
      this.reCalNum -= 1;
      RouteNode localRouteNode1 = NavRoutePlanModel.getInstance().getStartRouteNode();
      RouteNode localRouteNode2 = NavRoutePlanModel.getInstance().getEndRouteNode();
      List localList = NavRoutePlanModel.getInstance().getViaNodes();
      int i = NavRoutePlanModel.getInstance().getPreference();
      int j = NavRoutePlanModel.getInstance().getDriveRefTimeInterval();
      int k = NavRoutePlanModel.getInstance().getDriveRefTimeDuration();
      int m = NavRoutePlanModel.getInstance().getStrategy();
      int n = NavRoutePlanModel.getInstance().getEntry();
      BaiduNaviManager.getInstance().calcRouteToNaviRoute(localRouteNode1, localRouteNode2, localList, i, j, k, m, n);
      return;
    }
    this.reCalNum = 2;
    if (BaiduNaviManager.getInstance().getMapHandler() != null) {
      BaiduNaviManager.getInstance().getMapHandler().obtainMessage(3060).sendToTarget();
    }
    NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
  }
  
  private void savePreloadRouteJsonResult(byte[] paramArrayOfByte) {}
  
  private boolean selectRouteToIpoNav(final String paramString, boolean paramBoolean1, boolean paramBoolean2, final int paramInt)
  {
    if (BNRoutePlaner.getInstance().isBuildRouteReady(false, paramString))
    {
      if (BNRoutePlaner.getInstance().selectRouteWithMrsl(paramString) >= 0)
      {
        gotoRouteGuideViewDirectly(paramString);
        return true;
      }
      getInstance().setRequestShowRouteGuideView(false);
      return false;
    }
    Object localObject = NavCommonFuncModel.getInstance().getActivity();
    if ((localObject != null) && (paramInt != 16))
    {
      NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity)localObject, null, null, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          BNRoutePlaner.setSelectRouteCallback(null);
          paramAnonymousDialogInterface = BaiduNaviManager.getInstance().getNaviMainHandler();
          if ((paramAnonymousDialogInterface != null) && (paramAnonymousDialogInterface.hasMessages(3))) {
            paramAnonymousDialogInterface.removeMessages(3);
          }
        }
      });
      localObject = BaiduNaviManager.getInstance().getNaviMainHandler();
      if (localObject != null)
      {
        if (((Handler)localObject).hasMessages(3)) {
          ((Handler)localObject).removeMessages(3);
        }
        ((Handler)localObject).sendEmptyMessageDelayed(3, 60000L);
      }
    }
    BNRoutePlaner.setSelectRouteCallback(new BNRoutePlaner.MapComponentCallback()
    {
      public int onMapComponentCall(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt1)
        {
        }
        do
        {
          do
          {
            return 0;
            if (paramInt != 16)
            {
              NavMapAdapter.getInstance().dismissMProgressDialog();
              paramAnonymousObject = BaiduNaviManager.getInstance().getNaviMainHandler();
              if ((paramAnonymousObject != null) && (((Handler)paramAnonymousObject).hasMessages(3))) {
                ((Handler)paramAnonymousObject).removeMessages(3);
              }
            }
            if (BNRoutePlaner.getInstance().selectRouteWithMrsl(paramString) >= 0)
            {
              NavRoutePlanController.this.gotoRouteGuideViewDirectly(paramString);
              return 0;
            }
            NavRoutePlanController.getInstance().setRequestShowRouteGuideView(false);
            return 0;
          } while (paramInt == 16);
          NavMapAdapter.getInstance().dismissMProgressDialog();
          paramAnonymousObject = BaiduNaviManager.getInstance().getNaviMainHandler();
        } while ((paramAnonymousObject == null) || (!((Handler)paramAnonymousObject).hasMessages(3)));
        ((Handler)paramAnonymousObject).removeMessages(3);
        return 0;
      }
    });
    return true;
  }
  
  private boolean startNavPageDirectly(RouteNode paramRouteNode1, RouteNode paramRouteNode2, int paramInt)
  {
    if ((paramInt == 16) || (paramInt == 10)) {
      this.mHasDirectyStartRouteGuide = false;
    }
    for (;;)
    {
      return this.mHasDirectyStartRouteGuide;
      if (paramInt != 7)
      {
        if (BNRoutePlaner.getInstance().getComeFrom() != 28) {}
        for (boolean bool = true;; bool = false)
        {
          this.mHasDirectyStartRouteGuide = NavRouteGuideController.getInstance().startRouteGuideView(false, createNaviParam(1, bool));
          break;
        }
      }
      if ((paramRouteNode1 != null) && (paramRouteNode2 != null) && ((paramRouteNode1.mFromType == 1) || (paramRouteNode1.mFromType == 3)) && ((paramRouteNode2.mFromType == 1) || (paramRouteNode2.mFromType == 3))) {
        this.mHasDirectyStartRouteGuide = NavRouteGuideController.getInstance().startRouteGuideView(false, createNaviParam(1, true));
      } else {
        this.mHasDirectyStartRouteGuide = false;
      }
    }
  }
  
  public void calcRouteForPBData(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6)
  {
    NavInitController.getInstance().handleAppSource();
    paramString = BNaviModuleManager.getActivity();
    if (paramString == null) {
      return;
    }
    if (paramRouteNode2.mFromType == 99) {
      paramRouteNode2.mFromType = 1;
    }
    ArrayList localArrayList;
    for (this.isMulRoutePlan = true;; this.isMulRoutePlan = false)
    {
      NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
      NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
      NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = -1;
      NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
      this.mHasDirectyStartRouteGuide = false;
      setRequestShowRouteGuideView(false);
      localArrayList = new ArrayList();
      paramRouteNode1 = NavModelHelper.convertRouteNode(paramRouteNode1);
      if (PerformStatItem.sEnableTestData) {
        paramRouteNode1.setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119D, 40.040642D));
      }
      localArrayList.add(paramRouteNode1);
      if (NavLogUtils.LOGGABLE) {
        NavTipTool.onCreateToastDialog(paramString, "速度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSAccuracy);
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramInt2 = 0;
      while (paramInt2 < paramList.size())
      {
        paramRouteNode1 = (RouteNode)paramList.get(paramInt2);
        if (paramRouteNode1 != null) {
          localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode1));
        }
        paramInt2 += 1;
      }
    }
    localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode2));
    this.mRoutePlanObserver = new NavRoutePlanObserver(paramString, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    NavMapAdapter.getInstance().getCarRoutePlanMrsl();
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    this.mRoutePlanType = 0;
    BNRoutePlaner.getInstance().setCalcPrference(paramInt1);
    BNRoutePlaner.getInstance().setDriveRefTimeParams(30, 1440);
    if (paramInt5 == 2) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      BNRoutePlaner.getInstance().setEntry(paramInt6);
      BNRoutePlaner.getInstance().setPointsToCalcRouteForMap(localArrayList, -1, false, null, paramInt1);
      CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
      NavLogUtils.e(CarNaviTrajectoryModel.TAG, "is from route plan");
      return;
    }
  }
  
  public void calcRouteToNaviRoute(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    NavInitController.getInstance().handleAppSource();
    NavLogUtils.e(TAG, "calcRouteToNaviRoute() unPreference=" + paramInt1 + ", strategy=" + paramInt4);
    Object localObject1 = BNaviModuleManager.getActivity();
    if (localObject1 == null)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteToNaviRoute activity is null");
      return;
    }
    this.mHasDirectyStartRouteGuide = false;
    setRequestShowRouteGuideView(false);
    checkNodeIsValid(paramRouteNode1, paramRouteNode2, paramInt5);
    NavRoutePlanModel.getInstance().setStrategy(2);
    ArrayList localArrayList = new ArrayList();
    NavRoutePlanModel.getInstance().setViaNodes(paramList);
    Object localObject2 = NavModelHelper.convertRouteNode(paramRouteNode1);
    if (PerformStatItem.sEnableTestData) {
      ((RoutePlanNode)localObject2).setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119D, 40.040642D));
    }
    paramRouteNode1.mCityID = ((RoutePlanNode)localObject2).mDistrictID;
    NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
    localArrayList.add(localObject2);
    if (NavLogUtils.LOGGABLE) {
      NavTipTool.onCreateToastDialog((Context)localObject1, "速度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSAccuracy);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramInt2 = 0;
      while (paramInt2 < paramList.size())
      {
        localObject2 = (RouteNode)paramList.get(paramInt2);
        if (localObject2 != null) {
          localArrayList.add(NavModelHelper.convertRouteNode((RouteNode)localObject2));
        }
        paramInt2 += 1;
      }
    }
    paramList = NavModelHelper.convertRouteNode(paramRouteNode2);
    paramRouteNode2.mCityID = paramList.mDistrictID;
    NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
    localArrayList.add(paramList);
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new NavRoutePlanObserver((Activity)localObject1, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    this.mRoutePlanType = 2;
    boolean bool;
    if (NavMapAdapter.getInstance().isGpsEnabled()) {
      if (NavMapAdapter.getInstance().isGPSLocationValid())
      {
        paramInt2 = 1;
        BNRoutePlaner.getInstance().triggerGPSStatus(paramInt2);
        BNRoutePlaner.getInstance().setCalcPrference(paramInt1);
        BNRoutePlaner.getInstance().setEntry(paramInt5);
        if ((paramInt5 != 10) && (paramInt5 != 16) && (paramInt5 != 4)) {
          break label524;
        }
        bool = true;
        label433:
        NavLogUtils.e(CarNaviTrajectoryModel.TAG, "cal-jx 6");
        this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(paramRouteNode1, paramRouteNode2, paramInt5);
        localObject1 = BNRoutePlaner.getInstance();
        if (!bool) {
          break label530;
        }
      }
    }
    label524:
    label530:
    for (paramList = NavMapAdapter.getInstance().getCarRoutePlanMrsl();; paramList = null)
    {
      ((BNRoutePlaner)localObject1).setPointsToCalcRoute(localArrayList, -1, bool, paramList, 0);
      CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
      NavLogUtils.e(CarNaviTrajectoryModel.TAG, "is from route plan");
      startNavPageDirectly(paramRouteNode1, paramRouteNode2, paramInt5);
      return;
      paramInt2 = 2;
      break;
      paramInt2 = 0;
      break;
      bool = false;
      break label433;
    }
  }
  
  public void calcRouteToNaviRoute(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6)
  {
    NavInitController.getInstance().handleAppSource();
    paramString = BNaviModuleManager.getActivity();
    if (paramString == null) {
      return;
    }
    this.mHasDirectyStartRouteGuide = false;
    setRequestShowRouteGuideView(false);
    checkNodeIsValid(paramRouteNode1, paramRouteNode2, paramInt6);
    NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
    NavRoutePlanModel.getInstance().mRoutePlanResultOK = false;
    NavRoutePlanModel.getInstance().mRoutePlanResultFailedType = -1;
    NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject = NavModelHelper.convertRouteNode(paramRouteNode1);
    if (PerformStatItem.sEnableTestData) {
      ((RoutePlanNode)localObject).setGeoPoint(CoordinateTransformUtil.transferWGS84ToGCJ02(116.30119D, 40.040642D));
    }
    localArrayList.add(localObject);
    if (NavLogUtils.LOGGABLE) {
      NavTipTool.onCreateToastDialog(paramString, "速度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSSpeed + ", 精度=" + ((RoutePlanNode)localArrayList.get(0)).mGPSAccuracy);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramInt2 = 0;
      while (paramInt2 < paramList.size())
      {
        localObject = (RouteNode)paramList.get(paramInt2);
        if (localObject != null) {
          localArrayList.add(NavModelHelper.convertRouteNode((RouteNode)localObject));
        }
        paramInt2 += 1;
      }
    }
    localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode2));
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new NavRoutePlanObserver(paramString, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    paramString = GeoLocateModel.getInstance().getDistrictByManMade();
    paramList = paramString;
    if (paramString == null) {
      paramList = GeoLocateModel.getInstance().getCurrentDistrict();
    }
    this.mDistrictID = paramList.mId;
    boolean bool;
    if (!NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData())
    {
      paramInt2 = 1;
      new SearchPoiPager(paramRouteNode1.mName, paramList, 10, paramInt2);
      BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
      NavMapAdapter.getInstance().getCarRoutePlanMrsl();
      BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
      this.mRoutePlanType = 2;
      BNRoutePlaner.getInstance().setCalcPrference(paramInt1);
      BNRoutePlaner.getInstance().setDriveRefTimeParams(30, 1440);
      BNRoutePlaner.getInstance().setEntry(paramInt6);
      if ((paramInt6 != 10) && (paramInt6 != 16) && (paramInt6 != 4)) {
        break label493;
      }
      bool = true;
      label415:
      this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(paramRouteNode1, paramRouteNode2, paramInt6);
      paramString = BNRoutePlaner.getInstance();
      if (!bool) {
        break label499;
      }
    }
    label493:
    label499:
    for (paramList = NavMapAdapter.getInstance().getCarRoutePlanMrsl();; paramList = null)
    {
      paramString.setPointsToCalcRouteForMap(localArrayList, -1, bool, paramList, 0);
      CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
      NavLogUtils.e(CarNaviTrajectoryModel.TAG, "is from route plan");
      startNavPageDirectly(paramRouteNode1, paramRouteNode2, paramInt6);
      return;
      paramInt2 = BNSettingManager.getPrefRoutPlanMode();
      break;
      bool = false;
      break label415;
    }
  }
  
  public void calcRouteWithMapLightPBData(byte[] paramArrayOfByte, int paramInt)
  {
    NavInitController.getInstance().handleAppSource();
    NavLogUtils.e(TAG, "calcRouteWithMapLightPBData() pbDataLen=" + paramInt);
    this.mHasDirectyStartRouteGuide = false;
    setRequestShowRouteGuideView(false);
    int i = NavRoutePlanModel.getInstance().getPreference();
    if (!NavSearchController.getInstance().isFromMap()) {
      i = BNRoutePlaner.getInstance().getTMPCalcPreference();
    }
    try
    {
      boolean bool = BNRoutePlaner.getInstance().calcRouteWithPB(1, 1, null, i, paramArrayOfByte, paramInt);
      NavLogUtils.e(TAG, "NavRoutePlanController.calcRouteWithMapLightPBData() ret" + bool);
      return;
    }
    catch (Throwable paramArrayOfByte) {}
  }
  
  public void calcRouteWithPBData(RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    NavInitController.getInstance().handleAppSource();
    NavLogUtils.e(TAG, "calcRouteWithPBData()");
    NavCommonFuncModel.getInstance().mNaviStartTime = SystemClock.elapsedRealtime();
    NavLogUtils.e("route_plan_time", "navi_time_diff_map_start=" + (NavCommonFuncModel.getInstance().mNaviStartTime - NavCommonFuncModel.getInstance().mMapStartTime) + "ms");
    this.mHasDirectyStartRouteGuide = false;
    setRequestShowRouteGuideView(false);
    Activity localActivity = BNaviModuleManager.getActivity();
    if (localActivity == null)
    {
      SDKDebugFileUtil.getInstance().addCoreLog("CoreLog_Common: ", "calcRouteWithPBData activity is null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode1));
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        paramRouteNode1 = (RouteNode)paramList.get(i);
        if (paramRouteNode1 != null) {
          localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode1));
        }
        i += 1;
      }
    }
    localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode2));
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new NavRoutePlanObserver(localActivity, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    this.mRoutePlanType = 1;
    BNRoutePlaner.getInstance().setCalcPrference(paramInt1);
    BNRoutePlaner.getInstance().SetCalcRouteNetMode(3);
    BNRoutePlaner.getInstance().setEntry(8);
    BNRoutePlaner.getInstance().setComeFrom(8);
    boolean bool = BNRoutePlaner.getInstance().calcRouteWithPB(1, 0, localArrayList, paramInt1, paramArrayOfByte, paramInt2);
    NavLogUtils.e(TAG, "NavRoutePlanController.calcRouteWithPBData() ret" + bool);
    CarNaviTrajectoryModel.getInstance().isFromRoutePlan = true;
    NavLogUtils.e(CarNaviTrajectoryModel.TAG, "is from route plan");
  }
  
  public void cancleCalcRouteRequest()
  {
    this.mHasDirectyStartRouteGuide = false;
    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
  }
  
  public boolean clearRouteBuffer()
  {
    return BNRoutePlaner.getInstance().clearRouteBuffer();
  }
  
  public void continueLastNavi(ArrayList<RoutePlanNode> paramArrayList)
  {
    this.mHasDirectyStartRouteGuide = false;
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {}
    do
    {
      return;
      localObject = (RoutePlanNode)paramArrayList.get(0);
      final RoutePlanNode localRoutePlanNode = (RoutePlanNode)paramArrayList.get(paramArrayList.size() - 1);
      if (localObject != null) {
        ((RoutePlanNode)localObject).mNodeType = 3;
      }
      if (localRoutePlanNode != null) {
        localRoutePlanNode.mNodeType = 1;
      }
      BNRoutePlaner.getInstance().addRouteResultHandler(new BNMainLooperHandler()
      {
        public void onMessage(Message paramAnonymousMessage)
        {
          NavLogUtils.e(NavRoutePlanController.TAG, "continueLastNavi calc route msg.what:" + paramAnonymousMessage.what);
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          case 4: 
            NavLogUtils.e(NavRoutePlanController.TAG, "continueLastNavi calc route success");
            BNRoutePlaner.getInstance().removeRouteResultHandler(this);
            NavUserBehaviour.getInstance().sendNaviStatisticsTransfer(localObject, localRoutePlanNode, "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), "nav_nav");
            return;
          case 7: 
            BNRoutePlaner.getInstance().removeRouteResultHandler(this);
            return;
          }
          BNRoutePlaner.getInstance().removeRouteResultHandler(this);
        }
      });
      localObject = NavCommonFuncModel.getInstance().getActivity();
    } while (localObject == null);
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new NavRoutePlanObserver((Activity)localObject, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    NavRoutePlanModel.getInstance().setEntry(22);
    BNRoutePlaner.getInstance().setEntry(22);
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    int i = NavMapAdapter.getInstance().onGetLastPreferValue();
    NavMapAdapter.getInstance().setPreferValue(i);
    final Object localObject = BNSettingManager.getPlateFromLocal(NavMapAdapter.getInstance().getJNIInitializerContext());
    NavMapAdapter.getInstance().setCalcPrference(i);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      BNRoutePlaner.getInstance().setCalcPrefCarNo((String)localObject);
    }
    this.mRoutePlanObserver.isDirectlyEnterNavPage = isCanStartNavPageDirectly(null, null, 22);
    BNRoutePlaner.getInstance().setComeFrom(22);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramArrayList, 0);
    NavLogUtils.e(TAG, "continueLastNavi calc route ");
    startNavPageDirectly(null, null, 22);
  }
  
  public Bundle createNaviParam(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("routeguide_view_mode", 1);
    localBundle.putInt("calroute_done", 0);
    RouteNode localRouteNode = NavRoutePlanModel.getInstance().getStartRouteNode();
    NavGeoPoint localNavGeoPoint;
    if (localRouteNode != null)
    {
      localNavGeoPoint = localRouteNode.mGeoPoint;
      if (localNavGeoPoint != null)
      {
        localBundle.putInt("start_x", localNavGeoPoint.getLongitudeE6());
        localBundle.putInt("start_y", localNavGeoPoint.getLatitudeE6());
      }
    }
    try
    {
      localBundle.putString("start_name", localRouteNode.mName);
      localRouteNode = NavRoutePlanModel.getInstance().getEndRouteNode();
      if (localRouteNode != null)
      {
        localNavGeoPoint = localRouteNode.mGeoPoint;
        if (localNavGeoPoint != null)
        {
          localBundle.putInt("end_x", localNavGeoPoint.getLongitudeE6());
          localBundle.putInt("end_y", localNavGeoPoint.getLatitudeE6());
        }
      }
      try
      {
        localBundle.putString("end_name", localRouteNode.mName);
        localBundle.putInt("locate_mode", paramInt);
        localBundle.putBoolean("net_refresh", true);
        localBundle.putBoolean("show_fullview", paramBoolean);
        localBundle.putBoolean("car_result_has_show_anim", false);
        return localBundle;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public int entryToCarsDataType(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    case 31: 
    default: 
      if (getRoutePlanNaviMode() == 2) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      NavLogUtils.e(TAG, "entryToCarsDataType() entry=" + paramInt + ", type=" + i);
      return i;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public int getFailTypePermissionDenied()
  {
    return 5092;
  }
  
  public Bundle getHomeAndCompanyRouteInfo(RouteNode paramRouteNode1, RouteNode paramRouteNode2, int paramInt1, int paramInt2)
  {
    return BNRoutePlaner.getInstance().getHomeAndCompanyRouteInfo(NavModelHelper.convertRouteNode(paramRouteNode1), NavModelHelper.convertRouteNode(paramRouteNode2), NavMapAdapter.getInstance().onGetLastPreferValue(), paramInt1, paramInt2, NavRoutePlanModel.getInstance().routePlanStatistcsUrl);
  }
  
  public int getRoutePlanNaviMode()
  {
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    if (localRoutePlanModel != null) {
      return localRoutePlanModel.getEnNaviType();
    }
    return 0;
  }
  
  public int getRoutePlanRequestID()
  {
    return BNRoutePlaner.getInstance().getRoutePlanRequestID();
  }
  
  public Bundle getRoutePlanStatusInfo()
  {
    Bundle localBundle = new Bundle();
    NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = true;
    Object localObject = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    ArrayList localArrayList;
    int i;
    if (localObject != null)
    {
      localArrayList = ((RoutePlanModel)localObject).getRouteInput();
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localObject = (RoutePlanNode)localArrayList.get(i);
        if ((localObject != null) && (((RoutePlanNode)localObject).mFrom != 2) && (((RoutePlanNode)localObject).mGeoPoint != null)) {
          localObject = BNPoiSearcher.getInstance().getDistrictByPoint(((RoutePlanNode)localObject).mGeoPoint, 0);
        }
        for (;;)
        {
          if (localObject != null)
          {
            for (;;)
            {
              if ((localObject != null) && (((DistrictInfo)localObject).mType > 2))
              {
                localObject = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject).mId);
                continue;
                if ((localObject != null) && (((RoutePlanNode)localObject).mDistrictID > 1))
                {
                  localObject = BNPoiSearcher.getInstance().getDistrictById(((RoutePlanNode)localObject).mDistrictID);
                  break;
                }
                localObject = null;
                break;
              }
            }
            if ((localObject != null) && (((DistrictInfo)localObject).mType == 2))
            {
              NavRoutePlanModel localNavRoutePlanModel = NavRoutePlanModel.getInstance();
              localNavRoutePlanModel.mIsContainsAllNodeOfflineData &= BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId);
              if (NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData) {
                break label421;
              }
            }
          }
        }
      }
      for (;;)
      {
        NavLogUtils.e(TAG, "getRoutePlanStatusInfo() result=" + NavRoutePlanModel.getInstance().mRoutePlanResultOK + ", failedType=" + NavCommonFuncController.getInstance().getFormatErrorCode(NavRoutePlanModel.getInstance().mRoutePlanResultFailedType) + ", netmode=" + BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() + ", hasOfflineData=" + NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData + ", calcTime=" + (NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime) + "ms");
        localBundle.putBoolean("result", NavRoutePlanModel.getInstance().mRoutePlanResultOK);
        localBundle.putInt("failed_type", NavCommonFuncController.getInstance().getFormatErrorCode(NavRoutePlanModel.getInstance().mRoutePlanResultFailedType));
        localBundle.putInt("netmode", BNRoutePlaner.getInstance().getEngineCalcRouteNetMode());
        localBundle.putBoolean("has_offline_data", NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData);
        localBundle.putLong("time", NavCommonFuncModel.getInstance().mNaviEndTime - NavCommonFuncModel.getInstance().mNaviStartTime);
        return localBundle;
        NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
        break;
        NavRoutePlanModel.getInstance().mIsContainsAllNodeOfflineData = false;
      }
      label421:
      i += 1;
    }
  }
  
  public String getTRURlParam()
  {
    if (NavLogUtils.LOGGABLE) {
      NavLogUtils.e(TAG, "getTRURlParam() =" + BNRoutePlaner.getInstance().getTRURlParam());
    }
    try
    {
      String str = BNRoutePlaner.getInstance().getTRURlParam();
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void init()
  {
    initMapSearchListener();
    setCarInfo(NavMapAdapter.getInstance().getCarInfoFromMap());
    if (NavMapAdapter.getInstance().getDebugConfigUserTest())
    {
      PerformStatItem.sUserTest = NavMapAdapter.getInstance().getDebugConfigUserTest();
      PerformStatisticsController.getInstance().setPerformStatListener(this.mPerformStatListener);
    }
  }
  
  public void lauchIPONavi()
  {
    Object localObject = BaiduNaviManager.getInstance().getMapHandler();
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1031);
      if (localObject != null) {
        ((Message)localObject).sendToTarget();
      }
    }
    NavMapAdapter.getInstance().removeRequestByType(NavMapAdapter.getInstance().getResultKeyMCarRoute());
    new Bundle().putString("slight", "com.baidu.BaiduMap");
  }
  
  public boolean removeRoute(int paramInt)
  {
    return BNRouteGuider.getInstance().removeRoute(paramInt);
  }
  
  public boolean selectRouteToNavi(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    NavLogUtils.e(TAG, "NavRoutePlanController.selectRouteToNavi() mrsl=" + paramString + "  entry= " + paramInt);
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if (localActivity == null) {
      return false;
    }
    this.mHasDirectyStartRouteGuide = false;
    getInstance().setRequestShowRouteGuideView(true);
    NavRouteGuideController localNavRouteGuideController = NavRouteGuideController.getInstance();
    if (paramBoolean1) {}
    for (int i = 1;; i = 2)
    {
      localNavRouteGuideController.setLocateMode(i);
      NavRoutePlanModel.getInstance().setEntry(paramInt);
      this.mRoutePlanObserver = null;
      this.mRoutePlanObserver = new NavRoutePlanObserver(localActivity, new RoutePlanObserver.IJumpToDownloadListener()
      {
        public void onJumpToDownloadOfflineData()
        {
          BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
        }
      });
      BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
      if ((paramInt == 16) || (paramInt == 10)) {
        break label173;
      }
      if (BNRoutePlaner.getInstance().selectRouteWithMrsl(paramString) < 0) {
        break;
      }
      gotoRouteGuideViewDirectly(paramString);
      return true;
    }
    getInstance().setRequestShowRouteGuideView(false);
    return false;
    label173:
    return selectRouteToIpoNav(paramString, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void setBNotBuildCarData(boolean paramBoolean)
  {
    BNRoutePlaner.bNotBuildCarData = paramBoolean;
  }
  
  public void setCarInfo(NavCarInfo paramNavCarInfo)
  {
    if ((paramNavCarInfo != null) && (paramNavCarInfo.carPANumber != null) && (paramNavCarInfo.carPANumber.length() > 0)) {}
    try
    {
      BNRoutePlaner.getInstance().setCalcPrefCarNo(paramNavCarInfo.carPANumber);
      return;
    }
    catch (Throwable paramNavCarInfo) {}
  }
  
  public boolean setDestNodes(List<RouteNode> paramList, RouteNode paramRouteNode)
  {
    NavLogUtils.e(TAG, "setDestsWithPBData() ");
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        RouteNode localRouteNode = (RouteNode)paramList.get(i);
        if (localRouteNode != null) {
          localArrayList.add(NavModelHelper.convertRouteNode(localRouteNode));
        }
        i += 1;
      }
    }
    localArrayList.add(NavModelHelper.convertRouteNode(paramRouteNode));
    NavLogUtils.e(TAG, "setDestsWithPBData() ret " + false);
    return false;
  }
  
  public void setRequestShowRouteGuideView(boolean paramBoolean)
  {
    this.mIsRequestShowRouteGuideView = paramBoolean;
  }
  
  public void statisticsRoutePlanSuc()
  {
    statisticsRoutePlanSuc(false);
  }
  
  public void statisticsRoutePlanSuc(boolean paramBoolean)
  {
    UserOPController.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
    RoutePlanStatItem.getInstance().startRoutePlanStat = true;
    NaviStatItem.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
    NaviIPOStatItem.getInstance().setSessionId(BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
    Object localObject = "";
    UserOP localUserOP = new UserOP();
    localUserOP.op = "2.1";
    if (paramBoolean) {
      switch (BNRoutePlaner.currentDesNode.mFrom)
      {
      default: 
        localUserOP.a = "";
      }
    }
    for (;;)
    {
      UserOPController.getInstance().cacheOP(localUserOP);
      return;
      String str2 = BNRoutePlaner.currentDesNode.getUID();
      String str1;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2;
      }
      try
      {
        if (str2.length() >= 2) {
          str1 = str2.substring(str2.length() - 2);
        }
        str1 = URLEncoder.encode(str1, "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;) {}
      }
      localUserOP.b = ((String)localObject);
      continue;
      localUserOP.a = "";
      continue;
      if (!TextUtils.isEmpty(BNRoutePlaner.currentDesNode.getName())) {}
      try
      {
        str1 = URLEncoder.encode(BNRoutePlaner.currentDesNode.getName(), "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        for (;;) {}
      }
      localUserOP.c = ((String)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavRoutePlanController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */