package com.baidu.baidunavis.control;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig.MapMode;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.nplatform.comapi.map.BNMapManager;
import com.baidu.platform.comapi.map.CaptureMapListener;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapController.HeatMapType;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.NaviMapGestureAdapter;
import com.baidu.platform.comapi.map.NaviMapViewListener;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class NavMapManager
{
  private static final String TAG = NavMapManager.class.getSimpleName();
  private boolean isChangedMapMode = false;
  private boolean mBaseMapListenerModified = false;
  private MapViewListener mBaseMapViewListener = null;
  private boolean mInited = false;
  private MapController mMapController = null;
  private int[] mMapOverlays2BClosedInNavi = { 7, 20, 12 };
  private int[] mMapOverlays2BClosedInRoute = { 20 };
  private SparseArray<Boolean> mMapOverlaysChangeLog = new SparseArray();
  private MapGLSurfaceView mMapView = null;
  private int mNaviMapMode = 0;
  private NaviMapViewListener mNaviMapViewListener = new NaviMapViewListener()
  {
    public void onAction(int paramAnonymousInt, Object paramAnonymousObject)
    {
      BNMapManager.getInstance().onAction(paramAnonymousInt, paramAnonymousObject);
    }
    
    public boolean onItemClick(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      NavLogUtils.e(NavMapManager.TAG, "onItemClick: mapObjJson --> " + paramAnonymousString);
      return BNMapManager.getInstance().onItemClick(paramAnonymousString, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public void onMapAnimationFinish()
    {
      BNMapManager.getInstance().onMapAnimationFinish();
    }
    
    public void onMapRenderModeChange(int paramAnonymousInt)
    {
      BNMapManager.getInstance().onMapRenderModeChange(paramAnonymousInt);
    }
    
    public com.baidu.platform.comapi.basestruct.Point onTapInterception(com.baidu.platform.comapi.basestruct.Point paramAnonymousPoint)
    {
      Object localObject;
      if (paramAnonymousPoint == null) {
        localObject = null;
      }
      com.baidu.nplatform.comapi.basestruct.Point localPoint;
      do
      {
        return (com.baidu.platform.comapi.basestruct.Point)localObject;
        localObject = new com.baidu.nplatform.comapi.basestruct.Point(paramAnonymousPoint.getIntX(), paramAnonymousPoint.getIntY());
        localPoint = BNMapManager.getInstance().onTapInterception((com.baidu.nplatform.comapi.basestruct.Point)localObject);
        localObject = paramAnonymousPoint;
      } while (localPoint == null);
      paramAnonymousPoint.setIntX(localPoint.getmPtx());
      paramAnonymousPoint.setIntY(localPoint.getmPty());
      return paramAnonymousPoint;
    }
    
    public void resizeScreen(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BNMapController.getInstance().resizeScreen(paramAnonymousInt1, paramAnonymousInt2);
    }
  };
  private Object mSyncObj = new Object();
  private NaviMapGestureAdapter naviMapGestureAdapter = null;
  
  public static NavMapManager getInstance()
  {
    return Holder.sInstance;
  }
  
  private void logChangeLog()
  {
    if (NavLogUtils.LOGGABLE)
    {
      int i = 0;
      while (i < this.mMapOverlaysChangeLog.size())
      {
        int j = this.mMapOverlaysChangeLog.keyAt(i);
        boolean bool = ((Boolean)this.mMapOverlaysChangeLog.get(j)).booleanValue();
        NavLogUtils.e(TAG, "logChangeLog: --> key: " + j + ", value: " + bool);
        i += 1;
      }
    }
  }
  
  public void addMapObserver(BNMapObserver paramBNMapObserver)
  {
    if (paramBNMapObserver != null) {
      BNMapManager.getInstance().addMapObserver(paramBNMapObserver);
    }
  }
  
  public void addNaviMapListener()
  {
    NavLogUtils.e(TAG, "addNaviMapListener: --> ");
    init();
    if ((this.mMapController != null) && (this.mMapView != null))
    {
      this.mMapController.setNaviMapViewListener(this.mNaviMapViewListener);
      if (this.naviMapGestureAdapter == null) {
        break label67;
      }
      this.mMapView.removeSimpleOnGestureListener(this.naviMapGestureAdapter);
    }
    for (;;)
    {
      this.mMapView.addSimpleOnGestureListener(this.naviMapGestureAdapter);
      return;
      label67:
      this.naviMapGestureAdapter = new NaviMapGestureAdapter();
      this.naviMapGestureAdapter.setMapController(this.mMapController);
    }
  }
  
  public void clearLocationIcon()
  {
    NavLogUtils.e(TAG, "NMM.clearLocationIcon()");
    if (MapViewFactory.getInstance().getMapView() != null) {
      MapViewFactory.getInstance().getMapView().clearDefaultLocationLayerData(new Bundle());
    }
  }
  
  public void closeHotMap()
  {
    MapViewFactory.getInstance().getMapView().getController().getBaseMap().ShowHotMap(false, MapController.HeatMapType.CITY.getId());
    GlobalConfig.getInstance().setHotMapLayerOnOff(false);
  }
  
  public void closeSatellite()
  {
    if (this.mMapView != null)
    {
      MapViewConfig.getInstance().setMapMode(MapViewConfig.MapMode._2D);
      this.mMapView.setSatellite(false);
    }
  }
  
  public void deleteMapObserver(BNMapObserver paramBNMapObserver)
  {
    if (paramBNMapObserver != null) {
      BNMapManager.getInstance().deleteMapObserver(paramBNMapObserver);
    }
  }
  
  public void fullviewForCarResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setScreenShow(paramInt1, paramInt2, paramInt3, paramInt4);
    BNMapController.getInstance().resetRouteDetailIndex();
  }
  
  public MapController getBaseMapController()
  {
    return this.mMapController;
  }
  
  public void getMapScreenshot(final String paramString, final Handler paramHandler, final int paramInt)
  {
    if ((this.mMapController == null) || (paramString == null) || (paramHandler == null)) {
      return;
    }
    try
    {
      this.mMapController.setCaptureMapListener(new CaptureMapListener()
      {
        public void onGetCaptureMap(boolean paramAnonymousBoolean)
        {
          NavLogUtils.e(NavMapManager.TAG, "onGetCaptureMap: isCapOk --> " + paramAnonymousBoolean);
          Message localMessage = paramHandler.obtainMessage(paramInt);
          if (paramAnonymousBoolean) {}
          for (localMessage.obj = BitmapFactory.decodeFile(paramString);; localMessage.obj = null)
          {
            paramHandler.sendMessage(localMessage);
            return;
          }
        }
      });
      this.mMapController.saveScreenToLocal(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public int getNaviMapMode()
  {
    return this.mNaviMapMode;
  }
  
  public int getNaviMapMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 5: 
      return 100;
    case 6: 
      return 100;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public void handleMapOverlays(int paramInt)
  {
    NavLogUtils.e(TAG, "handleMapOverlays: naviMapMode --> " + paramInt);
    if (paramInt == 0)
    {
      resetMapOverlays();
      return;
    }
    int j;
    if (paramInt == 100)
    {
      arrayOfInt = this.mMapOverlays2BClosedInRoute;
      i = arrayOfInt.length;
      paramInt = 0;
      while (paramInt < i)
      {
        j = arrayOfInt[paramInt];
        if (com.baidu.baidumaps.f.b.a.a().a(j))
        {
          this.mMapOverlaysChangeLog.put(j, Boolean.TRUE);
          com.baidu.baidumaps.f.b.a.a().a(j, false);
        }
        paramInt += 1;
      }
      logChangeLog();
      return;
    }
    int[] arrayOfInt = this.mMapOverlays2BClosedInNavi;
    int i = arrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      j = arrayOfInt[paramInt];
      if (com.baidu.baidumaps.f.b.a.a().a(j))
      {
        this.mMapOverlaysChangeLog.put(j, Boolean.TRUE);
        com.baidu.baidumaps.f.b.a.a().a(j, false);
      }
      paramInt += 1;
    }
    logChangeLog();
  }
  
  public void handleMapThemeAndScene(int paramInt)
  {
    PerformStatisticsController.peByType(0, "map_handleMapThemeAndScene_start", System.currentTimeMillis());
    int i = getNaviMapMode(paramInt);
    initNaviSO();
    if ((i == 1) || (i == 2) || (i == 3))
    {
      closeSatellite();
      closeHotMap();
    }
    boolean bool = false;
    if ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5)) {
      bool = true;
    }
    NavLogUtils.e(TAG, "handleMapThemeAndScene: --> pageType: " + paramInt + ", naviMapMode: " + i + ", mapToNav: " + bool);
    if (bool)
    {
      if (!com.baidu.baidumaps.f.a.a.a.a().c("cache_common_navi_page")) {
        com.baidu.baidumaps.f.a.a.a.a().a("cache_common_navi_page");
      }
      handleMapOverlays(i);
      if ((i == 3) || (i == 1)) {
        com.baidu.baidumaps.f.b.a.a().a(7, false);
      }
      setNaviMapMode(i);
    }
    for (;;)
    {
      PerformStatisticsController.peByType(0, "map_handleMapThemeAndScene_end", System.currentTimeMillis());
      return;
      setNaviMapMode(i);
      com.baidu.baidumaps.f.a.a.a.a().b("cache_common_navi_page");
      handleMapOverlays(i);
    }
  }
  
  public void handleRoadCondition(int paramInt)
  {
    if ((paramInt == 0) || (paramInt >= 100))
    {
      BNRoutePlaner.getInstance().EnableRoadCondition(false);
      return;
    }
    BNRoutePlaner.getInstance().EnableRoadCondition(true);
  }
  
  public void init()
  {
    if (this.mInited) {
      return;
    }
    try
    {
      synchronized (this.mSyncObj)
      {
        if (this.mInited) {
          return;
        }
      }
      this.mInited = true;
    }
    catch (Throwable localThrowable)
    {
      this.mInited = false;
      NavLogUtils.e(TAG, "init: Exception --> " + localThrowable.getMessage());
      return;
    }
    if (this.mMapView == null) {
      this.mMapView = MapViewFactory.getInstance().getMapView();
    }
    this.mMapController = this.mMapView.getController();
    Bundle localBundle = new Bundle();
    localBundle.putInt("screen_width", this.mMapView.getWidth());
    localBundle.putInt("screen_height", this.mMapView.getHeight());
    BNMapManager.getInstance().init(NavCommonFuncModel.getInstance().getContext(), localBundle);
    BNMapController.getInstance().showLayer(9, false);
    BNAutoDayNightHelper.getInstance().updateDayNightMode();
    if (!this.mMapController.getMapClickEnable()) {
      this.mMapController.setMapClickEnable(true);
    }
  }
  
  public void initNaviSO()
  {
    if (!BaiduNaviManager.sIsNaviSoLoadSuccess)
    {
      NavLogUtils.e(TAG, "handleMapSceneAndOverlays sIsNaviSoLoadSuccess false");
      NavInitController.getInstance().loadNaviSO();
    }
  }
  
  public boolean isChangedMapMode()
  {
    return this.isChangedMapMode;
  }
  
  public boolean isMapConfigTrafficOn()
  {
    return MapViewConfig.getInstance().isTraffic();
  }
  
  public boolean releaseSharedMapData()
  {
    return BNMapController.getInstance().releaseSharedMapData();
  }
  
  public void removeNaviMapListener()
  {
    NavLogUtils.e(TAG, "removeNaviMapListener: --> ");
    if ((this.mMapController != null) && (this.mMapView != null))
    {
      this.mMapController.setNaviMapViewListener(null);
      if (this.naviMapGestureAdapter != null) {
        this.mMapView.removeSimpleOnGestureListener(this.naviMapGestureAdapter);
      }
    }
  }
  
  public void resetBaseMapViewListener()
  {
    if ((this.mMapController != null) && (this.mBaseMapListenerModified))
    {
      NavLogUtils.e(TAG, "resetBaseMapViewListener: --> ");
      this.mBaseMapListenerModified = false;
      this.mMapController.setMapViewListener(this.mBaseMapViewListener);
    }
  }
  
  public void resetMapOverlays()
  {
    NavLogUtils.e(TAG, "resetMapOverlays: --> ");
    Object localObject = this.mMapOverlays2BClosedInNavi;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject[i];
      if (((Boolean)this.mMapOverlaysChangeLog.get(k, Boolean.FALSE)).booleanValue())
      {
        this.mMapOverlaysChangeLog.put(k, Boolean.FALSE);
        com.baidu.baidumaps.f.b.a.a().a(k, true);
      }
      i += 1;
    }
    if (this.mMapView != null)
    {
      localObject = this.mMapView.getMapStatus();
      if (localObject != null)
      {
        ((MapStatus)localObject).overlooking = 0;
        ((MapStatus)localObject).rotation = 0;
        ((MapStatus)localObject).xOffset = 0.0F;
        ((MapStatus)localObject).yOffset = 0.0F;
        this.mMapView.setMapStatus((MapStatus)localObject);
      }
    }
    logChangeLog();
    NavLogUtils.e(TAG, "resetMapOverlays: --> end");
  }
  
  public void set3DGestureEnable(boolean paramBoolean)
  {
    if (this.mMapController != null)
    {
      NavLogUtils.e(TAG, "set3DGestureEnable: enable --> " + paramBoolean);
      this.mMapController.set3DGestureEnable(paramBoolean);
    }
  }
  
  public void setBaseMapViewListener(BaseMapViewListener paramBaseMapViewListener)
  {
    if (this.mMapController != null)
    {
      this.mBaseMapListenerModified = true;
      this.mBaseMapViewListener = this.mMapController.getMapViewListener();
      this.mMapController.setMapViewListener(paramBaseMapViewListener);
    }
  }
  
  public void setNaviMapMode(int paramInt)
  {
    NavLogUtils.e(TAG, "setNaviMapMode: naviMapMode --> " + paramInt);
    if (paramInt >= 100) {
      BNMapController.getInstance().setNaviMapMode(0);
    }
    for (this.mNaviMapMode = 0;; this.mNaviMapMode = paramInt)
    {
      if (this.mNaviMapMode != 0) {
        this.isChangedMapMode = true;
      }
      return;
      BNMapController.getInstance().setNaviMapMode(paramInt);
    }
  }
  
  public void setScreenShow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BNMapController.getInstance().setScreenShow(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight(), ScreenUtil.getInstance().dip2px(paramInt1), ScreenUtil.getInstance().dip2px(paramInt2), ScreenUtil.getInstance().dip2px(paramInt3), ScreenUtil.getInstance().dip2px(paramInt4));
  }
  
  public void showCarResultLayer(boolean paramBoolean)
  {
    NavLogUtils.e(TAG, "showCarResultLayer show: " + paramBoolean);
    BNMapController.getInstance().showLayer(10, paramBoolean);
    if (!paramBoolean) {
      BNMapController.getInstance().clearLayer(10);
    }
    BNMapController.getInstance().updateLayer(10);
    BNMapController.getInstance().showLayer(8, paramBoolean);
    if (!paramBoolean) {
      BNMapController.getInstance().clearLayer(8);
    }
    BNMapController.getInstance().updateLayer(8);
    BNMapController.getInstance().showLayer(27, paramBoolean);
    if (!paramBoolean) {
      BNMapController.getInstance().clearLayer(27);
    }
    BNMapController.getInstance().updateLayer(27);
  }
  
  public void syncMapTraffic()
  {
    if (this.mMapView != null)
    {
      boolean bool = isMapConfigTrafficOn();
      NavLogUtils.e(TAG, "syncMapTraffic: isMapConfigTrafficOn --> " + bool);
      this.mMapView.forceSetTraffic(bool);
    }
  }
  
  public void unInit()
  {
    for (;;)
    {
      try
      {
        synchronized (this.mSyncObj)
        {
          NavLogUtils.e(TAG, "unInit: --> ");
          BNMapManager.getInstance().unInit();
          if (this.mMapController != null)
          {
            if (isMapConfigTrafficOn())
            {
              i = 5;
              PerformStatisticsController.peByType(0, "map_setMapThemeScene_start", System.currentTimeMillis());
              this.mMapController.setMapThemeScene(1, i, new Bundle());
              PerformStatisticsController.peByType(0, "map_setMapThemeScene_end", System.currentTimeMillis());
              this.mMapController.setOverlookGestureEnable(true);
            }
          }
          else
          {
            set3DGestureEnable(GlobalConfig.getInstance().isOpen3D());
            resetMapOverlays();
            this.mInited = false;
            return;
          }
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        this.mInited = false;
        NavLogUtils.e(TAG, "unInit: Exception --> " + localThrowable.getMessage());
        return;
      }
    }
  }
  
  public boolean updateShareMapData()
  {
    return BNMapController.getInstance().updateShareMapData();
  }
  
  static class Holder
  {
    private static NavMapManager sInstance = new NavMapManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavMapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */