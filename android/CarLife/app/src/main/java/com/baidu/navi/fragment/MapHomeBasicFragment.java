package com.baidu.navi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.HomeController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.view.HomePoiBasicView;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navi.view.ZoomButtonView.OnZoomBtnClickListener;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.CruiseStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.lang.ref.WeakReference;

public class MapHomeBasicFragment
  extends BrowseMapFragment
{
  private static final float ENTER_CRUISE_COND_SPEED = 10.0F;
  private static final int ENTER_CRUISE_COND_TIMEOUT = 30000;
  private static final int MAP_SCALE_DEFAULT = 14;
  private static final String TAG = "MapHomeBasic";
  protected Handler mHandler = new MapHomeBasicHandler(this);
  protected HomeController mHomeController;
  private boolean mIsCalcRoute = false;
  private boolean mIsGpsEnabled = false;
  private boolean mIsMapLocated = false;
  private long mLastTimeShowMapPoi = 0L;
  private LocationChangeListener mLocationChangeListener = new LocationChangeListener()
  {
    public LocationChangeListener.CoordType onGetCoordType()
    {
      return LocationChangeListener.CoordType.CoordType_GCJ02;
    }
    
    public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
    {
      if ((paramAnonymousLocData != null) && (LocationManager.getInstance().isLocationValid()))
      {
        TipTool.onCreateDebugToast(MapHomeBasicFragment.this.getContext(), "LocSDK: Got " + paramAnonymousLocData);
        if (!MapHomeBasicFragment.this.mIsMapLocated) {
          MapHomeBasicFragment.this.initMapStatus();
        }
        if (MapHomeBasicFragment.this.mIsMapLocated) {
          MapHomeBasicFragment.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LocationManager.getInstance().removeLocationChangeLister(MapHomeBasicFragment.this.mLocationChangeListener);
            }
          });
        }
      }
    }
  };
  private ILocationListener mLocationListener = new ILocationListener()
  {
    public void onGpsStatusChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      LogUtil.e("MapHomeBasic", "recved GPS status change, enabled " + paramAnonymousBoolean1 + ", avail " + paramAnonymousBoolean2);
      MapHomeBasicFragment.access$102(MapHomeBasicFragment.this, paramAnonymousBoolean1);
      if (paramAnonymousBoolean1) {
        MapHomeBasicFragment.this.mHomeController.dismissGPSSettingDialog();
      }
    }
    
    public void onLocationChange(LocData paramAnonymousLocData)
    {
      if ((BNSysLocationManager.getInstance().isSysLocationValid()) || ((paramAnonymousLocData != null) && (paramAnonymousLocData.isValid())))
      {
        float f = paramAnonymousLocData.speed * 3600.0F / 1000.0F;
        if (f > MapHomeBasicFragment.this.mMaxSpeed) {
          MapHomeBasicFragment.access$002(MapHomeBasicFragment.this, f);
        }
      }
    }
    
    public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2) {}
  };
  private BNLocationManager mLocationManager;
  private float mMaxSpeed = 0.0F;
  protected HomePoiBasicView mPoiDetailView;
  private Runnable mSaveMapScaleRunnable = new Runnable()
  {
    public void run()
    {
      int i = BNMapController.getInstance().getZoomLevel();
      LogUtil.e("MapHomeBasic", "saveMapScale: " + i);
      PreferenceHelper.getInstance(MapHomeBasicFragment.this.getContext()).putInt("sp_last_scale", i);
    }
  };
  private Runnable mStartCruiseTask = new Runnable()
  {
    public void run()
    {
      MapHomeBasicFragment.this.mHandler.removeCallbacks(MapHomeBasicFragment.this.mStartCruiseTask);
      boolean bool2 = false;
      int i;
      boolean bool1;
      if ((MapHomeBasicFragment.this.mHomeController.isOnlineUseDialogShowing()) || (MapHomeBasicFragment.this.mHomeController.isContinueLastNaviDialogShowing()) || (BaseFragment.mActivity.e()) || (MapHomeBasicFragment.this.mIsCalcRoute))
      {
        i = 1;
        LogUtil.e("MapHomeBasic", "GPSIsEnabled " + MapHomeBasicFragment.this.mIsGpsEnabled + ", maxSpeed " + MapHomeBasicFragment.this.mMaxSpeed);
        bool1 = bool2;
        if (MapHomeBasicFragment.this.mIsGpsEnabled)
        {
          bool1 = bool2;
          if (MapHomeBasicFragment.this.mMaxSpeed >= 10.0F)
          {
            bool1 = bool2;
            if (i == 0)
            {
              if (!NetworkUtils.isNetworkAvailable(BaseFragment.mActivity)) {
                break label211;
              }
              bool1 = true;
              LogUtil.e("MapHomeBasic", "network is available");
            }
          }
        }
      }
      for (;;)
      {
        MapHomeBasicFragment.access$002(MapHomeBasicFragment.this, 0.0F);
        if ((!bool1) || (MapHomeBasicFragment.this.getCurrentFragmentType() != 17)) {
          break label278;
        }
        MapHomeBasicFragment.this.showFragment(114, null);
        CruiseStatItem.getInstance().setCruiseFrom("1");
        return;
        i = 0;
        break;
        label211:
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
        {
          bool1 = MapHomeBasicFragment.this.isOfflineDataDownloaded(MapHomeBasicFragment.this.mLocationManager.getLastValidLocation());
          LogUtil.e("MapHomeBasic", "offline data is downloaded: " + bool1);
        }
        else
        {
          LogUtil.e("MapHomeBasic", "network is unavailable, or no common offline data exist!");
          bool1 = bool2;
        }
      }
      label278:
      MapHomeBasicFragment.this.mHandler.postDelayed(MapHomeBasicFragment.this.mStartCruiseTask, 30000L);
    }
  };
  protected ViewGroup mViewGroup;
  private ZoomButtonView.OnZoomBtnClickListener mZoomBtnClickListener = new ZoomButtonView.OnZoomBtnClickListener()
  {
    public void onZoomInBtnClick()
    {
      MapHomeBasicFragment.this.enterCruiseFollowModeDetect();
      MapHomeBasicFragment.this.saveMapScale(500L);
      MapHomeBasicFragment.this.mMapControlPanel.disableWatermark();
    }
    
    public void onZoomOutBtnClick()
    {
      MapHomeBasicFragment.this.enterCruiseFollowModeDetect();
      MapHomeBasicFragment.this.saveMapScale(500L);
      MapHomeBasicFragment.this.mMapControlPanel.disableWatermark();
    }
  };
  
  private void initLocationManager()
  {
    this.mLocationManager = BNSysLocationManager.getInstance();
    this.mLocationManager.init(mActivity);
  }
  
  private void initMapStatus()
  {
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    if (localMapStatus == null) {
      return;
    }
    localMapStatus._Rotation = 0;
    localMapStatus._Overlooking = 0;
    localMapStatus._Xoffset = 0L;
    localMapStatus._Yoffset = 0L;
    int i = PreferenceHelper.getInstance(getContext()).getInt("sp_last_scale", 14);
    LogUtil.e("MapHomeBasic", "initMapScale: savedLevel " + i);
    LocData localLocData;
    if (i > 14)
    {
      localMapStatus._Level = i;
      localLocData = GeoLocateModel.getInstance().getLastLocation();
      if ((localLocData == null) || (!localLocData.isValid())) {
        break label203;
      }
      this.mIsMapLocated = true;
      MainMapModel.getInstance().bFirstLoc = false;
      Bundle localBundle = CoordinateTransformUtil.LL2MC(localLocData.longitude, localLocData.latitude);
      localMapStatus._CenterPtX = localBundle.getInt("MCx");
      localMapStatus._CenterPtY = localBundle.getInt("MCy");
      TipTool.onCreateDebugToast(getContext(), "initMap: Got " + localLocData);
    }
    for (;;)
    {
      BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationAll);
      this.mMapControlPanel.updateView();
      return;
      localMapStatus._Level = 14.0F;
      break;
      label203:
      this.mIsMapLocated = false;
      LogUtil.e("MapHomeBasic", "initMapScale: null location data...");
      localMapStatus._Level = 3.0F;
      TipTool.onCreateDebugToast(getContext(), "initMap: ***Invalid " + localLocData);
    }
  }
  
  private boolean isOfflineDataDownloaded(GeoPoint paramGeoPoint)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramGeoPoint != null)
    {
      for (paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0); (paramGeoPoint != null) && (paramGeoPoint.mType > 2); paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId)) {}
      bool1 = bool2;
      if (paramGeoPoint != null) {
        bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(paramGeoPoint.mId);
      }
    }
    return bool1;
  }
  
  private void rescheduleCruiseTask()
  {
    this.mMaxSpeed = 0.0F;
  }
  
  private void saveMapScale(long paramLong)
  {
    this.mHandler.postDelayed(this.mSaveMapScaleRunnable, paramLong);
  }
  
  private void startCheckToEnterCruise()
  {
    this.mIsGpsEnabled = this.mLocationManager.isGpsEnabled();
    this.mLocationManager.addLocationListener(this.mLocationListener);
    this.mLocationManager.startNaviLocate(mActivity);
  }
  
  private void stopCheckToEnterCruise()
  {
    this.mHandler.removeCallbacks(this.mStartCruiseTask);
    this.mMaxSpeed = 0.0F;
    this.mLocationManager.removeLocationListener(this.mLocationListener);
  }
  
  protected void enterCruiseFollowModeDetect()
  {
    if ((this.mPoiDetailView == null) || (!this.mPoiDetailView.isVisible())) {
      EnterQuitLogicManager.getmInstance().enterCruiseFollowModeDetect();
    }
  }
  
  protected void handleMessage(Message paramMessage) {}
  
  protected void handleSingleTap(MotionEvent paramMotionEvent)
  {
    long l = System.currentTimeMillis() - this.mLastTimeShowMapPoi;
    LogUtil.e("MapHomeBasic", "handleSingleTap on map, time since show poi " + l);
    if (((l < 0L) || (l >= 500L)) && (this.mPoiDetailView.isVisible()))
    {
      this.mPoiDetailView.hide();
      enterCruiseFollowModeDetect();
      setMapFocusViewVisible(true);
    }
  }
  
  protected HomePoiBasicView initMapPoiDetailView()
  {
    return null;
  }
  
  protected ViewGroup initViews()
  {
    return null;
  }
  
  public boolean onBackPressed()
  {
    if ((this.mPoiDetailView != null) && (this.mPoiDetailView.isVisible()))
    {
      this.mPoiDetailView.hide();
      enterCruiseFollowModeDetect();
      return true;
    }
    return false;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    if (MainMapModel.getInstance().mbFirstMapviewContent)
    {
      paramLayoutInflater = BNLocationManagerProxy.getInstance().getLastValidLocation();
      LogUtil.e("MapHomeBasic", "GeoLocate position: " + paramLayoutInflater);
      MainMapModel.getInstance().mbFirstMapviewContent = false;
    }
    loadMapCtrlPanel(true);
    this.mbMoveToLocationPoint = true;
    this.mHomeController = new HomeController(mActivity, this);
    this.mViewGroup = initViews();
    this.mPoiDetailView = initMapPoiDetailView();
    return this.mViewGroup;
  }
  
  public void onDestroyView()
  {
    this.mViewCreated = false;
    super.onDestroyView();
  }
  
  protected void onInitMap()
  {
    super.onInitMap();
  }
  
  protected void onInitView() {}
  
  protected void onLocationBtnClicked(MapViewConfig.PositionStatus paramPositionStatus)
  {
    super.onLocationBtnClicked(paramPositionStatus);
    if (paramPositionStatus == MapViewConfig.PositionStatus.NORMAL)
    {
      paramPositionStatus = BNLocationManagerProxy.getInstance().getLastValidLocation();
      LogUtil.e("MapHomeBasic", "onLocationBtnClicked: " + paramPositionStatus);
      if (paramPositionStatus != null)
      {
        this.mPoiDetailView.show(paramPositionStatus, true);
        setMapFocusViewVisible(false);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mPoiDetailView.onPause();
    LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
  }
  
  public void onResume()
  {
    super.onResume();
    if (MainMapModel.getInstance().bFirstLoc)
    {
      initMapStatus();
      LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
    }
    this.mPoiDetailView.onResume();
    if (this.mMapControlPanel != null) {
      this.mMapControlPanel.setZoomBtnClickListener(this.mZoomBtnClickListener);
    }
  }
  
  protected void onShowFavPoi(SearchPoi paramSearchPoi)
  {
    LogUtil.e("MapHomeBasic", "onShowMapPoi");
    if (paramSearchPoi != null)
    {
      ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setMapSearchPoi(paramSearchPoi);
      this.mPoiDetailView.showFavPoi();
      this.mLastTimeShowMapPoi = System.currentTimeMillis();
      setMapFocusViewVisible(false);
    }
  }
  
  protected void onShowMapGeoPoint(GeoPoint paramGeoPoint)
  {
    if (h.a().getNaviFragmentManager().isDriving()) {}
    do
    {
      return;
      LogUtil.e("MapHomeBasic", "onShowMapGeoPoint");
    } while (paramGeoPoint == null);
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setAntiGeoPoint(paramGeoPoint);
    this.mPoiDetailView.show(paramGeoPoint, false);
    this.mLastTimeShowMapPoi = System.currentTimeMillis();
    setMapFocusViewVisible(false);
  }
  
  protected void onShowMapPoi(SearchPoi paramSearchPoi)
  {
    LogUtil.e("MapHomeBasic", "onShowMapPoi");
    if (paramSearchPoi != null)
    {
      ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).setMapSearchPoi(paramSearchPoi);
      this.mPoiDetailView.showMapPoi();
      this.mLastTimeShowMapPoi = System.currentTimeMillis();
      setMapFocusViewVisible(false);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    int i = getCurrentFragmentType();
    getCurrentFragment();
    LogUtil.e("MapHomeBasic", "onStop: current fragment type " + i);
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    super.onUpdateOrientation(paramInt);
    this.mPoiDetailView.onUpdateOrientation(paramInt);
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    this.mPoiDetailView.updateStyle();
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt1)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      rescheduleCruiseTask();
      LogUtil.e("MapHomeBasic", "onVoiceCommand: type " + paramInt1 + ", subType " + paramInt2 + ", " + paramInt3 + ", processed " + bool1);
      bool2 = bool1;
      if (!bool1) {
        bool2 = super.onVoiceCommand(paramInt1, paramInt2, paramInt3, paramObject, paramBoolean);
      }
      return bool2;
      bool1 = bool2;
      switch (paramInt2)
      {
      case 2: 
      default: 
        bool1 = bool2;
        break;
      case 1: 
        onBackPressed();
        replyVoiceCommand(paramInt1, 1, paramBoolean);
        bool1 = true;
      }
    }
  }
  
  private static class MapHomeBasicHandler
    extends Handler
  {
    private WeakReference<MapHomeBasicFragment> mWeakRef;
    
    public MapHomeBasicHandler(MapHomeBasicFragment paramMapHomeBasicFragment)
    {
      this.mWeakRef = new WeakReference(paramMapHomeBasicFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      MapHomeBasicFragment localMapHomeBasicFragment = (MapHomeBasicFragment)this.mWeakRef.get();
      if (localMapHomeBasicFragment != null)
      {
        localMapHomeBasicFragment.handleMessage(paramMessage);
        return;
      }
      LogUtil.e("MapHomeBasic", "MapHomeBasicFragment is freed");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/MapHomeBasicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */