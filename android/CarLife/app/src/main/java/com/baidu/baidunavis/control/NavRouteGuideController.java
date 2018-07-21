package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.android.common.util.CommonParam;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.stat.NavUserBehaviour;
import com.baidu.baidunavis.ui.BNCruiserFragment;
import com.baidu.baidunavis.ui.BNRouteGuideFragment;
import com.baidu.baidunavis.ui.NavFragmentManager;
import com.baidu.baidunavis.ui.widget.BNLoadingView;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.MainActivity;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator.NavUserBehaviourCallback;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.LoadingProxy;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.ViewActionListener;
import com.baidu.navisdk.ui.widget.RoutePlanObserver;
import com.baidu.navisdk.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.c;
import java.util.ArrayList;
import java.util.List;

public class NavRouteGuideController
{
  public static final int MSG_PRELOAD_ROUTEGUIDE_VIEW = 1;
  public static final String TAG = NavRouteGuideController.class.getSimpleName();
  private static NavRouteGuideController sInstance = null;
  private Boolean hasSetPreference = Boolean.valueOf(false);
  private BNavigatorListener mBNavigatorListener = null;
  private Handler mHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      RGViewController.getInstance().preloadViews(NavCommonFuncModel.getInstance().getActivity());
    }
  };
  private boolean mIsThirdServer = false;
  private BNLoadingViewProxy.LoadingProxy mLoadingProxy;
  private BNLoadingView mLoadingView;
  private BNavigator.NavUserBehaviourCallback mNavUserBehaviourCallback = new BNavigator.NavUserBehaviourCallback()
  {
    public boolean isShouldShowNaviResult()
    {
      String str = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getEndName(NavCommonFuncModel.getInstance().getActivity(), true);
      int i = NavTrajectoryController.getInstance().endRecord(str, true, 1);
      UserOPController.getInstance().add("8.2.2", "1", "" + i, null);
      return i == 0;
    }
    
    public void onCarLogoPageShow()
    {
      NavMapAdapter.getInstance().navigateToCarLogoPage();
    }
    
    public boolean onFellowCloseLCS()
    {
      LogUtil.e("onFellowCloseLCS", "NavUserBehaviourCallback   onFellowCloseLCS====");
      return NavLongLinkController.getInstance().CloseLCS();
    }
    
    public boolean onFellowCreateLCS()
    {
      LogUtil.e("onFellowCreateLCS", "NavUserBehaviourCallback   onFellowCreateLCS====");
      return NavLongLinkController.getInstance().createLCS();
    }
    
    public int onFellowGetReqId()
    {
      LogUtil.e("onFellowGetReqId", "NavUserBehaviourCallback   onFellowGetReqId====");
      return NavLongLinkController.getInstance().GetReqId();
    }
    
    public boolean onFellowRegisterLCS()
    {
      LogUtil.e("onFellowRegisterLCS", "NavUserBehaviourCallback   onFellowRegisterLCS====");
      return NavLongLinkController.getInstance().registerLCS();
    }
    
    public Bundle onFellowSendData(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, String paramAnonymousString1, String paramAnonymousString2)
    {
      LogUtil.e("onFellowSendData", "NavUserBehaviourCallback   onFellowSendData====");
      return NavLongLinkController.getInstance().SendData(paramAnonymousInt, paramAnonymousArrayOfByte, paramAnonymousString1, paramAnonymousString2);
    }
    
    public boolean onFellowUnregisterLCS()
    {
      LogUtil.e("onFellowUnregisterLCS", "NavUserBehaviourCallback   onFellowUnregisterLCS====");
      return NavLongLinkController.getInstance().unRegisterLCS();
    }
    
    public void onRoutePlan()
    {
      LogUtil.e("onRoutePlan", "NavUserBehaviourCallback   onRoutePlan====");
      BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "route_plan", NavRoutePlanModel.getInstance().getmNavEnter());
    }
    
    public void onShowMenu()
    {
      LogUtil.e("onShowMenu", "NavUserBehaviourCallback   onShowMenu====");
      BaiduNaviManager.getInstance().sendNaviStatistics(null, null, "settings", "naving_set");
    }
    
    public void onUgcPageShow(int paramAnonymousInt, String paramAnonymousString)
    {
      LogUtil.e("onUgcPageShow", "pageType urlStr " + paramAnonymousInt + " " + paramAnonymousString);
    }
    
    public void onYawing()
    {
      LogUtil.e("onYawing", "NavUserBehaviourCallback   onYawing====");
      BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "yaw", NavRoutePlanModel.getInstance().getmNavEnter());
    }
    
    public void registerLoadingProxy()
    {
      NavRouteGuideController.access$002(NavRouteGuideController.this, new BNLoadingViewProxy.LoadingProxy()
      {
        public View getLoadingView()
        {
          if (NavRouteGuideController.this.mLoadingView == null)
          {
            NavRouteGuideController.access$102(NavRouteGuideController.this, new BNLoadingView(NavCommonFuncModel.getInstance().getActivity()));
            NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(1);
          }
          return NavRouteGuideController.this.mLoadingView;
        }
        
        public void onLoadingEnd(int paramAnonymous2Int, boolean paramAnonymous2Boolean, ViewGroup paramAnonymous2ViewGroup, final BNLoadingViewProxy.ViewActionListener paramAnonymous2ViewActionListener)
        {
          if (paramAnonymous2Int == 1) {
            RGMapModeViewController.getInstance().dismissUgcDetailViewShowProgressDialog();
          }
          while ((paramAnonymous2Boolean) || (NavRouteGuideController.this.mLoadingView == null)) {
            return;
          }
          NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(3);
          NavRouteGuideController.this.mLoadingView.setLoadFailAction("加载失败, ", new View.OnClickListener()
          {
            public void onClick(View paramAnonymous3View)
            {
              paramAnonymous2ViewActionListener.onAction(1);
            }
          });
        }
        
        public void onLoadingStart(int paramAnonymous2Int, ViewGroup paramAnonymous2ViewGroup)
        {
          if (paramAnonymous2Int == 1) {
            RGMapModeViewController.getInstance().showUgcDetailViewShowProgressDialog();
          }
          while (paramAnonymous2ViewGroup == null) {
            return;
          }
          paramAnonymous2ViewGroup.removeAllViews();
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          NavRouteGuideController.access$102(NavRouteGuideController.this, new BNLoadingView(NavCommonFuncModel.getInstance().getActivity()));
          NavRouteGuideController.this.mLoadingView.resetBottomLoadtab(1);
          paramAnonymous2ViewGroup.addView(NavRouteGuideController.this.mLoadingView, localLayoutParams);
        }
      });
      BNRCEventDetailsViewController.getInstance().setLoadingProxy(NavRouteGuideController.this.mLoadingProxy);
    }
    
    public void unRegisterLoadingProxy()
    {
      BNRCEventDetailsViewController.getInstance().setLoadingProxy(null);
      NavRouteGuideController.access$002(NavRouteGuideController.this, null);
      NavRouteGuideController.access$102(NavRouteGuideController.this, null);
    }
  };
  private boolean mNewGuideIsThirdServer = false;
  private int mRouteGuideLocateMode = 1;
  private int mRouteGuidePreference = 1;
  private RoutePlanObserver mRoutePlanObserver = null;
  
  public static NavRouteGuideController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavRouteGuideController();
    }
    return sInstance;
  }
  
  private void startRGActivity(Context paramContext, GeoPoint paramGeoPoint1, String paramString1, GeoPoint paramGeoPoint2, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        NavRoutePlanModel.getInstance().setmNavEnter("nav_nav");
        NavUserBehaviour.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), "nav_nav");
      }
    }
    else
    {
      BNRoutePlaner.getInstance().EnableRoadCondition(true);
      localBundle = new Bundle();
      localBundle.putInt("routeguide_view_mode", 0);
      localBundle.putInt("calroute_done", 0);
      localBundle.putInt("start_x", paramGeoPoint1.getLongitudeE6());
      localBundle.putInt("start_y", paramGeoPoint1.getLatitudeE6());
      localBundle.putInt("end_x", paramGeoPoint2.getLongitudeE6());
      localBundle.putInt("end_y", paramGeoPoint2.getLatitudeE6());
      localBundle.putString("start_name", paramString1);
      localBundle.putString("end_name", paramString2);
      if (paramBoolean1) {
        break label214;
      }
      localBundle.putInt("locate_mode", 2);
    }
    for (;;)
    {
      localBundle.putBoolean("net_refresh", true);
      if (JarUtils.getAsJar()) {
        break label225;
      }
      NavTipTool.onCreateToastDialog(paramContext, 2131296656);
      return;
      NavRoutePlanModel.getInstance().setmNavEnter("route_nav");
      NavUserBehaviour.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", NavRoutePlanModel.getInstance().getStrategyForUserBeh(), "route_nav");
      break;
      label214:
      localBundle.putInt("locate_mode", 1);
    }
    try
    {
      label225:
      NavLogUtils.e(TAG, "startRGActivity() ok");
      NavFragmentManager.getInstance().showNavMapMapPage(BNRouteGuideFragment.class.getName(), localBundle);
      return;
    }
    catch (Exception paramContext)
    {
      NavLogUtils.e(TAG, "startRGActivity() error");
      NavMapAdapter.getInstance().exceptionLog(paramContext);
    }
  }
  
  public void UnSetNavUserBehaviourCallback()
  {
    BNavigator.getInstance().setmNavUserBehaviourCallback(null);
  }
  
  public void backToCruiser(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    NavMapAdapter.getInstance().purgeMapDataForNavi(paramActivity);
    if (!JarUtils.getAsJar())
    {
      NavTipTool.onCreateToastDialog(paramActivity, 2131296656);
      return;
    }
    BaiduNaviManager.getInstance().showNavPage(BNCruiserFragment.class.getName(), null);
  }
  
  public void dismissWaitProgressDialog()
  {
    if (this.mRoutePlanObserver != null) {
      this.mRoutePlanObserver.dismissWaitProgressDialog();
    }
  }
  
  public void forceQuitWithoutDialog()
  {
    if (BNavigator.getInstance().isNaviBegin())
    {
      NavTrajectoryController.getInstance().setEndNaviByOpenApi(true);
      BNavigator.getInstance().forceQuitWithoutDialog();
    }
    while (!BCruiser.getInstance().isRouteCruiseBegin()) {
      return;
    }
    BCruiser.getInstance().quitCruise();
  }
  
  public BNavigatorListener getBNavigatorListener()
  {
    return this.mBNavigatorListener;
  }
  
  public int getLocateMode()
  {
    return this.mRouteGuideLocateMode;
  }
  
  public boolean isThirdServer()
  {
    return this.mIsThirdServer;
  }
  
  public void launchCruiser(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (!NavCommonFuncController.getInstance().hasGPSPermission(paramActivity))
    {
      TipTool.onCreateToastDialog(paramActivity, JarUtils.getResources().getString(1711670032));
      return;
    }
    NavUserBehaviour.getInstance().sendBehaviourLog("01001");
    Bundle localBundle = new Bundle();
    localBundle.putInt("cruiser_view_mode", 0);
    NavMapAdapter.getInstance().purgeMapDataForNavi(paramActivity);
    if (!JarUtils.getAsJar())
    {
      NavTipTool.onCreateToastDialog(paramActivity, 2131296656);
      return;
    }
    BaiduNaviManager.getInstance().showNavPage(BNCruiserFragment.class.getName(), localBundle);
  }
  
  public void launchCruiser(Activity paramActivity, Boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (!NavCommonFuncController.getInstance().hasGPSPermission(paramActivity))
    {
      TipTool.onCreateToastDialog(paramActivity, JarUtils.getResources().getString(1711670032));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("cruiser_view_mode", 0);
    NavMapAdapter.getInstance().purgeMapDataForNavi(paramActivity);
    if (!JarUtils.getAsJar())
    {
      NavTipTool.onCreateToastDialog(paramActivity, 2131296656);
      return;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = NavUserBehaviour.getInstance();
      if (NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData()) {}
      for (paramActivity = "offline";; paramActivity = "online")
      {
        paramBoolean.sendNaviStatistics(null, null, "edog", paramActivity, "nav_edog");
        MainActivity.a(new BNCruiserFragment(), localBundle);
        return;
      }
    }
    paramBoolean = NavUserBehaviour.getInstance();
    if (NavMapAdapter.getInstance().hasCurMapLocationCityOfflineData()) {}
    for (paramActivity = "offline";; paramActivity = "online")
    {
      paramBoolean.sendNaviStatistics(null, null, "edog", paramActivity, "map_edog");
      break;
    }
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, NavGeoPoint paramNavGeoPoint1, String paramString1, NavGeoPoint paramNavGeoPoint2, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    launchNavigator(paramActivity, paramNavGeoPoint1, paramString1, paramNavGeoPoint2, paramString2, paramInt1, paramBoolean, paramInt2, false);
  }
  
  @Deprecated
  public void launchNavigator(final Activity paramActivity, final NavGeoPoint paramNavGeoPoint1, final String paramString1, final NavGeoPoint paramNavGeoPoint2, final String paramString2, final int paramInt1, final boolean paramBoolean1, int paramInt2, final boolean paramBoolean2)
  {
    NavLogUtils.e(TAG, "launchNavigator2() ");
    if (paramActivity == null) {
      return;
    }
    if (!NavCommonFuncController.getInstance().hasGPSPermission(paramActivity))
    {
      TipTool.onCreateToastDialog(paramActivity, JarUtils.getResources().getString(1711670031));
      return;
    }
    NavRoutePlanModel.getInstance().setStartRouteNode(NavMapAdapter.getInstance().getRouteNode(paramNavGeoPoint1, paramString1, null));
    NavRoutePlanModel.getInstance().setEndRouteNode(NavMapAdapter.getInstance().getRouteNode(paramNavGeoPoint2, paramString2, null));
    NavRoutePlanModel.getInstance().setPreference(paramInt1);
    NavRoutePlanModel.getInstance().setStrategy(paramInt2);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new RoutePlanNode();
    ((RoutePlanNode)localObject).setGeoPoint(NavModelHelper.convertNavGeoPoint(paramNavGeoPoint1));
    ((RoutePlanNode)localObject).setName(paramString1);
    localArrayList.add(localObject);
    localObject = new RoutePlanNode();
    ((RoutePlanNode)localObject).setGeoPoint(NavModelHelper.convertNavGeoPoint(paramNavGeoPoint2));
    if ((!TextUtils.isEmpty(paramString2)) && (!"地图上的点".equals(paramString2))) {
      ((RoutePlanNode)localObject).setName(paramString2);
    }
    localArrayList.add(localObject);
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new RoutePlanObserver(paramActivity, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    localObject = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
    paramActivity = new BNMainLooperHandler()
    {
      public void onMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        case 5: 
        case 6: 
        default: 
          return;
        case 4: 
          NavMapAdapter.getInstance().purgeMapDataForNavi(paramActivity);
          NavRouteGuideController.this.startRGActivity(paramActivity.getApplicationContext(), NavModelHelper.convertNavGeoPoint(paramNavGeoPoint1), paramString1, NavModelHelper.convertNavGeoPoint(paramNavGeoPoint2), paramString2, paramInt1, paramBoolean1, paramBoolean2);
          BNRoutePlaner.getInstance().removeRouteResultHandler(this);
          return;
        }
        BNRoutePlaner.getInstance().removeRouteResultHandler(this);
      }
    };
    BNRoutePlaner.getInstance().addRouteResultHandler(paramActivity);
    int i;
    if (NavMapAdapter.getInstance().isGpsEnabled()) {
      if (NavMapAdapter.getInstance().isGPSLocationValid()) {
        i = 1;
      }
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().triggerGPSStatus(i);
      NavLogUtils.e(TAG, "launchNavigator2() mrsl=" + (String)localObject + ", nRPPolicy=" + paramInt1 + ", strategy=" + paramInt2);
      switch (paramInt2)
      {
      default: 
        BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, -1, true, (String)localObject, 0);
        return;
        i = 2;
        continue;
        i = 0;
      }
    }
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, 3, true, (String)localObject, 0);
    return;
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, -1, true, (String)localObject, 0);
  }
  
  @Deprecated
  public void launchNavigator(Activity paramActivity, RouteNode paramRouteNode1, RouteNode paramRouteNode2, List<RouteNode> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    launchNavigator(paramActivity, paramRouteNode1, paramRouteNode2, paramList, paramInt1, paramBoolean, paramInt2, false);
  }
  
  @Deprecated
  public void launchNavigator(final Activity paramActivity, final RouteNode paramRouteNode1, final RouteNode paramRouteNode2, List<RouteNode> paramList, final int paramInt1, final boolean paramBoolean1, int paramInt2, final boolean paramBoolean2)
  {
    NavLogUtils.e(TAG, "launchNavigator4()  nRPPolicy=" + paramInt1 + ", strategy=" + paramInt2 + ", cuid=" + CommonParam.getCUID(paramActivity));
    if (paramActivity == null) {
      return;
    }
    if (!NavCommonFuncController.getInstance().hasGPSPermission(paramActivity))
    {
      TipTool.onCreateToastDialog(paramActivity, JarUtils.getResources().getString(1711670031));
      return;
    }
    NavRoutePlanModel.getInstance().setStartRouteNode(paramRouteNode1);
    NavRoutePlanModel.getInstance().setEndRouteNode(paramRouteNode2);
    NavRoutePlanModel.getInstance().setPreference(paramInt1);
    NavRoutePlanModel.getInstance().setStrategy(paramInt2);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new RoutePlanNode();
    ((RoutePlanNode)localObject).setGeoPoint(NavModelHelper.convertNavGeoPoint(paramRouteNode1.mGeoPoint));
    ((RoutePlanNode)localObject).setName(paramRouteNode1.mName);
    ((RoutePlanNode)localObject).setUID(paramRouteNode1.mUID);
    localArrayList.add(localObject);
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 0;
      while (i < paramList.size())
      {
        localObject = (RouteNode)paramList.get(i);
        if (localObject != null)
        {
          RoutePlanNode localRoutePlanNode = new RoutePlanNode();
          localRoutePlanNode.setGeoPoint(NavModelHelper.convertNavGeoPoint(((RouteNode)localObject).mGeoPoint));
          localRoutePlanNode.setName(((RouteNode)localObject).mName);
          localRoutePlanNode.setUID(((RouteNode)localObject).mUID);
          localArrayList.add(localRoutePlanNode);
        }
        i += 1;
      }
    }
    paramList = new RoutePlanNode();
    paramList.setGeoPoint(NavModelHelper.convertNavGeoPoint(paramRouteNode2.mGeoPoint));
    if ((!TextUtils.isEmpty(paramRouteNode2.mName)) && (!"地图上的点".equals(paramRouteNode2.mName))) {
      paramList.setName(paramRouteNode2.mName);
    }
    paramList.setUID(paramRouteNode2.mUID);
    localArrayList.add(paramList);
    this.mRoutePlanObserver = null;
    this.mRoutePlanObserver = new RoutePlanObserver(paramActivity, new RoutePlanObserver.IJumpToDownloadListener()
    {
      public void onJumpToDownloadOfflineData()
      {
        BaiduNaviManager.getInstance().launchDownloadActivity(NavMapAdapter.getInstance().getContext(), null);
      }
    });
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    paramList = NavMapAdapter.getInstance().getCarRoutePlanMrsl();
    paramActivity = new BNMainLooperHandler()
    {
      public void onMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        case 5: 
        case 6: 
        default: 
          return;
        case 4: 
          NavMapAdapter.getInstance().purgeMapDataForNavi(paramActivity);
          BNRoutePlaner.getInstance().selectRoute(0);
          NavRouteGuideController.this.startRGActivity(paramActivity.getApplicationContext(), NavModelHelper.convertNavGeoPoint(paramRouteNode1.mGeoPoint), paramRouteNode1.mName, NavModelHelper.convertNavGeoPoint(paramRouteNode2.mGeoPoint), paramRouteNode2.mName, paramInt1, paramBoolean1, paramBoolean2);
          BNRoutePlaner.getInstance().removeRouteResultHandler(this);
          return;
        }
        BNRoutePlaner.getInstance().removeRouteResultHandler(this);
      }
    };
    BNRoutePlaner.getInstance().addRouteResultHandler(paramActivity);
    if (NavMapAdapter.getInstance().isGpsEnabled()) {
      if (NavMapAdapter.getInstance().isGPSLocationValid()) {
        i = 1;
      }
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().triggerGPSStatus(i);
      NavLogUtils.e(TAG, "launchNavigator4() mRouteGuidePreference= " + this.mRouteGuidePreference + " hasSetPreference " + this.hasSetPreference);
      if (this.hasSetPreference.booleanValue())
      {
        this.hasSetPreference = Boolean.valueOf(false);
        BNRoutePlaner.getInstance().setCalcPrference(this.mRouteGuidePreference);
      }
      NavLogUtils.e(TAG, "launchNavigator4() mrsl=" + paramList + ", nRPPolicy=" + paramInt1 + ", strategy=" + paramInt2);
      switch (paramInt2)
      {
      default: 
        BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, -1, true, paramList, 0);
        return;
        i = 2;
        continue;
        i = 0;
      }
    }
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, 3, true, paramList, 0);
    return;
    BNRoutePlaner.getInstance().setPointsToCalcRoute(localArrayList, -1, true, paramList, 0);
  }
  
  public boolean newGuideIsThirdServer()
  {
    return this.mNewGuideIsThirdServer;
  }
  
  public void onPageJump(int paramInt, Object paramObject)
  {
    if (this.mBNavigatorListener != null) {
      this.mBNavigatorListener.onPageJump(paramInt, paramObject);
    }
  }
  
  public void preloadRouteGuideView()
  {
    CommonHandlerThread.getInstance().getHandler().post(new Runnable()
    {
      public void run()
      {
        try
        {
          RGViewController.getInstance().preloadViews(NavCommonFuncModel.getInstance().getActivity());
          return;
        }
        catch (Throwable localThrowable)
        {
          LogUtil.e("onRoutePlan", "system.err preloadRouteGuideView err:" + localThrowable.getMessage());
        }
      }
    });
  }
  
  public void releasePreloadRouteGuideView()
  {
    RGMapModeViewController.getInstance().releasePreloadSubViews();
  }
  
  public boolean resetEndNodeInNavi(RouteNode paramRouteNode)
  {
    return RGEngineControl.getInstance().setEndPtToCalcRoute(NavModelHelper.convertNavGeoPoint(paramRouteNode.mGeoPoint));
  }
  
  public void runMonkey()
  {
    if (!NavMapAdapter.sMonkey) {}
    do
    {
      do
      {
        return;
      } while (!BaiduNaviManager.isNaviSoLoadSuccess());
      localActivity = NavCommonFuncModel.getInstance().getActivity();
      if (BaiduNaviManager.sIsBaseEngineInitialized) {
        break;
      }
    } while (localActivity == null);
    BaiduNaviManager.getInstance().initBaseEngine(localActivity, new NaviEngineInitListener()
    {
      public void engineInitFail()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBEFail-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().showMToast(c.f(), 2131296656);
            NavMapAdapter.getInstance().dismissMProgressDialog();
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
      
      public void engineInitStart()
      {
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBEStart-" + getClass().getSimpleName(), null)new BNWorkerConfig
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
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("InitBESuc-" + getClass().getSimpleName(), null)new BNWorkerConfig
        {
          protected String execute()
          {
            NavMapAdapter.getInstance().dismissMProgressDialog();
            Activity localActivity = BNaviModuleManager.getActivity();
            BaiduNaviManager.getInstance().launchNavigator(localActivity, new NavGeoPoint(11394118, 2254282), "我的位置", new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
            return null;
          }
        }, new BNWorkerConfig(100, 0));
      }
    });
    return;
    Activity localActivity = BNaviModuleManager.getActivity();
    BaiduNaviManager.getInstance().launchNavigator(localActivity, new NavGeoPoint(11394118, 2254282), "我的位置", new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
  }
  
  public void setBNavigatorListener(BNavigatorListener paramBNavigatorListener)
  {
    this.mBNavigatorListener = paramBNavigatorListener;
    if (paramBNavigatorListener != null) {
      setIsThirdServer(true);
    }
  }
  
  public void setCalcPrference(int paramInt)
  {
    this.hasSetPreference = Boolean.valueOf(true);
    this.mRouteGuidePreference = paramInt;
  }
  
  public void setIsThirdServer(boolean paramBoolean)
  {
    this.mIsThirdServer = paramBoolean;
  }
  
  public void setLocateMode(int paramInt)
  {
    this.mRouteGuideLocateMode = paramInt;
  }
  
  public void setNavUserBehaviourCallback()
  {
    BNavigator.getInstance().setmNavUserBehaviourCallback(this.mNavUserBehaviourCallback);
  }
  
  public void setNewGuideIsThirdServer(boolean paramBoolean)
  {
    this.mNewGuideIsThirdServer = paramBoolean;
  }
  
  public boolean setUserChooseRouteBit(int paramInt)
  {
    return BNRouteGuider.getInstance().setUserChooseRouteBit(paramInt);
  }
  
  public void setVoiceModeInNavi(int paramInt)
  {
    BNSettingManager.setVoiceMode(paramInt);
    BNRouteGuider.getInstance().setVoiceMode(paramInt);
    if (2 == paramInt)
    {
      BNRouteGuider.getInstance().setElecCameraSpeak(false);
      BNRouteGuider.getInstance().setSpeedCameraSpeak(false);
      BNRouteGuider.getInstance().setSaftyDriveSpeak(false);
      BNRouteGuider.getInstance().setRoadConditionSpeak(false);
      BNRouteGuider.getInstance().setStraightDirectSpeak(false);
    }
    for (;;)
    {
      if (BNavigator.getInstance().isNaviBegin()) {
        BNavigator.getInstance().onVoiceCommand(2, 33, 0, null, false);
      }
      return;
      BNRouteGuider.getInstance().setElecCameraSpeak(BNSettingManager.isElecCameraSpeakEnable());
      BNRouteGuider.getInstance().setSpeedCameraSpeak(BNSettingManager.isSpeedCameraSpeakEnable());
      BNRouteGuider.getInstance().setSaftyDriveSpeak(BNSettingManager.isSaftyDriveSpeakEnable());
      BNRouteGuider.getInstance().setRoadConditionSpeak(BNSettingManager.isRoadConditionSpeakEnable());
      BNRouteGuider.getInstance().setStraightDirectSpeak(BNSettingManager.isStraightDirectSpeakEnable());
    }
  }
  
  public boolean startRouteGuideView(boolean paramBoolean, Bundle paramBundle)
  {
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if ((!paramBoolean) && (localActivity != null)) {
      NavMapAdapter.getInstance().purgeMapDataForNavi(localActivity);
    }
    if ((localActivity != null) && (!BaiduNaviManager.getInstance().hasGPSPermission(localActivity)))
    {
      TipTool.onCreateToastDialog(localActivity, JarUtils.getResources().getString(1711670031));
      return false;
    }
    try
    {
      if (PerformStatItem.sUserTest)
      {
        PerformStatisticsController.peByType(0, "ad_start_show_routeguide", System.currentTimeMillis());
        PerformStatItem.sPoiToNaviTime10 = System.currentTimeMillis();
        PerformStatisticsController.getInstance().addTimeLogForPoiGoToNavi("10", "发起跳转导航界面v2", "NaviSDK", PerformStatItem.sPoiToNaviTime9, PerformStatItem.sPoiToNaviTime10);
        PerformStatItem.sRoutePageToNaviTime4 = System.currentTimeMillis();
        PerformStatisticsController.getInstance().addTimeLogForRoutePageGoToNavi("4", "创建导航页面UI前的操作", "NaviSDK", PerformStatItem.sRoutePageToNaviTime3, PerformStatItem.sRoutePageToNaviTime4);
      }
      h.a().showFragment(113, paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      NavMapAdapter.getInstance().exceptionLog(paramBundle);
    }
    return false;
  }
  
  public static abstract interface BNavigatorListener
  {
    public abstract void onPageJump(int paramInt, Object paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavRouteGuideController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */