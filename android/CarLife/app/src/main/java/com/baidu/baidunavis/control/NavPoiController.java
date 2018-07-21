package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavModelHelper;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver;
import com.baidu.baidunavis.ui.widget.RoutePlanObserver.IJumpToDownloadListener;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.view.dialog.e;
import com.baidu.navi.location.LocationManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.platform.comapi.c;
import java.util.ArrayList;

public class NavPoiController
{
  private static final String TAG = "NavPoiController";
  private static e mWaitProgress = null;
  private Activity mActivity;
  private Context mContext = BNaviModuleManager.getContext();
  private int mDistrictId;
  private int mId;
  private Handler mRPHandler = new BNMainLooperHandler()
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4: 
        BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
        BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "route_plan", "nav_nav");
        NavRoutePlanController.getInstance().statisticsRoutePlanSuc();
        int i;
        if (NavMapAdapter.getInstance().isGpsEnabled()) {
          if (NavMapAdapter.getInstance().isGPSLocationValid()) {
            i = 1;
          }
        }
        for (;;)
        {
          BNRoutePlaner.getInstance().triggerGPSStatus(i);
          NavRoutePlanModel.getInstance().setmNavEnter("nav_nav");
          BaiduNaviManager.getInstance().sendNaviStatistics(NavRoutePlanModel.getInstance().getStartRouteNode(), NavRoutePlanModel.getInstance().getEndRouteNode(), "navi", "nav_nav");
          if ((BNStyleManager.getRealDayStyle()) || (NavMapManager.getInstance().isChangedMapMode())) {
            break;
          }
          sendEmptyMessageDelayed(222, 1000L);
          return;
          i = 2;
          continue;
          i = 0;
        }
        NavPoiController.this.dismissWaitProgressDialog();
        NavMapAdapter.getInstance().showFragment(52, null);
        return;
      case 7: 
        NavPoiController.this.dismissWaitProgressDialog();
        BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
        return;
      case 32: 
        NavPoiController.this.dismissWaitProgressDialog();
        BNRoutePlaner.getInstance().removeRouteResultHandler(NavPoiController.this.mRPHandler);
        return;
      case 8: 
        NavPoiController.this.showWaitProgressDialog();
        return;
      }
      NavPoiController.this.dismissWaitProgressDialog();
      NavMapAdapter.getInstance().showFragment(52, null);
    }
  };
  private RoutePlanObserver mRoutePlanObserver = new RoutePlanObserver(new RoutePlanObserver.IJumpToDownloadListener()
  {
    public void onJumpToDownloadOfflineData()
    {
      h.a().showFragment(554, null);
    }
  });
  private SearchPoi mRoutePlanPoi;
  private String mSearchKey;
  private int mSearchRsultNetMode = 1;
  private GeoPoint myPositionPoint;
  
  private RoutePlanNode createRoutePlanNode(SearchPoi paramSearchPoi)
  {
    return new RoutePlanNode(paramSearchPoi.mGuidePoint, paramSearchPoi.mViewPoint, 8, paramSearchPoi.mName, paramSearchPoi.mAddress, paramSearchPoi.mOriginUID);
  }
  
  public static NavPoiController getInstance()
  {
    return InnerHolder.mInstance;
  }
  
  public void animationByFrogleap(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    animationByFrogleap(paramSearchPoi.mViewPoint);
  }
  
  public void animationByFrogleap(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    MapStatus localMapStatus;
    do
    {
      return;
      localMapStatus = BNMapController.getInstance().getMapStatus();
      paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    } while ((localMapStatus == null) || (paramGeoPoint == null));
    localMapStatus._CenterPtX = paramGeoPoint.getInt("MCx");
    localMapStatus._CenterPtY = paramGeoPoint.getInt("MCy");
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationFrogleap);
  }
  
  public void animationTo(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    if ((paramGeoPoint != null) && (!paramGeoPoint.isEmpty()))
    {
      localMapStatus._CenterPtX = paramGeoPoint.getInt("MCx");
      localMapStatus._CenterPtY = paramGeoPoint.getInt("MCy");
    }
    BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationPos);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2)
  {
    animationTo(paramGeoPoint, paramLong1, paramLong2, -1);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2, int paramInt)
  {
    animationTo(paramGeoPoint, paramLong1, paramLong2, paramInt, true);
  }
  
  public void animationTo(GeoPoint paramGeoPoint, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    MapStatus localMapStatus;
    do
    {
      return;
      localMapStatus = BNMapController.getInstance().getMapStatus();
    } while (localMapStatus == null);
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    if ((paramGeoPoint != null) && (!paramGeoPoint.isEmpty()))
    {
      localMapStatus._CenterPtX = paramGeoPoint.getInt("MCx");
      localMapStatus._CenterPtY = paramGeoPoint.getInt("MCy");
    }
    localMapStatus._Xoffset = paramLong1;
    localMapStatus._Yoffset = paramLong2;
    if (paramInt > 0) {
      localMapStatus._Level = paramInt;
    }
    BNMapController localBNMapController = BNMapController.getInstance();
    if (paramBoolean) {}
    for (paramGeoPoint = MapController.AnimationType.eAnimationPos;; paramGeoPoint = MapController.AnimationType.eAnimationNone)
    {
      localBNMapController.setMapStatus(localMapStatus, paramGeoPoint);
      return;
    }
  }
  
  public boolean antiGeo(SearchPoi paramSearchPoi, int paramInt, Handler paramHandler)
  {
    if (paramSearchPoi == null) {
      return false;
    }
    return BNPoiSearcher.getInstance().asynGetPoiByPoint(paramSearchPoi.mViewPoint, paramInt, 10000, paramHandler);
  }
  
  public void clearPoiCache()
  {
    BNPoiSearcher.getInstance().clearPoiCache();
    BNMapController.getInstance().showLayer(3, false);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public boolean dismissWaitProgressDialog()
  {
    NavMapAdapter.getInstance().dismissWaitProgressDialog();
    return true;
  }
  
  public void focusItem(boolean paramBoolean)
  {
    BNMapController.getInstance().focusItem(3, this.mId, paramBoolean);
  }
  
  public void focusMadianPoi(SearchPoi paramSearchPoi, boolean paramBoolean, int paramInt)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mId = 0;
    BNPoiSearcher.getInstance().clearPoiCache();
    BNPoiSearcher.getInstance().updateBkgPoiCache(paramSearchPoi.mViewPoint, paramBoolean, paramInt);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public void focusPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    focusPoi(paramSearchPoi.mViewPoint);
  }
  
  public void focusPoi(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    this.mId = 0;
    BNPoiSearcher.getInstance().clearPoiCache();
    BNPoiSearcher.getInstance().updatePoiCache(paramGeoPoint);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public void focusPoi(ArrayList<SearchPoi> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    this.mId = paramInt;
    BNPoiSearcher.getInstance().clearPoiCache();
    BNPoiSearcher.getInstance().updatePoiCacheWithList(paramArrayList);
    BNMapController.getInstance().showLayer(3, true);
    BNMapController.getInstance().updateLayer(3);
  }
  
  public int getAntiPoiNetMode(GeoPoint paramGeoPoint)
  {
    int i = -1;
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return -1;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0);
      bool1 = bool2;
      if (paramGeoPoint != null)
      {
        paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId);
        bool1 = bool2;
        if (paramGeoPoint != null) {
          bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(paramGeoPoint.mId);
        }
      }
    }
    if (bool1) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (NetworkUtils.getConnectStatus()) {
        i = 1;
      }
    }
  }
  
  public String getDistance2CurrentPoint(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return "无数据";
    }
    return getDistance2CurrentPoint(paramSearchPoi.mViewPoint);
  }
  
  public String getDistance2CurrentPoint(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return "";
    }
    if ((this.myPositionPoint == null) || (!this.myPositionPoint.isValid())) {
      return "";
    }
    return StringUtils.getDistance(paramGeoPoint.getLongitudeE6() - this.myPositionPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6() - this.myPositionPoint.getLatitudeE6());
  }
  
  public int getDistrictId()
  {
    return this.mDistrictId;
  }
  
  public String getRoutePlanTipsMsg()
  {
    String str;
    switch (BNRoutePlaner.getInstance().getGuideSceneType())
    {
    case 3: 
    default: 
      str = this.mContext.getResources().getString(2131296911);
    }
    for (;;)
    {
      BNRoutePlaner.getInstance().setGuideSceneType(1);
      return str;
      str = this.mContext.getResources().getString(2131296911);
      continue;
      str = this.mContext.getResources().getString(2131296890);
      continue;
      str = this.mContext.getResources().getString(2131296893);
    }
  }
  
  public int getSearchNetMode()
  {
    return this.mSearchRsultNetMode;
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setDestCalcRoute(RoutePlanNode paramRoutePlanNode, Handler paramHandler)
  {
    if (!LocationManager.getInstance().isLocationValid())
    {
      Toast.makeText(c.f(), "定位失败,请检查网络后重试!", 0).show();
      return;
    }
    BNRoutePlaner.getInstance().cancleCalcRouteRequest();
    BNRoutePlaner.getInstance().clearRouteInfoHandler();
    RouteNode localRouteNode = NavMapAdapter.getInstance().getRouteNode(NavMapAdapter.getInstance().getGeoPoint(null, true), "我的位置", null);
    NavRoutePlanModel.getInstance().setStartRouteNode(localRouteNode);
    NavRoutePlanModel.getInstance().setEndRouteNode(NavMapAdapter.getInstance().getRouteNode(NavModelHelper.convertGeoPoint(paramRoutePlanNode.getGeoPoint()), paramRoutePlanNode.getName(), paramRoutePlanNode.getUID()));
    NavMapAdapter.getInstance().setPreferValue(NavMapAdapter.getInstance().onGetLastPreferValue());
    BNRoutePlaner.getInstance().setObserver(this.mRoutePlanObserver);
    BNRoutePlaner.getInstance().addRouteResultHandler(paramHandler);
    paramHandler = new ArrayList(2);
    paramHandler.add(NavModelHelper.convertRouteNode(NavRoutePlanModel.getInstance().getStartRouteNode()));
    paramHandler.add(paramRoutePlanNode);
    NavSearchController.getInstance().setRpEntry(6);
    BNRoutePlaner.getInstance().setPointsToCalcRoute(paramHandler, 0);
  }
  
  public void setDistrictId(int paramInt)
  {
    this.mDistrictId = paramInt;
  }
  
  public void setMapffset(long paramLong1, long paramLong2)
  {
    MapStatus localMapStatus = NMapControlProxy.getInstance().getMapStatus();
    if (localMapStatus != null)
    {
      localMapStatus._Xoffset = paramLong1;
      localMapStatus._Yoffset = paramLong2;
      NMapControlProxy.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
    }
  }
  
  public void setMyPositionGeo(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint != null)
    {
      this.myPositionPoint = paramGeoPoint;
      PoiSearchModel localPoiSearchModel = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
      if (localPoiSearchModel != null) {
        localPoiSearchModel.setMyPositionGeo(paramGeoPoint);
      }
    }
  }
  
  public void setSearchKey(String paramString)
  {
    this.mSearchKey = paramString;
  }
  
  public void setSearchNetMode(int paramInt)
  {
    this.mSearchRsultNetMode = paramInt;
  }
  
  public void showWaitProgressDialog()
  {
    dismissWaitProgressDialog();
    try
    {
      NavMapAdapter.getInstance().showProgressDialog(getRoutePlanTipsMsg(), new b()new d
      {
        public void onClick()
        {
          LogUtil.e("RoutePlan", "WaitProgress onCancel!");
          BNRoutePlaner.getInstance().cancleCalcRouteRequest();
          BNRoutePlaner.getInstance().clearRouteInfoHandler();
        }
      }, new d()
      {
        public void onCancel()
        {
          LogUtil.e("RoutePlan", "WaitProgress onCancel!");
          BNRoutePlaner.getInstance().cancleCalcRouteRequest();
          BNRoutePlaner.getInstance().clearRouteInfoHandler();
        }
      });
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startCalcRoute(RoutePlanNode paramRoutePlanNode)
  {
    NavRouteGuideController.getInstance().setBNavigatorListener(null);
    NavRouteGuideController.getInstance().setIsThirdServer(false);
    if (paramRoutePlanNode == null) {
      return;
    }
    LogUtil.e("NavPoiController", "calc route for navNode");
    setDestCalcRoute(paramRoutePlanNode, this.mRPHandler);
  }
  
  public void startCalcRoute(SearchPoi paramSearchPoi)
  {
    if (!NavRouteGuideController.getInstance().isThirdServer()) {
      NavRouteGuideController.getInstance().setBNavigatorListener(null);
    }
    NavRouteGuideController.getInstance().setIsThirdServer(false);
    if (paramSearchPoi == null) {
      return;
    }
    this.mRoutePlanPoi = paramSearchPoi;
    LogUtil.e("NavPoiController", "calc route");
    RoutePlanNode localRoutePlanNode = createRoutePlanNode(paramSearchPoi);
    localRoutePlanNode.mBusinessPoi = paramSearchPoi.mWanda;
    if ((this.mSearchRsultNetMode == 0) && (paramSearchPoi != null)) {
      BNPoiSearcher.getInstance().inputIndex(this.mSearchKey, this.mDistrictId, paramSearchPoi.mId);
    }
    setDestCalcRoute(localRoutePlanNode, this.mRPHandler);
  }
  
  public void updatePoiBkgLayer(ArrayList<SearchPoi> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    BNPoiSearcher.getInstance().clearBkgCache();
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    if (i < paramArrayList.size())
    {
      SearchPoi localSearchPoi = (SearchPoi)paramArrayList.get(i);
      if (localSearchPoi == null) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localSearchPoi.mViewPoint);
      }
    }
    BNPoiSearcher.getInstance().updateBkgCache(localArrayList, -1);
    BNMapController.getInstance().updateLayer(4);
    BNMapController.getInstance().updateLayer(3);
  }
  
  static class InnerHolder
  {
    static NavPoiController mInstance = new NavPoiController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavPoiController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */